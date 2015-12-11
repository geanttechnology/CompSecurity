.class public Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHMShopAuthenticationPlugin.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$3;
    }
.end annotation


# instance fields
.field private mCallback:Lorg/apache/cordova/CallbackContext;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    .line 82
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;)Lorg/apache/cordova/CallbackContext;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    return-object v0
.end method

.method private handleActivityResultForLogout(I)V
    .locals 2
    .param p1, "resultCode"    # I

    .prologue
    .line 97
    const/4 v0, -0x1

    if-ne p1, v0, :cond_1

    .line 98
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v0}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 102
    :cond_0
    :goto_0
    return-void

    .line 99
    :cond_1
    if-nez p1, :cond_0

    .line 100
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v1, Lcom/amazon/mobile/mash/error/MASHError;->USER_CANCELLED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v1}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method

.method private logout(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
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
    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    .line 64
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 90
    return-void
.end method

.method private userChangedPrimeStatus(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 112
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$2;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$2;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 125
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
    .line 36
    const-string/jumbo v0, "Logout"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 37
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->logout(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 45
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0

    .line 38
    :cond_0
    const-string/jumbo v0, "UserChangedPrimeStatus"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 39
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->userChangedPrimeStatus(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 41
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 50
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 51
    invoke-direct {p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->handleActivityResultForLogout(I)V

    .line 53
    :cond_0
    return-void
.end method
