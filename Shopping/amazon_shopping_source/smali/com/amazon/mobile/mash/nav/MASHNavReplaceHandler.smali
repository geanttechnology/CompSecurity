.class public Lcom/amazon/mobile/mash/nav/MASHNavReplaceHandler;
.super Lcom/amazon/mobile/mash/nav/MASHNavHandler;
.source "MASHNavReplaceHandler.java"


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
    .locals 7

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavReplaceHandler;->getMASHNavigationPlugin()Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    move-result-object v1

    .line 49
    .local v1, "mashNavigationPlugin":Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;
    iget-object v3, v1, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    check-cast v3, Lcom/amazon/mobile/mash/MASHWebView;

    .line 50
    .local v3, "webView":Lcom/amazon/mobile/mash/MASHWebView;
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavReplaceHandler;->getPreOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v4

    if-eqz v4, :cond_2

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavReplaceHandler;->getPreOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "back"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 51
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavReplaceHandler;->getPreOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/mobile/mash/nav/MASHNavUtils;->computeBackAmount(Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavOperation;)I

    move-result v2

    .line 52
    .local v2, "pendingBackAmount":I
    rsub-int/lit8 v4, v2, 0x0

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v3, v4}, Lcom/amazon/mobile/mash/MASHWebView;->canGoBackOrForward(I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 53
    add-int/lit8 v4, v2, 0x1

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavReplaceHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getRequest()Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    move-result-object v5

    invoke-static {v3, v4, v5}, Lcom/amazon/mobile/mash/nav/MASHNavUtils;->goBackAndForward(Lcom/amazon/mobile/mash/MASHWebView;ILcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V

    .line 69
    .end local v2    # "pendingBackAmount":I
    :goto_0
    return-void

    .line 54
    .restart local v2    # "pendingBackAmount":I
    :cond_0
    rsub-int/lit8 v4, v2, 0x0

    invoke-virtual {v3, v4}, Lcom/amazon/mobile/mash/MASHWebView;->canGoBackOrForward(I)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 55
    iget-object v4, v1, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v4}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/nav/MASHNavInterface;

    .line 56
    .local v0, "mashNavInterface":Lcom/amazon/mobile/mash/nav/MASHNavInterface;
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavReplaceHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getRequest()Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Lcom/amazon/mobile/mash/nav/MASHNavInterface;->replaceRootWebViewWithNewUrl(Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V

    goto :goto_0

    .line 58
    .end local v0    # "mashNavInterface":Lcom/amazon/mobile/mash/nav/MASHNavInterface;
    :cond_1
    const-string/jumbo v4, "MASHNavReplaceHandler"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "MASH API can not do operation "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavReplaceHandler;->getPreOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 59
    new-instance v4, Lcom/amazon/mobile/mash/nav/MASHNavException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Not able to do op. "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavReplaceHandler;->getPreOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/mobile/mash/nav/MASHNavException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 62
    .end local v2    # "pendingBackAmount":I
    :cond_2
    const/4 v4, -0x1

    invoke-virtual {v3, v4}, Lcom/amazon/mobile/mash/MASHWebView;->canGoBackOrForward(I)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 63
    const/4 v4, 0x1

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavReplaceHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getRequest()Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    move-result-object v5

    invoke-static {v3, v4, v5}, Lcom/amazon/mobile/mash/nav/MASHNavUtils;->goBackAndForward(Lcom/amazon/mobile/mash/MASHWebView;ILcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V

    goto :goto_0

    .line 65
    :cond_3
    iget-object v4, v1, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v4}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/nav/MASHNavInterface;

    .line 66
    .restart local v0    # "mashNavInterface":Lcom/amazon/mobile/mash/nav/MASHNavInterface;
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavReplaceHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getRequest()Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Lcom/amazon/mobile/mash/nav/MASHNavInterface;->replaceRootWebViewWithNewUrl(Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V

    goto/16 :goto_0
.end method
