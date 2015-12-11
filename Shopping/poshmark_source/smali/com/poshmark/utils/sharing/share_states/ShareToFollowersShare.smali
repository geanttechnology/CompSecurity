.class public Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "ShareToFollowersShare.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;->id:Ljava/util/UUID;

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
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 28
    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    .line 29
    .local v0, "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getListing()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v2

    .line 30
    .local v2, "listingItem":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 v1, 0x1

    .line 31
    .local v1, "isFragmentAdded":Z
    :goto_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f06025d

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 32
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare$1;

    invoke-direct {v4, p0, v0, v1, v2}, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare$1;-><init>(Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;Lcom/poshmark/ui/fragments/PMFragment;ZLcom/poshmark/data_model/models/ListingSummary;)V

    invoke-static {v3, v5, v5, v5, v4}, Lcom/poshmark/http/api/PMApi;->shareListing(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 57
    return-void

    .line 30
    .end local v1    # "isFragmentAdded":Z
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 60
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;->id:Ljava/util/UUID;

    return-object v0
.end method
