.class public Lco/vine/android/ChannelsListFragment;
.super Lco/vine/android/BaseCursorListFragment;
.source "ChannelsListFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ChannelsListFragment$ChannelViewHolder;,
        Lco/vine/android/ChannelsListFragment$ChannelsAdapter;,
        Lco/vine/android/ChannelsListFragment$ChannelsListSessionListener;
    }
.end annotation


# static fields
.field public static final ARG_SELECTED_CHANNEL:Ljava/lang/String; = "selected_channel"


# instance fields
.field private mCallback:Lco/vine/android/ChannelsListActivity;

.field private mDbHelper:Lco/vine/android/provider/VineDatabaseHelper;

.field private mFetched:Z

.field private mSelectedChannel:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Lco/vine/android/BaseCursorListFragment;-><init>()V

    .line 243
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/ChannelsListFragment;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/ChannelsListFragment;

    .prologue
    .line 44
    iget-wide v0, p0, Lco/vine/android/ChannelsListFragment;->mSelectedChannel:J

    return-wide v0
.end method

.method private fetchContent(I)V
    .locals 2
    .param p1, "fetchType"    # I

    .prologue
    .line 120
    invoke-virtual {p0, p1}, Lco/vine/android/ChannelsListFragment;->hasPendingRequest(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 142
    :goto_0
    return-void

    .line 125
    :cond_0
    packed-switch p1, :pswitch_data_0

    .line 136
    const/4 v0, 0x1

    .line 140
    .local v0, "pageType":I
    :goto_1
    iget-object v1, p0, Lco/vine/android/ChannelsListFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1, v0}, Lco/vine/android/client/AppController;->fetchChannels(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, p1}, Lco/vine/android/ChannelsListFragment;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    .line 141
    const/4 v1, 0x1

    iput-boolean v1, p0, Lco/vine/android/ChannelsListFragment;->mFetched:Z

    goto :goto_0

    .line 127
    .end local v0    # "pageType":I
    :pswitch_0
    const/4 v0, 0x2

    .line 128
    .restart local v0    # "pageType":I
    goto :goto_1

    .line 131
    .end local v0    # "pageType":I
    :pswitch_1
    const/4 v0, 0x3

    .line 132
    .restart local v0    # "pageType":I
    goto :goto_1

    .line 125
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 71
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 73
    iget-object v1, p0, Lco/vine/android/ChannelsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-nez v1, :cond_0

    .line 74
    new-instance v1, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;

    invoke-virtual {p0}, Lco/vine/android/ChannelsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/ChannelsListFragment;->mAppController:Lco/vine/android/client/AppController;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;-><init>(Lco/vine/android/ChannelsListFragment;Landroid/content/Context;Lco/vine/android/client/AppController;I)V

    iput-object v1, p0, Lco/vine/android/ChannelsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 77
    :cond_0
    iget-object v0, p0, Lco/vine/android/ChannelsListFragment;->mListView:Landroid/widget/ListView;

    .line 78
    .local v0, "listview":Landroid/widget/ListView;
    invoke-virtual {p0}, Lco/vine/android/ChannelsListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090026

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setBackgroundColor(I)V

    .line 79
    iget-object v1, p0, Lco/vine/android/ChannelsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 80
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 55
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 56
    check-cast v0, Lco/vine/android/ChannelsListActivity;

    iput-object v0, p0, Lco/vine/android/ChannelsListFragment;->mCallback:Lco/vine/android/ChannelsListActivity;

    .line 57
    invoke-static {p1}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/ChannelsListFragment;->mDbHelper:Lco/vine/android/provider/VineDatabaseHelper;

    .line 58
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 157
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 62
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 63
    new-instance v1, Lco/vine/android/ChannelsListFragment$ChannelsListSessionListener;

    invoke-direct {v1, p0}, Lco/vine/android/ChannelsListFragment$ChannelsListSessionListener;-><init>(Lco/vine/android/ChannelsListFragment;)V

    iput-object v1, p0, Lco/vine/android/ChannelsListFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 65
    invoke-virtual {p0}, Lco/vine/android/ChannelsListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 66
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "selected_channel"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/ChannelsListFragment;->mSelectedChannel:J

    .line 67
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

    .line 95
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/ChannelsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Lco/vine/android/provider/Vine$Channels;->CONTENT_URI:Landroid/net/Uri;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$ChannelsQuery;->PROJECTION:[Ljava/lang/String;

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .locals 5
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    .line 146
    iget-object v4, p0, Lco/vine/android/ChannelsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v4}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v3

    .line 147
    .local v3, "cursor":Landroid/database/Cursor;
    if-eqz v3, :cond_0

    invoke-interface {v3, p3}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 148
    const/4 v4, 0x1

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 149
    .local v1, "channelId":J
    const/4 v4, 0x2

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 150
    .local v0, "channel":Ljava/lang/String;
    iget-object v4, p0, Lco/vine/android/ChannelsListFragment;->mCallback:Lco/vine/android/ChannelsListActivity;

    invoke-virtual {v4, v1, v2, v0}, Lco/vine/android/ChannelsListActivity;->onChannelSelected(JLjava/lang/String;)V

    .line 151
    iget-object v4, p0, Lco/vine/android/ChannelsListFragment;->mDbHelper:Lco/vine/android/provider/VineDatabaseHelper;

    invoke-virtual {v4, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->markChannelLastUsedTimestamp(J)V

    .line 153
    .end local v0    # "channel":Ljava/lang/String;
    .end local v1    # "channelId":J
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
    .line 101
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseCursorListFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    .line 102
    iget-boolean v0, p0, Lco/vine/android/ChannelsListFragment;->mFetched:Z

    if-eqz v0, :cond_0

    .line 103
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lco/vine/android/ChannelsListFragment;->hideProgress(I)V

    .line 104
    iget-object v0, p0, Lco/vine/android/ChannelsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0}, Landroid/support/v4/widget/CursorAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 105
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/ChannelsListFragment;->showSadface(Z)V

    .line 110
    :cond_0
    :goto_0
    return-void

    .line 107
    :cond_1
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/ChannelsListFragment;->showSadface(Z)V

    goto :goto_0
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 44
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/ChannelsListFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 84
    invoke-super {p0}, Lco/vine/android/BaseCursorListFragment;->onResume()V

    .line 85
    iget-object v0, p0, Lco/vine/android/ChannelsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    if-nez v0, :cond_0

    .line 86
    invoke-virtual {p0}, Lco/vine/android/ChannelsListFragment;->initLoader()V

    .line 88
    :cond_0
    iget-boolean v0, p0, Lco/vine/android/ChannelsListFragment;->mFetched:Z

    if-nez v0, :cond_1

    .line 89
    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lco/vine/android/ChannelsListFragment;->fetchContent(I)V

    .line 91
    :cond_1
    return-void
.end method

.method protected onScrollLastItem(Landroid/database/Cursor;)V
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 114
    iget-boolean v0, p0, Lco/vine/android/ChannelsListFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x7

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-nez v0, :cond_0

    .line 115
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/ChannelsListFragment;->fetchContent(I)V

    .line 117
    :cond_0
    return-void
.end method
