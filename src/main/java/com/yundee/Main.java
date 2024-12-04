package com.yundee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yundee.domin.FileObject;
import com.yundee.domin.MessageObject;
import com.yundee.scripts.Getter;
import lombok.extern.slf4j.Slf4j;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Slf4j
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Getter getter = new Getter();
        String json = getter.GetList();
        // 创建 ObjectMapper 实例
        ObjectMapper objectMapper = new ObjectMapper();
        MessageObject messageObject = objectMapper.readValue(json, MessageObject.class);
        ArrayList<FileObject> fileObjects = objectMapper.readValue( messageObject.getData().toString(),new TypeReference<ArrayList<FileObject>>() {});
        for (FileObject fileObject : fileObjects) {
            // 将时间戳转换为 LocalDateTime
            LocalDateTime dateTime = Instant.ofEpochSecond(fileObject.getCreated_at())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            // 格式化为可读的字符串
            String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            log.info(formattedDate);
        }
    }
}
