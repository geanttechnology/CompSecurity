.class Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4$1;
.super Landroid/webkit/WebViewClient;
.source "SourceFile"


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;)V
    .locals 0

    .prologue
    .line 205
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 6

    .prologue
    const/4 v0, 0x1

    .line 208
    const-string v1, "fb://"

    invoke-virtual {p2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "://play.google.com/store/apps/details?id="

    invoke-virtual {p2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 210
    :cond_0
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 211
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 212
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v2, v1}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    .line 224
    :goto_0
    return v0

    .line 215
    :cond_1
    const-string v1, "mailto:"

    invoke-virtual {p2, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 216
    invoke-static {p2}, Landroid/net/MailTo;->parse(Ljava/lang/String;)Landroid/net/MailTo;

    move-result-object v1

    .line 217
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.SEND"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 218
    const-string v3, "android.intent.extra.EMAIL"

    new-array v4, v0, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-virtual {v1}, Landroid/net/MailTo;->getTo()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 219
    const-string v1, "message/rfc822"

    invoke-virtual {v2, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 220
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 224
    :cond_2
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method
