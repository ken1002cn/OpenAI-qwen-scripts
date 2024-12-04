package com.yundee.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileObject {
    private String id;
    private String object;
    private Long bytes;
    private Long created_at;
    private String filename;
    private String purpose;
    private String status;
}
