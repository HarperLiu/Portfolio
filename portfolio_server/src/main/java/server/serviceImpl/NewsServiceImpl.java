package server.serviceImpl;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import server.dao.FileDao;
import server.daoImpl.FileDaoImpl;
import server.service.NewsService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service(value = "newsService")
public class NewsServiceImpl implements NewsService {
    private FileDao fileDao = new FileDaoImpl();
    private final String newsCommandPath = "/Users/apple/Desktop/Portfolio/portfolio_server/src/main/resources/static/instructions/newsCommand.sh";
    private final String indexCommandPath = "/Users/apple/Desktop/Portfolio/portfolio_server/src/main/resources/static/instructions/indexCommand.sh";
    private final String newsJsonFilePath = "/Users/apple/Desktop/Portfolio/portfolio_server/src/main/resources/static/jsonData/news.json";
    private final String indexJsonFilePath = "/Users/apple/Desktop/Portfolio/portfolio_server/src/main/resources/static/jsonData/index.json";
    @Override
    public JSONArray searchNews() {
        try {
            Process process = Runtime.getRuntime().exec(newsCommandPath);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String news = fileDao.readJsonFile(newsJsonFilePath);
        JSONArray jsonArray = new JSONArray(news);
        for(int i=0;i<jsonArray.length();i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(jsonObject.get("content").equals("")||(Double)jsonObject.get("rcounts")==0.0){
                jsonArray.remove(i);
                i--;
            }
        }
        return jsonArray;
    }

    @Override
    public JSONArray searchIndexes() {
        try {
            Process process = Runtime.getRuntime().exec(indexCommandPath);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String index = fileDao.readJsonFile(indexJsonFilePath);
        JSONArray jsonArray = new JSONArray(index);
        return jsonArray;
    }

}
