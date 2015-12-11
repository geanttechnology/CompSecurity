.class public Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private displayMessage:Ljava/lang/String;

.field private homeDeliveryCode:I

.field private homeDeliveryMessage:Ljava/lang/String;

.field private instoreAvailabilty:Z

.field private maxQuantity:I

.field private orderCode:I

.field private sku:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;
    .locals 8

    .prologue
    const/4 v1, 0x0

    .line 56
    new-instance v3, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;-><init>()V

    .line 57
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v0

    .line 58
    const-string v2, "sku-id"

    invoke-interface {v0, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 59
    if-eqz v0, :cond_0

    .line 60
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->sku:Ljava/lang/String;

    .line 62
    :cond_0
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v4

    move v0, v1

    .line 63
    :goto_0
    invoke-interface {v4}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v2

    if-ge v0, v2, :cond_8

    .line 64
    invoke-interface {v4, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 65
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "order-code"

    invoke-virtual {v5, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v5

    if-nez v5, :cond_2

    .line 67
    :try_start_0
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v3, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->orderCode:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 63
    :cond_1
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 68
    :catch_0
    move-exception v2

    .line 69
    sget-object v5, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Could not parse order code to integer: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v2}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v5, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 71
    :cond_2
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "display-message"

    invoke-virtual {v5, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v5

    if-nez v5, :cond_3

    .line 72
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->displayMessage:Ljava/lang/String;

    goto :goto_1

    .line 73
    :cond_3
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "home-delivery-code"

    invoke-virtual {v5, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v5

    if-nez v5, :cond_4

    .line 75
    :try_start_1
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v3, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->homeDeliveryCode:I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 76
    :catch_1
    move-exception v2

    .line 77
    sget-object v5, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Could not parse home delivery code to integer: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v2}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v5, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 79
    :cond_4
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "home-delivery-message"

    invoke-virtual {v5, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v5

    if-nez v5, :cond_5

    .line 80
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->homeDeliveryMessage:Ljava/lang/String;

    goto :goto_1

    .line 81
    :cond_5
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "instore-availability"

    invoke-virtual {v5, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v5

    if-nez v5, :cond_7

    .line 82
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v2

    const-string v5, "true"

    invoke-virtual {v2, v5}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_6

    .line 83
    const/4 v2, 0x1

    iput-boolean v2, v3, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->instoreAvailabilty:Z

    goto/16 :goto_1

    .line 85
    :cond_6
    iput-boolean v1, v3, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->instoreAvailabilty:Z

    goto/16 :goto_1

    .line 87
    :cond_7
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "max-quantity"

    invoke-virtual {v5, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v5

    if-nez v5, :cond_1

    .line 89
    :try_start_2
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v3, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->maxQuantity:I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto/16 :goto_1

    .line 90
    :catch_2
    move-exception v2

    .line 91
    sget-object v5, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Could not parse max quantity to integer: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v2}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v5, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 95
    :cond_8
    return-object v3
.end method


# virtual methods
.method public getDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->displayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getHomeDeliveryCode()I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->homeDeliveryCode:I

    return v0
.end method

.method public getHomeDeliveryMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->homeDeliveryMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxQuantity()I
    .locals 1

    .prologue
    .line 52
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->maxQuantity:I

    return v0
.end method

.method public getOrderCode()I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->orderCode:I

    return v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public isInstoreAvailabilty()Z
    .locals 1

    .prologue
    .line 48
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ProductAvailability;->instoreAvailabilty:Z

    return v0
.end method
