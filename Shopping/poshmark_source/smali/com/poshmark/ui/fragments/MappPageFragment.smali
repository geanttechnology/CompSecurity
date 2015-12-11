.class public Lcom/poshmark/ui/fragments/MappPageFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "MappPageFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;
    }
.end annotation


# static fields
.field public static final bundleLearnMoreURL:Ljava/lang/String; = "/mapp/bundles_help"

.field public static final externalLibrariesURL:Ljava/lang/String; = "/mapp/external_libraries"

.field public static final feePolicyURL:Ljava/lang/String; = "/mapp/fee_policy"

.field public static final findPeopleContactsURL:Ljava/lang/String; = "/mapp/find_people/contacts"

.field public static final nwtPolicyURL:Ljava/lang/String; = "/mapp/nwt_policy"

.field public static final privacyPolicyURL:Ljava/lang/String; = "/mapp/privacy_policy"

.field public static final termsAndConditionsURL:Ljava/lang/String; = "/mapp/terms_and_conditions"


# instance fields
.field actionbarButtonCommands:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/webcommands/WebCommand;",
            ">;"
        }
    .end annotation
.end field

.field authority:Ljava/lang/String;

.field bShowRefreshButton:Z

.field commandsManager:Lcom/poshmark/webcommands/WebCommandsManager;

.field lastPathSegment:Ljava/lang/String;

.field pageLoadComplete:Z

.field pageName:Ljava/lang/String;

.field path:Ljava/lang/String;

.field pendingCommandResult:Z

.field savedRequestCode:I

.field savedResultCode:I

.field savedResultData:Landroid/content/Intent;

.field title:Ljava/lang/String;

.field url:Ljava/lang/String;

.field webView:Landroid/webkit/WebView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 51
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 61
    iput-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    .line 62
    iput-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->url:Ljava/lang/String;

    .line 63
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->bShowRefreshButton:Z

    .line 64
    iput-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    .line 69
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->pageLoadComplete:Z

    .line 72
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->actionbarButtonCommands:Ljava/util/List;

    .line 78
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->pendingCommandResult:Z

    .line 396
    return-void
.end method

.method private setupWebClient()V
    .locals 4

    .prologue
    .line 297
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    new-instance v2, Lcom/poshmark/ui/fragments/MappPageFragment$6;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/MappPageFragment$6;-><init>(Lcom/poshmark/ui/fragments/MappPageFragment;)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 340
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    new-instance v2, Lcom/poshmark/ui/fragments/MappPageFragment$7;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/MappPageFragment$7;-><init>(Lcom/poshmark/ui/fragments/MappPageFragment;)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 363
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 364
    .local v0, "webSettings":Landroid/webkit/WebSettings;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 365
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    new-instance v2, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;-><init>(Lcom/poshmark/ui/fragments/MappPageFragment;Landroid/content/Context;)V

    const-string v3, "AndroidInterface"

    invoke-virtual {v1, v2, v3}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 366
    return-void
.end method


# virtual methods
.method public addActionBarButtonCommand(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 1
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 288
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->actionbarButtonCommands:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 289
    return-void
.end method

.method public fireJSCallback(Ljava/lang/String;)V
    .locals 3
    .param p1, "callback"    # Ljava/lang/String;

    .prologue
    .line 292
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p1}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 293
    return-void
.end method

.method public getLastPathSegment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 280
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->lastPathSegment:Ljava/lang/String;

    return-object v0
.end method

.method public getPageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 284
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->pageName:Ljava/lang/String;

    return-object v0
.end method

.method public getURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getUrlAuthority()Ljava/lang/String;
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->authority:Ljava/lang/String;

    return-object v0
.end method

.method public getUrlPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->path:Ljava/lang/String;

    return-object v0
.end method

.method public handleBack()Z
    .locals 1

    .prologue
    .line 386
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 387
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->goBack()V

    .line 388
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->clearHistory()V

    .line 389
    const/4 v0, 0x1

    .line 391
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public launchWebView(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "analyticsPageName"    # Ljava/lang/String;

    .prologue
    .line 251
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 252
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "URL"

    invoke-virtual {v1, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 253
    const-string v2, "ANALYTICS_PAGE_NAME"

    invoke-virtual {v1, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 254
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 255
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMActivity;->replaceFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 256
    return-void
.end method

.method protected loadComplete(Landroid/webkit/WebView;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;

    .prologue
    .line 369
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->pageLoadComplete:Z

    .line 370
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->hideProgressDialog()V

    .line 378
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->pendingCommandResult:Z

    if-eqz v0, :cond_0

    .line 379
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->pendingCommandResult:Z

    .line 380
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->commandsManager:Lcom/poshmark/webcommands/WebCommandsManager;

    iget v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->savedRequestCode:I

    iget v2, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->savedResultCode:I

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->savedResultData:Landroid/content/Intent;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/webcommands/WebCommandsManager;->handleCommandResult(IILandroid/content/Intent;)V

    .line 382
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 138
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 139
    const-string v1, "PM Callback"

    const-string v2, "OnActivityCreated"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 140
    if-nez p1, :cond_1

    .line 141
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->actionbarButtonCommands:Ljava/util/List;

    .line 146
    :goto_0
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    .line 147
    .local v0, "cookieManager":Landroid/webkit/CookieManager;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0318

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/webkit/WebView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    .line 148
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->setupWebClient()V

    .line 150
    invoke-virtual {v0}, Landroid/webkit/CookieManager;->hasCookies()Z

    move-result v1

    if-nez v1, :cond_0

    .line 151
    const-string v1, "PMLogging"

    const-string v2, "No Cookies"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplication;->setCookieInJar()V

    .line 155
    :cond_0
    if-eqz p1, :cond_2

    .line 156
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v1, p1}, Landroid/webkit/WebView;->restoreState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;

    .line 161
    :goto_1
    return-void

    .line 143
    .end local v0    # "cookieManager":Landroid/webkit/CookieManager;
    :cond_1
    const-string v1, "MAPP_PAGE_TITLE"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    goto :goto_0

    .line 158
    .restart local v0    # "cookieManager":Landroid/webkit/CookieManager;
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->url:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 159
    const v1, 0x7f060190

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 165
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 166
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->pageLoadComplete:Z

    if-eqz v0, :cond_0

    .line 167
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->commandsManager:Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-virtual {v0, p1, p2, p3}, Lcom/poshmark/webcommands/WebCommandsManager;->handleCommandResult(IILandroid/content/Intent;)V

    .line 175
    :goto_0
    return-void

    .line 170
    :cond_0
    iput p1, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->savedRequestCode:I

    .line 171
    iput p2, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->savedResultCode:I

    .line 172
    iput-object p3, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->savedResultData:Landroid/content/Intent;

    .line 173
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->pendingCommandResult:Z

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 11
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 84
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 85
    const-string v8, "PM Callback"

    const-string v9, "onCreate"

    invoke-static {v8, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 86
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v8

    const-string v9, "URL"

    invoke-virtual {v8, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->url:Ljava/lang/String;

    .line 87
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v8

    const-string v9, "SHOW_REFRESH"

    const/4 v10, 0x0

    invoke-virtual {v8, v9, v10}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v8

    iput-boolean v8, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->bShowRefreshButton:Z

    .line 88
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v8

    const-string v9, "TITLE"

    invoke-virtual {v8, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    .line 90
    iget-object v8, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->url:Ljava/lang/String;

    invoke-static {v8}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    .line 91
    .local v6, "uri":Landroid/net/Uri;
    invoke-virtual {v6}, Landroid/net/Uri;->getEncodedAuthority()Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->authority:Ljava/lang/String;

    .line 92
    invoke-virtual {v6}, Landroid/net/Uri;->getEncodedPath()Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->path:Ljava/lang/String;

    .line 93
    invoke-virtual {v6}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->lastPathSegment:Ljava/lang/String;

    .line 94
    const-string v8, "pageName"

    invoke-virtual {v6, v8}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->pageName:Ljava/lang/String;

    .line 96
    new-instance v9, Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    check-cast v8, Lcom/poshmark/ui/PMActivity;

    invoke-direct {v9, v8, p0}, Lcom/poshmark/webcommands/WebCommandsManager;-><init>(Lcom/poshmark/ui/PMActivity;Lcom/poshmark/ui/fragments/MappPageFragment;)V

    iput-object v9, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->commandsManager:Lcom/poshmark/webcommands/WebCommandsManager;

    .line 97
    if-eqz p1, :cond_0

    .line 98
    const-string v8, "VISIBILITY_HINT"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v7

    .line 99
    .local v7, "visible":Z
    invoke-virtual {p0, v7}, Lcom/poshmark/ui/fragments/MappPageFragment;->setUserVisibleHint(Z)V

    .line 100
    if-nez v7, :cond_1

    .line 101
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    invoke-virtual {v8}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 102
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v5

    .line 103
    .local v5, "transaction":Landroid/support/v4/app/FragmentTransaction;
    invoke-virtual {v5, p0}, Landroid/support/v4/app/FragmentTransaction;->hide(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 104
    invoke-virtual {v5}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 126
    .end local v1    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v5    # "transaction":Landroid/support/v4/app/FragmentTransaction;
    .end local v7    # "visible":Z
    :cond_0
    :goto_0
    return-void

    .line 109
    .restart local v7    # "visible":Z
    :cond_1
    const-string v8, "LIST_OF_PENDING_COMMANDS"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 110
    .local v2, "json":Ljava/lang/String;
    if-eqz v2, :cond_2

    .line 111
    new-instance v4, Lcom/poshmark/ui/fragments/MappPageFragment$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/MappPageFragment$1;-><init>(Lcom/poshmark/ui/fragments/MappPageFragment;)V

    .line 112
    .local v4, "mapOfCommands":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v2, v4}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    .line 113
    .local v0, "commandsWaitingForResults":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Integer;Lcom/poshmark/webcommands/WebCommand;>;"
    iget-object v8, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->commandsManager:Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-virtual {v8, v0}, Lcom/poshmark/webcommands/WebCommandsManager;->setPendingCommandsMap(Ljava/util/Map;)V

    .line 114
    iget-object v8, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->commandsManager:Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-virtual {v8}, Lcom/poshmark/webcommands/WebCommandsManager;->reAttachHandlersToPendingCommands()V

    .line 117
    .end local v0    # "commandsWaitingForResults":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Integer;Lcom/poshmark/webcommands/WebCommand;>;"
    .end local v4    # "mapOfCommands":Lcom/google/gson/reflect/TypeToken;
    :cond_2
    const-string v8, "LIST_OF_BUTTON_COMMANDS"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 118
    if-eqz v2, :cond_0

    .line 119
    const-string v8, "Mapp actions"

    invoke-static {v8, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 120
    new-instance v3, Lcom/poshmark/ui/fragments/MappPageFragment$2;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/MappPageFragment$2;-><init>(Lcom/poshmark/ui/fragments/MappPageFragment;)V

    .line 121
    .local v3, "listOfCommands":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v2, v3}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    iput-object v8, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->actionbarButtonCommands:Ljava/util/List;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 130
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 131
    const-string v1, "PM Callback"

    const-string v2, "onCreateView"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 132
    const v1, 0x7f0300d2

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 133
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 179
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->hideProgressDialog()V

    .line 180
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroy()V

    .line 181
    return-void
.end method

.method public onHiddenChanged(Z)V
    .locals 1
    .param p1, "hidden"    # Z

    .prologue
    .line 186
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    if-eqz v0, :cond_0

    if-nez p1, :cond_0

    .line 187
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->setupActionBar()V

    .line 188
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->setTitle(Ljava/lang/String;)V

    .line 190
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 216
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 217
    iget-object v6, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->actionbarButtonCommands:Ljava/util/List;

    if-eqz v6, :cond_0

    .line 218
    new-instance v6, Lcom/poshmark/ui/fragments/MappPageFragment$3;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/MappPageFragment$3;-><init>(Lcom/poshmark/ui/fragments/MappPageFragment;)V

    invoke-virtual {v6}, Lcom/poshmark/ui/fragments/MappPageFragment$3;->getType()Ljava/lang/reflect/Type;

    move-result-object v2

    .line 219
    .local v2, "listOfCommands":Ljava/lang/reflect/Type;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->actionbarButtonCommands:Ljava/util/List;

    invoke-static {v6, v2}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    .line 220
    .local v1, "json":Ljava/lang/String;
    const-string v6, "LIST_OF_BUTTON_COMMANDS"

    invoke-virtual {p1, v6, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    new-instance v4, Lcom/poshmark/ui/fragments/MappPageFragment$4;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/MappPageFragment$4;-><init>(Lcom/poshmark/ui/fragments/MappPageFragment;)V

    .line 224
    .local v4, "token":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v1, v4}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    iput-object v6, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->actionbarButtonCommands:Ljava/util/List;

    .line 228
    .end local v1    # "json":Ljava/lang/String;
    .end local v2    # "listOfCommands":Ljava/lang/reflect/Type;
    .end local v4    # "token":Lcom/google/gson/reflect/TypeToken;
    :cond_0
    iget-object v6, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->commandsManager:Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-virtual {v6}, Lcom/poshmark/webcommands/WebCommandsManager;->getPendingCommands()Ljava/util/Map;

    move-result-object v3

    .line 229
    .local v3, "pendingCommands":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Lcom/poshmark/webcommands/WebCommand;>;"
    if-eqz v3, :cond_1

    invoke-interface {v3}, Ljava/util/Map;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_1

    .line 230
    new-instance v6, Lcom/poshmark/ui/fragments/MappPageFragment$5;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/MappPageFragment$5;-><init>(Lcom/poshmark/ui/fragments/MappPageFragment;)V

    invoke-virtual {v6}, Lcom/poshmark/ui/fragments/MappPageFragment$5;->getType()Ljava/lang/reflect/Type;

    move-result-object v2

    .line 231
    .restart local v2    # "listOfCommands":Ljava/lang/reflect/Type;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->commandsManager:Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-virtual {v6}, Lcom/poshmark/webcommands/WebCommandsManager;->getPendingCommands()Ljava/util/Map;

    move-result-object v6

    invoke-static {v6, v2}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/Map;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    .line 232
    .restart local v1    # "json":Ljava/lang/String;
    const-string v6, "LIST_OF_PENDING_COMMANDS"

    invoke-virtual {p1, v6, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 235
    .end local v1    # "json":Ljava/lang/String;
    .end local v2    # "listOfCommands":Ljava/lang/reflect/Type;
    :cond_1
    iget-object v6, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    if-eqz v6, :cond_2

    .line 236
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 237
    .local v0, "id":Ljava/util/UUID;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    invoke-static {v0, v6}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 238
    const-string v6, "MAPP_PAGE_TITLE"

    new-instance v7, Landroid/os/ParcelUuid;

    invoke-direct {v7, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v6, v7}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 239
    const-string v6, "MAPP_PAGE_TITLE"

    iget-object v7, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    invoke-virtual {p1, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 243
    .end local v0    # "id":Ljava/util/UUID;
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getUserVisibleHint()Z

    move-result v5

    .line 244
    .local v5, "visibile":Z
    const-string v6, "VISIBILITY_HINT"

    invoke-virtual {p1, v6, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 246
    iget-object v6, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v6, p1}, Landroid/webkit/WebView;->saveState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;

    .line 247
    return-void
.end method

.method public reload()V
    .locals 1

    .prologue
    .line 267
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 268
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->reload()V

    .line 269
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 3

    .prologue
    .line 259
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ANALYTICS_PAGE_NAME"

    const-string v2, "mapp_screen"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 260
    return-void
.end method

.method public setupActionBar()V
    .locals 3

    .prologue
    .line 194
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 196
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 197
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->title:Ljava/lang/String;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MappPageFragment;->setTitle(Ljava/lang/String;)V

    .line 201
    :goto_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->actionbarButtonCommands:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    .line 205
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->actionbarButtonCommands:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 207
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->actionbarButtonCommands:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/webcommands/WebCommand;

    .line 208
    .local v0, "cmd":Lcom/poshmark/webcommands/WebCommand;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->actionbarButtonCommands:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 209
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MappPageFragment;->commandsManager:Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-virtual {v2, v0}, Lcom/poshmark/webcommands/WebCommandsManager;->fireCommand(Lcom/poshmark/webcommands/WebCommand;)V

    .line 205
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 199
    .end local v0    # "cmd":Lcom/poshmark/webcommands/WebCommand;
    .end local v1    # "i":I
    :cond_0
    const-string v2, ""

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MappPageFragment;->setTitle(Ljava/lang/String;)V

    goto :goto_0

    .line 212
    :cond_1
    return-void
.end method
