package model;
import java.util.ArrayList;

public class Lista<T> {
	private ArrayList<T> elementos = new ArrayList<>();
	public void addLast(T elemento) {
		elementos.add(elemento);
	}
	public T get(int index) {
		return elementos.get(index);
	}
	public int size() {
		return elementos.size();
	}
}
