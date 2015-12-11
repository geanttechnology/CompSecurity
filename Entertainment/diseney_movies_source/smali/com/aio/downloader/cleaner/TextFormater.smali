.class public Lcom/aio/downloader/cleaner/TextFormater;
.super Ljava/lang/Object;
.source "TextFormater.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static dataSizeFormat(J)Ljava/lang/String;
    .locals 7
    .param p0, "size"    # J

    .prologue
    .line 9
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v4, "####.00"

    invoke-direct {v0, v4}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 10
    .local v0, "formater":Ljava/text/DecimalFormat;
    const-wide/16 v4, 0x400

    cmp-long v4, p0, v4

    if-gez v4, :cond_0

    .line 12
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {p0, p1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "byte"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 31
    :goto_0
    return-object v4

    .line 14
    :cond_0
    const-wide/32 v4, 0x100000

    cmp-long v4, p0, v4

    if-gez v4, :cond_1

    .line 16
    const/16 v4, 0xa

    shr-long v4, p0, v4

    long-to-float v2, v4

    .line 17
    .local v2, "kSize":F
    new-instance v4, Ljava/lang/StringBuilder;

    float-to-double v5, v2

    invoke-virtual {v0, v5, v6}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "KB"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 19
    .end local v2    # "kSize":F
    :cond_1
    const-wide/32 v4, 0x40000000

    cmp-long v4, p0, v4

    if-gez v4, :cond_2

    .line 21
    const/16 v4, 0x14

    shr-long v4, p0, v4

    long-to-float v3, v4

    .line 22
    .local v3, "mSize":F
    new-instance v4, Ljava/lang/StringBuilder;

    float-to-double v5, v3

    invoke-virtual {v0, v5, v6}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "MB"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 24
    .end local v3    # "mSize":F
    :cond_2
    const-wide/16 v4, 0x100

    cmp-long v4, p0, v4

    if-gez v4, :cond_3

    .line 26
    const/16 v4, 0x1e

    shr-long v4, p0, v4

    long-to-float v1, v4

    .line 27
    .local v1, "gSize":F
    new-instance v4, Ljava/lang/StringBuilder;

    float-to-double v5, v1

    invoke-virtual {v0, v5, v6}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "GB"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 31
    .end local v1    # "gSize":F
    :cond_3
    const-string v4, "size : error"

    goto :goto_0
.end method

.method public static getSizeFromKB(J)Ljava/lang/String;
    .locals 2
    .param p0, "kSize"    # J

    .prologue
    .line 37
    const/16 v0, 0xa

    shl-long v0, p0, v0

    invoke-static {v0, v1}, Lcom/aio/downloader/cleaner/TextFormater;->dataSizeFormat(J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
