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
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IndexOutOfBoundsException;
        }
    .end annotation

    .prologue
    .line 203
    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 204
    if-eq v0, p2, :cond_0

    .line 205
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

    move-result-object v0

    const-string v2, "\'"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 207
    :cond_0
    return-void
.end method

.method public static format(Ljava/util/Date;)Ljava/lang/String;
    .locals 2

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

    .prologue
    .line 58
    sget-object v0, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->TIMEZONE_GMT:Ljava/util/TimeZone;

    invoke-static {p0, p1, v0}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->format(Ljava/util/Date;ZLjava/util/TimeZone;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static format(Ljava/util/Date;ZLjava/util/TimeZone;)Ljava/lang/String;
    .locals 8

    .prologue
    const v7, 0xea60

    const/16 v6, 0x3a

    const/16 v1, 0x2d

    .line 70
    new-instance v2, Ljava/util/GregorianCalendar;

    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v2, p2, v0}, Ljava/util/GregorianCalendar;-><init>(Ljava/util/TimeZone;Ljava/util/Locale;)V

    .line 71
    invoke-virtual {v2, p0}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 74
    const-string v0, "yyyy-MM-ddThh:mm:ss"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    .line 75
    if-eqz p1, :cond_1

    const-string v0, ".sss"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    :goto_0
    add-int/2addr v3, v0

    .line 76
    invoke-virtual {p2}, Ljava/util/TimeZone;->getRawOffset()I

    move-result v0

    if-nez v0, :cond_2

    const-string v0, "Z"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    :goto_1
    add-int/2addr v0, v3

    .line 77
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 79
    const/4 v0, 0x1

    invoke-virtual {v2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const-string v4, "yyyy"

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-static {v3, v0, v4}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 80
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 81
    const/4 v0, 0x2

    invoke-virtual {v2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    const-string v4, "MM"

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-static {v3, v0, v4}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 82
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 83
    const/4 v0, 0x5

    invoke-virtual {v2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const-string v4, "dd"

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-static {v3, v0, v4}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 84
    const/16 v0, 0x54

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 85
    const/16 v0, 0xb

    invoke-virtual {v2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const-string v4, "hh"

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-static {v3, v0, v4}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 86
    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 87
    const/16 v0, 0xc

    invoke-virtual {v2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const-string v4, "mm"

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-static {v3, v0, v4}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 88
    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 89
    const/16 v0, 0xd

    invoke-virtual {v2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const-string v4, "ss"

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-static {v3, v0, v4}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 90
    if-eqz p1, :cond_0

    .line 91
    const/16 v0, 0x2e

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 92
    const/16 v0, 0xe

    invoke-virtual {v2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const-string v4, "sss"

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-static {v3, v0, v4}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 95
    :cond_0
    invoke-virtual {v2}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    invoke-virtual {p2, v4, v5}, Ljava/util/TimeZone;->getOffset(J)I

    move-result v0

    .line 96
    if-eqz v0, :cond_4

    .line 97
    div-int v2, v0, v7

    div-int/lit8 v2, v2, 0x3c

    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v2

    .line 98
    div-int v4, v0, v7

    rem-int/lit8 v4, v4, 0x3c

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v4

    .line 99
    if-gez v0, :cond_3

    move v0, v1

    :goto_2
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 100
    const-string v0, "hh"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    invoke-static {v3, v2, v0}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 101
    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 102
    const-string v0, "mm"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    invoke-static {v3, v4, v0}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 107
    :goto_3
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 75
    :cond_1
    const/4 v0, 0x0

    goto/16 :goto_0

    .line 76
    :cond_2
    const-string v0, "+hh:mm"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    goto/16 :goto_1

    .line 99
    :cond_3
    const/16 v0, 0x2b

    goto :goto_2

    .line 104
    :cond_4
    const/16 v0, 0x5a

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_3
.end method

.method private static padInt(Ljava/lang/StringBuilder;II)V
    .locals 3

    .prologue
    .line 252
    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    .line 253
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    sub-int v0, p2, v0

    :goto_0
    if-lez v0, :cond_0

    .line 254
    const/16 v2, 0x30

    invoke-virtual {p0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 253
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 256
    :cond_0
    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 257
    return-void
.end method

.method public static parse(Ljava/lang/String;)Ljava/util/Date;
    .locals 12

    .prologue
    const/16 v10, 0x2d

    const/4 v0, 0x0

    .line 125
    .line 127
    const/4 v1, 0x0

    .line 130
    const/4 v2, 0x4

    :try_start_0
    invoke-static {p0, v1, v2}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v3

    .line 131
    const/16 v1, 0x2d

    invoke-static {p0, v2, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 134
    const/4 v1, 0x5

    const/4 v2, 0x7

    invoke-static {p0, v1, v2}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v4

    .line 135
    const/16 v1, 0x2d

    invoke-static {p0, v2, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 138
    const/16 v1, 0x8

    const/16 v2, 0xa

    invoke-static {p0, v1, v2}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v5

    .line 139
    const/16 v1, 0x54

    invoke-static {p0, v2, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 142
    const/16 v1, 0xb

    const/16 v2, 0xd

    invoke-static {p0, v1, v2}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v6

    .line 143
    const/16 v1, 0x3a

    invoke-static {p0, v2, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 145
    const/16 v1, 0xe

    const/16 v2, 0x10

    invoke-static {p0, v1, v2}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v7

    .line 146
    const/16 v1, 0x3a

    invoke-static {p0, v2, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 148
    const/16 v2, 0x11

    const/16 v1, 0x13

    invoke-static {p0, v2, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v2

    .line 151
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v8

    const/16 v9, 0x2e

    if-ne v8, v9, :cond_5

    .line 152
    const/16 v0, 0x2e

    invoke-static {p0, v1, v0}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->checkOffset(Ljava/lang/String;IC)V

    .line 153
    const/16 v0, 0x14

    const/16 v1, 0x17

    invoke-static {p0, v0, v1}, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v0

    move v11, v0

    move v0, v1

    move v1, v11

    .line 158
    :goto_0
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v8

    .line 159
    const/16 v9, 0x2b

    if-eq v8, v9, :cond_0

    if-ne v8, v10, :cond_1

    .line 160
    :cond_0
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "GMT"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 166
    :goto_1
    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v8

    .line 167
    invoke-virtual {v8}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 168
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2

    .line 182
    :catch_0
    move-exception v0

    move-object v1, v0

    .line 189
    :goto_2
    if-nez p0, :cond_4

    const/4 v0, 0x0

    .line 190
    :goto_3
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to parse date ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "]: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 161
    :cond_1
    const/16 v0, 0x5a

    if-ne v8, v0, :cond_2

    .line 162
    :try_start_1
    const-string v0, "GMT"

    goto :goto_1

    .line 164
    :cond_2
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid time zone indicator "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 184
    :catch_1
    move-exception v0

    move-object v1, v0

    .line 188
    goto :goto_2

    .line 171
    :cond_3
    new-instance v0, Ljava/util/GregorianCalendar;

    invoke-direct {v0, v8}, Ljava/util/GregorianCalendar;-><init>(Ljava/util/TimeZone;)V

    .line 172
    const/4 v8, 0x0

    invoke-virtual {v0, v8}, Ljava/util/Calendar;->setLenient(Z)V

    .line 173
    const/4 v8, 0x1

    invoke-virtual {v0, v8, v3}, Ljava/util/Calendar;->set(II)V

    .line 174
    const/4 v3, 0x2

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v0, v3, v4}, Ljava/util/Calendar;->set(II)V

    .line 175
    const/4 v3, 0x5

    invoke-virtual {v0, v3, v5}, Ljava/util/Calendar;->set(II)V

    .line 176
    const/16 v3, 0xb

    invoke-virtual {v0, v3, v6}, Ljava/util/Calendar;->set(II)V

    .line 177
    const/16 v3, 0xc

    invoke-virtual {v0, v3, v7}, Ljava/util/Calendar;->set(II)V

    .line 178
    const/16 v3, 0xd

    invoke-virtual {v0, v3, v2}, Ljava/util/Calendar;->set(II)V

    .line 179
    const/16 v2, 0xe

    invoke-virtual {v0, v2, v1}, Ljava/util/Calendar;->set(II)V

    .line 181
    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;
    :try_end_1
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v0

    return-object v0

    .line 186
    :catch_2
    move-exception v0

    move-object v1, v0

    .line 187
    goto :goto_2

    .line 189
    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v2, 0x22

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\'"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_3

    :cond_5
    move v11, v0

    move v0, v1

    move v1, v11

    goto/16 :goto_0
.end method

.method private static parseInt(Ljava/lang/String;II)I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NumberFormatException;
        }
    .end annotation

    .prologue
    const/16 v3, 0xa

    .line 219
    if-ltz p1, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-gt p2, v0, :cond_0

    if-le p1, p2, :cond_1

    .line 220
    :cond_0
    new-instance v0, Ljava/lang/NumberFormatException;

    invoke-direct {v0, p0}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 224
    :cond_1
    const/4 v0, 0x0

    .line 226
    if-ge p1, p2, :cond_3

    .line 227
    add-int/lit8 v1, p1, 0x1

    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    invoke-static {v0, v3}, Ljava/lang/Character;->digit(CI)I

    move-result v0

    .line 228
    if-gez v0, :cond_2

    .line 229
    new-instance v0, Ljava/lang/NumberFormatException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid number: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 231
    :cond_2
    neg-int v0, v0

    move p1, v1

    .line 233
    :cond_3
    :goto_0
    if-ge p1, p2, :cond_5

    .line 234
    add-int/lit8 v1, p1, 0x1

    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-static {v2, v3}, Ljava/lang/Character;->digit(CI)I

    move-result v2

    .line 235
    if-gez v2, :cond_4

    .line 236
    new-instance v0, Ljava/lang/NumberFormatException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid number: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 238
    :cond_4
    mul-int/lit8 v0, v0, 0xa

    .line 239
    sub-int/2addr v0, v2

    move p1, v1

    goto :goto_0

    .line 241
    :cond_5
    neg-int v0, v0

    return v0
.end method

.method public static timeZoneGMT()Ljava/util/TimeZone;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/fasterxml/jackson/databind/util/ISO8601Utils;->TIMEZONE_GMT:Ljava/util/TimeZone;

    return-object v0
.end method
