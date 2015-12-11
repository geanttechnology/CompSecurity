.class Lcom/poshmark/ui/fragments/ChangePasswordFragment$2$1;
.super Ljava/lang/Object;
.source "ChangePasswordFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->onClick(Landroid/view/View;)V
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
        "Lcom/poshmark/user/UserInfo;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2$1;->this$1:Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/user/UserInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 101
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/user/UserInfo;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2$1;->this$1:Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 102
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2$1;->this$1:Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->hideProgressDialog()V

    .line 103
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_1

    .line 104
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/user/UserInfo;

    .line 105
    .local v0, "info":Lcom/poshmark/user/UserInfo;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/poshmark/application/PMApplicationSession;->saveSession(Lcom/poshmark/user/UserInfo;)V

    .line 106
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2$1;->this$1:Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 112
    .end local v0    # "info":Lcom/poshmark/user/UserInfo;
    :cond_0
    :goto_0
    return-void

    .line 108
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2$1;->this$1:Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->UPDATE_PASSWORD:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2$1;->this$1:Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    const v6, 0x7f0600ff

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
