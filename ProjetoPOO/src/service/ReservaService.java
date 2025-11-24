package service;

import java.util.List;
import dao.daoReserva;
import model.Reserva;

public class ReservaService {
    private daoReserva reservaDAO = new daoReserva();
    private List<Reserva> reservas = reservaDAO.carregar();

    public void criarReserva(Reserva reserva) {
        reservas.add(reserva);
        reservaDAO.salvar(reservas);
    }

    public void cancelarReserva(int id) {
        Reserva reserva = buscarPorId(id);
        if (reserva != null) {
            reserva.setStatus(Reserva.statusDaReserva.CANCELADO);
            reservaDAO.salvar(reservas);
        }
    }

    public Reserva buscarPorId(int id) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }
        return null;
    }

    public List<Reserva> listarTodas() {
        return reservas;
    }
}