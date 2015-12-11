.class public Lcom/amazon/mobile/mash/nav/MASHNavModalCloseHandler;
.super Lcom/amazon/mobile/mash/nav/MASHNavHandler;
.source "MASHNavModalCloseHandler.java"


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
    .line 30
    .local p2, "operationList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mobile/mash/nav/MASHNavOperation;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavHandler;-><init>(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Ljava/util/List;I)V

    .line 31
    return-void
.end method


# virtual methods
.method public navigate()V
    .locals 5

    .prologue
    .line 39
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavModalCloseHandler;->getMASHNavigationPlugin()Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    move-result-object v2

    iget-object v2, v2, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v2}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 40
    .local v0, "activity":Landroid/app/Activity;
    instance-of v2, v0, Lcom/amazon/mobile/mash/nav/MASHNavInterface;

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    move-object v2, v0

    check-cast v2, Lcom/amazon/mobile/mash/nav/MASHNavInterface;

    invoke-interface {v2}, Lcom/amazon/mobile/mash/nav/MASHNavInterface;->getModalActivityClass()Ljava/lang/Class;

    move-result-object v2

    if-ne v3, v2, :cond_0

    .line 42
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 43
    .local v1, "intent":Landroid/content/Intent;
    const-string/jumbo v2, "remainingOperations"

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavModalCloseHandler;->getRemainingOperations()[Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 44
    const/16 v2, 0x2711

    invoke-virtual {v0, v2, v1}, Landroid/app/Activity;->setResult(ILandroid/content/Intent;)V

    .line 45
    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 50
    return-void

    .line 47
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_0
    const-string/jumbo v2, "MASHNavModalCloseHandler"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "MASH API can not do operation "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavModalCloseHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 48
    new-instance v2, Lcom/amazon/mobile/mash/nav/MASHNavException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Not able to do op. "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavModalCloseHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/mobile/mash/nav/MASHNavException;-><init>(Ljava/lang/String;)V

    throw v2
.end method
