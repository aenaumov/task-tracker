import java.util.ArrayList;
import java.util.HashMap;

/**
 * Менеджера задач.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class Менеджер {
	private final HashMap<Integer, Задача> задачи = new HashMap<>();
	private int генераторИД = 0;

	/**
	 * Список всех задач
	 *
	 * @return
	 */
	public ArrayList<Задача> получениеЗадач() {
		return new ArrayList<>(задачи.values());
	}

	/**
	 * Удаление всех задач
	 */
	public void удалениеЗадач() {
		задачи.clear();
	}

	/**
	 * Получение по идентификатору
	 */
	public Задача получениеЗадачи(int ид) {
		return задачи.get(ид);
	}

	/**
	 * Создание. Сам объект должен передаваться в качестве параметра.
	 */
	public void созданиеЗадачи(Задача задача) {
		задача.setИд(++генераторИД);
		задачи.put(задача.getИд(), задача);
	}

	/**
	 * Обновление. Новая версия объекта с верным идентификатором передаются в виде параметра.
	 */
	public void обновлениеЗадачи(Задача задача) {
		if (!задачи.containsKey(задача.getИд())) {
			return;
		}
		задачи.put(задача.getИд(), задача);
	}

	/**
	 * Удаление по идентификатору
	 */
	public void удалениеЗадачи(int ид) {
		задачи.remove(ид);
	}

	private void обновитьСтатус(Эпик эпик) {
		for (Подзадача подзадача : эпик.getПодзадачи()) {

		}
	}
}
