package util;

import org.apache.http.HttpEntity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 * Created by guoqing on 20/7/17.
 */
public class HttpUtil {
    private static final Logger logger = Logger.getLogger(HttpUtil.class.getName());

    HttpUtil(){

    }

    public static String getChunk(HttpEntity entity) throws IOException {
        String chunk = null;
        byte[] buffer = new byte[1024];
        if (entity != null) {
            InputStream inputStream = entity.getContent();
            int bytesRead = 0;
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            while ((bytesRead = bis.read(buffer)) != -1) {
                chunk = new String(buffer, 0, bytesRead);
                logger.info(chunk);
            }
            inputStream.close();
        }
        return chunk;
    }
}
