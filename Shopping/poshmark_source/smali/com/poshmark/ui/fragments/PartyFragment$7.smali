.class Lcom/poshmark/ui/fragments/PartyFragment$7;
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
    .line 479
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PartyFragment$7;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 482
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment$7;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PartyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 483
    .local v0, "activity":Lcom/poshmark/ui/PMContainerActivity;
    const/4 v1, 0x0

    const-class v2, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PartyFragment$7;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    # getter for: Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/PartyFragment;->access$400(Lcom/poshmark/ui/fragments/PartyFragment;)Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment$7;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMContainerActivity;->launchDialogFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 484
    return-void
.end method
