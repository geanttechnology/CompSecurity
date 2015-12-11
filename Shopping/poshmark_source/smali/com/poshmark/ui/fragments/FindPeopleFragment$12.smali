.class Lcom/poshmark/ui/fragments/FindPeopleFragment$12;
.super Ljava/lang/Object;
.source "FindPeopleFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindPeopleFragment;->setupHeaderView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V
    .locals 0

    .prologue
    .line 374
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$12;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    .line 377
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$12;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/FindPeopleFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "user"

    const-string v5, "load_new_closets"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 378
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 379
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "ID"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 380
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_OPENED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 381
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$12;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 382
    .local v1, "parent":Lcom/poshmark/ui/PMActivity;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 383
    const-class v2, Lcom/poshmark/ui/fragments/UserListFragment;

    invoke-virtual {v1, v0, v2, v6}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 386
    :cond_0
    return-void
.end method
