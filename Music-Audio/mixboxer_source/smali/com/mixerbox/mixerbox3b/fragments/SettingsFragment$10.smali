.class Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$10;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V
    .locals 0

    .prologue
    .line 363
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$10;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 367
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$10;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 368
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$10;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->NoNetworkAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 369
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 381
    :goto_0
    return-void

    .line 373
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$10;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_1

    .line 374
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$10;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldSendNoti:Z

    .line 375
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$10;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->closePlayer()V

    .line 377
    :cond_1
    const-string v0, "action:setting_page_login"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 379
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$10;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSignUp:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    iput v1, v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->checkLoginType:I

    .line 380
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$10;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSignUp:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->performClick()Z

    goto :goto_0
.end method
