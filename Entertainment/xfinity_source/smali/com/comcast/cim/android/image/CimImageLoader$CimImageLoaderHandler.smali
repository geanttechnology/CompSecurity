.class Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;
.super Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;
.source "CimImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/image/CimImageLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CimImageLoaderHandler"
.end annotation


# instance fields
.field private onLoadListener:Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

.field final synthetic this$0:Lcom/comcast/cim/android/image/CimImageLoader;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/image/CimImageLoader;Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V
    .locals 0
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "imageUrl"    # Ljava/lang/String;
    .param p4, "errorDrawable"    # Landroid/graphics/drawable/Drawable;
    .param p5, "onLoadListener"    # Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    .prologue
    .line 192
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>.CimImageLoaderHandler;"
    iput-object p1, p0, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->this$0:Lcom/comcast/cim/android/image/CimImageLoader;

    .line 193
    invoke-direct {p0, p2, p3, p4}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;-><init>(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V

    .line 194
    iput-object p5, p0, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->onLoadListener:Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    .line 195
    return-void
.end method


# virtual methods
.method protected handleImageLoaded(Landroid/graphics/Bitmap;Landroid/os/Message;)Z
    .locals 6
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .param p2, "msg"    # Landroid/os/Message;

    .prologue
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;, "Lcom/comcast/cim/android/image/CimImageLoader<TMT;>.CimImageLoaderHandler;"
    const/4 v3, 0x0

    .line 199
    invoke-virtual {p0}, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->getImageView()Landroid/widget/ImageView;

    move-result-object v2

    .line 200
    .local v2, "imageView":Landroid/widget/ImageView;
    invoke-virtual {v2}, Landroid/widget/ImageView;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 202
    .local v1, "forUrl":Ljava/lang/String;
    if-nez p1, :cond_1

    .line 203
    iget-object v4, p0, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->this$0:Lcom/comcast/cim/android/image/CimImageLoader;

    # getter for: Lcom/comcast/cim/android/image/CimImageLoader;->badUrlCache:Lcom/comcast/cim/android/image/BadUrlCache;
    invoke-static {v4}, Lcom/comcast/cim/android/image/CimImageLoader;->access$000(Lcom/comcast/cim/android/image/CimImageLoader;)Lcom/comcast/cim/android/image/BadUrlCache;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->getImageUrl()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/comcast/cim/android/image/BadUrlCache;->setBadUrl(Ljava/lang/String;)V

    .line 204
    iget-object v4, p0, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->onLoadListener:Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    if-eqz v4, :cond_1

    .line 205
    iget-object v4, p0, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->onLoadListener:Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    invoke-interface {v4, v2, v1}, Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;->onLoadError(Landroid/widget/ImageView;Ljava/lang/String;)V

    .line 229
    :cond_0
    :goto_0
    return v3

    .line 211
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->getImageUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 212
    if-eqz p1, :cond_3

    .line 213
    invoke-virtual {p0}, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->getImageView()Landroid/widget/ImageView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ImageView;->getContext()Landroid/content/Context;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$anim;->image_fade_in:I

    invoke-static {v3, v4}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 214
    .local v0, "anim":Landroid/view/animation/Animation;
    invoke-virtual {v2, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 215
    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 217
    iget-object v3, p0, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->onLoadListener:Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    if-eqz v3, :cond_2

    .line 218
    iget-object v3, p0, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->onLoadListener:Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    invoke-interface {v3, v2, v1, p1}, Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;->onLoad(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 225
    .end local v0    # "anim":Landroid/view/animation/Animation;
    :cond_2
    :goto_1
    iget-object v3, p0, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->this$0:Lcom/comcast/cim/android/image/CimImageLoader;

    # getter for: Lcom/comcast/cim/android/image/CimImageLoader;->imageLoader:Lcom/github/ignition/support/images/remote/RemoteImageLoader;
    invoke-static {v3}, Lcom/comcast/cim/android/image/CimImageLoader;->access$300(Lcom/comcast/cim/android/image/CimImageLoader;)Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->cancelLoad(Landroid/widget/ImageView;)V

    .line 227
    const/4 v3, 0x1

    goto :goto_0

    .line 220
    :cond_3
    invoke-virtual {p0}, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->getErrorDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 221
    invoke-virtual {p0}, Lcom/comcast/cim/android/image/CimImageLoader$CimImageLoaderHandler;->getErrorDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1
.end method
