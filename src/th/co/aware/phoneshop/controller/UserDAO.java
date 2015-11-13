package th.co.aware.phoneshop.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import th.co.aware.phoneshop.bean.Order;
import th.co.aware.phoneshop.bean.Product;
import th.co.aware.phoneshop.bean.User;

public class UserDAO {
	@Autowired
	DataSource dataSource;

	public User getUserByUsernameAndPassword(String username, String password) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from user where username Like '" + username + "' and password Like '" + password + "'";
		List<User> st = jdbcTemplate.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User s = new User();
				s.setUsername(rs.getString("username"));
				s.setPassword(rs.getString("password"));
				return s;
			}
		});
		if (st.size() > 0) {
			return st.get(0);
		} else {
			return null;
		}
	}

	public List<Product> getProduct() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from product";
		return jdbcTemplate.query(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product p = new Product();
				p.setProduct_id(rs.getInt(1));
				p.setProduct_name(rs.getString(2));
				p.setProduct_brand(rs.getString(3));
				p.setProduct_price(rs.getInt(4));
				return p;
			}
		});

	}

	public Boolean saveOrder(Order o) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "insert into phoneorder (order_time, user_id, product_id) "
				+ "values (now(),(select user_id from user where username = ?),?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, o.getUsername());
				ps.setInt(2, o.getProduct_id());
				return ps.execute();
			}
		});
	}

	public Boolean regisUser(User u) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "insert into user (first_name, last_name, username, password) " + "values (?, ?, ?, ?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, u.getFirst_name());
				ps.setString(2, u.getLast_name());
				ps.setString(3, u.getUsername());
				ps.setString(4, u.getPassword());
				return ps.execute();
			}
		});
	}

	public List<Product> getOrder(String username) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select o.order_id,p.product_name,p.product_brand,p.product_price from phoneorder o join product p "
				+ "on o.product_id = p.product_id where o.user_id = "
				+ "(select user_id from user where username = '" + username + "')";
		return jdbcTemplate.query(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product p = new Product();
				p.setOrder_id(rs.getInt(1));
				p.setProduct_name(rs.getString(2));
				p.setProduct_brand(rs.getString(3));
				p.setProduct_price(rs.getInt(4));
				return p;
			}
		});

	}
	public Boolean delOrder(Order o) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "delete from phoneorder where order_id = ?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setInt(1, o.getOrder_id());
				return ps.execute();
			}
		});
	}

}
