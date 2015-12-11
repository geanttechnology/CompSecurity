.class public final Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;
.super Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;
.source "AuthenticationWebViewClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

.field private mDcqPageRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field private final mExpectedReturnToURL:Ljava/lang/String;

.field private volatile mIsDCQ:Z

.field private volatile mIsMFA:Z

.field private mMfaPageRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field public mRedirected:Z

.field private final mRequestType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

.field private final mScope:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$TOKEN_SCOPE;

.field private mSignInRegisterFormSubmitTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field private final mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    const-class v0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;Ljava/lang/String;Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$TOKEN_SCOPE;Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 2
    .param p1, "requestType"    # Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .param p2, "expectedReturnToURL"    # Ljava/lang/String;
    .param p3, "scope"    # Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$TOKEN_SCOPE;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v1, 0x0

    .line 98
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;-><init>()V

    .line 51
    iput-boolean v1, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mRedirected:Z

    .line 69
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mSignInRegisterFormSubmitTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 73
    iput-boolean v1, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsMFA:Z

    .line 75
    iput-boolean v1, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsDCQ:Z

    .line 99
    const-string/jumbo v0, "callback"

    invoke-static {p4, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 101
    iput-object p2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mExpectedReturnToURL:Ljava/lang/String;

    .line 102
    iput-object p4, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    .line 103
    iput-object p3, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mScope:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$TOKEN_SCOPE;

    .line 104
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mRequestType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    .line 105
    iput-object p5, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    .line 106
    return-void
.end method

.method public static isMAPUrl(Ljava/lang/String;)Z
    .locals 11
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x0

    .line 347
    if-nez p0, :cond_1

    .line 349
    sget-object v9, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v10, "URL is null"

    invoke-static {v9, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 383
    :cond_0
    :goto_0
    return v8

    .line 354
    :cond_1
    :try_start_0
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 362
    .local v0, "aURL":Ljava/net/URL;
    invoke-virtual {v0}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v7

    .line 363
    .local v7, "protocol":Ljava/lang/String;
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_0

    const-string/jumbo v9, "http"

    invoke-virtual {v7, v9}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 365
    invoke-virtual {v0}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v1

    .line 366
    .local v1, "host":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_0

    const-string/jumbo v9, ".amazon."

    invoke-virtual {v1, v9}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 368
    invoke-virtual {v0}, Ljava/net/URL;->getPath()Ljava/lang/String;

    move-result-object v3

    .line 369
    .local v3, "path":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    .line 370
    .local v2, "isPathEmpty":Z
    const-string/jumbo v9, "/ap/"

    invoke-virtual {v3, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    .line 371
    .local v6, "pathStartsWithAP":Z
    const-string/jumbo v9, "/gp/yourstore/home"

    invoke-virtual {v3, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    .line 372
    .local v5, "pathEqualsGP":Z
    const-string/jumbo v9, "/ap/forgotpassword"

    invoke-virtual {v3, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 373
    .local v4, "pathEqualsAPForgotPassword":Z
    sget-object v9, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->LOG_TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string/jumbo v10, " isEmpty="

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, "startsWithAP="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, "equalsGP="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, "equalsForgotPassword="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 376
    if-nez v2, :cond_0

    if-eqz v6, :cond_2

    if-eqz v4, :cond_3

    :cond_2
    if-eqz v5, :cond_0

    .line 378
    :cond_3
    const/4 v8, 0x1

    goto/16 :goto_0

    .line 358
    .end local v0    # "aURL":Ljava/net/URL;
    .end local v1    # "host":Ljava/lang/String;
    .end local v2    # "isPathEmpty":Z
    .end local v3    # "path":Ljava/lang/String;
    .end local v4    # "pathEqualsAPForgotPassword":Z
    .end local v5    # "pathEqualsGP":Z
    .end local v6    # "pathStartsWithAP":Z
    .end local v7    # "protocol":Ljava/lang/String;
    :catch_0
    move-exception v9

    sget-object v9, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->LOG_TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string/jumbo v10, "MalformedURLException url="

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto/16 :goto_0
.end method

.method private isSignInOrRegisterPost(Ljava/lang/String;)Z
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 260
    const-string/jumbo v0, "ap/signin"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "ap/register"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const-string/jumbo v0, "openid.assoc_handle"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 263
    const/4 v0, 0x1

    .line 265
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public handleSSLError(Landroid/net/http/SslError;)V
    .locals 6
    .param p1, "error"    # Landroid/net/http/SslError;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 391
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    .line 393
    invoke-virtual {p1}, Landroid/net/http/SslError;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Landroid/net/http/SslError;->getPrimaryError()I

    move-result v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->recordWebViewLoadFailureSSL(Ljava/lang/String;I)V

    .line 400
    :goto_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "SSL Failure. SSL Error code %d."

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p1}, Landroid/net/http/SslError;->getPrimaryError()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;->setError(Landroid/os/Bundle;)V

    .line 403
    return-void

    .line 397
    :cond_0
    const-string/jumbo v0, "CannotGetURL"

    invoke-virtual {p1}, Landroid/net/http/SslError;->getPrimaryError()I

    move-result v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->recordWebViewLoadFailureSSL(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public isDCQ()Z
    .locals 1

    .prologue
    .line 250
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsDCQ:Z

    return v0
.end method

.method public isMFA()Z
    .locals 1

    .prologue
    .line 245
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsMFA:Z

    return v0
.end method

.method public onPageFinished(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)V
    .locals 1
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "sUrl"    # Ljava/lang/String;

    .prologue
    .line 288
    sget-object v0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->LOG_TAG:Ljava/lang/String;

    .line 289
    invoke-super {p0, p1, p2}, Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;->onPageFinished(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)V

    .line 291
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsMFA:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mMfaPageRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    if-eqz v0, :cond_0

    .line 293
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mMfaPageRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 295
    :cond_0
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsDCQ:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mDcqPageRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    if-eqz v0, :cond_1

    .line 297
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mDcqPageRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 307
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mExpectedReturnToURL:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mRedirected:Z

    if-eqz v0, :cond_4

    .line 309
    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mSignInRegisterFormSubmitTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    if-eqz v0, :cond_3

    .line 311
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mSignInRegisterFormSubmitTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 312
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mSignInRegisterFormSubmitTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 318
    :cond_3
    :goto_0
    return-void

    .line 317
    :cond_4
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;->onPageFinished()V

    goto :goto_0
.end method

.method public onPageStarted(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 8
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v5, 0x1

    const/4 v7, 0x0

    .line 125
    sget-object v2, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "On Page Started with scope ="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mScope:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$TOKEN_SCOPE;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 126
    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mExpectedReturnToURL:Ljava/lang/String;

    invoke-virtual {p2, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 128
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->isSignInOrRegisterPost(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    iget-boolean v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsMFA:Z

    if-nez v2, :cond_0

    iget-boolean v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsDCQ:Z

    if-eqz v2, :cond_1

    .line 130
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    invoke-interface {v2}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;->onCodeEnterFinished()V

    .line 134
    :cond_1
    const-string/jumbo v2, "ap/dcq"

    invoke-virtual {p2, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "WebView:ContactedDCQ:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mRequestType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    const-string/jumbo v3, "DCQ:PageRender"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mDcqPageRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    iput-boolean v5, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsDCQ:Z

    iput-boolean v7, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsMFA:Z

    .line 136
    :goto_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    invoke-interface {v2, p2}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;->onPageStarted(Ljava/lang/String;)V

    .line 201
    :cond_2
    :goto_1
    return-void

    .line 134
    :cond_3
    const-string/jumbo v2, "ap/mfa"

    invoke-virtual {p2, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "WebView:ContactedMFA:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mRequestType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    const-string/jumbo v3, "MFA:PageRender"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mMfaPageRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    iput-boolean v5, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsMFA:Z

    iput-boolean v7, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsDCQ:Z

    goto :goto_0

    :cond_4
    iput-boolean v7, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsMFA:Z

    iput-boolean v7, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsDCQ:Z

    goto :goto_0

    .line 141
    :cond_5
    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    invoke-interface {v2, p2}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;->onPageStarted(Ljava/lang/String;)V

    .line 143
    iput-boolean v5, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mRedirected:Z

    .line 145
    sget-object v2, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->LOG_TAG:Ljava/lang/String;

    .line 146
    invoke-virtual {p1}, Lcom/amazon/android/webkit/AmazonWebView;->stopLoading()V

    .line 148
    new-instance v1, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;

    invoke-direct {v1, p2}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;-><init>(Ljava/lang/String;)V

    .line 151
    .local v1, "response":Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;
    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mExpectedReturnToURL:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->isCancelEvent(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 158
    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    const/4 v3, 0x4

    const-string/jumbo v4, "Registration canceled"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getAccountManagerErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;->setError(Landroid/os/Bundle;)V

    .line 160
    iget-boolean v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsDCQ:Z

    if-eqz v2, :cond_6

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    const-string/jumbo v3, "DCQCanceled"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    :cond_6
    iget-boolean v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mIsMFA:Z

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    const-string/jumbo v3, "MFACanceled"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    goto :goto_1

    .line 164
    :cond_7
    sget-object v2, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->LOG_TAG:Ljava/lang/String;

    .line 168
    const-string/jumbo v2, "device_auth_access"

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getScope()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_8

    .line 170
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "WebViewFailure:InvalidScope:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mRequestType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Lcom/amazon/identity/platform/metric/MetricUtils;->getAuthPortalUrlPathAndDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v3, v7, [Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 172
    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v3

    const-string/jumbo v4, "Received token with invalid scope %s"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getScope()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;->setError(Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 178
    :cond_8
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getAccessToken()Lcom/amazon/identity/auth/device/token/AccessToken;

    move-result-object v0

    .line 179
    .local v0, "accessToken":Lcom/amazon/identity/auth/device/token/Token;
    if-eqz v0, :cond_9

    invoke-interface {v0}, Lcom/amazon/identity/auth/device/token/Token;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 181
    :cond_9
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "WebViewFailure:NoAccessToken:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mRequestType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Lcom/amazon/identity/platform/metric/MetricUtils;->getAuthPortalUrlPathAndDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v3, v7, [Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 183
    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v3

    const-string/jumbo v4, "Received an invalid access token"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;->setError(Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 189
    :cond_a
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 191
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "WebViewFailure:NoDirectedID:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mRequestType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Lcom/amazon/identity/platform/metric/MetricUtils;->getAuthPortalUrlPathAndDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v3, v7, [Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 193
    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v3

    const-string/jumbo v4, "Registration response received invalid because it did not contain a directed id"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;->setError(Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 199
    :cond_b
    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    invoke-interface {v2, v1}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;->setResult(Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;)V

    goto/16 :goto_1
.end method

.method public onReceivedError(Lcom/amazon/android/webkit/AmazonWebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 275
    sget-object v0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Got an error from the webview. Returning false for SignIn ("

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ") "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 277
    invoke-static {p4, p2}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->recordWebViewLoadFailure(Ljava/lang/String;I)V

    .line 279
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mCallback:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "Received error code %d and description: %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p3, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;->setError(Landroid/os/Bundle;)V

    .line 283
    return-void
.end method

.method public shouldInterceptRequest(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)Lcom/amazon/android/webkit/AmazonWebResourceResponse;
    .locals 3
    .param p1, "webview"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 114
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->isSignInOrRegisterPost(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mSignInRegisterFormSubmitTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    if-nez v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "AuthenticationWebViewClient_SignInRegisterPost:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mRequestType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->mSignInRegisterFormSubmitTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 119
    :cond_0
    invoke-super {p0, p1, p2}, Lcom/amazon/identity/auth/device/api/AbstractMAPWebViewClient;->shouldInterceptRequest(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)Lcom/amazon/android/webkit/AmazonWebResourceResponse;

    move-result-object v0

    return-object v0
.end method

.method public shouldOverrideUrlLoading(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)Z
    .locals 3
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 329
    invoke-static {p2}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->isMAPUrl(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 331
    sget-object v1, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "should override called - no override - url="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 341
    const/4 v1, 0x0

    :goto_0
    return v1

    .line 335
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "should override called - override - url="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 336
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "android.intent.action.VIEW"

    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 337
    .local v0, "browserIntent":Landroid/content/Intent;
    invoke-virtual {p1}, Lcom/amazon/android/webkit/AmazonWebView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 338
    const/4 v1, 0x1

    goto :goto_0
.end method
