.class Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$1;
.super Ljava/lang/Object;
.source "PeriodicMetricReporterImpl.java"

# interfaces
.implements Ljava/util/concurrent/ThreadFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;-><init>(Lcom/amazon/client/metrics/MetricsFactory;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;


# direct methods
.method constructor <init>(Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$1;->this$0:Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public newThread(Ljava/lang/Runnable;)Ljava/lang/Thread;
    .locals 2
    .param p1, "r"    # Ljava/lang/Runnable;

    .prologue
    .line 100
    new-instance v0, Ljava/lang/Thread;

    const-string/jumbo v1, "PeriodicMetricReporterThread"

    invoke-direct {v0, p1, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    .line 102
    .local v0, "thread":Ljava/lang/Thread;
    return-object v0
.end method
