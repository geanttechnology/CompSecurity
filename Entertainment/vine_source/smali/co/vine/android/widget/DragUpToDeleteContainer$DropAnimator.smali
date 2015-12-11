.class Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;
.super Lco/vine/android/animation/SmoothAnimator;
.source "DragUpToDeleteContainer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/DragUpToDeleteContainer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DropAnimator"
.end annotation


# instance fields
.field private mDeltaX:F

.field private mDeltaY:F

.field private mTargetX:I

.field private mTargetY:I

.field final synthetic this$0:Lco/vine/android/widget/DragUpToDeleteContainer;


# direct methods
.method public constructor <init>(Lco/vine/android/widget/DragUpToDeleteContainer;FI)V
    .locals 0
    .param p2, "smoothness"    # F
    .param p3, "duration"    # I

    .prologue
    .line 243
    iput-object p1, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    .line 244
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/animation/SmoothAnimator;-><init>(Landroid/view/View;FI)V

    .line 245
    return-void
.end method


# virtual methods
.method public onStart()V
    .locals 2

    .prologue
    .line 249
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    const/4 v1, 0x1

    # setter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDropping:Z
    invoke-static {v0, v1}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$602(Lco/vine/android/widget/DragUpToDeleteContainer;Z)Z

    .line 250
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragView:Landroid/widget/ImageView;
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$700(Lco/vine/android/widget/DragUpToDeleteContainer;)Landroid/widget/ImageView;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 251
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDownY:F
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$800(Lco/vine/android/widget/DragUpToDeleteContainer;)F

    move-result v0

    iget-object v1, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mYOffsetFromTouch:F
    invoke-static {v1}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$900(Lco/vine/android/widget/DragUpToDeleteContainer;)F

    move-result v1

    sub-float/2addr v0, v1

    float-to-int v0, v0

    iput v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->mTargetY:I

    .line 253
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragViewX:I
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$1000(Lco/vine/android/widget/DragUpToDeleteContainer;)I

    move-result v0

    iput v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->mTargetX:I

    .line 254
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragViewX:I
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$1000(Lco/vine/android/widget/DragUpToDeleteContainer;)I

    move-result v0

    iget v1, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->mTargetX:I

    sub-int/2addr v0, v1

    int-to-float v0, v0

    iput v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->mDeltaX:F

    .line 255
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragViewY:I
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$000(Lco/vine/android/widget/DragUpToDeleteContainer;)I

    move-result v0

    iget v1, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->mTargetY:I

    sub-int/2addr v0, v1

    int-to-float v0, v0

    iput v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->mDeltaY:F

    .line 256
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 269
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragUpListener:Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$500(Lco/vine/android/widget/DragUpToDeleteContainer;)Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 270
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragUpListener:Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$500(Lco/vine/android/widget/DragUpToDeleteContainer;)Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;

    move-result-object v0

    invoke-interface {v0}, Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;->viewLanded()V

    .line 272
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # invokes: Lco/vine/android/widget/DragUpToDeleteContainer;->destroyDragView()V
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$400(Lco/vine/android/widget/DragUpToDeleteContainer;)V

    .line 273
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    invoke-virtual {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->invalidate()V

    .line 274
    return-void
.end method

.method public onUpdate(FF)V
    .locals 4
    .param p1, "frac"    # F
    .param p2, "smoothFrac"    # F

    .prologue
    .line 261
    const/high16 v1, 0x3f800000    # 1.0f

    sub-float v0, v1, p2

    .line 262
    .local v0, "f":F
    iget-object v1, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    iget v2, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->mTargetX:I

    iget v3, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->mDeltaX:F

    mul-float/2addr v3, v0

    float-to-int v3, v3

    add-int/2addr v2, v3

    # setter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragViewX:I
    invoke-static {v1, v2}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$1002(Lco/vine/android/widget/DragUpToDeleteContainer;I)I

    .line 263
    iget-object v1, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    iget v2, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->mTargetY:I

    iget v3, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->mDeltaY:F

    mul-float/2addr v3, v0

    float-to-int v3, v3

    add-int/2addr v2, v3

    # setter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragViewY:I
    invoke-static {v1, v2}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$002(Lco/vine/android/widget/DragUpToDeleteContainer;I)I

    .line 264
    iget-object v1, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DropAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    invoke-virtual {v1}, Lco/vine/android/widget/DragUpToDeleteContainer;->invalidate()V

    .line 265
    return-void
.end method
