.class public Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private freeShipping:Z

.field private shippingOptions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;",
            ">;"
        }
    .end annotation
.end field

.field private sku:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->shippingOptions:Ljava/util/ArrayList;

    .line 79
    return-void
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;
    .locals 7

    .prologue
    const/4 v0, 0x0

    .line 47
    new-instance v1, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;-><init>()V

    .line 49
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v2

    .line 50
    const-string v3, "sku-id"

    invoke-interface {v2, v3}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 51
    if-eqz v3, :cond_0

    .line 52
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->sku:Ljava/lang/String;

    .line 54
    :cond_0
    const-string v3, "free-shipping"

    invoke-interface {v2, v3}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 55
    if-eqz v2, :cond_2

    .line 56
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    const-string v3, "true"

    invoke-virtual {v2, v3}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_1

    .line 57
    const/4 v2, 0x1

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->freeShipping:Z

    .line 65
    :goto_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->shippingOptions:Ljava/util/ArrayList;

    .line 67
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v2

    .line 68
    :goto_1
    invoke-interface {v2}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v0, v3, :cond_4

    .line 69
    invoke-interface {v2, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 70
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "option"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_3

    .line 71
    iget-object v4, v1, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->shippingOptions:Ljava/util/ArrayList;

    # invokes: Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;
    invoke-static {v3}, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;->access$000(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 68
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 59
    :cond_1
    iput-boolean v0, v1, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->freeShipping:Z

    goto :goto_0

    .line 62
    :cond_2
    iput-boolean v0, v1, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->freeShipping:Z

    goto :goto_0

    .line 73
    :cond_3
    sget-object v4, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unknown elements found in while parsing ProductAggregate\'s shipping options: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v4, v3}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 76
    :cond_4
    return-object v1
.end method


# virtual methods
.method public getShippingOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions$ShippingOption;",
            ">;"
        }
    .end annotation

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->shippingOptions:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public isFreeShipping()Z
    .locals 1

    .prologue
    .line 40
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/capi/product/ShippingOptions;->freeShipping:Z

    return v0
.end method
