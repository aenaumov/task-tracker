package controller;

import java.util.List;

import model.Задача;

/**
 * Менеджер задач.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public interface МенеджерЗадач<T extends Задача> {

	List<T> получениеВсех();

	void удалениеВсех();

	T получение(int ид);

	void создание(T задача);

	void обновление(T задача);

	void удаление(int ид);
}
