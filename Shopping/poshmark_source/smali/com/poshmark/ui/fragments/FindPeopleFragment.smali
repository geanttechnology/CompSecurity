.class public Lcom/poshmark/ui/fragments/FindPeopleFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "FindPeopleFragment.java"


# static fields
.field private static screenTag:Ljava/lang/String;


# instance fields
.field private adapter:Lcom/poshmark/data_model/adapters/UserListAdapter;

.field fbUserList:Lcom/poshmark/data_model/models/UserReferenceList;

.field private headerView:Landroid/view/View;

.field itemClickListener:Landroid/view/View$OnClickListener;

.field private peopleListView:Landroid/widget/ListView;

.field private searchButton:Lcom/poshmark/ui/customviews/PMButton;

.field private searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

.field searchResultsList:Lcom/poshmark/data_model/models/UserReferenceList;

.field searchString:Ljava/lang/String;

.field suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

.field twitterUserList:Lcom/poshmark/data_model/models/UserReferenceList;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const-string v0, "su"

    sput-object v0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->screenTag:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 168
    new-instance v0, Lcom/poshmark/ui/fragments/FindPeopleFragment$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$2;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->itemClickListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindPeopleFragment;

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->updateUsersList()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindPeopleFragment;

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->fetchTwitterFriends()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindPeopleFragment;

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showTwitterFriends()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/FindPeopleFragment;Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindPeopleFragment;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/UserReferenceList;
    .param p2, "x2"    # Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .prologue
    .line 41
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->launchUserListFragment(Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/FindPeopleFragment;)Lcom/poshmark/ui/customviews/PMEditText;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindPeopleFragment;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    return-object v0
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindPeopleFragment;

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->findUsers()V

    return-void
.end method

.method static synthetic access$600(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindPeopleFragment;

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showFBFriends()V

    return-void
.end method

.method private fetchFBFriends()V
    .locals 3

    .prologue
    const/4 v2, 0x5

    .line 279
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->fbUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-nez v0, :cond_0

    .line 280
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    sget v1, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_FRIENDS_REQUEST:I

    invoke-virtual {v0, p0, v2, v2, v1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;III)V

    .line 283
    :cond_0
    return-void
.end method

.method private fetchFbFriendsFromPM()V
    .locals 1

    .prologue
    .line 259
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 260
    new-instance v0, Lcom/poshmark/ui/fragments/FindPeopleFragment$5;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$5;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getFacebookFriends(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 276
    return-void
.end method

.method private fetchTwitterFriends()V
    .locals 1

    .prologue
    .line 238
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->twitterUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-nez v0, :cond_0

    .line 239
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 240
    new-instance v0, Lcom/poshmark/ui/fragments/FindPeopleFragment$4;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$4;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getTwitterConnections(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 256
    :cond_0
    return-void
.end method

.method private findUsers()V
    .locals 2

    .prologue
    .line 286
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchString:Ljava/lang/String;

    .line 287
    const v0, 0x7f06023b

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 288
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchString:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->searchUsers(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 307
    return-void
.end method

.method private launchUserListFragment(Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V
    .locals 4
    .param p1, "userList"    # Lcom/poshmark/data_model/models/UserReferenceList;
    .param p2, "mode"    # Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .prologue
    .line 183
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 184
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 185
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 186
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    invoke-virtual {p2}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    const-class v2, Lcom/poshmark/ui/fragments/UserListFragment;

    invoke-virtual {v0, v1, v2, p1}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 189
    .end local v1    # "b":Landroid/os/Bundle;
    :cond_0
    return-void
.end method

.method private setupFindPeopleList()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 138
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-nez v0, :cond_0

    .line 139
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 140
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/FindPeopleFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$1;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    invoke-static {v0, v2, v2, v1}, Lcom/poshmark/http/api/PMApi;->getSuggestedUsers(Ljava/lang/String;ZILcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 155
    :cond_0
    return-void
.end method

.method private setupHeaderView()V
    .locals 7

    .prologue
    .line 310
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    .line 311
    .local v4, "inflater":Landroid/view/LayoutInflater;
    const v5, 0x7f030054

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    iput-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->headerView:Landroid/view/View;

    .line 312
    iget-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0151

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 313
    iget-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0039

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMButton;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 315
    iget-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchString:Ljava/lang/String;

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchString:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_0

    .line 316
    iget-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchString:Ljava/lang/String;

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 318
    :cond_0
    iget-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    new-instance v6, Lcom/poshmark/ui/fragments/FindPeopleFragment$7;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$7;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMEditText;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 331
    iget-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchButton:Lcom/poshmark/ui/customviews/PMButton;

    new-instance v6, Lcom/poshmark/ui/fragments/FindPeopleFragment$8;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$8;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 344
    iget-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0152

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 345
    .local v0, "findContactFriendsLayout":Landroid/widget/LinearLayout;
    new-instance v5, Lcom/poshmark/ui/fragments/FindPeopleFragment$9;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$9;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 357
    iget-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0154

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 358
    .local v1, "findFBFriendsLayout":Landroid/widget/LinearLayout;
    new-instance v5, Lcom/poshmark/ui/fragments/FindPeopleFragment$10;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$10;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 365
    iget-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0156

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 366
    .local v3, "findTwitterFriendsLayout":Landroid/widget/LinearLayout;
    new-instance v5, Lcom/poshmark/ui/fragments/FindPeopleFragment$11;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$11;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    invoke-virtual {v3, v5}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 373
    iget-object v5, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0157

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 374
    .local v2, "findNewClosetsLayout":Landroid/widget/LinearLayout;
    new-instance v5, Lcom/poshmark/ui/fragments/FindPeopleFragment$12;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$12;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 389
    return-void
.end method

.method private showFBFriends()V
    .locals 7

    .prologue
    const/4 v6, 0x5

    .line 192
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "user"

    const-string v4, "load_facebook_friends"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 193
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v1

    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->FRIENDS_PERMISSION:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isPermissionEnabled(Ljava/lang/String;)Z

    move-result v0

    .line 194
    .local v0, "fbFriendsPermissionEnabled":Z
    if-eqz v0, :cond_1

    .line 195
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->fbUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-nez v1, :cond_0

    .line 196
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->fetchFBFriends()V

    .line 205
    :goto_0
    return-void

    .line 199
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->fbUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    sget-object v2, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->FB_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-direct {p0, v1, v2}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->launchUserListFragment(Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V

    goto :goto_0

    .line 202
    :cond_1
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v1

    sget v2, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_FRIENDS_REQUEST:I

    invoke-virtual {v1, p0, v6, v6, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;III)V

    goto :goto_0
.end method

.method private showNewClosets()V
    .locals 0

    .prologue
    .line 393
    return-void
.end method

.method private showTwitterFriends()V
    .locals 6

    .prologue
    .line 208
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "user"

    const-string v4, "load_twitter_friends"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 209
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getTwitterToken()Ljava/lang/String;

    move-result-object v0

    .line 210
    .local v0, "twToken":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 211
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->twitterUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-nez v1, :cond_0

    .line 212
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->fetchTwitterFriends()V

    .line 235
    :goto_0
    return-void

    .line 215
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->twitterUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    sget-object v2, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->TWITTER_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-direct {p0, v1, v2}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->launchUserListFragment(Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V

    goto :goto_0

    .line 218
    :cond_1
    const v1, 0x7f060190

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 219
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/FindPeopleFragment$3;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment$3;-><init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    invoke-virtual {v1, p0, v2}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->twitterLink(Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V

    goto :goto_0
.end method

.method private updateUsersList()V
    .locals 4

    .prologue
    .line 158
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-eqz v1, :cond_0

    .line 159
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-direct {v0, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 160
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/UserReferenceList;->fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V

    .line 161
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->adapter:Lcom/poshmark/data_model/adapters/UserListAdapter;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/adapters/UserListAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 162
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->adapter:Lcom/poshmark/data_model/adapters/UserListAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/UserListAdapter;->notifyDataSetChanged()V

    .line 164
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->adapter:Lcom/poshmark/data_model/adapters/UserListAdapter;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->itemClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/adapters/UserListAdapter;->setOnItemClickListener(Landroid/view/View$OnClickListener;)V

    .line 166
    .end local v0    # "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    :cond_0
    return-void
.end method


# virtual methods
.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 130
    const-string v0, "su"

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 397
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 398
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    .line 401
    :cond_0
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 402
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->bUpdateOnShow:Z

    .line 404
    :cond_1
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 81
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 82
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 60
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 61
    sget-object v0, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->REGULAR:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    .line 62
    new-instance v0, Lcom/poshmark/data_model/adapters/UserListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    const/high16 v3, -0x80000000

    invoke-direct {v0, v1, p0, v2, v3}, Lcom/poshmark/data_model/adapters/UserListAdapter;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->adapter:Lcom/poshmark/data_model/adapters/UserListAdapter;

    .line 63
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 64
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 66
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 70
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 71
    const v1, 0x7f030053

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 72
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->setupHeaderView()V

    .line 73
    const v1, 0x7f0c0150

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->peopleListView:Landroid/widget/ListView;

    .line 74
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->peopleListView:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->headerView:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 75
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->peopleListView:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->adapter:Lcom/poshmark/data_model/adapters/UserListAdapter;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 76
    return-object v0
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 6
    .param p1, "result"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    const/4 v5, 0x0

    .line 107
    sget v4, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_FRIENDS_REQUEST:I

    if-ne p2, v4, :cond_0

    .line 109
    if-eqz p1, :cond_0

    .line 110
    const-string v4, "HAS_ERROR"

    invoke-virtual {p1, v4, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    .line 111
    .local v2, "hasError":Z
    if-nez v2, :cond_1

    .line 112
    const-string v4, "ACCESS_LEVEL"

    invoke-virtual {p1, v4, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v3

    .line 113
    .local v3, "permissionsGranted":I
    and-int/lit8 v4, v3, 0x4

    if-eqz v4, :cond_0

    .line 114
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->fetchFbFriendsFromPM()V

    .line 126
    .end local v2    # "hasError":Z
    .end local v3    # "permissionsGranted":I
    :cond_0
    :goto_0
    return-void

    .line 117
    .restart local v2    # "hasError":Z
    :cond_1
    const-string v4, "ERROR_JSON"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 118
    .local v1, "errorJson":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 119
    invoke-static {v1}, Lcom/poshmark/http/api/PMApiError;->deserialize(Ljava/lang/String;)Lcom/poshmark/http/api/PMApiError;

    move-result-object v0

    .line 120
    .local v0, "error":Lcom/poshmark/http/api/PMApiError;
    invoke-static {v0, p0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->showFBLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;)V

    goto :goto_0
.end method

.method public onPMResume()V
    .locals 1

    .prologue
    .line 98
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 99
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 100
    sget-object v0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->screenTag:Ljava/lang/String;

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getViewTrackingInfo(Ljava/lang/String;)V

    .line 101
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->setupFindPeopleList()V

    .line 103
    :cond_0
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 134
    const-string v0, "search_people_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 135
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 86
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 87
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/poshmark/ui/MainActivity;

    if-eq v0, v1, :cond_0

    .line 88
    const v0, 0x7f060129

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->setTitle(Ljava/lang/String;)V

    .line 92
    :goto_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showRefreshButton(Z)V

    .line 94
    return-void

    .line 90
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showLogoAsTitle()V

    goto :goto_0
.end method
