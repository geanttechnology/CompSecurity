.class public Lcom/amazon/mShop/payment/alipay/AlipayAdapter$Factory;
.super Ljava/lang/Object;
.source "AlipayAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/payment/alipay/AlipayAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Factory"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/payment/alipay/AlipayAdapter;
    .locals 1

    .prologue
    .line 59
    # getter for: Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->SINGLETON_INSTANCE:Lcom/amazon/mShop/payment/alipay/AlipayAdapter;
    invoke-static {}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->access$000()Lcom/amazon/mShop/payment/alipay/AlipayAdapter;

    move-result-object v0

    return-object v0
.end method
