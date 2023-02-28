package org.webkit.myweb.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long seq;
    private Long cnt; // 조회수
    private String title;
    private String content;
    private String author;
    private Date date = new Date();
}
