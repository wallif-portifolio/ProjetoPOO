package service;

import dao.daoEspaco;
import model.Espaco;
import java.util.List;

public class EspacoService {
    private daoEspaco espacoDAO = new daoEspaco();
    private List<Espaco> espacos = espacoDAO.carregar();

    public void cadastrarEspaco(Espaco espaco) {
        espacos.add(espaco);
        espacoDAO.salvar(espacos);
    }

    public void editarEspaco(int id, String nome, int capacidade, double precoPorHora) {
        for (Espaco espaco : espacos) {
            if (espaco.getid() == id) {
                espaco.setnome(nome);
                espaco.setcapacidade(capacidade);
                espaco.setprePorHora(precoPorHora);
                espacoDAO.salvar(espacos);
                return;
            }
        }
    }

    public void removerEspaco(int id) {
        for (int i = 0; i < espacos.size(); i++) {
            if (espacos.get(i).getid() == id) {
                espacos.remove(i);
                espacoDAO.salvar(espacos);
                return;
            }
        }
    }

    public List<Espaco> listarTodos() {
        return espacos;
    }

    public Espaco buscarPorId(int id) {
        for (Espaco espaco : espacos) {
            if (espaco.getid() == id) {
                return espaco;
            }
        }
        return null;
    }

    public void atualizarDisponibilidade(int id, boolean disponivel) {
        Espaco espaco = buscarPorId(id);
        if (espaco != null) {
            espaco.setDisponivel(disponivel);
            espacoDAO.salvar(espacos);
        }
    }
}