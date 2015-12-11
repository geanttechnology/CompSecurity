.class public Lcom/poshmark/ui/fragments/MyLikesFragment;
.super Lcom/poshmark/ui/fragments/PMFilterableFragment;
.source "MyLikesFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/ListingNotificationHandler;
.implements Lcom/poshmark/utils/CollectionSortWidgetListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/MyLikesFragment$12;,
        Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;
    }
.end annotation


# static fields
.field private static screenTag:Ljava/lang/String;


# instance fields
.field private adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

.field backgroundBmp:Landroid/graphics/Bitmap;

.field private bundlesAdapter:Lcom/poshmark/data_model/adapters/BundlesAdapter;

.field private callFromUserSettings:Z

.field currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

.field headerView:Landroid/view/View;

.field private myBundles:Lcom/poshmark/data_model/models/MyBundles;

.field private myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

.field private myLikes:Lcom/poshmark/data_model/models/MyLikes;

.field private myLikesListView:Lcom/poshmark/ui/customviews/PMListView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 62
    const-string v0, "mlk"

    sput-object v0, Lcom/poshmark/ui/fragments/MyLikesFragment;->screenTag:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 54
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;-><init>()V

    .line 56
    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 60
    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    .line 64
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/MyLikesFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MyLikesFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 54
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getMyLikes(Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/MyLikesFragment;)Lcom/poshmark/data_model/adapters/BundlesAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MyLikesFragment;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->bundlesAdapter:Lcom/poshmark/data_model/adapters/BundlesAdapter;

    return-object v0
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/MyLikesFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MyLikesFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 54
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/MyLikesFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/MyLikesFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MyLikesFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 54
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/MyLikesFragment;->handleMyBundlesApiResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method private getMyBundles(Z)V
    .locals 3
    .param p1, "isPagination"    # Z

    .prologue
    .line 403
    if-nez p1, :cond_1

    .line 404
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 405
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060190

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 406
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v0

    .line 407
    .local v0, "searchString":Ljava/lang/String;
    const/4 v1, 0x0

    new-instance v2, Lcom/poshmark/ui/fragments/MyLikesFragment$9;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/MyLikesFragment$9;-><init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V

    invoke-static {v1, v2}, Lcom/poshmark/http/api/PMApi;->getMyBundles(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 427
    .end local v0    # "searchString":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 416
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundles:Lcom/poshmark/data_model/models/MyBundles;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MyBundles;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 417
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundles:Lcom/poshmark/data_model/models/MyBundles;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MyBundles;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/MyLikesFragment$10;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/MyLikesFragment$10;-><init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V

    invoke-static {v1, v2}, Lcom/poshmark/http/api/PMApi;->getMyBundles(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private getMyLikes(Z)V
    .locals 5
    .param p1, "isPagination"    # Z

    .prologue
    const v3, 0x7f060190

    const/4 v4, 0x0

    .line 339
    if-nez p1, :cond_2

    .line 340
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->isFilterApplied:Z

    if-eqz v2, :cond_1

    .line 341
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 342
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 343
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v1

    .line 344
    .local v1, "searchString":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/MyLikesFragment$5;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/MyLikesFragment$5;-><init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V

    invoke-static {v4, v1, v2, v3}, Lcom/poshmark/http/api/PMApi;->getMyLikedListingsFiltered(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 400
    .end local v1    # "searchString":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 356
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 357
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 358
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v1

    .line 359
    .restart local v1    # "searchString":Ljava/lang/String;
    new-instance v2, Lcom/poshmark/ui/fragments/MyLikesFragment$6;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/MyLikesFragment$6;-><init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V

    invoke-static {v4, v2}, Lcom/poshmark/http/api/PMApi;->getMyLikedListings(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 370
    .end local v1    # "searchString":Ljava/lang/String;
    :cond_2
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->isFilterApplied:Z

    if-eqz v2, :cond_3

    .line 371
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MyLikes;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 372
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    .line 373
    .local v0, "model":Lcom/poshmark/utils/SearchFilterModel;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MyLikes;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/poshmark/utils/SearchFilterModel;->setNextPageId(Ljava/lang/String;)V

    .line 374
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v1

    .line 375
    .restart local v1    # "searchString":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MyLikes;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/MyLikesFragment$7;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/MyLikesFragment$7;-><init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V

    invoke-static {v2, v1, v4, v3}, Lcom/poshmark/http/api/PMApi;->getMyLikedListingsFiltered(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 385
    .end local v0    # "model":Lcom/poshmark/utils/SearchFilterModel;
    .end local v1    # "searchString":Ljava/lang/String;
    :cond_3
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MyLikes;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 386
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    .line 387
    .restart local v0    # "model":Lcom/poshmark/utils/SearchFilterModel;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MyLikes;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/poshmark/utils/SearchFilterModel;->setNextPageId(Ljava/lang/String;)V

    .line 388
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v1

    .line 389
    .restart local v1    # "searchString":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MyLikes;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/MyLikesFragment$8;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/MyLikesFragment$8;-><init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V

    invoke-static {v2, v3}, Lcom/poshmark/http/api/PMApi;->getMyLikedListings(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private handleMyBundlesApiResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 5
    .param p2, "isPagination"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/MyBundles;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 452
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/MyBundles;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->hideProgressDialog()V

    .line 453
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_2

    .line 454
    if-nez p2, :cond_1

    .line 455
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/MyBundles;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundles:Lcom/poshmark/data_model/models/MyBundles;

    .line 456
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundles:Lcom/poshmark/data_model/models/MyBundles;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 457
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 458
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 459
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundles:Lcom/poshmark/data_model/models/MyBundles;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MyBundles;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 460
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showEmptyMyBundlesMessage()V

    .line 471
    :cond_0
    :goto_0
    return-void

    .line 463
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundles:Lcom/poshmark/data_model/models/MyBundles;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/MyBundles;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 464
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 467
    :cond_2
    if-nez p2, :cond_0

    .line 468
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_MY_LIKES:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0600e8

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 5
    .param p2, "isPagination"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/MyLikes;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 430
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/MyLikes;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->hideProgressDialog()V

    .line 431
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_2

    .line 432
    if-nez p2, :cond_1

    .line 433
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/MyLikes;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    .line 434
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 435
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 436
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 437
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MyLikes;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 438
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->showDefaultEmptyContentView()V

    .line 449
    :cond_0
    :goto_0
    return-void

    .line 441
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/MyLikes;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 442
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 445
    :cond_2
    if-nez p2, :cond_0

    .line 446
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_MY_LIKES:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0600e8

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private setScreenTagBasedOnSearchType()V
    .locals 2

    .prologue
    .line 301
    const/4 v1, 0x0

    .line 302
    .local v1, "screenStackTag":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    .line 303
    .local v0, "model":Lcom/poshmark/utils/SearchFilterModel;
    if-eqz v0, :cond_0

    .line 304
    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v1

    .line 307
    :cond_0
    if-eqz v1, :cond_1

    .line 308
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MyLikesFragment;->setTrackingLabel(Ljava/lang/String;)V

    .line 310
    :cond_1
    return-void
.end method

.method private setupHeaderView(Landroid/view/View;)Landroid/view/View;
    .locals 10
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    const/16 v9, 0x8

    .line 474
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/FeatureManager;->isBrandPriceDropEnabled()Z

    move-result v4

    .line 475
    .local v4, "pdEnabled":Z
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/FeatureManager;->isMyLikesFiltersEnabled()Z

    move-result v1

    .line 476
    .local v1, "filteringEnabled":Z
    if-nez v4, :cond_0

    if-eqz v1, :cond_1

    .line 477
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    invoke-static {v7}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 478
    .local v3, "inflater":Landroid/view/LayoutInflater;
    const v7, 0x7f03008b

    invoke-virtual {v3, v7, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 479
    .local v2, "headerLayout":Landroid/view/View;
    const v7, 0x7f0c020a

    invoke-virtual {v2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/FrameLayout;

    .line 480
    .local v6, "sortWidgetContainer":Landroid/widget/FrameLayout;
    if-eqz v4, :cond_4

    .line 481
    const v7, 0x7f0c0068

    invoke-virtual {v2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/CollectionSortWidget;

    .line 482
    .local v5, "sortWidget":Lcom/poshmark/ui/customviews/CollectionSortWidget;
    invoke-virtual {v5, p0}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setSortSelectionListener(Lcom/poshmark/utils/CollectionSortWidgetListener;)V

    .line 483
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f06003c

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setLeftButtonText(Ljava/lang/String;)V

    .line 484
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f060068

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setCenterButtonText(Ljava/lang/String;)V

    .line 485
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f06021b

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setRightButtonText(Ljava/lang/String;)V

    .line 486
    iget-object v7, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    sget-object v8, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->BUNDLES:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    if-ne v7, v8, :cond_2

    .line 487
    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectCenterButton()V

    .line 498
    .end local v5    # "sortWidget":Lcom/poshmark/ui/customviews/CollectionSortWidget;
    :goto_0
    const v7, 0x7f0c0069

    invoke-virtual {v2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 499
    .local v0, "filterWidgetContainer":Landroid/widget/LinearLayout;
    if-eqz v1, :cond_5

    .line 500
    const v7, 0x7f0c006a

    invoke-virtual {v2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    iput-object v7, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    .line 501
    iget-object v7, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v7, p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setOwnerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 507
    .end local v0    # "filterWidgetContainer":Landroid/widget/LinearLayout;
    .end local v2    # "headerLayout":Landroid/view/View;
    .end local v3    # "inflater":Landroid/view/LayoutInflater;
    .end local v6    # "sortWidgetContainer":Landroid/widget/FrameLayout;
    :cond_1
    :goto_1
    return-object v2

    .line 488
    .restart local v2    # "headerLayout":Landroid/view/View;
    .restart local v3    # "inflater":Landroid/view/LayoutInflater;
    .restart local v5    # "sortWidget":Lcom/poshmark/ui/customviews/CollectionSortWidget;
    .restart local v6    # "sortWidgetContainer":Landroid/widget/FrameLayout;
    :cond_2
    iget-object v7, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    sget-object v8, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    if-ne v7, v8, :cond_3

    .line 489
    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectRightButton()V

    goto :goto_0

    .line 491
    :cond_3
    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectLeftButton()V

    goto :goto_0

    .line 494
    .end local v5    # "sortWidget":Lcom/poshmark/ui/customviews/CollectionSortWidget;
    :cond_4
    invoke-virtual {v6, v9}, Landroid/widget/FrameLayout;->setVisibility(I)V

    goto :goto_0

    .line 503
    .restart local v0    # "filterWidgetContainer":Landroid/widget/LinearLayout;
    :cond_5
    invoke-virtual {v0, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_1
.end method

.method private setupMyLikesList()V
    .locals 4

    .prologue
    const v3, 0x7f060190

    const/4 v2, 0x0

    .line 513
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->BUNDLES:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    if-eq v0, v1, :cond_3

    .line 514
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 515
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->bUpdateOnShow:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    if-nez v0, :cond_2

    .line 516
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 517
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 518
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getMyLikes(Z)V

    .line 541
    :cond_1
    :goto_0
    return-void

    .line 522
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 523
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MyLikes;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 524
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showEmptyMyLikesMessage()V

    goto :goto_0

    .line 528
    :cond_3
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 529
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->bUpdateOnShow:Z

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundles:Lcom/poshmark/data_model/models/MyBundles;

    if-nez v0, :cond_5

    .line 530
    :cond_4
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 531
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 532
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getMyBundles(Z)V

    goto :goto_0

    .line 535
    :cond_5
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 536
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundles:Lcom/poshmark/data_model/models/MyBundles;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MyBundles;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 537
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showEmptyMyBundlesMessage()V

    goto :goto_0
.end method

.method private showEmptyMyBundlesMessage()V
    .locals 5

    .prologue
    .line 551
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 552
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v3, 0x7f03003c

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 553
    .local v2, "linearLayout":Landroid/widget/LinearLayout;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v3, v2}, Lcom/poshmark/ui/customviews/PMListView;->showEmptyContentView(Landroid/view/View;)V

    .line 554
    const v3, 0x7f0c010c

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMButton;

    .line 555
    .local v1, "learnMoreButton":Lcom/poshmark/ui/customviews/PMButton;
    new-instance v3, Lcom/poshmark/ui/fragments/MyLikesFragment$11;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/MyLikesFragment$11;-><init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V

    invoke-virtual {v1, v3}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 565
    return-void
.end method

.method private showEmptyMyLikesMessage()V
    .locals 4

    .prologue
    .line 544
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 545
    .local v0, "inflater":Landroid/view/LayoutInflater;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMListView;->getHeaderViewsCount()I

    move-result v1

    if-nez v1, :cond_0

    .line 546
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    const v2, 0x7f03003d

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMListView;->showEmptyContentView(Landroid/view/View;)V

    .line 548
    :cond_0
    return-void
.end method


# virtual methods
.method public addCommentToListing(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 584
    return-void
.end method

.method public deleteListing(Ljava/lang/String;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 593
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->bUpdateOnShow:Z

    .line 594
    return-void
.end method

.method public filterContent()V
    .locals 1

    .prologue
    .line 284
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 285
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    .line 286
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->isFilterApplied:Z

    .line 287
    return-void
.end method

.method public fireSearch()V
    .locals 2

    .prologue
    .line 291
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 292
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->closeDrawer()V

    .line 293
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getMyLikes(Z)V

    .line 294
    return-void
.end method

.method public getFilterModel()Lcom/poshmark/utils/SearchFilterModel;
    .locals 1

    .prologue
    .line 297
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    return-object v0
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 324
    sget-object v0, Lcom/poshmark/ui/fragments/MyLikesFragment;->screenTag:Ljava/lang/String;

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v3, 0x0

    .line 247
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.poshmark.intents.FILTER_SELECTION_ACTION"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 248
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->facetsAvailable()Z

    move-result v1

    if-nez v1, :cond_2

    .line 249
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 251
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    const-string v2, "1"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->setCount(Ljava/lang/String;)V

    .line 252
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v0

    .line 253
    .local v0, "filterQuery":Ljava/lang/String;
    new-instance v1, Lcom/poshmark/ui/fragments/MyLikesFragment$4;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/ui/fragments/MyLikesFragment$4;-><init>(Lcom/poshmark/ui/fragments/MyLikesFragment;Landroid/content/Intent;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getMyLikesFacets(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 274
    .end local v0    # "filterQuery":Ljava/lang/String;
    :cond_0
    :goto_0
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 275
    iput-object v3, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    .line 279
    :cond_1
    :goto_1
    return-void

    .line 269
    :cond_2
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->handleNotification(Landroid/content/Intent;)V

    goto :goto_0

    .line 276
    :cond_3
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 277
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->bUpdateOnShow:Z

    goto :goto_1
.end method

.method public likeListing(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "likeStatus"    # Z

    .prologue
    .line 588
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->bUpdateOnShow:Z

    .line 589
    return-void
.end method

.method public newListingCreated()V
    .locals 0

    .prologue
    .line 599
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 187
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 188
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x0

    const/4 v5, 0x1

    const/high16 v7, -0x80000000

    .line 72
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreate(Landroid/os/Bundle;)V

    .line 75
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    .line 76
    .local v1, "b":Landroid/os/Bundle;
    if-eqz v1, :cond_0

    .line 77
    const-string v4, "callFromUserSettings"

    invoke-virtual {v1, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    move v4, v5

    :goto_0
    iput-boolean v4, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->callFromUserSettings:Z

    .line 80
    :cond_0
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v4

    const-string v6, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v4, v6, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 81
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v4

    const-string v6, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v4, v6, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 82
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v4

    invoke-virtual {v4, p0}, Lcom/poshmark/notifications/ListingNotificationManager;->registerListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V

    .line 84
    new-instance v4, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-direct {v4, v6, p0, v8, v7}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V

    iput-object v4, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 85
    new-instance v4, Lcom/poshmark/data_model/adapters/BundlesAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-direct {v4, v6, p0, v8, v7}, Lcom/poshmark/data_model/adapters/BundlesAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V

    iput-object v4, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->bundlesAdapter:Lcom/poshmark/data_model/adapters/BundlesAdapter;

    .line 86
    iput-boolean v5, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->bUpdateOnShow:Z

    .line 89
    const/4 v2, 0x0

    .line 90
    .local v2, "modeString":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 91
    .local v0, "args":Landroid/os/Bundle;
    if-eqz v0, :cond_1

    .line 92
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v4

    const-string v5, "MODE"

    invoke-virtual {v4, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 94
    :cond_1
    if-nez v2, :cond_4

    .line 96
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->getSortBy()Ljava/lang/String;

    move-result-object v3

    .line 97
    .local v3, "sort_by_clause":Ljava/lang/String;
    if-eqz v3, :cond_3

    const-string v4, "price_drop"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 98
    sget-object v4, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    iput-object v4, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    .line 99
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    const-string v5, "mlkpd"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 100
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/MyLikesFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 119
    .end local v3    # "sort_by_clause":Ljava/lang/String;
    :goto_1
    return-void

    .line 77
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v2    # "modeString":Ljava/lang/String;
    :cond_2
    const/4 v4, 0x0

    goto :goto_0

    .line 102
    .restart local v0    # "args":Landroid/os/Bundle;
    .restart local v2    # "modeString":Ljava/lang/String;
    .restart local v3    # "sort_by_clause":Ljava/lang/String;
    :cond_3
    sget-object v4, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    iput-object v4, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    .line 103
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    const-string v5, "mlk"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 104
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/MyLikesFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    goto :goto_1

    .line 107
    .end local v3    # "sort_by_clause":Ljava/lang/String;
    :cond_4
    invoke-static {v2}, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    .line 108
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    sget-object v5, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    if-ne v4, v5, :cond_5

    .line 109
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    const-string v5, "mlk"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 110
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/MyLikesFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    goto :goto_1

    .line 111
    :cond_5
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    sget-object v5, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    if-ne v4, v5, :cond_6

    .line 112
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    const-string v5, "mlkpd"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 113
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->getSearchTrigger()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/MyLikesFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    goto :goto_1

    .line 115
    :cond_6
    const-string v4, "mbnd"

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/MyLikesFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 123
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 124
    const v1, 0x7f03008d

    invoke-virtual {p1, v1, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 125
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c020e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 126
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->setupHeaderView(Landroid/view/View;)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->headerView:Landroid/view/View;

    .line 127
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->headerView:Landroid/view/View;

    new-instance v4, Lcom/poshmark/ui/fragments/MyLikesFragment$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/MyLikesFragment$1;-><init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V

    invoke-virtual {v1, v2, v3, v6, v4}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 133
    const v1, 0x7f0c020f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 134
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->bundlesAdapter:Lcom/poshmark/data_model/adapters/BundlesAdapter;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->headerView:Landroid/view/View;

    new-instance v4, Lcom/poshmark/ui/fragments/MyLikesFragment$2;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/MyLikesFragment$2;-><init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V

    invoke-virtual {v1, v2, v3, v6, v4}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 140
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    new-instance v2, Lcom/poshmark/ui/fragments/MyLikesFragment$3;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/MyLikesFragment$3;-><init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 156
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    sget-object v2, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->BUNDLES:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    if-ne v1, v2, :cond_0

    .line 157
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v1, v5}, Lcom/poshmark/ui/customviews/PMListView;->setVisibility(I)V

    .line 158
    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showFilterWidget(Z)V

    .line 163
    :goto_0
    return-object v0

    .line 160
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v1, v5}, Lcom/poshmark/ui/customviews/PMListView;->setVisibility(I)V

    .line 161
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showFilterWidget(Z)V

    goto :goto_0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 192
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onDestroyView()V

    .line 193
    return-void
.end method

.method public onPMResume()V
    .locals 6

    .prologue
    .line 197
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPMResume()V

    .line 198
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getUserVisibleHint()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 200
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->setupMyLikesList()V

    .line 201
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->bUpdateOnShow:Z

    .line 206
    :cond_0
    :try_start_0
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->headerView:Landroid/view/View;

    if-eqz v3, :cond_1

    .line 207
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v3

    invoke-interface {v3}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Display;->getWidth()I

    move-result v2

    .line 208
    .local v2, "width":I
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const/high16 v4, 0x42f00000    # 120.0f

    invoke-static {v3, v4}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v3

    float-to-int v0, v3

    .line 209
    .local v0, "height":I
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f020112

    const/4 v5, 0x1

    invoke-static {v3, v4, v2, v0, v5}, Lcom/poshmark/utils/ImageUtils;->loadScaledBitmapFromResource(Landroid/content/res/Resources;IIIZ)Landroid/graphics/Bitmap;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    .line 210
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    if-eqz v3, :cond_1

    .line 211
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c0062

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 212
    .local v1, "img":Landroid/widget/ImageView;
    if-eqz v1, :cond_1

    .line 213
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 221
    .end local v0    # "height":I
    .end local v1    # "img":Landroid/widget/ImageView;
    .end local v2    # "width":I
    :cond_1
    :goto_0
    return-void

    .line 218
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method public onPause()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 225
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPause()V

    .line 226
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 227
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->headerView:Landroid/view/View;

    if-eqz v1, :cond_1

    .line 228
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    if-eqz v1, :cond_1

    .line 229
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->headerView:Landroid/view/View;

    const v2, 0x7f0c0062

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 230
    .local v0, "img":Landroid/widget/ImageView;
    if-eqz v0, :cond_0

    .line 231
    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 233
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->recycle()V

    .line 234
    iput-object v3, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    .line 237
    .end local v0    # "img":Landroid/widget/ImageView;
    :cond_1
    return-void
.end method

.method protected pullParametersFromState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 168
    if-nez p1, :cond_0

    .line 169
    const-class v2, Lcom/poshmark/utils/SearchFilterModel;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/SearchFilterModel;

    .line 170
    .local v0, "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    if-eqz v0, :cond_1

    .line 171
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/poshmark/utils/FilterResultsManager;->setSearchModel(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 183
    .end local v0    # "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    :cond_0
    :goto_0
    return-void

    .line 173
    .restart local v0    # "currentSearchFilter":Lcom/poshmark/utils/SearchFilterModel;
    :cond_1
    new-instance v1, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v1}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 174
    .local v1, "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v2, "category_v2"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 175
    const-string v2, "category_feature"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 176
    const-string v2, "color"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 177
    const-string v2, "size"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 178
    const-string v2, "brand"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 179
    const-string v2, "mlk"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 180
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/poshmark/utils/FilterResultsManager;->setSearchModel(Lcom/poshmark/utils/SearchFilterModel;)V

    goto :goto_0
.end method

.method public setActionBarTitle()V
    .locals 4

    .prologue
    .line 314
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 315
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    .line 316
    .local v1, "customView":Landroid/view/View;
    const v3, 0x7f0c0035

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 317
    .local v2, "titleView":Landroid/widget/TextView;
    const v3, 0x7f0601b2

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 318
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 319
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 2

    .prologue
    .line 329
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->BUNDLES:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    if-ne v0, v1, :cond_1

    .line 330
    const-string v0, "my_bundles_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 336
    :cond_0
    :goto_0
    return-void

    .line 331
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    if-ne v0, v1, :cond_2

    .line 332
    const-string v0, "listings_liked_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 333
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    if-ne v0, v1, :cond_0

    .line 334
    const-string v0, "listings_liked_price_drop_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0
.end method

.method public setupActionBar()V
    .locals 0

    .prologue
    .line 241
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->setupActionBar()V

    .line 242
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->setActionBarTitle()V

    .line 243
    return-void
.end method

.method public showBundles()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 617
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "my_bundles_screen"

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 618
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "my_bundles_screen"

    const-string v2, "bundle"

    const-string v3, "view_my_bundles_tapped"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 619
    sget-object v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->BUNDLES:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    .line 620
    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showFilterWidget(Z)V

    .line 621
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setVisibility(I)V

    .line 622
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0, v5}, Lcom/poshmark/ui/customviews/PMListView;->setVisibility(I)V

    .line 623
    const-string v0, "mbnd"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 624
    invoke-direct {p0, v5}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getMyBundles(Z)V

    .line 625
    return-void
.end method

.method public showFilterWidget(Z)V
    .locals 3
    .param p1, "show"    # Z

    .prologue
    .line 568
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->headerView:Landroid/view/View;

    const v2, 0x7f0c0069

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 569
    .local v0, "filterWidgetContainer":Landroid/widget/LinearLayout;
    if-eqz p1, :cond_0

    .line 570
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 574
    :goto_0
    return-void

    .line 572
    :cond_0
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public sortAll()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 602
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setVisibility(I)V

    .line 603
    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showFilterWidget(Z)V

    .line 604
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setVisibility(I)V

    .line 605
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 606
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    .line 607
    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->isFilterApplied:Z

    .line 608
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearSortBy()V

    .line 609
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "mlk"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 610
    const-string v0, "mlk"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 611
    sget-object v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    .line 612
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->fireSearch()V

    .line 613
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "listings_liked_screen"

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 614
    return-void
.end method

.method public sortPriceDrop()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 628
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikesListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setVisibility(I)V

    .line 629
    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showFilterWidget(Z)V

    .line 630
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myBundlesListView:Lcom/poshmark/ui/customviews/PMListView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setVisibility(I)V

    .line 631
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/SearchFilterModel;->clearNextPageId()V

    .line 632
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->myLikes:Lcom/poshmark/data_model/models/MyLikes;

    .line 633
    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->isFilterApplied:Z

    .line 634
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "price_drop"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSortBy(Ljava/lang/String;)V

    .line 635
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v0

    const-string v1, "mlkpd"

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 636
    const-string v0, "mlkpd"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 637
    sget-object v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment;->currentMode:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    .line 638
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->fireSearch()V

    .line 639
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "listings_liked_price_drop_screen"

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 640
    return-void
.end method

.method public sortWidgetClicked(Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;)V
    .locals 2
    .param p1, "buttonType"    # Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    .prologue
    .line 644
    sget-object v0, Lcom/poshmark/ui/fragments/MyLikesFragment$12;->$SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 656
    :goto_0
    return-void

    .line 646
    :pswitch_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->sortAll()V

    goto :goto_0

    .line 649
    :pswitch_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->showBundles()V

    goto :goto_0

    .line 652
    :pswitch_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MyLikesFragment;->sortPriceDrop()V

    goto :goto_0

    .line 644
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 0
    .param p1, "newListingDetail"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 579
    return-void
.end method
