.class public final Lcom/newrelic/agent/android/util/AndroidMachineMeasurementsSampler;
.super Ljava/lang/Object;
.source "AndroidMachineMeasurementsSampler.java"

# interfaces
.implements Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;


# static fields
.field private static final KB_IN_MB:I = 0x400

.field private static final PID:[I

.field private static log:Lcom/newrelic/agent/android/logging/AgentLog;


# instance fields
.field private final context:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 12
    invoke-static {}, Lcom/newrelic/agent/android/logging/AgentLogManager;->getAgentLog()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v0

    sput-object v0, Lcom/newrelic/agent/android/util/AndroidMachineMeasurementsSampler;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    .line 14
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v2

    aput v2, v0, v1

    sput-object v0, Lcom/newrelic/agent/android/util/AndroidMachineMeasurementsSampler;->PID:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/newrelic/agent/android/util/AndroidMachineMeasurementsSampler;->context:Landroid/content/Context;

    .line 21
    return-void
.end method

.method private getResidentMemory(Landroid/content/Context;)F
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 31
    const-string v3, "activity"

    invoke-virtual {p1, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 32
    .local v0, "activityManager":Landroid/app/ActivityManager;
    sget-object v3, Lcom/newrelic/agent/android/util/AndroidMachineMeasurementsSampler;->PID:[I

    invoke-virtual {v0, v3}, Landroid/app/ActivityManager;->getProcessMemoryInfo([I)[Landroid/os/Debug$MemoryInfo;

    move-result-object v1

    .line 33
    .local v1, "memInfo":[Landroid/os/Debug$MemoryInfo;
    const/4 v3, 0x0

    aget-object v3, v1, v3

    invoke-virtual {v3}, Landroid/os/Debug$MemoryInfo;->getTotalPss()I

    move-result v2

    .line 35
    .local v2, "thisMeasurement":I
    if-ltz v2, :cond_0

    .line 36
    div-int/lit16 v3, v2, 0x400

    int-to-float v3, v3

    .line 40
    :goto_0
    return v3

    .line 39
    :cond_0
    sget-object v3, Lcom/newrelic/agent/android/util/AndroidMachineMeasurementsSampler;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v4, "MemorySampler: getTotalPss() returned a negative value!"

    invoke-interface {v3, v4}, Lcom/newrelic/agent/android/logging/AgentLog;->debug(Ljava/lang/String;)V

    .line 40
    const/4 v3, 0x0

    goto :goto_0
.end method


# virtual methods
.method public sample()Lcom/newrelic/agent/android/api/common/MachineMeasurements;
    .locals 2

    .prologue
    .line 24
    new-instance v0, Lcom/newrelic/agent/android/api/common/MachineMeasurements;

    iget-object v1, p0, Lcom/newrelic/agent/android/util/AndroidMachineMeasurementsSampler;->context:Landroid/content/Context;

    invoke-direct {p0, v1}, Lcom/newrelic/agent/android/util/AndroidMachineMeasurementsSampler;->getResidentMemory(Landroid/content/Context;)F

    move-result v1

    invoke-direct {v0, v1}, Lcom/newrelic/agent/android/api/common/MachineMeasurements;-><init>(F)V

    return-object v0
.end method
