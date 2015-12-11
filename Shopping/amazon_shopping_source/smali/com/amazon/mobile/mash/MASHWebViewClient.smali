.class public Lcom/amazon/mobile/mash/MASHWebViewClient;
.super Lorg/apache/cordova/CordovaWebViewClient;
.source "MASHWebViewClient.java"


# instance fields
.field private mNavDelegate:Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

.field private mUrlIntercepter:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;


# direct methods
.method public constructor <init>(Lorg/apache/cordova/CordovaInterface;Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavDelegate;Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;)V
    .locals 0
    .param p1, "cordova"    # Lorg/apache/cordova/CordovaInterface;
    .param p2, "webView"    # Lcom/amazon/mobile/mash/MASHWebView;
    .param p3, "navDelegate"    # Lcom/amazon/mobile/mash/nav/MASHNavDelegate;
    .param p4, "urlIntercepter"    # Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;

    .prologue
    .line 42
    invoke-direct {p0, p1, p2}, Lorg/apache/cordova/CordovaWebViewClient;-><init>(Lorg/apache/cordova/CordovaInterface;Lorg/apache/cordova/CordovaWebView;)V

    .line 43
    iput-object p3, p0, Lcom/amazon/mobile/mash/MASHWebViewClient;->mNavDelegate:Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

    .line 44
    iput-object p4, p0, Lcom/amazon/mobile/mash/MASHWebViewClient;->mUrlIntercepter:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;

    .line 45
    return-void
.end method

.method public constructor <init>(Lorg/apache/cordova/CordovaInterface;Lcom/amazon/mobile/mash/nav/MASHNavDelegate;Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;)V
    .locals 0
    .param p1, "cordova"    # Lorg/apache/cordova/CordovaInterface;
    .param p2, "navDelegate"    # Lcom/amazon/mobile/mash/nav/MASHNavDelegate;
    .param p3, "urlIntercepter"    # Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;

    .prologue
    .line 52
    invoke-direct {p0, p1}, Lorg/apache/cordova/CordovaWebViewClient;-><init>(Lorg/apache/cordova/CordovaInterface;)V

    .line 53
    iput-object p2, p0, Lcom/amazon/mobile/mash/MASHWebViewClient;->mNavDelegate:Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

    .line 54
    iput-object p3, p0, Lcom/amazon/mobile/mash/MASHWebViewClient;->mUrlIntercepter:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;

    .line 55
    return-void
.end method


# virtual methods
.method public doUpdateVisitedHistory(Landroid/webkit/WebView;Ljava/lang/String;Z)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "isReload"    # Z

    .prologue
    .line 173
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;

    const/4 v1, 0x0

    invoke-direct {v0, p2, v1}, Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    .local v0, "amazonItem":Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;
    check-cast p1, Lcom/amazon/mobile/mash/MASHWebView;

    .end local p1    # "view":Landroid/webkit/WebView;
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/MASHWebView;->getMASHWebBackForwardList()Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->addHistoryItem(Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;)V

    .line 175
    return-void
.end method

.method public getMASHNavDelegate()Lcom/amazon/mobile/mash/nav/MASHNavDelegate;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/mobile/mash/MASHWebViewClient;->mNavDelegate:Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

    return-object v0
.end method

.method protected handlePageLoadNatively(Lcom/amazon/mobile/mash/MASHWebView;Ljava/lang/String;)Z
    .locals 4
    .param p1, "view"    # Lcom/amazon/mobile/mash/MASHWebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 124
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 125
    const-string/jumbo v1, "MASHWebViewClient"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "handlePageLoad: url = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 128
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/MASHWebView;->isInEmbeddedBrowserMode()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 143
    :cond_1
    :goto_0
    return v0

    .line 133
    :cond_2
    iget-object v1, p0, Lcom/amazon/mobile/mash/MASHWebViewClient;->mNavDelegate:Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/amazon/mobile/mash/MASHWebViewClient;->mNavDelegate:Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

    invoke-virtual {p1}, Lcom/amazon/mobile/mash/MASHWebView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-interface {v1, p2, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegate;->navigate(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 134
    const/4 v0, 0x1

    goto :goto_0

    .line 140
    :cond_3
    invoke-static {}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;->shouldInterceptUrl()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 141
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/MASHWebViewClient;->interceptUrl(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method

.method protected interceptUrl(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 5
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 156
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 157
    const-string/jumbo v2, "MASHWebViewClient"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "WebViewClient:interceptUrl = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 159
    :cond_0
    iget-object v2, p0, Lcom/amazon/mobile/mash/MASHWebViewClient;->mUrlIntercepter:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;

    if-nez v2, :cond_2

    .line 168
    :cond_1
    :goto_0
    return v1

    .line 163
    :cond_2
    iget-object v2, p0, Lcom/amazon/mobile/mash/MASHWebViewClient;->mUrlIntercepter:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;

    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v2, p2, v3}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;->buildHandler(Ljava/lang/String;Landroid/content/Context;)Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;

    move-result-object v0

    .line 164
    .local v0, "urlHandler":Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;
    if-eqz v0, :cond_1

    .line 165
    invoke-virtual {v0}, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;->handle()Z

    move-result v1

    goto :goto_0
.end method

.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 6
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 86
    invoke-super {p0, p1, p2}, Lorg/apache/cordova/CordovaWebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    move-object v2, p1

    .line 87
    check-cast v2, Lcom/amazon/mobile/mash/MASHWebView;

    .line 92
    .local v2, "webView":Lcom/amazon/mobile/mash/MASHWebView;
    invoke-static {p2}, Lcom/amazon/mobile/mash/util/MASHUtil;->isFragmentUrl(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 93
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;

    invoke-direct {v0, p2, v5}, Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    .local v0, "amazonItem":Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;
    invoke-virtual {v2}, Lcom/amazon/mobile/mash/MASHWebView;->getMASHWebBackForwardList()Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->addHistoryItem(Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;)V

    .line 103
    .end local v0    # "amazonItem":Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;
    :goto_0
    invoke-virtual {v2}, Lcom/amazon/mobile/mash/MASHWebView;->getPendingNavRequest()Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 104
    invoke-virtual {v2}, Lcom/amazon/mobile/mash/MASHWebView;->getPendingNavRequest()Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/mobile/mash/nav/MASHNavUtils;->issuePageRequest(Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V

    .line 105
    invoke-virtual {v2, v5}, Lcom/amazon/mobile/mash/MASHWebView;->setPendingNavRequest(Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V

    .line 113
    :cond_0
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/amazon/mobile/mash/MASHWebView;->setShouldHideProgressIndicator(Z)V

    .line 114
    return-void

    .line 99
    :cond_1
    invoke-virtual {p1}, Landroid/webkit/WebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v1

    .line 100
    .local v1, "list":Landroid/webkit/WebBackForwardList;
    invoke-virtual {v2}, Lcom/amazon/mobile/mash/MASHWebView;->getMASHWebBackForwardList()Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;

    move-result-object v3

    invoke-virtual {v1}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->setCurrentIndex(I)V

    goto :goto_0
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 70
    move-object v0, p1

    check-cast v0, Lcom/amazon/mobile/mash/MASHWebView;

    invoke-virtual {p0, v0, p2}, Lcom/amazon/mobile/mash/MASHWebViewClient;->handlePageLoadNatively(Lcom/amazon/mobile/mash/MASHWebView;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    .line 81
    :goto_0
    return v0

    .line 78
    :cond_0
    invoke-super {p0, p1, p2}, Lorg/apache/cordova/CordovaWebViewClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    .line 79
    goto :goto_0

    .line 81
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
