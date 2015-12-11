.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->navigate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$callbackId:Ljava/lang/String;

.field final synthetic val$transitionEffect:Ljava/lang/String;

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 559
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->val$transitionEffect:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->val$url:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->val$callbackId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 564
    const/4 v3, 0x1

    .line 565
    .local v3, "needTransitionAnimation":Z
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->val$transitionEffect:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v5, v6}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    const-string/jumbo v5, "none"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->val$transitionEffect:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 566
    const/4 v3, 0x0

    .line 568
    :cond_0
    const/4 v2, 0x0

    .line 569
    .local v2, "handledByNative":Z
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->val$url:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v5, v6}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 575
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->val$url:Ljava/lang/String;

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v6}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$200(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/mobile/mash/util/MASHUtil;->canonicalizeIfRelativeUrl(Ljava/lang/String;Landroid/webkit/WebView;)Ljava/lang/String;

    move-result-object v1

    .line 576
    .local v1, "canonicalUrl":Ljava/lang/String;
    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 580
    .local v4, "uri":Landroid/net/Uri;
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mNavigationManager:Lcom/amazon/mobile/mash/nav/MASHNavDelegate;
    invoke-static {v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$500(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v6}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v6

    invoke-interface {v5, v1, v6}, Lcom/amazon/mobile/mash/nav/MASHNavDelegate;->navigate(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v2

    .line 582
    if-nez v2, :cond_5

    .line 586
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$200(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v5

    invoke-static {v5, v1}, Lcom/amazon/mShop/web/security/WebViewSecurity;->shouldBlockWebViewLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v0

    .line 587
    .local v0, "blocked":Z
    if-eqz v0, :cond_2

    .line 588
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v5

    const/4 v6, 0x5

    invoke-virtual {v5, v6}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showSslError(I)V

    .line 592
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$200(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/web/MShopWebView;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v1, v0}, Lcom/amazon/mShop/web/security/WebViewSecurity;->logMetricsForHTTPRequest(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 620
    .end local v0    # "blocked":Z
    .end local v1    # "canonicalUrl":Ljava/lang/String;
    .end local v4    # "uri":Landroid/net/Uri;
    :cond_1
    :goto_0
    return-void

    .line 598
    .restart local v0    # "blocked":Z
    .restart local v1    # "canonicalUrl":Ljava/lang/String;
    .restart local v4    # "uri":Landroid/net/Uri;
    :cond_2
    if-eqz v3, :cond_3

    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getTransitionManager()Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 599
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v5

    invoke-virtual {v5, v8}, Lcom/amazon/mShop/web/MShopWebViewContainer;->navigateForward(Ljava/lang/String;)V

    .line 603
    :cond_3
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$200(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v5

    invoke-virtual {v5, v1}, Lcom/amazon/mShop/web/MShopWebView;->loadUrl(Ljava/lang/String;)V

    .line 617
    .end local v0    # "blocked":Z
    .end local v1    # "canonicalUrl":Ljava/lang/String;
    .end local v4    # "uri":Landroid/net/Uri;
    :cond_4
    :goto_1
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->val$callbackId:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v5, v6}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 618
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;
    invoke-static {v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$200(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebView;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->val$callbackId:Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static {v5, v6, v8, v7}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$MASHcallback;->execSuccessCallback(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_0

    .line 606
    .restart local v1    # "canonicalUrl":Ljava/lang/String;
    .restart local v4    # "uri":Landroid/net/Uri;
    :cond_5
    invoke-static {v4}, Lcom/amazon/mShop/util/WebUtils;->logRefMarkerForWebPage(Landroid/net/Uri;)V

    goto :goto_0

    .line 611
    .end local v1    # "canonicalUrl":Ljava/lang/String;
    .end local v4    # "uri":Landroid/net/Uri;
    :cond_6
    if-eqz v3, :cond_4

    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getTransitionManager()Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    move-result-object v5

    if-eqz v5, :cond_4

    .line 613
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;
    invoke-static {v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v5

    invoke-virtual {v5, v8}, Lcom/amazon/mShop/web/MShopWebViewContainer;->navigateForward(Ljava/lang/String;)V

    goto :goto_1
.end method
