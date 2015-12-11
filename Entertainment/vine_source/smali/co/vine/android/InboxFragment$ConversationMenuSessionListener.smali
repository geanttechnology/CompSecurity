.class public Lco/vine/android/InboxFragment$ConversationMenuSessionListener;
.super Lco/vine/android/client/AppSessionListener;
.source "InboxFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/InboxFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ConversationMenuSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/InboxFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/InboxFragment;)V
    .locals 0

    .prologue
    .line 651
    iput-object p1, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onGetConversationRowIdComplete(JJLjava/lang/String;Z)V
    .locals 9
    .param p1, "recipientId"    # J
    .param p3, "conversationObjectId"    # J
    .param p5, "username"    # Ljava/lang/String;
    .param p6, "amFollowing"    # Z

    .prologue
    .line 678
    iget-object v0, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    iget-wide v0, v0, Lco/vine/android/InboxFragment;->mWaitingToStartId:J

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    .line 679
    iget-object v0, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    const-wide/16 v1, -0x1

    iput-wide v1, v0, Lco/vine/android/InboxFragment;->mWaitingToStartId:J

    .line 680
    iget-object v0, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    iget-object v0, v0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0, p3, p4}, Lco/vine/android/client/AppController;->clearUnreadMessageCount(J)V

    .line 681
    iget-object v8, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    iget-object v0, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    invoke-virtual {v0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v7, 0x0

    move-wide v1, p3

    move-object v3, p5

    move-wide v4, p1

    move v6, p6

    invoke-static/range {v0 .. v7}, Lco/vine/android/ConversationActivity;->getIntent(Landroid/content/Context;JLjava/lang/String;JZZ)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v8, v0}, Lco/vine/android/InboxFragment;->startActivity(Landroid/content/Intent;)V

    .line 684
    :cond_0
    return-void
.end method

.method public onGetMessageInboxComplete(Ljava/lang/String;ILjava/lang/String;I)V
    .locals 4
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "count"    # I

    .prologue
    const/4 v3, 0x3

    .line 655
    iget-object v1, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/InboxFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 656
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_1

    .line 657
    iget-object v1, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    const/4 v2, 0x0

    # setter for: Lco/vine/android/InboxFragment;->mLoadingMore:Z
    invoke-static {v1, v2}, Lco/vine/android/InboxFragment;->access$1402(Lco/vine/android/InboxFragment;Z)Z

    .line 658
    iget-object v1, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    iget v2, v0, Lco/vine/android/PendingRequest;->fetchType:I

    invoke-virtual {v1, v2}, Lco/vine/android/InboxFragment;->hideProgress(I)V

    .line 659
    iget-object v1, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    invoke-virtual {v1, p4}, Lco/vine/android/InboxFragment;->onGetMessageInboxComplete(I)V

    .line 660
    packed-switch p2, :pswitch_data_0

    .line 665
    iget-object v1, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    invoke-virtual {v1, v3}, Lco/vine/android/InboxFragment;->hideProgress(I)V

    .line 666
    iget v1, v0, Lco/vine/android/PendingRequest;->fetchType:I

    if-eq v1, v3, :cond_0

    .line 667
    iget-object v1, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    invoke-virtual {v1}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f0e00cb

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 669
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Error "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 673
    :cond_1
    :pswitch_0
    return-void

    .line 660
    :pswitch_data_0
    .packed-switch 0xc8
        :pswitch_0
    .end packed-switch
.end method

.method public onGetUsersComplete(Lco/vine/android/client/Session;Ljava/lang/String;ILjava/lang/String;ILjava/util/ArrayList;IIJ)V
    .locals 3
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "reqId"    # Ljava/lang/String;
    .param p3, "statusCode"    # I
    .param p4, "reasonPhrase"    # Ljava/lang/String;
    .param p5, "count"    # I
    .param p7, "nextPage"    # I
    .param p8, "previousPage"    # I
    .param p9, "anchor"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/client/Session;",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;IIJ)V"
        }
    .end annotation

    .prologue
    .line 695
    .local p6, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    iget-object v1, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    invoke-virtual {v1, p2}, Lco/vine/android/InboxFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 696
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 697
    iget-object v1, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    iget v2, v0, Lco/vine/android/PendingRequest;->fetchType:I

    invoke-virtual {v1, v2}, Lco/vine/android/InboxFragment;->hideProgress(I)V

    .line 698
    packed-switch p3, :pswitch_data_0

    .line 703
    iget-object v1, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Lco/vine/android/InboxFragment;->hideProgress(I)V

    .line 704
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Error:  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 709
    :cond_0
    :pswitch_0
    return-void

    .line 698
    nop

    :pswitch_data_0
    .packed-switch 0xc8
        :pswitch_0
    .end packed-switch
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
    .line 688
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v0, p0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;->this$0:Lco/vine/android/InboxFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/InboxFragment;->onPhotoImageLoaded(Ljava/util/HashMap;)V

    .line 689
    return-void
.end method
