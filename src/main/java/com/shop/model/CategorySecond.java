package com.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * `csid` int(11) NOT NULL,
 `csname` varchar(255) DEFAULT NULL,
 `cid` int(11) DEFAULT NULL
 */
@Entity
@Table(name="categorysecond")
public class CategorySecond implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer csid;

    @Column(table = "categorysecond", length = 255, columnDefinition = "varchar", nullable = true)
    private String csname;

    /**
     * categorysecond表和product表是一对多关系，要再“一”所在实体添加下列代码，具体参数根据情况来定
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;//产品作为多方，我们使用Set集合来存储，同时还能防止存放相同的产品

    /**
     * categorysecond表和category表是多对一关系
     * @JoinColumn要再多的一方设置
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="cid")
    private Category category;

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
