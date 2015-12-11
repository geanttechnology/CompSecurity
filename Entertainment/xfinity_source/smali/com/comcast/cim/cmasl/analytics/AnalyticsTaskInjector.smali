.class public Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;
.super Ljava/lang/Object;
.source "AnalyticsTaskInjector.java"

# interfaces
.implements Lcom/squareup/tape/TaskInjector;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/squareup/tape/TaskInjector",
        "<",
        "Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;",
        ">;"
    }
.end annotation


# instance fields
.field private final analyticsSenderFactory:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

.field private final taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;)V
    .locals 0
    .param p1, "analyticsSenderFactory"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;
    .param p2, "taskExecutorFactory"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;->analyticsSenderFactory:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    .line 14
    iput-object p2, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 15
    return-void
.end method


# virtual methods
.method public injectMembers(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;)V
    .locals 1
    .param p1, "analyticsTask"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;->analyticsSenderFactory:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->setAnalyticsSenderFactory(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;)V

    .line 20
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;->setTaskExecutorFactory(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;)V

    .line 21
    return-void
.end method

.method public bridge synthetic injectMembers(Lcom/squareup/tape/Task;)V
    .locals 0
    .param p1, "x0"    # Lcom/squareup/tape/Task;

    .prologue
    .line 6
    check-cast p1, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    .end local p1    # "x0":Lcom/squareup/tape/Task;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;->injectMembers(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;)V

    return-void
.end method
