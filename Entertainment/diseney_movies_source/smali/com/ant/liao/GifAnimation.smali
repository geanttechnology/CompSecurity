.class public Lcom/ant/liao/GifAnimation;
.super Ljava/lang/Object;
.source "GifAnimation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/ant/liao/GifAnimation$AnimationRunAble;
    }
.end annotation


# instance fields
.field private animation:Lcom/ant/liao/GifAnimation$AnimationRunAble;

.field private draw:Lcom/ant/liao/GifReDraw;

.field private handler:Landroid/os/Handler;

.field private pause:Z


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput-object v2, p0, Lcom/ant/liao/GifAnimation;->draw:Lcom/ant/liao/GifReDraw;

    .line 10
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/ant/liao/GifAnimation;->pause:Z

    .line 12
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/ant/liao/GifAnimation;->handler:Landroid/os/Handler;

    .line 13
    new-instance v0, Lcom/ant/liao/GifAnimation$AnimationRunAble;

    invoke-direct {v0, p0, v2}, Lcom/ant/liao/GifAnimation$AnimationRunAble;-><init>(Lcom/ant/liao/GifAnimation;Lcom/ant/liao/GifAnimation$AnimationRunAble;)V

    iput-object v0, p0, Lcom/ant/liao/GifAnimation;->animation:Lcom/ant/liao/GifAnimation$AnimationRunAble;

    .line 17
    return-void
.end method

.method static synthetic access$0(Lcom/ant/liao/GifAnimation;)Lcom/ant/liao/GifReDraw;
    .locals 1

    .prologue
    .line 9
    iget-object v0, p0, Lcom/ant/liao/GifAnimation;->draw:Lcom/ant/liao/GifReDraw;

    return-object v0
.end method

.method static synthetic access$1(Lcom/ant/liao/GifAnimation;)Z
    .locals 1

    .prologue
    .line 10
    iget-boolean v0, p0, Lcom/ant/liao/GifAnimation;->pause:Z

    return v0
.end method

.method static synthetic access$2(Lcom/ant/liao/GifAnimation;)Lcom/ant/liao/GifAnimation$AnimationRunAble;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/ant/liao/GifAnimation;->animation:Lcom/ant/liao/GifAnimation$AnimationRunAble;

    return-object v0
.end method

.method static synthetic access$3(Lcom/ant/liao/GifAnimation;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 12
    iget-object v0, p0, Lcom/ant/liao/GifAnimation;->handler:Landroid/os/Handler;

    return-object v0
.end method


# virtual methods
.method public destroy()V
    .locals 1

    .prologue
    .line 47
    invoke-virtual {p0}, Lcom/ant/liao/GifAnimation;->stopAnimation()V

    .line 48
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/ant/liao/GifAnimation;->draw:Lcom/ant/liao/GifReDraw;

    .line 49
    return-void
.end method

.method public pauseAnimation()V
    .locals 3

    .prologue
    .line 24
    iget-object v1, p0, Lcom/ant/liao/GifAnimation;->animation:Lcom/ant/liao/GifAnimation$AnimationRunAble;

    monitor-enter v1

    .line 25
    :try_start_0
    iget-object v0, p0, Lcom/ant/liao/GifAnimation;->handler:Landroid/os/Handler;

    iget-object v2, p0, Lcom/ant/liao/GifAnimation;->animation:Lcom/ant/liao/GifAnimation$AnimationRunAble;

    invoke-virtual {v0, v2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 26
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/ant/liao/GifAnimation;->pause:Z

    .line 24
    monitor-exit v1

    .line 28
    return-void

    .line 24
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public restartAnimation()V
    .locals 3

    .prologue
    .line 31
    iget-object v1, p0, Lcom/ant/liao/GifAnimation;->animation:Lcom/ant/liao/GifAnimation$AnimationRunAble;

    monitor-enter v1

    .line 32
    const/4 v0, 0x0

    :try_start_0
    iput-boolean v0, p0, Lcom/ant/liao/GifAnimation;->pause:Z

    .line 33
    iget-object v0, p0, Lcom/ant/liao/GifAnimation;->handler:Landroid/os/Handler;

    iget-object v2, p0, Lcom/ant/liao/GifAnimation;->animation:Lcom/ant/liao/GifAnimation$AnimationRunAble;

    invoke-virtual {v0, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 31
    monitor-exit v1

    .line 35
    return-void

    .line 31
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public runAnimation()V
    .locals 2

    .prologue
    .line 42
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/ant/liao/GifAnimation;->pause:Z

    .line 43
    iget-object v0, p0, Lcom/ant/liao/GifAnimation;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/ant/liao/GifAnimation;->animation:Lcom/ant/liao/GifAnimation$AnimationRunAble;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 44
    return-void
.end method

.method public setRedraw(Lcom/ant/liao/GifReDraw;)V
    .locals 0
    .param p1, "v"    # Lcom/ant/liao/GifReDraw;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/ant/liao/GifAnimation;->draw:Lcom/ant/liao/GifReDraw;

    .line 21
    return-void
.end method

.method public stopAnimation()V
    .locals 0

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/ant/liao/GifAnimation;->pauseAnimation()V

    .line 39
    return-void
.end method
