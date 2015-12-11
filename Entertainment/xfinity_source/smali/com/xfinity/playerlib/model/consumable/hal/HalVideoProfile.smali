.class public Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
.super Ljava/lang/Object;
.source "HalVideoProfile.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/hal/model/HalParseable;


# instance fields
.field private bitrate:J

.field private contentSizeInBytes:J

.field private height:I

.field private manifestUrl:Ljava/lang/String;

.field private secData:Ljava/lang/String;

.field private width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 8
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 62
    if-ne p0, p1, :cond_1

    .line 91
    :cond_0
    :goto_0
    return v1

    .line 65
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 66
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 69
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    .line 71
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->bitrate:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->bitrate:J

    cmp-long v3, v4, v6

    if-eqz v3, :cond_4

    move v1, v2

    .line 72
    goto :goto_0

    .line 74
    :cond_4
    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->contentSizeInBytes:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->contentSizeInBytes:J

    cmp-long v3, v4, v6

    if-eqz v3, :cond_5

    move v1, v2

    .line 75
    goto :goto_0

    .line 77
    :cond_5
    iget v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->height:I

    iget v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->height:I

    if-eq v3, v4, :cond_6

    move v1, v2

    .line 78
    goto :goto_0

    .line 80
    :cond_6
    iget v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->width:I

    iget v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->width:I

    if-eq v3, v4, :cond_7

    move v1, v2

    .line 81
    goto :goto_0

    .line 83
    :cond_7
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->manifestUrl:Ljava/lang/String;

    if-eqz v3, :cond_9

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->manifestUrl:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->manifestUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_a

    :cond_8
    move v1, v2

    .line 84
    goto :goto_0

    .line 83
    :cond_9
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->manifestUrl:Ljava/lang/String;

    if-nez v3, :cond_8

    .line 87
    :cond_a
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->secData:Ljava/lang/String;

    if-eqz v3, :cond_b

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->secData:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->secData:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 88
    goto :goto_0

    .line 87
    :cond_b
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->secData:Ljava/lang/String;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getBitrate()J
    .locals 2

    .prologue
    .line 57
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->bitrate:J

    return-wide v0
.end method

.method public getContentSizeInBytes()J
    .locals 2

    .prologue
    .line 53
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->contentSizeInBytes:J

    return-wide v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 45
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->height:I

    return v0
.end method

.method public getManifestUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->manifestUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getSecData()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->secData:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 49
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->width:I

    return v0
.end method

.method public hashCode()I
    .locals 7

    .prologue
    const/16 v6, 0x20

    const/4 v1, 0x0

    .line 96
    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->manifestUrl:Ljava/lang/String;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->manifestUrl:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 97
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->secData:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->secData:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 98
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->height:I

    add-int v0, v1, v2

    .line 99
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->width:I

    add-int v0, v1, v2

    .line 100
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->contentSizeInBytes:J

    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->contentSizeInBytes:J

    ushr-long/2addr v4, v6

    xor-long/2addr v2, v4

    long-to-int v2, v2

    add-int v0, v1, v2

    .line 101
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->bitrate:J

    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->bitrate:J

    ushr-long/2addr v4, v6

    xor-long/2addr v2, v4

    long-to-int v2, v2

    add-int v0, v1, v2

    .line 102
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 96
    goto :goto_0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 6
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 17
    const-string v4, "manifest"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchLinkAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->manifestUrl:Ljava/lang/String;

    .line 18
    const-string v4, "secData"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->secData:Ljava/lang/String;

    .line 19
    const-string v4, "height"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 20
    .local v2, "heightString":Ljava/lang/String;
    if-nez v2, :cond_0

    const-string v2, "0"

    .line 21
    :cond_0
    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    iput v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->height:I

    .line 22
    const-string v4, "width"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 23
    .local v3, "widthString":Ljava/lang/String;
    if-nez v3, :cond_1

    const-string v3, "0"

    .line 24
    :cond_1
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    iput v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->width:I

    .line 25
    const-string v4, "contentSize"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 26
    .local v1, "contentSize":Ljava/lang/String;
    if-nez v1, :cond_2

    const-string v1, "0"

    .line 27
    :cond_2
    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->contentSizeInBytes:J

    .line 28
    const-string v4, "bitrate"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 29
    .local v0, "bitrateString":Ljava/lang/String;
    if-nez v0, :cond_3

    const-string v0, "0"

    .line 30
    :cond_3
    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->bitrate:J

    .line 31
    return-void
.end method
