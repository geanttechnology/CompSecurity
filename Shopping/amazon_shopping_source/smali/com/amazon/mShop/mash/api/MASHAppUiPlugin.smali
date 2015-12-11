.class public Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHAppUiPlugin.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method private cancelFullscreen(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 45
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$1;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$1;-><init>(Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 53
    return-void
.end method

.method private navMenuFocusOnItem(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 2
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 81
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 82
    .local v0, "menuItemId":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$3;

    invoke-direct {v1, p0, v0, p2}, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$3;-><init>(Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 107
    return-void
.end method

.method private requestFullscreen(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 63
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$2;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$2;-><init>(Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 71
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
    .line 24
    const-string/jumbo v0, "CancelFullscreen"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 25
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;->cancelFullscreen(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 34
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0

    .line 26
    :cond_0
    const-string/jumbo v0, "RequestFullscreen"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 27
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;->requestFullscreen(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 28
    :cond_1
    const-string/jumbo v0, "FocusOnItem"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 29
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;->navMenuFocusOnItem(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 31
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method
