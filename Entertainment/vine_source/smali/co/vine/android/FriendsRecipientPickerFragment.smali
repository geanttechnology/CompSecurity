.class public Lco/vine/android/FriendsRecipientPickerFragment;
.super Lco/vine/android/BaseRecipientPickerFragment;
.source "FriendsRecipientPickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/FriendsRecipientPickerFragment$FilterRunnable;
    }
.end annotation


# static fields
.field private static final LOADER_ID_FILTER_FRIENDS:I = 0x1


# instance fields
.field private mAnchorManager:Lco/vine/android/util/StringAnchorManager;

.field private mCallback:Lco/vine/android/RecipientPickerActivity;

.field private mFindFriendsCta:Landroid/widget/Button;

.field private mFriendsPickerAdapter:Lco/vine/android/FriendsPickerAdapter;

.field private mIsFetched:Z

.field private mIsFiltering:Z

.field private mIsLoaderReady:Z

.field private mLastFiredQuery:Ljava/lang/String;

.field private mRefreshingTime:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Lco/vine/android/BaseRecipientPickerFragment;-><init>()V

    .line 280
    return-void
.end method

.method static synthetic access$002(Lco/vine/android/FriendsRecipientPickerFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/FriendsRecipientPickerFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mLastFiredQuery:Ljava/lang/String;

    return-object p1
.end method

.method private fetchContent(I)V
    .locals 4
    .param p1, "fetchType"    # I

    .prologue
    .line 200
    invoke-virtual {p0, p1}, Lco/vine/android/FriendsRecipientPickerFragment;->hasPendingRequest(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 231
    :cond_0
    :goto_0
    return-void

    .line 204
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Fetching content: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 206
    packed-switch p1, :pswitch_data_0

    .line 221
    const/4 v0, 0x1

    .line 226
    .local v0, "pageType":I
    :goto_1
    iget-object v2, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mAppController:Lco/vine/android/client/AppController;

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3}, Lco/vine/android/client/AppController;->fetchFriends(II)Ljava/lang/String;

    move-result-object v1

    .line 227
    .local v1, "reqId":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 228
    invoke-virtual {p0, p1}, Lco/vine/android/FriendsRecipientPickerFragment;->showProgress(I)V

    .line 229
    invoke-virtual {p0, v1, p1}, Lco/vine/android/FriendsRecipientPickerFragment;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    goto :goto_0

    .line 208
    .end local v0    # "pageType":I
    .end local v1    # "reqId":Ljava/lang/String;
    :pswitch_0
    const/4 v0, 0x1

    .line 209
    .restart local v0    # "pageType":I
    goto :goto_1

    .line 213
    .end local v0    # "pageType":I
    :pswitch_1
    const/4 v0, 0x1

    .line 214
    .restart local v0    # "pageType":I
    goto :goto_1

    .line 217
    .end local v0    # "pageType":I
    :pswitch_2
    const/4 v0, 0x3

    .line 218
    .restart local v0    # "pageType":I
    goto :goto_1

    .line 206
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private showFindFriendsCta(Z)V
    .locals 2
    .param p1, "show"    # Z

    .prologue
    .line 184
    iget-object v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mFindFriendsCta:Landroid/widget/Button;

    if-eqz p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/Button;->setVisibility(I)V

    .line 185
    return-void

    .line 184
    :cond_0
    const/16 v0, 0x8

    goto :goto_0
.end method


# virtual methods
.method protected handleFocus()V
    .locals 2

    .prologue
    const/4 v1, 0x3

    .line 129
    iget-boolean v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mIsFetched:Z

    if-nez v0, :cond_0

    .line 130
    invoke-virtual {p0, v1}, Lco/vine/android/FriendsRecipientPickerFragment;->showProgress(I)V

    .line 131
    invoke-direct {p0, v1}, Lco/vine/android/FriendsRecipientPickerFragment;->fetchContent(I)V

    .line 133
    :cond_0
    invoke-virtual {p0, v1}, Lco/vine/android/FriendsRecipientPickerFragment;->hideProgress(I)V

    .line 134
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 66
    invoke-super {p0, p1}, Lco/vine/android/BaseRecipientPickerFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 67
    invoke-virtual {p0}, Lco/vine/android/FriendsRecipientPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, v3}, Lco/vine/android/provider/Vine;->getUserSectionsAnchorManager(Landroid/content/Context;I)Lco/vine/android/util/StringAnchorManager;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mAnchorManager:Lco/vine/android/util/StringAnchorManager;

    .line 69
    sget-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FRIENDS:Landroid/net/Uri;

    iget-object v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v1

    invoke-static {v0, v1, v2}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mContentUri:Landroid/net/Uri;

    .line 71
    sget-object v0, Lco/vine/android/provider/VineDatabaseSQL$UsersQuery;->PROJECTION:[Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mProjection:[Ljava/lang/String;

    .line 73
    invoke-virtual {p0}, Lco/vine/android/FriendsRecipientPickerFragment;->refreshSelections()V

    .line 74
    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0}, Lcom/twitter/android/widget/RefreshableListView;->disablePTR()V

    .line 76
    const-string v0, "last_section_refresh DESC, section_index ASC"

    iput-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mSortOrder:Ljava/lang/String;

    .line 78
    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-nez v0, :cond_0

    .line 79
    new-instance v0, Lco/vine/android/FriendsPickerAdapter;

    invoke-virtual {p0}, Lco/vine/android/FriendsRecipientPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {v0, v1, v2, v3, p0}, Lco/vine/android/FriendsPickerAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;ILco/vine/android/FriendsRecipientPickerFragment;)V

    iput-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mFriendsPickerAdapter:Lco/vine/android/FriendsPickerAdapter;

    .line 80
    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mFriendsPickerAdapter:Lco/vine/android/FriendsPickerAdapter;

    iput-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 82
    :cond_0
    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 83
    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, v3}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 84
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 55
    invoke-super {p0, p1}, Lco/vine/android/BaseRecipientPickerFragment;->onAttach(Landroid/app/Activity;)V

    .line 56
    check-cast p1, Lco/vine/android/RecipientPickerActivity;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mCallback:Lco/vine/android/RecipientPickerActivity;

    .line 57
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 104
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 111
    :goto_0
    return-void

    .line 106
    :pswitch_0
    const-string v0, "VM Share"

    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackVisitFindFriends(Ljava/lang/String;)V

    .line 107
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/FriendsRecipientPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lco/vine/android/FindFriendsActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lco/vine/android/FriendsRecipientPickerFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 104
    :pswitch_data_0
    .packed-switch 0x7f0a0145
        :pswitch_0
    .end packed-switch
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 8
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

    .line 143
    packed-switch p1, :pswitch_data_0

    .line 154
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseRecipientPickerFragment;->onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;

    move-result-object v0

    :goto_0
    return-object v0

    .line 145
    :pswitch_0
    sget-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FRIENDS_FILTER:Landroid/net/Uri;

    iget-object v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v1

    invoke-static {v0, v1, v2}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v7

    .line 147
    .local v7, "contentUri":Landroid/net/Uri$Builder;
    const-string v0, "filter"

    iget-object v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mQueryString:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 148
    const-string v0, "group_type"

    const/16 v1, 0xa

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 150
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/FriendsRecipientPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v7}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mProjection:[Ljava/lang/String;

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 143
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 61
    const v0, 0x7f03007c

    invoke-virtual {p0, p1, v0, p2}, Lco/vine/android/FriendsRecipientPickerFragment;->createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method protected onGetFriendsComplete(I)V
    .locals 7
    .param p1, "errorCode"    # I

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 235
    iput-boolean v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mIsFetched:Z

    .line 236
    iget-wide v3, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mRefreshingTime:J

    iget-object v5, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mAnchorManager:Lco/vine/android/util/StringAnchorManager;

    invoke-virtual {v5}, Lco/vine/android/util/StringAnchorManager;->getRefreshTime()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-eqz v3, :cond_1

    move v0, v1

    .line 237
    .local v0, "hasThingsChanged":Z
    :goto_0
    const-string v3, "Has refresh time changed? {}"

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 238
    invoke-virtual {p0, v1}, Lco/vine/android/FriendsRecipientPickerFragment;->hideProgress(I)V

    .line 239
    if-eqz v0, :cond_2

    .line 240
    invoke-virtual {p0}, Lco/vine/android/FriendsRecipientPickerFragment;->refreshSelections()V

    .line 241
    iput-boolean v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mIsLoaderReady:Z

    .line 242
    invoke-virtual {p0, v2}, Lco/vine/android/FriendsRecipientPickerFragment;->initLoader(I)V

    .line 249
    :cond_0
    :goto_1
    return-void

    .end local v0    # "hasThingsChanged":Z
    :cond_1
    move v0, v2

    .line 236
    goto :goto_0

    .line 244
    .restart local v0    # "hasThingsChanged":Z
    :cond_2
    iget-boolean v3, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mIsLoaderReady:Z

    if-nez v3, :cond_0

    .line 245
    iput-boolean v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mIsLoaderReady:Z

    .line 246
    invoke-virtual {p0, v2}, Lco/vine/android/FriendsRecipientPickerFragment;->initLoader(I)V

    goto :goto_1
.end method

.method public onGetFriendsTypeAheadComplete(Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 4
    .param p1, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 253
    if-eqz p2, :cond_0

    iget-object v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mLastFiredQuery:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 254
    new-instance v1, Lco/vine/android/provider/FriendsPickerExclusiveCursor;

    invoke-direct {v1, p2}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;-><init>(Ljava/util/ArrayList;)V

    invoke-virtual {p0, v3, v1}, Lco/vine/android/FriendsRecipientPickerFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    .line 263
    :goto_0
    iput-object v3, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mLastFiredQuery:Ljava/lang/String;

    .line 264
    return-void

    .line 256
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/FriendsRecipientPickerFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/support/v4/app/LoaderManager;->getLoader(I)Landroid/support/v4/content/Loader;

    move-result-object v0

    .line 257
    .local v0, "friendsLoader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/support/v4/content/Loader;->isStarted()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 258
    invoke-virtual {p0, v2}, Lco/vine/android/FriendsRecipientPickerFragment;->restartLoader(I)Z

    goto :goto_0

    .line 260
    :cond_1
    invoke-virtual {p0, v2}, Lco/vine/android/FriendsRecipientPickerFragment;->initLoader(I)V

    goto :goto_0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
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
    .line 189
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/FriendsPickerViewHolder;

    .line 190
    .local v0, "holder":Lco/vine/android/FriendsPickerViewHolder;
    iget-object v1, v0, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {p0, v1}, Lco/vine/android/FriendsRecipientPickerFragment;->isRecipientSelected(Lco/vine/android/api/VineRecipient;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 191
    iget-object v1, v0, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {p0, v1}, Lco/vine/android/FriendsRecipientPickerFragment;->removeRecipient(Lco/vine/android/api/VineRecipient;)V

    .line 192
    invoke-virtual {p0}, Lco/vine/android/FriendsRecipientPickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lco/vine/android/FriendsPickerViewHolder;->setSelected(Landroid/content/res/Resources;Z)V

    .line 197
    :goto_0
    return-void

    .line 194
    :cond_0
    iget-object v1, v0, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {p0, v1}, Lco/vine/android/FriendsRecipientPickerFragment;->addRecipient(Lco/vine/android/api/VineRecipient;)V

    .line 195
    invoke-virtual {p0}, Lco/vine/android/FriendsRecipientPickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/FriendsPickerViewHolder;->setSelected(Landroid/content/res/Resources;Z)V

    goto :goto_0
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 5
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
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    const/4 v3, 0x1

    .line 161
    iget-boolean v2, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mIsFiltering:Z

    if-eqz v2, :cond_0

    if-nez p1, :cond_4

    :cond_0
    iget-boolean v2, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mIsFiltering:Z

    if-nez v2, :cond_1

    if-eqz p1, :cond_4

    .line 162
    :cond_1
    instance-of v2, p2, Lco/vine/android/provider/FriendsPickerExclusiveCursor;

    if-nez v2, :cond_2

    .line 163
    new-instance v1, Lco/vine/android/provider/FriendsPickerExclusiveCursor;

    invoke-direct {v1, p2}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;-><init>(Landroid/database/Cursor;)V

    .end local p2    # "cursor":Landroid/database/Cursor;
    .local v1, "cursor":Landroid/database/Cursor;
    move-object p2, v1

    .end local v1    # "cursor":Landroid/database/Cursor;
    .restart local p2    # "cursor":Landroid/database/Cursor;
    :cond_2
    move-object v2, p2

    .line 165
    check-cast v2, Lco/vine/android/provider/FriendsPickerExclusiveCursor;

    invoke-virtual {v2}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->prepare()V

    .line 166
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    .line 168
    .local v0, "count":I
    if-ge v0, v3, :cond_5

    move v2, v3

    :goto_0
    invoke-virtual {p0, v2}, Lco/vine/android/FriendsRecipientPickerFragment;->showSadface(Z)V

    .line 169
    const/16 v2, 0xa

    if-ge v0, v2, :cond_3

    .line 170
    iget-object v2, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mCallback:Lco/vine/android/RecipientPickerActivity;

    const-string v4, "address_book"

    invoke-virtual {v2, v4}, Lco/vine/android/RecipientPickerActivity;->showPage(Ljava/lang/String;)V

    .line 171
    invoke-direct {p0, v3}, Lco/vine/android/FriendsRecipientPickerFragment;->showFindFriendsCta(Z)V

    .line 173
    :cond_3
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseRecipientPickerFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    .line 175
    .end local v0    # "count":I
    :cond_4
    return-void

    .line 168
    .restart local v0    # "count":I
    :cond_5
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 39
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/FriendsRecipientPickerFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onRecipientItemRemoved(Lco/vine/android/api/VineRecipient;)V
    .locals 1
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 138
    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mFriendsPickerAdapter:Lco/vine/android/FriendsPickerAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/FriendsPickerAdapter;->onRecipientItemRemoved(Lco/vine/android/api/VineRecipient;)V

    .line 139
    return-void
.end method

.method protected onScrollLastItem(Landroid/database/Cursor;)V
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 115
    iget-boolean v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mIsFiltering:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mAnchorManager:Lco/vine/android/util/StringAnchorManager;

    invoke-virtual {v0}, Lco/vine/android/util/StringAnchorManager;->haveMore()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 116
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/FriendsRecipientPickerFragment;->fetchContent(I)V

    .line 117
    const/4 v0, 0x7

    invoke-virtual {p0, v0}, Lco/vine/android/FriendsRecipientPickerFragment;->showProgress(I)V

    .line 119
    :cond_0
    return-void
.end method

.method protected onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 5
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    const/4 v2, 0x0

    .line 269
    invoke-super {p0, p1, p2, p3, p4}, Lco/vine/android/BaseRecipientPickerFragment;->onTextChanged(Ljava/lang/CharSequence;III)V

    .line 270
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 271
    .local v0, "query":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 272
    const/4 v1, 0x1

    iput-boolean v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mIsFiltering:Z

    .line 273
    iget-object v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mHandler:Landroid/os/Handler;

    new-instance v2, Lco/vine/android/FriendsRecipientPickerFragment$FilterRunnable;

    invoke-direct {v2, p0, v0}, Lco/vine/android/FriendsRecipientPickerFragment$FilterRunnable;-><init>(Lco/vine/android/FriendsRecipientPickerFragment;Ljava/lang/String;)V

    const-wide/16 v3, 0x96

    invoke-virtual {v1, v2, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 278
    :goto_0
    return-void

    .line 275
    :cond_0
    iput-boolean v2, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mIsFiltering:Z

    .line 276
    invoke-virtual {p0, v2}, Lco/vine/android/FriendsRecipientPickerFragment;->restartLoader(I)Z

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 88
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseRecipientPickerFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 89
    const v0, 0x7f0a0145

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mFindFriendsCta:Landroid/widget/Button;

    .line 90
    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mFindFriendsCta:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mFindFriendsCta:Landroid/widget/Button;

    invoke-virtual {v0}, Landroid/widget/Button;->bringToFront()V

    .line 92
    return-void
.end method

.method public refresh()V
    .locals 1

    .prologue
    .line 123
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lco/vine/android/FriendsRecipientPickerFragment;->showProgress(I)V

    .line 124
    invoke-virtual {p0}, Lco/vine/android/FriendsRecipientPickerFragment;->handleFocus()V

    .line 125
    return-void
.end method

.method public refreshSelections()V
    .locals 4

    .prologue
    .line 95
    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mAnchorManager:Lco/vine/android/util/StringAnchorManager;

    invoke-virtual {v0}, Lco/vine/android/util/StringAnchorManager;->getRefreshTime()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mRefreshingTime:J

    .line 96
    const-string v0, "Refreshing time: {}."

    iget-wide v1, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mRefreshingTime:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 97
    const-string v0, "section_type=0 AND last_section_refresh=?"

    iput-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mSelection:Ljava/lang/String;

    .line 99
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    iget-wide v2, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mRefreshingTime:J

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    iput-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment;->mSelArgs:[Ljava/lang/String;

    .line 100
    return-void
.end method

.method protected showSadface(Z)V
    .locals 0
    .param p1, "show"    # Z

    .prologue
    .line 179
    invoke-super {p0, p1, p1}, Lco/vine/android/BaseRecipientPickerFragment;->showSadface(ZZ)V

    .line 180
    invoke-direct {p0, p1}, Lco/vine/android/FriendsRecipientPickerFragment;->showFindFriendsCta(Z)V

    .line 181
    return-void
.end method
