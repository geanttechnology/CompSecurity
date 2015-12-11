.class public Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/timeline/advertising/ContentTracker;


# instance fields
.field private final LOG_TAG:Ljava/lang/String;

.field private _logger:Lcom/adobe/mediacore/logging/Logger;

.field private final auditudeAdReporter:Lcom/auditude/ads/reporting/ReportingHelper;

.field private currentSequence:Lcom/auditude/ads/model/smil/Sequence;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/reporting/ReportingHelper;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::[AuditudeAd]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->LOG_TAG:Ljava/lang/String;

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->_logger:Lcom/adobe/mediacore/logging/Logger;

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->auditudeAdReporter:Lcom/auditude/ads/reporting/ReportingHelper;

    return-void
.end method

.method private retrieveReference(Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/auditude/ads/model/smil/Ref;
    .locals 2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    instance-of v1, v0, Lcom/adobe/mediacore/metadata/AuditudeSettings;

    if-eqz v1, :cond_0

    check-cast v0, Lcom/adobe/mediacore/metadata/AuditudeSettings;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getData()Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Lcom/auditude/ads/model/smil/Ref;

    if-eqz v1, :cond_0

    check-cast v0, Lcom/auditude/ads/model/smil/Ref;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public onAdBreakComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->currentSequence:Lcom/auditude/ads/model/smil/Sequence;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->auditudeAdReporter:Lcom/auditude/ads/reporting/ReportingHelper;

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->currentSequence:Lcom/auditude/ads/model/smil/Sequence;

    invoke-virtual {v0, v1}, Lcom/auditude/ads/reporting/ReportingHelper;->onSequenceEnd(Lcom/auditude/ads/model/smil/Sequence;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->currentSequence:Lcom/auditude/ads/model/smil/Sequence;

    :cond_0
    return-void
.end method

.method public onAdBreakStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->currentSequence:Lcom/auditude/ads/model/smil/Sequence;

    return-void
.end method

.method public onAdClick(Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 4

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->retrieveReference(Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/auditude/ads/model/smil/Ref;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#onAdClick()"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Reporting AD-CLICK."

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->auditudeAdReporter:Lcom/auditude/ads/reporting/ReportingHelper;

    invoke-virtual {v1, v0}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdClick(Lcom/auditude/ads/model/smil/Ref;)V

    :cond_0
    return-void
.end method

.method public onAdComplete(Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 4

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->retrieveReference(Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/auditude/ads/model/smil/Ref;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#onAdComplete()"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Reporting AD-COMPLETE."

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->auditudeAdReporter:Lcom/auditude/ads/reporting/ReportingHelper;

    invoke-virtual {v1, v0}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdComplete(Lcom/auditude/ads/model/smil/Ref;)V

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/model/Asset;->Reset()V

    :cond_0
    return-void
.end method

.method public onAdError(Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 4

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->retrieveReference(Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/auditude/ads/model/smil/Ref;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#onAdError()"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Reporting AD-ERROR."

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->auditudeAdReporter:Lcom/auditude/ads/reporting/ReportingHelper;

    invoke-virtual {v1, v0}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdError(Lcom/auditude/ads/model/smil/Ref;)V

    :cond_0
    return-void
.end method

.method public onAdProgress(Lcom/adobe/mediacore/timeline/advertising/Ad;I)V
    .locals 5

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->retrieveReference(Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/auditude/ads/model/smil/Ref;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#onAdProgress()"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Reporting AD-PROGRESS: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "%"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->auditudeAdReporter:Lcom/auditude/ads/reporting/ReportingHelper;

    const/16 v2, 0x64

    invoke-virtual {v1, v0, v2, p2}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdProgress(Lcom/auditude/ads/model/smil/Ref;II)V

    :cond_0
    return-void
.end method

.method public onAdStart(Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 4

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->retrieveReference(Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/auditude/ads/model/smil/Ref;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v1

    invoke-virtual {v1}, Lcom/auditude/ads/model/smil/Par;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v1

    invoke-virtual {v1}, Lcom/auditude/ads/model/smil/Par;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->currentSequence:Lcom/auditude/ads/model/smil/Sequence;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->currentSequence:Lcom/auditude/ads/model/smil/Sequence;

    if-eq v1, v2, :cond_0

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->auditudeAdReporter:Lcom/auditude/ads/reporting/ReportingHelper;

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->currentSequence:Lcom/auditude/ads/model/smil/Sequence;

    invoke-virtual {v2, v3}, Lcom/auditude/ads/reporting/ReportingHelper;->onSequenceEnd(Lcom/auditude/ads/model/smil/Sequence;)V

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->auditudeAdReporter:Lcom/auditude/ads/reporting/ReportingHelper;

    invoke-virtual {v2, v1}, Lcom/auditude/ads/reporting/ReportingHelper;->onSequenceBegin(Lcom/auditude/ads/model/smil/Sequence;)V

    :cond_0
    :goto_0
    iput-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->currentSequence:Lcom/auditude/ads/model/smil/Sequence;

    :cond_1
    if-eqz v0, :cond_2

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#onAdStart()"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Reporting AD-START."

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->auditudeAdReporter:Lcom/auditude/ads/reporting/ReportingHelper;

    invoke-virtual {v1, v0}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdStart(Lcom/auditude/ads/model/smil/Ref;)V

    :cond_2
    return-void

    :cond_3
    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;->auditudeAdReporter:Lcom/auditude/ads/reporting/ReportingHelper;

    invoke-virtual {v2, v1}, Lcom/auditude/ads/reporting/ReportingHelper;->onSequenceBegin(Lcom/auditude/ads/model/smil/Sequence;)V

    goto :goto_0
.end method
