package org.webkit.myweb.controller;

import org.webkit.myweb.board.model.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

public class BoardController implements Controller {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String viewName = "/WEB-INF/views/board/list.jsp";
        BoardDTO board1 = new BoardDTO(1L, 24L, "제목", "이게 무슨 일이야?ㅋ", "박준수", new Date());

        ArrayList<BoardDTO> boardList = new ArrayList<>();
        boardList.add(board1);
        request.setAttribute("boardList", boardList);

        return viewName;
    }
}
