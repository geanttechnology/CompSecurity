.class Lcom/auditude/ads/model/media/MediaFileComparator;
.super Ljava/lang/Object;
.source "MediaStreamSet.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/auditude/ads/model/media/MediaFile;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/auditude/ads/model/media/MediaFile;Lcom/auditude/ads/model/media/MediaFile;)I
    .locals 2
    .param p1, "a"    # Lcom/auditude/ads/model/media/MediaFile;
    .param p2, "b"    # Lcom/auditude/ads/model/media/MediaFile;

    .prologue
    .line 50
    iget v0, p1, Lcom/auditude/ads/model/media/MediaFile;->bitrate:I

    iget v1, p2, Lcom/auditude/ads/model/media/MediaFile;->bitrate:I

    if-le v0, v1, :cond_0

    .line 52
    const/4 v0, 0x1

    .line 59
    :goto_0
    return v0

    .line 54
    :cond_0
    iget v0, p1, Lcom/auditude/ads/model/media/MediaFile;->bitrate:I

    iget v1, p2, Lcom/auditude/ads/model/media/MediaFile;->bitrate:I

    if-ge v0, v1, :cond_1

    .line 56
    const/4 v0, -0x1

    goto :goto_0

    .line 59
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 1
    check-cast p1, Lcom/auditude/ads/model/media/MediaFile;

    check-cast p2, Lcom/auditude/ads/model/media/MediaFile;

    invoke-virtual {p0, p1, p2}, Lcom/auditude/ads/model/media/MediaFileComparator;->compare(Lcom/auditude/ads/model/media/MediaFile;Lcom/auditude/ads/model/media/MediaFile;)I

    move-result v0

    return v0
.end method
