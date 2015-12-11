.class public interface abstract Lcom/comcast/playerplatform/primetime/android/ads/managers/AdTimeline;
.super Ljava/lang/Object;
.source "AdTimeline.java"


# virtual methods
.method public abstract getAdList()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getCurrentAd()Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
.end method

.method public abstract getCurrentAdBreak()Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
.end method

.method public abstract isAdPlaying()Z
.end method

.method public abstract setAdList(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract setResumePosition(J)V
.end method
