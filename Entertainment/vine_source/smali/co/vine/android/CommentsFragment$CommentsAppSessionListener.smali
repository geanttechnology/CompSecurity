.class Lco/vine/android/CommentsFragment$CommentsAppSessionListener;
.super Lco/vine/android/client/AppSessionListener;
.source "CommentsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/CommentsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "CommentsAppSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/CommentsFragment;


# direct methods
.method constructor <init>(Lco/vine/android/CommentsFragment;)V
    .locals 0

    .prologue
    .line 484
    iput-object p1, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onCaptchaRequired(Ljava/lang/String;Ljava/lang/String;Lco/vine/android/service/PendingAction;)V
    .locals 7
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "captchaUrl"    # Ljava/lang/String;
    .param p3, "action"    # Lco/vine/android/service/PendingAction;

    .prologue
    .line 589
    iget-object v0, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/CommentsFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v6

    .line 590
    .local v6, "req":Lco/vine/android/PendingRequest;
    if-eqz v6, :cond_0

    .line 591
    iget-object v0, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v0, v0, Lco/vine/android/CommentsFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    iget-object v1, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    invoke-virtual {v1}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget v3, p3, Lco/vine/android/service/PendingAction;->actionCode:I

    iget-object v4, p3, Lco/vine/android/service/PendingAction;->bundle:Landroid/os/Bundle;

    move-object v2, p1

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/PendingRequestHelper;->onCaptchaRequired(Landroid/support/v4/app/FragmentActivity;Ljava/lang/String;ILandroid/os/Bundle;Ljava/lang/String;)V

    .line 593
    :cond_0
    return-void
.end method

.method public onDeleteCommentComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 4
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "commentId"    # J

    .prologue
    .line 553
    iget-object v1, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/CommentsFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 554
    .local v0, "request":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 555
    const/16 v1, 0xc8

    if-ne p2, v1, :cond_0

    .line 556
    iget-object v1, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v1, v1, Lco/vine/android/CommentsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v1, Lco/vine/android/CommentsAdapter;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/CommentsAdapter;->deleteComment(J)V

    .line 557
    iget-object v1, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v1, v1, Lco/vine/android/CommentsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v1}, Landroid/widget/BaseAdapter;->getCount()I

    move-result v1

    if-nez v1, :cond_0

    .line 558
    iget-object v1, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lco/vine/android/CommentsFragment;->showSadface(ZZ)V

    .line 562
    :cond_0
    return-void
.end method

.method public onGetCommentsComplete(Ljava/lang/String;ILjava/lang/String;IJLjava/util/ArrayList;)V
    .locals 7
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
    .local p7, "comments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineComment;>;"
    const/4 v5, 0x0

    const/16 v6, 0xc8

    .line 489
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    invoke-virtual {v3, p1}, Lco/vine/android/CommentsFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v2

    .line 490
    .local v2, "req":Lco/vine/android/PendingRequest;
    if-eqz v2, :cond_5

    .line 491
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    const/4 v4, 0x3

    invoke-virtual {v3, v4}, Lco/vine/android/CommentsFragment;->hideProgress(I)V

    .line 492
    if-eqz p7, :cond_0

    invoke-virtual {p7}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-nez v3, :cond_6

    .line 493
    :cond_0
    if-eq p2, v6, :cond_1

    .line 494
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v3, v3, Lco/vine/android/CommentsFragment;->mEmptyText:Landroid/widget/TextView;

    const v4, 0x7f0e00d9

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(I)V

    .line 496
    :cond_1
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    const/4 v4, 0x1

    invoke-virtual {v3, v4, v5}, Lco/vine/android/CommentsFragment;->showSadface(ZZ)V

    .line 501
    :goto_0
    if-ne p2, v6, :cond_2

    .line 502
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # setter for: Lco/vine/android/CommentsFragment;->mNextPage:I
    invoke-static {v3, p4}, Lco/vine/android/CommentsFragment;->access$402(Lco/vine/android/CommentsFragment;I)I

    .line 503
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # setter for: Lco/vine/android/CommentsFragment;->mAnchor:J
    invoke-static {v3, p5, p6}, Lco/vine/android/CommentsFragment;->access$502(Lco/vine/android/CommentsFragment;J)J

    .line 505
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # invokes: Lco/vine/android/CommentsFragment;->saveTopItemInfo()V
    invoke-static {v3}, Lco/vine/android/CommentsFragment;->access$600(Lco/vine/android/CommentsFragment;)V

    .line 506
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v0, v3, Lco/vine/android/CommentsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v0, Lco/vine/android/CommentsAdapter;

    .line 507
    .local v0, "adapter":Lco/vine/android/CommentsAdapter;
    invoke-virtual {v0, p7}, Lco/vine/android/CommentsAdapter;->mergeComments(Ljava/util/ArrayList;)V

    .line 509
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mLastTopItemId:J
    invoke-static {v3}, Lco/vine/android/CommentsFragment;->access$700(Lco/vine/android/CommentsFragment;)J

    move-result-wide v3

    invoke-virtual {v0, v3, v4}, Lco/vine/android/CommentsAdapter;->getPositionForId(J)I

    move-result v1

    .line 510
    .local v1, "pos":I
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v3, v3, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    iget-object v4, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v4, v4, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v4}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v4

    add-int/2addr v4, v1

    iget-object v5, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mLastTopItemPixelOffset:I
    invoke-static {v5}, Lco/vine/android/CommentsFragment;->access$800(Lco/vine/android/CommentsFragment;)I

    move-result v5

    invoke-virtual {v3, v4, v5}, Landroid/widget/ListView;->setSelectionFromTop(II)V

    .line 513
    .end local v0    # "adapter":Lco/vine/android/CommentsAdapter;
    .end local v1    # "pos":I
    :cond_2
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mFetched:Z
    invoke-static {v3}, Lco/vine/android/CommentsFragment;->access$900(Lco/vine/android/CommentsFragment;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mNextPage:I
    invoke-static {v3}, Lco/vine/android/CommentsFragment;->access$400(Lco/vine/android/CommentsFragment;)I

    move-result v3

    if-lez v3, :cond_3

    if-eqz p7, :cond_3

    invoke-virtual {p7}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-nez v3, :cond_4

    .line 514
    :cond_3
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v3, v3, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    check-cast v3, Lco/vine/android/widget/ConversationList;

    invoke-virtual {v3}, Lco/vine/android/widget/ConversationList;->deactivateRefresh()V

    .line 517
    :cond_4
    if-eq p2, v6, :cond_5

    .line 518
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v3, v3, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    check-cast v3, Lco/vine/android/widget/ConversationList;

    invoke-virtual {v3}, Lco/vine/android/widget/ConversationList;->deactivateRefresh()V

    .line 521
    :cond_5
    return-void

    .line 498
    :cond_6
    iget-object v3, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    invoke-virtual {v3, v5}, Lco/vine/android/CommentsFragment;->showSadface(Z)V

    goto :goto_0
.end method

.method public onGetTagTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineTag;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 578
    .local p5, "tags":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineTag;>;"
    iget-object v0, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/CommentsFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    if-eqz v0, :cond_0

    const/16 v0, 0xc8

    if-ne p2, v0, :cond_0

    .line 579
    invoke-virtual {p5}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 580
    invoke-static {p4, p5}, Lco/vine/android/provider/VineSuggestionsProvider;->addRealtimeTagSuggestions(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 581
    iget-object v0, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;
    invoke-static {v0}, Lco/vine/android/CommentsFragment;->access$1100(Lco/vine/android/CommentsFragment;)Lco/vine/android/widget/PopupEditText;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/PopupEditText;->performFilter(Z)V

    .line 584
    :cond_0
    return-void
.end method

.method public onGetUserTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 567
    .local p5, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    iget-object v0, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/CommentsFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    if-eqz v0, :cond_0

    const/16 v0, 0xc8

    if-ne p2, v0, :cond_0

    .line 568
    invoke-virtual {p5}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 569
    invoke-static {p4, p5}, Lco/vine/android/provider/VineSuggestionsProvider;->addRealtimeUserSuggestions(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 570
    iget-object v0, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;
    invoke-static {v0}, Lco/vine/android/CommentsFragment;->access$1100(Lco/vine/android/CommentsFragment;)Lco/vine/android/widget/PopupEditText;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/PopupEditText;->performFilter(Z)V

    .line 573
    :cond_0
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
    .line 525
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    invoke-super {p0, p1}, Lco/vine/android/client/AppSessionListener;->onPhotoImageLoaded(Ljava/util/HashMap;)V

    .line 526
    iget-object v0, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v0, v0, Lco/vine/android/CommentsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v0, Lco/vine/android/CommentsAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/CommentsAdapter;->updateProfileImages(Ljava/util/HashMap;)V

    .line 527
    iget-object v0, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mUsersAdapter:Lco/vine/android/UsersAutoCompleteAdapter;
    invoke-static {v0}, Lco/vine/android/CommentsFragment;->access$1000(Lco/vine/android/CommentsFragment;)Lco/vine/android/UsersAutoCompleteAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/UsersAutoCompleteAdapter;->setUserImages(Ljava/util/HashMap;)V

    .line 528
    return-void
.end method

.method public onPostCommentComplete(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Lco/vine/android/api/VineComment;)V
    .locals 4
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "postId"    # J
    .param p6, "comment"    # Ljava/lang/String;
    .param p7, "commentToMerge"    # Lco/vine/android/api/VineComment;

    .prologue
    .line 533
    iget-object v2, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    invoke-virtual {v2}, Lco/vine/android/CommentsFragment;->dismissDialog()V

    .line 534
    iget-object v2, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    invoke-virtual {v2, p1}, Lco/vine/android/CommentsFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v1

    .line 535
    .local v1, "req":Lco/vine/android/PendingRequest;
    if-eqz v1, :cond_0

    iget-object v2, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mPostId:J
    invoke-static {v2}, Lco/vine/android/CommentsFragment;->access$000(Lco/vine/android/CommentsFragment;)J

    move-result-wide v2

    cmp-long v2, p4, v2

    if-nez v2, :cond_0

    .line 536
    iget-object v2, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v0, v2, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    .line 537
    .local v0, "listView":Landroid/widget/ListView;
    new-instance v2, Lco/vine/android/CommentsFragment$CommentsAppSessionListener$1;

    invoke-direct {v2, p0, v0}, Lco/vine/android/CommentsFragment$CommentsAppSessionListener$1;-><init>(Lco/vine/android/CommentsFragment$CommentsAppSessionListener;Landroid/widget/ListView;)V

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->post(Ljava/lang/Runnable;)Z

    .line 542
    const/16 v2, 0xc8

    if-eq p2, v2, :cond_1

    .line 543
    iget-object v2, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;
    invoke-static {v2}, Lco/vine/android/CommentsFragment;->access$1100(Lco/vine/android/CommentsFragment;)Lco/vine/android/widget/PopupEditText;

    move-result-object v2

    invoke-virtual {v2, p6}, Lco/vine/android/widget/PopupEditText;->setText(Ljava/lang/CharSequence;)V

    .line 549
    .end local v0    # "listView":Landroid/widget/ListView;
    :cond_0
    :goto_0
    return-void

    .line 545
    .restart local v0    # "listView":Landroid/widget/ListView;
    :cond_1
    iget-object v2, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v2, v2, Lco/vine/android/CommentsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v2, Lco/vine/android/CommentsAdapter;

    invoke-virtual {v2, p7}, Lco/vine/android/CommentsAdapter;->addMyComment(Lco/vine/android/api/VineComment;)V

    .line 546
    iget-object v2, p0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;->this$0:Lco/vine/android/CommentsFragment;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lco/vine/android/CommentsFragment;->showSadface(Z)V

    goto :goto_0
.end method
