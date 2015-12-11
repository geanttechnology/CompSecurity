.class public final enum Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;
.super Ljava/lang/Enum;
.source "PlayerAdBreakPolicies.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AdBreakPolicy"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

.field public static final enum KEEP:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

.field public static final enum REMOVE:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

.field public static final enum REMOVE_BEFORE_PLAYBACK:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 73
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    const-string v1, "KEEP"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->KEEP:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 74
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    const-string v1, "REMOVE"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->REMOVE:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 75
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    const-string v1, "REMOVE_BEFORE_PLAYBACK"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->REMOVE_BEFORE_PLAYBACK:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    .line 72
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->KEEP:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->REMOVE:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->REMOVE_BEFORE_PLAYBACK:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    aput-object v1, v0, v4

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

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
    .line 72
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 72
    const-class v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;
    .locals 1

    .prologue
    .line 72
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy;

    return-object v0
.end method
