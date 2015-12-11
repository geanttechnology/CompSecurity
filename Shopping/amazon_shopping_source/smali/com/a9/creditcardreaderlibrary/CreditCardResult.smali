.class public Lcom/a9/creditcardreaderlibrary/CreditCardResult;
.super Ljava/lang/Object;
.source "CreditCardResult.java"


# instance fields
.field private m_alternateCardNumbers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private m_alternateExpirationDates:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private m_cardHolderName:Ljava/lang/String;

.field private m_cardNumber:Ljava/lang/String;

.field private m_cardType:Ljava/lang/String;

.field private m_expirationDate:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V
    .locals 7
    .param p1, "a_creditCardInfo"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;->getCardHolderName()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_cardHolderName:Ljava/lang/String;

    .line 28
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;->getCardNumber()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_cardNumber:Ljava/lang/String;

    .line 29
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;->getExpirationDate()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_expirationDate:Ljava/lang/String;

    .line 30
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;->getType()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_cardType:Ljava/lang/String;

    .line 33
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;->getCardNumberAlternatives()Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    move-result-object v0

    .line 34
    .local v0, "alternateCardNumbers":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_alternateCardNumbers:Ljava/util/List;

    .line 35
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    int-to-long v3, v2

    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-gez v3, :cond_0

    .line 36
    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_alternateCardNumbers:Ljava/util/List;

    invoke-virtual {v0, v2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 35
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 40
    :cond_0
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;->getCardDateAlternatives()Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    move-result-object v1

    .line 41
    .local v1, "alternateExpirationDates":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_alternateExpirationDates:Ljava/util/List;

    .line 42
    const/4 v2, 0x0

    :goto_1
    int-to-long v3, v2

    invoke-virtual {v1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-gez v3, :cond_1

    .line 43
    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_alternateExpirationDates:Ljava/util/List;

    invoke-virtual {v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 42
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 45
    :cond_1
    return-void
.end method


# virtual methods
.method public getAlternateCardNumbers()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_alternateCardNumbers:Ljava/util/List;

    return-object v0
.end method

.method public getAlternateExpirationDates()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 76
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_alternateExpirationDates:Ljava/util/List;

    return-object v0
.end method

.method public getCardNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_cardNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getExpirationDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->m_expirationDate:Ljava/lang/String;

    return-object v0
.end method
