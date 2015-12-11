.class Ltv/freewheel/hybrid/utils/Scheduler$2;
.super Ljava/util/TimerTask;
.source "Scheduler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/utils/Scheduler;->start(DZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/utils/Scheduler;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/utils/Scheduler;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Ltv/freewheel/hybrid/utils/Scheduler$2;->this$0:Ltv/freewheel/hybrid/utils/Scheduler;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 53
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler$2;->this$0:Ltv/freewheel/hybrid/utils/Scheduler;

    iget-object v1, p0, Ltv/freewheel/hybrid/utils/Scheduler$2;->this$0:Ltv/freewheel/hybrid/utils/Scheduler;

    # getter for: Ltv/freewheel/hybrid/utils/Scheduler;->recordTimer:Ltv/freewheel/hybrid/utils/RecordTimer;
    invoke-static {v1}, Ltv/freewheel/hybrid/utils/Scheduler;->access$100(Ltv/freewheel/hybrid/utils/Scheduler;)Ltv/freewheel/hybrid/utils/RecordTimer;

    move-result-object v1

    invoke-virtual {v1}, Ltv/freewheel/hybrid/utils/RecordTimer;->tick()J

    move-result-wide v2

    # setter for: Ltv/freewheel/hybrid/utils/Scheduler;->lastRunDuration:J
    invoke-static {v0, v2, v3}, Ltv/freewheel/hybrid/utils/Scheduler;->access$002(Ltv/freewheel/hybrid/utils/Scheduler;J)J

    .line 54
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler$2;->this$0:Ltv/freewheel/hybrid/utils/Scheduler;

    # getter for: Ltv/freewheel/hybrid/utils/Scheduler;->task:Ljava/lang/Runnable;
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/Scheduler;->access$200(Ltv/freewheel/hybrid/utils/Scheduler;)Ljava/lang/Runnable;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 55
    return-void
.end method
