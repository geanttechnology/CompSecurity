.class public Lcom/comcast/playerplatform/util/android/Clock;
.super Ljava/lang/Object;
.source "Clock.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;
    }
.end annotation


# instance fields
.field private final clockEventListeners:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;",
            ">;"
        }
    .end annotation
.end field

.field private final interval:J

.field private final name:Ljava/lang/String;

.field private timer:Ljava/util/Timer;


# direct methods
.method public constructor <init>(Ljava/lang/String;J)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "interval"    # J

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/util/android/Clock;->clockEventListeners:Ljava/util/Vector;

    .line 39
    iput-object p1, p0, Lcom/comcast/playerplatform/util/android/Clock;->name:Ljava/lang/String;

    .line 40
    iput-wide p2, p0, Lcom/comcast/playerplatform/util/android/Clock;->interval:J

    .line 41
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/util/android/Clock;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/util/android/Clock;

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/Clock;->dispatchClockEvent()V

    return-void
.end method

.method private dispatchClockEvent()V
    .locals 4

    .prologue
    .line 30
    iget-object v3, p0, Lcom/comcast/playerplatform/util/android/Clock;->clockEventListeners:Ljava/util/Vector;

    monitor-enter v3

    .line 32
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/util/android/Clock;->clockEventListeners:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    .line 33
    .local v1, "listener":Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;
    iget-object v2, p0, Lcom/comcast/playerplatform/util/android/Clock;->name:Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;->onTick(Ljava/lang/String;)V

    goto :goto_0

    .line 35
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 36
    return-void
.end method


# virtual methods
.method public addClockEventListener(Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/Clock;->clockEventListeners:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public removeClockEventListener(Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/Clock;->clockEventListeners:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public start()V
    .locals 6

    .prologue
    .line 44
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/util/android/Clock;->timer:Ljava/util/Timer;

    .line 45
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/Clock;->timer:Ljava/util/Timer;

    new-instance v1, Lcom/comcast/playerplatform/util/android/Clock$1;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/util/android/Clock$1;-><init>(Lcom/comcast/playerplatform/util/android/Clock;)V

    const-wide/16 v2, 0x0

    iget-wide v4, p0, Lcom/comcast/playerplatform/util/android/Clock;->interval:J

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 51
    return-void
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/Clock;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 55
    return-void
.end method
