.class Lcom/amazon/mShop/mash/api/MASHPrivatePlugin$1;
.super Ljava/lang/Object;
.source "MASHPrivatePlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHPrivatePlugin;->getPushNotificationInfo(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/api/MASHPrivatePlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/api/MASHPrivatePlugin;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHPrivatePlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHPrivatePlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHPrivatePlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 38
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v2

    .line 39
    .local v2, "manager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    if-eqz v2, :cond_0

    .line 40
    invoke-virtual {v2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getCurrentMShopDeviceToken()Ljava/lang/String;

    move-result-object v3

    .line 42
    .local v3, "token":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 44
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 45
    .local v1, "info":Lorg/json/JSONObject;
    const-string/jumbo v4, "pushToken"

    invoke-virtual {v1, v4, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 46
    const-string/jumbo v4, "appID"

    const-string/jumbo v5, "com.amazon.mShop.android"

    invoke-virtual {v1, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 47
    const-string/jumbo v4, "protocol"

    const-string/jumbo v5, "GCM"

    invoke-virtual {v1, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 48
    iget-object v4, p0, Lcom/amazon/mShop/mash/api/MASHPrivatePlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v4, v1}, Lorg/apache/cordova/CallbackContext;->success(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 56
    .end local v1    # "info":Lorg/json/JSONObject;
    .end local v3    # "token":Ljava/lang/String;
    :goto_0
    return-void

    .line 49
    .restart local v3    # "token":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 50
    .local v0, "e":Lorg/json/JSONException;
    iget-object v4, p0, Lcom/amazon/mShop/mash/api/MASHPrivatePlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    sget-object v5, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v5}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 55
    .end local v0    # "e":Lorg/json/JSONException;
    .end local v3    # "token":Ljava/lang/String;
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/mash/api/MASHPrivatePlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    sget-object v5, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v5}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method
