package com.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * `tid` int(11) NOT NULL COMMENT '优惠券编号',
 `privilege` double NOT NULL COMMENT '优惠券金额',
 `consume` double NOT NULL COMMENT '满减金额',
 `useTime` datetime NOT NULL COMMENT '使用期限',
 `cid` int(11) NOT NULL COMMENT '类别编号',
 `pacid` int(11) NOT NULL COMMENT '卡包编号'
 */

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tid;


    private Double privilege;
    private Double consume;

    @Temporal(TemporalType.TIMESTAMP)
    private Date useTime;

    //cid一对一的关联category表
    @OneToOne(optional = false)
    @JoinColumn(name = "cid", unique = true, nullable = false)
    private Category category ;

    //多个ticket记录对应一个卡包，多对一关系
    @ManyToOne(targetEntity = Ticket.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "pacid")
    private Packet packet;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Double getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Double privilege) {
        this.privilege = privilege;
    }

    public Double getConsume() {
        return consume;
    }

    public void setConsume(Double consume) {
        this.consume = consume;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }
}
