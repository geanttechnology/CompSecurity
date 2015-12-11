.class Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3$1;
.super Ljava/lang/Object;
.source "SignInSignUpWallFragment.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;)V
    .locals 0

    .prologue
    .line 190
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3$1;->this$1:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 2
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 198
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3$1;->this$1:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    sget-object v1, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-static {p1, v0, v1}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->showGoogleLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    .line 199
    return-void
.end method

.method public success(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "userInfoBundle"    # Landroid/os/Bundle;

    .prologue
    .line 193
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3$1;->this$1:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->googleLoginComplete(Landroid/os/Bundle;)V

    .line 194
    return-void
.end method
