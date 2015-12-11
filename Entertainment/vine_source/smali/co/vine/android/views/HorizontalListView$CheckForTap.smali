.class final Lco/vine/android/views/HorizontalListView$CheckForTap;
.super Ljava/lang/Object;
.source "HorizontalListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/views/HorizontalListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "CheckForTap"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/views/HorizontalListView;


# direct methods
.method constructor <init>(Lco/vine/android/views/HorizontalListView;)V
    .locals 0

    .prologue
    .line 1268
    iput-object p1, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    .line 1270
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mTouchMode:I
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$000(Lco/vine/android/views/HorizontalListView;)I

    move-result v3

    if-nez v3, :cond_3

    .line 1271
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # setter for: Lco/vine/android/views/HorizontalListView;->mTouchMode:I
    invoke-static {v3, v6}, Lco/vine/android/views/HorizontalListView;->access$002(Lco/vine/android/views/HorizontalListView;I)I

    .line 1272
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    iget-object v4, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mMotionPosition:I
    invoke-static {v4}, Lco/vine/android/views/HorizontalListView;->access$200(Lco/vine/android/views/HorizontalListView;)I

    move-result v4

    iget-object v5, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I
    invoke-static {v5}, Lco/vine/android/views/HorizontalListView;->access$800(Lco/vine/android/views/HorizontalListView;)I

    move-result v5

    sub-int/2addr v4, v5

    invoke-virtual {v3, v4}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 1273
    .local v0, "child":Landroid/view/View;
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Landroid/view/View;->hasFocusable()Z

    move-result v3

    if-nez v3, :cond_3

    .line 1274
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mDataChanged:Z
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$100(Lco/vine/android/views/HorizontalListView;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 1275
    invoke-virtual {v0, v6}, Landroid/view/View;->setPressed(Z)V

    .line 1276
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v3, v6}, Lco/vine/android/views/HorizontalListView;->setPressed(Z)V

    .line 1277
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v3}, Lco/vine/android/views/HorizontalListView;->layoutChildren()V

    .line 1279
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v3}, Lco/vine/android/views/HorizontalListView;->refreshDrawableState()V

    .line 1281
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v3}, Lco/vine/android/views/HorizontalListView;->isLongClickable()Z

    move-result v2

    .line 1283
    .local v2, "longClickable":Z
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mSelector:Landroid/graphics/drawable/Drawable;
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$900(Lco/vine/android/views/HorizontalListView;)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 1284
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mSelector:Landroid/graphics/drawable/Drawable;
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$900(Lco/vine/android/views/HorizontalListView;)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 1285
    .local v1, "d":Landroid/graphics/drawable/Drawable;
    if-eqz v1, :cond_0

    instance-of v3, v1, Landroid/graphics/drawable/TransitionDrawable;

    if-eqz v3, :cond_0

    .line 1286
    if-eqz v2, :cond_4

    .line 1287
    check-cast v1, Landroid/graphics/drawable/TransitionDrawable;

    .end local v1    # "d":Landroid/graphics/drawable/Drawable;
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mLongPressMillis:I
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$1000(Lco/vine/android/views/HorizontalListView;)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/graphics/drawable/TransitionDrawable;->startTransition(I)V

    .line 1294
    :cond_0
    :goto_0
    if-eqz v2, :cond_5

    .line 1295
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mPendingCheckForLongPress:Lco/vine/android/views/HorizontalListView$CheckForLongPress;
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$1100(Lco/vine/android/views/HorizontalListView;)Lco/vine/android/views/HorizontalListView$CheckForLongPress;

    move-result-object v3

    if-nez v3, :cond_1

    .line 1296
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    new-instance v4, Lco/vine/android/views/HorizontalListView$CheckForLongPress;

    iget-object v5, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    const/4 v6, 0x0

    invoke-direct {v4, v5, v6}, Lco/vine/android/views/HorizontalListView$CheckForLongPress;-><init>(Lco/vine/android/views/HorizontalListView;Lco/vine/android/views/HorizontalListView$1;)V

    # setter for: Lco/vine/android/views/HorizontalListView;->mPendingCheckForLongPress:Lco/vine/android/views/HorizontalListView$CheckForLongPress;
    invoke-static {v3, v4}, Lco/vine/android/views/HorizontalListView;->access$1102(Lco/vine/android/views/HorizontalListView;Lco/vine/android/views/HorizontalListView$CheckForLongPress;)Lco/vine/android/views/HorizontalListView$CheckForLongPress;

    .line 1298
    :cond_1
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mPendingCheckForLongPress:Lco/vine/android/views/HorizontalListView$CheckForLongPress;
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$1100(Lco/vine/android/views/HorizontalListView;)Lco/vine/android/views/HorizontalListView$CheckForLongPress;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/views/HorizontalListView$CheckForLongPress;->rememberWindowAttachCount()V

    .line 1299
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    iget-object v4, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mPendingCheckForLongPress:Lco/vine/android/views/HorizontalListView$CheckForLongPress;
    invoke-static {v4}, Lco/vine/android/views/HorizontalListView;->access$1100(Lco/vine/android/views/HorizontalListView;)Lco/vine/android/views/HorizontalListView$CheckForLongPress;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mLongPressMillis:I
    invoke-static {v5}, Lco/vine/android/views/HorizontalListView;->access$1000(Lco/vine/android/views/HorizontalListView;)I

    move-result v5

    int-to-long v5, v5

    invoke-virtual {v3, v4, v5, v6}, Lco/vine/android/views/HorizontalListView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1304
    :goto_1
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mSelector:Landroid/graphics/drawable/Drawable;
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$900(Lco/vine/android/views/HorizontalListView;)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 1305
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mSelector:Landroid/graphics/drawable/Drawable;
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$900(Lco/vine/android/views/HorizontalListView;)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 1306
    .restart local v1    # "d":Landroid/graphics/drawable/Drawable;
    if-eqz v1, :cond_2

    instance-of v3, v1, Landroid/graphics/drawable/TransitionDrawable;

    if-eqz v3, :cond_2

    .line 1307
    check-cast v1, Landroid/graphics/drawable/TransitionDrawable;

    .end local v1    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v1}, Landroid/graphics/drawable/TransitionDrawable;->resetTransition()V

    .line 1311
    .end local v2    # "longClickable":Z
    :cond_2
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # setter for: Lco/vine/android/views/HorizontalListView;->mTouchMode:I
    invoke-static {v3, v7}, Lco/vine/android/views/HorizontalListView;->access$002(Lco/vine/android/views/HorizontalListView;I)I

    .line 1314
    .end local v0    # "child":Landroid/view/View;
    :cond_3
    return-void

    .line 1289
    .restart local v0    # "child":Landroid/view/View;
    .restart local v1    # "d":Landroid/graphics/drawable/Drawable;
    .restart local v2    # "longClickable":Z
    :cond_4
    check-cast v1, Landroid/graphics/drawable/TransitionDrawable;

    .end local v1    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v1}, Landroid/graphics/drawable/TransitionDrawable;->resetTransition()V

    goto :goto_0

    .line 1301
    :cond_5
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$CheckForTap;->this$0:Lco/vine/android/views/HorizontalListView;

    # setter for: Lco/vine/android/views/HorizontalListView;->mTouchMode:I
    invoke-static {v3, v7}, Lco/vine/android/views/HorizontalListView;->access$002(Lco/vine/android/views/HorizontalListView;I)I

    goto :goto_1
.end method
