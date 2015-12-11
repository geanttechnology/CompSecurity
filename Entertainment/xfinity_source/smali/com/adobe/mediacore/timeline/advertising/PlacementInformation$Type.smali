.class public final enum Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

.field public static final enum CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

.field public static final enum MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

.field public static final enum POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

.field public static final enum PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

.field public static final enum SERVER_MAP:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    const-string v1, "PRE_ROLL"

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    const-string v1, "MID_ROLL"

    invoke-direct {v0, v1, v3}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    const-string v1, "POST_ROLL"

    invoke-direct {v0, v1, v4}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    const-string v1, "SERVER_MAP"

    invoke-direct {v0, v1, v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->SERVER_MAP:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    const-string v1, "CUSTOM_TIME_RANGES"

    invoke-direct {v0, v1, v6}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    aput-object v1, v0, v2

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->SERVER_MAP:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    aput-object v1, v0, v6

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->$VALUES:[Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->$VALUES:[Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    return-object v0
.end method
