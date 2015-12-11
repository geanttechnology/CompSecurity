.class public Lcom/poshmark/ui/fragments/FindFriendsFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "FindFriendsFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/FindFriendsFragment$FetchFBFriendsCompletionsCallback;
    }
.end annotation


# instance fields
.field fbList:Lcom/poshmark/data_model/models/UserReferenceList;

.field suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

.field twitterList:Lcom/poshmark/data_model/models/UserReferenceList;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 39
    iput-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    .line 40
    iput-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->fbList:Lcom/poshmark/data_model/models/UserReferenceList;

    .line 41
    iput-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->twitterList:Lcom/poshmark/data_model/models/UserReferenceList;

    .line 448
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/FindFriendsFragment;Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindFriendsFragment;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/UserReferenceList;
    .param p2, "x2"    # Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .prologue
    .line 37
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->launchUserListFragment(Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindFriendsFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->fetchTwFriends()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindFriendsFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getSuggestedUsers()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindFriendsFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->updateTwitterPanel()V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindFriendsFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->updateFacebookPanel()V

    return-void
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FindFriendsFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->updateSuggestedUsersPanel()V

    return-void
.end method

.method private fetchFbFriends(Lcom/poshmark/ui/fragments/FindFriendsFragment$FetchFBFriendsCompletionsCallback;)V
    .locals 1
    .param p1, "callback"    # Lcom/poshmark/ui/fragments/FindFriendsFragment$FetchFBFriendsCompletionsCallback;

    .prologue
    .line 271
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->fbList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->fbList:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/UserReferenceList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 272
    :cond_0
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 273
    new-instance v0, Lcom/poshmark/ui/fragments/FindFriendsFragment$8;

    invoke-direct {v0, p0, p1}, Lcom/poshmark/ui/fragments/FindFriendsFragment$8;-><init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;Lcom/poshmark/ui/fragments/FindFriendsFragment$FetchFBFriendsCompletionsCallback;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getFacebookFriends(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 295
    :cond_1
    return-void
.end method

.method private fetchTwFriends()V
    .locals 1

    .prologue
    .line 250
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->twitterList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-nez v0, :cond_0

    .line 251
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 252
    new-instance v0, Lcom/poshmark/ui/fragments/FindFriendsFragment$7;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment$7;-><init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getTwitterConnections(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 268
    :cond_0
    return-void
.end method

.method private getExternalConnections()V
    .locals 3

    .prologue
    .line 225
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v1

    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->FRIENDS_PERMISSION:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isPermissionEnabled(Ljava/lang/String;)Z

    move-result v0

    .line 226
    .local v0, "fbFriendsPermissionEnabled":Z
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->fbList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-nez v1, :cond_3

    .line 227
    if-eqz v0, :cond_2

    .line 228
    new-instance v1, Lcom/poshmark/ui/fragments/FindFriendsFragment$6;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment$6;-><init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V

    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->fetchFbFriends(Lcom/poshmark/ui/fragments/FindFriendsFragment$FetchFBFriendsCompletionsCallback;)V

    .line 244
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-eqz v1, :cond_1

    .line 245
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->updateSuggestedUsersPanel()V

    .line 247
    :cond_1
    return-void

    .line 237
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-nez v1, :cond_0

    .line 238
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getSuggestedUsers()V

    goto :goto_0

    .line 242
    :cond_3
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->updateFacebookPanel()V

    goto :goto_0
.end method

.method private getSuggestedUsers()V
    .locals 4

    .prologue
    .line 298
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-nez v0, :cond_0

    .line 299
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 300
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    new-instance v3, Lcom/poshmark/ui/fragments/FindFriendsFragment$9;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment$9;-><init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V

    invoke-static {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApi;->getSuggestedUsers(Ljava/lang/String;ZILcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 319
    :goto_0
    return-void

    .line 317
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->updateSuggestedUsersPanel()V

    goto :goto_0
.end method

.method private launchUserListFragment(Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V
    .locals 4
    .param p1, "userList"    # Lcom/poshmark/data_model/models/UserReferenceList;
    .param p2, "mode"    # Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    .prologue
    .line 217
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 218
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 219
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    invoke-virtual {p2}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 220
    const-class v2, Lcom/poshmark/ui/fragments/UserListFragment;

    invoke-virtual {v0, v1, v2, p1}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 221
    return-void
.end method

.method private populateUserPanels()V
    .locals 2

    .prologue
    .line 72
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getFacebookToken()Ljava/lang/String;

    move-result-object v0

    .line 73
    .local v0, "fbToken":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 76
    :cond_0
    return-void
.end method

.method private setupContactsPanel()V
    .locals 3

    .prologue
    .line 130
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c013a

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 131
    .local v0, "contactsPanel":Landroid/widget/RelativeLayout;
    new-instance v1, Lcom/poshmark/ui/fragments/FindFriendsFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment$2;-><init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    return-void
.end method

.method private setupFacebookPanel()V
    .locals 3

    .prologue
    .line 146
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c013e

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 147
    .local v0, "fbPanel":Landroid/widget/RelativeLayout;
    new-instance v1, Lcom/poshmark/ui/fragments/FindFriendsFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment$3;-><init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 162
    return-void
.end method

.method private setupSuggestedUsersPanel()V
    .locals 3

    .prologue
    .line 167
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c014a

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 168
    .local v0, "suggestedUserPanel":Landroid/widget/RelativeLayout;
    new-instance v1, Lcom/poshmark/ui/fragments/FindFriendsFragment$4;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment$4;-><init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 178
    return-void
.end method

.method private setupTwitterPanel()V
    .locals 3

    .prologue
    .line 182
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0144

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 183
    .local v0, "twPanel":Landroid/widget/RelativeLayout;
    new-instance v1, Lcom/poshmark/ui/fragments/FindFriendsFragment$5;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment$5;-><init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 214
    return-void
.end method

.method private updateFacebookPanel()V
    .locals 14

    .prologue
    .line 366
    iget-object v10, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->fbList:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/UserReferenceList;->getConnectionInfoList()Ljava/util/List;

    move-result-object v5

    .line 367
    .local v5, "list":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    invoke-interface {v5}, Ljava/util/List;->isEmpty()Z

    move-result v10

    if-nez v10, :cond_1

    .line 370
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v10

    const v11, 0x7f0c0141

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 371
    .local v8, "title":Landroid/widget/TextView;
    const v10, 0x7f060109

    invoke-virtual {p0, v10}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 373
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f06010d

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 374
    .local v7, "str":Ljava/lang/String;
    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v7, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 375
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v10

    const v11, 0x7f0c0142

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .end local v8    # "title":Landroid/widget/TextView;
    check-cast v8, Landroid/widget/TextView;

    .line 376
    .restart local v8    # "title":Landroid/widget/TextView;
    const/4 v10, 0x0

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 377
    invoke-virtual {v8, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 380
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .line 381
    .local v4, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_1

    .line 382
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 383
    .local v3, "info":Lcom/poshmark/data_model/models/inner_models/UserReference;
    new-instance v2, Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-direct {v2, v10}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 384
    .local v2, "img":Landroid/widget/ImageView;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v10, -0x2

    const/4 v11, -0x2

    invoke-direct {v6, v10, v11}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 385
    .local v6, "lp":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v10, 0x46

    iput v10, v6, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 386
    const/16 v10, 0x46

    iput v10, v6, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 387
    const/16 v10, 0xa

    const/16 v11, 0xa

    const/16 v12, 0xa

    const/16 v13, 0xa

    invoke-virtual {v6, v10, v11, v12, v13}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 388
    invoke-virtual {v2, v6}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 390
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v9

    .line 391
    .local v9, "url":Ljava/lang/String;
    if-nez v9, :cond_0

    .line 392
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f0200d4

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v10

    invoke-virtual {v2, v10}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 399
    :goto_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v10

    const v11, 0x7f0c0143

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 400
    .local v0, "imageLayout":Landroid/widget/LinearLayout;
    const/4 v10, 0x0

    invoke-virtual {v0, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 401
    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 394
    .end local v0    # "imageLayout":Landroid/widget/LinearLayout;
    :cond_0
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v1

    .line 395
    .local v1, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    goto :goto_1

    .line 404
    .end local v1    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    .end local v2    # "img":Landroid/widget/ImageView;
    .end local v3    # "info":Lcom/poshmark/data_model/models/inner_models/UserReference;
    .end local v4    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    .end local v6    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    .end local v7    # "str":Ljava/lang/String;
    .end local v8    # "title":Landroid/widget/TextView;
    .end local v9    # "url":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private updateSuggestedUsersPanel()V
    .locals 14

    .prologue
    .line 323
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v10

    const v11, 0x7f0c014d

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 324
    .local v8, "title":Landroid/widget/TextView;
    const v10, 0x7f060292

    invoke-virtual {p0, v10}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 327
    iget-object v10, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/UserReferenceList;->getConnectionInfoList()Ljava/util/List;

    move-result-object v5

    .line 328
    .local v5, "list":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    invoke-interface {v5}, Ljava/util/List;->isEmpty()Z

    move-result v10

    if-nez v10, :cond_1

    .line 330
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f060291

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 331
    .local v7, "str":Ljava/lang/String;
    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v7, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 332
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v10

    const v11, 0x7f0c014e

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .end local v8    # "title":Landroid/widget/TextView;
    check-cast v8, Landroid/widget/TextView;

    .line 333
    .restart local v8    # "title":Landroid/widget/TextView;
    const/4 v10, 0x0

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 334
    invoke-virtual {v8, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 337
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .line 338
    .local v4, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_1

    .line 339
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 340
    .local v3, "info":Lcom/poshmark/data_model/models/inner_models/UserReference;
    new-instance v2, Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-direct {v2, v10}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 341
    .local v2, "img":Landroid/widget/ImageView;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v10, -0x2

    const/4 v11, -0x2

    invoke-direct {v6, v10, v11}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 342
    .local v6, "lp":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v10, 0x46

    iput v10, v6, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 343
    const/16 v10, 0x46

    iput v10, v6, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 344
    const/16 v10, 0xa

    const/16 v11, 0xa

    const/16 v12, 0xa

    const/16 v13, 0xa

    invoke-virtual {v6, v10, v11, v12, v13}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 345
    invoke-virtual {v2, v6}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 347
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v9

    .line 348
    .local v9, "url":Ljava/lang/String;
    if-nez v9, :cond_0

    .line 349
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f0200d4

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v10

    invoke-virtual {v2, v10}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 356
    :goto_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v10

    const v11, 0x7f0c014f

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 357
    .local v0, "imageLayout":Landroid/widget/LinearLayout;
    const/4 v10, 0x0

    invoke-virtual {v0, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 358
    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 351
    .end local v0    # "imageLayout":Landroid/widget/LinearLayout;
    :cond_0
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v1

    .line 352
    .local v1, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    goto :goto_1

    .line 361
    .end local v1    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    .end local v2    # "img":Landroid/widget/ImageView;
    .end local v3    # "info":Lcom/poshmark/data_model/models/inner_models/UserReference;
    .end local v4    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    .end local v6    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    .end local v7    # "str":Ljava/lang/String;
    .end local v9    # "url":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private updateTwitterPanel()V
    .locals 14

    .prologue
    .line 408
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v10

    const v11, 0x7f0c0147

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 409
    .local v8, "title":Landroid/widget/TextView;
    const v10, 0x7f0602a1

    invoke-virtual {p0, v10}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 412
    iget-object v10, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->twitterList:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/UserReferenceList;->getConnectionInfoList()Ljava/util/List;

    move-result-object v5

    .line 413
    .local v5, "list":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    invoke-interface {v5}, Ljava/util/List;->isEmpty()Z

    move-result v10

    if-nez v10, :cond_1

    .line 415
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f06029f

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 416
    .local v7, "str":Ljava/lang/String;
    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v7, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 417
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v10

    const v11, 0x7f0c0148

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .end local v8    # "title":Landroid/widget/TextView;
    check-cast v8, Landroid/widget/TextView;

    .line 418
    .restart local v8    # "title":Landroid/widget/TextView;
    const/4 v10, 0x0

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 419
    invoke-virtual {v8, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 422
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .line 423
    .local v4, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_1

    .line 424
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 425
    .local v3, "info":Lcom/poshmark/data_model/models/inner_models/UserReference;
    new-instance v2, Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-direct {v2, v10}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 426
    .local v2, "img":Landroid/widget/ImageView;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v10, -0x2

    const/4 v11, -0x2

    invoke-direct {v6, v10, v11}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 427
    .local v6, "lp":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v10, 0x46

    iput v10, v6, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 428
    const/16 v10, 0x46

    iput v10, v6, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 429
    const/16 v10, 0xa

    const/16 v11, 0xa

    const/16 v12, 0xa

    const/16 v13, 0xa

    invoke-virtual {v6, v10, v11, v12, v13}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 430
    invoke-virtual {v2, v6}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 432
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v9

    .line 433
    .local v9, "url":Ljava/lang/String;
    if-nez v9, :cond_0

    .line 434
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f0200d4

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v10

    invoke-virtual {v2, v10}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 441
    :goto_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getView()Landroid/view/View;

    move-result-object v10

    const v11, 0x7f0c0149

    invoke-virtual {v10, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 442
    .local v0, "imageLayout":Landroid/widget/LinearLayout;
    const/4 v10, 0x0

    invoke-virtual {v0, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 443
    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 436
    .end local v0    # "imageLayout":Landroid/widget/LinearLayout;
    :cond_0
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v1

    .line 437
    .local v1, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    goto :goto_1

    .line 446
    .end local v1    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    .end local v2    # "img":Landroid/widget/ImageView;
    .end local v3    # "info":Lcom/poshmark/data_model/models/inner_models/UserReference;
    .end local v4    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/UserReference;>;"
    .end local v6    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    .end local v7    # "str":Ljava/lang/String;
    .end local v9    # "url":Ljava/lang/String;
    :cond_1
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 57
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 59
    const v0, 0x7f0601fd

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->setTitle(I)V

    .line 61
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->setupContactsPanel()V

    .line 62
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->setupTwitterPanel()V

    .line 63
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->setupFacebookPanel()V

    .line 64
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->setupSuggestedUsersPanel()V

    .line 67
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getExternalConnections()V

    .line 69
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 95
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 96
    invoke-static {p1}, Lcom/facebook/FacebookSdk;->isFacebookRequestCode(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 97
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getCallbackManager()Lcom/facebook/CallbackManager;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3}, Lcom/facebook/CallbackManager;->onActivityResult(IILandroid/content/Intent;)Z

    .line 99
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 45
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 46
    const v1, 0x7f030052

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 47
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 52
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 53
    return-void
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 6
    .param p1, "result"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    const/4 v5, 0x0

    .line 103
    sget v4, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_FRIENDS_REQUEST:I

    if-ne p2, v4, :cond_0

    .line 105
    if-eqz p1, :cond_0

    .line 106
    const-string v4, "HAS_ERROR"

    invoke-virtual {p1, v4, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    .line 107
    .local v2, "hasError":Z
    if-nez v2, :cond_1

    .line 108
    const-string v4, "ACCESS_LEVEL"

    invoke-virtual {p1, v4, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v3

    .line 109
    .local v3, "permissionsGranted":I
    and-int/lit8 v4, v3, 0x4

    if-eqz v4, :cond_0

    .line 110
    const/4 v4, 0x0

    invoke-direct {p0, v4}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->fetchFbFriends(Lcom/poshmark/ui/fragments/FindFriendsFragment$FetchFBFriendsCompletionsCallback;)V

    .line 122
    .end local v2    # "hasError":Z
    .end local v3    # "permissionsGranted":I
    :cond_0
    :goto_0
    return-void

    .line 113
    .restart local v2    # "hasError":Z
    :cond_1
    const-string v4, "ERROR_JSON"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 114
    .local v1, "errorJson":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 115
    invoke-static {v1}, Lcom/poshmark/http/api/PMApiError;->deserialize(Ljava/lang/String;)Lcom/poshmark/http/api/PMApiError;

    move-result-object v0

    .line 116
    .local v0, "error":Lcom/poshmark/http/api/PMApiError;
    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-static {v0, p0, v4}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->showFBLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    goto :goto_0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 126
    const-string v0, "on_ramp_following_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 127
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 80
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 81
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v0

    .line 82
    .local v0, "doneButton":Landroid/widget/Button;
    const v1, 0x7f0600bf

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 83
    new-instance v1, Lcom/poshmark/ui/fragments/FindFriendsFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment$1;-><init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    return-void
.end method
