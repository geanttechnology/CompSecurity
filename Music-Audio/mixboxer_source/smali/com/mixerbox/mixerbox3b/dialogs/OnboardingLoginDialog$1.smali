.class Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 37
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 38
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldSendNoti:Z

    .line 39
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->closePlayer()V

    .line 42
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSignUp:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    iput v1, v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->checkLoginType:I

    .line 43
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSignUp:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->performClick()Z

    .line 44
    return-void
.end method
