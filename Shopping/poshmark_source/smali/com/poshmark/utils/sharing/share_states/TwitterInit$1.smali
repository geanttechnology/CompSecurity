.class Lcom/poshmark/utils/sharing/share_states/TwitterInit$1;
.super Ljava/lang/Object;
.source "TwitterInit.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/TwitterInit;->executeState()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/sharing/share_states/TwitterInit;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/TwitterInit;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/TwitterInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TwitterInit;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 3
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TwitterInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TwitterInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 38
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TwitterInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TwitterInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 39
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TwitterInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TwitterInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LINK_TWITTER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, p1, v2}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    .line 41
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TwitterInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TwitterInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateFailed()V

    .line 42
    return-void
.end method

.method public success(ILandroid/os/Bundle;)V
    .locals 1
    .param p1, "accessLevel"    # I
    .param p2, "loginBundle"    # Landroid/os/Bundle;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TwitterInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TwitterInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TwitterInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TwitterInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 48
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TwitterInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TwitterInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 50
    :cond_0
    return-void
.end method
