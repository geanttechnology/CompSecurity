.class Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;
.super Ljava/lang/Object;
.source "ViewItScannedItemAnimationFrame.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->startItemScaleAndTranslateAnimation()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)V
    .locals 0

    .prologue
    .line 219
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 222
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    const/4 v1, 0x1

    # setter for: Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mIsAnimationEnd:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->access$302(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;Z)Z

    .line 223
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 224
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinner:Landroid/view/View;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->access$400(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_1

    .line 225
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->updateSlidingDrawerAndDismissAnimationWindow(Z)V

    .line 233
    :cond_0
    :goto_0
    return-void

    .line 227
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->access$500(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBottomOffset()I

    move-result v0

    neg-int v0, v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinnerMinimumHeight:I
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->access$600(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 228
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->access$500(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mProgressSpinnerMinimumHeight:I
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->access$600(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)I

    move-result v1

    neg-int v1, v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateBottomOffset(I)V

    .line 229
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->access$700(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 238
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 243
    return-void
.end method
