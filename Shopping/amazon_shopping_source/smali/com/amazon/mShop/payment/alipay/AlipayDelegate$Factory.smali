.class public Lcom/amazon/mShop/payment/alipay/AlipayDelegate$Factory;
.super Ljava/lang/Object;
.source "AlipayDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/payment/alipay/AlipayDelegate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Factory"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/payment/alipay/AlipayDelegate;
    .locals 1

    .prologue
    .line 24
    # getter for: Lcom/amazon/mShop/payment/alipay/AlipayDelegate;->SINGLETON_INSTANCE:Lcom/amazon/mShop/payment/alipay/AlipayDelegate;
    invoke-static {}, Lcom/amazon/mShop/payment/alipay/AlipayDelegate;->access$000()Lcom/amazon/mShop/payment/alipay/AlipayDelegate;

    move-result-object v0

    return-object v0
.end method
