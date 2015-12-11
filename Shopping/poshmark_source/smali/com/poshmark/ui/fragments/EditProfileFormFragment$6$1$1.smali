.class Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1$1;
.super Ljava/lang/Object;
.source "EditProfileFormFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
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
.field final synthetic this$2:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;)V
    .locals 0

    .prologue
    .line 475
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1$1;->this$2:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 8
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
    .line 478
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/user/UserInfoDetails;>;"
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1$1;->this$2:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 479
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1$1;->this$2:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->hideProgressDialog()V

    .line 480
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v2

    if-nez v2, :cond_1

    .line 481
    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/user/UserInfoDetails;

    .line 482
    .local v1, "userInfo":Lcom/poshmark/user/UserInfoDetails;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/poshmark/application/PMApplicationSession;->updateUserInfo(Lcom/poshmark/user/UserInfoDetails;)V

    .line 483
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1$1;->this$2:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 484
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1$1;->this$2:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    const/4 v3, 0x1

    iput-boolean v3, v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->profileUpdated:Z

    .line 485
    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->onBackPressed()V

    .line 491
    .end local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    .end local v1    # "userInfo":Lcom/poshmark/user/UserInfoDetails;
    :cond_0
    :goto_0
    return-void

    .line 487
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1$1;->this$2:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    new-instance v3, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v4, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v5, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_USER_PROFILE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    const v7, 0x7f0600eb

    invoke-virtual {v6, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v3, v4, v5, v6}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
