.class public Lcom/poshmark/utils/PMSearchBoxTimer;
.super Ljava/util/TimerTask;
.source "PMSearchBoxTimer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;
    }
.end annotation


# instance fields
.field callOnUIThread:Z

.field callback:Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;

.field searchString:Ljava/lang/String;


# direct methods
.method public constructor <init>(IZLjava/lang/String;Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;)V
    .locals 4
    .param p1, "timeInMilli"    # I
    .param p2, "callOnUIThread"    # Z
    .param p3, "keyword"    # Ljava/lang/String;
    .param p4, "callback"    # Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    .line 19
    iput-object p3, p0, Lcom/poshmark/utils/PMSearchBoxTimer;->searchString:Ljava/lang/String;

    .line 20
    iput-object p4, p0, Lcom/poshmark/utils/PMSearchBoxTimer;->callback:Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;

    .line 21
    iput-boolean p2, p0, Lcom/poshmark/utils/PMSearchBoxTimer;->callOnUIThread:Z

    .line 22
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 23
    .local v0, "timer":Ljava/util/Timer;
    int-to-long v2, p1

    invoke-virtual {v0, p0, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 24
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/poshmark/utils/PMSearchBoxTimer;->callOnUIThread:Z

    if-eqz v0, :cond_0

    .line 28
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplication;->getActivity()Lcom/poshmark/ui/MainActivity;

    move-result-object v0

    new-instance v1, Lcom/poshmark/utils/PMSearchBoxTimer$1;

    invoke-direct {v1, p0}, Lcom/poshmark/utils/PMSearchBoxTimer$1;-><init>(Lcom/poshmark/utils/PMSearchBoxTimer;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 37
    :goto_0
    return-void

    .line 35
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/PMSearchBoxTimer;->callback:Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;

    iget-object v1, p0, Lcom/poshmark/utils/PMSearchBoxTimer;->searchString:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;->timerCallback(Ljava/lang/String;)V

    goto :goto_0
.end method
