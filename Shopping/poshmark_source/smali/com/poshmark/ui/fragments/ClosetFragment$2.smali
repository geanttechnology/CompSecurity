.class Lcom/poshmark/ui/fragments/ClosetFragment$2;
.super Ljava/lang/Object;
.source "ClosetFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ClosetFragment;->setupClosetList()V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ClosetFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V
    .locals 0

    .prologue
    .line 195
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$2;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

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
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/user/UserInfoDetails;>;"
    const/4 v3, 0x0

    .line 198
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$2;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 199
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_1

    .line 200
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment$2;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/user/UserInfoDetails;

    # setter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v2, v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$102(Lcom/poshmark/ui/fragments/ClosetFragment;Lcom/poshmark/user/UserInfoDetails;)Lcom/poshmark/user/UserInfoDetails;

    .line 201
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$2;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # invokes: Lcom/poshmark/ui/fragments/ClosetFragment;->getUserCloset(Z)V
    invoke-static {v1, v3}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$000(Lcom/poshmark/ui/fragments/ClosetFragment;Z)V

    .line 202
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$2;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # invokes: Lcom/poshmark/ui/fragments/ClosetFragment;->updateProfileCard()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$200(Lcom/poshmark/ui/fragments/ClosetFragment;)V

    .line 203
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$2;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->setupActionBar()V

    .line 204
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$2;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$300(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    move-result-object v1

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 214
    :cond_0
    :goto_0
    return-void

    .line 206
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$2;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->hideProgressDialog()V

    .line 207
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

    .line 210
    .local v0, "operationStringResource":I
    :goto_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$2;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_USER_PROFILE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ClosetFragment$2;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {v5, v0}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0

    .line 207
    .end local v0    # "operationStringResource":I
    :cond_3
    const v0, 0x7f0600eb

    goto :goto_1
.end method
