.class public Lcom/amazon/analytics/session/PackageSession;
.super Ljava/lang/Object;
.source "PackageSession.java"


# static fields
.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private final WAIT_TIME_SECONDS:I

.field config:Lcom/amazon/analytics/AnalyticsConfiguration;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private future:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future",
            "<*>;"
        }
    .end annotation
.end field

.field private final packageName:Ljava/lang/String;

.field private runId:I

.field private sessionEvent:Lcom/amazon/device/analytics/events/Event;

.field sessionObserver:Lcom/amazon/analytics/session/SessionObserver;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private state:Lcom/amazon/analytics/session/SessionState;

.field timerService:Ljava/util/concurrent/ScheduledExecutorService;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation

    .annotation runtime Ljavax/inject/Named;
        value = "TailwindExecutorService"
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/amazon/analytics/session/PackageSession;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/analytics/session/PackageSession;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    invoke-static {p0}, Lcom/amazon/android/dagger/DaggerAndroid;->inject(Ljava/lang/Object;)V

    .line 43
    iget-object v0, p0, Lcom/amazon/analytics/session/PackageSession;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    sget-object v1, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->IgnoreSessionInterval:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    invoke-interface {v0, v1}, Lcom/amazon/analytics/AnalyticsConfiguration;->getInt(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)I

    move-result v0

    iput v0, p0, Lcom/amazon/analytics/session/PackageSession;->WAIT_TIME_SECONDS:I

    .line 44
    iput-object p1, p0, Lcom/amazon/analytics/session/PackageSession;->packageName:Ljava/lang/String;

    .line 45
    sget-object v0, Lcom/amazon/analytics/session/SessionState;->NO_SESSION:Lcom/amazon/analytics/session/SessionState;

    iput-object v0, p0, Lcom/amazon/analytics/session/PackageSession;->state:Lcom/amazon/analytics/session/SessionState;

    .line 46
    invoke-virtual {p0}, Lcom/amazon/analytics/session/PackageSession;->clearTrackingInfo()V

    .line 47
    return-void
.end method


# virtual methods
.method public clearTrackingInfo()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 138
    iput-object v0, p0, Lcom/amazon/analytics/session/PackageSession;->sessionEvent:Lcom/amazon/device/analytics/events/Event;

    .line 139
    iput-object v0, p0, Lcom/amazon/analytics/session/PackageSession;->future:Ljava/util/concurrent/Future;

    .line 140
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/analytics/session/PackageSession;->runId:I

    .line 141
    return-void
.end method

.method public getCurrentStartEvent()Lcom/amazon/device/analytics/events/Event;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/analytics/session/PackageSession;->sessionEvent:Lcom/amazon/device/analytics/events/Event;

    return-object v0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/analytics/session/PackageSession;->packageName:Ljava/lang/String;

    return-object v0
.end method

.method public getRunId()I
    .locals 1

    .prologue
    .line 109
    iget v0, p0, Lcom/amazon/analytics/session/PackageSession;->runId:I

    return v0
.end method

.method public getSessionState()Lcom/amazon/analytics/session/SessionState;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/analytics/session/PackageSession;->state:Lcom/amazon/analytics/session/SessionState;

    return-object v0
.end method

.method public incrementRunId()V
    .locals 1

    .prologue
    .line 113
    iget v0, p0, Lcom/amazon/analytics/session/PackageSession;->runId:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/analytics/session/PackageSession;->runId:I

    .line 114
    return-void
.end method

.method public scheduleTimerTask(Lcom/amazon/analytics/util/Message;)Z
    .locals 6
    .param p1, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 73
    const/4 v0, 0x0

    .line 74
    .local v0, "isScheduled":Z
    iget-object v1, p0, Lcom/amazon/analytics/session/PackageSession;->future:Ljava/util/concurrent/Future;

    if-nez v1, :cond_0

    .line 75
    const/4 v0, 0x1

    .line 76
    iget-object v1, p0, Lcom/amazon/analytics/session/PackageSession;->timerService:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v2, Lcom/amazon/analytics/session/PackageSession$1;

    invoke-direct {v2, p0, p1}, Lcom/amazon/analytics/session/PackageSession$1;-><init>(Lcom/amazon/analytics/session/PackageSession;Lcom/amazon/analytics/util/Message;)V

    iget v3, p0, Lcom/amazon/analytics/session/PackageSession;->WAIT_TIME_SECONDS:I

    int-to-long v3, v3

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v1, v2, v3, v4, v5}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/analytics/session/PackageSession;->future:Ljava/util/concurrent/Future;

    .line 88
    :cond_0
    return v0
.end method

.method public setCurrentStartEvent(Lcom/amazon/device/analytics/events/Event;)V
    .locals 0
    .param p1, "event"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/analytics/session/PackageSession;->sessionEvent:Lcom/amazon/device/analytics/events/Event;

    .line 63
    return-void
.end method

.method public tryCancelTimerTask()Z
    .locals 3

    .prologue
    .line 99
    const/4 v0, 0x0

    .line 100
    .local v0, "isCancelled":Z
    iget-object v1, p0, Lcom/amazon/analytics/session/PackageSession;->future:Ljava/util/concurrent/Future;

    if-eqz v1, :cond_0

    .line 101
    iget-object v1, p0, Lcom/amazon/analytics/session/PackageSession;->future:Ljava/util/concurrent/Future;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/concurrent/Future;->cancel(Z)Z

    move-result v0

    .line 102
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/analytics/session/PackageSession;->future:Ljava/util/concurrent/Future;

    .line 104
    :cond_0
    return v0
.end method

.method public tryChangeSessionState(Lcom/amazon/analytics/util/Message;)Lcom/amazon/device/analytics/events/Event;
    .locals 6
    .param p1, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 123
    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v3

    const-string/jumbo v4, "SessionFlag"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 124
    .local v1, "flag":I
    sget-object v3, Lcom/amazon/analytics/session/PackageSession;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Incoming message has session flag "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 126
    iget-object v3, p0, Lcom/amazon/analytics/session/PackageSession;->state:Lcom/amazon/analytics/session/SessionState;

    invoke-virtual {v3, p0, v1, p1}, Lcom/amazon/analytics/session/SessionState;->getNextState(Lcom/amazon/analytics/session/PackageSession;ILcom/amazon/analytics/util/Message;)Lcom/amazon/analytics/session/SessionState;

    move-result-object v2

    .line 127
    .local v2, "nextState":Lcom/amazon/analytics/session/SessionState;
    const/4 v0, 0x0

    .line 128
    .local v0, "event":Lcom/amazon/device/analytics/events/Event;
    iget-object v3, p0, Lcom/amazon/analytics/session/PackageSession;->state:Lcom/amazon/analytics/session/SessionState;

    if-eq v3, v2, :cond_0

    .line 129
    iget-object v3, p0, Lcom/amazon/analytics/session/PackageSession;->state:Lcom/amazon/analytics/session/SessionState;

    invoke-virtual {v2, p0, v3, p1}, Lcom/amazon/analytics/session/SessionState;->triggerOnStateAction(Lcom/amazon/analytics/session/PackageSession;Lcom/amazon/analytics/session/SessionState;Lcom/amazon/analytics/util/Message;)Lcom/amazon/device/analytics/events/Event;

    move-result-object v0

    .line 131
    :cond_0
    iput-object v2, p0, Lcom/amazon/analytics/session/PackageSession;->state:Lcom/amazon/analytics/session/SessionState;

    .line 133
    return-object v0
.end method
