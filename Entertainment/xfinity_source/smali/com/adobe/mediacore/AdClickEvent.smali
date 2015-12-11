.class Lcom/adobe/mediacore/AdClickEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private final _ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

.field private final _adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

.field private final _adClick:Lcom/adobe/mediacore/timeline/advertising/AdClick;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/Ad;Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/AdClick;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput-object p2, p0, Lcom/adobe/mediacore/AdClickEvent;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    iput-object p3, p0, Lcom/adobe/mediacore/AdClickEvent;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    iput-object p4, p0, Lcom/adobe/mediacore/AdClickEvent;->_adClick:Lcom/adobe/mediacore/timeline/advertising/AdClick;

    return-void
.end method

.method public static createAdClickEvent()Lcom/adobe/mediacore/AdClickEvent;
    .locals 3

    const/4 v2, 0x0

    new-instance v0, Lcom/adobe/mediacore/AdClickEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIEW_CLICKED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, v1, v2, v2, v2}, Lcom/adobe/mediacore/AdClickEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/Ad;Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/AdClick;)V

    return-object v0
.end method

.method public static createAdClickEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;Lcom/adobe/mediacore/timeline/advertising/AdClick;)Lcom/adobe/mediacore/AdClickEvent;
    .locals 5

    new-instance v0, Lcom/adobe/mediacore/AdClickEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_CLICK:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, v1, p1, p0, p2}, Lcom/adobe/mediacore/AdClickEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/timeline/advertising/Ad;Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/AdClick;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_CLICK:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "Ad click event detected."

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

    const-string v3, "AD_CLICK"

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/AdClick;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdClickEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method


# virtual methods
.method public getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdClickEvent;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    return-object v0
.end method

.method public getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdClickEvent;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    return-object v0
.end method

.method public getAdClick()Lcom/adobe/mediacore/timeline/advertising/AdClick;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdClickEvent;->_adClick:Lcom/adobe/mediacore/timeline/advertising/AdClick;

    return-object v0
.end method
