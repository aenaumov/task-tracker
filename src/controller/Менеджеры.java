package controller;

/**
 * Менеджеры.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class Менеджеры {

	private static final ВПамятиМенеджер вПамятиМенеджер;
	private static final ВПамятиИсторияЗадач вПамятиИсторияЗадач;

	static {
		вПамятиИсторияЗадач = new ВПамятиИсторияЗадач();
		вПамятиМенеджер = new ВПамятиМенеджер();
//		вПамятиМенеджер.setИстория(вПамятиИсторияЗадач);
	}


	public static Менеджер получитьМенеджера() {
		return вПамятиМенеджер;
	}

	public static ИсторияЗадач получитьИсторияЗадач() {
		return вПамятиИсторияЗадач;
	}
}
