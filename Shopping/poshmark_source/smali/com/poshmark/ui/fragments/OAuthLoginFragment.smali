.class public Lcom/poshmark/ui/fragments/OAuthLoginFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "OAuthLoginFragment.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "SetJavaScriptEnabled"
    }
.end annotation


# instance fields
.field parentActivity:Lcom/poshmark/ui/PMActivity;

.field url:Ljava/lang/String;

.field webView:Landroid/webkit/WebView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 26
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 27
    iput-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->webView:Landroid/webkit/WebView;

    .line 28
    iput-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->url:Ljava/lang/String;

    return-void
.end method

.method private setupWebClient()V
    .locals 3

    .prologue
    .line 59
    iget-object v1, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->webView:Landroid/webkit/WebView;

    new-instance v2, Lcom/poshmark/ui/fragments/OAuthLoginFragment$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/OAuthLoginFragment$1;-><init>(Lcom/poshmark/ui/fragments/OAuthLoginFragment;)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 89
    iget-object v1, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->webView:Landroid/webkit/WebView;

    new-instance v2, Lcom/poshmark/ui/fragments/OAuthLoginFragment$2;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/OAuthLoginFragment$2;-><init>(Lcom/poshmark/ui/fragments/OAuthLoginFragment;)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 97
    iget-object v1, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 98
    .local v0, "webSettings":Landroid/webkit/WebSettings;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 99
    return-void
.end method


# virtual methods
.method protected fireloginCompleteIntent(Ljava/lang/String;)V
    .locals 10
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 104
    :try_start_0
    new-instance v7, Ljava/net/URL;

    invoke-direct {v7, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 105
    .local v7, "uri":Ljava/net/URL;
    invoke-virtual {v7}, Ljava/net/URL;->getQuery()Ljava/lang/String;

    move-result-object v6

    .line 106
    .local v6, "params":Ljava/lang/String;
    const-string v8, "&"

    invoke-virtual {v6, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 107
    .local v5, "paramArray":[Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 108
    .local v0, "b":Landroid/os/Bundle;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v8, v5

    if-ge v2, v8, :cond_0

    .line 109
    aget-object v4, v5, v2

    .line 110
    .local v4, "param":Ljava/lang/String;
    const-string v8, "="

    invoke-virtual {v4, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 111
    .local v3, "keyValue":[Ljava/lang/String;
    const/4 v8, 0x0

    aget-object v8, v3, v8

    const/4 v9, 0x1

    aget-object v9, v3, v9

    invoke-virtual {v0, v8, v9}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 113
    .end local v3    # "keyValue":[Ljava/lang/String;
    .end local v4    # "param":Ljava/lang/String;
    :cond_0
    const-string v8, "com.poshmark.intents.OAUTH_REPONSE_OK"

    invoke-static {v8, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 119
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v2    # "i":I
    .end local v5    # "paramArray":[Ljava/lang/String;
    .end local v6    # "params":Ljava/lang/String;
    .end local v7    # "uri":Ljava/net/URL;
    :goto_1
    return-void

    .line 115
    :catch_0
    move-exception v1

    .line 117
    .local v1, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v1}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto :goto_1
.end method

.method public handleBack()Z
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 124
    iget-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->goBack()V

    .line 125
    iget-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->clearHistory()V

    .line 126
    const/4 v0, 0x1

    .line 128
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 45
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 46
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->parentActivity:Lcom/poshmark/ui/PMActivity;

    .line 47
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0318

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->webView:Landroid/webkit/WebView;

    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->setupWebClient()V

    .line 49
    iget-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->webView:Landroid/webkit/WebView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->url:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 50
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 51
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 33
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 34
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "URL"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->url:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 38
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 39
    const v1, 0x7f0300d2

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 40
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public setViewNameForAnalytics()V
    .locals 3

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ANALYTICS_PAGE_NAME"

    const-string v2, "oauth_login_screen"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/OAuthLoginFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 55
    return-void
.end method
