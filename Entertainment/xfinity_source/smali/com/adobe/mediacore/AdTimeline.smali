.class final Lcom/adobe/mediacore/AdTimeline;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/timeline/Timeline;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/AdTimeline$AdInformation;,
        Lcom/adobe/mediacore/AdTimeline$Info;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/adobe/mediacore/timeline/Timeline",
        "<",
        "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private _logger:Lcom/adobe/mediacore/logging/Logger;

.field private final _videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/AdTimeline;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/AdTimeline;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineTimeline;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/AdTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/AdTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Video engine timeline parameter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p1, p0, Lcom/adobe/mediacore/AdTimeline;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    return-void
.end method


# virtual methods
.method public getAdjustedPosition(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;JLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/AdTimeline;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/adobe/mediacore/VideoEngineTimeline;->adjustSeekPosition(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;JLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    return-object v0
.end method

.method public getInfoForContentId(J)Lcom/adobe/mediacore/AdTimeline$Info;
    .locals 7

    iget-object v0, p0, Lcom/adobe/mediacore/AdTimeline;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdBreakPlacements()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/adobe/mediacore/timeline/advertising/Ad;

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v4

    int-to-long v4, v4

    cmp-long v4, p1, v4

    if-nez v4, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-static {v0, v1}, Lcom/adobe/mediacore/AdTimeline$Info;->createInfo(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/adobe/mediacore/AdTimeline$Info;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public timelineMarkers()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/AdTimeline;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdBreakPlacements()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public update(J)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdTimeline;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimeline;->updateTimelineMarkers(J)V

    return-void
.end method
