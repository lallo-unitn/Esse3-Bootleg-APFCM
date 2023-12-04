package it.unitn.disi.advprog.gennaro.adv_prog_project.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import it.unitn.disi.advprog.gennaro.adv_prog_project.dto.TeacherDto;
import it.unitn.disi.advprog.gennaro.adv_prog_project.managers.CourseManagerBean;
import it.unitn.disi.advprog.gennaro.adv_prog_project.managers.StudentManagerBean;
import it.unitn.disi.advprog.gennaro.adv_prog_project.managers.TeacherManagerBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class AssignGradeServlet extends HttpServlet {

    @EJB
    private TeacherManagerBean teacherManagerBean;
    @EJB
    private StudentManagerBean studentManagerBean;
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Get the studentId number from the request
//        int studentId = Integer.parseInt(req.getParameter("studentId"));
//
//        // Get the studentDto attribute from the session
//        TeacherDto teacherDto = (TeacherDto) req.getSession().getAttribute("teacherDto");
//
//        /*// Get the list of teachers associated with the student using the TeacherManagerBean
//        List<TeacherDto> teacherList = teacherManagerBean.getTeacherByStudent(studentId);
//
//        // Check if the student is enrolled in any course
//        if (!teacherList.contains(teacherDto)) {
//            // Set an error message and forward to teacher.jsp
//            req.setAttribute("messageStudent", "Not enrolled in your course");
//            req.getRequestDispatcher("restricted/teacher.jsp").forward(req, resp);
//            return;
//        }*/
//
//        // Get the grade from the request
//        int grade = Integer.parseInt(req.getParameter("grade"));
//
//        // Set the grade for the student using the TeacherManagerBean
//        teacherManagerBean.setStudentGrade(
//                studentManagerBean.getStudent(studentId),
//                teacherDto.getCourse(),
//                grade
//        );
//
//        // Forward the request to teacher.jsp
//        req.getRequestDispatcher("restricted/teacher.jsp").forward(req, resp);
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Read JSON data from the request body
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }

        // Parse JSON data using Gson library
        Gson gson = new Gson();
        JsonObject jsonData = gson.fromJson(requestBody.toString(), JsonObject.class);

        // print json data
        System.out.println(jsonData);

    //    // Extract fields from JSON
    //    long timestamp = jsonData.get("timestamp").getAsLong();
    //    String studentId = jsonData.get("studentId").getAsString();
    //    String grade = jsonData.get("grade").getAsString();
    //    String signatureBase64 = jsonData.get("signature").getAsString();
    //
    //    // Verify the signature (example: using Base64-decoded signature)
    //    byte[] signature = Base64.getDecoder().decode(signatureBase64);
    //    boolean signatureValid = verifySignature(jsonData, signature);
    //
    //    // Respond based on signature verification result
    //    if (signatureValid) {
    //        // Signature is valid, process the data (e.g., save to a database)
    //        processValidData(timestamp, studentId, grade);
    //
    //        // Respond with a success message
    //        sendResponse(response, "Signature verified, data processed successfully");
    //    } else {
    //        // Signature is not valid, reject the data
    //        sendResponse(response, "Invalid signature, data rejected");
    //    }
    }

    private boolean verifySignature(JsonObject jsonData, byte[] signature) {

        return true;
    }

    private void processValidData(long timestamp, String studentId, String grade) {
        // Implement data processing logic (e.g., save to a database)
        System.out.println("Processing data - Timestamp: " + timestamp + ", Student ID: " + studentId + ", Grade: " + grade);
    }

    private void sendResponse(HttpServletResponse response, String message) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
