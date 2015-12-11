.class public Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;
.super Ljava/lang/Object;
.source "AnalyticsServiceConfiguration.java"


# instance fields
.field private final delayAfterError:J

.field private final maxTaskFailures:I


# direct methods
.method public constructor <init>(IJ)V
    .locals 0
    .param p1, "maxTaskFailures"    # I
    .param p2, "delayAfterError"    # J

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;->maxTaskFailures:I

    .line 18
    iput-wide p2, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;->delayAfterError:J

    .line 19
    return-void
.end method

.method public static getDefaultAnalyticsServiceConfiguration()Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;
    .locals 4

    .prologue
    .line 13
    new-instance v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;

    const/4 v1, 0x2

    const-wide/32 v2, 0x1d4c0

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;-><init>(IJ)V

    return-object v0
.end method


# virtual methods
.method public getDelayAfterError()J
    .locals 2

    .prologue
    .line 26
    iget-wide v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;->delayAfterError:J

    return-wide v0
.end method

.method public getMaxTaskFailures()I
    .locals 1

    .prologue
    .line 22
    iget v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsServiceConfiguration;->maxTaskFailures:I

    return v0
.end method
