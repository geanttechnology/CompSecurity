.class Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;
.super Lcom/nineoldandroids/animation/AnimatorListenerAdapter;
.source "SwipeDismissListViewTouchListener.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->performDismiss(Landroid/view/View;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;


# direct methods
.method constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    .line 255
    invoke-direct {p0}, Lcom/nineoldandroids/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Lcom/nineoldandroids/animation/Animator;)V
    .locals 7
    .param p1, "animation"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 258
    iget-object v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDismissAnimationRefCount:I
    invoke-static {v4}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$1(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-static {v4, v5}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$2(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;I)V

    .line 259
    iget-object v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDismissAnimationRefCount:I
    invoke-static {v4}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$1(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)I

    move-result v4

    if-nez v4, :cond_0

    .line 262
    iget-object v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mPendingDismisses:Ljava/util/List;
    invoke-static {v4}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$3(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)Ljava/util/List;

    move-result-object v4

    invoke-static {v4}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 264
    iget-object v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mPendingDismisses:Ljava/util/List;
    invoke-static {v4}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$3(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    new-array v0, v4, [I

    .line 265
    .local v0, "dismissPositions":[I
    iget-object v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mPendingDismisses:Ljava/util/List;
    invoke-static {v4}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$3(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v1, v4, -0x1

    .local v1, "i":I
    :goto_0
    if-gez v1, :cond_1

    .line 268
    iget-object v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mCallback:Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
    invoke-static {v4}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$4(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;

    move-result-object v4

    iget-object v5, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mListView:Landroid/widget/ListView;
    invoke-static {v5}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$5(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)Landroid/widget/ListView;

    move-result-object v5

    invoke-interface {v4, v5, v0}, Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;->onDismiss(Landroid/widget/ListView;[I)V

    .line 271
    iget-object v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mPendingDismisses:Ljava/util/List;
    invoke-static {v4}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$3(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_2

    .line 280
    iget-object v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mPendingDismisses:Ljava/util/List;
    invoke-static {v4}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$3(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->clear()V

    .line 282
    .end local v0    # "dismissPositions":[I
    .end local v1    # "i":I
    :cond_0
    return-void

    .line 266
    .restart local v0    # "dismissPositions":[I
    .restart local v1    # "i":I
    :cond_1
    iget-object v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mPendingDismisses:Ljava/util/List;
    invoke-static {v4}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$3(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;

    iget v4, v4, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;->position:I

    aput v4, v0, v1

    .line 265
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 271
    :cond_2
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;

    .line 273
    .local v3, "pendingDismiss":Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;
    iget-object v5, v3, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;->view:Landroid/view/View;

    const/high16 v6, 0x3f800000    # 1.0f

    invoke-static {v5, v6}, Lcom/nineoldandroids/view/ViewHelper;->setAlpha(Landroid/view/View;F)V

    .line 274
    iget-object v5, v3, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;->view:Landroid/view/View;

    const/4 v6, 0x0

    invoke-static {v5, v6}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    .line 275
    iget-object v5, v3, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;->view:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 276
    .local v2, "lp":Landroid/view/ViewGroup$LayoutParams;
    const/4 v5, 0x0

    iput v5, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 277
    iget-object v5, v3, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;->view:Landroid/view/View;

    invoke-virtual {v5, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_1
.end method
