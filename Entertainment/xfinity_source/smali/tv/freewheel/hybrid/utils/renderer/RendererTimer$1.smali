.class Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;
.super Ljava/util/TimerTask;
.source "RendererTimer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->start()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 38
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # getter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$200(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "tick duration="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # getter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->duration:I
    invoke-static {v2}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$000(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", counter="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # getter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->counter:I
    invoke-static {v2}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$100(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 39
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # getter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->state:Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$300(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    if-eqz v0, :cond_0

    .line 50
    :goto_0
    return-void

    .line 41
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # getter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->counter:I
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$100(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)I

    move-result v0

    if-lez v0, :cond_1

    .line 42
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # operator-- for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->counter:I
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$110(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)I

    .line 49
    :goto_1
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # getter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timerService:Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$500(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # getter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->duration:I
    invoke-static {v1}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$000(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)I

    move-result v1

    iget-object v2, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # getter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->counter:I
    invoke-static {v2}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$100(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)I

    move-result v2

    sub-int/2addr v1, v2

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;->playHeadTime(I)V

    goto :goto_0

    .line 44
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # getter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timer:Ljava/util/Timer;
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$400(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)Ljava/util/Timer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 45
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # getter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timer:Ljava/util/Timer;
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$400(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)Ljava/util/Timer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 46
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    const/4 v1, 0x0

    # setter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timer:Ljava/util/Timer;
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$402(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;Ljava/util/Timer;)Ljava/util/Timer;

    .line 47
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;->this$0:Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    # getter for: Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timerService:Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->access$500(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;

    move-result-object v0

    invoke-interface {v0}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;->timeOut()V

    goto :goto_1
.end method
