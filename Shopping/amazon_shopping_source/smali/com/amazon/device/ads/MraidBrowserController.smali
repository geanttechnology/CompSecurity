.class Lcom/amazon/device/ads/MraidBrowserController;
.super Lcom/amazon/device/ads/MraidAbstractController;
.source "MraidBrowserController.java"


# static fields
.field private static final LOGTAG:Ljava/lang/String; = "MraidBrowserController"


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidView;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/device/ads/MraidView;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/MraidAbstractController;-><init>(Lcom/amazon/device/ads/MraidView;)V

    .line 19
    return-void
.end method


# virtual methods
.method protected executeAmazonMobileCallback(Lcom/amazon/device/ads/MraidView;Ljava/lang/String;)V
    .locals 1
    .param p1, "view"    # Lcom/amazon/device/ads/MraidView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-virtual {p1}, Lcom/amazon/device/ads/MraidView;->getOnSpecialUrlClickListener()Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 32
    invoke-virtual {p1}, Lcom/amazon/device/ads/MraidView;->getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->isExpanded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 34
    invoke-virtual {p1}, Lcom/amazon/device/ads/MraidView;->getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->close()V

    .line 37
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/device/ads/MraidView;->getOnSpecialUrlClickListener()Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;->onSpecialUrlClick(Lcom/amazon/device/ads/MraidView;Ljava/lang/String;)V

    .line 39
    :cond_1
    return-void
.end method

.method protected open(Ljava/lang/String;)V
    .locals 9
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 43
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidBrowserController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v3

    .line 45
    .local v3, "view":Lcom/amazon/device/ads/MraidView;
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    if-nez v4, :cond_1

    .line 47
    :cond_0
    const-string/jumbo v4, "MraidBrowserController"

    const-string/jumbo v5, "URI cannot be null or empty"

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    :goto_0
    return-void

    .line 51
    :cond_1
    const-string/jumbo v4, "MraidBrowserController"

    const-string/jumbo v5, "Opening in-app browser: %s"

    new-array v6, v8, [Ljava/lang/Object;

    aput-object p1, v6, v7

    invoke-static {v4, v5, v6}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 52
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 54
    .local v1, "incomingUrl":Landroid/net/Uri;
    invoke-virtual {v1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_2

    invoke-virtual {v1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "amazonmobile"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 56
    invoke-virtual {p0, v3, p1}, Lcom/amazon/device/ads/MraidBrowserController;->executeAmazonMobileCallback(Lcom/amazon/device/ads/MraidView;Ljava/lang/String;)V

    goto :goto_0

    .line 63
    :cond_2
    const/4 v2, 0x0

    .line 66
    .local v2, "redir":Ljava/lang/String;
    :try_start_0
    const-string/jumbo v4, "d.url"

    invoke-virtual {v1, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 74
    if-nez v2, :cond_3

    .line 75
    move-object v2, p1

    .line 77
    :cond_3
    const-string/jumbo v4, "amazonmobile:"

    invoke-virtual {v2, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 79
    invoke-virtual {p0, v3, v2}, Lcom/amazon/device/ads/MraidBrowserController;->executeAmazonMobileCallback(Lcom/amazon/device/ads/MraidView;Ljava/lang/String;)V

    goto :goto_0

    .line 68
    :catch_0
    move-exception v0

    .line 71
    .local v0, "e":Ljava/lang/UnsupportedOperationException;
    const-string/jumbo v4, "MraidBrowserController"

    const-string/jumbo v5, "Could not open non-hierarchical URI: %s"

    new-array v6, v8, [Ljava/lang/Object;

    aput-object p1, v6, v7

    invoke-static {v4, v5, v6}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 85
    .end local v0    # "e":Ljava/lang/UnsupportedOperationException;
    :cond_4
    invoke-virtual {v3}, Lcom/amazon/device/ads/MraidView;->getOnOpenListener()Lcom/amazon/device/ads/MraidView$OnOpenListener;

    move-result-object v4

    if-eqz v4, :cond_5

    .line 86
    invoke-virtual {v3}, Lcom/amazon/device/ads/MraidView;->getOnOpenListener()Lcom/amazon/device/ads/MraidView$OnOpenListener;

    move-result-object v4

    invoke-interface {v4, v3}, Lcom/amazon/device/ads/MraidView$OnOpenListener;->onOpen(Lcom/amazon/device/ads/MraidView;)V

    .line 88
    :cond_5
    const-string/jumbo v4, "http:"

    invoke-virtual {v2, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_6

    const-string/jumbo v4, "https:"

    invoke-virtual {v2, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 90
    :cond_6
    new-instance v4, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    invoke-direct {v4}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidBrowserController;->getView()Lcom/amazon/device/ads/MraidView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/MraidView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->withContext(Landroid/content/Context;)Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->withUrl(Ljava/lang/String;)Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->withExternalBrowserButton()Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->show()V

    goto/16 :goto_0

    .line 98
    :cond_7
    iget-object v4, v3, Lcom/amazon/device/ads/MraidView;->adView:Lcom/amazon/device/ads/AdView;

    invoke-interface {v4, v2}, Lcom/amazon/device/ads/AdView;->launchExternalBrowserForLink(Ljava/lang/String;)Z

    goto/16 :goto_0
.end method
