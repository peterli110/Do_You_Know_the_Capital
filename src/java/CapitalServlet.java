/*
 * Student Info: Name=Xinkai Li, ID=16271
 * Subject: CS532B_HW1_Fall_2016
 * Author: PeterLi
 * Filename: CapitalServlet.java
 * Date and Time: 2016-11-30 19:20:19
 * Project Name: HW4
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PeterLi
 */
public class CapitalServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//            Int[] array = new Int[50];
//            for (int i = 0; i < list.size(); i++) {
//                array[i] = list.get(i);
//            }  
            String action=request.getParameter("action");
            HttpSession session=request.getSession();
            String url="";
            synchronized(session){
                String question="";
                String answer="";
                    if(action==null||action.equals("Next")){
                        String capitalsAndstate [][] = {
                            {"Alabama", "Montgomery"},
                            {"Alaska", "Juneau"},
                            {"Arizona", "Phoenix"},
                            {"Arkansas", "Little Rock"},
                            {"California", "Sacramento"},
                            {"Colorado", "Denver"},
                            {"Connecticut", "Hartford"},
                            {"Delaware", "Dover"},
                            {"Florida", "Tallahasse"},
                            {"Georgia", "Atlanta"},
                            {"Hawaii", "Honolulu"},
                            {"Idaho", "Boise"},
                            {"Illinois", "Springfield"},
                            {"Indiana", "Indianapolis"},
                            {"Iowa", "Des Moines"},
                            {"Kansas", "Topeka"},
                            {"Kentucky", "Frankfort"},
                            {"Louisiana", "Baton Rouge"},
                            {"Maine", "Augusta"},
                            {"Maryland", "Annapolis"},
                            {"Massachusettes", "Boston"},
                            {"Michigan", "Lansing"},
                            {"Minnesota", "Saint Paul"},
                            {"Mississippi", "Jackson"},
                            {"Missouri", "Jefferson City"},
                            {"Montana", "Helena"},
                            {"Nebraska", "Lincoln"},
                            {"Nevada", "Carson City"},
                            {"New Hampshire", "Concord"},
                            {"New Jersey", "Trenton"},
                            {"New York", "Albany"},
                            {"New Mexico", "Santa Fe"},
                            {"North Carolina", "Raleigh"},
                            {"North Dakota", "Bismark"},
                            {"Ohio", "Columbus"},
                            {"Oklahoma", "Oklahoma City"},
                            {"Oregon", "Salem"},
                            {"Pennslyvania", "Harrisburg"},
                            {"Rhode Island", "Providence"},
                            {"South Carolina", "Columbia"},
                            {"South Dakota", "Pierre"},
                            {"Tennessee", "Nashville"},
                            {"Texas", "Austin"},
                            {"Utah", "Salt Lake City"},
                            {"Vermont", "Montpelier"},
                            {"Virginia", "Richmond"},
                            {"Washington", "Olympia"},
                            {"West Virginia", "Charleston"},
                            {"Wisconsin", "Madison"},
                            {"Wyoming", "Cheyenne"}
                           };
                            ArrayList<String> list = new ArrayList<String>();
                            for (int i = 0; i < capitalsAndstate.length; i++)
                            {
                                list.add(capitalsAndstate[i][0]);
                            }
                            Collections.shuffle(list);
                            question = list.get(1);
                            session.setAttribute("question", question);
                            for(int i=0;i<capitalsAndstate.length;i++){
                                if(capitalsAndstate[i][0]==question){
                                   answer= capitalsAndstate[i][1];
                                }
                            }
                            session.setAttribute("answer", answer);
                            url="/capital.jsp";
                        }else if(action.equals("Submit")){
                            String capital_name=request.getParameter("capital_name");
                            session.setAttribute("capital_name", capital_name);
                            
                            if(capital_name.equals(session.getAttribute("answer"))){
                                String outcome = "Yes, the capital of "+session.getAttribute("question")+" is "+session.getAttribute("answer")+".";
                                session.setAttribute("outcome", outcome);
                                url="/result.jsp";
                            }else{
                                String outcome = "No, the capital of "+session.getAttribute("question")+" is "+session.getAttribute("answer")+".";
                                session.setAttribute("outcome", outcome);
                                url="/result.jsp";
                            }
                        }
                }
            RequestDispatcher dispatcher =getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
