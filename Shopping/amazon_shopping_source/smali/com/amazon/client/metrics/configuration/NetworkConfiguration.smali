.class public interface abstract Lcom/amazon/client/metrics/configuration/NetworkConfiguration;
.super Ljava/lang/Object;
.source "NetworkConfiguration.java"


# virtual methods
.method public abstract getNetworkTypes()Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/client/metrics/configuration/NetworkType;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getTransportType()Lcom/amazon/client/metrics/configuration/TransportType;
.end method
