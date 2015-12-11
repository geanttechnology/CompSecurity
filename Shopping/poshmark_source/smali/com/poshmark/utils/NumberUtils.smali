.class public Lcom/poshmark/utils/NumberUtils;
.super Ljava/lang/Object;
.source "NumberUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getBigDecimalAsGroupedString(Ljava/math/BigDecimal;II)Ljava/lang/String;
    .locals 2
    .param p0, "number"    # Ljava/math/BigDecimal;
    .param p1, "minFractionDigits"    # I
    .param p2, "maxFractionDigits"    # I

    .prologue
    .line 20
    new-instance v0, Ljava/text/DecimalFormat;

    invoke-direct {v0}, Ljava/text/DecimalFormat;-><init>()V

    .line 21
    .local v0, "df":Ljava/text/DecimalFormat;
    invoke-virtual {v0, p2}, Ljava/text/DecimalFormat;->setMaximumFractionDigits(I)V

    .line 22
    invoke-virtual {v0, p1}, Ljava/text/DecimalFormat;->setMinimumFractionDigits(I)V

    .line 23
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/text/DecimalFormat;->setGroupingUsed(Z)V

    .line 24
    invoke-virtual {v0, p0}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static getIntegerAsGroupedString(I)Ljava/lang/String;
    .locals 4
    .param p0, "number"    # I

    .prologue
    const/4 v1, 0x0

    .line 12
    new-instance v0, Ljava/text/DecimalFormat;

    invoke-direct {v0}, Ljava/text/DecimalFormat;-><init>()V

    .line 13
    .local v0, "df":Ljava/text/DecimalFormat;
    invoke-virtual {v0, v1}, Ljava/text/DecimalFormat;->setMaximumFractionDigits(I)V

    .line 14
    invoke-virtual {v0, v1}, Ljava/text/DecimalFormat;->setMinimumFractionDigits(I)V

    .line 15
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/text/DecimalFormat;->setGroupingUsed(Z)V

    .line 16
    int-to-long v2, p0

    invoke-virtual {v0, v2, v3}, Ljava/text/DecimalFormat;->format(J)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
