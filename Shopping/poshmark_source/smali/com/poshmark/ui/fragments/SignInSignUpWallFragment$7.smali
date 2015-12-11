.class Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;
.super Ljava/lang/Object;
.source "SignInSignUpWallFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->fbLloginComplete(Ljava/lang/String;Ljava/lang/String;)V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;)V
    .locals 0

    .prologue
    .line 290
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 5
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
    .line 293
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/user/UserInfo;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 294
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->hideProgressDialog()V

    .line 295
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 297
    sget-object v0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->markAsExpired()V

    .line 298
    sget-object v0, Lcom/poshmark/utils/DeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/DeferredDeepLinkManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/DeferredDeepLinkManager;->markAsExpired()V

    .line 299
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/user/UserInfo;

    # invokes: Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->login(Lcom/poshmark/user/UserInfo;)V
    invoke-static {v1, v0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->access$100(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;Lcom/poshmark/user/UserInfo;)V

    .line 322
    :cond_0
    :goto_0
    return-void

    .line 300
    :cond_1
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v0, v0, Lcom/poshmark/http/api/PMApiError;->pmError:Lcom/poshmark/data_model/models/PMError;

    if-eqz v0, :cond_0

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v0, v0, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_NOT_FOUND:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v0, v1, :cond_0

    .line 301
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "user"

    const-string v3, "facebook_signup_flow_initiated"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 303
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    const v2, 0x7f060190

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 304
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7$1;-><init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getMe(Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;)V

    goto :goto_0
.end method
