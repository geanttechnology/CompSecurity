.class public final Lcom/amazon/android/profiling/PageMetrics;
.super Ljava/lang/Object;
.source "PageMetrics.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/profiling/PageMetrics$TimerMeasurement;
    }
.end annotation


# instance fields
.field private pageStartTime:J

.field private resourceLoadStartNanos:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private resourceLoadsByUrl:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/android/profiling/PageMetrics$TimerMeasurement;",
            ">;"
        }
    .end annotation
.end field

.field private timersByName:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/android/profiling/PageMetrics$TimerMeasurement;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/profiling/PageMetrics;->timersByName:Ljava/util/Map;

    .line 18
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/profiling/PageMetrics;->resourceLoadsByUrl:Ljava/util/Map;

    .line 21
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/profiling/PageMetrics;->resourceLoadStartNanos:Ljava/util/Map;

    .line 25
    return-void
.end method


# virtual methods
.method public getPageStartTime()J
    .locals 2

    .prologue
    .line 65
    iget-wide v0, p0, Lcom/amazon/android/profiling/PageMetrics;->pageStartTime:J

    return-wide v0
.end method

.method public getResourceLoads()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/android/profiling/PageMetrics$TimerMeasurement;",
            ">;"
        }
    .end annotation

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/android/profiling/PageMetrics;->resourceLoadsByUrl:Ljava/util/Map;

    return-object v0
.end method

.method public getTimers()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/android/profiling/PageMetrics$TimerMeasurement;",
            ">;"
        }
    .end annotation

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/android/profiling/PageMetrics;->timersByName:Ljava/util/Map;

    return-object v0
.end method

.method public setPageStartTime(J)V
    .locals 0
    .param p1, "pageStartTime"    # J

    .prologue
    .line 29
    iput-wide p1, p0, Lcom/amazon/android/profiling/PageMetrics;->pageStartTime:J

    .line 30
    return-void
.end method
