.class public final enum Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;
.super Ljava/lang/Enum;
.source "PlayerAdBreakPolicies.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AdBreakSeekIntoPolicy"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

.field public static final enum PLAY:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

.field public static final enum PLAY_FROM_BEGINNING:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 84
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    const-string v1, "PLAY"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;->PLAY:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    .line 85
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    const-string v1, "PLAY_FROM_BEGINNING"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;->PLAY_FROM_BEGINNING:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    .line 83
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;->PLAY:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;->PLAY_FROM_BEGINNING:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    aput-object v1, v0, v3

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 83
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 83
    const-class v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;
    .locals 1

    .prologue
    .line 83
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy;

    return-object v0
.end method
