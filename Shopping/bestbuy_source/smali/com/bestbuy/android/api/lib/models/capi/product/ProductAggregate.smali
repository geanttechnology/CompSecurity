.class public Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field deliveryDates:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/Date;",
            ">;"
        }
    .end annotation
.end field

.field private productAvailability:Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;

.field private shippingOptions:Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;

.field stores:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;",
            ">;"
        }
    .end annotation
.end field

.field private tax:Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;

.field private unitPrice:Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    const-class v0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;
    .locals 11

    .prologue
    const/4 v1, 0x0

    .line 65
    new-instance v4, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;-><init>()V

    .line 66
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v0

    const-string v2, "productservice-response"

    invoke-virtual {v0, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_9

    .line 67
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v5

    move v0, v1

    .line 68
    :goto_0
    invoke-interface {v5}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v2

    if-ge v0, v2, :cond_9

    .line 69
    invoke-interface {v5, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 70
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v6, "availability-query"

    invoke-virtual {v3, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_1

    .line 71
    invoke-static {v2}, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;

    move-result-object v2

    iput-object v2, v4, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->productAvailability:Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;

    .line 68
    :cond_0
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 72
    :cond_1
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v6, "price-response"

    invoke-virtual {v3, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_2

    .line 73
    invoke-static {v2}, Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;->loadPriceData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;

    move-result-object v2

    iput-object v2, v4, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->unitPrice:Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;

    goto :goto_1

    .line 74
    :cond_2
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v6, "estimated-tax"

    invoke-virtual {v3, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_3

    .line 75
    invoke-static {v2}, Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;->loadTaxData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;

    move-result-object v2

    iput-object v2, v4, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->tax:Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;

    goto :goto_1

    .line 76
    :cond_3
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v6, "shipping-options"

    invoke-virtual {v3, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_4

    .line 77
    invoke-static {v2}, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;

    move-result-object v2

    iput-object v2, v4, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->shippingOptions:Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;

    goto :goto_1

    .line 78
    :cond_4
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v6, "deliverydate-response"

    invoke-virtual {v3, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_6

    .line 79
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v4, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->deliveryDates:Ljava/util/ArrayList;

    .line 80
    new-instance v6, Ljava/text/SimpleDateFormat;

    const-string v3, "yyyy-mm-dd"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v7

    invoke-direct {v6, v3, v7}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 81
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v7

    move v2, v1

    .line 82
    :goto_2
    invoke-interface {v7}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v2, v3, :cond_0

    .line 83
    invoke-interface {v7, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 84
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v8

    const-string v9, "deliverydate"

    invoke-virtual {v8, v9}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v8

    if-nez v8, :cond_5

    .line 86
    :try_start_0
    iget-object v8, v4, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->deliveryDates:Ljava/util/ArrayList;

    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v6, v3}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v8, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    :cond_5
    :goto_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 87
    :catch_0
    move-exception v3

    .line 88
    sget-object v8, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Could not parse delivery date: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v3}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v8, v3}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 92
    :cond_6
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    const-string v6, "stores"

    invoke-virtual {v3, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_8

    .line 93
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v4, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->stores:Ljava/util/ArrayList;

    .line 94
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v3

    move v2, v1

    .line 95
    :goto_4
    invoke-interface {v3}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v6

    if-ge v2, v6, :cond_0

    .line 96
    invoke-interface {v3, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v6

    .line 97
    invoke-interface {v6}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "store"

    invoke-virtual {v7, v8}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v7

    if-nez v7, :cond_7

    .line 98
    invoke-static {v6}, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;

    move-result-object v6

    .line 99
    iget-object v7, v4, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->stores:Ljava/util/ArrayList;

    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 95
    :goto_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    .line 101
    :cond_7
    sget-object v7, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Unknown elements found in while parsing ProductAggregate\'s store availability: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-interface {v6}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v7, v6}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_5

    .line 105
    :cond_8
    sget-object v3, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Unknown elements found in while parsing ProductAggregate: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 109
    :cond_9
    return-object v4
.end method


# virtual methods
.method public getDeliveryDates()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/Date;",
            ">;"
        }
    .end annotation

    .prologue
    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->deliveryDates:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getProductAvailability()Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->productAvailability:Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;

    return-object v0
.end method

.method public getShippingOptions()Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->shippingOptions:Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;

    return-object v0
.end method

.method public getStores()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;",
            ">;"
        }
    .end annotation

    .prologue
    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->stores:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTax()Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->tax:Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;

    return-object v0
.end method

.method public getUnitPrice()Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAggregate;->unitPrice:Lcom/bestbuy/android/api/lib/models/capi/product/PriceResponse;

    return-object v0
.end method
