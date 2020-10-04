package br.com.danilo.test.service.interfaces;

public interface ServiceInterface<T> {
    T save(T object) throws Exception;

}
