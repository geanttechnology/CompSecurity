.class public Lco/vine/android/ExploreChannelsFragment;
.super Lco/vine/android/BaseTimelineFragment;
.source "ExploreChannelsFragment.java"


# static fields
.field public static final ARG_CHANNEL_ID:Ljava/lang/String; = "channelId"

.field public static final ARG_COLOR:Ljava/lang/String; = "color"

.field public static final ARG_SORT:Ljava/lang/String; = "sort"

.field public static final ARG_TAG:Ljava/lang/String; = "tag"

.field public static final CATEGORY_CHANNELS:Ljava/lang/String; = "channels"

.field private static final EVENT_SOURCE_TITLE:Ljava/lang/String; = "Explore Channel: "

.field public static final SORT_POPULAR:Ljava/lang/String; = "popular"

.field public static final SORT_RECENT:Ljava/lang/String; = "recent"


# instance fields
.field private mCallback:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/ExploreChannelsActivity;",
            ">;"
        }
    .end annotation
.end field

.field private mChannelId:Ljava/lang/String;

.field private mColor:I

.field private mSort:Ljava/lang/String;

.field private mTabTag:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lco/vine/android/BaseTimelineFragment;-><init>()V

    return-void
.end method

.method private handleFocus()V
    .locals 5

    .prologue
    const/4 v4, 0x3

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 101
    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mCallback:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mCallback:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 102
    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mCallback:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/ExploreChannelsActivity;

    iget-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mTabTag:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lco/vine/android/ExploreChannelsActivity;->isShowing(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 103
    invoke-virtual {p0, v3}, Lco/vine/android/ExploreChannelsFragment;->setFocused(Z)V

    .line 104
    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 105
    invoke-virtual {p0, v4}, Lco/vine/android/ExploreChannelsFragment;->showProgress(I)V

    .line 106
    invoke-virtual {p0, v4, v2}, Lco/vine/android/ExploreChannelsFragment;->fetchContent(IZ)V

    .line 108
    :cond_0
    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/GenericTimelineAdapter;->isPlaying()Z

    move-result v0

    if-nez v0, :cond_1

    .line 109
    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0, v3}, Lco/vine/android/widget/GenericTimelineAdapter;->onResume(Z)V

    .line 116
    :cond_1
    :goto_0
    return-void

    .line 112
    :cond_2
    invoke-virtual {p0, v2}, Lco/vine/android/ExploreChannelsFragment;->setFocused(Z)V

    .line 113
    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0, v2}, Lco/vine/android/widget/GenericTimelineAdapter;->onResume(Z)V

    goto :goto_0
.end method

.method public static prepareArguments(Landroid/content/Intent;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/os/Bundle;
    .locals 2
    .param p0, "intent"    # Landroid/content/Intent;
    .param p1, "refreshable"    # Z
    .param p2, "channelId"    # Ljava/lang/String;
    .param p3, "sort"    # Ljava/lang/String;
    .param p4, "tag"    # Ljava/lang/String;
    .param p5, "color"    # I

    .prologue
    .line 134
    invoke-static {p0, p1}, Lco/vine/android/BaseArrayListFragment;->prepareArguments(Landroid/content/Intent;Z)Landroid/os/Bundle;

    move-result-object v0

    .line 135
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "channelId"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    const-string v1, "sort"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    const-string v1, "tag"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    const-string v1, "color"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 139
    return-object v0
.end method


# virtual methods
.method protected fetchPosts(IJZ)Ljava/lang/String;
    .locals 13
    .param p1, "page"    # I
    .param p2, "anchor"    # J
    .param p4, "userInitiated"    # Z

    .prologue
    .line 121
    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mSort:Ljava/lang/String;

    const-string v1, "popular"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 122
    const/16 v5, 0x8

    .line 127
    .local v5, "groupType":I
    :goto_0
    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    const/16 v2, 0xa

    iget-object v3, p0, Lco/vine/android/ExploreChannelsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v3

    iget-object v10, p0, Lco/vine/android/ExploreChannelsFragment;->mChannelId:Ljava/lang/String;

    iget-object v11, p0, Lco/vine/android/ExploreChannelsFragment;->mSort:Ljava/lang/String;

    const/4 v12, 0x0

    move v6, p1

    move-wide v7, p2

    move/from16 v9, p4

    invoke-virtual/range {v0 .. v12}, Lco/vine/android/client/AppController;->fetchPosts(Lco/vine/android/client/Session;IJIIJZLjava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 124
    .end local v5    # "groupType":I
    :cond_0
    const/16 v5, 0x9

    .restart local v5    # "groupType":I
    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 73
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 74
    iget-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    const v2, 0xffffff

    iget v3, p0, Lco/vine/android/ExploreChannelsFragment;->mColor:I

    and-int/2addr v2, v3

    invoke-virtual {v1, v2}, Lco/vine/android/widget/GenericTimelineAdapter;->setProfileColor(I)V

    .line 75
    iget-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mListView:Landroid/widget/ListView;

    iget-object v2, p0, Lco/vine/android/ExploreChannelsFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 76
    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lco/vine/android/ExploreChannelsActivity;

    invoke-virtual {v1}, Lco/vine/android/ExploreChannelsActivity;->hasTabs()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 77
    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsFragment;->setUpUnderNavHeader()V

    .line 78
    iget-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mEmptyProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v1}, Landroid/widget/ProgressBar;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 79
    .local v0, "params":Landroid/view/ViewGroup$MarginLayoutParams;
    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0084

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    iput v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 81
    .end local v0    # "params":Landroid/view/ViewGroup$MarginLayoutParams;
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 39
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 40
    check-cast v0, Lco/vine/android/ExploreChannelsActivity;

    .line 41
    .local v0, "callback":Lco/vine/android/ExploreChannelsActivity;
    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mCallback:Ljava/lang/ref/WeakReference;

    .line 42
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 46
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onCreate(Landroid/os/Bundle;)V

    .line 47
    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 48
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "channelId"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mChannelId:Ljava/lang/String;

    .line 50
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Explore Channel: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ExploreChannelsFragment;->mChannelId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lco/vine/android/ExploreChannelsFragment;->setFlurryEventSource(Ljava/lang/String;)V

    .line 52
    const-string v1, "sort"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mSort:Ljava/lang/String;

    .line 53
    iget-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mSort:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 54
    const-string v1, "popular"

    iput-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mSort:Ljava/lang/String;

    .line 57
    :cond_0
    const-string v1, "color"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lco/vine/android/ExploreChannelsFragment;->mColor:I

    .line 59
    const-string v1, "tag"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mTabTag:Ljava/lang/String;

    .line 60
    iget-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mTabTag:Ljava/lang/String;

    if-nez v1, :cond_1

    .line 61
    const-string v1, "popular"

    iput-object v1, p0, Lco/vine/android/ExploreChannelsFragment;->mTabTag:Ljava/lang/String;

    .line 63
    :cond_1
    return-void
.end method

.method public onMoveTo(I)V
    .locals 1
    .param p1, "oldPosition"    # I

    .prologue
    .line 67
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onMoveTo(I)V

    .line 68
    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/ExploreChannelsActivity;

    invoke-virtual {v0}, Lco/vine/android/ExploreChannelsActivity;->resetNav()V

    .line 69
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 95
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment;->onPause()V

    .line 96
    invoke-virtual {p0, v1}, Lco/vine/android/ExploreChannelsFragment;->setFocused(Z)V

    .line 97
    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onPause(Z)V

    .line 98
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 85
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment;->onResume()V

    .line 86
    invoke-direct {p0}, Lco/vine/android/ExploreChannelsFragment;->handleFocus()V

    .line 87
    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    const-string v1, "ExploreChannels"

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->startLoadingTimeProfiling(Ljava/lang/String;)V

    .line 88
    iget-object v0, p0, Lco/vine/android/ExploreChannelsFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/GenericTimelineAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 89
    const/4 v0, 0x3

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lco/vine/android/ExploreChannelsFragment;->fetchContent(IZ)V

    .line 91
    :cond_0
    return-void
.end method
