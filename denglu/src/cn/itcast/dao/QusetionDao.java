package cn.itcast.dao;

import cn.itcast.domain.Question;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表的类
 */
public class QusetionDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public Question login(String x){
        try {
            //1.编写sql
            String sql = "select * from choice where id = ?";
            //2.调用query方法
            Question question = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Question>(Question.class),x
            );
            return question;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }
    }
}
