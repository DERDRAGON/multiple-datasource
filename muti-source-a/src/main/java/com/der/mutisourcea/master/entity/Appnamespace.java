package com.der.mutisourcea.master.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Appnamespace implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appnamespace.Id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appnamespace.Name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appnamespace.AppId
     *
     * @mbggenerated
     */
    private String appid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appnamespace.Format
     *
     * @mbggenerated
     */
    private String format;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appnamespace.IsPublic
     *
     * @mbggenerated
     */
    private Boolean ispublic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appnamespace.Comment
     *
     * @mbggenerated
     */
    private String comment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appnamespace.IsDeleted
     *
     * @mbggenerated
     */
    private Boolean isdeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appnamespace.DataChange_CreatedBy
     *
     * @mbggenerated
     */
    private String datachangeCreatedby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appnamespace.DataChange_CreatedTime
     *
     * @mbggenerated
     */
    private Date datachangeCreatedtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appnamespace.DataChange_LastModifiedBy
     *
     * @mbggenerated
     */
    private String datachangeLastmodifiedby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appnamespace.DataChange_LastTime
     *
     * @mbggenerated
     */
    private Date datachangeLasttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table appnamespace
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;
}