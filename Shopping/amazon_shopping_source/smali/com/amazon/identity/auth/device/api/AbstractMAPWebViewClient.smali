.class public abstract Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;
.super Lcom/amazon/android/webkit/AmazonWebViewClient;
.source "AbstractMAPWebViewClient.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/amazon/android/webkit/AmazonWebViewClient;-><init>()V

    .line 27
    return-void
.end method


# virtual methods
.method public abstract handleSSLError(Landroid/net/http/SslError;)V
.end method

.method public onPageFinished(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)V
    .locals 1
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 32
    sget-object v0, Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;->LOG_TAG:Ljava/lang/String;

    .line 33
    invoke-super {p0, p1, p2}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onPageFinished(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)V

    .line 35
    invoke-static {}, Lcom/amazon/android/webkit/AmazonCookieSyncManager;->getInstance()Lcom/amazon/android/webkit/AmazonCookieSyncManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonCookieSyncManager;->sync()V

    .line 36
    return-void
.end method

.method public onReceivedSslError(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonSslErrorHandler;Landroid/net/http/SslError;)V
    .locals 2
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "handler"    # Lcom/amazon/android/webkit/AmazonSslErrorHandler;
    .param p3, "error"    # Landroid/net/http/SslError;

    .prologue
    .line 46
    sget-object v0, Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;->LOG_TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Got an SSL error:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3}, Landroid/net/http/SslError;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 48
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->isCurrentEnvironmentProd()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 50
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x8

    if-ge v0, v1, :cond_0

    .line 53
    invoke-virtual {p0, p3}, Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;->handleSSLError(Landroid/net/http/SslError;)V

    .line 70
    :goto_0
    return-void

    .line 59
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/android/webkit/AmazonWebViewClient;->onReceivedSslError(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonSslErrorHandler;Landroid/net/http/SslError;)V

    goto :goto_0

    .line 68
    :cond_1
    invoke-virtual {p2}, Lcom/amazon/android/webkit/AmazonSslErrorHandler;->proceed()V

    goto :goto_0
.end method
