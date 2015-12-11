.class public Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHMShopCheckoutPlugin.java"


# instance fields
.field private mCallback:Lorg/apache/cordova/CallbackContext;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method static synthetic access$002(Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;Lorg/apache/cordova/CallbackContext;)Lorg/apache/cordova/CallbackContext;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;
    .param p1, "x1"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 21
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    return-object p1
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private addressToJSON(Lcom/amazon/rio/j2me/client/services/mShop/Address;)Lorg/json/JSONObject;
    .locals 5
    .param p1, "address"    # Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 110
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 111
    .local v2, "location":Lorg/json/JSONObject;
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 112
    .local v0, "addressJson":Lorg/json/JSONObject;
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getLocation()Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    move-result-object v1

    .line 113
    .local v1, "coordinates":Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;
    const-string/jumbo v3, "type"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 114
    const-string/jumbo v3, "addressId"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddressId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 115
    const-string/jumbo v3, "name"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 116
    const-string/jumbo v3, "address1"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddress1()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 117
    const-string/jumbo v3, "address2"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddress2()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 118
    const-string/jumbo v3, "address3"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddress3()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 119
    const-string/jumbo v3, "county"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getCounty()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 120
    const-string/jumbo v3, "city"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getCity()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 121
    const-string/jumbo v3, "state"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getState()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 122
    const-string/jumbo v3, "zip"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getZip()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 123
    const-string/jumbo v3, "country"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getCountry()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 124
    const-string/jumbo v3, "countryCode"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getCountryCode()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 125
    const-string/jumbo v3, "phone"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getPhone()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 126
    const-string/jumbo v3, "information"

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getInformation()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 127
    if-eqz v1, :cond_0

    .line 128
    const-string/jumbo v3, "latitude"

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->getLatitude()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 129
    const-string/jumbo v3, "longitude"

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->getLongitude()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 130
    const-string/jumbo v3, "location"

    invoke-virtual {v0, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 132
    :cond_0
    return-object v0
.end method

.method private handleActivityResultForShowDeliveryDestinationPicker(ILandroid/content/Intent;)V
    .locals 4
    .param p1, "resultCode"    # I
    .param p2, "data"    # Landroid/content/Intent;

    .prologue
    .line 85
    const/4 v2, -0x1

    if-ne p1, v2, :cond_2

    .line 86
    sget-object v2, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedAddresss:Ljava/util/List;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .line 87
    .local v0, "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    if-eqz v0, :cond_1

    .line 89
    :try_start_0
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->addressToJSON(Lcom/amazon/rio/j2me/client/services/mShop/Address;)Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->success(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 101
    .end local v0    # "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    :cond_0
    :goto_0
    return-void

    .line 90
    .restart local v0    # "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    :catch_0
    move-exception v1

    .line 91
    .local v1, "e":Lorg/json/JSONException;
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 92
    sget-object v2, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "json error"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 95
    .end local v1    # "e":Lorg/json/JSONException;
    :cond_1
    sget-object v2, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "onActivityResult: address is null"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 96
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 98
    .end local v0    # "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    :cond_2
    if-nez p1, :cond_0

    .line 99
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->USER_CANCELLED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method

.method private showDeliveryDestinationPicker(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 57
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 76
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
    .line 35
    const-string/jumbo v0, "ShowDeliveryDestinationPicker"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 36
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->showDeliveryDestinationPicker(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 37
    const/4 v0, 0x1

    .line 39
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 44
    const/4 v0, 0x6

    if-ne p1, v0, :cond_0

    .line 45
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->handleActivityResultForShowDeliveryDestinationPicker(ILandroid/content/Intent;)V

    .line 47
    :cond_0
    return-void
.end method
