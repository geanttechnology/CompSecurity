.class public Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;
.super Ljava/lang/Object;
.source "DRMPlaybackTimeWindow.java"


# instance fields
.field private endDate:Ljava/util/Date;

.field private periodInSeconds:J

.field private startDate:Ljava/util/Date;


# direct methods
.method protected constructor <init>(JLjava/util/Date;Ljava/util/Date;)V
    .locals 1
    .param p1, "periodInSeconds"    # J
    .param p3, "startDate"    # Ljava/util/Date;
    .param p4, "endDate"    # Ljava/util/Date;

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-wide p1, p0, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->periodInSeconds:J

    .line 35
    iput-object p3, p0, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->startDate:Ljava/util/Date;

    .line 36
    iput-object p4, p0, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->endDate:Ljava/util/Date;

    .line 37
    return-void
.end method


# virtual methods
.method public getPlaybackEndDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->endDate:Ljava/util/Date;

    return-object v0
.end method

.method public getPlaybackPeriodInSeconds()J
    .locals 2

    .prologue
    .line 41
    iget-wide v0, p0, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->periodInSeconds:J

    return-wide v0
.end method

.method public getPlaybackStartDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->startDate:Ljava/util/Date;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    .prologue
    .line 56
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 57
    .local v0, "sb":Ljava/lang/StringBuffer;
    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->getPlaybackPeriodInSeconds()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-lez v1, :cond_0

    .line 58
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "period in seconds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->getPlaybackPeriodInSeconds()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 59
    :cond_0
    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->getPlaybackStartDate()Ljava/util/Date;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 60
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "start date "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->getPlaybackStartDate()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 61
    :cond_1
    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->getPlaybackEndDate()Ljava/util/Date;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 62
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "end date "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMPlaybackTimeWindow;->getPlaybackEndDate()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 63
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
