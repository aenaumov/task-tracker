package model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Эпик.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class Эпик extends Задача {
	private final ArrayList<Подзадача> подзадачи;

	public Эпик(String название, String описание) {
		super(название, описание, Статус.NEW);
		this.подзадачи = new ArrayList<>();
	}

	public Эпик(String название, String описание, int ид, String cтатус, ArrayList<Подзадача> подзадачи) {
		super(название, описание, ид, cтатус);
		this.подзадачи = подзадачи;
	}

	public ArrayList<Подзадача> getПодзадачи() {
		return подзадачи;
	}

	public void добавить(Подзадача подзадача) {
		подзадачи.add(подзадача);
	}

	public void удалить(Подзадача подзадача) {
		подзадачи.remove(подзадача);
	}

	public void обновитьСтатус() {
		if (подзадачи.isEmpty()) {
			статус = Статус.NEW;
		}
		for (Подзадача подзадача : подзадачи) {
			// TODO
		}
		статус = Статус.IN_PROGRESS;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Эпик)) return false;
		if (!super.equals(o)) return false;
		Эпик эпик = (Эпик) o;
		return Objects.equals(подзадачи, эпик.подзадачи);
	}

	@Override
	public String toString() {
		return "Эпик{" +
				"название='" + название + '\'' +
				", описание='" + описание + '\'' +
				", ид=" + ид +
				", cтатус='" + статус + '\'' +
				", подзадачи=" + подзадачи +
				"} ";
	}
}
