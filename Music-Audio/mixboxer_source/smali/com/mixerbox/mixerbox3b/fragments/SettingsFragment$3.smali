.class Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

.field final synthetic val$jAd:Lorg/json/JSONObject;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;Lorg/json/JSONObject;)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3;->val$jAd:Lorg/json/JSONObject;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 141
    const-string v0, "page:open_ad"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 142
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-direct {v1, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 143
    new-instance v2, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;-><init>(Landroid/content/Context;)V

    .line 146
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3;->val$jAd:Lorg/json/JSONObject;

    const-string v3, "link"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;->loadUrl(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 150
    :goto_0
    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 151
    new-instance v0, Landroid/webkit/WebChromeClient;

    invoke-direct {v0}, Landroid/webkit/WebChromeClient;-><init>()V

    invoke-virtual {v2, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 152
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3$1;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3;)V

    invoke-virtual {v2, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 174
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 175
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f08007e

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3$2;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3;)V

    invoke-virtual {v1, v0, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 181
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    move-result-object v0

    .line 182
    invoke-virtual {v0}, Landroid/app/AlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 183
    return-void

    .line 147
    :catch_0
    move-exception v0

    .line 148
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method
