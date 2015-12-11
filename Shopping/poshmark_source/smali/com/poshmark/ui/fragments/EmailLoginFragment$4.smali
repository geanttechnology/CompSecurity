.class Lcom/poshmark/ui/fragments/EmailLoginFragment$4;
.super Ljava/lang/Object;
.source "EmailLoginFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/EmailLoginFragment;->onLoginClicked()V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/EmailLoginFragment;)V
    .locals 0

    .prologue
    .line 115
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$4;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

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
            "Lcom/poshmark/user/UserInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/user/UserInfo;>;"
    const/4 v6, 0x0

    .line 118
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$4;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 119
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$4;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->hideProgressDialog()V

    .line 120
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v2

    if-nez v2, :cond_1

    .line 122
    sget-object v2, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->markAsExpired()V

    .line 123
    sget-object v2, Lcom/poshmark/utils/DeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/DeferredDeepLinkManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/DeferredDeepLinkManager;->markAsExpired()V

    .line 124
    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/user/UserInfo;

    .line 125
    .local v1, "userInfo":Lcom/poshmark/user/UserInfo;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    .line 126
    .local v0, "session":Lcom/poshmark/application/PMApplicationSession;
    invoke-virtual {v0, v1}, Lcom/poshmark/application/PMApplicationSession;->saveSession(Lcom/poshmark/user/UserInfo;)V

    .line 127
    const-string v2, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-static {v2}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 128
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "email_login_screen"

    const-string v4, "user"

    const-string v5, "login"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$4;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->finishActivity()V

    .line 144
    .end local v0    # "session":Lcom/poshmark/application/PMApplicationSession;
    .end local v1    # "userInfo":Lcom/poshmark/user/UserInfo;
    :cond_0
    :goto_0
    return-void

    .line 133
    :cond_1
    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v2, v2, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v3, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_UNAUTHORIZED:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v2, v3, :cond_2

    .line 134
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$4;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0600e0

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v6, v3}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 137
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$4;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

    new-instance v3, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v4, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v5, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->USER_LOGIN:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    const v7, 0x7f0600ef

    invoke-virtual {v6, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    sget-object v7, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v3, v4, v5, v6, v7}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
