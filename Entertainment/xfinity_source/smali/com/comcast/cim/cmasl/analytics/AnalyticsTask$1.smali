.class Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;
.super Ljava/lang/Object;
.source "AnalyticsTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->execute(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

.field final synthetic val$callback:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;->this$0:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;->val$callback:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 45
    iget-object v1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;->this$0:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    # getter for: Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
    invoke-static {v1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->access$100(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;->this$0:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    # getter for: Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->analyticsSenderFactory:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;
    invoke-static {v2}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->access$000(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;)Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;->this$0:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->getAnalyticsHost()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;->this$0:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    invoke-virtual {v4}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->getDataPairs()Ljava/util/Map;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;->createTask(Ljava/lang/String;Ljava/util/Map;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    .line 46
    .local v0, "taskExecutor":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    new-instance v1, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1$1;

    invoke-direct {v1, p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1$1;-><init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;)V

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 57
    return-void
.end method
