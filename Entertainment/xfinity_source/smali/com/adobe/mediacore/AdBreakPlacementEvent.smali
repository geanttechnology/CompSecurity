.class Lcom/adobe/mediacore/AdBreakPlacementEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private final _acceptedAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

.field private final _proposedAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput-object p2, p0, Lcom/adobe/mediacore/AdBreakPlacementEvent;->_proposedAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    iput-object p3, p0, Lcom/adobe/mediacore/AdBreakPlacementEvent;->_acceptedAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    return-void
.end method

.method public static createPlacementCompletedEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Lcom/adobe/mediacore/AdBreakPlacementEvent;
    .locals 5

    new-instance v0, Lcom/adobe/mediacore/AdBreakPlacementEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, v1, p0, p1}, Lcom/adobe/mediacore/AdBreakPlacementEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_PLACEMENT_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "Ad-break placement operation is complete."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "PROPOSED_AD_BREAK"

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "ACCEPTED_AD_BREAK"

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdBreakPlacementEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method

.method public static createPlacementFailedEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Lcom/adobe/mediacore/AdBreakPlacementEvent;
    .locals 5

    new-instance v0, Lcom/adobe/mediacore/AdBreakPlacementEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p0, v2}, Lcom/adobe/mediacore/AdBreakPlacementEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AD_INSERTION_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v3, "Ad-break placement operation has failed."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "PROPOSED_AD_BREAK"

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdBreakPlacementEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method


# virtual methods
.method public getAcceptedAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdBreakPlacementEvent;->_acceptedAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    return-object v0
.end method

.method public getProposedAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdBreakPlacementEvent;->_proposedAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    return-object v0
.end method
