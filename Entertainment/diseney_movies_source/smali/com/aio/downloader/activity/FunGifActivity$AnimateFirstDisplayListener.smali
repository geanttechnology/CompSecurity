.class Lcom/aio/downloader/activity/FunGifActivity$AnimateFirstDisplayListener;
.super Lcom/nostra13/universalimageloader/core/assist/SimpleImageLoadingListener;
.source "FunGifActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/FunGifActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AnimateFirstDisplayListener"
.end annotation


# instance fields
.field final displayedImages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/aio/downloader/activity/FunGifActivity;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/activity/FunGifActivity;)V
    .locals 1

    .prologue
    .line 392
    iput-object p1, p0, Lcom/aio/downloader/activity/FunGifActivity$AnimateFirstDisplayListener;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    invoke-direct {p0}, Lcom/nostra13/universalimageloader/core/assist/SimpleImageLoadingListener;-><init>()V

    .line 395
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity$AnimateFirstDisplayListener;->displayedImages:Ljava/util/List;

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/activity/FunGifActivity;Lcom/aio/downloader/activity/FunGifActivity$AnimateFirstDisplayListener;)V
    .locals 0

    .prologue
    .line 392
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/FunGifActivity$AnimateFirstDisplayListener;-><init>(Lcom/aio/downloader/activity/FunGifActivity;)V

    return-void
.end method


# virtual methods
.method public onLoadingComplete(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "loadedImage"    # Landroid/graphics/Bitmap;

    .prologue
    .line 402
    if-eqz p3, :cond_0

    move-object v1, p2

    .line 403
    check-cast v1, Landroid/widget/ImageView;

    .line 404
    .local v1, "imageView":Landroid/widget/ImageView;
    iget-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity$AnimateFirstDisplayListener;->displayedImages:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    const/4 v0, 0x0

    .line 405
    .local v0, "firstDisplay":Z
    :goto_0
    if-eqz v0, :cond_0

    .line 406
    const/16 v2, 0x1f4

    invoke-static {v1, v2}, Lcom/nostra13/universalimageloader/core/display/FadeInBitmapDisplayer;->animate(Landroid/widget/ImageView;I)V

    .line 407
    iget-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity$AnimateFirstDisplayListener;->displayedImages:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 410
    .end local v0    # "firstDisplay":Z
    .end local v1    # "imageView":Landroid/widget/ImageView;
    :cond_0
    return-void

    .line 404
    .restart local v1    # "imageView":Landroid/widget/ImageView;
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method
