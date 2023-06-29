package com.example.parentandchildtask.repository;

import com.example.parentandchildtask.entity.Child;
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
    private final RowMapper<Child> rowMapper = (rs, rowNum) -> (
            new Child(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDate(3)
            ));

    @Override
    public List<Child> getAllChild() {
        String sql = "Select * from Child";
        return template.query(sql, rowMapper);
    }

    @Override
    public Child getChildById(int id) {
        String sql = "Select * from Child Where id=?";
        return template.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    @Override
    public Child creatChild(Child child) {
        String sql = "Insert into Child(name,birth_date)";
        template.update(sql, child.getName(), child.getBirth_date());
        return child;
    }

    @Override
    public Child delete (int id) {
        String sql = "Delete from Child Where id =?";
        template.update(sql, id);
        return null;
    }

    @Override
    public Child updateById(Child child, int id) {
        String sql = "Update Child Set name=?,birth_date=?, Where id=?";
        template.update(sql, child.getName(), child.getBirth_date());
        return child;
    }
}
