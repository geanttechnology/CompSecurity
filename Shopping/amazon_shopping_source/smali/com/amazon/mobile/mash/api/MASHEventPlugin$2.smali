.class Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;
.super Ljava/lang/Object;
.source "MASHEventPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHEventPlugin;->removeEventListener(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;

.field final synthetic val$eventType:Ljava/lang/String;

.field final synthetic val$mashEvent:Lorg/json/JSONObject;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHEventPlugin;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;Lorg/json/JSONObject;)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->val$eventType:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->val$callback:Lorg/apache/cordova/CallbackContext;

    iput-object p4, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->val$mashEvent:Lorg/json/JSONObject;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 130
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->val$eventType:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->getReceiver(Ljava/lang/String;)Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;

    move-result-object v0

    .line 131
    .local v0, "receiver":Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;
    if-eqz v0, :cond_0

    .line 132
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

    # getter for: Lcom/amazon/mobile/mash/api/MASHEventPlugin;->mMashNotificationReceivers:Ljava/util/Map;
    invoke-static {v1}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->access$000(Lcom/amazon/mobile/mash/api/MASHEventPlugin;)Ljava/util/Map;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->val$eventType:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    invoke-virtual {v0}, Lcom/amazon/mobile/mash/event/AmazonMASHNotificationReceiver;->useIntentReceiver()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 134
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

    iget-object v1, v1, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    invoke-virtual {v1}, Lorg/apache/cordova/CordovaWebView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/content/LocalBroadcastManager;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 137
    :cond_0
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->val$callback:Lorg/apache/cordova/CallbackContext;

    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->val$mashEvent:Lorg/json/JSONObject;

    invoke-virtual {v1, v2}, Lorg/apache/cordova/CallbackContext;->success(Lorg/json/JSONObject;)V

    .line 138
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 139
    sget-object v1, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "RemoveEventListener is executed succeccfully. eventType="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$2;->val$eventType:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 141
    :cond_1
    return-void
.end method
