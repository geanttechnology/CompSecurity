.class Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeWebViewClient;
.super Lcom/amazon/mShop/web/MShopWebViewClient;
.source "PrimeUpsellActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PrimeWebViewClient"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;Lorg/apache/cordova/CordovaInterface;)V
    .locals 2
    .param p2, "cordova"    # Lorg/apache/cordova/CordovaInterface;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeWebViewClient;->this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;

    .line 81
    new-instance v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeNavManager;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeNavManager;-><init>(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$1;)V

    invoke-direct {p0, p2, v0}, Lcom/amazon/mShop/web/MShopWebViewClient;-><init>(Lorg/apache/cordova/CordovaInterface;Lcom/amazon/mShop/mash/nav/AmazonNavManager;)V

    .line 82
    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 0
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 86
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/web/MShopWebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 87
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->primePageFinishLoading()V

    .line 88
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 92
    invoke-super {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/web/MShopWebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V

    .line 93
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->primePageFinishLoading()V

    .line 94
    return-void
.end method

.method public onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
    .locals 0
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "handler"    # Landroid/webkit/SslErrorHandler;
    .param p3, "error"    # Landroid/net/http/SslError;

    .prologue
    .line 98
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/web/MShopWebViewClient;->onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V

    .line 99
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->primePageFinishLoading()V

    .line 100
    return-void
.end method
