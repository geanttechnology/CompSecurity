.class public Lco/vine/android/util/DateTimeUtil;
.super Ljava/lang/Object;
.source "DateTimeUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static clearTime(Ljava/util/Calendar;)Ljava/util/Calendar;
    .locals 2
    .param p0, "calendar"    # Ljava/util/Calendar;

    .prologue
    const/4 v1, 0x0

    .line 20
    const/16 v0, 0xb

    invoke-virtual {p0, v0, v1}, Ljava/util/Calendar;->set(II)V

    .line 21
    const/16 v0, 0xa

    invoke-virtual {p0, v0, v1}, Ljava/util/Calendar;->set(II)V

    .line 22
    const/16 v0, 0xc

    invoke-virtual {p0, v0, v1}, Ljava/util/Calendar;->set(II)V

    .line 23
    const/16 v0, 0xd

    invoke-virtual {p0, v0, v1}, Ljava/util/Calendar;->set(II)V

    .line 24
    const/16 v0, 0xe

    invoke-virtual {p0, v0, v1}, Ljava/util/Calendar;->set(II)V

    .line 25
    return-object p0
.end method

.method public static getStartOfDay()Ljava/util/Calendar;
    .locals 1

    .prologue
    .line 16
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/DateTimeUtil;->clearTime(Ljava/util/Calendar;)Ljava/util/Calendar;

    move-result-object v0

    return-object v0
.end method

.method public static getTimeInMsFromString(Ljava/lang/String;Ljava/lang/String;)J
    .locals 9
    .param p0, "time"    # Ljava/lang/String;
    .param p1, "format"    # Ljava/lang/String;

    .prologue
    .line 37
    new-instance v3, Ljava/text/SimpleDateFormat;

    sget-object v7, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v3, p1, v7}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 38
    .local v3, "sdf":Ljava/text/SimpleDateFormat;
    const-wide/16 v4, 0x0

    .line 40
    .local v4, "timestamp":J
    :try_start_0
    invoke-virtual {v3, p0}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 41
    .local v0, "date":Ljava/util/Date;
    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    .line 42
    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v6

    .line 43
    .local v6, "tz":Ljava/util/TimeZone;
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    .line 44
    .local v1, "now":Ljava/util/Date;
    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v7

    invoke-virtual {v6, v7, v8}, Ljava/util/TimeZone;->getOffset(J)I
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    .line 45
    .local v2, "offsetFromUtc":I
    int-to-long v7, v2

    add-long/2addr v4, v7

    .line 48
    .end local v0    # "date":Ljava/util/Date;
    .end local v1    # "now":Ljava/util/Date;
    .end local v2    # "offsetFromUtc":I
    .end local v6    # "tz":Ljava/util/TimeZone;
    :goto_0
    return-wide v4

    .line 46
    :catch_0
    move-exception v7

    goto :goto_0
.end method

.method public static getTimeInStringFromMs(JLjava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "time"    # J
    .param p2, "format"    # Ljava/lang/String;

    .prologue
    .line 52
    new-instance v0, Ljava/text/SimpleDateFormat;

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, p2, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    new-instance v1, Ljava/util/Date;

    invoke-direct {v1, p0, p1}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
