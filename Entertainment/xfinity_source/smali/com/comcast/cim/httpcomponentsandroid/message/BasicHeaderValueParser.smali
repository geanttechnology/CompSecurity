.class public Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;
.super Ljava/lang/Object;
.source "BasicHeaderValueParser.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;


# static fields
.field private static final ALL_DELIMITERS:[C

.field public static final DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;-><init>()V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;

    .line 59
    const/4 v0, 0x2

    new-array v0, v0, [C

    fill-array-data v0, :array_0

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->ALL_DELIMITERS:[C

    return-void

    :array_0
    .array-data 2
        0x3bs
        0x2cs
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static isOneOf(C[C)Z
    .locals 2
    .param p0, "ch"    # C
    .param p1, "chs"    # [C

    .prologue
    .line 288
    if-eqz p1, :cond_1

    .line 289
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p1

    if-ge v0, v1, :cond_1

    .line 290
    aget-char v1, p1, v0

    if-ne p0, v1, :cond_0

    .line 291
    const/4 v1, 0x1

    .line 295
    .end local v0    # "i":I
    :goto_1
    return v1

    .line 289
    .restart local v0    # "i":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 295
    .end local v0    # "i":I
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public static final parseElements(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;)[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .locals 4
    .param p0, "value"    # Ljava/lang/String;
    .param p1, "parser"    # Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation

    .prologue
    .line 80
    if-nez p0, :cond_0

    .line 81
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Value to parse may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 85
    :cond_0
    if-nez p1, :cond_1

    .line 86
    sget-object p1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;

    .line 88
    :cond_1
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    invoke-direct {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 89
    .local v0, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    invoke-virtual {v0, p0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 90
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    const/4 v2, 0x0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    invoke-direct {v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;-><init>(II)V

    .line 91
    .local v1, "cursor":Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    invoke-interface {p1, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;->parseElements(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v2

    return-object v2
.end method


# virtual methods
.method protected createHeaderElement(Ljava/lang/String;Ljava/lang/String;[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;)Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "params"    # [Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    .prologue
    .line 179
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;

    invoke-direct {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;-><init>(Ljava/lang/String;Ljava/lang/String;[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;)V

    return-object v0
.end method

.method protected createNameValuePair(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 399
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicNameValuePair;

    invoke-direct {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public parseElements(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .locals 4
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "cursor"    # Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    .prologue
    .line 99
    if-nez p1, :cond_0

    .line 100
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Char array buffer may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 102
    :cond_0
    if-nez p2, :cond_1

    .line 103
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Parser cursor may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 106
    :cond_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 107
    .local v1, "elements":Ljava/util/List;
    :cond_2
    :goto_0
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->atEnd()Z

    move-result v2

    if-nez v2, :cond_4

    .line 108
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->parseHeaderElement(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v0

    .line 109
    .local v0, "element":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_3

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 110
    :cond_3
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 113
    .end local v0    # "element":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_4
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    invoke-interface {v1, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    check-cast v2, [Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    return-object v2
.end method

.method public parseHeaderElement(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .locals 5
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "cursor"    # Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    .prologue
    .line 150
    if-nez p1, :cond_0

    .line 151
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Char array buffer may not be null"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 153
    :cond_0
    if-nez p2, :cond_1

    .line 154
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Parser cursor may not be null"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 157
    :cond_1
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->parseNameValuePair(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    move-result-object v1

    .line 158
    .local v1, "nvp":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    const/4 v2, 0x0

    .line 159
    .local v2, "params":[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->atEnd()Z

    move-result v3

    if-nez v3, :cond_2

    .line 160
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v0

    .line 161
    .local v0, "ch":C
    const/16 v3, 0x2c

    if-eq v0, v3, :cond_2

    .line 162
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->parseParameters(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    move-result-object v2

    .line 165
    .end local v0    # "ch":C
    :cond_2
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->createHeaderElement(Ljava/lang/String;Ljava/lang/String;[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;)Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v3

    return-object v3
.end method

.method public parseNameValuePair(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .locals 1
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "cursor"    # Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    .prologue
    .line 284
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->ALL_DELIMITERS:[C

    invoke-virtual {p0, p1, p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->parseNameValuePair(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;[C)Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    move-result-object v0

    return-object v0
.end method

.method public parseNameValuePair(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;[C)Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .locals 14
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "cursor"    # Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    .param p3, "delimiters"    # [C

    .prologue
    .line 302
    if-nez p1, :cond_0

    .line 303
    new-instance v12, Ljava/lang/IllegalArgumentException;

    const-string v13, "Char array buffer may not be null"

    invoke-direct {v12, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v12

    .line 305
    :cond_0
    if-nez p2, :cond_1

    .line 306
    new-instance v12, Ljava/lang/IllegalArgumentException;

    const-string v13, "Parser cursor may not be null"

    invoke-direct {v12, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v12

    .line 309
    :cond_1
    const/4 v10, 0x0

    .line 311
    .local v10, "terminated":Z
    invoke-virtual/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v8

    .line 312
    .local v8, "pos":I
    invoke-virtual/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v5

    .line 313
    .local v5, "indexFrom":I
    invoke-virtual/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getUpperBound()I

    move-result v6

    .line 316
    .local v6, "indexTo":I
    const/4 v7, 0x0

    .line 317
    .local v7, "name":Ljava/lang/String;
    :goto_0
    if-ge v8, v6, :cond_2

    .line 318
    invoke-virtual {p1, v8}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v1

    .line 319
    .local v1, "ch":C
    const/16 v12, 0x3d

    if-ne v1, v12, :cond_3

    .line 329
    .end local v1    # "ch":C
    :cond_2
    :goto_1
    if-ne v8, v6, :cond_5

    .line 330
    const/4 v10, 0x1

    .line 331
    invoke-virtual {p1, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substringTrimmed(II)Ljava/lang/String;

    move-result-object v7

    .line 337
    :goto_2
    if-eqz v10, :cond_6

    .line 338
    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->updatePos(I)V

    .line 339
    const/4 v12, 0x0

    invoke-virtual {p0, v7, v12}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->createNameValuePair(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    move-result-object v12

    .line 386
    :goto_3
    return-object v12

    .line 322
    .restart local v1    # "ch":C
    :cond_3
    move-object/from16 v0, p3

    invoke-static {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->isOneOf(C[C)Z

    move-result v12

    if-eqz v12, :cond_4

    .line 323
    const/4 v10, 0x1

    .line 324
    goto :goto_1

    .line 326
    :cond_4
    add-int/lit8 v8, v8, 0x1

    .line 327
    goto :goto_0

    .line 333
    .end local v1    # "ch":C
    :cond_5
    invoke-virtual {p1, v5, v8}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substringTrimmed(II)Ljava/lang/String;

    move-result-object v7

    .line 334
    add-int/lit8 v8, v8, 0x1

    goto :goto_2

    .line 343
    :cond_6
    const/4 v11, 0x0

    .line 344
    .local v11, "value":Ljava/lang/String;
    move v3, v8

    .line 346
    .local v3, "i1":I
    const/4 v9, 0x0

    .line 347
    .local v9, "qouted":Z
    const/4 v2, 0x0

    .line 348
    .local v2, "escaped":Z
    :goto_4
    if-ge v8, v6, :cond_8

    .line 349
    invoke-virtual {p1, v8}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v1

    .line 350
    .restart local v1    # "ch":C
    const/16 v12, 0x22

    if-ne v1, v12, :cond_7

    if-nez v2, :cond_7

    .line 351
    if-nez v9, :cond_9

    const/4 v9, 0x1

    .line 353
    :cond_7
    :goto_5
    if-nez v9, :cond_a

    if-nez v2, :cond_a

    move-object/from16 v0, p3

    invoke-static {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->isOneOf(C[C)Z

    move-result v12

    if-eqz v12, :cond_a

    .line 354
    const/4 v10, 0x1

    .line 365
    .end local v1    # "ch":C
    :cond_8
    move v4, v8

    .line 367
    .local v4, "i2":I
    :goto_6
    if-ge v3, v4, :cond_d

    invoke-virtual {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v12

    invoke-static {v12}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HTTP;->isWhitespace(C)Z

    move-result v12

    if-eqz v12, :cond_d

    .line 368
    add-int/lit8 v3, v3, 0x1

    goto :goto_6

    .line 351
    .end local v4    # "i2":I
    .restart local v1    # "ch":C
    :cond_9
    const/4 v9, 0x0

    goto :goto_5

    .line 357
    :cond_a
    if-eqz v2, :cond_b

    .line 358
    const/4 v2, 0x0

    .line 362
    :goto_7
    add-int/lit8 v8, v8, 0x1

    .line 363
    goto :goto_4

    .line 360
    :cond_b
    if-eqz v9, :cond_c

    const/16 v12, 0x5c

    if-ne v1, v12, :cond_c

    const/4 v2, 0x1

    :goto_8
    goto :goto_7

    :cond_c
    const/4 v2, 0x0

    goto :goto_8

    .line 371
    .end local v1    # "ch":C
    .restart local v4    # "i2":I
    :cond_d
    :goto_9
    if-le v4, v3, :cond_e

    add-int/lit8 v12, v4, -0x1

    invoke-virtual {p1, v12}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v12

    invoke-static {v12}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HTTP;->isWhitespace(C)Z

    move-result v12

    if-eqz v12, :cond_e

    .line 372
    add-int/lit8 v4, v4, -0x1

    goto :goto_9

    .line 375
    :cond_e
    sub-int v12, v4, v3

    const/4 v13, 0x2

    if-lt v12, v13, :cond_f

    invoke-virtual {p1, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v12

    const/16 v13, 0x22

    if-ne v12, v13, :cond_f

    add-int/lit8 v12, v4, -0x1

    invoke-virtual {p1, v12}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v12

    const/16 v13, 0x22

    if-ne v12, v13, :cond_f

    .line 378
    add-int/lit8 v3, v3, 0x1

    .line 379
    add-int/lit8 v4, v4, -0x1

    .line 381
    :cond_f
    invoke-virtual {p1, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v11

    .line 382
    if-eqz v10, :cond_10

    .line 383
    add-int/lit8 v8, v8, 0x1

    .line 385
    :cond_10
    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->updatePos(I)V

    .line 386
    invoke-virtual {p0, v7, v11}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->createNameValuePair(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    move-result-object v12

    goto/16 :goto_3
.end method

.method public parseParameters(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .locals 7
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "cursor"    # Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    .prologue
    .line 216
    if-nez p1, :cond_0

    .line 217
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "Char array buffer may not be null"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 219
    :cond_0
    if-nez p2, :cond_1

    .line 220
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "Parser cursor may not be null"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 223
    :cond_1
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v4

    .line 224
    .local v4, "pos":I
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getUpperBound()I

    move-result v1

    .line 226
    .local v1, "indexTo":I
    :goto_0
    if-ge v4, v1, :cond_2

    .line 227
    invoke-virtual {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v0

    .line 228
    .local v0, "ch":C
    invoke-static {v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HTTP;->isWhitespace(C)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 229
    add-int/lit8 v4, v4, 0x1

    .line 233
    goto :goto_0

    .line 234
    .end local v0    # "ch":C
    :cond_2
    invoke-virtual {p2, v4}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->updatePos(I)V

    .line 235
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->atEnd()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 236
    const/4 v5, 0x0

    new-array v5, v5, [Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    .line 249
    :goto_1
    return-object v5

    .line 239
    :cond_3
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 240
    .local v3, "params":Ljava/util/List;
    :cond_4
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->atEnd()Z

    move-result v5

    if-nez v5, :cond_5

    .line 241
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->parseNameValuePair(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    move-result-object v2

    .line 242
    .local v2, "param":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 243
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;->getPos()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v0

    .line 244
    .restart local v0    # "ch":C
    const/16 v5, 0x2c

    if-ne v0, v5, :cond_4

    .line 249
    .end local v0    # "ch":C
    .end local v2    # "param":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    :cond_5
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v5

    new-array v5, v5, [Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    invoke-interface {v3, v5}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    check-cast v5, [Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    goto :goto_1
.end method
