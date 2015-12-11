.class public Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;
.super Ljava/lang/Object;


# instance fields
.field private _secondsPlayed:J

.field private _secondsSpent:J


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSecondsPlayed()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;->_secondsPlayed:J

    return-wide v0
.end method

.method public getSecondsSpent()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;->_secondsSpent:J

    return-wide v0
.end method
