.class public Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private availabilityMessage:Ljava/lang/String;

.field private href:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private shipToStore:Z

.field private storeId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;
    .locals 3

    .prologue
    .line 38
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;-><init>()V

    .line 40
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v1

    .line 41
    const-string v2, "id"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 42
    if-eqz v2, :cond_0

    .line 43
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->storeId:Ljava/lang/String;

    .line 46
    :cond_0
    const-string v2, "name"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 47
    if-eqz v2, :cond_1

    .line 48
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->name:Ljava/lang/String;

    .line 51
    :cond_1
    const-string v2, "availabilityMsg"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 52
    if-eqz v2, :cond_2

    .line 53
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->availabilityMessage:Ljava/lang/String;

    .line 56
    :cond_2
    const-string v2, "href"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 57
    if-eqz v2, :cond_3

    .line 58
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->href:Ljava/lang/String;

    .line 61
    :cond_3
    const-string v2, "ship-to-store"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 62
    if-eqz v1, :cond_4

    .line 63
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v1

    const-string v2, "true"

    invoke-virtual {v1, v2}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_5

    .line 64
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->shipToStore:Z

    .line 70
    :cond_4
    :goto_0
    return-object v0

    .line 66
    :cond_5
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->shipToStore:Z

    goto :goto_0
.end method


# virtual methods
.method public getAvailabilityMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->availabilityMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getHref()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->href:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->storeId:Ljava/lang/String;

    return-object v0
.end method

.method public isShipToStore()Z
    .locals 1

    .prologue
    .line 34
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/StoreAvailability;->shipToStore:Z

    return v0
.end method
