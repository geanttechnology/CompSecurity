.class public Lcom/poshmark/ui/fragments/FeedFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "FeedFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/ListingNotificationHandler;
.implements Lcom/poshmark/notifications/SynchronousBroadcastListener;


# instance fields
.field adapter:Lcom/poshmark/data_model/adapters/FeedListAdapter;

.field feedData:Lcom/poshmark/data_model/models/Feed_v1;

.field feedListView:Lcom/poshmark/ui/customviews/PMListView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/FeedFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FeedFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 33
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/FeedFragment;->getFeed(Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/FeedFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FeedFragment;

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FeedFragment;->showFindPeopleFragment()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/FeedFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FeedFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/FeedFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method private getFeed(Z)V
    .locals 2
    .param p1, "isPagination"    # Z

    .prologue
    .line 164
    if-nez p1, :cond_1

    .line 165
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FeedFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 166
    const/4 v0, 0x0

    new-instance v1, Lcom/poshmark/ui/fragments/FeedFragment$5;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/FeedFragment$5;-><init>(Lcom/poshmark/ui/fragments/FeedFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getFeed(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 187
    :cond_0
    :goto_0
    return-void

    .line 176
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Feed_v1;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 177
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Feed_v1;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/FeedFragment$6;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/FeedFragment$6;-><init>(Lcom/poshmark/ui/fragments/FeedFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getFeed(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

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
            "Lcom/poshmark/data_model/models/Feed_v1;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 190
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/Feed_v1;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedFragment;->hideProgressDialog()V

    .line 191
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_2

    .line 192
    if-nez p2, :cond_1

    .line 193
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/Feed_v1;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    .line 194
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Feed_v1;->createHashAndRemoveDups()V

    .line 195
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 196
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 197
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 208
    :cond_0
    :goto_0
    return-void

    .line 199
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/Feed_v1;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 200
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 204
    :cond_2
    if-nez p2, :cond_0

    .line 205
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_MY_FEED:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0600e7

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FeedFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private setupFeedList()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 150
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    if-eqz v0, :cond_0

    .line 151
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 155
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->bUpdateOnShow:Z

    if-eqz v0, :cond_2

    .line 156
    :cond_1
    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/FeedFragment;->bUpdateOnShow:Z

    .line 157
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FeedFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 158
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/FeedFragment;->getFeed(Z)V

    .line 160
    :cond_2
    return-void
.end method

.method private showFindPeopleFragment()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 145
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 146
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v1, Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v0, v2, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 147
    return-void
.end method


# virtual methods
.method public addCommentToListing(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 247
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    if-eqz v0, :cond_0

    .line 248
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    invoke-virtual {v0, p1, p2}, Lcom/poshmark/data_model/models/Feed_v1;->addNewComment(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V

    .line 249
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 251
    :cond_0
    return-void
.end method

.method public deleteListing(Ljava/lang/String;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 263
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    if-eqz v0, :cond_0

    .line 264
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/Feed_v1;->deleteListing(Ljava/lang/String;)V

    .line 265
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 267
    :cond_0
    return-void
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 136
    const-string v0, "fd"

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x0

    .line 213
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 214
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    .line 217
    :cond_0
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 218
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 219
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 220
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FeedFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 221
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/FeedFragment;->getFeed(Z)V

    .line 229
    :cond_1
    :goto_0
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.UPDATE_FEED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 230
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 231
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/FeedFragment;->getFeed(Z)V

    .line 234
    :cond_2
    return-void

    .line 224
    :cond_3
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->bUpdateOnShow:Z

    goto :goto_0
.end method

.method public handleSynchronousBroadcastMsg(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "intent"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/Object;

    .prologue
    .line 93
    const-string v0, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 96
    :cond_0
    return-void
.end method

.method public likeListing(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "likeStatus"    # Z

    .prologue
    .line 255
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    if-eqz v0, :cond_0

    .line 256
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    invoke-virtual {v0, p1, p2}, Lcom/poshmark/data_model/models/Feed_v1;->updateLikeStatus(Ljava/lang/String;Z)V

    .line 257
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 259
    :cond_0
    return-void
.end method

.method public newListingCreated()V
    .locals 1

    .prologue
    .line 271
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->bUpdateOnShow:Z

    .line 272
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 68
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 41
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 42
    new-instance v0, Lcom/poshmark/data_model/adapters/FeedListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    const/high16 v3, -0x80000000

    invoke-direct {v0, v1, p0, v2, v3}, Lcom/poshmark/data_model/adapters/FeedListAdapter;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->adapter:Lcom/poshmark/data_model/adapters/FeedListAdapter;

    .line 43
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 44
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 45
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.UPDATE_FEED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 46
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/ListingNotificationManager;->registerListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V

    .line 47
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 51
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 53
    const v1, 0x7f03003e

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 54
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c010d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 56
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedFragment;->adapter:Lcom/poshmark/data_model/adapters/FeedListAdapter;

    new-instance v3, Lcom/poshmark/ui/fragments/FeedFragment$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/FeedFragment$1;-><init>(Lcom/poshmark/ui/fragments/FeedFragment;)V

    invoke-virtual {v1, v2, v4, v4, v3}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 62
    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 79
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 80
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 84
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 85
    invoke-static {}, Lcom/poshmark/notifications/SynchronousBroadcastManager;->getSyncronousBroadcastManager()Lcom/poshmark/notifications/SynchronousBroadcastManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/SynchronousBroadcastManager;->registerSynchronousBroadcastListener(Ljava/lang/String;Lcom/poshmark/notifications/SynchronousBroadcastListener;)V

    .line 86
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 87
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FeedFragment;->setupFeedList()V

    .line 89
    :cond_0
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 72
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onStop()V

    .line 73
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->adapter:Lcom/poshmark/data_model/adapters/FeedListAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/FeedListAdapter;->clearImageList()V

    .line 74
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 141
    const-string v0, "listings_feed_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 142
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 102
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 103
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedFragment;->showLogoAsTitle()V

    .line 104
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/FeedFragment;->showRefreshButton(Z)V

    .line 105
    new-instance v0, Lcom/poshmark/ui/fragments/FeedFragment$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/FeedFragment$2;-><init>(Lcom/poshmark/ui/fragments/FeedFragment;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FeedFragment;->setRefreshActionButtonListener(Landroid/view/View$OnClickListener;)V

    .line 114
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/FeedFragment;->showFindPeopleButton(Z)V

    .line 115
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/FeedFragment;->showSearchButton(Z)V

    .line 116
    new-instance v0, Lcom/poshmark/ui/fragments/FeedFragment$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/FeedFragment$3;-><init>(Lcom/poshmark/ui/fragments/FeedFragment;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FeedFragment;->setSearchActionButtonListener(Landroid/view/View$OnClickListener;)V

    .line 126
    new-instance v0, Lcom/poshmark/ui/fragments/FeedFragment$4;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/FeedFragment$4;-><init>(Lcom/poshmark/ui/fragments/FeedFragment;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FeedFragment;->setFindPeopleActionButtonListener(Landroid/view/View$OnClickListener;)V

    .line 132
    return-void
.end method

.method public updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 1
    .param p1, "listing"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 239
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    if-eqz v0, :cond_0

    .line 240
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed_v1;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/Feed_v1;->updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V

    .line 241
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 243
    :cond_0
    return-void
.end method
