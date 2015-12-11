.class Lcom/amazon/device/ads/MraidRenderer;
.super Lcom/amazon/device/ads/AdRenderer;
.source "MraidRenderer.java"

# interfaces
.implements Lcom/amazon/device/ads/MraidView$OnCloseListener;
.implements Lcom/amazon/device/ads/MraidView$OnExpandListener;
.implements Lcom/amazon/device/ads/MraidView$OnReadyListener;
.implements Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/MraidRenderer$1;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "MraidRenderer"


# instance fields
.field protected mraidView_:Lcom/amazon/device/ads/MraidView;

.field private webView_:Landroid/webkit/WebView;


# direct methods
.method protected constructor <init>(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/IAdController;Landroid/webkit/WebView;Landroid/content/Context;)V
    .locals 0
    .param p1, "ad"    # Lcom/amazon/device/ads/AdData;
    .param p2, "controller"    # Lcom/amazon/device/ads/IAdController;
    .param p3, "webView"    # Landroid/webkit/WebView;
    .param p4, "context"    # Landroid/content/Context;

    .prologue
    .line 35
    invoke-direct {p0, p1, p2, p4}, Lcom/amazon/device/ads/AdRenderer;-><init>(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/IAdController;Landroid/content/Context;)V

    .line 36
    iput-object p3, p0, Lcom/amazon/device/ads/MraidRenderer;->webView_:Landroid/webkit/WebView;

    .line 37
    return-void
.end method


# virtual methods
.method protected adLoaded(Lcom/amazon/device/ads/AdProperties;)V
    .locals 0
    .param p1, "props"    # Lcom/amazon/device/ads/AdProperties;

    .prologue
    .line 186
    invoke-super {p0, p1}, Lcom/amazon/device/ads/AdRenderer;->adLoaded(Lcom/amazon/device/ads/AdProperties;)V

    .line 187
    return-void
.end method

.method protected createNewMraidView()Lcom/amazon/device/ads/MraidView;
    .locals 8

    .prologue
    .line 96
    new-instance v0, Lcom/amazon/device/ads/MraidView;

    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v1}, Lcom/amazon/device/ads/IAdController;->getWindowWidth()I

    move-result v2

    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v1}, Lcom/amazon/device/ads/IAdController;->getWindowHeight()I

    move-result v3

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidRenderer;->getScalingMultiplier()D

    move-result-wide v4

    iget-object v6, p0, Lcom/amazon/device/ads/MraidRenderer;->context:Landroid/content/Context;

    iget-object v7, p0, Lcom/amazon/device/ads/MraidRenderer;->webView_:Landroid/webkit/WebView;

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/amazon/device/ads/MraidView;-><init>(Lcom/amazon/device/ads/AdView;IIDLandroid/content/Context;Landroid/webkit/WebView;)V

    return-object v0
.end method

.method protected destroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 166
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    if-eqz v0, :cond_0

    .line 168
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->destroy()V

    .line 169
    iput-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    .line 170
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/MraidRenderer;->isDestroyed:Z

    .line 173
    :cond_0
    iput-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->webView_:Landroid/webkit/WebView;

    .line 174
    return-void
.end method

.method protected getAdState(Lcom/amazon/device/ads/AdRenderer$AdState;)Z
    .locals 3
    .param p1, "c"    # Lcom/amazon/device/ads/AdRenderer$AdState;

    .prologue
    const/4 v0, 0x0

    .line 47
    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    if-nez v1, :cond_0

    .line 49
    const-string/jumbo v1, "MraidRenderer"

    const-string/jumbo v2, "Unable to retrieve ad state."

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    :goto_0
    return v0

    .line 57
    :cond_0
    sget-object v1, Lcom/amazon/device/ads/MraidRenderer$1;->$SwitchMap$com$amazon$device$ads$AdRenderer$AdState:[I

    invoke-virtual {p1}, Lcom/amazon/device/ads/AdRenderer$AdState;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 60
    :pswitch_0
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->isExpanded()Z

    move-result v0

    goto :goto_0

    .line 57
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public launchExternalBrowserForLink(Ljava/lang/String;)Z
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 246
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidRenderer;->isAdViewRenderable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 248
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->context:Landroid/content/Context;

    invoke-static {p1, v0}, Lcom/amazon/device/ads/AdUtils;->launchActivityForIntentLink(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v0

    .line 250
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onClose(Lcom/amazon/device/ads/MraidView;Lcom/amazon/device/ads/MraidView$ViewState;)V
    .locals 1
    .param p1, "view"    # Lcom/amazon/device/ads/MraidView;
    .param p2, "newViewState"    # Lcom/amazon/device/ads/MraidView$ViewState;

    .prologue
    .line 221
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidRenderer;->isAdViewRemoved()Z

    move-result v0

    if-nez v0, :cond_0

    .line 222
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->adClosedExpansion()V

    .line 223
    :cond_0
    return-void
.end method

.method public onExpand(Lcom/amazon/device/ads/MraidView;)V
    .locals 1
    .param p1, "view"    # Lcom/amazon/device/ads/MraidView;

    .prologue
    .line 214
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidRenderer;->isAdViewRemoved()Z

    move-result v0

    if-nez v0, :cond_0

    .line 215
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->adExpanded()V

    .line 216
    :cond_0
    return-void
.end method

.method public onPageFinished()V
    .locals 2

    .prologue
    .line 234
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    if-nez v0, :cond_0

    .line 236
    const-string/jumbo v0, "MraidRenderer"

    const-string/jumbo v1, "Call to onPageFinished() ignored because view is null."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 241
    :goto_0
    return-void

    .line 240
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->onPageFinished()V

    goto :goto_0
.end method

.method public onReady(Lcom/amazon/device/ads/MraidView;)V
    .locals 1
    .param p1, "view"    # Lcom/amazon/device/ads/MraidView;

    .prologue
    .line 208
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getProperties()Lcom/amazon/device/ads/AdProperties;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidRenderer;->adLoaded(Lcom/amazon/device/ads/AdProperties;)V

    .line 209
    return-void
.end method

.method public onSpecialUrlClick(Lcom/amazon/device/ads/MraidView;Ljava/lang/String;)V
    .locals 1
    .param p1, "view"    # Lcom/amazon/device/ads/MraidView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 256
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidRenderer;->isAdViewRenderable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 258
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidRenderer;->getSpecialUrlExecutor()Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;

    move-result-object v0

    invoke-interface {v0, p2}, Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;->execute(Ljava/lang/String;)Z

    .line 260
    :cond_0
    return-void
.end method

.method protected prepareToGoAway()V
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->prepareToGoAway()V

    .line 181
    :cond_0
    return-void
.end method

.method protected removeView()V
    .locals 1

    .prologue
    .line 126
    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidRenderer;->viewRemoved:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidRenderer;->isDestroyed:Z

    if-nez v0, :cond_0

    .line 136
    :try_start_0
    iget-object v0, p0, Lcom/amazon/device/ads/MraidRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->getAdLayout()Lcom/amazon/device/ads/AdLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdLayout;->removeAllViews()V
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 159
    :goto_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/MraidRenderer;->viewRemoved:Z

    .line 161
    :cond_0
    return-void

    .line 138
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected render()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 69
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidRenderer;->isAdViewDestroyed()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 87
    :cond_0
    :goto_0
    return v0

    .line 74
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidRenderer;->createNewMraidView()Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    .line 76
    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getShouldForceRenderFailure()Z

    move-result v1

    if-nez v1, :cond_0

    .line 81
    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    iget-object v2, p0, Lcom/amazon/device/ads/MraidRenderer;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getCreative()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/MraidView;->loadHtmlData(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 86
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidRenderer;->renderMraidView()V

    .line 87
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected renderMraidView()V
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "InlinedApi"
        }
    .end annotation

    .prologue
    const/4 v2, -0x1

    .line 110
    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v1, p0}, Lcom/amazon/device/ads/MraidView;->setOnReadyListener(Lcom/amazon/device/ads/MraidView$OnReadyListener;)V

    .line 111
    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v1, p0}, Lcom/amazon/device/ads/MraidView;->setOnSpecialUrlClickListener(Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;)V

    .line 112
    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v1, p0}, Lcom/amazon/device/ads/MraidView;->setOnExpandListener(Lcom/amazon/device/ads/MraidView$OnExpandListener;)V

    .line 113
    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v1, p0}, Lcom/amazon/device/ads/MraidView;->setOnCloseListener(Lcom/amazon/device/ads/MraidView$OnCloseListener;)V

    .line 115
    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v1}, Lcom/amazon/device/ads/IAdController;->getAdLayout()Lcom/amazon/device/ads/AdLayout;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/AdLayout;->removeAllViews()V

    .line 116
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    const/16 v1, 0x11

    invoke-direct {v0, v2, v2, v1}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    .line 120
    .local v0, "layoutParams":Landroid/widget/FrameLayout$LayoutParams;
    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v1}, Lcom/amazon/device/ads/IAdController;->getAdLayout()Lcom/amazon/device/ads/AdLayout;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/device/ads/AdLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 121
    return-void
.end method

.method protected sendCommand(Ljava/lang/String;Ljava/util/Map;)Z
    .locals 5
    .param p1, "command"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p2, "args":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 192
    const-string/jumbo v2, "MraidRenderer"

    const-string/jumbo v3, "sendCommand: %s"

    new-array v4, v0, [Ljava/lang/Object;

    aput-object p1, v4, v1

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 193
    const-string/jumbo v2, "close"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 195
    iget-object v2, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v2}, Lcom/amazon/device/ads/MraidView;->getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/MraidDisplayController;->isExpanded()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 197
    iget-object v1, p0, Lcom/amazon/device/ads/MraidRenderer;->mraidView_:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidDisplayController;->close()V

    .line 202
    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method protected shouldReuse()Z
    .locals 1

    .prologue
    .line 228
    const/4 v0, 0x0

    return v0
.end method
