package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Задача;
import model.Подзадача;
import model.Статус;
import model.Эпик;

/**
 * Менеджера задач.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class ВПамятиМенеджер implements Менеджер {
	МенеджерЗадач<Задача> менеджерЗадач;
	МенеджерЗадач<Подзадача> менеджерПодзадач;
	МенеджерЗадач<Эпик> менеджерЭпик;
	private final HashMap<Integer, Задача> задачи = new HashMap<>();
	private final HashMap<Integer, Подзадача> подзадачи = new HashMap<>();
	private final HashMap<Integer, Эпик> эпики = new HashMap<>();
	private int генераторИД = 0;
	private final ИсторияЗадач историяЗадач = Менеджеры.получитьИсторияЗадач();

	@Override
	public List<Задача> получениеЗадач() {
//		return менеджерЗадач.получениеВсех();
		return new ArrayList<>(задачи.values());
	}

	/**
	 * Удаление всех задач
	 */
	@Override
	public void удалениеЗадач() {
		задачи.clear();
	}

	/**
	 * Получение по идентификатору
	 */
	@Override
	public Задача получениеЗадачи(int ид) {
		final Задача задача = задачи.get(ид);
		историяЗадач.добавить(задача);
		return задача;
	}

	/**
	 * Создание. Сам объект должен передаваться в качестве параметра.
	 */
	@Override
	public void созданиеЗадачи(Задача задача) {
		задача.setИд(++генераторИД);
		задачи.put(задача.getИд(), задача);
	}

	/**
	 * Обновление. Новая версия объекта с верным идентификатором передаются в виде параметра.
	 */
	@Override
	public void обновлениеЗадачи(Задача задача) {
		if (!задачи.containsKey(задача.getИд())) {
			return;
		}
		задачи.put(задача.getИд(), задача);
	}

	/**
	 * Удаление по идентификатору
	 */
	@Override
	public void удалениеЗадачи(int ид) {
		задачи.remove(ид);
	}

	/**
	 * Список всех эпиков
	 *
	 * @return
	 */
	@Override
	public List<Эпик> получениеЭпиков() {
//		return менеджерЭпик.получениеВсех();
		return new ArrayList<>(эпики.values());
	}

	/**
	 * Удаление всех эпиков
	 */
	@Override
	public void удалениеЭпиков() {
		эпики.clear();
		подзадачи.clear();
	}

	/**
	 * Получение по идентификатору
	 */
	@Override
	public Эпик получениеЭпиков(int ид) {
		final Эпик эпик = эпики.get(ид);
		return эпик;
	}

	/**
	 * Создание. Сам объект должен передаваться в качестве параметра.
	 */
	@Override
	public void созданиеЭпика(Эпик эпик) {
		эпик.setИд(++генераторИД);
		эпик.setСтатус(Статус.NEW);
		эпики.put(эпик.getИд(), эпик);
	}

	/**
	 * Обновление. Новая версия объекта с верным идентификатором передаются в виде параметра.
	 */
	@Override
	public void обновлениеЭпика(Эпик эпик) {
		final Эпик эпикСохраненный = эпики.get(эпик.getИд());
		if (эпикСохраненный == null) {
			return;
		}
		эпикСохраненный.setНазвание(эпик.getНазвание());
		эпикСохраненный.setОписание(эпик.getОписание());
	}

	/**
	 * Удаление по идентификатору
	 */
	@Override
	public void удалениеЭпика(int ид) {
		final Эпик эпик = эпики.remove(ид);
		for (Подзадача подзадача : эпик.getПодзадачи()) {
			подзадачи.remove(подзадача.getИд());
		}
	}

}
