.class public Lcom/amazon/mobile/mash/nav/MASHNavBackHandler;
.super Lcom/amazon/mobile/mash/nav/MASHNavHandler;
.source "MASHNavBackHandler.java"


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
    .locals 5

    .prologue
    .line 39
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavBackHandler;->getNextOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v2

    if-eqz v2, :cond_1

    const-string/jumbo v2, "replace"

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavBackHandler;->getNextOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string/jumbo v2, "forward"

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavBackHandler;->getNextOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 53
    :cond_0
    :goto_0
    return-void

    .line 44
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavBackHandler;->getMASHNavigationPlugin()Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    move-result-object v1

    .line 45
    .local v1, "mashNavigationPlugin":Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;
    iget-object v2, v1, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    check-cast v2, Lcom/amazon/mobile/mash/MASHWebView;

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavBackHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/mobile/mash/nav/MASHNavUtils;->computeBackAmount(Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavOperation;)I

    move-result v0

    .line 47
    .local v0, "backAmount":I
    const/4 v2, -0x1

    if-ne v0, v2, :cond_2

    .line 48
    const-string/jumbo v2, "MASHNavBackHandler"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "MASH API can not do operation "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavBackHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    new-instance v2, Lcom/amazon/mobile/mash/nav/MASHNavException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Not able to do op. "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavBackHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/mobile/mash/nav/MASHNavException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 51
    :cond_2
    iget-object v2, v1, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    rsub-int/lit8 v3, v0, 0x0

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CordovaWebView;->goBackOrForward(I)V

    goto :goto_0
.end method
