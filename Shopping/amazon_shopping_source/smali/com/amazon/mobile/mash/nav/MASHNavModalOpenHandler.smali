.class public Lcom/amazon/mobile/mash/nav/MASHNavModalOpenHandler;
.super Lcom/amazon/mobile/mash/nav/MASHNavHandler;
.source "MASHNavModalOpenHandler.java"


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
    .line 24
    .local p2, "operationList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mobile/mash/nav/MASHNavOperation;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavHandler;-><init>(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Ljava/util/List;I)V

    .line 25
    return-void
.end method


# virtual methods
.method public navigate()V
    .locals 5

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavModalOpenHandler;->getMASHNavigationPlugin()Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    move-result-object v2

    .line 34
    .local v2, "mashNavigationPlugin":Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;
    iget-object v3, v2, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v3}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v1

    check-cast v1, Lcom/amazon/mobile/mash/nav/MASHNavInterface;

    .line 35
    .local v1, "mashNavInterface":Lcom/amazon/mobile/mash/nav/MASHNavInterface;
    new-instance v0, Landroid/content/Intent;

    iget-object v3, v2, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v3}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-interface {v1}, Lcom/amazon/mobile/mash/nav/MASHNavInterface;->getModalActivityClass()Ljava/lang/Class;

    move-result-object v4

    invoke-direct {v0, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 36
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHNavModalOpenHandler;->getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getRequest()Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 37
    iget-object v3, v2, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    const/16 v4, 0x2713

    invoke-interface {v3, v2, v0, v4}, Lorg/apache/cordova/CordovaInterface;->startActivityForResult(Lorg/apache/cordova/CordovaPlugin;Landroid/content/Intent;I)V

    .line 38
    return-void
.end method
