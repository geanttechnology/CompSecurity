.class Lcom/poshmark/ui/fragments/FindPeopleFragment$1;
.super Ljava/lang/Object;
.source "FindPeopleFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindPeopleFragment;->setupFindPeopleList()V
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
        "Lcom/poshmark/data_model/models/UserReferenceList;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$1;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

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
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 143
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$1;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->hideProgressDialog()V

    .line 144
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$1;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 145
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 146
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$1;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/UserReferenceList;

    iput-object v0, v1, Lcom/poshmark/ui/fragments/FindPeopleFragment;->suggestedUserList:Lcom/poshmark/data_model/models/UserReferenceList;

    .line 147
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$1;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    # invokes: Lcom/poshmark/ui/fragments/FindPeopleFragment;->updateUsersList()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->access$000(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    .line 152
    :cond_0
    :goto_0
    return-void

    .line 149
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$1;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->FETCH_SUGGESTED_USERS:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
