import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LeitorXML {

	public void leituraArquivoXML(String arquivo) {
		// LEITURA ARQUIVO XML
		try {
			File arquivoXML = new File(arquivo);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(arquivoXML);
			Element raiz = document.getDocumentElement();

			if (document.hasChildNodes()) {
				printNode(raiz.getElementsByTagName("SERIAL"));
				printNode(raiz.getElementsByTagName("DATE"));
				printNode(raiz.getElementsByTagName("AD1"));
				printNode(raiz.getElementsByTagName("AD3"));
				printNode(raiz.getElementsByTagName("AD4"));
				printChildNode(raiz.getElementsByTagName("OUTPUTS"));
				printChildNode(raiz.getElementsByTagName("INPUTS"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Diretório " + System.getProperty("user.dir"));
		}

	}

	public void printNode(NodeList nodeList) {

		for (int count = 0; count < nodeList.getLength(); count++) {
			Node elemNode = nodeList.item(count);

			if (elemNode.getNodeType() == Node.ELEMENT_NODE) {
				// get node content
				System.out.println(
						"Node Name: " + elemNode.getNodeName() + "\nNode Content = " + elemNode.getTextContent());
			}
		}
	}
	
	public void printChildNode(NodeList nodeList) {
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node elemNode = nodeList.item(count);
			if (elemNode.getNodeType() == Node.ELEMENT_NODE) {
				// get node name and value
				System.out.println("\nNode Name = " + elemNode.getNodeName() + " [OPEN]");
				System.out.println("Node Content = " + elemNode.getTextContent());					
				System.out.println("Node Name = " + elemNode.getNodeName() + " [CLOSE]");
			}
		}
	}

//		private static void printNodeList(NodeList nodeList) {
//			for (int count = 0; count < nodeList.getLength(); count++) {
//				Node elemNode = nodeList.item(count);
//				if (elemNode.getNodeType() == Node.ELEMENT_NODE) {
//						// get node name and value
//						System.out.println("\nNode Name =" + elemNode.getNodeName() + " [OPEN]");
//						System.out.println("Node Content =" + elemNode.getTextContent());
//						if (elemNode.hasAttributes()) {
//							NamedNodeMap nodeMap = elemNode.getAttributes();
//							for (int i = 0; i < nodeMap.getLength(); i++) {
//								Node node = nodeMap.item(i);
//								System.out.println("attr name : " + node.getNodeName());
//								System.out.println("attr value : " + node.getNodeValue());
//							}
//						}
//					
//					if (elemNode.hasChildNodes()) {
//						// recursive call if the node has child nodes
//						printNodeList(elemNode.getChildNodes());
//					}
//					System.out.println("Node Name =" + elemNode.getNodeName() + " [CLOSE]");
//				}
//			}
//		}
}
