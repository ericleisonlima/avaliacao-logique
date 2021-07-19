package model;

import java.util.ArrayList;
import java.util.List;

public class LinkDAO extends DAO {

	private static final String INSERT = "insert into link(url, code, data_insercao) values(?, (select to_base64((select count(1) as total from link l))), sysdate())";
	private static final String FIND_ALL = "select id, url, code, custom from link";
	private static final String UPDATE = "update link set custom = ? where id = ?";
	private static final String GET_LINK_BY_CODE = "select id, url, code, custom from link where code = ?";

	public boolean create(String url) throws Exception {

		try {

			open();
			statement = connection.prepareStatement(INSERT);
			statement.setString(1, url);
			return statement.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	public List<LinkBean> findAll() throws Exception {
		
		List<LinkBean> links = null;

		try {

			open();
			statement = connection.prepareStatement(FIND_ALL);
			resultSet = statement.executeQuery();
			links = new ArrayList<LinkBean>();
			while (resultSet.next()) {
				
				links.add(new LinkBean(resultSet.getInt("id"), resultSet.getString("url"), resultSet.getString("code"), resultSet.getString("custom")));

				System.out.println("===============================");
				System.out.println("Id = " + resultSet.getInt("id"));
				System.out.println("URL =" + resultSet.getString("url"));
				System.out.println("Code =" + resultSet.getString("code"));
				System.out.println("Custom =" + resultSet.getString("custom"));
				System.out.println("===============================");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return links;

	}
	
	public LinkBean getLinkByCode(String code) throws Exception {
		
		LinkBean link = null;

		try {

			open();
			statement = connection.prepareStatement(GET_LINK_BY_CODE);
			statement.setString(1, code);
			resultSet = statement.executeQuery();
		
			if (resultSet.next()) {
				
				 link = new LinkBean(resultSet.getInt("id"), resultSet.getString("url"), resultSet.getString("code"), resultSet.getString("custom"));

			
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return link;

	}

	public boolean update(String custom, int id) throws Exception {

		try {

			open();
			statement = connection.prepareStatement(UPDATE);
			statement.setString(1, custom);
			statement.setInt(2, id);
			return statement.executeUpdate() > 0 ? true : false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * teste
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			LinkDAO linkDAO = new LinkDAO();
			linkDAO.create("https://www.logiquesistemas.com.br/");
			linkDAO.findAll();
			linkDAO.update("Teste UPDATE", 28);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
