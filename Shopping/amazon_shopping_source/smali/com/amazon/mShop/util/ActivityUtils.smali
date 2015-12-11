.class public Lcom/amazon/mShop/util/ActivityUtils;
.super Ljava/lang/Object;
.source "ActivityUtils.java"


# static fields
.field public static final ASIN_AMAZON_COINS:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final DEBUG:Z

.field private static final EXCLUDED_MODEL_FOR_HTML_GATEWAY_HA_OFF:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 123
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    .line 131
    new-instance v0, Ljava/util/HashSet;

    const/16 v1, 0xf

    new-array v1, v1, [Ljava/lang/String;

    const-string/jumbo v2, "B0096E8CQA"

    aput-object v2, v1, v4

    const-string/jumbo v2, "B0096E8DAU"

    aput-object v2, v1, v5

    const-string/jumbo v2, "B0096E8DSM"

    aput-object v2, v1, v6

    const/4 v2, 0x3

    const-string/jumbo v3, "B0096E8EC2"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string/jumbo v3, "B0096E8EPY"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string/jumbo v3, "B00ESJDO66"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string/jumbo v3, "B00ESJDP9W"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    const-string/jumbo v3, "B00ESJDQ8M"

    aput-object v3, v1, v2

    const/16 v2, 0x8

    const-string/jumbo v3, "B00ESJDR9A"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    const-string/jumbo v3, "B00ESJDS62"

    aput-object v3, v1, v2

    const/16 v2, 0xa

    const-string/jumbo v3, "B00FA49T6M"

    aput-object v3, v1, v2

    const/16 v2, 0xb

    const-string/jumbo v3, "B00FA49URU"

    aput-object v3, v1, v2

    const/16 v2, 0xc

    const-string/jumbo v3, "B00FA49WCI"

    aput-object v3, v1, v2

    const/16 v2, 0xd

    const-string/jumbo v3, "B00FA49XX6"

    aput-object v3, v1, v2

    const/16 v2, 0xe

    const-string/jumbo v3, "B00FA49ZIO"

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    sput-object v0, Lcom/amazon/mShop/util/ActivityUtils;->ASIN_AMAZON_COINS:Ljava/util/HashSet;

    .line 139
    new-instance v0, Ljava/util/ArrayList;

    new-array v1, v6, [Ljava/lang/String;

    const-string/jumbo v2, "One X"

    aput-object v2, v1, v4

    const-string/jumbo v2, "S720e"

    aput-object v2, v1, v5

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    sput-object v0, Lcom/amazon/mShop/util/ActivityUtils;->EXCLUDED_MODEL_FOR_HTML_GATEWAY_HA_OFF:Ljava/util/ArrayList;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 116
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static appendAssociateTagParameter(Landroid/net/Uri$Builder;Ljava/util/Map;)V
    .locals 2
    .param p0, "builder"    # Landroid/net/Uri$Builder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri$Builder;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1327
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/AttributionUtils;->getAssociatesTag(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 1328
    .local v0, "associateTag":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1329
    const-string/jumbo v1, "tag"

    invoke-virtual {p0, v1, v0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1330
    const-string/jumbo v1, "tag"

    invoke-static {p1, v1}, Lcom/amazon/mShop/util/ActivityUtils;->removeParam(Ljava/util/Map;Ljava/lang/String;)V

    .line 1332
    :cond_0
    return-void
.end method

.method public static appendParamsToURL(Landroid/net/Uri$Builder;Ljava/util/Map;)V
    .locals 4
    .param p0, "builder"    # Landroid/net/Uri$Builder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri$Builder;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1336
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p1, :cond_2

    .line 1337
    invoke-interface {p1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 1338
    .local v1, "key":Ljava/lang/String;
    const-class v2, Ljava/lang/String;

    invoke-static {p1, v1, v2}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 1341
    const-string/jumbo v2, "ref"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1342
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "ref="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v2, "ref"

    invoke-interface {p1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_0

    .line 1344
    :cond_1
    invoke-interface {p1, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {p0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_0

    .line 1349
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "key":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method protected static deviceExcludedHtmalGatewayHAOff()Z
    .locals 4

    .prologue
    .line 1989
    sget-object v2, Lcom/amazon/mShop/util/ActivityUtils;->EXCLUDED_MODEL_FOR_HTML_GATEWAY_HA_OFF:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 1990
    .local v1, "modelKeyWord":Ljava/lang/String;
    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1991
    const/4 v2, 0x1

    .line 1994
    .end local v1    # "modelKeyWord":Ljava/lang/String;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static getAIVGatewayUrl(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 2016
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_url:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getAccountPhoneNumberOption()Ljava/lang/String;
    .locals 3

    .prologue
    .line 1850
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 1851
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v2, "accountPhoneNumber"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1852
    .local v1, "option":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string/jumbo v1, "Account Weblab Control"

    .end local v1    # "option":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method private static getCheckOutPostParams(Lcom/amazon/mShop/opl/PurchaseParams;)[B
    .locals 12
    .param p0, "parameters"    # Lcom/amazon/mShop/opl/PurchaseParams;

    .prologue
    const/4 v11, 0x1

    .line 1706
    new-instance v1, Landroid/net/Uri$Builder;

    invoke-direct {v1}, Landroid/net/Uri$Builder;-><init>()V

    .line 1707
    .local v1, "builder":Landroid/net/Uri$Builder;
    if-eqz p0, :cond_7

    invoke-virtual {p0}, Lcom/amazon/mShop/opl/PurchaseParams;->isCartPurchase()Z

    move-result v9

    if-nez v9, :cond_7

    .line 1708
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/PurchaseParams;->getAsin()Ljava/lang/String;

    move-result-object v0

    .line 1709
    .local v0, "asin":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_0

    .line 1710
    const-string/jumbo v9, "asin"

    invoke-virtual {v1, v9, v0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1713
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/PurchaseParams;->getOfferId()Ljava/lang/String;

    move-result-object v5

    .line 1714
    .local v5, "offerId":Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_1

    .line 1715
    const-string/jumbo v9, "offeringID"

    invoke-virtual {v1, v9, v5}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1718
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/PurchaseParams;->getListId()Ljava/lang/String;

    move-result-object v3

    .line 1719
    .local v3, "listId":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_2

    .line 1720
    const-string/jumbo v9, "registryID"

    invoke-virtual {v1, v9, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1723
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/PurchaseParams;->getListItemId()Ljava/lang/String;

    move-result-object v4

    .line 1724
    .local v4, "listItemId":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_3

    .line 1725
    const-string/jumbo v9, "registryItemID"

    invoke-virtual {v1, v9, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1728
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/PurchaseParams;->getOneClickShippingSpeed()Ljava/lang/String;

    move-result-object v8

    .line 1729
    .local v8, "shippingSpeed":Ljava/lang/String;
    invoke-static {v8}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_6

    .line 1730
    const-string/jumbo v9, "shippingSpeed"

    invoke-virtual {v1, v9, v8}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1731
    const-string/jumbo v9, "oneClick"

    invoke-static {v11}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v9, v10}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1736
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/PurchaseParams;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v2

    .line 1737
    .local v2, "clickstreamOrigin":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_4

    .line 1738
    const-string/jumbo v9, "clickstreamOrigin"

    invoke-virtual {v1, v9, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1745
    .end local v0    # "asin":Ljava/lang/String;
    .end local v2    # "clickstreamOrigin":Ljava/lang/String;
    .end local v3    # "listId":Ljava/lang/String;
    .end local v4    # "listItemId":Ljava/lang/String;
    .end local v5    # "offerId":Ljava/lang/String;
    .end local v8    # "shippingSpeed":Ljava/lang/String;
    :cond_4
    :goto_1
    invoke-static {}, Lcom/amazon/mShop/net/CookieBridge;->getCurrentSessionId()Ljava/lang/String;

    move-result-object v7

    .line 1746
    .local v7, "sessionID":Ljava/lang/String;
    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_5

    .line 1747
    const-string/jumbo v9, "sessionID"

    invoke-virtual {v1, v9, v7}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1750
    :cond_5
    const-string/jumbo v9, "timestamp"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v9, v10}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1751
    invoke-virtual {v1}, Landroid/net/Uri$Builder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_8

    const/4 v6, 0x0

    .line 1752
    .local v6, "postParameters":[B
    :goto_2
    return-object v6

    .line 1733
    .end local v6    # "postParameters":[B
    .end local v7    # "sessionID":Ljava/lang/String;
    .restart local v0    # "asin":Ljava/lang/String;
    .restart local v3    # "listId":Ljava/lang/String;
    .restart local v4    # "listItemId":Ljava/lang/String;
    .restart local v5    # "offerId":Ljava/lang/String;
    .restart local v8    # "shippingSpeed":Ljava/lang/String;
    :cond_6
    const-string/jumbo v9, "buyNow"

    invoke-static {v11}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v9, v10}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_0

    .line 1741
    .end local v0    # "asin":Ljava/lang/String;
    .end local v3    # "listId":Ljava/lang/String;
    .end local v4    # "listItemId":Ljava/lang/String;
    .end local v5    # "offerId":Ljava/lang/String;
    .end local v8    # "shippingSpeed":Ljava/lang/String;
    :cond_7
    const-string/jumbo v9, "proceedToCheckout"

    invoke-static {v11}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v9, v10}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1742
    const-string/jumbo v9, "useDefaultCart"

    invoke-static {v11}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v9, v10}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_1

    .line 1751
    .restart local v7    # "sessionID":Ljava/lang/String;
    :cond_8
    invoke-virtual {v1}, Landroid/net/Uri$Builder;->toString()Ljava/lang/String;

    move-result-object v9

    const-string/jumbo v10, "UTF-8"

    invoke-static {v9, v10}, Lorg/apache/http/util/EncodingUtils;->getBytes(Ljava/lang/String;Ljava/lang/String;)[B

    move-result-object v6

    goto :goto_2
.end method

.method private static getFullUdpUrl(Ljava/lang/String;Lcom/amazon/mShop/control/item/ProductController;Ljava/util/Map;)Ljava/lang/String;
    .locals 10
    .param p0, "baseUrl"    # Ljava/lang/String;
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/control/item/ProductController;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 1217
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    invoke-virtual {v8}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 1220
    .local v0, "builder":Landroid/net/Uri$Builder;
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getListId()Ljava/lang/String;

    move-result-object v3

    .line 1221
    .local v3, "listId":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 1222
    const-string/jumbo v8, "colid"

    invoke-virtual {v0, v8, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1223
    const-string/jumbo v8, "colid"

    invoke-static {p2, v8}, Lcom/amazon/mShop/util/ActivityUtils;->removeParam(Ljava/util/Map;Ljava/lang/String;)V

    .line 1226
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getListItemId()Ljava/lang/String;

    move-result-object v4

    .line 1227
    .local v4, "listItemId":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 1228
    const-string/jumbo v8, "coliid"

    invoke-virtual {v0, v8, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1229
    const-string/jumbo v8, "coliid"

    invoke-static {p2, v8}, Lcom/amazon/mShop/util/ActivityUtils;->removeParam(Ljava/util/Map;Ljava/lang/String;)V

    .line 1234
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getPendingDealId()Ljava/lang/String;

    move-result-object v1

    .line 1235
    .local v1, "dealId":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_2

    .line 1236
    const-string/jumbo v8, "di"

    invoke-virtual {v0, v8, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1237
    const-string/jumbo v8, "di"

    invoke-static {p2, v8}, Lcom/amazon/mShop/util/ActivityUtils;->removeParam(Ljava/util/Map;Ljava/lang/String;)V

    .line 1240
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getPendingDealType()Ljava/lang/String;

    move-result-object v2

    .line 1241
    .local v2, "dealType":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 1242
    const-string/jumbo v8, "dt"

    invoke-virtual {v0, v8, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1243
    const-string/jumbo v8, "dt"

    invoke-static {p2, v8}, Lcom/amazon/mShop/util/ActivityUtils;->removeParam(Ljava/util/Map;Ljava/lang/String;)V

    .line 1248
    :cond_3
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getMerchantId()Ljava/lang/String;

    move-result-object v5

    .line 1249
    .local v5, "merchantId":Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 1250
    const-string/jumbo v8, "m"

    invoke-virtual {v0, v8, v5}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1251
    const-string/jumbo v8, "m"

    invoke-static {p2, v8}, Lcom/amazon/mShop/util/ActivityUtils;->removeParam(Ljava/util/Map;Ljava/lang/String;)V

    .line 1255
    :cond_4
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getClickStreamTag()Lcom/amazon/mShop/control/item/ClickStreamTag;

    move-result-object v8

    invoke-virtual {v8}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v7

    .line 1256
    .local v7, "tag":Ljava/lang/String;
    sget-object v8, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_WISHLIST:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v8}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_5

    sget-object v8, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_CART:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v8}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 1259
    :cond_5
    const-string/jumbo v8, "vs"

    const-string/jumbo v9, "1"

    invoke-virtual {v0, v8, v9}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1260
    const-string/jumbo v8, "vs"

    invoke-static {p2, v8}, Lcom/amazon/mShop/util/ActivityUtils;->removeParam(Ljava/util/Map;Ljava/lang/String;)V

    .line 1265
    :cond_6
    invoke-static {v0, p2}, Lcom/amazon/mShop/util/ActivityUtils;->appendAssociateTagParameter(Landroid/net/Uri$Builder;Ljava/util/Map;)V

    .line 1272
    const-string/jumbo v6, ""

    .line 1273
    .local v6, "refmarker":Ljava/lang/String;
    if-eqz p2, :cond_7

    const-string/jumbo v8, "ref"

    invoke-interface {p2, v8}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 1274
    const-string/jumbo v8, "ref"

    invoke-interface {p2, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .end local v6    # "refmarker":Ljava/lang/String;
    check-cast v6, Ljava/lang/String;

    .line 1275
    .restart local v6    # "refmarker":Ljava/lang/String;
    const-string/jumbo v8, "ref"

    invoke-static {p2, v8}, Lcom/amazon/mShop/util/ActivityUtils;->removeParam(Ljava/util/Map;Ljava/lang/String;)V

    .line 1277
    :cond_7
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_a

    .line 1278
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "ref="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v8}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1285
    :cond_8
    :goto_0
    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_9

    .line 1286
    const-string/jumbo v8, "clickstream-tag"

    invoke-virtual {v0, v8, v7}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1290
    :cond_9
    invoke-static {v0, p2}, Lcom/amazon/mShop/util/ActivityUtils;->appendParamsToURL(Landroid/net/Uri$Builder;Ljava/util/Map;)V

    .line 1292
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v8

    invoke-virtual {v8}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v8

    return-object v8

    .line 1279
    :cond_a
    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_8

    .line 1280
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "ref="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-static {v7}, Lcom/amazon/mShop/control/item/ClickStreamTag;->createFullClickstreamTag(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v8}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_0
.end method

.method public static getHTMLGatewayUrl(Landroid/content/Context;Ljava/util/Map;)Ljava/lang/String;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 190
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v4

    const-string/jumbo v5, "currentGatewayUrl"

    invoke-interface {v4, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 191
    .local v3, "url":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 193
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->gateway_web_page_url:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 196
    :cond_0
    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    .line 198
    .local v1, "builder":Landroid/net/Uri$Builder;
    invoke-static {v1, p1}, Lcom/amazon/mShop/util/ActivityUtils;->appendParamsToURL(Landroid/net/Uri$Builder;Ljava/util/Map;)V

    .line 200
    const/4 v2, 0x0

    .line 201
    .local v2, "isAssociatedTagExisted":Z
    if-eqz p1, :cond_1

    const-string/jumbo v4, "tag"

    const-class v5, Ljava/lang/String;

    invoke-static {p1, v4, v5}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 202
    const/4 v2, 0x1

    .line 208
    :cond_1
    if-nez v2, :cond_2

    .line 209
    invoke-static {p0}, Lcom/amazon/mShop/util/AttributionUtils;->getAssociatesTag(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 210
    .local v0, "associateTag":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 211
    const-string/jumbo v4, "tag"

    invoke-virtual {v1, v4, v0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 215
    .end local v0    # "associateTag":Ljava/lang/String;
    :cond_2
    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    .line 216
    sget-boolean v4, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v4, :cond_3

    .line 217
    const-string/jumbo v4, "ActivityUtils"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "html gateway URL:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 220
    :cond_3
    return-object v3
.end method

.method public static getSSONonAuthForceSignInOption()Ljava/lang/String;
    .locals 3

    .prologue
    .line 1808
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 1809
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v2, "switchSSONonAuthForceSignIn"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1810
    .local v1, "option":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string/jumbo v1, "Weblab"

    .end local v1    # "option":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method public static getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p2, "extraFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/Class",
            "<*>;I)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 159
    .local p1, "activityClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v0, 0x1

    invoke-static {p0, p1, v0, p2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;ZI)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;ZI)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p2, "isReorderToFront"    # Z
    .param p3, "extraFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/Class",
            "<*>;ZI)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 162
    .local p1, "activityClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 163
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "intentActionStartActivity"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 164
    if-eqz p2, :cond_0

    .line 165
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 167
    :cond_0
    const/4 v1, -0x1

    if-eq p3, v1, :cond_1

    .line 168
    invoke-virtual {v0, p3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 170
    :cond_1
    return-object v0
.end method

.method private static getStartDealsActivityIntent(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;Ljava/util/Map;Z)Landroid/content/Intent;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "goldboxParams"    # Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;
    .param p2, "clickStreamOrigin"    # Ljava/lang/String;
    .param p4, "isReorderToFront"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;Z)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 1392
    .local p3, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p0, p1, p2, p3}, Lcom/amazon/mShop/util/ActivityUtils;->getWebDealsURL(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v1

    .line 1393
    .local v1, "url":Ljava/lang/String;
    const-class v2, Lcom/amazon/mShop/goldbox/WebGoldboxActivity;

    const/4 v3, -0x1

    invoke-static {p0, v2, v1, p4, v3}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v0

    .line 1394
    .local v0, "intent":Landroid/content/Intent;
    return-object v0
.end method

.method public static getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "extraFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            "I)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 174
    .local p1, "activityClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v0, 0x1

    invoke-static {p0, p1, p2, v0, p3}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;ZI)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "isReorderToFront"    # Z
    .param p4, "extraFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            "ZI)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 178
    .local p1, "activityClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {p0, p1, p3, p4}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;ZI)Landroid/content/Intent;

    move-result-object v0

    .line 179
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 180
    return-object v0
.end method

.method public static getStartWebNotificationActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/util/Map;Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;I)Landroid/content/Intent;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p3, "target"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .param p4, "extraFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;",
            "I)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 958
    .local p1, "activityClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v4

    const-string/jumbo v5, "CURRENT_HTML_NOTIFICATIONS_SETTING_DEBUG_URL"

    invoke-interface {v4, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 960
    .local v3, "url":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 962
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->html_notifications_settings_web_page_url:I

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 966
    :cond_0
    const-string/jumbo v2, ""

    .line 967
    .local v2, "tokenType":Ljava/lang/String;
    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getType()I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 984
    :goto_0
    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 986
    .local v0, "builder":Landroid/net/Uri$Builder;
    const-string/jumbo v4, "d"

    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getDestination()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v4

    const-string/jumbo v5, "a"

    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getApplicationId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v4

    const-string/jumbo v5, "t"

    invoke-virtual {v4, v5, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 990
    invoke-static {v0, p2}, Lcom/amazon/mShop/util/ActivityUtils;->appendParamsToURL(Landroid/net/Uri$Builder;Ljava/util/Map;)V

    .line 991
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    .line 992
    sget-boolean v4, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v4, :cond_1

    .line 993
    const-string/jumbo v4, "ActivityUtils"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "html Notifications URL:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 996
    :cond_1
    const-class v4, Lcom/amazon/mShop/pushnotification/WebNotificationsSettingsActivity;

    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->shouldReorderActivity(Landroid/content/Context;)Z

    move-result v5

    const/4 v6, -0x1

    invoke-static {p0, v4, v3, v5, v6}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v1

    .line 997
    .local v1, "intent":Landroid/content/Intent;
    return-object v1

    .line 969
    .end local v0    # "builder":Landroid/net/Uri$Builder;
    .end local v1    # "intent":Landroid/content/Intent;
    :pswitch_0
    const-string/jumbo v2, "APNS"

    .line 970
    goto :goto_0

    .line 972
    :pswitch_1
    const-string/jumbo v2, "ADM"

    .line 973
    goto :goto_0

    .line 975
    :pswitch_2
    const-string/jumbo v2, "GCM"

    .line 976
    goto :goto_0

    .line 978
    :pswitch_3
    const-string/jumbo v2, "GETUI"

    .line 979
    goto :goto_0

    .line 967
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
        :pswitch_3
    .end packed-switch
.end method

.method public static getStartWishListActivityIntent(Landroid/content/Context;Ljava/util/Map;I)Landroid/content/Intent;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p2, "extraFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;I)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 442
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    const-string/jumbo v4, "currentWishlistUrl"

    invoke-interface {v3, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 443
    .local v2, "url":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 444
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->wishlist_web_page_url:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 447
    :cond_0
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 451
    .local v0, "builder":Landroid/net/Uri$Builder;
    invoke-static {v0, p1}, Lcom/amazon/mShop/util/ActivityUtils;->appendAssociateTagParameter(Landroid/net/Uri$Builder;Ljava/util/Map;)V

    .line 453
    invoke-static {v0, p1}, Lcom/amazon/mShop/util/ActivityUtils;->appendParamsToURL(Landroid/net/Uri$Builder;Ljava/util/Map;)V

    .line 455
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    .line 456
    sget-boolean v3, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v3, :cond_1

    .line 457
    const-string/jumbo v3, "ActivityUtils"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "html wishlist URL:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 460
    :cond_1
    const-class v3, Lcom/amazon/mShop/wishlist/web/WebWishListActivity;

    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->shouldReorderActivity(Landroid/content/Context;)Z

    move-result v4

    invoke-static {p0, v3, v2, v4, p2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v1

    .line 462
    .local v1, "intent":Landroid/content/Intent;
    return-object v1
.end method

.method public static getStartYourAccountActivity(Landroid/content/Context;Ljava/util/Map;)Landroid/content/Intent;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 471
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 473
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    const-string/jumbo v4, "currentYourAccountUrl"

    invoke-interface {v3, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 474
    .local v2, "url":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 475
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->your_account_web_page_url:I

    invoke-virtual {p0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 478
    :cond_0
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 479
    .local v0, "builder":Landroid/net/Uri$Builder;
    invoke-static {v0, p1}, Lcom/amazon/mShop/util/ActivityUtils;->appendParamsToURL(Landroid/net/Uri$Builder;Ljava/util/Map;)V

    .line 480
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    .line 481
    sget-boolean v3, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v3, :cond_1

    .line 482
    const-string/jumbo v3, "ActivityUtils"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "html Your Account URL:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 485
    :cond_1
    const-class v3, Lcom/amazon/mShop/youraccount/web/WebYourAccountActivity;

    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->shouldReorderActivity(Landroid/content/Context;)Z

    move-result v4

    const/4 v5, -0x1

    invoke-static {p0, v3, v2, v4, v5}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v1

    .line 486
    return-object v1
.end method

.method private static getWebDealsURL(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "parameters"    # Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;
    .param p2, "clickStreamOrigin"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 1416
    .local p3, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v4

    const-string/jumbo v5, "currentDealsUrl"

    invoke-interface {v4, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1417
    .local v0, "baseUrl":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1418
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->deals_web_page_url:I

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1421
    :cond_0
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->goldbox:I

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 1423
    .local v3, "title":Ljava/lang/String;
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    .line 1426
    .local v1, "builder":Landroid/net/Uri$Builder;
    if-eqz p1, :cond_1

    const-string/jumbo v4, "LD"

    invoke-virtual {p1}, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;->getDealType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1427
    const-string/jumbo v4, "lightning-deals"

    invoke-virtual {v1, v4}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1428
    invoke-virtual {p1}, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;->getCategory()Ljava/lang/String;

    move-result-object v2

    .line 1429
    .local v2, "category":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_6

    .line 1433
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1435
    invoke-virtual {p1}, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;->getTitle()Ljava/lang/String;

    move-result-object v3

    .line 1443
    .end local v2    # "category":Ljava/lang/String;
    :cond_1
    :goto_0
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 1444
    const-string/jumbo v4, "app-title"

    invoke-virtual {v1, v4, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1448
    :cond_2
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isMarketplaceSupportsNotification()Z

    move-result v4

    if-eqz v4, :cond_3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->config_hasNotificationForDeals:I

    invoke-static {v4}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 1451
    const-string/jumbo v4, "isSupportNotification"

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1455
    :cond_3
    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 1456
    const-string/jumbo v4, "clickstream-tag"

    invoke-virtual {v1, v4, p2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1460
    :cond_4
    invoke-static {v1, p3}, Lcom/amazon/mShop/util/ActivityUtils;->appendParamsToURL(Landroid/net/Uri$Builder;Ljava/util/Map;)V

    .line 1462
    sget-boolean v4, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v4, :cond_5

    .line 1463
    const-string/jumbo v4, "ActivityUtils"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "html deals URL:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v6

    invoke-virtual {v6}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 1466
    :cond_5
    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 1438
    .restart local v2    # "category":Ljava/lang/String;
    :cond_6
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->dp_deal_row_title:I

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public static goToUdp(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;Ljava/util/Map;I)Z
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p3, "extraFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/amazon/mShop/control/item/ProductController;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;I)Z"
        }
    .end annotation

    .prologue
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v7, 0x0

    .line 1156
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v0

    .line 1157
    .local v0, "asin":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getClickStreamTag()Lcom/amazon/mShop/control/item/ClickStreamTag;

    move-result-object v1

    .line 1158
    .local v1, "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    const-string/jumbo v5, "ref"

    const-class v6, Ljava/lang/String;

    invoke-static {p2, v5, v6}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 1161
    .local v3, "refmarker":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->isMobileApp()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-static {}, Lcom/amazon/mShop/appstore/AppstoreUtils;->isAppstoreAvailable()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 1162
    invoke-static {p0, v0, v3, v7, v7}, Lcom/amazon/mShop/util/ActivityUtils;->startAppstoreActivityWithAsin(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1163
    const/4 v5, 0x1

    .line 1177
    :goto_0
    return v5

    .line 1165
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v5

    const-string/jumbo v6, "currentUdpUrl"

    invoke-interface {v5, v6}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 1166
    .local v4, "url":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 1168
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->product_details_web_page_url:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 1172
    :cond_1
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, p1, p2}, Lcom/amazon/mShop/util/ActivityUtils;->getFullUdpUrl(Ljava/lang/String;Lcom/amazon/mShop/control/item/ProductController;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v2

    .line 1173
    .local v2, "fullUrl":Ljava/lang/String;
    sget-boolean v5, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v5, :cond_2

    .line 1174
    const-string/jumbo v5, "ActivityUtils"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "html Product Detail Page URL:"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 1177
    :cond_2
    invoke-static {p0, v2, v1, p3}, Lcom/amazon/mShop/util/ActivityUtils;->goToUdp(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;I)Z

    move-result v5

    goto :goto_0
.end method

.method public static goToUdp(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;I)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "fullUdpUrl"    # Ljava/lang/String;
    .param p2, "clickStreamTag"    # Lcom/amazon/mShop/control/item/ClickStreamTag;
    .param p3, "extraFlag"    # I

    .prologue
    .line 1189
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/details/web/WebProductDetailsActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1190
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "intentActionStartActivity"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 1191
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1192
    const-string/jumbo v1, "clickStreamOrigin"

    invoke-virtual {p2}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1193
    const/4 v1, -0x1

    if-eq p3, v1, :cond_0

    .line 1194
    invoke-virtual {v0, p3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 1197
    :cond_0
    sget-boolean v1, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v1, :cond_1

    .line 1198
    const-string/jumbo v1, "ActivityUtils"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Go to UDP, url:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 1201
    :cond_1
    const-string/jumbo v1, "Launch_From_Public_Url"

    instance-of v2, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 1203
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1204
    const/4 v1, 0x1

    return v1
.end method

.method public static isAccountPhoneNumber()Z
    .locals 5

    .prologue
    .line 1827
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/Context;

    .line 1828
    .local v2, "applicationContext":Landroid/content/Context;
    sget-boolean v3, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v3, :cond_2

    .line 1829
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    const-string/jumbo v4, "accountPhoneNumber"

    invoke-interface {v3, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1830
    .local v1, "accountPhoneNumberOption":Ljava/lang/String;
    const-string/jumbo v3, "Email"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1832
    const/4 v0, 0x0

    .line 1846
    .end local v1    # "accountPhoneNumberOption":Ljava/lang/String;
    .local v0, "accountPhoneNumber":Z
    :goto_0
    return v0

    .line 1833
    .end local v0    # "accountPhoneNumber":Z
    .restart local v1    # "accountPhoneNumberOption":Ljava/lang/String;
    :cond_0
    const-string/jumbo v3, "Email or Phone Number"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1835
    const/4 v0, 0x1

    .restart local v0    # "accountPhoneNumber":Z
    goto :goto_0

    .line 1839
    .end local v0    # "accountPhoneNumber":Z
    :cond_1
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->config_account_phone_number_support:I

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    .restart local v0    # "accountPhoneNumber":Z
    goto :goto_0

    .line 1844
    .end local v0    # "accountPhoneNumber":Z
    .end local v1    # "accountPhoneNumberOption":Ljava/lang/String;
    :cond_2
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->config_account_phone_number_support:I

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    .restart local v0    # "accountPhoneNumber":Z
    goto :goto_0
.end method

.method public static isBlockHttpEnabled()Z
    .locals 4

    .prologue
    .line 1897
    const/4 v0, 0x1

    .line 1898
    .local v0, "blockHttp":Z
    sget-boolean v2, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v2, :cond_0

    .line 1899
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "debugShouldBlockHttp"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1900
    .local v1, "switchPage":Ljava/lang/String;
    const-string/jumbo v2, "featureNative"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1902
    const/4 v0, 0x0

    .line 1906
    .end local v1    # "switchPage":Ljava/lang/String;
    :cond_0
    return v0
.end method

.method public static isDebugSettingEnabled(Ljava/lang/String;)Z
    .locals 3
    .param p0, "debugSwitch"    # Ljava/lang/String;

    .prologue
    .line 1774
    const/4 v0, 0x0

    .line 1775
    .local v0, "enabled":Z
    sget-boolean v2, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v2, :cond_1

    .line 1776
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    invoke-interface {v2, p0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1777
    .local v1, "switchPage":Ljava/lang/String;
    const-string/jumbo v2, "fatureHTML"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string/jumbo v2, "featureNative"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1779
    :cond_0
    const/4 v0, 0x1

    .line 1783
    .end local v1    # "switchPage":Ljava/lang/String;
    :cond_1
    return v0
.end method

.method public static isFlowEnabled(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1966
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasFlow:I

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1968
    const-string/jumbo v0, "Android_ShopAppFlow"

    const/4 v1, 0x1

    const-string/jumbo v2, "switchFlow"

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->isWebFeatureEnabled(Ljava/lang/String;ZLjava/lang/String;)Z

    move-result v0

    .line 1970
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isGoToWebOneClickSetting()Z
    .locals 3

    .prologue
    .line 1544
    const-string/jumbo v0, "Android_ShopAppOneClickSetting"

    const/4 v1, 0x1

    const-string/jumbo v2, "switchOneClickSetting"

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->isWebFeatureEnabled(Ljava/lang/String;ZLjava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isHTMLGatewayEnabled()Z
    .locals 3

    .prologue
    .line 1870
    const-string/jumbo v0, "Android_ShopAppHTMLGateway"

    const/4 v1, 0x1

    const-string/jumbo v2, "debugHTMLGateway"

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->isWebFeatureEnabled(Ljava/lang/String;ZLjava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isHTMLRecommendationsEnabled()Z
    .locals 3

    .prologue
    .line 1874
    const-string/jumbo v0, "Android_ShopAppHTMLRecommendations"

    const/4 v1, 0x1

    const-string/jumbo v2, "switchRecommendations"

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->isWebFeatureEnabled(Ljava/lang/String;ZLjava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isHTMLSnSEnabled()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 1883
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_hasSns:I

    invoke-static {v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "Android_Enable_Sns_CA"

    const-string/jumbo v2, "debugEnableSnSInCA"

    invoke-static {v1, v0, v2}, Lcom/amazon/mShop/util/ActivityUtils;->isWebFeatureEnabled(Ljava/lang/String;ZLjava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isHtmlGatewayWebViewHAOff()Z
    .locals 2

    .prologue
    .line 1979
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    const-string/jumbo v1, "Android_ShopAppHtmlGatewayHA"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->deviceExcludedHtmalGatewayHAOff()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isPublicURLDealsEnabled()Z
    .locals 3

    .prologue
    .line 1892
    const-string/jumbo v0, "Android_Deals"

    const/4 v1, 0x1

    const-string/jumbo v2, "switchDeals"

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->isWebFeatureEnabled(Ljava/lang/String;ZLjava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isSignInPrompt()Z
    .locals 4

    .prologue
    .line 1788
    sget-boolean v2, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v2, :cond_2

    .line 1789
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "switchSSONonAuthForceSignIn"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1790
    .local v0, "SwitchSSONonAuthSignIn":Ljava/lang/String;
    const-string/jumbo v2, "Normal"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1792
    const/4 v1, 0x0

    .line 1804
    .end local v0    # "SwitchSSONonAuthSignIn":Ljava/lang/String;
    .local v1, "signInPrompt":Z
    :goto_0
    return v1

    .line 1793
    .end local v1    # "signInPrompt":Z
    .restart local v0    # "SwitchSSONonAuthSignIn":Ljava/lang/String;
    :cond_0
    const-string/jumbo v2, "Force"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1795
    const/4 v1, 0x1

    .restart local v1    # "signInPrompt":Z
    goto :goto_0

    .line 1798
    .end local v1    # "signInPrompt":Z
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v2

    const-string/jumbo v3, "Android_ShopAppSigninPrompt"

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v1

    .restart local v1    # "signInPrompt":Z
    goto :goto_0

    .line 1802
    .end local v0    # "SwitchSSONonAuthSignIn":Ljava/lang/String;
    .end local v1    # "signInPrompt":Z
    :cond_2
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v2

    const-string/jumbo v3, "Android_ShopAppSigninPrompt"

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v1

    .restart local v1    # "signInPrompt":Z
    goto :goto_0
.end method

.method public static isSmileEnabled()Z
    .locals 3

    .prologue
    .line 1888
    const-string/jumbo v0, "Android_AmazonSmile"

    const/4 v1, 0x1

    const-string/jumbo v2, "smile"

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->isWebFeatureEnabled(Ljava/lang/String;ZLjava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isSpinnerV2Enabled()Z
    .locals 3

    .prologue
    .line 1856
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-ge v0, v1, :cond_0

    .line 1857
    const/4 v0, 0x0

    .line 1859
    :goto_0
    return v0

    :cond_0
    const-string/jumbo v0, "Android_ShopAppSpinnerHardwareAcc"

    const/4 v1, 0x1

    const-string/jumbo v2, "debugSpinnerDismissLogicSwitch"

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->isWebFeatureEnabled(Ljava/lang/String;ZLjava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method

.method private static isWebFeatureEnabled(Ljava/lang/String;ZLjava/lang/String;)Z
    .locals 4
    .param p0, "featureName"    # Ljava/lang/String;
    .param p1, "isSupportWeblabInLocale"    # Z
    .param p2, "debugSwitchKey"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    const/4 v2, 0x0

    .line 1523
    sget-boolean v3, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v3, :cond_3

    .line 1524
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    invoke-interface {v3, p2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1525
    .local v1, "switchPage":Ljava/lang/String;
    const-string/jumbo v3, "fatureHTML"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1527
    const/4 v0, 0x1

    .line 1539
    .end local v1    # "switchPage":Ljava/lang/String;
    .local v0, "goToWebPage":Z
    :goto_0
    return v0

    .line 1528
    .end local v0    # "goToWebPage":Z
    .restart local v1    # "switchPage":Ljava/lang/String;
    :cond_0
    const-string/jumbo v3, "featureNative"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1530
    const/4 v0, 0x0

    .restart local v0    # "goToWebPage":Z
    goto :goto_0

    .line 1533
    .end local v0    # "goToWebPage":Z
    :cond_1
    if-eqz p1, :cond_2

    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v3

    invoke-virtual {v3, p0}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .restart local v0    # "goToWebPage":Z
    :goto_1
    goto :goto_0

    .end local v0    # "goToWebPage":Z
    :cond_2
    move v0, v2

    goto :goto_1

    .line 1536
    .end local v1    # "switchPage":Ljava/lang/String;
    :cond_3
    if-eqz p1, :cond_4

    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v3

    invoke-virtual {v3, p0}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .restart local v0    # "goToWebPage":Z
    :goto_2
    goto :goto_0

    .end local v0    # "goToWebPage":Z
    :cond_4
    move v0, v2

    goto :goto_2
.end method

.method public static isWebNotificationsPage()Z
    .locals 3

    .prologue
    .line 1001
    const-string/jumbo v0, "Android_HTMLNotificationsPage"

    const/4 v1, 0x1

    const-string/jumbo v2, "DEBUG_SWITCH_NOTIFICATIONS_PAGE"

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->isWebFeatureEnabled(Ljava/lang/String;ZLjava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static launchDetailsPage(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;Ljava/util/Map;I)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p3, "extraFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/amazon/mShop/control/item/ProductController;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;I)Z"
        }
    .end annotation

    .prologue
    .line 1132
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-boolean v0, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 1133
    const-string/jumbo v0, "ActivityUtils"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "asin:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " clickStreamTag:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getClickStreamTag()Lcom/amazon/mShop/control/item/ClickStreamTag;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 1136
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1138
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->error_can_not_find_product:I

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;I)V

    .line 1139
    const/4 v0, 0x0

    .line 1142
    :goto_0
    return v0

    :cond_1
    invoke-static {p0, p1, p2, p3}, Lcom/amazon/mShop/util/ActivityUtils;->goToUdp(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;Ljava/util/Map;I)Z

    move-result v0

    goto :goto_0
.end method

.method public static varargs launchDetailsPage(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;[I)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p2, "flag"    # [I

    .prologue
    .line 1116
    array-length v1, p2

    if-lez v1, :cond_0

    const/4 v1, 0x0

    aget v0, p2, v1

    .line 1117
    .local v0, "additionalFlag":I
    :goto_0
    const/4 v1, 0x0

    invoke-static {p0, p1, v1, v0}, Lcom/amazon/mShop/util/ActivityUtils;->launchDetailsPage(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;Ljava/util/Map;I)Z

    move-result v1

    return v1

    .line 1116
    .end local v0    # "additionalFlag":I
    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public static logViewHistory(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 1362
    :try_start_0
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 1363
    .local v1, "values":Landroid/content/ContentValues;
    const-string/jumbo v2, "asin"

    invoke-virtual {v1, v2, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1364
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/history/HistoryContentProvider;->PRODUCT_URI:Landroid/net/Uri;

    invoke-virtual {v2, v3, v1}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    .line 1375
    .end local v1    # "values":Landroid/content/ContentValues;
    :goto_0
    return-void

    .line 1365
    :catch_0
    move-exception v0

    .line 1366
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    const-string/jumbo v2, "ActivityUtils"

    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 1367
    .end local v0    # "e":Lcom/amazon/mShop/util/DBException;
    :catch_1
    move-exception v0

    .line 1372
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    invoke-static {v0}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->logMetric(Ljava/lang/Exception;)V

    .line 1373
    const-string/jumbo v2, "ActivityUtils"

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static logWeblabTrigger(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "featureName"    # Ljava/lang/String;
    .param p1, "debugSwitch"    # Ljava/lang/String;

    .prologue
    .line 1763
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->isDebugSettingEnabled(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1764
    invoke-static {p0}, Lcom/amazon/mShop/feature/WeblabCsmUtils;->postFeatureTrigger(Ljava/lang/String;)V

    .line 1766
    :cond_0
    return-void
.end method

.method public static notifyUserSignedin()V
    .locals 1

    .prologue
    .line 1863
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1864
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->userSignedIn(Lcom/amazon/mShop/model/auth/User;)V

    .line 1867
    :cond_0
    return-void
.end method

.method public static postSignInPromptFeatureTrigger()V
    .locals 2

    .prologue
    .line 1814
    sget-boolean v1, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v1, :cond_1

    .line 1815
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->getSSONonAuthForceSignInOption()Ljava/lang/String;

    move-result-object v0

    .line 1816
    .local v0, "ssoFeatureOption":Ljava/lang/String;
    const-string/jumbo v1, "Normal"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "Force"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1823
    :cond_0
    :goto_0
    return-void

    .line 1822
    :cond_1
    const-string/jumbo v1, "Android_ShopAppSigninPrompt"

    invoke-static {v1}, Lcom/amazon/mShop/feature/WeblabCsmUtils;->postFeatureTrigger(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static reloadHomeActivity(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 1913
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 1914
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    .line 1915
    return-void
.end method

.method private static removeParam(Ljava/util/Map;Ljava/lang/String;)V
    .locals 1
    .param p1, "paramName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1352
    .local p0, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p0, :cond_0

    invoke-interface {p0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1353
    invoke-interface {p0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1355
    :cond_0
    return-void
.end method

.method public static shouldBrowseRedirect(Landroid/content/Context;Landroid/net/Uri;)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 883
    const-string/jumbo v3, "node"

    invoke-virtual {p1, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 884
    .local v0, "node":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isAIVAvailable()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-static {v0}, Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;->shouldLaunchAIVBrowse(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 886
    sget-object v3, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v4, "url"

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_url:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "forceClearHistory"

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v4, v5, v6, v2}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    invoke-static {p0, v3, v2}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    .line 896
    :goto_0
    return v1

    .line 891
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/appstore/AppstoreUtils;->isAppstoreAvailable()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-static {v0}, Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;->shouldLaunchAppStoreBrowse(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 893
    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_gateway:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-virtual {v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;->name()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startAppstoreActivity(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move v1, v2

    .line 896
    goto :goto_0
.end method

.method public static shouldReorderActivity(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 382
    instance-of v0, p0, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static startAIVGatewayActivity(Landroid/content/Context;Ljava/lang/String;I)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "refmarker"    # Ljava/lang/String;
    .param p2, "extraFlag"    # I

    .prologue
    .line 2026
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->getAIVGatewayUrl(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 2027
    .local v0, "url":Ljava/lang/String;
    invoke-static {p0, p1, p2, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startAIVGatewayActivity(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)Z

    move-result v1

    return v1
.end method

.method public static startAIVGatewayActivity(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)Z
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "refmarker"    # Ljava/lang/String;
    .param p2, "extraFlag"    # I
    .param p3, "url"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 2038
    if-nez p0, :cond_1

    .line 2053
    :cond_0
    :goto_0
    return v3

    .line 2041
    :cond_1
    invoke-static {p3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_url:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 2042
    .local v0, "aivGatewayUrl":Ljava/lang/String;
    :goto_1
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    .line 2043
    .local v1, "builder":Landroid/net/Uri$Builder;
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 2044
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "ref="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 2046
    :cond_2
    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object p3

    .line 2047
    const-class v4, Lcom/amazon/mShop/aiv/AIVGatewayActivity;

    invoke-static {p0, v4, v0, p2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v2

    .line 2048
    .local v2, "intent":Landroid/content/Intent;
    if-eqz v2, :cond_0

    .line 2051
    invoke-virtual {p0, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 2053
    const/4 v3, 0x1

    goto :goto_0

    .end local v0    # "aivGatewayUrl":Ljava/lang/String;
    .end local v1    # "builder":Landroid/net/Uri$Builder;
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_3
    move-object v0, p3

    .line 2041
    goto :goto_1
.end method

.method public static startAIVSettingsActivity(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1605
    const-class v0, Lcom/amazon/mShop/aiv/AIVSettingsActivity;

    const/4 v1, -0x1

    invoke-static {p0, v0, v1}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1606
    const/4 v0, 0x1

    return v0
.end method

.method public static startAIVWebActivity(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "forceClearHistory"    # Z

    .prologue
    .line 2004
    const-class v1, Lcom/amazon/mShop/aiv/AIVMShopWebActivity;

    const/4 v2, -0x1

    invoke-static {p0, v1, p1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    .line 2005
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "ForceClearHistory"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 2006
    const-string/jumbo v1, "CallingClassName"

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2007
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 2008
    return-void
.end method

.method public static startAboutActivity(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 685
    const-class v1, Lcom/amazon/mShop/about/MShopAboutActivity;

    const/4 v2, -0x1

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v0

    .line 686
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 687
    const/4 v1, 0x1

    return v1
.end method

.method public static startAdsWebActivity(Landroid/content/Context;Landroid/net/Uri;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 1027
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/amazon/mShop/mobileads/AdsWebActivity;

    invoke-direct {v0, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1028
    .local v0, "intent":Landroid/content/Intent;
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/Uri;->isHierarchical()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1029
    const-string/jumbo v2, "url"

    invoke-virtual {p1, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1030
    .local v1, "url":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1032
    .end local v1    # "url":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1033
    const/4 v2, 0x1

    return v2
.end method

.method public static startAdsWebActivity(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 1044
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1045
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/mobileads/AdsWebActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1046
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1047
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1049
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    const/4 v1, 0x1

    return v1
.end method

.method public static startAppstoreActivity(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "target"    # Ljava/lang/String;

    .prologue
    .line 1627
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startAppstoreActivity(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 1628
    return-void
.end method

.method public static startAppstoreActivity(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "target"    # Ljava/lang/String;
    .param p2, "leftNavClick"    # Z

    .prologue
    .line 1637
    invoke-static {p1, p2}, Lcom/amazon/venezia/mShop/AppstoreNavigation;->createIntentForTarget(Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v0

    .line 1638
    .local v0, "intent":Landroid/content/Intent;
    const-class v1, Lcom/amazon/mShop/appstore/AppstoreActivity;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 1639
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1640
    return-void
.end method

.method public static startAppstoreActivityToBuyCoins(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 1693
    invoke-static {p1}, Lcom/amazon/venezia/mShop/AppstoreNavigation;->createIntentToBuyCoins(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 1694
    .local v0, "intent":Landroid/content/Intent;
    const-class v1, Lcom/amazon/mShop/appstore/AppstoreActivity;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 1695
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1696
    return-void
.end method

.method public static startAppstoreActivityWithAsin(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "ref"    # Ljava/lang/String;
    .param p3, "qid"    # Ljava/lang/String;
    .param p4, "sr"    # Ljava/lang/String;

    .prologue
    .line 1682
    invoke-static {p1, p2, p3, p4}, Lcom/amazon/venezia/mShop/AppstoreNavigation;->createIntentForAsin(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 1683
    .local v0, "intent":Landroid/content/Intent;
    const-class v1, Lcom/amazon/mShop/appstore/AppstoreActivity;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 1684
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1685
    return-void
.end method

.method public static startAppstoreActivityWithAsinAndFlag(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "ref"    # Ljava/lang/String;
    .param p3, "qid"    # Ljava/lang/String;
    .param p4, "sr"    # Ljava/lang/String;
    .param p5, "flag"    # I

    .prologue
    .line 1660
    invoke-static {p1, p2, p3, p4}, Lcom/amazon/venezia/mShop/AppstoreNavigation;->createIntentForAsin(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 1661
    .local v0, "intent":Landroid/content/Intent;
    const-class v1, Lcom/amazon/mShop/appstore/AppstoreActivity;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 1662
    invoke-virtual {v0, p5}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 1663
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1664
    return-void
.end method

.method public static startBackupYourPhotosActivity(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1070
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1071
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1072
    const/4 v1, 0x1

    return v1
.end method

.method public static startBarcodeActivity(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V
    .locals 2
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "refmarker"    # Ljava/lang/String;

    .prologue
    .line 1936
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1937
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 1938
    const/4 v1, 0x4

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1940
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1941
    invoke-static {p1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 1943
    :cond_0
    return-void
.end method

.method public static startCartActivity(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 386
    const/4 v0, 0x0

    const/4 v1, -0x1

    invoke-static {p0, v0, v1}, Lcom/amazon/mShop/util/ActivityUtils;->startCartActivity(Landroid/content/Context;Ljava/util/Map;I)Z

    move-result v0

    return v0
.end method

.method public static startCartActivity(Landroid/content/Context;Ljava/util/Map;I)Z
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p2, "extraFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;I)Z"
        }
    .end annotation

    .prologue
    .line 354
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p0, :cond_0

    .line 355
    const/4 v3, 0x0

    .line 375
    :goto_0
    return v3

    .line 358
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    const-string/jumbo v4, "currentCart"

    invoke-interface {v3, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 359
    .local v2, "url":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 360
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->web_cart_page:I

    invoke-virtual {p0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 362
    :cond_1
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 363
    .local v0, "builder":Landroid/net/Uri$Builder;
    invoke-static {v0, p1}, Lcom/amazon/mShop/util/ActivityUtils;->appendParamsToURL(Landroid/net/Uri$Builder;Ljava/util/Map;)V

    .line 364
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    .line 365
    sget-boolean v3, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v3, :cond_2

    .line 366
    const-string/jumbo v3, "ActivityUtils"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "HTML Cart URL:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 369
    :cond_2
    const-class v3, Lcom/amazon/mShop/cart/web/WebCartActivity;

    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->shouldReorderActivity(Landroid/content/Context;)Z

    move-result v4

    invoke-static {p0, v3, v2, v4, p2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v1

    .line 371
    .local v1, "intent":Landroid/content/Intent;
    if-eqz v1, :cond_3

    .line 372
    const-string/jumbo v3, "Launch_From_Public_Url"

    instance-of v4, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 374
    :cond_3
    invoke-virtual {p0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 375
    const/4 v3, 0x1

    goto :goto_0
.end method

.method public static startCategoryBrowseActivity(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 847
    const-string/jumbo v0, "/s/browse?node=aps"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startCategoryBrowseActivity(Landroid/content/Context;Landroid/net/Uri;)Z

    move-result v0

    return v0
.end method

.method public static startCategoryBrowseActivity(Landroid/content/Context;Landroid/net/Uri;)Z
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    const/4 v6, -0x1

    .line 857
    invoke-static {p1}, Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;->buildCategoryBrowseLink(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v2

    .line 860
    .local v2, "link":Ljava/lang/String;
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-static {p0, v4}, Lcom/amazon/mShop/util/ActivityUtils;->shouldBrowseRedirect(Landroid/content/Context;Landroid/net/Uri;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 873
    :goto_0
    return v8

    .line 865
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v4

    const-string/jumbo v5, "SX_mShop_Android_Fast_Browse"

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/feature/Features;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 866
    .local v3, "state":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v4

    const-string/jumbo v5, "SX_mShop_Android_Fast_Browse"

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v1

    .line 867
    .local v1, "isFastBrowseEnabled":Z
    if-eqz v1, :cond_1

    .line 868
    const-class v4, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    invoke-static {p0, v4, v2, v7, v6}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v0

    .line 872
    .local v0, "intent":Landroid/content/Intent;
    :goto_1
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 870
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_1
    const-class v4, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;

    invoke-static {p0, v4, v2, v7, v6}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v0

    .restart local v0    # "intent":Landroid/content/Intent;
    goto :goto_1
.end method

.method public static startContactUsActivity(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1554
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "currentContactUsUrl"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1555
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1556
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->contact_us_web_page_url:I

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 1558
    :cond_0
    const-class v2, Lcom/amazon/mShop/help/web/WebContactUsActivity;

    const/4 v3, -0x1

    invoke-static {p0, v2, v1, v3}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    .line 1559
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1561
    const/4 v2, 0x1

    return v2
.end method

.method public static startDealsActivity(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "parameters"    # Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;
    .param p2, "clickStreamOrigin"    # Ljava/lang/String;

    .prologue
    .line 657
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-static {p0, p1, p2, v0, v1}, Lcom/amazon/mShop/util/ActivityUtils;->startDealsActivity(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;Ljava/util/Map;Z)Z

    move-result v0

    return v0
.end method

.method public static startDealsActivity(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;Ljava/util/Map;Z)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "goldboxParams"    # Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;
    .param p2, "clickStreamOrigin"    # Ljava/lang/String;
    .param p4, "isReorderToFront"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;Z)Z"
        }
    .end annotation

    .prologue
    .line 673
    .local p3, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/util/ActivityUtils;->getStartDealsActivityIntent(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;Ljava/util/Map;Z)Landroid/content/Intent;

    move-result-object v0

    .line 675
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 676
    const/4 v1, 0x1

    return v1
.end method

.method public static startFlowActivity(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "clickStreamOrigin"    # Ljava/lang/String;
    .param p2, "refmarker"    # Ljava/lang/String;

    .prologue
    .line 1949
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1950
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 1951
    const-string/jumbo v1, "MODULE_TYPE_IS_IMAGE_SEARCH"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 1952
    const-string/jumbo v1, "clickStreamOrigin"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1953
    const/16 v1, 0x12

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1955
    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1956
    invoke-static {p2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 1958
    :cond_0
    return-void
.end method

.method public static startHelpActivity(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 697
    const-class v1, Lcom/amazon/mShop/help/HelpActivity;

    const/4 v2, -0x1

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v0

    .line 698
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 699
    const/4 v1, 0x1

    return v1
.end method

.method public static startHelpActivityWithAIVHelpPage(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1615
    const-class v1, Lcom/amazon/mShop/help/HelpActivity;

    const/4 v2, -0x1

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v0

    .line 1616
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "source"

    const-string/jumbo v2, "aiv_help"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1617
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1618
    const/4 v1, 0x1

    return v1
.end method

.method public static startHomeActivity(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 295
    const/4 v0, 0x0

    const/4 v1, -0x1

    const/4 v2, 0x0

    invoke-static {p0, v0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;Ljava/util/Map;IZ)Z

    move-result v0

    return v0
.end method

.method public static startHomeActivity(Landroid/content/Context;Ljava/util/Map;IZ)Z
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p2, "extraFlag"    # I
    .param p3, "launchInNewTask"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;IZ)Z"
        }
    .end annotation

    .prologue
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 240
    invoke-static {}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->getInstance()Lcom/amazon/mShop/home/GatewayWeblabUtil;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->updateGatewayWeblabState()Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    move-result-object v0

    .line 241
    .local v0, "featureStateChangeType":Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;
    const-string/jumbo v4, "ref"

    const-class v5, Ljava/lang/String;

    invoke-static {p1, v4, v5}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 247
    .local v2, "refmarker":Ljava/lang/String;
    sget-object v4, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->TREATMENT_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    if-ne v4, v0, :cond_0

    instance-of v4, p0, Lcom/amazon/mShop/splashscreen/StartupActivity;

    if-nez v4, :cond_0

    .line 248
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->restartApp()V

    .line 292
    :goto_0
    return v7

    .line 253
    :cond_0
    const/4 v1, 0x0

    .line 254
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isHTMLGatewayEnabled()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 255
    invoke-static {p0, p1}, Lcom/amazon/mShop/util/ActivityUtils;->getHTMLGatewayUrl(Landroid/content/Context;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    .line 257
    .local v3, "url":Ljava/lang/String;
    const-class v4, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->shouldReorderActivity(Landroid/content/Context;)Z

    move-result v5

    invoke-static {p0, v4, v3, v5, p2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v1

    .line 264
    .end local v3    # "url":Ljava/lang/String;
    :goto_1
    const/high16 v4, 0x4000000

    invoke-virtual {v1, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 266
    if-eqz p3, :cond_1

    .line 271
    const/high16 v4, 0x10000000

    invoke-virtual {v1, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 272
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0xb

    if-lt v4, v5, :cond_1

    .line 273
    const v4, 0x8000

    invoke-virtual {v1, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 277
    :cond_1
    instance-of v4, p0, Lcom/amazon/mShop/home/GatewayActivity;

    if-eqz v4, :cond_2

    .line 278
    const-string/jumbo v4, "newIntentOrigin"

    const-string/jumbo v5, "home"

    invoke-virtual {v1, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 281
    :cond_2
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 285
    const-string/jumbo v4, "home_v38"

    invoke-static {v4, v2}, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;->logServiceMethodNameAndRefmarker(Ljava/lang/String;Ljava/lang/String;)Z

    .line 290
    :cond_3
    invoke-static {}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->getInstance()Lcom/amazon/mShop/home/GatewayWeblabUtil;

    move-result-object v4

    invoke-virtual {v4, v6}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->postGatewayFeatureTrigger(Z)V

    .line 291
    invoke-virtual {p0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 259
    :cond_4
    const-class v4, Lcom/amazon/mShop/home/GatewayActivity;

    invoke-static {p0, v4, v6, p2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;ZI)Landroid/content/Intent;

    move-result-object v1

    .line 261
    const-string/jumbo v4, "home_v38"

    invoke-static {v4, v2}, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;->logServiceMethodNameAndRefmarker(Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_1
.end method

.method public static varargs startLocaleSwitchActivity(Landroid/content/Context;[I)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "flag"    # [I

    .prologue
    .line 835
    array-length v2, p1

    if-lez v2, :cond_0

    const/4 v2, 0x0

    aget v0, p1, v2

    .line 836
    .local v0, "additionalFlag":I
    :goto_0
    const-class v2, Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity;

    invoke-static {p0, v2, v0}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v1

    .line 837
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 838
    const/4 v2, 0x1

    return v2

    .line 835
    .end local v0    # "additionalFlag":I
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public static startLocaleSwitchActivityWhenNecessary(Landroid/app/Activity;Ljava/lang/String;)Z
    .locals 6
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "startupTaskId"    # Ljava/lang/String;

    .prologue
    .line 1474
    const/4 v2, 0x0

    .line 1475
    .local v2, "startedLocaleSwitchActivity":Z
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    .line 1476
    .local v3, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v4, "needToSelectLocale"

    invoke-interface {v3, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1477
    const-string/jumbo v4, "needToSelectLocale"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 1481
    sget v4, Lcom/amazon/mShop/android/lib/R$raw;->default_locale:I

    invoke-static {p0, v4}, Lcom/amazon/mShop/util/AttributionUtils;->readStringFromRawResourceFile(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 1482
    .local v0, "defaultLocaleName":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/LocaleUtils;->setCurrentAppLocale(Ljava/lang/String;)V

    .line 1486
    new-instance v1, Landroid/content/Intent;

    const-class v4, Lcom/amazon/mShop/startup/StartupSetCountryActivity;

    invoke-direct {v1, p0, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1491
    .local v1, "intent":Landroid/content/Intent;
    instance-of v4, p0, Landroid/app/Activity;

    if-nez v4, :cond_0

    .line 1492
    const/high16 v4, 0x10000000

    invoke-virtual {v1, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 1494
    :cond_0
    invoke-static {p0, v1, p1}, Lcom/amazon/mShop/splashscreen/StartupActivity;->startActivityForStartup(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V

    .line 1495
    const/4 v2, 0x1

    .line 1497
    .end local v0    # "defaultLocaleName":Ljava/lang/String;
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_1
    return v2
.end method

.method public static varargs startLoginActivity(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;[I)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "origin"    # Ljava/lang/String;
    .param p2, "userInitiatedLogin"    # Z
    .param p3, "refMarker"    # Ljava/lang/String;
    .param p4, "flag"    # [I

    .prologue
    .line 725
    array-length v2, p4

    if-lez v2, :cond_0

    const/4 v2, 0x0

    aget v0, p4, v2

    .line 727
    .local v0, "additionalFlag":I
    :goto_0
    const-class v2, Lcom/amazon/mShop/account/LoginActivity;

    invoke-static {p0, v2, v0}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v1

    .line 730
    .local v1, "intent":Landroid/content/Intent;
    const-string/jumbo v2, "USER_INITIATED_LOGIN"

    invoke-virtual {v1, v2, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 731
    const-string/jumbo v2, "LOGIN_ORIGIN_KEY"

    invoke-virtual {v1, v2, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 732
    const-string/jumbo v2, "REFMARKER"

    invoke-virtual {v1, v2, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 733
    invoke-virtual {p0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 734
    const/4 v2, 0x1

    return v2

    .line 725
    .end local v0    # "additionalFlag":I
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public static startLoginActivityForResult(Landroid/content/Context;ILjava/lang/String;ZZZLjava/lang/String;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "requestCode"    # I
    .param p2, "origin"    # Ljava/lang/String;
    .param p3, "initialLogin"    # Z
    .param p4, "forceSign"    # Z
    .param p5, "isCreateNewAccount"    # Z
    .param p6, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 752
    const-class v1, Lcom/amazon/mShop/account/LoginActivity;

    const/4 v2, -0x1

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v0

    .line 755
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "LOGIN_ORIGIN_KEY"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 756
    const-string/jumbo v1, "USER_INITIATED_LOGIN"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 757
    const-string/jumbo v1, "FORCE_SIGN_IN"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 758
    const-string/jumbo v1, "IS_CREATE_NEW_ACCOUNT"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 759
    const-string/jumbo v1, "REFMARKER"

    invoke-virtual {v0, v1, p6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 760
    check-cast p0, Landroid/app/Activity;

    .end local p0    # "context":Landroid/content/Context;
    invoke-virtual {p0, v0, p1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 761
    const/4 v1, 0x1

    return v1
.end method

.method public static startLogoutActivity(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 770
    const-class v1, Lcom/amazon/mShop/account/LogoutActivity;

    const/4 v2, -0x1

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v0

    .line 771
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 772
    const/4 v1, 0x1

    return v1
.end method

.method public static startMShopModalWebActivity(Landroid/app/Activity;Landroid/net/Uri;)Z
    .locals 4
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 1011
    invoke-virtual {p1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 1012
    .local v0, "builder":Landroid/net/Uri$Builder;
    const-string/jumbo v2, "app-nav-type"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1013
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/amazon/mShop/web/MShopModalWebActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1014
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1015
    const/16 v2, 0x11

    invoke-virtual {p0, v1, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1016
    const/4 v2, 0x1

    return v2
.end method

.method public static startNotificationSettingActivity(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "category"    # Ljava/lang/String;

    .prologue
    .line 907
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startNotificationSettingActivity(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)Z

    move-result v0

    return v0
.end method

.method public static startNotificationSettingActivity(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "category"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v4, 0x1

    .line 911
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v5

    if-nez v5, :cond_0

    .line 953
    :goto_0
    return v4

    .line 917
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v1

    .line 918
    .local v1, "manager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    const/4 v5, 0x0

    invoke-virtual {v1, v5}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v3

    .line 919
    .local v3, "target":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    const-string/jumbo v5, "ref"

    const-class v6, Ljava/lang/String;

    invoke-static {p2, v5, v6}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 926
    .local v2, "refmarker":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isWebNotificationsPage()Z

    move-result v5

    if-eqz v5, :cond_1

    if-nez v3, :cond_4

    .line 929
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-class v5, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;

    invoke-direct {v0, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 930
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v5, "deal"

    invoke-virtual {v5, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 931
    const-string/jumbo v5, "DefaultExpandedGroupId"

    const-string/jumbo v6, "TD"

    invoke-virtual {v0, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 941
    :cond_2
    :goto_1
    const-string/jumbo v5, "get_notification_subscriptions_v35"

    invoke-static {v5, v2}, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;->logServiceMethodNameAndRefmarker(Ljava/lang/String;Ljava/lang/String;)Z

    .line 947
    :goto_2
    if-eqz v0, :cond_5

    .line 949
    const-string/jumbo v5, "Android_HTMLNotificationsPage"

    const-string/jumbo v6, "DEBUG_SWITCH_NOTIFICATIONS_PAGE"

    invoke-static {v5, v6}, Lcom/amazon/mShop/util/ActivityUtils;->logWeblabTrigger(Ljava/lang/String;Ljava/lang/String;)V

    .line 950
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 934
    :cond_3
    const-string/jumbo v5, "shipment"

    invoke-virtual {v5, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 935
    const-string/jumbo v5, "DefaultExpandedGroupId"

    const-string/jumbo v6, "ST"

    invoke-virtual {v0, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_1

    .line 944
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_4
    const-class v5, Lcom/amazon/mShop/pushnotification/WebNotificationsSettingsActivity;

    const/4 v6, -0x1

    invoke-static {p0, v5, p2, v3, v6}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebNotificationActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/util/Map;Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;I)Landroid/content/Intent;

    move-result-object v0

    .restart local v0    # "intent":Landroid/content/Intent;
    goto :goto_2

    .line 953
    :cond_5
    const/4 v4, 0x0

    goto :goto_0
.end method

.method public static startOneClickSettingActivity(Landroid/content/Context;I)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "extralFlag"    # I

    .prologue
    .line 533
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/youraccount/OneClickSettingsActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 534
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 535
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 536
    const/4 v1, 0x1

    return v1
.end method

.method public static startOneClickSettingActivity(Landroid/content/Context;ZZ)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "swapView"    # Z
    .param p2, "showContinueButton"    # Z

    .prologue
    .line 516
    const/4 v0, 0x0

    .line 517
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isGoToWebOneClickSetting()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 518
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "currentOneClickSettingUrl"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 519
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 520
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_web_page_url:I

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 522
    :cond_0
    const-class v2, Lcom/amazon/mShop/youraccount/web/WebOneClickSettingsActivity;

    const/4 v3, -0x1

    invoke-static {p0, v2, v1, v3}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    .line 523
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 528
    .end local v1    # "url":Ljava/lang/String;
    .end local p0    # "context":Landroid/content/Context;
    :goto_0
    const/4 v2, 0x1

    return v2

    .line 525
    .restart local p0    # "context":Landroid/content/Context;
    :cond_1
    new-instance v2, Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    check-cast p0, Lcom/amazon/mShop/AmazonActivity;

    .end local p0    # "context":Landroid/content/Context;
    invoke-direct {v2, p0, p1, p2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;-><init>(Lcom/amazon/mShop/AmazonActivity;ZZ)V

    goto :goto_0
.end method

.method public static startPrimeUpsellActivity(Landroid/content/Context;ILjava/lang/String;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "extraFlag"    # I
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 2066
    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->help_prime_instant_video_button_url:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 2068
    .local v1, "primeUpsellUrl":Ljava/lang/String;
    :goto_0
    const-class v2, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;

    invoke-static {p0, v2, v1, p1}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    .line 2069
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 2070
    return-void

    .end local v0    # "intent":Landroid/content/Intent;
    .end local v1    # "primeUpsellUrl":Ljava/lang/String;
    :cond_0
    move-object v1, p2

    .line 2066
    goto :goto_0
.end method

.method public static startPurchaseActivity(Landroid/content/Context;Lcom/amazon/mShop/opl/PurchaseParams;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "parameters"    # Lcom/amazon/mShop/opl/PurchaseParams;

    .prologue
    .line 1570
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    invoke-direct {v0, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1571
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "currentCheckOutUrl"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1572
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1573
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->web_check_out:I

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 1579
    :cond_0
    if-eqz p1, :cond_3

    invoke-virtual {p1}, Lcom/amazon/mShop/opl/PurchaseParams;->getCheckoutUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 1580
    invoke-virtual {p1}, Lcom/amazon/mShop/opl/PurchaseParams;->getCheckoutUrl()Ljava/lang/String;

    move-result-object v1

    .line 1586
    :goto_0
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1588
    if-eqz p1, :cond_1

    .line 1589
    const-string/jumbo v2, "isCartPurchase"

    invoke-virtual {p1}, Lcom/amazon/mShop/opl/PurchaseParams;->isCartPurchase()Z

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 1592
    :cond_1
    if-eqz p1, :cond_2

    .line 1593
    const-string/jumbo v3, "oneClick"

    invoke-virtual {p1}, Lcom/amazon/mShop/opl/PurchaseParams;->getOneClickShippingSpeed()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_4

    const/4 v2, 0x1

    :goto_1
    invoke-virtual {v0, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 1596
    :cond_2
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1597
    return-void

    .line 1583
    :cond_3
    const-string/jumbo v2, "postParams"

    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->getCheckOutPostParams(Lcom/amazon/mShop/opl/PurchaseParams;)[B

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[B)Landroid/content/Intent;

    goto :goto_0

    .line 1593
    :cond_4
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public static startRecentlyViewedItemsActivity(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 709
    const-class v1, Lcom/amazon/mShop/history/HistoryActivity;

    const/4 v2, -0x1

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v0

    .line 710
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 711
    const/4 v1, 0x1

    return v1
.end method

.method public static startRecommendationsActivity(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 781
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startRecommendationsActivity(Landroid/content/Context;Ljava/util/Map;)Z

    move-result v0

    return v0
.end method

.method public static startRecommendationsActivity(Landroid/content/Context;Ljava/util/Map;)Z
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v9, -0x1

    .line 791
    const/4 v3, 0x0

    .line 792
    .local v3, "intent":Landroid/content/Intent;
    const-string/jumbo v6, "ref"

    const-class v7, Ljava/lang/String;

    invoke-static {p1, v6, v7}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 793
    .local v4, "refmarker":Ljava/lang/String;
    const-string/jumbo v6, "node"

    const-class v7, Ljava/lang/String;

    invoke-static {p1, v6, v7}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 794
    .local v0, "browseNode":Ljava/lang/String;
    const-string/jumbo v6, "category_display_name"

    const-class v7, Ljava/lang/String;

    invoke-static {p1, v6, v7}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 796
    .local v2, "categoryDisplayName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isHTMLRecommendationsEnabled()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 798
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v6

    const-string/jumbo v7, "currentRecommendationsUrl"

    invoke-interface {v6, v7}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 799
    .local v5, "url":Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 800
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->html_recommendations_web_page_url:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 802
    :cond_0
    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-virtual {v6}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    .line 803
    .local v1, "builder":Landroid/net/Uri$Builder;
    invoke-static {v1, p1}, Lcom/amazon/mShop/util/ActivityUtils;->appendParamsToURL(Landroid/net/Uri$Builder;Ljava/util/Map;)V

    .line 804
    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v6

    invoke-virtual {v6}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v5

    .line 805
    sget-boolean v6, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v6, :cond_1

    .line 806
    const-string/jumbo v6, "ActivityUtils"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "html RECS URL:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 809
    :cond_1
    const-class v6, Lcom/amazon/mShop/recommendations/web/WebRecommendationsActivity;

    invoke-static {p0, v6, v5, v9}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v3

    .line 823
    .end local v1    # "builder":Landroid/net/Uri$Builder;
    .end local v5    # "url":Ljava/lang/String;
    :cond_2
    :goto_0
    const-string/jumbo v6, "Android_ShopAppHTMLRecommendations"

    const-string/jumbo v7, "switchRecommendations"

    invoke-static {v6, v7}, Lcom/amazon/mShop/util/ActivityUtils;->logWeblabTrigger(Ljava/lang/String;Ljava/lang/String;)V

    .line 824
    invoke-virtual {p0, v3}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 825
    const/4 v6, 0x1

    return v6

    .line 812
    :cond_3
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 813
    const-string/jumbo v6, "get_recommended_items_v32"

    invoke-static {v6, v4}, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;->logServiceMethodNameAndRefmarker(Ljava/lang/String;Ljava/lang/String;)Z

    .line 815
    :cond_4
    const-class v6, Lcom/amazon/mShop/recommendations/RecommendationsActivity;

    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->shouldReorderActivity(Landroid/content/Context;)Z

    move-result v7

    invoke-static {p0, v6, v7, v9}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;ZI)Landroid/content/Intent;

    move-result-object v3

    .line 816
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 817
    const-string/jumbo v6, "BROWSE_NODE"

    invoke-virtual {v3, v6, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 818
    const-string/jumbo v6, "CATEGORY_DISPLAY_NAME"

    invoke-virtual {v3, v6, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method

.method public static startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z
    .locals 10
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v5, 0x1

    const/4 v3, 0x0

    const/4 v6, 0x0

    .line 305
    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    :cond_0
    move v5, v6

    .line 340
    .end local p0    # "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    :goto_0
    return v5

    .line 311
    .restart local p0    # "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    :cond_1
    instance-of v7, p0, Lcom/amazon/mShop/search/ScopedSearch;

    if-eqz v7, :cond_5

    move-object v2, p0

    .line 312
    check-cast v2, Lcom/amazon/mShop/search/ScopedSearch;

    .line 313
    .local v2, "scopedSearch":Lcom/amazon/mShop/search/ScopedSearch;
    invoke-interface {v2}, Lcom/amazon/mShop/search/ScopedSearch;->getCategoryMetadata()Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;

    move-result-object v0

    .line 314
    .local v0, "categoryMetadata":Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;
    if-eqz v0, :cond_6

    iget-object v1, v0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->title:Ljava/lang/String;

    .line 315
    .local v1, "categoryName":Ljava/lang/String;
    :goto_1
    if-eqz v0, :cond_7

    iget-object v4, v0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->searchUrl:Ljava/lang/String;

    .line 316
    .local v4, "searchUrl":Ljava/lang/String;
    :goto_2
    if-eqz v0, :cond_2

    iget-object v3, v0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;->searchAlias:Ljava/lang/String;

    .line 317
    .local v3, "searchAlias":Ljava/lang/String;
    :cond_2
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    .line 318
    const-string/jumbo v7, "CATEGORY_NAME"

    invoke-virtual {p1, v7, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 319
    const-string/jumbo v7, "CATEGORY_URL"

    invoke-virtual {p1, v7, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 320
    const-string/jumbo v7, "CATEGORY_ALIAS"

    invoke-virtual {p1, v7, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 324
    :cond_3
    instance-of v7, v2, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    if-nez v7, :cond_4

    instance-of v7, v2, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;

    if-eqz v7, :cond_5

    .line 326
    :cond_4
    const-string/jumbo v7, "br_quit_%1$d_sr"

    new-array v8, v5, [Ljava/lang/Object;

    invoke-interface {v2}, Lcom/amazon/mShop/search/ScopedSearch;->getCurrentDepartmentDepth()I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v6

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 331
    .end local v0    # "categoryMetadata":Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;
    .end local v1    # "categoryName":Ljava/lang/String;
    .end local v2    # "scopedSearch":Lcom/amazon/mShop/search/ScopedSearch;
    .end local v3    # "searchAlias":Ljava/lang/String;
    .end local v4    # "searchUrl":Ljava/lang/String;
    :cond_5
    const-string/jumbo v7, "Launch_From_Public_Url"

    instance-of v8, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity;

    invoke-virtual {p1, v7, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 334
    instance-of v7, p0, Lcom/amazon/mShop/search/SearchActivity;

    if-eqz v7, :cond_8

    .line 336
    check-cast p0, Lcom/amazon/mShop/search/SearchActivity;

    .end local p0    # "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    invoke-virtual {p0, p1, v6}, Lcom/amazon/mShop/search/SearchActivity;->showSearchEntryView(Landroid/content/Intent;Z)V

    goto :goto_0

    .restart local v0    # "categoryMetadata":Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;
    .restart local v2    # "scopedSearch":Lcom/amazon/mShop/search/ScopedSearch;
    .restart local p0    # "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    :cond_6
    move-object v1, v3

    .line 314
    goto :goto_1

    .restart local v1    # "categoryName":Ljava/lang/String;
    :cond_7
    move-object v4, v3

    .line 315
    goto :goto_2

    .line 338
    .end local v0    # "categoryMetadata":Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;
    .end local v1    # "categoryName":Ljava/lang/String;
    .end local v2    # "scopedSearch":Lcom/amazon/mShop/search/ScopedSearch;
    :cond_8
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public static startSigninPromptActivity(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 2111
    const-class v1, Lcom/amazon/mShop/sso/SigninPromptActivity;

    const/4 v2, -0x1

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v0

    .line 2112
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 2113
    return-void
.end method

.method public static startSnapItActivity(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V
    .locals 2
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "refmarker"    # Ljava/lang/String;

    .prologue
    .line 1922
    const-string/jumbo v1, "sr_snap"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 1923
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/search/image/SnapItActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1924
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 1925
    const/16 v1, 0xa

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1927
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1928
    invoke-static {p1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 1930
    :cond_0
    return-void
.end method

.method public static startSnsDispatchActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "token"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "refmarker"    # Ljava/lang/String;

    .prologue
    .line 1089
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/amazon/mShop/sns/SnsManageYourSubscribesActivity;

    invoke-direct {v1, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1092
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->sns_dispatch_page:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1093
    .local v2, "url":Ljava/lang/String;
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 1094
    .local v0, "builder":Landroid/net/Uri$Builder;
    invoke-static {p3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 1095
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "ref="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1097
    :cond_0
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 1098
    const-string/jumbo v3, "data"

    invoke-virtual {v0, v3, p1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 1100
    :cond_1
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1102
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1103
    invoke-virtual {p0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1105
    const/4 v3, 0x1

    return v3
.end method

.method public static startSnsManageYourSubscribesActivity(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1058
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "currentSnsMys"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1059
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1060
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sns_mys_page:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 1062
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/amazon/mShop/sns/SnsManageYourSubscribesActivity;

    invoke-direct {v0, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1063
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1065
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 1066
    const/4 v2, 0x1

    return v2
.end method

.method public static startSocialConnectActivity(Landroid/app/Activity;Ljava/lang/String;)V
    .locals 9
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "startupTaskId"    # Ljava/lang/String;

    .prologue
    .line 2080
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v6

    const-string/jumbo v7, "socialConnectDebugUrl"

    invoke-interface {v6, v7}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 2081
    .local v5, "socialConnectUrl":Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 2083
    invoke-virtual {p0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->social_connect_url:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 2086
    :cond_0
    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-virtual {v6}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v2

    .line 2088
    .local v2, "builder":Landroid/net/Uri$Builder;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/Context;

    .line 2089
    .local v1, "applicationContext":Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 2091
    .local v0, "account":Ljava/lang/String;
    const-string/jumbo v6, "app"

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v6, v7}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 2093
    const-string/jumbo v6, "last_shown"

    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getInstance()Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;

    move-result-object v7

    invoke-virtual {v7, v0}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getLastShown(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v6, v7}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 2095
    const-string/jumbo v6, "times_shown"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getInstance()Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;

    move-result-object v8

    invoke-virtual {v8, v0}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getNumberTimesShown(Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v6, v7}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 2098
    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getInstance()Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;

    move-result-object v6

    invoke-virtual {v6, v0}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getDoNotShowAgain(Ljava/lang/String;)Z

    move-result v3

    .line 2099
    .local v3, "doNotShowAgain":Z
    const-string/jumbo v7, "do_not_show_again"

    if-eqz v3, :cond_1

    const-string/jumbo v6, "1"

    :goto_0
    invoke-virtual {v2, v7, v6}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 2101
    const-class v6, Lcom/amazon/mShop/social/SocialConnectActivity;

    invoke-virtual {v2}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v7

    invoke-virtual {v7}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v7

    const/4 v8, -0x1

    invoke-static {p0, v6, v7, v8}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v4

    .line 2103
    .local v4, "intent":Landroid/content/Intent;
    invoke-static {p0, v4, p1}, Lcom/amazon/mShop/splashscreen/StartupActivity;->startActivityForStartup(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V

    .line 2104
    return-void

    .line 2099
    .end local v4    # "intent":Landroid/content/Intent;
    :cond_1
    const-string/jumbo v6, "0"

    goto :goto_0
.end method

.method public static startWishListActivity(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 396
    const/4 v0, -0x1

    invoke-static {p0, v1, v1, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startWishListActivity(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;I)Z

    move-result v0

    return v0
.end method

.method public static startWishListActivity(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;I)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "clickStreamOrigin"    # Ljava/lang/String;
    .param p3, "extraFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;I)Z"
        }
    .end annotation

    .prologue
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 411
    if-nez p0, :cond_1

    .line 425
    :cond_0
    :goto_0
    return v1

    .line 415
    :cond_1
    invoke-static {p0, p2, p3}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWishListActivityIntent(Landroid/content/Context;Ljava/util/Map;I)Landroid/content/Intent;

    move-result-object v0

    .line 416
    .local v0, "intent":Landroid/content/Intent;
    if-eqz v0, :cond_0

    .line 420
    const-string/jumbo v1, "Launch_From_Public_Url"

    instance-of v2, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 422
    const-string/jumbo v1, "clickStreamOrigin"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 424
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 425
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public static startYourAccountActivity(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 495
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startYourAccountActivity(Landroid/content/Context;Ljava/util/Map;)Z

    move-result v0

    return v0
.end method

.method public static startYourAccountActivity(Landroid/content/Context;Ljava/util/Map;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 505
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p0, p1}, Lcom/amazon/mShop/util/ActivityUtils;->getStartYourAccountActivity(Landroid/content/Context;Ljava/util/Map;)Landroid/content/Intent;

    move-result-object v0

    .line 506
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 507
    const/4 v1, 0x1

    return v1
.end method

.method public static startYourOrdersActivity(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 543
    const/4 v0, -0x1

    invoke-static {p0, v1, v1, v1, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startYourOrdersActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z

    move-result v0

    return v0
.end method

.method public static startYourOrdersActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZI)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "orderId"    # Ljava/lang/String;
    .param p2, "orderActionKey"    # Ljava/lang/String;
    .param p3, "shipmentIndex"    # I
    .param p4, "refmarker"    # Ljava/lang/String;
    .param p5, "isReorderToFront"    # Z
    .param p6, "extraFlag"    # I

    .prologue
    .line 588
    sget-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->ORDER_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    invoke-static {v0, p1}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v1

    const-string/jumbo v0, "ref"

    invoke-static {v0, p4}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v4

    move-object v0, p0

    move-object v2, p2

    move v3, p3

    move v5, p5

    move v6, p6

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/ActivityUtils;->startYourOrdersActivity(Landroid/content/Context;Ljava/util/Map;Ljava/lang/String;ILjava/util/Map;ZI)Z

    move-result v0

    return v0
.end method

.method public static startYourOrdersActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "orderId"    # Ljava/lang/String;
    .param p2, "orderActionKey"    # Ljava/lang/String;
    .param p3, "refmarker"    # Ljava/lang/String;
    .param p4, "extraFlag"    # I

    .prologue
    .line 567
    const/4 v3, -0x1

    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    move v6, p4

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/ActivityUtils;->startYourOrdersActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZI)Z

    move-result v0

    return v0
.end method

.method public static startYourOrdersActivity(Landroid/content/Context;Ljava/util/Map;Ljava/lang/String;ILjava/util/Map;ZI)Z
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p2, "orderActionKey"    # Ljava/lang/String;
    .param p3, "shipmentIndex"    # I
    .param p5, "isReorderToFront"    # Z
    .param p6, "extraFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "I",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;ZI)Z"
        }
    .end annotation

    .prologue
    .local p1, "orderActionParams":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;Ljava/lang/String;>;"
    .local p4, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v7, 0x1

    .line 610
    const/4 v1, 0x0

    .line 611
    .local v1, "intent":Landroid/content/Intent;
    const/4 v3, 0x0

    .line 614
    .local v3, "url":Ljava/lang/String;
    const-string/jumbo v4, "order_to_view"

    invoke-virtual {v4, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 615
    sget-object v2, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->VIEW_ORDER:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    .line 625
    .local v2, "orderAction":Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;
    :goto_0
    :try_start_0
    invoke-virtual {v2, p0, p1, p4}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->getUrl(Landroid/content/Context;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    .line 626
    sget-boolean v4, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v4, :cond_0

    .line 627
    const-string/jumbo v4, "ActivityUtils"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "html Order URL:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 640
    :cond_0
    :goto_1
    const-class v4, Lcom/amazon/mShop/order/web/WebViewOrderActivity;

    invoke-static {p0, v4, v3, p5, p6}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v1

    .line 642
    instance-of v4, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity;

    if-eqz v4, :cond_1

    .line 643
    const-string/jumbo v4, "Launch_From_Public_Url"

    invoke-virtual {v1, v4, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 646
    :cond_1
    invoke-virtual {p0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 647
    return v7

    .line 616
    .end local v2    # "orderAction":Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;
    :cond_2
    const-string/jumbo v4, "order_to_cancel"

    invoke-virtual {v4, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 617
    sget-object v2, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->CANCEL_ORDER:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    .restart local v2    # "orderAction":Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;
    goto :goto_0

    .line 618
    .end local v2    # "orderAction":Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;
    :cond_3
    const-string/jumbo v4, "ORDER_TO_TRACK"

    invoke-virtual {v4, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 619
    sget-object v2, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->TRACK_PACKAGE:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    .restart local v2    # "orderAction":Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;
    goto :goto_0

    .line 621
    .end local v2    # "orderAction":Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;
    :cond_4
    sget-object v2, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->VIEW_ALL_ORDERS:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    .restart local v2    # "orderAction":Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;
    goto :goto_0

    .line 629
    :catch_0
    move-exception v0

    .line 630
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    const-string/jumbo v4, "ActivityUtils"

    const-string/jumbo v5, "Could not retrieve view order url"

    invoke-static {v4, v5, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 634
    sget-object v4, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->VIEW_ALL_ORDERS:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    const/4 v5, 0x0

    invoke-virtual {v4, p0, v5, p4}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->getUrl(Landroid/content/Context;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    .line 635
    sget-boolean v4, Lcom/amazon/mShop/util/ActivityUtils;->DEBUG:Z

    if-eqz v4, :cond_0

    .line 636
    const-string/jumbo v4, "ActivityUtils"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "html Order:View all orders URL:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method
