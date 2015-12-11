.class final enum Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$4;
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
    .line 128
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;-><init>(Ljava/lang/String;ILjava/lang/String;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V

    return-void
.end method


# virtual methods
.method public execute(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;Lorg/apache/cordova/CordovaPlugin;)Z
    .locals 9
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .param p3, "cordovaPlugin"    # Lorg/apache/cordova/CordovaPlugin;

    .prologue
    const/4 v5, 0x0

    .line 130
    iget-object v6, p3, Lorg/apache/cordova/CordovaPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v6}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 132
    .local v0, "activity":Landroid/app/Activity;
    invoke-static {v0}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isAIVCompanionAppInstalled(Landroid/content/Context;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 151
    :goto_0
    return v5

    .line 138
    :cond_0
    const/4 v6, 0x0

    :try_start_0
    invoke-virtual {p1, v6}, Lorg/json/JSONArray;->getJSONArray(I)Lorg/json/JSONArray;

    move-result-object v4

    .line 139
    .local v4, "jsonArray":Lorg/json/JSONArray;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 140
    .local v1, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v6

    if-ge v3, v6, :cond_1

    .line 141
    invoke-virtual {v4, v3}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v1, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 140
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 143
    :cond_1
    iget-object v6, p3, Lorg/apache/cordova/CordovaPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v6}, Lorg/apache/cordova/CordovaInterface;->getThreadPool()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    new-instance v7, Lcom/amazon/mShop/mash/api/MASHAivPlugin$WhisperCacheTask;

    const/4 v8, 0x0

    invoke-direct {v7, p2, v1, v8}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$WhisperCacheTask;-><init>(Lorg/apache/cordova/CallbackContext;Ljava/util/List;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V

    invoke-interface {v6, v7}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 151
    const/4 v5, 0x1

    goto :goto_0

    .line 144
    .end local v1    # "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v3    # "i":I
    .end local v4    # "jsonArray":Lorg/json/JSONArray;
    :catch_0
    move-exception v2

    .line 145
    .local v2, "e":Lorg/json/JSONException;
    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 146
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$4;->getApiName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 148
    :cond_2
    sget-object v6, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v6

    invoke-virtual {p2, v6}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method
