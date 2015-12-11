.class public Lcom/amazon/client/metrics/transport/StaticCredentialRequestSigner;
.super Ljava/lang/Object;
.source "StaticCredentialRequestSigner.java"

# interfaces
.implements Lamazon/communication/authentication/RequestSigner;


# instance fields
.field private final mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;


# direct methods
.method public constructor <init>(Lcom/amazon/device/utils/DeviceUtil;)V
    .locals 2
    .param p1, "deviceUtil"    # Lcom/amazon/device/utils/DeviceUtil;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    if-nez p1, :cond_0

    .line 21
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "deviceUtil cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 23
    :cond_0
    iput-object p1, p0, Lcom/amazon/client/metrics/transport/StaticCredentialRequestSigner;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    .line 24
    return-void
.end method


# virtual methods
.method public signRequest(Lorg/apache/http/client/methods/HttpRequestBase;)V
    .locals 1
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpRequestBase;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    .prologue
    .line 29
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/client/metrics/transport/StaticCredentialRequestSigner;->signRequest(Lorg/apache/http/client/methods/HttpRequestBase;Lamazon/communication/authentication/RequestContext;)V

    .line 30
    return-void
.end method

.method public signRequest(Lorg/apache/http/client/methods/HttpRequestBase;Lamazon/communication/authentication/RequestContext;)V
    .locals 3
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpRequestBase;
    .param p2, "requestContext"    # Lamazon/communication/authentication/RequestContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    .prologue
    .line 40
    iget-object v1, p0, Lcom/amazon/client/metrics/transport/StaticCredentialRequestSigner;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v1}, Lcom/amazon/device/utils/DeviceUtil;->fetchStaticCredential()Ljava/lang/String;

    move-result-object v0

    .line 41
    .local v0, "staticCredentialToken":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 42
    const-string/jumbo v1, "x-credential-token"

    invoke-virtual {p1, v1, v0}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    return-void

    .line 44
    :cond_0
    new-instance v1, Lamazon/communication/MissingCredentialsException;

    const-string/jumbo v2, "Static Credential is unavailable."

    invoke-direct {v1, v2}, Lamazon/communication/MissingCredentialsException;-><init>(Ljava/lang/String;)V

    throw v1
.end method
