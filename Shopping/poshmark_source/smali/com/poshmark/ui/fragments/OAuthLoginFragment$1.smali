.class Lcom/poshmark/ui/fragments/OAuthLoginFragment$1;
.super Landroid/webkit/WebViewClient;
.source "OAuthLoginFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/OAuthLoginFragment;->setupWebClient()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/OAuthLoginFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/OAuthLoginFragment;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment$1;->this$0:Lcom/poshmark/ui/fragments/OAuthLoginFragment;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment$1;->this$0:Lcom/poshmark/ui/fragments/OAuthLoginFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->hideProgressDialog()V

    .line 71
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment$1;->this$0:Lcom/poshmark/ui/fragments/OAuthLoginFragment;

    invoke-virtual {v0, p3}, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;)V

    .line 67
    return-void
.end method

.method public onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
    .locals 0
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "handler"    # Landroid/webkit/SslErrorHandler;
    .param p3, "error"    # Landroid/net/http/SslError;

    .prologue
    .line 62
    invoke-virtual {p2}, Landroid/webkit/SslErrorHandler;->proceed()V

    .line 63
    return-void
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 74
    const-string v0, "http://localhost"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "oauth_verifier"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 75
    iget-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment$1;->this$0:Lcom/poshmark/ui/fragments/OAuthLoginFragment;

    invoke-virtual {v0, p2}, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->fireloginCompleteIntent(Ljava/lang/String;)V

    .line 76
    iget-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment$1;->this$0:Lcom/poshmark/ui/fragments/OAuthLoginFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->popTopFragment()V

    .line 84
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 77
    :cond_0
    const-string v0, "http://localhost"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "denied"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "#_=_"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 79
    :cond_1
    const-string v0, "com.poshmark.intents.OAUTH_CANCEL"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 80
    iget-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment$1;->this$0:Lcom/poshmark/ui/fragments/OAuthLoginFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->popTopFragment()V

    goto :goto_0

    .line 82
    :cond_2
    invoke-virtual {p1, p2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0
.end method
