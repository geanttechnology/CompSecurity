.class public Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "ShareToPartyShare.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 28
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 30
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    .line 31
    .local v0, "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getListing()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v3

    .line 32
    .local v3, "listingItem":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getParty()Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v1

    .line 33
    .local v1, "event":Lcom/poshmark/data_model/models/PartyEvent;
    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v4

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v4

    if-eqz v4, :cond_1

    const/4 v2, 0x1

    .line 34
    .local v2, "isFragmentAdded":Z
    :goto_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 35
    sget-object v4, Lcom/poshmark/utils/NewRelicCustomInteractions;->SHARE_LISTING_TO_PARTY:Ljava/lang/String;

    invoke-static {v4}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 36
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    const v5, 0x7f06025d

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 37
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;

    invoke-direct {v6, p0, v0, v2, v3}, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;-><init>(Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;Lcom/poshmark/ui/fragments/PMFragment;ZLcom/poshmark/data_model/models/ListingSummary;)V

    invoke-static {v4, v7, v5, v7, v6}, Lcom/poshmark/http/api/PMApi;->shareListing(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 63
    :cond_0
    return-void

    .line 33
    .end local v2    # "isFragmentAdded":Z
    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 66
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;->id:Ljava/util/UUID;

    return-object v0
.end method
