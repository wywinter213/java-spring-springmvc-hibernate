package com.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * `pid` int(11) NOT NULL,
 `pname` varchar(255) DEFAULT NULL,
 `market_price` float DEFAULT NULL,
 `shop_price` float DEFAULT NULL,
 `inventory` int(5) NOT NULL,
 `image` varchar(255) DEFAULT NULL,
 `pdesc` varchar(255) DEFAULT NULL,
 `is_hot` int(11) DEFAULT NULL,
 `pdate` datetime DEFAULT NULL,
 `csid` int(11) DEFAULT NULL
 */

@Entity
@Table(name="product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pid;
    private String pname;

    @Column(scale=1, precision=1)
    private Float market_price;
    @Column(scale=1, precision=1)
    private Float shop_price;

    private Integer inventory;
    @Lob
    @Column(table="product", length = 255, columnDefinition = "varchar", nullable = true)
    private String image;
    @Lob
    @Column(length = 255, columnDefinition = "text", nullable = true)
    private String pdesc;
    private Integer is_hot;

    @Temporal(TemporalType.TIMESTAMP)
    private Date pdate;

    /**
     * @ManyToOne 使用此标签建立多对一关联，此属性在“多”方使用,注解在我们的“一”方属性上
     * @cascade 指定级联操作，以数组方式指定，如果只有一个，可以省略“{}”
     * @fetch 定义抓取策略
     * @optional 定义是否为必需属性，如果为必需（false），但在持久化时user = null,则会持久化失败
     * @targetEntity 目标关联对象，默认为被注解属性所在类
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="csid")//@JoinColumn注解的都是在“主控方”，因而我们需要注解在Product类中
    private CategorySecond categorySecond;

    //与orderitem表是一对多关系
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "product")
    private Set<OrderItem> orderItems;

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Float getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Float market_price) {
        this.market_price = market_price;
    }

    public Float getShop_price() {
        return shop_price;
    }

    public void setShop_price(Float shop_price) {
        this.shop_price = shop_price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

//    public CategorySecond getCategorySecond() {
//        return categorySecond;
//    }
//
//    public void setCategorySecond(CategorySecond categorySecond) {
//        this.categorySecond = categorySecond;
//    }
}
