.class Lcom/amazon/mShop/search/viewit/ViewItItemView$1;
.super Ljava/lang/Object;
.source "ViewItItemView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItItemView;->onFinishInflate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItItemView;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 99
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->showUndoButtonContent()V

    .line 100
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-static {v3}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemType:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$200(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->updateUndoObject(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;)Z

    .line 102
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 103
    .local v0, "currentview":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 104
    instance-of v1, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    if-eqz v1, :cond_1

    .line 105
    const-string/jumbo v1, "fl_history_del_btn"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 110
    :cond_0
    :goto_0
    return-void

    .line 106
    :cond_1
    instance-of v1, v0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    if-eqz v1, :cond_0

    .line 107
    const-string/jumbo v1, "fl_allmatch_del_btn"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method
