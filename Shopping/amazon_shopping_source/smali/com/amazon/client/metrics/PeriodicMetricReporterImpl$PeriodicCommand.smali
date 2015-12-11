.class public final Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;
.super Ljava/lang/Object;
.source "PeriodicMetricReporterImpl.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x14
    name = "PeriodicCommand"
.end annotation


# instance fields
.field private final mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final synthetic this$0:Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;)V
    .locals 2

    .prologue
    .line 228
    iput-object p1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;->this$0:Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 229
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 230
    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 236
    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;->this$0:Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;

    # invokes: Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->recordMetricEvent()V
    invoke-static {v0}, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->access$000(Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 244
    :cond_0
    :goto_0
    return-void

    .line 237
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public shutdown()V
    .locals 2

    .prologue
    .line 252
    iget-object v0, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 253
    return-void
.end method
