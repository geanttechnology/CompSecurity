.class Lcom/poshmark/utils/sharing/share_states/GetServerContent$1;
.super Ljava/lang/Object;
.source "GetServerContent.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/GetServerContent;->executeState()V
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
        "Lcom/poshmark/utils/sharing/ServerShareMessages;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/sharing/share_states/GetServerContent;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/GetServerContent;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/GetServerContent$1;->this$0:Lcom/poshmark/utils/sharing/share_states/GetServerContent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/utils/sharing/ServerShareMessages;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 44
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/utils/sharing/ServerShareMessages;>;"
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/GetServerContent$1;->this$0:Lcom/poshmark/utils/sharing/share_states/GetServerContent;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 45
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 46
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/GetServerContent$1;->this$0:Lcom/poshmark/utils/sharing/share_states/GetServerContent;

    iget-object v1, v0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/utils/sharing/ServerShareMessages;

    invoke-virtual {v1, v0}, Lcom/poshmark/utils/ShareManager;->setShareContent(Lcom/poshmark/utils/sharing/ServerShareMessages;)V

    .line 47
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/GetServerContent$1;->this$0:Lcom/poshmark/utils/sharing/share_states/GetServerContent;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 51
    :goto_0
    return-void

    .line 49
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/GetServerContent$1;->this$0:Lcom/poshmark/utils/sharing/share_states/GetServerContent;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateFailed()V

    goto :goto_0
.end method
