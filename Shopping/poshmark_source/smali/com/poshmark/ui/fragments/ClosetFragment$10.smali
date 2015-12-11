.class Lcom/poshmark/ui/fragments/ClosetFragment$10;
.super Ljava/lang/Object;
.source "ClosetFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ClosetFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ClosetFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V
    .locals 0

    .prologue
    .line 410
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$10;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 413
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment$10;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 414
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 415
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->PM_FOLLOWERS_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 416
    const-string v2, "ID"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment$10;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 417
    const-string v2, "DISPLAY_COUNT"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment$10;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getFollowersCount()I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 418
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment$10;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 419
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 420
    const-class v2, Lcom/poshmark/ui/fragments/UserListFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 424
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    :cond_0
    return-void
.end method
