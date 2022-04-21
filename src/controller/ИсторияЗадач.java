package controller;

import java.util.List;

import model.Задача;

/**
 * История задач.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public interface ИсторияЗадач {
	List<Задача> получитьИсторию();
//	List<Integer> получитьИсторию();

	void добавить(Задача задача);
//	void добавить(Integer задачаИД);

	void удалить(Задача задача);

}
