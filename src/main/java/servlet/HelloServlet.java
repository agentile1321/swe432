package servlet;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/hello"}
    )

public class HelloServlet extends HttpServlet
{
  @Override
   protected void doGet  (HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException
   {

        res.setContentType ("text/html");
        PrintWriter out = res.getWriter ();

        out.println ("<HTML>");
        out.println ("<HEAD>");
        out.println ("<TITLE>SWE 432 Final Exam</TITLE>");
        out.println ("</HEAD>");

        out.println ("<BODY>");
        out.println ("<CENTER>");

        out.println ("<h1>SWE 432 Final Exam </h1>");
        out.println ("<span style=\"width: 90%; align: left\">");
        out.println ("<span>Please enter comma separated strings or numbers you would like to sort</span><br/>");
        out.println ("<input type=\"text\" id=\"inputBox\" name=\"inputBox\" style=\"align: left; width: 60%\"/> &nbsp;&nbsp;&nbsp;<button id=\"buttonSort\" onclick=\"defaultSort()\">Sort</button>");
        out.println ("</span>");
        out.println ("<br/><br />");
        out.println ("<span id=\"result\" style=\"width: 90%; align: left\"></span>");
        out.println ("<script type=\"text/javascript\">");
        out.println ("var resultTxt = \"\";");
        out.println ("function defaultSort() {");
        out.println ("document.getElementById(\"result\").innerHTML = \"\";");
        out.println ("var str = document.getElementById(\"inputBox\").value;");
        out.println ("var res = str.split(\",\");");
        out.println ("var trimedArr = res.map(str => str.trim());");
        out.println ("var sortedArr = trimedArr.sort();");
        out.println ("sortedArr.forEach(concatinateFunction);");
        out.println ("var sortedResult = resultTxt.substring(0, resultTxt.length - 2);");
       out.println (" document.getElementById(\"result\").innerHTML = sortedResult;");
     out.println ("}");

    out.println (" numbers.forEach(myFunction);");

    out.println (" function concatinateFunction(value, index, array) {");
         out.println ("resultTxt = resultTxt + value + \", \";");
     out.println ("}");
 out.println ("</script>");
      
        out.println ("</BODY>");

        out.println ("</HTML>");
        out.flush();

        out.close ();

    }
}
