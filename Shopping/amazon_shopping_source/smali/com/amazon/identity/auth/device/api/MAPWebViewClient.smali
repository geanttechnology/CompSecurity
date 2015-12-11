.class public Lcom/amazon/identity/auth/device/api/MAPWebViewClient;
.super Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;
.source "MAPWebViewClient.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mActivity:Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/amazon/identity/auth/device/api/MAPWebViewClient;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewClient;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;)V
    .locals 0
    .param p1, "activity"    # Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewClient;->mActivity:Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;

    .line 39
    return-void
.end method


# virtual methods
.method public handleSSLError(Landroid/net/http/SslError;)V
    .locals 3
    .param p1, "error"    # Landroid/net/http/SslError;

    .prologue
    .line 77
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "SSL error: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/net/http/SslError;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewClient;->mActivity:Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;

    invoke-interface {v1}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;->getEventCallback()Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->setError(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 80
    return-void
.end method

.method public onPageStarted(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 44
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewClient;->LOG_TAG:Ljava/lang/String;

    .line 48
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewClient;->mActivity:Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;

    invoke-interface {v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;->getWebWebViewHelper()Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewClient;->mActivity:Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;

    invoke-interface {v1}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->handleAuthentication(Landroid/app/Activity;Ljava/lang/String;)Z

    move-result v0

    .line 49
    if-eqz v0, :cond_0

    .line 56
    :goto_0
    return-void

    .line 54
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;->onPageStarted(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method

.method public shouldOverrideUrlLoading(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)Z
    .locals 2
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 64
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewClient;->LOG_TAG:Ljava/lang/String;

    .line 66
    invoke-super {p0, p1, p2}, Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;->shouldOverrideUrlLoading(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)Z

    .line 67
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewClient;->mActivity:Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;

    invoke-interface {v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;->getWebWebViewHelper()Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewClient;->mActivity:Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;

    invoke-interface {v1}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->handleAuthentication(Landroid/app/Activity;Ljava/lang/String;)Z

    move-result v0

    .line 71
    return v0
.end method
