package org.webkit.myweb.saram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SaramDAO {
    // CRUD 전담 class
    Connection conn; //DB 연결
    PreparedStatement stmt; // DB에 query 전달
    ResultSet rs; // 결과를 받아올 때 사용

    // search
    public List<SaramDTO> findAll() {
        return null;
    }

    public List<SaramDTO> findOne() {
        return null;
    }

    // input
    public void saveAll(SaramDTO dto) {

    }

    public void saveOne(SaramDTO dto) {

    }

    // edit
    public void update(SaramDTO dto) {
    }

    // delete
    public void deleteAll(SaramDTO dto) {

    }

    public void deleteOne(SaramDTO dto) {

    }

}
