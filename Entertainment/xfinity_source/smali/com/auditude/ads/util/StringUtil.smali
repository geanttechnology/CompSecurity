.class public final Lcom/auditude/ads/util/StringUtil;
.super Ljava/lang/Object;
.source "StringUtil.java"


# direct methods
.method public static ConvertToKeysAndValues(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/HashMap;
    .locals 9
    .param p0, "value"    # Ljava/lang/String;
    .param p1, "pairsDelimiter"    # Ljava/lang/String;
    .param p2, "keyValueDelimiter"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 17
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 19
    .local v0, "collection":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 34
    :cond_0
    return-object v0

    .line 24
    :cond_1
    invoke-virtual {p0, p1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 25
    .local v3, "pairs":[Ljava/lang/String;
    array-length v6, v3

    move v4, v5

    :goto_0
    if-ge v4, v6, :cond_0

    aget-object v2, v3, v4

    .line 27
    .local v2, "pair":Ljava/lang/String;
    invoke-virtual {v2, p2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 28
    .local v1, "idx":I
    if-lez v1, :cond_2

    .line 30
    invoke-virtual {v2, v5, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    add-int/lit8 v8, v1, 0x1

    invoke-virtual {v2, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_0
.end method

.method public static ConvertToString(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "pairsDelimiter"    # Ljava/lang/String;
    .param p2, "keyValueDelimiter"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 39
    .local p0, "keyValues":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, ""

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 41
    .local v2, "sb":Ljava/lang/StringBuilder;
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/util/HashMap;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 43
    invoke-virtual {p0}, Ljava/util/HashMap;->size()I

    move-result v0

    .line 44
    .local v0, "count":I
    invoke-virtual {p0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 51
    .end local v0    # "count":I
    :cond_0
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 44
    .restart local v0    # "count":I
    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 46
    .local v1, "kvp":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    add-int/lit8 v0, v0, -0x1

    .line 47
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v5, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    if-gtz v0, :cond_2

    const-string v3, ""

    :goto_1
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    :cond_2
    move-object v3, p1

    goto :goto_1
.end method

.method public static convertToHHMMSS(I)Ljava/lang/String;
    .locals 4
    .param p0, "seconds"    # I

    .prologue
    .line 83
    const-string v0, "%02d:%02d:%02d.000"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    div-int/lit16 v3, p0, 0xe10

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    rem-int/lit16 v3, p0, 0xe10

    div-int/lit8 v3, v3, 0x3c

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    rem-int/lit8 v3, p0, 0x3c

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static convertToInt(Ljava/lang/String;)I
    .locals 2
    .param p0, "data"    # Ljava/lang/String;

    .prologue
    .line 73
    :try_start_0
    invoke-static {p0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    float-to-int v1, v1

    .line 77
    :goto_0
    return v1

    .line 75
    :catch_0
    move-exception v0

    .line 77
    .local v0, "nfe":Ljava/lang/NumberFormatException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static isNotNullOrEmpty(Ljava/lang/String;)Z
    .locals 1
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 12
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isNullOrEmpty(Ljava/lang/String;)Z
    .locals 1
    .param p0, "string"    # Ljava/lang/String;

    .prologue
    .line 7
    if-eqz p0, :cond_0

    const-string v0, ""

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static parseDuration(Ljava/lang/String;)I
    .locals 4
    .param p0, "duration"    # Ljava/lang/String;

    .prologue
    const/4 v1, -0x1

    .line 56
    invoke-static {p0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 66
    :goto_0
    return v1

    .line 57
    :cond_0
    const-string v2, ":"

    invoke-virtual {p0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 58
    .local v0, "parts":[Ljava/lang/String;
    array-length v2, v0

    const/4 v3, 0x3

    if-ne v2, v3, :cond_1

    .line 60
    const/4 v1, 0x0

    aget-object v1, v0, v1

    invoke-static {v1}, Lcom/auditude/ads/util/StringUtil;->convertToInt(Ljava/lang/String;)I

    move-result v1

    mul-int/lit16 v1, v1, 0xe10

    const/4 v2, 0x1

    aget-object v2, v0, v2

    invoke-static {v2}, Lcom/auditude/ads/util/StringUtil;->convertToInt(Ljava/lang/String;)I

    move-result v2

    mul-int/lit8 v2, v2, 0x3c

    add-int/2addr v1, v2

    const/4 v2, 0x2

    aget-object v2, v0, v2

    invoke-static {v2}, Lcom/auditude/ads/util/StringUtil;->convertToInt(Ljava/lang/String;)I

    move-result v2

    add-int/2addr v1, v2

    goto :goto_0

    .line 64
    :cond_1
    invoke-static {p0}, Lcom/auditude/ads/util/StringUtil;->convertToInt(Ljava/lang/String;)I

    goto :goto_0
.end method
