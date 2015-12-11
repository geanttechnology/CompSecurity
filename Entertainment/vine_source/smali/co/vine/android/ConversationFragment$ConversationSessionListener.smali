.class Lco/vine/android/ConversationFragment$ConversationSessionListener;
.super Lco/vine/android/client/AppSessionListener;
.source "ConversationFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ConversationFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConversationSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConversationFragment;


# direct methods
.method private constructor <init>(Lco/vine/android/ConversationFragment;)V
    .locals 0

    .prologue
    .line 1004
    iput-object p1, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/ConversationFragment;Lco/vine/android/ConversationFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/ConversationFragment;
    .param p2, "x1"    # Lco/vine/android/ConversationFragment$1;

    .prologue
    .line 1004
    invoke-direct {p0, p1}, Lco/vine/android/ConversationFragment$ConversationSessionListener;-><init>(Lco/vine/android/ConversationFragment;)V

    return-void
.end method


# virtual methods
.method public onGetConversationComplete(Ljava/lang/String;ILjava/lang/String;JIZ)V
    .locals 5
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "conversationRowId"    # J
    .param p6, "responseCode"    # I
    .param p7, "empty"    # Z

    .prologue
    const/4 v4, 0x0

    .line 1019
    iget-object v2, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    invoke-virtual {v2, p1}, Lco/vine/android/ConversationFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v1

    .line 1020
    .local v1, "req":Lco/vine/android/PendingRequest;
    if-eqz v1, :cond_2

    iget-object v2, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    # getter for: Lco/vine/android/ConversationFragment;->mConversationRowId:J
    invoke-static {v2}, Lco/vine/android/ConversationFragment;->access$700(Lco/vine/android/ConversationFragment;)J

    move-result-wide v2

    cmp-long v2, p4, v2

    if-nez v2, :cond_2

    .line 1021
    iget-object v2, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Lco/vine/android/ConversationFragment;->hideProgress(I)V

    .line 1022
    if-eqz p7, :cond_3

    .line 1023
    iget-object v2, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    const/4 v3, 0x1

    invoke-virtual {v2, v3, v4}, Lco/vine/android/ConversationFragment;->showSadface(ZZ)V

    .line 1028
    :goto_0
    iget-object v2, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    iget-object v0, v2, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v0, Lco/vine/android/ConversationAdapter;

    .line 1029
    .local v0, "adapter":Lco/vine/android/ConversationAdapter;
    iget-object v2, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    # getter for: Lco/vine/android/ConversationFragment;->mFetched:Z
    invoke-static {v2}, Lco/vine/android/ConversationFragment;->access$1300(Lco/vine/android/ConversationFragment;)Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-virtual {v0}, Lco/vine/android/ConversationAdapter;->atLastPage()Z

    move-result v2

    if-nez v2, :cond_0

    if-nez p7, :cond_0

    invoke-virtual {v0}, Lco/vine/android/ConversationAdapter;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1030
    :cond_0
    iget-object v2, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    # getter for: Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;
    invoke-static {v2}, Lco/vine/android/ConversationFragment;->access$1400(Lco/vine/android/ConversationFragment;)Landroid/view/View;

    move-result-object v2

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 1033
    :cond_1
    const/4 v2, 0x4

    if-ne p6, v2, :cond_2

    .line 1034
    iget-object v2, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    # getter for: Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;
    invoke-static {v2}, Lco/vine/android/ConversationFragment;->access$1400(Lco/vine/android/ConversationFragment;)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 1037
    .end local v0    # "adapter":Lco/vine/android/ConversationAdapter;
    :cond_2
    return-void

    .line 1025
    :cond_3
    iget-object v2, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    invoke-virtual {v2, v4}, Lco/vine/android/ConversationFragment;->showSadface(Z)V

    goto :goto_0
.end method

.method public onGetConversationRemoteIdComplete(J)V
    .locals 2
    .param p1, "conversationId"    # J

    .prologue
    .line 1041
    iget-object v0, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    # setter for: Lco/vine/android/ConversationFragment;->mConversationId:J
    invoke-static {v0, p1, p2}, Lco/vine/android/ConversationFragment;->access$1502(Lco/vine/android/ConversationFragment;J)J

    .line 1042
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gtz v0, :cond_0

    .line 1044
    iget-object v0, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    # getter for: Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/ConversationFragment;->access$1400(Lco/vine/android/ConversationFragment;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1046
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
    .line 1012
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v0, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    iget-object v0, v0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v0, Lco/vine/android/ConversationAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/ConversationAdapter;->setImages(Ljava/util/HashMap;)V

    .line 1013
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
    .line 1007
    .local p1, "videos":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/video/VideoKey;Lco/vine/android/util/video/UrlVideo;>;"
    iget-object v0, p0, Lco/vine/android/ConversationFragment$ConversationSessionListener;->this$0:Lco/vine/android/ConversationFragment;

    iget-object v0, v0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v0, Lco/vine/android/ConversationAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/ConversationAdapter;->onVideoPathObtained(Ljava/util/HashMap;)V

    .line 1008
    return-void
.end method
