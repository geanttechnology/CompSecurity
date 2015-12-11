.class Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7$1;
.super Ljava/lang/Object;
.source "SignInSignUpWallFragment.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;)V
    .locals 0

    .prologue
    .line 304
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7$1;->this$1:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 3
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 316
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7$1;->this$1:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->hideProgressDialog()V

    .line 317
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7$1;->this$1:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->USER_SIGNUP:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, p1, v2}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    .line 318
    return-void
.end method

.method public success(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "userInfoBundle"    # Landroid/os/Bundle;

    .prologue
    .line 307
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7$1;->this$1:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->hideProgressDialog()V

    .line 308
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7$1;->this$1:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 309
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 310
    const-class v1, Lcom/poshmark/ui/fragments/SignupFormFragment;

    const/4 v2, 0x0

    invoke-virtual {v0, p1, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 312
    :cond_0
    return-void
.end method
