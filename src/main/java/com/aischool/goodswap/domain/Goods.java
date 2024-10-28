package com.aischool.goodswap.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Builder;
import lombok.ToString;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString(exclude = {"user"})
@Table(name = "tb_goods")
public class Goods {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_idx")
    private Long id;

    @Column(name = "goods_name", nullable = false)
    private String goodsName;

    @Column(name = "goods_price", nullable = false)
    private int goodsPrice;

    @Column(name = "goods_stock", nullable = false)
    private int goodsStock;

    @Column(name = "shipping_fee", nullable = false)
    private int shippingFee;

    @ManyToOne
    @JoinColumn(name = "user_email", nullable = false)
    private User user;

    @Column(name = "goods_desc", nullable = false)
    private String goodsDesc;

    @Column(name = "closed_at")
    private LocalDate closedAt;

    @Column(name = "goods_status", nullable = false)
    private String goodsStatus;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public Goods(String goodsName, int goodsPrice, int goodsStock, int shippingFee, User user,
      String goodsDesc, LocalDate closedAt, String goodsStatus) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsStock = goodsStock;
        this.shippingFee = shippingFee;
        this.user = user;
        this.goodsDesc = goodsDesc;
        this.closedAt = closedAt;
        this.goodsStatus = goodsStatus;
    }
}
