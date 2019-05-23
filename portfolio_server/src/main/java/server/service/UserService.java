package server.service;

import org.json.JSONObject;
import server.util.ResultMessage;

import java.util.List;

public interface UserService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public ResultMessage login(String username,String password);

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    public ResultMessage register(String username,String password);

    /**
     * 根据用户名返回用户id
     * @param username
     * @return
     */
    public int getUserIdByUsername(String username);

    /**
     * 判断用户投资偏好
     * @param sheet
     * @param userId
     * @return
     */
    public int AssessUserRisk(List<Integer> sheet,int userId);
}
