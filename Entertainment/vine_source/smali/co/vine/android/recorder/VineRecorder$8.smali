.class Lco/vine/android/recorder/VineRecorder$8;
.super Ljava/lang/Object;
.source "VineRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/VineRecorder;->updateGhostBitmap(Landroid/graphics/Bitmap;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/VineRecorder;

.field final synthetic val$ghostBitmap:Landroid/graphics/Bitmap;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/VineRecorder;Landroid/graphics/Bitmap;)V
    .locals 0

    .prologue
    .line 456
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$8;->this$0:Lco/vine/android/recorder/VineRecorder;

    iput-object p2, p0, Lco/vine/android/recorder/VineRecorder$8;->val$ghostBitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/16 v1, 0x8

    .line 459
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$8;->val$ghostBitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_1

    .line 460
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$8;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1400(Lco/vine/android/recorder/VineRecorder;)Landroid/widget/ImageView;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 461
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$8;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1400(Lco/vine/android/recorder/VineRecorder;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 475
    :cond_0
    :goto_0
    return-void

    .line 464
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$8;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mResources:Landroid/content/res/Resources;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$300(Lco/vine/android/recorder/VineRecorder;)Landroid/content/res/Resources;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$8;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1400(Lco/vine/android/recorder/VineRecorder;)Landroid/widget/ImageView;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 465
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$8;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_2

    .line 466
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$8;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1400(Lco/vine/android/recorder/VineRecorder;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 468
    :cond_2
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$8;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1400(Lco/vine/android/recorder/VineRecorder;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_3

    .line 469
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$8;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1400(Lco/vine/android/recorder/VineRecorder;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 471
    :cond_3
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$8;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1400(Lco/vine/android/recorder/VineRecorder;)Landroid/widget/ImageView;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder$8;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mResources:Landroid/content/res/Resources;
    invoke-static {v2}, Lco/vine/android/recorder/VineRecorder;->access$300(Lco/vine/android/recorder/VineRecorder;)Landroid/content/res/Resources;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder$8;->val$ghostBitmap:Landroid/graphics/Bitmap;

    invoke-direct {v1, v2, v3}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method
