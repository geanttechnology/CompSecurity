.class public Lcom/poshmark/ui/fragments/ClosetFragment;
.super Lcom/poshmark/ui/fragments/PMFilterableFragment;
.source "ClosetFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/ListingNotificationHandler;


# instance fields
.field aboutButtonClickListener:Landroid/view/View$OnClickListener;

.field private adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

.field private bUseFilter:Z

.field private closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

.field private closetListView:Lcom/poshmark/ui/customviews/PMListView;

.field drawerItemlistener:Landroid/widget/AdapterView$OnItemClickListener;

.field private emptyListHeader:Landroid/view/View;

.field followerOnClickListener:Landroid/view/View$OnClickListener;

.field followingOnClickListener:Landroid/view/View$OnClickListener;

.field private headerView:Landroid/view/View;

.field private listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

.field private profileData:Lcom/poshmark/user/UserInfoDetails;

.field sharesOnClickListener:Landroid/view/View$OnClickListener;

.field private userName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 51
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;-><init>()V

    .line 53
    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 56
    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    .line 59
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->bUseFilter:Z

    .line 60
    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->emptyListHeader:Landroid/view/View;

    .line 410
    new-instance v0, Lcom/poshmark/ui/fragments/ClosetFragment$10;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$10;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->followerOnClickListener:Landroid/view/View$OnClickListener;

    .line 427
    new-instance v0, Lcom/poshmark/ui/fragments/ClosetFragment$11;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$11;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->followingOnClickListener:Landroid/view/View$OnClickListener;

    .line 444
    new-instance v0, Lcom/poshmark/ui/fragments/ClosetFragment$12;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$12;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->sharesOnClickListener:Landroid/view/View$OnClickListener;

    .line 460
    new-instance v0, Lcom/poshmark/ui/fragments/ClosetFragment$13;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$13;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->aboutButtonClickListener:Landroid/view/View$OnClickListener;

    .line 480
    new-instance v0, Lcom/poshmark/ui/fragments/ClosetFragment$14;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$14;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->drawerItemlistener:Landroid/widget/AdapterView$OnItemClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ClosetFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ClosetFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 51
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ClosetFragment;->getUserCloset(Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ClosetFragment;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    return-object v0
.end method

.method static synthetic access$102(Lcom/poshmark/ui/fragments/ClosetFragment;Lcom/poshmark/user/UserInfoDetails;)Lcom/poshmark/user/UserInfoDetails;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ClosetFragment;
    .param p1, "x1"    # Lcom/poshmark/user/UserInfoDetails;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    return-object p1
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/ClosetFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ClosetFragment;

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->updateProfileCard()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ClosetFragment;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    return-object v0
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/ClosetFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ClosetFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/ClosetFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method private getUserCloset(Z)V
    .locals 5
    .param p1, "isPagination"    # Z

    .prologue
    const/4 v4, 0x0

    .line 228
    if-eqz p1, :cond_1

    .line 229
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->bUseFilter:Z

    if-eqz v2, :cond_0

    .line 230
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    .line 231
    .local v1, "model":Lcom/poshmark/utils/SearchFilterModel;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->setNextPageId(Ljava/lang/String;)V

    .line 233
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v0

    .line 234
    .local v0, "filterQuery":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v2}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/ui/fragments/ClosetFragment$3;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$3;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    invoke-static {v2, v3, v0, v4}, Lcom/poshmark/http/api/PMApi;->getUserClosetFiltered(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 278
    .end local v0    # "filterQuery":Ljava/lang/String;
    .end local v1    # "model":Lcom/poshmark/utils/SearchFilterModel;
    :goto_0
    return-void

    .line 243
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v2}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/ui/fragments/ClosetFragment$4;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$4;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    invoke-static {v2, v3, v4}, Lcom/poshmark/http/api/PMApi;->getUserCloset(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 254
    :cond_1
    const v2, 0x7f060190

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 255
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->bUseFilter:Z

    if-eqz v2, :cond_2

    .line 256
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v0

    .line 257
    .restart local v0    # "filterQuery":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v2}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/ClosetFragment$5;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$5;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    invoke-static {v2, v4, v0, v3}, Lcom/poshmark/http/api/PMApi;->getUserClosetFiltered(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 268
    .end local v0    # "filterQuery":Ljava/lang/String;
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v2}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/ClosetFragment$6;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$6;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    invoke-static {v2, v4, v3}, Lcom/poshmark/http/api/PMApi;->getUserCloset(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

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
            "Lcom/poshmark/data_model/models/ListingSummaryCollection;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 282
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->hideProgressDialog()V

    .line 283
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_2

    .line 285
    if-nez p2, :cond_1

    .line 286
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/ListingSummaryCollection;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    .line 287
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->createHashAndRemoveDups()V

    .line 288
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 289
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 290
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 291
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 292
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->showCustomEmptyListingsMessage()V

    .line 305
    :cond_0
    :goto_0
    return-void

    .line 296
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 297
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 301
    :cond_2
    if-nez p2, :cond_0

    .line 302
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_CLOSET:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0600eb

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private setupClosetList()V
    .locals 5

    .prologue
    .line 185
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c00c0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 186
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const/4 v3, 0x0

    new-instance v4, Lcom/poshmark/ui/fragments/ClosetFragment$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$1;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 193
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    if-nez v0, :cond_0

    .line 194
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 195
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->userName:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/ClosetFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$2;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getUserProfile(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 225
    :goto_0
    return-void

    .line 218
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 219
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 220
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->showCustomEmptyListingsMessage()V

    .line 222
    :cond_2
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->updateProfileCard()V

    .line 223
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method private setupDrawerButton()V
    .locals 0

    .prologue
    .line 172
    return-void
.end method

.method private setupHeaderView(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 588
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 589
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v1, 0x7f03008f

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    .line 590
    new-instance v1, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    invoke-direct {v1}, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    .line 591
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c0062

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->bgCovershotImageView:Landroid/widget/ImageView;

    .line 592
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c00c1

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/RoundedImageView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->avataarImageView:Lcom/poshmark/ui/customviews/RoundedImageView;

    .line 593
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c00c8

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->closetTitleView:Landroid/widget/TextView;

    .line 595
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c00c2

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->listingsCountView:Landroid/widget/TextView;

    .line 596
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c00c3

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->listingsLableView:Landroid/widget/TextView;

    .line 597
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c00c4

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followerCountView:Landroid/widget/TextView;

    .line 598
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c00c5

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followerLabelView:Landroid/widget/TextView;

    .line 599
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c00c6

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followingCountView:Landroid/widget/TextView;

    .line 600
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c021d

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->sharesLabelView:Landroid/widget/TextView;

    .line 601
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c021c

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->sharesCountView:Landroid/widget/TextView;

    .line 602
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c00c7

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followingLabelView:Landroid/widget/TextView;

    .line 603
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c0066

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->userFollowButtonLayout:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    .line 604
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c0219

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->editProfileButton:Landroid/widget/Button;

    .line 605
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c0217

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->aboutButton:Landroid/widget/Button;

    .line 607
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followerLabelView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->followerOnClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 608
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followerCountView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->followerOnClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 609
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followingLabelView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->followingOnClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 610
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followingCountView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->followingOnClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 612
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->sharesCountView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->sharesOnClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 613
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->sharesLabelView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->sharesOnClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 616
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c0069

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    .line 617
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->headerView:Landroid/view/View;

    const v2, 0x7f0c006a

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    .line 618
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v1, p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setOwnerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 656
    return-void
.end method

.method private updateProfileCard()V
    .locals 12

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 488
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getUserVisibleHint()Z

    move-result v8

    if-eqz v8, :cond_1

    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    if-eqz v8, :cond_1

    .line 489
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getView()Landroid/view/View;

    move-result-object v6

    .line 490
    .local v6, "v":Landroid/view/View;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v0, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->avataarImageView:Lcom/poshmark/ui/customviews/RoundedImageView;

    .line 491
    .local v0, "avataar":Lcom/poshmark/ui/customviews/RoundedImageView;
    if-eqz v0, :cond_0

    .line 492
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v3

    .line 493
    .local v3, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v5

    .line 494
    .local v5, "pictureURL":Ljava/lang/String;
    if-eqz v5, :cond_0

    .line 495
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->bgCovershotImageView:Landroid/widget/ImageView;

    invoke-virtual {v3, v5, v8}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 499
    .end local v3    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    .end local v5    # "pictureURL":Ljava/lang/String;
    :cond_0
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "@"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v9}, Lcom/poshmark/user/UserInfoDetails;->getDisplayHandle()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/fragments/ClosetFragment;->setTitle(Ljava/lang/String;)V

    .line 501
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->closetTitleView:Landroid/widget/TextView;

    iget-object v9, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v9}, Lcom/poshmark/user/UserInfoDetails;->getClosetTitle()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 503
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getListingCount()I

    move-result v4

    .line 504
    .local v4, "listingsCount":I
    if-le v4, v11, :cond_2

    .line 505
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->listingsLableView:Landroid/widget/TextView;

    const v9, 0x7f06018f

    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 509
    :goto_0
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->listingsCountView:Landroid/widget/TextView;

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 511
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getFollowersCount()I

    move-result v2

    .line 512
    .local v2, "followersCount":I
    if-le v2, v11, :cond_3

    .line 513
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followerLabelView:Landroid/widget/TextView;

    const v9, 0x7f060133

    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 517
    :goto_1
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getFollowersCount()I

    move-result v8

    invoke-static {v8}, Lcom/poshmark/utils/StringUtils;->abbreviatedStringRepresentationOfNumber(I)Ljava/lang/String;

    move-result-object v1

    .line 518
    .local v1, "countString":Ljava/lang/String;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followerCountView:Landroid/widget/TextView;

    invoke-virtual {v8, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 520
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getFollowingCount()I

    move-result v8

    invoke-static {v8}, Lcom/poshmark/utils/StringUtils;->abbreviatedStringRepresentationOfNumber(I)Ljava/lang/String;

    move-result-object v1

    .line 521
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followingCountView:Landroid/widget/TextView;

    invoke-virtual {v8, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 523
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getShareCount()I

    move-result v8

    invoke-static {v8}, Lcom/poshmark/utils/StringUtils;->abbreviatedStringRepresentationOfNumber(I)Ljava/lang/String;

    move-result-object v1

    .line 524
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->sharesCountView:Landroid/widget/TextView;

    invoke-virtual {v8, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 526
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v3

    .line 527
    .restart local v3    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v8

    if-eqz v8, :cond_4

    .line 528
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v8

    iget-object v9, v0, Lcom/poshmark/ui/customviews/RoundedImageView;->listener:Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;

    invoke-virtual {v3, v8, v9}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;)V

    .line 532
    :goto_2
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->aboutButtonClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v8}, Lcom/poshmark/ui/customviews/RoundedImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 534
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->aboutButton:Landroid/widget/Button;

    invoke-virtual {v8, v10}, Landroid/widget/Button;->setVisibility(I)V

    .line 535
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->aboutButton:Landroid/widget/Button;

    iget-object v9, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->aboutButtonClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v8, v9}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 537
    const v8, 0x7f0c0218

    invoke-virtual {v6, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/LinearLayout;

    .line 539
    .local v7, "wrapper":Landroid/widget/LinearLayout;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v8

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v9

    invoke-virtual {v9}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 540
    const/16 v8, 0x8

    invoke-virtual {v7, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 541
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->editProfileButton:Landroid/widget/Button;

    invoke-virtual {v8, v10}, Landroid/widget/Button;->setVisibility(I)V

    .line 542
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->editProfileButton:Landroid/widget/Button;

    new-instance v9, Lcom/poshmark/ui/fragments/ClosetFragment$15;

    invoke-direct {v9, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$15;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    invoke-virtual {v8, v9}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 578
    :goto_3
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/SearchFilterModel;->getPrimaryFilters()Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    move-result-object v8

    iget-object v9, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v9}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->addUser(Ljava/lang/String;)V

    .line 579
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v8

    const-string v9, "brand"

    invoke-virtual {v8, v9}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 580
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v8

    const-string v9, "category_v2"

    invoke-virtual {v8, v9}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 581
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v8

    const-string v9, "category_feature"

    invoke-virtual {v8, v9}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 582
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v8

    const-string v9, "size"

    invoke-virtual {v8, v9}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 583
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v8

    const-string v9, "color"

    invoke-virtual {v8, v9}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 585
    .end local v0    # "avataar":Lcom/poshmark/ui/customviews/RoundedImageView;
    .end local v1    # "countString":Ljava/lang/String;
    .end local v2    # "followersCount":I
    .end local v3    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    .end local v4    # "listingsCount":I
    .end local v6    # "v":Landroid/view/View;
    .end local v7    # "wrapper":Landroid/widget/LinearLayout;
    :cond_1
    return-void

    .line 507
    .restart local v0    # "avataar":Lcom/poshmark/ui/customviews/RoundedImageView;
    .restart local v4    # "listingsCount":I
    .restart local v6    # "v":Landroid/view/View;
    :cond_2
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->listingsLableView:Landroid/widget/TextView;

    const v9, 0x7f060167

    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 515
    .restart local v2    # "followersCount":I
    :cond_3
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followerLabelView:Landroid/widget/TextView;

    const v9, 0x7f060132

    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1

    .line 530
    .restart local v1    # "countString":Ljava/lang/String;
    .restart local v3    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    :cond_4
    const v8, 0x7f0200d4

    invoke-virtual {v0, v8}, Lcom/poshmark/ui/customviews/RoundedImageView;->setBitmap(I)V

    goto/16 :goto_2

    .line 553
    .restart local v7    # "wrapper":Landroid/widget/LinearLayout;
    :cond_5
    invoke-virtual {v7, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 554
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->userFollowButtonLayout:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-object v9, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v9}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v9

    iget-object v10, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v10}, Lcom/poshmark/user/UserInfoDetails;->isCallerFollowing()Z

    move-result v10

    invoke-virtual {v8, v9, v10}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setUser(Ljava/lang/String;Z)V

    .line 555
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->userFollowButtonLayout:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    new-instance v9, Lcom/poshmark/ui/fragments/ClosetFragment$16;

    invoke-direct {v9, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$16;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setListener(Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;)V

    .line 575
    invoke-virtual {v6}, Landroid/view/View;->invalidate()V

    goto/16 :goto_3
.end method


# virtual methods
.method public addCommentToListing(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 667
    return-void
.end method

.method public blockUser()V
    .locals 2

    .prologue
    .line 357
    const v0, 0x7f06021e

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 358
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v0}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/ClosetFragment$8;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$8;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->blockUser(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 377
    return-void
.end method

.method public deleteListing(Ljava/lang/String;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 676
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->hasListing(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 677
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->bUpdateOnShow:Z

    .line 681
    :cond_0
    return-void
.end method

.method public filterContent()V
    .locals 1

    .prologue
    const/4 v0, 0x1

    .line 764
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->bUpdateOnShow:Z

    .line 765
    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->bUseFilter:Z

    .line 766
    return-void
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 156
    const-string v0, "cl"

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 13
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v12, 0x0

    .line 692
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v8

    const-string v9, "com.poshmark.intents.FILTER_SELECTION_ACTION"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 693
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->facetsAvailable()Z

    move-result v8

    if-nez v8, :cond_1

    .line 694
    invoke-virtual {p0, v12}, Lcom/poshmark/ui/fragments/ClosetFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 696
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v8

    const-string v9, "1"

    invoke-virtual {v8, v9}, Lcom/poshmark/utils/SearchFilterModel;->setCount(Ljava/lang/String;)V

    .line 697
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v2

    .line 698
    .local v2, "filterQuery":Ljava/lang/String;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v8

    new-instance v9, Lcom/poshmark/ui/fragments/ClosetFragment$17;

    invoke-direct {v9, p0, p1}, Lcom/poshmark/ui/fragments/ClosetFragment$17;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;Landroid/content/Intent;)V

    invoke-static {v8, v2, v9}, Lcom/poshmark/http/api/PMApi;->getUserClosetFacets(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 761
    .end local v2    # "filterQuery":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 714
    :cond_1
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->handleNotification(Landroid/content/Intent;)V

    goto :goto_0

    .line 716
    :cond_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v8

    const-string v9, "com.poshmark.intents.BLOCK_USER_ACTION"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 717
    const-string v8, "RESULT"

    invoke-virtual {p1, v8}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 718
    .local v1, "b":Landroid/os/Bundle;
    const-string v8, "PARENT_ID"

    invoke-virtual {v1, v8}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v7

    check-cast v7, Landroid/os/ParcelUuid;

    .line 719
    .local v7, "uuidParcel":Landroid/os/ParcelUuid;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v7}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 720
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->blockUser()V

    goto :goto_0

    .line 722
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v7    # "uuidParcel":Landroid/os/ParcelUuid;
    :cond_3
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v8

    const-string v9, "com.poshmark.intents.UNBLOCK_USER_ACTION"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 723
    const-string v8, "RESULT"

    invoke-virtual {p1, v8}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 724
    .restart local v1    # "b":Landroid/os/Bundle;
    const-string v8, "PARENT_ID"

    invoke-virtual {v1, v8}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v7

    check-cast v7, Landroid/os/ParcelUuid;

    .line 725
    .restart local v7    # "uuidParcel":Landroid/os/ParcelUuid;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v7}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 726
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->unblockUser()V

    goto :goto_0

    .line 728
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v7    # "uuidParcel":Landroid/os/ParcelUuid;
    :cond_4
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v8

    const-string v9, "com.poshmark.intents.REPORT_USER_ACTION"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 729
    const-string v8, "RESULT"

    invoke-virtual {p1, v8}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 730
    .restart local v1    # "b":Landroid/os/Bundle;
    const-string v8, "PARENT_ID"

    invoke-virtual {v1, v8}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v7

    check-cast v7, Landroid/os/ParcelUuid;

    .line 731
    .restart local v7    # "uuidParcel":Landroid/os/ParcelUuid;
    const-string v8, "REPORT_REASON"

    invoke-virtual {v1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 732
    .local v5, "reason":Ljava/lang/String;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v7}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 733
    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/ClosetFragment;->reportUser(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 735
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v5    # "reason":Ljava/lang/String;
    .end local v7    # "uuidParcel":Landroid/os/ParcelUuid;
    :cond_5
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v8

    const-string v9, "com.poshmark.intents.SHARE_CLOSET_ACTION"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 736
    const-string v8, "RESULT"

    invoke-virtual {p1, v8}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 737
    .restart local v1    # "b":Landroid/os/Bundle;
    const-string v8, "PARENT_ID"

    invoke-virtual {v1, v8}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v7

    check-cast v7, Landroid/os/ParcelUuid;

    .line 738
    .restart local v7    # "uuidParcel":Landroid/os/ParcelUuid;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v7}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 739
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->shareCloset()V

    goto/16 :goto_0

    .line 741
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v7    # "uuidParcel":Landroid/os/ParcelUuid;
    :cond_6
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v8

    const-string v9, "com.poshmark.intents.USER_FOLLOW_STATUS_CHANGED"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 742
    const-string v8, "RESULT"

    invoke-virtual {p1, v8}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 743
    .restart local v1    # "b":Landroid/os/Bundle;
    const-string v8, "USER"

    invoke-virtual {v1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 744
    .local v6, "userId":Ljava/lang/String;
    const-string v8, "IS_FOLLOWING"

    invoke-virtual {v1, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    .line 745
    .local v3, "isFollowing":Z
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    if-eqz v8, :cond_0

    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 746
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v8, v3}, Lcom/poshmark/user/UserInfoDetails;->setCallerIsFollowing(Z)V

    .line 747
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->userFollowButtonLayout:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    invoke-virtual {v8, v6, v3}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setUser(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 749
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v3    # "isFollowing":Z
    .end local v6    # "userId":Ljava/lang/String;
    :cond_7
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v8

    const-string v9, "com.poshmark.intents.VIEW_BUNDLE_ACTION"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 750
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v8

    iget-object v9, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v10, "bundle"

    const-string v11, "view_bundle_tapped"

    invoke-virtual {v8, v9, v10, v11, v12}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 751
    const-string v8, "RESULT"

    invoke-virtual {p1, v8}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 752
    .restart local v1    # "b":Landroid/os/Bundle;
    const-string v8, "PARENT_ID"

    invoke-virtual {v1, v8}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v7

    check-cast v7, Landroid/os/ParcelUuid;

    .line 753
    .restart local v7    # "uuidParcel":Landroid/os/ParcelUuid;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v7}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 754
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v4

    .line 755
    .local v4, "parentActivity":Lcom/poshmark/ui/PMActivity;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 756
    .local v0, "args":Landroid/os/Bundle;
    const-string v8, "ID"

    iget-object v9, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v9}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v8, v9}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 757
    const-class v8, Lcom/poshmark/ui/fragments/ViewBundleFragment;

    invoke-virtual {v4, v0, v8, v12}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_0
.end method

.method public isLoggedInUserCloset()Z
    .locals 3

    .prologue
    .line 179
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v1

    .line 180
    .local v1, "loggedInUsername":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    .line 181
    .local v0, "loggedInUserId":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->userName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->userName:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public isUserBlocked()Z
    .locals 1

    .prologue
    .line 380
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    if-eqz v0, :cond_0

    .line 381
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v0}, Lcom/poshmark/user/UserInfoDetails;->isUserBlocked()Z

    move-result v0

    .line 383
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public likeListing(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "likeStatus"    # Z

    .prologue
    .line 672
    return-void
.end method

.method public newListingCreated()V
    .locals 0

    .prologue
    .line 686
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 100
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 101
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->setupClosetList()V

    .line 102
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 64
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreate(Landroid/os/Bundle;)V

    .line 65
    new-instance v1, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    const/high16 v4, -0x80000000

    invoke-direct {v1, v2, p0, v3, v4}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 67
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "NAME"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 68
    .local v0, "uName":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 69
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    const-string v2, "\n"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->userName:Ljava/lang/String;

    .line 77
    :cond_0
    :goto_0
    sget-object v1, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->HAS_DRAWER:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    .line 80
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 82
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/poshmark/notifications/ListingNotificationManager;->registerListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V

    .line 85
    sget-object v1, Lcom/poshmark/utils/NewRelicCustomInteractions;->CLOSET:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 87
    return-void

    .line 72
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "ID"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 73
    if-eqz v0, :cond_0

    .line 74
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    const-string v2, "\n"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->userName:Ljava/lang/String;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 91
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 92
    const v1, 0x7f030026

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 94
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->setupHeaderView(Landroid/view/View;)V

    .line 95
    return-object v0
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 112
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPMResume()V

    .line 113
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 114
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->bUpdateOnShow:Z

    if-eqz v0, :cond_1

    .line 115
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->bUpdateOnShow:Z

    .line 117
    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->getUserCloset(Z)V

    .line 127
    :cond_0
    :goto_0
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.BLOCK_USER_ACTION"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 128
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.UNBLOCK_USER_ACTION"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 129
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.REPORT_USER_ACTION"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 130
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.SHARE_CLOSET_ACTION"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 131
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.USER_FOLLOW_STATUS_CHANGED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 132
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.VIEW_BUNDLE_ACTION"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 133
    return-void

    .line 119
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 120
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 122
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->showCustomEmptyListingsMessage()V

    goto :goto_0
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 161
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPause()V

    .line 162
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 166
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 167
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 168
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 106
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onStop()V

    .line 107
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->clearImageList()V

    .line 108
    return-void
.end method

.method public reportUser(Ljava/lang/String;)V
    .locals 2
    .param p1, "reason"    # Ljava/lang/String;

    .prologue
    .line 327
    const v0, 0x7f060229

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 328
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->userName:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/ClosetFragment$7;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$7;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    invoke-static {v0, p1, v1}, Lcom/poshmark/http/api/PMApi;->reportUser(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 344
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 175
    const-string v0, "user_profile_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 176
    return-void
.end method

.method public setupActionBar()V
    .locals 5

    .prologue
    .line 137
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->setupActionBar()V

    .line 138
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    if-nez v2, :cond_0

    .line 139
    const-string v2, ""

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->setTitle(Ljava/lang/String;)V

    .line 152
    :goto_0
    return-void

    .line 141
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v2}, Lcom/poshmark/user/UserInfoDetails;->getDisplayStatus()Ljava/lang/String;

    move-result-object v0

    .line 142
    .local v0, "closet_status_msg":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 143
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->setSubTitle(Ljava/lang/String;)V

    .line 145
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "@"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getDisplayHandle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->setTitle(Ljava/lang/String;)V

    .line 146
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 147
    .local v1, "drawerPayload":Landroid/os/Bundle;
    const-string v2, "PARENT_FRAGMENT_ID"

    new-instance v3, Landroid/os/ParcelUuid;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->fragmentId:Ljava/util/UUID;

    invoke-direct {v3, v4}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 148
    const-string v2, "USER_ID"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    const-string v2, "BLOCK_USER_STATUS"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->isUserBlocked()Z

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 150
    const-class v2, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;

    const v3, 0x7f0c003e

    invoke-virtual {p0, v2, p0, v3, v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->setDrawerActionButton(Ljava/lang/Class;Lcom/poshmark/ui/fragments/PMFragment;ILjava/lang/Object;)Lcom/poshmark/ui/fragments/PMFragment;

    goto :goto_0
.end method

.method public shareCloset()V
    .locals 8

    .prologue
    .line 347
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "user"

    const-string v6, "mycloset_share_button_tapped"

    const/4 v7, 0x0

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 348
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getView()Landroid/view/View;

    move-result-object v3

    invoke-static {v3}, Lcom/poshmark/utils/ImageUtils;->takeScreenshot(Landroid/view/View;)Landroid/net/Uri;

    move-result-object v1

    .line 349
    .local v1, "closetScreenshot":Landroid/net/Uri;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 350
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "MODE"

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 351
    const-string v3, "IMAGE_URI"

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 352
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 353
    .local v2, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v3, Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v2, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 354
    return-void
.end method

.method public showCustomEmptyListingsMessage()V
    .locals 7

    .prologue
    const v5, 0x7f0c00cb

    const/4 v6, 0x0

    .line 308
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 309
    .local v0, "inflater":Landroid/view/LayoutInflater;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->emptyListHeader:Landroid/view/View;

    if-nez v3, :cond_0

    .line 310
    const v3, 0x7f030028

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->emptyListHeader:Landroid/view/View;

    .line 312
    :cond_0
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getShareCount()I

    move-result v3

    if-lez v3, :cond_1

    .line 313
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->emptyListHeader:Landroid/view/View;

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    .line 314
    .local v2, "shopSharesMsg":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v2, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 315
    const v3, 0x7f060267

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v5}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 316
    .local v1, "msg":Ljava/lang/String;
    invoke-virtual {v2, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 318
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->sharesOnClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 323
    .end local v1    # "msg":Ljava/lang/String;
    .end local v2    # "shopSharesMsg":Lcom/poshmark/ui/customviews/PMTextView;
    :goto_0
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->closetListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->emptyListHeader:Landroid/view/View;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMListView;->showEmptyContentView(Landroid/view/View;)V

    .line 324
    return-void

    .line 321
    :cond_1
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->emptyListHeader:Landroid/view/View;

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public unblockUser()V
    .locals 2

    .prologue
    .line 388
    const v0, 0x7f06021e

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 389
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v0}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/ClosetFragment$9;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ClosetFragment$9;-><init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->unblockUser(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 408
    return-void
.end method

.method public updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 2
    .param p1, "newListingDetail"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 660
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getUserId()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 661
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment;->bUpdateOnShow:Z

    .line 662
    :cond_0
    return-void
.end method
