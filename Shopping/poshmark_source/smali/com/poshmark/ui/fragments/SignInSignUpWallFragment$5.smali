.class Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$5;
.super Ljava/lang/Object;
.source "SignInSignUpWallFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->setupButtonHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;)V
    .locals 0

    .prologue
    .line 222
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$5;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 226
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$5;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 227
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v1, Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-virtual {v0, v5, v1, v5}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 228
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$5;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "user"

    const-string v4, "email_signup_flow_initiated"

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 229
    return-void
.end method
