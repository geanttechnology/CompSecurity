.class public Lcom/comcast/playerplatform/util/android/TimeUtil;
.super Ljava/lang/Object;
.source "TimeUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getClockMonoTonicMillis()J
    .locals 4

    .prologue
    .line 17
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    const-wide/32 v2, 0xf4240

    div-long/2addr v0, v2

    return-wide v0
.end method

.method public static getUnixEpochTimeInMillis()J
    .locals 2

    .prologue
    .line 13
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    return-wide v0
.end method
