.class Lcom/adobe/mediacore/AdManifestLoadEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# static fields
.field private static final INVALID_DURATION:I = 0x0

.field private static final INVALID_HANDLE:I = -0x1


# instance fields
.field private final _contentId:I

.field private final _duration:J

.field private final _handle:I


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;IIJ)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput p2, p0, Lcom/adobe/mediacore/AdManifestLoadEvent;->_contentId:I

    iput p3, p0, Lcom/adobe/mediacore/AdManifestLoadEvent;->_handle:I

    iput-wide p4, p0, Lcom/adobe/mediacore/AdManifestLoadEvent;->_duration:J

    return-void
.end method

.method public static createAdManifestLoadCompletedEvent(IIJ)Lcom/adobe/mediacore/AdManifestLoadEvent;
    .locals 6

    new-instance v0, Lcom/adobe/mediacore/AdManifestLoadEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    move v2, p0

    move v3, p1

    move-wide v4, p2

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/AdManifestLoadEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;IIJ)V

    return-object v0
.end method

.method public static createAdManifestLoadFailedEvent(I)Lcom/adobe/mediacore/AdManifestLoadEvent;
    .locals 6

    new-instance v0, Lcom/adobe/mediacore/AdManifestLoadEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_MANIFEST_LOAD_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const/4 v3, -0x1

    const-wide/16 v4, 0x0

    move v2, p0

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/AdManifestLoadEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;IIJ)V

    return-object v0
.end method


# virtual methods
.method public getContentId()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/AdManifestLoadEvent;->_contentId:I

    return v0
.end method

.method public getDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/AdManifestLoadEvent;->_duration:J

    return-wide v0
.end method

.method public getHandle()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/AdManifestLoadEvent;->_handle:I

    return v0
.end method
