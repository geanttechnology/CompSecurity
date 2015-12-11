.class Lco/vine/android/AbstractRecordingActivity$4;
.super Ljava/lang/Object;
.source "AbstractRecordingActivity.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/AbstractRecordingActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field hasMovedOut:Z

.field final synthetic this$0:Lco/vine/android/AbstractRecordingActivity;


# direct methods
.method constructor <init>(Lco/vine/android/AbstractRecordingActivity;)V
    .locals 1

    .prologue
    .line 388
    iput-object p1, p0, Lco/vine/android/AbstractRecordingActivity$4;->this$0:Lco/vine/android/AbstractRecordingActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 389
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/AbstractRecordingActivity$4;->hasMovedOut:Z

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 7
    .param p1, "view"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v6, 0x0

    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 393
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 415
    :cond_0
    :goto_0
    return v5

    .line 395
    :pswitch_0
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity$4;->this$0:Lco/vine/android/AbstractRecordingActivity;

    iget v3, v3, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity$4;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;
    invoke-static {v6}, Lco/vine/android/AbstractRecordingActivity;->access$000(Lco/vine/android/AbstractRecordingActivity;)Landroid/util/SparseArray;

    move-result-object v6

    invoke-virtual {v6}, Landroid/util/SparseArray;->size()I

    move-result v6

    if-eq v3, v6, :cond_0

    .line 396
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity$4;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mDraftTrashBackground:Landroid/view/View;
    invoke-static {v3}, Lco/vine/android/AbstractRecordingActivity;->access$200(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v4}, Landroid/view/View;->setActivated(Z)V

    .line 397
    iput-boolean v5, p0, Lco/vine/android/AbstractRecordingActivity$4;->hasMovedOut:Z

    goto :goto_0

    .line 401
    :pswitch_1
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity$4;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mDraftTrashBackground:Landroid/view/View;
    invoke-static {v3}, Lco/vine/android/AbstractRecordingActivity;->access$200(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/view/View;->setActivated(Z)V

    goto :goto_0

    .line 404
    :pswitch_2
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    .line 405
    .local v1, "x":F
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    .line 406
    .local v2, "y":F
    cmpl-float v3, v1, v6

    if-ltz v3, :cond_2

    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity$4;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;
    invoke-static {v3}, Lco/vine/android/AbstractRecordingActivity;->access$300(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v3

    int-to-float v3, v3

    cmpg-float v3, v1, v3

    if-gtz v3, :cond_2

    cmpl-float v3, v2, v6

    if-ltz v3, :cond_2

    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity$4;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;
    invoke-static {v3}, Lco/vine/android/AbstractRecordingActivity;->access$300(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getHeight()I

    move-result v3

    int-to-float v3, v3

    cmpg-float v3, v2, v3

    if-gtz v3, :cond_2

    move v0, v4

    .line 408
    .local v0, "activate":Z
    :goto_1
    if-nez v0, :cond_1

    .line 409
    iput-boolean v4, p0, Lco/vine/android/AbstractRecordingActivity$4;->hasMovedOut:Z

    .line 411
    :cond_1
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity$4;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mDraftTrashBackground:Landroid/view/View;
    invoke-static {v3}, Lco/vine/android/AbstractRecordingActivity;->access$200(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;

    move-result-object v6

    if-eqz v0, :cond_3

    iget-boolean v3, p0, Lco/vine/android/AbstractRecordingActivity$4;->hasMovedOut:Z

    if-nez v3, :cond_3

    move v3, v4

    :goto_2
    invoke-virtual {v6, v3}, Landroid/view/View;->setActivated(Z)V

    .line 412
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity$4;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;
    invoke-static {v3}, Lco/vine/android/AbstractRecordingActivity;->access$300(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;

    move-result-object v3

    if-eqz v0, :cond_4

    iget-boolean v6, p0, Lco/vine/android/AbstractRecordingActivity$4;->hasMovedOut:Z

    if-nez v6, :cond_4

    :goto_3
    invoke-virtual {v3, v4}, Landroid/view/View;->setActivated(Z)V

    goto :goto_0

    .end local v0    # "activate":Z
    :cond_2
    move v0, v5

    .line 406
    goto :goto_1

    .restart local v0    # "activate":Z
    :cond_3
    move v3, v5

    .line 411
    goto :goto_2

    :cond_4
    move v4, v5

    .line 412
    goto :goto_3

    .line 393
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
