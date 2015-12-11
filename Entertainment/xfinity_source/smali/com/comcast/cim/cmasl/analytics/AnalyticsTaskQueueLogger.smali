.class public Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;
.super Ljava/lang/Object;
.source "AnalyticsTaskQueueLogger.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;


# instance fields
.field private final analyticsTaskQueue:Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

.field private final applicationName:Ljava/lang/String;

.field private final hostUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "analyticsTaskQueue"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;
    .param p2, "applicationName"    # Ljava/lang/String;
    .param p3, "hostUrl"    # Ljava/lang/String;

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    iput-object p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;->analyticsTaskQueue:Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    .line 11
    iput-object p2, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;->applicationName:Ljava/lang/String;

    .line 12
    iput-object p3, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;->hostUrl:Ljava/lang/String;

    .line 13
    return-void
.end method


# virtual methods
.method public logData(Lcom/comcast/cim/cmasl/analytics/EventData;)V
    .locals 3
    .param p1, "data"    # Lcom/comcast/cim/cmasl/analytics/EventData;

    .prologue
    .line 17
    const-string v0, "app"

    iget-object v1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;->applicationName:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/comcast/cim/cmasl/analytics/EventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;->analyticsTaskQueue:Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    new-instance v1, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;->hostUrl:Ljava/lang/String;

    invoke-direct {v1, v2, p1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;-><init>(Ljava/lang/String;Lcom/comcast/cim/cmasl/analytics/EventData;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->add(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask;)V

    .line 19
    return-void
.end method

.method public startService()V
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;->analyticsTaskQueue:Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;->startService()V

    .line 24
    return-void
.end method
