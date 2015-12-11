.class public Lcom/poshmark/ui/fragments/BrandFragment;
.super Lcom/poshmark/ui/fragments/PMFilterableFragment;
.source "BrandFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/ListingNotificationHandler;
.implements Lcom/poshmark/utils/CollectionSortWidgetListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/BrandFragment$10;,
        Lcom/poshmark/ui/fragments/BrandFragment$MODE;
    }
.end annotation


# instance fields
.field private adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

.field backgroundBmp:Landroid/graphics/Bitmap;

.field private brand:Lcom/poshmark/data_model/models/Brand;

.field private brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

.field private brandName:Ljava/lang/String;

.field brandUnknown:Z

.field currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

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

    .line 56
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;-><init>()V

    .line 62
    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 63
    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brand:Lcom/poshmark/data_model/models/Brand;

    .line 69
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandUnknown:Z

    .line 73
    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->keywordSource:Ljava/lang/String;

    .line 527
    new-instance v0, Lcom/poshmark/ui/fragments/BrandFragment$9;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/BrandFragment$9;-><init>(Lcom/poshmark/ui/fragments/BrandFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->shareButtonListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/BrandFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/BrandFragment;->getSearchResults(Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/BrandFragment;)Lcom/poshmark/data_model/models/Brand;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brand:Lcom/poshmark/data_model/models/Brand;

    return-object v0
.end method

.method static synthetic access$102(Lcom/poshmark/ui/fragments/BrandFragment;Lcom/poshmark/data_model/models/Brand;)Lcom/poshmark/data_model/models/Brand;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/Brand;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brand:Lcom/poshmark/data_model/models/Brand;

    return-object p1
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/BrandFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$202(Lcom/poshmark/ui/fragments/BrandFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/BrandFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment;

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->handleBrandShareTrigger()V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/BrandFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment;

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->populateHeaderViews()V

    return-void
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/BrandFragment;)Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    return-object v0
.end method

.method static synthetic access$600(Lcom/poshmark/ui/fragments/BrandFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/BrandFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/BrandFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method private getSearchResults(Z)V
    .locals 10
    .param p1, "isPagination"    # Z

    .prologue
    const/4 v2, 0x0

    .line 415
    if-nez p1, :cond_1

    .line 416
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f06023b

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 417
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 418
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v1

    .line 419
    .local v1, "searchString":Ljava/lang/String;
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/BrandFragment;->keywordSource:Ljava/lang/String;

    new-instance v5, Lcom/poshmark/ui/fragments/BrandFragment$7;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/BrandFragment$7;-><init>(Lcom/poshmark/ui/fragments/BrandFragment;)V

    invoke-static/range {v0 .. v5}, Lcom/poshmark/http/api/PMApi;->getListingsForBrand(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 445
    .end local v1    # "searchString":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 431
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 432
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v9

    .line 433
    .local v9, "model":Lcom/poshmark/utils/SearchFilterModel;
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v9, v0}, Lcom/poshmark/utils/SearchFilterModel;->setNextPageId(Ljava/lang/String;)V

    .line 434
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v1

    .line 435
    .restart local v1    # "searchString":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v5

    new-instance v8, Lcom/poshmark/ui/fragments/BrandFragment$8;

    invoke-direct {v8, p0}, Lcom/poshmark/ui/fragments/BrandFragment$8;-><init>(Lcom/poshmark/ui/fragments/BrandFragment;)V

    move-object v4, v1

    move-object v6, v2

    move-object v7, v2

    invoke-static/range {v3 .. v8}, Lcom/poshmark/http/api/PMApi;->getListingsForBrand(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private handleBrandShareTrigger()V
    .locals 6

    .prologue
    .line 448
    invoke-static {}, Lcom/poshmark/triggers/PMTriggerManager;->getGlobalTriggerManager()Lcom/poshmark/triggers/PMTriggerManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/triggers/PMTriggerManager;->getBrandShareTrigger()Lcom/poshmark/triggers/BrandShareTrigger;

    move-result-object v0

    .line 449
    .local v0, "trigger":Lcom/poshmark/triggers/BrandShareTrigger;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/triggers/BrandShareTrigger;->isValid()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 450
    invoke-virtual {v0}, Lcom/poshmark/triggers/BrandShareTrigger;->incrementViewCount()V

    .line 451
    invoke-virtual {v0}, Lcom/poshmark/triggers/BrandShareTrigger;->shouldFireTrigger()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 452
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->shareTriggerLayout:Landroid/widget/RelativeLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 453
    invoke-virtual {v0}, Lcom/poshmark/triggers/BrandShareTrigger;->getCurrentState()Lcom/poshmark/triggers/PMTrigger$TriggerState;

    move-result-object v1

    sget-object v2, Lcom/poshmark/triggers/PMTrigger$TriggerState;->INITIAL:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    if-ne v1, v2, :cond_1

    .line 455
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "brand"

    const-string v4, "brand_share_banner_displayed_first_time"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 459
    :goto_0
    sget-object v1, Lcom/poshmark/triggers/PMTrigger$TriggerState;->IGNORED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {v0, v1}, Lcom/poshmark/triggers/BrandShareTrigger;->setNewState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)V

    .line 462
    :cond_0
    return-void

    .line 457
    :cond_1
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "brand"

    const-string v4, "brand_share_banner_displayed"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

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
    .line 471
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/SearchResults;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->hideProgressDialog()V

    .line 472
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v2

    if-nez v2, :cond_2

    .line 473
    if-nez p2, :cond_1

    .line 474
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getLabelForAnalytics()Ljava/lang/String;

    move-result-object v1

    .line 475
    .local v1, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "listings_filtered"

    invoke-virtual {v2, v3, v4, v5, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 477
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/SearchResults;

    .line 478
    .local v0, "data":Lcom/poshmark/data_model/models/SearchResults;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->getFacets()Lcom/poshmark/data_model/models/Facets;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/BrandFragment;->saveFacetLists(Lcom/poshmark/data_model/models/Facets;)V

    .line 479
    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    .line 480
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 481
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 482
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 483
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 484
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->showDefaultEmptyContentView()V

    .line 497
    .end local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    .end local v1    # "label":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 487
    :cond_1
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/SearchResults;

    .line 488
    .restart local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v2, v0}, Lcom/poshmark/data_model/models/SearchResults;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 489
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 494
    .end local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    :cond_2
    if-nez p2, :cond_0

    .line 495
    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/BrandFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private populateHeaderViews()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 368
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->brandTitleView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 369
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 370
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->viewNameForAnalytics:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 371
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandUnknown:Z

    if-nez v1, :cond_0

    .line 372
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setBrand(Ljava/lang/String;)V

    .line 374
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06005c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 375
    .local v0, "bannerMessage":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->shareBrandBannerMessageView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 376
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setVisibility(I)V

    .line 381
    .end local v0    # "bannerMessage":Ljava/lang/String;
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 382
    return-void

    .line 378
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->unknownBrandButton:Landroid/widget/Button;

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 379
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method private setScreenTagBasedOnSearchType()V
    .locals 2

    .prologue
    .line 389
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    .line 390
    .local v0, "model":Lcom/poshmark/utils/SearchFilterModel;
    if-eqz v0, :cond_0

    .line 391
    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->screenStackTag:Ljava/lang/String;

    .line 394
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->screenStackTag:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 395
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->screenStackTag:Ljava/lang/String;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/BrandFragment;->setTrackingLabel(Ljava/lang/String;)V

    .line 397
    :cond_1
    return-void
.end method

.method private setupHeader()V
    .locals 2

    .prologue
    .line 170
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brand:Lcom/poshmark/data_model/models/Brand;

    if-nez v0, :cond_0

    .line 172
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/BrandFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/BrandFragment$2;-><init>(Lcom/poshmark/ui/fragments/BrandFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getBrandMetaData(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 192
    :goto_0
    return-void

    .line 190
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->populateHeaderViews()V

    goto :goto_0
.end method

.method private setupHeaderViewHolder(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x0

    .line 271
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FeatureManager;->isBrandPriceDropEnabled()Z

    move-result v1

    .line 273
    .local v1, "pdEnabled":Z
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 274
    .local v0, "inflater":Landroid/view/LayoutInflater;
    new-instance v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    invoke-direct {v2}, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    .line 275
    if-eqz v1, :cond_3

    .line 276
    const v2, 0x7f030012

    invoke-virtual {v0, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    .line 277
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c0068

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/CollectionSortWidget;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->sortWidget:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    .line 278
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->sortWidget:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    invoke-virtual {v2, p0}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setSortSelectionListener(Lcom/poshmark/utils/CollectionSortWidgetListener;)V

    .line 279
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->sortWidget:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f06003c

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setLeftButtonText(Ljava/lang/String;)V

    .line 280
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->sortWidget:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f06015c

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setCenterButtonText(Ljava/lang/String;)V

    .line 281
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->sortWidget:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f06021b

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setRightButtonText(Ljava/lang/String;)V

    .line 282
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    if-ne v2, v3, :cond_1

    .line 283
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->sortWidget:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectCenterButton()V

    .line 308
    :goto_0
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c006b

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->shareTriggerLayout:Landroid/widget/RelativeLayout;

    .line 309
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c006d

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->cancelTriggerButton:Landroid/widget/ImageView;

    .line 310
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c0070

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMButton;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->inviteFriendsButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 313
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->cancelTriggerButton:Landroid/widget/ImageView;

    new-instance v3, Lcom/poshmark/ui/fragments/BrandFragment$4;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/BrandFragment$4;-><init>(Lcom/poshmark/ui/fragments/BrandFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 326
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->inviteFriendsButton:Lcom/poshmark/ui/customviews/PMButton;

    new-instance v3, Lcom/poshmark/ui/fragments/BrandFragment$5;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/BrandFragment$5;-><init>(Lcom/poshmark/ui/fragments/BrandFragment;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 343
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c0062

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->backgroundImage:Landroid/widget/ImageView;

    .line 344
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c0056

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->brandTitleView:Landroid/widget/TextView;

    .line 345
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c0066

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    .line 346
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c0065

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->followFollowingButtonContainer:Landroid/widget/LinearLayout;

    .line 348
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c0064

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->unknownBrandButton:Landroid/widget/Button;

    .line 349
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->unknownBrandButton:Landroid/widget/Button;

    new-instance v3, Lcom/poshmark/ui/fragments/BrandFragment$6;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/BrandFragment$6;-><init>(Lcom/poshmark/ui/fragments/BrandFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 356
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c006f

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->shareBrandBannerMessageView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 359
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c0069

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    .line 360
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brand:Lcom/poshmark/data_model/models/Brand;

    if-eqz v2, :cond_0

    .line 361
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 363
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c006a

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    .line 364
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v2, p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setOwnerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 365
    return-void

    .line 284
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    if-ne v2, v3, :cond_2

    .line 285
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->sortWidget:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectRightButton()V

    goto/16 :goto_0

    .line 287
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->sortWidget:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectLeftButton()V

    goto/16 :goto_0

    .line 290
    :cond_3
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    if-ne v2, v3, :cond_4

    .line 291
    const v2, 0x7f030015

    invoke-virtual {v0, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    goto/16 :goto_0

    .line 293
    :cond_4
    const v2, 0x7f030014

    invoke-virtual {v0, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    .line 294
    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c0073

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, v3, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->justInButton:Landroid/widget/Button;

    .line 295
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->justInButton:Landroid/widget/Button;

    new-instance v3, Lcom/poshmark/ui/fragments/BrandFragment$3;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/BrandFragment$3;-><init>(Lcom/poshmark/ui/fragments/BrandFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0
.end method

.method private setupSearchResultsList()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 400
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 401
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->bUpdateOnShow:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    if-nez v0, :cond_2

    .line 402
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 403
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 404
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/BrandFragment;->getSearchResults(Z)V

    .line 412
    :cond_1
    :goto_0
    return-void

    .line 407
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 408
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 409
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->showDefaultEmptyContentView()V

    goto :goto_0
.end method


# virtual methods
.method public addCommentToListing(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 548
    return-void
.end method

.method public allowFilteringOnAllBrands()Z
    .locals 1

    .prologue
    .line 524
    const/4 v0, 0x0

    return v0
.end method

.method public deleteListing(Ljava/lang/String;)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 558
    return-void
.end method

.method public filterContent()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 511
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 512
    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    .line 513
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->isFilterApplied:Z

    .line 516
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getBrand()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 517
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getBrand()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    .line 518
    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brand:Lcom/poshmark/data_model/models/Brand;

    .line 520
    :cond_0
    return-void
.end method

.method public fireSearch()V
    .locals 2

    .prologue
    .line 465
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 466
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->closeDrawer()V

    .line 467
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/BrandFragment;->getSearchResults(Z)V

    .line 468
    return-void
.end method

.method public getFilterModel()Lcom/poshmark/utils/SearchFilterModel;
    .locals 1

    .prologue
    .line 385
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    return-object v0
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 258
    const-string v0, "br"

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 500
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->handleNotification(Landroid/content/Intent;)V

    .line 501
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.SEARCH_FILTER_ACTION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 503
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 504
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->fireSearch()V

    .line 506
    :cond_0
    return-void
.end method

.method public likeListing(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "liked"    # Z

    .prologue
    .line 553
    return-void
.end method

.method public newListingCreated()V
    .locals 0

    .prologue
    .line 563
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 229
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 230
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 81
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreate(Landroid/os/Bundle;)V

    .line 82
    new-instance v2, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/4 v4, 0x0

    const/high16 v5, -0x80000000

    invoke-direct {v2, v3, p0, v4, v5}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 85
    if-nez p1, :cond_2

    .line 86
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "NAME"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    .line 87
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    if-nez v2, :cond_0

    .line 88
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "ID"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    .line 93
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getPrimaryFilters()Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->addBrand(Ljava/lang/String;)V

    .line 97
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "KEYWORD_SOURCE"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->keywordSource:Ljava/lang/String;

    .line 99
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "MODE"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 100
    .local v0, "modeString":Ljava/lang/String;
    if-nez v0, :cond_5

    .line 102
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getSortBy()Ljava/lang/String;

    move-result-object v1

    .line 103
    .local v1, "sort_by_clause":Ljava/lang/String;
    if-eqz v1, :cond_3

    const-string v2, "added_desc"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 104
    sget-object v2, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    .line 105
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "brj"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 124
    .end local v1    # "sort_by_clause":Ljava/lang/String;
    :cond_1
    :goto_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/BrandFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 125
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v2

    invoke-virtual {v2, p0}, Lcom/poshmark/notifications/ListingNotificationManager;->registerListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V

    .line 126
    return-void

    .line 91
    .end local v0    # "modeString":Ljava/lang/String;
    :cond_2
    const-string v2, "BRAND_NAME"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    goto :goto_0

    .line 106
    .restart local v0    # "modeString":Ljava/lang/String;
    .restart local v1    # "sort_by_clause":Ljava/lang/String;
    :cond_3
    if-eqz v1, :cond_4

    const-string v2, "price_drop"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 107
    sget-object v2, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    .line 108
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "brpd"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1

    .line 110
    :cond_4
    sget-object v2, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    .line 111
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "br"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1

    .line 114
    .end local v1    # "sort_by_clause":Ljava/lang/String;
    :cond_5
    invoke-static {v0}, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    .line 115
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    if-ne v2, v3, :cond_6

    .line 116
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "added_desc"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSortBy(Ljava/lang/String;)V

    .line 117
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "brj"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1

    .line 118
    :cond_6
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    if-ne v2, v3, :cond_7

    .line 119
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "br"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1

    .line 120
    :cond_7
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    if-ne v2, v3, :cond_1

    .line 121
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    const-string v3, "brpd"

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 155
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 156
    const v1, 0x7f030026

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 157
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment;->setupHeaderViewHolder(Landroid/view/View;)V

    .line 158
    const v1, 0x7f0c00c0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 159
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->resultsListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->headerView:Landroid/view/View;

    const/4 v4, 0x0

    new-instance v5, Lcom/poshmark/ui/fragments/BrandFragment$1;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/BrandFragment$1;-><init>(Lcom/poshmark/ui/fragments/BrandFragment;)V

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 165
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->setupHeader()V

    .line 166
    return-object v0
.end method

.method public onPMResume()V
    .locals 5

    .prologue
    .line 196
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPMResume()V

    .line 197
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getUserVisibleHint()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 198
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->setupSearchResultsList()V

    .line 199
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->bUpdateOnShow:Z

    .line 201
    :cond_0
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v2

    const-string v3, "com.poshmark.intents.SEARCH_FILTER_ACTION"

    invoke-virtual {v2, v3, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 205
    :try_start_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v2

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Display;->getWidth()I

    move-result v1

    .line 206
    .local v1, "width":I
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const/high16 v3, 0x42f00000    # 120.0f

    invoke-static {v2, v3}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v2

    float-to-int v0, v2

    .line 207
    .local v0, "height":I
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020112

    const/4 v4, 0x1

    invoke-static {v2, v3, v1, v0, v4}, Lcom/poshmark/utils/ImageUtils;->loadScaledBitmapFromResource(Landroid/content/res/Resources;IIIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    .line 208
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    if-eqz v2, :cond_1

    .line 209
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->backgroundImage:Landroid/widget/ImageView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 214
    .end local v0    # "height":I
    .end local v1    # "width":I
    :cond_1
    :goto_0
    return-void

    .line 211
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 218
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPause()V

    .line 219
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 220
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->backgroundImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 221
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 222
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 223
    iput-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    .line 225
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 242
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 244
    const-string v0, "BRAND_NAME"

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 245
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 236
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onStop()V

    .line 237
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->clearImageList()V

    .line 238
    return-void
.end method

.method protected pullParametersFromState(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 130
    if-nez p1, :cond_0

    .line 131
    const-class v3, Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/BrandFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/SearchFilterModel;

    .line 132
    .local v0, "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    if-eqz v0, :cond_1

    .line 133
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/poshmark/utils/FilterResultsManager;->setSearchModel(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 150
    .end local v0    # "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    :cond_0
    :goto_0
    return-void

    .line 135
    .restart local v0    # "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    :cond_1
    new-instance v1, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v1}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 136
    .local v1, "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v3, "available"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 138
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v2

    .line 139
    .local v2, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v2, :cond_2

    iget-object v3, v2, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 140
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 142
    :cond_2
    const-string v3, "category_v2"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 143
    const-string v3, "category_feature"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 144
    const-string v3, "size"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 145
    const-string v3, "color"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 146
    const-string v3, "br"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 147
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/poshmark/utils/FilterResultsManager;->setSearchModel(Lcom/poshmark/utils/SearchFilterModel;)V

    goto :goto_0
.end method

.method public setViewNameForAnalytics()V
    .locals 2

    .prologue
    .line 262
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    if-ne v0, v1, :cond_0

    .line 263
    const-string v0, "brand_just_in_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 267
    :goto_0
    return-void

    .line 265
    :cond_0
    const-string v0, "brand_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 249
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->setupActionBar()V

    .line 250
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandName:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment;->setTitle(Ljava/lang/String;)V

    .line 251
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->brandUnknown:Z

    if-nez v0, :cond_0

    .line 252
    const v0, 0x7f06024e

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment;->shareButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/BrandFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 254
    :cond_0
    return-void
.end method

.method public sortAll()V
    .locals 2

    .prologue
    .line 566
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 567
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    .line 568
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->isFilterApplied:Z

    .line 569
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearSortBy()V

    .line 570
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "br"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 571
    const-string v0, "br"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 572
    sget-object v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    .line 573
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->fireSearch()V

    .line 574
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "brand_screen"

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 575
    return-void
.end method

.method public sortJustIn()V
    .locals 2

    .prologue
    .line 579
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 580
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    .line 581
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->isFilterApplied:Z

    .line 582
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "added_desc"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSortBy(Ljava/lang/String;)V

    .line 583
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "brj"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 584
    const-string v0, "brj"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 585
    sget-object v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    .line 586
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->fireSearch()V

    .line 587
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "brand_just_in_screen"

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 588
    return-void
.end method

.method public sortPriceDrop()V
    .locals 2

    .prologue
    .line 591
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 592
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->searchResultsData:Lcom/poshmark/data_model/models/SearchResults;

    .line 593
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->isFilterApplied:Z

    .line 594
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "price_drop"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSortBy(Ljava/lang/String;)V

    .line 595
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "brpd"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 596
    const-string v0, "brpd"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BrandFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 597
    sget-object v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment;->currentMode:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    .line 598
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->fireSearch()V

    .line 599
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "brand_price_drop_screen"

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 600
    return-void
.end method

.method public sortWidgetClicked(Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;)V
    .locals 2
    .param p1, "buttonType"    # Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    .prologue
    .line 604
    sget-object v0, Lcom/poshmark/ui/fragments/BrandFragment$10;->$SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 616
    :goto_0
    return-void

    .line 606
    :pswitch_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->sortAll()V

    goto :goto_0

    .line 609
    :pswitch_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->sortJustIn()V

    goto :goto_0

    .line 612
    :pswitch_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/BrandFragment;->sortPriceDrop()V

    goto :goto_0

    .line 604
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 0
    .param p1, "listing"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 543
    return-void
.end method
