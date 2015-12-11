.class Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter$1;
.super Ljava/lang/Object;
.source "ViewItSlidingDrawerView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

.field final synthetic val$itemView:Lcom/amazon/mShop/search/viewit/ViewItItemView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;Lcom/amazon/mShop/search/viewit/ViewItItemView;)V
    .locals 0

    .prologue
    .line 421
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter$1;->val$itemView:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 424
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mHeaderContent:Landroid/view/View;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$200(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    .line 425
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter$1;->val$itemView:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->setBottomOffsetToFirstItemHeight(Lcom/amazon/mShop/search/viewit/ViewItItemView;)V

    .line 427
    :cond_0
    return-void
.end method
