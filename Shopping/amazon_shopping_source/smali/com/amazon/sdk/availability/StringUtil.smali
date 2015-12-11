.class final Lcom/amazon/sdk/availability/StringUtil;
.super Ljava/lang/Object;
.source "StringUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 118
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 119
    return-void
.end method

.method public static dateToString(Ljava/lang/Long;)Ljava/lang/String;
    .locals 5
    .param p0, "epochDate"    # Ljava/lang/Long;

    .prologue
    .line 107
    const/4 v0, 0x0

    .line 108
    .local v0, "result":Ljava/lang/String;
    if-eqz p0, :cond_0

    .line 109
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string/jumbo v2, "yyyy-MM-dd HH:mm:ss"

    invoke-direct {v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 110
    .local v1, "sdf":Ljava/text/SimpleDateFormat;
    new-instance v2, Ljava/util/Date;

    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-direct {v2, v3, v4}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 112
    .end local v1    # "sdf":Ljava/text/SimpleDateFormat;
    :cond_0
    return-object v0
.end method

.method public static isBlank(Ljava/lang/String;)Z
    .locals 1
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 35
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isEmpty(Ljava/lang/String;)Z
    .locals 1
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 25
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static join([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "arr"    # [Ljava/lang/String;
    .param p1, "delim"    # Ljava/lang/String;

    .prologue
    .line 65
    const/4 v3, 0x0

    .line 66
    .local v3, "result":Ljava/lang/String;
    if-eqz p0, :cond_3

    .line 67
    invoke-static {p1}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    const/4 v1, 0x1

    .line 68
    .local v1, "hasDelimiter":Z
    :goto_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 69
    .local v0, "buffer":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v4, p0

    if-ge v2, v4, :cond_2

    .line 70
    aget-object v4, p0, v2

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 71
    if-eqz v1, :cond_0

    array-length v4, p0

    add-int/lit8 v4, v4, -0x1

    if-ge v2, v4, :cond_0

    .line 72
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 69
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 67
    .end local v0    # "buffer":Ljava/lang/StringBuilder;
    .end local v1    # "hasDelimiter":Z
    .end local v2    # "i":I
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    .line 75
    .restart local v0    # "buffer":Ljava/lang/StringBuilder;
    .restart local v1    # "hasDelimiter":Z
    .restart local v2    # "i":I
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 77
    .end local v0    # "buffer":Ljava/lang/StringBuilder;
    .end local v1    # "hasDelimiter":Z
    .end local v2    # "i":I
    :cond_3
    return-object v3
.end method

.method public static split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    .locals 4
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "delim"    # Ljava/lang/String;

    .prologue
    .line 88
    const/4 v1, 0x0

    .line 89
    .local v1, "result":[Ljava/lang/String;
    if-eqz p0, :cond_0

    if-eqz p1, :cond_0

    .line 90
    new-instance v2, Ljava/util/StringTokenizer;

    invoke-direct {v2, p0, p1}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    .local v2, "tok":Ljava/util/StringTokenizer;
    invoke-virtual {v2}, Ljava/util/StringTokenizer;->countTokens()I

    move-result v3

    new-array v1, v3, [Ljava/lang/String;

    .line 92
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {v2}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 93
    invoke-virtual {v2}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v0

    .line 92
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 96
    .end local v0    # "i":I
    .end local v2    # "tok":Ljava/util/StringTokenizer;
    :cond_0
    return-object v1
.end method
