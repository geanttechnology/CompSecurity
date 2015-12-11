.class public Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHMShopYourAccountPlugin.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method private changedSmileStatus(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 4
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 165
    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Lorg/json/JSONArray;->getBoolean(I)Z

    move-result v1

    .line 168
    .local v1, "isSmile":Z
    if-eqz v1, :cond_0

    invoke-virtual {p1, v3}, Lorg/json/JSONArray;->isNull(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 169
    sget-object v2, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {p2, v2}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 189
    :goto_0
    return-void

    .line 172
    :cond_0
    invoke-virtual {p1, v3}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 174
    .local v0, "charityName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/smile/SmileHelper;->shouldSyncSmileInfo()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/model/auth/User;->getCharity()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 175
    invoke-virtual {p2}, Lorg/apache/cordova/CallbackContext;->success()V

    goto :goto_0

    .line 178
    :cond_1
    new-instance v2, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$6;

    invoke-direct {v2, p0, v1, v0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$6;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;ZLjava/lang/String;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method private showAdsPreferences(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 65
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$1;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$1;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 77
    return-void
.end method

.method private showAmazonPoints(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 87
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$2;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$2;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 99
    return-void
.end method

.method private showOneClickSettings(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 109
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$3;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$3;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 119
    return-void
.end method

.method private showRecommendations(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 147
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$5;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$5;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 155
    return-void
.end method

.method private showYourAccount(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 129
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$4;

    invoke-direct {v0, p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$4;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 137
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
    .line 30
    const-string/jumbo v0, "ShowYourAccount"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 31
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->showYourAccount(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 53
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0

    .line 33
    :cond_0
    const-string/jumbo v0, "ShowRecommendations"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 34
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->showRecommendations(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 36
    :cond_1
    const-string/jumbo v0, "ShowOneClickSettings"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 37
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->showOneClickSettings(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 39
    :cond_2
    const-string/jumbo v0, "ShowAmazonPoints"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 40
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->showAmazonPoints(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 42
    :cond_3
    const-string/jumbo v0, "ShowAdsPreferences"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 43
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->showAdsPreferences(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 44
    :cond_4
    const-string/jumbo v0, "UserChangedSmileStatus"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 45
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->changedSmileStatus(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 51
    :cond_5
    const/4 v0, 0x0

    goto :goto_1
.end method
