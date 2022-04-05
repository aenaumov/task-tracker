package controller;

import java.util.List;

import model.Задача;
import model.Эпик;

/**
 * // TODO .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class ВПамятиСИсториейМенеджер implements Менеджер {
	ВПамятиМенеджер менеджер = new ВПамятиМенеджер();
	ВПамятиИсторияЗадач историяЗадач = new ВПамятиИсторияЗадач();

	@Override
	public List<Задача> получениеЗадач() {
		return менеджер.получениеЗадач();
	}

	@Override
	public void удалениеЗадач() {
		менеджер.удалениеЗадач();
	}

	@Override
	public Задача получениеЗадачи(int ид) {
		final Задача задача = менеджер.получениеЗадачи(ид);
		if (задача == null) {
			return null;
		}
		историяЗадач.добавить(задача);
		return задача;
	}

	@Override
	public void созданиеЗадачи(Задача задача) {

	}

	@Override
	public void обновлениеЗадачи(Задача задача) {

	}

	@Override
	public void удалениеЗадачи(int ид) {

	}

	@Override
	public List<Эпик> получениеЭпиков() {
		return null;
	}

	@Override
	public void удалениеЭпиков() {

	}

	@Override
	public Эпик получениеЭпиков(int ид) {
		return null;
	}

	@Override
	public void созданиеЭпика(Эпик эпик) {

	}

	@Override
	public void обновлениеЭпика(Эпик эпик) {

	}

	@Override
	public void удалениеЭпика(int ид) {

	}
}
