.class Lnet/singular/sdk/TimeHelper;
.super Ljava/lang/Object;
.source "TimeHelper.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public currentTimeMillis()J
    .locals 2

    .prologue
    .line 5
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    return-wide v0
.end method

.method public currentTimeSeconds()J
    .locals 4

    .prologue
    .line 9
    invoke-virtual {p0}, Lnet/singular/sdk/TimeHelper;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    return-wide v0
.end method
