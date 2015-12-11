.class public interface abstract Lcom/auditude/ads/network/INetworkAdLoader;
.super Ljava/lang/Object;
.source "INetworkAdLoader.java"

# interfaces
.implements Lcom/auditude/ads/util/event/IEventDispatcher;


# virtual methods
.method public abstract getAd()Lcom/auditude/ads/model/Ad;
.end method

.method public abstract getResult()Ljava/lang/Object;
.end method

.method public abstract load()V
.end method

.method public abstract setAd(Lcom/auditude/ads/model/Ad;)V
.end method

.method public abstract setCustomParams(Ljava/util/HashMap;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract setSource(Ljava/lang/Object;)V
.end method
