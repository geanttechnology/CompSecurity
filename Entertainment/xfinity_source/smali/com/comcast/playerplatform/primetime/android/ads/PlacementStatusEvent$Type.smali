.class public final enum Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;
.super Ljava/lang/Enum;
.source "PlacementStatusEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

.field public static final enum END:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

.field public static final enum END_ALL:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

.field public static final enum FIRST_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

.field public static final enum SECOND_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

.field public static final enum START:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

.field public static final enum STATUS:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

.field public static final enum THIRD_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 35
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    const-string v1, "START"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->START:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    .line 36
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    const-string v1, "STATUS"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->STATUS:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    .line 37
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    const-string v1, "FIRST_QUARTILE"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->FIRST_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    .line 38
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    const-string v1, "SECOND_QUARTILE"

    invoke-direct {v0, v1, v6}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->SECOND_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    .line 39
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    const-string v1, "THIRD_QUARTILE"

    invoke-direct {v0, v1, v7}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->THIRD_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    .line 40
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    const-string v1, "END"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->END:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    .line 41
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    const-string v1, "END_ALL"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->END_ALL:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    .line 34
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->START:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->STATUS:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->FIRST_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->SECOND_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    aput-object v1, v0, v6

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->THIRD_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->END:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->END_ALL:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

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
    .line 34
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 34
    const-class v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;
    .locals 1

    .prologue
    .line 34
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    return-object v0
.end method
