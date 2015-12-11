.class Lcom/amazon/mShop/web/MShopWebChromeClient;
.super Lorg/apache/cordova/CordovaChromeClient;
.source "MShopWebChromeClient.java"


# static fields
.field protected static final DEBUG:Z


# instance fields
.field private final mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/web/MShopWebChromeClient;->DEBUG:Z

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/web/MShopWebViewContainer;Lorg/apache/cordova/CordovaInterface;Lorg/apache/cordova/CordovaWebView;)V
    .locals 0
    .param p1, "webViewContainer"    # Lcom/amazon/mShop/web/MShopWebViewContainer;
    .param p2, "cordova"    # Lorg/apache/cordova/CordovaInterface;
    .param p3, "webView"    # Lorg/apache/cordova/CordovaWebView;

    .prologue
    .line 29
    invoke-direct {p0, p2, p3}, Lorg/apache/cordova/CordovaChromeClient;-><init>(Lorg/apache/cordova/CordovaInterface;Lorg/apache/cordova/CordovaWebView;)V

    .line 30
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebChromeClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    .line 31
    return-void
.end method


# virtual methods
.method public onExceededDatabaseQuota(Ljava/lang/String;Ljava/lang/String;JJJLandroid/webkit/WebStorage$QuotaUpdater;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "databaseIdentifier"    # Ljava/lang/String;
    .param p3, "currentQuota"    # J
    .param p5, "estimatedSize"    # J
    .param p7, "totalUsedQuota"    # J
    .param p9, "quotaUpdater"    # Landroid/webkit/WebStorage$QuotaUpdater;

    .prologue
    .line 65
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebChromeClient;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 66
    const-string/jumbo v0, "MShopWebChromeClient"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onExceededDatabaseQuota estimatedSize: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p5, p6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "  currentQuota: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3, p4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "  totalUsedQuota: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p7, p8}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 71
    :cond_0
    const-wide/32 v0, 0x500000

    cmp-long v0, p5, v0

    if-gez v0, :cond_1

    .line 72
    invoke-interface {p9, p5, p6}, Landroid/webkit/WebStorage$QuotaUpdater;->updateQuota(J)V

    .line 76
    :goto_0
    return-void

    .line 74
    :cond_1
    invoke-interface {p9, p3, p4}, Landroid/webkit/WebStorage$QuotaUpdater;->updateQuota(J)V

    goto :goto_0
.end method

.method public onProgressChanged(Landroid/webkit/WebView;I)V
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "newProgress"    # I

    .prologue
    .line 35
    invoke-super {p0, p1, p2}, Lorg/apache/cordova/CordovaChromeClient;->onProgressChanged(Landroid/webkit/WebView;I)V

    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebChromeClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0, p2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->onProgressChanged(I)V

    .line 37
    return-void
.end method

.method public onReceivedTitle(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-super {p0, p1, p2}, Lorg/apache/cordova/CordovaChromeClient;->onReceivedTitle(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 42
    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebChromeClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0, p2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setTitle(Ljava/lang/CharSequence;)V

    .line 46
    :cond_0
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebChromeClient;->DEBUG:Z

    if-eqz v0, :cond_1

    .line 47
    const-string/jumbo v0, "MShopWebChromeClient"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onReceivedTitle, title = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    :cond_1
    return-void
.end method
