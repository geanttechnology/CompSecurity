.class public final Lcom/amazon/identity/auth/device/utils/TimeUtil;
.super Ljava/lang/Object;
.source "TimeUtil.java"


# static fields
.field static final START_YEAR:I = 0x76c


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    return-void
.end method

.method public static deserialize(Ljava/lang/String;)Ljava/util/Date;
    .locals 4
    .param p0, "timestampStr"    # Ljava/lang/String;

    .prologue
    .line 51
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    .line 53
    .local v0, "timestamp":Ljava/lang/Long;
    if-nez v0, :cond_0

    .line 55
    const/4 v1, 0x0

    .line 58
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Ljava/util/Date;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/util/Date;-><init>(J)V

    goto :goto_0
.end method

.method public static fromDaysTo(JLjava/util/concurrent/TimeUnit;)J
    .locals 2
    .param p0, "days"    # J
    .param p2, "unit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 21
    const-wide/16 v0, 0x18

    mul-long/2addr v0, p0

    .line 23
    invoke-static {v0, v1, p2}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->fromHoursTo(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    return-wide v0
.end method

.method public static fromHoursTo(JLjava/util/concurrent/TimeUnit;)J
    .locals 2
    .param p0, "hours"    # J
    .param p2, "unit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 28
    const-wide/16 v0, 0x3c

    mul-long/2addr v0, p0

    .line 30
    invoke-static {v0, v1, p2}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->fromMinutesTo(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    return-wide v0
.end method

.method public static fromMinutesTo(JLjava/util/concurrent/TimeUnit;)J
    .locals 4
    .param p0, "minutes"    # J
    .param p2, "unit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 35
    const-wide/16 v2, 0x3c

    mul-long v0, p0, v2

    .line 37
    .local v0, "seconds":J
    sget-object v2, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {p2, v0, v1, v2}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v2

    return-wide v2
.end method

.method public static serialize(Ljava/util/Date;)Ljava/lang/String;
    .locals 2
    .param p0, "date"    # Ljava/util/Date;

    .prologue
    .line 42
    if-nez p0, :cond_0

    .line 44
    const/4 v0, 0x0

    .line 46
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
