.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$23;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->finishSpinnerWebviewAnimated(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$animationTargetUrl:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 882
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$23;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$23;->val$animationTargetUrl:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 885
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$23;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$23;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$23;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    .line 887
    .local v0, "webView":Landroid/webkit/WebView;
    :goto_0
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$23;->val$animationTargetUrl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 890
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$23;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->webviewAnimated()V

    .line 892
    :cond_0
    return-void

    .line 885
    .end local v0    # "webView":Landroid/webkit/WebView;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
