.class public Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;
.super Ljava/lang/Object;
.source "AnalyticsTask.java"

# interfaces
.implements Lcom/squareup/tape/Task;
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/squareup/tape/Task",
        "<",
        "Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;",
        ">;",
        "Ljava/io/Serializable;"
    }
.end annotation


# instance fields
.field LOG:Lorg/slf4j/Logger;

.field private analyticsHost:Ljava/lang/String;

.field private transient analyticsSenderFactory:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

.field private dataPairs:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private failureCount:I

.field private transient taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    const-class v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->LOG:Lorg/slf4j/Logger;

    .line 19
    const/4 v0, 0x0

    iput v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->failureCount:I

    .line 25
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/comcast/cim/cmasl/analytics/EventData;)V
    .locals 1
    .param p1, "analyticsHost"    # Ljava/lang/String;
    .param p2, "data"    # Lcom/comcast/cim/cmasl/analytics/EventData;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    const-class v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->LOG:Lorg/slf4j/Logger;

    .line 19
    const/4 v0, 0x0

    iput v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->failureCount:I

    .line 28
    iput-object p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->analyticsHost:Ljava/lang/String;

    .line 29
    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/analytics/EventData;->getEventData()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->dataPairs:Ljava/util/Map;

    .line 30
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;)Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->analyticsSenderFactory:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    return-object v0
.end method


# virtual methods
.method public execute(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;)V
    .locals 2
    .param p1, "callback"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;

    .prologue
    .line 42
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;

    invoke-direct {v1, p0, p1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;-><init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 59
    return-void
.end method

.method public getAnalyticsHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->analyticsHost:Ljava/lang/String;

    return-object v0
.end method

.method public getDataPairs()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 66
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->dataPairs:Ljava/util/Map;

    return-object v0
.end method

.method public getFailureCount()I
    .locals 1

    .prologue
    .line 62
    iget v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->failureCount:I

    return v0
.end method

.method public setAnalyticsSenderFactory(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;)V
    .locals 0
    .param p1, "analyticsSenderFactory"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->analyticsSenderFactory:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    .line 76
    return-void
.end method

.method public setTaskExecutorFactory(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;)V
    .locals 0
    .param p1, "taskExecutorFactory"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 80
    return-void
.end method
