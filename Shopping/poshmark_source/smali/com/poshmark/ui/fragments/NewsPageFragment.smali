.class public Lcom/poshmark/ui/fragments/NewsPageFragment;
.super Lcom/poshmark/ui/fragments/MappPageFragment;
.source "NewsPageFragment.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    const-string v0, "nw"

    return-object v0
.end method

.method public launchWebView(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "analyticsPageName"    # Ljava/lang/String;

    .prologue
    .line 79
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 80
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "URL"

    invoke-virtual {v1, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    const-string v2, "ANALYTICS_PAGE_NAME"

    invoke-virtual {v1, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewsPageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 83
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 84
    return-void
.end method

.method protected loadComplete(Landroid/webkit/WebView;)V
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;

    .prologue
    .line 73
    const-string v0, "com.poshmark.intents.CLEAR_NEWS_BADGE"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 74
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewsPageFragment;->hideProgressDialog()V

    .line 75
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 25
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "/mapp/users/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/notifications?pageName=NEWS_ROOT"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 26
    .local v1, "urlPath":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "https://www.poshmark.com"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/NewsPageFragment;->url:Ljava/lang/String;

    .line 29
    iget-object v2, p0, Lcom/poshmark/ui/fragments/NewsPageFragment;->url:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 30
    .local v0, "uri":Landroid/net/Uri;
    invoke-virtual {v0}, Landroid/net/Uri;->getEncodedAuthority()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/NewsPageFragment;->authority:Ljava/lang/String;

    .line 31
    invoke-virtual {v0}, Landroid/net/Uri;->getEncodedPath()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/NewsPageFragment;->path:Ljava/lang/String;

    .line 32
    invoke-virtual {v0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/NewsPageFragment;->lastPathSegment:Ljava/lang/String;

    .line 33
    const-string v2, "NEWS_ROOT"

    iput-object v2, p0, Lcom/poshmark/ui/fragments/NewsPageFragment;->pageName:Ljava/lang/String;

    .line 36
    sget-object v2, Lcom/poshmark/utils/NewRelicCustomInteractions;->NEWS_FEED_REFRESH:Ljava/lang/String;

    invoke-static {v2}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 41
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/MappPageFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 42
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 87
    const-string v0, "news_feed_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/NewsPageFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 46
    invoke-super {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->setupActionBar()V

    .line 47
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/NewsPageFragment;->bShowRefreshButton:Z

    if-eqz v0, :cond_0

    .line 48
    const v0, 0x7f0601cb

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/NewsPageFragment;->setTitle(I)V

    .line 49
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/NewsPageFragment;->showFindPeopleButton(Z)V

    .line 50
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/NewsPageFragment;->showRefreshButton(Z)V

    .line 51
    new-instance v0, Lcom/poshmark/ui/fragments/NewsPageFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/NewsPageFragment$1;-><init>(Lcom/poshmark/ui/fragments/NewsPageFragment;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/NewsPageFragment;->setRefreshActionButtonListener(Landroid/view/View$OnClickListener;)V

    .line 62
    :cond_0
    return-void
.end method
