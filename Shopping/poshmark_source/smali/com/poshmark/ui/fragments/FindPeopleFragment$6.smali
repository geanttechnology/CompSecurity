.class Lcom/poshmark/ui/fragments/FindPeopleFragment$6;
.super Ljava/lang/Object;
.source "FindPeopleFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindPeopleFragment;->findUsers()V
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
    .line 288
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

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
    .line 291
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 292
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->hideProgressDialog()V

    .line 293
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_2

    .line 294
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/UserReferenceList;

    iput-object v0, v1, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchResultsList:Lcom/poshmark/data_model/models/UserReferenceList;

    .line 295
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchResultsList:Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/UserReferenceList;->getConnectionInfoList()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 296
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchResultsList:Lcom/poshmark/data_model/models/UserReferenceList;

    sget-object v2, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->SEARCH_PEOPLE_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    # invokes: Lcom/poshmark/ui/fragments/FindPeopleFragment;->launchUserListFragment(Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V
    invoke-static {v0, v1, v2}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->access$300(Lcom/poshmark/ui/fragments/FindPeopleFragment;Lcom/poshmark/data_model/models/UserReferenceList;Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;)V

    .line 305
    :cond_0
    :goto_0
    return-void

    .line 298
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    const v2, 0x7f0601d3

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;)V

    goto :goto_0

    .line 301
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->FETCH_FACEBOOK_PM_USERS:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
