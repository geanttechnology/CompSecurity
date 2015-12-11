.class Lcom/newrelic/agent/android/stats/StatsEngine$Stat;
.super Ljava/lang/Object;
.source "StatsEngine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/newrelic/agent/android/stats/StatsEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Stat"
.end annotation


# instance fields
.field public callCount:J

.field public haveTime:Z

.field public maxTime:F

.field public minTime:F

.field public sumOfSquares:F

.field final synthetic this$0:Lcom/newrelic/agent/android/stats/StatsEngine;

.field public totalTime:F


# direct methods
.method private constructor <init>(Lcom/newrelic/agent/android/stats/StatsEngine;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 147
    iput-object p1, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->this$0:Lcom/newrelic/agent/android/stats/StatsEngine;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 148
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->callCount:J

    .line 149
    iput v2, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->totalTime:F

    .line 150
    const v0, 0x7f7fffff    # Float.MAX_VALUE

    iput v0, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->minTime:F

    .line 151
    const/4 v0, 0x1

    iput v0, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->maxTime:F

    .line 152
    iput v2, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->sumOfSquares:F

    .line 153
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->haveTime:Z

    return-void
.end method

.method synthetic constructor <init>(Lcom/newrelic/agent/android/stats/StatsEngine;Lcom/newrelic/agent/android/stats/StatsEngine$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/newrelic/agent/android/stats/StatsEngine;
    .param p2, "x1"    # Lcom/newrelic/agent/android/stats/StatsEngine$1;

    .prologue
    .line 147
    invoke-direct {p0, p1}, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;-><init>(Lcom/newrelic/agent/android/stats/StatsEngine;)V

    return-void
.end method


# virtual methods
.method public declared-synchronized toJSONObject()Lorg/json/JSONObject;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 162
    monitor-enter p0

    :try_start_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 164
    .local v0, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v2, "count"

    iget-wide v3, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->callCount:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 165
    const-string v2, "total"

    iget v3, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->totalTime:F

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 166
    const-string v3, "min"

    iget-boolean v2, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->haveTime:Z

    if-eqz v2, :cond_1

    iget v2, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->minTime:F

    :goto_0
    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v0, v3, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 167
    const-string v2, "max"

    iget-boolean v3, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->haveTime:Z

    if-eqz v3, :cond_0

    iget v1, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->maxTime:F

    :cond_0
    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 168
    const-string v1, "sum_of_squares"

    iget v2, p0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->sumOfSquares:F

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 170
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    :cond_1
    move v2, v1

    .line 166
    goto :goto_0

    .line 162
    .end local v0    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
