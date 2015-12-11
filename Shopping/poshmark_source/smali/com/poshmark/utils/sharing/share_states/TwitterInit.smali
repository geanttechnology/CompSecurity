.class public Lcom/poshmark/utils/sharing/share_states/TwitterInit;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "TwitterInit.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->id:Ljava/util/UUID;

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
    .locals 4

    .prologue
    .line 28
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getTwitterToken()Ljava/lang/String;

    move-result-object v0

    .line 29
    .local v0, "tw_Id":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 30
    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v1}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 53
    :goto_0
    return-void

    .line 32
    :cond_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v1}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060190

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 33
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    new-instance v3, Lcom/poshmark/utils/sharing/share_states/TwitterInit$1;

    invoke-direct {v3, p0}, Lcom/poshmark/utils/sharing/share_states/TwitterInit$1;-><init>(Lcom/poshmark/utils/sharing/share_states/TwitterInit;)V

    invoke-virtual {v1, v2, v3}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->twitterLink(Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V

    goto :goto_0
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 56
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->id:Ljava/util/UUID;

    return-object v0
.end method
