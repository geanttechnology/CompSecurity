.class public Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHEmbeddedBrowserPlugin.java"


# instance fields
.field private mCallbackContext:Lorg/apache/cordova/CallbackContext;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;)Lorg/apache/cordova/CallbackContext;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    return-object v0
.end method

.method private exitEmbeddedBrowser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 7
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 119
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 121
    .local v2, "targetUrl":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {v2}, Lcom/amazon/mobile/mash/util/Util;->isUrlWhitelisted(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 122
    sget-object v0, Lcom/amazon/mobile/mash/error/ExitEmbeddedBrowserError;->TARGET_URL_NOT_ALLOWED:Lcom/amazon/mobile/mash/error/ExitEmbeddedBrowserError;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/error/ExitEmbeddedBrowserError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {p2, v0}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 154
    :goto_0
    return-void

    .line 125
    :cond_0
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 126
    .local v3, "method":Ljava/lang/String;
    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    .line 128
    .local v6, "postParametersJSON":Lorg/json/JSONObject;
    invoke-static {v6}, Lcom/amazon/mobile/mash/util/Util;->getPostDataAsByteArray(Lorg/json/JSONObject;)[B

    move-result-object v4

    .line 130
    .local v4, "postParameters":[B
    new-instance v0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;

    move-object v1, p0

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$2;-><init>(Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;Ljava/lang/String;Ljava/lang/String;[BLorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method private showEmbeddedBrowser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 8
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 67
    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    .line 68
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 69
    .local v2, "targetUrl":Ljava/lang/String;
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 70
    .local v4, "method":Ljava/lang/String;
    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v7

    .line 71
    .local v7, "postDataJSON":Lorg/json/JSONObject;
    invoke-static {v7}, Lcom/amazon/mobile/mash/util/Util;->getPostDataAsByteArray(Lorg/json/JSONObject;)[B

    move-result-object v3

    .line 73
    .local v3, "postDataByteArray":[B
    const/4 v0, 0x4

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getBoolean(I)Z

    move-result v5

    .line 74
    .local v5, "showRefreshButton":Z
    const/4 v0, 0x5

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getBoolean(I)Z

    move-result v6

    .line 77
    .local v6, "showActionButton":Z
    const-string/jumbo v0, "GET"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "POST"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 78
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    sget-object v1, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v1}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 108
    :goto_0
    return-void

    .line 82
    :cond_0
    new-instance v0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin$1;-><init>(Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;Ljava/lang/String;[BLjava/lang/String;ZZ)V

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method


# virtual methods
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
    .line 49
    const-string/jumbo v0, "ShowEmbeddedBrowser"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 50
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->showEmbeddedBrowser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 54
    :cond_0
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 51
    :cond_1
    const-string/jumbo v0, "ExitEmbeddedBrowser"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 52
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->exitEmbeddedBrowser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 5
    .param p1, "reqCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/16 v4, 0x2712

    .line 158
    if-ne p1, v4, :cond_0

    .line 159
    const/4 v3, -0x1

    if-ne p2, v3, :cond_2

    .line 160
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p3, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 161
    .local v2, "targetUrl":Ljava/lang/String;
    const-string/jumbo v3, "method"

    invoke-virtual {p3, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 162
    .local v0, "method":Ljava/lang/String;
    const-string/jumbo v3, "postParams"

    invoke-virtual {p3, v3}, Landroid/content/Intent;->getByteArrayExtra(Ljava/lang/String;)[B

    move-result-object v1

    .line 164
    .local v1, "postParameters":[B
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 166
    const-string/jumbo v3, "POST"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 167
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    invoke-virtual {v3, v2, v1}, Lorg/apache/cordova/CordovaWebView;->postUrl(Ljava/lang/String;[B)V

    .line 179
    .end local v0    # "method":Ljava/lang/String;
    .end local v1    # "postParameters":[B
    .end local v2    # "targetUrl":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 169
    .restart local v0    # "method":Ljava/lang/String;
    .restart local v1    # "postParameters":[B
    .restart local v2    # "targetUrl":Ljava/lang/String;
    :cond_1
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    invoke-virtual {v3, v2}, Lorg/apache/cordova/CordovaWebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0

    .line 172
    .end local v0    # "method":Ljava/lang/String;
    .end local v1    # "postParameters":[B
    .end local v2    # "targetUrl":Ljava/lang/String;
    :cond_2
    if-ne p2, v4, :cond_0

    .line 174
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHEmbeddedBrowserPlugin;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    const-string/jumbo v4, "doneButtonCallback"

    invoke-virtual {v3, v4}, Lorg/apache/cordova/CallbackContext;->success(Ljava/lang/String;)V

    goto :goto_0
.end method
