.class Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;
.super Ljava/lang/Object;
.source "MASHEmbeddedBrowserPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->exitEmbeddedBrowser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;

.field final synthetic val$method:Ljava/lang/String;

.field final synthetic val$postParameters:[B

.field final synthetic val$targetUrl:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;Ljava/lang/String;Ljava/lang/String;[BLorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 130
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;

    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$targetUrl:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$method:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$postParameters:[B

    iput-object p5, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 133
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;

    iget-object v2, v2, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    check-cast v2, Lcom/amazon/mobile/mash/MASHWebView;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/MASHWebView;->isInEmbeddedBrowserMode()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 134
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 135
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$targetUrl:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 136
    const-string/jumbo v2, "method"

    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$method:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 137
    const-string/jumbo v2, "postParams"

    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$postParameters:[B

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[B)Landroid/content/Intent;

    .line 138
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;

    iget-object v2, v2, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v2}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 139
    .local v0, "activity":Landroid/app/Activity;
    const/4 v2, -0x1

    invoke-virtual {v0, v2, v1}, Landroid/app/Activity;->setResult(ILandroid/content/Intent;)V

    .line 140
    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 144
    .end local v0    # "activity":Landroid/app/Activity;
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_0
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v2}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 145
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 146
    sget-object v2, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "exitEmbeddedBrowser is executed successfully. \n arguments: targetUrl="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$targetUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " method="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$method:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 148
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$postParameters:[B

    if-eqz v2, :cond_1

    .line 149
    sget-object v2, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, " postData="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    new-instance v4, Ljava/lang/String;

    iget-object v5, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;->val$postParameters:[B

    invoke-direct {v4, v5}, Ljava/lang/String;-><init>([B)V

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    :cond_1
    return-void
.end method
