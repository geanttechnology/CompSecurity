.class Lcom/poshmark/ui/fragments/MappPageFragment$6;
.super Landroid/webkit/WebViewClient;
.source "MappPageFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MappPageFragment;->setupWebClient()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MappPageFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MappPageFragment;)V
    .locals 0

    .prologue
    .line 297
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MappPageFragment$6;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 311
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment$6;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/fragments/MappPageFragment;->loadComplete(Landroid/webkit/WebView;)V

    .line 312
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 306
    const/16 v0, 0x12e

    if-ne p2, v0, :cond_0

    .line 308
    :cond_0
    return-void
.end method

.method public onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
    .locals 0
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "handler"    # Landroid/webkit/SslErrorHandler;
    .param p3, "error"    # Landroid/net/http/SslError;

    .prologue
    .line 301
    invoke-virtual {p2}, Landroid/webkit/SslErrorHandler;->proceed()V

    .line 302
    return-void
.end method

.method public shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 335
    const/4 v0, 0x0

    return-object v0
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 5
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 316
    if-nez p2, :cond_0

    .line 330
    :goto_0
    return v0

    .line 319
    :cond_0
    const-string v2, "market://"

    invoke-virtual {p2, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 320
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.VIEW"

    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {v0, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    move v0, v1

    .line 321
    goto :goto_0

    .line 324
    :cond_1
    const-string v2, "mailto:"

    invoke-virtual {p2, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 325
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment$6;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p2}, Lcom/poshmark/utils/ExternalAppUtils;->showEmailClientForURL(Landroid/content/Context;Ljava/lang/String;)V

    move v0, v1

    .line 326
    goto :goto_0

    .line 329
    :cond_2
    new-instance v1, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MappPageFragment$6;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MappPageFragment$6;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MappPageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;-><init>(Lcom/poshmark/ui/fragments/MappPageFragment;Landroid/content/Context;)V

    const-string v2, "AndroidInterface"

    invoke-virtual {p1, v1, v2}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    goto :goto_0
.end method
