.class Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;
.super Ljava/lang/Object;
.source "TouchImageView.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PrivateOnTouchListener"
.end annotation


# instance fields
.field private last:Landroid/graphics/PointF;

.field final synthetic this$0:Lcom/aio/downloader/views/TouchImageView;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/views/TouchImageView;)V
    .locals 1

    .prologue
    .line 817
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 822
    new-instance v0, Landroid/graphics/PointF;

    invoke-direct {v0}, Landroid/graphics/PointF;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->last:Landroid/graphics/PointF;

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;)V
    .locals 0

    .prologue
    .line 817
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;-><init>(Lcom/aio/downloader/views/TouchImageView;)V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 8
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 826
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->mScaleDetector:Landroid/view/ScaleGestureDetector;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$8(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/ScaleGestureDetector;

    move-result-object v5

    invoke-virtual {v5, p2}, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 827
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->mGestureDetector:Landroid/view/GestureDetector;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$9(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/GestureDetector;

    move-result-object v5

    invoke-virtual {v5, p2}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 828
    new-instance v0, Landroid/graphics/PointF;

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v6

    invoke-direct {v0, v5, v6}, Landroid/graphics/PointF;-><init>(FF)V

    .line 830
    .local v0, "curr":Landroid/graphics/PointF;
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->state:Lcom/aio/downloader/views/TouchImageView$State;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$4(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$State;

    move-result-object v5

    sget-object v6, Lcom/aio/downloader/views/TouchImageView$State;->NONE:Lcom/aio/downloader/views/TouchImageView$State;

    if-eq v5, v6, :cond_0

    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->state:Lcom/aio/downloader/views/TouchImageView$State;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$4(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$State;

    move-result-object v5

    sget-object v6, Lcom/aio/downloader/views/TouchImageView$State;->DRAG:Lcom/aio/downloader/views/TouchImageView$State;

    if-eq v5, v6, :cond_0

    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->state:Lcom/aio/downloader/views/TouchImageView$State;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$4(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$State;

    move-result-object v5

    sget-object v6, Lcom/aio/downloader/views/TouchImageView$State;->FLING:Lcom/aio/downloader/views/TouchImageView$State;

    if-ne v5, v6, :cond_1

    .line 831
    :cond_0
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v5

    packed-switch v5, :pswitch_data_0

    .line 858
    :cond_1
    :goto_0
    :pswitch_0
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    iget-object v6, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;
    invoke-static {v6}, Lcom/aio/downloader/views/TouchImageView;->access$16(Lcom/aio/downloader/views/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/aio/downloader/views/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 863
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->userTouchListener:Landroid/view/View$OnTouchListener;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$18(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/View$OnTouchListener;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 864
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->userTouchListener:Landroid/view/View$OnTouchListener;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$18(Lcom/aio/downloader/views/TouchImageView;)Landroid/view/View$OnTouchListener;

    move-result-object v5

    invoke-interface {v5, p1, p2}, Landroid/view/View$OnTouchListener;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z

    .line 870
    :cond_2
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$19(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 871
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$19(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    move-result-object v5

    invoke-interface {v5}, Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;->onMove()V

    .line 877
    :cond_3
    const/4 v5, 0x1

    return v5

    .line 833
    :pswitch_1
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->last:Landroid/graphics/PointF;

    invoke-virtual {v5, v0}, Landroid/graphics/PointF;->set(Landroid/graphics/PointF;)V

    .line 834
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->fling:Lcom/aio/downloader/views/TouchImageView$Fling;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$1(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$Fling;

    move-result-object v5

    if-eqz v5, :cond_4

    .line 835
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->fling:Lcom/aio/downloader/views/TouchImageView$Fling;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$1(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$Fling;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/views/TouchImageView$Fling;->cancelFling()V

    .line 836
    :cond_4
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    sget-object v6, Lcom/aio/downloader/views/TouchImageView$State;->DRAG:Lcom/aio/downloader/views/TouchImageView$State;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->setState(Lcom/aio/downloader/views/TouchImageView$State;)V
    invoke-static {v5, v6}, Lcom/aio/downloader/views/TouchImageView;->access$10(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$State;)V

    goto :goto_0

    .line 840
    :pswitch_2
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->state:Lcom/aio/downloader/views/TouchImageView$State;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$4(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$State;

    move-result-object v5

    sget-object v6, Lcom/aio/downloader/views/TouchImageView$State;->DRAG:Lcom/aio/downloader/views/TouchImageView$State;

    if-ne v5, v6, :cond_1

    .line 841
    iget v5, v0, Landroid/graphics/PointF;->x:F

    iget-object v6, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->last:Landroid/graphics/PointF;

    iget v6, v6, Landroid/graphics/PointF;->x:F

    sub-float v1, v5, v6

    .line 842
    .local v1, "deltaX":F
    iget v5, v0, Landroid/graphics/PointF;->y:F

    iget-object v6, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->last:Landroid/graphics/PointF;

    iget v6, v6, Landroid/graphics/PointF;->y:F

    sub-float v2, v5, v6

    .line 843
    .local v2, "deltaY":F
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    iget-object v6, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->viewWidth:I
    invoke-static {v6}, Lcom/aio/downloader/views/TouchImageView;->access$11(Lcom/aio/downloader/views/TouchImageView;)I

    move-result v6

    int-to-float v6, v6

    iget-object v7, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F
    invoke-static {v7}, Lcom/aio/downloader/views/TouchImageView;->access$12(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v7

    # invokes: Lcom/aio/downloader/views/TouchImageView;->getFixDragTrans(FFF)F
    invoke-static {v5, v1, v6, v7}, Lcom/aio/downloader/views/TouchImageView;->access$13(Lcom/aio/downloader/views/TouchImageView;FFF)F

    move-result v3

    .line 844
    .local v3, "fixTransX":F
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    iget-object v6, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->viewHeight:I
    invoke-static {v6}, Lcom/aio/downloader/views/TouchImageView;->access$14(Lcom/aio/downloader/views/TouchImageView;)I

    move-result v6

    int-to-float v6, v6

    iget-object v7, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->getImageHeight()F
    invoke-static {v7}, Lcom/aio/downloader/views/TouchImageView;->access$15(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v7

    # invokes: Lcom/aio/downloader/views/TouchImageView;->getFixDragTrans(FFF)F
    invoke-static {v5, v2, v6, v7}, Lcom/aio/downloader/views/TouchImageView;->access$13(Lcom/aio/downloader/views/TouchImageView;FFF)F

    move-result v4

    .line 845
    .local v4, "fixTransY":F
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$16(Lcom/aio/downloader/views/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v5

    invoke-virtual {v5, v3, v4}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 846
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->fixTrans()V
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$17(Lcom/aio/downloader/views/TouchImageView;)V

    .line 847
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->last:Landroid/graphics/PointF;

    iget v6, v0, Landroid/graphics/PointF;->x:F

    iget v7, v0, Landroid/graphics/PointF;->y:F

    invoke-virtual {v5, v6, v7}, Landroid/graphics/PointF;->set(FF)V

    goto/16 :goto_0

    .line 853
    .end local v1    # "deltaX":F
    .end local v2    # "deltaY":F
    .end local v3    # "fixTransX":F
    .end local v4    # "fixTransY":F
    :pswitch_3
    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$PrivateOnTouchListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    sget-object v6, Lcom/aio/downloader/views/TouchImageView$State;->NONE:Lcom/aio/downloader/views/TouchImageView$State;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->setState(Lcom/aio/downloader/views/TouchImageView$State;)V
    invoke-static {v5, v6}, Lcom/aio/downloader/views/TouchImageView;->access$10(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$State;)V

    goto/16 :goto_0

    .line 831
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method
