.class public abstract Lco/vine/android/BaseTimelineFragment;
.super Lco/vine/android/BaseArrayListFragment;
.source "BaseTimelineFragment.java"

# interfaces
.implements Lco/vine/android/widget/SpanClickListener;
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;
    }
.end annotation


# static fields
.field private static final REQUEST_CODE_OPTIONS:I = 0xa

.field private static final STATE_LIKE_CACHE:Ljava/lang/String; = "state_like_cache"

.field private static final STATE_REVINE_CACHE:Ljava/lang/String; = "state_revine_cache"


# instance fields
.field private mCallback:Landroid/support/v7/app/ActionBarActivity;

.field protected mClientFlagsBannerParent:Landroid/view/ViewGroup;

.field protected mClientFlagsBannerWasDismissed:Z

.field protected mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

.field protected mFetched:Z

.field private mFlurryEventSource:Ljava/lang/String;

.field protected final mHeaderParents:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field protected mLastFetchType:I

.field protected mLikeCache:Lco/vine/android/LikeCache;

.field protected final mMergePostReceiver:Landroid/content/BroadcastReceiver;

.field private mMergePostReceiverRegistered:Z

.field private final mMuteChangeReceiver:Landroid/content/BroadcastReceiver;

.field protected mRevineCache:Lco/vine/android/RevineCache;

.field protected final mVineSpanClicker:Lco/vine/android/VineSpanClicker;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 54
    invoke-direct {p0}, Lco/vine/android/BaseArrayListFragment;-><init>()V

    .line 69
    new-instance v0, Lco/vine/android/VineSpanClicker;

    invoke-direct {v0, p0}, Lco/vine/android/VineSpanClicker;-><init>(Lco/vine/android/BaseFragment;)V

    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mVineSpanClicker:Lco/vine/android/VineSpanClicker;

    .line 72
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mHeaderParents:Ljava/util/HashSet;

    .line 75
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/BaseTimelineFragment;->mMergePostReceiverRegistered:Z

    .line 78
    new-instance v0, Lco/vine/android/BaseTimelineFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/BaseTimelineFragment$1;-><init>(Lco/vine/android/BaseTimelineFragment;)V

    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mMergePostReceiver:Landroid/content/BroadcastReceiver;

    .line 100
    new-instance v0, Lco/vine/android/BaseTimelineFragment$2;

    invoke-direct {v0, p0}, Lco/vine/android/BaseTimelineFragment$2;-><init>(Lco/vine/android/BaseTimelineFragment;)V

    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mMuteChangeReceiver:Landroid/content/BroadcastReceiver;

    .line 424
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/BaseTimelineFragment;)Landroid/support/v7/app/ActionBarActivity;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/BaseTimelineFragment;

    .prologue
    .line 54
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mCallback:Landroid/support/v7/app/ActionBarActivity;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/BaseTimelineFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/BaseTimelineFragment;

    .prologue
    .line 54
    invoke-direct {p0}, Lco/vine/android/BaseTimelineFragment;->hideClientFlagsBanner()V

    return-void
.end method

.method private hideClientFlagsBanner()V
    .locals 2

    .prologue
    .line 419
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mClientFlagsBannerParent:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 420
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mClientFlagsBannerParent:Landroid/view/ViewGroup;

    const v1, 0x7f0a0237

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 422
    :cond_0
    return-void
.end method


# virtual methods
.method public addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "data"    # Ljava/lang/Object;
    .param p3, "isSeletable"    # Z

    .prologue
    .line 136
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, p1, p2, p3}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 137
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mHeaderParents:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 138
    return-void
.end method

.method protected fetchContent(IZ)V
    .locals 3
    .param p1, "fetchType"    # I
    .param p2, "userInitiated"    # Z

    .prologue
    const/4 v1, 0x1

    .line 238
    iput p1, p0, Lco/vine/android/BaseTimelineFragment;->mLastFetchType:I

    .line 239
    invoke-virtual {p0, p1}, Lco/vine/android/BaseTimelineFragment;->hasPendingRequest(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 258
    :goto_0
    return-void

    .line 242
    :cond_0
    iput-boolean v1, p0, Lco/vine/android/BaseTimelineFragment;->mFetched:Z

    .line 244
    packed-switch p1, :pswitch_data_0

    .line 254
    :goto_1
    if-eqz p2, :cond_1

    .line 255
    invoke-virtual {p0, p1}, Lco/vine/android/BaseTimelineFragment;->showProgress(I)V

    .line 257
    :cond_1
    iget v0, p0, Lco/vine/android/BaseTimelineFragment;->mNextPage:I

    iget-wide v1, p0, Lco/vine/android/BaseTimelineFragment;->mAnchor:J

    invoke-virtual {p0, v0, v1, v2, p2}, Lco/vine/android/BaseTimelineFragment;->fetchPosts(IJZ)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lco/vine/android/BaseTimelineFragment;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    goto :goto_0

    .line 248
    :pswitch_0
    iput v1, p0, Lco/vine/android/BaseTimelineFragment;->mNextPage:I

    .line 249
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/BaseTimelineFragment;->mAnchor:J

    goto :goto_1

    .line 244
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method protected abstract fetchPosts(IJZ)Ljava/lang/String;
.end method

.method public getHeaderViewParents()Ljava/util/HashSet;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashSet",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation

    .prologue
    .line 141
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mHeaderParents:Ljava/util/HashSet;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 182
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 183
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 184
    .local v1, "activity":Landroid/app/Activity;
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lco/vine/android/HomeTabActivity;

    if-eqz v0, :cond_0

    .line 185
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->setUpUnderNavHeader()V

    .line 187
    :cond_0
    new-instance v0, Lco/vine/android/widget/FeedAdapter;

    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment;->mListView:Landroid/widget/ListView;

    iget-object v3, p0, Lco/vine/android/BaseTimelineFragment;->mLikeCache:Lco/vine/android/LikeCache;

    iget-object v4, p0, Lco/vine/android/BaseTimelineFragment;->mRevineCache:Lco/vine/android/RevineCache;

    iget-object v6, p0, Lco/vine/android/BaseTimelineFragment;->mFlurryEventSource:Ljava/lang/String;

    move-object v5, p0

    invoke-direct/range {v0 .. v6}, Lco/vine/android/widget/FeedAdapter;-><init>(Landroid/app/Activity;Landroid/widget/ListView;Lco/vine/android/LikeCache;Lco/vine/android/RevineCache;Lco/vine/android/BaseTimelineFragment;Ljava/lang/String;)V

    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    .line 190
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mAdapter:Landroid/widget/BaseAdapter;

    .line 191
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 338
    packed-switch p1, :pswitch_data_0

    .line 345
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseArrayListFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 349
    :goto_0
    return-void

    .line 340
    :pswitch_0
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v0, v1, p2, p3}, Lco/vine/android/PostOptionsDialogActivity;->onActivityResult(Lco/vine/android/client/AppController;Landroid/app/Activity;ILandroid/content/Intent;)Lco/vine/android/PostOptionsDialogActivity$Result;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/BaseTimelineFragment;->processPostOptionsResult(Lco/vine/android/PostOptionsDialogActivity$Result;)V

    goto :goto_0

    .line 338
    nop

    :pswitch_data_0
    .packed-switch 0xa
        :pswitch_0
    .end packed-switch
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 174
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onAttach(Landroid/app/Activity;)V

    .line 175
    instance-of v0, p1, Landroid/support/v7/app/ActionBarActivity;

    if-eqz v0, :cond_0

    .line 176
    check-cast p1, Landroid/support/v7/app/ActionBarActivity;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lco/vine/android/BaseTimelineFragment;->mCallback:Landroid/support/v7/app/ActionBarActivity;

    .line 178
    :cond_0
    return-void
.end method

.method public onBackPressed()Z
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/GenericTimelineAdapter;->onBackPressed()Z

    move-result v0

    return v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 10
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 279
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 334
    :cond_0
    :goto_0
    return-void

    .line 281
    :sswitch_0
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Long;

    .line 282
    .local v9, "postId":Ljava/lang/Long;
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment;->mLikeCache:Lco/vine/android/LikeCache;

    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Lco/vine/android/LikeCache;->isLike(J)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 284
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment;->mFlurryEventSource:Ljava/lang/String;

    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/client/AppController;->unlikePost(Ljava/lang/String;Lco/vine/android/client/Session;JZ)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lco/vine/android/BaseTimelineFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 288
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment;->mLikeCache:Lco/vine/android/LikeCache;

    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Lco/vine/android/LikeCache;->unlike(J)V

    .line 289
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Lco/vine/android/widget/GenericTimelineAdapter;->showUnlikedByMe(J)V

    goto :goto_0

    .line 292
    :cond_1
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment;->mFlurryEventSource:Ljava/lang/String;

    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    iget-object v5, p0, Lco/vine/android/BaseTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v5

    iget-object v7, p0, Lco/vine/android/BaseTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v7}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v7

    invoke-virtual {v7}, Lco/vine/android/client/Session;->getName()Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual/range {v0 .. v8}, Lco/vine/android/client/AppController;->likePost(Ljava/lang/String;Lco/vine/android/client/Session;JJLjava/lang/String;Z)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lco/vine/android/BaseTimelineFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 297
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment;->mLikeCache:Lco/vine/android/LikeCache;

    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Lco/vine/android/LikeCache;->like(J)V

    .line 298
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Lco/vine/android/widget/GenericTimelineAdapter;->showLikedByMe(J)V

    goto :goto_0

    .line 303
    .end local v9    # "postId":Ljava/lang/Long;
    :sswitch_1
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VinePost;

    .line 304
    .local v0, "post":Lco/vine/android/api/VinePost;
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 305
    .local v1, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v1, :cond_0

    .line 306
    iget-wide v2, v0, Lco/vine/android/api/VinePost;->userId:J

    iget-object v4, p0, Lco/vine/android/BaseTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_2

    const/4 v2, 0x1

    :goto_1
    const/4 v3, 0x0

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/PostOptionsDialogActivity;->getMoreIntent(Lco/vine/android/api/VinePost;Landroid/content/Context;ZZ)Landroid/content/Intent;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v1, v2, v3}, Landroid/support/v4/app/FragmentActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto/16 :goto_0

    :cond_2
    const/4 v2, 0x0

    goto :goto_1

    .line 314
    .end local v0    # "post":Lco/vine/android/api/VinePost;
    .end local v1    # "activity":Landroid/support/v4/app/FragmentActivity;
    :sswitch_2
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VinePost;

    .line 315
    .restart local v0    # "post":Lco/vine/android/api/VinePost;
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 316
    .restart local v1    # "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v1, :cond_0

    .line 317
    iget-wide v2, v0, Lco/vine/android/api/VinePost;->userId:J

    iget-object v4, p0, Lco/vine/android/BaseTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_3

    const/4 v2, 0x1

    :goto_2
    iget-object v3, p0, Lco/vine/android/BaseTimelineFragment;->mRevineCache:Lco/vine/android/RevineCache;

    iget-wide v4, v0, Lco/vine/android/api/VinePost;->postId:J

    invoke-virtual {v3, v4, v5}, Lco/vine/android/RevineCache;->getMyRepostId(J)J

    move-result-wide v3

    iget-object v5, p0, Lco/vine/android/BaseTimelineFragment;->mFlurryEventSource:Ljava/lang/String;

    invoke-static/range {v0 .. v5}, Lco/vine/android/PostOptionsDialogActivity;->getShareIntent(Lco/vine/android/api/VinePost;Landroid/content/Context;ZJLjava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v1, v2, v3}, Landroid/support/v4/app/FragmentActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto/16 :goto_0

    :cond_3
    const/4 v2, 0x0

    goto :goto_2

    .line 326
    .end local v0    # "post":Lco/vine/android/api/VinePost;
    .end local v1    # "activity":Landroid/support/v4/app/FragmentActivity;
    :sswitch_3
    invoke-direct {p0}, Lco/vine/android/BaseTimelineFragment;->hideClientFlagsBanner()V

    .line 327
    const/4 v2, 0x1

    iput-boolean v2, p0, Lco/vine/android/BaseTimelineFragment;->mClientFlagsBannerWasDismissed:Z

    goto/16 :goto_0

    .line 279
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0a014d -> :sswitch_1
        0x7f0a014f -> :sswitch_0
        0x7f0a0151 -> :sswitch_2
        0x7f0a0239 -> :sswitch_3
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 146
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 147
    new-instance v0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;

    invoke-direct {v0, p0}, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;-><init>(Lco/vine/android/BaseTimelineFragment;)V

    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 149
    if-eqz p1, :cond_0

    const-string v0, "state_like_cache"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 150
    const-string v0, "state_like_cache"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lco/vine/android/LikeCache;

    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mLikeCache:Lco/vine/android/LikeCache;

    .line 151
    const-string v0, "state_revine_cache"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lco/vine/android/RevineCache;

    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mRevineCache:Lco/vine/android/RevineCache;

    .line 156
    :goto_0
    return-void

    .line 153
    :cond_0
    new-instance v0, Lco/vine/android/LikeCache;

    invoke-direct {v0}, Lco/vine/android/LikeCache;-><init>()V

    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mLikeCache:Lco/vine/android/LikeCache;

    .line 154
    new-instance v0, Lco/vine/android/RevineCache;

    invoke-direct {v0}, Lco/vine/android/RevineCache;-><init>()V

    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mRevineCache:Lco/vine/android/RevineCache;

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 360
    :try_start_0
    invoke-super {p0}, Lco/vine/android/BaseArrayListFragment;->onDestroy()V

    .line 361
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onDestroy()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 365
    :goto_0
    return-void

    .line 362
    :catch_0
    move-exception v0

    .line 363
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Failed to remove timeline fragment"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    .line 201
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/GenericTimelineAdapter;->onDestroyView()V

    .line 202
    iget-boolean v0, p0, Lco/vine/android/BaseTimelineFragment;->mMergePostReceiverRegistered:Z

    if-eqz v0, :cond_0

    .line 203
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment;->mMergePostReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 205
    :cond_0
    invoke-super {p0}, Lco/vine/android/BaseArrayListFragment;->onDestroyView()V

    .line 206
    return-void
.end method

.method public onMoveAway(I)V
    .locals 2
    .param p1, "newPosition"    # I

    .prologue
    .line 226
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onMoveAway(I)V

    .line 227
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->isFocused()Z

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onPause(Z)V

    .line 228
    return-void
.end method

.method public onMoveTo(I)V
    .locals 2
    .param p1, "oldPosition"    # I

    .prologue
    .line 217
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onMoveTo(I)V

    .line 218
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 219
    const/4 v0, 0x3

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lco/vine/android/BaseTimelineFragment;->fetchContent(IZ)V

    .line 221
    :cond_0
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->isFocused()Z

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onResume(Z)V

    .line 222
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 131
    invoke-super {p0}, Lco/vine/android/BaseArrayListFragment;->onPause()V

    .line 132
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment;->mMuteChangeReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 133
    return-void
.end method

.method public onResume()V
    .locals 5

    .prologue
    .line 125
    invoke-super {p0}, Lco/vine/android/BaseArrayListFragment;->onResume()V

    .line 126
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment;->mMuteChangeReceiver:Landroid/content/BroadcastReceiver;

    sget-object v2, Lco/vine/android/util/MuteUtil;->MUTE_INTENT_FILTER:Landroid/content/IntentFilter;

    const-string v3, "co.vine.android.BROADCAST"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 127
    return-void
.end method

.method public onRevineBySpanClicked(J)V
    .locals 1
    .param p1, "userId"    # J

    .prologue
    .line 120
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mVineSpanClicker:Lco/vine/android/VineSpanClicker;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/VineSpanClicker;->onRevineBySpanClicked(J)V

    .line 121
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 210
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 211
    const-string v0, "state_like_cache"

    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment;->mLikeCache:Lco/vine/android/LikeCache;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 212
    const-string v0, "state_revine_cache"

    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment;->mRevineCache:Lco/vine/android/RevineCache;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 213
    return-void
.end method

.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 116
    invoke-super {p0, p1, p2, p3, p4}, Lco/vine/android/BaseArrayListFragment;->onScroll(Landroid/widget/AbsListView;III)V

    .line 117
    return-void
.end method

.method protected onScrollLastItem()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 373
    iget-boolean v0, p0, Lco/vine/android/BaseTimelineFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 374
    iget v0, p0, Lco/vine/android/BaseTimelineFragment;->mNextPage:I

    if-lez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->getCount()I

    move-result v0

    const/16 v1, 0x190

    if-gt v0, v1, :cond_0

    .line 375
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->isFocused()Z

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onPause(Z)V

    .line 376
    invoke-virtual {p0, v2, v2}, Lco/vine/android/BaseTimelineFragment;->fetchContent(IZ)V

    .line 377
    invoke-virtual {p0, v2}, Lco/vine/android/BaseTimelineFragment;->showProgress(I)V

    .line 378
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    iget v1, p0, Lco/vine/android/BaseTimelineFragment;->mNextPage:I

    invoke-static {v0, v1}, Lco/vine/android/util/FlurryUtils;->trackTimeLinePageScroll(Ljava/lang/String;I)V

    .line 381
    :cond_0
    return-void
.end method

.method public declared-synchronized onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 1
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 353
    monitor-enter p0

    :try_start_0
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseArrayListFragment;->onScrollStateChanged(Landroid/widget/AbsListView;I)V

    .line 354
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/widget/GenericTimelineAdapter;->onScrollStateChanged(Landroid/widget/AbsListView;I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 355
    monitor-exit p0

    return-void

    .line 353
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onSpanClicked(Landroid/view/View;ILjava/lang/Object;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/Object;

    .prologue
    .line 274
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mVineSpanClicker:Lco/vine/android/VineSpanClicker;

    invoke-virtual {v0, p1, p2, p3}, Lco/vine/android/VineSpanClicker;->onSpanClicked(Landroid/view/View;ILjava/lang/Object;)V

    .line 275
    return-void
.end method

.method protected populateClientFlagsBanner(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;

    .prologue
    .line 404
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 405
    const v0, 0x7f0a008d

    invoke-virtual {p0, v0, p1}, Lco/vine/android/BaseTimelineFragment;->setBannerText(ILjava/lang/String;)V

    .line 407
    :cond_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 408
    const v0, 0x7f0a0093

    invoke-virtual {p0, v0, p2}, Lco/vine/android/BaseTimelineFragment;->setBannerText(ILjava/lang/String;)V

    .line 410
    :cond_1
    return-void
.end method

.method protected refresh()V
    .locals 2

    .prologue
    const/4 v1, 0x2

    .line 264
    invoke-virtual {p0, v1}, Lco/vine/android/BaseTimelineFragment;->hideProgress(I)V

    .line 265
    const/4 v0, 0x1

    invoke-virtual {p0, v1, v0}, Lco/vine/android/BaseTimelineFragment;->fetchContent(IZ)V

    .line 266
    return-void
.end method

.method protected refreshSilently()V
    .locals 2

    .prologue
    const/4 v1, 0x2

    .line 269
    invoke-virtual {p0, v1}, Lco/vine/android/BaseTimelineFragment;->hideProgress(I)V

    .line 270
    const/4 v0, 0x0

    invoke-virtual {p0, v1, v0}, Lco/vine/android/BaseTimelineFragment;->fetchContent(IZ)V

    .line 271
    return-void
.end method

.method public registerMergePostReceiver()V
    .locals 5

    .prologue
    .line 91
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/BaseTimelineFragment;->mMergePostReceiverRegistered:Z

    .line 92
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment;->mMergePostReceiver:Landroid/content/BroadcastReceiver;

    sget-object v2, Lco/vine/android/service/VineService;->SHOW_POST_FILTER:Landroid/content/IntentFilter;

    const-string v3, "co.vine.android.BROADCAST"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 93
    return-void
.end method

.method protected setBannerText(ILjava/lang/String;)V
    .locals 1
    .param p1, "id"    # I
    .param p2, "s"    # Ljava/lang/String;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 413
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mClientFlagsBannerParent:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 414
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mClientFlagsBannerParent:Landroid/view/ViewGroup;

    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 416
    :cond_0
    return-void
.end method

.method protected setFlurryEventSource(Ljava/lang/String;)V
    .locals 1
    .param p1, "source"    # Ljava/lang/String;

    .prologue
    .line 159
    iput-object p1, p0, Lco/vine/android/BaseTimelineFragment;->mFlurryEventSource:Ljava/lang/String;

    .line 160
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mVineSpanClicker:Lco/vine/android/VineSpanClicker;

    invoke-virtual {v0, p1}, Lco/vine/android/VineSpanClicker;->setFlurryEventSource(Ljava/lang/String;)V

    .line 161
    return-void
.end method

.method public setUpUnderNavHeader()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 194
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f03009d

    invoke-virtual {v1, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 195
    .local v0, "header":Landroid/view/View;
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment;->mListView:Landroid/widget/ListView;

    check-cast v1, Lco/vine/android/widget/PinnedHeaderListView;

    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0b0084

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    invoke-virtual {v1, v0, v2}, Lco/vine/android/widget/PinnedHeaderListView;->setRefreshHeader(Landroid/view/View;I)V

    .line 196
    const/4 v1, 0x0

    invoke-virtual {p0, v0, v4, v1}, Lco/vine/android/BaseTimelineFragment;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 197
    return-void
.end method

.method protected showClientFlagsBanner()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 384
    iget-object v5, p0, Lco/vine/android/BaseTimelineFragment;->mClientFlagsBannerParent:Landroid/view/ViewGroup;

    if-nez v5, :cond_0

    .line 385
    iget-object v3, p0, Lco/vine/android/BaseTimelineFragment;->mListView:Landroid/widget/ListView;

    .line 386
    .local v3, "listView":Landroid/widget/ListView;
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    const v6, 0x7f0300ab

    invoke-virtual {v5, v6, v3, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 389
    .local v0, "bannerParent":Landroid/widget/RelativeLayout;
    const v5, 0x7f0a0239

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 390
    .local v1, "clearButton":Landroid/widget/ImageButton;
    invoke-virtual {p0}, Lco/vine/android/BaseTimelineFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f090027

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v1, v5}, Landroid/widget/ImageButton;->setColorFilter(I)V

    .line 391
    invoke-virtual {v1, p0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 393
    invoke-virtual {v3, v0}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 394
    iput-object v0, p0, Lco/vine/android/BaseTimelineFragment;->mClientFlagsBannerParent:Landroid/view/ViewGroup;

    .line 397
    .end local v0    # "bannerParent":Landroid/widget/RelativeLayout;
    .end local v1    # "clearButton":Landroid/widget/ImageButton;
    .end local v3    # "listView":Landroid/widget/ListView;
    :cond_0
    iget-object v5, p0, Lco/vine/android/BaseTimelineFragment;->mClientFlagsBannerParent:Landroid/view/ViewGroup;

    const v6, 0x7f0a0237

    invoke-virtual {v5, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 398
    .local v2, "container":Landroid/view/ViewGroup;
    invoke-virtual {v2}, Landroid/view/ViewGroup;->getVisibility()I

    move-result v4

    .line 399
    .local v4, "visibility":I
    invoke-virtual {v2, v7}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 400
    if-eqz v4, :cond_1

    iget-object v5, p0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v5}, Lco/vine/android/widget/GenericTimelineAdapter;->notifyDataSetChanged()V

    .line 401
    :cond_1
    return-void
.end method

.method protected trackNewCount()Z
    .locals 1

    .prologue
    .line 368
    const/4 v0, 0x0

    return v0
.end method
