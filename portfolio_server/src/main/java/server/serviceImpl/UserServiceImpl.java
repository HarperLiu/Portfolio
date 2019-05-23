package server.serviceImpl;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dao.FileDao;
import server.dao.UserRepository;
import server.daoImpl.FileDaoImpl;
import server.entity.UserEntity;
import server.service.UserService;
import server.util.ResultMessage;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private FileDao fileDao = new FileDaoImpl();

    private final String riskValuesPath = "/Users/apple/Desktop/Portfolio/portfolio_server/src/main/resources/static/jsonData/riskManagement.json";

    @Override
    public ResultMessage login(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity!=null&&userEntity.getPassword().equals(password)){
            return ResultMessage.SUCCESS;
        }
        return ResultMessage.FAILED;
    }

    @Override
    public ResultMessage register(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity!=null){
            return ResultMessage.FAILED;
        }
        else{
            userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setPassword(password);
            userRepository.save(userEntity);
            return ResultMessage.SUCCESS;
        }
    }

    @Override
    public int getUserIdByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity!=null){
            return userEntity.getId();
        }
        return -1;
    }

    @Override
    public int AssessUserRisk(List<Integer> sheet,int userId) {
        String values = fileDao.readJsonFile(riskValuesPath);
        int res = 0;
        JSONArray jsonArray = new JSONArray(values);
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            res+=Integer.parseInt((String)jsonObject.get(sheet.get(i)+""));
        }
        UserEntity userEntity = userRepository.findById(userId);
        userEntity.setRisk(res);
        userRepository.save(userEntity);
        return res;
    }
}
