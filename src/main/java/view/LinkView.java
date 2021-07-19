package view;

import java.util.List;
import java.util.PrimitiveIterator;

import model.LinkBean;
import model.LinkDAO;

public class LinkView {
	
	public List<LinkBean>getLinks() {
		
		List<LinkBean> links = null;
		try {
			LinkDAO linkDAO = new LinkDAO();
			links = linkDAO.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return links;
		
	}
	
	public LinkBean getLinkByCode(String code) {

		LinkBean link = null;
		try {
			LinkDAO linkDAO = new LinkDAO();
			link = linkDAO.getLinkByCode(code);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return link;

	}

}
