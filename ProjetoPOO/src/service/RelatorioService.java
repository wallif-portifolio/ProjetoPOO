package service;

import model.Reserva;
import model.Pagamento;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class RelatorioService {
    private ReservaService reservaService;
    private PagamentoService pagamentoService;

    public RelatorioService(ReservaService reservaService, PagamentoService pagamentoService) {
        this.reservaService = reservaService;
        this.pagamentoService = pagamentoService;
    }

    public List<Reserva> reservasPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservaService.listarTodas()) {
            if (reserva.getInicio().isAfter(inicio) && reserva.getFim().isBefore(fim)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public double faturamentoTotal() {
        double total = 0;
        for (Pagamento pagamento : pagamentoService.listarTodos()) {
            total += pagamento.getValorPago();
        }
        return total;
    }
}