.class public Lcom/amazon/android/webkit/android/AndroidWebViewClient;
.super Landroid/webkit/WebViewClient;
.source "AndroidWebViewClient.java"


# instance fields
.field private final client:Lcom/amazon/android/webkit/AmazonWebViewClient;

.field private final webview:Lcom/amazon/android/webkit/AmazonWebView;


# direct methods
.method public constructor <init>(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonWebViewClient;)V
    .locals 0
    .param p1, "webview"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "client"    # Lcom/amazon/android/webkit/AmazonWebViewClient;

    .prologue
    .line 33
    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    .line 35
    iput-object p2, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    .line 36
    return-void
.end method


# virtual methods
.method public doUpdateVisitedHistory(Landroid/webkit/WebView;Ljava/lang/String;Z)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "isReload"    # Z

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2, p3}, Lcom/amazon/android/webkit/AmazonWebViewClient;->doUpdateVisitedHistory(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Z)V

    .line 77
    return-void
.end method

.method public onFormResubmission(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "dontResend"    # Landroid/os/Message;
    .param p3, "resend"    # Landroid/os/Message;

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2, p3}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onFormResubmission(Lcom/amazon/android/webkit/AmazonWebView;Landroid/os/Message;Landroid/os/Message;)V

    .line 122
    return-void
.end method

.method public onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onLoadResource(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)V

    .line 55
    return-void
.end method

.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onPageFinished(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)V

    .line 60
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2, p3}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onPageStarted(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 65
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2, p3, p4}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onReceivedError(Lcom/amazon/android/webkit/AmazonWebView;ILjava/lang/String;Ljava/lang/String;)V

    .line 71
    return-void
.end method

.method public onReceivedHttpAuthRequest(Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "handler"    # Landroid/webkit/HttpAuthHandler;
    .param p3, "host"    # Ljava/lang/String;
    .param p4, "realm"    # Ljava/lang/String;

    .prologue
    .line 82
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebViewClient$1;

    invoke-direct {v0, p0, p2}, Lcom/amazon/android/webkit/android/AndroidWebViewClient$1;-><init>(Lcom/amazon/android/webkit/android/AndroidWebViewClient;Landroid/webkit/HttpAuthHandler;)V

    .line 98
    .local v0, "amazonHandler":Lcom/amazon/android/webkit/AmazonHttpAuthHandler;
    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v2, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v1, v2, v0, p3, p4}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onReceivedHttpAuthRequest(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonHttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    return-void
.end method

.method public onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
    .locals 3
    .param p1, "webView"    # Landroid/webkit/WebView;
    .param p2, "sslErrorHandler"    # Landroid/webkit/SslErrorHandler;
    .param p3, "sslError"    # Landroid/net/http/SslError;

    .prologue
    .line 104
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebViewClient$2;

    invoke-direct {v0, p0, p2}, Lcom/amazon/android/webkit/android/AndroidWebViewClient$2;-><init>(Lcom/amazon/android/webkit/android/AndroidWebViewClient;Landroid/webkit/SslErrorHandler;)V

    .line 115
    .local v0, "amazonHandler":Lcom/amazon/android/webkit/AmazonSslErrorHandler;
    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v2, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v1, v2, v0, p3}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onReceivedSslError(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonSslErrorHandler;Landroid/net/http/SslError;)V

    .line 116
    return-void
.end method

.method public onScaleChanged(Landroid/webkit/WebView;FF)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "oldScale"    # F
    .param p3, "newScale"    # F

    .prologue
    .line 143
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2, p3}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onScaleChanged(Lcom/amazon/android/webkit/AmazonWebView;FF)V

    .line 144
    return-void
.end method

.method public onTooManyRedirects(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "cancelMsg"    # Landroid/os/Message;
    .param p3, "continueMsg"    # Landroid/os/Message;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 128
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2, p3}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onTooManyRedirects(Lcom/amazon/android/webkit/AmazonWebView;Landroid/os/Message;Landroid/os/Message;)V

    .line 129
    return-void
.end method

.method public onUnhandledKeyEvent(Landroid/webkit/WebView;Landroid/view/KeyEvent;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 138
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onUnhandledKeyEvent(Lcom/amazon/android/webkit/AmazonWebView;Landroid/view/KeyEvent;)V

    .line 139
    return-void
.end method

.method public shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    .locals 5
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 40
    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v2, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v1, v2, p2}, Lcom/amazon/android/webkit/AmazonWebViewClient;->shouldInterceptRequest(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)Lcom/amazon/android/webkit/AmazonWebResourceResponse;

    move-result-object v0

    .line 41
    .local v0, "response":Lcom/amazon/android/webkit/AmazonWebResourceResponse;
    if-nez v0, :cond_0

    .line 42
    const/4 v1, 0x0

    .line 44
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Landroid/webkit/WebResourceResponse;

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebResourceResponse;->getMimeType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebResourceResponse;->getEncoding()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebResourceResponse;->getData()Ljava/io/InputStream;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Landroid/webkit/WebResourceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V

    goto :goto_0
.end method

.method public shouldOverrideKeyEvent(Landroid/webkit/WebView;Landroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 133
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2}, Lcom/amazon/android/webkit/AmazonWebViewClient;->shouldOverrideKeyEvent(Lcom/amazon/android/webkit/AmazonWebView;Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->client:Lcom/amazon/android/webkit/AmazonWebViewClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2}, Lcom/amazon/android/webkit/AmazonWebViewClient;->shouldOverrideUrlLoading(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
