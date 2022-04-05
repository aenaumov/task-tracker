package controller;

import java.util.LinkedList;
import java.util.List;

import model.Задача;

/**
 * История задач в памяти.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class ВПамятиИсторияЗадач implements ИсторияЗадач {
	LinkedList<Задача> история = new LinkedList<>();

	@Override
	public List<Задача> получитьИсторию() {
		return история;
	}

	@Override
	public void добавить(Задача задача) {
		история.add(задача);
		// TODO добавить ограничение на длинну
	}
}
