.class Lcom/newrelic/agent/android/background/HarvestHeartbeat$1;
.super Ljava/lang/Object;
.source "HarvestHeartbeat.java"

# interfaces
.implements Ljava/util/concurrent/ThreadFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/newrelic/agent/android/background/HarvestHeartbeat;-><init>(Lcom/newrelic/agent/android/api/v1/NewRelicApi;Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;Lcom/newrelic/agent/android/util/ConnectivitySampler;JLjava/util/concurrent/TimeUnit;JLjava/util/concurrent/TimeUnit;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;


# direct methods
.method constructor <init>(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)V
    .locals 0

    .prologue
    .line 92
    iput-object p1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$1;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public newThread(Ljava/lang/Runnable;)Ljava/lang/Thread;
    .locals 2
    .param p1, "r"    # Ljava/lang/Runnable;

    .prologue
    .line 95
    new-instance v0, Ljava/lang/Thread;

    const-string v1, "[New Relic] Heartbeat"

    invoke-direct {v0, p1, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    return-object v0
.end method
