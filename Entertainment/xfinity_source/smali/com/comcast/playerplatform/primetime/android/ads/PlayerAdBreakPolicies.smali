.class public Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;
.super Ljava/lang/Object;
.source "PlayerAdBreakPolicies.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;,
        Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;,
        Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;
    }
.end annotation


# instance fields
.field private adBreakWatchedPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;

.field private midRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

.field private postRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

.field private preRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->KEEP:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->midRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 10
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->KEEP:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->postRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 11
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->KEEP:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->preRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 12
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;->DO_NOT_MARK:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->adBreakWatchedPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;

    .line 15
    return-void
.end method


# virtual methods
.method public getAdBreakWatchedPolicy()Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->adBreakWatchedPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;

    return-object v0
.end method

.method public getMidRollPolicy()Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->midRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    return-object v0
.end method

.method public getPostRollPolicy()Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->postRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    return-object v0
.end method

.method public getPreRollPolicy()Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->preRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    return-object v0
.end method

.method public setMidRollPolicy(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;)Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;
    .locals 0
    .param p1, "midRollPolicy"    # Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->midRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 47
    return-object p0
.end method

.method public setPostRollPolicy(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;)Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;
    .locals 0
    .param p1, "postRollPolicy"    # Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->postRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 38
    return-object p0
.end method

.method public setPreRollPolicy(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;)Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;
    .locals 0
    .param p1, "adBreakPolicy"    # Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;->preRollPolicy:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 29
    return-object p0
.end method
