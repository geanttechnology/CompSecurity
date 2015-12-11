.class public Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private cardNumber:Ljava/lang/String;

.field private currency:Ljava/lang/String;

.field private value:D


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;
    .locals 7

    .prologue
    .line 48
    new-instance v2, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;-><init>()V

    .line 49
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v3

    .line 50
    const/4 v0, 0x0

    :goto_0
    invoke-interface {v3}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_3

    .line 51
    invoke-interface {v3, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 52
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "gift-card"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_2

    .line 53
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v4

    .line 54
    const-string v5, "card-num"

    invoke-interface {v4, v5}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v5

    .line 55
    if-eqz v5, :cond_0

    .line 56
    invoke-interface {v5}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v2, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->cardNumber:Ljava/lang/String;

    .line 58
    :cond_0
    const-string v5, "currency"

    invoke-interface {v4, v5}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v4

    .line 59
    if-eqz v4, :cond_1

    .line 60
    invoke-interface {v4}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v2, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->currency:Ljava/lang/String;

    .line 63
    :cond_1
    :try_start_0
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v2, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->value:D
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 50
    :cond_2
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 64
    :catch_0
    move-exception v1

    .line 65
    sget-object v4, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Could not parse price into double: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4, v1}, Lgs;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 72
    :cond_3
    return-object v2
.end method


# virtual methods
.method public getCardNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->cardNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getCurrency()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->currency:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()D
    .locals 2

    .prologue
    .line 36
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->value:D

    return-wide v0
.end method

.method public setCardNumber(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->cardNumber:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public setCurrency(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->currency:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setValue(D)V
    .locals 1

    .prologue
    .line 24
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->value:D

    .line 25
    return-void
.end method
