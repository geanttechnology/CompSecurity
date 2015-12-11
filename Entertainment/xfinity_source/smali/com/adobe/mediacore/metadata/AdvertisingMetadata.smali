.class public Lcom/adobe/mediacore/metadata/AdvertisingMetadata;
.super Lcom/adobe/mediacore/metadata/MetadataNode;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    return-void
.end method


# virtual methods
.method public final getAdBreakAsWatched()Lcom/adobe/mediacore/metadata/AdBreakAsWatched;
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AD_BREAK_AS_WATCHED_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_ON_BEGIN:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    :goto_0
    return-object v0

    :cond_0
    invoke-static {v0}, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->createFrom(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    move-result-object v0

    goto :goto_0
.end method

.method public final getEnableLivePreroll()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ENABLE_LIVE_PRE_ROLL:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AD_SIGNALING_MODE_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    :goto_0
    return-object v0

    :cond_0
    invoke-static {v0}, Lcom/adobe/mediacore/metadata/AdSignalingMode;->createFrom(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/AdSignalingMode;

    move-result-object v0

    goto :goto_0
.end method

.method public final setAdBreakAsWatched(Lcom/adobe/mediacore/metadata/AdBreakAsWatched;)V
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AD_BREAK_AS_WATCHED_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final setEnableLivePreroll(Ljava/lang/String;)V
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ENABLE_LIVE_PRE_ROLL:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final setSignalingMode(Lcom/adobe/mediacore/metadata/AdSignalingMode;)V
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AD_SIGNALING_MODE_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/AdSignalingMode;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final setTimeRanges(Lcom/adobe/mediacore/utils/TimeRangeCollection;Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, p2}, Lcom/adobe/mediacore/utils/TimeRangeCollection;->toMetadata(Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    return-void
.end method
