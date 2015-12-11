.class public Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;
.super Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;
.source "SourceFile"


# instance fields
.field private address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

.field private deliveryDate:Ljava/util/Date;

.field private startDate:Ljava/util/Date;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;-><init>()V

    return-void
.end method

.method public static loadData(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;)Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;
    .locals 1

    .prologue
    .line 41
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;-><init>()V

    .line 42
    iput-object p0, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->itemId:Ljava/lang/String;

    .line 43
    iput-object p1, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->ffId:Ljava/lang/String;

    .line 44
    iput-object p2, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->startDate:Ljava/util/Date;

    .line 45
    iput-object p3, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->deliveryDate:Ljava/util/Date;

    .line 46
    iput-object p4, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    .line 47
    return-object v0
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;
    .locals 3

    .prologue
    .line 51
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;-><init>()V

    .line 52
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v1

    .line 53
    const-string v2, "item-id"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    invoke-interface {v2}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->itemId:Ljava/lang/String;

    .line 54
    const-string v2, "id"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v1

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->ffId:Ljava/lang/String;

    .line 55
    return-object v0
.end method


# virtual methods
.method public getAddress()Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    return-object v0
.end method

.method public getDelieveryDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->deliveryDate:Ljava/util/Date;

    return-object v0
.end method

.method public getStartDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->startDate:Ljava/util/Date;

    return-object v0
.end method

.method public getXML()Ljava/lang/String;
    .locals 3

    .prologue
    .line 60
    const-string v0, ""

    .line 62
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "<homedelivery-fulfillment start-date=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lgv;->a:Ljava/text/SimpleDateFormat;

    iget-object v2, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->startDate:Ljava/util/Date;

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\" delivery-date=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lgv;->a:Ljava/text/SimpleDateFormat;

    iget-object v2, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->deliveryDate:Ljava/util/Date;

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\" item-id=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->itemId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 63
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<address type=\"delivery\" verified=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->isVerified()Z

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\">"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 64
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->getCAPIAddressGuts(Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 65
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</address></homedelivery-fulfillment>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 70
    return-object v0

    .line 67
    :catch_0
    move-exception v0

    .line 68
    throw v0
.end method

.method public setAddress(Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->address:Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    .line 26
    return-void
.end method
