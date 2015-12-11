.class public Lco/vine/android/ImageFragment;
.super Lco/vine/android/BaseControllerFragment;
.source "ImageFragment.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ImageFragment$1;,
        Lco/vine/android/ImageFragment$ImageSessionListener;
    }
.end annotation


# static fields
.field public static final ARG_IMAGE_URL:Ljava/lang/String; = "image_url"

.field public static final STATE_IMAGE_BITMAP:Ljava/lang/String; = "state_image_bitmap"


# instance fields
.field private mFirstTouch:J

.field private final mHandler:Landroid/os/Handler;

.field private mImageBitmap:Landroid/graphics/Bitmap;

.field private mImageKey:Lco/vine/android/util/image/ImageKey;

.field private mImageView:Landroid/widget/ImageView;

.field private mProgress:Landroid/widget/ProgressBar;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 28
    invoke-direct {p0}, Lco/vine/android/BaseControllerFragment;-><init>()V

    .line 40
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lco/vine/android/ImageFragment;->mHandler:Landroid/os/Handler;

    .line 110
    return-void
.end method

.method static synthetic access$100(Lco/vine/android/ImageFragment;)Lco/vine/android/util/image/ImageKey;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ImageFragment;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/ImageFragment;->mImageKey:Lco/vine/android/util/image/ImageKey;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/ImageFragment;)Landroid/widget/ProgressBar;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ImageFragment;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/ImageFragment;->mProgress:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/ImageFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ImageFragment;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/ImageFragment;->mImageView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/ImageFragment;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ImageFragment;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/ImageFragment;->mHandler:Landroid/os/Handler;

    return-object v0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 58
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 60
    if-nez p1, :cond_2

    .line 61
    invoke-virtual {p0}, Lco/vine/android/ImageFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 62
    .local v0, "args":Landroid/os/Bundle;
    const-string v3, "image_url"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 64
    .local v2, "imageUrl":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 65
    new-instance v3, Lco/vine/android/util/image/ImageKey;

    invoke-direct {v3, v2}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;)V

    iput-object v3, p0, Lco/vine/android/ImageFragment;->mImageKey:Lco/vine/android/util/image/ImageKey;

    .line 66
    iget-object v3, p0, Lco/vine/android/ImageFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v4, p0, Lco/vine/android/ImageFragment;->mImageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {v3, v4}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 68
    .local v1, "imageBitmap":Landroid/graphics/Bitmap;
    if-eqz v1, :cond_1

    .line 69
    iput-object v1, p0, Lco/vine/android/ImageFragment;->mImageBitmap:Landroid/graphics/Bitmap;

    .line 74
    .end local v1    # "imageBitmap":Landroid/graphics/Bitmap;
    :cond_0
    :goto_0
    iget-object v3, p0, Lco/vine/android/ImageFragment;->mImageView:Landroid/widget/ImageView;

    invoke-virtual {v3, p0}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 78
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v2    # "imageUrl":Ljava/lang/String;
    :goto_1
    return-void

    .line 71
    .restart local v0    # "args":Landroid/os/Bundle;
    .restart local v1    # "imageBitmap":Landroid/graphics/Bitmap;
    .restart local v2    # "imageUrl":Ljava/lang/String;
    :cond_1
    iget-object v3, p0, Lco/vine/android/ImageFragment;->mProgress:Landroid/widget/ProgressBar;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_0

    .line 76
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v1    # "imageBitmap":Landroid/graphics/Bitmap;
    .end local v2    # "imageUrl":Ljava/lang/String;
    :cond_2
    const-string v3, "state_image_bitmap"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Landroid/graphics/Bitmap;

    iput-object v3, p0, Lco/vine/android/ImageFragment;->mImageBitmap:Landroid/graphics/Bitmap;

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 44
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onCreate(Landroid/os/Bundle;)V

    .line 45
    new-instance v0, Lco/vine/android/ImageFragment$ImageSessionListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lco/vine/android/ImageFragment$ImageSessionListener;-><init>(Lco/vine/android/ImageFragment;Lco/vine/android/ImageFragment$1;)V

    iput-object v0, p0, Lco/vine/android/ImageFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 46
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 50
    const v1, 0x7f030049

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 51
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0a0046

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lco/vine/android/ImageFragment;->mImageView:Landroid/widget/ImageView;

    .line 52
    const v1, 0x7f0a0030

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ProgressBar;

    iput-object v1, p0, Lco/vine/android/ImageFragment;->mProgress:Landroid/widget/ProgressBar;

    .line 53
    return-object v0
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 82
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onResume()V

    .line 83
    iget-object v0, p0, Lco/vine/android/ImageFragment;->mImageBitmap:Landroid/graphics/Bitmap;

    .line 84
    .local v0, "imageBitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 85
    iget-object v1, p0, Lco/vine/android/ImageFragment;->mImageView:Landroid/widget/ImageView;

    new-instance v2, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    invoke-virtual {p0}, Lco/vine/android/ImageFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 87
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 104
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 105
    iget-object v0, p0, Lco/vine/android/ImageFragment;->mImageBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 106
    const-string v0, "state_image_bitmap"

    iget-object v1, p0, Lco/vine/android/ImageFragment;->mImageBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 108
    :cond_0
    return-void
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 7
    .param p1, "view"    # Landroid/view/View;
    .param p2, "motionEvent"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v2, 0x1

    .line 91
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    if-eq v3, v2, :cond_0

    const/4 v2, 0x0

    .line 99
    :goto_0
    return v2

    .line 93
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 94
    .local v0, "now":J
    iget-wide v3, p0, Lco/vine/android/ImageFragment;->mFirstTouch:J

    sub-long v3, v0, v3

    const-wide/16 v5, 0x190

    cmp-long v3, v3, v5

    if-gez v3, :cond_1

    .line 95
    invoke-virtual {p0}, Lco/vine/android/ImageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_0

    .line 97
    :cond_1
    iput-wide v0, p0, Lco/vine/android/ImageFragment;->mFirstTouch:J

    goto :goto_0
.end method
