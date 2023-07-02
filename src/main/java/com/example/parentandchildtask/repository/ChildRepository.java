package com.example.parentandchildtask.repository;

import com.example.parentandchildtask.entity.ChildEntity;
import com.example.parentandchildtask.interface1.ChildInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class ChildRepository implements ChildInterface {
    private final JdbcTemplate template;
    private final RowMapper<ChildEntity> rowMapper = (rs, rowNum) -> (
            new ChildEntity(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDate(3)
            ));

    @Override
    public List<ChildEntity> getAllChild() {
        String sql = "Select * from Child";
        return template.query(sql, rowMapper);
    }

    @Override
    public ChildEntity getChildById(int id) {
        String sql = "Select * from Child Where id=?";
        return template.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    @Override
    public ChildEntity creatChild(ChildEntity child) {
        String sql = "Insert into Child(name,birth_date)";
        template.update(sql, child.getName(), child.getBirth_date());
        return child;
    }

    @Override
    public ChildEntity delete (int id) {
        String sql = "Delete from Child Where id =?";
        template.update(sql, id);
        return null;
    }

    @Override
    public ChildEntity updateById(ChildEntity child, int id) {
        String sql = "Update Child Set name=?,birth_date=?, Where id=?";
        template.update(sql, child.getName(), child.getBirth_date());
        return child;
    }
}
