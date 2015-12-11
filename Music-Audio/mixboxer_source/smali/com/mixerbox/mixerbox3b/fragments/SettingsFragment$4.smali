.class Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

.field final synthetic val$s:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 197
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;->val$s:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 200
    const-string v0, "action:faq_open"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 201
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 202
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800ef

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 203
    new-instance v1, Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 204
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;->val$s:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 205
    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4$1;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 227
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 228
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08007e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4$2;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 234
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 235
    return-void
.end method
