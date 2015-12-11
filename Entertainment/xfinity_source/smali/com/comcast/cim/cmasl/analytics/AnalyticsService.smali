.class public abstract Lcom/comcast/cim/cmasl/analytics/AnalyticsService;
.super Landroid/app/Service;
.source "AnalyticsService.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;


# instance fields
.field private consecutiveFailures:I

.field private postAfterTime:J

.field private running:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 12
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->postAfterTime:J

    .line 13
    const/4 v0, 0x0

    iput v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->consecutiveFailures:I

    .line 15
    return-void
.end method

.method private deviceIsCharging()Z
    .locals 5

    .prologue
    const/4 v3, 0x1

    .line 48
    new-instance v1, Landroid/content/IntentFilter;

    const-string v4, "android.intent.action.BATTERY_CHANGED"

    invoke-direct {v1, v4}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 49
    .local v1, "ifilter":Landroid/content/IntentFilter;
    const/4 v4, 0x0

    invoke-virtual {p0, v4, v1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    move-result-object v0

    .line 50
    .local v0, "batteryStatus":Landroid/content/Intent;
    if-eqz v0, :cond_1

    const-string v4, "status"

    invoke-virtual {v0, v4, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    .line 53
    .local v2, "status":I
    :goto_0
    const/4 v4, 0x2

    if-eq v2, v4, :cond_0

    const/4 v4, 0x5

    if-ne v2, v4, :cond_2

    :cond_0
    :goto_1
    return v3

    .end local v2    # "status":I
    :cond_1
    move v2, v3

    .line 50
    goto :goto_0

    .line 53
    .restart local v2    # "status":I
    :cond_2
    const/4 v3, 0x0

    goto :goto_1
.end method

.method private hasFastInternetAccess()Z
    .locals 1

    .prologue
    .line 57
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnectedOnWiFi()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnectedOnHighspeedMobile()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private notInFailureBackoffTimePeriod()Z
    .locals 4

    .prologue
    .line 60
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->postAfterTime:J

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private sendAnalytics()V
    .locals 2

    .prologue
    .line 29
    iget-boolean v1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->running:Z

    if-eqz v1, :cond_0

    .line 40
    :goto_0
    return-void

    .line 33
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->getAnalyticsTaskQueue()Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->peek()Lcom/squareup/tape/Task;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    .line 34
    .local v0, "analyticsTask":Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->shouldRunNow()Z

    move-result v1

    if-eqz v1, :cond_1

    if-eqz v0, :cond_1

    .line 35
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->running:Z

    .line 36
    invoke-virtual {v0, p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->execute(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;)V

    goto :goto_0

    .line 38
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->stopSelf()V

    goto :goto_0
.end method

.method private shouldRunNow()Z
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->notInFailureBackoffTimePeriod()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->hasFastInternetAccess()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->deviceIsCharging()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected abstract getAnalyticsTaskQueue()Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;
.end method

.method protected abstract getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
.end method

.method protected abstract getServiceConfiguration()Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 64
    const/4 v0, 0x0

    return-object v0
.end method

.method public onFailure()V
    .locals 6

    .prologue
    .line 77
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->getAnalyticsTaskQueue()Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->peek()Lcom/squareup/tape/Task;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->getFailureCount()I

    move-result v0

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->getServiceConfiguration()Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;->getMaxTaskFailures()I

    move-result v1

    if-le v0, v1, :cond_0

    .line 78
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->getAnalyticsTaskQueue()Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->remove()V

    .line 80
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->running:Z

    .line 81
    iget v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->consecutiveFailures:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->consecutiveFailures:I

    .line 82
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->getServiceConfiguration()Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;->getDelayAfterError()J

    move-result-wide v2

    iget v4, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->consecutiveFailures:I

    int-to-long v4, v4

    mul-long/2addr v2, v4

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->postAfterTime:J

    .line 83
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->sendAnalytics()V

    .line 20
    const/4 v0, 0x1

    return v0
.end method

.method public onSuccess()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 69
    iput v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->consecutiveFailures:I

    .line 70
    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->running:Z

    .line 71
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->getAnalyticsTaskQueue()Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->remove()V

    .line 72
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;->sendAnalytics()V

    .line 73
    return-void
.end method
