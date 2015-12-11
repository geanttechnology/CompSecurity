.class Lcom/poshmark/ui/fragments/FindFriendsFragment$2;
.super Ljava/lang/Object;
.source "FindFriendsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindFriendsFragment;->setupContactsPanel()V
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
    .line 131
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$2;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    .line 134
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$2;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/FindFriendsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "user"

    const-string v5, "load_contacts"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 137
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "URL"

    const-string v3, "https://www.poshmark.com/mapp/find_people/contacts"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$2;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 139
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v1, v0, v2, v6}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 140
    return-void
.end method
