.class Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14;
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
    .line 456
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 459
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 460
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->NoNetworkAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 461
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 493
    :goto_0
    return-void

    .line 464
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 465
    new-instance v1, Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 466
    const-string v2, "http://static.mixerbox.com/inAppWeb/mb.copyright.info.android.html"

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 467
    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14$1;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14;)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 486
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 487
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08007e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14$2;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 492
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_0
.end method
