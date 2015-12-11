.class public Lcom/poshmark/utils/CurrencyUtils;
.super Ljava/lang/Object;
.source "CurrencyUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getCurrencyCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    const-string v0, "USD"

    return-object v0
.end method

.method public static getCurrencySymbol()Ljava/lang/String;
    .locals 1

    .prologue
    .line 11
    const-string v0, "$"

    return-object v0
.end method

.method public static getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;
    .locals 3
    .param p0, "price"    # Ljava/math/BigDecimal;

    .prologue
    const/4 v2, 0x2

    .line 23
    new-instance v0, Ljava/text/DecimalFormat;

    invoke-direct {v0}, Ljava/text/DecimalFormat;-><init>()V

    .line 24
    .local v0, "df":Ljava/text/DecimalFormat;
    invoke-virtual {v0, v2}, Ljava/text/DecimalFormat;->setMaximumFractionDigits(I)V

    .line 25
    invoke-virtual {v0, v2}, Ljava/text/DecimalFormat;->setMinimumFractionDigits(I)V

    .line 26
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Ljava/text/DecimalFormat;->setGroupingUsed(Z)V

    .line 27
    invoke-virtual {v0, p0}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 28
    .local v1, "result":Ljava/lang/String;
    return-object v1
.end method

.method public static getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;
    .locals 3
    .param p0, "price"    # Ljava/math/BigDecimal;

    .prologue
    const/4 v2, 0x0

    .line 32
    new-instance v0, Ljava/text/DecimalFormat;

    invoke-direct {v0}, Ljava/text/DecimalFormat;-><init>()V

    .line 33
    .local v0, "df":Ljava/text/DecimalFormat;
    invoke-virtual {v0, v2}, Ljava/text/DecimalFormat;->setMaximumFractionDigits(I)V

    .line 34
    invoke-virtual {v0, v2}, Ljava/text/DecimalFormat;->setMinimumFractionDigits(I)V

    .line 35
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Ljava/text/DecimalFormat;->setGroupingUsed(Z)V

    .line 36
    invoke-virtual {v0, p0}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 37
    .local v1, "result":Ljava/lang/String;
    return-object v1
.end method
