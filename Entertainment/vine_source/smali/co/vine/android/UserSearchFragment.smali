.class public Lco/vine/android/UserSearchFragment;
.super Lco/vine/android/BaseSearchFragment;
.source "UserSearchFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/UserSearchFragment$UserSearchSessionListener;
    }
.end annotation


# static fields
.field private static final EVENT_SOURCE_TITLE:Ljava/lang/String; = "User Search Results"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lco/vine/android/BaseSearchFragment;-><init>()V

    .line 132
    return-void
.end method


# virtual methods
.method public cleanSearchResults()V
    .locals 2

    .prologue
    .line 124
    iget-object v0, p0, Lco/vine/android/UserSearchFragment;->mExecutor:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lco/vine/android/UserSearchFragment$1;

    invoke-direct {v1, p0}, Lco/vine/android/UserSearchFragment$1;-><init>(Lco/vine/android/UserSearchFragment;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 130
    return-void
.end method

.method protected fetchContent(I)V
    .locals 4
    .param p1, "fetchType"    # I

    .prologue
    .line 89
    invoke-virtual {p0, p1}, Lco/vine/android/UserSearchFragment;->hasPendingRequest(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 120
    :cond_0
    :goto_0
    return-void

    .line 94
    :cond_1
    packed-switch p1, :pswitch_data_0

    .line 109
    const/4 v0, 0x1

    .line 114
    .local v0, "pageType":I
    :goto_1
    iget-object v2, p0, Lco/vine/android/UserSearchFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/UserSearchFragment;->mEncodedQueryString:Ljava/lang/String;

    invoke-virtual {v2, v3, v0}, Lco/vine/android/client/AppController;->searchUsers(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v1

    .line 116
    .local v1, "reqId":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 117
    invoke-virtual {p0, p1}, Lco/vine/android/UserSearchFragment;->showProgress(I)V

    .line 118
    invoke-virtual {p0, v1, p1}, Lco/vine/android/UserSearchFragment;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    goto :goto_0

    .line 96
    .end local v0    # "pageType":I
    .end local v1    # "reqId":Ljava/lang/String;
    :pswitch_0
    const/4 v0, 0x1

    .line 97
    .restart local v0    # "pageType":I
    goto :goto_1

    .line 101
    .end local v0    # "pageType":I
    :pswitch_1
    const/4 v0, 0x2

    .line 102
    .restart local v0    # "pageType":I
    goto :goto_1

    .line 105
    .end local v0    # "pageType":I
    :pswitch_2
    const/4 v0, 0x3

    .line 106
    .restart local v0    # "pageType":I
    goto :goto_1

    .line 94
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public getMinimumSearchQueryLength()I
    .locals 1

    .prologue
    .line 45
    const/4 v0, 0x2

    return v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x0

    const/4 v3, 0x0

    .line 32
    invoke-super {p0, p1}, Lco/vine/android/BaseSearchFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 33
    iget-object v0, p0, Lco/vine/android/UserSearchFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-nez v0, :cond_0

    .line 34
    sget-object v0, Lco/vine/android/provider/VineDatabaseSQL$UsersQuery;->PROJECTION:[Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/UserSearchFragment;->mProjection:[Ljava/lang/String;

    .line 35
    const-string v0, "_id ASC"

    iput-object v0, p0, Lco/vine/android/UserSearchFragment;->mSortOrder:Ljava/lang/String;

    .line 36
    new-instance v0, Lco/vine/android/UsersAdapter;

    invoke-virtual {p0}, Lco/vine/android/UserSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/UserSearchFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object v4, p0

    move v6, v3

    invoke-direct/range {v0 .. v6}, Lco/vine/android/UsersAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;ZLandroid/view/View$OnClickListener;Lco/vine/android/Friendships;I)V

    iput-object v0, p0, Lco/vine/android/UserSearchFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 38
    :cond_0
    iget-object v0, p0, Lco/vine/android/UserSearchFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/UserSearchFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 39
    iget-object v0, p0, Lco/vine/android/UserSearchFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, v3}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 40
    new-instance v0, Lco/vine/android/UserSearchFragment$UserSearchSessionListener;

    invoke-direct {v0, p0, v5}, Lco/vine/android/UserSearchFragment$UserSearchSessionListener;-><init>(Lco/vine/android/UserSearchFragment;Lco/vine/android/UserSearchFragment$1;)V

    iput-object v0, p0, Lco/vine/android/UserSearchFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 41
    return-void
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

    .line 50
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/UserSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_USER_SEARCH_RESULTS:Landroid/net/Uri;

    iget-object v3, p0, Lco/vine/android/UserSearchFragment;->mProjection:[Ljava/lang/String;

    iget-object v6, p0, Lco/vine/android/UserSearchFragment;->mSortOrder:Ljava/lang/String;

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method protected onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .locals 2
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    .line 70
    const-wide/16 v0, 0x0

    cmp-long v0, p4, v0

    if-lez v0, :cond_0

    .line 71
    invoke-virtual {p0}, Lco/vine/android/UserSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "User Search Results"

    invoke-static {v0, p4, p5, v1}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    .line 73
    :cond_0
    return-void
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 1
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
    .line 56
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseSearchFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    .line 57
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lco/vine/android/UserSearchFragment;->hideProgress(I)V

    .line 58
    return-void
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 26
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/UserSearchFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method protected onScrollLastItem(Landroid/database/Cursor;)V
    .locals 2
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 62
    const/16 v0, 0x11

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-nez v0, :cond_0

    invoke-interface {p1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    const/16 v1, 0x190

    if-gt v0, v1, :cond_0

    .line 64
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/UserSearchFragment;->fetchContent(I)V

    .line 66
    :cond_0
    return-void
.end method

.method public performSearch()V
    .locals 1

    .prologue
    .line 77
    invoke-virtual {p0}, Lco/vine/android/UserSearchFragment;->hideSearchHint()V

    .line 78
    invoke-virtual {p0}, Lco/vine/android/UserSearchFragment;->cleanSearchResults()V

    .line 79
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lco/vine/android/UserSearchFragment;->fetchContent(I)V

    .line 80
    return-void
.end method
