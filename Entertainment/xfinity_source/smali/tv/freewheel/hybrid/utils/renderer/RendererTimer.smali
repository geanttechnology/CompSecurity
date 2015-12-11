.class public Ltv/freewheel/hybrid/utils/renderer/RendererTimer;
.super Ljava/lang/Object;
.source "RendererTimer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;
    }
.end annotation


# static fields
.field private static CLASSTAG:Ljava/lang/String;


# instance fields
.field private counter:I

.field private duration:I

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private state:Ljava/util/concurrent/atomic/AtomicInteger;

.field private timer:Ljava/util/Timer;

.field private timerService:Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-string v0, "RendererTimer"

    sput-object v0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->CLASSTAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(ILtv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;)V
    .locals 3
    .param p1, "duration"    # I
    .param p2, "timeOut"    # Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 25
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "RendererTimer(duration="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 26
    iput p1, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->duration:I

    .line 27
    iput p1, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->counter:I

    .line 28
    iput-object p2, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timerService:Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;

    .line 29
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timer:Ljava/util/Timer;

    .line 30
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 31
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    .prologue
    .line 9
    iget v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->duration:I

    return v0
.end method

.method static synthetic access$100(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    .prologue
    .line 9
    iget v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->counter:I

    return v0
.end method

.method static synthetic access$110(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)I
    .locals 2
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    .prologue
    .line 9
    iget v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->counter:I

    add-int/lit8 v1, v0, -0x1

    iput v1, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->counter:I

    return v0
.end method

.method static synthetic access$200(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    .prologue
    .line 9
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-object v0
.end method

.method static synthetic access$300(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)Ljava/util/concurrent/atomic/AtomicInteger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    .prologue
    .line 9
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    return-object v0
.end method

.method static synthetic access$400(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)Ljava/util/Timer;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    .prologue
    .line 9
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timer:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$402(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;Ljava/util/Timer;)Ljava/util/Timer;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/renderer/RendererTimer;
    .param p1, "x1"    # Ljava/util/Timer;

    .prologue
    .line 9
    iput-object p1, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timer:Ljava/util/Timer;

    return-object p1
.end method

.method static synthetic access$500(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/renderer/RendererTimer;

    .prologue
    .line 9
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timerService:Ltv/freewheel/hybrid/utils/renderer/RendererTimer$IRendererTimerService;

    return-object v0
.end method


# virtual methods
.method public pause()V
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "pause"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 68
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 69
    return-void
.end method

.method public resume()V
    .locals 2

    .prologue
    .line 72
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "resume"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 73
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 74
    return-void
.end method

.method public start()V
    .locals 6

    .prologue
    .line 34
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v2, "start"

    invoke-virtual {v0, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 35
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 36
    new-instance v1, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/utils/renderer/RendererTimer$1;-><init>(Ltv/freewheel/hybrid/utils/renderer/RendererTimer;)V

    .line 53
    .local v1, "tick":Ljava/util/TimerTask;
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timer:Ljava/util/Timer;

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3e8

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    .line 54
    return-void
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 57
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 58
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 59
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 61
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 62
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/renderer/RendererTimer;->timer:Ljava/util/Timer;

    .line 64
    :cond_0
    return-void
.end method
