.class Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$11;
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
    .line 385
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$11;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 389
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$11;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 390
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$11;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->NoNetworkAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 391
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 403
    :goto_0
    return-void

    .line 395
    :cond_0
    const-string v0, "action:feedback"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 397
    :try_start_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const-string v2, "fb://profile/264387593636216"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 398
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$11;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1, v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 400
    :catch_0
    move-exception v0

    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const-string v2, "https://www.facebook.com/MixerBox"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 401
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$11;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1, v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method
