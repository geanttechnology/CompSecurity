.class Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;
.super Landroid/webkit/WebViewClient;
.source "SourceFile"


# instance fields
.field loadingFinished:Z

.field redirect:Z

.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

.field final synthetic val$btnNext:Landroid/widget/ImageButton;

.field final synthetic val$btnPrev:Landroid/widget/ImageButton;

.field final synthetic val$wv:Landroid/webkit/WebView;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/WebFragment;Landroid/webkit/WebView;Landroid/widget/ImageButton;Landroid/widget/ImageButton;)V
    .locals 1

    .prologue
    .line 65
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->val$wv:Landroid/webkit/WebView;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->val$btnPrev:Landroid/widget/ImageButton;

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->val$btnNext:Landroid/widget/ImageButton;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    .line 67
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->loadingFinished:Z

    .line 68
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->redirect:Z

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 90
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->redirect:Z

    if-nez v0, :cond_0

    .line 91
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->loadingFinished:Z

    .line 93
    :cond_0
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->loadingFinished:Z

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->redirect:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 94
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/actionbarsherlock/app/SherlockFragmentActivity;

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->setSupportProgressBarIndeterminateVisibility(Z)V

    .line 98
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->val$wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 99
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->val$btnPrev:Landroid/widget/ImageButton;

    const v1, 0x7f020112

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 102
    :goto_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->val$wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoForward()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 103
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->val$btnNext:Landroid/widget/ImageButton;

    const v1, 0x7f020110

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 106
    :goto_2
    return-void

    .line 96
    :cond_1
    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->redirect:Z

    goto :goto_0

    .line 101
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->val$btnPrev:Landroid/widget/ImageButton;

    const v1, 0x7f020113

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto :goto_1

    .line 105
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->val$btnNext:Landroid/widget/ImageButton;

    const v1, 0x7f020111

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto :goto_2
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 72
    const-string v0, "fb://"

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "://play.google.com/store/apps/details?id="

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 73
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 74
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 75
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    invoke-virtual {v1, v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->startActivity(Landroid/content/Intent;)V

    move v0, v2

    .line 85
    :goto_0
    return v0

    .line 78
    :cond_1
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->loadingFinished:Z

    if-nez v0, :cond_2

    .line 79
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->redirect:Z

    .line 81
    :cond_2
    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->loadingFinished:Z

    .line 82
    invoke-virtual {p1, p2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 83
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 84
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/actionbarsherlock/app/SherlockFragmentActivity;

    invoke-virtual {v0, v2}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->setSupportProgressBarIndeterminateVisibility(Z)V

    :cond_3
    move v0, v1

    .line 85
    goto :goto_0
.end method
