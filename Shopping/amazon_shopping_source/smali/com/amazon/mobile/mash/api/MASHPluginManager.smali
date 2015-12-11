.class public Lcom/amazon/mobile/mash/api/MASHPluginManager;
.super Lorg/apache/cordova/PluginManager;
.source "MASHPluginManager.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mWebView:Lorg/apache/cordova/CordovaWebView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/mobile/mash/api/MASHPluginManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/api/MASHPluginManager;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lorg/apache/cordova/CordovaWebView;Lorg/apache/cordova/CordovaInterface;Ljava/util/List;)V
    .locals 0
    .param p1, "webView"    # Lorg/apache/cordova/CordovaWebView;
    .param p2, "cordova"    # Lorg/apache/cordova/CordovaInterface;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/apache/cordova/CordovaWebView;",
            "Lorg/apache/cordova/CordovaInterface;",
            "Ljava/util/List",
            "<",
            "Lorg/apache/cordova/PluginEntry;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 31
    .local p3, "pluginEntries":Ljava/util/List;, "Ljava/util/List<Lorg/apache/cordova/PluginEntry;>;"
    invoke-direct {p0, p1, p2, p3}, Lorg/apache/cordova/PluginManager;-><init>(Lorg/apache/cordova/CordovaWebView;Lorg/apache/cordova/CordovaInterface;Ljava/util/List;)V

    .line 32
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHPluginManager;->mWebView:Lorg/apache/cordova/CordovaWebView;

    .line 33
    return-void
.end method


# virtual methods
.method public exec(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "service"    # Ljava/lang/String;
    .param p2, "action"    # Ljava/lang/String;
    .param p3, "callbackId"    # Ljava/lang/String;
    .param p4, "rawArgs"    # Ljava/lang/String;

    .prologue
    .line 43
    new-instance v0, Lorg/apache/cordova/CallbackContext;

    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHPluginManager;->mWebView:Lorg/apache/cordova/CordovaWebView;

    invoke-direct {v0, p3, v3}, Lorg/apache/cordova/CallbackContext;-><init>(Ljava/lang/String;Lorg/apache/cordova/CordovaWebView;)V

    .line 47
    .local v0, "callbackContext":Lorg/apache/cordova/CallbackContext;
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHPluginManager;->mWebView:Lorg/apache/cordova/CordovaWebView;

    check-cast v3, Lcom/amazon/mobile/mash/MASHWebView;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/MASHWebView;->isInEmbeddedBrowserMode()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 48
    const-string/jumbo v3, "ExitEmbeddedBrowser"

    invoke-virtual {v3, p2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string/jumbo v3, "Device"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string/jumbo v3, "NetworkStatus"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    :cond_0
    const/4 v1, 0x1

    .line 52
    .local v1, "isAccessible":Z
    :goto_0
    if-nez v1, :cond_2

    .line 53
    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->PERMISSION_DENIED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v0, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 54
    sget-object v3, Lcom/amazon/mobile/mash/api/MASHPluginManager;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "MASHError.PERMISSION_DENIED for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 61
    .end local v1    # "isAccessible":Z
    :goto_1
    return-void

    .line 48
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    .line 59
    :cond_2
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mobile/mash/api/MASHPluginManager;->overrideServiceName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 60
    .local v2, "newService":Ljava/lang/String;
    invoke-super {p0, v2, p2, p3, p4}, Lorg/apache/cordova/PluginManager;->exec(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method protected overrideServiceName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "service"    # Ljava/lang/String;
    .param p2, "action"    # Ljava/lang/String;

    .prologue
    .line 77
    const-string/jumbo v0, "Mash"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string/jumbo v0, "ShowEmbeddedBrowser"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "ExitEmbeddedBrowser"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 79
    :cond_0
    const-string/jumbo p1, "MASHEmbeddedBrowser"

    .line 81
    .end local p1    # "service":Ljava/lang/String;
    :cond_1
    return-object p1
.end method
