.class Lcom/amazon/mobile/mash/api/MASHContactsPlugin$1;
.super Ljava/lang/Object;
.source "MASHContactsPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->showContactPicker(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/api/MASHContactsPlugin;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHContactsPlugin;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHContactsPlugin;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 76
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.PICK"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 77
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v2, "vnd.android.cursor.dir/contact"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 78
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHContactsPlugin;

    iget-object v2, v2, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHContactsPlugin;

    const/16 v4, 0x2711

    invoke-interface {v2, v3, v0, v4}, Lorg/apache/cordova/CordovaInterface;->startActivityForResult(Lorg/apache/cordova/CordovaPlugin;Landroid/content/Intent;I)V

    .line 79
    new-instance v1, Lorg/apache/cordova/PluginResult;

    sget-object v2, Lorg/apache/cordova/PluginResult$Status;->NO_RESULT:Lorg/apache/cordova/PluginResult$Status;

    invoke-direct {v1, v2}, Lorg/apache/cordova/PluginResult;-><init>(Lorg/apache/cordova/PluginResult$Status;)V

    .line 80
    .local v1, "result":Lorg/apache/cordova/PluginResult;
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lorg/apache/cordova/PluginResult;->setKeepCallback(Z)V

    .line 81
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHContactsPlugin;

    # getter for: Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;
    invoke-static {v2}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->access$000(Lcom/amazon/mobile/mash/api/MASHContactsPlugin;)Lorg/apache/cordova/CallbackContext;

    move-result-object v2

    invoke-virtual {v2, v1}, Lorg/apache/cordova/CallbackContext;->sendPluginResult(Lorg/apache/cordova/PluginResult;)V

    .line 82
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 83
    # getter for: Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->access$100()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "MASH API ShowContactPicker is executed succeccfully."

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 85
    :cond_0
    return-void
.end method
