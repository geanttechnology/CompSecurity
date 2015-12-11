.class final Lcom/adobe/mediacore/VideoEngineTimeline$Period;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/VideoEngineTimeline;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "Period"
.end annotation


# instance fields
.field private final periodIndex:I

.field private final periodInfo:Lcom/adobe/ave/PeriodInfo;

.field final synthetic this$0:Lcom/adobe/mediacore/VideoEngineTimeline;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineTimeline;ILcom/adobe/ave/PeriodInfo;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p2, p0, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->periodIndex:I

    iput-object p3, p0, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->periodInfo:Lcom/adobe/ave/PeriodInfo;

    return-void
.end method


# virtual methods
.method public getDuration()J
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->periodInfo:Lcom/adobe/ave/PeriodInfo;

    iget-wide v0, v0, Lcom/adobe/ave/PeriodInfo;->duration:J

    return-wide v0
.end method

.method public getLocalEndTime()J
    .locals 4

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getLocalStartTime()J

    move-result-wide v0

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getDuration()J

    move-result-wide v2

    add-long/2addr v0, v2

    return-wide v0
.end method

.method public getLocalStartTime()J
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->periodInfo:Lcom/adobe/ave/PeriodInfo;

    iget-wide v0, v0, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    return-wide v0
.end method

.method public getPeriodIndex()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->periodIndex:I

    return v0
.end method

.method public getVirtualTime()J
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->periodInfo:Lcom/adobe/ave/PeriodInfo;

    iget-wide v0, v0, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    return-wide v0
.end method
