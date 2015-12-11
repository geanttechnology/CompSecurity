.class public Lcom/wjj/utils/CommonUtil;
.super Ljava/lang/Object;
.source "CommonUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static formatSize(J)Ljava/lang/String;
    .locals 9
    .param p0, "size"    # J

    .prologue
    const-wide/high16 v7, 0x4090000000000000L    # 1024.0

    const-wide/16 v5, 0x400

    .line 7
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v3, "#.00"

    invoke-direct {v0, v3}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 8
    .local v0, "format":Ljava/text/DecimalFormat;
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 9
    .local v1, "sb":Ljava/lang/StringBuffer;
    cmp-long v3, p0, v5

    if-gez v3, :cond_0

    .line 10
    invoke-virtual {v1, p0, p1}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    .line 11
    const-string v3, "B"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 25
    :goto_0
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 12
    :cond_0
    const-wide/32 v3, 0x100000

    cmp-long v3, p0, v3

    if-gez v3, :cond_1

    .line 13
    long-to-double v3, p0

    div-double/2addr v3, v7

    invoke-virtual {v0, v3, v4}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    .line 14
    .local v2, "str":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 15
    const-string v3, "K"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 16
    .end local v2    # "str":Ljava/lang/String;
    :cond_1
    const-wide/32 v3, 0x40000000

    cmp-long v3, p0, v3

    if-gez v3, :cond_2

    .line 17
    div-long v3, p0, v5

    long-to-double v3, v3

    div-double/2addr v3, v7

    invoke-virtual {v0, v3, v4}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    .line 18
    .restart local v2    # "str":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 19
    const-string v3, "M"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 21
    .end local v2    # "str":Ljava/lang/String;
    :cond_2
    div-long v3, p0, v5

    div-long/2addr v3, v5

    long-to-double v3, v3

    div-double/2addr v3, v7

    invoke-virtual {v0, v3, v4}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    .line 22
    .restart local v2    # "str":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 23
    const-string v3, "G"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method
