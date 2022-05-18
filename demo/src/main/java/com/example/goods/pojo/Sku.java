package com.example.goods.pojo;


import org.springframework.context.annotation.Bean;


import java.io.Serializable;
import java.util.Date;

/****
 * @Author:admin
 * @Description:Sku构建
 * @Date 2019/6/14 19:13
// *****/
//@Table(name="tb_sku")
//@Entity(name="tb_sku")
public class Sku implements Serializable,Cloneable {
	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

	//@Id
    //@Column(name = "id")
	private Long id;//商品id

    //@Column(name = "sn")
	private String sn;//商品条码

    //@Column(name = "name")
	private String name;//SKU名称

    //@Column(name = "price")
	private Integer price;//价格（分）

    //@Column(name = "num")
	private Integer num;//库存数量

    //@Column(name = "alert_num")
	private Integer alertNum;//库存预警数量

    //@Column(name = "image")
	private String image;//商品图片

    //@Column(name = "images")
	private String images;//商品图片列表

    //@Column(name = "weight")
	private Integer weight;//重量（克）

    //@Column(name = "create_time")
	private Date createTime;//创建时间

    //@Column(name = "update_time")
	private Date updateTime;//更新时间

    //@Column(name = "spu_id")
	private Long spuId;//SPUID

    //@Column(name = "category_id")
	private Integer categoryId;//类目ID

    //@Column(name = "category_name")
	private String categoryName;//类目名称

    //@Column(name = "brand_name")
	private String brandName;//品牌名称

    //@Column(name = "spec")
	private String spec;//规格

    //@Column(name = "sale_num")
	private Integer saleNum;//销量

    //@Column(name = "comment_num")
	private Integer commentNum;//评论数

    //@Column(name = "status")
	private String status;//商品状态 1-正常，2-下架，3-删除


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getAlertNum() {
		return alertNum;
	}

	public void setAlertNum(Integer alertNum) {
		this.alertNum = alertNum;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getSpuId() {
		return spuId;
	}

	public void setSpuId(Long spuId) {
		this.spuId = spuId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
