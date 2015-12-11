.class public Lcom/xfinity/playerlib/image/CoverArtImageLoader;
.super Lcom/xfinity/playerlib/image/ProgramArtImageLoader;
.source "CoverArtImageLoader.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private cover_art_height:I

.field private cover_art_width:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;Landroid/content/Context;)V
    .locals 2
    .param p1, "entityThumbnailUrl"    # Ljava/lang/String;
    .param p4, "context"    # Landroid/content/Context;
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
            ")V"
        }
    .end annotation

    .prologue
    .line 23
    .local p2, "imageLoader":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<Landroid/graphics/Bitmap;>;"
    .local p3, "imageCache":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<Landroid/graphics/Bitmap;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/image/ProgramArtImageLoader;-><init>(Ljava/lang/String;Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;)V

    .line 25
    invoke-virtual {p4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$dimen;->cover_art_src_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->cover_art_width:I

    .line 26
    invoke-virtual {p4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$dimen;->cover_art_src_height:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->cover_art_height:I

    .line 27
    return-void
.end method

.method private getImageUrl(Lcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;
    .locals 2
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 66
    iget v0, p0, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->cover_art_width:I

    iget v1, p0, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->cover_art_height:I

    invoke-virtual {p0, v0, v1, p1}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->getImageUrl(IILcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getImageUrl(Lcom/xfinity/playerlib/model/Program;)Ljava/lang/String;
    .locals 2
    .param p1, "program"    # Lcom/xfinity/playerlib/model/Program;

    .prologue
    .line 46
    if-nez p1, :cond_0

    .line 47
    sget-object v0, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->LOG:Lorg/slf4j/Logger;

    const-string v1, "unexpected null program"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    .line 48
    const/4 v0, 0x0

    .line 50
    :goto_0
    return-object v0

    :cond_0
    iget v0, p0, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->cover_art_width:I

    iget v1, p0, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->cover_art_height:I

    invoke-virtual {p0, v0, v1, p1}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->getImageUrl(IILcom/xfinity/playerlib/model/Program;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public loadImage(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V
    .locals 1
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "view"    # Landroid/widget/ImageView;
    .param p3, "onLoadListener"    # Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->getImageUrl(Lcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p2, p3}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    .line 43
    return-void
.end method

.method public loadImage(Lcom/xfinity/playerlib/model/Program;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V
    .locals 1
    .param p1, "program"    # Lcom/xfinity/playerlib/model/Program;
    .param p2, "view"    # Landroid/widget/ImageView;
    .param p3, "onLoadListener"    # Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    .prologue
    .line 30
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->getImageUrl(Lcom/xfinity/playerlib/model/Program;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p2, p3}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    .line 31
    return-void
.end method

.method public loadImageFromMemory(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z
    .locals 2
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "onLoadListener"    # Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    .prologue
    .line 62
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->getImageUrl(Lcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-super {p0, v0, v1, p2, p3}, Lcom/xfinity/playerlib/image/ProgramArtImageLoader;->loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z

    move-result v0

    return v0
.end method

.method public loadImageFromMemory(Lcom/xfinity/playerlib/model/Program;Landroid/widget/ImageView;)Z
    .locals 2
    .param p1, "program"    # Lcom/xfinity/playerlib/model/Program;
    .param p2, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 54
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->getImageUrl(Lcom/xfinity/playerlib/model/Program;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, p2}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)Z

    move-result v0

    return v0
.end method

.method public loadImageFromMemory(Lcom/xfinity/playerlib/model/Program;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z
    .locals 2
    .param p1, "program"    # Lcom/xfinity/playerlib/model/Program;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "onLoadListener"    # Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    .prologue
    .line 58
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->getImageUrl(Lcom/xfinity/playerlib/model/Program;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, p2, p3}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z

    move-result v0

    return v0
.end method
