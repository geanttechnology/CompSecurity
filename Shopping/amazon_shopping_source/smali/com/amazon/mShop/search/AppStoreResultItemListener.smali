.class Lcom/amazon/mShop/search/AppStoreResultItemListener;
.super Lcom/amazon/mShop/search/ResultItemListener;
.source "AppStoreResultItemListener.java"


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/SearchActivity;)V
    .locals 0
    .param p1, "searchActivity"    # Lcom/amazon/mShop/search/SearchActivity;

    .prologue
    .line 25
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/ResultItemListener;-><init>(Lcom/amazon/mShop/search/SearchActivity;)V

    .line 26
    return-void
.end method

.method private parseRefParameter(Landroid/net/Uri;)Ljava/lang/String;
    .locals 8
    .param p1, "parsedUri"    # Landroid/net/Uri;

    .prologue
    const/4 v5, 0x0

    .line 52
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    .line 54
    .local v2, "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v3, 0x0

    .line 55
    .local v3, "ref":Ljava/lang/String;
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    add-int/lit8 v0, v6, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 56
    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 57
    .local v1, "pathPiece":Ljava/lang/String;
    const-string/jumbo v6, "ref="

    invoke-virtual {v1, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 58
    move-object v3, v1

    .line 64
    .end local v1    # "pathPiece":Ljava/lang/String;
    :cond_0
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 73
    :cond_1
    :goto_1
    return-object v5

    .line 55
    .restart local v1    # "pathPiece":Ljava/lang/String;
    :cond_2
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 68
    .end local v1    # "pathPiece":Ljava/lang/String;
    :cond_3
    const-string/jumbo v6, "="

    invoke-virtual {v3, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 70
    .local v4, "refPieces":[Ljava/lang/String;
    array-length v6, v4

    const/4 v7, 0x2

    if-lt v6, v7, :cond_1

    .line 73
    const/4 v5, 0x1

    aget-object v5, v4, v5

    goto :goto_1
.end method


# virtual methods
.method protected openView(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)Z
    .locals 6
    .param p1, "resultItem"    # Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    .prologue
    .line 30
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->getDetailPageUrlPath()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 31
    .local v0, "parsedUri":Landroid/net/Uri;
    const-string/jumbo v4, "qid"

    invoke-virtual {v0, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 32
    .local v1, "qid":Ljava/lang/String;
    const-string/jumbo v4, "sr"

    invoke-virtual {v0, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 35
    .local v3, "sr":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/AppStoreResultItemListener;->parseRefParameter(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v2

    .line 37
    .local v2, "ref":Ljava/lang/String;
    const-string/jumbo v4, "mobile_application"

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->getProductGroup()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 38
    invoke-virtual {p0}, Lcom/amazon/mShop/search/AppStoreResultItemListener;->getSearchActivity()Lcom/amazon/mShop/search/SearchActivity;

    move-result-object v4

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->getAsin()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5, v2, v1, v3}, Lcom/amazon/mShop/util/ActivityUtils;->startAppstoreActivityWithAsin(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 39
    const/4 v4, 0x1

    .line 42
    :goto_0
    return v4

    :cond_0
    const/4 v4, 0x0

    goto :goto_0
.end method
