.class Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;
.super Ljava/lang/Object;
.source "SignupFormFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SignupFormFragment$4;->onClick(Landroid/view/View;)V
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
.field final synthetic this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SignupFormFragment$4;)V
    .locals 0

    .prologue
    .line 359
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 10
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
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/user/UserInfo;>;"
    const/4 v7, 0x0

    .line 362
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    const/4 v5, 0x0

    # setter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->creationInProgress:Z
    invoke-static {v4, v5}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1702(Lcom/poshmark/ui/fragments/SignupFormFragment;Z)Z

    .line 363
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/SignupFormFragment;->isAdded()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 364
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/SignupFormFragment;->hideProgressDialog()V

    .line 365
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v4

    if-nez v4, :cond_1

    .line 367
    sget-object v4, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->markAsExpired()V

    .line 368
    sget-object v4, Lcom/poshmark/utils/DeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/DeferredDeepLinkManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/DeferredDeepLinkManager;->markAsExpired()V

    .line 370
    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v3, Lcom/poshmark/user/UserInfo;

    .line 371
    .local v3, "userInfo":Lcom/poshmark/user/UserInfo;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    .line 372
    .local v2, "session":Lcom/poshmark/application/PMApplicationSession;
    invoke-virtual {v2, v3}, Lcom/poshmark/application/PMApplicationSession;->saveSession(Lcom/poshmark/user/UserInfo;)V

    .line 375
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/SignupFormFragment;->fireTrackingCalls()V
    invoke-static {v4}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1800(Lcom/poshmark/ui/fragments/SignupFormFragment;)V

    .line 378
    const-string v4, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-static {v4}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 379
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    const/4 v5, 0x1

    # setter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->userCreated:Z
    invoke-static {v4, v5}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1902(Lcom/poshmark/ui/fragments/SignupFormFragment;Z)Z

    .line 380
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 381
    .local v1, "parent":Lcom/poshmark/ui/PMActivity;
    invoke-virtual {v1}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 382
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 383
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "MODE"

    sget-object v5, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_CREATE:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->ordinal()I

    move-result v5

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 384
    const-class v4, Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v1, v0, v4, v7}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 405
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "parent":Lcom/poshmark/ui/PMActivity;
    .end local v2    # "session":Lcom/poshmark/application/PMApplicationSession;
    .end local v3    # "userInfo":Lcom/poshmark/user/UserInfo;
    :cond_0
    :goto_0
    return-void

    .line 388
    :cond_1
    iget-object v4, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v4, v4, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v5, Lcom/poshmark/data_model/models/PMErrorType;->USERNAME_TAKEN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v4, v5, :cond_2

    .line 389
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const v6, 0x7f060102

    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v7, v5}, Lcom/poshmark/ui/fragments/SignupFormFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 391
    :cond_2
    iget-object v4, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v4, v4, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v5, Lcom/poshmark/data_model/models/PMErrorType;->EMAIL_TAKEN:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v4, v5, :cond_3

    .line 392
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const v6, 0x7f0600da

    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v7, v5}, Lcom/poshmark/ui/fragments/SignupFormFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 394
    :cond_3
    iget-object v4, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v4, v4, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v5, Lcom/poshmark/data_model/models/PMErrorType;->INVALID_REFERRAL_CODE:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v4, v5, :cond_4

    .line 395
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const v6, 0x7f0600e1

    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v7, v5}, Lcom/poshmark/ui/fragments/SignupFormFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 398
    :cond_4
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    new-instance v5, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v6, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v7, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->USER_SIGNUP:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v8

    const v9, 0x7f0600d7

    invoke-virtual {v8, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v8

    sget-object v9, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v5, v6, v7, v8, v9}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/SignupFormFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
