.class public Lco/vine/android/ActivityFragment;
.super Lco/vine/android/BaseArrayListFragment;
.source "ActivityFragment.java"

# interfaces
.implements Lco/vine/android/widget/SpanClickListener;
.implements Landroid/view/View$OnClickListener;
.implements Lco/vine/android/widget/OnTabChangedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ActivityFragment$ActivityListener;
    }
.end annotation


# static fields
.field private static final EVENT_SOURCE_TITLE:Ljava/lang/String; = "Activity Feed"

.field private static final STATE_PRIVATE:Ljava/lang/String; = "state_private"

.field private static final TAG:Ljava/lang/String; = "ActivityFragment"


# instance fields
.field private mFetched:Z

.field private mPrivate:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Lco/vine/android/BaseArrayListFragment;-><init>()V

    .line 239
    return-void
.end method

.method static synthetic access$002(Lco/vine/android/ActivityFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ActivityFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 32
    iput-boolean p1, p0, Lco/vine/android/ActivityFragment;->mPrivate:Z

    return p1
.end method

.method private fetchContent(I)V
    .locals 1
    .param p1, "fetchType"    # I

    .prologue
    .line 135
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/ActivityFragment;->fetchContent(IZ)V

    .line 136
    return-void
.end method

.method private fetchContent(IZ)V
    .locals 7
    .param p1, "fetchType"    # I
    .param p2, "silent"    # Z

    .prologue
    const-wide/16 v2, 0x0

    const/4 v1, 0x1

    .line 139
    invoke-virtual {p0, p1}, Lco/vine/android/ActivityFragment;->hasPendingRequest(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 166
    :goto_0
    return-void

    .line 142
    :cond_0
    iput-boolean v1, p0, Lco/vine/android/ActivityFragment;->mFetched:Z

    .line 144
    if-nez p2, :cond_1

    .line 145
    invoke-virtual {p0, p1}, Lco/vine/android/ActivityFragment;->showProgress(I)V

    .line 147
    :cond_1
    packed-switch p1, :pswitch_data_0

    .line 163
    :goto_1
    iget-object v0, p0, Lco/vine/android/ActivityFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ActivityFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    iget v2, p0, Lco/vine/android/ActivityFragment;->mNextPage:I

    iget-wide v3, p0, Lco/vine/android/ActivityFragment;->mAnchor:J

    iget-boolean v5, p0, Lco/vine/android/ActivityFragment;->mPrivate:Z

    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->isFocused()Z

    move-result v6

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->fetchActivity(Lco/vine/android/client/Session;IJZZ)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lco/vine/android/ActivityFragment;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    .line 165
    iget-object v0, p0, Lco/vine/android/ActivityFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->fetchActivityCounts()Ljava/lang/String;

    goto :goto_0

    .line 149
    :pswitch_0
    iput v1, p0, Lco/vine/android/ActivityFragment;->mNextPage:I

    .line 150
    iput-wide v2, p0, Lco/vine/android/ActivityFragment;->mAnchor:J

    goto :goto_1

    .line 154
    :pswitch_1
    iput v1, p0, Lco/vine/android/ActivityFragment;->mNextPage:I

    .line 155
    iput-wide v2, p0, Lco/vine/android/ActivityFragment;->mAnchor:J

    goto :goto_1

    .line 147
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 60
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 62
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "take_focus"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lco/vine/android/ActivityFragment;->mFetched:Z

    if-nez v1, :cond_0

    .line 63
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/HomeTabActivity;

    .line 64
    .local v0, "callback":Lco/vine/android/HomeTabActivity;
    const/4 v1, 0x1

    invoke-virtual {v0, v1, p0}, Lco/vine/android/HomeTabActivity;->showPage(ILandroid/support/v4/app/Fragment;)V

    .line 65
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 66
    const-string v1, "ActivityFragment"

    const-string v2, "Activity tab took focus."

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 69
    .end local v0    # "callback":Lco/vine/android/HomeTabActivity;
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 198
    iget-object v0, p0, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v0, Lco/vine/android/ActivityAdapter;

    .line 199
    .local v0, "adapter":Lco/vine/android/ActivityAdapter;
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 219
    :goto_0
    :pswitch_0
    return-void

    .line 202
    :pswitch_1
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Long;

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    const-string v3, "Activity Feed"

    invoke-static {v4, v5, v6, v3}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    goto :goto_0

    .line 206
    :pswitch_2
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Long;

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    .line 207
    .local v1, "userId":J
    iget-object v3, p0, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v3, Lco/vine/android/ActivityAdapter;

    invoke-virtual {v3, v1, v2}, Lco/vine/android/ActivityAdapter;->isFollowing(J)Z

    move-result v3

    if-nez v3, :cond_0

    .line 208
    invoke-virtual {v0, v1, v2}, Lco/vine/android/ActivityAdapter;->follow(J)V

    .line 209
    iget-object v3, p0, Lco/vine/android/ActivityFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v4, p0, Lco/vine/android/ActivityFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v4

    invoke-virtual {v3, v4, v1, v2, v5}, Lco/vine/android/client/AppController;->followUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lco/vine/android/ActivityFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 212
    :cond_0
    invoke-virtual {v0, v1, v2}, Lco/vine/android/ActivityAdapter;->unfollow(J)V

    .line 213
    iget-object v3, p0, Lco/vine/android/ActivityFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v4, p0, Lco/vine/android/ActivityFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v4

    invoke-virtual {v3, v4, v1, v2, v5}, Lco/vine/android/client/AppController;->unfollowUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lco/vine/android/ActivityFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 199
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0063
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 46
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 47
    new-instance v1, Lco/vine/android/ActivityFragment$ActivityListener;

    invoke-direct {v1, p0}, Lco/vine/android/ActivityFragment$ActivityListener;-><init>(Lco/vine/android/ActivityFragment;)V

    iput-object v1, p0, Lco/vine/android/ActivityFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 48
    if-eqz p1, :cond_1

    .line 49
    const-string v1, "state_private"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 50
    const-string v1, "state_private"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/ActivityFragment;->mPrivate:Z

    .line 56
    :cond_0
    :goto_0
    return-void

    .line 53
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 54
    .local v0, "pr":Landroid/content/SharedPreferences;
    const-string v1, "settings_private"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/ActivityFragment;->mPrivate:Z

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x0

    .line 74
    const v0, 0x7f030060

    invoke-virtual {p0, p1, v0, p2}, Lco/vine/android/ActivityFragment;->createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v7

    .line 75
    .local v7, "v":Landroid/view/View;
    iget-object v0, p0, Lco/vine/android/ActivityFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, v8}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 76
    new-instance v0, Lco/vine/android/ActivityAdapter;

    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ActivityFragment;->mListView:Landroid/widget/ListView;

    iget-object v3, p0, Lco/vine/android/ActivityFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object v4, p0

    move-object v5, p0

    invoke-direct/range {v0 .. v5}, Lco/vine/android/ActivityAdapter;-><init>(Landroid/content/Context;Landroid/widget/ListView;Lco/vine/android/client/AppController;Lco/vine/android/widget/SpanClickListener;Landroid/view/View$OnClickListener;)V

    iput-object v0, p0, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    .line 77
    iget-object v0, p0, Lco/vine/android/ActivityFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 78
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lco/vine/android/HomeTabActivity;

    if-eqz v0, :cond_0

    .line 79
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f03009d

    invoke-virtual {v0, v1, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v6

    .line 80
    .local v6, "header":Landroid/view/View;
    iget-object v0, p0, Lco/vine/android/ActivityFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lco/vine/android/widget/PinnedHeaderListView;

    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0084

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    invoke-virtual {v0, v6, v1}, Lco/vine/android/widget/PinnedHeaderListView;->setRefreshHeader(Landroid/view/View;I)V

    .line 81
    iget-object v0, p0, Lco/vine/android/ActivityFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, v6, v9, v8}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 83
    .end local v6    # "header":Landroid/view/View;
    :cond_0
    return-object v7
.end method

.method protected onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .locals 7
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    const/4 v5, 0x1

    const-wide/16 v2, 0x0

    .line 223
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lco/vine/android/widget/ActivityViewHolder;

    if-eqz v0, :cond_0

    .line 224
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/widget/ActivityViewHolder;

    .line 225
    .local v6, "holder":Lco/vine/android/widget/ActivityViewHolder;
    iget-boolean v0, v6, Lco/vine/android/widget/ActivityViewHolder;->clickable:Z

    if-eqz v0, :cond_0

    .line 226
    iget v0, v6, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    if-ne v0, v5, :cond_1

    iget-wide v0, v6, Lco/vine/android/widget/ActivityViewHolder;->postId:J

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 227
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-wide v1, v6, Lco/vine/android/widget/ActivityViewHolder;->postId:J

    invoke-static {v0, v1, v2}, Lco/vine/android/SingleActivity;->start(Landroid/content/Context;J)V

    .line 237
    .end local v6    # "holder":Lco/vine/android/widget/ActivityViewHolder;
    :cond_0
    :goto_0
    return-void

    .line 228
    .restart local v6    # "holder":Lco/vine/android/widget/ActivityViewHolder;
    :cond_1
    iget v0, v6, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    if-nez v0, :cond_2

    iget-wide v0, v6, Lco/vine/android/widget/ActivityViewHolder;->userId:J

    cmp-long v0, v0, v2

    if-lez v0, :cond_2

    .line 229
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-wide v1, v6, Lco/vine/android/widget/ActivityViewHolder;->userId:J

    const-string v3, "Activity Feed"

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    goto :goto_0

    .line 230
    :cond_2
    iget v0, v6, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_3

    iget-wide v0, v6, Lco/vine/android/widget/ActivityViewHolder;->notificationId:J

    cmp-long v0, v0, v2

    if-lez v0, :cond_3

    .line 231
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-wide v1, v6, Lco/vine/android/widget/ActivityViewHolder;->notificationId:J

    iget-wide v3, v6, Lco/vine/android/widget/ActivityViewHolder;->anchor:J

    invoke-static {v0, v1, v2, v3, v4}, Lco/vine/android/UsersActivity;->launchUserListForNotification(Landroid/content/Context;JJ)V

    goto :goto_0

    .line 232
    :cond_3
    iget v0, v6, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    iget-wide v0, v6, Lco/vine/android/widget/ActivityViewHolder;->postId:J

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 233
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-wide v1, v6, Lco/vine/android/widget/ActivityViewHolder;->postId:J

    iget-object v3, p0, Lco/vine/android/ActivityFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v3

    invoke-static/range {v0 .. v5}, Lco/vine/android/CommentsActivity;->start(Landroid/content/Context;JJZ)V

    goto :goto_0
.end method

.method public onMoveAway(I)V
    .locals 1
    .param p1, "newPosition"    # I

    .prologue
    .line 130
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onMoveAway(I)V

    .line 131
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/ActivityFragment;->mFocused:Z

    .line 132
    return-void
.end method

.method public onMoveTo(I)V
    .locals 4
    .param p1, "oldPosition"    # I

    .prologue
    const/4 v3, 0x1

    .line 114
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onMoveTo(I)V

    .line 115
    iput-boolean v3, p0, Lco/vine/android/ActivityFragment;->mFocused:Z

    .line 116
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 117
    .local v0, "pr":Landroid/content/SharedPreferences;
    const-string v1, "settings_private"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/ActivityFragment;->mPrivate:Z

    .line 119
    iget-object v1, p0, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->hasPendingRequest()Z

    move-result v1

    if-nez v1, :cond_0

    .line 120
    iget-object v1, p0, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v1}, Landroid/widget/BaseAdapter;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 121
    const/4 v1, 0x3

    invoke-direct {p0, v1}, Lco/vine/android/ActivityFragment;->fetchContent(I)V

    .line 126
    :cond_0
    :goto_0
    return-void

    .line 123
    :cond_1
    const/4 v1, 0x2

    invoke-direct {p0, v1, v3}, Lco/vine/android/ActivityFragment;->fetchContent(IZ)V

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 88
    invoke-super {p0}, Lco/vine/android/BaseArrayListFragment;->onResume()V

    .line 89
    iget-object v0, p0, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/ActivityFragment;->mFetched:Z

    if-nez v0, :cond_0

    .line 90
    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lco/vine/android/ActivityFragment;->fetchContent(I)V

    .line 92
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 103
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 104
    const-string v0, "state_private"

    iget-boolean v1, p0, Lco/vine/android/ActivityFragment;->mPrivate:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 105
    return-void
.end method

.method protected onScrollLastItem()V
    .locals 2

    .prologue
    .line 95
    iget-boolean v0, p0, Lco/vine/android/ActivityFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lco/vine/android/ActivityFragment;->mNextPage:I

    if-lez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->getCount()I

    move-result v0

    const/16 v1, 0x190

    if-gt v0, v1, :cond_0

    .line 97
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/ActivityFragment;->fetchContent(I)V

    .line 99
    :cond_0
    return-void
.end method

.method public onSpanClicked(Landroid/view/View;ILjava/lang/Object;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/Object;

    .prologue
    const/4 v5, 0x1

    .line 170
    packed-switch p2, :pswitch_data_0

    .line 188
    :pswitch_0
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_1

    .line 194
    .end local p3    # "tag":Ljava/lang/Object;
    :goto_0
    return-void

    .line 172
    .restart local p3    # "tag":Ljava/lang/Object;
    :pswitch_1
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast p3, Ljava/lang/Long;

    .end local p3    # "tag":Ljava/lang/Object;
    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    const-string v3, "Activity Feed"

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    goto :goto_0

    .line 176
    .restart local p3    # "tag":Ljava/lang/Object;
    :pswitch_2
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast p3, Ljava/lang/String;

    .end local p3    # "tag":Ljava/lang/Object;
    invoke-static {v0, p3}, Lco/vine/android/HashtagActivity;->start(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 180
    .restart local p3    # "tag":Ljava/lang/Object;
    :pswitch_3
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    move-object v0, p3

    check-cast v0, [Ljava/lang/Object;

    check-cast v0, [Ljava/lang/Object;

    const/4 v2, 0x0

    aget-object v0, v0, v2

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    check-cast p3, [Ljava/lang/Object;

    .end local p3    # "tag":Ljava/lang/Object;
    check-cast p3, [Ljava/lang/Object;

    aget-object v0, p3, v5

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v1, v2, v3, v4, v5}, Lco/vine/android/UsersActivity;->launchUserListForNotification(Landroid/content/Context;JJ)V

    goto :goto_0

    .line 184
    .restart local p3    # "tag":Ljava/lang/Object;
    :pswitch_4
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast p3, Ljava/lang/Long;

    .end local p3    # "tag":Ljava/lang/Object;
    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    const-wide/16 v3, 0x0

    invoke-static/range {v0 .. v5}, Lco/vine/android/CommentsActivity;->start(Landroid/content/Context;JJZ)V

    goto :goto_0

    .line 190
    .restart local p3    # "tag":Ljava/lang/Object;
    :pswitch_5
    invoke-virtual {p0}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast p3, Ljava/lang/Long;

    .end local p3    # "tag":Ljava/lang/Object;
    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    const-string v3, "Activity Feed"

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    goto :goto_0

    .line 170
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch

    .line 188
    :pswitch_data_1
    .packed-switch 0x7f0a005e
        :pswitch_5
    .end packed-switch
.end method

.method protected refresh()V
    .locals 1

    .prologue
    .line 109
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lco/vine/android/ActivityFragment;->fetchContent(I)V

    .line 110
    return-void
.end method
