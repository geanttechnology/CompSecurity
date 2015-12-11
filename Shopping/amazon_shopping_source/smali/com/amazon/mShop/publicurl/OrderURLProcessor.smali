.class public Lcom/amazon/mShop/publicurl/OrderURLProcessor;
.super Lcom/amazon/mShop/publicurl/PublicURLProcessor;
.source "OrderURLProcessor.java"


# instance fields
.field private isSpecificOrder:Z


# direct methods
.method public constructor <init>(Landroid/net/Uri;)V
    .locals 0
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 51
    invoke-direct {p0, p1}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;-><init>(Landroid/net/Uri;)V

    .line 52
    return-void
.end method


# virtual methods
.method protected doProcess(Landroid/content/Context;)V
    .locals 14
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v6, 0x2

    const/4 v4, 0x1

    .line 56
    const/4 v1, 0x0

    .line 57
    .local v1, "orderId":Ljava/lang/String;
    const/4 v5, 0x0

    .line 58
    .local v5, "trackingNumber":Ljava/lang/String;
    const/4 v3, 0x0

    .line 59
    .local v3, "shipMethod":Ljava/lang/String;
    const/4 v13, 0x0

    .line 62
    .local v13, "action":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/OrderURLProcessor;->mPathSegments:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lt v0, v6, :cond_0

    .line 63
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/OrderURLProcessor;->mPathSegments:Ljava/util/List;

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "orderId":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 64
    .restart local v1    # "orderId":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/OrderURLProcessor;->mPathSegments:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v2, 0x3

    if-lt v0, v2, :cond_0

    .line 65
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/OrderURLProcessor;->mPathSegments:Ljava/util/List;

    invoke-interface {v0, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    .end local v13    # "action":Ljava/lang/String;
    check-cast v13, Ljava/lang/String;

    .line 66
    .restart local v13    # "action":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/OrderURLProcessor;->mUri:Landroid/net/Uri;

    const-string/jumbo v2, "tn"

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/OrderURLProcessor;->mUri:Landroid/net/Uri;

    const-string/jumbo v2, "sm"

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 73
    :cond_0
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    const-string/jumbo v0, "[0-9]{3}-[0-9]{7}-[0-9]{7}"

    invoke-virtual {v1, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 74
    iput-boolean v4, p0, Lcom/amazon/mShop/publicurl/OrderURLProcessor;->isSpecificOrder:Z

    .line 75
    const-string/jumbo v0, "track"

    invoke-virtual {v0, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 76
    const-string/jumbo v8, "ORDER_TO_TRACK"

    .line 84
    .local v8, "orderActionKey":Ljava/lang/String;
    :goto_0
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_NOTIFICATION:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/mShop/publicurl/OrderURLProcessor;->getOrigin()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 85
    const-string/jumbo v0, "pn_orders_t"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 89
    :cond_1
    sget-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->ORDER_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    sget-object v2, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->SHIP_METHOD:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    sget-object v4, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->TRACKING_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v7

    const/4 v9, -0x1

    invoke-virtual {p0}, Lcom/amazon/mShop/publicurl/OrderURLProcessor;->getParams()Ljava/util/Map;

    move-result-object v10

    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->shouldReorderActivity(Landroid/content/Context;)Z

    move-result v11

    const/high16 v12, 0x80000

    move-object v6, p1

    invoke-static/range {v6 .. v12}, Lcom/amazon/mShop/util/ActivityUtils;->startYourOrdersActivity(Landroid/content/Context;Ljava/util/Map;Ljava/lang/String;ILjava/util/Map;ZI)Z

    .line 99
    return-void

    .line 78
    .end local v8    # "orderActionKey":Ljava/lang/String;
    :cond_2
    const-string/jumbo v8, "order_to_view"

    .restart local v8    # "orderActionKey":Ljava/lang/String;
    goto :goto_0

    .line 81
    .end local v8    # "orderActionKey":Ljava/lang/String;
    :cond_3
    const/4 v8, 0x0

    .restart local v8    # "orderActionKey":Ljava/lang/String;
    goto :goto_0
.end method

.method public getMetricIdentity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-boolean v0, p0, Lcom/amazon/mShop/publicurl/OrderURLProcessor;->isSpecificOrder:Z

    if-eqz v0, :cond_0

    const-string/jumbo v0, "ORDER"

    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "ORDERS"

    goto :goto_0
.end method
