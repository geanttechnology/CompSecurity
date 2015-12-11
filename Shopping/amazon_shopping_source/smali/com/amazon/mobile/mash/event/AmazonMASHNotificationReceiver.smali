.class public Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;
.super Landroid/content/BroadcastReceiver;
.source "AmazonMASHNotificationReceiver.java"


# static fields
.field public static final MASH_EVENT_INTENT_FILTER:Landroid/content/IntentFilter;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mCallbackContext:Lorg/apache/cordova/CallbackContext;

.field private final mEventType:Ljava/lang/String;

.field private final mUseIntentReceiver:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 27
    const-class v0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->TAG:Ljava/lang/String;

    .line 46
    new-instance v0, Landroid/content/IntentFilter;

    const-string/jumbo v1, "com.amazon.mShop.mash.notification"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->MASH_EVENT_INTENT_FILTER:Landroid/content/IntentFilter;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/apache/cordova/CallbackContext;Z)V
    .locals 0
    .param p1, "eventType"    # Ljava/lang/String;
    .param p2, "callbackContext"    # Lorg/apache/cordova/CallbackContext;
    .param p3, "useIntentReceiver"    # Z

    .prologue
    .line 59
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 60
    iput-object p1, p0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->mEventType:Ljava/lang/String;

    .line 61
    iput-object p2, p0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    .line 62
    iput-boolean p3, p0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->mUseIntentReceiver:Z

    .line 63
    return-void
.end method


# virtual methods
.method public notifyWebPage(Lorg/json/JSONObject;)V
    .locals 5
    .param p1, "eventDetail"    # Lorg/json/JSONObject;

    .prologue
    .line 99
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 100
    .local v1, "mashEvent":Lorg/json/JSONObject;
    const-string/jumbo v3, "type"

    iget-object v4, p0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->mEventType:Ljava/lang/String;

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 101
    if-eqz p1, :cond_0

    .line 102
    const-string/jumbo v3, "detail"

    invoke-virtual {v1, v3, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 105
    :cond_0
    new-instance v2, Lorg/apache/cordova/PluginResult;

    sget-object v3, Lorg/apache/cordova/PluginResult$Status;->OK:Lorg/apache/cordova/PluginResult$Status;

    invoke-direct {v2, v3, v1}, Lorg/apache/cordova/PluginResult;-><init>(Lorg/apache/cordova/PluginResult$Status;Lorg/json/JSONObject;)V

    .line 106
    .local v2, "result":Lorg/apache/cordova/PluginResult;
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lorg/apache/cordova/PluginResult;->setKeepCallback(Z)V

    .line 107
    iget-object v3, p0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v3, v2}, Lorg/apache/cordova/CallbackContext;->sendPluginResult(Lorg/apache/cordova/PluginResult;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 113
    .end local v1    # "mashEvent":Lorg/json/JSONObject;
    .end local v2    # "result":Lorg/apache/cordova/PluginResult;
    :cond_1
    :goto_0
    return-void

    .line 108
    :catch_0
    move-exception v0

    .line 109
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mobile/mash/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 110
    sget-object v3, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->TAG:Ljava/lang/String;

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 81
    const-string/jumbo v3, "type"

    invoke-virtual {p2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 82
    .local v2, "target":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->mEventType:Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 83
    const-string/jumbo v3, "detail"

    invoke-virtual {p2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 85
    .local v1, "eventDetail":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Lcom/amazon/mobile/mash/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    const/4 v3, 0x0

    :goto_0
    invoke-virtual {p0, v3}, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->notifyWebPage(Lorg/json/JSONObject;)V

    .line 91
    .end local v1    # "eventDetail":Ljava/lang/String;
    :cond_0
    :goto_1
    return-void

    .line 85
    .restart local v1    # "eventDetail":Ljava/lang/String;
    :cond_1
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 86
    :catch_0
    move-exception v0

    .line 88
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method

.method public useIntentReceiver()Z
    .locals 1

    .prologue
    .line 76
    iget-boolean v0, p0, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->mUseIntentReceiver:Z

    return v0
.end method
