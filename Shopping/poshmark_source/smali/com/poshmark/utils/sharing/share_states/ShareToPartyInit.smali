.class public Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "ShareToPartyInit.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 26
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 7

    .prologue
    .line 29
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getListing()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v2

    .line 30
    .local v2, "listingItem":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getParty()Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v1

    .line 31
    .local v1, "event":Lcom/poshmark/data_model/models/PartyEvent;
    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/PartyEvent;->isListingEligibleForParty(Lcom/poshmark/data_model/models/ListingSummary;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 32
    new-instance v3, Ljava/lang/String;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    const v5, 0x7f060149

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 33
    .local v3, "msg":Ljava/lang/String;
    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 35
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v0, v4}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 36
    .local v0, "dialogBuilder":Landroid/app/AlertDialog$Builder;
    const v4, 0x1080027

    invoke-virtual {v0, v4}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 37
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    const v5, 0x7f0600d0

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 38
    invoke-virtual {v0, v3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 39
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    const v5, 0x7f0602be

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit$1;

    invoke-direct {v5, p0, v1}, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit$1;-><init>(Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;Lcom/poshmark/data_model/models/PartyEvent;)V

    invoke-virtual {v0, v4, v5}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 47
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    const v5, 0x7f0601e1

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v0, v4, v5}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 48
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 49
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v4}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateFailed()V

    .line 54
    .end local v0    # "dialogBuilder":Landroid/app/AlertDialog$Builder;
    .end local v3    # "msg":Ljava/lang/String;
    :goto_0
    return-void

    .line 51
    :cond_0
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v4}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    goto :goto_0
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 58
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyInit;->id:Ljava/util/UUID;

    return-object v0
.end method
