.class public abstract enum Lcom/xfinity/playerlib/tracking/VideoMilestone;
.super Ljava/lang/Enum;
.source "VideoMilestone.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/tracking/VideoMilestone;",
        ">;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/xfinity/playerlib/tracking/VideoMilestone;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/tracking/VideoMilestone;

.field public static final enum COMPLETED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

.field public static final enum LIVE_STREAM_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

.field private static final LOG:Lorg/slf4j/Logger;

.field public static final enum NOT_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

.field public static final enum ONE_HALF:Lcom/xfinity/playerlib/tracking/VideoMilestone;

.field public static final enum ONE_QUARTER:Lcom/xfinity/playerlib/tracking/VideoMilestone;

.field public static final enum STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

.field public static final enum THREE_QUARTERS:Lcom/xfinity/playerlib/tracking/VideoMilestone;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 12
    new-instance v0, Lcom/xfinity/playerlib/tracking/VideoMilestone$1;

    const-string v1, "NOT_STARTED"

    invoke-direct {v0, v1, v3}, Lcom/xfinity/playerlib/tracking/VideoMilestone$1;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->NOT_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 24
    new-instance v0, Lcom/xfinity/playerlib/tracking/VideoMilestone$2;

    const-string v1, "STARTED"

    invoke-direct {v0, v1, v4}, Lcom/xfinity/playerlib/tracking/VideoMilestone$2;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 34
    new-instance v0, Lcom/xfinity/playerlib/tracking/VideoMilestone$3;

    const-string v1, "ONE_QUARTER"

    invoke-direct {v0, v1, v5}, Lcom/xfinity/playerlib/tracking/VideoMilestone$3;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->ONE_QUARTER:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 44
    new-instance v0, Lcom/xfinity/playerlib/tracking/VideoMilestone$4;

    const-string v1, "ONE_HALF"

    invoke-direct {v0, v1, v6}, Lcom/xfinity/playerlib/tracking/VideoMilestone$4;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->ONE_HALF:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 54
    new-instance v0, Lcom/xfinity/playerlib/tracking/VideoMilestone$5;

    const-string v1, "THREE_QUARTERS"

    invoke-direct {v0, v1, v7}, Lcom/xfinity/playerlib/tracking/VideoMilestone$5;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->THREE_QUARTERS:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 64
    new-instance v0, Lcom/xfinity/playerlib/tracking/VideoMilestone$6;

    const-string v1, "COMPLETED"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/VideoMilestone$6;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->COMPLETED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 74
    new-instance v0, Lcom/xfinity/playerlib/tracking/VideoMilestone$7;

    const-string v1, "LIVE_STREAM_STARTED"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/VideoMilestone$7;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->LIVE_STREAM_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 10
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/xfinity/playerlib/tracking/VideoMilestone;

    sget-object v1, Lcom/xfinity/playerlib/tracking/VideoMilestone;->NOT_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/tracking/VideoMilestone;->STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xfinity/playerlib/tracking/VideoMilestone;->ONE_QUARTER:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    aput-object v1, v0, v5

    sget-object v1, Lcom/xfinity/playerlib/tracking/VideoMilestone;->ONE_HALF:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    aput-object v1, v0, v6

    sget-object v1, Lcom/xfinity/playerlib/tracking/VideoMilestone;->THREE_QUARTERS:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/xfinity/playerlib/tracking/VideoMilestone;->COMPLETED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/xfinity/playerlib/tracking/VideoMilestone;->LIVE_STREAM_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    aput-object v2, v0, v1

    sput-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->$VALUES:[Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 90
    const-class v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->LOG:Lorg/slf4j/Logger;

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
    .line 10
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILcom/xfinity/playerlib/tracking/VideoMilestone$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lcom/xfinity/playerlib/tracking/VideoMilestone$1;

    .prologue
    .line 10
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/tracking/VideoMilestone;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method static synthetic access$100()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method public static decodePercentage(F)Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .locals 4
    .param p0, "percent"    # F

    .prologue
    .line 115
    const/4 v0, 0x0

    cmpg-float v0, p0, v0

    if-gez v0, :cond_0

    .line 116
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->NOT_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 130
    :goto_0
    return-object v0

    .line 117
    :cond_0
    float-to-double v0, p0

    const-wide/high16 v2, 0x3fd0000000000000L    # 0.25

    cmpg-double v0, v0, v2

    if-gez v0, :cond_1

    .line 118
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    goto :goto_0

    .line 119
    :cond_1
    float-to-double v0, p0

    const-wide/high16 v2, 0x3fe0000000000000L    # 0.5

    cmpg-double v0, v0, v2

    if-gez v0, :cond_2

    .line 120
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->ONE_QUARTER:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    goto :goto_0

    .line 121
    :cond_2
    float-to-double v0, p0

    const-wide/high16 v2, 0x3fe8000000000000L    # 0.75

    cmpg-double v0, v0, v2

    if-gez v0, :cond_3

    .line 122
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->ONE_HALF:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    goto :goto_0

    .line 123
    :cond_3
    float-to-double v0, p0

    const-wide v2, 0x3fef5c28f5c28f5cL    # 0.98

    cmpg-double v0, v0, v2

    if-gez v0, :cond_4

    .line 124
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->THREE_QUARTERS:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    goto :goto_0

    .line 127
    :cond_4
    const/high16 v0, 0x3f800000    # 1.0f

    cmpl-float v0, p0, v0

    if-lez v0, :cond_5

    .line 128
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->LOG:Lorg/slf4j/Logger;

    const-string v1, "unexpected argument; percent > 1 percent={}"

    invoke-static {p0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Object;)V

    .line 130
    :cond_5
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->COMPLETED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    goto :goto_0
.end method

.method public static decodePosition(II)Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .locals 3
    .param p0, "position"    # I
    .param p1, "duration"    # I

    .prologue
    .line 107
    int-to-float v1, p0

    .line 108
    .local v1, "p":F
    int-to-float v0, p1

    .line 109
    .local v0, "d":F
    div-float v2, v1, v0

    invoke-static {v2}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->decodePercentage(F)Lcom/xfinity/playerlib/tracking/VideoMilestone;

    move-result-object v2

    return-object v2
.end method

.method public static decodePosition(ILcom/xfinity/playerlib/model/consumable/VideoFacade;)Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .locals 5
    .param p0, "position"    # I
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 98
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v1

    mul-int/lit16 v0, v1, 0x3e8

    .line 100
    .local v0, "durationMillis":I
    sget-object v1, Lcom/xfinity/playerlib/tracking/VideoMilestone;->LOG:Lorg/slf4j/Logger;

    const-string v2, "decodePosition() position={} durationMillis={}"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v1, v2, v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 102
    invoke-static {p0, v0}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->decodePosition(II)Lcom/xfinity/playerlib/tracking/VideoMilestone;

    move-result-object v1

    return-object v1
.end method

.method public static fromInt(I)Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .locals 5
    .param p0, "ordinal"    # I

    .prologue
    .line 152
    invoke-static {}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->values()[Lcom/xfinity/playerlib/tracking/VideoMilestone;

    move-result-object v2

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 153
    .local v0, "value":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->ordinal()I

    move-result v4

    if-ne v4, p0, :cond_0

    .line 158
    .end local v0    # "value":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    :goto_1
    return-object v0

    .line 152
    .restart local v0    # "value":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 158
    .end local v0    # "value":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    :cond_1
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->NOT_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 10
    const-class v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/xfinity/playerlib/tracking/VideoMilestone;->$VALUES:[Lcom/xfinity/playerlib/tracking/VideoMilestone;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/tracking/VideoMilestone;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/tracking/VideoMilestone;

    return-object v0
.end method


# virtual methods
.method public abstract getEvent()Ljava/lang/String;
.end method

.method public greaterThan(Lcom/xfinity/playerlib/tracking/VideoMilestone;)Z
    .locals 1
    .param p1, "videoMilestone"    # Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .prologue
    .line 93
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->compareTo(Ljava/lang/Enum;)I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public valuesBetween(Lcom/xfinity/playerlib/tracking/VideoMilestone;)Ljava/util/List;
    .locals 4
    .param p1, "higherMilestone"    # Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/tracking/VideoMilestone;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/tracking/VideoMilestone;",
            ">;"
        }
    .end annotation

    .prologue
    .line 136
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 138
    .local v1, "values":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/tracking/VideoMilestone;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->ordinal()I

    move-result v0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->ordinal()I

    move-result v3

    if-gt v0, v3, :cond_1

    .line 139
    invoke-static {}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->values()[Lcom/xfinity/playerlib/tracking/VideoMilestone;

    move-result-object v3

    aget-object v2, v3, v0

    .line 140
    .local v2, "videoMilestone":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    invoke-virtual {v2, p0}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->greaterThan(Lcom/xfinity/playerlib/tracking/VideoMilestone;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 141
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 138
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 144
    .end local v2    # "videoMilestone":Lcom/xfinity/playerlib/tracking/VideoMilestone;
    :cond_1
    return-object v1
.end method
