.class public Lcom/bestbuy/android/api/lib/models/capi/order/Order;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private cart:Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;

.field private certAmount:D

.field private extraFees:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;",
            ">;"
        }
    .end annotation
.end field

.field private orderCost:D

.field private productCost:D

.field private promoAmount:D

.field private salesTax:D

.field private shipCost:D

.field private svcAmount:D

.field private taxMessage:Ljava/lang/String;

.field private tender:Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;)Lcom/bestbuy/android/api/lib/models/capi/order/Order;
    .locals 1

    .prologue
    .line 83
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/Order;-><init>()V

    .line 84
    iput-object p0, v0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->cart:Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;

    .line 85
    iput-object p1, v0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->tender:Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;

    .line 86
    return-object v0
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/Order;
    .locals 13

    .prologue
    const/4 v1, 0x0

    .line 90
    new-instance v4, Lcom/bestbuy/android/api/lib/models/capi/order/Order;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/capi/order/Order;-><init>()V

    .line 91
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v5

    .line 95
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    move v0, v1

    .line 96
    :goto_0
    invoke-interface {v5}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 97
    invoke-interface {v5, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 99
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v7, "addresses"

    invoke-virtual {v3, v7}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_0

    .line 100
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v2

    move v0, v1

    .line 101
    :goto_1
    invoke-interface {v2}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v0, v3, :cond_1

    .line 102
    invoke-interface {v2, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 103
    invoke-static {v3}, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    move-result-object v3

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 101
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 96
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 111
    :cond_1
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    move v0, v1

    .line 112
    :goto_2
    invoke-interface {v5}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v2

    if-ge v0, v2, :cond_9

    .line 113
    invoke-interface {v5, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 114
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v8, "fulfillment"

    invoke-virtual {v3, v8}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_8

    .line 115
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v8

    move v2, v1

    .line 116
    :goto_3
    invoke-interface {v8}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v0

    if-ge v2, v0, :cond_9

    .line 117
    invoke-interface {v8, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 118
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v9, "homedelivery-fulfillment"

    invoke-virtual {v3, v9}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_4

    .line 119
    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;

    move-result-object v9

    move v3, v1

    .line 120
    :goto_4
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v3, v0, :cond_2

    .line 121
    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    .line 122
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->getFfId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->getFulfillmentId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v10

    if-nez v10, :cond_3

    .line 123
    invoke-virtual {v9, v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentDelivery;->setAddress(Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;)V

    .line 124
    invoke-virtual {v7, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 116
    :cond_2
    :goto_5
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_3

    .line 120
    :cond_3
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_4

    .line 128
    :cond_4
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v9, "address-fulfillment"

    invoke-virtual {v3, v9}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_6

    .line 129
    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;

    move-result-object v9

    move v3, v1

    .line 130
    :goto_6
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v3, v0, :cond_2

    .line 131
    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    .line 132
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->getFfId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->getFulfillmentId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v10

    if-nez v10, :cond_5

    .line 133
    invoke-virtual {v9, v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentShipping;->setAddress(Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;)V

    .line 134
    invoke-virtual {v7, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_5

    .line 130
    :cond_5
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_6

    .line 138
    :cond_6
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v9, "store-fulfillment"

    invoke-virtual {v3, v9}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_7

    .line 139
    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;

    move-result-object v0

    .line 140
    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_5

    .line 142
    :cond_7
    sget-object v3, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Unknown fulfillment XML, skipping: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_5

    .line 112
    :cond_8
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_2

    :cond_9
    move v0, v1

    .line 150
    :goto_7
    invoke-interface {v5}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v2

    if-ge v0, v2, :cond_17

    .line 151
    invoke-interface {v5, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 152
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v6, "cart"

    invoke-virtual {v3, v6}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_14

    .line 153
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v6

    move v2, v1

    .line 154
    :goto_8
    invoke-interface {v6}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v2, v3, :cond_15

    .line 155
    invoke-interface {v6, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 156
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v8

    const-string v9, "items"

    invoke-virtual {v8, v9}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v8

    if-nez v8, :cond_b

    .line 157
    invoke-static {v3, v7}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->loadData(Lorg/w3c/dom/Node;Ljava/util/ArrayList;)Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;

    move-result-object v3

    iput-object v3, v4, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->cart:Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;

    .line 154
    :cond_a
    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    .line 158
    :cond_b
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v8

    const-string v9, "total"

    invoke-virtual {v8, v9}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v8

    if-nez v8, :cond_a

    .line 160
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v8

    move v3, v1

    .line 161
    :goto_9
    invoke-interface {v8}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v9

    if-ge v3, v9, :cond_a

    .line 162
    invoke-interface {v8, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v9

    .line 163
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v11, "product-cost"

    invoke-virtual {v10, v11}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v10

    if-nez v10, :cond_c

    .line 164
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    iput-wide v10, v4, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->productCost:D

    .line 161
    :goto_a
    add-int/lit8 v3, v3, 0x1

    goto :goto_9

    .line 165
    :cond_c
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v11, "sales-tax"

    invoke-virtual {v10, v11}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v10

    if-nez v10, :cond_d

    .line 166
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    iput-wide v10, v4, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->salesTax:D

    goto :goto_a

    .line 167
    :cond_d
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v11, "shipping-cost"

    invoke-virtual {v10, v11}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v10

    if-nez v10, :cond_e

    .line 168
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    iput-wide v10, v4, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->shipCost:D

    goto :goto_a

    .line 169
    :cond_e
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v11, "tax-message"

    invoke-virtual {v10, v11}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v10

    if-nez v10, :cond_f

    .line 170
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v9

    iput-object v9, v4, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->taxMessage:Ljava/lang/String;

    goto :goto_a

    .line 171
    :cond_f
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v11, "order-cost"

    invoke-virtual {v10, v11}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v10

    if-nez v10, :cond_10

    .line 172
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    iput-wide v10, v4, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->orderCost:D

    goto :goto_a

    .line 173
    :cond_10
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v11, "svc-amount"

    invoke-virtual {v10, v11}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v10

    if-nez v10, :cond_11

    .line 174
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    iput-wide v10, v4, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->svcAmount:D

    goto :goto_a

    .line 175
    :cond_11
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v11, "promocode-amount"

    invoke-virtual {v10, v11}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v10

    if-nez v10, :cond_12

    .line 176
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    iput-wide v10, v4, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->promoAmount:D

    goto/16 :goto_a

    .line 177
    :cond_12
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v11, "rwz-cert-amount"

    invoke-virtual {v10, v11}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v10

    if-nez v10, :cond_13

    .line 178
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    iput-wide v10, v4, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->certAmount:D

    goto/16 :goto_a

    .line 180
    :cond_13
    sget-object v10, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->TAG:Ljava/lang/String;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Unknown XML value found while parsing orderNodeList, skipping:"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-interface {v9}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v11, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v10, v9}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_a

    .line 185
    :cond_14
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v6, "tender"

    invoke-virtual {v3, v6}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_16

    .line 186
    invoke-static {v2}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;

    move-result-object v2

    iput-object v2, v4, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->tender:Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;

    .line 150
    :cond_15
    :goto_b
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_7

    .line 188
    :cond_16
    sget-object v3, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unknown XML value found while parsing Order, skipping:"

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_b

    .line 192
    :cond_17
    return-object v4
.end method


# virtual methods
.method public getCart()Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->cart:Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;

    return-object v0
.end method

.method public getCertAmount()D
    .locals 2

    .prologue
    .line 79
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->certAmount:D

    return-wide v0
.end method

.method public getExtraFees()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;",
            ">;"
        }
    .end annotation

    .prologue
    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->extraFees:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getOrderCost()D
    .locals 2

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->orderCost:D

    return-wide v0
.end method

.method public getProductCost()D
    .locals 2

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->productCost:D

    return-wide v0
.end method

.method public getPromoAmount()D
    .locals 2

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->promoAmount:D

    return-wide v0
.end method

.method public getSalesTax()D
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->salesTax:D

    return-wide v0
.end method

.method public getShipCost()D
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->shipCost:D

    return-wide v0
.end method

.method public getSvcAmount()D
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->svcAmount:D

    return-wide v0
.end method

.method public getTaxMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->taxMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getTender()Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->tender:Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;

    return-object v0
.end method

.method public getXML(Ljava/lang/String;Z)Ljava/lang/String;
    .locals 2

    .prologue
    .line 196
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "<order id=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\" reviewable=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    if-eqz p2, :cond_2

    const-string v0, "true"

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\" > "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 197
    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->cart:Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;

    if-eqz v1, :cond_0

    .line 198
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->cart:Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;

    invoke-static {v1}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->getXML(Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 200
    :cond_0
    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->tender:Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;

    if-eqz v1, :cond_1

    .line 201
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/Order;->tender:Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;

    invoke-static {v1}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->getXML(Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 203
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</order>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 204
    return-object v0

    .line 196
    :cond_2
    const-string v0, "false"

    goto :goto_0
.end method
