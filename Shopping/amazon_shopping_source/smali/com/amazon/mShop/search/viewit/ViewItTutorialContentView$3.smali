.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$3;
.super Ljava/lang/Object;
.source "ViewItTutorialContentView.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startDeviceFrameTranslateAnimation1()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

.field final synthetic val$toXValue:F


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;F)V
    .locals 0

    .prologue
    .line 190
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iput p2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$3;->val$toXValue:F

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 3
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 193
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    const/4 v1, 0x0

    iget v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$3;->val$toXValue:F

    neg-float v2, v2

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startScannedItemTranslateAnimation(IF)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;IF)V

    .line 194
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 199
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 1
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 204
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->reLayoutContentView()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$200(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    .line 205
    return-void
.end method
