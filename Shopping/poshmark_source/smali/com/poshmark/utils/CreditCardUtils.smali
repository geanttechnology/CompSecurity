.class public Lcom/poshmark/utils/CreditCardUtils;
.super Ljava/lang/Object;
.source "CreditCardUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getCreditCardType(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "creditCardNumber"    # Ljava/lang/String;

    .prologue
    .line 69
    const v6, 0x7f060071

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 71
    .local v1, "ccString":Ljava/lang/String;
    const-string v6, " "

    const-string v7, ""

    invoke-virtual {p1, v6, v7}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    .line 72
    .local v4, "tempCCNumber":Ljava/lang/String;
    const-string v6, "-"

    const-string v7, "\'"

    invoke-virtual {v4, v6, v7}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    .line 74
    const-string v6, "^4[0-9]{12}(?:[0-9]{3})?$"

    invoke-static {v6}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v5

    .line 75
    .local v5, "visaPattern":Ljava/util/regex/Pattern;
    const-string v6, "^5[1-5][0-9]{14}$"

    invoke-static {v6}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v3

    .line 76
    .local v3, "masterCardPattern":Ljava/util/regex/Pattern;
    const-string v6, "^3[47][0-9]{13}$"

    invoke-static {v6}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    .line 77
    .local v0, "amexPattern":Ljava/util/regex/Pattern;
    const-string v6, "^(?:2131|1800|35[0-9]{3})[0-9]{11}$"

    invoke-static {v6}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v2

    .line 79
    .local v2, "discoverPattern":Ljava/util/regex/Pattern;
    invoke-virtual {v5, v4}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/regex/Matcher;->matches()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 80
    const v6, 0x7f0602c9

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 92
    .end local v1    # "ccString":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v1

    .line 82
    .restart local v1    # "ccString":Ljava/lang/String;
    :cond_1
    invoke-virtual {v3, v4}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/regex/Matcher;->matches()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 83
    const v6, 0x7f0601a3

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 85
    :cond_2
    invoke-virtual {v0, v4}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/regex/Matcher;->matches()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 86
    const v6, 0x7f060041

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 88
    :cond_3
    invoke-virtual {v2, v4}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/regex/Matcher;->matches()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 89
    const v6, 0x7f0600bd

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static getFormattedCreditCardExpirationDate(Landroid/content/Context;Lcom/poshmark/data_model/models/inner_models/CreditCard;)Ljava/lang/String;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "creditCard"    # Lcom/poshmark/data_model/models/inner_models/CreditCard;

    .prologue
    .line 96
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getNumber()Ljava/lang/String;

    move-result-object v5

    invoke-static {p0, v5}, Lcom/poshmark/utils/CreditCardUtils;->getCreditCardType(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 97
    .local v0, "cardType":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getExpirationYear()Ljava/lang/String;

    move-result-object v1

    .line 98
    .local v1, "expYearString":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    .line 99
    .local v4, "length":I
    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    const/4 v5, 0x2

    :goto_0
    invoke-virtual {v1, v5, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 100
    .local v3, "expirationYearString":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getExpirationMonth()Ljava/lang/String;

    move-result-object v2

    .line 101
    .local v2, "expirationMonthString":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    return-object v5

    .line 99
    .end local v2    # "expirationMonthString":Ljava/lang/String;
    .end local v3    # "expirationYearString":Ljava/lang/String;
    :cond_0
    const/4 v5, 0x0

    goto :goto_0
.end method

.method public static getStringFromCreditCard(Landroid/content/Context;Lcom/poshmark/data_model/models/inner_models/CreditCard;)Ljava/lang/String;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "creditCard"    # Lcom/poshmark/data_model/models/inner_models/CreditCard;

    .prologue
    const/4 v7, 0x4

    .line 15
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getNumber()Ljava/lang/String;

    move-result-object v6

    invoke-static {p0, v6}, Lcom/poshmark/utils/CreditCardUtils;->getCreditCardType(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 16
    .local v1, "cardType":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getExpirationYear()Ljava/lang/String;

    move-result-object v2

    .line 17
    .local v2, "expYearString":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    .line 18
    .local v5, "length":I
    if-ne v5, v7, :cond_1

    const/4 v6, 0x2

    :goto_0
    invoke-virtual {v2, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 19
    .local v4, "expirationYearString":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getExpirationMonth()Ljava/lang/String;

    move-result-object v3

    .line 20
    .local v3, "expirationMonthString":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getNumber()Ljava/lang/String;

    move-result-object v0

    .line 21
    .local v0, "cardNumberString":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    .line 22
    if-le v5, v7, :cond_0

    .line 23
    add-int/lit8 v6, v5, -0x4

    invoke-virtual {v0, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 25
    :cond_0
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "****"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 27
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const v7, 0x7f0600cd

    invoke-virtual {p0, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\n"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const v7, 0x7f060105

    invoke-virtual {p0, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6

    .line 18
    .end local v0    # "cardNumberString":Ljava/lang/String;
    .end local v3    # "expirationMonthString":Ljava/lang/String;
    .end local v4    # "expirationYearString":Ljava/lang/String;
    :cond_1
    const/4 v6, 0x0

    goto :goto_0
.end method

.method public static getStringFromPaymentInfo(Landroid/content/Context;Lcom/poshmark/data_model/models/inner_models/PaymentInfo;)Ljava/lang/String;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "paymentInfo"    # Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    .prologue
    .line 41
    if-nez p1, :cond_0

    .line 44
    const v6, 0x7f0601cf

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 57
    :goto_0
    return-object v6

    .line 47
    :cond_0
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->getExpiryDate()Ljava/lang/String;

    move-result-object v3

    .line 48
    .local v3, "expiryString":Ljava/lang/String;
    if-eqz v3, :cond_1

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v6

    if-nez v6, :cond_2

    .line 49
    :cond_1
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->getExpirationYear()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "expYearString":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    .line 51
    .local v5, "length":I
    const/4 v6, 0x4

    if-ne v5, v6, :cond_3

    const/4 v6, 0x2

    :goto_1
    invoke-virtual {v0, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 52
    .local v2, "expirationYearString":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->getExpirationMonth()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    .line 53
    .local v1, "expirationMonthString":Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 55
    .end local v0    # "expYearString":Ljava/lang/String;
    .end local v1    # "expirationMonthString":Ljava/lang/String;
    .end local v2    # "expirationYearString":Ljava/lang/String;
    .end local v5    # "length":I
    :cond_2
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "****"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->getCreditCardLast4Digits()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 57
    .local v4, "lastFourDigitsString":Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->getCreditCardType()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const v7, 0x7f0600cd

    invoke-virtual {p0, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\n"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const v7, 0x7f060105

    invoke-virtual {p0, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_0

    .line 51
    .end local v4    # "lastFourDigitsString":Ljava/lang/String;
    .restart local v0    # "expYearString":Ljava/lang/String;
    .restart local v5    # "length":I
    :cond_3
    const/4 v6, 0x0

    goto/16 :goto_1
.end method
