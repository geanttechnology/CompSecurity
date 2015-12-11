.class Lcom/aio/downloader/views/TouchImageView$GestureListener;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "TouchImageView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "GestureListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/TouchImageView;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/views/TouchImageView;)V
    .locals 0

    .prologue
    .line 751
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$GestureListener;)V
    .locals 0

    .prologue
    .line 751
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/TouchImageView$GestureListener;-><init>(Lcom/aio/downloader/views/TouchImageView;)V

    return-void
.end method


# virtual methods
.method public onDoubleTap(Landroid/view/MotionEvent;)Z
    .locals 7
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 785
    const/4 v6, 0x0

    .line 786
    .local v6, "consumed":Z
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$0(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 787
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$0(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v1

    invoke-interface {v1, p1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTap(Landroid/view/MotionEvent;)Z

    move-result v6

    .line 789
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->state:Lcom/aio/downloader/views/TouchImageView$State;
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$4(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$State;

    move-result-object v1

    sget-object v3, Lcom/aio/downloader/views/TouchImageView$State;->NONE:Lcom/aio/downloader/views/TouchImageView$State;

    if-ne v1, v3, :cond_1

    .line 790
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$5(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v1

    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->minScale:F
    invoke-static {v3}, Lcom/aio/downloader/views/TouchImageView;->access$6(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v3

    cmpl-float v1, v1, v3

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->maxScale:F
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$7(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v2

    .line 791
    .local v2, "targetZoom":F
    :goto_0
    new-instance v0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;

    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;-><init>(Lcom/aio/downloader/views/TouchImageView;FFFZ)V

    .line 792
    .local v0, "doubleTap":Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->compatPostOnAnimation(Ljava/lang/Runnable;)V
    invoke-static {v1, v0}, Lcom/aio/downloader/views/TouchImageView;->access$3(Lcom/aio/downloader/views/TouchImageView;Ljava/lang/Runnable;)V

    .line 793
    const/4 v6, 0x1

    .line 795
    .end local v0    # "doubleTap":Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;
    .end local v2    # "targetZoom":F
    :cond_1
    return v6

    .line 790
    :cond_2
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->minScale:F
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$6(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v2

    goto :goto_0
.end method

.method public onDoubleTapEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 800
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;
    invoke-static {v0}, Lcom/aio/downloader/views/TouchImageView;->access$0(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 801
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;
    invoke-static {v0}, Lcom/aio/downloader/views/TouchImageView;->access$0(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTapEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 803
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 5
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "velocityX"    # F
    .param p4, "velocityY"    # F

    .prologue
    .line 771
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->fling:Lcom/aio/downloader/views/TouchImageView$Fling;
    invoke-static {v0}, Lcom/aio/downloader/views/TouchImageView;->access$1(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$Fling;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 776
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->fling:Lcom/aio/downloader/views/TouchImageView$Fling;
    invoke-static {v0}, Lcom/aio/downloader/views/TouchImageView;->access$1(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$Fling;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/views/TouchImageView$Fling;->cancelFling()V

    .line 778
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    new-instance v1, Lcom/aio/downloader/views/TouchImageView$Fling;

    iget-object v2, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    float-to-int v3, p3

    float-to-int v4, p4

    invoke-direct {v1, v2, v3, v4}, Lcom/aio/downloader/views/TouchImageView$Fling;-><init>(Lcom/aio/downloader/views/TouchImageView;II)V

    invoke-static {v0, v1}, Lcom/aio/downloader/views/TouchImageView;->access$2(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$Fling;)V

    .line 779
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->fling:Lcom/aio/downloader/views/TouchImageView$Fling;
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$1(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$Fling;

    move-result-object v1

    # invokes: Lcom/aio/downloader/views/TouchImageView;->compatPostOnAnimation(Ljava/lang/Runnable;)V
    invoke-static {v0, v1}, Lcom/aio/downloader/views/TouchImageView;->access$3(Lcom/aio/downloader/views/TouchImageView;Ljava/lang/Runnable;)V

    .line 780
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result v0

    return v0
.end method

.method public onLongPress(Landroid/view/MotionEvent;)V
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 765
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/TouchImageView;->performLongClick()Z

    .line 766
    return-void
.end method

.method public onSingleTapConfirmed(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 756
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;
    invoke-static {v0}, Lcom/aio/downloader/views/TouchImageView;->access$0(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 757
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->doubleTapListener:Landroid/view/GestureDetector$OnDoubleTapListener;
    invoke-static {v0}, Lcom/aio/downloader/views/TouchImageView;->access$0(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onSingleTapConfirmed(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 759
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$GestureListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/TouchImageView;->performClick()Z

    move-result v0

    goto :goto_0
.end method
