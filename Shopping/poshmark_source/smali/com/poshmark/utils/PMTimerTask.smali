.class public Lcom/poshmark/utils/PMTimerTask;
.super Ljava/util/TimerTask;
.source "PMTimerTask.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/PMTimerTask$PMTimerTaskCallback;
    }
.end annotation


# instance fields
.field callOnUIThread:Z

.field callback:Lcom/poshmark/utils/PMTimerTask$PMTimerTaskCallback;


# direct methods
.method public constructor <init>(IZLcom/poshmark/utils/PMTimerTask$PMTimerTaskCallback;)V
    .locals 4
    .param p1, "timeInMilli"    # I
    .param p2, "callOnUIThread"    # Z
    .param p3, "callback"    # Lcom/poshmark/utils/PMTimerTask$PMTimerTaskCallback;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    .line 17
    iput-object p3, p0, Lcom/poshmark/utils/PMTimerTask;->callback:Lcom/poshmark/utils/PMTimerTask$PMTimerTaskCallback;

    .line 18
    iput-boolean p2, p0, Lcom/poshmark/utils/PMTimerTask;->callOnUIThread:Z

    .line 19
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 20
    .local v0, "timer":Ljava/util/Timer;
    int-to-long v2, p1

    invoke-virtual {v0, p0, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 21
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 24
    iget-boolean v0, p0, Lcom/poshmark/utils/PMTimerTask;->callOnUIThread:Z

    if-eqz v0, :cond_0

    .line 25
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplication;->getActivity()Lcom/poshmark/ui/MainActivity;

    move-result-object v0

    new-instance v1, Lcom/poshmark/utils/PMTimerTask$1;

    invoke-direct {v1, p0}, Lcom/poshmark/utils/PMTimerTask$1;-><init>(Lcom/poshmark/utils/PMTimerTask;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 34
    :goto_0
    return-void

    .line 32
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/PMTimerTask;->callback:Lcom/poshmark/utils/PMTimerTask$PMTimerTaskCallback;

    invoke-interface {v0}, Lcom/poshmark/utils/PMTimerTask$PMTimerTaskCallback;->timerCallback()V

    goto :goto_0
.end method
