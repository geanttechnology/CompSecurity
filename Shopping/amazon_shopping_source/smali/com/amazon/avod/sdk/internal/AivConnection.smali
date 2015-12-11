.class public interface abstract Lcom/amazon/avod/sdk/internal/AivConnection;
.super Ljava/lang/Object;
.source "AivConnection.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/sdk/internal/AivConnection$Factory;
    }
.end annotation


# virtual methods
.method public abstract disconnect()V
.end method

.method public abstract playVideo(Ljava/lang/String;Ljava/util/Map;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract queryPlaybackSupport(Lcom/amazon/avod/sdk/PlaybackSupportResponse;)V
.end method

.method public abstract teardownPreparedVideo(Lcom/amazon/avod/sdk/ResponseHandler;)V
.end method

.method public abstract tryConnect()Z
.end method

.method public abstract whisperCacheContent(Ljava/util/List;Lcom/amazon/avod/sdk/CacheLevel;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/avod/sdk/CacheLevel;",
            ")V"
        }
    .end annotation
.end method
