import java.io.File;

import controller.FileBackedTasksManager;
import controller.Менеджер;
import controller.Менеджеры;
import model.Задача;
import model.Статус;
import model.Эпик;

public class Main {
	public static void main(String[] args) {
		Менеджер менеджер = Менеджеры.получитьМенеджера();

		Задача задача = new Задача("Тест", "Описание", Статус.NEW);
		менеджер.созданиеЗадачи(задача);
		final Задача задачаСохраненная = менеджер.получениеЗадачи(задача.getИд());
		if (!задача.equals(задачаСохраненная)) {
			System.out.println("Ошибка задачи не находится по ид " + задача.getИд());
		}
		System.out.println(менеджер.получениеЗадач());
		менеджер.удалениеЗадачи(задачаСохраненная.getИд());
		менеджер.удалениеЗадач();

		Эпик эпик = new Эпик("Тест эпик", "Описание эпик");
		менеджер.созданиеЭпика(эпик);
		final Эпик эпикСохраненный = менеджер.получениеЭпика(эпик.getИд());
		if (!эпик.equals(эпикСохраненный)) {
			System.out.println("Ошибка задачи не находится по ид " + эпик.getИд());
		}
		System.out.println(менеджер.получениеЭпиков());
		менеджер.удалениеЭпика(эпикСохраненный.getИд());
		менеджер.удалениеЭпиков();

		Менеджер восстановленныйМенеджер = FileBackedTasksManager.loadFromFile(new File("task.csv"));
		System.out.println();
		System.out.println("Проверка: ");
		System.out.println("Задачи совпадают: " + менеджер.получениеЗадач().equals(восстановленныйМенеджер.получениеЗадач()));
		System.out.println("Подзадачи совпадают: " + менеджер.получениеПодзадач().equals(восстановленныйМенеджер.получениеПодзадач()));
		System.out.println("Эпики совпадают: " + менеджер.получениеЭпиков().equals(восстановленныйМенеджер.получениеЭпиков()));
		System.out.println("История совпадает: " + менеджер.получениеИстории().equals(восстановленныйМенеджер.получениеИстории()));
	}
}
