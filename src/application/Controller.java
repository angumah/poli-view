package application;

import entities.*;

import DAO.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


@SuppressWarnings("serial")
public class Controller extends HttpServlet {
	private StateDAO sDao;
    private RepDAO rDao;

    public void init() {
        final String url = getServletContext().getInitParameter("JDBC-URL");
        final String username = getServletContext().getInitParameter("JDBC-USERNAME");
        final String password = getServletContext().getInitParameter("JDBC-PASSWORD");

        sDao = new StateDAO(url, username, password);
        rDao = new RepDAO(url, username, password);


    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        final String action = request.getServletPath();
        System.out.println("path : " + action);
        System.out.println("action : " + request.getParameter("action"));


        try {
            switch(action ) {
                case "/states": setStates(request, response); break;
                case "/view": viewReps(request, response); break;
                case "/info": viewInfo(request, response); break;
                case "/news": viewNews(request, response); break;
                default: viewHome(request, response); break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    
    private void viewHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/icon-128x128.png");

        BufferedImage bImage = ImageIO.read(file);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "png", bos);

        byte[] bytes = bos.toByteArray();


        String menu = Base64.getEncoder().encodeToString(bytes);
        System.out.println(menu + "\ntest");

        System.out.println(request.getServletPath());
        
     
        
        File file1 = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/BlankMap-USA-states.jpg");

        BufferedImage bImage1 = ImageIO.read(file1);

        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
        ImageIO.write(bImage1, "jpg", bos1);

        byte[] bytes1 = bos1.toByteArray();


        String map = Base64.getEncoder().encodeToString(bytes1);
        System.out.println(map + "\ntest");

        System.out.println(request.getServletPath());
        
        
        
        File file2 = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/logo.png");

        BufferedImage bImage2 = ImageIO.read(file2);

        ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
        ImageIO.write(bImage2, "png", bos2);

        byte[] bytes2 = bos2.toByteArray();


        String logo = Base64.getEncoder().encodeToString(bytes2);
        System.out.println(logo + "\ntest");

        System.out.println(request.getServletPath());
        
        request.setAttribute("logo", logo);
        request.setAttribute("map", map);
        request.setAttribute("menu", menu);

        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);

    }

    private void setStates(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<State> states = sDao.getStates();

        request.setAttribute("states", states);
        
        File file = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/icon-128x128.png");

        BufferedImage bImage = ImageIO.read(file);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "png", bos);

        byte[] bytes = bos.toByteArray();

        String menu = Base64.getEncoder().encodeToString(bytes);
        System.out.println(menu + "\ntest");

        
        
        
        File file2 = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/logo.png");

        BufferedImage bImage2 = ImageIO.read(file2);

        ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
        ImageIO.write(bImage2, "png", bos2);

        byte[] bytes2 = bos2.toByteArray();


        String logo = Base64.getEncoder().encodeToString(bytes2);
        System.out.println(logo + "\ntest");

        System.out.println(request.getServletPath());
        
       
       request.setAttribute("menu", menu);
       request.setAttribute("logo", logo);
       

        RequestDispatcher dispatcher = request.getRequestDispatcher("states.jsp");
        dispatcher.forward(request, response);

    }


    private void viewReps(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    	File file2 = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/logo.png");

         BufferedImage bImage2 = ImageIO.read(file2);

         ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
         ImageIO.write(bImage2, "png", bos2);

         byte[] bytes2 = bos2.toByteArray();


         String logo = Base64.getEncoder().encodeToString(bytes2);
         System.out.println(logo + "\ntest");

         System.out.println(request.getServletPath());
         
        request.setAttribute("logo", logo);
        
        
        
        
        int stateID = Integer.parseInt(request.getParameter("id"));
        List<Representative> reps = new ArrayList<>();
        List<Representative> senators = new ArrayList<>();
        
        List<Representative> mySql = rDao.getReps(stateID);
        
        for(int i=0; i<mySql.size(); i++) {
        	Representative currentRep = mySql.get(i);
        	
        	if(currentRep.getType().equals("Senator")) {
        		senators.add(currentRep);
        	} else {
        		reps.add(currentRep);
        	}
        }
        request.setAttribute("reps", reps);
        request.setAttribute("senators", senators);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reps.jsp");
        dispatcher.forward(request, response);

    }
    
    private void viewInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    	
        File file2 = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/logo.png");

        BufferedImage bImage2 = ImageIO.read(file2);

        ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
        ImageIO.write(bImage2, "png", bos2);

        byte[] bytes2 = bos2.toByteArray();


        String logo = Base64.getEncoder().encodeToString(bytes2);
        System.out.println(logo + "\ntest");

        System.out.println(request.getServletPath());
        

       request.setAttribute("logo", logo);
       
       
        int id = Integer.parseInt(request.getParameter("id"));
        File file1 = null;

        Representative rep = rDao.getRep(id);

        String searchId = "";
        switch(id) {
            case 12: file1 = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/bonnie.jpg");
                searchId = "24799";
                break;
        }

        BufferedImage bImage1 = ImageIO.read(file1);

        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
        ImageIO.write(bImage1, "jpg", bos1);

        byte[] image = bos1.toByteArray();

        String i = Base64.getEncoder().encodeToString(image);
        System.out.println(i);
        
        try {
			getInfo(searchId, request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.setAttribute("rep", rep);
        request.setAttribute("i", i);
        RequestDispatcher dispatcher = request.getRequestDispatcher("info.jsp");
        dispatcher.forward(request, response);

    }
    
    private void viewNews(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	File file = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/icon-128x128.png");

        BufferedImage bImage = ImageIO.read(file);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "png", bos);

        byte[] bytes = bos.toByteArray();

        String menu = Base64.getEncoder().encodeToString(bytes);
        System.out.println(menu + "\ntest");

        
        
        
        File file2 = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/logo.png");

        BufferedImage bImage2 = ImageIO.read(file2);

        ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
        ImageIO.write(bImage2, "png", bos2);

        byte[] bytes2 = bos2.toByteArray();


        String logo = Base64.getEncoder().encodeToString(bytes2);
        System.out.println(logo + "\ntest");

        System.out.println(request.getServletPath());
        
        
        File file3 = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/article1.png");

        BufferedImage bImage3 = ImageIO.read(file3);

        ByteArrayOutputStream bos3 = new ByteArrayOutputStream();
        ImageIO.write(bImage3, "png", bos3);

        byte[] bytes3 = bos3.toByteArray();


        String article = Base64.getEncoder().encodeToString(bytes3);
        System.out.println(article + "\ntest");

        System.out.println(request.getServletPath());
        
        File file4 = new File("C:/Users/tonst/OneDrive/Desktop/ASCProjects/poli_view/WebContent/images/article2.png");

        BufferedImage bImage4 = ImageIO.read(file4);

        ByteArrayOutputStream bos4 = new ByteArrayOutputStream();
        ImageIO.write(bImage4, "png", bos4);

        byte[] bytes4 = bos4.toByteArray();


        String article1 = Base64.getEncoder().encodeToString(bytes4);
        System.out.println(article1 + "\ntest");

        System.out.println(request.getServletPath());

       
       request.setAttribute("menu", menu);
       request.setAttribute("logo", logo);
       request.setAttribute("article", article);
       request.setAttribute("article1", article1);
    	 RequestDispatcher dispatcher = request.getRequestDispatcher("news.jsp");
         dispatcher.forward(request, response);
    }
    
    
    private void getInfo(String id, HttpServletRequest request, HttpServletResponse response) throws IOException, SAXException{
        String apiKey = "f78c840b2c831d68502bd1e935ec5aa9";
        URL url = new URL("http://api.votesmart.org/CandidateBio.getBio?key="+apiKey+"&candidateId="+id);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer buf = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            buf.append(inputLine);
        }
        
        in.close();
        
        System.out.println(buf.toString());
        Element err = (Element)null;
        Document doc =null;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new InputSource(new StringReader(buf.toString())));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        NodeList errNodes = doc.getElementsByTagName("bio");
        if(errNodes.getLength() >0) {
        	err = (Element)errNodes.item(0);
        }
        String birthDate = err.getElementsByTagName("birthDate").item(0).getTextContent();
        
        String birthPlace = err.getElementsByTagName("birthPlace").item(0).getTextContent();
    
        String officeName = err.getElementsByTagName("name").item(0).getTextContent();
        
        List<Integer> committees = new ArrayList();
        int num = 0;
        
        while(true) {
        	try {
        		int committee = Integer.parseInt(err.getElementsByTagName("committeeId").item(num).getTextContent());
        		num++;
        		committees.add(committee);
        	} catch (NullPointerException e) {
        		
        		break;
        	}
        }
        
        
        int size = committees.size();
        
        List<Committee> committeesList = new ArrayList();
        
        for(int i = 0; i < size; i++) {
        	String committeeId = String.valueOf(committees.get(i));
        	url = new URL("http://api.votesmart.org/Committee.getCommittee?key="+apiKey+"&committeeId="+committeeId);
        	
        	con = (HttpURLConnection) url.openConnection();
            responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            inputLine = "";
            buf = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                buf.append(inputLine);
            }
            
            in.close();
            
            System.out.println(buf.toString());
            err = (Element)null;
            doc =null;
    		try {
    			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
    					.parse(new InputSource(new StringReader(buf.toString())));
    		} catch (SAXException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (ParserConfigurationException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            errNodes = doc.getElementsByTagName("committee");
            if(errNodes.getLength() >0) {
            	err = (Element)errNodes.item(0);
            }
        String name = err.getElementsByTagName("name").item(0).getTextContent();
        String jurisdiction = err.getElementsByTagName("jurisdiction").item(0).getTextContent();
        System.out.println(jurisdiction);
        String address = err.getElementsByTagName("address1").item(0).getTextContent();
        String city = err.getElementsByTagName("city").item(0).getTextContent();
        String state = err.getElementsByTagName("state").item(0).getTextContent();
        String zip = err.getElementsByTagName("zip").item(0).getTextContent();
        String phone = err.getElementsByTagName("phone").item(0).getTextContent();
        String site = err.getElementsByTagName("url").item(0).getTextContent();
        String staffContact = err.getElementsByTagName("staffContact").item(0).getTextContent();
        
        committeesList.add(new Committee(committees.get(i), name, jurisdiction, address, city, state, zip, phone, site.concat(staffContact)));
        }
        
        
        request.setAttribute("committeesList", committeesList);
    }

}
