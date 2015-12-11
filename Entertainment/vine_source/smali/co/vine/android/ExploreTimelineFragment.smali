.class public Lco/vine/android/ExploreTimelineFragment;
.super Lco/vine/android/BaseTimelineFragment;
.source "ExploreTimelineFragment.java"


# static fields
.field public static final ARG_CATEGORY:Ljava/lang/String; = "category"

.field public static final ARG_DATA:Ljava/lang/String; = "data"

.field public static final ARG_TAG:Ljava/lang/String; = "tag"

.field public static final CATEGORY_ON_THE_RISE:Ljava/lang/String; = "trending-people"

.field public static final CATEGORY_POPULAR_NOW:Ljava/lang/String; = "popular-now"

.field public static final CATEGORY_TAG:Ljava/lang/String; = "tag"

.field public static final CATEGORY_TIMELINES:Ljava/lang/String; = "timelines"

.field private static final EVENT_SOURCE_TITLE:Ljava/lang/String; = "Explore Timeline: "


# instance fields
.field private mCategory:Ljava/lang/String;

.field private mData:Landroid/net/Uri;

.field private mTag:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lco/vine/android/BaseTimelineFragment;-><init>()V

    return-void
.end method

.method public static prepareArguments(Landroid/content/Intent;ZLjava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Landroid/os/Bundle;
    .locals 2
    .param p0, "intent"    # Landroid/content/Intent;
    .param p1, "refreshable"    # Z
    .param p2, "category"    # Ljava/lang/String;
    .param p3, "tag"    # Ljava/lang/String;
    .param p4, "data"    # Landroid/net/Uri;

    .prologue
    .line 88
    invoke-static {p0, p1}, Lco/vine/android/BaseArrayListFragment;->prepareArguments(Landroid/content/Intent;Z)Landroid/os/Bundle;

    move-result-object v0

    .line 89
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "category"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    const-string v1, "tag"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    const-string v1, "data"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 92
    return-object v0
.end method


# virtual methods
.method protected fetchPosts(IJZ)Ljava/lang/String;
    .locals 13
    .param p1, "page"    # I
    .param p2, "anchor"    # J
    .param p4, "userInitiated"    # Z

    .prologue
    .line 67
    const-string v0, "trending-people"

    iget-object v1, p0, Lco/vine/android/ExploreTimelineFragment;->mCategory:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 68
    const/4 v5, 0x4

    .line 82
    .local v5, "type":I
    :goto_0
    iget-object v0, p0, Lco/vine/android/ExploreTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ExploreTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    const/16 v2, 0xa

    iget-object v3, p0, Lco/vine/android/ExploreTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v3

    iget-object v10, p0, Lco/vine/android/ExploreTimelineFragment;->mTag:Ljava/lang/String;

    const/4 v11, 0x0

    iget-object v12, p0, Lco/vine/android/ExploreTimelineFragment;->mData:Landroid/net/Uri;

    move v6, p1

    move-wide v7, p2

    move/from16 v9, p4

    invoke-virtual/range {v0 .. v12}, Lco/vine/android/client/AppController;->fetchPosts(Lco/vine/android/client/Session;IJIIJZLjava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 69
    .end local v5    # "type":I
    :cond_0
    const-string v0, "popular-now"

    iget-object v1, p0, Lco/vine/android/ExploreTimelineFragment;->mCategory:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 70
    const/4 v5, 0x5

    .restart local v5    # "type":I
    goto :goto_0

    .line 71
    .end local v5    # "type":I
    :cond_1
    const-string v0, "tag"

    iget-object v1, p0, Lco/vine/android/ExploreTimelineFragment;->mCategory:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 72
    iget-object v0, p0, Lco/vine/android/ExploreTimelineFragment;->mTag:Ljava/lang/String;

    if-nez v0, :cond_2

    .line 73
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "You have to specify a tag."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 75
    :cond_2
    const/4 v5, 0x6

    .restart local v5    # "type":I
    goto :goto_0

    .line 76
    .end local v5    # "type":I
    :cond_3
    const-string v0, "timelines"

    iget-object v1, p0, Lco/vine/android/ExploreTimelineFragment;->mCategory:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 77
    const/16 v5, 0xb

    .restart local v5    # "type":I
    goto :goto_0

    .line 79
    .end local v5    # "type":I
    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "You have to specify a category."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 44
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 45
    iget-object v0, p0, Lco/vine/android/ExploreTimelineFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/ExploreTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 46
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 33
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onCreate(Landroid/os/Bundle;)V

    .line 34
    invoke-virtual {p0}, Lco/vine/android/ExploreTimelineFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 35
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "category"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ExploreTimelineFragment;->mCategory:Ljava/lang/String;

    .line 36
    const-string v1, "data"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    iput-object v1, p0, Lco/vine/android/ExploreTimelineFragment;->mData:Landroid/net/Uri;

    .line 37
    const-string v1, "tag"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ExploreTimelineFragment;->mTag:Ljava/lang/String;

    .line 38
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Explore Timeline: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ExploreTimelineFragment;->mCategory:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lco/vine/android/ExploreTimelineFragment;->setFlurryEventSource(Ljava/lang/String;)V

    .line 39
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lco/vine/android/ExploreTimelineFragment;->setFocused(Z)V

    .line 40
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 60
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment;->onPause()V

    .line 61
    iget-object v0, p0, Lco/vine/android/ExploreTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/ExploreTimelineFragment;->isFocused()Z

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onPause(Z)V

    .line 62
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 50
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment;->onResume()V

    .line 51
    iget-object v0, p0, Lco/vine/android/ExploreTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/ExploreTimelineFragment;->isFocused()Z

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onResume(Z)V

    .line 52
    iget-object v0, p0, Lco/vine/android/ExploreTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    const-string v1, "ExploreTimeline"

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->startLoadingTimeProfiling(Ljava/lang/String;)V

    .line 53
    iget-object v0, p0, Lco/vine/android/ExploreTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/GenericTimelineAdapter;->getCount()I

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/ExploreTimelineFragment;->mFetched:Z

    if-nez v0, :cond_0

    .line 54
    const/4 v0, 0x3

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lco/vine/android/ExploreTimelineFragment;->fetchContent(IZ)V

    .line 56
    :cond_0
    return-void
.end method
