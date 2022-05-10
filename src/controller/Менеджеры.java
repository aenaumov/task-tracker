package controller;

/**
 * Менеджеры.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class Менеджеры {

	private static final ВПамятиИсторияЗадач вПамятиИсторияЗадач;

	static {
		вПамятиИсторияЗадач = new ВПамятиИсторияЗадач();
//		вПамятиМенеджер.setИстория(вПамятиИсторияЗадач);
	}


	public static Менеджер получитьМенеджера() {
		return new FileBackedTasksManager();
	}

	public static ИсторияЗадач получитьИсторияЗадач() {
		return вПамятиИсторияЗадач;
	}
}
