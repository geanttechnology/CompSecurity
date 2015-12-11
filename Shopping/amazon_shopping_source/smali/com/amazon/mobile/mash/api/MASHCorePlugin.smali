.class public Lcom/amazon/mobile/mash/api/MASHCorePlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHCorePlugin.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method private canLaunchIntentURL(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 8
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 241
    const/4 v5, 0x0

    invoke-virtual {p1, v5}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 242
    .local v4, "url":Ljava/lang/String;
    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v5, "android.intent.action.VIEW"

    invoke-direct {v1, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 243
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v1, v5}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 244
    iget-object v5, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    invoke-virtual {v5}, Lorg/apache/cordova/CordovaWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 245
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 246
    .local v3, "mgr":Landroid/content/pm/PackageManager;
    const/high16 v5, 0x10000

    invoke-virtual {v3, v1, v5}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v2

    .line 247
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_1

    const-string/jumbo v5, "true"

    :goto_0
    invoke-virtual {p2, v5}, Lorg/apache/cordova/CallbackContext;->success(Ljava/lang/String;)V

    .line 248
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 249
    sget-object v5, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "CanLaunchIntentURL is executed successfully. url="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 251
    :cond_0
    return-void

    .line 247
    :cond_1
    const-string/jumbo v5, "false"

    goto :goto_0
.end method

.method private launchIntentURL(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 2
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 211
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 212
    .local v0, "url":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mobile/mash/api/MASHCorePlugin$4;

    invoke-direct {v1, p0, v0, p2}, Lcom/amazon/mobile/mash/api/MASHCorePlugin$4;-><init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v1}, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 230
    return-void
.end method

.method private openInExternalBrowser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 2
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 188
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 189
    .local v0, "url":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mobile/mash/api/MASHCorePlugin$3;

    invoke-direct {v1, p0, v0, p2}, Lcom/amazon/mobile/mash/api/MASHCorePlugin$3;-><init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v1}, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 200
    return-void
.end method

.method private showAlert(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 10
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v1, 0x0

    .line 125
    invoke-virtual {p1, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 126
    .local v2, "title":Ljava/lang/String;
    invoke-virtual {p1, v5}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 127
    .local v3, "message":Ljava/lang/String;
    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getJSONArray(I)Lorg/json/JSONArray;

    move-result-object v9

    .line 128
    .local v9, "buttonTitles":Lorg/json/JSONArray;
    const/4 v0, 0x3

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 129
    .local v7, "cancelButtonTitle":Ljava/lang/String;
    invoke-virtual {v9}, Lorg/json/JSONArray;->length()I

    move-result v8

    .line 130
    .local v8, "lenOfButtonTitles":I
    invoke-virtual {v9, v1}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v4

    .line 131
    .local v4, "positiveButtonTitle":Ljava/lang/String;
    invoke-virtual {v9, v5}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v6

    .line 133
    .local v6, "neutralButtonTitle":Ljava/lang/String;
    new-instance v0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;

    move-object v1, p0

    move-object v5, p2

    invoke-direct/range {v0 .. v8}, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;-><init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;Ljava/lang/String;Ljava/lang/String;I)V

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 177
    return-void
.end method

.method private showChooser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 10
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 63
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 64
    .local v2, "title":Ljava/lang/String;
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getJSONArray(I)Lorg/json/JSONArray;

    move-result-object v8

    .line 65
    .local v8, "buttonTitles":Lorg/json/JSONArray;
    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 66
    .local v5, "cancelButtonTitle":Ljava/lang/String;
    const/4 v0, 0x3

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 67
    .local v7, "destructiveButtonTitle":Ljava/lang/String;
    invoke-virtual {v8}, Lorg/json/JSONArray;->length()I

    move-result v6

    .line 68
    .local v6, "lenOfButtonTitles":I
    new-array v3, v6, [Ljava/lang/String;

    .line 69
    .local v3, "buttonTitlesArray":[Ljava/lang/String;
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_0
    if-ge v9, v6, :cond_0

    .line 71
    invoke-virtual {v8, v9}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v9

    .line 69
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 74
    :cond_0
    new-instance v0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;

    move-object v1, p0

    move-object v4, p2

    invoke-direct/range {v0 .. v7}, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;-><init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/cordova/CallbackContext;Ljava/lang/String;ILjava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 115
    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/String;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)Z
    .locals 1
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "args"    # Lorg/json/JSONArray;
    .param p3, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 38
    const-string/jumbo v0, "ShowChooser"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 39
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->showChooser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 51
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0

    .line 40
    :cond_0
    const-string/jumbo v0, "ShowAlert"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 41
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->showAlert(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 42
    :cond_1
    const-string/jumbo v0, "OpenInExternalBrowser"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 43
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->openInExternalBrowser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 44
    :cond_2
    const-string/jumbo v0, "LaunchIntentURL"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 45
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->launchIntentURL(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 46
    :cond_3
    const-string/jumbo v0, "CanLaunchIntentURL"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 47
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->canLaunchIntentURL(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 49
    :cond_4
    const/4 v0, 0x0

    goto :goto_1
.end method
