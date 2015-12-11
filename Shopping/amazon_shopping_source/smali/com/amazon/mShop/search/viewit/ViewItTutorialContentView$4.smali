.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$4;
.super Ljava/lang/Object;
.source "ViewItTutorialContentView.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startDeviceFrameTranslateAnimation2(F)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V
    .locals 0

    .prologue
    .line 222
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 3
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 225
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    const/4 v1, 0x1

    const/4 v2, 0x0

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startScannedItemTranslateAnimation(IF)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;IF)V

    .line 226
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 231
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 236
    return-void
.end method
