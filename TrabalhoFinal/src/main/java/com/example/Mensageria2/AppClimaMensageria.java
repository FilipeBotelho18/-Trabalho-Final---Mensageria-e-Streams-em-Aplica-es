package com.example.Mensageria2;

import com.example.Mensageria2.DTO.MensagemDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AppClimaMensageria implements CommandLineRunner {

	private final Producer producer;

	public AppClimaMensageria(Producer producer) {
		this.producer = producer;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppClimaMensageria.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);

		boolean continuar = true;

		while (continuar) {
			MensagemDTO mensagem = coletarDados(scanner);

			if (mensagem != null) {
				producer.enviarMensagemAlerta(mensagem);
				System.out.println("Mensagem de alerta enviada com sucesso!");
			}

			System.out.print("Deseja enviar outro alerta? (s/n): ");
			String resposta = scanner.nextLine();
			if (resposta.equalsIgnoreCase("n")) {
				continuar = false;
			}
		}

		System.out.println("Programa encerrado.");
	}

	private MensagemDTO coletarDados(Scanner scanner) {

		System.out.println("==============Alertas Climativos==============");
		System.out.print("Digite o nome do alerta: ");
		String nome = scanner.nextLine();


		System.out.print("Digite o estado: ");
		String estado = scanner.nextLine();

		System.out.print("Digite o nível de severidade: ");
		String nivelSeveridade = scanner.nextLine();

		System.out.print("Digite o tipo de evento: ");
		String tipoEvento = scanner.nextLine();

		System.out.print("Digite a descrição do alerta: ");
		String descricao = scanner.nextLine();

		double latitude = 0;
		while (true) {
			System.out.print("Digite a latitude: ");
			try {
				latitude = Double.parseDouble(scanner.nextLine());
				if (latitude < -90 || latitude > 90) {
					System.out.println("Latitude inválida. Deve estar entre -90 e 90.");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Por favor, insira um valor numérico válido para a latitude.");
			}
		}

		double longitude = 0;
		while (true) {
			System.out.print("Digite a longitude: ");
			try {
				longitude = Double.parseDouble(scanner.nextLine());
				if (longitude < -180 || longitude > 180) {
					System.out.println("Longitude inválida. Deve estar entre -180 e 180.");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Por favor, insira um valor numérico válido para a longitude.");
			}
		}

		MensagemDTO mensagem = new MensagemDTO();
		mensagem.setNome(nome);
		mensagem.setEstado(estado);
		mensagem.setDescricao(descricao);
		mensagem.setNivelSeveridade(nivelSeveridade);
		mensagem.setTipoEvento(tipoEvento);
		mensagem.setLatitude(latitude);
		mensagem.setLongitude(longitude);

		return mensagem;
	}
}
