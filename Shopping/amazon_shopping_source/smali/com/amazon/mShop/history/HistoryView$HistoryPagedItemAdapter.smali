.class Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;
.super Lcom/amazon/mShop/PagedItemAdapter;
.source "HistoryView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/history/HistoryView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HistoryPagedItemAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/PagedItemAdapter",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/history/HistoryView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/history/HistoryView;Lcom/amazon/mShop/AmazonActivity;I)V
    .locals 0
    .param p2, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p3, "rowResId"    # I

    .prologue
    .line 196
    iput-object p1, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    .line 197
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/PagedItemAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;I)V

    .line 198
    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 203
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v4, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->setCurrentIndex(I)V

    .line 206
    if-nez p2, :cond_1

    .line 207
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->layoutInflater:Landroid/view/LayoutInflater;

    iget v5, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->rowResId:I

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/history/HistoryItemView;

    .line 208
    .local v1, "itemView":Lcom/amazon/mShop/history/HistoryItemView;
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/history/HistoryItemView;->setObserver(Lcom/amazon/mShop/history/ObjectDeletingObserver;)V

    .line 213
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v4, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getObjectAtIndex(I)Ljava/lang/Object;

    move-result-object v2

    .line 215
    .local v2, "o":Ljava/lang/Object;
    move v0, p1

    .line 217
    .local v0, "displayIndex":I
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # getter for: Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I
    invoke-static {v4}, Lcom/amazon/mShop/history/HistoryView;->access$000(Lcom/amazon/mShop/history/HistoryView;)I

    move-result v4

    const/4 v5, -0x1

    if-eq v4, v5, :cond_0

    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # getter for: Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I
    invoke-static {v4}, Lcom/amazon/mShop/history/HistoryView;->access$000(Lcom/amazon/mShop/history/HistoryView;)I

    move-result v4

    if-le p1, v4, :cond_0

    .line 218
    add-int/lit8 v0, v0, -0x1

    .line 221
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v4, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getImageAtIndex(I)[B

    move-result-object v3

    .line 222
    .local v3, "thumbnail":[B
    invoke-virtual {v1, p1}, Lcom/amazon/mShop/history/HistoryItemView;->setObjectIndex(I)V

    .line 223
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # getter for: Lcom/amazon/mShop/history/HistoryView;->mVisitDateList:Ljava/util/List;
    invoke-static {v4}, Lcom/amazon/mShop/history/HistoryView;->access$100(Lcom/amazon/mShop/history/HistoryView;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/history/HistoryItemView;->setTag(Ljava/lang/Object;)V

    .line 224
    invoke-virtual {v1, p0, v2, v3, v0}, Lcom/amazon/mShop/history/HistoryItemView;->update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;[BI)V

    .line 226
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # getter for: Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I
    invoke-static {v4}, Lcom/amazon/mShop/history/HistoryView;->access$000(Lcom/amazon/mShop/history/HistoryView;)I

    move-result v4

    if-ne p1, v4, :cond_2

    .line 227
    invoke-virtual {v1}, Lcom/amazon/mShop/history/HistoryItemView;->showUndoGroup()V

    .line 232
    :goto_1
    return-object v1

    .end local v0    # "displayIndex":I
    .end local v1    # "itemView":Lcom/amazon/mShop/history/HistoryItemView;
    .end local v2    # "o":Ljava/lang/Object;
    .end local v3    # "thumbnail":[B
    :cond_1
    move-object v1, p2

    .line 210
    check-cast v1, Lcom/amazon/mShop/history/HistoryItemView;

    .restart local v1    # "itemView":Lcom/amazon/mShop/history/HistoryItemView;
    goto :goto_0

    .line 229
    .restart local v0    # "displayIndex":I
    .restart local v2    # "o":Ljava/lang/Object;
    .restart local v3    # "thumbnail":[B
    :cond_2
    invoke-virtual {v1}, Lcom/amazon/mShop/history/HistoryItemView;->showItemGroup()V

    goto :goto_1
.end method

.method public isEnabled(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 238
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # getter for: Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I
    invoke-static {v0}, Lcom/amazon/mShop/history/HistoryView;->access$000(Lcom/amazon/mShop/history/HistoryView;)I

    move-result v0

    if-eq p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected makeObjectForForward()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 265
    invoke-super {p0}, Lcom/amazon/mShop/PagedItemAdapter;->makeObjectForForward()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/control/item/ProductController;

    .line 266
    .local v0, "productController":Lcom/amazon/mShop/control/item/ProductController;
    sget-object v1, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_RVI:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setClickStreamTag(Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 267
    return-object v0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 1
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 255
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const-string/jumbo v0, "dp_rvi"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 256
    invoke-super/range {p0 .. p5}, Lcom/amazon/mShop/PagedItemAdapter;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V

    .line 257
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    invoke-virtual {v0}, Lcom/amazon/mShop/history/HistoryView;->deleteAsinsFromDB()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 258
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    invoke-virtual {v0}, Lcom/amazon/mShop/history/HistoryView;->refresh()V

    .line 261
    :cond_0
    return-void
.end method

.method public onPageComplete()V
    .locals 2

    .prologue
    .line 243
    invoke-super {p0}, Lcom/amazon/mShop/PagedItemAdapter;->onPageComplete()V

    .line 244
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # getter for: Lcom/amazon/mShop/history/HistoryView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;
    invoke-static {v0}, Lcom/amazon/mShop/history/HistoryView;->access$200(Lcom/amazon/mShop/history/HistoryView;)Lcom/amazon/mShop/ui/BottomToolBar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/ui/BottomToolBar;->setToolBarEnabled(Z)V

    .line 245
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # getter for: Lcom/amazon/mShop/history/HistoryView;->mBrowser:Lcom/amazon/mShop/control/history/HistoryBrowser;
    invoke-static {v0}, Lcom/amazon/mShop/history/HistoryView;->access$300(Lcom/amazon/mShop/history/HistoryView;)Lcom/amazon/mShop/control/history/HistoryBrowser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/history/HistoryBrowser;->getAvailableItemCount()I

    move-result v0

    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # getter for: Lcom/amazon/mShop/history/HistoryView;->mBrowser:Lcom/amazon/mShop/control/history/HistoryBrowser;
    invoke-static {v1}, Lcom/amazon/mShop/history/HistoryView;->access$300(Lcom/amazon/mShop/history/HistoryView;)Lcom/amazon/mShop/control/history/HistoryBrowser;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/control/history/HistoryBrowser;->getReceivedCount()I

    move-result v1

    if-le v0, v1, :cond_0

    .line 246
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # invokes: Lcom/amazon/mShop/history/HistoryView;->showLoadingStatus()V
    invoke-static {v0}, Lcom/amazon/mShop/history/HistoryView;->access$400(Lcom/amazon/mShop/history/HistoryView;)V

    .line 250
    :goto_0
    return-void

    .line 248
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # invokes: Lcom/amazon/mShop/history/HistoryView;->hideStatus()V
    invoke-static {v0}, Lcom/amazon/mShop/history/HistoryView;->access$500(Lcom/amazon/mShop/history/HistoryView;)V

    goto :goto_0
.end method
