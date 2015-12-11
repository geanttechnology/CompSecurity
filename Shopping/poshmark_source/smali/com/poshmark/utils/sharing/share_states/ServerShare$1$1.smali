.class Lcom/poshmark/utils/sharing/share_states/ServerShare$1$1;
.super Ljava/lang/Object;
.source "ServerShare.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/ServerShare$1;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/utils/sharing/share_states/ServerShare$1;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/ServerShare$1;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1$1;->this$1:Lcom/poshmark/utils/sharing/share_states/ServerShare$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public dialogDismissed()V
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1$1;->this$1:Lcom/poshmark/utils/sharing/share_states/ServerShare$1;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ServerShare;

    # invokes: Lcom/poshmark/utils/sharing/share_states/ServerShare;->deRegisterListeners()V
    invoke-static {v0}, Lcom/poshmark/utils/sharing/share_states/ServerShare;->access$000(Lcom/poshmark/utils/sharing/share_states/ServerShare;)V

    .line 87
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1$1;->this$1:Lcom/poshmark/utils/sharing/share_states/ServerShare$1;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ServerShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 88
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1$1;->this$1:Lcom/poshmark/utils/sharing/share_states/ServerShare$1;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ServerShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->popTopFragment()V

    .line 89
    return-void
.end method
