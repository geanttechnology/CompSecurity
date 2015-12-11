.class public Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field cartItemProducts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;",
            ">;"
        }
    .end annotation
.end field

.field cartItemWarranties:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemWarranty;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getXML(Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;)Ljava/lang/String;
    .locals 10

    .prologue
    const/4 v2, 0x0

    .line 90
    const-string v0, "<list id=\"list-1\"><items>"

    .line 91
    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemProducts:Ljava/util/ArrayList;

    if-eqz v1, :cond_0

    .line 92
    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemProducts:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move-object v1, v0

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;

    .line 93
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->getXML()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 94
    goto :goto_0

    :cond_0
    move-object v1, v0

    .line 97
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemWarranties:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemWarranties:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemWarranty;

    .line 99
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemWarranty;->getXML()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 102
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</items></list>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 103
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<fulfillment>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 106
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 107
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    move v1, v2

    .line 109
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemProducts:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_6

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemProducts:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->getFulfillment()Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;

    move-result-object v7

    .line 111
    invoke-virtual {v7}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;->getFfId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    move v3, v2

    .line 113
    :goto_3
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v3, v0, :cond_3

    .line 114
    invoke-virtual {v5, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;

    .line 115
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;->getFfId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;->getFfId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v8

    if-nez v8, :cond_4

    .line 116
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;->getItemId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v8, ", "

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v7}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;->getItemId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;->setItemId(Ljava/lang/String;)V

    .line 109
    :cond_3
    :goto_4
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_2

    .line 113
    :cond_4
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_3

    .line 122
    :cond_5
    invoke-virtual {v7}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;->getFfId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 123
    invoke-virtual {v5, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 128
    :cond_6
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move-object v1, v4

    :goto_5
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;

    .line 129
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;->getXML()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 130
    goto :goto_5

    .line 132
    :cond_7
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</fulfillment>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 133
    return-object v0
.end method

.method public static loadData(Ljava/util/ArrayList;Ljava/util/ArrayList;)Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemWarranty;",
            ">;)",
            "Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;"
        }
    .end annotation

    .prologue
    .line 33
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;-><init>()V

    .line 34
    iput-object p0, v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemProducts:Ljava/util/ArrayList;

    .line 35
    iput-object p1, v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemWarranties:Ljava/util/ArrayList;

    .line 36
    return-object v0
.end method

.method public static loadData(Lorg/w3c/dom/Node;Ljava/util/ArrayList;)Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/w3c/dom/Node;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;",
            ">;)",
            "Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 40
    new-instance v4, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;-><init>()V

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemProducts:Ljava/util/ArrayList;

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemWarranties:Ljava/util/ArrayList;

    .line 45
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v5

    move v1, v2

    .line 46
    :goto_0
    invoke-interface {v5}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v0

    if-ge v1, v0, :cond_6

    .line 47
    invoke-interface {v5, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 48
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v0

    const-string v6, "item"

    invoke-virtual {v0, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_5

    .line 50
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v6

    move v0, v2

    .line 52
    :goto_1
    invoke-interface {v6}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v7

    if-ge v0, v7, :cond_7

    .line 53
    invoke-interface {v6, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v7

    .line 54
    invoke-interface {v7}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v8

    const-string v9, "shipping-cost"

    invoke-virtual {v8, v9}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v7}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "delivery-charge"

    invoke-virtual {v7, v8}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v7

    if-nez v7, :cond_2

    .line 56
    :cond_0
    const/4 v0, 0x1

    .line 61
    :goto_2
    if-eqz v0, :cond_4

    .line 62
    invoke-static {v3}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;

    move-result-object v6

    move v3, v2

    .line 64
    :goto_3
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v3, v0, :cond_1

    .line 65
    invoke-virtual {p1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;

    .line 66
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;->getItemId()Ljava/lang/String;

    move-result-object v7

    iget-object v8, v6, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->itemId:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v7

    if-nez v7, :cond_3

    .line 67
    invoke-virtual {v6, v0}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;->setFulfillment(Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;)V

    .line 71
    :cond_1
    iget-object v0, v4, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemProducts:Ljava/util/ArrayList;

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 46
    :goto_4
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 52
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 64
    :cond_3
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_3

    .line 74
    :cond_4
    :try_start_0
    invoke-static {v3}, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemWarranty;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemWarranty;

    move-result-object v0

    .line 75
    iget-object v3, v4, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemWarranties:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_4

    .line 76
    :catch_0
    move-exception v0

    .line 77
    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error parsing Cart Item Warranty - Skipping: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    throw v0

    .line 82
    :cond_5
    sget-object v0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Unknown XML item while parsing Cart Items, skipping: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_4

    .line 86
    :cond_6
    return-object v4

    :cond_7
    move v0, v2

    goto :goto_2
.end method


# virtual methods
.method public getCartItemProducts()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemProducts:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCartItemWarranties()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItemWarranty;",
            ">;"
        }
    .end annotation

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/Cart;->cartItemWarranties:Ljava/util/ArrayList;

    return-object v0
.end method
