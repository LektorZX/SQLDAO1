package Servlets;

import REST.Restaraunt;
import Servis.RestServis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/resta")

public class ServletOnRest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/Html");
        PrintWriter writer = resp.getWriter();
        String collect = RestServis.getINSTANSE().getAll().stream()
                .map(this::model)
                .collect(Collectors.joining());
        writer.print(collect);
    }
    private String model(Restaraunt restaraunt){
        return "<p>"+restaraunt.getId()+" "+restaraunt.getName()+"</p>";
    }
}
