.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9$1;
.super Ljava/lang/Object;
.source "ViewItTutorialContentView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;->onAnimationEnd(Landroid/view/animation/Animation;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;)V
    .locals 0

    .prologue
    .line 478
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 481
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->view_it_tutorial_title_3:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->view_it_tutorial_description_3:I

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->showTutorialTitleAndDescription(II)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;II)V

    .line 482
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$9;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->showHistorySlidingArrow()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$1200(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    .line 483
    return-void
.end method
