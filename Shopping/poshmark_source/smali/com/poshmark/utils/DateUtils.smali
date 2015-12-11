.class public Lcom/poshmark/utils/DateUtils;
.super Ljava/lang/Object;
.source "DateUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/DateUtils$1;,
        Lcom/poshmark/utils/DateUtils$TIME_UNIT;
    }
.end annotation


# static fields
.field static displayFormat:Ljava/text/SimpleDateFormat;

.field static formatter_local:Ljava/text/SimpleDateFormat;

.field static formatter_utc:Ljava/text/SimpleDateFormat;

.field static formatter_utc_milli:Ljava/text/SimpleDateFormat;

.field static str1:Ljava/lang/String;

.field static str2:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 14
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ssZ"

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    sput-object v0, Lcom/poshmark/utils/DateUtils;->formatter_utc:Ljava/text/SimpleDateFormat;

    .line 15
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ss.SSSZ"

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    sput-object v0, Lcom/poshmark/utils/DateUtils;->formatter_utc_milli:Ljava/text/SimpleDateFormat;

    .line 16
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ss"

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    sput-object v0, Lcom/poshmark/utils/DateUtils;->formatter_local:Ljava/text/SimpleDateFormat;

    .line 17
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "MMM dd"

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    sput-object v0, Lcom/poshmark/utils/DateUtils;->displayFormat:Ljava/text/SimpleDateFormat;

    .line 20
    const-string v0, "2013-07-23T01:41:23-07:00"

    sput-object v0, Lcom/poshmark/utils/DateUtils;->str1:Ljava/lang/String;

    .line 21
    const-string v0, "2013-07-23T01:41:23"

    sput-object v0, Lcom/poshmark/utils/DateUtils;->str2:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    return-void
.end method

.method public static convertMilliSecondsTo(JLcom/poshmark/utils/DateUtils$TIME_UNIT;)J
    .locals 12
    .param p0, "milliSeconds"    # J
    .param p2, "timeUnit"    # Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    .prologue
    .line 162
    const-wide/16 v6, 0x0

    .line 163
    .local v6, "retVal":J
    const-wide/16 v10, 0x3e8

    div-long v8, p0, v10

    .line 164
    .local v8, "secs":J
    const-wide/16 v10, 0x3c

    div-long v4, v8, v10

    .line 165
    .local v4, "mins":J
    const-wide/16 v10, 0x3c

    div-long v2, v4, v10

    .line 166
    .local v2, "hours":J
    const-wide/16 v10, 0x18

    div-long v0, v2, v10

    .line 168
    .local v0, "days":J
    sget-object v10, Lcom/poshmark/utils/DateUtils$1;->$SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT:[I

    invoke-virtual {p2}, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->ordinal()I

    move-result v11

    aget v10, v10, v11

    packed-switch v10, :pswitch_data_0

    .line 190
    :goto_0
    :pswitch_0
    return-wide v6

    .line 170
    :pswitch_1
    move-wide v6, v8

    .line 171
    goto :goto_0

    .line 173
    :pswitch_2
    move-wide v6, v4

    .line 174
    goto :goto_0

    .line 176
    :pswitch_3
    move-wide v6, v2

    .line 177
    goto :goto_0

    .line 179
    :pswitch_4
    move-wide v6, v0

    .line 180
    goto :goto_0

    .line 168
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public static formatDateForDisplay(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 18
    .param p0, "dateString"    # Ljava/lang/String;
    .param p1, "prefix"    # Ljava/lang/String;

    .prologue
    .line 214
    invoke-static/range {p0 .. p0}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 217
    .local v1, "date":Ljava/util/Date;
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 218
    .local v0, "current":Ljava/util/Date;
    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v14

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v16

    sub-long v4, v14, v16

    .line 219
    .local v4, "diffInMilli":J
    const-wide/16 v14, 0x3e8

    div-long v12, v4, v14

    .line 220
    .local v12, "secs":J
    const-wide/16 v14, 0x3c

    div-long v10, v12, v14

    .line 221
    .local v10, "mins":J
    const-wide/16 v14, 0x3c

    div-long v8, v10, v14

    .line 222
    .local v8, "hours":J
    const-wide/16 v14, 0x18

    div-long v2, v8, v14

    .line 224
    .local v2, "days":J
    if-nez p1, :cond_0

    .line 225
    const-string p1, ""

    .line 227
    :cond_0
    const-wide/16 v14, 0x7

    cmp-long v7, v2, v14

    if-lez v7, :cond_2

    .line 228
    sget-object v7, Lcom/poshmark/utils/DateUtils;->displayFormat:Ljava/text/SimpleDateFormat;

    invoke-virtual {v7, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v6

    .line 229
    .local v6, "formattedDate":Ljava/lang/String;
    if-eqz p1, :cond_1

    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_1

    .line 230
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v14

    const v15, 0x7f0601e2

    invoke-virtual {v14, v15}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v14, " "

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 257
    .end local v6    # "formattedDate":Ljava/lang/String;
    :cond_1
    :goto_0
    return-object v6

    .line 236
    :cond_2
    const-wide/16 v14, 0x1

    cmp-long v7, v2, v14

    if-nez v7, :cond_3

    .line 237
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v14, " "

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v14

    const v15, 0x7f0600a1

    invoke-virtual {v14, v15}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 239
    :cond_3
    const-wide/16 v14, 0x1

    cmp-long v7, v2, v14

    if-lez v7, :cond_4

    .line 240
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v14, " "

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v14

    const v15, 0x7f0600a2

    invoke-virtual {v14, v15}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 242
    :cond_4
    const-wide/16 v14, 0x1

    cmp-long v7, v8, v14

    if-nez v7, :cond_5

    .line 243
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v7

    const v14, 0x7f060144

    invoke-virtual {v7, v14}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 245
    :cond_5
    const-wide/16 v14, 0x1

    cmp-long v7, v8, v14

    if-lez v7, :cond_6

    .line 246
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v14, " "

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v14

    const v15, 0x7f060145

    invoke-virtual {v14, v15}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_0

    .line 248
    :cond_6
    const-wide/16 v14, 0x1

    cmp-long v7, v10, v14

    if-nez v7, :cond_7

    .line 249
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v7

    const v14, 0x7f0601a6

    invoke-virtual {v7, v14}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_0

    .line 251
    :cond_7
    const-wide/16 v14, 0x1

    cmp-long v7, v10, v14

    if-lez v7, :cond_8

    .line 252
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v10, v11}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v14, " "

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v14

    const v15, 0x7f0601a5

    invoke-virtual {v14, v15}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_0

    .line 254
    :cond_8
    const-wide/16 v14, 0x0

    cmp-long v7, v12, v14

    if-gtz v7, :cond_9

    .line 255
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v7

    const v14, 0x7f0601a8

    invoke-virtual {v7, v14}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_0

    .line 257
    :cond_9
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v12, v13}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v14, " "

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v14

    const v15, 0x7f06023c

    invoke-virtual {v14, v15}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v7, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_0
.end method

.method private static getCorrectFormatter(Ljava/lang/String;)Ljava/text/SimpleDateFormat;
    .locals 4
    .param p0, "dateString"    # Ljava/lang/String;

    .prologue
    .line 103
    const-string v2, "(.*)T(\\d*):(\\d*):(\\d*)(-|\\+)(.*)"

    invoke-virtual {p0, v2}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    .line 104
    .local v0, "timeZonePresent":Z
    const-string v2, "(.*)T(\\d*):(\\d*):(\\d*).(\\d*)(-|\\+)(.*)"

    invoke-virtual {p0, v2}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v1

    .line 105
    .local v1, "timeZonePresentWithMilli":Z
    if-eqz v0, :cond_0

    .line 106
    sget-object v2, Lcom/poshmark/utils/DateUtils;->formatter_utc:Ljava/text/SimpleDateFormat;

    const-string v3, "UTC"

    invoke-static {v3}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 107
    sget-object v2, Lcom/poshmark/utils/DateUtils;->formatter_utc:Ljava/text/SimpleDateFormat;

    .line 113
    :goto_0
    return-object v2

    .line 108
    :cond_0
    if-eqz v1, :cond_1

    .line 109
    sget-object v2, Lcom/poshmark/utils/DateUtils;->formatter_utc_milli:Ljava/text/SimpleDateFormat;

    const-string v3, "UTC"

    invoke-static {v3}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 110
    sget-object v2, Lcom/poshmark/utils/DateUtils;->formatter_utc_milli:Ljava/text/SimpleDateFormat;

    goto :goto_0

    .line 112
    :cond_1
    sget-object v2, Lcom/poshmark/utils/DateUtils;->formatter_local:Ljava/text/SimpleDateFormat;

    const-string v3, "UTC"

    invoke-static {v3}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 113
    sget-object v2, Lcom/poshmark/utils/DateUtils;->formatter_local:Ljava/text/SimpleDateFormat;

    goto :goto_0
.end method

.method public static getDateFromString(Ljava/lang/String;)Ljava/util/Date;
    .locals 3
    .param p0, "dateString"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 26
    if-eqz p0, :cond_0

    .line 27
    :try_start_0
    invoke-static {p0}, Lcom/poshmark/utils/DateUtils;->getCorrectFormatter(Ljava/lang/String;)Ljava/text/SimpleDateFormat;

    move-result-object v2

    .line 28
    .local v2, "formatter":Ljava/text/SimpleDateFormat;
    invoke-virtual {v2, p0}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 34
    .end local v2    # "formatter":Ljava/text/SimpleDateFormat;
    :cond_0
    :goto_0
    return-object v0

    .line 33
    :catch_0
    move-exception v1

    .line 34
    .local v1, "e":Ljava/text/ParseException;
    goto :goto_0
.end method

.method public static getDiffBetweenDates(Ljava/util/Date;Ljava/util/Date;Lcom/poshmark/utils/DateUtils$TIME_UNIT;)J
    .locals 4
    .param p0, "currentDate"    # Ljava/util/Date;
    .param p1, "futureDate"    # Ljava/util/Date;
    .param p2, "timeUnit"    # Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    .prologue
    .line 205
    invoke-virtual {p0, p1}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 206
    const-wide/16 v2, 0x0

    .line 209
    :goto_0
    return-wide v2

    .line 208
    :cond_0
    invoke-static {p0, p1}, Lcom/poshmark/utils/DateUtils;->getDiffInMilli(Ljava/util/Date;Ljava/util/Date;)J

    move-result-wide v0

    .line 209
    .local v0, "diffInMilli":J
    invoke-static {v0, v1, p2}, Lcom/poshmark/utils/DateUtils;->convertMilliSecondsTo(JLcom/poshmark/utils/DateUtils$TIME_UNIT;)J

    move-result-wide v2

    goto :goto_0
.end method

.method public static getDiffInMilli(Ljava/util/Date;Ljava/util/Date;)J
    .locals 6
    .param p0, "date1"    # Ljava/util/Date;
    .param p1, "date2"    # Ljava/util/Date;

    .prologue
    .line 196
    invoke-virtual {p0, p1}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 197
    invoke-virtual {p0}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    sub-long v0, v2, v4

    .line 201
    .local v0, "diffInMilli":J
    :goto_0
    return-wide v0

    .line 199
    .end local v0    # "diffInMilli":J
    :cond_0
    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-virtual {p0}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    sub-long v0, v2, v4

    .restart local v0    # "diffInMilli":J
    goto :goto_0
.end method

.method public static getStringFromUTCDate(Ljava/util/Date;)Ljava/lang/String;
    .locals 10
    .param p0, "date"    # Ljava/util/Date;

    .prologue
    .line 40
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v8, "yyyy-MM-dd\'T\'HH:mm:ssZ"

    sget-object v9, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v2, v8, v9}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 41
    .local v2, "formatter":Ljava/text/SimpleDateFormat;
    invoke-virtual {v2, p0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 44
    .local v0, "dateString":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v6

    .line 45
    .local v6, "length":I
    const-string v8, "-"

    invoke-virtual {v0, v8}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v4

    .line 46
    .local v4, "index1":I
    const-string v8, "+"

    invoke-virtual {v0, v8}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v5

    .line 48
    .local v5, "index2":I
    if-ge v4, v5, :cond_1

    .line 49
    add-int/lit8 v7, v5, 0x1

    .line 55
    .local v7, "startPos":I
    :goto_0
    const/4 v8, 0x0

    invoke-virtual {v0, v8, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 57
    .local v1, "finalString":Ljava/lang/String;
    move v3, v7

    .local v3, "i":I
    :goto_1
    if-ge v3, v6, :cond_2

    .line 59
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    add-int/lit8 v9, v3, 0x2

    invoke-virtual {v0, v3, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 60
    add-int/lit8 v8, v3, 0x2

    if-ge v8, v6, :cond_0

    .line 61
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ":"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 57
    :cond_0
    add-int/lit8 v3, v3, 0x2

    goto :goto_1

    .line 51
    .end local v1    # "finalString":Ljava/lang/String;
    .end local v3    # "i":I
    .end local v7    # "startPos":I
    :cond_1
    add-int/lit8 v7, v4, 0x1

    .restart local v7    # "startPos":I
    goto :goto_0

    .line 66
    .restart local v1    # "finalString":Ljava/lang/String;
    .restart local v3    # "i":I
    :cond_2
    return-object v1
.end method

.method public static getTimeStampStringFromUTCDate(Ljava/util/Date;)Ljava/lang/String;
    .locals 10
    .param p0, "date"    # Ljava/util/Date;

    .prologue
    .line 70
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v8, "yyyy-MM-dd\'T\'HH:mm:ss.SSZ"

    sget-object v9, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v2, v8, v9}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 71
    .local v2, "formatter":Ljava/text/SimpleDateFormat;
    invoke-virtual {v2, p0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 74
    .local v0, "dateString":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v6

    .line 75
    .local v6, "length":I
    const-string v8, "-"

    invoke-virtual {v0, v8}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v4

    .line 76
    .local v4, "index1":I
    const-string v8, "+"

    invoke-virtual {v0, v8}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v5

    .line 78
    .local v5, "index2":I
    if-ge v4, v5, :cond_1

    .line 79
    add-int/lit8 v7, v5, 0x1

    .line 85
    .local v7, "startPos":I
    :goto_0
    const/4 v8, 0x0

    invoke-virtual {v0, v8, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 87
    .local v1, "finalString":Ljava/lang/String;
    move v3, v7

    .local v3, "i":I
    :goto_1
    if-ge v3, v6, :cond_2

    .line 89
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    add-int/lit8 v9, v3, 0x2

    invoke-virtual {v0, v3, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 90
    add-int/lit8 v8, v3, 0x2

    if-ge v8, v6, :cond_0

    .line 91
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ":"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 87
    :cond_0
    add-int/lit8 v3, v3, 0x2

    goto :goto_1

    .line 81
    .end local v1    # "finalString":Ljava/lang/String;
    .end local v3    # "i":I
    .end local v7    # "startPos":I
    :cond_1
    add-int/lit8 v7, v4, 0x1

    .restart local v7    # "startPos":I
    goto :goto_0

    .line 96
    .restart local v1    # "finalString":Ljava/lang/String;
    .restart local v3    # "i":I
    :cond_2
    return-object v1
.end method

.method public static isDateWithinPastWindow(Ljava/util/Date;JLcom/poshmark/utils/DateUtils$TIME_UNIT;)Z
    .locals 19
    .param p0, "eventDate"    # Ljava/util/Date;
    .param p1, "duration"    # J
    .param p3, "timeUnit"    # Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    .prologue
    .line 119
    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    .line 120
    .local v2, "currentTime":Ljava/util/Date;
    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v14

    if-eqz v14, :cond_0

    .line 121
    const/4 v3, 0x0

    .line 154
    :goto_0
    :pswitch_0
    return v3

    .line 123
    :cond_0
    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v14

    invoke-virtual/range {p0 .. p0}, Ljava/util/Date;->getTime()J

    move-result-wide v16

    sub-long v6, v14, v16

    .line 124
    .local v6, "diffInMilli":J
    const-wide/16 v14, 0x3e8

    div-long v12, v6, v14

    .line 125
    .local v12, "secs":J
    const-wide/16 v14, 0x3c

    div-long v10, v12, v14

    .line 126
    .local v10, "mins":J
    const-wide/16 v14, 0x3c

    div-long v8, v10, v14

    .line 127
    .local v8, "hours":J
    const-wide/16 v14, 0x18

    div-long v4, v8, v14

    .line 129
    .local v4, "days":J
    const/4 v3, 0x0

    .line 130
    .local v3, "retVal":Z
    sget-object v14, Lcom/poshmark/utils/DateUtils$1;->$SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT:[I

    invoke-virtual/range {p3 .. p3}, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->ordinal()I

    move-result v15

    aget v14, v14, v15

    packed-switch v14, :pswitch_data_0

    goto :goto_0

    .line 132
    :pswitch_1
    cmp-long v14, v12, p1

    if-gtz v14, :cond_1

    const/4 v3, 0x1

    .line 133
    :goto_1
    goto :goto_0

    .line 132
    :cond_1
    const/4 v3, 0x0

    goto :goto_1

    .line 135
    :pswitch_2
    cmp-long v14, v10, p1

    if-gtz v14, :cond_2

    const/4 v3, 0x1

    .line 136
    :goto_2
    goto :goto_0

    .line 135
    :cond_2
    const/4 v3, 0x0

    goto :goto_2

    .line 138
    :pswitch_3
    cmp-long v14, v8, p1

    if-gtz v14, :cond_3

    const/4 v3, 0x1

    .line 139
    :goto_3
    goto :goto_0

    .line 138
    :cond_3
    const/4 v3, 0x0

    goto :goto_3

    .line 141
    :pswitch_4
    cmp-long v14, v4, p1

    if-gtz v14, :cond_4

    const/4 v3, 0x1

    .line 142
    :goto_4
    goto :goto_0

    .line 141
    :cond_4
    const/4 v3, 0x0

    goto :goto_4

    .line 130
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
