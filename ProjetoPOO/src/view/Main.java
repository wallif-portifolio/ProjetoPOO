package view;

import service.EspacoService;
import service.ReservaService;
import service.PagamentoService;
import model.*;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EspacoService espacoService = new EspacoService();
        ReservaService reservaService = new ReservaService();
        PagamentoService pagamentoService = new PagamentoService();
        
        while (true) {
            System.out.println("\n=== COWORKING ===");
            System.out.println("1. Ver espaços");
            System.out.println("2. Ver reservas");
            System.out.println("3. Ver pagamentos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            
            int op = sc.nextInt();
            
            if (op == 1) {
                List<Espaco> espacos = espacoService.listarTodos();
                System.out.println("\nEspaços:");
                for (Espaco e : espacos) {
                    System.out.println("- " + e.getnome() + " (R$ " + e.getprePorHora() + "/hora)");
                }
            }
            else if (op == 2) {
                List<Reserva> reservas = reservaService.listarTodas();
                System.out.println("\nReservas:");
                for (Reserva r : reservas) {
                    System.out.println("- " + r.getEspaco().getnome() + " - " + r.getStatus());
                }
            }
            else if (op == 3) {
                List<Pagamento> pagamentos = pagamentoService.listarTodos();
                System.out.println("\nPagamentos:");
                for (Pagamento p : pagamentos) {
                    System.out.println("- R$ " + p.getValorPago() + " (" + p.getMetodo() + ")");
                }
            }
            else if (op == 0) {
                System.out.println("Saiu.");
                sc.close();
                break;
            }
            else {
                System.out.println("Opção inválida!");
            }
        }
    }
}