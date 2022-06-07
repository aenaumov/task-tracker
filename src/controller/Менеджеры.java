package controller;

/**
 * Менеджеры.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class Менеджеры {

	public static Менеджер получитьМенеджера() {
		return new HttpTasksManager(8078);
	}

	public static ИсторияЗадач получитьИсторияЗадач() {
		return new ВПамятиИсторияЗадач();
	}
}
