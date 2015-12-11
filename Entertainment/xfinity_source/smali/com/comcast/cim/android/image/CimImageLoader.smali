.class public abstract Lcom/comcast/cim/android/image/CimImageLoader;
.super Ljava/lang/Object;
.source "CimImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;,
        Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<MT:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private badUrlCache:Lcom/comcast/cim/android/image/BadUrlCache;

.field private imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<TMT;>;"
        }
    .end annotation
.end field

.field private imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/github/ignition/support/images/remote/RemoteImageLoader",
            "<TMT;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/comcast/cim/android/image/CimImageLoader;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/image/CimImageLoader;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/github/ignition/support/images/remote/RemoteImageLoader",
            "<TMT;>;",
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<TMT;>;)V"
        }
    .end annotation

    .prologue
    .line 25
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    .local p1, "imageLoader":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    .local p2, "imageCache":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<TMT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    invoke-virtual {p1, p2}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->setImageCache(Lcom/github/ignition/support/cache/AbstractImageCache;)V

    .line 27
    iput-object p2, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    .line 28
    new-instance v0, Lcom/comcast/cim/android/image/BadUrlCache;

    const/16 v1, 0x48

    const/16 v2, 0x1e

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/image/BadUrlCache;-><init>(II)V

    iput-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader;->badUrlCache:Lcom/comcast/cim/android/image/BadUrlCache;

    .line 29
    iput-object p1, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    .line 30
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/image/CimImageLoader;)Lcom/comcast/cim/android/image/BadUrlCache;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/image/CimImageLoader;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader;->badUrlCache:Lcom/comcast/cim/android/image/BadUrlCache;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/cim/android/image/CimImageLoader;)Lcom/github/ignition/support/images/remote/RemoteImageLoader;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/image/CimImageLoader;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    return-object v0
.end method

.method private shouldTryUrl(Ljava/lang/String;)Z
    .locals 1
    .param p1, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 185
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader;->badUrlCache:Lcom/comcast/cim/android/image/BadUrlCache;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/android/image/BadUrlCache;->isBadUrl(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private stopAnimationOnView(Landroid/widget/ImageView;)V
    .locals 1
    .param p1, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 173
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    invoke-virtual {p1}, Landroid/widget/ImageView;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v0

    .line 174
    .local v0, "animation":Landroid/view/animation/Animation;
    if-eqz v0, :cond_0

    .line 175
    invoke-virtual {p1}, Landroid/widget/ImageView;->clearAnimation()V

    .line 176
    invoke-virtual {v0}, Landroid/view/animation/Animation;->cancel()V

    .line 178
    :cond_0
    return-void
.end method


# virtual methods
.method protected getBitmapFromMemory(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 59
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    invoke-virtual {v0, p1}, Lcom/github/ignition/support/cache/AbstractImageCache;->getBitmapFromMemory(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public loadImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    .locals 7
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    const/4 v4, 0x0

    .line 110
    sget v0, Lcom/comcast/cim/android/R$id;->CIM_IMAGE_LOAD_TAG_KEY:I

    invoke-virtual {p2, v0, p1}, Landroid/widget/ImageView;->setTag(ILjava/lang/Object;)V

    .line 111
    iget-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    invoke-virtual {v0, p2}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->cancelLoad(Landroid/widget/ImageView;)V

    .line 112
    invoke-direct {p0, p2}, Lcom/comcast/cim/android/image/CimImageLoader;->stopAnimationOnView(Landroid/widget/ImageView;)V

    .line 113
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/image/CimImageLoader;->shouldTryUrl(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1, v4, p2}, Lcom/comcast/cim/android/image/CimImageLoader;->loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 114
    iget-object v6, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    new-instance v0, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;

    move-object v1, p0

    move-object v2, p2

    move-object v3, p1

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;-><init>(Lcom/comcast/cim/android/image/CimImageLoader;Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    invoke-virtual {v6, p1, p2, v0}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;)V

    .line 116
    :cond_0
    return-void
.end method

.method public loadImage(Ljava/lang/String;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    .locals 2
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "dummyDrawable"    # Landroid/graphics/drawable/Drawable;
    .param p4, "errorDrawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 119
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    sget v0, Lcom/comcast/cim/android/R$id;->CIM_IMAGE_LOAD_TAG_KEY:I

    invoke-virtual {p2, v0, p1}, Landroid/widget/ImageView;->setTag(ILjava/lang/Object;)V

    .line 120
    iget-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    invoke-virtual {v0, p2}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->cancelLoad(Landroid/widget/ImageView;)V

    .line 121
    invoke-direct {p0, p2}, Lcom/comcast/cim/android/image/CimImageLoader;->stopAnimationOnView(Landroid/widget/ImageView;)V

    .line 122
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/image/CimImageLoader;->shouldTryUrl(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 123
    invoke-virtual {p0, p1, p3, p2}, Lcom/comcast/cim/android/image/CimImageLoader;->loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 124
    iget-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    new-instance v1, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;

    invoke-direct {v1, p2, p1, p4}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;-><init>(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {v0, p1, p2, p3, v1}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;)V

    .line 129
    :cond_0
    :goto_0
    return-void

    .line 126
    :cond_1
    if-eqz p4, :cond_0

    .line 127
    invoke-virtual {p2, p4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public loadImage(Ljava/lang/String;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V
    .locals 7
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "dummyDrawable"    # Landroid/graphics/drawable/Drawable;
    .param p4, "onLoadListener"    # Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    .prologue
    .line 97
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    sget v0, Lcom/comcast/cim/android/R$id;->CIM_IMAGE_LOAD_TAG_KEY:I

    invoke-virtual {p2, v0, p1}, Landroid/widget/ImageView;->setTag(ILjava/lang/Object;)V

    .line 98
    iget-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    invoke-virtual {v0, p2}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->cancelLoad(Landroid/widget/ImageView;)V

    .line 99
    invoke-direct {p0, p2}, Lcom/comcast/cim/android/image/CimImageLoader;->stopAnimationOnView(Landroid/widget/ImageView;)V

    .line 100
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/image/CimImageLoader;->shouldTryUrl(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 101
    invoke-virtual {p0, p1, p3, p2, p4}, Lcom/comcast/cim/android/image/CimImageLoader;->loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 102
    iget-object v6, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    new-instance v0, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;

    move-object v1, p0

    move-object v2, p2

    move-object v3, p1

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;-><init>(Lcom/comcast/cim/android/image/CimImageLoader;Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    invoke-virtual {v6, p1, p2, v0}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;)V

    .line 107
    :cond_0
    :goto_0
    return-void

    .line 104
    :cond_1
    if-eqz p4, :cond_0

    .line 105
    invoke-interface {p4, p2, p1}, Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;->onLoadError(Landroid/widget/ImageView;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V
    .locals 1
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "onLoadListener"    # Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    .prologue
    .line 93
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0, p3}, Lcom/comcast/cim/android/image/CimImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    .line 94
    return-void
.end method

.method public loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)Z
    .locals 1
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "placeholderDrawable"    # Landroid/graphics/drawable/Drawable;
    .param p3, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 85
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/comcast/cim/android/image/CimImageLoader;->loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z

    move-result v0

    return v0
.end method

.method public loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z
    .locals 2
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "placeholderDrawable"    # Landroid/graphics/drawable/Drawable;
    .param p3, "imageView"    # Landroid/widget/ImageView;
    .param p4, "onLoadListener"    # Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    .prologue
    .line 40
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    sget v1, Lcom/comcast/cim/android/R$id;->CIM_IMAGE_LOAD_TAG_KEY:I

    invoke-virtual {p3, v1, p1}, Landroid/widget/ImageView;->setTag(ILjava/lang/Object;)V

    .line 41
    iget-object v1, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    invoke-virtual {v1, p3}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->cancelLoad(Landroid/widget/ImageView;)V

    .line 42
    invoke-direct {p0, p3}, Lcom/comcast/cim/android/image/CimImageLoader;->stopAnimationOnView(Landroid/widget/ImageView;)V

    .line 44
    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/image/CimImageLoader;->getBitmapFromMemory(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 45
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_1

    .line 46
    invoke-virtual {p3, v0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 48
    if-eqz p4, :cond_0

    .line 49
    invoke-interface {p4, p3, p1, v0}, Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;->onLoad(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 51
    :cond_0
    const/4 v1, 0x1

    .line 55
    :goto_0
    return v1

    .line 52
    :cond_1
    if-eqz p2, :cond_2

    .line 53
    invoke-virtual {p3, p2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 55
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public preloadImage(Ljava/lang/String;)V
    .locals 3
    .param p1, "imageUrl"    # Ljava/lang/String;

    .prologue
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    const/4 v2, 0x0

    .line 63
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/image/CimImageLoader;->shouldTryUrl(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    new-instance v1, Lcom/comcast/cim/android/image/CimImageLoader$1;

    invoke-direct {v1, p0, v2, v2, v2}, Lcom/comcast/cim/android/image/CimImageLoader$1;-><init>(Lcom/comcast/cim/android/image/CimImageLoader;Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {v0, p1, v2, v1}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;)V

    .line 76
    :cond_0
    return-void
.end method

.method public purgeJobs()V
    .locals 1

    .prologue
    .line 181
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    invoke-virtual {v0}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->purgeJobs()V

    .line 182
    return-void
.end method
