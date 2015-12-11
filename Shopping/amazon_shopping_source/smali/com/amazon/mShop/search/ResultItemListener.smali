.class Lcom/amazon/mShop/search/ResultItemListener;
.super Ljava/lang/Object;
.source "ResultItemListener.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;


# instance fields
.field private final searchActivity:Lcom/amazon/mShop/search/SearchActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/SearchActivity;)V
    .locals 0
    .param p1, "searchActivity"    # Lcom/amazon/mShop/search/SearchActivity;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/amazon/mShop/search/ResultItemListener;->searchActivity:Lcom/amazon/mShop/search/SearchActivity;

    .line 27
    return-void
.end method


# virtual methods
.method protected getSearchActivity()Lcom/amazon/mShop/search/SearchActivity;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/search/ResultItemListener;->searchActivity:Lcom/amazon/mShop/search/SearchActivity;

    return-object v0
.end method

.method public onResultItemSelected(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)V
    .locals 1
    .param p1, "resultItem"    # Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    .prologue
    .line 35
    if-nez p1, :cond_1

    .line 42
    :cond_0
    :goto_0
    return-void

    .line 39
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/ResultItemListener;->openView(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 40
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/ResultItemListener;->openUdp(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)V

    goto :goto_0
.end method

.method protected openUdp(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)V
    .locals 5
    .param p1, "resultItem"    # Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    .prologue
    .line 57
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->getDetailPageUrlPath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 78
    :goto_0
    return-void

    .line 63
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "currentUdpUrl"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 65
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 67
    iget-object v2, p0, Lcom/amazon/mShop/search/ResultItemListener;->searchActivity:Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/SearchActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->product_details_web_page_url:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 70
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->getProductGroup()Ljava/lang/String;

    move-result-object v0

    .line 72
    .local v0, "productGroup":Ljava/lang/String;
    const-string/jumbo v2, "points_stored_value"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 73
    iget-object v2, p0, Lcom/amazon/mShop/search/ResultItemListener;->searchActivity:Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->getAsin()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/ActivityUtils;->startAppstoreActivityToBuyCoins(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 75
    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->getDetailPageUrlPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 76
    iget-object v2, p0, Lcom/amazon/mShop/search/ResultItemListener;->searchActivity:Lcom/amazon/mShop/search/SearchActivity;

    sget-object v3, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    const/4 v4, -0x1

    invoke-static {v2, v1, v3, v4}, Lcom/amazon/mShop/util/ActivityUtils;->goToUdp(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;I)Z

    goto :goto_0
.end method

.method protected openView(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)Z
    .locals 1
    .param p1, "resultItem"    # Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    .prologue
    .line 50
    const/4 v0, 0x0

    return v0
.end method
