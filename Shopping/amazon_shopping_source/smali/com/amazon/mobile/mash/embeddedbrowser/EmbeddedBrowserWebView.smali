.class public Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;
.super Lcom/amazon/mobile/mash/MASHWebView;
.source "EmbeddedBrowserWebView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 28
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Lcom/amazon/mobile/mash/MASHWebView;-><init>(Lcom/amazon/mobile/mash/appcontext/AppContext;Landroid/content/Context;)V

    .line 29
    invoke-direct {p0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->initializeEmbeddedBrowser()V

    .line 30
    return-void
.end method

.method private initializeEmbeddedBrowser()V
    .locals 5
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetJavaScriptEnabled"
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 47
    invoke-virtual {p0, v4}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->setIsInEmbeddedBrowserMode(Z)V

    .line 48
    invoke-static {}, Lcom/amazon/mobile/mash/MASHApplicationFactory;->getInstance()Lcom/amazon/mobile/mash/MASHApplication;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mobile/mash/MASHApplication;->getAppCustomUserAgent()Ljava/lang/String;

    move-result-object v1

    .line 49
    .local v1, "userAgent":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 50
    .local v0, "settings":Landroid/webkit/WebSettings;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 51
    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 53
    :cond_0
    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 54
    invoke-virtual {v0, v3}, Landroid/webkit/WebSettings;->setSavePassword(Z)V

    .line 55
    invoke-virtual {v0, v3}, Landroid/webkit/WebSettings;->setSaveFormData(Z)V

    .line 56
    sget-object v2, Landroid/webkit/WebSettings$LayoutAlgorithm;->NARROW_COLUMNS:Landroid/webkit/WebSettings$LayoutAlgorithm;

    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setLayoutAlgorithm(Landroid/webkit/WebSettings$LayoutAlgorithm;)V

    .line 57
    return-void
.end method


# virtual methods
.method public isInEmbeddedBrowserMode()Z
    .locals 1

    .prologue
    .line 61
    const/4 v0, 0x1

    return v0
.end method
