.class Lcom/adobe/mediacore/AdBreakPlaybackEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private final _adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput-object p2, p0, Lcom/adobe/mediacore/AdBreakPlaybackEvent;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    return-void
.end method

.method public static createCompleteEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/AdBreakPlaybackEvent;
    .locals 5

    new-instance v0, Lcom/adobe/mediacore/AdBreakPlaybackEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, v1, p0}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "Ad-break has completed."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "AD_BREAK"

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method

.method public static createSkippedEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/AdBreakPlaybackEvent;
    .locals 5

    new-instance v0, Lcom/adobe/mediacore/AdBreakPlaybackEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_SKIPPED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, v1, p0}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_SKIPPED:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "Ad-break has been skipped."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "AD_BREAK"

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method

.method public static createStartEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/AdBreakPlaybackEvent;
    .locals 5

    new-instance v0, Lcom/adobe/mediacore/AdBreakPlaybackEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, v1, p0}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "Ad-break has started."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "AD_BREAK"

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method


# virtual methods
.method public getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdBreakPlaybackEvent;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    return-object v0
.end method
