.class public Lorg/apache/commons/lang3/time/DurationFormatUtils;
.super Ljava/lang/Object;
.source "DurationFormatUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;
    }
.end annotation


# static fields
.field static final H:Ljava/lang/Object;

.field static final M:Ljava/lang/Object;

.field static final S:Ljava/lang/Object;

.field static final d:Ljava/lang/Object;

.field static final m:Ljava/lang/Object;

.field static final s:Ljava/lang/Object;

.field static final y:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 469
    const-string v0, "y"

    sput-object v0, Lorg/apache/commons/lang3/time/DurationFormatUtils;->y:Ljava/lang/Object;

    .line 470
    const-string v0, "M"

    sput-object v0, Lorg/apache/commons/lang3/time/DurationFormatUtils;->M:Ljava/lang/Object;

    .line 471
    const-string v0, "d"

    sput-object v0, Lorg/apache/commons/lang3/time/DurationFormatUtils;->d:Ljava/lang/Object;

    .line 472
    const-string v0, "H"

    sput-object v0, Lorg/apache/commons/lang3/time/DurationFormatUtils;->H:Ljava/lang/Object;

    .line 473
    const-string v0, "m"

    sput-object v0, Lorg/apache/commons/lang3/time/DurationFormatUtils;->m:Ljava/lang/Object;

    .line 474
    const-string v0, "s"

    sput-object v0, Lorg/apache/commons/lang3/time/DurationFormatUtils;->s:Ljava/lang/Object;

    .line 475
    const-string v0, "S"

    sput-object v0, Lorg/apache/commons/lang3/time/DurationFormatUtils;->S:Ljava/lang/Object;

    return-void
.end method

.method static format([Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;IIIIIIIZ)Ljava/lang/String;
    .locals 11
    .param p0, "tokens"    # [Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;
    .param p1, "years"    # I
    .param p2, "months"    # I
    .param p3, "days"    # I
    .param p4, "hours"    # I
    .param p5, "minutes"    # I
    .param p6, "seconds"    # I
    .param p7, "milliseconds"    # I
    .param p8, "padWithZeros"    # Z

    .prologue
    .line 416
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 417
    .local v1, "buffer":Ljava/lang/StringBuffer;
    const/4 v4, 0x0

    .line 418
    .local v4, "lastOutputSeconds":Z
    array-length v6, p0

    .line 419
    .local v6, "sz":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v6, :cond_11

    .line 420
    aget-object v7, p0, v3

    .line 421
    .local v7, "token":Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;
    invoke-virtual {v7}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;->getValue()Ljava/lang/Object;

    move-result-object v8

    .line 422
    .local v8, "value":Ljava/lang/Object;
    invoke-virtual {v7}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;->getCount()I

    move-result v2

    .line 423
    .local v2, "count":I
    instance-of v9, v8, Ljava/lang/StringBuffer;

    if-eqz v9, :cond_1

    .line 424
    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 419
    :cond_0
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 426
    :cond_1
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->y:Ljava/lang/Object;

    if-ne v8, v9, :cond_3

    .line 427
    if-eqz p8, :cond_2

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x30

    invoke-static {v9, v2, v10}, Lorg/apache/commons/lang3/StringUtils;->leftPad(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v9

    :goto_2
    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 429
    const/4 v4, 0x0

    goto :goto_1

    .line 427
    :cond_2
    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    goto :goto_2

    .line 430
    :cond_3
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->M:Ljava/lang/Object;

    if-ne v8, v9, :cond_5

    .line 431
    if-eqz p8, :cond_4

    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x30

    invoke-static {v9, v2, v10}, Lorg/apache/commons/lang3/StringUtils;->leftPad(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v9

    :goto_3
    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 433
    const/4 v4, 0x0

    goto :goto_1

    .line 431
    :cond_4
    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    goto :goto_3

    .line 434
    :cond_5
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->d:Ljava/lang/Object;

    if-ne v8, v9, :cond_7

    .line 435
    if-eqz p8, :cond_6

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x30

    invoke-static {v9, v2, v10}, Lorg/apache/commons/lang3/StringUtils;->leftPad(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v9

    :goto_4
    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 437
    const/4 v4, 0x0

    goto :goto_1

    .line 435
    :cond_6
    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    goto :goto_4

    .line 438
    :cond_7
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->H:Ljava/lang/Object;

    if-ne v8, v9, :cond_9

    .line 439
    if-eqz p8, :cond_8

    invoke-static {p4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x30

    invoke-static {v9, v2, v10}, Lorg/apache/commons/lang3/StringUtils;->leftPad(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v9

    :goto_5
    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 441
    const/4 v4, 0x0

    goto :goto_1

    .line 439
    :cond_8
    invoke-static {p4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    goto :goto_5

    .line 442
    :cond_9
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->m:Ljava/lang/Object;

    if-ne v8, v9, :cond_b

    .line 443
    if-eqz p8, :cond_a

    invoke-static/range {p5 .. p5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x30

    invoke-static {v9, v2, v10}, Lorg/apache/commons/lang3/StringUtils;->leftPad(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v9

    :goto_6
    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 445
    const/4 v4, 0x0

    goto :goto_1

    .line 443
    :cond_a
    invoke-static/range {p5 .. p5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    goto :goto_6

    .line 446
    :cond_b
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->s:Ljava/lang/Object;

    if-ne v8, v9, :cond_d

    .line 447
    if-eqz p8, :cond_c

    invoke-static/range {p6 .. p6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x30

    invoke-static {v9, v2, v10}, Lorg/apache/commons/lang3/StringUtils;->leftPad(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v9

    :goto_7
    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 449
    const/4 v4, 0x1

    goto/16 :goto_1

    .line 447
    :cond_c
    invoke-static/range {p6 .. p6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    goto :goto_7

    .line 450
    :cond_d
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->S:Ljava/lang/Object;

    if-ne v8, v9, :cond_0

    .line 451
    if-eqz v4, :cond_f

    .line 452
    move/from16 v0, p7

    add-int/lit16 v0, v0, 0x3e8

    move/from16 p7, v0

    .line 453
    if-eqz p8, :cond_e

    invoke-static/range {p7 .. p7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x30

    invoke-static {v9, v2, v10}, Lorg/apache/commons/lang3/StringUtils;->leftPad(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v5

    .line 456
    .local v5, "str":Ljava/lang/String;
    :goto_8
    const/4 v9, 0x1

    invoke-virtual {v5, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 462
    .end local v5    # "str":Ljava/lang/String;
    :goto_9
    const/4 v4, 0x0

    goto/16 :goto_1

    .line 453
    :cond_e
    invoke-static/range {p7 .. p7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    goto :goto_8

    .line 458
    :cond_f
    if-eqz p8, :cond_10

    invoke-static/range {p7 .. p7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x30

    invoke-static {v9, v2, v10}, Lorg/apache/commons/lang3/StringUtils;->leftPad(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v9

    :goto_a
    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_9

    :cond_10
    invoke-static/range {p7 .. p7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    goto :goto_a

    .line 466
    .end local v2    # "count":I
    .end local v7    # "token":Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;
    .end local v8    # "value":Ljava/lang/Object;
    :cond_11
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    return-object v9
.end method

.method public static formatDuration(JLjava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "durationMillis"    # J
    .param p2, "format"    # Ljava/lang/String;

    .prologue
    .line 106
    const/4 v0, 0x1

    invoke-static {p0, p1, p2, v0}, Lorg/apache/commons/lang3/time/DurationFormatUtils;->formatDuration(JLjava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatDuration(JLjava/lang/String;Z)Ljava/lang/String;
    .locals 12
    .param p0, "durationMillis"    # J
    .param p2, "format"    # Ljava/lang/String;
    .param p3, "padWithZeros"    # Z

    .prologue
    .line 124
    invoke-static {p2}, Lorg/apache/commons/lang3/time/DurationFormatUtils;->lexx(Ljava/lang/String;)[Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;

    move-result-object v0

    .line 126
    .local v0, "tokens":[Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;
    const/4 v3, 0x0

    .line 127
    .local v3, "days":I
    const/4 v4, 0x0

    .line 128
    .local v4, "hours":I
    const/4 v5, 0x0

    .line 129
    .local v5, "minutes":I
    const/4 v6, 0x0

    .line 130
    .local v6, "seconds":I
    const/4 v7, 0x0

    .line 132
    .local v7, "milliseconds":I
    sget-object v1, Lorg/apache/commons/lang3/time/DurationFormatUtils;->d:Ljava/lang/Object;

    invoke-static {v0, v1}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;->containsTokenWithValue([Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 133
    const-wide/32 v8, 0x5265c00

    div-long v8, p0, v8

    long-to-int v3, v8

    .line 134
    int-to-long v8, v3

    const-wide/32 v10, 0x5265c00

    mul-long/2addr v8, v10

    sub-long/2addr p0, v8

    .line 136
    :cond_0
    sget-object v1, Lorg/apache/commons/lang3/time/DurationFormatUtils;->H:Ljava/lang/Object;

    invoke-static {v0, v1}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;->containsTokenWithValue([Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 137
    const-wide/32 v8, 0x36ee80

    div-long v8, p0, v8

    long-to-int v4, v8

    .line 138
    int-to-long v8, v4

    const-wide/32 v10, 0x36ee80

    mul-long/2addr v8, v10

    sub-long/2addr p0, v8

    .line 140
    :cond_1
    sget-object v1, Lorg/apache/commons/lang3/time/DurationFormatUtils;->m:Ljava/lang/Object;

    invoke-static {v0, v1}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;->containsTokenWithValue([Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 141
    const-wide/32 v8, 0xea60

    div-long v8, p0, v8

    long-to-int v5, v8

    .line 142
    int-to-long v8, v5

    const-wide/32 v10, 0xea60

    mul-long/2addr v8, v10

    sub-long/2addr p0, v8

    .line 144
    :cond_2
    sget-object v1, Lorg/apache/commons/lang3/time/DurationFormatUtils;->s:Ljava/lang/Object;

    invoke-static {v0, v1}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;->containsTokenWithValue([Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 145
    const-wide/16 v8, 0x3e8

    div-long v8, p0, v8

    long-to-int v6, v8

    .line 146
    int-to-long v8, v6

    const-wide/16 v10, 0x3e8

    mul-long/2addr v8, v10

    sub-long/2addr p0, v8

    .line 148
    :cond_3
    sget-object v1, Lorg/apache/commons/lang3/time/DurationFormatUtils;->S:Ljava/lang/Object;

    invoke-static {v0, v1}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;->containsTokenWithValue([Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 149
    long-to-int v7, p0

    .line 152
    :cond_4
    const/4 v1, 0x0

    const/4 v2, 0x0

    move v8, p3

    invoke-static/range {v0 .. v8}, Lorg/apache/commons/lang3/time/DurationFormatUtils;->format([Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;IIIIIIIZ)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static formatDurationHMS(J)Ljava/lang/String;
    .locals 2
    .param p0, "durationMillis"    # J

    .prologue
    .line 76
    const-string v0, "H:mm:ss.SSS"

    invoke-static {p0, p1, v0}, Lorg/apache/commons/lang3/time/DurationFormatUtils;->formatDuration(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static lexx(Ljava/lang/String;)[Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;
    .locals 11
    .param p0, "format"    # Ljava/lang/String;

    .prologue
    .line 484
    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    .line 485
    .local v0, "array":[C
    new-instance v5, Ljava/util/ArrayList;

    array-length v10, v0

    invoke-direct {v5, v10}, Ljava/util/ArrayList;-><init>(I)V

    .line 487
    .local v5, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;>;"
    const/4 v4, 0x0

    .line 488
    .local v4, "inLiteral":Z
    const/4 v1, 0x0

    .line 489
    .local v1, "buffer":Ljava/lang/StringBuffer;
    const/4 v6, 0x0

    .line 490
    .local v6, "previous":Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;
    array-length v7, v0

    .line 491
    .local v7, "sz":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v7, :cond_5

    .line 492
    aget-char v2, v0, v3

    .line 493
    .local v2, "ch":C
    if-eqz v4, :cond_1

    const/16 v10, 0x27

    if-eq v2, v10, :cond_1

    .line 494
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 491
    :cond_0
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 497
    :cond_1
    const/4 v9, 0x0

    .line 498
    .local v9, "value":Ljava/lang/Object;
    sparse-switch v2, :sswitch_data_0

    .line 518
    if-nez v1, :cond_2

    .line 519
    new-instance v1, Ljava/lang/StringBuffer;

    .end local v1    # "buffer":Ljava/lang/StringBuffer;
    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 520
    .restart local v1    # "buffer":Ljava/lang/StringBuffer;
    new-instance v10, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;

    invoke-direct {v10, v1}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v5, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 522
    :cond_2
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 525
    .end local v9    # "value":Ljava/lang/Object;
    :goto_2
    if-eqz v9, :cond_0

    .line 526
    if-eqz v6, :cond_4

    invoke-virtual {v6}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;->getValue()Ljava/lang/Object;

    move-result-object v10

    if-ne v10, v9, :cond_4

    .line 527
    invoke-virtual {v6}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;->increment()V

    .line 533
    :goto_3
    const/4 v1, 0x0

    goto :goto_1

    .line 501
    .restart local v9    # "value":Ljava/lang/Object;
    :sswitch_0
    if-eqz v4, :cond_3

    .line 502
    const/4 v1, 0x0

    .line 503
    const/4 v4, 0x0

    goto :goto_2

    .line 505
    :cond_3
    new-instance v1, Ljava/lang/StringBuffer;

    .end local v1    # "buffer":Ljava/lang/StringBuffer;
    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 506
    .restart local v1    # "buffer":Ljava/lang/StringBuffer;
    new-instance v10, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;

    invoke-direct {v10, v1}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v5, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 507
    const/4 v4, 0x1

    .line 509
    goto :goto_2

    .line 510
    :sswitch_1
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->y:Ljava/lang/Object;

    goto :goto_2

    .line 511
    :sswitch_2
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->M:Ljava/lang/Object;

    goto :goto_2

    .line 512
    :sswitch_3
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->d:Ljava/lang/Object;

    goto :goto_2

    .line 513
    :sswitch_4
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->H:Ljava/lang/Object;

    goto :goto_2

    .line 514
    :sswitch_5
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->m:Ljava/lang/Object;

    goto :goto_2

    .line 515
    :sswitch_6
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->s:Ljava/lang/Object;

    goto :goto_2

    .line 516
    :sswitch_7
    sget-object v9, Lorg/apache/commons/lang3/time/DurationFormatUtils;->S:Ljava/lang/Object;

    goto :goto_2

    .line 529
    .end local v9    # "value":Ljava/lang/Object;
    :cond_4
    new-instance v8, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;

    invoke-direct {v8, v9}, Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;-><init>(Ljava/lang/Object;)V

    .line 530
    .local v8, "token":Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;
    invoke-virtual {v5, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 531
    move-object v6, v8

    goto :goto_3

    .line 536
    .end local v2    # "ch":C
    .end local v8    # "token":Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;
    :cond_5
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v10

    new-array v10, v10, [Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;

    invoke-virtual {v5, v10}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v10

    check-cast v10, [Lorg/apache/commons/lang3/time/DurationFormatUtils$Token;

    return-object v10

    .line 498
    :sswitch_data_0
    .sparse-switch
        0x27 -> :sswitch_0
        0x48 -> :sswitch_4
        0x4d -> :sswitch_2
        0x53 -> :sswitch_7
        0x64 -> :sswitch_3
        0x6d -> :sswitch_5
        0x73 -> :sswitch_6
        0x79 -> :sswitch_1
    .end sparse-switch
.end method
