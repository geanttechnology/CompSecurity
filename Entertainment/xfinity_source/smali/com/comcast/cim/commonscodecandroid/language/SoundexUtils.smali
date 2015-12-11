.class final Lcom/comcast/cim/commonscodecandroid/language/SoundexUtils;
.super Ljava/lang/Object;
.source "SoundexUtils.java"


# direct methods
.method static clean(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 41
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_1

    .line 55
    .end local p0    # "str":Ljava/lang/String;
    .local v0, "chars":[C
    .local v2, "count":I
    .local v3, "i":I
    .local v4, "len":I
    :cond_0
    :goto_0
    return-object p0

    .line 44
    .end local v0    # "chars":[C
    .end local v2    # "count":I
    .end local v3    # "i":I
    .end local v4    # "len":I
    .restart local p0    # "str":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    .line 45
    .restart local v4    # "len":I
    new-array v0, v4, [C

    .line 46
    .restart local v0    # "chars":[C
    const/4 v1, 0x0

    .line 47
    .local v1, "count":I
    const/4 v3, 0x0

    .restart local v3    # "i":I
    move v2, v1

    .end local v1    # "count":I
    .restart local v2    # "count":I
    :goto_1
    if-ge v3, v4, :cond_2

    .line 48
    invoke-virtual {p0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v5

    invoke-static {v5}, Ljava/lang/Character;->isLetter(C)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 49
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "count":I
    .restart local v1    # "count":I
    invoke-virtual {p0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v5

    aput-char v5, v0, v2

    .line 47
    :goto_2
    add-int/lit8 v3, v3, 0x1

    move v2, v1

    .end local v1    # "count":I
    .restart local v2    # "count":I
    goto :goto_1

    .line 52
    :cond_2
    if-ne v2, v4, :cond_3

    .line 53
    sget-object v5, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {p0, v5}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 55
    :cond_3
    new-instance v5, Ljava/lang/String;

    const/4 v6, 0x0

    invoke-direct {v5, v0, v6, v2}, Ljava/lang/String;-><init>([CII)V

    sget-object v6, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v5, v6}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    :cond_4
    move v1, v2

    .end local v2    # "count":I
    .restart local v1    # "count":I
    goto :goto_2
.end method
