.class public Lcom/xfinity/playerlib/image/ProgramArtImageLoader;
.super Lcom/comcast/cim/android/image/CimImageLoader;
.source "ProgramArtImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/android/image/CimImageLoader",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private final entityThumbnailUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;)V
    .locals 0
    .param p1, "thumbnailUrl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/github/ignition/support/images/remote/RemoteImageLoader",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;",
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 17
    .local p2, "imageLoader":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<Landroid/graphics/Bitmap;>;"
    .local p3, "imageCache":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<Landroid/graphics/Bitmap;>;"
    invoke-direct {p0, p2, p3}, Lcom/comcast/cim/android/image/CimImageLoader;-><init>(Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;)V

    .line 18
    iput-object p1, p0, Lcom/xfinity/playerlib/image/ProgramArtImageLoader;->entityThumbnailUrl:Ljava/lang/String;

    .line 19
    return-void
.end method


# virtual methods
.method public getImageUrl(IILcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;
    .locals 5
    .param p1, "imageWidth"    # I
    .param p2, "imageHeight"    # I
    .param p3, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 26
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v1, "%s/%d/%d/%d?noRedir=true"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/xfinity/playerlib/image/ProgramArtImageLoader;->entityThumbnailUrl:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    .line 28
    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    .line 26
    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getImageUrl(IILcom/xfinity/playerlib/model/Program;)Ljava/lang/String;
    .locals 1
    .param p1, "imageWidth"    # I
    .param p2, "imageHeight"    # I
    .param p3, "program"    # Lcom/xfinity/playerlib/model/Program;

    .prologue
    .line 22
    invoke-interface {p3}, Lcom/xfinity/playerlib/model/Program;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {p0, p1, p2, v0}, Lcom/xfinity/playerlib/image/ProgramArtImageLoader;->getImageUrl(IILcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSeriesImageUrl(IILcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;
    .locals 5
    .param p1, "imageWidth"    # I
    .param p2, "imageHeight"    # I
    .param p3, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 32
    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    const-wide v2, 0x2386f26fc10000L

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    .line 33
    invoke-virtual {p0, p1, p2, p3}, Lcom/xfinity/playerlib/image/ProgramArtImageLoader;->getImageUrl(IILcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v0

    .line 36
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v1, "%s/%s/%d/%d?noRedir=true"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/xfinity/playerlib/image/ProgramArtImageLoader;->entityThumbnailUrl:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    .line 38
    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespacedId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    .line 36
    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
