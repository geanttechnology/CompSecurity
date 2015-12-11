.class Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;
.super Lco/vine/android/animation/SmoothAnimator;
.source "DragUpToDeleteContainer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/DragUpToDeleteContainer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DragViewDestroyAnimator"
.end annotation


# instance fields
.field private mDeltaY:I

.field private mStartY:I

.field final synthetic this$0:Lco/vine/android/widget/DragUpToDeleteContainer;


# direct methods
.method public constructor <init>(Lco/vine/android/widget/DragUpToDeleteContainer;FI)V
    .locals 0
    .param p2, "smoothness"    # F
    .param p3, "duration"    # I

    .prologue
    .line 206
    iput-object p1, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    .line 207
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/animation/SmoothAnimator;-><init>(Landroid/view/View;FI)V

    .line 208
    return-void
.end method


# virtual methods
.method public onStart()V
    .locals 2

    .prologue
    .line 211
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragViewY:I
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$000(Lco/vine/android/widget/DragUpToDeleteContainer;)I

    move-result v0

    iput v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->mStartY:I

    .line 212
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragViewY:I
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$000(Lco/vine/android/widget/DragUpToDeleteContainer;)I

    move-result v0

    iget-object v1, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragViewHeight:I
    invoke-static {v1}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$100(Lco/vine/android/widget/DragUpToDeleteContainer;)I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->mDeltaY:I

    .line 213
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    const/4 v1, 0x1

    # setter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDestroying:Z
    invoke-static {v0, v1}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$202(Lco/vine/android/widget/DragUpToDeleteContainer;Z)Z

    .line 214
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 223
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    const/4 v1, 0x0

    # setter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragViewAlpha:F
    invoke-static {v0, v1}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$302(Lco/vine/android/widget/DragUpToDeleteContainer;F)F

    .line 224
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    const/4 v1, 0x0

    # setter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDestroying:Z
    invoke-static {v0, v1}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$202(Lco/vine/android/widget/DragUpToDeleteContainer;Z)Z

    .line 225
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # invokes: Lco/vine/android/widget/DragUpToDeleteContainer;->destroyDragView()V
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$400(Lco/vine/android/widget/DragUpToDeleteContainer;)V

    .line 226
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragUpListener:Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$500(Lco/vine/android/widget/DragUpToDeleteContainer;)Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 227
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    # getter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragUpListener:Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;
    invoke-static {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$500(Lco/vine/android/widget/DragUpToDeleteContainer;)Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;

    move-result-object v0

    invoke-interface {v0}, Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;->viewDestroyFinished()V

    .line 229
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    invoke-virtual {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->invalidate()V

    .line 230
    return-void
.end method

.method public onUpdate(FF)V
    .locals 3
    .param p1, "frac"    # F
    .param p2, "smoothFrac"    # F

    .prologue
    .line 217
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    iget v1, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->mStartY:I

    int-to-float v1, v1

    iget v2, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->mDeltaY:I

    int-to-float v2, v2

    mul-float/2addr v2, p2

    sub-float/2addr v1, v2

    float-to-int v1, v1

    # setter for: Lco/vine/android/widget/DragUpToDeleteContainer;->mDragViewY:I
    invoke-static {v0, v1}, Lco/vine/android/widget/DragUpToDeleteContainer;->access$002(Lco/vine/android/widget/DragUpToDeleteContainer;I)I

    .line 218
    iget-object v0, p0, Lco/vine/android/widget/DragUpToDeleteContainer$DragViewDestroyAnimator;->this$0:Lco/vine/android/widget/DragUpToDeleteContainer;

    invoke-virtual {v0}, Lco/vine/android/widget/DragUpToDeleteContainer;->invalidate()V

    .line 219
    return-void
.end method
