.class public Lcom/creditcardreader/utils/CreditCardUtils;
.super Ljava/lang/Object;
.source "CreditCardUtils.java"


# static fields
.field private static sResources:Landroid/content/res/Resources;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static addExpirationDates(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    .locals 2
    .param p0, "expirationDate"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 105
    .local p1, "expirationMonths":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .local p2, "expirationYears":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string/jumbo v1, "/"

    invoke-virtual {p0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 106
    .local v0, "date":[Ljava/lang/String;
    const/4 v1, 0x0

    aget-object v1, v0, v1

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 107
    const/4 v1, 0x1

    aget-object v1, v0, v1

    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 108
    return-void
.end method

.method public static convertDpToPx(I)F
    .locals 3
    .param p0, "dp"    # I

    .prologue
    .line 33
    const/4 v0, 0x1

    int-to-float v1, p0

    sget-object v2, Lcom/creditcardreader/utils/CreditCardUtils;->sResources:Landroid/content/res/Resources;

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v0, v1, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    return v0
.end method

.method public static createSuccessIntent(Lcom/a9/creditcardreaderlibrary/CreditCardResult;)Landroid/content/Intent;
    .locals 10
    .param p0, "result"    # Lcom/a9/creditcardreaderlibrary/CreditCardResult;

    .prologue
    .line 47
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 48
    .local v1, "cardNumbers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 51
    .local v8, "numberConfidence":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getCardNumber()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 52
    const-string/jumbo v9, "0.9"

    invoke-virtual {v8, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 55
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getAlternateCardNumbers()Ljava/util/List;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 56
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getAlternateCardNumbers()Ljava/util/List;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 57
    .local v0, "cardNumber":Ljava/lang/String;
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 58
    const-string/jumbo v9, "0.7"

    invoke-virtual {v8, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 63
    .end local v0    # "cardNumber":Ljava/lang/String;
    .end local v6    # "i$":Ljava/util/Iterator;
    :cond_0
    new-instance v7, Landroid/content/Intent;

    invoke-direct {v7}, Landroid/content/Intent;-><init>()V

    .line 64
    .local v7, "intent":Landroid/content/Intent;
    const-string/jumbo v9, "CARD_NUMBERS"

    invoke-virtual {v7, v9, v1}, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 66
    const-string/jumbo v9, "NUMBER_CONFIDENCE"

    invoke-virtual {v7, v9, v8}, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 70
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getExpirationDate()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    if-lez v9, :cond_2

    .line 71
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 72
    .local v4, "expirationMonths":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 73
    .local v5, "expirationYears":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 76
    .local v2, "expirationConfidence":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getExpirationDate()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9, v4, v5}, Lcom/creditcardreader/utils/CreditCardUtils;->addExpirationDates(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 78
    const-string/jumbo v9, "0.9"

    invoke-virtual {v2, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 81
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getAlternateExpirationDates()Ljava/util/List;

    move-result-object v9

    if-eqz v9, :cond_1

    .line 82
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;->getAlternateExpirationDates()Ljava/util/List;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .restart local v6    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 83
    .local v3, "expirationDate":Ljava/lang/String;
    invoke-static {v3, v4, v5}, Lcom/creditcardreader/utils/CreditCardUtils;->addExpirationDates(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 85
    const-string/jumbo v9, "0.7"

    invoke-virtual {v2, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 89
    .end local v3    # "expirationDate":Ljava/lang/String;
    .end local v6    # "i$":Ljava/util/Iterator;
    :cond_1
    const-string/jumbo v9, "CARD_EXPIRATION_MONTHS"

    invoke-virtual {v7, v9, v4}, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 91
    const-string/jumbo v9, "CARD_EXPIRATION_YEARS"

    invoke-virtual {v7, v9, v5}, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 93
    const-string/jumbo v9, "EXPIRAITON_CONFIDENCE"

    invoke-virtual {v7, v9, v2}, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 97
    .end local v2    # "expirationConfidence":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v4    # "expirationMonths":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v5    # "expirationYears":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_2
    return-object v7
.end method

.method public static setResources(Landroid/content/res/Resources;)V
    .locals 0
    .param p0, "resources"    # Landroid/content/res/Resources;

    .prologue
    .line 117
    sput-object p0, Lcom/creditcardreader/utils/CreditCardUtils;->sResources:Landroid/content/res/Resources;

    .line 118
    return-void
.end method
