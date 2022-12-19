package dao;

public interface Dao<T> {
	T find(Integer id);

	void create();

	void update(T t, Integer id);

	void delete(Integer id);

}
