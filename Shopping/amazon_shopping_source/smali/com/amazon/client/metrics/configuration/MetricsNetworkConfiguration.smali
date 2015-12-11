.class public Lcom/amazon/client/metrics/configuration/MetricsNetworkConfiguration;
.super Ljava/lang/Object;
.source "MetricsNetworkConfiguration.java"

# interfaces
.implements Lcom/amazon/client/metrics/configuration/NetworkConfiguration;


# instance fields
.field final mNetworkTypes:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/client/metrics/configuration/NetworkType;",
            ">;"
        }
    .end annotation
.end field

.field mTransportType:Lcom/amazon/client/metrics/configuration/TransportType;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/configuration/TransportType;Ljava/util/Set;)V
    .locals 2
    .param p1, "tranportType"    # Lcom/amazon/client/metrics/configuration/TransportType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/client/metrics/configuration/TransportType;",
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/client/metrics/configuration/NetworkType;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 14
    .local p2, "networkTypes":Ljava/util/Set;, "Ljava/util/Set<Lcom/amazon/client/metrics/configuration/NetworkType;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    if-nez p1, :cond_0

    .line 16
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "tranportType is null in configuration"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 19
    :cond_0
    if-eqz p2, :cond_1

    invoke-interface {p2}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 20
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "networkTypes is null or empty in configuration"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 22
    :cond_2
    iput-object p1, p0, Lcom/amazon/client/metrics/configuration/MetricsNetworkConfiguration;->mTransportType:Lcom/amazon/client/metrics/configuration/TransportType;

    .line 23
    iput-object p2, p0, Lcom/amazon/client/metrics/configuration/MetricsNetworkConfiguration;->mNetworkTypes:Ljava/util/Set;

    .line 24
    return-void
.end method


# virtual methods
.method public getNetworkTypes()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/client/metrics/configuration/NetworkType;",
            ">;"
        }
    .end annotation

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsNetworkConfiguration;->mNetworkTypes:Ljava/util/Set;

    return-object v0
.end method

.method public getTransportType()Lcom/amazon/client/metrics/configuration/TransportType;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsNetworkConfiguration;->mTransportType:Lcom/amazon/client/metrics/configuration/TransportType;

    return-object v0
.end method
