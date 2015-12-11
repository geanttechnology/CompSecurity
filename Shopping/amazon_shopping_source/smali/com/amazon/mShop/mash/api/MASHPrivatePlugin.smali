.class public Lcom/amazon/mShop/mash/api/MASHPrivatePlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHPrivatePlugin.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method private getPushNotificationInfo(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 35
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHPrivatePlugin$1;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHPrivatePlugin$1;-><init>(Lcom/amazon/mShop/mash/api/MASHPrivatePlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHPrivatePlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 58
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
    .line 27
    const-string/jumbo v0, "GetPushNotificationInfo"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 28
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHPrivatePlugin;->getPushNotificationInfo(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 29
    const/4 v0, 0x1

    .line 31
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
