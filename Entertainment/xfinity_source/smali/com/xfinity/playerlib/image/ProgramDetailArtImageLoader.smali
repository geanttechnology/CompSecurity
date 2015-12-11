.class public Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;
.super Lcom/xfinity/playerlib/image/ProgramArtImageLoader;
.source "ProgramDetailArtImageLoader.java"


# instance fields
.field private deviceInfo:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private movie_detail_art_height:I

.field private movie_detail_art_width:I

.field private series_detail_art_height:I

.field private series_detail_art_width:I


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;Landroid/content/Context;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;)V
    .locals 3
    .param p1, "thumbnailUrl"    # Ljava/lang/String;
    .param p4, "context"    # Landroid/content/Context;
    .param p5, "deviceInfo"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
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
            ">;",
            "Landroid/content/Context;",
            "Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;",
            ")V"
        }
    .end annotation

    .prologue
    .line 24
    .local p2, "imageLoader":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<Landroid/graphics/Bitmap;>;"
    .local p3, "imageCache":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<Landroid/graphics/Bitmap;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/image/ProgramArtImageLoader;-><init>(Ljava/lang/String;Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;)V

    .line 26
    invoke-virtual {p4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$dimen;->series_detail_art_src_width:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    iput v1, p0, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->series_detail_art_width:I

    .line 27
    invoke-virtual {p4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$dimen;->series_detail_art_src_height:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    iput v1, p0, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->series_detail_art_height:I

    .line 29
    invoke-virtual {p4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$dimen;->movie_detail_art_src_width:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    iput v1, p0, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->movie_detail_art_width:I

    .line 30
    invoke-virtual {p4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$dimen;->movie_detail_art_src_height:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    iput v1, p0, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->movie_detail_art_height:I

    .line 32
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual {p4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$color;->MissingImage:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-direct {v0, v1}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 33
    .local v0, "drawable":Landroid/graphics/drawable/ColorDrawable;
    invoke-virtual {p2, v0}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->setDownloadFailedDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 34
    invoke-virtual {p2, v0}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->setDownloadInProgressDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 36
    iput-object p5, p0, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->deviceInfo:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 37
    return-void
.end method

.method private getImageUrl(Lcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;
    .locals 5
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 68
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v3

    sget-object v4, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 69
    iget v2, p0, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->movie_detail_art_width:I

    .line 70
    .local v2, "imageWidth":I
    iget v0, p0, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->movie_detail_art_height:I

    .line 71
    .local v0, "imageHeight":I
    invoke-virtual {p0, v2, v0, p1}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->getImageUrl(IILcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v1

    .line 77
    .local v1, "imageUrl":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 73
    .end local v0    # "imageHeight":I
    .end local v1    # "imageUrl":Ljava/lang/String;
    .end local v2    # "imageWidth":I
    :cond_0
    iget v2, p0, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->series_detail_art_width:I

    .line 74
    .restart local v2    # "imageWidth":I
    iget v0, p0, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->series_detail_art_height:I

    .line 75
    .restart local v0    # "imageHeight":I
    invoke-virtual {p0, v2, v0, p1}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->getSeriesImageUrl(IILcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "imageUrl":Ljava/lang/String;
    goto :goto_0
.end method


# virtual methods
.method public getBitmapFromCache(Lcom/xfinity/playerlib/model/MerlinId;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 93
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->getImageUrl(Lcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->getBitmapFromMemory(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public loadDetailProgramArt(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;)V
    .locals 1
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "view"    # Landroid/widget/ImageView;

    .prologue
    .line 59
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->getImageUrl(Lcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v0

    .line 61
    .local v0, "imageUrl":Ljava/lang/String;
    invoke-virtual {p0, v0, p2}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 62
    return-void
.end method

.method public loadDetailProgramArt(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;II)V
    .locals 1
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "view"    # Landroid/widget/ImageView;
    .param p3, "sourceWidth"    # I
    .param p4, "sourceHeight"    # I

    .prologue
    .line 81
    invoke-virtual {p0, p3, p4, p1}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->getImageUrl(IILcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v0

    .line 82
    .local v0, "imageUrl":Ljava/lang/String;
    invoke-virtual {p0, v0, p2}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 83
    return-void
.end method

.method public loadNetworkFeatureDetailProgramArt(Lcom/xfinity/playerlib/model/tags/FeaturedShow;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V
    .locals 3
    .param p1, "program"    # Lcom/xfinity/playerlib/model/tags/FeaturedShow;
    .param p2, "view"    # Landroid/widget/ImageView;
    .param p3, "onLoadListener"    # Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    .prologue
    .line 41
    iget-object v1, p0, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->deviceInfo:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getDensity()F

    move-result v1

    const/high16 v2, 0x3f800000    # 1.0f

    cmpl-float v1, v1, v2

    if-lez v1, :cond_0

    .line 42
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->getImageUrl2x()Ljava/lang/String;

    move-result-object v0

    .line 47
    .local v0, "imageUrl":Ljava/lang/String;
    :goto_0
    invoke-virtual {p0, v0, p2, p3}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    .line 48
    return-void

    .line 44
    .end local v0    # "imageUrl":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "imageUrl":Ljava/lang/String;
    goto :goto_0
.end method

.method public preCacheDrawable(Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 1
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 87
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->getBitmapFromCache(Lcom/xfinity/playerlib/model/MerlinId;)Landroid/graphics/Bitmap;

    move-result-object v0

    if-nez v0, :cond_0

    .line 88
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->getImageUrl(Lcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->preloadImage(Ljava/lang/String;)V

    .line 90
    :cond_0
    return-void
.end method
