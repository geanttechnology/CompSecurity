.class public Lcom/poshmark/utils/sharing/share_states/TumblrInit;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "TumblrInit.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 25
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 5

    .prologue
    .line 28
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getTumblrToken()Ljava/lang/String;

    move-result-object v1

    .line 29
    .local v1, "tm_Id":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v0, 0x1

    .line 30
    .local v0, "isFragmentAdded":Z
    :goto_0
    if-eqz v1, :cond_1

    .line 31
    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v2}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 56
    :goto_1
    return-void

    .line 29
    .end local v0    # "isFragmentAdded":Z
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 33
    .restart local v0    # "isFragmentAdded":Z
    :cond_1
    if-eqz v0, :cond_2

    .line 34
    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f060190

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 36
    :cond_2
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v3

    new-instance v4, Lcom/poshmark/utils/sharing/share_states/TumblrInit$1;

    invoke-direct {v4, p0}, Lcom/poshmark/utils/sharing/share_states/TumblrInit$1;-><init>(Lcom/poshmark/utils/sharing/share_states/TumblrInit;)V

    invoke-virtual {v2, v3, v4}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->tumblrLink(Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V

    goto :goto_1
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->id:Ljava/util/UUID;

    return-object v0
.end method
