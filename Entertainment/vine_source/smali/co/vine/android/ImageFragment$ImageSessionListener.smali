.class Lco/vine/android/ImageFragment$ImageSessionListener;
.super Lco/vine/android/client/AppSessionListener;
.source "ImageFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ImageFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ImageSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ImageFragment;


# direct methods
.method private constructor <init>(Lco/vine/android/ImageFragment;)V
    .locals 0

    .prologue
    .line 110
    iput-object p1, p0, Lco/vine/android/ImageFragment$ImageSessionListener;->this$0:Lco/vine/android/ImageFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/ImageFragment;Lco/vine/android/ImageFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/ImageFragment;
    .param p2, "x1"    # Lco/vine/android/ImageFragment$1;

    .prologue
    .line 110
    invoke-direct {p0, p1}, Lco/vine/android/ImageFragment$ImageSessionListener;-><init>(Lco/vine/android/ImageFragment;)V

    return-void
.end method

.method private finishFailed()V
    .locals 2

    .prologue
    .line 128
    iget-object v0, p0, Lco/vine/android/ImageFragment$ImageSessionListener;->this$0:Lco/vine/android/ImageFragment;

    # getter for: Lco/vine/android/ImageFragment;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lco/vine/android/ImageFragment;->access$400(Lco/vine/android/ImageFragment;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lco/vine/android/ImageFragment$ImageSessionListener$1;

    invoke-direct {v1, p0}, Lco/vine/android/ImageFragment$ImageSessionListener$1;-><init>(Lco/vine/android/ImageFragment$ImageSessionListener;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 135
    return-void
.end method


# virtual methods
.method public onPhotoImageError(Lco/vine/android/util/image/ImageKey;Lco/vine/android/network/HttpResult;)V
    .locals 1
    .param p1, "key"    # Lco/vine/android/util/image/ImageKey;
    .param p2, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 122
    iget-object v0, p0, Lco/vine/android/ImageFragment$ImageSessionListener;->this$0:Lco/vine/android/ImageFragment;

    # getter for: Lco/vine/android/ImageFragment;->mImageKey:Lco/vine/android/util/image/ImageKey;
    invoke-static {v0}, Lco/vine/android/ImageFragment;->access$100(Lco/vine/android/ImageFragment;)Lco/vine/android/util/image/ImageKey;

    move-result-object v0

    invoke-virtual {p1, v0}, Lco/vine/android/util/image/ImageKey;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 123
    invoke-direct {p0}, Lco/vine/android/ImageFragment$ImageSessionListener;->finishFailed()V

    .line 125
    :cond_0
    return-void
.end method

.method public onPhotoImageLoaded(Ljava/util/HashMap;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 113
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v1, p0, Lco/vine/android/ImageFragment$ImageSessionListener;->this$0:Lco/vine/android/ImageFragment;

    # getter for: Lco/vine/android/ImageFragment;->mImageKey:Lco/vine/android/util/image/ImageKey;
    invoke-static {v1}, Lco/vine/android/ImageFragment;->access$100(Lco/vine/android/ImageFragment;)Lco/vine/android/util/image/ImageKey;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/image/UrlImage;

    .line 114
    .local v0, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 115
    iget-object v1, p0, Lco/vine/android/ImageFragment$ImageSessionListener;->this$0:Lco/vine/android/ImageFragment;

    # getter for: Lco/vine/android/ImageFragment;->mProgress:Landroid/widget/ProgressBar;
    invoke-static {v1}, Lco/vine/android/ImageFragment;->access$200(Lco/vine/android/ImageFragment;)Landroid/widget/ProgressBar;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 116
    iget-object v1, p0, Lco/vine/android/ImageFragment$ImageSessionListener;->this$0:Lco/vine/android/ImageFragment;

    # getter for: Lco/vine/android/ImageFragment;->mImageView:Landroid/widget/ImageView;
    invoke-static {v1}, Lco/vine/android/ImageFragment;->access$300(Lco/vine/android/ImageFragment;)Landroid/widget/ImageView;

    move-result-object v1

    new-instance v2, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v3, p0, Lco/vine/android/ImageFragment$ImageSessionListener;->this$0:Lco/vine/android/ImageFragment;

    # getter for: Lco/vine/android/ImageFragment;->mImageView:Landroid/widget/ImageView;
    invoke-static {v3}, Lco/vine/android/ImageFragment;->access$300(Lco/vine/android/ImageFragment;)Landroid/widget/ImageView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    iget-object v4, v0, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {v2, v3, v4}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 118
    :cond_0
    return-void
.end method
