.class public Lcom/xfinity/playerlib/VideoPlayUtil;
.super Ljava/lang/Object;
.source "VideoPlayUtil.java"


# instance fields
.field private final LOG:Lorg/slf4j/Logger;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const-class v0, Lcom/xfinity/playerlib/VideoPlayUtil;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/VideoPlayUtil;->LOG:Lorg/slf4j/Logger;

    return-void
.end method


# virtual methods
.method public getDisplayTime(II)Ljava/lang/String;
    .locals 12
    .param p1, "milSeconds"    # I
    .param p2, "duration"    # I

    .prologue
    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v5, 0x0

    .line 51
    if-gez p1, :cond_0

    move v2, v5

    .line 52
    .local v2, "mil":I
    :goto_0
    div-int/lit16 v6, v2, 0x3e8

    div-int/lit16 v1, v6, 0xe10

    .line 53
    .local v1, "hours":I
    div-int/lit16 v6, v2, 0x3e8

    mul-int/lit8 v7, v1, 0x3c

    mul-int/lit8 v7, v7, 0x3c

    sub-int/2addr v6, v7

    div-int/lit8 v3, v6, 0x3c

    .line 54
    .local v3, "mins":I
    div-int/lit16 v6, v2, 0x3e8

    mul-int/lit16 v7, v1, 0xe10

    sub-int/2addr v6, v7

    mul-int/lit8 v7, v3, 0x3c

    sub-int v4, v6, v7

    .line 55
    .local v4, "seconds":I
    const/4 v0, 0x0

    .line 56
    .local v0, "displayTime":Ljava/lang/String;
    const v6, 0x36ee80

    if-le p2, v6, :cond_1

    .line 57
    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v7, "%d:%02d:%02d"

    const/4 v8, 0x3

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v5

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v8, v10

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v8, v11

    invoke-static {v6, v7, v8}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 61
    :goto_1
    return-object v0

    .end local v0    # "displayTime":Ljava/lang/String;
    .end local v1    # "hours":I
    .end local v2    # "mil":I
    .end local v3    # "mins":I
    .end local v4    # "seconds":I
    :cond_0
    move v2, p1

    .line 51
    goto :goto_0

    .line 59
    .restart local v0    # "displayTime":Ljava/lang/String;
    .restart local v1    # "hours":I
    .restart local v2    # "mil":I
    .restart local v3    # "mins":I
    .restart local v4    # "seconds":I
    :cond_1
    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v7, "%02d:%02d"

    new-array v8, v11, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v5

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v8, v10

    invoke-static {v6, v7, v8}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method
