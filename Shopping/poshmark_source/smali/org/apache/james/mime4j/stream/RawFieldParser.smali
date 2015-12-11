.class public Lorg/apache/james/mime4j/stream/RawFieldParser;
.super Ljava/lang/Object;
.source "RawFieldParser.java"


# static fields
.field static final COLON:Ljava/util/BitSet;

.field public static final DEFAULT:Lorg/apache/james/mime4j/stream/RawFieldParser;

.field static final EQUAL_OR_SEMICOLON:Ljava/util/BitSet;

.field static final SEMICOLON:Ljava/util/BitSet;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 47
    new-array v0, v3, [I

    const/16 v1, 0x3a

    aput v1, v0, v2

    invoke-static {v0}, Lorg/apache/james/mime4j/stream/RawFieldParser;->INIT_BITSET([I)Ljava/util/BitSet;

    move-result-object v0

    sput-object v0, Lorg/apache/james/mime4j/stream/RawFieldParser;->COLON:Ljava/util/BitSet;

    .line 48
    const/4 v0, 0x2

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    invoke-static {v0}, Lorg/apache/james/mime4j/stream/RawFieldParser;->INIT_BITSET([I)Ljava/util/BitSet;

    move-result-object v0

    sput-object v0, Lorg/apache/james/mime4j/stream/RawFieldParser;->EQUAL_OR_SEMICOLON:Ljava/util/BitSet;

    .line 49
    new-array v0, v3, [I

    const/16 v1, 0x3b

    aput v1, v0, v2

    invoke-static {v0}, Lorg/apache/james/mime4j/stream/RawFieldParser;->INIT_BITSET([I)Ljava/util/BitSet;

    move-result-object v0

    sput-object v0, Lorg/apache/james/mime4j/stream/RawFieldParser;->SEMICOLON:Ljava/util/BitSet;

    .line 51
    new-instance v0, Lorg/apache/james/mime4j/stream/RawFieldParser;

    invoke-direct {v0}, Lorg/apache/james/mime4j/stream/RawFieldParser;-><init>()V

    sput-object v0, Lorg/apache/james/mime4j/stream/RawFieldParser;->DEFAULT:Lorg/apache/james/mime4j/stream/RawFieldParser;

    return-void

    .line 48
    :array_0
    .array-data 4
        0x3d
        0x3b
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static varargs INIT_BITSET([I)Ljava/util/BitSet;
    .locals 3
    .param p0, "b"    # [I

    .prologue
    .line 40
    new-instance v0, Ljava/util/BitSet;

    array-length v2, p0

    invoke-direct {v0, v2}, Ljava/util/BitSet;-><init>(I)V

    .line 41
    .local v0, "bitset":Ljava/util/BitSet;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p0

    if-ge v1, v2, :cond_0

    .line 42
    aget v2, p0, v1

    invoke-virtual {v0, v2}, Ljava/util/BitSet;->set(I)V

    .line 41
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 44
    :cond_0
    return-object v0
.end method


# virtual methods
.method public copyContent(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;Ljava/util/BitSet;Ljava/lang/StringBuilder;)V
    .locals 6
    .param p1, "buf"    # Lorg/apache/james/mime4j/util/ByteSequence;
    .param p2, "cursor"    # Lorg/apache/james/mime4j/stream/ParserCursor;
    .param p3, "delimiters"    # Ljava/util/BitSet;
    .param p4, "dst"    # Ljava/lang/StringBuilder;

    .prologue
    .line 319
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v4

    .line 320
    .local v4, "pos":I
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v2

    .line 321
    .local v2, "indexFrom":I
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getUpperBound()I

    move-result v3

    .line 322
    .local v3, "indexTo":I
    move v1, v2

    .local v1, "i":I
    :goto_0
    if-ge v1, v3, :cond_1

    .line 323
    invoke-interface {p1, v1}, Lorg/apache/james/mime4j/util/ByteSequence;->byteAt(I)B

    move-result v5

    and-int/lit16 v5, v5, 0xff

    int-to-char v0, v5

    .line 324
    .local v0, "current":C
    if-eqz p3, :cond_0

    invoke-virtual {p3, v0}, Ljava/util/BitSet;->get(I)Z

    move-result v5

    if-nez v5, :cond_1

    :cond_0
    invoke-static {v0}, Lorg/apache/james/mime4j/util/CharsetUtil;->isWhitespace(C)Z

    move-result v5

    if-nez v5, :cond_1

    const/16 v5, 0x28

    if-ne v0, v5, :cond_2

    .line 332
    .end local v0    # "current":C
    :cond_1
    invoke-virtual {p2, v4}, Lorg/apache/james/mime4j/stream/ParserCursor;->updatePos(I)V

    .line 333
    return-void

    .line 328
    .restart local v0    # "current":C
    :cond_2
    add-int/lit8 v4, v4, 0x1

    .line 329
    invoke-virtual {p4, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 322
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public copyQuotedContent(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;Ljava/lang/StringBuilder;)V
    .locals 9
    .param p1, "buf"    # Lorg/apache/james/mime4j/util/ByteSequence;
    .param p2, "cursor"    # Lorg/apache/james/mime4j/stream/ParserCursor;
    .param p3, "dst"    # Ljava/lang/StringBuilder;

    .prologue
    const/16 v8, 0x5c

    const/16 v7, 0x22

    .line 344
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->atEnd()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 378
    :cond_0
    :goto_0
    return-void

    .line 347
    :cond_1
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v5

    .line 348
    .local v5, "pos":I
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v3

    .line 349
    .local v3, "indexFrom":I
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getUpperBound()I

    move-result v4

    .line 350
    .local v4, "indexTo":I
    invoke-interface {p1, v5}, Lorg/apache/james/mime4j/util/ByteSequence;->byteAt(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    int-to-char v0, v6

    .line 351
    .local v0, "current":C
    if-ne v0, v7, :cond_0

    .line 354
    add-int/lit8 v5, v5, 0x1

    .line 355
    add-int/lit8 v3, v3, 0x1

    .line 356
    const/4 v1, 0x0

    .line 357
    .local v1, "escaped":Z
    move v2, v3

    .local v2, "i":I
    :goto_1
    if-ge v2, v4, :cond_5

    .line 358
    invoke-interface {p1, v2}, Lorg/apache/james/mime4j/util/ByteSequence;->byteAt(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    int-to-char v0, v6

    .line 359
    if-eqz v1, :cond_4

    .line 360
    if-eq v0, v7, :cond_2

    if-eq v0, v8, :cond_2

    .line 361
    invoke-virtual {p3, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 363
    :cond_2
    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 364
    const/4 v1, 0x0

    .line 357
    :cond_3
    :goto_2
    add-int/lit8 v2, v2, 0x1

    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 366
    :cond_4
    if-ne v0, v7, :cond_6

    .line 367
    add-int/lit8 v5, v5, 0x1

    .line 377
    :cond_5
    invoke-virtual {p2, v5}, Lorg/apache/james/mime4j/stream/ParserCursor;->updatePos(I)V

    goto :goto_0

    .line 370
    :cond_6
    if-ne v0, v8, :cond_7

    .line 371
    const/4 v1, 0x1

    goto :goto_2

    .line 372
    :cond_7
    const/16 v6, 0xd

    if-eq v0, v6, :cond_3

    const/16 v6, 0xa

    if-eq v0, v6, :cond_3

    .line 373
    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_2
.end method

.method public parseField(Lorg/apache/james/mime4j/util/ByteSequence;)Lorg/apache/james/mime4j/stream/RawField;
    .locals 5
    .param p1, "raw"    # Lorg/apache/james/mime4j/util/ByteSequence;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/apache/james/mime4j/MimeException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 59
    if-nez p1, :cond_0

    .line 68
    :goto_0
    return-object v2

    .line 62
    :cond_0
    new-instance v0, Lorg/apache/james/mime4j/stream/ParserCursor;

    const/4 v3, 0x0

    invoke-interface {p1}, Lorg/apache/james/mime4j/util/ByteSequence;->length()I

    move-result v4

    invoke-direct {v0, v3, v4}, Lorg/apache/james/mime4j/stream/ParserCursor;-><init>(II)V

    .line 63
    .local v0, "cursor":Lorg/apache/james/mime4j/stream/ParserCursor;
    sget-object v3, Lorg/apache/james/mime4j/stream/RawFieldParser;->COLON:Ljava/util/BitSet;

    invoke-virtual {p0, p1, v0, v3}, Lorg/apache/james/mime4j/stream/RawFieldParser;->parseToken(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;Ljava/util/BitSet;)Ljava/lang/String;

    move-result-object v1

    .line 64
    .local v1, "name":Ljava/lang/String;
    invoke-virtual {v0}, Lorg/apache/james/mime4j/stream/ParserCursor;->atEnd()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 65
    new-instance v2, Lorg/apache/james/mime4j/MimeException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid MIME field: no name/value separator found: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/apache/james/mime4j/MimeException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 68
    :cond_1
    new-instance v3, Lorg/apache/james/mime4j/stream/RawField;

    invoke-virtual {v0}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v4

    invoke-direct {v3, p1, v4, v1, v2}, Lorg/apache/james/mime4j/stream/RawField;-><init>(Lorg/apache/james/mime4j/util/ByteSequence;ILjava/lang/String;Ljava/lang/String;)V

    move-object v2, v3

    goto :goto_0
.end method

.method public parseParameter(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)Lorg/apache/james/mime4j/stream/NameValuePair;
    .locals 5
    .param p1, "buf"    # Lorg/apache/james/mime4j/util/ByteSequence;
    .param p2, "cursor"    # Lorg/apache/james/mime4j/stream/ParserCursor;

    .prologue
    const/4 v4, 0x0

    .line 132
    sget-object v3, Lorg/apache/james/mime4j/stream/RawFieldParser;->EQUAL_OR_SEMICOLON:Ljava/util/BitSet;

    invoke-virtual {p0, p1, p2, v3}, Lorg/apache/james/mime4j/stream/RawFieldParser;->parseToken(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;Ljava/util/BitSet;)Ljava/lang/String;

    move-result-object v1

    .line 133
    .local v1, "name":Ljava/lang/String;
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->atEnd()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 134
    new-instance v3, Lorg/apache/james/mime4j/stream/NameValuePair;

    invoke-direct {v3, v1, v4}, Lorg/apache/james/mime4j/stream/NameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    :goto_0
    return-object v3

    .line 136
    :cond_0
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v3

    invoke-interface {p1, v3}, Lorg/apache/james/mime4j/util/ByteSequence;->byteAt(I)B

    move-result v0

    .line 137
    .local v0, "delim":I
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {p2, v3}, Lorg/apache/james/mime4j/stream/ParserCursor;->updatePos(I)V

    .line 138
    const/16 v3, 0x3b

    if-ne v0, v3, :cond_1

    .line 139
    new-instance v3, Lorg/apache/james/mime4j/stream/NameValuePair;

    invoke-direct {v3, v1, v4}, Lorg/apache/james/mime4j/stream/NameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 141
    :cond_1
    sget-object v3, Lorg/apache/james/mime4j/stream/RawFieldParser;->SEMICOLON:Ljava/util/BitSet;

    invoke-virtual {p0, p1, p2, v3}, Lorg/apache/james/mime4j/stream/RawFieldParser;->parseValue(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;Ljava/util/BitSet;)Ljava/lang/String;

    move-result-object v2

    .line 142
    .local v2, "value":Ljava/lang/String;
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->atEnd()Z

    move-result v3

    if-nez v3, :cond_2

    .line 143
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {p2, v3}, Lorg/apache/james/mime4j/stream/ParserCursor;->updatePos(I)V

    .line 145
    :cond_2
    new-instance v3, Lorg/apache/james/mime4j/stream/NameValuePair;

    invoke-direct {v3, v1, v2}, Lorg/apache/james/mime4j/stream/NameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public parseParameters(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)Ljava/util/List;
    .locals 3
    .param p1, "buf"    # Lorg/apache/james/mime4j/util/ByteSequence;
    .param p2, "cursor"    # Lorg/apache/james/mime4j/stream/ParserCursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/apache/james/mime4j/util/ByteSequence;",
            "Lorg/apache/james/mime4j/stream/ParserCursor;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/james/mime4j/stream/NameValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 115
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 116
    .local v1, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/james/mime4j/stream/NameValuePair;>;"
    invoke-virtual {p0, p1, p2}, Lorg/apache/james/mime4j/stream/RawFieldParser;->skipWhiteSpace(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)V

    .line 117
    :goto_0
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->atEnd()Z

    move-result v2

    if-nez v2, :cond_0

    .line 118
    invoke-virtual {p0, p1, p2}, Lorg/apache/james/mime4j/stream/RawFieldParser;->parseParameter(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)Lorg/apache/james/mime4j/stream/NameValuePair;

    move-result-object v0

    .line 119
    .local v0, "param":Lorg/apache/james/mime4j/stream/NameValuePair;
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 121
    .end local v0    # "param":Lorg/apache/james/mime4j/stream/NameValuePair;
    :cond_0
    return-object v1
.end method

.method public parseRawBody(Lorg/apache/james/mime4j/stream/RawField;)Lorg/apache/james/mime4j/stream/RawBody;
    .locals 7
    .param p1, "field"    # Lorg/apache/james/mime4j/stream/RawField;

    .prologue
    .line 77
    invoke-virtual {p1}, Lorg/apache/james/mime4j/stream/RawField;->getRaw()Lorg/apache/james/mime4j/util/ByteSequence;

    move-result-object v1

    .line 78
    .local v1, "buf":Lorg/apache/james/mime4j/util/ByteSequence;
    invoke-virtual {p1}, Lorg/apache/james/mime4j/stream/RawField;->getDelimiterIdx()I

    move-result v4

    add-int/lit8 v3, v4, 0x1

    .line 79
    .local v3, "pos":I
    if-nez v1, :cond_1

    .line 80
    invoke-virtual {p1}, Lorg/apache/james/mime4j/stream/RawField;->getBody()Ljava/lang/String;

    move-result-object v0

    .line 81
    .local v0, "body":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 82
    new-instance v4, Lorg/apache/james/mime4j/stream/RawBody;

    const-string v5, ""

    const/4 v6, 0x0

    invoke-direct {v4, v5, v6}, Lorg/apache/james/mime4j/stream/RawBody;-><init>(Ljava/lang/String;Ljava/util/List;)V

    .line 88
    .end local v0    # "body":Ljava/lang/String;
    :goto_0
    return-object v4

    .line 84
    .restart local v0    # "body":Ljava/lang/String;
    :cond_0
    invoke-static {v0}, Lorg/apache/james/mime4j/util/ContentUtil;->encode(Ljava/lang/String;)Lorg/apache/james/mime4j/util/ByteSequence;

    move-result-object v1

    .line 85
    const/4 v3, 0x0

    .line 87
    .end local v0    # "body":Ljava/lang/String;
    :cond_1
    new-instance v2, Lorg/apache/james/mime4j/stream/ParserCursor;

    invoke-interface {v1}, Lorg/apache/james/mime4j/util/ByteSequence;->length()I

    move-result v4

    invoke-direct {v2, v3, v4}, Lorg/apache/james/mime4j/stream/ParserCursor;-><init>(II)V

    .line 88
    .local v2, "cursor":Lorg/apache/james/mime4j/stream/ParserCursor;
    invoke-virtual {p0, v1, v2}, Lorg/apache/james/mime4j/stream/RawFieldParser;->parseRawBody(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)Lorg/apache/james/mime4j/stream/RawBody;

    move-result-object v4

    goto :goto_0
.end method

.method public parseRawBody(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)Lorg/apache/james/mime4j/stream/RawBody;
    .locals 4
    .param p1, "buf"    # Lorg/apache/james/mime4j/util/ByteSequence;
    .param p2, "cursor"    # Lorg/apache/james/mime4j/stream/ParserCursor;

    .prologue
    .line 98
    sget-object v2, Lorg/apache/james/mime4j/stream/RawFieldParser;->SEMICOLON:Ljava/util/BitSet;

    invoke-virtual {p0, p1, p2, v2}, Lorg/apache/james/mime4j/stream/RawFieldParser;->parseToken(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;Ljava/util/BitSet;)Ljava/lang/String;

    move-result-object v1

    .line 99
    .local v1, "value":Ljava/lang/String;
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->atEnd()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 100
    new-instance v2, Lorg/apache/james/mime4j/stream/RawBody;

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    invoke-direct {v2, v1, v3}, Lorg/apache/james/mime4j/stream/RawBody;-><init>(Ljava/lang/String;Ljava/util/List;)V

    .line 104
    :goto_0
    return-object v2

    .line 102
    :cond_0
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {p2, v2}, Lorg/apache/james/mime4j/stream/ParserCursor;->updatePos(I)V

    .line 103
    invoke-virtual {p0, p1, p2}, Lorg/apache/james/mime4j/stream/RawFieldParser;->parseParameters(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)Ljava/util/List;

    move-result-object v0

    .line 104
    .local v0, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/james/mime4j/stream/NameValuePair;>;"
    new-instance v2, Lorg/apache/james/mime4j/stream/RawBody;

    invoke-direct {v2, v1, v0}, Lorg/apache/james/mime4j/stream/RawBody;-><init>(Ljava/lang/String;Ljava/util/List;)V

    goto :goto_0
.end method

.method public parseToken(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;Ljava/util/BitSet;)Ljava/lang/String;
    .locals 4
    .param p1, "buf"    # Lorg/apache/james/mime4j/util/ByteSequence;
    .param p2, "cursor"    # Lorg/apache/james/mime4j/stream/ParserCursor;
    .param p3, "delimiters"    # Ljava/util/BitSet;

    .prologue
    .line 158
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 159
    .local v1, "dst":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    .line 160
    .local v2, "whitespace":Z
    :goto_0
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->atEnd()Z

    move-result v3

    if-nez v3, :cond_0

    .line 161
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v3

    invoke-interface {p1, v3}, Lorg/apache/james/mime4j/util/ByteSequence;->byteAt(I)B

    move-result v3

    and-int/lit16 v3, v3, 0xff

    int-to-char v0, v3

    .line 162
    .local v0, "current":C
    if-eqz p3, :cond_1

    invoke-virtual {p3, v0}, Ljava/util/BitSet;->get(I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 177
    .end local v0    # "current":C
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 164
    .restart local v0    # "current":C
    :cond_1
    invoke-static {v0}, Lorg/apache/james/mime4j/util/CharsetUtil;->isWhitespace(C)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 165
    invoke-virtual {p0, p1, p2}, Lorg/apache/james/mime4j/stream/RawFieldParser;->skipWhiteSpace(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)V

    .line 166
    const/4 v2, 0x1

    goto :goto_0

    .line 167
    :cond_2
    const/16 v3, 0x28

    if-ne v0, v3, :cond_3

    .line 168
    invoke-virtual {p0, p1, p2}, Lorg/apache/james/mime4j/stream/RawFieldParser;->skipComment(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)V

    goto :goto_0

    .line 170
    :cond_3
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-lez v3, :cond_4

    if-eqz v2, :cond_4

    .line 171
    const/16 v3, 0x20

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 173
    :cond_4
    invoke-virtual {p0, p1, p2, p3, v1}, Lorg/apache/james/mime4j/stream/RawFieldParser;->copyContent(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;Ljava/util/BitSet;Ljava/lang/StringBuilder;)V

    .line 174
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public parseValue(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;Ljava/util/BitSet;)Ljava/lang/String;
    .locals 5
    .param p1, "buf"    # Lorg/apache/james/mime4j/util/ByteSequence;
    .param p2, "cursor"    # Lorg/apache/james/mime4j/stream/ParserCursor;
    .param p3, "delimiters"    # Ljava/util/BitSet;

    .prologue
    const/16 v4, 0x20

    .line 191
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 192
    .local v1, "dst":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    .line 193
    .local v2, "whitespace":Z
    :goto_0
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->atEnd()Z

    move-result v3

    if-nez v3, :cond_0

    .line 194
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v3

    invoke-interface {p1, v3}, Lorg/apache/james/mime4j/util/ByteSequence;->byteAt(I)B

    move-result v3

    and-int/lit16 v3, v3, 0xff

    int-to-char v0, v3

    .line 195
    .local v0, "current":C
    if-eqz p3, :cond_1

    invoke-virtual {p3, v0}, Ljava/util/BitSet;->get(I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 216
    .end local v0    # "current":C
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 197
    .restart local v0    # "current":C
    :cond_1
    invoke-static {v0}, Lorg/apache/james/mime4j/util/CharsetUtil;->isWhitespace(C)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 198
    invoke-virtual {p0, p1, p2}, Lorg/apache/james/mime4j/stream/RawFieldParser;->skipWhiteSpace(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)V

    .line 199
    const/4 v2, 0x1

    goto :goto_0

    .line 200
    :cond_2
    const/16 v3, 0x28

    if-ne v0, v3, :cond_3

    .line 201
    invoke-virtual {p0, p1, p2}, Lorg/apache/james/mime4j/stream/RawFieldParser;->skipComment(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)V

    goto :goto_0

    .line 202
    :cond_3
    const/16 v3, 0x22

    if-ne v0, v3, :cond_5

    .line 203
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-lez v3, :cond_4

    if-eqz v2, :cond_4

    .line 204
    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 206
    :cond_4
    invoke-virtual {p0, p1, p2, v1}, Lorg/apache/james/mime4j/stream/RawFieldParser;->copyQuotedContent(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;Ljava/lang/StringBuilder;)V

    .line 207
    const/4 v2, 0x0

    goto :goto_0

    .line 209
    :cond_5
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-lez v3, :cond_6

    if-eqz v2, :cond_6

    .line 210
    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 212
    :cond_6
    invoke-virtual {p0, p1, p2, p3, v1}, Lorg/apache/james/mime4j/stream/RawFieldParser;->copyContent(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;Ljava/util/BitSet;Ljava/lang/StringBuilder;)V

    .line 213
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public skipAllWhiteSpace(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)V
    .locals 2
    .param p1, "buf"    # Lorg/apache/james/mime4j/util/ByteSequence;
    .param p2, "cursor"    # Lorg/apache/james/mime4j/stream/ParserCursor;

    .prologue
    .line 295
    :goto_0
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->atEnd()Z

    move-result v1

    if-nez v1, :cond_1

    .line 296
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v1

    invoke-interface {p1, v1}, Lorg/apache/james/mime4j/util/ByteSequence;->byteAt(I)B

    move-result v1

    and-int/lit16 v1, v1, 0xff

    int-to-char v0, v1

    .line 297
    .local v0, "current":C
    invoke-static {v0}, Lorg/apache/james/mime4j/util/CharsetUtil;->isWhitespace(C)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 298
    invoke-virtual {p0, p1, p2}, Lorg/apache/james/mime4j/stream/RawFieldParser;->skipWhiteSpace(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)V

    goto :goto_0

    .line 299
    :cond_0
    const/16 v1, 0x28

    if-ne v0, v1, :cond_1

    .line 300
    invoke-virtual {p0, p1, p2}, Lorg/apache/james/mime4j/stream/RawFieldParser;->skipComment(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)V

    goto :goto_0

    .line 305
    .end local v0    # "current":C
    :cond_1
    return-void
.end method

.method public skipComment(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)V
    .locals 9
    .param p1, "buf"    # Lorg/apache/james/mime4j/util/ByteSequence;
    .param p2, "cursor"    # Lorg/apache/james/mime4j/stream/ParserCursor;

    .prologue
    const/16 v8, 0x28

    .line 250
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->atEnd()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 284
    :cond_0
    :goto_0
    return-void

    .line 253
    :cond_1
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v6

    .line 254
    .local v6, "pos":I
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v3

    .line 255
    .local v3, "indexFrom":I
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getUpperBound()I

    move-result v4

    .line 256
    .local v4, "indexTo":I
    invoke-interface {p1, v6}, Lorg/apache/james/mime4j/util/ByteSequence;->byteAt(I)B

    move-result v7

    and-int/lit16 v7, v7, 0xff

    int-to-char v0, v7

    .line 257
    .local v0, "current":C
    if-ne v0, v8, :cond_0

    .line 260
    add-int/lit8 v6, v6, 0x1

    .line 261
    add-int/lit8 v3, v3, 0x1

    .line 263
    const/4 v5, 0x1

    .line 264
    .local v5, "level":I
    const/4 v1, 0x0

    .line 265
    .local v1, "escaped":Z
    move v2, v3

    .local v2, "i":I
    :goto_1
    if-ge v2, v4, :cond_3

    .line 266
    invoke-interface {p1, v2}, Lorg/apache/james/mime4j/util/ByteSequence;->byteAt(I)B

    move-result v7

    and-int/lit16 v7, v7, 0xff

    int-to-char v0, v7

    .line 267
    if-eqz v1, :cond_4

    .line 268
    const/4 v1, 0x0

    .line 278
    :cond_2
    :goto_2
    if-gtz v5, :cond_7

    .line 279
    add-int/lit8 v6, v6, 0x1

    .line 283
    :cond_3
    invoke-virtual {p2, v6}, Lorg/apache/james/mime4j/stream/ParserCursor;->updatePos(I)V

    goto :goto_0

    .line 270
    :cond_4
    const/16 v7, 0x5c

    if-ne v0, v7, :cond_5

    .line 271
    const/4 v1, 0x1

    goto :goto_2

    .line 272
    :cond_5
    if-ne v0, v8, :cond_6

    .line 273
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 274
    :cond_6
    const/16 v7, 0x29

    if-ne v0, v7, :cond_2

    .line 275
    add-int/lit8 v5, v5, -0x1

    goto :goto_2

    .line 265
    :cond_7
    add-int/lit8 v2, v2, 0x1

    add-int/lit8 v6, v6, 0x1

    goto :goto_1
.end method

.method public skipWhiteSpace(Lorg/apache/james/mime4j/util/ByteSequence;Lorg/apache/james/mime4j/stream/ParserCursor;)V
    .locals 6
    .param p1, "buf"    # Lorg/apache/james/mime4j/util/ByteSequence;
    .param p2, "cursor"    # Lorg/apache/james/mime4j/stream/ParserCursor;

    .prologue
    .line 227
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v4

    .line 228
    .local v4, "pos":I
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getPos()I

    move-result v2

    .line 229
    .local v2, "indexFrom":I
    invoke-virtual {p2}, Lorg/apache/james/mime4j/stream/ParserCursor;->getUpperBound()I

    move-result v3

    .line 230
    .local v3, "indexTo":I
    move v1, v2

    .local v1, "i":I
    :goto_0
    if-ge v1, v3, :cond_0

    .line 231
    invoke-interface {p1, v1}, Lorg/apache/james/mime4j/util/ByteSequence;->byteAt(I)B

    move-result v5

    and-int/lit16 v5, v5, 0xff

    int-to-char v0, v5

    .line 232
    .local v0, "current":C
    invoke-static {v0}, Lorg/apache/james/mime4j/util/CharsetUtil;->isWhitespace(C)Z

    move-result v5

    if-nez v5, :cond_1

    .line 238
    .end local v0    # "current":C
    :cond_0
    invoke-virtual {p2, v4}, Lorg/apache/james/mime4j/stream/ParserCursor;->updatePos(I)V

    .line 239
    return-void

    .line 235
    .restart local v0    # "current":C
    :cond_1
    add-int/lit8 v4, v4, 0x1

    .line 230
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method
