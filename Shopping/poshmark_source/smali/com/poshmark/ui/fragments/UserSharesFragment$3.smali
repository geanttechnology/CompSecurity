.class Lcom/poshmark/ui/fragments/UserSharesFragment$3;
.super Ljava/lang/Object;
.source "UserSharesFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/UserSharesFragment;->setupClosetList()V
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
        "Lcom/poshmark/user/UserInfoDetails;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V
    .locals 0

    .prologue
    .line 187
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$3;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

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
            "Lcom/poshmark/user/UserInfoDetails;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 190
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/user/UserInfoDetails;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$3;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserSharesFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 191
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_1

    .line 192
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$3;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/user/UserInfoDetails;

    # setter for: Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v2, v1}, Lcom/poshmark/ui/fragments/UserSharesFragment;->access$002(Lcom/poshmark/ui/fragments/UserSharesFragment;Lcom/poshmark/user/UserInfoDetails;)Lcom/poshmark/user/UserInfoDetails;

    .line 193
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$3;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    const/4 v2, 0x0

    # invokes: Lcom/poshmark/ui/fragments/UserSharesFragment;->getUserShares(Z)V
    invoke-static {v1, v2}, Lcom/poshmark/ui/fragments/UserSharesFragment;->access$200(Lcom/poshmark/ui/fragments/UserSharesFragment;Z)V

    .line 194
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$3;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    # invokes: Lcom/poshmark/ui/fragments/UserSharesFragment;->updateProfileCard()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/UserSharesFragment;->access$300(Lcom/poshmark/ui/fragments/UserSharesFragment;)V

    .line 195
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$3;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserSharesFragment;->setupActionBar()V

    .line 205
    :cond_0
    :goto_0
    return-void

    .line 197
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$3;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/UserSharesFragment;->hideProgressDialog()V

    .line 198
    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v1, v1, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_NOT_FOUND:Lcom/poshmark/data_model/models/PMErrorType;

    if-eq v1, v2, :cond_2

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v1, v1, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_GONE:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v1, v2, :cond_3

    :cond_2
    const v0, 0x7f0600dd

    .line 201
    .local v0, "operationStringResource":I
    :goto_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$3;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_USER_PROFILE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$3;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    invoke-virtual {v5, v0}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/UserSharesFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0

    .line 198
    .end local v0    # "operationStringResource":I
    :cond_3
    const v0, 0x7f0600eb

    goto :goto_1
.end method
