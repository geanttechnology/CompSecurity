.class Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;
.super Ljava/lang/Object;
.source "EditProfileFormFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->onClick(Landroid/view/View;)V
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
.field final synthetic this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;)V
    .locals 0

    .prologue
    .line 469
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;

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
    .line 473
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 474
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 475
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1$1;-><init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getUserProfile(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 500
    :cond_0
    :goto_0
    return-void

    .line 495
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->hideProgressDialog()V

    .line 496
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->UPDATE_USER_PROFILE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    const v5, 0x7f060100

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
