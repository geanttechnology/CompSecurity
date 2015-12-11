.class Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;
.super Ljava/lang/Object;
.source "GetLocalContent.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->executeState()V
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
        "Lcom/poshmark/data_model/models/BrandShareMessageContainer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/sharing/share_states/GetLocalContent;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/GetLocalContent;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;->this$0:Lcom/poshmark/utils/sharing/share_states/GetLocalContent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/BrandShareMessageContainer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 102
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/BrandShareMessageContainer;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;->this$0:Lcom/poshmark/utils/sharing/share_states/GetLocalContent;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v1

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/BrandShareMessageContainer;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/BrandShareMessageContainer;->getBrandShareMessages()Lcom/poshmark/data_model/models/BrandShareMessages;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/poshmark/utils/sharing/PMShareContent;->setBrandShareMessages(Lcom/poshmark/data_model/models/BrandShareMessages;)V

    .line 104
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;->this$0:Lcom/poshmark/utils/sharing/share_states/GetLocalContent;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 105
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;->this$0:Lcom/poshmark/utils/sharing/share_states/GetLocalContent;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 115
    :goto_0
    return-void

    .line 107
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;->this$0:Lcom/poshmark/utils/sharing/share_states/GetLocalContent;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SHARE_LISTING_TWITTER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    new-instance v2, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3$1;

    invoke-direct {v2, p0}, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3$1;-><init>(Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;)V

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    goto :goto_0
.end method
