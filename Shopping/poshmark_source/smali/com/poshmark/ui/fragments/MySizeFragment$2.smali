.class Lcom/poshmark/ui/fragments/MySizeFragment$2;
.super Ljava/lang/Object;
.source "MySizeFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MySizeFragment;->getMySizes()V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MySizeFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MySizeFragment;)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MySizeFragment$2;->this$0:Lcom/poshmark/ui/fragments/MySizeFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 6
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
    .line 152
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment$2;->this$0:Lcom/poshmark/ui/fragments/MySizeFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MySizeFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 153
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment$2;->this$0:Lcom/poshmark/ui/fragments/MySizeFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MySizeFragment;->hideProgressDialog()V

    .line 154
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 155
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizeFragment$2;->this$0:Lcom/poshmark/ui/fragments/MySizeFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MySizeFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "user"

    const-string v3, "my_size_updated"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/UserStateSummaryController;->refreshModels()V

    .line 164
    :cond_0
    :goto_0
    return-void

    .line 160
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizeFragment$2;->this$0:Lcom/poshmark/ui/fragments/MySizeFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->UPDATE_MY_SIZE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/MySizeFragment$2;->this$0:Lcom/poshmark/ui/fragments/MySizeFragment;

    const v5, 0x7f0600fe

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/MySizeFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/MySizeFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
