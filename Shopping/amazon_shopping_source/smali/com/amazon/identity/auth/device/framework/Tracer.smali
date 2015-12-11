.class public Lcom/amazon/identity/auth/device/framework/Tracer;
.super Ljava/lang/Object;
.source "Tracer.java"


# static fields
.field public static final KEY_API_NAME:Ljava/lang/String; = "apiName"

.field public static final KEY_TRACE_ID:Ljava/lang/String; = "traceId"

.field private static final TAG:Ljava/lang/String;

.field private static final TRACE_ID_COUNTER:Ljava/util/concurrent/atomic/AtomicInteger;


# instance fields
.field private final mApiName:Ljava/lang/String;

.field private mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

.field private mStartTime:J

.field private final mTraceId:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 29
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/Tracer;->TRACE_ID_COUNTER:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 30
    const-class v0, Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/Tracer;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(ILjava/lang/String;)V
    .locals 3
    .param p1, "traceId"    # I
    .param p2, "apiName"    # Ljava/lang/String;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mStartTime:J

    .line 39
    iput p1, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mTraceId:I

    .line 40
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mApiName:Ljava/lang/String;

    .line 41
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mApiName:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/identity/platform/metric/MetricsHelper;->getNewCollector(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    .line 42
    sget-object v0, Lcom/amazon/identity/auth/device/framework/Tracer;->TAG:Ljava/lang/String;

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget v2, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mTraceId:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mApiName:Ljava/lang/String;

    aput-object v2, v0, v1

    .line 43
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "apiName"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTraceId()I

    move-result v0

    invoke-direct {p0, v0, p1}, Lcom/amazon/identity/auth/device/framework/Tracer;-><init>(ILjava/lang/String;)V

    .line 48
    return-void
.end method

.method public static createFromBundle(Landroid/os/Bundle;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;
    .locals 4
    .param p0, "bundle"    # Landroid/os/Bundle;
    .param p1, "defaultApiName"    # Ljava/lang/String;

    .prologue
    .line 75
    if-nez p0, :cond_0

    .line 77
    new-instance v2, Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {v2, p1}, Lcom/amazon/identity/auth/device/framework/Tracer;-><init>(Ljava/lang/String;)V

    .line 89
    :goto_0
    return-object v2

    .line 80
    :cond_0
    const-string/jumbo v2, "traceId"

    invoke-static {}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTraceId()I

    move-result v3

    invoke-virtual {p0, v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 82
    .local v1, "traceId":I
    const-string/jumbo v2, "apiName"

    invoke-virtual {p0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 84
    .local v0, "apiName":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 86
    new-instance v2, Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {v2, v1, p1}, Lcom/amazon/identity/auth/device/framework/Tracer;-><init>(ILjava/lang/String;)V

    goto :goto_0

    .line 89
    :cond_1
    new-instance v2, Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {v2, v1, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;-><init>(ILjava/lang/String;)V

    goto :goto_0
.end method

.method public static createFromIntent(Landroid/content/Intent;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;
    .locals 4
    .param p0, "intent"    # Landroid/content/Intent;
    .param p1, "defaultApiName"    # Ljava/lang/String;

    .prologue
    .line 100
    if-nez p0, :cond_0

    .line 102
    new-instance v2, Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {v2, p1}, Lcom/amazon/identity/auth/device/framework/Tracer;-><init>(Ljava/lang/String;)V

    .line 118
    :goto_0
    return-object v2

    .line 105
    :cond_0
    const-string/jumbo v2, "traceId"

    invoke-static {}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTraceId()I

    move-result v3

    invoke-virtual {p0, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    .line 107
    .local v1, "traceId":I
    const-string/jumbo v2, "apiName"

    invoke-virtual {p0, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 109
    .local v0, "apiName":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 111
    sget-object v2, Lcom/amazon/identity/auth/device/framework/Tracer;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "There is no tracer info in intent, creating tracer using new traceId and defaultApiName, traceId:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " apiName:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 114
    new-instance v2, Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {v2, v1, p1}, Lcom/amazon/identity/auth/device/framework/Tracer;-><init>(ILjava/lang/String;)V

    goto :goto_0

    .line 117
    :cond_1
    sget-object v2, Lcom/amazon/identity/auth/device/framework/Tracer;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Creating Tracer from intent, traceId:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " apiName:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 118
    new-instance v2, Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {v2, v1, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;-><init>(ILjava/lang/String;)V

    goto :goto_0
.end method

.method private static getNewTraceId()I
    .locals 2

    .prologue
    .line 56
    sget-object v0, Lcom/amazon/identity/auth/device/framework/Tracer;->TRACE_ID_COUNTER:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    move-result v0

    rem-int/lit16 v0, v0, 0x3e8

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v1

    mul-int/lit16 v1, v1, 0x3e8

    add-int/2addr v0, v1

    return v0
.end method

.method public static getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;
    .locals 1
    .param p0, "apiName"    # Ljava/lang/String;

    .prologue
    .line 64
    new-instance v0, Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/framework/Tracer;-><init>(Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public addToBundle(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 141
    const-string/jumbo v0, "traceId"

    iget v1, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mTraceId:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 142
    const-string/jumbo v0, "apiName"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mApiName:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    return-void
.end method

.method public addToIntent(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 130
    const-string/jumbo v0, "traceId"

    iget v1, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mTraceId:I

    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 131
    const-string/jumbo v0, "apiName"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mApiName:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 132
    return-void
.end method

.method public addTracePoint(Ljava/lang/String;)V
    .locals 6
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 160
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mStartTime:J

    sub-long/2addr v2, v4

    const-wide/32 v4, 0xf4240

    div-long v0, v2, v4

    .line 161
    .local v0, "elapsedTime":J
    sget-object v2, Lcom/amazon/identity/auth/device/framework/Tracer;->TAG:Ljava/lang/String;

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget v4, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mTraceId:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p1, v2, v3

    const/4 v3, 0x2

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    .line 162
    return-void
.end method

.method public finishTrace()V
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    invoke-interface {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;->recordEvent()V

    .line 210
    return-void
.end method

.method public getAPIName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mApiName:Ljava/lang/String;

    return-object v0
.end method

.method public getTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 1
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 181
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    invoke-interface {v0, p1}, Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;->createTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 182
    return-object v0
.end method

.method public getTraceId()I
    .locals 1

    .prologue
    .line 152
    iget v0, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mTraceId:I

    return v0
.end method

.method public incrementCounter(Ljava/lang/String;)V
    .locals 2
    .param p1, "counter"    # Ljava/lang/String;

    .prologue
    .line 190
    sget-object v0, Lcom/amazon/identity/auth/device/framework/Tracer;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "increase MAP incrementCounter:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 191
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    invoke-interface {v0, p1}, Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;->incrementCounter(Ljava/lang/String;)V

    .line 192
    return-void
.end method

.method public incrementCounter(Ljava/lang/String;D)V
    .locals 1
    .param p1, "counter"    # Ljava/lang/String;
    .param p2, "count"    # D

    .prologue
    .line 199
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;->incrementCounter(Ljava/lang/String;D)V

    .line 200
    return-void
.end method

.method setCollector(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;)V
    .locals 0
    .param p1, "collector"    # Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    .prologue
    .line 217
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    .line 218
    return-void
.end method

.method public startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 2
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 170
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/Tracer;->mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    invoke-interface {v1, p1}, Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;->createTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 171
    .local v0, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->start()V

    .line 172
    return-object v0
.end method
