.class Lcom/poshmark/ui/fragments/EditProfileFormFragment$5$1;
.super Ljava/lang/Object;
.source "EditProfileFormFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->onClick(Landroid/view/View;)V
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
.field final synthetic this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;)V
    .locals 0

    .prologue
    .line 389
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;

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
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    const/4 v2, 0x0

    .line 392
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 393
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->hideProgressDialog()V

    .line 394
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_2

    .line 397
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FeatureManager;->isBrandsFollowOnSignupEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 398
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 399
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 400
    const-class v1, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    invoke-virtual {v0, v2, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 415
    .end local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    :cond_0
    :goto_0
    return-void

    .line 404
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 405
    .restart local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 406
    const-class v1, Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-virtual {v0, v2, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_0

    .line 411
    .end local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5$1;->this$1:Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->UPDATE_USER_PROFILE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const v6, 0x7f060100

    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
