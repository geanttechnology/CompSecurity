.class final enum Lcom/adobe/ave/VideoCodecs;
.super Ljava/lang/Enum;
.source "VideoCodecs.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/VideoCodecs;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/VideoCodecs;

.field public static final enum H264:Lcom/adobe/ave/VideoCodecs;

.field public static final enum INVALID:Lcom/adobe/ave/VideoCodecs;

.field public static final enum MAX_VIDEO_CODECS:Lcom/adobe/ave/VideoCodecs;

.field public static final enum NO_VIDEO:Lcom/adobe/ave/VideoCodecs;

.field public static final enum ON2VP6:Lcom/adobe/ave/VideoCodecs;

.field public static final enum ON2VP6_ALPHA:Lcom/adobe/ave/VideoCodecs;

.field public static final enum SCREEN_SHARE:Lcom/adobe/ave/VideoCodecs;

.field public static final enum SCREEN_SHARE_V2:Lcom/adobe/ave/VideoCodecs;

.field public static final enum SORENSON_H263:Lcom/adobe/ave/VideoCodecs;


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 29
    new-instance v0, Lcom/adobe/ave/VideoCodecs;

    const-string v1, "INVALID"

    invoke-direct {v0, v1, v4, v4}, Lcom/adobe/ave/VideoCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/VideoCodecs;->INVALID:Lcom/adobe/ave/VideoCodecs;

    .line 34
    new-instance v0, Lcom/adobe/ave/VideoCodecs;

    const-string v1, "NO_VIDEO"

    invoke-direct {v0, v1, v5, v5}, Lcom/adobe/ave/VideoCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/VideoCodecs;->NO_VIDEO:Lcom/adobe/ave/VideoCodecs;

    .line 39
    new-instance v0, Lcom/adobe/ave/VideoCodecs;

    const-string v1, "SORENSON_H263"

    invoke-direct {v0, v1, v6, v6}, Lcom/adobe/ave/VideoCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/VideoCodecs;->SORENSON_H263:Lcom/adobe/ave/VideoCodecs;

    .line 44
    new-instance v0, Lcom/adobe/ave/VideoCodecs;

    const-string v1, "SCREEN_SHARE"

    invoke-direct {v0, v1, v7, v7}, Lcom/adobe/ave/VideoCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/VideoCodecs;->SCREEN_SHARE:Lcom/adobe/ave/VideoCodecs;

    .line 49
    new-instance v0, Lcom/adobe/ave/VideoCodecs;

    const-string v1, "ON2VP6"

    invoke-direct {v0, v1, v8, v8}, Lcom/adobe/ave/VideoCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/VideoCodecs;->ON2VP6:Lcom/adobe/ave/VideoCodecs;

    .line 54
    new-instance v0, Lcom/adobe/ave/VideoCodecs;

    const-string v1, "ON2VP6_ALPHA"

    const/4 v2, 0x5

    const/4 v3, 0x5

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/VideoCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/VideoCodecs;->ON2VP6_ALPHA:Lcom/adobe/ave/VideoCodecs;

    .line 59
    new-instance v0, Lcom/adobe/ave/VideoCodecs;

    const-string v1, "SCREEN_SHARE_V2"

    const/4 v2, 0x6

    const/4 v3, 0x6

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/VideoCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/VideoCodecs;->SCREEN_SHARE_V2:Lcom/adobe/ave/VideoCodecs;

    .line 64
    new-instance v0, Lcom/adobe/ave/VideoCodecs;

    const-string v1, "H264"

    const/4 v2, 0x7

    const/4 v3, 0x7

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/VideoCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/VideoCodecs;->H264:Lcom/adobe/ave/VideoCodecs;

    .line 69
    new-instance v0, Lcom/adobe/ave/VideoCodecs;

    const-string v1, "MAX_VIDEO_CODECS"

    const/16 v2, 0x8

    const/16 v3, 0x8

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/VideoCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/VideoCodecs;->MAX_VIDEO_CODECS:Lcom/adobe/ave/VideoCodecs;

    .line 24
    const/16 v0, 0x9

    new-array v0, v0, [Lcom/adobe/ave/VideoCodecs;

    sget-object v1, Lcom/adobe/ave/VideoCodecs;->INVALID:Lcom/adobe/ave/VideoCodecs;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/ave/VideoCodecs;->NO_VIDEO:Lcom/adobe/ave/VideoCodecs;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/ave/VideoCodecs;->SORENSON_H263:Lcom/adobe/ave/VideoCodecs;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/ave/VideoCodecs;->SCREEN_SHARE:Lcom/adobe/ave/VideoCodecs;

    aput-object v1, v0, v7

    sget-object v1, Lcom/adobe/ave/VideoCodecs;->ON2VP6:Lcom/adobe/ave/VideoCodecs;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/ave/VideoCodecs;->ON2VP6_ALPHA:Lcom/adobe/ave/VideoCodecs;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/ave/VideoCodecs;->SCREEN_SHARE_V2:Lcom/adobe/ave/VideoCodecs;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/ave/VideoCodecs;->H264:Lcom/adobe/ave/VideoCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/adobe/ave/VideoCodecs;->MAX_VIDEO_CODECS:Lcom/adobe/ave/VideoCodecs;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/ave/VideoCodecs;->$VALUES:[Lcom/adobe/ave/VideoCodecs;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "value"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 73
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 74
    iput p3, p0, Lcom/adobe/ave/VideoCodecs;->value:I

    .line 75
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/VideoCodecs;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 24
    const-class v0, Lcom/adobe/ave/VideoCodecs;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/VideoCodecs;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/VideoCodecs;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/adobe/ave/VideoCodecs;->$VALUES:[Lcom/adobe/ave/VideoCodecs;

    invoke-virtual {v0}, [Lcom/adobe/ave/VideoCodecs;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/VideoCodecs;

    return-object v0
.end method


# virtual methods
.method final getValue()I
    .locals 1

    .prologue
    .line 78
    iget v0, p0, Lcom/adobe/ave/VideoCodecs;->value:I

    return v0
.end method
