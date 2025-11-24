package model;

public class CabineIndividual extends Espaco {
    public CabineIndividual(int id, String nome, int capacidade, boolean disponivel, double precoPorHora) {
        super(id, nome, capacidade, disponivel, precoPorHora);
    }

    @Override
    public double calcularCustoReserva(double horas) {
        double valor = precoPorHora * horas;
        if(horas > 4) {
            double desconto = valor * 0.10;
            valor = valor - desconto;
        }
        return valor;
    }
}