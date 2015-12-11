.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$10$1;
.super Ljava/lang/Object;
.source "ViewItTutorialContentView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$10;->onAnimationEnd(Landroid/view/animation/Animation;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$10;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$10;)V
    .locals 0

    .prologue
    .line 524
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$10$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$10;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 527
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$10$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$10;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$10;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    const/4 v1, 0x3

    const/4 v2, 0x0

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startScannedItemTranslateAnimation(IF)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;IF)V

    .line 528
    return-void
.end method
