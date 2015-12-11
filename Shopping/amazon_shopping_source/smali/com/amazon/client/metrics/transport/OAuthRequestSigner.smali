.class public Lcom/amazon/client/metrics/transport/OAuthRequestSigner;
.super Ljava/lang/Object;
.source "OAuthRequestSigner.java"

# interfaces
.implements Lamazon/communication/authentication/RequestSigner;


# instance fields
.field private mOAuthHelper:Lcom/amazon/client/metrics/transport/OAuthHelper;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private validateRequest(Lorg/apache/http/client/methods/HttpRequestBase;)V
    .locals 2
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpRequestBase;

    .prologue
    .line 42
    if-nez p1, :cond_0

    .line 43
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Request cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 45
    :cond_0
    return-void
.end method


# virtual methods
.method public setOAuthHelper(Lcom/amazon/client/metrics/transport/OAuthHelper;)V
    .locals 0
    .param p1, "oAuthHelper"    # Lcom/amazon/client/metrics/transport/OAuthHelper;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/amazon/client/metrics/transport/OAuthRequestSigner;->mOAuthHelper:Lcom/amazon/client/metrics/transport/OAuthHelper;

    .line 67
    return-void
.end method

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
    .line 27
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/transport/OAuthRequestSigner;->validateRequest(Lorg/apache/http/client/methods/HttpRequestBase;)V

    .line 28
    iget-object v2, p0, Lcom/amazon/client/metrics/transport/OAuthRequestSigner;->mOAuthHelper:Lcom/amazon/client/metrics/transport/OAuthHelper;

    if-nez v2, :cond_0

    .line 29
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "OAuth helper is set to null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 36
    :catch_0
    move-exception v1

    .line 37
    .local v1, "e":Ljava/lang/Exception;
    new-instance v2, Lamazon/communication/MissingCredentialsException;

    const-string/jumbo v3, "Exception while retrieving access token"

    invoke-direct {v2, v3, v1}, Lamazon/communication/MissingCredentialsException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v2

    .line 31
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/amazon/client/metrics/transport/OAuthRequestSigner;->mOAuthHelper:Lcom/amazon/client/metrics/transport/OAuthHelper;

    invoke-interface {v2}, Lcom/amazon/client/metrics/transport/OAuthHelper;->getAccessToken()Ljava/lang/String;

    move-result-object v0

    .line 32
    .local v0, "accessToken":Ljava/lang/String;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 33
    :cond_1
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "OAuth access token is null or empty"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 35
    :cond_2
    const-string/jumbo v2, "x-amz-access-token"

    invoke-virtual {p1, v2, v0}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 39
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
    .line 55
    if-eqz p2, :cond_0

    .line 56
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "OAuthRequestSigner does not support client-provided RequestContext"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 58
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/transport/OAuthRequestSigner;->signRequest(Lorg/apache/http/client/methods/HttpRequestBase;)V

    .line 59
    return-void
.end method
