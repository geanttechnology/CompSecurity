.class public final enum Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;
.super Ljava/lang/Enum;
.source "PlacementViewerEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

.field public static final enum FAST_FARWARD:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

.field public static final enum PAUSE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

.field public static final enum PLAY:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

.field public static final enum REWIND:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

.field public static final enum STOP:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 34
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    const-string v1, "FAST_FARWARD"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->FAST_FARWARD:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    .line 35
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    const-string v1, "PAUSE"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->PAUSE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    .line 36
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    const-string v1, "PLAY"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->PLAY:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    .line 37
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    const-string v1, "REWIND"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->REWIND:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    .line 38
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    const-string v1, "STOP"

    invoke-direct {v0, v1, v6}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->STOP:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    .line 33
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->FAST_FARWARD:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->PAUSE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->PLAY:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->REWIND:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->STOP:Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    aput-object v1, v0, v6

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

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
    .line 33
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 33
    const-class v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type;

    return-object v0
.end method
