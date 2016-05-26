package server.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Damien on 24.05.2016.
 */
public class ConverterJSON {
    public static String toJSON_String(Map map, boolean root) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(map.values());
        if(root){
            str = str.replaceAll(",\"parent\":0}", "}");
        }
        return str;
    }
}
