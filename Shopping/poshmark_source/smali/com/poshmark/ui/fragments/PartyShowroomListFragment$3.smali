.class Lcom/poshmark/ui/fragments/PartyShowroomListFragment$3;
.super Ljava/lang/Object;
.source "PartyShowroomListFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->updateHeaderView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PartyShowroomListFragment;)V
    .locals 0

    .prologue
    .line 210
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$3;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 214
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 215
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "ID"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$3;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    # getter for: Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->access$100(Lcom/poshmark/ui/fragments/PartyShowroomListFragment;)Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$3;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 217
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/PartyInviteFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$3;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    # getter for: Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->access$100(Lcom/poshmark/ui/fragments/PartyShowroomListFragment;)Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 219
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$3;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->dismiss()V

    .line 220
    return-void
.end method
