.class public Lcom/poshmark/ui/fragments/UserListFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "UserListFragment.java"

# interfaces
.implements Lcom/poshmark/utils/CollectionSortWidgetListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/UserListFragment$11;,
        Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;
    }
.end annotation


# instance fields
.field private Id:Ljava/lang/String;

.field private adapter:Lcom/poshmark/data_model/adapters/UserListAdapter;

.field backgroundBmp:Landroid/graphics/Bitmap;

.field backgroundImageView:Landroid/widget/ImageView;

.field private displayCount:I

.field private headerView:Landroid/view/View;

.field itemClickListener:Landroid/view/View$OnClickListener;

.field private mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

.field model:Lcom/poshmark/data_model/models/UserReferenceList;

.field private screenStackTag:Ljava/lang/String;

.field private subTitle:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private userListView:Lcom/poshmark/ui/customviews/PMListView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 30
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 47
    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->model:Lcom/poshmark/data_model/models/UserReferenceList;

    .line 52
    const/4 v0, 0x0

    iput v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->displayCount:I

    .line 54
    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->title:Ljava/lang/String;

    .line 55
    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->subTitle:Ljava/lang/String;

    .line 362
    new-instance v0, Lcom/poshmark/ui/fragments/UserListFragment$10;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserListFragment$10;-><init>(Lcom/poshmark/ui/fragments/UserListFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->itemClickListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/UserListFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/UserListFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/UserListFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/UserListFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/UserListFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    return-object v0
.end method

.method private fetchNewlyJoinedClosets()V
    .locals 3

    .prologue
    .line 339
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_JOINED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 340
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "newly_joined_closets_screen"

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 341
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserListFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 342
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    const/4 v1, 0x0

    new-instance v2, Lcom/poshmark/ui/fragments/UserListFragment$8;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/UserListFragment$8;-><init>(Lcom/poshmark/ui/fragments/UserListFragment;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->getNewlyJoinedClosets(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 348
    return-void
.end method

.method private fetchNewlyOpenedClosets()V
    .locals 3

    .prologue
    .line 351
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_OPENED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 352
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "newly_opened_closets_screen"

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 353
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserListFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 354
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    const/4 v1, 0x0

    new-instance v2, Lcom/poshmark/ui/fragments/UserListFragment$9;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/UserListFragment$9;-><init>(Lcom/poshmark/ui/fragments/UserListFragment;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->getNewlyOpenedClosets(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 360
    return-void
.end method

.method private handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 3
    .param p2, "isPagination"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 376
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 377
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->hideProgressDialog()V

    .line 378
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_2

    .line 379
    if-nez p2, :cond_1

    .line 380
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/UserReferenceList;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->model:Lcom/poshmark/data_model/models/UserReferenceList;

    .line 381
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->userListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 382
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->userListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->model:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 383
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->userListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 398
    :cond_0
    :goto_0
    return-void

    .line 385
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->model:Lcom/poshmark/data_model/models/UserReferenceList;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/UserReferenceList;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 386
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->userListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 390
    :cond_2
    if-nez p2, :cond_0

    .line 391
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->FETCH_USERLIST:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserListFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private setScreenTagBasedOnMode()V
    .locals 2

    .prologue
    .line 318
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 323
    :goto_0
    return-void

    .line 320
    :pswitch_0
    new-instance v0, Ljava/lang/String;

    const-string v1, "sp"

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->screenStackTag:Ljava/lang/String;

    goto :goto_0

    .line 318
    :pswitch_data_0
    .packed-switch 0x8
        :pswitch_0
    .end packed-switch
.end method

.method private setupHeaderView()V
    .locals 4

    .prologue
    .line 300
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 301
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v2, 0x7f0300ca

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->headerView:Landroid/view/View;

    .line 302
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c0062

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->backgroundImageView:Landroid/widget/ImageView;

    .line 303
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c0068

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/CollectionSortWidget;

    .line 304
    .local v1, "sortWidget":Lcom/poshmark/ui/customviews/CollectionSortWidget;
    invoke-virtual {v1, p0}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setSortSelectionListener(Lcom/poshmark/utils/CollectionSortWidgetListener;)V

    .line 305
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f060138

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setLeftButtonText(Ljava/lang/String;)V

    .line 306
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f06015e

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->setRightButtonText(Ljava/lang/String;)V

    .line 307
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_OPENED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    if-ne v2, v3, :cond_0

    .line 308
    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectLeftButton()V

    .line 315
    :goto_0
    return-void

    .line 309
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_JOINED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    if-ne v2, v3, :cond_1

    .line 310
    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectRightButton()V

    goto :goto_0

    .line 312
    :cond_1
    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectLeftButton()V

    goto :goto_0
.end method

.method private setupListView()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 278
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_OPENED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_JOINED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    if-ne v0, v1, :cond_1

    .line 279
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->setupHeaderView()V

    .line 281
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c02f6

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->userListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 282
    new-instance v0, Lcom/poshmark/data_model/adapters/UserListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, -0x80000000

    invoke-direct {v0, v1, p0, v4, v2}, Lcom/poshmark/data_model/adapters/UserListAdapter;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->adapter:Lcom/poshmark/data_model/adapters/UserListAdapter;

    .line 283
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->userListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->adapter:Lcom/poshmark/data_model/adapters/UserListAdapter;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->headerView:Landroid/view/View;

    new-instance v3, Lcom/poshmark/ui/fragments/UserListFragment$7;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/UserListFragment$7;-><init>(Lcom/poshmark/ui/fragments/UserListFragment;)V

    invoke-virtual {v0, v1, v2, v4, v3}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 296
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->adapter:Lcom/poshmark/data_model/adapters/UserListAdapter;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->itemClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/adapters/UserListAdapter;->setOnItemClickListener(Landroid/view/View$OnClickListener;)V

    .line 297
    return-void
.end method


# virtual methods
.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->screenStackTag:Ljava/lang/String;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 119
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 120
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->setupListView()V

    .line 121
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 61
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 62
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const v3, 0x7f060107

    .line 66
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 67
    const v1, 0x7f0300c9

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 69
    .local v0, "v":Landroid/view/View;
    sget-object v1, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 114
    :cond_0
    :goto_0
    return-object v0

    .line 71
    :pswitch_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060165

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->title:Ljava/lang/String;

    goto :goto_0

    .line 74
    :pswitch_1
    const v1, 0x7f060133

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/UserListFragment;->setTitle(I)V

    .line 75
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 76
    iget v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->displayCount:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->subTitle:Ljava/lang/String;

    goto :goto_0

    .line 80
    :pswitch_2
    const v1, 0x7f060134

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/UserListFragment;->setTitle(I)V

    .line 81
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 82
    iget v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->displayCount:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->subTitle:Ljava/lang/String;

    goto :goto_0

    .line 86
    :pswitch_3
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060109

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->title:Ljava/lang/String;

    goto :goto_0

    .line 89
    :pswitch_4
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0602a1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->title:Ljava/lang/String;

    goto :goto_0

    .line 93
    :pswitch_5
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060292

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->title:Ljava/lang/String;

    goto :goto_0

    .line 96
    :pswitch_6
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0601fd

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->title:Ljava/lang/String;

    goto/16 :goto_0

    .line 99
    :pswitch_7
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06025a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->title:Ljava/lang/String;

    goto/16 :goto_0

    .line 103
    :pswitch_8
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->title:Ljava/lang/String;

    goto/16 :goto_0

    .line 107
    :pswitch_9
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->title:Ljava/lang/String;

    goto/16 :goto_0

    .line 69
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method

.method public onPMResume()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 125
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 126
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->model:Lcom/poshmark/data_model/models/UserReferenceList;

    if-nez v2, :cond_1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    if-eqz v2, :cond_1

    .line 128
    const v2, 0x7f060190

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserListFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserListFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 129
    sget-object v2, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserListFragment;->mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 191
    :goto_0
    :pswitch_0
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->backgroundImageView:Landroid/widget/ImageView;

    if-eqz v2, :cond_0

    .line 192
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v2

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Display;->getWidth()I

    move-result v1

    .line 193
    .local v1, "width":I
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const/high16 v3, 0x42f00000    # 120.0f

    invoke-static {v2, v3}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v2

    float-to-int v0, v2

    .line 194
    .local v0, "height":I
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020112

    const/4 v4, 0x1

    invoke-static {v2, v3, v1, v0, v4}, Lcom/poshmark/utils/ImageUtils;->loadScaledBitmapFromResource(Landroid/content/res/Resources;IIIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    .line 195
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    if-eqz v2, :cond_0

    .line 196
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->backgroundImageView:Landroid/widget/ImageView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserListFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 203
    .end local v0    # "height":I
    .end local v1    # "width":I
    :cond_0
    :goto_1
    return-void

    .line 131
    :pswitch_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    new-instance v3, Lcom/poshmark/ui/fragments/UserListFragment$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/UserListFragment$1;-><init>(Lcom/poshmark/ui/fragments/UserListFragment;)V

    invoke-static {v2, v3}, Lcom/poshmark/http/api/PMApi;->getLikersforListing(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 140
    :pswitch_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    new-instance v3, Lcom/poshmark/ui/fragments/UserListFragment$2;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/UserListFragment$2;-><init>(Lcom/poshmark/ui/fragments/UserListFragment;)V

    invoke-static {v2, v3}, Lcom/poshmark/http/api/PMApi;->getFollowersList(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 149
    :pswitch_3
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    new-instance v3, Lcom/poshmark/ui/fragments/UserListFragment$3;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/UserListFragment$3;-><init>(Lcom/poshmark/ui/fragments/UserListFragment;)V

    invoke-static {v2, v3}, Lcom/poshmark/http/api/PMApi;->getFollowingList(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 158
    :pswitch_4
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    new-instance v3, Lcom/poshmark/ui/fragments/UserListFragment$4;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/UserListFragment$4;-><init>(Lcom/poshmark/ui/fragments/UserListFragment;)V

    invoke-static {v2, v4, v3}, Lcom/poshmark/http/api/PMApi;->getDiscoveredClosets(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 166
    :pswitch_5
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    new-instance v3, Lcom/poshmark/ui/fragments/UserListFragment$5;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/UserListFragment$5;-><init>(Lcom/poshmark/ui/fragments/UserListFragment;)V

    invoke-static {v2, v4, v3}, Lcom/poshmark/http/api/PMApi;->getNewlyOpenedClosets(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 174
    :pswitch_6
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    new-instance v3, Lcom/poshmark/ui/fragments/UserListFragment$6;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/UserListFragment$6;-><init>(Lcom/poshmark/ui/fragments/UserListFragment;)V

    invoke-static {v2, v4, v3}, Lcom/poshmark/http/api/PMApi;->getNewlyJoinedClosets(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 184
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->userListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 185
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->userListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserListFragment;->model:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 186
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserListFragment;->userListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto/16 :goto_0

    .line 199
    :catch_0
    move-exception v2

    goto :goto_1

    .line 129
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public onPause()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 207
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPause()V

    .line 208
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->backgroundImageView:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->backgroundImageView:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 210
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 211
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 212
    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->backgroundBmp:Landroid/graphics/Bitmap;

    .line 215
    :cond_0
    return-void
.end method

.method protected pullParametersFromState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 237
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "MODE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .line 238
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ID"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->Id:Ljava/lang/String;

    .line 239
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "DISPLAY_COUNT"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->displayCount:I

    .line 240
    const-class v0, Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserListFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/UserReferenceList;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->model:Lcom/poshmark/data_model/models/UserReferenceList;

    .line 241
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->setScreenTagBasedOnMode()V

    .line 242
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 2

    .prologue
    .line 245
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$fragments$UserListFragment$USER_LIST_MODE:[I

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserListFragment;->mode:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 275
    :goto_0
    :pswitch_0
    return-void

    .line 247
    :pswitch_1
    const-string v0, "listing_user_likes_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 250
    :pswitch_2
    const-string v0, "followers_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 253
    :pswitch_3
    const-string v0, "following_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 256
    :pswitch_4
    const-string v0, "suggested_users_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 259
    :pswitch_5
    const-string v0, "secondary_suggested_users_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 262
    :pswitch_6
    const-string v0, "facebook_connections_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 265
    :pswitch_7
    const-string v0, "twitter_connections_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 268
    :pswitch_8
    const-string v0, "newly_opened_closets_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 271
    :pswitch_9
    const-string v0, "newly_joined_closets_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 245
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_6
        :pswitch_7
        :pswitch_4
        :pswitch_5
        :pswitch_8
        :pswitch_0
        :pswitch_0
        :pswitch_9
    .end packed-switch
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 220
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 221
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->title:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 222
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->title:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserListFragment;->setTitle(Ljava/lang/String;)V

    .line 224
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->subTitle:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 225
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserListFragment;->subTitle:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserListFragment;->setSubTitle(Ljava/lang/String;)V

    .line 227
    :cond_1
    return-void
.end method

.method public sortWidgetClicked(Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;)V
    .locals 2
    .param p1, "buttonType"    # Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    .prologue
    .line 327
    sget-object v0, Lcom/poshmark/ui/fragments/UserListFragment$11;->$SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 336
    :goto_0
    return-void

    .line 329
    :pswitch_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->fetchNewlyOpenedClosets()V

    goto :goto_0

    .line 332
    :pswitch_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/UserListFragment;->fetchNewlyJoinedClosets()V

    goto :goto_0

    .line 327
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
