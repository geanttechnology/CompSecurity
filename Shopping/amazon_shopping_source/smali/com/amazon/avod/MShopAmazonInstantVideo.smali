.class public interface abstract Lcom/amazon/avod/MShopAmazonInstantVideo;
.super Ljava/lang/Object;
.source "MShopAmazonInstantVideo.java"


# virtual methods
.method public abstract forceRefreshAccount()V
.end method

.method public abstract getGroverRecommendations()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end method

.method public abstract getGroverRecommendationsTTLMillis()J
.end method

.method public abstract isAIVBeta()Z
.end method

.method public abstract isPlaybackSustainable()Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract isSupported()Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract refreshUserData()V
.end method

.method public abstract startPlayback(Landroid/app/Activity;Ljava/lang/String;J)V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract startTrailer(Landroid/app/Activity;Ljava/lang/String;)V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract verifyAndroidRuntime(Landroid/app/Activity;Ljava/lang/Runnable;)V
.end method

.method public abstract whisperCache(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method
