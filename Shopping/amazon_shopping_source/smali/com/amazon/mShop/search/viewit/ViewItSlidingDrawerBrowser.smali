.class public Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
.super Lcom/amazon/mShop/control/PagedListingBrowser;
.source "ViewItSlidingDrawerBrowser.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/control/PagedListingBrowser",
        "<",
        "Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;",
        ">;",
        "Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;"
    }
.end annotation


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field private mAllHistoryDBObjects:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;",
            ">;"
        }
    .end annotation
.end field

.field private mAllMatchesAdapter:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;

.field private mCurrentRequestDBObjects:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;",
            ">;"
        }
    .end annotation
.end field

.field private mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

.field protected mHistoryObjectsDeletedCount:I

.field private mNextPageStartIndex:I

.field private mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

.field private mRecentlyScannedObjects:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;",
            ">;"
        }
    .end annotation
.end field

.field private mRequestId:Ljava/lang/String;

.field private mSlidingDrawerAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;II)V
    .locals 2
    .param p1, "activity"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .param p2, "pageSize"    # I
    .param p3, "nextPageTriggerCount"    # I

    .prologue
    const/4 v0, 0x0

    .line 68
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/control/PagedListingBrowser;-><init>(II)V

    .line 29
    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mNextPageStartIndex:I

    .line 40
    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mHistoryObjectsDeletedCount:I

    .line 69
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .line 70
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mCurrentRequestDBObjects:Ljava/util/List;

    .line 71
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    .line 72
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    .line 73
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mCurrentRequestDBObjects:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .prologue
    .line 22
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->nextTriggerObjectIndex:I

    return v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .prologue
    .line 22
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->pageSize:I

    return v0
.end method

.method static synthetic access$402(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    .param p1, "x1"    # I

    .prologue
    .line 22
    iput p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->nextTriggerObjectIndex:I

    return p1
.end method

.method static synthetic access$500(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .prologue
    .line 22
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->nextTriggerObjectIndex:I

    return v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .prologue
    .line 22
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->pageSize:I

    return v0
.end method

.method private deleteEntireGroup(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)Z
    .locals 7
    .param p1, "object"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .prologue
    const/4 v4, 0x1

    .line 151
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->isRecentlyScanned()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 152
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 153
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v3

    .line 154
    .local v3, "size":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_3

    .line 155
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    invoke-interface {v5, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 156
    .local v1, "item":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 157
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    invoke-interface {v5, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 158
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    invoke-virtual {v5, p1}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->delete(Lcom/amazon/mShop/search/viewit/ResultWrapper;)V

    .line 176
    .end local v0    # "i":I
    .end local v1    # "item":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .end local v3    # "size":I
    :goto_1
    return v4

    .line 154
    .restart local v0    # "i":I
    .restart local v1    # "item":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .restart local v3    # "size":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 163
    .end local v0    # "i":I
    .end local v1    # "item":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .end local v3    # "size":I
    :cond_1
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->listingObjects:Ljava/util/List;

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 164
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v3

    .line 165
    .restart local v3    # "size":I
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_2
    if-ge v2, v3, :cond_3

    .line 166
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v5, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 167
    .restart local v1    # "item":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 168
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v5, v2}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 169
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    invoke-virtual {v5, p1}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->delete(Lcom/amazon/mShop/search/viewit/ResultWrapper;)V

    .line 170
    iget v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mHistoryObjectsDeletedCount:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mHistoryObjectsDeletedCount:I

    goto :goto_1

    .line 165
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 176
    .end local v1    # "item":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .end local v2    # "j":I
    .end local v3    # "size":I
    :cond_3
    const/4 v4, 0x0

    goto :goto_1
.end method

.method private deleteItemOfGroup(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)Z
    .locals 6
    .param p1, "object"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .prologue
    .line 180
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v2

    .line 182
    .local v2, "searchResults":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getDeletedAsin()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 183
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    .line 184
    .local v3, "size":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_1

    .line 185
    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 186
    .local v1, "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getDeletedAsin()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 187
    invoke-interface {v2, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 188
    const/4 v4, 0x0

    invoke-virtual {p1, v4}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->setDeletedAsin(Ljava/lang/String;)V

    .line 189
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    invoke-virtual {v4, p1}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->update(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    .line 190
    const/4 v4, 0x1

    .line 195
    .end local v0    # "i":I
    .end local v1    # "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .end local v3    # "size":I
    :goto_1
    return v4

    .line 184
    .restart local v0    # "i":I
    .restart local v1    # "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .restart local v3    # "size":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 195
    .end local v0    # "i":I
    .end local v1    # "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .end local v3    # "size":I
    :cond_1
    const/4 v4, 0x0

    goto :goto_1
.end method

.method private deleteObject(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)Z
    .locals 5
    .param p1, "objectToDelete"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .prologue
    const/4 v3, 0x0

    .line 131
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getDeletedAsin()Ljava/lang/String;

    move-result-object v1

    .line 132
    .local v1, "deleteAsin":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 133
    const-string/jumbo v2, "delete_all_asin"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 135
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->deleteEntireGroup(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)Z

    move-result v2

    .line 147
    :goto_0
    return v2

    .line 136
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    const/4 v4, 0x1

    if-ne v2, v4, :cond_1

    .line 137
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v0

    .line 138
    .local v0, "asin":Ljava/lang/String;
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 139
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->deleteEntireGroup(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)Z

    move-result v2

    goto :goto_0

    .line 143
    .end local v0    # "asin":Ljava/lang/String;
    :cond_1
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->deleteItemOfGroup(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)Z

    move-result v2

    goto :goto_0

    :cond_2
    move v2, v3

    .line 147
    goto :goto_0
.end method

.method private notifyDataSetChanged()V
    .locals 1

    .prologue
    .line 228
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mSlidingDrawerAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    if-eqz v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mSlidingDrawerAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->notifyDataSetChanged()V

    .line 232
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mAllMatchesAdapter:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;

    if-eqz v0, :cond_1

    .line 233
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mAllMatchesAdapter:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;->notifyDataSetChanged()V

    .line 235
    :cond_1
    return-void
.end method


# virtual methods
.method public addNewSannedObejct(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V
    .locals 2
    .param p1, "newObject"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 124
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->insert(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    .line 125
    return-void
.end method

.method protected adjustRequestTriggerIndex(I)I
    .locals 1
    .param p1, "currentIndex"    # I

    .prologue
    .line 361
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mHistoryObjectsDeletedCount:I

    add-int/2addr v0, p1

    return v0
.end method

.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 449
    invoke-super {p0, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 450
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$4;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$4;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 456
    return-void
.end method

.method public clear()V
    .locals 1

    .prologue
    .line 216
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 217
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mCurrentRequestDBObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 218
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 219
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 221
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mHistoryObjectsDeletedCount:I

    .line 222
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mAllHistoryDBObjects:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 223
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mAllHistoryDBObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 225
    :cond_0
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "response"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 393
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$2;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$2;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 426
    return-void
.end method

.method public deleteAllObjects()V
    .locals 1

    .prologue
    .line 203
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->cancel()Z

    .line 206
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->clear()V

    .line 209
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->deleteAllObjectsFromDB()V

    .line 210
    return-void
.end method

.method public deleteUndoObject()V
    .locals 1

    .prologue
    .line 287
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    if-eqz v0, :cond_0

    .line 288
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->deleteObject(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)Z

    .line 289
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 290
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->notifyDataSetChanged()V

    .line 292
    :cond_0
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 430
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/control/PagedListingBrowser;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 431
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$3;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 445
    return-void
.end method

.method public getAllHistoryDBObjects()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;",
            ">;"
        }
    .end annotation

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mAllHistoryDBObjects:Ljava/util/List;

    return-object v0
.end method

.method public getCurrentRequestDBObjects()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;",
            ">;"
        }
    .end annotation

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mCurrentRequestDBObjects:Ljava/util/List;

    return-object v0
.end method

.method public getHistoryListingObjects()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;",
            ">;"
        }
    .end annotation

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->listingObjects:Ljava/util/List;

    return-object v0
.end method

.method public getNextPageStartIndex()I
    .locals 1

    .prologue
    .line 101
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mNextPageStartIndex:I

    return v0
.end method

.method public getObjectAtIndex(I)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 366
    if-ltz p1, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    if-ge p1, v0, :cond_1

    .line 367
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 368
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 373
    :goto_0
    return-object v0

    .line 370
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->listingObjects:Ljava/util/List;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    sub-int v1, p1, v1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    goto :goto_0

    .line 373
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic getObjectAtIndex(I)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 22
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getObjectAtIndex(I)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v0

    return-object v0
.end method

.method public getObjectToDelete()Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    return-object v0
.end method

.method public getObjectsCount()I
    .locals 2

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public getRecentlyScannedObjects()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;",
            ">;"
        }
    .end annotation

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRecentlyScannedObjects:Ljava/util/List;

    return-object v0
.end method

.method public getViewItDBHelper()Lcom/amazon/mShop/search/viewit/ViewItDBHelper;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    return-object v0
.end method

.method public isObjectToDelete(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;)Z
    .locals 3
    .param p1, "object"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .param p2, "itemResult"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p3, "itemType"    # Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    .prologue
    const/4 v0, 0x1

    .line 302
    if-eqz p1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    if-eqz v1, :cond_2

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 303
    sget-object v1, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITME_SHOW_AS_GROUP:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    invoke-virtual {v1, p3}, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string/jumbo v1, "delete_all_asin"

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getDeletedAsin()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 311
    :cond_0
    :goto_0
    return v0

    .line 306
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getDeletedAsin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 311
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected objectsReceived(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;",
            ">;",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation

    .prologue
    .line 379
    .local p1, "objects":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;>;"
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/control/PagedListingBrowser;->objectsReceived(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 381
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 386
    return-void
.end method

.method public recoverUndo(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V
    .locals 3
    .param p1, "object"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .prologue
    const/4 v2, 0x0

    .line 245
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 246
    invoke-virtual {p1, v2}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->setDeletedAsin(Ljava/lang/String;)V

    .line 247
    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 249
    :cond_0
    return-void
.end method

.method public setAllMatchesPageListingAdapter(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;)V
    .locals 0
    .param p1, "adapter"    # Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mAllMatchesAdapter:Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;

    .line 110
    return-void
.end method

.method public setSlidingDrawerPageListingAdapter(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;)V
    .locals 0
    .param p1, "adapter"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mSlidingDrawerAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    .line 106
    return-void
.end method

.method public startFirstPageRequest(Ljava/util/List;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 76
    .local p1, "allDBObjects":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;>;"
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mAllHistoryDBObjects:Ljava/util/List;

    .line 77
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x0

    invoke-super {p0, v0, v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    move-result v0

    return v0
.end method

.method protected startPageRequest(I)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 14
    .param p1, "pageNumber"    # I

    .prologue
    .line 319
    new-instance v8, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;-><init>()V

    .line 320
    .local v8, "request":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;
    new-instance v9, Ljava/util/Vector;

    invoke-direct {v9}, Ljava/util/Vector;-><init>()V

    .line 322
    .local v9, "requestAsins":Ljava/util/Vector;, "Ljava/util/Vector<Ljava/lang/String;>;"
    iget-object v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mCurrentRequestDBObjects:Ljava/util/List;

    invoke-interface {v11}, Ljava/util/List;->clear()V

    .line 323
    iget v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->pageSize:I

    mul-int v10, p1, v11

    .line 324
    .local v10, "start":I
    iget v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->pageSize:I

    add-int v3, v10, v11

    .line 325
    .local v3, "end":I
    iget-object v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mAllHistoryDBObjects:Ljava/util/List;

    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v0

    .line 326
    .local v0, "allDBSize":I
    if-le v3, v0, :cond_0

    move v3, v0

    .line 327
    :cond_0
    iput v3, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mNextPageStartIndex:I

    .line 329
    iget-object v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mAllHistoryDBObjects:Ljava/util/List;

    invoke-interface {v11, v10, v3}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v7

    .line 330
    .local v7, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;>;"
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;

    .line 331
    .local v6, "item":Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;
    invoke-virtual {v6}, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;->getAsinList()Ljava/util/List;

    move-result-object v2

    .line 332
    .local v2, "asinList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v11

    if-nez v11, :cond_1

    .line 333
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 334
    .local v1, "asin":Ljava/lang/String;
    invoke-virtual {v9, v1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 337
    .end local v1    # "asin":Ljava/lang/String;
    .end local v5    # "i$":Ljava/util/Iterator;
    :cond_1
    iget-object v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mCurrentRequestDBObjects:Ljava/util/List;

    invoke-interface {v11, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 340
    .end local v2    # "asinList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v6    # "item":Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;
    :cond_2
    invoke-virtual {v9}, Ljava/util/Vector;->size()I

    move-result v11

    if-nez v11, :cond_3

    .line 341
    iput p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->lastRequestPageIndex:I

    .line 342
    const/4 v11, -0x1

    iput v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->currentRequestPageIndex:I

    .line 343
    iget-object v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v11}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateBottomToolBar()V

    .line 345
    iget-object v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    invoke-interface {v11}, Lcom/amazon/mShop/control/ObjectSubscriber;->onPageComplete()V

    .line 346
    const/4 v11, 0x0

    .line 355
    :goto_2
    return-object v11

    .line 348
    :cond_3
    invoke-virtual {v8, v9}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;->setAsins(Ljava/util/List;)V

    .line 349
    if-nez p1, :cond_4

    .line 350
    invoke-static {}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->getAmazonRequestId()Ljava/lang/String;

    move-result-object v11

    iput-object v11, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRequestId:Ljava/lang/String;

    .line 351
    const-string/jumbo v11, "basic_products_v32"

    const/4 v12, 0x0

    iget-object v13, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRequestId:Ljava/lang/String;

    invoke-static {v11, v12, v13}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 355
    :goto_3
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v11

    invoke-interface {v11, v8, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->basicProducts(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v11

    goto :goto_2

    .line 353
    :cond_4
    const-string/jumbo v11, "basic_products_v32"

    const/4 v12, 0x1

    iget-object v13, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mRequestId:Ljava/lang/String;

    invoke-static {v11, v12, v13}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    goto :goto_3
.end method

.method public updateUndoObject(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;)Z
    .locals 1
    .param p1, "object"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .param p2, "itemResult"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p3, "itemType"    # Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    .prologue
    .line 259
    if-eqz p1, :cond_2

    if-eqz p2, :cond_2

    .line 261
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    if-eqz v0, :cond_0

    .line 262
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->deleteObject(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)Z

    .line 263
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->notifyDataSetChanged()V

    .line 266
    :cond_0
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITME_SHOW_AS_GROUP:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    invoke-virtual {v0, p3}, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 269
    const-string/jumbo v0, "delete_all_asin"

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->setDeletedAsin(Ljava/lang/String;)V

    .line 275
    :goto_0
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mObjectToDelete:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 277
    const/4 v0, 0x1

    .line 280
    :goto_1
    return v0

    .line 272
    :cond_1
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->setDeletedAsin(Ljava/lang/String;)V

    goto :goto_0

    .line 280
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method
