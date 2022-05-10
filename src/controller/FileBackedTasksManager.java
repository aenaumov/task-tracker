package controller;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Задача;
import model.ТипыЗадач;
import model.Эпик;

/**
 * // TODO .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class FileBackedTasksManager extends ВПамятиМенеджер {
	private final File file;

	public FileBackedTasksManager() {
		this(new File("task.csv"), false);
	}

	public FileBackedTasksManager(File file) {
		this(file, false);
	}

	public FileBackedTasksManager(File file, boolean load) {
		this.file = file;
		if (load) {
			load();
		}
	}

	@Override
	public List<Задача> получениеЗадач() {
		final List<Задача> задачи = super.получениеЗадач();
		save();
		return задачи;
	}

	@Override
	public void удалениеЗадач() {
		super.удалениеЗадач();
	}

	@Override
	public Задача получениеЗадачи(int ид) {
		return super.получениеЗадачи(ид);
	}

	@Override
	public void созданиеЗадачи(Задача задача) {
		super.созданиеЗадачи(задача);
	}

	@Override
	public void обновлениеЗадачи(Задача задача) {
		super.обновлениеЗадачи(задача);
	}

	@Override
	public void удалениеЗадачи(int ид) {
		super.удалениеЗадачи(ид);
	}

	@Override
	public List<Эпик> получениеЭпиков() {
		return super.получениеЭпиков();
	}

	@Override
	public void удалениеЭпиков() {
		super.удалениеЭпиков();
	}

	@Override
	public Эпик получениеЭпиков(int ид) {
		return super.получениеЭпиков(ид);
	}

	@Override
	public void созданиеЭпика(Эпик эпик) {
		super.созданиеЭпика(эпик);
	}

	@Override
	public void обновлениеЭпика(Эпик эпик) {
		super.обновлениеЭпика(эпик);
	}

	@Override
	public void удалениеЭпика(int ид) {
		super.удалениеЭпика(ид);
	}

	// Todo
	private String toString(Задача task) {
		return "";
	}

	// Todo
	private Задача fromString(String value) {
		final String[] поля = value.split(",");


//		switch (type = valueOf(поля[1])) {
//			case TASK:
//			case SUBTASK:
//			case EPIC:
//		}
		return null;
	}

	static String toString(ИсторияЗадач manager) {
		StringBuilder sb = new StringBuilder();
		for (Задача задача : manager.получитьИсторию()) {
			// TODO
		}
		return sb.toString();
	}

	static List<Integer> historyFromString(String value) {
		final String[] ид = value.split(",");
		List<Integer> история = new ArrayList<>();
		for (String v : ид) {
//			история.add(Integer.parseInt(v));
			история.add(Integer.valueOf(v));
		}
		return история;
	}

	// Сохранение в файл
	private void save() {
		try (final BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			// TODO  Заголовок id,type,name,status,description,epic
			for (Map.Entry<Integer, Задача> entry : задачи.entrySet()) {
				writer.append(toString(entry.getValue()));
				writer.newLine();
			}
			// TODO подзадачи , эпики, история
		} catch (IOException e) {
			throw new RuntimeException(e); // TODO ManagerSaveException
		}

	}

	// Восстановление из в файла
	private void load() {
//		try {
//			final String s = Files.readString(file.toPath());
//			s.split("\n");
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}

		int maxId = 0;
		try (final BufferedReader reader = new BufferedReader(new FileReader(file, UTF_8))) {
			reader.readLine(); // Пропускаем заголовок
			while (true) {
				String line = reader.readLine();
				// Задачи
				final Задача задача = fromString(line);
				// TODO добавить задачу в менеджер
				final int id = задача.getИд();
				if (задача.getТип() == ТипыЗадач.TASK) {
					задачи.put(id, задача);
//				} else if () { // TODO

				}

				if (maxId < id) {
					maxId = id;
				}
				if (line.isEmpty()) {
					break;
				}
			}

			String line = reader.readLine();
			// История

		} catch (IOException e) {
			throw new RuntimeException(e); // TODO ManagerSaveException
		}
		// генератор
		генераторИД = maxId;

	}

	public static FileBackedTasksManager loadFromFile(File file) {
		final FileBackedTasksManager manager = new FileBackedTasksManager(file, true);
		return manager;
	}
}
