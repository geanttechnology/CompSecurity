.class Lcom/ant/liao/GifAnimation$AnimationRunAble;
.super Ljava/lang/Object;
.source "GifAnimation.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/ant/liao/GifAnimation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AnimationRunAble"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/ant/liao/GifAnimation;


# direct methods
.method private constructor <init>(Lcom/ant/liao/GifAnimation;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/ant/liao/GifAnimation$AnimationRunAble;->this$0:Lcom/ant/liao/GifAnimation;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/ant/liao/GifAnimation;Lcom/ant/liao/GifAnimation$AnimationRunAble;)V
    .locals 0

    .prologue
    .line 51
    invoke-direct {p0, p1}, Lcom/ant/liao/GifAnimation$AnimationRunAble;-><init>(Lcom/ant/liao/GifAnimation;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 53
    iget-object v1, p0, Lcom/ant/liao/GifAnimation$AnimationRunAble;->this$0:Lcom/ant/liao/GifAnimation;

    # getter for: Lcom/ant/liao/GifAnimation;->draw:Lcom/ant/liao/GifReDraw;
    invoke-static {v1}, Lcom/ant/liao/GifAnimation;->access$0(Lcom/ant/liao/GifAnimation;)Lcom/ant/liao/GifReDraw;

    move-result-object v1

    invoke-interface {v1}, Lcom/ant/liao/GifReDraw;->reDraw()I

    move-result v0

    .line 54
    .local v0, "delay":I
    iget-object v1, p0, Lcom/ant/liao/GifAnimation$AnimationRunAble;->this$0:Lcom/ant/liao/GifAnimation;

    # getter for: Lcom/ant/liao/GifAnimation;->pause:Z
    invoke-static {v1}, Lcom/ant/liao/GifAnimation;->access$1(Lcom/ant/liao/GifAnimation;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 55
    if-lez v0, :cond_0

    .line 56
    int-to-long v1, v0

    invoke-static {v1, v2}, Landroid/os/SystemClock;->sleep(J)V

    .line 57
    :cond_0
    iget-object v1, p0, Lcom/ant/liao/GifAnimation$AnimationRunAble;->this$0:Lcom/ant/liao/GifAnimation;

    # getter for: Lcom/ant/liao/GifAnimation;->animation:Lcom/ant/liao/GifAnimation$AnimationRunAble;
    invoke-static {v1}, Lcom/ant/liao/GifAnimation;->access$2(Lcom/ant/liao/GifAnimation;)Lcom/ant/liao/GifAnimation$AnimationRunAble;

    move-result-object v2

    monitor-enter v2

    .line 58
    :try_start_0
    iget-object v1, p0, Lcom/ant/liao/GifAnimation$AnimationRunAble;->this$0:Lcom/ant/liao/GifAnimation;

    # getter for: Lcom/ant/liao/GifAnimation;->pause:Z
    invoke-static {v1}, Lcom/ant/liao/GifAnimation;->access$1(Lcom/ant/liao/GifAnimation;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 59
    iget-object v1, p0, Lcom/ant/liao/GifAnimation$AnimationRunAble;->this$0:Lcom/ant/liao/GifAnimation;

    # getter for: Lcom/ant/liao/GifAnimation;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/ant/liao/GifAnimation;->access$3(Lcom/ant/liao/GifAnimation;)Landroid/os/Handler;

    move-result-object v1

    iget-object v3, p0, Lcom/ant/liao/GifAnimation$AnimationRunAble;->this$0:Lcom/ant/liao/GifAnimation;

    # getter for: Lcom/ant/liao/GifAnimation;->animation:Lcom/ant/liao/GifAnimation$AnimationRunAble;
    invoke-static {v3}, Lcom/ant/liao/GifAnimation;->access$2(Lcom/ant/liao/GifAnimation;)Lcom/ant/liao/GifAnimation$AnimationRunAble;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 57
    :cond_1
    monitor-exit v2

    .line 62
    :cond_2
    return-void

    .line 57
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method
