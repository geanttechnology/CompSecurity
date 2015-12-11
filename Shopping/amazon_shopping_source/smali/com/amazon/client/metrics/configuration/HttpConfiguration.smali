.class public Lcom/amazon/client/metrics/configuration/HttpConfiguration;
.super Ljava/lang/Object;
.source "HttpConfiguration.java"


# static fields
.field protected static final DEFAULT_HTTP_URL_ENDPOINT_DEVO:Ljava/lang/String; = "https://dp-mont.integ.amazon.com:443"

.field protected static final DEFAULT_HTTP_URL_ENDPOINT_PROD:Ljava/lang/String; = "https://device-metrics-us.amazon.com:443"

.field protected static final DEFAULT_STATIC_CREDENTIAL_HTTP_URL_ENDPOINT:Ljava/lang/String; = "https://device-metrics-us-2.amazon.com:443"


# instance fields
.field private final mHttpRequestSignerType:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

.field private final mStaticCredentialUrlEndpoint:Ljava/lang/String;

.field private final mUrlEndpoint:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "httpRequestSignerType"    # Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;
    .param p2, "urlEndpoint"    # Ljava/lang/String;
    .param p3, "staticCredentialUrlEndpoint"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    if-nez p1, :cond_0

    .line 19
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v1, "HttpRequestSignerType is null in configuration"

    invoke-direct {v0, v1}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 22
    :cond_0
    if-nez p2, :cond_1

    .line 23
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v1, "UrlEndpoint is null in configuration"

    invoke-direct {v0, v1}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 26
    :cond_1
    if-nez p3, :cond_2

    .line 27
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v1, "UrlEndpoint is null in configuration"

    invoke-direct {v0, v1}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 29
    :cond_2
    iput-object p1, p0, Lcom/amazon/client/metrics/configuration/HttpConfiguration;->mHttpRequestSignerType:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    .line 30
    iput-object p2, p0, Lcom/amazon/client/metrics/configuration/HttpConfiguration;->mUrlEndpoint:Ljava/lang/String;

    .line 31
    iput-object p3, p0, Lcom/amazon/client/metrics/configuration/HttpConfiguration;->mStaticCredentialUrlEndpoint:Ljava/lang/String;

    .line 32
    return-void
.end method


# virtual methods
.method public getHttpRequestSignerType()Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/HttpConfiguration;->mHttpRequestSignerType:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    return-object v0
.end method

.method public getStaticCredentialUrlEndpoint()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/HttpConfiguration;->mStaticCredentialUrlEndpoint:Ljava/lang/String;

    return-object v0
.end method

.method public getUrlEndpoint()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/HttpConfiguration;->mUrlEndpoint:Ljava/lang/String;

    return-object v0
.end method
