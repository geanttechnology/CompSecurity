.class Lcom/comcast/cim/android/image/CimImageLoader$1;
.super Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;
.source "CimImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/image/CimImageLoader;->preloadImage(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/image/CimImageLoader;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/image/CimImageLoader;Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/image/CimImageLoader;
    .param p2, "x0"    # Landroid/widget/ImageView;
    .param p3, "x1"    # Ljava/lang/String;
    .param p4, "x2"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 64
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader$1;, "Lcom/comcast/cim/android/image/CimImageLoader$1;"
    iput-object p1, p0, Lcom/comcast/cim/android/image/CimImageLoader$1;->this$0:Lcom/comcast/cim/android/image/CimImageLoader;

    invoke-direct {p0, p2, p3, p4}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;-><init>(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V

    return-void
.end method


# virtual methods
.method protected handleImageLoaded(Landroid/graphics/Bitmap;Landroid/os/Message;)Z
    .locals 2
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .param p2, "msg"    # Landroid/os/Message;

    .prologue
    .line 68
    .local p0, "this":Lcom/comcast/cim/android/image/CimImageLoader$1;, "Lcom/comcast/cim/android/image/CimImageLoader$1;"
    if-nez p1, :cond_0

    .line 69
    iget-object v0, p0, Lcom/comcast/cim/android/image/CimImageLoader$1;->this$0:Lcom/comcast/cim/android/image/CimImageLoader;

    # getter for: Lcom/comcast/cim/android/image/CimImageLoader;->badUrlCache:Lcom/comcast/cim/android/image/BadUrlCache;
    invoke-static {v0}, Lcom/comcast/cim/android/image/CimImageLoader;->access$000(Lcom/comcast/cim/android/image/CimImageLoader;)Lcom/comcast/cim/android/image/BadUrlCache;

    move-result-object v0

    invoke-virtual {p0}, Lcom/comcast/cim/android/image/CimImageLoader$1;->getImageUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/image/BadUrlCache;->setBadUrl(Ljava/lang/String;)V

    .line 72
    :cond_0
    const/4 v0, 0x0

    return v0
.end method
