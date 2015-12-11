.class public Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;
.super Lcom/amazon/mShop/PagedItemAdapter;
.source "ViewItSlidingDrawerView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ViewItSlidingDrawerItemAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/PagedItemAdapter",
        "<",
        "Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;Lcom/amazon/mShop/AmazonActivity;I)V
    .locals 0
    .param p2, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p3, "rowResId"    # I

    .prologue
    .line 351
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .line 352
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/PagedItemAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;I)V

    .line 353
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 2

    .prologue
    .line 363
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getRecentlyScannedObjects()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getReceivedCount()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v3, 0x0

    const/4 v6, 0x0

    .line 393
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getRecentlyScannedObjects()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-lt p1, v4, :cond_0

    .line 395
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v5}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getRecentlyScannedObjects()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    sub-int v5, p1, v5

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->setCurrentIndex(I)V

    .line 398
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v4, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getObjectAtIndex(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 399
    .local v2, "object":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 402
    .local v0, "itemResult":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    if-nez p2, :cond_2

    .line 403
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->layoutInflater:Landroid/view/LayoutInflater;

    iget v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->rowResId:I

    invoke-virtual {v4, v5, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/search/viewit/ViewItItemView;

    .line 408
    .local v1, "itemView":Lcom/amazon/mShop/search/viewit/ViewItItemView;
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v4

    sget-object v5, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITME_SHOW_AS_GROUP:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    invoke-virtual {v1, v2, v0, v4, v5}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->setObject(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;)V

    .line 409
    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->updateButtonVisibility()V

    .line 411
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v4

    sget-object v5, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITME_SHOW_AS_GROUP:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    invoke-virtual {v4, v2, v0, v5}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->isObjectToDelete(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 412
    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->showUndoButtonContent()V

    .line 417
    :goto_1
    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v3, [B

    invoke-virtual {v1, p0, v4, v3, p1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;[BI)V

    .line 418
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-virtual {v1, v4, v3, v2, v6}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->setItemClickAction(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Z)V

    .line 420
    if-nez p1, :cond_1

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isClosed()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 421
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter$1;

    invoke-direct {v4, p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;Lcom/amazon/mShop/search/viewit/ViewItItemView;)V

    invoke-interface {v3, v4}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 431
    :cond_1
    return-object v1

    .end local v1    # "itemView":Lcom/amazon/mShop/search/viewit/ViewItItemView;
    :cond_2
    move-object v1, p2

    .line 405
    check-cast v1, Lcom/amazon/mShop/search/viewit/ViewItItemView;

    .restart local v1    # "itemView":Lcom/amazon/mShop/search/viewit/ViewItItemView;
    goto :goto_0

    .line 414
    :cond_3
    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->showItemContent()V

    goto :goto_1
.end method

.method public onCancelled()V
    .locals 1

    .prologue
    .line 368
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->hideProgressBar()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V

    .line 369
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateHeaderVisibilityAndBottomOffset()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$600(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V

    .line 370
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 4
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 374
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->hideProgressBar()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V

    .line 375
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateHeaderVisibilityAndBottomOffset()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$600(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V

    .line 376
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$700(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItDialogHelper()Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$700(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v2

    invoke-static {v2, p1}, Lcom/amazon/mShop/util/UIUtils;->getMessageForException(Landroid/content/Context;Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_MSHOP_SERVER:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showDialog(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V

    .line 377
    return-void
.end method

.method public onPageComplete()V
    .locals 2

    .prologue
    .line 381
    invoke-super {p0}, Lcom/amazon/mShop/PagedItemAdapter;->onPageComplete()V

    .line 382
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getAllHistoryDBObjects()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getNextPageStartIndex()I

    move-result v1

    if-le v0, v1, :cond_0

    .line 383
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->showProgressBar()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$800(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V

    .line 388
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$500(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->notifyDataSetChanged()V

    .line 389
    return-void

    .line 385
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->hideProgressBar()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V

    goto :goto_0
.end method

.method public setBrowser(Lcom/amazon/mShop/control/PagedListingBrowser;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/control/PagedListingBrowser",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 357
    .local p1, "browser":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;>;"
    invoke-super {p0, p1}, Lcom/amazon/mShop/PagedItemAdapter;->setBrowser(Lcom/amazon/mShop/control/PagedListingBrowser;)V

    .line 358
    check-cast p1, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .end local p1    # "browser":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;>;"
    invoke-virtual {p1, p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->setSlidingDrawerPageListingAdapter(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;)V

    .line 359
    return-void
.end method
