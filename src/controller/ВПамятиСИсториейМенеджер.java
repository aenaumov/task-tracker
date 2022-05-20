package controller;

import java.util.List;

import model.Задача;
import model.Подзадача;
import model.Эпик;

/**
 * Менеджер + история через декраратор.
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
	public Эпик получениеЭпика(int ид) {
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

	@Override
	public List<Подзадача> получениеПодзадачЭпика(int эпикИд) {
		return null;
	}

	@Override
	public List<Подзадача> получениеПодзадач() {
		return null;
	}

	@Override
	public void удалениеПодзадачи() {

	}

	@Override
	public Подзадача получениеПодзадачи(int ид) {
		return null;
	}

	@Override
	public void созданиеПодзадачи(Подзадача подзадача) {

	}

	@Override
	public void обновлениеПодзадачи(Подзадача подзадача) {

	}

	@Override
	public void удалениеПодзадачи(int ид) {

	}

	@Override
	public List<Задача> получениеИстории() {
		return null;
	}
}
