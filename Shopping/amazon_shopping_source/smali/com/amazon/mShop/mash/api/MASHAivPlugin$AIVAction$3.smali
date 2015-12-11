.class final enum Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$3;
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
    .line 103
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;-><init>(Ljava/lang/String;ILjava/lang/String;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V

    return-void
.end method


# virtual methods
.method public execute(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;Lorg/apache/cordova/CordovaPlugin;)Z
    .locals 6
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .param p3, "cordovaPlugin"    # Lorg/apache/cordova/CordovaPlugin;

    .prologue
    const/4 v3, 0x0

    .line 105
    iget-object v4, p3, Lorg/apache/cordova/CordovaPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v4}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 109
    .local v0, "activity":Landroid/app/Activity;
    const/4 v4, 0x0

    :try_start_0
    invoke-virtual {p1, v4}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 119
    .local v1, "asin":Ljava/lang/String;
    # invokes: Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->redirectToInstallCompanionApp(Landroid/app/Activity;Ljava/lang/String;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->access$200(Landroid/app/Activity;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 125
    .end local v1    # "asin":Ljava/lang/String;
    :goto_0
    return v3

    .line 110
    :catch_0
    move-exception v2

    .line 111
    .local v2, "e":Lorg/json/JSONException;
    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 112
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$3;->getApiName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 114
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$3;->getApiName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " JSONException: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p2, v4}, Lorg/apache/cordova/CallbackContext;->error(Ljava/lang/String;)V

    goto :goto_0

    .line 123
    .end local v2    # "e":Lorg/json/JSONException;
    .restart local v1    # "asin":Ljava/lang/String;
    :cond_1
    iget-object v3, p3, Lorg/apache/cordova/CordovaPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v3}, Lorg/apache/cordova/CordovaInterface;->getThreadPool()Ljava/util/concurrent/ExecutorService;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartTrailerTask;

    const/4 v5, 0x0

    invoke-direct {v4, p2, v0, v1, v5}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartTrailerTask;-><init>(Lorg/apache/cordova/CallbackContext;Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V

    invoke-interface {v3, v4}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 125
    const/4 v3, 0x1

    goto :goto_0
.end method
