.class public abstract Lorg/codehaus/jackson/impl/JsonNumericParserBase;
.super Lorg/codehaus/jackson/impl/JsonParserBase;
.source "JsonNumericParserBase.java"


# static fields
.field static final BD_MAX_INT:Ljava/math/BigDecimal;

.field static final BD_MAX_LONG:Ljava/math/BigDecimal;

.field static final BD_MIN_INT:Ljava/math/BigDecimal;

.field static final BD_MIN_LONG:Ljava/math/BigDecimal;


# instance fields
.field protected _expLength:I

.field protected _fractLength:I

.field protected _intLength:I

.field protected _numTypesValid:I

.field protected _numberBigDecimal:Ljava/math/BigDecimal;

.field protected _numberBigInt:Ljava/math/BigInteger;

.field protected _numberDouble:D

.field protected _numberInt:I

.field protected _numberLong:J

.field protected _numberNegative:Z


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const-wide v3, 0x7fffffffffffffffL

    const-wide/high16 v1, -0x8000000000000000L

    .line 41
    new-instance v0, Ljava/math/BigDecimal;

    invoke-direct {v0, v1, v2}, Ljava/math/BigDecimal;-><init>(J)V

    sput-object v0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->BD_MIN_LONG:Ljava/math/BigDecimal;

    .line 42
    new-instance v0, Ljava/math/BigDecimal;

    invoke-direct {v0, v3, v4}, Ljava/math/BigDecimal;-><init>(J)V

    sput-object v0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->BD_MAX_LONG:Ljava/math/BigDecimal;

    .line 44
    new-instance v0, Ljava/math/BigDecimal;

    invoke-direct {v0, v1, v2}, Ljava/math/BigDecimal;-><init>(J)V

    sput-object v0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->BD_MIN_INT:Ljava/math/BigDecimal;

    .line 45
    new-instance v0, Ljava/math/BigDecimal;

    invoke-direct {v0, v3, v4}, Ljava/math/BigDecimal;-><init>(J)V

    sput-object v0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->BD_MAX_INT:Ljava/math/BigDecimal;

    return-void
.end method

.method protected constructor <init>(Lorg/codehaus/jackson/io/IOContext;I)V
    .locals 1
    .param p1, "ctxt"    # Lorg/codehaus/jackson/io/IOContext;
    .param p2, "features"    # I

    .prologue
    .line 143
    invoke-direct {p0, p1, p2}, Lorg/codehaus/jackson/impl/JsonParserBase;-><init>(Lorg/codehaus/jackson/io/IOContext;I)V

    .line 91
    const/4 v0, 0x0

    iput v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    .line 144
    return-void
.end method

.method private final _parseSlowFloatValue(I)V
    .locals 3
    .param p1, "expType"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/codehaus/jackson/JsonParseException;
        }
    .end annotation

    .prologue
    const/16 v1, 0x10

    .line 413
    if-ne p1, v1, :cond_0

    .line 414
    :try_start_0
    iget-object v1, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_textBuffer:Lorg/codehaus/jackson/util/TextBuffer;

    invoke-virtual {v1}, Lorg/codehaus/jackson/util/TextBuffer;->contentsAsDecimal()Ljava/math/BigDecimal;

    move-result-object v1

    iput-object v1, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberBigDecimal:Ljava/math/BigDecimal;

    .line 415
    const/16 v1, 0x10

    iput v1, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    .line 425
    :goto_0
    return-void

    .line 418
    :cond_0
    iget-object v1, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_textBuffer:Lorg/codehaus/jackson/util/TextBuffer;

    invoke-virtual {v1}, Lorg/codehaus/jackson/util/TextBuffer;->contentsAsDouble()D

    move-result-wide v1

    iput-wide v1, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberDouble:D

    .line 419
    const/16 v1, 0x8

    iput v1, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 421
    :catch_0
    move-exception v0

    .line 423
    .local v0, "nex":Ljava/lang/NumberFormatException;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Malformed numeric value \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_textBuffer:Lorg/codehaus/jackson/util/TextBuffer;

    invoke-virtual {v2}, Lorg/codehaus/jackson/util/TextBuffer;->contentsAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_wrapError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private final _parseSlowIntValue(I[CII)V
    .locals 4
    .param p1, "expType"    # I
    .param p2, "buf"    # [C
    .param p3, "offset"    # I
    .param p4, "len"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/codehaus/jackson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 430
    iget-object v2, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_textBuffer:Lorg/codehaus/jackson/util/TextBuffer;

    invoke-virtual {v2}, Lorg/codehaus/jackson/util/TextBuffer;->contentsAsString()Ljava/lang/String;

    move-result-object v1

    .line 433
    .local v1, "numStr":Ljava/lang/String;
    :try_start_0
    iget-boolean v2, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberNegative:Z

    invoke-static {p2, p3, p4, v2}, Lorg/codehaus/jackson/io/NumberInput;->inLongRange([CIIZ)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 435
    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberLong:J

    .line 436
    const/4 v2, 0x2

    iput v2, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    .line 446
    :goto_0
    return-void

    .line 439
    :cond_0
    new-instance v2, Ljava/math/BigInteger;

    invoke-direct {v2, v1}, Ljava/math/BigInteger;-><init>(Ljava/lang/String;)V

    iput-object v2, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberBigInt:Ljava/math/BigInteger;

    .line 440
    const/4 v2, 0x4

    iput v2, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 442
    :catch_0
    move-exception v0

    .line 444
    .local v0, "nex":Ljava/lang/NumberFormatException;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Malformed numeric value \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2, v0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_wrapError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method protected _parseNumericValue(I)V
    .locals 9
    .param p1, "expType"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/codehaus/jackson/JsonParseException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x1

    .line 354
    iget-object v6, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_currToken:Lorg/codehaus/jackson/JsonToken;

    sget-object v7, Lorg/codehaus/jackson/JsonToken;->VALUE_NUMBER_INT:Lorg/codehaus/jackson/JsonToken;

    if-ne v6, v7, :cond_7

    .line 355
    iget-object v6, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_textBuffer:Lorg/codehaus/jackson/util/TextBuffer;

    invoke-virtual {v6}, Lorg/codehaus/jackson/util/TextBuffer;->getTextBuffer()[C

    move-result-object v0

    .line 356
    .local v0, "buf":[C
    iget-object v6, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_textBuffer:Lorg/codehaus/jackson/util/TextBuffer;

    invoke-virtual {v6}, Lorg/codehaus/jackson/util/TextBuffer;->getTextOffset()I

    move-result v5

    .line 357
    .local v5, "offset":I
    iget v4, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_intLength:I

    .line 358
    .local v4, "len":I
    iget-boolean v6, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberNegative:Z

    if-eqz v6, :cond_0

    .line 359
    add-int/lit8 v5, v5, 0x1

    .line 361
    :cond_0
    const/16 v6, 0x9

    if-gt v4, v6, :cond_2

    .line 362
    invoke-static {v0, v5, v4}, Lorg/codehaus/jackson/io/NumberInput;->parseInt([CII)I

    move-result v1

    .line 363
    .local v1, "i":I
    iget-boolean v6, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberNegative:Z

    if-eqz v6, :cond_1

    neg-int v1, v1

    .end local v1    # "i":I
    :cond_1
    iput v1, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberInt:I

    .line 364
    iput v8, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    .line 400
    .end local v0    # "buf":[C
    .end local v4    # "len":I
    .end local v5    # "offset":I
    :goto_0
    return-void

    .line 367
    .restart local v0    # "buf":[C
    .restart local v4    # "len":I
    .restart local v5    # "offset":I
    :cond_2
    const/16 v6, 0x12

    if-gt v4, v6, :cond_6

    .line 368
    invoke-static {v0, v5, v4}, Lorg/codehaus/jackson/io/NumberInput;->parseLong([CII)J

    move-result-wide v2

    .line 369
    .local v2, "l":J
    iget-boolean v6, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberNegative:Z

    if-eqz v6, :cond_3

    .line 370
    neg-long v2, v2

    .line 373
    :cond_3
    const/16 v6, 0xa

    if-ne v4, v6, :cond_5

    .line 374
    iget-boolean v6, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberNegative:Z

    if-eqz v6, :cond_4

    .line 375
    const-wide/32 v6, -0x80000000

    cmp-long v6, v2, v6

    if-ltz v6, :cond_5

    .line 376
    long-to-int v6, v2

    iput v6, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberInt:I

    .line 377
    iput v8, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    goto :goto_0

    .line 381
    :cond_4
    const-wide/32 v6, 0x7fffffff

    cmp-long v6, v2, v6

    if-gtz v6, :cond_5

    .line 382
    long-to-int v6, v2

    iput v6, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberInt:I

    .line 383
    iput v8, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    goto :goto_0

    .line 388
    :cond_5
    iput-wide v2, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberLong:J

    .line 389
    const/4 v6, 0x2

    iput v6, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    goto :goto_0

    .line 392
    .end local v2    # "l":J
    :cond_6
    invoke-direct {p0, p1, v0, v5, v4}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_parseSlowIntValue(I[CII)V

    goto :goto_0

    .line 395
    .end local v0    # "buf":[C
    .end local v4    # "len":I
    .end local v5    # "offset":I
    :cond_7
    iget-object v6, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_currToken:Lorg/codehaus/jackson/JsonToken;

    sget-object v7, Lorg/codehaus/jackson/JsonToken;->VALUE_NUMBER_FLOAT:Lorg/codehaus/jackson/JsonToken;

    if-ne v6, v7, :cond_8

    .line 396
    invoke-direct {p0, p1}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_parseSlowFloatValue(I)V

    goto :goto_0

    .line 399
    :cond_8
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "Current token ("

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_currToken:Lorg/codehaus/jackson/JsonToken;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, ") not numeric, can not use numeric value accessors"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_reportError(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected convertNumberToLong()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/codehaus/jackson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 490
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_0

    .line 491
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberInt:I

    int-to-long v0, v0

    iput-wide v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberLong:J

    .line 511
    :goto_0
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    .line 512
    return-void

    .line 492
    :cond_0
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    and-int/lit8 v0, v0, 0x4

    if-eqz v0, :cond_1

    .line 494
    iget-object v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberBigInt:Ljava/math/BigInteger;

    invoke-virtual {v0}, Ljava/math/BigInteger;->longValue()J

    move-result-wide v0

    iput-wide v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberLong:J

    goto :goto_0

    .line 495
    :cond_1
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    and-int/lit8 v0, v0, 0x8

    if-eqz v0, :cond_4

    .line 497
    iget-wide v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberDouble:D

    const-wide/high16 v2, -0x3c20000000000000L    # -9.223372036854776E18

    cmpg-double v0, v0, v2

    if-ltz v0, :cond_2

    iget-wide v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberDouble:D

    const-wide/high16 v2, 0x43e0000000000000L    # 9.223372036854776E18

    cmpl-double v0, v0, v2

    if-lez v0, :cond_3

    .line 498
    :cond_2
    invoke-virtual {p0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->reportOverflowLong()V

    .line 500
    :cond_3
    iget-wide v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberDouble:D

    double-to-long v0, v0

    iput-wide v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberLong:J

    goto :goto_0

    .line 501
    :cond_4
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    and-int/lit8 v0, v0, 0x10

    if-eqz v0, :cond_7

    .line 502
    sget-object v0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->BD_MIN_LONG:Ljava/math/BigDecimal;

    iget-object v1, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberBigDecimal:Ljava/math/BigDecimal;

    invoke-virtual {v0, v1}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v0

    if-gtz v0, :cond_5

    sget-object v0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->BD_MAX_LONG:Ljava/math/BigDecimal;

    iget-object v1, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberBigDecimal:Ljava/math/BigDecimal;

    invoke-virtual {v0, v1}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v0

    if-gez v0, :cond_6

    .line 504
    :cond_5
    invoke-virtual {p0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->reportOverflowLong()V

    .line 506
    :cond_6
    iget-object v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberBigDecimal:Ljava/math/BigDecimal;

    invoke-virtual {v0}, Ljava/math/BigDecimal;->longValue()J

    move-result-wide v0

    iput-wide v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberLong:J

    goto :goto_0

    .line 508
    :cond_7
    invoke-virtual {p0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_throwInternal()V

    goto :goto_0
.end method

.method public getLongValue()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/codehaus/jackson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 266
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    and-int/lit8 v0, v0, 0x2

    if-nez v0, :cond_1

    .line 267
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    if-nez v0, :cond_0

    .line 268
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_parseNumericValue(I)V

    .line 270
    :cond_0
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    and-int/lit8 v0, v0, 0x2

    if-nez v0, :cond_1

    .line 271
    invoke-virtual {p0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->convertNumberToLong()V

    .line 274
    :cond_1
    iget-wide v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberLong:J

    return-wide v0
.end method

.method public getNumberValue()Ljava/lang/Number;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/codehaus/jackson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 191
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    if-nez v0, :cond_0

    .line 192
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_parseNumericValue(I)V

    .line 195
    :cond_0
    iget-object v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_currToken:Lorg/codehaus/jackson/JsonToken;

    sget-object v1, Lorg/codehaus/jackson/JsonToken;->VALUE_NUMBER_INT:Lorg/codehaus/jackson/JsonToken;

    if-ne v0, v1, :cond_4

    .line 196
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_1

    .line 197
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberInt:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 218
    :goto_0
    return-object v0

    .line 199
    :cond_1
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_2

    .line 200
    iget-wide v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberLong:J

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    goto :goto_0

    .line 202
    :cond_2
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    and-int/lit8 v0, v0, 0x4

    if-eqz v0, :cond_3

    .line 203
    iget-object v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberBigInt:Ljava/math/BigInteger;

    goto :goto_0

    .line 206
    :cond_3
    iget-object v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberBigDecimal:Ljava/math/BigDecimal;

    goto :goto_0

    .line 212
    :cond_4
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    and-int/lit8 v0, v0, 0x10

    if-eqz v0, :cond_5

    .line 213
    iget-object v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberBigDecimal:Ljava/math/BigDecimal;

    goto :goto_0

    .line 215
    :cond_5
    iget v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    and-int/lit8 v0, v0, 0x8

    if-nez v0, :cond_6

    .line 216
    invoke-virtual {p0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_throwInternal()V

    .line 218
    :cond_6
    iget-wide v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberDouble:D

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    goto :goto_0
.end method

.method protected reportInvalidNumber(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/codehaus/jackson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 602
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "Invalid numeric value: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_reportError(Ljava/lang/String;)V

    .line 603
    return-void
.end method

.method protected reportOverflowLong()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/codehaus/jackson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 615
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "Numeric value ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->getText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ") out of range of long ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-wide/high16 v1, -0x8000000000000000L

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-wide v1, 0x7fffffffffffffffL

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_reportError(Ljava/lang/String;)V

    .line 616
    return-void
.end method

.method protected reportUnexpectedNumberChar(ILjava/lang/String;)V
    .locals 3
    .param p1, "ch"    # I
    .param p2, "comment"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/codehaus/jackson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 592
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Unexpected character ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p1}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_getCharDesc(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ") in numeric value"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 593
    .local v0, "msg":Ljava/lang/String;
    if-eqz p2, :cond_0

    .line 594
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 596
    :cond_0
    invoke-virtual {p0, v0}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_reportError(Ljava/lang/String;)V

    .line 597
    return-void
.end method

.method protected final reset(ZIII)Lorg/codehaus/jackson/JsonToken;
    .locals 1
    .param p1, "negative"    # Z
    .param p2, "intLen"    # I
    .param p3, "fractLen"    # I
    .param p4, "expLen"    # I

    .prologue
    const/4 v0, 0x1

    .line 148
    if-ge p3, v0, :cond_0

    if-ge p4, v0, :cond_0

    .line 149
    invoke-virtual {p0, p1, p2}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->resetInt(ZI)Lorg/codehaus/jackson/JsonToken;

    move-result-object v0

    .line 151
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0, p1, p2, p3, p4}, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->resetFloat(ZIII)Lorg/codehaus/jackson/JsonToken;

    move-result-object v0

    goto :goto_0
.end method

.method protected final resetAsNaN(Ljava/lang/String;D)Lorg/codehaus/jackson/JsonToken;
    .locals 1
    .param p1, "valueStr"    # Ljava/lang/String;
    .param p2, "value"    # D

    .prologue
    .line 176
    iget-object v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_textBuffer:Lorg/codehaus/jackson/util/TextBuffer;

    invoke-virtual {v0, p1}, Lorg/codehaus/jackson/util/TextBuffer;->resetWithString(Ljava/lang/String;)V

    .line 177
    iput-wide p2, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberDouble:D

    .line 178
    const/16 v0, 0x8

    iput v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    .line 179
    sget-object v0, Lorg/codehaus/jackson/JsonToken;->VALUE_NUMBER_FLOAT:Lorg/codehaus/jackson/JsonToken;

    return-object v0
.end method

.method protected final resetFloat(ZIII)Lorg/codehaus/jackson/JsonToken;
    .locals 1
    .param p1, "negative"    # Z
    .param p2, "intLen"    # I
    .param p3, "fractLen"    # I
    .param p4, "expLen"    # I

    .prologue
    .line 166
    iput-boolean p1, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberNegative:Z

    .line 167
    iput p2, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_intLength:I

    .line 168
    iput p3, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_fractLength:I

    .line 169
    iput p4, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_expLength:I

    .line 170
    const/4 v0, 0x0

    iput v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    .line 171
    sget-object v0, Lorg/codehaus/jackson/JsonToken;->VALUE_NUMBER_FLOAT:Lorg/codehaus/jackson/JsonToken;

    return-object v0
.end method

.method protected final resetInt(ZI)Lorg/codehaus/jackson/JsonToken;
    .locals 1
    .param p1, "negative"    # Z
    .param p2, "intLen"    # I

    .prologue
    const/4 v0, 0x0

    .line 156
    iput-boolean p1, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numberNegative:Z

    .line 157
    iput p2, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_intLength:I

    .line 158
    iput v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_fractLength:I

    .line 159
    iput v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_expLength:I

    .line 160
    iput v0, p0, Lorg/codehaus/jackson/impl/JsonNumericParserBase;->_numTypesValid:I

    .line 161
    sget-object v0, Lorg/codehaus/jackson/JsonToken;->VALUE_NUMBER_INT:Lorg/codehaus/jackson/JsonToken;

    return-object v0
.end method
