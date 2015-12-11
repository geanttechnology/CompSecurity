.class Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit$1;
.super Ljava/lang/Object;
.source "ShareToPartyInit.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;->executeState()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;

.field final synthetic val$event:Lcom/poshmark/data_model/models/PartyEvent;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;Lcom/poshmark/data_model/models/PartyEvent;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;

    iput-object p2, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit$1;->val$event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 43
    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v1}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 44
    .local v0, "activity":Lcom/poshmark/ui/PMContainerActivity;
    const/4 v1, 0x0

    const-class v2, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit$1;->val$event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMContainerActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 45
    return-void
.end method
