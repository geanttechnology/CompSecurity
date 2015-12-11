.class public abstract Lco/vine/android/FindFriendsBaseFragment;
.super Lco/vine/android/BaseCursorListFragment;
.source "FindFriendsBaseFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/AdapterView$OnItemClickListener;
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;
.implements Lco/vine/android/FindFriendsNUXActivity$FilterableFriendsList;


# static fields
.field protected static final DIALOG_STORE_CONTACTS:I = 0x1

.field protected static final EVENT_SOURCE_TITLE:Ljava/lang/String; = "Find Friends: Address"

.field protected static final LOADER_ID_FILTER:I = 0x1

.field protected static final STATE_FETCHED:Ljava/lang/String; = "fetch"

.field protected static final STATE_FRIENDSHIPS:Ljava/lang/String; = "friendships"


# instance fields
.field protected mActivity:Lco/vine/android/FindFriendsBaseActivity;

.field protected mBold:[Landroid/text/style/StyleSpan;

.field protected mFetched:Z

.field protected mFriendships:Lco/vine/android/Friendships;

.field protected mNewFollowsCount:I

.field protected mProjection:[Ljava/lang/String;

.field protected volatile mSearchQuery:Ljava/lang/String;

.field protected mSortOrder:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Lco/vine/android/BaseCursorListFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected fetchContent(I)V
    .locals 3
    .param p1, "fetchType"    # I

    .prologue
    .line 132
    const/4 v1, 0x1

    iput-boolean v1, p0, Lco/vine/android/FindFriendsBaseFragment;->mFetched:Z

    .line 133
    invoke-virtual {p0, p1}, Lco/vine/android/FindFriendsBaseFragment;->showProgress(I)V

    .line 135
    packed-switch p1, :pswitch_data_0

    .line 150
    :goto_0
    return-void

    .line 137
    :pswitch_0
    new-instance v0, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lco/vine/android/FindFriendsBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f0f0037

    invoke-direct {v0, v1, v2}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 139
    .local v0, "d":Landroid/app/ProgressDialog;
    const v1, 0x7f0e00f4

    invoke-virtual {p0, v1}, Lco/vine/android/FindFriendsBaseFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 140
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 141
    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 142
    iput-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 143
    iget-object v1, p0, Lco/vine/android/FindFriendsBaseFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/FindFriendsBaseFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/client/AppController;->fetchAddressFriends(Lco/vine/android/client/Session;)Ljava/lang/String;

    goto :goto_0

    .line 135
    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 94
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 95
    iget-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-nez v0, :cond_0

    .line 96
    sget-object v0, Lco/vine/android/provider/VineDatabaseSQL$UsersQuery;->PROJECTION:[Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mProjection:[Ljava/lang/String;

    .line 97
    const-string v0, "username ASC"

    iput-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mSortOrder:Ljava/lang/String;

    .line 98
    new-instance v0, Lco/vine/android/UsersAdapter;

    invoke-virtual {p0}, Lco/vine/android/FindFriendsBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/FindFriendsBaseFragment;->mAppController:Lco/vine/android/client/AppController;

    const/4 v3, 0x1

    iget-object v5, p0, Lco/vine/android/FindFriendsBaseFragment;->mFriendships:Lco/vine/android/Friendships;

    const/4 v6, 0x0

    move-object v4, p0

    invoke-direct/range {v0 .. v6}, Lco/vine/android/UsersAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;ZLandroid/view/View$OnClickListener;Lco/vine/android/Friendships;I)V

    iput-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 101
    :cond_0
    iget-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/FindFriendsBaseFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 102
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 58
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onAttach(Landroid/app/Activity;)V

    .line 59
    check-cast p1, Lco/vine/android/FindFriendsBaseActivity;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lco/vine/android/FindFriendsBaseFragment;->mActivity:Lco/vine/android/FindFriendsBaseActivity;

    .line 60
    return-void
.end method

.method public abstract onClick(Landroid/view/View;)V
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x1

    .line 64
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 66
    new-array v0, v3, [Landroid/text/style/StyleSpan;

    const/4 v1, 0x0

    new-instance v2, Landroid/text/style/StyleSpan;

    invoke-direct {v2, v3}, Landroid/text/style/StyleSpan;-><init>(I)V

    aput-object v2, v0, v1

    iput-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mBold:[Landroid/text/style/StyleSpan;

    .line 68
    if-eqz p1, :cond_2

    .line 69
    const-string v0, "fetch"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 70
    const-string v0, "fetch"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mFetched:Z

    .line 72
    :cond_0
    const-string v0, "friendships"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 73
    const-string v0, "friendships"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lco/vine/android/Friendships;

    iput-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mFriendships:Lco/vine/android/Friendships;

    .line 80
    :cond_1
    :goto_0
    iget-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/FindFriendsBaseFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    const/4 v2, 0x7

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->removeUsers(Lco/vine/android/client/Session;I)Ljava/lang/String;

    .line 82
    return-void

    .line 76
    :cond_2
    new-instance v0, Lco/vine/android/Friendships;

    invoke-direct {v0}, Lco/vine/android/Friendships;-><init>()V

    iput-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mFriendships:Lco/vine/android/Friendships;

    goto :goto_0
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 7
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 113
    packed-switch p1, :pswitch_data_0

    .line 124
    sget-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FIND_FRIENDS_ADDRESS:Landroid/net/Uri;

    iget-object v1, p0, Lco/vine/android/FindFriendsBaseFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v5

    invoke-static {v0, v5, v6}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v2

    .line 126
    .local v2, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/FindFriendsBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v3, p0, Lco/vine/android/FindFriendsBaseFragment;->mProjection:[Ljava/lang/String;

    iget-object v6, p0, Lco/vine/android/FindFriendsBaseFragment;->mSortOrder:Ljava/lang/String;

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .end local v2    # "uri":Landroid/net/Uri;
    :goto_0
    return-object v0

    .line 115
    :pswitch_0
    sget-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FRIENDS_FILTER:Landroid/net/Uri;

    iget-object v1, p0, Lco/vine/android/FindFriendsBaseFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v5

    invoke-static {v0, v5, v6}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v2

    .line 117
    .local v2, "uri":Landroid/net/Uri$Builder;
    const-string v0, "filter"

    iget-object v1, p0, Lco/vine/android/FindFriendsBaseFragment;->mSearchQuery:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v0, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 118
    const-string v0, "group_type"

    const/4 v1, 0x7

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v0, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 120
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/FindFriendsBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v2}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .end local v2    # "uri":Landroid/net/Uri$Builder;
    iget-object v3, p0, Lco/vine/android/FindFriendsBaseFragment;->mProjection:[Ljava/lang/String;

    iget-object v6, p0, Lco/vine/android/FindFriendsBaseFragment;->mSortOrder:Ljava/lang/String;

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 113
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 87
    const v1, 0x7f03003d

    invoke-virtual {p0, p1, v1, p2}, Lco/vine/android/FindFriendsBaseFragment;->createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 88
    .local v0, "view":Landroid/view/View;
    iget-object v1, p0, Lco/vine/android/FindFriendsBaseFragment;->mListView:Landroid/widget/ListView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 89
    return-object v0
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 6
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 157
    invoke-virtual {p0}, Lco/vine/android/FindFriendsBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    .line 158
    .local v1, "am":Landroid/accounts/AccountManager;
    invoke-virtual {p0}, Lco/vine/android/FindFriendsBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/FindFriendsBaseFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    invoke-virtual {v5}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 160
    .local v0, "account":Landroid/accounts/Account;
    invoke-static {v1, v0}, Lco/vine/android/client/VineAccountHelper;->setDidShowStoreContactsPrompt(Landroid/accounts/AccountManager;Landroid/accounts/Account;)V

    .line 162
    packed-switch p2, :pswitch_data_0

    .line 175
    :goto_0
    return-void

    .line 164
    :pswitch_0
    const/4 v4, -0x1

    if-ne p3, v4, :cond_0

    const/4 v3, 0x1

    .line 165
    .local v3, "enable":Z
    :goto_1
    iget-object v4, p0, Lco/vine/android/FindFriendsBaseFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4, v3}, Lco/vine/android/client/AppController;->updateEnableAddressBook(Z)Ljava/lang/String;

    .line 166
    invoke-virtual {p0}, Lco/vine/android/FindFriendsBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v4

    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 167
    .local v2, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v4, "enable_address_book"

    invoke-interface {v2, v4, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 168
    const/4 v4, 0x3

    invoke-virtual {p0, v4}, Lco/vine/android/FindFriendsBaseFragment;->fetchContent(I)V

    goto :goto_0

    .line 164
    .end local v2    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v3    # "enable":Z
    :cond_0
    const/4 v3, 0x0

    goto :goto_1

    .line 162
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .param p2, "view"    # Landroid/view/View;
    .param p3, "i"    # I
    .param p4, "l"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 179
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Lco/vine/android/widget/UserViewHolder;

    if-eqz v1, :cond_0

    .line 180
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/UserViewHolder;

    .line 181
    .local v0, "h":Lco/vine/android/widget/UserViewHolder;
    iget-wide v1, v0, Lco/vine/android/widget/UserViewHolder;->userId:J

    invoke-virtual {p0, v1, v2}, Lco/vine/android/FindFriendsBaseFragment;->startProfileActivity(J)V

    .line 183
    .end local v0    # "h":Lco/vine/android/widget/UserViewHolder;
    :cond_0
    return-void
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 2
    .param p2, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 196
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseCursorListFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    .line 197
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mActivity:Lco/vine/android/FindFriendsBaseActivity;

    instance-of v0, v0, Lco/vine/android/FindFriendsNUXActivity;

    if-eqz v0, :cond_0

    .line 198
    iget-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mActivity:Lco/vine/android/FindFriendsBaseActivity;

    check-cast v0, Lco/vine/android/FindFriendsNUXActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/FindFriendsNUXActivity;->showSearchIcon(Z)V

    .line 200
    :cond_0
    return-void
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 34
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/FindFriendsBaseFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/support/v4/content/Loader;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 204
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    iget-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/CursorAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 205
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 106
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 107
    const-string v0, "fetch"

    iget-boolean v1, p0, Lco/vine/android/FindFriendsBaseFragment;->mFetched:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 108
    const-string v0, "friendships"

    iget-object v1, p0, Lco/vine/android/FindFriendsBaseFragment;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 109
    return-void
.end method

.method public abstract onTextChanged(Ljava/lang/CharSequence;III)V
.end method

.method public shouldShowSearchIcon()Z
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/FindFriendsBaseFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0}, Landroid/support/v4/widget/CursorAdapter;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected abstract startProfileActivity(J)V
.end method
