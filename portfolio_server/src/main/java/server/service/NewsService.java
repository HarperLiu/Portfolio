package server.service;

import netscape.javascript.JSObject;
import org.json.JSONArray;

import java.util.List;

public interface NewsService {
    /**
     * 搜索新闻
     * @return
     */
    public JSONArray searchNews();

    /**
     * 搜索指数
     * @return
     */
    public JSONArray searchIndexes();
}
