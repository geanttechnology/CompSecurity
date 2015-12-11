.class public Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;
.super Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;
.source "SourceFile"


# instance fields
.field private ageVerified:Z

.field private fulfillment:Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;

.field private qty:I

.field private warrantyId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;-><init>()V

    return-void
.end method

.method public static loadData(Ljava/lang/String;ZILjava/lang/String;Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;)Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;
    .locals 1

    .prologue
    .line 68
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;-><init>()V

    .line 69
    iput-object p0, v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->itemId:Ljava/lang/String;

    .line 70
    iput-boolean p1, v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->ageVerified:Z

    .line 71
    iput p2, v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->qty:I

    .line 72
    iput-object p3, v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->sku:Ljava/lang/String;

    .line 73
    iput-object p4, v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->fulfillment:Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;

    .line 74
    return-object v0
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 43
    new-instance v2, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;-><init>()V

    .line 44
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v0

    .line 45
    const-string v3, "sku"

    invoke-interface {v0, v3}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v3

    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->sku:Ljava/lang/String;

    .line 46
    const-string v3, "id"

    invoke-interface {v0, v3}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v3

    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->itemId:Ljava/lang/String;

    .line 47
    const-string v3, "backordered"

    invoke-interface {v0, v3}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v0

    invoke-interface {v0}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v0

    const-string v3, "true"

    invoke-virtual {v0, v3}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->backordered:Z

    .line 48
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 49
    :goto_1
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v1, v3, :cond_6

    .line 50
    invoke-interface {v0, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 51
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "quantity"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_2

    .line 52
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    iput v3, v2, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->qty:I

    .line 49
    :cond_0
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_1
    move v0, v1

    .line 47
    goto :goto_0

    .line 53
    :cond_2
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "description"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_3

    .line 54
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->description:Ljava/lang/String;

    goto :goto_2

    .line 55
    :cond_3
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "unit-price"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_4

    .line 56
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v2, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->cost:D

    goto :goto_2

    .line 57
    :cond_4
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "shipping-cost"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_5

    .line 58
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v2, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->shippingCost:D

    goto :goto_2

    .line 59
    :cond_5
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "tax-cost"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_0

    .line 60
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v2, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->taxCost:D

    goto :goto_2

    .line 64
    :cond_6
    return-object v2
.end method


# virtual methods
.method public getFulfillment()Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->fulfillment:Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;

    return-object v0
.end method

.method public getQty()I
    .locals 1

    .prologue
    .line 27
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->qty:I

    return v0
.end method

.method public getWarrantyId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->warrantyId:Ljava/lang/String;

    return-object v0
.end method

.method public getXML()Ljava/lang/String;
    .locals 2

    .prologue
    .line 78
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "<item id=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->itemId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\" age-verified=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->ageVerified:Z

    if-eqz v0, :cond_0

    const-string v0, "true"

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\">"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 79
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<quantity>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->qty:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</quantity>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 80
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<link rel=\"src\" href=\"http://server/sku/us/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->sku:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".xml\"/>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 81
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</item>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 82
    return-object v0

    .line 78
    :cond_0
    const-string v0, "false"

    goto :goto_0
.end method

.method public isAgeVerified()Z
    .locals 1

    .prologue
    .line 35
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->ageVerified:Z

    return v0
.end method

.method public setFulfillment(Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->fulfillment:Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;

    .line 24
    return-void
.end method
