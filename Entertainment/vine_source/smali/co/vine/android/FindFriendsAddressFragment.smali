.class public Lco/vine/android/FindFriendsAddressFragment;
.super Lco/vine/android/FindFriendsBaseFragment;
.source "FindFriendsAddressFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/FindFriendsAddressFragment$FriendsListener;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lco/vine/android/FindFriendsBaseFragment;-><init>()V

    .line 118
    return-void
.end method


# virtual methods
.method public getFirstItemPosition()Lcom/twitter/android/widget/ItemPosition;
    .locals 1

    .prologue
    .line 73
    const/4 v0, 0x0

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x1

    .line 78
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 98
    :cond_0
    :goto_0
    return-void

    .line 80
    :pswitch_0
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/FollowButtonViewHolder;

    .line 81
    .local v0, "holder":Lco/vine/android/FollowButtonViewHolder;
    if-eqz v0, :cond_0

    .line 82
    iget-boolean v1, v0, Lco/vine/android/FollowButtonViewHolder;->following:Z

    if-nez v1, :cond_1

    .line 83
    iget-object v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/FindFriendsAddressFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    iget-wide v3, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3, v4, v5}, Lco/vine/android/client/AppController;->followUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;

    .line 85
    iget-object v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mFriendships:Lco/vine/android/Friendships;

    iget-wide v2, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3}, Lco/vine/android/Friendships;->addFollowing(J)V

    .line 86
    iget-object v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->notifyDataSetChanged()V

    .line 87
    iget v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mNewFollowsCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mNewFollowsCount:I

    goto :goto_0

    .line 89
    :cond_1
    iget-object v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/FindFriendsAddressFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    iget-wide v3, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3, v4, v5}, Lco/vine/android/client/AppController;->unfollowUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;

    .line 91
    iget-object v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mFriendships:Lco/vine/android/Friendships;

    iget-wide v2, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3}, Lco/vine/android/Friendships;->removeFollowing(J)V

    .line 92
    iget-object v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 78
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a022d
        :pswitch_0
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 32
    invoke-super {p0, p1}, Lco/vine/android/FindFriendsBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 33
    new-instance v0, Lco/vine/android/FindFriendsAddressFragment$FriendsListener;

    invoke-direct {v0, p0}, Lco/vine/android/FindFriendsAddressFragment$FriendsListener;-><init>(Lco/vine/android/FindFriendsAddressFragment;)V

    iput-object v0, p0, Lco/vine/android/FindFriendsAddressFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 34
    return-void
.end method

.method public onMoveAway(I)V
    .locals 3
    .param p1, "newPosition"    # I

    .prologue
    .line 102
    invoke-super {p0, p1}, Lco/vine/android/FindFriendsBaseFragment;->onMoveAway(I)V

    .line 103
    iget-boolean v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mFetched:Z

    if-eqz v1, :cond_0

    .line 104
    iget v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mNewFollowsCount:I

    const/16 v2, 0xf

    if-le v1, v2, :cond_1

    const-string v0, ">15"

    .line 105
    .local v0, "count":Ljava/lang/String;
    :goto_0
    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackAddressNewFollowingCount(Ljava/lang/String;)V

    .line 107
    .end local v0    # "count":Ljava/lang/String;
    :cond_0
    const/4 v1, 0x0

    iput v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mNewFollowsCount:I

    .line 108
    return-void

    .line 104
    :cond_1
    iget v1, p0, Lco/vine/android/FindFriendsAddressFragment;->mNewFollowsCount:I

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onResume()V
    .locals 5

    .prologue
    .line 49
    invoke-super {p0}, Lco/vine/android/FindFriendsBaseFragment;->onResume()V

    .line 50
    iget-boolean v3, p0, Lco/vine/android/FindFriendsAddressFragment;->mFetched:Z

    if-nez v3, :cond_0

    .line 51
    invoke-virtual {p0}, Lco/vine/android/FindFriendsAddressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    .line 52
    .local v1, "am":Landroid/accounts/AccountManager;
    invoke-virtual {p0}, Lco/vine/android/FindFriendsAddressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lco/vine/android/FindFriendsAddressFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 54
    .local v0, "account":Landroid/accounts/Account;
    invoke-static {v1, v0}, Lco/vine/android/client/VineAccountHelper;->shouldShowStoreContactsPrompt(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 55
    const/4 v3, 0x1

    invoke-static {v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    .line 57
    .local v2, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    invoke-virtual {v2, p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setListener(Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;)V

    .line 58
    const v3, 0x7f0e0234

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 59
    const v3, 0x7f0e0233

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 60
    const v3, 0x7f0e014d

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 61
    const v3, 0x7f0e0163

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 62
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setCancelable(Z)V

    .line 63
    invoke-virtual {p0}, Lco/vine/android/FindFriendsAddressFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    .line 68
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v1    # "am":Landroid/accounts/AccountManager;
    .end local v2    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_0
    :goto_0
    return-void

    .line 65
    .restart local v0    # "account":Landroid/accounts/Account;
    .restart local v1    # "am":Landroid/accounts/AccountManager;
    :cond_1
    const/4 v3, 0x3

    invoke-virtual {p0, v3}, Lco/vine/android/FindFriendsAddressFragment;->fetchContent(I)V

    goto :goto_0
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 116
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 38
    invoke-super {p0, p1, p2}, Lco/vine/android/FindFriendsBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 39
    invoke-virtual {p0}, Lco/vine/android/FindFriendsAddressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 40
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v2, 0x7f03004f

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 41
    .local v1, "title":Landroid/view/View;
    iget-object v2, p0, Lco/vine/android/FindFriendsAddressFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2, v1}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 43
    const v2, 0x7f0a0110

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    const v3, 0x7f0e00e2

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    .line 45
    return-void
.end method

.method protected startProfileActivity(J)V
    .locals 3
    .param p1, "userId"    # J

    .prologue
    .line 111
    invoke-virtual {p0}, Lco/vine/android/FindFriendsAddressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "Find Friends: Address"

    const/4 v2, 0x1

    invoke-static {v0, p1, p2, v1, v2}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;Z)V

    .line 112
    return-void
.end method
