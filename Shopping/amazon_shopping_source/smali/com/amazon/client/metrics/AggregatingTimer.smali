.class public Lcom/amazon/client/metrics/AggregatingTimer;
.super Ljava/lang/Object;
.source "AggregatingTimer.java"


# static fields
.field private static final TIMEUNIT:Ljava/util/concurrent/TimeUnit;


# instance fields
.field private final mAllowRunningTimers:Z

.field private mLastUpdatedTime:J

.field private mRunningCount:I

.field private mTotalElapsedTime:D

.field private mTotalSamplesCount:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 41
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    sput-object v0, Lcom/amazon/client/metrics/AggregatingTimer;->TIMEUNIT:Ljava/util/concurrent/TimeUnit;

    return-void
.end method

.method public constructor <init>(Z)V
    .locals 2
    .param p1, "allowRunningTimers"    # Z

    .prologue
    const/4 v0, 0x0

    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    iput v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    .line 44
    iput v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalSamplesCount:I

    .line 46
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mLastUpdatedTime:J

    .line 47
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalElapsedTime:D

    .line 59
    iput-boolean p1, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mAllowRunningTimers:Z

    .line 60
    return-void
.end method


# virtual methods
.method public addTime(DI)V
    .locals 2
    .param p1, "elapsedTimeMillis"    # D
    .param p3, "samples"    # I

    .prologue
    .line 100
    invoke-static {p1, p2}, Lcom/amazon/client/metrics/DoubleValidator;->validateDouble(D)V

    .line 101
    iget-wide v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalElapsedTime:D

    add-double/2addr v0, p1

    iput-wide v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalElapsedTime:D

    .line 102
    iget v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalSamplesCount:I

    add-int/2addr v0, p3

    iput v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalSamplesCount:I

    .line 103
    return-void
.end method

.method public getElapsedTime()D
    .locals 3

    .prologue
    .line 120
    iget-boolean v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mAllowRunningTimers:Z

    if-nez v0, :cond_0

    iget v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    if-lez v0, :cond_0

    .line 121
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Cannot get elapsed time - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " start calls not matched with stop."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 125
    :cond_0
    iget-wide v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalElapsedTime:D

    return-wide v0
.end method

.method public getSamples()I
    .locals 1

    .prologue
    .line 133
    iget v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalSamplesCount:I

    return v0
.end method

.method public getTimeUnit()Ljava/util/concurrent/TimeUnit;
    .locals 1

    .prologue
    .line 110
    sget-object v0, Lcom/amazon/client/metrics/AggregatingTimer;->TIMEUNIT:Ljava/util/concurrent/TimeUnit;

    return-object v0
.end method

.method public numRunningTimers()I
    .locals 1

    .prologue
    .line 141
    iget v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    return v0
.end method

.method public startTimer()V
    .locals 8

    .prologue
    .line 68
    invoke-static {}, Lcom/dp/utils/SystemTime;->now()J

    move-result-wide v0

    .line 70
    .local v0, "now":J
    iget v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    if-lez v2, :cond_0

    .line 71
    iget-wide v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalElapsedTime:D

    iget v4, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    int-to-long v4, v4

    iget-wide v6, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mLastUpdatedTime:J

    sub-long v6, v0, v6

    mul-long/2addr v4, v6

    long-to-double v4, v4

    add-double/2addr v2, v4

    iput-wide v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalElapsedTime:D

    .line 74
    :cond_0
    iput-wide v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mLastUpdatedTime:J

    .line 75
    iget v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    .line 76
    return-void
.end method

.method public stopTimer()V
    .locals 8

    .prologue
    .line 83
    invoke-static {}, Lcom/dp/utils/SystemTime;->now()J

    move-result-wide v0

    .line 84
    .local v0, "now":J
    iget v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    if-lez v2, :cond_0

    .line 85
    iget-wide v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalElapsedTime:D

    iget v4, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    int-to-long v4, v4

    iget-wide v6, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mLastUpdatedTime:J

    sub-long v6, v0, v6

    mul-long/2addr v4, v6

    long-to-double v4, v4

    add-double/2addr v2, v4

    iput-wide v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalElapsedTime:D

    .line 86
    iget v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mRunningCount:I

    .line 87
    iput-wide v0, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mLastUpdatedTime:J

    .line 90
    iget v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalSamplesCount:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/amazon/client/metrics/AggregatingTimer;->mTotalSamplesCount:I

    .line 92
    :cond_0
    return-void
.end method
