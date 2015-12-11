.class Lcom/poshmark/utils/sharing/share_states/ServerShare$1;
.super Ljava/lang/Object;
.source "ServerShare.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/sharing/share_states/ServerShare;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/sharing/share_states/ServerShare;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/ServerShare;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ServerShare;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 81
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 82
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ServerShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->popTopFragment()V

    .line 83
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ServerShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060259

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/utils/sharing/share_states/ServerShare$1$1;

    invoke-direct {v2, p0}, Lcom/poshmark/utils/sharing/share_states/ServerShare$1$1;-><init>(Lcom/poshmark/utils/sharing/share_states/ServerShare$1;)V

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    .line 98
    :goto_0
    return-void

    .line 92
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ServerShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->trackShareFailedEvent()V

    .line 93
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ServerShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SHARE_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ServerShare;

    iget-object v4, v4, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v4

    invoke-static {v4}, Lcom/poshmark/utils/sharing/ShareContentHelper;->getSharingErrorString(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
