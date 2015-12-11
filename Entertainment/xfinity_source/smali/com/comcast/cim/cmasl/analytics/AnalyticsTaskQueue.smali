.class public Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;
.super Lcom/squareup/tape/TaskQueue;
.source "AnalyticsTaskQueue.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/squareup/tape/TaskQueue",
        "<",
        "Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;",
        ">;"
    }
.end annotation


# instance fields
.field private final context:Landroid/content/Context;

.field private final serviceName:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsService;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/squareup/tape/ObjectQueue;Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;Landroid/content/Context;Ljava/lang/Class;)V
    .locals 0
    .param p2, "analyticsTaskInjector"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;
    .param p3, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/squareup/tape/ObjectQueue",
            "<",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;",
            ">;",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskInjector;",
            "Landroid/content/Context;",
            "Ljava/lang/Class",
            "<+",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsService;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 17
    .local p1, "delegate":Lcom/squareup/tape/ObjectQueue;, "Lcom/squareup/tape/ObjectQueue<Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;>;"
    .local p4, "serviceName":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/comcast/cim/cmasl/analytics/AnalyticsService;>;"
    invoke-direct {p0, p1, p2}, Lcom/squareup/tape/TaskQueue;-><init>(Lcom/squareup/tape/ObjectQueue;Lcom/squareup/tape/TaskInjector;)V

    .line 18
    iput-object p3, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->context:Landroid/content/Context;

    .line 19
    iput-object p4, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->serviceName:Ljava/lang/Class;

    .line 20
    return-void
.end method


# virtual methods
.method public add(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;)V
    .locals 2
    .param p1, "task"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    .prologue
    .line 24
    invoke-super {p0, p1}, Lcom/squareup/tape/TaskQueue;->add(Lcom/squareup/tape/Task;)V

    .line 26
    :goto_0
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->size()I

    move-result v0

    const/16 v1, 0x1e

    if-le v0, v1, :cond_0

    .line 27
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->remove()V

    goto :goto_0

    .line 29
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->startService()V

    .line 30
    return-void
.end method

.method public bridge synthetic add(Lcom/squareup/tape/Task;)V
    .locals 0
    .param p1, "x0"    # Lcom/squareup/tape/Task;

    .prologue
    .line 8
    check-cast p1, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    .end local p1    # "x0":Lcom/squareup/tape/Task;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->add(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;)V

    return-void
.end method

.method public bridge synthetic add(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 8
    check-cast p1, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->add(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;)V

    return-void
.end method

.method protected startService()V
    .locals 4

    .prologue
    .line 33
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->context:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->context:Landroid/content/Context;

    iget-object v3, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->serviceName:Ljava/lang/Class;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v1}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 34
    return-void
.end method
