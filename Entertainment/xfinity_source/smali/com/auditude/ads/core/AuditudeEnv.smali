.class public Lcom/auditude/ads/core/AuditudeEnv;
.super Ljava/lang/Object;
.source "AuditudeEnv.java"


# static fields
.field private static instance:Lcom/auditude/ads/core/AuditudeEnv;


# instance fields
.field private adSettings:Lcom/auditude/ads/core/AdSettings;

.field private apiBridge:Lcom/auditude/ads/core/APIBridge;

.field private reporting:Lcom/auditude/ads/reporting/ReportingHelper;

.field public shouldIgnoreNextBreak:Ljava/lang/Boolean;

.field public shouldPauseAdPatterns:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/core/AuditudeEnv;->shouldPauseAdPatterns:Ljava/lang/Boolean;

    .line 17
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/core/AuditudeEnv;->shouldIgnoreNextBreak:Ljava/lang/Boolean;

    .line 25
    return-void
.end method

.method public static getInstance()Lcom/auditude/ads/core/AuditudeEnv;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/auditude/ads/core/AuditudeEnv;->instance:Lcom/auditude/ads/core/AuditudeEnv;

    return-object v0
.end method

.method private initLoggers()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 58
    invoke-static {}, Lcom/auditude/ads/util/log/Log;->flush()V

    .line 62
    new-instance v0, Lcom/auditude/ads/util/log/targets/TraceTarget;

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/auditude/ads/util/log/targets/TraceTarget;-><init>(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V

    .line 63
    .local v0, "target":Lcom/auditude/ads/util/log/targets/AbstractTarget;
    sget-object v1, Lcom/auditude/ads/util/log/LogLevel;->ALL:Lcom/auditude/ads/util/log/LogLevel;

    invoke-virtual {v0, v1}, Lcom/auditude/ads/util/log/targets/AbstractTarget;->setLevel(Lcom/auditude/ads/util/log/LogLevel;)V

    .line 69
    return-void
.end method

.method public static setEnvironment(Lcom/auditude/ads/core/AuditudeEnv;)V
    .locals 0
    .param p0, "env"    # Lcom/auditude/ads/core/AuditudeEnv;

    .prologue
    .line 34
    sput-object p0, Lcom/auditude/ads/core/AuditudeEnv;->instance:Lcom/auditude/ads/core/AuditudeEnv;

    .line 35
    return-void
.end method


# virtual methods
.method public final getAPI()Lcom/auditude/ads/core/APIBridge;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/auditude/ads/core/AuditudeEnv;->apiBridge:Lcom/auditude/ads/core/APIBridge;

    return-object v0
.end method

.method public final getAdSettings()Lcom/auditude/ads/core/AdSettings;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/auditude/ads/core/AuditudeEnv;->adSettings:Lcom/auditude/ads/core/AdSettings;

    return-object v0
.end method

.method public final getReportingHelper()Lcom/auditude/ads/reporting/ReportingHelper;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/auditude/ads/core/AuditudeEnv;->reporting:Lcom/auditude/ads/reporting/ReportingHelper;

    return-object v0
.end method

.method public final init(Lcom/auditude/ads/core/APIBridge;Lcom/auditude/ads/reporting/ReportingHelper;Lcom/auditude/ads/core/AdSettings;)V
    .locals 2
    .param p1, "api"    # Lcom/auditude/ads/core/APIBridge;
    .param p2, "reporting"    # Lcom/auditude/ads/reporting/ReportingHelper;
    .param p3, "adSettings"    # Lcom/auditude/ads/core/AdSettings;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/auditude/ads/core/AuditudeEnv;->apiBridge:Lcom/auditude/ads/core/APIBridge;

    .line 46
    iput-object p2, p0, Lcom/auditude/ads/core/AuditudeEnv;->reporting:Lcom/auditude/ads/reporting/ReportingHelper;

    .line 47
    iput-object p3, p0, Lcom/auditude/ads/core/AuditudeEnv;->adSettings:Lcom/auditude/ads/core/AdSettings;

    .line 50
    invoke-direct {p0}, Lcom/auditude/ads/core/AuditudeEnv;->initLoggers()V

    .line 53
    invoke-static {}, Lcom/auditude/ads/util/log/Log;->getLogger()Lcom/auditude/ads/util/log/ILogger;

    move-result-object v0

    const-string v1, "Auditude Library Version: 57988"

    invoke-interface {v0, v1}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    .line 54
    return-void
.end method
