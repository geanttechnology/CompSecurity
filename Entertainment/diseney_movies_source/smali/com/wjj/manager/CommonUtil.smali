.class public Lcom/wjj/manager/CommonUtil;
.super Ljava/lang/Object;
.source "CommonUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static formatSize(J)Ljava/lang/String;
    .locals 9
    .param p0, "size"    # J

    .prologue
    const-wide/high16 v7, 0x4090000000000000L    # 1024.0

    const-wide/16 v5, 0x400

    .line 21
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v3, "#.00"

    invoke-direct {v0, v3}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 22
    .local v0, "format":Ljava/text/DecimalFormat;
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 23
    .local v1, "sb":Ljava/lang/StringBuffer;
    cmp-long v3, p0, v5

    if-gez v3, :cond_0

    .line 24
    invoke-virtual {v1, p0, p1}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    .line 35
    :goto_0
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 25
    :cond_0
    const-wide/32 v3, 0x100000

    cmp-long v3, p0, v3

    if-gez v3, :cond_1

    .line 26
    long-to-double v3, p0

    div-double/2addr v3, v7

    invoke-virtual {v0, v3, v4}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    .line 27
    .local v2, "str":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 28
    .end local v2    # "str":Ljava/lang/String;
    :cond_1
    const-wide/32 v3, 0x40000000

    cmp-long v3, p0, v3

    if-gez v3, :cond_2

    .line 29
    div-long v3, p0, v5

    long-to-double v3, v3

    div-double/2addr v3, v7

    invoke-virtual {v0, v3, v4}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    .line 30
    .restart local v2    # "str":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 32
    .end local v2    # "str":Ljava/lang/String;
    :cond_2
    div-long v3, p0, v5

    div-long/2addr v3, v5

    long-to-double v3, v3

    div-double/2addr v3, v7

    invoke-virtual {v0, v3, v4}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    .line 33
    .restart local v2    # "str":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method public static formatSizeDanwei(J)Ljava/lang/String;
    .locals 9
    .param p0, "size"    # J

    .prologue
    const-wide/high16 v7, 0x4090000000000000L    # 1024.0

    const-wide/16 v5, 0x400

    .line 40
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v3, "#.00"

    invoke-direct {v0, v3}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 41
    .local v0, "format":Ljava/text/DecimalFormat;
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 42
    .local v1, "sb":Ljava/lang/StringBuffer;
    cmp-long v3, p0, v5

    if-gez v3, :cond_0

    .line 43
    invoke-virtual {v1, p0, p1}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    .line 44
    const-string v3, "B"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 58
    :goto_0
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 45
    :cond_0
    const-wide/32 v3, 0x100000

    cmp-long v3, p0, v3

    if-gez v3, :cond_1

    .line 46
    long-to-double v3, p0

    div-double/2addr v3, v7

    invoke-virtual {v0, v3, v4}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    .line 47
    .local v2, "str":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 48
    const-string v3, "K"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 49
    .end local v2    # "str":Ljava/lang/String;
    :cond_1
    const-wide/32 v3, 0x40000000

    cmp-long v3, p0, v3

    if-gez v3, :cond_2

    .line 50
    div-long v3, p0, v5

    long-to-double v3, v3

    div-double/2addr v3, v7

    invoke-virtual {v0, v3, v4}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    .line 51
    .restart local v2    # "str":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 52
    const-string v3, "M"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 54
    .end local v2    # "str":Ljava/lang/String;
    :cond_2
    div-long v3, p0, v5

    div-long/2addr v3, v5

    long-to-double v3, v3

    div-double/2addr v3, v7

    invoke-virtual {v0, v3, v4}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    .line 55
    .restart local v2    # "str":Ljava/lang/String;
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 56
    const-string v3, "G"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method public static formatSizeDanweiTwo(J)Ljava/lang/String;
    .locals 3
    .param p0, "size"    # J

    .prologue
    .line 62
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 63
    .local v0, "sb":Ljava/lang/StringBuffer;
    const-wide/16 v1, 0x400

    cmp-long v1, p0, v1

    if-gez v1, :cond_0

    .line 64
    const-string v1, "B"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 72
    :goto_0
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 65
    :cond_0
    const-wide/32 v1, 0x100000

    cmp-long v1, p0, v1

    if-gez v1, :cond_1

    .line 66
    const-string v1, "KB"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 67
    :cond_1
    const-wide/32 v1, 0x40000000

    cmp-long v1, p0, v1

    if-gez v1, :cond_2

    .line 68
    const-string v1, "MB"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 70
    :cond_2
    const-string v1, "GB"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method public static getCurTime()Ljava/lang/String;
    .locals 3

    .prologue
    .line 9
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 10
    .local v0, "data":Ljava/util/Date;
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "yyyyMMddHHmmss"

    invoke-direct {v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 11
    .local v1, "sdf":Ljava/text/SimpleDateFormat;
    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static getCurTime(J)Ljava/lang/String;
    .locals 3
    .param p0, "time"    # J

    .prologue
    .line 15
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0, p0, p1}, Ljava/util/Date;-><init>(J)V

    .line 16
    .local v0, "data":Ljava/util/Date;
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "yyyy-MM-dd HH:mm:ss"

    invoke-direct {v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 17
    .local v1, "sdf":Ljava/text/SimpleDateFormat;
    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
