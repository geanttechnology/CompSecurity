.class public Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;
.super Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;
.source "SourceFile"


# instance fields
.field private address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

.field private estimatedDeliveryDateRange:Ljava/lang/String;

.field private shippingOption:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;-><init>()V

    return-void
.end method

.method public static loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;)Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;
    .locals 1

    .prologue
    .line 50
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;-><init>()V

    .line 51
    iput-object p0, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->itemId:Ljava/lang/String;

    .line 52
    iput-object p1, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->ffId:Ljava/lang/String;

    .line 53
    iput-object p2, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->shippingOption:Ljava/lang/String;

    .line 54
    iput-object p3, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->estimatedDeliveryDateRange:Ljava/lang/String;

    .line 55
    iput-object p4, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    .line 56
    return-object v0
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;
    .locals 3

    .prologue
    .line 60
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;-><init>()V

    .line 61
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v1

    .line 62
    const-string v2, "shipping-option"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    invoke-interface {v2}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->shippingOption:Ljava/lang/String;

    .line 63
    const-string v2, "item-id"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    invoke-interface {v2}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->itemId:Ljava/lang/String;

    .line 64
    const-string v2, "id"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v1

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->ffId:Ljava/lang/String;

    .line 65
    return-object v0
.end method


# virtual methods
.method public getAddress()Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    return-object v0
.end method

.method public getEstimatedDeliveryDateRange()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->estimatedDeliveryDateRange:Ljava/lang/String;

    return-object v0
.end method

.method public getShippingOption()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->shippingOption:Ljava/lang/String;

    return-object v0
.end method

.method public getXML()Ljava/lang/String;
    .locals 2

    .prologue
    .line 38
    const-string v0, ""

    .line 40
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<address-fulfillment item-id=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->itemId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\"><shipping option=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->shippingOption:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\"/><address type=\"Shipping\" verified=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->isVerified()Z

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\">"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 41
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->getCAPIAddressGuts(Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 42
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</address></address-fulfillment>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 46
    return-object v0

    .line 43
    :catch_0
    move-exception v0

    .line 44
    throw v0
.end method

.method public setAddress(Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;)V
    .locals 0

    .prologue
    .line 21
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    .line 22
    return-void
.end method
