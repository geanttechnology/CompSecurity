.class public Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;
.super Landroid/widget/BaseAdapter;
.source "ViewItAllMatchedResultsView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ViewItAllMatchesAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 65
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 70
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v3, 0x0

    .line 75
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 77
    .local v1, "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    if-nez p2, :cond_0

    .line 78
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->view_it_item_row:I

    invoke-virtual {v2, v4, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/viewit/ViewItItemView;

    .line 82
    .local v0, "itemView":Lcom/amazon/mShop/search/viewit/ViewItItemView;
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v2

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->access$200(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v4

    sget-object v5, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITEM_SHOW_IN_ALL_MATCHES:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    invoke-virtual {v0, v2, v1, v4, v5}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->setObject(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;)V

    .line 83
    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->updateButtonVisibility()V

    .line 85
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->access$200(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v2

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v4

    sget-object v5, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITEM_SHOW_IN_ALL_MATCHES:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    invoke-virtual {v2, v4, v1, v5}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->isObjectToDelete(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 86
    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->showUndoButtonContent()V

    :goto_1
    move-object v2, v3

    .line 91
    check-cast v2, [B

    invoke-virtual {v0, v3, v1, v2, p1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;[BI)V

    .line 92
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-static {v3}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v0, v2, v1, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->setItemClickAction(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Z)V

    .line 93
    return-object v0

    .end local v0    # "itemView":Lcom/amazon/mShop/search/viewit/ViewItItemView;
    :cond_0
    move-object v0, p2

    .line 80
    check-cast v0, Lcom/amazon/mShop/search/viewit/ViewItItemView;

    .restart local v0    # "itemView":Lcom/amazon/mShop/search/viewit/ViewItItemView;
    goto :goto_0

    .line 88
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->showItemContent()V

    goto :goto_1
.end method
