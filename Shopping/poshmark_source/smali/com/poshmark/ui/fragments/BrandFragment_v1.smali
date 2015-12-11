.class public Lcom/poshmark/ui/fragments/BrandFragment_v1;
.super Lcom/poshmark/ui/fragments/PMFilterableFragment;
.source "BrandFragment_v1.java"

# interfaces
.implements Lcom/poshmark/notifications/ListingNotificationHandler;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;
    }
.end annotation


# instance fields
.field private adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

.field background:Landroid/graphics/drawable/Drawable;

.field private brand:Lcom/poshmark/data_model/models/Brand;

.field private brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

.field private brandName:Ljava/lang/String;

.field brandUnknown:Z

.field currentMode:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

.field private headerView:Landroid/view/View;

.field keywordSource:Ljava/lang/String;

.field resultsListView:Lcom/poshmark/ui/customviews/PMListView;

.field screenStackTag:Ljava/lang/String;

.field searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

.field private shareButtonListener:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 51
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;-><init>()V

    .line 57
    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 58
    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brand:Lcom/poshmark/data_model/models/Brand;

    .line 64
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandUnknown:Z

    .line 68
    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->keywordSource:Ljava/lang/String;

    .line 514
    new-instance v0, Lcom/poshmark/ui/fragments/BrandFragment_v1$9;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1$9;-><init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->shareButtonListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/BrandFragment_v1;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment_v1;
    .param p1, "x1"    # Z

    .prologue
    .line 51
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getSearchResults(Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/BrandFragment_v1;)Lcom/poshmark/data_model/models/Brand;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment_v1;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brand:Lcom/poshmark/data_model/models/Brand;

    return-object v0
.end method

.method static synthetic access$102(Lcom/poshmark/ui/fragments/BrandFragment_v1;Lcom/poshmark/data_model/models/Brand;)Lcom/poshmark/data_model/models/Brand;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment_v1;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/Brand;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brand:Lcom/poshmark/data_model/models/Brand;

    return-object p1
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/BrandFragment_v1;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment_v1;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$202(Lcom/poshmark/ui/fragments/BrandFragment_v1;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment_v1;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment_v1;

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->handleBrandShareTrigger()V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment_v1;

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->populateHeaderViews()V

    return-void
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/BrandFragment_v1;)Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment_v1;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    return-object v0
.end method

.method static synthetic access$600(Lcom/poshmark/ui/fragments/BrandFragment_v1;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment_v1;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method private getSearchResults(Z)V
    .locals 10
    .param p1, "isPagination"    # Z

    .prologue
    const/4 v2, 0x0

    .line 402
    if-nez p1, :cond_2

    .line 403
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    if-eqz v0, :cond_0

    .line 404
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    const/16 v3, 0x8

    invoke-virtual {v0, v3}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setVisibility(I)V

    .line 405
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->updateFilterWidget()V

    .line 408
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f06023b

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 409
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 410
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v1

    .line 411
    .local v1, "searchString":Ljava/lang/String;
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->keywordSource:Ljava/lang/String;

    new-instance v5, Lcom/poshmark/ui/fragments/BrandFragment_v1$7;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1$7;-><init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V

    invoke-static/range {v0 .. v5}, Lcom/poshmark/http/api/PMApi;->getListingsForBrand(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 437
    .end local v1    # "searchString":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 423
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 424
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v9

    .line 425
    .local v9, "model":Lcom/poshmark/utils/SearchFilterModel;
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v9, v0}, Lcom/poshmark/utils/SearchFilterModel;->setNextPageId(Ljava/lang/String;)V

    .line 426
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v1

    .line 427
    .restart local v1    # "searchString":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v5

    new-instance v8, Lcom/poshmark/ui/fragments/BrandFragment_v1$8;

    invoke-direct {v8, p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1$8;-><init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V

    move-object v4, v1

    move-object v6, v2

    move-object v7, v2

    invoke-static/range {v3 .. v8}, Lcom/poshmark/http/api/PMApi;->getListingsForBrand(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private handleBrandShareTrigger()V
    .locals 6

    .prologue
    .line 440
    invoke-static {}, Lcom/poshmark/triggers/PMTriggerManager;->getGlobalTriggerManager()Lcom/poshmark/triggers/PMTriggerManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/triggers/PMTriggerManager;->getBrandShareTrigger()Lcom/poshmark/triggers/BrandShareTrigger;

    move-result-object v0

    .line 441
    .local v0, "trigger":Lcom/poshmark/triggers/BrandShareTrigger;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/triggers/BrandShareTrigger;->isValid()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 442
    invoke-virtual {v0}, Lcom/poshmark/triggers/BrandShareTrigger;->incrementViewCount()V

    .line 443
    invoke-virtual {v0}, Lcom/poshmark/triggers/BrandShareTrigger;->shouldFireTrigger()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 444
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->shareTriggerLayout:Landroid/widget/RelativeLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 445
    invoke-virtual {v0}, Lcom/poshmark/triggers/BrandShareTrigger;->getCurrentState()Lcom/poshmark/triggers/PMTrigger$TriggerState;

    move-result-object v1

    sget-object v2, Lcom/poshmark/triggers/PMTrigger$TriggerState;->INITIAL:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    if-ne v1, v2, :cond_1

    .line 447
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "brand"

    const-string v4, "brand_share_banner_displayed_first_time"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 451
    :goto_0
    sget-object v1, Lcom/poshmark/triggers/PMTrigger$TriggerState;->IGNORED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {v0, v1}, Lcom/poshmark/triggers/BrandShareTrigger;->setNewState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)V

    .line 454
    :cond_0
    return-void

    .line 449
    :cond_1
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "brand"

    const-string v4, "brand_share_banner_displayed"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 6
    .param p2, "isPagination"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/SearchResults;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 464
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/SearchResults;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->hideProgressDialog()V

    .line 465
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v2

    if-nez v2, :cond_2

    .line 466
    if-nez p2, :cond_1

    .line 467
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getLabelForAnalytics()Ljava/lang/String;

    move-result-object v1

    .line 468
    .local v1, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "listings_filtered"

    invoke-virtual {v2, v3, v4, v5, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 470
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/SearchResults;

    .line 471
    .local v0, "data":Lcom/poshmark/data_model/models/SearchResults;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->getFacets()Lcom/poshmark/data_model/models/Facets;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->saveFacetLists(Lcom/poshmark/data_model/models/Facets;)V

    .line 472
    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    .line 473
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 474
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 475
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 476
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 477
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->showDefaultEmptyContentView()V

    .line 490
    .end local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    .end local v1    # "label":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 480
    :cond_1
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/SearchResults;

    .line 481
    .restart local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v2, v0}, Lcom/poshmark/data_model/models/SearchResults;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 482
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 487
    .end local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    :cond_2
    if-nez p2, :cond_0

    .line 488
    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private populateHeaderViews()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 339
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->brandTitleView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 340
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 341
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->viewNameForAnalytics:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 342
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandUnknown:Z

    if-nez v1, :cond_0

    .line 343
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setBrand(Ljava/lang/String;)V

    .line 345
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06005c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 346
    .local v0, "bannerMessage":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->shareBrandBannerMessageView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 348
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setVisibility(I)V

    .line 349
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 369
    .end local v0    # "bannerMessage":Ljava/lang/String;
    :goto_0
    return-void

    .line 366
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->unknownBrandButton:Landroid/widget/Button;

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 367
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method private setScreenTagBasedOnSearchType()V
    .locals 2

    .prologue
    .line 376
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    .line 377
    .local v0, "model":Lcom/poshmark/utils/SearchFilterModel;
    if-eqz v0, :cond_0

    .line 378
    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->screenStackTag:Ljava/lang/String;

    .line 381
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->screenStackTag:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 382
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->screenStackTag:Ljava/lang/String;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->setTrackingLabel(Ljava/lang/String;)V

    .line 384
    :cond_1
    return-void
.end method

.method private setupHeader()V
    .locals 2

    .prologue
    .line 158
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brand:Lcom/poshmark/data_model/models/Brand;

    if-nez v0, :cond_0

    .line 160
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/BrandFragment_v1$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1$2;-><init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getBrandMetaData(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 179
    :goto_0
    return-void

    .line 177
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->populateHeaderViews()V

    goto :goto_0
.end method

.method private setupHeaderViewHolder(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x0

    .line 260
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 261
    .local v0, "inflater":Landroid/view/LayoutInflater;
    new-instance v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    invoke-direct {v1}, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    .line 262
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    sget-object v2, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    if-ne v1, v2, :cond_1

    .line 263
    const v1, 0x7f030015

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    .line 279
    :goto_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v3, 0x7f0c006b

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->shareTriggerLayout:Landroid/widget/RelativeLayout;

    .line 280
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v3, 0x7f0c006d

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->cancelTriggerButton:Landroid/widget/ImageView;

    .line 281
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v3, 0x7f0c0070

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMButton;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->inviteFriendsButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 284
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->cancelTriggerButton:Landroid/widget/ImageView;

    new-instance v2, Lcom/poshmark/ui/fragments/BrandFragment_v1$4;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1$4;-><init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 297
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->inviteFriendsButton:Lcom/poshmark/ui/customviews/PMButton;

    new-instance v2, Lcom/poshmark/ui/fragments/BrandFragment_v1$5;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1$5;-><init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 314
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v3, 0x7f0c0062

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->backgroundImage:Landroid/widget/ImageView;

    .line 315
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v3, 0x7f0c0056

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->brandTitleView:Landroid/widget/TextView;

    .line 316
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v3, 0x7f0c0066

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    .line 317
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v3, 0x7f0c0065

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonContainer:Landroid/widget/LinearLayout;

    .line 319
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v3, 0x7f0c0064

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->unknownBrandButton:Landroid/widget/Button;

    .line 320
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->unknownBrandButton:Landroid/widget/Button;

    new-instance v2, Lcom/poshmark/ui/fragments/BrandFragment_v1$6;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1$6;-><init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 327
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v3, 0x7f0c006f

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->shareBrandBannerMessageView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 330
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v3, 0x7f0c0069

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    .line 331
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brand:Lcom/poshmark/data_model/models/Brand;

    if-eqz v1, :cond_0

    .line 332
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 334
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v2, 0x7f0c006a

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    .line 335
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v1, p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setOwnerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 336
    return-void

    .line 266
    :cond_1
    const v1, 0x7f030014

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    .line 267
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const v3, 0x7f0c0073

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->justInButton:Landroid/widget/Button;

    .line 268
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->justInButton:Landroid/widget/Button;

    new-instance v2, Lcom/poshmark/ui/fragments/BrandFragment_v1$3;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1$3;-><init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0
.end method

.method private setupSearchResultsList()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 387
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 388
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->bUpdateOnShow:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    if-nez v0, :cond_2

    .line 389
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 390
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 391
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getSearchResults(Z)V

    .line 399
    :cond_1
    :goto_0
    return-void

    .line 394
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 395
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 396
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->showDefaultEmptyContentView()V

    goto :goto_0
.end method


# virtual methods
.method public addCommentToListing(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 535
    return-void
.end method

.method public deleteListing(Ljava/lang/String;)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 545
    return-void
.end method

.method public filterContent()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 503
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 504
    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    .line 505
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->isFilterApplied:Z

    .line 508
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getBrand()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 509
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getBrand()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    .line 510
    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brand:Lcom/poshmark/data_model/models/Brand;

    .line 512
    :cond_0
    return-void
.end method

.method public fireSearch()V
    .locals 2

    .prologue
    .line 457
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 458
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->closeDrawer()V

    .line 459
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getSearchResults(Z)V

    .line 460
    return-void
.end method

.method public getFilterModel()Lcom/poshmark/utils/SearchFilterModel;
    .locals 1

    .prologue
    .line 372
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    return-object v0
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 247
    const-string v0, "br"

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 493
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->handleNotification(Landroid/content/Intent;)V

    .line 494
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.SEARCH_FILTER_ACTION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 496
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 497
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->fireSearch()V

    .line 499
    :cond_0
    return-void
.end method

.method public likeListing(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "liked"    # Z

    .prologue
    .line 540
    return-void
.end method

.method public newListingCreated()V
    .locals 0

    .prologue
    .line 550
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 214
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 215
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 76
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreate(Landroid/os/Bundle;)V

    .line 77
    new-instance v2, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/4 v4, 0x0

    const/high16 v5, -0x80000000

    invoke-direct {v2, v3, p0, v4, v5}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 80
    if-nez p1, :cond_3

    .line 81
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "NAME"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    .line 82
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    if-nez v2, :cond_0

    .line 83
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "ID"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    .line 88
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getPrimaryFilters()Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->addBrand(Ljava/lang/String;)V

    .line 92
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "KEYWORD_SOURCE"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->keywordSource:Ljava/lang/String;

    .line 94
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "MODE"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 95
    .local v0, "modeString":Ljava/lang/String;
    if-nez v0, :cond_5

    .line 97
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getSortBy()Ljava/lang/String;

    move-result-object v1

    .line 98
    .local v1, "sort_by_clause":Ljava/lang/String;
    if-eqz v1, :cond_1

    const-string v2, "added_desc"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 99
    :cond_1
    sget-object v2, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->ALL:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    .line 100
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "br"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 114
    .end local v1    # "sort_by_clause":Ljava/lang/String;
    :cond_2
    :goto_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 115
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v2

    invoke-virtual {v2, p0}, Lcom/poshmark/notifications/ListingNotificationManager;->registerListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V

    .line 116
    return-void

    .line 86
    .end local v0    # "modeString":Ljava/lang/String;
    :cond_3
    const-string v2, "BRAND_NAME"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    goto :goto_0

    .line 102
    .restart local v0    # "modeString":Ljava/lang/String;
    .restart local v1    # "sort_by_clause":Ljava/lang/String;
    :cond_4
    sget-object v2, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    .line 103
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "brj"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1

    .line 106
    .end local v1    # "sort_by_clause":Ljava/lang/String;
    :cond_5
    invoke-static {v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    .line 107
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    if-ne v2, v3, :cond_6

    .line 108
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "added_desc"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSortBy(Ljava/lang/String;)V

    .line 109
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "brj"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1

    .line 110
    :cond_6
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->ALL:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    if-ne v2, v3, :cond_2

    .line 111
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "br"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 143
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 144
    const v1, 0x7f030026

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 145
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->setupHeaderViewHolder(Landroid/view/View;)V

    .line 146
    const v1, 0x7f0c00c0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 147
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->headerView:Landroid/view/View;

    const/4 v4, 0x0

    new-instance v5, Lcom/poshmark/ui/fragments/BrandFragment_v1$1;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1$1;-><init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 153
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->setupHeader()V

    .line 154
    return-object v0
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 183
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPMResume()V

    .line 184
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 185
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->setupSearchResultsList()V

    .line 186
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->bUpdateOnShow:Z

    .line 188
    :cond_0
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.SEARCH_FILTER_ACTION"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 192
    :try_start_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f020111

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->background:Landroid/graphics/drawable/Drawable;

    .line 193
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->background:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->backgroundImage:Landroid/widget/ImageView;

    if-eqz v0, :cond_1

    .line 194
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->backgroundImage:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->background:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 195
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->backgroundImage:Landroid/widget/ImageView;

    sget-object v1, Landroid/widget/ImageView$ScaleType;->CENTER_CROP:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 200
    :cond_1
    :goto_0
    return-void

    .line 197
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 204
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPause()V

    .line 205
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 206
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->background:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->backgroundImage:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 207
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->backgroundImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 208
    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->background:Landroid/graphics/drawable/Drawable;

    .line 210
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 227
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 229
    const-string v0, "BRAND_NAME"

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 221
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onStop()V

    .line 222
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->clearImageList()V

    .line 223
    return-void
.end method

.method protected pullParametersFromState(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 120
    if-nez p1, :cond_0

    .line 121
    const-class v3, Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/SearchFilterModel;

    .line 122
    .local v0, "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    if-eqz v0, :cond_1

    .line 123
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/poshmark/utils/FilterResultsManager;->setSearchModel(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 137
    .end local v0    # "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    :cond_0
    :goto_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->setScreenTagBasedOnSearchType()V

    .line 138
    return-void

    .line 125
    .restart local v0    # "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    :cond_1
    new-instance v1, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v1}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 126
    .local v1, "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v3, "available"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 128
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v2

    .line 129
    .local v2, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v2, :cond_2

    iget-object v3, v2, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 130
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 132
    :cond_2
    const-string v3, "category_v2"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 133
    const-string v3, "size"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 134
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/poshmark/utils/FilterResultsManager;->setSearchModel(Lcom/poshmark/utils/SearchFilterModel;)V

    goto :goto_0
.end method

.method public setViewNameForAnalytics()V
    .locals 2

    .prologue
    .line 251
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    if-ne v0, v1, :cond_0

    .line 252
    const-string v0, "brand_just_in_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->viewNameForAnalytics:Ljava/lang/String;

    .line 256
    :goto_0
    return-void

    .line 254
    :cond_0
    const-string v0, "brand_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 234
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->setupActionBar()V

    .line 235
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    if-ne v0, v1, :cond_1

    .line 236
    const-string v0, "Just In"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->setTitle(Ljava/lang/String;)V

    .line 240
    :goto_0
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandUnknown:Z

    if-nez v0, :cond_0

    .line 241
    const v0, 0x7f06024e

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->shareButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 243
    :cond_0
    return-void

    .line 238
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->setTitle(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 0
    .param p1, "listing"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 530
    return-void
.end method
