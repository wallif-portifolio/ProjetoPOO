package dao;

import java.util.List;

public interface Interface<T> {
    void salvar(List<T> lista);
    List<T> carregar();
}