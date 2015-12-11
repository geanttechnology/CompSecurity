.class public Lcom/amazon/mShop/PagedItemAdapter;
.super Lcom/amazon/mShop/PagedListingAdapter;
.source "PagedItemAdapter.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/amazon/mShop/PagedListingAdapter",
        "<TT;>;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field protected final layoutInflater:Landroid/view/LayoutInflater;

.field private listView:Landroid/widget/ListView;

.field protected final rowResId:I


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;I)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "rowResId"    # I

    .prologue
    .line 32
    .local p0, "this":Lcom/amazon/mShop/PagedItemAdapter;, "Lcom/amazon/mShop/PagedItemAdapter<TT;>;"
    invoke-direct {p0, p1}, Lcom/amazon/mShop/PagedListingAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    .line 33
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/PagedItemAdapter;->layoutInflater:Landroid/view/LayoutInflater;

    .line 34
    iput p2, p0, Lcom/amazon/mShop/PagedItemAdapter;->rowResId:I

    .line 35
    return-void
.end method


# virtual methods
.method public forward(I)V
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 51
    .local p0, "this":Lcom/amazon/mShop/PagedItemAdapter;, "Lcom/amazon/mShop/PagedItemAdapter<TT;>;"
    if-ltz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/PagedItemAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->getReceivedCount()I

    move-result v0

    if-lt p1, v0, :cond_1

    .line 57
    :cond_0
    :goto_0
    return-void

    .line 55
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/PagedItemAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->setCurrentIndex(I)V

    .line 56
    invoke-virtual {p0}, Lcom/amazon/mShop/PagedItemAdapter;->getAmazonActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/mShop/PagedItemAdapter;->makeObjectForForward()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->forward(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 89
    .local p0, "this":Lcom/amazon/mShop/PagedItemAdapter;, "Lcom/amazon/mShop/PagedItemAdapter<TT;>;"
    iget-object v3, p0, Lcom/amazon/mShop/PagedItemAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v3, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->setCurrentIndex(I)V

    .line 94
    if-nez p2, :cond_0

    .line 95
    iget-object v3, p0, Lcom/amazon/mShop/PagedItemAdapter;->layoutInflater:Landroid/view/LayoutInflater;

    iget v4, p0, Lcom/amazon/mShop/PagedItemAdapter;->rowResId:I

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/ItemView;

    .line 100
    .local v0, "itemView":Lcom/amazon/mShop/ItemView;
    :goto_0
    iget-object v3, p0, Lcom/amazon/mShop/PagedItemAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v3, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getObjectAtIndex(I)Ljava/lang/Object;

    move-result-object v1

    .line 102
    .local v1, "o":Ljava/lang/Object;, "TT;"
    iget-object v3, p0, Lcom/amazon/mShop/PagedItemAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v3, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getImageAtIndex(I)[B

    move-result-object v2

    .line 103
    .local v2, "thumbnail":[B
    invoke-virtual {v0, p0, v1, v2, p1}, Lcom/amazon/mShop/ItemView;->update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;[BI)V

    .line 105
    return-object v0

    .end local v0    # "itemView":Lcom/amazon/mShop/ItemView;
    .end local v1    # "o":Ljava/lang/Object;, "TT;"
    .end local v2    # "thumbnail":[B
    :cond_0
    move-object v0, p2

    .line 97
    check-cast v0, Lcom/amazon/mShop/ItemView;

    .restart local v0    # "itemView":Lcom/amazon/mShop/ItemView;
    goto :goto_0
.end method

.method protected makeObjectForForward()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 77
    .local p0, "this":Lcom/amazon/mShop/PagedItemAdapter;, "Lcom/amazon/mShop/PagedItemAdapter<TT;>;"
    new-instance v0, Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/PagedItemAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentObject()Ljava/lang/Object;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/Object;)V

    .line 78
    .local v0, "controller":Lcom/amazon/mShop/control/item/ProductController;
    iget-object v1, p0, Lcom/amazon/mShop/PagedItemAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentImage()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setThumbnail([B)V

    .line 80
    return-object v0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
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
    .line 64
    .local p0, "this":Lcom/amazon/mShop/PagedItemAdapter;, "Lcom/amazon/mShop/PagedItemAdapter<TT;>;"
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v1, p0, Lcom/amazon/mShop/PagedItemAdapter;->listView:Landroid/widget/ListView;

    if-nez v1, :cond_0

    const/4 v1, 0x0

    :goto_0
    sub-int v0, p3, v1

    .line 65
    .local v0, "index":I
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/PagedItemAdapter;->forward(I)V

    .line 66
    return-void

    .line 64
    .end local v0    # "index":I
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/PagedItemAdapter;->listView:Landroid/widget/ListView;

    invoke-virtual {v1}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v1

    goto :goto_0
.end method

.method public setListView(Landroid/widget/ListView;)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;

    .prologue
    .line 45
    .local p0, "this":Lcom/amazon/mShop/PagedItemAdapter;, "Lcom/amazon/mShop/PagedItemAdapter<TT;>;"
    iput-object p1, p0, Lcom/amazon/mShop/PagedItemAdapter;->listView:Landroid/widget/ListView;

    .line 46
    invoke-virtual {p1, p0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 47
    invoke-virtual {p1, p0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 48
    return-void
.end method
