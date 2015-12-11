.class public Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHMShopCardScannerPlugin.java"


# static fields
.field private static final validCardTypes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mCallback:Lorg/apache/cordova/CallbackContext;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$1;

    invoke-direct {v0}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->validCardTypes:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method private cardToJSON(Landroid/content/Intent;)Lorg/json/JSONObject;
    .locals 12
    .param p1, "data"    # Landroid/content/Intent;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 169
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 170
    .local v1, "cardInfo":Lorg/json/JSONObject;
    if-eqz p1, :cond_1

    .line 171
    const-string/jumbo v10, "CARD_NUMBERS"

    invoke-virtual {p1, v10}, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    .line 172
    .local v2, "cardNumbers":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string/jumbo v10, "NUMBER_CONFIDENCE"

    invoke-virtual {p1, v10}, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v9

    .line 174
    .local v9, "numberConfidence":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0, v2, v9}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->generateCardData(Ljava/util/List;Ljava/util/List;)Lorg/json/JSONArray;

    move-result-object v8

    .line 176
    .local v8, "number":Lorg/json/JSONArray;
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 177
    .local v0, "cardData":Lorg/json/JSONObject;
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v10

    const-string/jumbo v11, "CARD_EXPIRATION_MONTHS"

    invoke-virtual {v10, v11}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_0

    .line 178
    const-string/jumbo v10, "CARD_EXPIRATION_MONTHS"

    invoke-virtual {p1, v10}, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v5

    .line 179
    .local v5, "expirationMonths":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string/jumbo v10, "CARD_EXPIRATION_YEARS"

    invoke-virtual {p1, v10}, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v7

    .line 180
    .local v7, "expirationYears":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string/jumbo v10, "EXPIRAITON_CONFIDENCE"

    invoke-virtual {p1, v10}, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v3

    .line 182
    .local v3, "expirationConfidence":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0, v5, v3}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->generateCardData(Ljava/util/List;Ljava/util/List;)Lorg/json/JSONArray;

    move-result-object v4

    .line 183
    .local v4, "expirationMonth":Lorg/json/JSONArray;
    invoke-direct {p0, v7, v3}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->generateCardData(Ljava/util/List;Ljava/util/List;)Lorg/json/JSONArray;

    move-result-object v6

    .line 185
    .local v6, "expirationYear":Lorg/json/JSONArray;
    const-string/jumbo v10, "expirationMonth"

    invoke-virtual {v0, v10, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 186
    const-string/jumbo v10, "expirationYear"

    invoke-virtual {v0, v10, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 188
    .end local v3    # "expirationConfidence":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v4    # "expirationMonth":Lorg/json/JSONArray;
    .end local v5    # "expirationMonths":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v6    # "expirationYear":Lorg/json/JSONArray;
    .end local v7    # "expirationYears":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    const-string/jumbo v10, "number"

    invoke-virtual {v0, v10, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 190
    const-string/jumbo v10, "cardData"

    invoke-virtual {v1, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 191
    const-string/jumbo v10, "cardType"

    const/4 v11, 0x1

    invoke-virtual {v1, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 193
    .end local v0    # "cardData":Lorg/json/JSONObject;
    .end local v2    # "cardNumbers":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v8    # "number":Lorg/json/JSONArray;
    .end local v9    # "numberConfidence":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_1
    return-object v1
.end method

.method private existsInvalidCardType(Ljava/util/List;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 153
    .local p1, "cardTypes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 154
    .local v0, "cardType":I
    sget-object v2, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->validCardTypes:Ljava/util/List;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 155
    const/4 v2, 0x1

    .line 158
    .end local v0    # "cardType":I
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private generateCardData(Ljava/util/List;Ljava/util/List;)Lorg/json/JSONArray;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lorg/json/JSONArray;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 204
    .local p1, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p2, "confidence":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    .line 205
    .local v0, "cardData":Lorg/json/JSONArray;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    .line 206
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 207
    .local v1, "cardFieldData":Lorg/json/JSONObject;
    const-string/jumbo v3, "value"

    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 208
    const-string/jumbo v3, "confidence"

    invoke-interface {p2, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 209
    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 205
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 211
    .end local v1    # "cardFieldData":Lorg/json/JSONObject;
    :cond_0
    return-object v0
.end method

.method private getCardTypes(Lorg/json/JSONArray;)Ljava/util/List;
    .locals 4
    .param p1, "args"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 138
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 139
    .local v1, "cardTypes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v3, 0x0

    invoke-virtual {p1, v3}, Lorg/json/JSONArray;->getJSONArray(I)Lorg/json/JSONArray;

    move-result-object v0

    .line 141
    .local v0, "cardTypeArray":Lorg/json/JSONArray;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v2, v3, :cond_0

    .line 142
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 141
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 145
    :cond_0
    return-object v1
.end method

.method private handleActivityResultForShowCardScanner(ILandroid/content/Intent;)V
    .locals 4
    .param p1, "resultCode"    # I
    .param p2, "data"    # Landroid/content/Intent;

    .prologue
    .line 112
    const/4 v2, -0x1

    if-ne p1, v2, :cond_0

    .line 114
    :try_start_0
    invoke-direct {p0, p2}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->cardToJSON(Landroid/content/Intent;)Lorg/json/JSONObject;

    move-result-object v1

    .line 115
    .local v1, "json":Lorg/json/JSONObject;
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v2, v1}, Lorg/apache/cordova/CallbackContext;->success(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 128
    .end local v1    # "json":Lorg/json/JSONObject;
    :goto_0
    return-void

    .line 116
    :catch_0
    move-exception v0

    .line 117
    .local v0, "e":Lorg/json/JSONException;
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 119
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_0
    if-nez p1, :cond_2

    .line 120
    if-eqz p2, :cond_1

    const-string/jumbo v2, "CANNOT_OPEN_CAMERA"

    const/4 v3, 0x0

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 121
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/CardScannerError;->CANNOT_OPEN_CAMERA:Lcom/amazon/mobile/mash/error/CardScannerError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/CardScannerError;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 123
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->USER_CANCELLED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 126
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method

.method private showCardScanner(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 4
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 75
    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    .line 77
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->getCardTypes(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v0

    .line 79
    .local v0, "cardTypes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-direct {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->existsInvalidCardType(Ljava/util/List;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 80
    sget-object v2, Lcom/amazon/mobile/mash/error/CardScannerError;->INVALID_CARD_TYPE:Lcom/amazon/mobile/mash/error/CardScannerError;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/CardScannerError;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {p2, v2}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 99
    .end local v0    # "cardTypes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    :goto_0
    return-void

    .line 84
    .restart local v0    # "cardTypes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    :cond_0
    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 85
    new-instance v2, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$2;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$2;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;)V

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 96
    .end local v0    # "cardTypes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    :catch_0
    move-exception v1

    .line 97
    .local v1, "e":Lorg/json/JSONException;
    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 94
    .end local v1    # "e":Lorg/json/JSONException;
    .restart local v0    # "cardTypes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    :cond_1
    :try_start_1
    sget-object v2, Lcom/amazon/mobile/mash/error/CardScannerError;->NO_SUPPORTED_CARD_TYPES:Lcom/amazon/mobile/mash/error/CardScannerError;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/CardScannerError;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {p2, v2}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
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
    .line 52
    const-string/jumbo v0, "ShowCardScanner"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 53
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->showCardScanner(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 57
    const/4 v0, 0x1

    :goto_0
    return v0

    .line 55
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
    .line 62
    const/16 v0, 0x14

    if-ne p1, v0, :cond_0

    .line 63
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->handleActivityResultForShowCardScanner(ILandroid/content/Intent;)V

    .line 65
    :cond_0
    return-void
.end method
