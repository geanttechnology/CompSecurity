.class Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;
.super Ljava/lang/Object;
.source "MASHEventPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHEventPlugin;->dispatchEvent(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;

.field final synthetic val$eventDetail:Ljava/lang/String;

.field final synthetic val$eventDetailJson:Lorg/json/JSONObject;

.field final synthetic val$eventType:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHEventPlugin;Ljava/lang/String;Lorg/json/JSONObject;Lorg/apache/cordova/CallbackContext;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 157
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;->this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;->val$eventType:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;->val$eventDetailJson:Lorg/json/JSONObject;

    iput-object p4, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;->val$callback:Lorg/apache/cordova/CallbackContext;

    iput-object p5, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;->val$eventDetail:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 160
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;->val$eventType:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;->val$eventDetailJson:Lorg/json/JSONObject;

    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;->this$0:Lcom/amazon/mobile/mash/api/MASHEventPlugin;

    iget-object v2, v2, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    invoke-virtual {v2}, Lorg/apache/cordova/CordovaWebView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->sendMASHEventBroadcast(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 161
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v0}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 162
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 163
    sget-object v0, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "DispatchEvent is executed succeccfully.\n eventType="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;->val$eventType:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " eventDetail="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEventPlugin$3;->val$eventDetail:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 166
    :cond_0
    return-void
.end method
