.class public abstract Lorg/springframework/util/StringUtils;
.super Ljava/lang/Object;
.source "StringUtils.java"


# direct methods
.method public static hasLength(Ljava/lang/CharSequence;)Z
    .locals 1
    .param p0, "str"    # Ljava/lang/CharSequence;

    .prologue
    .line 85
    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static hasLength(Ljava/lang/String;)Z
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 96
    invoke-static {p0}, Lorg/springframework/util/StringUtils;->hasLength(Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method

.method public static toStringArray(Ljava/util/Collection;)[Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)[",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 797
    .local p0, "collection":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    if-nez p0, :cond_0

    .line 798
    const/4 v0, 0x0

    .line 800
    :goto_0
    return-object v0

    :cond_0
    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v0

    new-array v0, v0, [Ljava/lang/String;

    invoke-interface {p0, v0}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    goto :goto_0
.end method

.method public static tokenizeToStringArray(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    .locals 1
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "delimiters"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    .line 940
    invoke-static {p0, p1, v0, v0}, Lorg/springframework/util/StringUtils;->tokenizeToStringArray(Ljava/lang/String;Ljava/lang/String;ZZ)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static tokenizeToStringArray(Ljava/lang/String;Ljava/lang/String;ZZ)[Ljava/lang/String;
    .locals 4
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "delimiters"    # Ljava/lang/String;
    .param p2, "trimTokens"    # Z
    .param p3, "ignoreEmptyTokens"    # Z

    .prologue
    .line 965
    if-nez p0, :cond_0

    .line 966
    const/4 v3, 0x0

    .line 979
    :goto_0
    return-object v3

    .line 968
    :cond_0
    new-instance v0, Ljava/util/StringTokenizer;

    invoke-direct {v0, p0, p1}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 969
    .local v0, "st":Ljava/util/StringTokenizer;
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 970
    .local v2, "tokens":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_1
    :goto_1
    invoke-virtual {v0}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 971
    invoke-virtual {v0}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v1

    .line 972
    .local v1, "token":Ljava/lang/String;
    if-eqz p2, :cond_2

    .line 973
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 975
    :cond_2
    if-eqz p3, :cond_3

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_1

    .line 976
    :cond_3
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 979
    .end local v1    # "token":Ljava/lang/String;
    :cond_4
    invoke-static {v2}, Lorg/springframework/util/StringUtils;->toStringArray(Ljava/util/Collection;)[Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method
