.class public Lcom/amazon/mShop/search/RetailSearchEntryViewListener;
.super Ljava/lang/Object;
.source "RetailSearchEntryViewListener.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/entry/SearchEntryViewListener;


# instance fields
.field private mSearchActivity:Lcom/amazon/mShop/search/SearchActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/SearchActivity;)V
    .locals 0
    .param p1, "searchActivity"    # Lcom/amazon/mShop/search/SearchActivity;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-object p1, p0, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->mSearchActivity:Lcom/amazon/mShop/search/SearchActivity;

    .line 32
    return-void
.end method

.method private isPerformCommonSearch(Ljava/lang/String;)Z
    .locals 1
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 109
    const-string/jumbo v0, "BARCODE_SEARCH_QUERY_KEYWORD"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "IMAGE_SEARCH_QUERY_KEYWORD"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "VOICE_SEARCH_QUERY_KEYWORD"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private logSearchRefMarker()V
    .locals 1

    .prologue
    .line 88
    const-string/jumbo v0, "sr_txt"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 89
    return-void
.end method


# virtual methods
.method protected getCurrentDepartmentFilter()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    invoke-static {}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentDepartmentFilter()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onDispatchKeyEventPreIme(Landroid/view/KeyEvent;Landroid/content/Context;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/KeyEvent;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 70
    const/4 v0, 0x0

    .line 71
    .local v0, "result":Z
    iget-object v1, p0, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->mSearchActivity:Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/search/SearchActivity;->menuDispatchedKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 72
    const/4 v0, 0x1

    .line 81
    :goto_0
    return v0

    .line 73
    :cond_0
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->mSearchActivity:Lcom/amazon/mShop/search/SearchActivity;

    if-eqz v1, :cond_1

    invoke-static {p2}, Lcom/amazon/mShop/util/UIUtils;->isPortrait(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_1

    .line 76
    iget-object v1, p0, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->mSearchActivity:Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/SearchActivity;->popView()Z

    .line 77
    const/4 v0, 0x1

    goto :goto_0

    .line 79
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onQueryCleared()V
    .locals 1

    .prologue
    .line 116
    const-string/jumbo v0, ""

    invoke-static {v0}, Lcom/amazon/mShop/search/SearchActivity;->setPreviousSearchTerm(Ljava/lang/String;)V

    .line 117
    return-void
.end method

.method public bridge synthetic onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/Query;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/api/query/Query;

    .prologue
    .line 27
    check-cast p1, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .end local p1    # "x0":Lcom/amazon/retailsearch/android/api/query/Query;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)V

    return-void
.end method

.method public onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)V
    .locals 5
    .param p1, "query"    # Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .prologue
    .line 35
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->getKeywords()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 67
    :cond_0
    :goto_0
    return-void

    .line 42
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->getKeywords()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->isPerformCommonSearch(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 45
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->isAps()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-virtual {p0}, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->getCurrentDepartmentFilter()Ljava/lang/String;

    move-result-object v1

    .line 46
    .local v1, "department":Ljava/lang/String;
    :goto_1
    invoke-direct {p0}, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->logSearchRefMarker()V

    .line 47
    iget-object v3, p0, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->mSearchActivity:Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/search/SearchActivity;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->mSearchActivity:Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/search/SearchActivity;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v0

    .line 49
    .local v0, "clickStreamOrigin":Ljava/lang/String;
    :goto_2
    new-instance v3, Lcom/amazon/mShop/search/SearchIntentBuilder;

    iget-object v4, p0, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->mSearchActivity:Lcom/amazon/mShop/search/SearchActivity;

    invoke-direct {v3, v4}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v3, p1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->retailSearchQuery(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->getKeywords()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/search/SearchIntentBuilder;->query(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->filter(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->categoryName(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/amazon/mShop/search/SearchIntentBuilder;->clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v2

    .line 66
    .end local v0    # "clickStreamOrigin":Ljava/lang/String;
    .end local v1    # "department":Ljava/lang/String;
    .local v2, "intent":Landroid/content/Intent;
    :cond_2
    :goto_3
    iget-object v3, p0, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->mSearchActivity:Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {v3, v2}, Lcom/amazon/mShop/search/SearchActivity;->doSearch(Landroid/content/Intent;)V

    goto :goto_0

    .line 45
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_3
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->getAlias()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 47
    .restart local v1    # "department":Ljava/lang/String;
    :cond_4
    sget-object v3, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    .line 58
    .end local v1    # "department":Ljava/lang/String;
    :cond_5
    new-instance v2, Landroid/content/Intent;

    iget-object v3, p0, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;->mSearchActivity:Lcom/amazon/mShop/search/SearchActivity;

    const-class v4, Lcom/amazon/mShop/search/SearchActivity;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 59
    .restart local v2    # "intent":Landroid/content/Intent;
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->getKeywords()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 60
    const-string/jumbo v3, "android.intent.action.VIEW"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 61
    const-string/jumbo v3, "BARCODE_SEARCH_QUERY_KEYWORD"

    invoke-virtual {v2}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 63
    const-string/jumbo v3, "REFMARKER"

    const-string/jumbo v4, "sr_scan"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_3
.end method
