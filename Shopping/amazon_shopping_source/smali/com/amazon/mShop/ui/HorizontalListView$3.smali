.class Lcom/amazon/mShop/ui/HorizontalListView$3;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "HorizontalListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/ui/HorizontalListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/ui/HorizontalListView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/ui/HorizontalListView;)V
    .locals 0

    .prologue
    .line 481
    iput-object p1, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onDoubleTap(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 554
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # invokes: Lcom/amazon/mShop/ui/HorizontalListView;->setHighlightItemToNormalBackground()V
    invoke-static {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->access$400(Lcom/amazon/mShop/ui/HorizontalListView;)V

    .line 555
    const/4 v0, 0x0

    return v0
.end method

.method public onDown(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 485
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/ui/HorizontalListView;->onDown(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 1
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "velocityX"    # F
    .param p4, "velocityY"    # F

    .prologue
    .line 510
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # invokes: Lcom/amazon/mShop/ui/HorizontalListView;->setHighlightItemToNormalBackground()V
    invoke-static {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->access$400(Lcom/amazon/mShop/ui/HorizontalListView;)V

    .line 511
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/amazon/mShop/ui/HorizontalListView;->onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result v0

    return v0
.end method

.method public onLongPress(Landroid/view/MotionEvent;)V
    .locals 8
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 560
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v6

    .line 561
    .local v6, "childCount":I
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    if-ge v7, v6, :cond_0

    .line 562
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 563
    .local v2, "child":Landroid/view/View;
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # invokes: Lcom/amazon/mShop/ui/HorizontalListView;->isEventWithinView(Landroid/view/MotionEvent;Landroid/view/View;)Z
    invoke-static {v0, p1, v2}, Lcom/amazon/mShop/ui/HorizontalListView;->access$500(Lcom/amazon/mShop/ui/HorizontalListView;Landroid/view/MotionEvent;Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 564
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemLongClicked:Landroid/widget/AdapterView$OnItemLongClickListener;
    invoke-static {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->access$900(Lcom/amazon/mShop/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemLongClickListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 565
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemLongClicked:Landroid/widget/AdapterView$OnItemLongClickListener;
    invoke-static {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->access$900(Lcom/amazon/mShop/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemLongClickListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    iget-object v3, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I
    invoke-static {v3}, Lcom/amazon/mShop/ui/HorizontalListView;->access$700(Lcom/amazon/mShop/ui/HorizontalListView;)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    add-int/2addr v3, v7

    iget-object v4, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    iget-object v4, v4, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v5, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I
    invoke-static {v5}, Lcom/amazon/mShop/ui/HorizontalListView;->access$700(Lcom/amazon/mShop/ui/HorizontalListView;)I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    add-int/2addr v5, v7

    invoke-interface {v4, v5}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v4

    invoke-interface/range {v0 .. v5}, Landroid/widget/AdapterView$OnItemLongClickListener;->onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z

    .line 571
    .end local v2    # "child":Landroid/view/View;
    :cond_0
    return-void

    .line 561
    .restart local v2    # "child":Landroid/view/View;
    :cond_1
    add-int/lit8 v7, v7, 0x1

    goto :goto_0
.end method

.method public onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 5
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "distanceX"    # F
    .param p4, "distanceY"    # F

    .prologue
    const/4 v4, 0x1

    .line 516
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # invokes: Lcom/amazon/mShop/ui/HorizontalListView;->setHighlightItemToNormalBackground()V
    invoke-static {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->access$400(Lcom/amazon/mShop/ui/HorizontalListView;)V

    .line 518
    iget-object v1, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    monitor-enter v1

    .line 519
    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    iget v2, v0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    float-to-int v3, p3

    add-int/2addr v2, v3

    iput v2, v0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    .line 520
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 522
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    invoke-interface {v0, v4}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 523
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->requestLayout()V

    .line 524
    return v4

    .line 520
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public onShowPress(Landroid/view/MotionEvent;)V
    .locals 2
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 490
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # invokes: Lcom/amazon/mShop/ui/HorizontalListView;->setFocusedItemToHightLightBackground(Landroid/view/MotionEvent;)V
    invoke-static {v0, p1}, Lcom/amazon/mShop/ui/HorizontalListView;->access$300(Lcom/amazon/mShop/ui/HorizontalListView;Landroid/view/MotionEvent;)V

    .line 492
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 493
    return-void
.end method

.method public onSingleTapConfirmed(Landroid/view/MotionEvent;)Z
    .locals 8
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 529
    const/4 v6, 0x0

    .line 530
    .local v6, "handled":Z
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v0

    if-ge v7, v0, :cond_0

    .line 531
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 532
    .local v2, "child":Landroid/view/View;
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # invokes: Lcom/amazon/mShop/ui/HorizontalListView;->isEventWithinView(Landroid/view/MotionEvent;Landroid/view/View;)Z
    invoke-static {v0, p1, v2}, Lcom/amazon/mShop/ui/HorizontalListView;->access$500(Lcom/amazon/mShop/ui/HorizontalListView;Landroid/view/MotionEvent;Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 533
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemClicked:Landroid/widget/AdapterView$OnItemClickListener;
    invoke-static {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->access$600(Lcom/amazon/mShop/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemClickListener;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 534
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemClicked:Landroid/widget/AdapterView$OnItemClickListener;
    invoke-static {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->access$600(Lcom/amazon/mShop/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemClickListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    iget-object v3, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I
    invoke-static {v3}, Lcom/amazon/mShop/ui/HorizontalListView;->access$700(Lcom/amazon/mShop/ui/HorizontalListView;)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    add-int/2addr v3, v7

    iget-object v4, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    iget-object v4, v4, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v5, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I
    invoke-static {v5}, Lcom/amazon/mShop/ui/HorizontalListView;->access$700(Lcom/amazon/mShop/ui/HorizontalListView;)I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    add-int/2addr v5, v7

    invoke-interface {v4, v5}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v4

    invoke-interface/range {v0 .. v5}, Landroid/widget/AdapterView$OnItemClickListener;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V

    .line 535
    const/4 v6, 0x1

    .line 549
    .end local v2    # "child":Landroid/view/View;
    :cond_0
    :goto_1
    return v6

    .line 538
    .restart local v2    # "child":Landroid/view/View;
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemSelected:Landroid/widget/AdapterView$OnItemSelectedListener;
    invoke-static {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->access$800(Lcom/amazon/mShop/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemSelectedListener;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 539
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemSelected:Landroid/widget/AdapterView$OnItemSelectedListener;
    invoke-static {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->access$800(Lcom/amazon/mShop/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemSelectedListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    iget-object v3, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I
    invoke-static {v3}, Lcom/amazon/mShop/ui/HorizontalListView;->access$700(Lcom/amazon/mShop/ui/HorizontalListView;)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    add-int/2addr v3, v7

    iget-object v4, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    iget-object v4, v4, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v5, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # getter for: Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I
    invoke-static {v5}, Lcom/amazon/mShop/ui/HorizontalListView;->access$700(Lcom/amazon/mShop/ui/HorizontalListView;)I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    add-int/2addr v5, v7

    invoke-interface {v4, v5}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v4

    invoke-interface/range {v0 .. v5}, Landroid/widget/AdapterView$OnItemSelectedListener;->onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V

    .line 540
    const/4 v6, 0x1

    .line 541
    goto :goto_1

    .line 544
    :cond_2
    invoke-virtual {v2}, Landroid/view/View;->performClick()Z

    move-result v6

    .line 545
    goto :goto_1

    .line 530
    :cond_3
    add-int/lit8 v7, v7, 0x1

    goto :goto_0
.end method

.method public onSingleTapUp(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 497
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # invokes: Lcom/amazon/mShop/ui/HorizontalListView;->setFocusedItemToHightLightBackground(Landroid/view/MotionEvent;)V
    invoke-static {v0, p1}, Lcom/amazon/mShop/ui/HorizontalListView;->access$300(Lcom/amazon/mShop/ui/HorizontalListView;Landroid/view/MotionEvent;)V

    .line 498
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    new-instance v1, Lcom/amazon/mShop/ui/HorizontalListView$3$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/ui/HorizontalListView$3$1;-><init>(Lcom/amazon/mShop/ui/HorizontalListView$3;)V

    const-wide/16 v2, 0x12c

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/mShop/ui/HorizontalListView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 505
    const/4 v0, 0x0

    return v0
.end method
