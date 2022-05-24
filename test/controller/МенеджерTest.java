package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Задача;
import model.Статус;
import model.Эпик;

/**
 * // TODO .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
abstract class МенеджерTest<T extends Менеджер> {
	protected T менеджер;
	Задача задача;
	Эпик эпик;

	void init() {
		задача = new Задача(-1, "Тест", "Описание", Статус.NEW, LocalDateTime.now(), 15);
		менеджер.созданиеЗадачи(задача);
		эпик = new Эпик("Тест эпик", "Описание эпик");
		менеджер.созданиеЭпика(эпик);
	}

	@Test
	void получениеЗадач() {

		final List<Задача> задачи = менеджер.получениеЗадач();

		assertNotNull(задачи);
		assertEquals(1, задачи.size(), "Одна задача");
		assertEquals(задача, задачи.get(0));
	}

	@Test
	void удалениеЗадач() {
	}

	@Test
	void получениеЗадачи() {
	}

	@Test
	void созданиеЗадачи() {
	}

	@Test
	void обновлениеЗадачи() {
	}

	@Test
	void удалениеЗадачи() {
	}

	@Test
	void получениеЭпиков() {
	}

	@Test
	void удалениеЭпиков() {
	}

	@Test
	void получениеЭпика() {
	}

	@Test
	void созданиеЭпика() {
	}

	@Test
	void обновлениеЭпика() {
	}

	@Test
	void удалениеЭпика() {
	}

	@Test
	void получениеПодзадачЭпика() {
	}

	@Test
	void получениеПодзадач() {
	}

	@Test
	void удалениеПодзадачи() {
	}

	@Test
	void получениеПодзадачи() {
	}

	@Test
	void созданиеПодзадачи() {
	}

	@Test
	void обновлениеПодзадачи() {
	}

	@Test
	void testУдалениеПодзадачи() {
	}

	@Test
	void получениеИстории() {
	}

	@Test
	void epicWithEmptySubtasks() {
	}
	@Test
	void epicWithNewSubtasks() {
	}
	@Test
	void epicWithInProgressNewSubtasks() {
	}
	@Test
	void epicWithDoneSubtasks() {
	}
}