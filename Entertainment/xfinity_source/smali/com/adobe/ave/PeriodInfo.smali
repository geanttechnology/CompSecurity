.class public Lcom/adobe/ave/PeriodInfo;
.super Ljava/lang/Object;
.source "PeriodInfo.java"


# instance fields
.field public duration:J

.field public firstCuePointIndex:I

.field public firstSubscribedTagIndex:I

.field public lastCuePointIndex:I

.field public lastSubscribedTagIndex:I

.field public localStartTime:J

.field public supportsTrickPlay:Z

.field public targetDuration:J

.field public userData:I

.field public virtualStartTime:J


# direct methods
.method private constructor <init>(IJJJIIIIZJ)V
    .locals 0
    .param p1, "aUserData"    # I
    .param p2, "aLocalStartTime"    # J
    .param p4, "aVirtualStartTime"    # J
    .param p6, "aDuration"    # J
    .param p8, "aFirstCuePointIndex"    # I
    .param p9, "aLastCuePointIndex"    # I
    .param p10, "aFirstSubscribedTagIndex"    # I
    .param p11, "aLastSubscribedTagIndex"    # I
    .param p12, "aSupportsTrickPlay"    # Z
    .param p13, "aTargetDuration"    # J

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput p1, p0, Lcom/adobe/ave/PeriodInfo;->userData:I

    .line 30
    iput-wide p2, p0, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    .line 31
    iput-wide p4, p0, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    .line 32
    iput-wide p6, p0, Lcom/adobe/ave/PeriodInfo;->duration:J

    .line 33
    iput p8, p0, Lcom/adobe/ave/PeriodInfo;->firstCuePointIndex:I

    .line 34
    iput p9, p0, Lcom/adobe/ave/PeriodInfo;->lastCuePointIndex:I

    .line 35
    iput-boolean p12, p0, Lcom/adobe/ave/PeriodInfo;->supportsTrickPlay:Z

    .line 36
    iput p10, p0, Lcom/adobe/ave/PeriodInfo;->firstSubscribedTagIndex:I

    .line 37
    iput p11, p0, Lcom/adobe/ave/PeriodInfo;->lastSubscribedTagIndex:I

    .line 38
    iput-wide p13, p0, Lcom/adobe/ave/PeriodInfo;->targetDuration:J

    .line 39
    return-void
.end method
