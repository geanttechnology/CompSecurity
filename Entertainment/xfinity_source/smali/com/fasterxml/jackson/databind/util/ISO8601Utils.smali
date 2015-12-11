.class public Lcom/fasterxml/jackson/databind/util/ISO8601Utils;
.super Ljava/lang/Object;
.source "ISO8601Utils.java"


# static fields
.field private static final GMT_ID:Ljava/lang/String; = "GMT"

.field private static final TIMEZONE_GMT:Ljava/util/TimeZone;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    sput-object v0, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->TIMEZONE_GMT:Ljava/util/TimeZone;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static checkOffset(Ljava/lang/String;IC)V
    .locals 4
    .param p0, "value"    # Ljava/lang/String;
    .param p1, "offset"    # I
    .param p2, "expected"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IndexOutOfBoundsException;
        }
    .end annotation

    .prologue
    .line 198
    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 199
    .local v0, "found":C
    if-eq v0, p2, :cond_0

    .line 200
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Expected \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' character but found \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 202
    :cond_0
    return-void
.end method

.method public static format(Ljava/util/Date;)Ljava/lang/String;
    .locals 2
    .param p0, "date"    # Ljava/util/Date;

    .prologue
    .line 47
    const/4 v0, 0x0

    sget-object v1, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->TIMEZONE_GMT:Ljava/util/TimeZone;

    invoke-static {p0, v0, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->format(Ljava/util/Date;ZLjava/util/TimeZone;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static format(Ljava/util/Date;Z)Ljava/lang/String;
    .locals 1
    .param p0, "date"    # Ljava/util/Date;
    .param p1, "millis"    # Z

    .prologue
    .line 58
    sget-object v0, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->TIMEZONE_GMT:Ljava/util/TimeZone;

    invoke-static {p0, p1, v0}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->format(Ljava/util/Date;ZLjava/util/TimeZone;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static format(Ljava/util/Date;ZLjava/util/TimeZone;)Ljava/lang/String;
    .locals 12
    .param p0, "date"    # Ljava/util/Date;
    .param p1, "millis"    # Z
    .param p2, "tz"    # Ljava/util/TimeZone;

    .prologue
    const v11, 0xea60

    const/16 v10, 0x3a

    const/16 v7, 0x2d

    .line 70
    new-instance v0, Ljava/util/GregorianCalendar;

    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, p2, v6}, Ljava/util/GregorianCalendar;-><init>(Ljava/util/TimeZone;Ljava/util/Locale;)V

    .line 71
    .local v0, "calendar":Ljava/util/Calendar;
    invoke-virtual {v0, p0}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 74
    const-string v6, "yyyy-MM-ddThh:mm:ss"

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v1

    .line 75
    .local v1, "capacity":I
    if-eqz p1, :cond_1

    const-string v6, ".sss"

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    :goto_0
    add-int/2addr v1, v6

    .line 76
    invoke-virtual {p2}, Ljava/util/TimeZone;->getRawOffset()I

    move-result v6

    if-nez v6, :cond_2

    const-string v6, "Z"

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    :goto_1
    add-int/2addr v1, v6

    .line 77
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 79
    .local v2, "formatted":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    const-string v8, "yyyy"

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-static {v2, v6, v8}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 80
    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 81
    const/4 v6, 0x2

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    add-int/lit8 v6, v6, 0x1

    const-string v8, "MM"

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-static {v2, v6, v8}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 82
    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 83
    const/4 v6, 0x5

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    const-string v8, "dd"

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-static {v2, v6, v8}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 84
    const/16 v6, 0x54

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 85
    const/16 v6, 0xb

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    const-string v8, "hh"

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-static {v2, v6, v8}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 86
    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 87
    const/16 v6, 0xc

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    const-string v8, "mm"

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-static {v2, v6, v8}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 88
    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 89
    const/16 v6, 0xd

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    const-string v8, "ss"

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-static {v2, v6, v8}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 90
    if-eqz p1, :cond_0

    .line 91
    const/16 v6, 0x2e

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 92
    const/16 v6, 0xe

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    const-string v8, "sss"

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-static {v2, v6, v8}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 95
    :cond_0
    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v8

    invoke-virtual {p2, v8, v9}, Ljava/util/TimeZone;->getOffset(J)I

    move-result v5

    .line 96
    .local v5, "offset":I
    if-eqz v5, :cond_4

    .line 97
    div-int v6, v5, v11

    div-int/lit8 v6, v6, 0x3c

    invoke-static {v6}, Ljava/lang/Math;->abs(I)I

    move-result v3

    .line 98
    .local v3, "hours":I
    div-int v6, v5, v11

    rem-int/lit8 v6, v6, 0x3c

    invoke-static {v6}, Ljava/lang/Math;->abs(I)I

    move-result v4

    .line 99
    .local v4, "minutes":I
    if-gez v5, :cond_3

    move v6, v7

    :goto_2
    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 100
    const-string v6, "hh"

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    invoke-static {v2, v3, v6}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 101
    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 102
    const-string v6, "mm"

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    invoke-static {v2, v4, v6}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 107
    .end local v3    # "hours":I
    .end local v4    # "minutes":I
    :goto_3
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6

    .line 75
    .end local v2    # "formatted":Ljava/lang/StringBuilder;
    .end local v5    # "offset":I
    :cond_1
    const/4 v6, 0x0

    goto/16 :goto_0

    .line 76
    :cond_2
    const-string v6, "+hh:mm"

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    goto/16 :goto_1

    .line 99
    .restart local v2    # "formatted":Ljava/lang/StringBuilder;
    .restart local v3    # "hours":I
    .restart local v4    # "minutes":I
    .restart local v5    # "offset":I
    :cond_3
    const/16 v6, 0x2b

    goto :goto_2

    .line 104
    .end local v3    # "hours":I
    .end local v4    # "minutes":I
    :cond_4
    const/16 v6, 0x5a

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_3
.end method

.method private static padInt(Ljava/lang/StringBuilder;II)V
    .locals 3
    .param p0, "buffer"    # Ljava/lang/StringBuilder;
    .param p1, "value"    # I
    .param p2, "length"    # I

    .prologue
    .line 247
    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    .line 248
    .local v1, "strValue":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    sub-int v0, p2, v2

    .local v0, "i":I
    :goto_0
    if-lez v0, :cond_0

    .line 249
    const/16 v2, 0x30

    invoke-virtual {p0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 248
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 251
    :cond_0
    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 252
    return-void
.end method

.method public static parse(Ljava/lang/String;)Ljava/util/Date;
    .locals 19
    .param p0, "date"    # Ljava/lang/String;

    .prologue
    .line 125
    const/4 v9, 0x0

    .line 128
    .local v9, "offset":I
    add-int/lit8 v10, v9, 0x4

    .end local v9    # "offset":I
    .local v10, "offset":I
    :try_start_0
    move-object/from16 v0, p0

    invoke-static {v0, v9, v10}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v15

    .line 129
    .local v15, "year":I
    const/16 v16, 0x2d

    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-static {v0, v10, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 132
    add-int/lit8 v9, v10, 0x1

    .end local v10    # "offset":I
    .restart local v9    # "offset":I
    add-int/lit8 v10, v9, 0x2

    .end local v9    # "offset":I
    .restart local v10    # "offset":I
    move-object/from16 v0, p0

    invoke-static {v0, v9, v10}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v8

    .line 133
    .local v8, "month":I
    const/16 v16, 0x2d

    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-static {v0, v10, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 136
    add-int/lit8 v9, v10, 0x1

    .end local v10    # "offset":I
    .restart local v9    # "offset":I
    add-int/lit8 v10, v9, 0x2

    .end local v9    # "offset":I
    .restart local v10    # "offset":I
    move-object/from16 v0, p0

    invoke-static {v0, v9, v10}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v3

    .line 137
    .local v3, "day":I
    const/16 v16, 0x54

    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-static {v0, v10, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 140
    add-int/lit8 v9, v10, 0x1

    .end local v10    # "offset":I
    .restart local v9    # "offset":I
    add-int/lit8 v10, v9, 0x2

    .end local v9    # "offset":I
    .restart local v10    # "offset":I
    move-object/from16 v0, p0

    invoke-static {v0, v9, v10}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v5

    .line 141
    .local v5, "hour":I
    const/16 v16, 0x3a

    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-static {v0, v10, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 143
    add-int/lit8 v9, v10, 0x1

    .end local v10    # "offset":I
    .restart local v9    # "offset":I
    add-int/lit8 v10, v9, 0x2

    .end local v9    # "offset":I
    .restart local v10    # "offset":I
    move-object/from16 v0, p0

    invoke-static {v0, v9, v10}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v7

    .line 144
    .local v7, "minutes":I
    const/16 v16, 0x3a

    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-static {v0, v10, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 146
    add-int/lit8 v9, v10, 0x1

    .end local v10    # "offset":I
    .restart local v9    # "offset":I
    add-int/lit8 v10, v9, 0x2

    .end local v9    # "offset":I
    .restart local v10    # "offset":I
    move-object/from16 v0, p0

    invoke-static {v0, v9, v10}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v11

    .line 148
    .local v11, "seconds":I
    const/4 v6, 0x0

    .line 149
    .local v6, "milliseconds":I
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Ljava/lang/String;->charAt(I)C

    move-result v16

    const/16 v17, 0x2e

    move/from16 v0, v16

    move/from16 v1, v17

    if-ne v0, v1, :cond_4

    .line 150
    const/16 v16, 0x2e

    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-static {v0, v10, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 151
    add-int/lit8 v9, v10, 0x1

    .end local v10    # "offset":I
    .restart local v9    # "offset":I
    add-int/lit8 v10, v9, 0x3

    .end local v9    # "offset":I
    .restart local v10    # "offset":I
    move-object/from16 v0, p0

    invoke-static {v0, v9, v10}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_5
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2

    move-result v6

    move v9, v10

    .line 156
    .end local v10    # "offset":I
    .restart local v9    # "offset":I
    :goto_0
    :try_start_1
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Ljava/lang/String;->charAt(I)C

    move-result v14

    .line 157
    .local v14, "timezoneIndicator":C
    const/16 v16, 0x2b

    move/from16 v0, v16

    if-eq v14, v0, :cond_0

    const/16 v16, 0x2d

    move/from16 v0, v16

    if-ne v14, v0, :cond_1

    .line 158
    :cond_0
    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "GMT"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 164
    .local v13, "timezoneId":Ljava/lang/String;
    :goto_1
    invoke-static {v13}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v12

    .line 165
    .local v12, "timezone":Ljava/util/TimeZone;
    invoke-virtual {v12}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v16

    if-nez v16, :cond_3

    .line 166
    new-instance v16, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct/range {v16 .. v16}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v16
    :try_end_1
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_3

    .line 180
    .end local v12    # "timezone":Ljava/util/TimeZone;
    .end local v13    # "timezoneId":Ljava/lang/String;
    .end local v14    # "timezoneIndicator":C
    :catch_0
    move-exception v4

    .line 181
    .end local v3    # "day":I
    .end local v5    # "hour":I
    .end local v6    # "milliseconds":I
    .end local v7    # "minutes":I
    .end local v8    # "month":I
    .end local v11    # "seconds":I
    .end local v15    # "year":I
    .local v4, "e":Ljava/lang/IndexOutOfBoundsException;
    :goto_2
    new-instance v16, Ljava/lang/IllegalArgumentException;

    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "Failed to parse date "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-direct {v0, v1, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v16

    .line 159
    .end local v4    # "e":Ljava/lang/IndexOutOfBoundsException;
    .restart local v3    # "day":I
    .restart local v5    # "hour":I
    .restart local v6    # "milliseconds":I
    .restart local v7    # "minutes":I
    .restart local v8    # "month":I
    .restart local v11    # "seconds":I
    .restart local v14    # "timezoneIndicator":C
    .restart local v15    # "year":I
    :cond_1
    const/16 v16, 0x5a

    move/from16 v0, v16

    if-ne v14, v0, :cond_2

    .line 160
    :try_start_2
    const-string v13, "GMT"

    .restart local v13    # "timezoneId":Ljava/lang/String;
    goto :goto_1

    .line 162
    .end local v13    # "timezoneId":Ljava/lang/String;
    :cond_2
    new-instance v16, Ljava/lang/IndexOutOfBoundsException;

    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "Invalid time zone indicator "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-direct/range {v16 .. v17}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v16
    :try_end_2
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_3

    .line 182
    .end local v14    # "timezoneIndicator":C
    :catch_1
    move-exception v4

    .line 183
    .end local v3    # "day":I
    .end local v5    # "hour":I
    .end local v6    # "milliseconds":I
    .end local v7    # "minutes":I
    .end local v8    # "month":I
    .end local v11    # "seconds":I
    .end local v15    # "year":I
    .local v4, "e":Ljava/lang/NumberFormatException;
    :goto_3
    new-instance v16, Ljava/lang/IllegalArgumentException;

    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "Failed to parse date "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-direct {v0, v1, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v16

    .line 169
    .end local v4    # "e":Ljava/lang/NumberFormatException;
    .restart local v3    # "day":I
    .restart local v5    # "hour":I
    .restart local v6    # "milliseconds":I
    .restart local v7    # "minutes":I
    .restart local v8    # "month":I
    .restart local v11    # "seconds":I
    .restart local v12    # "timezone":Ljava/util/TimeZone;
    .restart local v13    # "timezoneId":Ljava/lang/String;
    .restart local v14    # "timezoneIndicator":C
    .restart local v15    # "year":I
    :cond_3
    :try_start_3
    new-instance v2, Ljava/util/GregorianCalendar;

    invoke-direct {v2, v12}, Ljava/util/GregorianCalendar;-><init>(Ljava/util/TimeZone;)V

    .line 170
    .local v2, "calendar":Ljava/util/Calendar;
    const/16 v16, 0x0

    move/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/util/Calendar;->setLenient(Z)V

    .line 171
    const/16 v16, 0x1

    move/from16 v0, v16

    invoke-virtual {v2, v0, v15}, Ljava/util/Calendar;->set(II)V

    .line 172
    const/16 v16, 0x2

    add-int/lit8 v17, v8, -0x1

    move/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v2, v0, v1}, Ljava/util/Calendar;->set(II)V

    .line 173
    const/16 v16, 0x5

    move/from16 v0, v16

    invoke-virtual {v2, v0, v3}, Ljava/util/Calendar;->set(II)V

    .line 174
    const/16 v16, 0xb

    move/from16 v0, v16

    invoke-virtual {v2, v0, v5}, Ljava/util/Calendar;->set(II)V

    .line 175
    const/16 v16, 0xc

    move/from16 v0, v16

    invoke-virtual {v2, v0, v7}, Ljava/util/Calendar;->set(II)V

    .line 176
    const/16 v16, 0xd

    move/from16 v0, v16

    invoke-virtual {v2, v0, v11}, Ljava/util/Calendar;->set(II)V

    .line 177
    const/16 v16, 0xe

    move/from16 v0, v16

    invoke-virtual {v2, v0, v6}, Ljava/util/Calendar;->set(II)V

    .line 179
    invoke-virtual {v2}, Ljava/util/Calendar;->getTime()Ljava/util/Date;
    :try_end_3
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/NumberFormatException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_3 .. :try_end_3} :catch_3

    move-result-object v16

    return-object v16

    .line 184
    .end local v2    # "calendar":Ljava/util/Calendar;
    .end local v3    # "day":I
    .end local v5    # "hour":I
    .end local v6    # "milliseconds":I
    .end local v7    # "minutes":I
    .end local v8    # "month":I
    .end local v9    # "offset":I
    .end local v11    # "seconds":I
    .end local v12    # "timezone":Ljava/util/TimeZone;
    .end local v13    # "timezoneId":Ljava/lang/String;
    .end local v14    # "timezoneIndicator":C
    .end local v15    # "year":I
    .restart local v10    # "offset":I
    :catch_2
    move-exception v4

    move v9, v10

    .line 185
    .end local v10    # "offset":I
    .local v4, "e":Ljava/lang/IllegalArgumentException;
    .restart local v9    # "offset":I
    :goto_4
    new-instance v16, Ljava/lang/IllegalArgumentException;

    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "Failed to parse date "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-direct {v0, v1, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v16

    .line 184
    .end local v4    # "e":Ljava/lang/IllegalArgumentException;
    .restart local v3    # "day":I
    .restart local v5    # "hour":I
    .restart local v6    # "milliseconds":I
    .restart local v7    # "minutes":I
    .restart local v8    # "month":I
    .restart local v11    # "seconds":I
    .restart local v15    # "year":I
    :catch_3
    move-exception v4

    goto :goto_4

    .line 182
    .end local v3    # "day":I
    .end local v5    # "hour":I
    .end local v6    # "milliseconds":I
    .end local v7    # "minutes":I
    .end local v8    # "month":I
    .end local v9    # "offset":I
    .end local v11    # "seconds":I
    .end local v15    # "year":I
    .restart local v10    # "offset":I
    :catch_4
    move-exception v4

    move v9, v10

    .end local v10    # "offset":I
    .restart local v9    # "offset":I
    goto/16 :goto_3

    .line 180
    .end local v9    # "offset":I
    .restart local v10    # "offset":I
    :catch_5
    move-exception v4

    move v9, v10

    .end local v10    # "offset":I
    .restart local v9    # "offset":I
    goto/16 :goto_2

    .end local v9    # "offset":I
    .restart local v3    # "day":I
    .restart local v5    # "hour":I
    .restart local v6    # "milliseconds":I
    .restart local v7    # "minutes":I
    .restart local v8    # "month":I
    .restart local v10    # "offset":I
    .restart local v11    # "seconds":I
    .restart local v15    # "year":I
    :cond_4
    move v9, v10

    .end local v10    # "offset":I
    .restart local v9    # "offset":I
    goto/16 :goto_0
.end method

.method private static parseInt(Ljava/lang/String;II)I
    .locals 7
    .param p0, "value"    # Ljava/lang/String;
    .param p1, "beginIndex"    # I
    .param p2, "endIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NumberFormatException;
        }
    .end annotation

    .prologue
    const/16 v5, 0xa

    .line 214
    if-ltz p1, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    if-gt p2, v4, :cond_0

    if-le p1, p2, :cond_1

    .line 215
    :cond_0
    new-instance v4, Ljava/lang/NumberFormatException;

    invoke-direct {v4, p0}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 218
    :cond_1
    move v1, p1

    .line 219
    .local v1, "i":I
    const/4 v3, 0x0

    .line 221
    .local v3, "result":I
    if-ge v1, p2, :cond_5

    .line 222
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "i":I
    .local v2, "i":I
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4, v5}, Ljava/lang/Character;->digit(CI)I

    move-result v0

    .line 223
    .local v0, "digit":I
    if-gez v0, :cond_2

    .line 224
    new-instance v4, Ljava/lang/NumberFormatException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Invalid number: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 226
    :cond_2
    neg-int v3, v0

    .line 228
    .end local v0    # "digit":I
    :goto_0
    if-ge v2, p2, :cond_4

    .line 229
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4, v5}, Ljava/lang/Character;->digit(CI)I

    move-result v0

    .line 230
    .restart local v0    # "digit":I
    if-gez v0, :cond_3

    .line 231
    new-instance v4, Ljava/lang/NumberFormatException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Invalid number: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 233
    :cond_3
    mul-int/lit8 v3, v3, 0xa

    .line 234
    sub-int/2addr v3, v0

    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto :goto_0

    .line 236
    .end local v0    # "digit":I
    :cond_4
    neg-int v4, v3

    return v4

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :cond_5
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto :goto_0
.end method

.method public static timeZoneGMT()Ljava/util/TimeZone;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->TIMEZONE_GMT:Ljava/util/TimeZone;

    return-object v0
.end method
