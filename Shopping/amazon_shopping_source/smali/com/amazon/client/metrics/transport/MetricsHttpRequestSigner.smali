.class public Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;
.super Ljava/lang/Object;
.source "MetricsHttpRequestSigner.java"

# interfaces
.implements Lamazon/communication/authentication/RequestSigner;


# instance fields
.field private final mAdditionalHeaders:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mNextRequestSigner:Lamazon/communication/authentication/RequestSigner;


# direct methods
.method public constructor <init>(Ljava/util/Map;Lamazon/communication/authentication/RequestSigner;)V
    .locals 0
    .param p2, "nextRequestSigner"    # Lamazon/communication/authentication/RequestSigner;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lamazon/communication/authentication/RequestSigner;",
            ")V"
        }
    .end annotation

    .prologue
    .line 28
    .local p1, "additionalHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p2, p0, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->mNextRequestSigner:Lamazon/communication/authentication/RequestSigner;

    .line 30
    iput-object p1, p0, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->mAdditionalHeaders:Ljava/util/Map;

    .line 31
    return-void
.end method


# virtual methods
.method public getNextRequestSigner()Lamazon/communication/authentication/RequestSigner;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->mNextRequestSigner:Lamazon/communication/authentication/RequestSigner;

    return-object v0
.end method

.method public setNextRequestSigner(Lamazon/communication/authentication/RequestSigner;)V
    .locals 0
    .param p1, "requestSigner"    # Lamazon/communication/authentication/RequestSigner;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->mNextRequestSigner:Lamazon/communication/authentication/RequestSigner;

    .line 66
    return-void
.end method

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
    .line 36
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->signRequest(Lorg/apache/http/client/methods/HttpRequestBase;Lamazon/communication/authentication/RequestContext;)V

    .line 37
    return-void
.end method

.method public signRequest(Lorg/apache/http/client/methods/HttpRequestBase;Lamazon/communication/authentication/RequestContext;)V
    .locals 4
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpRequestBase;
    .param p2, "requestContext"    # Lamazon/communication/authentication/RequestContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    .prologue
    .line 47
    iget-object v2, p0, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->mAdditionalHeaders:Ljava/util/Map;

    if-eqz v2, :cond_0

    .line 48
    iget-object v2, p0, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->mAdditionalHeaders:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 50
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p1, v2, v3}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 53
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    iget-object v2, p0, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->mNextRequestSigner:Lamazon/communication/authentication/RequestSigner;

    if-eqz v2, :cond_1

    .line 54
    iget-object v2, p0, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->mNextRequestSigner:Lamazon/communication/authentication/RequestSigner;

    invoke-interface {v2, p1, p2}, Lamazon/communication/authentication/RequestSigner;->signRequest(Lorg/apache/http/client/methods/HttpRequestBase;Lamazon/communication/authentication/RequestContext;)V

    .line 56
    :cond_1
    return-void
.end method
