.class public final Lcom/auditude/ads/util/URLUtil;
.super Ljava/lang/Object;
.source "URLUtil.java"


# direct methods
.method public static appendURLParams(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;
    .locals 4
    .param p0, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 24
    .local p1, "urlParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 54
    .end local p0    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p0

    .line 29
    .restart local p0    # "url":Ljava/lang/String;
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, p0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 30
    .local v1, "sb":Ljava/lang/StringBuilder;
    const-string v2, "?"

    invoke-virtual {p0, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-gez v2, :cond_2

    .line 32
    const-string v2, "?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 35
    :cond_2
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 36
    const-string v2, "&"

    invoke-virtual {p0, v2}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-eq v2, v3, :cond_3

    const-string v2, "?"

    invoke-virtual {p0, v2}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-eq v2, v3, :cond_3

    .line 38
    const-string v2, "&"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 41
    :cond_3
    invoke-virtual {p1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_4

    .line 52
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    .line 54
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 41
    :cond_4
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 43
    .local v0, "kvp":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 44
    const-string v2, "="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 45
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 47
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Lcom/auditude/ads/util/URLUtil;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 49
    :cond_5
    const-string v2, "&"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1
.end method

.method public static isIPAddress(Ljava/lang/String;)Z
    .locals 9
    .param p0, "ipAddress"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 77
    invoke-static {p0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 107
    :cond_0
    :goto_0
    return v5

    .line 80
    :cond_1
    const-string v6, ":"

    invoke-virtual {p0, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 81
    .local v0, "colonIndex":I
    if-lez v0, :cond_2

    invoke-virtual {p0, v5, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    .line 83
    :cond_2
    const-string v6, "\\."

    invoke-virtual {p0, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 85
    .local v3, "parts":[Ljava/lang/String;
    array-length v6, v3

    const/4 v7, 0x4

    if-ne v6, v7, :cond_0

    .line 92
    :try_start_0
    array-length v7, v3

    move v6, v5

    :goto_1
    if-lt v6, v7, :cond_3

    .line 107
    const/4 v5, 0x1

    goto :goto_0

    .line 92
    :cond_3
    aget-object v4, v3, v6

    .line 94
    .local v4, "s":Ljava/lang/String;
    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 96
    .local v1, "i":I
    if-ltz v1, :cond_0

    const/16 v8, 0xff

    if-gt v1, v8, :cond_0

    .line 92
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 102
    .end local v1    # "i":I
    .end local v4    # "s":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 104
    .local v2, "nfe":Ljava/lang/NumberFormatException;
    goto :goto_0
.end method

.method public static urlEncode(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 10
    invoke-static {p0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 p0, 0x0

    .line 18
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    :goto_0
    return-object p0

    .line 14
    .end local v0    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_0
    :try_start_0
    const-string v1, "UTF-8"

    invoke-static {p0, v1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p0

    goto :goto_0

    .line 16
    :catch_0
    move-exception v0

    .line 18
    .restart local v0    # "e":Ljava/io/UnsupportedEncodingException;
    goto :goto_0
.end method
