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
        name = "FinalExam",
        urlPatterns = {"/finalExam"}
    )

public class FinalExam extends HttpServlet
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
       

        out.println ("<h1>SWE 432 Final Exam </h1>");

		out.println ("<span style=\"width: 90%; float: left\">");
		out.println ("<h4>Please enter comma separated strings or numbers you would like to sort</h4>");
		out.println ("<input type=\"text\" id=\"inputBox\"  style=\"float: left;width: 60%;  padding:10px;border:2px;box-shadow:0 0 3px 4px rgba(0,0,0,0.06);\"/>");
		out.println ("<br/><br/>");
        out.println ("<span style=\"float: left; margin-top:15px\">");
        out.println ("<button id=\"buttonSort\" style=\"padding:10px;\" onclick=\"defaultSort()\">Default Sort</button>");
        out.println ("<button id=\"buttonDescendingSort\" style=\"padding:10px;\" onclick=\"descendingSort()\">Descending Sort</button>");
        out.println ("<button id=\"buttonNumericSort\" style=\"padding:10px;\" onclick=\"numericDefaultSort()\">Numeric Sort</button>");
        out.println ("<button id=\"buttonDescendingNumericSort\" style=\"padding:10px;\" onclick=\"numericDescendingSort()\">Descending Numeric Sort</button>");
        out.println ("<button id=\"buttonDuplicatesSort\" style=\"padding:10px;\" onclick=\"removeDuplicatesAndSort()\">Remove Duplicates and Sort</button>");
        out.println (" </span>");
		out.println ("</span>");
		out.println ("<br/><br/>");
		out.println ("<span id=\"result\" style=\"width: 90%; float: left; margin-top:20px\"></span>");
		out.println ("<script type=\"text/javascript\">");
		out.println ("var resultTxt = '';");
		out.println ("var inputTxt = '';");
		out.println ("var inputArray = [];");
		// function that sorts array in default alphabetical order
		out.println ("function defaultSort() {");
		//clean result variable
        out.println ("resultTxt = '';");
		//clean result output span
        out.println ("readInput();");
        out.println ("document.getElementById(\"result\").innerHTML = resultTxt;"); 
		//javascript function for default sort
		out.println (" var sortedArr = inputArray.sort();");
		//concatinate output
        out.println ("sortedArr.forEach(concatinateFunction);");
		//remove last 2 character in the output string (, )
        out.println ("var sortedResult = resultTxt.substring(0, resultTxt.length - 2);");
		//print out result
        out.println ("document.getElementById(\"result\").innerHTML = sortedResult;");
		out.println ("}");
		// function removes duplicates and  sorts in default alphabetical order
		out.println ("function removeDuplicatesAndSort() {");
		//clean result variable
        out.println ("resultTxt = '';");
		//clean result span
        out.println ("document.getElementById(\"result\").innerHTML = resultTxt;");
        out.println ("readInput();");
		//sort array in default order
        out.println ("var sortedArr = inputArray.sort();");
		//javascrip function removes duplicates
        out.println ("var resultArr = sortedArr.filter(function(a, b) { return sortedArr.indexOf(a) === b; });");
		//concatinate  result array to string
        out.println ("resultArr.forEach(concatinateFunction);");
		//remove last 2 characters (, )
        out.println ("var sortedResult = resultTxt.substring(0, resultTxt.length - 2);");
		//print out resut
        out.println ("document.getElementById(\"result\").innerHTML = sortedResult;");
		out.println ("}");
		//function reads input from the input box
		out.println ("function readInput() {");
        out.println ("inputTxt = document.getElementById(\"inputBox\").value;");
		//convert everything to lower case for clean sort
        out.println ("inputTxt = inputTxt.toLowerCase();");
		//create array out of input string
        out.println ("var res = inputTxt.split(\",\");");
		//remove extra empty spaces 
        out.println ("inputArray = res.map(str => str.trim());");
		out.println ("}");
		//function for  decending  alphabetical sort
		out.println ("function descendingSort() {");
		//clean result  variable
        out.println ("resultTxt = '';");
		//clean last result form the screen
        out.println ("document.getElementById(\"result\").innerHTML = resultTxt;");
		//read input from input box
        out.println ("readInput();");
		//first sort  array with default order
        out.println ("var sortedArr = inputArray.sort();");
		//then reverse the array into descending order
        out.println ("var sortedArrReversed = sortedArr.reverse();");
		//concatinate the result into the string
        out.println ("sortedArrReversed.forEach(concatinateFunction);");
		//remove last 2 characters
        out.println ("var sortedResult = resultTxt.substring(0, resultTxt.length - 2);");
		//print out results
        out.println ("document.getElementById(\"result\").innerHTML = sortedResult;");
		out.println ("}");
		//function for numeric sort ( ascending order)
		out.println ("function numericDefaultSort() {");
		//clean
        out.println ("resultTxt = '';");
		//clean last result from the screen
        out.println ("document.getElementById(\"result\").innerHTML = resultTxt;");
		//read input
        out.println ("readInput();");
		//javascript function converting array of strings to array of numbers
		out.println ("var numericArray = inputArray.map(Number);");
		// javascript function for numeric sort in ascending order
        out.println ("var sortedArr = numericArray.sort(function (a, b) { return a-b; });");
		//concatinate the result into string 
        out.println ("sortedArr.forEach(concatinateFunction);");
		//remove last 2 characters
        out.println ("var sortedResult = resultTxt.substring(0, resultTxt.length - 2);");
		//print out results
        out.println ("document.getElementById(\"result\").innerHTML = sortedResult;");
		out.println ("}");
		// same as above but in descending order
		out.println ("function numericDescendingSort() {");
        out.println ("resultTxt = '';");
        out.println ("document.getElementById(\"result\").innerHTML = resultTxt;");
        out.println ("readInput();");
        out.println ("var numericArray = inputArray.map(Number);");
        out.println ("var sortedArr = numericArray.sort(function (a, b) { return b - a; });");
        out.println ("sortedArr.forEach(concatinateFunction);");
        out.println ("var sortedResult = resultTxt.substring(0, resultTxt.length - 2);");
        out.println ("document.getElementById(\"result\").innerHTML = sortedResult;");
		out.println ("}");
		// function concatinates array into string, comma separated
		out.println ("function concatinateFunction(value, index, array) {");
        out.println ("resultTxt = resultTxt + value + \", \";");
		out.println ("}");
		out.println ("</script>");
      
        out.println ("</BODY>");

        out.println ("</HTML>");
        out.flush();

        out.close ();

    }
}
