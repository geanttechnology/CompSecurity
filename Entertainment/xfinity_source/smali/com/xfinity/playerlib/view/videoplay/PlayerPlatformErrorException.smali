.class public Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;
.super Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
.source "PlayerPlatformErrorException.java"


# instance fields
.field private final localPlayback:Z

.field private final majorCode:I

.field private final minorCode:I

.field private final rawCode:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "rawCode"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 145
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 146
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 6
    .param p1, "rawCode"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "localPlayback"    # Z

    .prologue
    .line 119
    const-string v3, "code: %s, description: %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    aput-object p2, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    .line 120
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->rawCode:Ljava/lang/String;

    .line 123
    const/16 v3, 0x2e

    invoke-static {v3}, Lcom/google/common/base/Splitter;->on(C)Lcom/google/common/base/Splitter;

    move-result-object v3

    invoke-virtual {v3, p1}, Lcom/google/common/base/Splitter;->split(Ljava/lang/CharSequence;)Ljava/lang/Iterable;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 125
    .local v0, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->intValue(Ljava/lang/String;)I

    move-result v1

    .line 130
    .local v1, "majorCode":I
    const v3, 0x186a0

    if-ne v1, v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 131
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->intValue(Ljava/lang/String;)I

    move-result v1

    .line 133
    :cond_0
    iput v1, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->majorCode:I

    .line 135
    const/4 v2, -0x1

    .line 136
    .local v2, "minorCode":I
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 137
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->intValue(Ljava/lang/String;)I

    move-result v2

    .line 139
    :cond_1
    iput v2, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->minorCode:I

    .line 141
    iput-boolean p3, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->localPlayback:Z

    .line 142
    return-void
.end method

.method private intValue(Ljava/lang/String;)I
    .locals 2
    .param p1, "string"    # Ljava/lang/String;

    .prologue
    .line 150
    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 152
    :goto_0
    return v1

    .line 151
    :catch_0
    move-exception v0

    .line 152
    .local v0, "ignored":Ljava/lang/Throwable;
    const/4 v1, -0x1

    goto :goto_0
.end method


# virtual methods
.method public getMajorCode()I
    .locals 1

    .prologue
    .line 161
    iget v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->majorCode:I

    return v0
.end method

.method public getMinorCode()I
    .locals 1

    .prologue
    .line 165
    iget v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->minorCode:I

    return v0
.end method

.method public getRawCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->rawCode:Ljava/lang/String;

    return-object v0
.end method

.method public isLocalPlayback()Z
    .locals 1

    .prologue
    .line 169
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->localPlayback:Z

    return v0
.end method
