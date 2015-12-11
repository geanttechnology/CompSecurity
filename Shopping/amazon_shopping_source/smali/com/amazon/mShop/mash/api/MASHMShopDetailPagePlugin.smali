.class public Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHMShopDetailPagePlugin.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method private showOfferListingPage(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 6
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 40
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 41
    .local v2, "asin":Ljava/lang/String;
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 42
    .local v3, "listId":Ljava/lang/String;
    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 43
    .local v4, "listItemId":Ljava/lang/String;
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;

    move-object v1, p0

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;-><init>(Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 51
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
    .line 23
    const-string/jumbo v0, "ShowOfferListingPage"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 24
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin;->showOfferListingPage(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 25
    const/4 v0, 0x1

    .line 29
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
