.class public Lcom/github/ignition/support/IgnitedStrings;
.super Ljava/lang/Object;
.source "IgnitedStrings.java"


# direct methods
.method private static splitByCharacterType(Ljava/lang/String;Z)[Ljava/lang/String;
    .locals 9
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "camelCase"    # Z

    .prologue
    .line 91
    if-nez p0, :cond_0

    .line 92
    const/4 v7, 0x0

    .line 120
    :goto_0
    return-object v7

    .line 94
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v7

    if-nez v7, :cond_1

    .line 95
    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/String;

    goto :goto_0

    .line 97
    :cond_1
    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    .line 98
    .local v0, "c":[C
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 99
    .local v2, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v5, 0x0

    .line 100
    .local v5, "tokenStart":I
    aget-char v7, v0, v5

    invoke-static {v7}, Ljava/lang/Character;->getType(C)I

    move-result v1

    .line 101
    .local v1, "currentType":I
    add-int/lit8 v4, v5, 0x1

    .local v4, "pos":I
    :goto_1
    array-length v7, v0

    if-ge v4, v7, :cond_5

    .line 102
    aget-char v7, v0, v4

    invoke-static {v7}, Ljava/lang/Character;->getType(C)I

    move-result v6

    .line 103
    .local v6, "type":I
    if-ne v6, v1, :cond_2

    .line 101
    :goto_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 106
    :cond_2
    if-eqz p1, :cond_4

    const/4 v7, 0x2

    if-ne v6, v7, :cond_4

    const/4 v7, 0x1

    if-ne v1, v7, :cond_4

    .line 108
    add-int/lit8 v3, v4, -0x1

    .line 109
    .local v3, "newTokenStart":I
    if-eq v3, v5, :cond_3

    .line 110
    new-instance v7, Ljava/lang/String;

    sub-int v8, v3, v5

    invoke-direct {v7, v0, v5, v8}, Ljava/lang/String;-><init>([CII)V

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 111
    move v5, v3

    .line 117
    .end local v3    # "newTokenStart":I
    :cond_3
    :goto_3
    move v1, v6

    goto :goto_2

    .line 114
    :cond_4
    new-instance v7, Ljava/lang/String;

    sub-int v8, v4, v5

    invoke-direct {v7, v0, v5, v8}, Ljava/lang/String;-><init>([CII)V

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 115
    move v5, v4

    goto :goto_3

    .line 119
    .end local v6    # "type":I
    :cond_5
    new-instance v7, Ljava/lang/String;

    array-length v8, v0

    sub-int/2addr v8, v5

    invoke-direct {v7, v0, v5, v8}, Ljava/lang/String;-><init>([CII)V

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 120
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v7

    new-array v7, v7, [Ljava/lang/String;

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Ljava/lang/String;

    check-cast v7, [Ljava/lang/String;

    goto :goto_0
.end method

.method public static splitByCharacterTypeCamelCase(Ljava/lang/String;)[Ljava/lang/String;
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 67
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lcom/github/ignition/support/IgnitedStrings;->splitByCharacterType(Ljava/lang/String;Z)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static underscore(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "camelCaseString"    # Ljava/lang/String;

    .prologue
    .line 33
    invoke-static {p0}, Lcom/github/ignition/support/IgnitedStrings;->splitByCharacterTypeCamelCase(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 34
    .local v0, "words":[Ljava/lang/String;
    const-string v1, "_"

    invoke-static {v1, v0}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
