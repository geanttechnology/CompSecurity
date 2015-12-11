.class public final enum Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/timeline/advertising/AdBreak;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

.field public static final enum MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

.field public static final enum POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

.field public static final enum PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

.field public static final enum UNKNOWN:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    const-string v1, "PRE_ROLL"

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    const-string v1, "MID_ROLL"

    invoke-direct {v0, v1, v3}, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    const-string v1, "POST_ROLL"

    invoke-direct {v0, v1, v4}, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v5}, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->UNKNOWN:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    aput-object v1, v0, v2

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->UNKNOWN:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    aput-object v1, v0, v5

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->$VALUES:[Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

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

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->$VALUES:[Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    return-object v0
.end method
