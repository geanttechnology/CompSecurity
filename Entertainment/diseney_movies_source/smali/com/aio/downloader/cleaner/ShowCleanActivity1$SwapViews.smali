.class final Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;
.super Ljava/lang/Object;
.source "ShowCleanActivity1.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "SwapViews"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V
    .locals 0

    .prologue
    .line 361
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;)V
    .locals 0

    .prologue
    .line 361
    invoke-direct {p0, p1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v2, 0x4

    const/4 v6, 0x0

    .line 364
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mImageView1:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$3(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/ImageView;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 365
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mImageView2:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$4(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/ImageView;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 366
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mIndex:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$5(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$6(Lcom/aio/downloader/cleaner/ShowCleanActivity1;I)V

    .line 367
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mIndex:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$5(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)I

    move-result v1

    rem-int/lit8 v1, v1, 0x2

    if-nez v1, :cond_0

    .line 368
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mImageView1:Landroid/widget/ImageView;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$3(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/ImageView;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$7(Lcom/aio/downloader/cleaner/ShowCleanActivity1;Landroid/widget/ImageView;)V

    .line 372
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mStartAnimView:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$8(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/ImageView;

    move-result-object v1

    invoke-virtual {v1, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 373
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mStartAnimView:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$8(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/ImageView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ImageView;->requestFocus()Z

    .line 374
    new-instance v0, Lcom/aio/downloader/views/Rotate3dAnimation;

    const/high16 v1, -0x3d4c0000    # -90.0f

    const/4 v2, 0x0

    .line 375
    iget-object v3, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mCenterX:F
    invoke-static {v3}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$9(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)F

    move-result v3

    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mCenterY:F
    invoke-static {v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$10(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)F

    move-result v4

    iget-object v5, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mDepthZ:F
    invoke-static {v5}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$11(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)F

    move-result v5

    .line 374
    invoke-direct/range {v0 .. v6}, Lcom/aio/downloader/views/Rotate3dAnimation;-><init>(FFFFFZ)V

    .line 376
    .local v0, "rotation":Lcom/aio/downloader/views/Rotate3dAnimation;
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mDuration:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$12(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)I

    move-result v1

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/views/Rotate3dAnimation;->setDuration(J)V

    .line 377
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/Rotate3dAnimation;->setFillAfter(Z)V

    .line 378
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/Rotate3dAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 379
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mStartAnimView:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$8(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/ImageView;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 380
    return-void

    .line 370
    .end local v0    # "rotation":Lcom/aio/downloader/views/Rotate3dAnimation;
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$SwapViews;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mImageView2:Landroid/widget/ImageView;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$4(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/ImageView;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$7(Lcom/aio/downloader/cleaner/ShowCleanActivity1;Landroid/widget/ImageView;)V

    goto :goto_0
.end method
