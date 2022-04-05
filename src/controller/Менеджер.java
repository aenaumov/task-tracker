package controller;

import java.util.List;

import model.Задача;
import model.Эпик;

/**
 * Менеджер задач.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public interface Менеджер {
	/**
	 * Список всех задач
	 *
	 * @return
	 */
	List<Задача> получениеЗадач();

	void удалениеЗадач();

	Задача получениеЗадачи(int ид);

	void созданиеЗадачи(Задача задача);

	void обновлениеЗадачи(Задача задача);

	void удалениеЗадачи(int ид);

	List<Эпик> получениеЭпиков();

	void удалениеЭпиков();

	Эпик получениеЭпиков(int ид);

	void созданиеЭпика(Эпик эпик);

	void обновлениеЭпика(Эпик эпик);

	void удалениеЭпика(int ид);
}
