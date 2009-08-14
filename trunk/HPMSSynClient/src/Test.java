import java.io.File;
import java.io.FileWriter;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

public class Test {

	private static Logger log = Logger.getLogger(Test.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test = new Test();
		test.createXMLFile("test.xml");
	}

	public int createXMLFile(String filename) {
		/** ���ز������, 0��ʧ��, 1��ɹ� */
		int returnValue = 0;
		/** ����document���� */
		Document document = DocumentHelper.createDocument();
		/** ����XML�ĵ��ĸ�books */
		Element booksElement = document.addElement("books");
		/** ����һ��ע�� */
		booksElement.addComment("This is a test for dom4j, holen, 2004.9.11");
		/** �����һ��book�ڵ� */
		Element bookElement = booksElement.addElement("book");
		/** ����show�������� */
		bookElement.addAttribute("show", "yes");
		/** ����title�ڵ� */
		Element titleElement = bookElement.addElement("title");
		/** Ϊtitle�������� */
		titleElement.setText("Dom4j Tutorials");

		/** ���Ƶ���ɺ�����book */
		bookElement = booksElement.addElement("book");
		bookElement.addAttribute("show", "yes");
		titleElement = bookElement.addElement("title");
		titleElement.setText("Lucene Studing");
		bookElement = booksElement.addElement("book");
		bookElement.addAttribute("show", "no");
		titleElement = bookElement.addElement("title");
		titleElement.setText("Lucene in Action");

		/** ����owner�ڵ� */
		Element ownerElement = booksElement.addElement("owner");
		ownerElement.setText("O'Reilly");

		try {
			/** ��document�е�����д���ļ��� */
			XMLWriter writer = new XMLWriter(new FileWriter(new File(filename)));
			writer.write(document);
			writer.close();
			/** ִ�гɹ�,�践��1 */
			returnValue = 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return returnValue;
	}
}
