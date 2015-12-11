.class Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;
.super Ljava/lang/Object;
.source "MASHEmbeddedBrowserPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->showEmbeddedBrowser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;

.field final synthetic val$method:Ljava/lang/String;

.field final synthetic val$postDataByteArray:[B

.field final synthetic val$showActionButton:Z

.field final synthetic val$showRefreshButton:Z

.field final synthetic val$targetUrl:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;Ljava/lang/String;[BLjava/lang/String;ZZ)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;

    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$targetUrl:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$postDataByteArray:[B

    iput-object p4, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$method:Ljava/lang/String;

    iput-boolean p5, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$showRefreshButton:Z

    iput-boolean p6, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$showActionButton:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 85
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;

    iget-object v3, v3, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    invoke-virtual {v3}, Lorg/apache/cordova/CordovaWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 86
    .local v0, "context":Landroid/content/Context;
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;

    invoke-direct {v1, v0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 87
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$targetUrl:Ljava/lang/String;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 88
    const-string/jumbo v3, "postParams"

    iget-object v4, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$postDataByteArray:[B

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[B)Landroid/content/Intent;

    .line 89
    const-string/jumbo v3, "method"

    iget-object v4, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$method:Ljava/lang/String;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 90
    const-string/jumbo v3, "showRefreshButton"

    iget-boolean v4, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$showRefreshButton:Z

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 91
    const-string/jumbo v3, "showActionButton"

    iget-boolean v4, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$showActionButton:Z

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 92
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;

    iget-object v3, v3, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    iget-object v4, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;

    const/16 v5, 0x2712

    invoke-interface {v3, v4, v1, v5}, Lorg/apache/cordova/CordovaInterface;->startActivityForResult(Lorg/apache/cordova/CordovaPlugin;Landroid/content/Intent;I)V

    .line 96
    new-instance v2, Lorg/apache/cordova/PluginResult;

    sget-object v3, Lorg/apache/cordova/PluginResult$Status;->OK:Lorg/apache/cordova/PluginResult$Status;

    const-string/jumbo v4, "successCallback"

    invoke-direct {v2, v3, v4}, Lorg/apache/cordova/PluginResult;-><init>(Lorg/apache/cordova/PluginResult$Status;Ljava/lang/String;)V

    .line 97
    .local v2, "pluginResult":Lorg/apache/cordova/PluginResult;
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lorg/apache/cordova/PluginResult;->setKeepCallback(Z)V

    .line 98
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;

    # getter for: Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;
    invoke-static {v3}, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->access$000(Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;)Lorg/apache/cordova/CallbackContext;

    move-result-object v3

    invoke-virtual {v3, v2}, Lorg/apache/cordova/CallbackContext;->sendPluginResult(Lorg/apache/cordova/PluginResult;)V

    .line 99
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 100
    sget-object v3, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "MASH API ShowEmbeddedBrowser is executed successfully. targetUrl="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$targetUrl:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " method="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$method:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " showRefreshButton="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v5, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$showRefreshButton:Z

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " showActionButton="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v5, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;->val$showActionButton:Z

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 106
    :cond_0
    return-void
.end method
