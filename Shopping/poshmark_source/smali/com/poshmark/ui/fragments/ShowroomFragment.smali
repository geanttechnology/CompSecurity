.class public Lcom/poshmark/ui/fragments/ShowroomFragment;
.super Lcom/poshmark/ui/fragments/PMFilterableFragment;
.source "ShowroomFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;
.implements Lcom/poshmark/utils/CollectionSortWidgetListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/ShowroomFragment$8;,
        Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;
    }
.end annotation


# instance fields
.field private adapter:Landroid/widget/CursorAdapter;

.field private background:Landroid/graphics/drawable/Drawable;

.field currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

.field private filterWidgetLayout:Landroid/widget/LinearLayout;

.field private headerView:Landroid/view/View;

.field private showroom:Lcom/poshmark/data_model/models/Showroom;

.field private showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

.field private showroomId:Ljava/lang/String;

.field private showroomListView:Lcom/poshmark/ui/customviews/PMListView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;-><init>()V

    .line 54
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    .line 62
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ShowroomFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShowroomFragment;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->shareShowroom()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/ShowroomFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShowroomFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 50
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getShowroomListings(Z)V

    return-void
.end method

.method static synthetic access$202(Lcom/poshmark/ui/fragments/ShowroomFragment;Lcom/poshmark/data_model/models/Showroom;)Lcom/poshmark/data_model/models/Showroom;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShowroomFragment;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/Showroom;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    return-object p1
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/ShowroomFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShowroomFragment;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->updateHeaderView()V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/ShowroomFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShowroomFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 50
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/ShowroomFragment;->handleFilterResultsResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/ShowroomFragment;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShowroomFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->filterWidgetLayout:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$600(Lcom/poshmark/ui/fragments/ShowroomFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShowroomFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 50
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/ShowroomFragment;->handleShowroomListingsResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method private createShowroomHeaderView()V
    .locals 6

    .prologue
    .line 441
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/FeatureManager;->isShowroomPriceDropEnabled()Z

    move-result v2

    .line 443
    .local v2, "pdEnabled":Z
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 444
    .local v1, "inflater":Landroid/view/LayoutInflater;
    const v4, 0x7f0300ba

    const/4 v5, 0x0

    invoke-virtual {v1, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->headerView:Landroid/view/View;

    .line 445
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->headerView:Landroid/view/View;

    const v5, 0x7f0c0067

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 446
    .local v0, "container":Landroid/widget/LinearLayout;
    if-eqz v2, :cond_3

    .line 447
    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 448
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->headerView:Landroid/view/View;

    const v5, 0x7f0c0068

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/CollectionSortWidget;

    .line 449
    .local v3, "sortWidget":Lcom/poshmark/ui/customviews/CollectionSortWidget;
    invoke-virtual {v3, p0}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setSortSelectionListener(Lcom/poshmark/utils/CollectionSortWidgetListener;)V

    .line 450
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f06003c

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setLeftButtonText(Ljava/lang/String;)V

    .line 451
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f06015c

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setCenterButtonText(Ljava/lang/String;)V

    .line 452
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f06021b

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setRightButtonText(Ljava/lang/String;)V

    .line 453
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    sget-object v5, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    if-ne v4, v5, :cond_1

    .line 454
    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectCenterButton()V

    .line 463
    .end local v3    # "sortWidget":Lcom/poshmark/ui/customviews/CollectionSortWidget;
    :goto_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    if-eqz v4, :cond_0

    .line 464
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->updateHeaderView()V

    .line 466
    :cond_0
    return-void

    .line 455
    .restart local v3    # "sortWidget":Lcom/poshmark/ui/customviews/CollectionSortWidget;
    :cond_1
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    sget-object v5, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    if-ne v4, v5, :cond_2

    .line 456
    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectRightButton()V

    goto :goto_0

    .line 458
    :cond_2
    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectLeftButton()V

    goto :goto_0

    .line 461
    .end local v3    # "sortWidget":Lcom/poshmark/ui/customviews/CollectionSortWidget;
    :cond_3
    const/16 v4, 0x8

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method private getShowroomListings(Z)V
    .locals 1
    .param p1, "isPagination"    # Z

    .prologue
    .line 297
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->isFilterApplied:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    if-eqz v0, :cond_0

    .line 298
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShowroomFragment;->loadFilterResults(Z)V

    .line 303
    :goto_0
    return-void

    .line 301
    :cond_0
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShowroomFragment;->loadShowroomListings(Z)V

    goto :goto_0
.end method

.method private handleFilterResultsResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 6
    .param p2, "isPagination"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/ShowroomListings;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 346
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ShowroomListings;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->hideProgressDialog()V

    .line 347
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v2

    if-nez v2, :cond_2

    .line 348
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getLabelForAnalytics()Ljava/lang/String;

    move-result-object v1

    .line 349
    .local v1, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "listings_filtered"

    invoke-virtual {v2, v3, v4, v5, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 351
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMData;

    .line 352
    .local v0, "data":Lcom/poshmark/data_model/models/PMData;
    if-nez p2, :cond_1

    .line 353
    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v2, Lcom/poshmark/data_model/models/ShowroomListings;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    .line 354
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 355
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 358
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ShowroomListings;->getFacets()Lcom/poshmark/data_model/models/Facets;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ShowroomFragment;->saveFacetLists(Lcom/poshmark/data_model/models/Facets;)V

    .line 360
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 361
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ShowroomListings;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 362
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->showDefaultEmptyContentView()V

    .line 373
    .end local v0    # "data":Lcom/poshmark/data_model/models/PMData;
    .end local v1    # "label":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 366
    .restart local v0    # "data":Lcom/poshmark/data_model/models/PMData;
    .restart local v1    # "label":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-virtual {v2, v0}, Lcom/poshmark/data_model/models/ShowroomListings;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 367
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 371
    .end local v0    # "data":Lcom/poshmark/data_model/models/PMData;
    .end local v1    # "label":Ljava/lang/String;
    :cond_2
    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ShowroomFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private handleShowroomListingsResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 5
    .param p2, "isPagination"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/ShowroomListings;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 404
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ShowroomListings;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->hideProgressDialog()V

    .line 405
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_2

    .line 407
    if-nez p2, :cond_1

    .line 408
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/ShowroomListings;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    .line 409
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ShowroomListings;->createHashAndRemoveDups()V

    .line 410
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 411
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 412
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 413
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ShowroomListings;->getFacets()Lcom/poshmark/data_model/models/Facets;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->saveFacetLists(Lcom/poshmark/data_model/models/Facets;)V

    .line 414
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ShowroomListings;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 415
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->showDefaultEmptyContentView()V

    .line 427
    :cond_0
    :goto_0
    return-void

    .line 418
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/ShowroomListings;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 419
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 423
    :cond_2
    if-nez p2, :cond_0

    .line 424
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_SHOWROOM_LISTINGS:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0600ee

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private loadFilterResults(Z)V
    .locals 7
    .param p1, "isPagination"    # Z

    .prologue
    .line 306
    const/4 v2, 0x0

    .line 308
    .local v2, "nextPageMaxValue":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 309
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    if-eqz v4, :cond_0

    .line 310
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ShowroomListings;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    .line 311
    if-eqz v2, :cond_0

    .line 312
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    invoke-virtual {v4, v2}, Lcom/poshmark/utils/SearchFilterModel;->setNextPageId(Ljava/lang/String;)V

    .line 316
    :cond_0
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 317
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 318
    .local v1, "gson":Lcom/google/gson/Gson;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    instance-of v5, v1, Lcom/google/gson/Gson;

    if-nez v5, :cond_1

    invoke-virtual {v1, v4}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 320
    .end local v1    # "gson":Lcom/google/gson/Gson;
    .local v3, "searchString":Ljava/lang/String;
    :goto_0
    if-eqz p1, :cond_2

    .line 321
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomId:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lcom/poshmark/ui/fragments/ShowroomFragment$4;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/ShowroomFragment$4;-><init>(Lcom/poshmark/ui/fragments/ShowroomFragment;)V

    invoke-static {v4, v2, v3, v5, v6}, Lcom/poshmark/http/api/PMApi;->getShowroomListings(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 343
    :goto_1
    return-void

    .line 318
    .end local v3    # "searchString":Ljava/lang/String;
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v4}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 331
    .restart local v3    # "searchString":Ljava/lang/String;
    :cond_2
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 332
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomId:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lcom/poshmark/ui/fragments/ShowroomFragment$5;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/ShowroomFragment$5;-><init>(Lcom/poshmark/ui/fragments/ShowroomFragment;)V

    invoke-static {v4, v2, v3, v5, v6}, Lcom/poshmark/http/api/PMApi;->getShowroomListings(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_1
.end method

.method private loadShowroom()V
    .locals 2

    .prologue
    .line 281
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomId:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/ShowroomFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ShowroomFragment$3;-><init>(Lcom/poshmark/ui/fragments/ShowroomFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getShowroom(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 294
    return-void
.end method

.method private loadShowroomListings(Z)V
    .locals 5
    .param p1, "isPagination"    # Z

    .prologue
    const/4 v4, 0x0

    .line 376
    if-nez p1, :cond_0

    .line 377
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 378
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomId:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/ShowroomFragment$6;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ShowroomFragment$6;-><init>(Lcom/poshmark/ui/fragments/ShowroomFragment;)V

    invoke-static {v0, v4, v4, v1, v2}, Lcom/poshmark/http/api/PMApi;->getShowroomListings(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 401
    :goto_0
    return-void

    .line 390
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomId:Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ShowroomListings;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/ShowroomFragment$7;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ShowroomFragment$7;-><init>(Lcom/poshmark/ui/fragments/ShowroomFragment;)V

    invoke-static {v0, v1, v4, v2, v3}, Lcom/poshmark/http/api/PMApi;->getShowroomListings(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private setScreenTagBasedOnSearchType()V
    .locals 2

    .prologue
    .line 217
    const/4 v1, 0x0

    .line 218
    .local v1, "screenStackTag":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    .line 219
    .local v0, "model":Lcom/poshmark/utils/SearchFilterModel;
    if-eqz v0, :cond_0

    .line 220
    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v1

    .line 223
    :cond_0
    if-eqz v1, :cond_1

    .line 224
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ShowroomFragment;->setTrackingLabel(Ljava/lang/String;)V

    .line 226
    :cond_1
    return-void
.end method

.method private setupActionBarShareActionButton()V
    .locals 2

    .prologue
    .line 233
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v0

    .line 234
    .local v0, "nextActionButton":Landroid/widget/Button;
    if-nez v0, :cond_0

    .line 244
    :goto_0
    return-void

    .line 237
    :cond_0
    const v1, 0x7f06024e

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 238
    new-instance v1, Lcom/poshmark/ui/fragments/ShowroomFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ShowroomFragment$1;-><init>(Lcom/poshmark/ui/fragments/ShowroomFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method private setupListView()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 247
    new-instance v0, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, -0x80000000

    invoke-direct {v0, v1, p0, v5, v2}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->adapter:Landroid/widget/CursorAdapter;

    .line 249
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->createShowroomHeaderView()V

    .line 250
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c025a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 251
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->headerView:Landroid/view/View;

    const v1, 0x7f0c0069

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->filterWidgetLayout:Landroid/widget/LinearLayout;

    .line 252
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->headerView:Landroid/view/View;

    const v1, 0x7f0c006a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    .line 253
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v0, p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setOwnerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 254
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->adapter:Landroid/widget/CursorAdapter;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->headerView:Landroid/view/View;

    new-instance v3, Lcom/poshmark/ui/fragments/ShowroomFragment$2;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ShowroomFragment$2;-><init>(Lcom/poshmark/ui/fragments/ShowroomFragment;)V

    invoke-virtual {v0, v1, v2, v5, v3}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 261
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    if-eqz v0, :cond_0

    .line 262
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 263
    invoke-direct {p0, v4}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getShowroomListings(Z)V

    .line 266
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    if-eqz v0, :cond_1

    .line 267
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 268
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->filterWidgetLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 269
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->hideFilterButtonsForSingleFacet()V

    .line 271
    :cond_1
    return-void
.end method

.method private shareShowroom()V
    .locals 4

    .prologue
    .line 274
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 275
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 276
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 277
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 278
    return-void
.end method

.method private updateHeaderView()V
    .locals 6

    .prologue
    .line 469
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->headerView:Landroid/view/View;

    const v5, 0x7f0c02d2

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 470
    .local v1, "coverShot":Landroid/widget/ImageView;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    .line 471
    .local v2, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getCoverShot()Lcom/poshmark/data_model/models/inner_models/CoverShot;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url:Ljava/lang/String;

    invoke-virtual {v2, v4, v1}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 473
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->headerView:Landroid/view/View;

    const v5, 0x7f0c0062

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 474
    .local v0, "bgView":Landroid/widget/ImageView;
    if-eqz v0, :cond_0

    .line 475
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getCoverShot()Lcom/poshmark/data_model/models/inner_models/CoverShot;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url:Ljava/lang/String;

    invoke-virtual {v2, v4, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 478
    :cond_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->headerView:Landroid/view/View;

    const v5, 0x7f0c0241

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    .line 479
    .local v3, "titleTextView":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 480
    return-void
.end method


# virtual methods
.method public filterContent()V
    .locals 1

    .prologue
    .line 437
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    .line 438
    return-void
.end method

.method public fireSearch()V
    .locals 1

    .prologue
    .line 430
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->isFilterApplied:Z

    .line 431
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 432
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->loadFilterResults(Z)V

    .line 433
    return-void
.end method

.method public getFilterModel()Lcom/poshmark/utils/SearchFilterModel;
    .locals 1

    .prologue
    .line 213
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    return-object v0
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 209
    const-string v0, "shr"

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 483
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->handleNotification(Landroid/content/Intent;)V

    .line 484
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    const-string v4, "com.poshmark.intents.SEARCH_FILTER_ACTION"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 485
    const-string v3, "RESULT"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 486
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "PARENT_ID"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/os/ParcelUuid;

    .line 487
    .local v2, "uuidParcel":Landroid/os/ParcelUuid;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v2}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 488
    const-string v3, "SEARCH_FILTER_MODEL_JSON"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 489
    .local v1, "json":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->fireSearch()V

    .line 492
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "json":Ljava/lang/String;
    .end local v2    # "uuidParcel":Landroid/os/ParcelUuid;
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 191
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 192
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->setupListView()V

    .line 193
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    if-nez v0, :cond_0

    .line 194
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->loadShowroom()V

    .line 196
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x1

    .line 67
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreate(Landroid/os/Bundle;)V

    .line 68
    const-class v4, Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .line 69
    .local v0, "e":Ljava/lang/Object;
    if-eqz v0, :cond_2

    .line 70
    check-cast v0, Lcom/poshmark/data_model/models/Showroom;

    .end local v0    # "e":Ljava/lang/Object;
    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    .line 71
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomId:Ljava/lang/String;

    .line 76
    :goto_0
    iput-boolean v6, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->isFilterApplied:Z

    .line 77
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    const-string v5, "available"

    invoke-static {v5}, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;->getAvailabilityMetaItemFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/FilterResultsManager;->updateAvailability(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 80
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v3

    .line 81
    .local v3, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v3, :cond_0

    iget-object v4, v3, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 82
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    invoke-virtual {v4, v6}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 86
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v4

    const-string v5, "MODE"

    invoke-virtual {v4, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 87
    .local v1, "modeString":Ljava/lang/String;
    if-nez v1, :cond_5

    .line 89
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->getSortBy()Ljava/lang/String;

    move-result-object v2

    .line 90
    .local v2, "sort_by_clause":Ljava/lang/String;
    if-eqz v2, :cond_3

    const-string v4, "added_desc"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 91
    sget-object v4, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    iput-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    .line 92
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    const-string v5, "shrj"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 111
    .end local v2    # "sort_by_clause":Ljava/lang/String;
    :cond_1
    :goto_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/ShowroomFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 113
    return-void

    .line 73
    .end local v1    # "modeString":Ljava/lang/String;
    .end local v3    # "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    .restart local v0    # "e":Ljava/lang/Object;
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v4

    const-string v5, "ID"

    invoke-virtual {v4, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomId:Ljava/lang/String;

    .line 74
    invoke-static {}, Lcom/poshmark/controllers/ShowroomsController;->getGlobalShowroomsController()Lcom/poshmark/controllers/ShowroomsController;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomId:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/poshmark/controllers/ShowroomsController;->getShowroomWithId(Ljava/lang/String;)Lcom/poshmark/data_model/models/Showroom;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;

    goto :goto_0

    .line 93
    .end local v0    # "e":Ljava/lang/Object;
    .restart local v1    # "modeString":Ljava/lang/String;
    .restart local v2    # "sort_by_clause":Ljava/lang/String;
    .restart local v3    # "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    :cond_3
    if-eqz v2, :cond_4

    const-string v4, "price_drop"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 94
    sget-object v4, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    iput-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    .line 95
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    const-string v5, "shrpd"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1

    .line 97
    :cond_4
    sget-object v4, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    iput-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    .line 98
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    const-string v5, "shr"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1

    .line 101
    .end local v2    # "sort_by_clause":Ljava/lang/String;
    :cond_5
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    .line 102
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    sget-object v5, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    if-ne v4, v5, :cond_6

    .line 103
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    const-string v5, "added_desc"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel;->setSortBy(Ljava/lang/String;)V

    .line 104
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    const-string v5, "shrj"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1

    .line 105
    :cond_6
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    sget-object v5, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    if-ne v4, v5, :cond_7

    .line 106
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    const-string v5, "shr"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto :goto_1

    .line 107
    :cond_7
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    sget-object v5, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    if-ne v4, v5, :cond_1

    .line 108
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    const-string v5, "shrpd"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 117
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 118
    const v1, 0x7f0300bc

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 119
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 176
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPause()V

    .line 177
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 187
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 150
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onResume()V

    .line 151
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.SEARCH_FILTER_ACTION"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 152
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    if-eqz v0, :cond_0

    .line 153
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 172
    :cond_0
    return-void
.end method

.method protected pullParametersFromState(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 124
    if-nez p1, :cond_0

    .line 125
    const-class v3, Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/SearchFilterModel;

    .line 126
    .local v0, "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    if-eqz v0, :cond_1

    .line 127
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/poshmark/utils/FilterResultsManager;->setSearchModel(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 144
    .end local v0    # "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    :cond_0
    :goto_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->setScreenTagBasedOnSearchType()V

    .line 145
    return-void

    .line 129
    .restart local v0    # "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    :cond_1
    new-instance v1, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v1}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 130
    .local v1, "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v3, "available"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 132
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v2

    .line 133
    .local v2, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v2, :cond_2

    iget-object v3, v2, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 134
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 136
    :cond_2
    const-string v3, "category_v2"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 137
    const-string v3, "category_feature"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 138
    const-string v3, "brand"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 139
    const-string v3, "size"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 140
    const-string v3, "color"

    invoke-virtual {v1, v3}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 141
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/poshmark/utils/FilterResultsManager;->setSearchModel(Lcom/poshmark/utils/SearchFilterModel;)V

    goto :goto_0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 229
    const-string v0, "showroom_feed_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 230
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 200
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 201
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->setupActionBar()V

    .line 202
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->setupActionBarShareActionButton()V

    .line 203
    const v0, 0x7f06026e

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->setTitle(I)V

    .line 205
    :cond_0
    return-void
.end method

.method public sortAll()V
    .locals 2

    .prologue
    .line 495
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 496
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    .line 497
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->isFilterApplied:Z

    .line 498
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearSortBy()V

    .line 499
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "shr"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 500
    const-string v0, "shr"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 501
    sget-object v0, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    .line 502
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->fireSearch()V

    .line 503
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "showroom_feed_screen"

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 504
    return-void
.end method

.method public sortJustIn()V
    .locals 2

    .prologue
    .line 507
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 508
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    .line 509
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->isFilterApplied:Z

    .line 510
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "added_desc"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSortBy(Ljava/lang/String;)V

    .line 511
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "shrj"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 512
    const-string v0, "shrj"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 513
    sget-object v0, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    .line 514
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->fireSearch()V

    .line 515
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "showroom_just_in_screen"

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 516
    return-void
.end method

.method public sortPriceDrop()V
    .locals 2

    .prologue
    .line 519
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 520
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->showroomData:Lcom/poshmark/data_model/models/ShowroomListings;

    .line 521
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->isFilterApplied:Z

    .line 522
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "price_drop"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSortBy(Ljava/lang/String;)V

    .line 523
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "shrpd"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 524
    const-string v0, "shrpd"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 525
    sget-object v0, Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment;->currentMode:Lcom/poshmark/ui/fragments/ShowroomFragment$MODE;

    .line 526
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->fireSearch()V

    .line 527
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "showroom_price_drop_screen"

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 528
    return-void
.end method

.method public sortWidgetClicked(Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;)V
    .locals 2
    .param p1, "buttonType"    # Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    .prologue
    .line 532
    sget-object v0, Lcom/poshmark/ui/fragments/ShowroomFragment$8;->$SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 544
    :goto_0
    return-void

    .line 534
    :pswitch_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->sortAll()V

    goto :goto_0

    .line 537
    :pswitch_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->sortJustIn()V

    goto :goto_0

    .line 540
    :pswitch_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->sortPriceDrop()V

    goto :goto_0

    .line 532
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
