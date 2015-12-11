.class public Lcom/amazon/mShop/mash/api/MASHAivPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHAivPlugin.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;,
        Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;,
        Lcom/amazon/mShop/mash/api/MASHAivPlugin$WhisperCacheTask;,
        Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartTrailerTask;,
        Lcom/amazon/mShop/mash/api/MASHAivPlugin$IsPlaybackSustainableTask;,
        Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;,
        Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
    }
.end annotation


# instance fields
.field private mAivAction:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

.field private mCallbackContext:Lorg/apache/cordova/CallbackContext;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    .line 307
    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/String;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)Z
    .locals 1
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "args"    # Lorg/json/JSONArray;
    .param p3, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 206
    invoke-static {p1}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->actionFromAPIName(Ljava/lang/String;)Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin;->mAivAction:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    .line 207
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin;->mAivAction:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    if-nez v0, :cond_0

    .line 208
    sget-object v0, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {p3, v0}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 209
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    .line 210
    const/4 v0, 0x0

    .line 213
    :goto_0
    return v0

    .line 212
    :cond_0
    iput-object p3, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    .line 213
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin;->mAivAction:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    invoke-virtual {v0, p2, p3, p0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->execute(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;Lorg/apache/cordova/CordovaPlugin;)Z

    move-result v0

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 218
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin;->mAivAction:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v0, v1, p1, p2, p3}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->onActivityResult(Lorg/apache/cordova/CallbackContext;IILandroid/content/Intent;)V

    .line 219
    return-void
.end method
