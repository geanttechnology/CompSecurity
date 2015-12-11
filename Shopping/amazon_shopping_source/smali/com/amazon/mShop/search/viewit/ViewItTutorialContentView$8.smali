.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;
.super Ljava/lang/Object;
.source "ViewItTutorialContentView.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startHistoryTrayFrameTranslateAnimation()V
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
    .line 427
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 430
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mNextButton:Landroid/widget/Button;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$1000(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)Landroid/widget/Button;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->view_it_tutorial_next_button_get_started_text:I

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(I)V

    .line 431
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;)V

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->showNextButton(Landroid/view/View$OnClickListener;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$900(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;Landroid/view/View$OnClickListener;)V

    .line 438
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 443
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 448
    return-void
.end method
