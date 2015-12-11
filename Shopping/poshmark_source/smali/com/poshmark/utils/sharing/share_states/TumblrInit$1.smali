.class Lcom/poshmark/utils/sharing/share_states/TumblrInit$1;
.super Ljava/lang/Object;
.source "TumblrInit.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/TumblrInit;->executeState()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/sharing/share_states/TumblrInit;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/TumblrInit;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TumblrInit;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 3
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TumblrInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 41
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TumblrInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 42
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TumblrInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LINK_TUMBLR:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, p1, v2}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    .line 44
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TumblrInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateFailed()V

    .line 45
    return-void
.end method

.method public success(ILandroid/os/Bundle;)V
    .locals 1
    .param p1, "accessLevel"    # I
    .param p2, "loginBundle"    # Landroid/os/Bundle;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TumblrInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 50
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TumblrInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 51
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/TumblrInit$1;->this$0:Lcom/poshmark/utils/sharing/share_states/TumblrInit;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/TumblrInit;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 53
    :cond_0
    return-void
.end method
