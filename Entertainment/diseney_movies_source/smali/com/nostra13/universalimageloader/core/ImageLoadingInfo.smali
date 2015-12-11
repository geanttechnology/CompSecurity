.class final Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
.super Ljava/lang/Object;
.source "ImageLoadingInfo.java"


# instance fields
.field final imageView:Landroid/widget/ImageView;

.field final listener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

.field final loadFromUriLock:Ljava/util/concurrent/locks/ReentrantLock;

.field final memoryCacheKey:Ljava/lang/String;

.field final options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

.field final targetSize:Lcom/nostra13/universalimageloader/core/assist/ImageSize;

.field final uri:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/assist/ImageSize;Ljava/lang/String;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;Ljava/util/concurrent/locks/ReentrantLock;)V
    .locals 0
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "targetSize"    # Lcom/nostra13/universalimageloader/core/assist/ImageSize;
    .param p4, "memoryCacheKey"    # Ljava/lang/String;
    .param p5, "options"    # Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    .param p6, "listener"    # Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;
    .param p7, "loadFromUriLock"    # Ljava/util/concurrent/locks/ReentrantLock;

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->uri:Ljava/lang/String;

    .line 47
    iput-object p2, p0, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->imageView:Landroid/widget/ImageView;

    .line 48
    iput-object p3, p0, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->targetSize:Lcom/nostra13/universalimageloader/core/assist/ImageSize;

    .line 49
    iput-object p5, p0, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    .line 50
    iput-object p6, p0, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->listener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .line 51
    iput-object p7, p0, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->loadFromUriLock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 52
    iput-object p4, p0, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->memoryCacheKey:Ljava/lang/String;

    .line 53
    return-void
.end method
