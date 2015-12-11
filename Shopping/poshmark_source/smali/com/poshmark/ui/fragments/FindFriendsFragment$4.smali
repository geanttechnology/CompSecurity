.class Lcom/poshmark/ui/fragments/FindFriendsFragment$4;
.super Ljava/lang/Object;
.source "FindFriendsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindFriendsFragment;->setupSuggestedUsersPanel()V
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
    .line 168
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$4;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 172
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$4;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/FindFriendsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "user"

    const-string v3, "onramp_suggested_users_viewed"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 173
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$4;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$4;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/FindFriendsFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/UserReferenceList;->getConnectionInfoList()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 174
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$4;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$4;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/FindFriendsFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    sget-object v2, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->SUGGESTED_USERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    # invokes: Lcom/poshmark/ui/fragments/FindFriendsFragment;->launchUserListFragment(Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V
    invoke-static {v0, v1, v2}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->access$000(Lcom/poshmark/ui/fragments/FindFriendsFragment;Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V

    .line 176
    :cond_0
    return-void
.end method
