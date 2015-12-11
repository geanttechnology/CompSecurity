.class public Lcom/amazon/android/profiling/PageMetrics$TimerMeasurement;
.super Ljava/lang/Object;
.source "PageMetrics.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/android/profiling/PageMetrics;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TimerMeasurement"
.end annotation


# instance fields
.field private durationNanos:J

.field private startNanos:J

.field private threadName:Ljava/lang/String;


# virtual methods
.method public getDurationNanos()J
    .locals 2

    .prologue
    .line 117
    iget-wide v0, p0, Lcom/amazon/android/profiling/PageMetrics$TimerMeasurement;->durationNanos:J

    return-wide v0
.end method

.method public getStartNanos()J
    .locals 2

    .prologue
    .line 112
    iget-wide v0, p0, Lcom/amazon/android/profiling/PageMetrics$TimerMeasurement;->startNanos:J

    return-wide v0
.end method

.method public getThreadName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/android/profiling/PageMetrics$TimerMeasurement;->threadName:Ljava/lang/String;

    return-object v0
.end method
