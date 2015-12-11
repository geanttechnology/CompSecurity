.class public Lcom/amazon/analytics/session/poller/ScreenStateMonitor;
.super Ljava/lang/Object;
.source "ScreenStateMonitor.java"

# interfaces
.implements Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;


# instance fields
.field private final pollSeconds:I

.field private pollerTask:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future",
            "<*>;"
        }
    .end annotation
.end field

.field private final runner:Ljava/lang/Runnable;

.field private final scheduledService:Ljava/util/concurrent/ScheduledExecutorService;


# direct methods
.method public constructor <init>(Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Runnable;I)V
    .locals 7
    .param p1, "scheduledService"    # Ljava/util/concurrent/ScheduledExecutorService;
    .param p2, "runner"    # Ljava/lang/Runnable;
    .param p3, "pollSeconds"    # I

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->scheduledService:Ljava/util/concurrent/ScheduledExecutorService;

    .line 22
    iput-object p2, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->runner:Ljava/lang/Runnable;

    .line 23
    iput p3, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->pollSeconds:I

    .line 24
    const-wide/16 v2, 0x0

    int-to-long v4, p3

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    move-object v0, p1

    move-object v1, p2

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->pollerTask:Ljava/util/concurrent/Future;

    .line 25
    return-void
.end method


# virtual methods
.method public onScreenOff()V
    .locals 2

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->pollerTask:Ljava/util/concurrent/Future;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->pollerTask:Ljava/util/concurrent/Future;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/concurrent/Future;->cancel(Z)Z

    .line 45
    iget-object v0, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->scheduledService:Ljava/util/concurrent/ScheduledExecutorService;

    iget-object v1, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->runner:Ljava/lang/Runnable;

    invoke-interface {v0, v1}, Ljava/util/concurrent/ScheduledExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 46
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->pollerTask:Ljava/util/concurrent/Future;

    .line 48
    :cond_0
    return-void
.end method

.method public onScreenOn()V
    .locals 7

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->pollerTask:Ljava/util/concurrent/Future;

    if-nez v0, :cond_0

    .line 33
    iget-object v0, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->scheduledService:Ljava/util/concurrent/ScheduledExecutorService;

    iget-object v1, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->runner:Ljava/lang/Runnable;

    iget v2, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->pollSeconds:I

    int-to-long v2, v2

    iget v4, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->pollSeconds:I

    int-to-long v4, v4

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;->pollerTask:Ljava/util/concurrent/Future;

    .line 36
    :cond_0
    return-void
.end method
