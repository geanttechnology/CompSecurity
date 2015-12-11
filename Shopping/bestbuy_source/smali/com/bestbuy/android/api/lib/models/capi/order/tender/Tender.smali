.class public Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static cc:Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;

.field private static giftCards:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/tender/GiftCardTender;",
            ">;"
        }
    .end annotation
.end field

.field private static promoCodes:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/tender/PromoTender;",
            ">;"
        }
    .end annotation
.end field

.field private static rzCerts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/tender/RewardZoneTender;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getCc()Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;
    .locals 1

    .prologue
    .line 34
    sget-object v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->cc:Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;

    return-object v0
.end method

.method public static getGiftCards()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/tender/GiftCardTender;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    sget-object v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->giftCards:Ljava/util/ArrayList;

    return-object v0
.end method

.method public static getPromoCodes()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/tender/PromoTender;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    sget-object v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->promoCodes:Ljava/util/ArrayList;

    return-object v0
.end method

.method public static getRzCerts()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/tender/RewardZoneTender;",
            ">;"
        }
    .end annotation

    .prologue
    .line 22
    sget-object v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->rzCerts:Ljava/util/ArrayList;

    return-object v0
.end method

.method public static getXML(Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 97
    const-string v0, "<tender>"

    .line 98
    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->rzCerts:Ljava/util/ArrayList;

    if-eqz v1, :cond_1

    .line 99
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<rewardcerts>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 100
    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->rzCerts:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move-object v1, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/RewardZoneTender;

    .line 101
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/RewardZoneTender;->getXML()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 102
    goto :goto_0

    .line 103
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</rewardcerts>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 106
    :cond_1
    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->promoCodes:Ljava/util/ArrayList;

    if-eqz v1, :cond_3

    .line 107
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<promotionalcodes>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 108
    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->promoCodes:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move-object v1, v0

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/PromoTender;

    .line 109
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/PromoTender;->getXML()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 110
    goto :goto_1

    .line 111
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</promotionalcodes>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 114
    :cond_3
    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->giftCards:Ljava/util/ArrayList;

    if-eqz v1, :cond_5

    .line 115
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<giftcards>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 116
    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->giftCards:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move-object v1, v0

    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/GiftCardTender;

    .line 117
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/GiftCardTender;->getXML()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 118
    goto :goto_2

    .line 119
    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</giftcards>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 122
    :cond_5
    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->cc:Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;

    if-eqz v1, :cond_6

    .line 123
    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->cc:Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;

    iget-object v1, v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;->ccNumber:Ljava/lang/String;

    if-eqz v1, :cond_7

    .line 124
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<cc-tender>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 125
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->cc:Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;->getXML()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 126
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</cc-tender>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 131
    :cond_6
    :goto_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</tender>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 132
    return-object v0

    .line 127
    :cond_7
    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->cc:Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;->getCid()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_6

    .line 128
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->cc:Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;->getXML()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_3
.end method

.method public static loadData(Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;)Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;
    .locals 1

    .prologue
    .line 38
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;-><init>()V

    .line 39
    sput-object p0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->cc:Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;

    .line 40
    return-object v0
.end method

.method public static loadData(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;)Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/tender/RewardZoneTender;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/tender/PromoTender;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/tender/GiftCardTender;",
            ">;",
            "Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;",
            ")",
            "Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;"
        }
    .end annotation

    .prologue
    .line 44
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;-><init>()V

    .line 45
    sput-object p0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->rzCerts:Ljava/util/ArrayList;

    .line 46
    sput-object p1, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->promoCodes:Ljava/util/ArrayList;

    .line 47
    sput-object p2, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->giftCards:Ljava/util/ArrayList;

    .line 48
    sput-object p3, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->cc:Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;

    .line 49
    return-object v0
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 53
    new-instance v2, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;-><init>()V

    .line 54
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v3

    move v0, v1

    .line 55
    :goto_0
    invoke-interface {v3}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v0, v4, :cond_6

    .line 56
    invoke-interface {v3, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v4

    .line 57
    invoke-interface {v4}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "rewardcerts"

    invoke-virtual {v5, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v5

    if-nez v5, :cond_1

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->rzCerts:Ljava/util/ArrayList;

    .line 59
    invoke-interface {v4}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 60
    :goto_1
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v1, v3, :cond_6

    .line 61
    invoke-interface {v0, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 62
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "rwzcert"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_0

    .line 63
    sget-object v4, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->rzCerts:Ljava/util/ArrayList;

    invoke-static {v3}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/RewardZoneTender;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/tender/RewardZoneTender;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 60
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 67
    :cond_1
    invoke-interface {v4}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "promotionalcodes"

    invoke-virtual {v5, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v5

    if-nez v5, :cond_3

    .line 68
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->promoCodes:Ljava/util/ArrayList;

    .line 69
    invoke-interface {v4}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 70
    :goto_2
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v1, v3, :cond_6

    .line 71
    invoke-interface {v0, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 72
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "promotionalcode"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_2

    .line 73
    sget-object v4, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->promoCodes:Ljava/util/ArrayList;

    invoke-static {v3}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/PromoTender;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/tender/PromoTender;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 70
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 77
    :cond_3
    invoke-interface {v4}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "giftcards"

    invoke-virtual {v5, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v5

    if-nez v5, :cond_5

    .line 78
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->giftCards:Ljava/util/ArrayList;

    .line 79
    invoke-interface {v4}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 80
    :goto_3
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v1, v3, :cond_6

    .line 81
    invoke-interface {v0, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 82
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_4

    .line 83
    sget-object v4, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->giftCards:Ljava/util/ArrayList;

    invoke-static {v3}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/GiftCardTender;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/tender/GiftCardTender;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 80
    :cond_4
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 87
    :cond_5
    invoke-interface {v4}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "cc-tender"

    invoke-virtual {v5, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v5

    if-nez v5, :cond_7

    .line 88
    invoke-static {v4}, Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/order/tender/Tender;->cc:Lcom/bestbuy/android/api/lib/models/capi/order/tender/CreditCardTender;

    .line 93
    :cond_6
    return-object v2

    .line 55
    :cond_7
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0
.end method
