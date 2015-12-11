.class public Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private currency:Ljava/lang/String;

.field private expectedDeliveryDate:Ljava/util/Date;

.field private key:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private price:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;
    .locals 1

    .prologue
    .line 79
    invoke-static {p0}, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;

    move-result-object v0

    return-object v0
.end method

.method private static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;
    .locals 7

    .prologue
    .line 103
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;-><init>()V

    .line 105
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v1

    .line 107
    const-string v2, "price"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 108
    if-eqz v2, :cond_0

    .line 110
    :try_start_0
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->price:D
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 115
    :cond_0
    :goto_0
    const-string v2, "currency"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 116
    if-eqz v2, :cond_1

    .line 117
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->currency:Ljava/lang/String;

    .line 119
    :cond_1
    const-string v2, "expected-delivery-date"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 120
    if-eqz v2, :cond_2

    .line 121
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v3

    .line 122
    new-instance v4, Ljava/text/SimpleDateFormat;

    const-string v5, "yyyy-mm-dd"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 124
    :try_start_1
    invoke-virtual {v4, v3}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    iput-object v3, v0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->expectedDeliveryDate:Ljava/util/Date;
    :try_end_1
    .catch Ljava/text/ParseException; {:try_start_1 .. :try_end_1} :catch_1

    .line 129
    :cond_2
    :goto_1
    const-string v2, "key"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 130
    if-eqz v1, :cond_3

    .line 131
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->key:Ljava/lang/String;

    .line 134
    :cond_3
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->name:Ljava/lang/String;

    .line 136
    return-object v0

    .line 111
    :catch_0
    move-exception v3

    .line 112
    # getter for: Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->access$100()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not parse Shipping Option Price to double: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 125
    :catch_1
    move-exception v3

    .line 126
    # getter for: Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->access$100()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not parse Shipping Option expected-delivery-date: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method


# virtual methods
.method public getCurrency()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->currency:Ljava/lang/String;

    return-object v0
.end method

.method public getExpectedDeliveryDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->expectedDeliveryDate:Ljava/util/Date;

    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()D
    .locals 2

    .prologue
    .line 87
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->price:D

    return-wide v0
.end method
