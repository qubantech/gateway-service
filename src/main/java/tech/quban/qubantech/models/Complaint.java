package tech.quban.qubantech.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Complaint implements Serializable {
    private String id;
    private String status;
    private Long dateSent;
    private Long dateResponded;
    private String userId;
    private String theme;
    private String text;
    private String[] tags;
    private String[] keywords;
    private Long institutionId;
    private String response;
    private Double score;
}
