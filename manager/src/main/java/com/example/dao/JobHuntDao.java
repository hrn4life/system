package com.example.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.JobHunt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zby
 * @since 2023-04-17
 */
@Mapper
public interface JobHuntDao extends BaseMapper<JobHunt> {

    @SelectProvider(type = MyProvider.class, method = "getAllMethod")
    List<HashMap> getAll(Page<HashMap> page,String positon,String positionWorkplace,String minSalary);

    @SelectProvider(type = MyProvider1.class, method = "getAllMethod1")
    List<HashMap> getTotl(Map<String, Object> params);


    class MyProvider{
        public String getAllMethod(String positon,String positionWorkplace,String minSalary) {
                StringBuilder sqlBuilder = new StringBuilder();
                sqlBuilder.append("SELECT jh.user_id AS userId, s.NAME AS NAME, s.age AS age, s.gender AS gender, s.hobby AS hobby, s.university AS university, s.major AS major, r.photo AS photo, r.work_experiene AS workExperiene, r.self_assessment AS selfAssessment, r.award AS award, jh.create_time AS createTime, jh.min_salary AS minSalary, jh.position AS position, jh.job_type AS jobType, jh.position_workplace AS positionWorkplace, jh.note AS note ");
                sqlBuilder.append("FROM job_hunt jh JOIN student s ON jh.user_id = s.user_id JOIN resume r on r.stu_id = s.id ");
                sqlBuilder.append("WHERE jh.`status` = 1 ");

                if (!positionWorkplace.equals("")) {
                    sqlBuilder.append("AND jh.position_workplace like CONCAT('%', #{positionWorkplace}, '%') ");
                }

                if (!positon.equals("")) {
                    sqlBuilder.append("AND jh.position like CONCAT('%', #{positon}, '%') ");
                }

                if (!minSalary.equals("")) {
                    sqlBuilder.append("AND jh.min_salary <= #{minSalary} ");
                }

                return sqlBuilder.toString();

        }
    }


    class MyProvider1{
        public String getAllMethod1(Map<String, Object> params) {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT jh.user_id AS userId, s.NAME AS NAME, s.age AS age, s.gender AS gender, s.hobby AS hobby, s.university AS university, s.major AS major, r.photo AS photo, r.work_experiene AS workExperiene, r.self_assessment AS selfAssessment, r.award AS award, jh.create_time AS createTime, jh.min_salary AS minSalary, jh.position AS position, jh.job_type AS jobType, jh.position_workplace AS positionWorkplace, jh.note AS note ");
            sqlBuilder.append("FROM job_hunt jh JOIN student s ON jh.user_id = s.user_id JOIN resume r on r.stu_id = s.id ");
            sqlBuilder.append("WHERE jh.`status` = 1 ");

            if (params.containsKey("positionWorkplace") && params.get("positionWorkplace") != null && !params.get("positionWorkplace").equals("")) {
                sqlBuilder.append("AND jh.position_workplace like CONCAT('%', #{positionWorkplace}, '%') ");
            }

            if (params.containsKey("position") && params.get("position") != null && !params.get("position").equals("")) {
                sqlBuilder.append("AND jh.position like CONCAT('%', #{position}, '%') ");
            }

            if (params.containsKey("minSalary") && params.get("minSalary") != null && !params.get("minSalary").equals("")) {
                sqlBuilder.append("AND jh.min_salary <= #{minSalary} ");
            }

            return sqlBuilder.toString();

        }
    }
}
