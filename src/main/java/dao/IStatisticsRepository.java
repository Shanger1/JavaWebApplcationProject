package dao;

import model.Statistics;

import java.util.List;

public interface IStatisticsRepository extends IRepository<Statistics>{
	public List<Statistics> byId(Integer id);
}
