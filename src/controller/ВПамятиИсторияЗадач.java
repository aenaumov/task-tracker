package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Задача;

/**
 * История задач в памяти.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class ВПамятиИсторияЗадач implements ИсторияЗадач {
	Map<Integer, Node<Задача>> nodeByIdMap = new HashMap<>();

	Node<Задача> first;
	Node<Задача> last;

	public static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

	void linkLast(Задача e) {
		final Node<Задача> последний = last;
		final Node<Задача> новый = new Node<>(последний, e, null);
		last = новый;
		if (последний == null)
			first = новый;
		else
			последний.next = новый;
		nodeByIdMap.put(e.getИд(), новый);
	}

	@Override
	public List<Задача> получитьИсторию() {
		final List<Задача> list = new ArrayList<>();
		Node<Задача> node = first;
		while (node != null) {
			list.add(node.item);
			node = node.next;
		}
		return list;
	}

	@Override
	public void добавить(Задача задача) {
		if (задача == null) {
			return;
		}
		final Node<Задача> node = nodeByIdMap.get(задача.getИд());
		if (node != null) {
			removeNode(node);
		}
		linkLast(задача);
	}

	private void removeNode(Node<Задача> node) {
		// 1. Начало
//		if (node.prev == null)
		if (node == first) {
			if (node == last) {
				first = null;
				last = null;
				return;
			}

			final Node<Задача> newFirst = first.next;
			newFirst.prev = null;
			first = newFirst;
			return;
		}
		// 3. Конец
		if (node == last) {
			last = node.prev;
			node.next = null;
			return;
		}
		// 2. Середина
		final Node<Задача> prev = node.prev;
		final Node<Задача> next = node.next;
		prev.next = next;
		next.prev = prev;
	}

	@Override
	public void удалить(Задача задача) {
		final Node<Задача> node = nodeByIdMap.remove(задача.getИд());
		if (node != null) {
			removeNode(node);
		}
	}
}
