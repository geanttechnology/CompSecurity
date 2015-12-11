.class public Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;
.super Landroid/os/Handler;
.source "RemoteImageLoaderHandler.java"


# instance fields
.field private errorDrawable:Landroid/graphics/drawable/Drawable;

.field private imageUrl:Ljava/lang/String;

.field private imageView:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;
    .param p3, "errorDrawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 37
    iput-object p1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->imageView:Landroid/widget/ImageView;

    .line 38
    iput-object p2, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->imageUrl:Ljava/lang/String;

    .line 39
    iput-object p3, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->errorDrawable:Landroid/graphics/drawable/Drawable;

    .line 40
    return-void
.end method


# virtual methods
.method public getErrorDrawable()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->errorDrawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getImageView()Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->imageView:Landroid/widget/ImageView;

    return-object v0
.end method

.method protected handleImageLoaded(Landroid/graphics/Bitmap;Landroid/os/Message;)Z
    .locals 3
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .param p2, "msg"    # Landroid/os/Message;

    .prologue
    .line 69
    iget-object v1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->imageView:Landroid/widget/ImageView;

    invoke-virtual {v1}, Landroid/widget/ImageView;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 70
    .local v0, "forUrl":Ljava/lang/String;
    iget-object v1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->imageUrl:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 71
    if-nez p1, :cond_0

    .line 72
    iget-object v1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->imageView:Landroid/widget/ImageView;

    iget-object v2, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->errorDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 77
    :goto_0
    iget-object v1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->imageView:Landroid/widget/ImageView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 79
    const/4 v1, 0x1

    .line 82
    :goto_1
    return v1

    .line 74
    :cond_0
    iget-object v1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->imageView:Landroid/widget/ImageView;

    invoke-virtual {v1, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 82
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method protected final handleImageLoadedMessage(Landroid/os/Message;)V
    .locals 3
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 50
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    .line 51
    .local v1, "data":Landroid/os/Bundle;
    const-string v2, "ign:extra_bitmap"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 52
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    invoke-virtual {p0, v0, p1}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->handleImageLoaded(Landroid/graphics/Bitmap;Landroid/os/Message;)Z

    .line 53
    return-void
.end method

.method public final handleMessage(Landroid/os/Message;)V
    .locals 1
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 44
    iget v0, p1, Landroid/os/Message;->what:I

    if-nez v0, :cond_0

    .line 45
    invoke-virtual {p0, p1}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->handleImageLoadedMessage(Landroid/os/Message;)V

    .line 47
    :cond_0
    return-void
.end method
