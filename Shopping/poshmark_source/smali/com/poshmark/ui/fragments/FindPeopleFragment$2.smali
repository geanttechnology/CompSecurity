.class Lcom/poshmark/ui/fragments/FindPeopleFragment$2;
.super Ljava/lang/Object;
.source "FindPeopleFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/FindPeopleFragment;
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
    .line 168
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$2;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 171
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 172
    .local v3, "user":Lcom/poshmark/data_model/models/inner_models/UserReference;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$2;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 173
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 174
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 175
    .local v1, "b":Landroid/os/Bundle;
    const-string v4, "NAME"

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    iget-object v4, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$2;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 177
    .local v2, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v4, Lcom/poshmark/ui/fragments/ClosetFragment;

    const/4 v5, 0x0

    invoke-virtual {v2, v1, v4, v5}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 179
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v2    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    :cond_0
    return-void
.end method
