.class Lcom/amazon/mShop/payment/alipay/AlipayDelegate$1;
.super Ljava/lang/Object;
.source "AlipayDelegate.java"

# interfaces
.implements Lcom/amazon/mShop/payment/alipay/AlipayCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/payment/alipay/AlipayDelegate;->payWithAlipay(Lcom/amazon/mShop/web/MShopWebActivity;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/payment/alipay/AlipayDelegate;

.field final synthetic val$activity:Lcom/amazon/mShop/web/MShopWebActivity;

.field final synthetic val$returnUrl:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/payment/alipay/AlipayDelegate;Lcom/amazon/mShop/web/MShopWebActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/mShop/payment/alipay/AlipayDelegate$1;->this$0:Lcom/amazon/mShop/payment/alipay/AlipayDelegate;

    iput-object p2, p0, Lcom/amazon/mShop/payment/alipay/AlipayDelegate$1;->val$activity:Lcom/amazon/mShop/web/MShopWebActivity;

    iput-object p3, p0, Lcom/amazon/mShop/payment/alipay/AlipayDelegate$1;->val$returnUrl:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPaymentFinish(Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;Ljava/lang/String;)V
    .locals 3
    .param p1, "status"    # Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;
    .param p2, "result"    # Ljava/lang/String;

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/mShop/payment/alipay/AlipayDelegate$1;->val$activity:Lcom/amazon/mShop/web/MShopWebActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebActivity;->setSkipStopBehavior(Z)V

    .line 83
    iget-object v0, p0, Lcom/amazon/mShop/payment/alipay/AlipayDelegate$1;->this$0:Lcom/amazon/mShop/payment/alipay/AlipayDelegate;

    iget-object v1, p0, Lcom/amazon/mShop/payment/alipay/AlipayDelegate$1;->val$activity:Lcom/amazon/mShop/web/MShopWebActivity;

    iget-object v2, p0, Lcom/amazon/mShop/payment/alipay/AlipayDelegate$1;->val$returnUrl:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/payment/alipay/AlipayDelegate;->navigateBackFromAlipay(Lcom/amazon/mShop/web/MShopWebActivity;Ljava/lang/String;Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;Ljava/lang/String;)V
    invoke-static {v0, v1, v2, p1, p2}, Lcom/amazon/mShop/payment/alipay/AlipayDelegate;->access$100(Lcom/amazon/mShop/payment/alipay/AlipayDelegate;Lcom/amazon/mShop/web/MShopWebActivity;Ljava/lang/String;Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;Ljava/lang/String;)V

    .line 84
    return-void
.end method
