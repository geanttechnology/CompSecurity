.class public Lcom/auditude/ads/network/vast/model/VASTLinearCreative;
.super Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;
.source "VASTLinearCreative.java"


# instance fields
.field public click:Lcom/auditude/ads/network/vast/model/VASTClick;

.field public duration:I

.field private mediaFiles:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTMediaFile;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 5
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;-><init>()V

    .line 7
    const/4 v0, 0x0

    iput v0, p0, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->duration:I

    .line 5
    return-void
.end method


# virtual methods
.method public final addMediaFile(Lcom/auditude/ads/network/vast/model/VASTMediaFile;)V
    .locals 1
    .param p1, "mediaFile"    # Lcom/auditude/ads/network/vast/model/VASTMediaFile;

    .prologue
    .line 63
    if-nez p1, :cond_0

    .line 73
    :goto_0
    return-void

    .line 68
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->mediaFiles:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 70
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->mediaFiles:Ljava/util/ArrayList;

    .line 72
    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->mediaFiles:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public final getBestMediaFile()Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    .locals 11

    .prologue
    const/4 v10, 0x5

    const/4 v9, 0x0

    .line 14
    new-array v4, v10, [Ljava/lang/String;

    const-string v7, "application/x-mpegurl"

    aput-object v7, v4, v9

    const/4 v7, 0x1

    const-string v8, "video/mp4"

    aput-object v8, v4, v7

    const/4 v7, 0x2

    const-string v8, "video/m4v"

    aput-object v8, v4, v7

    const/4 v7, 0x3

    const-string v8, "video/x-flv"

    aput-object v8, v4, v7

    const/4 v7, 0x4

    const-string v8, "video/webm"

    aput-object v8, v4, v7

    .line 15
    .local v4, "mimeTypes":[Ljava/lang/String;
    new-array v3, v10, [I

    fill-array-data v3, :array_0

    .line 16
    .local v3, "mimeTypeCodes":[I
    const/4 v5, 0x0

    .line 17
    .local v5, "result":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    const/4 v1, 0x0

    .line 19
    .local v1, "index":I
    iget-object v7, p0, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->mediaFiles:Ljava/util/ArrayList;

    if-eqz v7, :cond_0

    .line 21
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v7, p0, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->mediaFiles:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lt v0, v7, :cond_1

    .end local v0    # "i":I
    :cond_0
    move-object v6, v5

    .line 53
    :goto_1
    return-object v6

    .line 23
    .restart local v0    # "i":I
    :cond_1
    iget-object v7, p0, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->mediaFiles:Ljava/util/ArrayList;

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/auditude/ads/network/vast/model/VASTMediaFile;

    .line 24
    .local v6, "tmp":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    iget-object v7, v6, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->type:Ljava/lang/String;

    invoke-virtual {v7}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    aget-object v8, v4, v9

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 26
    aget v1, v3, v9

    .line 27
    goto :goto_1

    .line 31
    :cond_2
    const/4 v2, 0x1

    .local v2, "j":I
    :goto_2
    array-length v7, v4

    if-lt v2, v7, :cond_3

    .line 21
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 33
    :cond_3
    iget-object v7, v6, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->type:Ljava/lang/String;

    invoke-virtual {v7}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    aget-object v8, v4, v2

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_6

    add-int/lit8 v7, v2, -0x1

    aget v7, v3, v7

    if-ge v1, v7, :cond_6

    .line 35
    if-eqz v5, :cond_7

    .line 37
    iget-object v7, v5, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->type:Ljava/lang/String;

    invoke-virtual {v7}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    iget-object v8, v6, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->type:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_4

    iget v7, v6, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->bitrate:I

    iget v8, v5, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->bitrate:I

    if-gt v7, v8, :cond_5

    :cond_4
    iget-object v7, v5, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->type:Ljava/lang/String;

    iget-object v8, v6, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->type:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_6

    .line 39
    :cond_5
    aget v1, v3, v2

    .line 40
    move-object v5, v6

    .line 31
    :cond_6
    :goto_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 45
    :cond_7
    aget v1, v3, v2

    .line 46
    move-object v5, v6

    goto :goto_3

    .line 15
    :array_0
    .array-data 4
        0x32
        0x28
        0x1e
        0x14
        0xa
    .end array-data
.end method

.method public final getMediaFiles()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTMediaFile;",
            ">;"
        }
    .end annotation

    .prologue
    .line 58
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->mediaFiles:Ljava/util/ArrayList;

    return-object v0
.end method

.method public final hasAssetsWithMimeType(Ljava/util/ArrayList;)Ljava/lang/Boolean;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/Boolean;"
        }
    .end annotation

    .prologue
    .line 77
    .local p1, "mimeTypes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 79
    iget-object v2, p0, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->mediaFiles:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_2

    .line 90
    :cond_1
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    :goto_0
    return-object v2

    .line 79
    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTMediaFile;

    .line 81
    .local v0, "mediaFile":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 83
    .local v1, "type":Ljava/lang/String;
    iget-object v4, v0, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->type:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 85
    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    goto :goto_0
.end method
