package com.artland.dao;


import com.artland.entity.Tag;
import com.artland.entity.TagCount;
import com.artland.entity.TagExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    long countByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    int deleteByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    int insert(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    int insertSelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    List<Tag> selectByExampleWithRowbounds(TagExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    List<Tag> selectByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    Tag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Tag record);

    /**
     * 根据Id删除标签
     * @param id
     * @return
     */
    int deleteTagById(Integer  id);

    /**
     * 根据多个Id删除标签
     * @param ids
     * @return
     */
    int deleteTagsByIds(Integer[] ids);

    List<TagCount> selectTagCountsForBlog(Integer userId);

    List<TagCount> selectTagCountsForMedia(Integer userId);
}