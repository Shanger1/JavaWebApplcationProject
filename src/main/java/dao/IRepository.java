package dao;

import model.IHaveId;

import java.util.List;

public interface IRepository<TEntity extends IHaveId> {

	public TEntity get(int playerId);

	public List<TEntity> getAll();

	public void add(TEntity entity);

	public void update(TEntity entity);

	public void delete(TEntity entity);

	public int getLastId();

}