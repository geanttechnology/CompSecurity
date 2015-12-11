.class Lcom/poshmark/ui/fragments/FindFriendsFragment$5;
.super Ljava/lang/Object;
.source "FindFriendsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindFriendsFragment;->setupTwitterPanel()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V
    .locals 0

    .prologue
    .line 183
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$5;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 187
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$5;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/FindFriendsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "user"

    const-string v4, "load_twitter_friends"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 188
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getTwitterToken()Ljava/lang/String;

    move-result-object v0

    .line 189
    .local v0, "twToken":Ljava/lang/String;
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$5;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/FindFriendsFragment;->twitterList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$5;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/FindFriendsFragment;->twitterList:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/UserReferenceList;->getConnectionInfoList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 190
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$5;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$5;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/FindFriendsFragment;->twitterList:Lcom/poshmark/data_model/models/UserReferenceList;

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->TWITTER_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    # invokes: Lcom/poshmark/ui/fragments/FindFriendsFragment;->launchUserListFragment(Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V
    invoke-static {v1, v2, v3}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->access$000(Lcom/poshmark/ui/fragments/FindFriendsFragment;Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V

    .line 212
    :goto_0
    return-void

    .line 192
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$5;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$5;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    const v3, 0x7f060190

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 193
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$5;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    new-instance v3, Lcom/poshmark/ui/fragments/FindFriendsFragment$5$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/FindFriendsFragment$5$1;-><init>(Lcom/poshmark/ui/fragments/FindFriendsFragment$5;)V

    invoke-virtual {v1, v2, v3}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->twitterLink(Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V

    goto :goto_0
.end method
