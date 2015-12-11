.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7$2;
.super Ljava/lang/Object;
.source "ViewItTutorialContentView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->onAnimationEnd(Landroid/view/animation/Animation;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;)V
    .locals 0

    .prologue
    .line 379
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7$2;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 382
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7$2;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$800(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7$2;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;

    iget-object v2, v2, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iget v2, v2, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mDeviceFrameHeight:I

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7$2;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;

    iget-object v3, v3, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iget v3, v3, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mProductsFrameWidth:I

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;-><init>(Landroid/content/Context;II)V

    .line 383
    .local v0, "contentView":Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7$2;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$800(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;Z)V

    .line 384
    return-void
.end method
