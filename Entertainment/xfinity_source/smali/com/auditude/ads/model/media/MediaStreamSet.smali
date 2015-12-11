.class public Lcom/auditude/ads/model/media/MediaStreamSet;
.super Ljava/lang/Object;
.source "MediaStreamSet.java"


# static fields
.field private static MIME_TYPES_SUPPORTED:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 10
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "video/mp4"

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    sput-object v0, Lcom/auditude/ads/model/media/MediaStreamSet;->MIME_TYPES_SUPPORTED:Ljava/util/ArrayList;

    return-void
.end method

.method public static Search(Ljava/util/ArrayList;I)Lcom/auditude/ads/model/media/MediaFile;
    .locals 5
    .param p1, "bitrate"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/media/MediaFile;",
            ">;I)",
            "Lcom/auditude/ads/model/media/MediaFile;"
        }
    .end annotation

    .prologue
    .local p0, "mediaFiles":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/media/MediaFile;>;"
    const/4 v2, 0x0

    .line 15
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_2

    :cond_0
    move-object v1, v2

    .line 41
    :cond_1
    :goto_0
    return-object v1

    .line 17
    :cond_2
    new-instance v3, Lcom/auditude/ads/model/media/MediaFileComparator;

    invoke-direct {v3}, Lcom/auditude/ads/model/media/MediaFileComparator;-><init>()V

    invoke-static {p0, v3}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 19
    const/4 v1, 0x0

    .line 20
    .local v1, "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/lit8 v0, v3, -0x1

    .local v0, "i":I
    :goto_1
    if-gez v0, :cond_3

    .line 31
    const/4 v0, 0x0

    :goto_2
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lt v0, v3, :cond_5

    move-object v1, v2

    .line 41
    goto :goto_0

    .line 22
    :cond_3
    invoke-virtual {p0, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    check-cast v1, Lcom/auditude/ads/model/media/MediaFile;

    .line 23
    .restart local v1    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    iget v3, v1, Lcom/auditude/ads/model/media/MediaFile;->bitrate:I

    if-gt v3, p1, :cond_4

    iget-object v3, v1, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    invoke-static {v3}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 24
    :cond_4
    sget-object v3, Lcom/auditude/ads/model/media/MediaStreamSet;->MIME_TYPES_SUPPORTED:Ljava/util/ArrayList;

    iget-object v4, v1, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v3

    if-gez v3, :cond_1

    .line 20
    add-int/lit8 v0, v0, -0x1

    goto :goto_1

    .line 33
    :cond_5
    invoke-virtual {p0, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    check-cast v1, Lcom/auditude/ads/model/media/MediaFile;

    .line 34
    .restart local v1    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    iget-object v3, v1, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    invoke-static {v3}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 35
    sget-object v3, Lcom/auditude/ads/model/media/MediaStreamSet;->MIME_TYPES_SUPPORTED:Ljava/util/ArrayList;

    iget-object v4, v1, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v3

    if-gez v3, :cond_1

    .line 31
    add-int/lit8 v0, v0, 0x1

    goto :goto_2
.end method
