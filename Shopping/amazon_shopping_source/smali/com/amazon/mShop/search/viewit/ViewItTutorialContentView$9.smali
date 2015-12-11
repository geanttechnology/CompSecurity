.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;
.super Ljava/lang/Object;
.source "ViewItTutorialContentView.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->animateOutProductsFrame(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

.field final synthetic val$isBarcode:Z


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;Z)V
    .locals 0

    .prologue
    .line 470
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iput-boolean p2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;->val$isBarcode:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 4
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 473
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrame:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 474
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;->val$isBarcode:Z

    if-nez v0, :cond_0

    .line 475
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->hideTutorialTitleAndDescription()V

    .line 476
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startDeviceFrameTranslateAnimation4()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$1100(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    .line 486
    :goto_0
    return-void

    .line 478
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;)V

    const-wide/16 v2, 0x64

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    goto :goto_0
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 491
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 496
    return-void
.end method
