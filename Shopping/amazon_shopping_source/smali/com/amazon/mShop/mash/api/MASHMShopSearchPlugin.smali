.class public Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHMShopSearchPlugin.java"


# instance fields
.field private mCallback:Lorg/apache/cordova/CallbackContext;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method private barcodeToJSON(Landroid/content/Intent;)Lorg/json/JSONObject;
    .locals 4
    .param p1, "data"    # Landroid/content/Intent;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 132
    const/4 v1, 0x0

    .line 133
    .local v1, "json":Lorg/json/JSONObject;
    if-eqz p1, :cond_0

    .line 141
    const-string/jumbo v2, "BARCODE_STRING"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 142
    .local v0, "barcodeString":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 143
    new-instance v1, Lorg/json/JSONObject;

    .end local v1    # "json":Lorg/json/JSONObject;
    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 144
    .restart local v1    # "json":Lorg/json/JSONObject;
    const-string/jumbo v2, "barcodeData"

    invoke-virtual {v1, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 145
    const-string/jumbo v2, "barcodeType"

    const-string/jumbo v3, ""

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 149
    .end local v0    # "barcodeString":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method private handleActivityResultForShowBarcodeScanner(ILandroid/content/Intent;)V
    .locals 4
    .param p1, "resultCode"    # I
    .param p2, "data"    # Landroid/content/Intent;

    .prologue
    .line 101
    const/4 v2, -0x1

    if-ne p1, v2, :cond_1

    .line 104
    :try_start_0
    invoke-direct {p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->barcodeToJSON(Landroid/content/Intent;)Lorg/json/JSONObject;

    move-result-object v1

    .line 105
    .local v1, "json":Lorg/json/JSONObject;
    if-eqz v1, :cond_0

    .line 106
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v2, v1}, Lorg/apache/cordova/CallbackContext;->success(Lorg/json/JSONObject;)V

    .line 123
    .end local v1    # "json":Lorg/json/JSONObject;
    :goto_0
    return-void

    .line 108
    .restart local v1    # "json":Lorg/json/JSONObject;
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->USER_CANCELLED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 110
    .end local v1    # "json":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 111
    .local v0, "e":Lorg/json/JSONException;
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 113
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_1
    if-nez p1, :cond_3

    .line 114
    if-eqz p2, :cond_2

    const-string/jumbo v2, "CANNOT_OPEN_CAMERA"

    const/4 v3, 0x0

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 115
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/BarcodeScanError;->CANNOT_OPEN_CAMERA:Lcom/amazon/mobile/mash/error/BarcodeScanError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/BarcodeScanError;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 117
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->USER_CANCELLED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 121
    :cond_3
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method

.method private showBarcodeScanner(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 64
    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    .line 65
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin$1;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 73
    return-void
.end method

.method private showShopByDepartment(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 83
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin$2;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin$2;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 91
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
    const-string/jumbo v0, "ShowShopByDepartment"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 37
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->showShopByDepartment(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 46
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0

    .line 39
    :cond_0
    const-string/jumbo v0, "ShowBarcodeScanner"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 40
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->showBarcodeScanner(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 44
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
    .line 51
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 52
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopSearchPlugin;->handleActivityResultForShowBarcodeScanner(ILandroid/content/Intent;)V

    .line 54
    :cond_0
    return-void
.end method
