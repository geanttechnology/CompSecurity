.class public Lorg/apache/commons/lang3/StringUtils;
.super Ljava/lang/Object;
.source "StringUtils.java"


# static fields
.field private static final WHITESPACE_BLOCK:Ljava/util/regex/Pattern;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 148
    const-string v0, "\\s+"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/StringUtils;->WHITESPACE_BLOCK:Ljava/util/regex/Pattern;

    return-void
.end method

.method public static indexOfIgnoreCase(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)I
    .locals 1
    .param p0, "str"    # Ljava/lang/CharSequence;
    .param p1, "searchStr"    # Ljava/lang/CharSequence;

    .prologue
    .line 1048
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lorg/apache/commons/lang3/StringUtils;->indexOfIgnoreCase(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)I

    move-result v0

    return v0
.end method

.method public static indexOfIgnoreCase(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)I
    .locals 8
    .param p0, "str"    # Ljava/lang/CharSequence;
    .param p1, "searchStr"    # Ljava/lang/CharSequence;
    .param p2, "startPos"    # I

    .prologue
    const/4 v7, -0x1

    .line 1084
    if-eqz p0, :cond_0

    if-nez p1, :cond_2

    :cond_0
    move v2, v7

    .line 1102
    :cond_1
    :goto_0
    return v2

    .line 1087
    :cond_2
    if-gez p2, :cond_3

    .line 1088
    const/4 p2, 0x0

    .line 1090
    :cond_3
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    sub-int/2addr v0, v1

    add-int/lit8 v6, v0, 0x1

    .line 1091
    .local v6, "endLimit":I
    if-le p2, v6, :cond_4

    move v2, v7

    .line 1092
    goto :goto_0

    .line 1094
    :cond_4
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-nez v0, :cond_5

    move v2, p2

    .line 1095
    goto :goto_0

    .line 1097
    :cond_5
    move v2, p2

    .local v2, "i":I
    :goto_1
    if-ge v2, v6, :cond_6

    .line 1098
    const/4 v1, 0x1

    const/4 v4, 0x0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v5

    move-object v0, p0

    move-object v3, p1

    invoke-static/range {v0 .. v5}, Lorg/apache/commons/lang3/CharSequenceUtils;->regionMatches(Ljava/lang/CharSequence;ZILjava/lang/CharSequence;II)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1097
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_6
    move v2, v7

    .line 1102
    goto :goto_0
.end method

.method public static isBlank(Ljava/lang/CharSequence;)Z
    .locals 4
    .param p0, "cs"    # Ljava/lang/CharSequence;

    .prologue
    const/4 v2, 0x1

    .line 224
    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    .local v1, "strLen":I
    if-nez v1, :cond_1

    .line 232
    .end local v1    # "strLen":I
    :cond_0
    :goto_0
    return v2

    .line 227
    .restart local v1    # "strLen":I
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v1, :cond_0

    .line 228
    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    invoke-static {v3}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v3

    if-nez v3, :cond_2

    .line 229
    const/4 v2, 0x0

    goto :goto_0

    .line 227
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static isEmpty(Ljava/lang/CharSequence;)Z
    .locals 1
    .param p0, "cs"    # Ljava/lang/CharSequence;

    .prologue
    .line 184
    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

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

.method public static join([Ljava/lang/Object;C)Ljava/lang/String;
    .locals 2
    .param p0, "array"    # [Ljava/lang/Object;
    .param p1, "separator"    # C

    .prologue
    .line 3265
    if-nez p0, :cond_0

    .line 3266
    const/4 v0, 0x0

    .line 3269
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, p1, v0, v1}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;CII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static join([Ljava/lang/Object;CII)Ljava/lang/String;
    .locals 4
    .param p0, "array"    # [Ljava/lang/Object;
    .param p1, "separator"    # C
    .param p2, "startIndex"    # I
    .param p3, "endIndex"    # I

    .prologue
    .line 3299
    if-nez p0, :cond_0

    .line 3300
    const/4 v3, 0x0

    .line 3317
    :goto_0
    return-object v3

    .line 3302
    :cond_0
    sub-int v2, p3, p2

    .line 3303
    .local v2, "noOfItems":I
    if-gtz v2, :cond_1

    .line 3304
    const-string v3, ""

    goto :goto_0

    .line 3307
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    mul-int/lit8 v3, v2, 0x10

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 3309
    .local v0, "buf":Ljava/lang/StringBuilder;
    move v1, p2

    .local v1, "i":I
    :goto_1
    if-ge v1, p3, :cond_4

    .line 3310
    if-le v1, p2, :cond_2

    .line 3311
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 3313
    :cond_2
    aget-object v3, p0, v1

    if-eqz v3, :cond_3

    .line 3314
    aget-object v3, p0, v1

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 3309
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 3317
    :cond_4
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public static join([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "array"    # [Ljava/lang/Object;
    .param p1, "separator"    # Ljava/lang/String;

    .prologue
    .line 3344
    if-nez p0, :cond_0

    .line 3345
    const/4 v0, 0x0

    .line 3347
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, p1, v0, v1}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static join([Ljava/lang/Object;Ljava/lang/String;II)Ljava/lang/String;
    .locals 4
    .param p0, "array"    # [Ljava/lang/Object;
    .param p1, "separator"    # Ljava/lang/String;
    .param p2, "startIndex"    # I
    .param p3, "endIndex"    # I

    .prologue
    .line 3378
    if-nez p0, :cond_0

    .line 3379
    const/4 v3, 0x0

    .line 3402
    :goto_0
    return-object v3

    .line 3381
    :cond_0
    if-nez p1, :cond_1

    .line 3382
    const-string p1, ""

    .line 3387
    :cond_1
    sub-int v2, p3, p2

    .line 3388
    .local v2, "noOfItems":I
    if-gtz v2, :cond_2

    .line 3389
    const-string v3, ""

    goto :goto_0

    .line 3392
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    mul-int/lit8 v3, v2, 0x10

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 3394
    .local v0, "buf":Ljava/lang/StringBuilder;
    move v1, p2

    .local v1, "i":I
    :goto_1
    if-ge v1, p3, :cond_5

    .line 3395
    if-le v1, p2, :cond_3

    .line 3396
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3398
    :cond_3
    aget-object v3, p0, v1

    if-eqz v3, :cond_4

    .line 3399
    aget-object v3, p0, v1

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 3394
    :cond_4
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 3402
    :cond_5
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public static leftPad(Ljava/lang/String;IC)Ljava/lang/String;
    .locals 2
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "size"    # I
    .param p2, "padChar"    # C

    .prologue
    .line 4718
    if-nez p0, :cond_1

    .line 4719
    const/4 p0, 0x0

    .line 4728
    .end local p0    # "str":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p0

    .line 4721
    .restart local p0    # "str":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    sub-int v0, p1, v1

    .line 4722
    .local v0, "pads":I
    if-lez v0, :cond_0

    .line 4725
    const/16 v1, 0x2000

    if-le v0, v1, :cond_2

    .line 4726
    invoke-static {p2}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, p1, v1}, Lorg/apache/commons/lang3/StringUtils;->leftPad(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 4728
    :cond_2
    invoke-static {p2, v0}, Lorg/apache/commons/lang3/StringUtils;->repeat(CI)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    goto :goto_0
.end method

.method public static leftPad(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "size"    # I
    .param p2, "padStr"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    .line 4755
    if-nez p0, :cond_1

    .line 4756
    const/4 p0, 0x0

    .line 4781
    .end local p0    # "str":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p0

    .line 4758
    .restart local p0    # "str":Ljava/lang/String;
    :cond_1
    invoke-static {p2}, Lorg/apache/commons/lang3/StringUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 4759
    const-string p2, " "

    .line 4761
    :cond_2
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    .line 4762
    .local v2, "padLen":I
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v5

    .line 4763
    .local v5, "strLen":I
    sub-int v4, p1, v5

    .line 4764
    .local v4, "pads":I
    if-lez v4, :cond_0

    .line 4767
    const/4 v6, 0x1

    if-ne v2, v6, :cond_3

    const/16 v6, 0x2000

    if-gt v4, v6, :cond_3

    .line 4768
    invoke-virtual {p2, v7}, Ljava/lang/String;->charAt(I)C

    move-result v6

    invoke-static {p0, p1, v6}, Lorg/apache/commons/lang3/StringUtils;->leftPad(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 4771
    :cond_3
    if-ne v4, v2, :cond_4

    .line 4772
    invoke-virtual {p2, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 4773
    :cond_4
    if-ge v4, v2, :cond_5

    .line 4774
    invoke-virtual {p2, v7, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 4776
    :cond_5
    new-array v3, v4, [C

    .line 4777
    .local v3, "padding":[C
    invoke-virtual {p2}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    .line 4778
    .local v1, "padChars":[C
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v4, :cond_6

    .line 4779
    rem-int v6, v0, v2

    aget-char v6, v1, v6

    aput-char v6, v3, v0

    .line 4778
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 4781
    :cond_6
    new-instance v6, Ljava/lang/String;

    invoke-direct {v6, v3}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v6, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    goto :goto_0
.end method

.method public static normalizeSpace(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 6528
    if-nez p0, :cond_0

    .line 6529
    const/4 v0, 0x0

    .line 6531
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lorg/apache/commons/lang3/StringUtils;->WHITESPACE_BLOCK:Ljava/util/regex/Pattern;

    invoke-static {p0}, Lorg/apache/commons/lang3/StringUtils;->trim(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/util/regex/Matcher;->replaceAll(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static remove(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "remove"    # Ljava/lang/String;

    .prologue
    .line 3736
    invoke-static {p0}, Lorg/apache/commons/lang3/StringUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1}, Lorg/apache/commons/lang3/StringUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 3739
    .end local p0    # "str":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p0

    .restart local p0    # "str":Ljava/lang/String;
    :cond_1
    const-string v0, ""

    const/4 v1, -0x1

    invoke-static {p0, p1, v0, v1}, Lorg/apache/commons/lang3/StringUtils;->replace(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object p0

    goto :goto_0
.end method

.method public static repeat(CI)Ljava/lang/String;
    .locals 3
    .param p0, "ch"    # C
    .param p1, "repeat"    # I

    .prologue
    .line 4554
    new-array v0, p1, [C

    .line 4555
    .local v0, "buf":[C
    add-int/lit8 v1, p1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_0

    .line 4556
    aput-char p0, v0, v1

    .line 4555
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 4558
    :cond_0
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v0}, Ljava/lang/String;-><init>([C)V

    return-object v2
.end method

.method public static repeat(Ljava/lang/String;I)Ljava/lang/String;
    .locals 10
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "repeat"    # I

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 4465
    if-nez p0, :cond_1

    .line 4466
    const/4 p0, 0x0

    .line 4497
    .end local p0    # "str":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p0

    .line 4468
    .restart local p0    # "str":Ljava/lang/String;
    :cond_1
    if-gtz p1, :cond_2

    .line 4469
    const-string p0, ""

    goto :goto_0

    .line 4471
    :cond_2
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    .line 4472
    .local v4, "inputLength":I
    if-eq p1, v9, :cond_0

    if-eqz v4, :cond_0

    .line 4475
    if-ne v4, v9, :cond_3

    const/16 v7, 0x2000

    if-gt p1, v7, :cond_3

    .line 4476
    invoke-virtual {p0, v8}, Ljava/lang/String;->charAt(I)C

    move-result v7

    invoke-static {v7, p1}, Lorg/apache/commons/lang3/StringUtils;->repeat(CI)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 4479
    :cond_3
    mul-int v6, v4, p1

    .line 4480
    .local v6, "outputLength":I
    packed-switch v4, :pswitch_data_0

    .line 4493
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v6}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 4494
    .local v0, "buf":Ljava/lang/StringBuilder;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    if-ge v3, p1, :cond_5

    .line 4495
    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 4494
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 4482
    .end local v0    # "buf":Ljava/lang/StringBuilder;
    .end local v3    # "i":I
    :pswitch_0
    invoke-virtual {p0, v8}, Ljava/lang/String;->charAt(I)C

    move-result v7

    invoke-static {v7, p1}, Lorg/apache/commons/lang3/StringUtils;->repeat(CI)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 4484
    :pswitch_1
    invoke-virtual {p0, v8}, Ljava/lang/String;->charAt(I)C

    move-result v1

    .line 4485
    .local v1, "ch0":C
    invoke-virtual {p0, v9}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 4486
    .local v2, "ch1":C
    new-array v5, v6, [C

    .line 4487
    .local v5, "output2":[C
    mul-int/lit8 v7, p1, 0x2

    add-int/lit8 v3, v7, -0x2

    .restart local v3    # "i":I
    :goto_2
    if-ltz v3, :cond_4

    .line 4488
    aput-char v1, v5, v3

    .line 4489
    add-int/lit8 v7, v3, 0x1

    aput-char v2, v5, v7

    .line 4487
    add-int/lit8 v3, v3, -0x1

    add-int/lit8 v3, v3, -0x1

    goto :goto_2

    .line 4491
    :cond_4
    new-instance p0, Ljava/lang/String;

    .end local p0    # "str":Ljava/lang/String;
    invoke-direct {p0, v5}, Ljava/lang/String;-><init>([C)V

    goto :goto_0

    .line 4497
    .end local v1    # "ch0":C
    .end local v2    # "ch1":C
    .end local v5    # "output2":[C
    .restart local v0    # "buf":Ljava/lang/StringBuilder;
    .restart local p0    # "str":Ljava/lang/String;
    :cond_5
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 4480
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static replace(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    .locals 8
    .param p0, "text"    # Ljava/lang/String;
    .param p1, "searchString"    # Ljava/lang/String;
    .param p2, "replacement"    # Ljava/lang/String;
    .param p3, "max"    # I

    .prologue
    const/16 v5, 0x40

    const/4 v7, -0x1

    .line 3860
    invoke-static {p0}, Lorg/apache/commons/lang3/StringUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    invoke-static {p1}, Lorg/apache/commons/lang3/StringUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    if-eqz p2, :cond_0

    if-nez p3, :cond_1

    .line 3882
    .end local p0    # "text":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p0

    .line 3863
    .restart local p0    # "text":Ljava/lang/String;
    :cond_1
    const/4 v4, 0x0

    .line 3864
    .local v4, "start":I
    invoke-virtual {p0, p1, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v1

    .line 3865
    .local v1, "end":I
    if-eq v1, v7, :cond_0

    .line 3868
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    .line 3869
    .local v3, "replLength":I
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v6

    sub-int v2, v6, v3

    .line 3870
    .local v2, "increase":I
    if-gez v2, :cond_2

    const/4 v2, 0x0

    .line 3871
    :cond_2
    if-gez p3, :cond_5

    const/16 v5, 0x10

    :cond_3
    :goto_1
    mul-int/2addr v2, v5

    .line 3872
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v5

    add-int/2addr v5, v2

    invoke-direct {v0, v5}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 3873
    .local v0, "buf":Ljava/lang/StringBuilder;
    :goto_2
    if-eq v1, v7, :cond_4

    .line 3874
    invoke-virtual {p0, v4, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3875
    add-int v4, v1, v3

    .line 3876
    add-int/lit8 p3, p3, -0x1

    if-nez p3, :cond_6

    .line 3881
    :cond_4
    invoke-virtual {p0, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3882
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 3871
    .end local v0    # "buf":Ljava/lang/StringBuilder;
    :cond_5
    if-gt p3, v5, :cond_3

    move v5, p3

    goto :goto_1

    .line 3879
    .restart local v0    # "buf":Ljava/lang/StringBuilder;
    :cond_6
    invoke-virtual {p0, p1, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v1

    goto :goto_2
.end method

.method public static split(Ljava/lang/String;)[Ljava/lang/String;
    .locals 2
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 2536
    const/4 v0, 0x0

    const/4 v1, -0x1

    invoke-static {p0, v0, v1}, Lorg/apache/commons/lang3/StringUtils;->split(Ljava/lang/String;Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static split(Ljava/lang/String;C)[Ljava/lang/String;
    .locals 1
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "separatorChar"    # C

    .prologue
    .line 2564
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lorg/apache/commons/lang3/StringUtils;->splitWorker(Ljava/lang/String;CZ)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    .locals 2
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "separatorChars"    # Ljava/lang/String;

    .prologue
    .line 2593
    const/4 v0, -0x1

    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Lorg/apache/commons/lang3/StringUtils;->splitWorker(Ljava/lang/String;Ljava/lang/String;IZ)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static split(Ljava/lang/String;Ljava/lang/String;I)[Ljava/lang/String;
    .locals 1
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "separatorChars"    # Ljava/lang/String;
    .param p2, "max"    # I

    .prologue
    .line 2627
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lorg/apache/commons/lang3/StringUtils;->splitWorker(Ljava/lang/String;Ljava/lang/String;IZ)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static splitWorker(Ljava/lang/String;CZ)[Ljava/lang/String;
    .locals 7
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "separatorChar"    # C
    .param p2, "preserveAllTokens"    # Z

    .prologue
    .line 2910
    if-nez p0, :cond_0

    .line 2911
    const/4 v6, 0x0

    .line 2938
    :goto_0
    return-object v6

    .line 2913
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .line 2914
    .local v2, "len":I
    if-nez v2, :cond_1

    .line 2915
    sget-object v6, Lorg/apache/commons/lang3/ArrayUtils;->EMPTY_STRING_ARRAY:[Ljava/lang/String;

    goto :goto_0

    .line 2917
    :cond_1
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 2918
    .local v3, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    const/4 v5, 0x0

    .line 2919
    .local v5, "start":I
    const/4 v4, 0x0

    .line 2920
    .local v4, "match":Z
    const/4 v1, 0x0

    .line 2921
    .local v1, "lastMatch":Z
    :goto_1
    if-ge v0, v2, :cond_5

    .line 2922
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v6

    if-ne v6, p1, :cond_4

    .line 2923
    if-nez v4, :cond_2

    if-eqz p2, :cond_3

    .line 2924
    :cond_2
    invoke-virtual {p0, v5, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v3, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 2925
    const/4 v4, 0x0

    .line 2926
    const/4 v1, 0x1

    .line 2928
    :cond_3
    add-int/lit8 v0, v0, 0x1

    move v5, v0

    .line 2929
    goto :goto_1

    .line 2931
    :cond_4
    const/4 v1, 0x0

    .line 2932
    const/4 v4, 0x1

    .line 2933
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 2935
    :cond_5
    if-nez v4, :cond_6

    if-eqz p2, :cond_7

    if-eqz v1, :cond_7

    .line 2936
    :cond_6
    invoke-virtual {p0, v5, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v3, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 2938
    :cond_7
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v6

    new-array v6, v6, [Ljava/lang/String;

    invoke-interface {v3, v6}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Ljava/lang/String;

    goto :goto_0
.end method

.method private static splitWorker(Ljava/lang/String;Ljava/lang/String;IZ)[Ljava/lang/String;
    .locals 11
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "separatorChars"    # Ljava/lang/String;
    .param p2, "max"    # I
    .param p3, "preserveAllTokens"    # Z

    .prologue
    .line 3037
    if-nez p0, :cond_0

    .line 3038
    const/4 v9, 0x0

    .line 3114
    :goto_0
    return-object v9

    .line 3040
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .line 3041
    .local v2, "len":I
    if-nez v2, :cond_1

    .line 3042
    sget-object v9, Lorg/apache/commons/lang3/ArrayUtils;->EMPTY_STRING_ARRAY:[Ljava/lang/String;

    goto :goto_0

    .line 3044
    :cond_1
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 3045
    .local v3, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v6, 0x1

    .line 3046
    .local v6, "sizePlus1":I
    const/4 v0, 0x0

    .local v0, "i":I
    const/4 v8, 0x0

    .line 3047
    .local v8, "start":I
    const/4 v4, 0x0

    .line 3048
    .local v4, "match":Z
    const/4 v1, 0x0

    .line 3049
    .local v1, "lastMatch":Z
    if-nez p1, :cond_5

    move v7, v6

    .line 3051
    .end local v6    # "sizePlus1":I
    .local v7, "sizePlus1":I
    :goto_1
    if-ge v0, v2, :cond_10

    .line 3052
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v9

    invoke-static {v9}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 3053
    if-nez v4, :cond_2

    if-eqz p3, :cond_13

    .line 3054
    :cond_2
    const/4 v1, 0x1

    .line 3055
    add-int/lit8 v6, v7, 0x1

    .end local v7    # "sizePlus1":I
    .restart local v6    # "sizePlus1":I
    if-ne v7, p2, :cond_3

    .line 3056
    move v0, v2

    .line 3057
    const/4 v1, 0x0

    .line 3059
    :cond_3
    invoke-virtual {p0, v8, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-interface {v3, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3060
    const/4 v4, 0x0

    .line 3062
    :goto_2
    add-int/lit8 v0, v0, 0x1

    move v8, v0

    move v7, v6

    .line 3063
    .end local v6    # "sizePlus1":I
    .restart local v7    # "sizePlus1":I
    goto :goto_1

    .line 3065
    :cond_4
    const/4 v1, 0x0

    .line 3066
    const/4 v4, 0x1

    .line 3067
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 3069
    .end local v7    # "sizePlus1":I
    .restart local v6    # "sizePlus1":I
    :cond_5
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v9

    const/4 v10, 0x1

    if-ne v9, v10, :cond_12

    .line 3071
    const/4 v9, 0x0

    invoke-virtual {p1, v9}, Ljava/lang/String;->charAt(I)C

    move-result v5

    .local v5, "sep":C
    move v7, v6

    .line 3072
    .end local v6    # "sizePlus1":I
    .restart local v7    # "sizePlus1":I
    :goto_3
    if-ge v0, v2, :cond_9

    .line 3073
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-ne v9, v5, :cond_8

    .line 3074
    if-nez v4, :cond_6

    if-eqz p3, :cond_11

    .line 3075
    :cond_6
    const/4 v1, 0x1

    .line 3076
    add-int/lit8 v6, v7, 0x1

    .end local v7    # "sizePlus1":I
    .restart local v6    # "sizePlus1":I
    if-ne v7, p2, :cond_7

    .line 3077
    move v0, v2

    .line 3078
    const/4 v1, 0x0

    .line 3080
    :cond_7
    invoke-virtual {p0, v8, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-interface {v3, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3081
    const/4 v4, 0x0

    .line 3083
    :goto_4
    add-int/lit8 v0, v0, 0x1

    move v8, v0

    move v7, v6

    .line 3084
    .end local v6    # "sizePlus1":I
    .restart local v7    # "sizePlus1":I
    goto :goto_3

    .line 3086
    :cond_8
    const/4 v1, 0x0

    .line 3087
    const/4 v4, 0x1

    .line 3088
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    :cond_9
    move v6, v7

    .line 3111
    .end local v5    # "sep":C
    .end local v7    # "sizePlus1":I
    .restart local v6    # "sizePlus1":I
    :goto_5
    if-nez v4, :cond_a

    if-eqz p3, :cond_b

    if-eqz v1, :cond_b

    .line 3112
    :cond_a
    invoke-virtual {p0, v8, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-interface {v3, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3114
    :cond_b
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v9

    new-array v9, v9, [Ljava/lang/String;

    invoke-interface {v3, v9}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v9

    check-cast v9, [Ljava/lang/String;

    goto/16 :goto_0

    .line 3092
    .end local v6    # "sizePlus1":I
    .restart local v7    # "sizePlus1":I
    :goto_6
    if-ge v0, v2, :cond_10

    .line 3093
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v9

    invoke-virtual {p1, v9}, Ljava/lang/String;->indexOf(I)I

    move-result v9

    if-ltz v9, :cond_e

    .line 3094
    if-nez v4, :cond_c

    if-eqz p3, :cond_f

    .line 3095
    :cond_c
    const/4 v1, 0x1

    .line 3096
    add-int/lit8 v6, v7, 0x1

    .end local v7    # "sizePlus1":I
    .restart local v6    # "sizePlus1":I
    if-ne v7, p2, :cond_d

    .line 3097
    move v0, v2

    .line 3098
    const/4 v1, 0x0

    .line 3100
    :cond_d
    invoke-virtual {p0, v8, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-interface {v3, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3101
    const/4 v4, 0x0

    .line 3103
    :goto_7
    add-int/lit8 v0, v0, 0x1

    move v8, v0

    move v7, v6

    .line 3104
    .end local v6    # "sizePlus1":I
    .restart local v7    # "sizePlus1":I
    goto :goto_6

    .line 3106
    :cond_e
    const/4 v1, 0x0

    .line 3107
    const/4 v4, 0x1

    .line 3108
    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    :cond_f
    move v6, v7

    .end local v7    # "sizePlus1":I
    .restart local v6    # "sizePlus1":I
    goto :goto_7

    .end local v6    # "sizePlus1":I
    .restart local v7    # "sizePlus1":I
    :cond_10
    move v6, v7

    .end local v7    # "sizePlus1":I
    .restart local v6    # "sizePlus1":I
    goto :goto_5

    .end local v6    # "sizePlus1":I
    .restart local v5    # "sep":C
    .restart local v7    # "sizePlus1":I
    :cond_11
    move v6, v7

    .end local v7    # "sizePlus1":I
    .restart local v6    # "sizePlus1":I
    goto :goto_4

    .end local v5    # "sep":C
    :cond_12
    move v7, v6

    .end local v6    # "sizePlus1":I
    .restart local v7    # "sizePlus1":I
    goto :goto_6

    :cond_13
    move v6, v7

    .end local v7    # "sizePlus1":I
    .restart local v6    # "sizePlus1":I
    goto/16 :goto_2
.end method

.method public static trim(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 282
    if-nez p0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
