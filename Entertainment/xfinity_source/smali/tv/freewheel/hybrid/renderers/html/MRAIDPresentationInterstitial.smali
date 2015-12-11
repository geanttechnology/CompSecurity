.class Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;
.super Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;
.source "MRAIDPresentationInterstitial.java"


# instance fields
.field private interstitialView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

.field private logger:Ltv/freewheel/hybrid/utils/Logger;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Z)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "bridge"    # Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;
    .param p3, "enableMRAID"    # Z

    .prologue
    const/4 v1, 0x1

    .line 11
    invoke-direct {p0, p1, p2, p3}, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;-><init>(Landroid/app/Activity;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Z)V

    .line 12
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 13
    new-instance v0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-direct {v0, p1, p2, v1, p3}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;-><init>(Landroid/app/Activity;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;ZZ)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->interstitialView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    .line 14
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->interstitialView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->setFullScreen(Z)V

    .line 15
    return-void
.end method


# virtual methods
.method public close()V
    .locals 2

    .prologue
    .line 53
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "close"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 54
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->interstitialView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->closeCustomView()V

    .line 55
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->removeView()V

    .line 56
    return-void
.end method

.method public collapse()V
    .locals 2

    .prologue
    .line 48
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "collapse, do nothing in interstitial presentation"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 49
    return-void
.end method

.method public dispose()V
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->interstitialView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->dispose()V

    .line 84
    return-void
.end method

.method public expand(Ljava/lang/String;II)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 43
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "expand, do nothing in interstitial presentation"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 44
    return-void
.end method

.method public getAbsoluteURL(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 65
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->interstitialView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->URLWithBaseURL(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentView()Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->interstitialView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    return-object v0
.end method

.method public getDefaultPositionOnScreen([I)V
    .locals 2
    .param p1, "location"    # [I

    .prologue
    const/4 v1, 0x0

    .line 75
    aput v1, p1, v1

    .line 76
    const/4 v0, 0x1

    aput v1, p1, v0

    .line 77
    const/4 v0, 0x2

    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->getFullScreenWidth()I

    move-result v1

    aput v1, p1, v0

    .line 78
    const/4 v0, 0x3

    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->getFullScreenHeight()I

    move-result v1

    aput v1, p1, v0

    .line 79
    return-void
.end method

.method public loadContent(Ljava/lang/String;)V
    .locals 6
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 26
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v2, "loadContent"

    invoke-virtual {v0, v2}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 27
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->interstitialView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    const-string v4, "utf-8"

    move-object v2, p1

    move-object v3, v1

    move-object v5, v1

    invoke-virtual/range {v0 .. v5}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    return-void
.end method

.method public loadURL(Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 19
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "loadURL("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 20
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->interstitialView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->loadUrl(Ljava/lang/String;)V

    .line 22
    return-void
.end method

.method public runJavaScript(Ljava/lang/String;)V
    .locals 1
    .param p1, "script"    # Ljava/lang/String;

    .prologue
    .line 60
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->interstitialView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->runJavaScript(Ljava/lang/String;)V

    .line 61
    return-void
.end method

.method public show()V
    .locals 2

    .prologue
    .line 36
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "show"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 37
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->interstitialView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInterstitial;->addView(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)V

    .line 39
    return-void
.end method
