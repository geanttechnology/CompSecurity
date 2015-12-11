.class public Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;
.super Lco/vine/android/client/AppSessionListener;
.source "ConversationMenuHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/ConversationMenuHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ConversationMenuHelperAppSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/util/ConversationMenuHelper;


# direct methods
.method public constructor <init>(Lco/vine/android/util/ConversationMenuHelper;)V
    .locals 0

    .prologue
    .line 363
    iput-object p1, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

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
    const/4 v7, 0x0

    .line 368
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mWaitingToStartUserId:J
    invoke-static {v0}, Lco/vine/android/util/ConversationMenuHelper;->access$600(Lco/vine/android/util/ConversationMenuHelper;)J

    move-result-wide v0

    cmp-long v0, p1, v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mWaitingToStartSearchUserId:J
    invoke-static {v0}, Lco/vine/android/util/ConversationMenuHelper;->access$700(Lco/vine/android/util/ConversationMenuHelper;)J

    move-result-wide v0

    cmp-long v0, p1, v0

    if-nez v0, :cond_2

    .line 369
    :cond_0
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mWaitingToStartSearchUserId:J
    invoke-static {v0}, Lco/vine/android/util/ConversationMenuHelper;->access$700(Lco/vine/android/util/ConversationMenuHelper;)J

    move-result-wide v0

    cmp-long v0, p1, v0

    if-nez v0, :cond_1

    .line 370
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    invoke-virtual {v0, v7}, Lco/vine/android/util/ConversationMenuHelper;->toggleContactSearch(Z)V

    .line 372
    :cond_1
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    const-wide/16 v1, -0x1

    # setter for: Lco/vine/android/util/ConversationMenuHelper;->mWaitingToStartUserId:J
    invoke-static {v0, v1, v2}, Lco/vine/android/util/ConversationMenuHelper;->access$602(Lco/vine/android/util/ConversationMenuHelper;J)J

    .line 373
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mAppController:Lco/vine/android/client/AppController;
    invoke-static {v0}, Lco/vine/android/util/ConversationMenuHelper;->access$800(Lco/vine/android/util/ConversationMenuHelper;)Lco/vine/android/client/AppController;

    move-result-object v0

    invoke-virtual {v0, p3, p4}, Lco/vine/android/client/AppController;->clearUnreadMessageCount(J)V

    .line 374
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;
    invoke-static {v0}, Lco/vine/android/util/ConversationMenuHelper;->access$300(Lco/vine/android/util/ConversationMenuHelper;)Lco/vine/android/BaseControllerActionBarActivity;

    move-result-object v8

    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;
    invoke-static {v0}, Lco/vine/android/util/ConversationMenuHelper;->access$300(Lco/vine/android/util/ConversationMenuHelper;)Lco/vine/android/BaseControllerActionBarActivity;

    move-result-object v0

    move-wide v1, p3

    move-object v3, p5

    move-wide v4, p1

    move v6, p6

    invoke-static/range {v0 .. v7}, Lco/vine/android/ConversationActivity;->getIntent(Landroid/content/Context;JLjava/lang/String;JZZ)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v8, v0}, Lco/vine/android/BaseControllerActionBarActivity;->startActivity(Landroid/content/Intent;)V

    .line 377
    :cond_2
    return-void
.end method

.method public onGetFriendsTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
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
    .line 391
    .local p5, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/util/ConversationMenuHelper;->showSearchProgressBar(Z)V

    .line 392
    if-eqz p5, :cond_0

    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mIsSearching:Z
    invoke-static {v0}, Lco/vine/android/util/ConversationMenuHelper;->access$900(Lco/vine/android/util/ConversationMenuHelper;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 393
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # invokes: Lco/vine/android/util/ConversationMenuHelper;->displaySearchResults(Ljava/util/ArrayList;)V
    invoke-static {v0, p5}, Lco/vine/android/util/ConversationMenuHelper;->access$1100(Lco/vine/android/util/ConversationMenuHelper;Ljava/util/ArrayList;)V

    .line 395
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
    .line 381
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mIsSearching:Z
    invoke-static {v0}, Lco/vine/android/util/ConversationMenuHelper;->access$900(Lco/vine/android/util/ConversationMenuHelper;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 382
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mFriendSearchAdapter:Lco/vine/android/FriendSearchAdapter;
    invoke-static {v0}, Lco/vine/android/util/ConversationMenuHelper;->access$1000(Lco/vine/android/util/ConversationMenuHelper;)Lco/vine/android/FriendSearchAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 383
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mFriendSearchAdapter:Lco/vine/android/FriendSearchAdapter;
    invoke-static {v0}, Lco/vine/android/util/ConversationMenuHelper;->access$1000(Lco/vine/android/util/ConversationMenuHelper;)Lco/vine/android/FriendSearchAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/FriendSearchAdapter;->setUserImages(Ljava/util/HashMap;)V

    .line 386
    :cond_0
    return-void
.end method
