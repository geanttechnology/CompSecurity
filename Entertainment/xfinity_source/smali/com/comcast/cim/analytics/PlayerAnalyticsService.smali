.class public Lcom/comcast/cim/analytics/PlayerAnalyticsService;
.super Lcom/comcast/cim/cmasl/analytics/AnalyticsService;
.source "PlayerAnalyticsService.java"


# instance fields
.field private analyticsTaskQueue:Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

.field private internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private serviceConfiguration:Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsService;-><init>()V

    .line 11
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAnalyticsTaskQueue()Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/analytics/PlayerAnalyticsService;->analyticsTaskQueue:Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    .line 12
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/analytics/PlayerAnalyticsService;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 13
    invoke-static {}, Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;->getDefaultAnalyticsServiceConfiguration()Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/analytics/PlayerAnalyticsService;->serviceConfiguration:Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;

    return-void
.end method


# virtual methods
.method protected getAnalyticsTaskQueue()Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/cim/analytics/PlayerAnalyticsService;->analyticsTaskQueue:Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    return-object v0
.end method

.method protected getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/comcast/cim/analytics/PlayerAnalyticsService;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    return-object v0
.end method

.method protected getServiceConfiguration()Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/cim/analytics/PlayerAnalyticsService;->serviceConfiguration:Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;

    return-object v0
.end method
