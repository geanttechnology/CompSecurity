.class public Lcom/amazon/mobile/mash/nav/MASHNavForwardHandler;
.super Lcom/amazon/mobile/mash/nav/MASHNavHandler;
.source "MASHNavForwardHandler.java"


# direct methods
.method public constructor <init>(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Ljava/util/List;I)V
    .locals 0
    .param p1, "plugin"    # Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;
    .param p3, "currentIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mobile/mash/nav/MASHNavOperation;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p2, "operationList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mobile/mash/nav/MASHNavOperation;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavHandler;-><init>(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Ljava/util/List;I)V

    .line 29
    return-void
.end method


# virtual methods
.method public navigate()V
    .locals 6

    .prologue
    .line 40
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavForwardHandler;->getMASHNavigationPlugin()Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    move-result-object v0

    .line 41
    .local v0, "mashNavigationPlugin":Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;
    iget-object v2, v0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    check-cast v2, Lcom/amazon/mobile/mash/MASHWebView;

    .line 42
    .local v2, "webview":Lcom/amazon/mobile/mash/MASHWebView;
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavForwardHandler;->getPreOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavForwardHandler;->getPreOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "back"

    invoke-virtual {v3, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 44
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavForwardHandler;->getPreOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/mobile/mash/nav/MASHNavUtils;->computeBackAmount(Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavOperation;)I

    move-result v1

    .line 45
    .local v1, "pendingBackAmount":I
    rsub-int/lit8 v3, v1, 0x0

    invoke-virtual {v2, v3}, Lcom/amazon/mobile/mash/MASHWebView;->canGoBackOrForward(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 46
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavForwardHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getRequest()Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    move-result-object v3

    invoke-static {v2, v1, v3}, Lcom/amazon/mobile/mash/nav/MASHNavUtils;->goBackAndForward(Lcom/amazon/mobile/mash/MASHWebView;ILcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V

    .line 54
    .end local v1    # "pendingBackAmount":I
    :goto_0
    return-void

    .line 48
    .restart local v1    # "pendingBackAmount":I
    :cond_0
    const-string/jumbo v3, "MASHNavForwardHandler"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "MASH API can not do operation "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavForwardHandler;->getPreOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    new-instance v3, Lcom/amazon/mobile/mash/nav/MASHNavException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Not able to do op. "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavForwardHandler;->getPreOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/amazon/mobile/mash/nav/MASHNavException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 52
    .end local v1    # "pendingBackAmount":I
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavForwardHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getRequest()Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/mobile/mash/nav/MASHNavUtils;->issuePageRequest(Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V

    goto :goto_0
.end method
