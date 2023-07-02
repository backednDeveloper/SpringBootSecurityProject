package com.example.parentandchildtask.repository;

import com.example.parentandchildtask.entity.ParentEntity;
import com.example.parentandchildtask.interface1.ParentInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParentRepository implements ParentInterface {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<ParentEntity> rowMapper = (rs, rowNum) -> (
            new ParentEntity(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4),
                    rs.getInt(5)
            ));

    @Override
    public List<ParentEntity> getAllParent() {
        String sql = "Select * from Parent";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public ParentEntity getParentById(int id) {
        String sql = "Select * from Parent WHERE=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    @Override
    public ParentEntity creatTeacher(ParentEntity parent) {
        String sql = "Insert into Parent(name,surname,birth_date,job_name) Values(?,?,?,?)";
        jdbcTemplate.update(sql, parent.getName(), parent.getSurname(),
                parent.getBirth_date());
        return parent;
    }

    @Override
    public ParentEntity delete (int id) {
        String sql = "Delete from Parent Where id=?";
        jdbcTemplate.update(sql, id);
        return null;
    }

    @Override
    public ParentEntity updateById(ParentEntity parent, int id) {
        String sql = "Update from Parent (name,surname,birth_date,job_name) Where id=? ";
        jdbcTemplate.update(sql, parent.getBirth_date(), parent.getName(), parent.getSurname());
        return parent;
    }
}
