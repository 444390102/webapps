package web;
import com.alibaba.fastjson.JSON;
import util.JsonTool;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

@WebServlet("/loginAction")
public class LoginAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        String data = null;
        JsonTool jsonTool = new JsonTool();
        try {
            data = jsonTool.InString(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data);
        List<Map<String, Object>> maps = JSON.parseObject(data, List.class);
        for (Map<String, Object> map : maps) {
            System.out.println(map.get("uAcc"));
            System.out.println(map.get("uPwd"));
        }
        response.setContentType("application/json");
        try {
            jsonTool.OutString(response.getWriter(), JSON.toJSONString(maps));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
