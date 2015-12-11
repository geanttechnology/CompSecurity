.class final enum Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$1;
.super Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
.source "MASHAivPlugin.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p3, "x0"    # Ljava/lang/String;

    .prologue
    .line 63
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;-><init>(Ljava/lang/String;ILjava/lang/String;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V

    return-void
.end method


# virtual methods
.method public execute(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;Lorg/apache/cordova/CordovaPlugin;)Z
    .locals 3
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .param p3, "cordovaPlugin"    # Lorg/apache/cordova/CordovaPlugin;

    .prologue
    .line 65
    iget-object v0, p3, Lorg/apache/cordova/CordovaPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v0}, Lorg/apache/cordova/CordovaInterface;->getThreadPool()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/mash/api/MASHAivPlugin$IsPlaybackSustainableTask;

    const/4 v2, 0x0

    invoke-direct {v1, p2, v2}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$IsPlaybackSustainableTask;-><init>(Lorg/apache/cordova/CallbackContext;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 66
    const/4 v0, 0x1

    return v0
.end method
