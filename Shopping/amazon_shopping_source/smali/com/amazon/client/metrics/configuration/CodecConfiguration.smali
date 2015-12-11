.class public Lcom/amazon/client/metrics/configuration/CodecConfiguration;
.super Ljava/lang/Object;
.source "CodecConfiguration.java"


# instance fields
.field final mCodecType:Lcom/amazon/client/metrics/configuration/CodecType;

.field final mCodecVersion:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/configuration/CodecType;Ljava/lang/String;)V
    .locals 2
    .param p1, "codecType"    # Lcom/amazon/client/metrics/configuration/CodecType;
    .param p2, "codecVersion"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    if-nez p1, :cond_0

    .line 15
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v1, "CodecType is null in configuration"

    invoke-direct {v0, v1}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 18
    :cond_0
    if-eqz p2, :cond_1

    const-string/jumbo v0, ""

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 19
    :cond_1
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v1, "Codec version is null in configuration"

    invoke-direct {v0, v1}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 21
    :cond_2
    iput-object p1, p0, Lcom/amazon/client/metrics/configuration/CodecConfiguration;->mCodecType:Lcom/amazon/client/metrics/configuration/CodecType;

    .line 22
    iput-object p2, p0, Lcom/amazon/client/metrics/configuration/CodecConfiguration;->mCodecVersion:Ljava/lang/String;

    .line 23
    return-void
.end method


# virtual methods
.method public getCodecType()Lcom/amazon/client/metrics/configuration/CodecType;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/CodecConfiguration;->mCodecType:Lcom/amazon/client/metrics/configuration/CodecType;

    return-object v0
.end method

.method public getCodecVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/CodecConfiguration;->mCodecVersion:Ljava/lang/String;

    return-object v0
.end method
