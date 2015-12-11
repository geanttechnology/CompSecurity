.class Ltv/freewheel/hybrid/CuePointManager$1;
.super Ljava/lang/Object;
.source "CuePointManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/CuePointManager;->setupTimer()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/CuePointManager;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/CuePointManager;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 37
    iget-object v2, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->TIMER_UPDATE_INTERVAL:D
    invoke-static {}, Ltv/freewheel/hybrid/CuePointManager;->access$100()D

    move-result-wide v4

    # += operator for: Ltv/freewheel/hybrid/CuePointManager;->timeElapsedSinceStart:D
    invoke-static {v2, v4, v5}, Ltv/freewheel/hybrid/CuePointManager;->access$018(Ltv/freewheel/hybrid/CuePointManager;D)D

    .line 38
    iget-object v2, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/CuePointManager;->access$200(Ltv/freewheel/hybrid/CuePointManager;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "onTimer: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->timeElapsedSinceStart:D
    invoke-static {v4}, Ltv/freewheel/hybrid/CuePointManager;->access$000(Ltv/freewheel/hybrid/CuePointManager;)D

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 39
    iget-object v2, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->cuePoints:Ljava/util/ArrayList;
    invoke-static {v2}, Ltv/freewheel/hybrid/CuePointManager;->access$300(Ltv/freewheel/hybrid/CuePointManager;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 40
    iget-object v2, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/CuePointManager;->access$200(Ltv/freewheel/hybrid/CuePointManager;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    const-string v3, "no cue points left, stop timeline"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 41
    iget-object v2, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/CuePointManager;->stop()V

    .line 57
    :cond_0
    :goto_0
    return-void

    .line 45
    :cond_1
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v2, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->cuePoints:Ljava/util/ArrayList;
    invoke-static {v2}, Ltv/freewheel/hybrid/CuePointManager;->access$300(Ltv/freewheel/hybrid/CuePointManager;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_2

    .line 46
    iget-object v2, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->cuePoints:Ljava/util/ArrayList;
    invoke-static {v2}, Ltv/freewheel/hybrid/CuePointManager;->access$300(Ltv/freewheel/hybrid/CuePointManager;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/util/Pair;

    .line 47
    .local v0, "cp":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/Double;>;"
    iget-object v2, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Double;

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->TIMER_UPDATE_INTERVAL:D
    invoke-static {}, Ltv/freewheel/hybrid/CuePointManager;->access$100()D

    move-result-wide v4

    sub-double/2addr v2, v4

    iget-object v4, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->timeElapsedSinceStart:D
    invoke-static {v4}, Ltv/freewheel/hybrid/CuePointManager;->access$000(Ltv/freewheel/hybrid/CuePointManager;)D

    move-result-wide v4

    cmpg-double v2, v2, v4

    if-gez v2, :cond_3

    iget-object v2, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Double;

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->TIMER_UPDATE_INTERVAL:D
    invoke-static {}, Ltv/freewheel/hybrid/CuePointManager;->access$100()D

    move-result-wide v4

    add-double/2addr v2, v4

    iget-object v4, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->timeElapsedSinceStart:D
    invoke-static {v4}, Ltv/freewheel/hybrid/CuePointManager;->access$000(Ltv/freewheel/hybrid/CuePointManager;)D

    move-result-wide v4

    cmpl-double v2, v2, v4

    if-lez v2, :cond_3

    .line 49
    iget-object v2, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/CuePointManager;->access$200(Ltv/freewheel/hybrid/CuePointManager;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Firing CuePoint at time "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 50
    iget-object v3, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    new-instance v4, Ltv/freewheel/hybrid/utils/events/Event;

    sget-object v5, Ltv/freewheel/hybrid/CuePointManager;->EVENT_CUE_POINT_REACHED:Ljava/lang/String;

    iget-object v2, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    invoke-direct {v4, v5, v2}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/CuePointManager;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 54
    .end local v0    # "cp":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/Double;>;"
    :cond_2
    iget-object v2, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->cuePoints:Ljava/util/ArrayList;
    invoke-static {v2}, Ltv/freewheel/hybrid/CuePointManager;->access$300(Ltv/freewheel/hybrid/CuePointManager;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 55
    iget-object v2, p0, Ltv/freewheel/hybrid/CuePointManager$1;->this$0:Ltv/freewheel/hybrid/CuePointManager;

    # getter for: Ltv/freewheel/hybrid/CuePointManager;->cuePoints:Ljava/util/ArrayList;
    invoke-static {v2}, Ltv/freewheel/hybrid/CuePointManager;->access$300(Ltv/freewheel/hybrid/CuePointManager;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto/16 :goto_0

    .line 45
    .restart local v0    # "cp":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/Double;>;"
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_1
.end method
