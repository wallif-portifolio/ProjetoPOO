package service;

import dao.daoPagamento;
import model.Pagamento;
import java.util.List;

public class PagamentoService {
    private daoPagamento pagamentoDAO = new daoPagamento();
    private List<Pagamento> pagamentos = pagamentoDAO.carregar();

    public void registrarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
        pagamentoDAO.salvar(pagamentos);
    }

    public List<Pagamento> listarTodos() {
        return pagamentos;
    }
}