.class public Lcom/amazon/mobile/mash/api/MASHEventPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHEventPlugin.java"


# instance fields
.field private mMashNotificationReceivers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->mMashNotificationReceivers:Ljava/util/Map;

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mobile/mash/api/MASHEventPlugin;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mobile/mash/api/MASHEventPlugin;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->mMashNotificationReceivers:Ljava/util/Map;

    return-object v0
.end method

.method private addEventListener(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 2
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 75
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 76
    .local v0, "eventType":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;

    invoke-direct {v1, p0, v0, p2}, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;-><init>(Lcom/amazon/mobile/mash/api/MASHEventPlugin;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v1}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 98
    return-void
.end method

.method private dispatchEvent(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 6
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 154
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 155
    .local v2, "eventType":Ljava/lang/String;
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 156
    .local v5, "eventDetail":Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/mobile/mash/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v3, 0x0

    .line 157
    .local v3, "eventDetailJson":Lorg/json/JSONObject;
    :goto_0
    new-instance v0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;

    move-object v1, p0

    move-object v4, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;-><init>(Lcom/amazon/mobile/mash/api/MASHEventPlugin;Ljava/lang/String;Lorg/json/JSONObject;Lorg/apache/cordova/CallbackContext;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 168
    return-void

    .line 156
    .end local v3    # "eventDetailJson":Lorg/json/JSONObject;
    :cond_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v5}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private removeEventListener(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 3
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 123
    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 124
    .local v0, "eventType":Ljava/lang/String;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 125
    .local v1, "mashEvent":Lorg/json/JSONObject;
    const-string/jumbo v2, "type"

    invoke-virtual {v1, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 127
    new-instance v2, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;

    invoke-direct {v2, p0, v0, p2, v1}, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;-><init>(Lcom/amazon/mobile/mash/api/MASHEventPlugin;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;Lorg/json/JSONObject;)V

    invoke-virtual {p0, v2}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 143
    return-void
.end method

.method private resetMASHNotificationReceivers()V
    .locals 3

    .prologue
    .line 174
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->mMashNotificationReceivers:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;

    .line 175
    .local v1, "receiver":Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;
    invoke-virtual {v1}, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->useIntentReceiver()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 176
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    invoke-virtual {v2}, Lorg/apache/cordova/CordovaWebView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/support/v4/content/LocalBroadcastManager;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    goto :goto_0

    .line 179
    .end local v1    # "receiver":Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;
    :cond_1
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->mMashNotificationReceivers:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->clear()V

    .line 180
    return-void
.end method

.method public static sendMASHEventBroadcast(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V
    .locals 3
    .param p0, "eventType"    # Ljava/lang/String;
    .param p1, "eventDetail"    # Lorg/json/JSONObject;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 235
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "com.amazon.mShop.mash.notification"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 236
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "type"

    invoke-virtual {v0, v1, p0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 237
    if-eqz p1, :cond_0

    .line 238
    const-string/jumbo v1, "detail"

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 240
    :cond_0
    invoke-static {p2}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    .line 241
    return-void
.end method


# virtual methods
.method protected createNotificationReceiver(Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;
    .locals 2
    .param p1, "eventType"    # Ljava/lang/String;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 104
    sget-object v0, Lcom/amazon/mobile/mash/event/MASHEventType;->cartUpdated:Lcom/amazon/mobile/mash/event/MASHEventType;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/event/MASHEventType;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 105
    new-instance v0, Lcom/amazon/mobile/mash/event/CartMASHNotificationReceiver;

    invoke-direct {v0, p2}, Lcom/amazon/mobile/mash/event/CartMASHNotificationReceiver;-><init>(Lorg/apache/cordova/CallbackContext;)V

    .line 111
    :goto_0
    return-object v0

    .line 106
    :cond_0
    sget-object v0, Lcom/amazon/mobile/mash/event/MASHEventType;->appPause:Lcom/amazon/mobile/mash/event/MASHEventType;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/event/MASHEventType;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lcom/amazon/mobile/mash/event/MASHEventType;->appResume:Lcom/amazon/mobile/mash/event/MASHEventType;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/event/MASHEventType;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 108
    :cond_1
    new-instance v0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;-><init>(Ljava/lang/String;Lorg/apache/cordova/CallbackContext;Z)V

    goto :goto_0

    .line 111
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public execute(Ljava/lang/String;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)Z
    .locals 1
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "args"    # Lorg/json/JSONArray;
    .param p3, "callbackContext"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 54
    const-string/jumbo v0, "AddEventListener"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 55
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->addEventListener(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 63
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0

    .line 56
    :cond_0
    const-string/jumbo v0, "RemoveEventListener"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 57
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->removeEventListener(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 58
    :cond_1
    const-string/jumbo v0, "DispatchEvent"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 59
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->dispatchEvent(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 61
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public getReceiver(Ljava/lang/String;)Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;
    .locals 1
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->mMashNotificationReceivers:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;

    return-object v0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 198
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->resetMASHNotificationReceivers()V

    .line 199
    return-void
.end method

.method public onPause(Z)V
    .locals 2
    .param p1, "multitasking"    # Z

    .prologue
    .line 207
    sget-object v1, Lcom/amazon/mobile/mash/event/MASHEventType;->appPause:Lcom/amazon/mobile/mash/event/MASHEventType;

    invoke-virtual {v1}, Lcom/amazon/mobile/mash/event/MASHEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->getReceiver(Ljava/lang/String;)Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;

    move-result-object v0

    .line 208
    .local v0, "receiver":Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;
    if-eqz v0, :cond_0

    .line 209
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->notifyWebPage(Lorg/json/JSONObject;)V

    .line 211
    :cond_0
    return-void
.end method

.method public onReset()V
    .locals 0

    .prologue
    .line 189
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->resetMASHNotificationReceivers()V

    .line 190
    return-void
.end method

.method public onResume(Z)V
    .locals 2
    .param p1, "multitasking"    # Z

    .prologue
    .line 220
    sget-object v1, Lcom/amazon/mobile/mash/event/MASHEventType;->appResume:Lcom/amazon/mobile/mash/event/MASHEventType;

    invoke-virtual {v1}, Lcom/amazon/mobile/mash/event/MASHEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->getReceiver(Ljava/lang/String;)Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;

    move-result-object v0

    .line 221
    .local v0, "receiver":Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;
    if-eqz v0, :cond_0

    .line 222
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->notifyWebPage(Lorg/json/JSONObject;)V

    .line 224
    :cond_0
    return-void
.end method
