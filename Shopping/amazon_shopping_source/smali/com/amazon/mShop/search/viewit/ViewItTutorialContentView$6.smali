.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$6;
.super Ljava/lang/Object;
.source "ViewItTutorialContentView.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startDeviceFrameTranslateAnimation4()V
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
    .line 286
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 3
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 289
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->view_it_tutorial_title_2:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->view_it_tutorial_description_2:I

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->showTutorialTitleAndDescription(II)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;II)V

    .line 290
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->animateInBarcodeFrame()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    .line 291
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 296
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 301
    return-void
.end method
