.class Lcom/poshmark/ui/fragments/PartyFragment$8;
.super Ljava/lang/Object;
.source "PartyFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PartyFragment;->createPartyHeaderView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PartyFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PartyFragment;)V
    .locals 0

    .prologue
    .line 488
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PartyFragment$8;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 492
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 493
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "ID"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PartyFragment$8;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    # getter for: Lcom/poshmark/ui/fragments/PartyFragment;->eventId:Ljava/lang/String;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/PartyFragment;->access$500(Lcom/poshmark/ui/fragments/PartyFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 494
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment$8;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PartyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 495
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/PartyInviteFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PartyFragment$8;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    # getter for: Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/PartyFragment;->access$400(Lcom/poshmark/ui/fragments/PartyFragment;)Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 496
    return-void
.end method
