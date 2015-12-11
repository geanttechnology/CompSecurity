.class Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;
.super Lcom/amazon/mShop/web/MShopWebViewClient;
.source "WebPurchaseActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->createWebViewClient()Lcom/amazon/mShop/web/MShopWebViewClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;Lorg/apache/cordova/CordovaInterface;)V
    .locals 0
    .param p2, "x0"    # Lorg/apache/cordova/CordovaInterface;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    invoke-direct {p0, p2}, Lcom/amazon/mShop/web/MShopWebViewClient;-><init>(Lorg/apache/cordova/CordovaInterface;)V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 95
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/web/MShopWebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 96
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    # setter for: Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->mIsPlacingOrder:Z
    invoke-static {v0, v2}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->access$102(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;Z)Z

    .line 99
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    # invokes: Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->isThankYouPage(Ljava/lang/String;)Z
    invoke-static {v0, p2}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->access$000(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isWebViewReceivedError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 102
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    # invokes: Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->exitModal()V
    invoke-static {v0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->access$200(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;)V

    .line 106
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "isCartPurchase"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 116
    invoke-static {v2}, Lcom/amazon/mShop/web/MShopWebViewNotification;->notifyCartCountChanged(I)V

    .line 118
    invoke-static {v2}, Lcom/amazon/mShop/web/NativeAppNotification;->notifyNativeCartChanged(I)V

    .line 124
    :cond_0
    invoke-virtual {p1}, Landroid/webkit/WebView;->clearHistory()V

    .line 126
    :cond_1
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 79
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/web/MShopWebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 81
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    # invokes: Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->isThankYouPage(Ljava/lang/String;)Z
    invoke-static {v0, p2}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->access$000(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 82
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    const/4 v1, 0x1

    # setter for: Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->mIsPlacingOrder:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->access$102(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;Z)Z

    .line 84
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1$1;-><init>(Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;)V

    const-wide/16 v2, 0x7530

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 91
    :cond_0
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 130
    invoke-super {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/web/MShopWebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V

    .line 131
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->mIsPlacingOrder:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->access$102(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;Z)Z

    .line 133
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->isOneClick()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 134
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    # invokes: Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->exitModal()V
    invoke-static {v0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->access$200(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;)V

    .line 136
    :cond_0
    return-void
.end method

.method public onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "handler"    # Landroid/webkit/SslErrorHandler;
    .param p3, "error"    # Landroid/net/http/SslError;

    .prologue
    .line 140
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/web/MShopWebViewClient;->onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V

    .line 141
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->mIsPlacingOrder:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->access$102(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;Z)Z

    .line 143
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->isOneClick()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;->this$0:Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    # invokes: Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->exitModal()V
    invoke-static {v0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->access$200(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;)V

    .line 146
    :cond_0
    return-void
.end method
