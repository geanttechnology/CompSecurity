.class public Ltv/freewheel/hybrid/CuePointManager;
.super Ltv/freewheel/hybrid/utils/events/EventDispatcher;
.source "CuePointManager.java"


# static fields
.field public static EVENT_CUE_POINT_REACHED:Ljava/lang/String;

.field private static TIMER_UPDATE_INTERVAL:D


# instance fields
.field private cuePoints:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Double;",
            ">;>;"
        }
    .end annotation
.end field

.field private final logger:Ltv/freewheel/hybrid/utils/Logger;

.field private timeElapsedSinceStart:D

.field private timer:Ltv/freewheel/hybrid/utils/Scheduler;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 13
    const-wide/high16 v0, 0x3fe0000000000000L    # 0.5

    sput-wide v0, Ltv/freewheel/hybrid/CuePointManager;->TIMER_UPDATE_INTERVAL:D

    .line 14
    const-string v0, "event_cue_point_reached"

    sput-object v0, Ltv/freewheel/hybrid/CuePointManager;->EVENT_CUE_POINT_REACHED:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ltv/freewheel/hybrid/utils/events/EventDispatcher;-><init>()V

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->cuePoints:Ljava/util/ArrayList;

    .line 23
    new-instance v0, Ltv/freewheel/hybrid/utils/Scheduler;

    invoke-direct {v0}, Ltv/freewheel/hybrid/utils/Scheduler;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->timer:Ltv/freewheel/hybrid/utils/Scheduler;

    .line 24
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 25
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/CuePointManager;)D
    .locals 2
    .param p0, "x0"    # Ltv/freewheel/hybrid/CuePointManager;

    .prologue
    .line 12
    iget-wide v0, p0, Ltv/freewheel/hybrid/CuePointManager;->timeElapsedSinceStart:D

    return-wide v0
.end method

.method static synthetic access$018(Ltv/freewheel/hybrid/CuePointManager;D)D
    .locals 3
    .param p0, "x0"    # Ltv/freewheel/hybrid/CuePointManager;
    .param p1, "x1"    # D

    .prologue
    .line 12
    iget-wide v0, p0, Ltv/freewheel/hybrid/CuePointManager;->timeElapsedSinceStart:D

    add-double/2addr v0, p1

    iput-wide v0, p0, Ltv/freewheel/hybrid/CuePointManager;->timeElapsedSinceStart:D

    return-wide v0
.end method

.method static synthetic access$100()D
    .locals 2

    .prologue
    .line 12
    sget-wide v0, Ltv/freewheel/hybrid/CuePointManager;->TIMER_UPDATE_INTERVAL:D

    return-wide v0
.end method

.method static synthetic access$200(Ltv/freewheel/hybrid/CuePointManager;)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/CuePointManager;

    .prologue
    .line 12
    iget-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-object v0
.end method

.method static synthetic access$300(Ltv/freewheel/hybrid/CuePointManager;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/CuePointManager;

    .prologue
    .line 12
    iget-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->cuePoints:Ljava/util/ArrayList;

    return-object v0
.end method


# virtual methods
.method public addCuePointForName(Ljava/lang/String;D)V
    .locals 4
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "time"    # D

    .prologue
    .line 28
    iget-object v1, p0, Ltv/freewheel/hybrid/CuePointManager;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Adding cuePoint "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " at "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2, p3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 29
    invoke-static {p2, p3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-static {p1, v1}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v0

    .line 30
    .local v0, "cp":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/Double;>;"
    iget-object v1, p0, Ltv/freewheel/hybrid/CuePointManager;->cuePoints:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 31
    return-void
.end method

.method public reset()V
    .locals 2

    .prologue
    .line 84
    iget-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "reset"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 85
    iget-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->cuePoints:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 86
    invoke-virtual {p0}, Ltv/freewheel/hybrid/CuePointManager;->stop()V

    .line 87
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Ltv/freewheel/hybrid/CuePointManager;->timeElapsedSinceStart:D

    .line 88
    return-void
.end method

.method public setupTimer()V
    .locals 4

    .prologue
    .line 34
    iget-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "setupTimer"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 35
    iget-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->timer:Ltv/freewheel/hybrid/utils/Scheduler;

    new-instance v1, Ltv/freewheel/hybrid/CuePointManager$1;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/CuePointManager$1;-><init>(Ltv/freewheel/hybrid/CuePointManager;)V

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Scheduler;->setTask(Ljava/lang/Runnable;)V

    .line 59
    iget-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->timer:Ltv/freewheel/hybrid/utils/Scheduler;

    sget-wide v2, Ltv/freewheel/hybrid/CuePointManager;->TIMER_UPDATE_INTERVAL:D

    const/4 v1, 0x1

    invoke-virtual {v0, v2, v3, v1}, Ltv/freewheel/hybrid/utils/Scheduler;->start(DZ)V

    .line 60
    return-void
.end method

.method public start()V
    .locals 2

    .prologue
    .line 63
    iget-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "start"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 64
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Ltv/freewheel/hybrid/CuePointManager;->timeElapsedSinceStart:D

    .line 65
    invoke-virtual {p0}, Ltv/freewheel/hybrid/CuePointManager;->setupTimer()V

    .line 66
    return-void
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 69
    iget-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 70
    iget-object v0, p0, Ltv/freewheel/hybrid/CuePointManager;->timer:Ltv/freewheel/hybrid/utils/Scheduler;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/utils/Scheduler;->stop()V

    .line 71
    return-void
.end method
