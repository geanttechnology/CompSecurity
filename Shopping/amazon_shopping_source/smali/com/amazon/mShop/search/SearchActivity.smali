.class public Lcom/amazon/mShop/search/SearchActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "SearchActivity.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;
.implements Lcom/amazon/retailsearch/metrics/SearchMetricsListener;


# static fields
.field private static final TAG:Ljava/lang/String;

.field public static downKeyFromSearch:Z

.field private static sDepartmentFilter:Ljava/lang/String;

.field private static sDepartmentName:Ljava/lang/String;

.field private static sDepartmentSearchUrl:Ljava/lang/String;

.field private static sLocalizedSearchTerm:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static sPreviousSearchTerm:Ljava/lang/String;

.field private static sSearchAlias:Ljava/lang/String;

.field private static sShouldShowBarcodeEntry:Z


# instance fields
.field private mATFPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mResultsDisplay:Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

.field private mResultsDisplayLayout:Landroid/view/View;

.field private mSRDSPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

.field private resultItemListener:Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 60
    sput-object v1, Lcom/amazon/mShop/search/SearchActivity;->sPreviousSearchTerm:Ljava/lang/String;

    .line 62
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/search/SearchActivity;->sLocalizedSearchTerm:Ljava/util/Map;

    .line 63
    sput-boolean v2, Lcom/amazon/mShop/search/SearchActivity;->sShouldShowBarcodeEntry:Z

    .line 64
    sput-object v1, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentFilter:Ljava/lang/String;

    .line 65
    sput-object v1, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentSearchUrl:Ljava/lang/String;

    .line 66
    sput-object v1, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentName:Ljava/lang/String;

    .line 67
    sput-boolean v2, Lcom/amazon/mShop/search/SearchActivity;->downKeyFromSearch:Z

    .line 69
    sput-object v1, Lcom/amazon/mShop/search/SearchActivity;->sSearchAlias:Ljava/lang/String;

    .line 108
    const-class v0, Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/search/SearchActivity;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 58
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 103
    iput-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mATFPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 104
    iput-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mSRDSPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    return-void
.end method

.method private adjustActionBar()V
    .locals 2

    .prologue
    .line 819
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 820
    .local v0, "top":Landroid/view/View;
    instance-of v1, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    if-eqz v1, :cond_0

    .line 821
    invoke-static {p0}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->onOrientationChanged(Lcom/amazon/mShop/AmazonActivity;)V

    .line 823
    :cond_0
    return-void
.end method

.method public static clearPreviousSearchTermForLocales(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 121
    .local p0, "localeList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string/jumbo v2, ""

    sput-object v2, Lcom/amazon/mShop/search/SearchActivity;->sPreviousSearchTerm:Ljava/lang/String;

    .line 122
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 123
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 124
    .local v1, "localeName":Ljava/lang/String;
    sget-object v2, Lcom/amazon/mShop/search/SearchActivity;->sLocalizedSearchTerm:Ljava/util/Map;

    const-string/jumbo v3, ""

    invoke-interface {v2, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 127
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "localeName":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private containsSearchResultsView(Landroid/view/ViewGroup;)Z
    .locals 5
    .param p1, "viewGroup"    # Landroid/view/ViewGroup;

    .prologue
    .line 956
    const/4 v2, 0x0

    .line 957
    .local v2, "result":Z
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    .line 958
    .local v0, "childrenCount":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 959
    invoke-virtual {p1, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 960
    .local v3, "view":Landroid/view/View;
    iget-object v4, p0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplayLayout:Landroid/view/View;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 961
    const/4 v2, 0x1

    .line 965
    .end local v3    # "view":Landroid/view/View;
    :cond_0
    return v2

    .line 958
    .restart local v3    # "view":Landroid/view/View;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private createResultItemListener()Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;
    .locals 1

    .prologue
    .line 585
    invoke-static {}, Lcom/amazon/mShop/appstore/AppstoreUtils;->isAppstoreAvailable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 586
    new-instance v0, Lcom/amazon/mShop/search/AppStoreResultItemListener;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/AppStoreResultItemListener;-><init>(Lcom/amazon/mShop/search/SearchActivity;)V

    .line 588
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/mShop/search/ResultItemListener;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/ResultItemListener;-><init>(Lcom/amazon/mShop/search/SearchActivity;)V

    goto :goto_0
.end method

.method private doBarcodeSearch(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "barcodeString"    # Ljava/lang/String;
    .param p2, "barcodeFormat"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 755
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 756
    .local v0, "v":Landroid/view/View;
    if-eqz v0, :cond_0

    instance-of v1, v0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;

    if-eqz v1, :cond_0

    .line 757
    invoke-super {p0, v3, v3}, Lcom/amazon/mShop/AmazonActivity;->popView(ZZ)Z

    .line 759
    :cond_0
    new-instance v1, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;

    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->getBarcodeClickStreamOrigin()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, p0, p1, p2, v2}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v1, v3}, Lcom/amazon/mShop/search/SearchActivity;->setSearchRootView(Landroid/view/View;Z)V

    .line 760
    return-void
.end method

.method private doImageSearch()V
    .locals 2

    .prologue
    .line 774
    new-instance v0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/search/SearchActivity;->setSearchRootView(Landroid/view/View;Z)V

    .line 775
    return-void
.end method

.method private getBarcodeClickStreamOrigin()Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 986
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "barcodeActivatedFromHome"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 987
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_HOME:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v0

    .line 991
    :goto_0
    return-object v0

    .line 988
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "barcodeActivatedFromDeepLink"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 989
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_DEEP_LINK:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 991
    :cond_1
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getCurrentDepartmentFilter()Ljava/lang/String;
    .locals 1

    .prologue
    .line 220
    sget-object v0, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentFilter:Ljava/lang/String;

    return-object v0
.end method

.method public static getCurrentDepartmentName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 211
    sget-object v0, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentName:Ljava/lang/String;

    return-object v0
.end method

.method public static getPreviousSearchTerm()Ljava/lang/String;
    .locals 2

    .prologue
    .line 111
    sget-object v0, Lcom/amazon/mShop/search/SearchActivity;->sLocalizedSearchTerm:Ljava/util/Map;

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sput-object v0, Lcom/amazon/mShop/search/SearchActivity;->sPreviousSearchTerm:Ljava/lang/String;

    .line 112
    sget-object v0, Lcom/amazon/mShop/search/SearchActivity;->sPreviousSearchTerm:Ljava/lang/String;

    return-object v0
.end method

.method private declared-synchronized getResultItemListener()Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;
    .locals 1

    .prologue
    .line 574
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->resultItemListener:Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    if-nez v0, :cond_0

    .line 575
    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->createResultItemListener()Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->resultItemListener:Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    .line 578
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->resultItemListener:Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 574
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public static getShouldShowBarcodeEntry()Z
    .locals 1

    .prologue
    .line 130
    sget-boolean v0, Lcom/amazon/mShop/search/SearchActivity;->sShouldShowBarcodeEntry:Z

    return v0
.end method

.method private handleOnActivityResultFromSnapIt(I)V
    .locals 2
    .param p1, "resultCode"    # I

    .prologue
    .line 763
    const/16 v1, 0x3eb

    if-ne v1, p1, :cond_1

    .line 764
    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->doImageSearch()V

    .line 771
    :cond_0
    :goto_0
    return-void

    .line 765
    :cond_1
    if-nez p1, :cond_0

    .line 766
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 767
    .local v0, "view":Landroid/view/View;
    if-nez v0, :cond_0

    .line 768
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->finish()V

    goto :goto_0
.end method

.method private initRetailSearchEntryView(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;Landroid/content/Intent;)V
    .locals 8
    .param p1, "retailSearchEntryView"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 1012
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v6

    if-eqz v6, :cond_1

    const-string/jumbo v6, "?"

    invoke-virtual {p2}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    move v1, v4

    .line 1013
    .local v1, "hasIntentData":Z
    :goto_0
    if-eqz v1, :cond_2

    invoke-virtual {p2}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v6

    const-string/jumbo v7, "paramQueryText"

    invoke-virtual {v6, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1016
    .local v2, "searchTerm":Ljava/lang/String;
    :goto_1
    invoke-virtual {p1, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setSearchTerm(Ljava/lang/String;)V

    .line 1017
    invoke-static {}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentDepartmentName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setCurrentDepartmentName(Ljava/lang/String;)V

    .line 1018
    sget-object v6, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentSearchUrl:Ljava/lang/String;

    invoke-virtual {p1, v6}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setSearchUrl(Ljava/lang/String;)V

    .line 1019
    sget-object v6, Lcom/amazon/mShop/search/SearchActivity;->sSearchAlias:Ljava/lang/String;

    invoke-virtual {p1, v6}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setSearchAlias(Ljava/lang/String;)V

    .line 1020
    invoke-static {}, Lcom/amazon/mShop/search/SearchActivity;->getPreviousSearchTerm()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setPreviousSearchTerm(Ljava/lang/String;)V

    .line 1022
    invoke-static {}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->getInstance()Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->voiceSearchInSuggestionsEnabled()Z

    move-result v3

    .line 1023
    .local v3, "voice":Z
    invoke-virtual {p1, v3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setVoiceEnabled(Z)V

    .line 1025
    invoke-virtual {p1, v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setShowBarcodeEntry(Z)V

    .line 1026
    invoke-virtual {p1, v5}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setFlowEnabled(Z)V

    .line 1027
    invoke-virtual {p1, v5}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setHasSnapIt(Z)V

    .line 1028
    invoke-virtual {p1, v5}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setShowVisualScan(Z)V

    .line 1029
    new-instance v6, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;

    invoke-direct {v6, p0}, Lcom/amazon/mShop/search/RetailSearchEntryViewListener;-><init>(Lcom/amazon/mShop/search/SearchActivity;)V

    invoke-virtual {p1, v6}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setListener(Lcom/amazon/retailsearch/android/ui/entry/SearchEntryViewListener;)V

    .line 1033
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->isFlowEnabled(Landroid/content/Context;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 1034
    invoke-virtual {p1, v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setFlowEnabled(Z)V

    .line 1035
    invoke-static {}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->getInstance()Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->flowButtonTreatment()Ljava/lang/String;

    move-result-object v0

    .line 1037
    .local v0, "flow":Ljava/lang/String;
    const-string/jumbo v6, "T1"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 1038
    invoke-virtual {p1, v5}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setShowBarcodeEntry(Z)V

    .line 1047
    .end local v0    # "flow":Ljava/lang/String;
    :cond_0
    :goto_2
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->updateEntryView()V

    .line 1048
    return-void

    .end local v1    # "hasIntentData":Z
    .end local v2    # "searchTerm":Ljava/lang/String;
    .end local v3    # "voice":Z
    :cond_1
    move v1, v5

    .line 1012
    goto :goto_0

    .line 1013
    .restart local v1    # "hasIntentData":Z
    :cond_2
    const/4 v2, 0x0

    goto :goto_1

    .line 1039
    .restart local v0    # "flow":Ljava/lang/String;
    .restart local v2    # "searchTerm":Ljava/lang/String;
    .restart local v3    # "voice":Z
    :cond_3
    const-string/jumbo v6, "T2"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 1040
    invoke-virtual {p1, v5}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setShowBarcodeEntry(Z)V

    .line 1041
    invoke-virtual {p1, v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setShowVisualScan(Z)V

    goto :goto_2

    .line 1043
    :cond_4
    if-nez v3, :cond_5

    :goto_3
    invoke-virtual {p1, v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->setShowBarcodeEntry(Z)V

    goto :goto_2

    :cond_5
    move v4, v5

    goto :goto_3
.end method

.method public static setPreviousSearchTerm(Ljava/lang/String;)V
    .locals 2
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 116
    sput-object p0, Lcom/amazon/mShop/search/SearchActivity;->sPreviousSearchTerm:Ljava/lang/String;

    .line 117
    sget-object v0, Lcom/amazon/mShop/search/SearchActivity;->sLocalizedSearchTerm:Ljava/util/Map;

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 118
    return-void
.end method

.method private setSearchRootView(Landroid/view/View;Z)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;
    .param p2, "useAnimation"    # Z

    .prologue
    const/4 v2, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 366
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/search/SearchActivity;->pushView(Landroid/view/View;Z)V

    .line 368
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v1

    .line 369
    .local v1, "viewAnimator":Landroid/widget/ViewAnimator;
    invoke-virtual {v1}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v0

    .line 370
    .local v0, "count":I
    if-le v0, v4, :cond_0

    .line 371
    invoke-virtual {v1, v2}, Landroid/widget/ViewAnimator;->setInAnimation(Landroid/view/animation/Animation;)V

    .line 372
    invoke-virtual {v1, v2}, Landroid/widget/ViewAnimator;->setOutAnimation(Landroid/view/animation/Animation;)V

    .line 374
    add-int/lit8 v2, v0, -0x2

    invoke-virtual {v1, v2}, Landroid/widget/ViewAnimator;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    instance-of v2, v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    if-eqz v2, :cond_1

    .line 375
    add-int/lit8 v2, v0, -0x2

    invoke-virtual {v1, v3, v2}, Landroid/widget/ViewAnimator;->removeViews(II)V

    .line 383
    invoke-virtual {v1, v4}, Landroid/widget/ViewAnimator;->setDisplayedChild(I)V

    .line 389
    :cond_0
    :goto_0
    return-void

    .line 385
    :cond_1
    add-int/lit8 v2, v0, -0x1

    invoke-virtual {v1, v3, v2}, Landroid/widget/ViewAnimator;->removeViews(II)V

    .line 386
    invoke-virtual {v1, v3}, Landroid/widget/ViewAnimator;->setDisplayedChild(I)V

    goto :goto_0
.end method

.method public static setShouldShowBarcodeEntry(Z)V
    .locals 0
    .param p0, "flag"    # Z

    .prologue
    .line 134
    sput-boolean p0, Lcom/amazon/mShop/search/SearchActivity;->sShouldShowBarcodeEntry:Z

    .line 135
    return-void
.end method

.method private update()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 523
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 524
    .local v1, "intent":Landroid/content/Intent;
    if-eqz v1, :cond_1

    .line 526
    const-string/jumbo v2, "clickStreamOrigin"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 527
    .local v0, "clickStreamTag":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v2, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v0

    .end local v0    # "clickStreamTag":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/SearchActivity;->setClickStreamOrigin(Ljava/lang/String;)V

    .line 529
    const-string/jumbo v2, "SHOW_SEARCH_ENTRY_VIEW"

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 530
    invoke-static {v1}, Lcom/amazon/mShop/search/SearchActivity;->updateCurrentDepartmentInfo(Landroid/content/Intent;)V

    .line 531
    invoke-virtual {p0, v1, v3}, Lcom/amazon/mShop/search/SearchActivity;->setSearchEntryViewAsRoot(Landroid/content/Intent;Z)V

    .line 536
    :cond_1
    :goto_0
    return-void

    .line 533
    :cond_2
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/SearchActivity;->doSearch(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method private updateActionBarForSearch()V
    .locals 2

    .prologue
    .line 593
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->action_bar_search:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/SearchActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 594
    .local v0, "searchButton":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 595
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 597
    :cond_0
    return-void
.end method

.method public static updateCurrentDepartmentInfo(Landroid/content/Intent;)V
    .locals 10
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v9, 0x0

    .line 143
    if-eqz p0, :cond_5

    .line 144
    const-string/jumbo v7, "CATEGORY_URL"

    invoke-virtual {p0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 145
    .local v4, "searchUrl":Ljava/lang/String;
    const-string/jumbo v7, "CATEGORY_NAME"

    invoke-virtual {p0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 146
    .local v1, "departmentName":Ljava/lang/String;
    const-string/jumbo v7, "CATEGORY_ALIAS"

    invoke-virtual {p0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 150
    .local v3, "searchAlias":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 151
    sput-object v4, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentSearchUrl:Ljava/lang/String;

    .line 152
    sput-object v1, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentName:Ljava/lang/String;

    .line 153
    sput-object v3, Lcom/amazon/mShop/search/SearchActivity;->sSearchAlias:Ljava/lang/String;

    .line 203
    .end local v1    # "departmentName":Ljava/lang/String;
    .end local v3    # "searchAlias":Ljava/lang/String;
    .end local v4    # "searchUrl":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 156
    .restart local v1    # "departmentName":Ljava/lang/String;
    .restart local v3    # "searchAlias":Ljava/lang/String;
    .restart local v4    # "searchUrl":Ljava/lang/String;
    :cond_1
    sput-object v9, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentSearchUrl:Ljava/lang/String;

    .line 157
    sput-object v9, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentName:Ljava/lang/String;

    .line 158
    sput-object v9, Lcom/amazon/mShop/search/SearchActivity;->sSearchAlias:Ljava/lang/String;

    .line 161
    const/4 v0, 0x0

    .line 162
    .local v0, "departmentFilter":Ljava/lang/String;
    const/4 v6, 0x0

    .line 163
    .local v6, "suggestiondepartmentFilter":Ljava/lang/String;
    const/4 v5, 0x0

    .line 164
    .local v5, "suggestionDepartmentName":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v7

    if-eqz v7, :cond_2

    .line 165
    invoke-virtual {p0}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v7

    const-string/jumbo v8, "paramDepartmentFilter"

    invoke-virtual {v7, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 166
    invoke-virtual {p0}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v7

    const-string/jumbo v8, "paramDepartmentName"

    invoke-virtual {v7, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 167
    invoke-virtual {p0}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v7

    const-string/jumbo v8, "paramSuggestionDepartmentFilter"

    invoke-virtual {v7, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 168
    invoke-virtual {p0}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v7

    const-string/jumbo v8, "paramSuggestionDepartmentName"

    invoke-virtual {v7, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 177
    :cond_2
    if-eqz p0, :cond_3

    invoke-virtual {p0}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    const-string/jumbo v7, "?"

    invoke-virtual {p0}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_3

    const/4 v2, 0x1

    .line 178
    .local v2, "hasData":Z
    :goto_1
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_4

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_4

    if-nez v2, :cond_4

    .line 179
    sput-object v0, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentFilter:Ljava/lang/String;

    .line 180
    sput-object v1, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentName:Ljava/lang/String;

    goto :goto_0

    .line 177
    .end local v2    # "hasData":Z
    :cond_3
    const/4 v2, 0x0

    goto :goto_1

    .line 181
    .restart local v2    # "hasData":Z
    :cond_4
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 194
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 195
    sput-object v9, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentFilter:Ljava/lang/String;

    .line 196
    sput-object v9, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentName:Ljava/lang/String;

    goto/16 :goto_0

    .line 200
    .end local v0    # "departmentFilter":Ljava/lang/String;
    .end local v1    # "departmentName":Ljava/lang/String;
    .end local v2    # "hasData":Z
    .end local v3    # "searchAlias":Ljava/lang/String;
    .end local v4    # "searchUrl":Ljava/lang/String;
    .end local v5    # "suggestionDepartmentName":Ljava/lang/String;
    .end local v6    # "suggestiondepartmentFilter":Ljava/lang/String;
    :cond_5
    sput-object v9, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentFilter:Ljava/lang/String;

    .line 201
    sput-object v9, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentName:Ljava/lang/String;

    goto/16 :goto_0
.end method

.method private updateSearchAsView(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v1, 0x0

    .line 867
    if-eqz p1, :cond_0

    .line 868
    instance-of v0, p1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    if-eqz v0, :cond_1

    .line 869
    invoke-direct {p0, v1}, Lcom/amazon/mShop/search/SearchActivity;->updateSearchButton(Z)V

    .line 878
    .end local p1    # "view":Landroid/view/View;
    :cond_0
    :goto_0
    return-void

    .line 870
    .restart local p1    # "view":Landroid/view/View;
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplayLayout:Landroid/view/View;

    invoke-virtual {p1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 871
    invoke-direct {p0, v1}, Lcom/amazon/mShop/search/SearchActivity;->updateSearchButton(Z)V

    goto :goto_0

    .line 872
    :cond_2
    instance-of v0, p1, Landroid/view/ViewGroup;

    if-eqz v0, :cond_3

    check-cast p1, Landroid/view/ViewGroup;

    .end local p1    # "view":Landroid/view/View;
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/SearchActivity;->containsSearchResultsView(Landroid/view/ViewGroup;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 873
    invoke-direct {p0, v1}, Lcom/amazon/mShop/search/SearchActivity;->updateSearchButton(Z)V

    goto :goto_0

    .line 875
    :cond_3
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/SearchActivity;->updateSearchButton(Z)V

    goto :goto_0
.end method

.method private updateSearchButton(Z)V
    .locals 2
    .param p1, "searchButtonVisible"    # Z

    .prologue
    .line 888
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->action_bar_search:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/SearchActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 889
    .local v0, "searchButton":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 890
    if-eqz p1, :cond_1

    const/4 v1, 0x0

    :goto_0
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 891
    new-instance v1, Lcom/amazon/mShop/search/SearchActivity$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/SearchActivity$3;-><init>(Lcom/amazon/mShop/search/SearchActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 903
    :cond_0
    return-void

    .line 890
    :cond_1
    const/16 v1, 0x8

    goto :goto_0
.end method

.method public static wrapSearchBar(Lcom/amazon/mShop/AmazonActivity;Landroid/view/View;Ljava/lang/String;)Lcom/amazon/mShop/search/SearchResultsContainer;
    .locals 4
    .param p0, "mActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "view"    # Landroid/view/View;
    .param p2, "searchTerm"    # Ljava/lang/String;

    .prologue
    .line 921
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    instance-of v2, v2, Landroid/view/ViewGroup;

    if-eqz v2, :cond_0

    .line 922
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 923
    .local v1, "parent":Landroid/view/ViewGroup;
    invoke-virtual {v1, p1}, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I

    move-result v2

    if-ltz v2, :cond_0

    .line 924
    invoke-virtual {v1, p1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 927
    .end local v1    # "parent":Landroid/view/ViewGroup;
    :cond_0
    new-instance v0, Lcom/amazon/mShop/search/SearchResultsContainer;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/SearchResultsContainer;-><init>(Landroid/content/Context;)V

    .line 928
    .local v0, "container":Lcom/amazon/mShop/search/SearchResultsContainer;
    invoke-virtual {v0, p2}, Lcom/amazon/mShop/search/SearchResultsContainer;->setSearchTerm(Ljava/lang/CharSequence;)V

    .line 929
    invoke-virtual {v0, p1}, Lcom/amazon/mShop/search/SearchResultsContainer;->setSearchResultView(Landroid/view/View;)V

    .line 930
    sget-object v2, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentFilter:Ljava/lang/String;

    sget-object v3, Lcom/amazon/mShop/search/SearchActivity;->sDepartmentName:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Lcom/amazon/mShop/search/SearchResultsContainer;->updateSearchBar(Ljava/lang/String;Ljava/lang/String;)V

    .line 932
    return-object v0
.end method


# virtual methods
.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x1

    .line 827
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_0

    .line 828
    sput-boolean v1, Lcom/amazon/mShop/search/SearchActivity;->downKeyFromSearch:Z

    .line 831
    :cond_0
    const/4 v2, 0x4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    if-ne v2, v3, :cond_1

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_1

    .line 832
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 833
    .local v0, "v":Landroid/view/View;
    if-eqz v0, :cond_1

    instance-of v2, v0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;

    if-eqz v2, :cond_1

    .line 834
    const/4 v2, 0x0

    invoke-static {p0, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startBarcodeActivity(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    .line 853
    .end local v0    # "v":Landroid/view/View;
    :goto_0
    return v1

    :cond_1
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0
.end method

.method public doSearch(Landroid/content/Intent;)V
    .locals 16
    .param p1, "queryIntent"    # Landroid/content/Intent;

    .prologue
    .line 227
    const/4 v6, 0x0

    .line 230
    .local v6, "query":Ljava/lang/String;
    const-string/jumbo v12, "android.intent.action.VIEW"

    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_0

    .line 231
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v6

    .line 232
    const-string/jumbo v12, ""

    invoke-virtual {v6, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_5

    .line 233
    invoke-super/range {p0 .. p0}, Lcom/amazon/mShop/AmazonActivity;->popToRoot()V

    .line 234
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/SearchActivity;->finish()V

    .line 271
    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v12

    if-eqz v12, :cond_e

    .line 272
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/search/SearchActivity;->updateCurrentDepartmentInfo(Landroid/content/Intent;)V

    .line 274
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v12

    const-string/jumbo v13, "paramQueryText"

    invoke-virtual {v12, v13}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 275
    invoke-static {v6}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->validateQuery(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 276
    sget-object v12, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->INTENT_EXTRA_KEY:Ljava/lang/String;

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v8

    check-cast v8, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .line 279
    .local v8, "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v12

    const-string/jumbo v13, "paramDataUrl"

    invoke-virtual {v12, v13}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 280
    .local v2, "dataUrl":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_a

    .line 281
    invoke-static {v2}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->fromUrl(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    move-result-object v8

    .line 308
    :cond_1
    :goto_0
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v12

    const-string/jumbo v13, "paramMethod"

    invoke-virtual {v12, v13}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->find(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    move-result-object v9

    .line 310
    .local v9, "searchMethod":Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    if-eqz v8, :cond_2

    if-eqz v9, :cond_2

    .line 312
    invoke-virtual {v8, v9}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->setSearchMethod(Lcom/amazon/searchapp/retailsearch/client/SearchMethod;)V

    .line 315
    :cond_2
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v12

    const-string/jumbo v13, "paramAsrRequestId"

    invoke-virtual {v12, v13}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 317
    .local v1, "asrRequestId":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_3

    .line 318
    invoke-virtual {v8, v1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->setAsrRequestId(Ljava/lang/String;)V

    .line 321
    :cond_3
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v12

    const-string/jumbo v13, "paramUtteranceId"

    invoke-virtual {v12, v13}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 323
    .local v10, "utteranceId":Ljava/lang/String;
    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_4

    .line 324
    invoke-virtual {v8, v10}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->setUtteranceId(Ljava/lang/String;)V

    .line 327
    :cond_4
    invoke-static {v6}, Lcom/amazon/mShop/search/SearchActivity;->setPreviousSearchTerm(Ljava/lang/String;)V

    .line 329
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplayLayout:Landroid/view/View;

    move-object/from16 v0, p0

    invoke-static {v0, v12, v6}, Lcom/amazon/mShop/search/SearchActivity;->wrapSearchBar(Lcom/amazon/mShop/AmazonActivity;Landroid/view/View;Ljava/lang/String;)Lcom/amazon/mShop/search/SearchResultsContainer;

    move-result-object v12

    const/4 v13, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v12, v13}, Lcom/amazon/mShop/search/SearchActivity;->setSearchRootView(Landroid/view/View;Z)V

    .line 330
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplay:Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

    invoke-virtual {v12, v8}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->search(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)V

    .line 354
    .end local v1    # "asrRequestId":Ljava/lang/String;
    .end local v2    # "dataUrl":Ljava/lang/String;
    .end local v8    # "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    .end local v9    # "searchMethod":Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    .end local v10    # "utteranceId":Ljava/lang/String;
    :goto_1
    return-void

    .line 235
    :cond_5
    const-string/jumbo v12, "BARCODE_SEARCH_QUERY_KEYWORD"

    invoke-virtual {v6, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_6

    .line 243
    const-string/jumbo v12, "REFMARKER"

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 244
    .local v7, "refMarker":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-static {v0, v7}, Lcom/amazon/mShop/util/ActivityUtils;->startBarcodeActivity(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    goto :goto_1

    .line 246
    .end local v7    # "refMarker":Ljava/lang/String;
    :cond_6
    const-string/jumbo v12, "IMAGE_SEARCH_QUERY_KEYWORD"

    invoke-virtual {v6, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_9

    .line 247
    invoke-static/range {p0 .. p0}, Lcom/amazon/mShop/util/ActivityUtils;->isFlowEnabled(Landroid/content/Context;)Z

    move-result v12

    if-eqz v12, :cond_8

    .line 248
    const-string/jumbo v12, "flowActivatedFromDeepLink"

    const/4 v13, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v12, v13}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v12

    if-eqz v12, :cond_7

    .line 249
    sget-object v12, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_ACTIVATED_FROM_DEEP_LINK:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v12}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v12

    const-string/jumbo v13, "deep_link_fl"

    move-object/from16 v0, p0

    invoke-static {v0, v12, v13}, Lcom/amazon/mShop/util/ActivityUtils;->startFlowActivity(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 252
    :cond_7
    sget-object v12, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_ACTIVATED_FROM_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v12}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v12

    const-string/jumbo v13, "sr_fl"

    move-object/from16 v0, p0

    invoke-static {v0, v12, v13}, Lcom/amazon/mShop/util/ActivityUtils;->startFlowActivity(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 256
    :cond_8
    const-string/jumbo v12, "sr_snap"

    move-object/from16 v0, p0

    invoke-static {v0, v12}, Lcom/amazon/mShop/util/ActivityUtils;->startSnapItActivity(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    goto :goto_1

    .line 259
    :cond_9
    const-string/jumbo v12, "VOICE_SEARCH_QUERY_KEYWORD"

    invoke-virtual {v6, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_0

    .line 261
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->getInstance()Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    move-result-object v12

    const/4 v13, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v12, v0, v13}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->openVoiceSearch(Landroid/app/Activity;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 262
    :catch_0
    move-exception v3

    .line 263
    .local v3, "e":Ljava/lang/Exception;
    sget-object v12, Lcom/amazon/mShop/search/SearchActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v13, "Failed to open voice search"

    invoke-static {v12, v13, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 282
    .end local v3    # "e":Ljava/lang/Exception;
    .restart local v2    # "dataUrl":Ljava/lang/String;
    .restart local v8    # "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    :cond_a
    if-nez v8, :cond_1

    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_1

    .line 285
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v12

    const-string/jumbo v13, "paramDepartmentFilter"

    invoke-virtual {v12, v13}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 286
    .local v4, "filter":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_b

    .line 287
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v12

    const-string/jumbo v13, "paramSuggestionDepartmentFilter"

    invoke-virtual {v12, v13}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 289
    :cond_b
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_c

    .line 292
    const-string/jumbo v12, ":"

    invoke-virtual {v4, v12}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 293
    .local v5, "filtersArray":[Ljava/lang/String;
    if-eqz v5, :cond_c

    array-length v12, v5

    if-lez v12, :cond_c

    .line 295
    array-length v12, v5

    add-int/lit8 v12, v12, -0x1

    aget-object v4, v5, v12

    .line 298
    .end local v5    # "filtersArray":[Ljava/lang/String;
    :cond_c
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_d

    .line 300
    new-instance v8, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .end local v8    # "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    invoke-direct {v8, v6}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;-><init>(Ljava/lang/String;)V

    .restart local v8    # "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    goto/16 :goto_0

    .line 304
    :cond_d
    new-instance v8, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .end local v8    # "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    invoke-direct {v8, v4, v6}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .restart local v8    # "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    goto/16 :goto_0

    .line 334
    .end local v2    # "dataUrl":Ljava/lang/String;
    .end local v4    # "filter":Ljava/lang/String;
    .end local v8    # "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    :cond_e
    const/4 v12, 0x0

    invoke-static {v12}, Lcom/amazon/mShop/search/SearchActivity;->updateCurrentDepartmentInfo(Landroid/content/Intent;)V

    .line 335
    const-string/jumbo v12, "query"

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 336
    invoke-static {v6}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->validateQuery(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 337
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_10

    .line 340
    sget-object v6, Lcom/amazon/mShop/search/SearchActivity;->sPreviousSearchTerm:Ljava/lang/String;

    .line 342
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v11

    .line 343
    .local v11, "view":Landroid/view/View;
    if-eqz v11, :cond_f

    .line 344
    const/4 v12, 0x4

    invoke-virtual {v11, v12}, Landroid/view/View;->setVisibility(I)V

    .line 348
    :cond_f
    sget-object v12, Lcom/amazon/mShop/search/SearchActivity;->sPreviousSearchTerm:Ljava/lang/String;

    const/4 v13, 0x1

    const/4 v14, 0x0

    const/4 v15, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v13, v14, v15}, Lcom/amazon/mShop/search/SearchActivity;->startSearch(Ljava/lang/String;ZLandroid/os/Bundle;Z)V

    .line 350
    .end local v11    # "view":Landroid/view/View;
    :cond_10
    new-instance v8, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-direct {v8, v6}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;-><init>(Ljava/lang/String;)V

    .line 351
    .restart local v8    # "rsQuery":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplayLayout:Landroid/view/View;

    move-object/from16 v0, p0

    invoke-static {v0, v12, v6}, Lcom/amazon/mShop/search/SearchActivity;->wrapSearchBar(Lcom/amazon/mShop/AmazonActivity;Landroid/view/View;Ljava/lang/String;)Lcom/amazon/mShop/search/SearchResultsContainer;

    move-result-object v12

    const/4 v13, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v12, v13}, Lcom/amazon/mShop/search/SearchActivity;->setSearchRootView(Landroid/view/View;Z)V

    .line 352
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplay:Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

    invoke-virtual {v12, v8}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->search(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)V

    goto/16 :goto_1
.end method

.method public getClassLoader()Ljava/lang/ClassLoader;
    .locals 2

    .prologue
    .line 1103
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 1104
    .local v0, "classLoader":Ljava/lang/ClassLoader;
    if-nez v0, :cond_0

    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .end local v0    # "classLoader":Ljava/lang/ClassLoader;
    :cond_0
    return-object v0
.end method

.method protected handleForceSignIn()V
    .locals 1

    .prologue
    .line 975
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->isLaunchedFromPublicUrl()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 976
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->handleSigninPrompt(Landroid/content/Context;)Z

    .line 978
    :cond_0
    return-void
.end method

.method public isActionBarSearchIconFadeable()Z
    .locals 1

    .prologue
    .line 970
    const/4 v0, 0x1

    return v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 8
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v7, -0x1

    const/4 v6, 0x4

    .line 660
    const/16 v5, 0x12

    if-ne p1, v5, :cond_1

    .line 661
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v5

    if-nez v5, :cond_1

    .line 664
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->finish()V

    .line 752
    :cond_0
    :goto_0
    return-void

    .line 669
    :cond_1
    if-ne p1, v6, :cond_4

    if-ne p2, v7, :cond_4

    .line 670
    if-eqz p3, :cond_2

    .line 671
    const-string/jumbo v5, "BARCODE_STRING"

    invoke-virtual {p3, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 676
    .local v0, "barcodeString":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 677
    const/4 v5, 0x0

    invoke-direct {p0, v0, v5}, Lcom/amazon/mShop/search/SearchActivity;->doBarcodeSearch(Ljava/lang/String;Ljava/lang/String;)V

    .line 747
    .end local v0    # "barcodeString":Ljava/lang/String;
    :cond_2
    const/16 v5, 0xa

    if-ne p1, v5, :cond_3

    .line 748
    invoke-direct {p0, p2}, Lcom/amazon/mShop/search/SearchActivity;->handleOnActivityResultFromSnapIt(I)V

    .line 751
    :cond_3
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/AmazonActivity;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0

    .line 680
    :cond_4
    if-ne p1, v6, :cond_6

    if-nez p2, :cond_6

    .line 681
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v4

    .line 682
    .local v4, "view":Landroid/view/View;
    if-nez v4, :cond_5

    .line 683
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->finish()V

    goto :goto_0

    .line 684
    :cond_5
    instance-of v5, v4, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;

    if-eqz v5, :cond_0

    .line 687
    const/4 v5, 0x1

    const/4 v6, 0x0

    invoke-virtual {p0, v5, v6}, Lcom/amazon/mShop/search/SearchActivity;->popView(ZZ)Z

    goto :goto_0

    .line 693
    .end local v4    # "view":Landroid/view/View;
    :cond_6
    if-ne p1, v6, :cond_2

    if-eq p2, v7, :cond_2

    .line 717
    new-instance v5, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v5, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->bc_picture_format_unspport_message:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v1

    .line 720
    .local v1, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    new-instance v3, Lcom/amazon/mShop/search/SearchActivity$1;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/search/SearchActivity$1;-><init>(Lcom/amazon/mShop/search/SearchActivity;)V

    .line 729
    .local v3, "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    new-instance v2, Lcom/amazon/mShop/search/SearchActivity$2;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/SearchActivity$2;-><init>(Lcom/amazon/mShop/search/SearchActivity;)V

    .line 740
    .local v2, "onCancelListern":Landroid/content/DialogInterface$OnCancelListener;
    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 741
    sget v5, Lcom/amazon/mShop/android/lib/R$string;->alert_ok_button:I

    invoke-virtual {v1, v5, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 742
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    goto :goto_0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 779
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 780
    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->adjustActionBar()V

    .line 781
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 540
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 552
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->search:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/SearchActivity;->setTitle(I)V

    .line 554
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->retail_search_layout:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplayLayout:Landroid/view/View;

    .line 556
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->results_view:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

    iput-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplay:Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

    .line 557
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplay:Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->getResultItemListener()Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V

    .line 558
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplay:Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

    invoke-virtual {v0, p0}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V

    .line 559
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplay:Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

    invoke-virtual {v0, p0}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->addListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V

    .line 561
    if-eqz p1, :cond_0

    .line 563
    const-string/jumbo v0, "PersistedSearchTerm"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/search/SearchActivity;->setPreviousSearchTerm(Ljava/lang/String;)V

    .line 565
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/SearchActivity;->setStopBehavior(I)V

    .line 566
    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->update()V

    .line 567
    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->updateActionBarForSearch()V

    .line 568
    return-void
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 638
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onDestroy()V

    .line 639
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->removeAllViews()V

    .line 640
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplay:Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

    if-eqz v0, :cond_1

    .line 641
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->resultItemListener:Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    if-eqz v0, :cond_0

    .line 642
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplay:Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

    iget-object v1, p0, Lcom/amazon/mShop/search/SearchActivity;->resultItemListener:Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V

    .line 645
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplay:Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

    invoke-virtual {v0, p0}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/SearchChangedListener;)V

    .line 646
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mResultsDisplay:Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;

    invoke-virtual {v0, p0}, Lcom/amazon/retailsearch/android/ui/results/ResultsDisplay;->removeListener(Lcom/amazon/retailsearch/metrics/SearchMetricsListener;)V

    .line 648
    :cond_1
    return-void
.end method

.method public onKeywordChanged(Ljava/lang/String;)V
    .locals 2
    .param p1, "keyword"    # Ljava/lang/String;

    .prologue
    .line 997
    invoke-static {p1}, Lcom/amazon/mShop/search/SearchActivity;->setPreviousSearchTerm(Ljava/lang/String;)V

    .line 998
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 999
    .local v0, "currentView":Landroid/view/View;
    if-eqz v0, :cond_0

    instance-of v1, v0, Lcom/amazon/mShop/search/SearchResultsContainer;

    if-eqz v1, :cond_0

    .line 1001
    check-cast v0, Lcom/amazon/mShop/search/SearchResultsContainer;

    .end local v0    # "currentView":Landroid/view/View;
    invoke-virtual {v0, p1}, Lcom/amazon/mShop/search/SearchResultsContainer;->setSearchTerm(Ljava/lang/CharSequence;)V

    .line 1003
    :cond_0
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 623
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 624
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/SearchActivity;->setIntent(Landroid/content/Intent;)V

    .line 625
    const/4 v0, 0x1

    invoke-static {v0}, Lcom/amazon/mShop/search/SearchActivity;->setShouldShowBarcodeEntry(Z)V

    .line 626
    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->update()V

    .line 627
    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->updateActionBarForSearch()V

    .line 628
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 652
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 653
    const-string/jumbo v0, "PersistedSearchTerm"

    invoke-static {}, Lcom/amazon/mShop/search/SearchActivity;->getPreviousSearchTerm()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 654
    return-void
.end method

.method public onSearchATFReached()V
    .locals 1

    .prologue
    .line 1069
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mATFPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mATFPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1073
    :cond_0
    :goto_0
    return-void

    .line 1072
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mATFPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onComplete()V

    goto :goto_0
.end method

.method public onSearchRequested()Z
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 788
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 789
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    instance-of v1, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    if-eqz v1, :cond_0

    .line 797
    :goto_0
    return v3

    .line 796
    :cond_0
    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/search/SearchActivity;->showSearchEntryView(Landroid/content/Intent;Z)V

    goto :goto_0
.end method

.method public onSearchSRDSCompleted()V
    .locals 1

    .prologue
    .line 1092
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mSRDSPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mSRDSPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1096
    :cond_0
    :goto_0
    return-void

    .line 1095
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mSRDSPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onComplete()V

    goto :goto_0
.end method

.method public onSearchSRDSStarted()V
    .locals 1

    .prologue
    .line 1080
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mSRDSPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mSRDSPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1081
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mSRDSPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 1083
    :cond_0
    const-string/jumbo v0, "SearchExperienceRequestLatency"

    invoke-static {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->start(Ljava/lang/String;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mSRDSPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 1085
    return-void
.end method

.method public onSearchStarted()V
    .locals 1

    .prologue
    .line 1055
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mATFPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mATFPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1058
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mATFPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 1061
    :cond_0
    const-string/jumbo v0, "SearchExperienceTapToATF"

    invoke-static {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->start(Ljava/lang/String;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mATFPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 1062
    return-void
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 632
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/SearchActivity;->setSkipStopBehavior(Z)V

    .line 633
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStop()V

    .line 634
    return-void
.end method

.method protected onViewPopped(Landroid/view/View;Landroid/view/View;)V
    .locals 0
    .param p1, "oldTop"    # Landroid/view/View;
    .param p2, "newTop"    # Landroid/view/View;

    .prologue
    .line 863
    invoke-direct {p0, p2}, Lcom/amazon/mShop/search/SearchActivity;->updateSearchAsView(Landroid/view/View;)V

    .line 864
    return-void
.end method

.method protected onViewPushed(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 858
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/SearchActivity;->updateSearchAsView(Landroid/view/View;)V

    .line 859
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 3
    .param p1, "hasFocus"    # Z

    .prologue
    .line 601
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onWindowFocusChanged(Z)V

    .line 602
    if-eqz p1, :cond_0

    .line 607
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v1

    .line 608
    .local v1, "viewAnimator":Landroid/widget/ViewAnimator;
    invoke-virtual {v1}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v2

    if-lez v2, :cond_0

    .line 609
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 610
    .local v0, "view":Landroid/view/View;
    instance-of v2, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    if-eqz v2, :cond_0

    .line 611
    check-cast v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    .end local v0    # "view":Landroid/view/View;
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->updateEntryView()V

    .line 615
    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->adjustActionBar()V

    .line 619
    .end local v1    # "viewAnimator":Landroid/widget/ViewAnimator;
    :cond_0
    return-void
.end method

.method public popView(ZZ)Z
    .locals 3
    .param p1, "finishActivityIfEmpty"    # Z
    .param p2, "useAnimation"    # Z

    .prologue
    .line 802
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/AmazonActivity;->popView(ZZ)Z

    move-result v0

    .line 803
    .local v0, "result":Z
    if-eqz v0, :cond_0

    .line 804
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v1

    .line 805
    .local v1, "view":Landroid/view/View;
    instance-of v2, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    if-eqz v2, :cond_0

    .line 809
    check-cast v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    .end local v1    # "view":Landroid/view/View;
    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->updateEntryView()V

    .line 812
    :cond_0
    return v0
.end method

.method public setRootView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 424
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/search/SearchActivity;->setRootView(Landroid/view/View;Z)V

    .line 425
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/SearchActivity;->onViewPushed(Landroid/view/View;)V

    .line 426
    return-void
.end method

.method public setSearchEntryViewAsRoot(Landroid/content/Intent;Z)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "useAnimation"    # Z

    .prologue
    .line 401
    invoke-static {p1}, Lcom/amazon/mShop/search/SearchActivity;->updateCurrentDepartmentInfo(Landroid/content/Intent;)V

    .line 402
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->rs_search_entry_view:I

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    iput-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    .line 403
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-direct {p0, v0, p1}, Lcom/amazon/mShop/search/SearchActivity;->initRetailSearchEntryView(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;Landroid/content/Intent;)V

    .line 404
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/SearchActivity;->setRootView(Landroid/view/View;)V

    .line 407
    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->adjustActionBar()V

    .line 408
    return-void
.end method

.method public showSearchEntryView(Landroid/content/Intent;Z)V
    .locals 7
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "useAnimation"    # Z

    .prologue
    const/4 v5, 0x0

    .line 446
    invoke-static {p1}, Lcom/amazon/mShop/search/SearchActivity;->updateCurrentDepartmentInfo(Landroid/content/Intent;)V

    .line 461
    if-nez p1, :cond_1

    .line 462
    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4}, Landroid/content/Intent;-><init>()V

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/search/SearchActivity;->setIntent(Landroid/content/Intent;)V

    .line 468
    :goto_0
    if-eqz p1, :cond_0

    const-string/jumbo v4, "clickStreamOrigin"

    invoke-virtual {p1, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 469
    :cond_0
    sget-object v4, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/search/SearchActivity;->setClickStreamOrigin(Ljava/lang/String;)V

    .line 474
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v2

    .line 475
    .local v2, "top":Landroid/view/View;
    if-nez v2, :cond_3

    .line 476
    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->rs_search_entry_view:I

    invoke-static {p0, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    iput-object v4, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    .line 477
    iget-object v4, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-direct {p0, v4, p1}, Lcom/amazon/mShop/search/SearchActivity;->initRetailSearchEntryView(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;Landroid/content/Intent;)V

    .line 478
    iget-object v4, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/search/SearchActivity;->setRootView(Landroid/view/View;)V

    .line 516
    .end local v2    # "top":Landroid/view/View;
    :goto_2
    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchActivity;->adjustActionBar()V

    .line 517
    return-void

    .line 464
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/SearchActivity;->setIntent(Landroid/content/Intent;)V

    goto :goto_0

    .line 471
    :cond_2
    const-string/jumbo v4, "clickStreamOrigin"

    invoke-virtual {p1, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/search/SearchActivity;->setClickStreamOrigin(Ljava/lang/String;)V

    goto :goto_1

    .line 479
    .restart local v2    # "top":Landroid/view/View;
    :cond_3
    instance-of v4, v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    if-eqz v4, :cond_4

    .line 480
    check-cast v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    .end local v2    # "top":Landroid/view/View;
    iput-object v2, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    .line 481
    iget-object v4, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-direct {p0, v4, p1}, Lcom/amazon/mShop/search/SearchActivity;->initRetailSearchEntryView(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;Landroid/content/Intent;)V

    .line 482
    new-instance v4, Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;

    iget-object v5, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    const/4 v6, 0x0

    invoke-direct {v4, p0, v5, v6}, Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/retailsearch/android/ui/DelayedInitView;Z)V

    goto :goto_2

    .line 485
    .restart local v2    # "top":Landroid/view/View;
    :cond_4
    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->rs_search_entry_view:I

    invoke-static {p0, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    iput-object v4, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    .line 486
    iget-object v4, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-direct {p0, v4, p1}, Lcom/amazon/mShop/search/SearchActivity;->initRetailSearchEntryView(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;Landroid/content/Intent;)V

    .line 487
    iget-object v4, p0, Lcom/amazon/mShop/search/SearchActivity;->mSearchEntryView:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-virtual {p0, v4, p2}, Lcom/amazon/mShop/search/SearchActivity;->pushView(Landroid/view/View;Z)V

    .line 490
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v3

    .line 491
    .local v3, "viewAnimator":Landroid/widget/ViewAnimator;
    invoke-virtual {v3}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v0

    .line 492
    .local v0, "count":I
    const/4 v4, 0x2

    if-le v0, v4, :cond_5

    .line 493
    add-int/lit8 v1, v0, -0x3

    .local v1, "i":I
    :goto_3
    if-ltz v1, :cond_5

    .line 494
    invoke-virtual {v3, v1}, Landroid/widget/ViewAnimator;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    instance-of v4, v4, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    if-eqz v4, :cond_6

    .line 495
    invoke-virtual {v3, v5}, Landroid/widget/ViewAnimator;->setInAnimation(Landroid/view/animation/Animation;)V

    .line 496
    invoke-virtual {v3, v5}, Landroid/widget/ViewAnimator;->setOutAnimation(Landroid/view/animation/Animation;)V

    .line 497
    invoke-virtual {v3, v1}, Landroid/widget/ViewAnimator;->removeViewAt(I)V

    .line 513
    .end local v1    # "i":I
    :cond_5
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchActivity;->removeTemporaryBlankView()V

    goto :goto_2

    .line 493
    .restart local v1    # "i":I
    :cond_6
    add-int/lit8 v1, v1, -0x1

    goto :goto_3
.end method
