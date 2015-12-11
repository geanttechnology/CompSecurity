.class Lcom/poshmark/ui/fragments/UserListFragment$10;
.super Ljava/lang/Object;
.source "UserListFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/UserListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/UserListFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserListFragment;)V
    .locals 0

    .prologue
    .line 362
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserListFragment$10;->this$0:Lcom/poshmark/ui/fragments/UserListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 365
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 366
    .local v2, "user":Lcom/poshmark/data_model/models/inner_models/UserReference;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 367
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "NAME"

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 368
    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserListFragment$10;->this$0:Lcom/poshmark/ui/fragments/UserListFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/UserListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 369
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 370
    const-class v3, Lcom/poshmark/ui/fragments/ClosetFragment;

    const/4 v4, 0x0

    invoke-virtual {v1, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 372
    :cond_0
    return-void
.end method
