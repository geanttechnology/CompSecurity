.class Lcom/amazon/device/ads/AmazonOOAdController$1;
.super Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;
.source "AmazonOOAdController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AmazonOOAdController;->getSpecialUrlExecutor()Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AmazonOOAdController;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AmazonOOAdController;Lcom/amazon/device/ads/AdView;Landroid/content/Context;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/device/ads/AdView;
    .param p3, "x1"    # Landroid/content/Context;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOOAdController$1;->this$0:Lcom/amazon/device/ads/AmazonOOAdController;

    invoke-direct {p0, p2, p3}, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;-><init>(Lcom/amazon/device/ads/AdView;Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method protected handleApplicationDefinedSpecialURL(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 48
    iget-object v1, p0, Lcom/amazon/device/ads/AmazonOOAdController$1;->this$0:Lcom/amazon/device/ads/AmazonOOAdController;

    # invokes: Lcom/amazon/device/ads/AmazonOOAdController;->getAmazonOOAdListener()Lcom/amazon/device/ads/AmazonOOAdListener;
    invoke-static {v1}, Lcom/amazon/device/ads/AmazonOOAdController;->access$000(Lcom/amazon/device/ads/AmazonOOAdController;)Lcom/amazon/device/ads/AmazonOOAdListener;

    move-result-object v0

    .line 49
    .local v0, "adListener":Lcom/amazon/device/ads/AmazonOOAdListener;
    if-eqz v0, :cond_0

    .line 51
    iget-object v1, p0, Lcom/amazon/device/ads/AmazonOOAdController$1;->this$0:Lcom/amazon/device/ads/AmazonOOAdController;

    invoke-virtual {v1}, Lcom/amazon/device/ads/AmazonOOAdController;->getAdLayout()Lcom/amazon/device/ads/AdLayout;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Lcom/amazon/device/ads/AmazonOOAdListener;->onSpecialUrlClicked(Lcom/amazon/device/ads/Ad;Ljava/lang/String;)V

    .line 53
    :cond_0
    return-void
.end method
