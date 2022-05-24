package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * // TODO .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
class ВПамятиМенеджерTest extends МенеджерTest<ВПамятиМенеджер> {
	@BeforeEach
	void initВПамятиМенеджер() {
		менеджер = new ВПамятиМенеджер();
		init();
	}

	@Test
	void тестВПамятиМенеджер() {
		менеджер = new ВПамятиМенеджер();

		assertEquals(0, менеджер.получениеЗадач().size(), "Задач нет");
		assertEquals(0, менеджер.получениеПодзадач().size(), "Задач нет");
		assertEquals(0, менеджер.получениеЭпиков().size(), "Задач нет");
		assertEquals(0, менеджер.получениеИстории().size(), "Задач нет");
	}
}