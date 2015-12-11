.class Lcom/poshmark/ui/fragments/FindFriendsFragment$3;
.super Ljava/lang/Object;
.source "FindFriendsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindFriendsFragment;->setupFacebookPanel()V
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
    .line 147
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x5

    .line 151
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/FindFriendsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "user"

    const-string v4, "load_facebook_friends"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v1

    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->FRIENDS_PERMISSION:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isPermissionEnabled(Ljava/lang/String;)Z

    move-result v0

    .line 153
    .local v0, "fbFriendsPermissionEnabled":Z
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/FindFriendsFragment;->fbList:Lcom/poshmark/data_model/models/UserReferenceList;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/FindFriendsFragment;->fbList:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/UserReferenceList;->getConnectionInfoList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 154
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/FindFriendsFragment;->fbList:Lcom/poshmark/data_model/models/UserReferenceList;

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->FB_FRIENDS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    # invokes: Lcom/poshmark/ui/fragments/FindFriendsFragment;->launchUserListFragment(Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V
    invoke-static {v1, v2, v3}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->access$000(Lcom/poshmark/ui/fragments/FindFriendsFragment;Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V

    .line 160
    :goto_0
    return-void

    .line 156
    :cond_0
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$3;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    sget v3, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_FRIENDS_REQUEST:I

    invoke-virtual {v1, v2, v6, v6, v3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;III)V

    goto :goto_0
.end method
