.class final enum Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$2;
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
    .line 69
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;-><init>(Ljava/lang/String;ILjava/lang/String;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V

    return-void
.end method


# virtual methods
.method public execute(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;Lorg/apache/cordova/CordovaPlugin;)Z
    .locals 8
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .param p3, "cordovaPlugin"    # Lorg/apache/cordova/CordovaPlugin;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 71
    iget-object v7, p3, Lorg/apache/cordova/CordovaPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v7}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 76
    .local v0, "activity":Landroid/app/Activity;
    const/4 v7, 0x0

    :try_start_0
    invoke-virtual {p1, v7}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 77
    .local v1, "asin":Ljava/lang/String;
    const/4 v7, 0x1

    invoke-virtual {p1, v7}, Lorg/json/JSONArray;->getInt(I)I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 87
    .local v4, "timecode":I
    # invokes: Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->redirectToInstallCompanionApp(Landroid/app/Activity;Ljava/lang/String;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->access$200(Landroid/app/Activity;Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 94
    .end local v1    # "asin":Ljava/lang/String;
    .end local v4    # "timecode":I
    :goto_0
    return v5

    .line 78
    :catch_0
    move-exception v2

    .line 79
    .local v2, "e":Lorg/json/JSONException;
    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 80
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$2;->getApiName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 82
    :cond_0
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$2;->getApiName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " JSONException: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v2}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v6}, Lorg/apache/cordova/CallbackContext;->error(Ljava/lang/String;)V

    goto :goto_0

    .line 91
    .end local v2    # "e":Lorg/json/JSONException;
    .restart local v1    # "asin":Ljava/lang/String;
    .restart local v4    # "timecode":I
    :cond_1
    new-instance v3, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;

    const/4 v5, 0x0

    invoke-direct {v3, v1, v4, p3, v5}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;-><init>(Ljava/lang/String;ILorg/apache/cordova/CordovaPlugin;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V

    .line 92
    .local v3, "task":Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;
    iget-object v5, p3, Lorg/apache/cordova/CordovaPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v5}, Lorg/apache/cordova/CordovaInterface;->getThreadPool()Ljava/util/concurrent/ExecutorService;

    move-result-object v5

    invoke-interface {v5, v3}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    move v5, v6

    .line 94
    goto :goto_0
.end method

.method public onActivityResult(Lorg/apache/cordova/CallbackContext;IILandroid/content/Intent;)V
    .locals 0
    .param p1, "callback"    # Lorg/apache/cordova/CallbackContext;
    .param p2, "requestCode"    # I
    .param p3, "resultCode"    # I
    .param p4, "data"    # Landroid/content/Intent;

    .prologue
    .line 100
    invoke-virtual {p1}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 101
    return-void
.end method
