.class Lcom/adobe/mediacore/AdPlaybackEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private final _ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

.field private final _adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

.field private final _progress:I


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;I)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput-object p2, p0, Lcom/adobe/mediacore/AdPlaybackEvent;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    iput-object p3, p0, Lcom/adobe/mediacore/AdPlaybackEvent;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    iput p4, p0, Lcom/adobe/mediacore/AdPlaybackEvent;->_progress:I

    return-void
.end method

.method public static createCompleteEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/adobe/mediacore/AdPlaybackEvent;
    .locals 5

    new-instance v0, Lcom/adobe/mediacore/AdPlaybackEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const/16 v2, 0x64

    invoke-direct {v0, v1, p0, p1, v2}, Lcom/adobe/mediacore/AdPlaybackEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;I)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "Ad has completed."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "AD_BREAK"

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "AD"

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdPlaybackEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method

.method public static createProgressEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;I)Lcom/adobe/mediacore/AdPlaybackEvent;
    .locals 6

    new-instance v0, Lcom/adobe/mediacore/AdPlaybackEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_PROGRESS:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, v1, p0, p1, p2}, Lcom/adobe/mediacore/AdPlaybackEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;I)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_PROGRESS:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "Ad playback progress."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "AD_BREAK"

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "AD"

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "PROGRESS"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdPlaybackEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method

.method public static createStartEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/adobe/mediacore/AdPlaybackEvent;
    .locals 5

    new-instance v0, Lcom/adobe/mediacore/AdPlaybackEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p0, p1, v2}, Lcom/adobe/mediacore/AdPlaybackEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;I)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "Ad has started."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "AD_BREAK"

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "AD"

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdPlaybackEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method


# virtual methods
.method public getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPlaybackEvent;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    return-object v0
.end method

.method public getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPlaybackEvent;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    return-object v0
.end method

.method public getProgress()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/AdPlaybackEvent;->_progress:I

    return v0
.end method
