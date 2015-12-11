.class Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;
.super Ljava/lang/Object;
.source "MASHEventPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHEventPlugin;->addEventListener(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;

.field final synthetic val$eventType:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHEventPlugin;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;->val$eventType:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 79
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;->val$eventType:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->createNotificationReceiver(Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;

    move-result-object v0

    .line 81
    .local v0, "receiver":Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;
    if-eqz v0, :cond_1

    .line 82
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

    # getter for: Lcom/amazon/mobile/mash/api/MASHEventPlugin;->mMashNotificationReceivers:Ljava/util/Map;
    invoke-static {v2}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->access$000(Lcom/amazon/mobile/mash/api/MASHEventPlugin;)Ljava/util/Map;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;->val$eventType:Ljava/lang/String;

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    invoke-virtual {v0}, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->useIntentReceiver()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 85
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

    iget-object v2, v2, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    invoke-virtual {v2}, Lorg/apache/cordova/CordovaWebView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v2

    sget-object v3, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->MASH_EVENT_INTENT_FILTER:Landroid/content/IntentFilter;

    invoke-virtual {v2, v0, v3}, Landroid/support/v4/content/LocalBroadcastManager;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 89
    :cond_0
    new-instance v1, Lorg/apache/cordova/PluginResult;

    sget-object v2, Lorg/apache/cordova/PluginResult$Status;->NO_RESULT:Lorg/apache/cordova/PluginResult$Status;

    invoke-direct {v1, v2}, Lorg/apache/cordova/PluginResult;-><init>(Lorg/apache/cordova/PluginResult$Status;)V

    .line 90
    .local v1, "res":Lorg/apache/cordova/PluginResult;
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lorg/apache/cordova/PluginResult;->setKeepCallback(Z)V

    .line 91
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v2, v1}, Lorg/apache/cordova/CallbackContext;->sendPluginResult(Lorg/apache/cordova/PluginResult;)V

    .line 92
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 93
    sget-object v2, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "AddEventListener is executed successfully. eventType="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$1;->val$eventType:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 96
    .end local v1    # "res":Lorg/apache/cordova/PluginResult;
    :cond_1
    return-void
.end method
