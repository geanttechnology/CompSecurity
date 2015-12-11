.class Ltv/freewheel/utils/Scheduler$2;
.super Ljava/util/TimerTask;
.source "Scheduler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/utils/Scheduler;->start(DZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/utils/Scheduler;


# direct methods
.method constructor <init>(Ltv/freewheel/utils/Scheduler;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Ltv/freewheel/utils/Scheduler$2;->this$0:Ltv/freewheel/utils/Scheduler;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 55
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler$2;->this$0:Ltv/freewheel/utils/Scheduler;

    # getter for: Ltv/freewheel/utils/Scheduler;->recordTimer:Ltv/freewheel/utils/RecordTimer;
    invoke-static {v0}, Ltv/freewheel/utils/Scheduler;->access$000(Ltv/freewheel/utils/Scheduler;)Ltv/freewheel/utils/RecordTimer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler$2;->this$0:Ltv/freewheel/utils/Scheduler;

    iget-object v1, p0, Ltv/freewheel/utils/Scheduler$2;->this$0:Ltv/freewheel/utils/Scheduler;

    # getter for: Ltv/freewheel/utils/Scheduler;->recordTimer:Ltv/freewheel/utils/RecordTimer;
    invoke-static {v1}, Ltv/freewheel/utils/Scheduler;->access$000(Ltv/freewheel/utils/Scheduler;)Ltv/freewheel/utils/RecordTimer;

    move-result-object v1

    invoke-virtual {v1}, Ltv/freewheel/utils/RecordTimer;->tick()J

    move-result-wide v2

    # setter for: Ltv/freewheel/utils/Scheduler;->lastRunDuration:J
    invoke-static {v0, v2, v3}, Ltv/freewheel/utils/Scheduler;->access$102(Ltv/freewheel/utils/Scheduler;J)J

    .line 57
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler$2;->this$0:Ltv/freewheel/utils/Scheduler;

    # getter for: Ltv/freewheel/utils/Scheduler;->task:Ljava/lang/Runnable;
    invoke-static {v0}, Ltv/freewheel/utils/Scheduler;->access$200(Ltv/freewheel/utils/Scheduler;)Ljava/lang/Runnable;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 59
    :cond_0
    return-void
.end method
