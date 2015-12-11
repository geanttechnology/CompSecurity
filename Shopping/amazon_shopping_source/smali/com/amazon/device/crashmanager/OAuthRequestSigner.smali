.class Lcom/amazon/device/crashmanager/OAuthRequestSigner;
.super Ljava/lang/Object;
.source "OAuthRequestSigner.java"

# interfaces
.implements Lcom/amazon/communication/authentication/RequestSigner;


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private mOAuthHelper:Lcom/amazon/device/utils/OAuthHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 21
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "OAuthRequestSigner"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/crashmanager/OAuthRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/utils/OAuthHelper;)V
    .locals 0
    .param p1, "oAuthHelper"    # Lcom/amazon/device/utils/OAuthHelper;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/amazon/device/crashmanager/OAuthRequestSigner;->mOAuthHelper:Lcom/amazon/device/utils/OAuthHelper;

    .line 27
    return-void
.end method

.method private validateRequest(Lorg/apache/http/client/methods/HttpRequestBase;)V
    .locals 2
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpRequestBase;

    .prologue
    .line 48
    if-nez p1, :cond_0

    .line 49
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Request cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 51
    :cond_0
    return-void
.end method


# virtual methods
.method public signRequest(Lorg/apache/http/client/methods/HttpRequestBase;)V
    .locals 4
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpRequestBase;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    .prologue
    .line 36
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/device/crashmanager/OAuthRequestSigner;->validateRequest(Lorg/apache/http/client/methods/HttpRequestBase;)V

    .line 37
    iget-object v2, p0, Lcom/amazon/device/crashmanager/OAuthRequestSigner;->mOAuthHelper:Lcom/amazon/device/utils/OAuthHelper;

    invoke-interface {v2}, Lcom/amazon/device/utils/OAuthHelper;->getAccessToken()Ljava/lang/String;

    move-result-object v0

    .line 38
    .local v0, "accessToken":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 39
    new-instance v2, Lamazon/communication/MissingCredentialsException;

    const-string/jumbo v3, "Null access token returned from OAuthHelper."

    invoke-direct {v2, v3}, Lamazon/communication/MissingCredentialsException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 42
    .end local v0    # "accessToken":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 43
    .local v1, "e":Ljava/lang/Exception;
    new-instance v2, Lamazon/communication/authentication/SigningException;

    const-string/jumbo v3, "Exception while retrieving access token"

    invoke-direct {v2, v3, v1}, Lamazon/communication/authentication/SigningException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 41
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v0    # "accessToken":Ljava/lang/String;
    :cond_0
    :try_start_1
    const-string/jumbo v2, "x-amz-access-token"

    invoke-virtual {p1, v2, v0}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 45
    return-void
.end method

.method public signRequest(Lorg/apache/http/client/methods/HttpRequestBase;Lamazon/communication/authentication/RequestContext;)V
    .locals 2
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpRequestBase;
    .param p2, "requestContext"    # Lamazon/communication/authentication/RequestContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    .prologue
    .line 61
    if-eqz p2, :cond_0

    .line 62
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "OAuthRequestSigner does not support client-provided RequestContext"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 64
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/device/crashmanager/OAuthRequestSigner;->signRequest(Lorg/apache/http/client/methods/HttpRequestBase;)V

    .line 65
    return-void
.end method
