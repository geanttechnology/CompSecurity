.class Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;
.super Landroid/webkit/WebViewClient;
.source "AmazonBrandedWebView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonBrandedWebView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyWebViewClient"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/AmazonBrandedWebView;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/AmazonBrandedWebView;)V
    .locals 0

    .prologue
    .line 203
    iput-object p1, p0, Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/AmazonBrandedWebView;Lcom/amazon/mShop/AmazonBrandedWebView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/AmazonBrandedWebView;
    .param p2, "x1"    # Lcom/amazon/mShop/AmazonBrandedWebView$1;

    .prologue
    .line 203
    invoke-direct {p0, p1}, Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;-><init>(Lcom/amazon/mShop/AmazonBrandedWebView;)V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 274
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonBrandedWebView;->isAttachedToWindow()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 275
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/AmazonBrandedWebView$DialogDismisser;

    iget-object v2, p0, Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/amazon/mShop/AmazonBrandedWebView$DialogDismisser;-><init>(Lcom/amazon/mShop/AmazonBrandedWebView;Lcom/amazon/mShop/AmazonBrandedWebView$1;)V

    const-wide/16 v2, 0x15e

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 277
    :cond_0
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 243
    invoke-static {p1, p2}, Lcom/amazon/mShop/web/security/WebViewSecurity;->shouldBlockWebViewLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v0

    .line 244
    .local v0, "blocked":Z
    invoke-static {p2}, Lcom/amazon/mShop/web/security/WebViewSecurity;->isHTTPUrl(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 247
    invoke-virtual {p1}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, p2, v0}, Lcom/amazon/mShop/web/security/WebViewSecurity;->logMetricsForHTTPRequest(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 249
    :cond_0
    if-eqz v0, :cond_2

    .line 250
    invoke-virtual {p1}, Landroid/webkit/WebView;->stopLoading()V

    .line 251
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/AmazonActivity;

    const/4 v3, 0x5

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportErrorWithGeneralErrorMessageAndGoToAmazonHome(Lcom/amazon/mShop/AmazonActivity;I)V

    .line 266
    :cond_1
    :goto_0
    return-void

    .line 256
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonBrandedWebView;->isAttachedToWindow()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 257
    iget-object v2, p0, Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    # ++operator for: Lcom/amazon/mShop/AmazonBrandedWebView;->mPageStartCount:I
    invoke-static {v2}, Lcom/amazon/mShop/AmazonBrandedWebView;->access$204(Lcom/amazon/mShop/AmazonBrandedWebView;)I

    .line 258
    iget-object v2, p0, Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    # getter for: Lcom/amazon/mShop/AmazonBrandedWebView;->mDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v2}, Lcom/amazon/mShop/AmazonBrandedWebView;->access$300(Lcom/amazon/mShop/AmazonBrandedWebView;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonProgressDialog;->isShowing()Z

    move-result v2

    if-nez v2, :cond_1

    .line 260
    :try_start_0
    iget-object v2, p0, Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    # getter for: Lcom/amazon/mShop/AmazonBrandedWebView;->mDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v2}, Lcom/amazon/mShop/AmazonBrandedWebView;->access$300(Lcom/amazon/mShop/AmazonBrandedWebView;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonProgressDialog;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 261
    :catch_0
    move-exception v1

    .line 262
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v2, "ProgressDialog"

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 287
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V

    .line 288
    iget-object v2, p0, Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    const/4 v3, 0x1

    # setter for: Lcom/amazon/mShop/AmazonBrandedWebView;->mIsReceivedError:Z
    invoke-static {v2, v3}, Lcom/amazon/mShop/AmazonBrandedWebView;->access$502(Lcom/amazon/mShop/AmazonBrandedWebView;Z)Z

    .line 291
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 292
    .local v1, "context":Landroid/content/Context;
    instance-of v2, v1, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v2, :cond_0

    move-object v0, v1

    .line 293
    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 294
    .local v0, "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v2

    invoke-static {v0, p1, v2}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportWebViewClientError(Lcom/amazon/mShop/AmazonActivity;Landroid/webkit/WebView;Landroid/view/View;)V

    .line 304
    .end local v0    # "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    :cond_0
    return-void
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 215
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p2}, Lcom/amazon/mShop/util/WebUtils;->handleMailtoLink(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    .line 231
    :goto_0
    return v0

    .line 221
    :cond_0
    invoke-static {p1, p2}, Lcom/amazon/mShop/web/security/WebViewSecurity;->shouldBlockWebViewLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 222
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    const/4 v2, 0x5

    invoke-static {v0, v2}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportErrorWithGeneralErrorMessageAndGoToAmazonHome(Lcom/amazon/mShop/AmazonActivity;I)V

    .line 227
    invoke-virtual {p1}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p2, v1}, Lcom/amazon/mShop/web/security/WebViewSecurity;->logMetricsForHTTPRequest(Ljava/lang/String;Ljava/lang/String;Z)V

    move v0, v1

    .line 228
    goto :goto_0

    .line 231
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
