.class public Lcom/comcast/playerplatform/primetime/android/asset/AdData;
.super Ljava/lang/Object;
.source "AdData.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/asset/AdData$Builder;
    }
.end annotation


# instance fields
.field private final adBreakPolicies:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

.field private final adBreaks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;"
        }
    .end annotation
.end field

.field private final adType:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

.field private final mediaId:Ljava/lang/String;

.field private targetingParameters:Ljava/util/Map;
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


# virtual methods
.method public getAdBreakPolicies()Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AdData;->adBreakPolicies:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

    return-object v0
.end method

.method public getAdBreaks()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;"
        }
    .end annotation

    .prologue
    .line 41
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AdData;->adBreaks:Ljava/util/List;

    return-object v0
.end method

.method public getAdType()Lcom/comcast/playerplatform/primetime/android/enums/AdType;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AdData;->adType:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    return-object v0
.end method

.method public getMediaId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AdData;->mediaId:Ljava/lang/String;

    return-object v0
.end method

.method public getTargetingParameters()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 45
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AdData;->targetingParameters:Ljava/util/Map;

    return-object v0
.end method
