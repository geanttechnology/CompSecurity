.class Lcom/amazon/mShop/search/viewit/ViewItItemView$3;
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
    .line 125
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 128
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getViewItMetricHelper()Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v2

    const-string/jumbo v3, "history-see-more-tap"

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    .line 129
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 130
    const-string/jumbo v2, "fl_max_all_btn"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 135
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 136
    .local v1, "inflater":Landroid/view/LayoutInflater;
    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->view_it_all_matched_items_view:I

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    .line 137
    .local v0, "allMatchedView":Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v3}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->updateAllMatchedResultsView(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)V

    .line 138
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->pushView(Landroid/view/View;)V

    .line 139
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->deleteUndoObject()V

    .line 140
    return-void

    .line 132
    .end local v0    # "allMatchedView":Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;
    .end local v1    # "inflater":Landroid/view/LayoutInflater;
    :cond_0
    const-string/jumbo v2, "fl_mini_all_btn"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method
