package com.shop.model;


import org.hibernate.validator.constraints.Email;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 CREATE TABLE `user` (
 `uid` int(11) NOT NULL,
 `username` varchar(255) DEFAULT NULL,
 `password` varchar(255) DEFAULT NULL,
 `name` varchar(255) DEFAULT NULL,
 `email` varchar(255) DEFAULT NULL,
 `phone` varchar(255) DEFAULT NULL,
 `age` int(5) DEFAULT NULL,
 `addr` varchar(255) DEFAULT NULL,
 `state` int(11) DEFAULT NULL,
 `code` varchar(64) DEFAULT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 */


@Entity//声明当前类为hibernate映射到数据库的实体类
@Table(name="user")//为实体Bean指定对应的数据表
public class User implements Serializable{

    @Id //声明当前字段为主键
    /**
     *  @GeneratedValue注解来定义生成策略
     *  GenerationType.TABLES 当前主键的值单独保存到一个数据库的表中
     *  GenerationType.SEQUENCE  利用底层数据库提供的序列生成标识符
     *  GenerationType.IDENTITY 采取数据库的自增策略
     *  GenerationType.AUTO 根据不同数据库自动选择合适的id生成方案，这里使用mysql,为递增型
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;

    @Column( columnDefinition="varchar",length = 255, nullable = true)//定义当前列的长度，是否为空，是否唯一等约束
    private String username;
    private String password;
    private String name;
    @Email(message = "邮箱格式错误")
    private String email;
    private String phone;

    /**
     * @Basic 基本属性类型映射,注解于非Static 非transient的属性，
     * 这时候我们可以为其声明抓取策略等属性
     * fetch: 获取策略，当以session.get()方法获取数据库对象时：
     *   fetchType.LAZY为懒加载，会在第一次使用该属性（如调用getAge()方法）时才获取。
     * FetchType.EAGER为即时加载。
     * optional:表示当前属性是否可选，默认为true，如果为false,则在持久化到数据库时，如果此属性为null，则会失败
     */
    @Basic(fetch = FetchType.EAGER, optional = true)
    private Integer age;
    /**
     * @Lob 注解表示属性将被持久化为Blob或者Clob类型,
     * 具体取决于属性的类型, java.sql.Clob, Character[], char[] 和 java.lang.String这些类型的属性都被持久化为Clob类型,
     * 而java.sql.Blob, Byte[], byte[] 和 serializable类型则被持久化为Blob类型.
     */
    @Lob
    @Column(columnDefinition="varchar",length = 255, nullable = true)//定义当前列的长度，是否为空，是否唯一等约束
    private String addr;
    private Integer state;
    @Column(length = 64, nullable = true)
    private String code;

    /**
     * @Temporal  标注在日期等属性上，声明映射为数据库的特定诶其属性类型，默认为java.sql.Timestamp（TemporalType.TIMESTAMP）
     *  此外还有java.sql.date（TemporalType.DATE）、java.sql.Time（TemporalType.TIME）
     */
//    @Temporal(TemporalType.TIME)
//    private Date birdDate;

    //卡包和用户表有一对一的关系
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Packet packet;
//
//    //一个人有一个钱包，一对一关系
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Wallet wallet;

    //一个用户可能有多个订单，一对多关系
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "uid")
//    private Set<Order> orders;

    /**
     * 构造函数，初始化类属性
     */
    public User() {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.addr = addr;
        this.state = state;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(age, user.age) &&
                Objects.equals(addr, user.addr) &&
                Objects.equals(state, user.state) &&
                Objects.equals(code, user.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, username, password, name, email, phone, age, addr, state, code);
    }

//    public Set<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<Order> orders) {
//        this.orders = orders;
//    }

//    public Wallet getWallet() {
//        return wallet;
//    }
//
//    public void setWallet(Wallet wallet) {
//        this.wallet = wallet;
//    }
//
//    public Packet getPacket() {
//        return packet;
//    }
//
//    public void setPacket(Packet packet) {
//        this.packet = packet;
//    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
