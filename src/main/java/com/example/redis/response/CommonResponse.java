package com.example.redis.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommonResponse {
    private Object data;
    private String status;
    private String msg;
    private long processCnt;
}
