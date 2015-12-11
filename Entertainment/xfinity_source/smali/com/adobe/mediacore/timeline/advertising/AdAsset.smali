.class public final Lcom/adobe/mediacore/timeline/advertising/AdAsset;
.super Ljava/lang/Object;


# instance fields
.field private final _adClick:Lcom/adobe/mediacore/timeline/advertising/AdClick;

.field private final _duration:J

.field private final _id:I

.field private final _mediaResource:Lcom/adobe/mediacore/MediaResource;

.field private final _metadata:Lcom/adobe/mediacore/metadata/Metadata;


# direct methods
.method public constructor <init>(IJLcom/adobe/mediacore/MediaResource;Lcom/adobe/mediacore/timeline/advertising/AdClick;Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_id:I

    iput-wide p2, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_duration:J

    iput-object p4, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    iput-object p5, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_adClick:Lcom/adobe/mediacore/timeline/advertising/AdClick;

    iput-object p6, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    return-void
.end method

.method public static newInstance(Lcom/adobe/mediacore/timeline/advertising/AdAsset;)Lcom/adobe/mediacore/timeline/advertising/AdAsset;
    .locals 7

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    iget v1, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_id:I

    iget-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_duration:J

    iget-object v4, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getAdClick()Lcom/adobe/mediacore/timeline/advertising/AdClick;

    move-result-object v5

    invoke-static {v5}, Lcom/adobe/mediacore/timeline/advertising/AdClick;->newInstance(Lcom/adobe/mediacore/timeline/advertising/AdClick;)Lcom/adobe/mediacore/timeline/advertising/AdClick;

    move-result-object v5

    iget-object v6, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    invoke-direct/range {v0 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;-><init>(IJLcom/adobe/mediacore/MediaResource;Lcom/adobe/mediacore/timeline/advertising/AdClick;Lcom/adobe/mediacore/metadata/Metadata;)V

    return-object v0
.end method


# virtual methods
.method public getAdClick()Lcom/adobe/mediacore/timeline/advertising/AdClick;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_adClick:Lcom/adobe/mediacore/timeline/advertising/AdClick;

    return-object v0
.end method

.method public getDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_duration:J

    return-wide v0
.end method

.method public getId()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_id:I

    return v0
.end method

.method public getMediaResource()Lcom/adobe/mediacore/MediaResource;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    return-object v0
.end method

.method public getMetadata()Lcom/adobe/mediacore/metadata/Metadata;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    return-object v0
.end method
