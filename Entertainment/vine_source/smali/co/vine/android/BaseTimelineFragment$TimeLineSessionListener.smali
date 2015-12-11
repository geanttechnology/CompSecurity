.class Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;
.super Lco/vine/android/client/AppSessionListener;
.source "BaseTimelineFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/BaseTimelineFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "TimeLineSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/BaseTimelineFragment;


# direct methods
.method constructor <init>(Lco/vine/android/BaseTimelineFragment;)V
    .locals 0

    .prologue
    .line 424
    iput-object p1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAbortAllRequestsComplete()V
    .locals 1

    .prologue
    .line 624
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v0}, Lco/vine/android/BaseTimelineFragment;->refreshSilently()V

    .line 625
    return-void
.end method

.method public onCaptchaRequired(Ljava/lang/String;Ljava/lang/String;Lco/vine/android/service/PendingAction;)V
    .locals 7
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "captchaUrl"    # Ljava/lang/String;
    .param p3, "action"    # Lco/vine/android/service/PendingAction;

    .prologue
    .line 591
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/BaseTimelineFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v6

    .line 592
    .local v6, "req":Lco/vine/android/PendingRequest;
    if-eqz v6, :cond_0

    .line 593
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v0, v0, Lco/vine/android/BaseTimelineFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v1}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget v3, p3, Lco/vine/android/service/PendingAction;->actionCode:I

    iget-object v4, p3, Lco/vine/android/service/PendingAction;->bundle:Landroid/os/Bundle;

    move-object v2, p1

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/PendingRequestHelper;->onCaptchaRequired(Landroid/support/v4/app/FragmentActivity;Ljava/lang/String;ILandroid/os/Bundle;Ljava/lang/String;)V

    .line 595
    :cond_0
    return-void
.end method

.method public onDeletePostComplete(Ljava/lang/String;JILjava/lang/String;)V
    .locals 3
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "postId"    # J
    .param p4, "statusCode"    # I
    .param p5, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 528
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/BaseTimelineFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 529
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 530
    const/16 v1, 0xc8

    if-ne p4, v1, :cond_1

    .line 531
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v1}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f0e0179

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 536
    :cond_0
    :goto_0
    return-void

    .line 533
    :cond_1
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v1}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f0e017a

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0
.end method

.method public onFetchClientFlagsComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineClientFlags;Z)V
    .locals 3
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "clientFlags"    # Lco/vine/android/api/VineClientFlags;
    .param p5, "showBanner"    # Z

    .prologue
    .line 601
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_0

    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v0}, Lco/vine/android/BaseTimelineFragment;->isFocused()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-boolean v0, v0, Lco/vine/android/BaseTimelineFragment;->mClientFlagsBannerWasDismissed:Z

    if-nez v0, :cond_0

    .line 602
    if-eqz p5, :cond_1

    .line 603
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v0}, Lco/vine/android/BaseTimelineFragment;->showClientFlagsBanner()V

    .line 604
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, p4, Lco/vine/android/api/VineClientFlags;->messageTitle:Ljava/lang/String;

    iget-object v2, p4, Lco/vine/android/api/VineClientFlags;->messageText:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lco/vine/android/BaseTimelineFragment;->populateClientFlagsBanner(Ljava/lang/String;Ljava/lang/String;)V

    .line 609
    :cond_0
    :goto_0
    return-void

    .line 606
    :cond_1
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    # invokes: Lco/vine/android/BaseTimelineFragment;->hideClientFlagsBanner()V
    invoke-static {v0}, Lco/vine/android/BaseTimelineFragment;->access$100(Lco/vine/android/BaseTimelineFragment;)V

    goto :goto_0
.end method

.method public onGetCommentsComplete(Ljava/lang/String;ILjava/lang/String;IJLjava/util/ArrayList;)V
    .locals 0
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "nextPage"    # I
    .param p5, "anchor"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "IJ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineComment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 492
    .local p7, "comments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineComment;>;"
    invoke-super/range {p0 .. p7}, Lco/vine/android/client/AppSessionListener;->onGetCommentsComplete(Ljava/lang/String;ILjava/lang/String;IJLjava/util/ArrayList;)V

    .line 493
    return-void
.end method

.method public onGetTimeLineComplete(Ljava/lang/String;ILjava/lang/String;IIZLjava/util/ArrayList;Ljava/lang/String;IIIJZILjava/lang/String;)V
    .locals 13
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "type"    # I
    .param p5, "count"    # I
    .param p6, "memory"    # Z
    .param p8, "tag"    # Ljava/lang/String;
    .param p9, "pageType"    # I
    .param p10, "next"    # I
    .param p11, "previous"    # I
    .param p12, "anchor"    # J
    .param p14, "userInitiated"    # Z
    .param p15, "size"    # I
    .param p16, "title"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "IIZ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;",
            "Ljava/lang/String;",
            "IIIJZI",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 452
    .local p7, "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v2, p1}, Lco/vine/android/BaseTimelineFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v12

    .line 453
    .local v12, "req":Lco/vine/android/PendingRequest;
    if-eqz v12, :cond_2

    .line 454
    if-eqz p6, :cond_1

    const/16 v2, 0xc8

    if-ne p2, v2, :cond_1

    .line 455
    sget-boolean v2, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v2, v2, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v2}, Lco/vine/android/widget/GenericTimelineAdapter;->getStartLoadingTime()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    .line 456
    const-string v2, "Time since started loading to end fetch: {}ms"

    iget-object v3, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v3, v3, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v3}, Lco/vine/android/widget/GenericTimelineAdapter;->timeSinceStartLoadingTime()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 460
    :cond_0
    if-eqz p7, :cond_1

    .line 461
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    move/from16 v0, p10

    iput v0, v2, Lco/vine/android/BaseTimelineFragment;->mNextPage:I

    .line 462
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    move-wide/from16 v0, p12

    iput-wide v0, v2, Lco/vine/android/BaseTimelineFragment;->mAnchor:J

    .line 463
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v2, v2, Lco/vine/android/BaseTimelineFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v2, Lco/vine/android/widget/FeedAdapter;

    iget v3, v12, Lco/vine/android/PendingRequest;->fetchType:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_4

    const/4 v3, 0x1

    :goto_0
    move-object/from16 v0, p7

    invoke-virtual {v2, v0, v3}, Lco/vine/android/widget/FeedAdapter;->mergePosts(Ljava/util/ArrayList;Z)V

    .line 464
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v2, v2, Lco/vine/android/BaseTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    const/4 v11, 0x0

    move-object/from16 v3, p7

    move/from16 v4, p4

    move-object/from16 v5, p8

    move/from16 v6, p9

    move/from16 v7, p10

    move/from16 v8, p11

    move-wide/from16 v9, p12

    invoke-virtual/range {v2 .. v11}, Lco/vine/android/client/AppController;->saveLoadedPosts(Ljava/util/ArrayList;ILjava/lang/String;IIIJZ)Ljava/lang/String;

    .line 468
    :cond_1
    iget v2, v12, Lco/vine/android/PendingRequest;->fetchType:I

    packed-switch v2, :pswitch_data_0

    .line 479
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget v3, v12, Lco/vine/android/PendingRequest;->fetchType:I

    invoke-virtual {v2, v3}, Lco/vine/android/BaseTimelineFragment;->hideProgress(I)V

    .line 484
    :cond_2
    :goto_1
    invoke-static/range {p16 .. p16}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    # getter for: Lco/vine/android/BaseTimelineFragment;->mCallback:Landroid/support/v7/app/ActionBarActivity;
    invoke-static {v2}, Lco/vine/android/BaseTimelineFragment;->access$000(Lco/vine/android/BaseTimelineFragment;)Landroid/support/v7/app/ActionBarActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v7/app/ActionBarActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 485
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    # getter for: Lco/vine/android/BaseTimelineFragment;->mCallback:Landroid/support/v7/app/ActionBarActivity;
    invoke-static {v2}, Lco/vine/android/BaseTimelineFragment;->access$000(Lco/vine/android/BaseTimelineFragment;)Landroid/support/v7/app/ActionBarActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v7/app/ActionBarActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v2

    move-object/from16 v0, p16

    invoke-virtual {v2, v0}, Landroid/support/v7/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 487
    :cond_3
    return-void

    .line 463
    :cond_4
    const/4 v3, 0x0

    goto :goto_0

    .line 470
    :pswitch_0
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v2, v2, Lco/vine/android/BaseTimelineFragment;->mAdapter:Landroid/widget/BaseAdapter;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v2, v2, Lco/vine/android/BaseTimelineFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v2}, Landroid/widget/BaseAdapter;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_5

    if-nez p5, :cond_5

    .line 471
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget v3, v12, Lco/vine/android/PendingRequest;->fetchType:I

    invoke-virtual {v2, v3}, Lco/vine/android/BaseTimelineFragment;->hideProgress(I)V

    .line 472
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lco/vine/android/BaseTimelineFragment;->showSadface(Z)V

    goto :goto_1

    .line 474
    :cond_5
    iget-object v2, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lco/vine/android/BaseTimelineFragment;->showSadface(Z)V

    goto :goto_1

    .line 468
    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
.end method

.method public onLikePost(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 540
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/BaseTimelineFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 541
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 542
    const/16 v1, 0xc8

    if-eq p2, v1, :cond_0

    .line 543
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mLikeCache:Lco/vine/android/LikeCache;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/LikeCache;->removeEntry(J)V

    .line 544
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/widget/GenericTimelineAdapter;->showUnlikedByMe(J)V

    .line 545
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v1}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 548
    :cond_0
    return-void
.end method

.method public onLowMemory()V
    .locals 2

    .prologue
    .line 506
    invoke-super {p0}, Lco/vine/android/client/AppSessionListener;->onLowMemory()V

    .line 507
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v0, v1, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    .line 508
    .local v0, "adapter":Lco/vine/android/widget/GenericTimelineAdapter;
    if-eqz v0, :cond_0

    .line 509
    invoke-virtual {v0}, Lco/vine/android/widget/GenericTimelineAdapter;->onLowMemory()V

    .line 511
    :cond_0
    return-void
.end method

.method public onMobileDataNetworkActivated()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 613
    iget-object v3, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v3}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/ClientFlagsHelper;->shouldShowClientFlagsBanner(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v3}, Lco/vine/android/BaseTimelineFragment;->isFocused()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 614
    iget-object v3, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v3}, Lco/vine/android/BaseTimelineFragment;->showClientFlagsBanner()V

    .line 615
    iget-object v3, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v3}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 616
    .local v0, "prefs":Landroid/content/SharedPreferences;
    const-string v3, "client_flags_message_title"

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 617
    .local v2, "title":Ljava/lang/String;
    const-string v3, "client_flags_message_text"

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 618
    .local v1, "text":Ljava/lang/String;
    iget-object v3, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v3, v2, v1}, Lco/vine/android/BaseTimelineFragment;->populateClientFlagsBanner(Ljava/lang/String;Ljava/lang/String;)V

    .line 620
    .end local v0    # "prefs":Landroid/content/SharedPreferences;
    .end local v1    # "text":Ljava/lang/String;
    .end local v2    # "title":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public onPhotoImageError(Lco/vine/android/util/image/ImageKey;Lco/vine/android/network/HttpResult;)V
    .locals 2
    .param p1, "key"    # Lco/vine/android/util/image/ImageKey;
    .param p2, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 438
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Download of image failed: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p2, Lco/vine/android/network/HttpResult;->reasonPhrase:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " key: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p1, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 439
    return-void
.end method

.method public onPhotoImageLoaded(Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 443
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v0, v0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/widget/GenericTimelineAdapter;->setImages(Ljava/util/HashMap;)V

    .line 444
    return-void
.end method

.method public onReportPostComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 3
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 516
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/BaseTimelineFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 517
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 518
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_1

    .line 519
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v1}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f0e017e

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 524
    :cond_0
    :goto_0
    return-void

    .line 521
    :cond_1
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v1}, Lco/vine/android/BaseTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f0e017f

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0
.end method

.method public onRevine(Ljava/lang/String;ILjava/lang/String;JLco/vine/android/api/VineRepost;)V
    .locals 4
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J
    .param p6, "repost"    # Lco/vine/android/api/VineRepost;

    .prologue
    .line 565
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/BaseTimelineFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 566
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 567
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_0

    .line 568
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mRevineCache:Lco/vine/android/RevineCache;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/RevineCache;->revine(J)V

    .line 569
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mRevineCache:Lco/vine/android/RevineCache;

    iget-wide v2, p6, Lco/vine/android/api/VineRepost;->repostId:J

    invoke-virtual {v1, p4, p5, v2, v3}, Lco/vine/android/RevineCache;->putMyRepostId(JJ)V

    .line 570
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v1}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 571
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    const/4 v2, 0x1

    invoke-virtual {v1, p4, p5, v2}, Lco/vine/android/widget/GenericTimelineAdapter;->updateRevinedCount(JZ)V

    .line 574
    :cond_0
    return-void
.end method

.method public onTrimMemory(I)V
    .locals 2
    .param p1, "level"    # I

    .prologue
    .line 497
    invoke-super {p0, p1}, Lco/vine/android/client/AppSessionListener;->onTrimMemory(I)V

    .line 498
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v0, v1, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    .line 499
    .local v0, "adapter":Lco/vine/android/widget/GenericTimelineAdapter;
    if-eqz v0, :cond_0

    .line 500
    invoke-virtual {v0, p1}, Lco/vine/android/widget/GenericTimelineAdapter;->onTrimMemory(I)V

    .line 502
    :cond_0
    return-void
.end method

.method public onUnlikePost(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 552
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/BaseTimelineFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 553
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 554
    const/16 v1, 0xc8

    if-eq p2, v1, :cond_0

    .line 555
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mLikeCache:Lco/vine/android/LikeCache;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/LikeCache;->like(J)V

    .line 556
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/widget/GenericTimelineAdapter;->showLikedByMe(J)V

    .line 557
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v1}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 560
    :cond_0
    return-void
.end method

.method public onUnrevine(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 3
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J

    .prologue
    .line 578
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/BaseTimelineFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 579
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 580
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_0

    .line 581
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mRevineCache:Lco/vine/android/RevineCache;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/RevineCache;->unRevine(J)V

    .line 582
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mRevineCache:Lco/vine/android/RevineCache;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/RevineCache;->removeMyRepostId(J)V

    .line 583
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v1}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 584
    iget-object v1, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v1, v1, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    const/4 v2, 0x0

    invoke-virtual {v1, p4, p5, v2}, Lco/vine/android/widget/GenericTimelineAdapter;->updateRevinedCount(JZ)V

    .line 587
    :cond_0
    return-void
.end method

.method public onVideoPathError(Lco/vine/android/util/video/VideoKey;Lco/vine/android/network/HttpResult;)V
    .locals 2
    .param p1, "key"    # Lco/vine/android/util/video/VideoKey;
    .param p2, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 433
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Download of video failed: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p2, Lco/vine/android/network/HttpResult;->reasonPhrase:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " key: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p1, Lco/vine/android/util/video/VideoKey;->url:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 434
    return-void
.end method

.method public onVideoPathObtained(Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/video/VideoKey;",
            "Lco/vine/android/util/video/UrlVideo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 428
    .local p1, "videos":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/video/VideoKey;Lco/vine/android/util/video/UrlVideo;>;"
    iget-object v0, p0, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->this$0:Lco/vine/android/BaseTimelineFragment;

    iget-object v0, v0, Lco/vine/android/BaseTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/widget/GenericTimelineAdapter;->onVideoPathObtained(Ljava/util/HashMap;)V

    .line 429
    return-void
.end method
