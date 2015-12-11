.class public Lcom/poshmark/ui/fragments/UserSharesFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "UserSharesFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/ListingNotificationHandler;


# instance fields
.field aboutButtonClickListener:Landroid/view/View$OnClickListener;

.field private adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

.field closetOnClickListener:Landroid/view/View$OnClickListener;

.field private emptyListHeader:Landroid/view/View;

.field followerOnClickListener:Landroid/view/View$OnClickListener;

.field followingOnClickListener:Landroid/view/View$OnClickListener;

.field private headerView:Landroid/view/View;

.field private listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

.field private profileData:Lcom/poshmark/user/UserInfoDetails;

.field private sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

.field private sharesListView:Lcom/poshmark/ui/customviews/PMListView;

.field private userName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 50
    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 52
    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    .line 53
    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    .line 56
    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->emptyListHeader:Landroid/view/View;

    .line 145
    new-instance v0, Lcom/poshmark/ui/fragments/UserSharesFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSharesFragment$1;-><init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->aboutButtonClickListener:Landroid/view/View$OnClickListener;

    .line 239
    new-instance v0, Lcom/poshmark/ui/fragments/UserSharesFragment$6;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSharesFragment$6;-><init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->closetOnClickListener:Landroid/view/View$OnClickListener;

    .line 299
    new-instance v0, Lcom/poshmark/ui/fragments/UserSharesFragment$7;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSharesFragment$7;-><init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->followerOnClickListener:Landroid/view/View$OnClickListener;

    .line 312
    new-instance v0, Lcom/poshmark/ui/fragments/UserSharesFragment$8;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSharesFragment$8;-><init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->followingOnClickListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/UserSharesFragment;)Lcom/poshmark/user/UserInfoDetails;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/UserSharesFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    return-object v0
.end method

.method static synthetic access$002(Lcom/poshmark/ui/fragments/UserSharesFragment;Lcom/poshmark/user/UserInfoDetails;)Lcom/poshmark/user/UserInfoDetails;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/UserSharesFragment;
    .param p1, "x1"    # Lcom/poshmark/user/UserInfoDetails;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    return-object p1
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/UserSharesFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/UserSharesFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->userName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/UserSharesFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/UserSharesFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 48
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getUserShares(Z)V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/UserSharesFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/UserSharesFragment;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->updateProfileCard()V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/UserSharesFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/UserSharesFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 48
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/UserSharesFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method private getUserShares(Z)V
    .locals 3
    .param p1, "isPagination"    # Z

    .prologue
    .line 215
    if-eqz p1, :cond_0

    .line 217
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v0}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/UserSharesFragment$4;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/UserSharesFragment$4;-><init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->getUserSharesList(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 237
    :goto_0
    return-void

    .line 227
    :cond_0
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 228
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v0}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-instance v2, Lcom/poshmark/ui/fragments/UserSharesFragment$5;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/UserSharesFragment$5;-><init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->getUserSharesList(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

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
    .line 273
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->hideProgressDialog()V

    .line 274
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_2

    .line 276
    if-nez p2, :cond_1

    .line 277
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/ListingSummaryCollection;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    .line 278
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->createHashAndRemoveDups()V

    .line 279
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 280
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 281
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 282
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 283
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 284
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->showCustomEmptyListingsMessage()V

    .line 296
    :cond_0
    :goto_0
    return-void

    .line 287
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 288
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 292
    :cond_2
    if-nez p2, :cond_0

    .line 293
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_CLOSET:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0600eb

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private setupClosetList()V
    .locals 5

    .prologue
    .line 177
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c00c0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 178
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->headerView:Landroid/view/View;

    const/4 v3, 0x0

    new-instance v4, Lcom/poshmark/ui/fragments/UserSharesFragment$2;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/UserSharesFragment$2;-><init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 185
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    if-nez v0, :cond_0

    .line 186
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 187
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->userName:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/UserSharesFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/UserSharesFragment$3;-><init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getUserProfile(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 212
    :goto_0
    return-void

    .line 209
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 210
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->updateProfileCard()V

    goto :goto_0
.end method

.method private setupHeaderView(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 373
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 374
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v1, 0x7f0300cd

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->headerView:Landroid/view/View;

    .line 375
    new-instance v1, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    invoke-direct {v1}, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    .line 376
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c0062

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->bgCovershotImageView:Landroid/widget/ImageView;

    .line 377
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c00c1

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/RoundedImageView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->avataarImageView:Lcom/poshmark/ui/customviews/RoundedImageView;

    .line 378
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c0261

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->titleView:Landroid/widget/TextView;

    .line 379
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c0066

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    .line 380
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->headerView:Landroid/view/View;

    const v3, 0x7f0c0218

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, v2, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->followButtonWrapper:Landroid/widget/LinearLayout;

    .line 381
    return-void
.end method

.method private updateProfileCard()V
    .locals 7

    .prologue
    .line 328
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getUserVisibleHint()Z

    move-result v4

    if-eqz v4, :cond_2

    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    if-eqz v4, :cond_2

    .line 329
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getView()Landroid/view/View;

    move-result-object v3

    .line 330
    .local v3, "v":Landroid/view/View;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v0, v4, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->avataarImageView:Lcom/poshmark/ui/customviews/RoundedImageView;

    .line 331
    .local v0, "avataar":Lcom/poshmark/ui/customviews/RoundedImageView;
    if-eqz v0, :cond_0

    .line 332
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v1

    .line 333
    .local v1, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v2

    .line 334
    .local v2, "pictureURL":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 335
    invoke-virtual {v1, v2, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 336
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->aboutButtonClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v4}, Lcom/poshmark/ui/customviews/RoundedImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 340
    .end local v1    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    .end local v2    # "pictureURL":Ljava/lang/String;
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "@"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v5}, Lcom/poshmark/user/UserInfoDetails;->getDisplayHandle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/UserSharesFragment;->setTitle(Ljava/lang/String;)V

    .line 342
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->titleView:Landroid/widget/TextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "@"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v6}, Lcom/poshmark/user/UserInfoDetails;->getDisplayHandle()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 343
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v1

    .line 344
    .restart local v1    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 345
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 346
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->bgCovershotImageView:Landroid/widget/ImageView;

    invoke-virtual {v1, v4, v5}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 350
    :cond_1
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 351
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->followButtonWrapper:Landroid/widget/LinearLayout;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 370
    .end local v0    # "avataar":Lcom/poshmark/ui/customviews/RoundedImageView;
    .end local v1    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    .end local v3    # "v":Landroid/view/View;
    :cond_2
    :goto_0
    return-void

    .line 354
    .restart local v0    # "avataar":Lcom/poshmark/ui/customviews/RoundedImageView;
    .restart local v1    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    .restart local v3    # "v":Landroid/view/View;
    :cond_3
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->followButtonWrapper:Landroid/widget/LinearLayout;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 356
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v5}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v6}, Lcom/poshmark/user/UserInfoDetails;->isCallerFollowing()Z

    move-result v6

    invoke-virtual {v4, v5, v6}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setUser(Ljava/lang/String;Z)V

    .line 357
    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    new-instance v5, Lcom/poshmark/ui/fragments/UserSharesFragment$9;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/UserSharesFragment$9;-><init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setListener(Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;)V

    goto :goto_0
.end method


# virtual methods
.method public addCommentToListing(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 407
    return-void
.end method

.method public deleteListing(Ljava/lang/String;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 416
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 417
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->bUpdateOnShow:Z

    .line 418
    :cond_0
    return-void
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 136
    const-string v0, "ush"

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 386
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    const-string v4, "com.poshmark.intents.USER_FOLLOW_STATUS_CHANGED"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 387
    const-string v3, "RESULT"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 388
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "USER"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 389
    .local v2, "userId":Ljava/lang/String;
    const-string v3, "IS_FOLLOWING"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    .line 390
    .local v1, "isFollowing":Z
    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 391
    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3, v1}, Lcom/poshmark/user/UserInfoDetails;->setCallerIsFollowing(Z)V

    .line 392
    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesHeaderViewHolder:Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/SharesHeaderViewHolder;->followFollowingButtonLayout:Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    invoke-virtual {v3, v2, v1}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setUser(Ljava/lang/String;Z)V

    .line 395
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "isFollowing":Z
    .end local v2    # "userId":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public likeListing(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "likeStatus"    # Z

    .prologue
    .line 412
    return-void
.end method

.method public newListingCreated()V
    .locals 0

    .prologue
    .line 423
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 82
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 83
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->setupClosetList()V

    .line 84
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 60
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 61
    new-instance v0, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    const/high16 v3, -0x80000000

    invoke-direct {v0, v1, p0, v2, v3}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 62
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "NAME"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, "\n"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->userName:Ljava/lang/String;

    .line 63
    const-class v0, Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/user/UserInfoDetails;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    .line 64
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    if-eqz v0, :cond_0

    .line 66
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->bUpdateOnShow:Z

    .line 68
    :cond_0
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/ListingNotificationManager;->registerListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V

    .line 69
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 73
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 74
    const v1, 0x7f030026

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 76
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->setupHeaderView(Landroid/view/View;)V

    .line 77
    return-object v0
.end method

.method public onPMResume()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 94
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 95
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.USER_FOLLOW_STATUS_CHANGED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 96
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 97
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->bUpdateOnShow:Z

    if-eqz v0, :cond_1

    .line 98
    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->bUpdateOnShow:Z

    .line 100
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getUserShares(Z)V

    .line 108
    :cond_0
    :goto_0
    return-void

    .line 102
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 103
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->listingSummaryCollectionData:Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSummaryCollection;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 104
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->showCustomEmptyListingsMessage()V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 141
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPause()V

    .line 142
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 143
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 112
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 113
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 114
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 88
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onStop()V

    .line 89
    iget-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->clearImageList()V

    .line 90
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 172
    const-string v0, "shared_listings_page"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 173
    return-void
.end method

.method public setupActionBar()V
    .locals 3

    .prologue
    .line 118
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 119
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    if-nez v1, :cond_0

    .line 120
    const-string v1, ""

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/UserSharesFragment;->setTitle(Ljava/lang/String;)V

    .line 132
    :goto_0
    return-void

    .line 122
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v1}, Lcom/poshmark/user/UserInfoDetails;->getDisplayStatus()Ljava/lang/String;

    move-result-object v0

    .line 123
    .local v0, "closet_status_msg":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 124
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->setSubTitle(Ljava/lang/String;)V

    .line 126
    :cond_1
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v2}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 127
    const-string v1, "My Shares"

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/UserSharesFragment;->setTitle(Ljava/lang/String;)V

    goto :goto_0

    .line 129
    :cond_2
    const-string v1, "Shares"

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/UserSharesFragment;->setTitle(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public showCustomEmptyListingsMessage()V
    .locals 7

    .prologue
    const v5, 0x7f0c00cc

    const/4 v6, 0x0

    .line 253
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 254
    .local v0, "inflater":Landroid/view/LayoutInflater;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->emptyListHeader:Landroid/view/View;

    if-nez v3, :cond_0

    .line 255
    const v3, 0x7f030029

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->emptyListHeader:Landroid/view/View;

    .line 257
    :cond_0
    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getListingCount()I

    move-result v3

    if-lez v3, :cond_1

    .line 258
    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->emptyListHeader:Landroid/view/View;

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    .line 259
    .local v2, "shopClosetMsg":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v2, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 260
    const v3, 0x7f060266

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v5}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 261
    .local v1, "msg":Ljava/lang/String;
    invoke-virtual {v2, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 262
    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->closetOnClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 267
    .end local v1    # "msg":Ljava/lang/String;
    .end local v2    # "shopClosetMsg":Lcom/poshmark/ui/customviews/PMTextView;
    :goto_0
    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->sharesListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->emptyListHeader:Landroid/view/View;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMListView;->showEmptyContentView(Landroid/view/View;)V

    .line 268
    return-void

    .line 265
    :cond_1
    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->emptyListHeader:Landroid/view/View;

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 2
    .param p1, "newListingDetail"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 400
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getUserId()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 401
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/UserSharesFragment;->bUpdateOnShow:Z

    .line 402
    :cond_0
    return-void
.end method
