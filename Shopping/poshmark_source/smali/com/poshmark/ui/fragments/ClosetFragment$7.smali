.class Lcom/poshmark/ui/fragments/ClosetFragment$7;
.super Ljava/lang/Object;
.source "ClosetFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ClosetFragment;->reportUser(Ljava/lang/String;)V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ClosetFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V
    .locals 0

    .prologue
    .line 328
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$7;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

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
    .line 332
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment$7;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 333
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment$7;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->hideProgressDialog()V

    .line 334
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 335
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment$7;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$7;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    const v2, 0x7f060228

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->showAutoHideSuccessMessage(Ljava/lang/String;)V

    .line 342
    :cond_0
    :goto_0
    return-void

    .line 338
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ClosetFragment$7;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->REPORT_USER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    const v5, 0x7f0600f6

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
