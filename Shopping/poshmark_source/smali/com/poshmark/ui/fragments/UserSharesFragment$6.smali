.class Lcom/poshmark/ui/fragments/UserSharesFragment$6;
.super Ljava/lang/Object;
.source "UserSharesFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/UserSharesFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V
    .locals 0

    .prologue
    .line 239
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$6;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 242
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$6;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    # getter for: Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/UserSharesFragment;->access$000(Lcom/poshmark/ui/fragments/UserSharesFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 244
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 245
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "NAME"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$6;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    # getter for: Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/UserSharesFragment;->access$000(Lcom/poshmark/ui/fragments/UserSharesFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$6;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 247
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/ClosetFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 249
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    :cond_0
    return-void
.end method
