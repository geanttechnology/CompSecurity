.class public Lcom/adobe/mediacore/metadata/AuditudeSettings;
.super Lcom/adobe/mediacore/metadata/AdvertisingMetadata;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private final CREATIVE_REPACKAGING_ENABLED:Ljava/lang/String;

.field private final CUSTOM_PARAMETERS_KEY:Ljava/lang/String;

.field private final CUSTOM_USER_AGENT:Ljava/lang/String;

.field private final DEFAULT_MEDIA_ID_KEY:Ljava/lang/String;

.field private final DOMAIN_KEY:Ljava/lang/String;

.field private final FALLBACK_ON_INVALID_CREATIVE:Ljava/lang/String;

.field private final MEDIA_ID_KEY:Ljava/lang/String;

.field private final TARGETING_KEY:Ljava/lang/String;

.field private final VALID_MIME_TYPES:Ljava/lang/String;

.field private final ZONE_ID_KEY:Ljava/lang/String;

.field private data:Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;-><init>()V

    const-string v0, "zoneid"

    iput-object v0, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->ZONE_ID_KEY:Ljava/lang/String;

    const-string v0, "mediaid"

    iput-object v0, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->MEDIA_ID_KEY:Ljava/lang/String;

    const-string v0, "domain"

    iput-object v0, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->DOMAIN_KEY:Ljava/lang/String;

    const-string v0, "targeting"

    iput-object v0, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->TARGETING_KEY:Ljava/lang/String;

    const-string v0, "custom_parameters"

    iput-object v0, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->CUSTOM_PARAMETERS_KEY:Ljava/lang/String;

    const-string v0, "creative_repackaging_enabled"

    iput-object v0, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->CREATIVE_REPACKAGING_ENABLED:Ljava/lang/String;

    const-string v0, "default_mediaid"

    iput-object v0, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->DEFAULT_MEDIA_ID_KEY:Ljava/lang/String;

    const-string v0, "custom_user_agent"

    iput-object v0, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->CUSTOM_USER_AGENT:Ljava/lang/String;

    const-string v0, "validMimeTypes"

    iput-object v0, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->VALID_MIME_TYPES:Ljava/lang/String;

    const-string v0, "fallbackOnInvalidCreative"

    iput-object v0, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->FALLBACK_ON_INVALID_CREATIVE:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getCustomParameters()Lcom/adobe/mediacore/metadata/Metadata;
    .locals 1

    const-string v0, "custom_parameters"

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    return-object v0
.end method

.method public getData()Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->data:Ljava/lang/Object;

    return-object v0
.end method

.method public getDefaultMediaId()Ljava/lang/String;
    .locals 1

    const-string v0, "default_mediaid"

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDomain()Ljava/lang/String;
    .locals 1

    const-string v0, "domain"

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMediaId()Ljava/lang/String;
    .locals 1

    const-string v0, "mediaid"

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTargetingParameters()Lcom/adobe/mediacore/metadata/Metadata;
    .locals 1

    const-string v0, "targeting"

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    return-object v0
.end method

.method public getUserAgent()Ljava/lang/String;
    .locals 1

    const-string v0, "custom_user_agent"

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getValidMimeTypes()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const-string v0, "validMimeTypes"

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getObject(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    return-object v0
.end method

.method public getZoneId()Ljava/lang/String;
    .locals 1

    const-string v0, "zoneid"

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isCreativeRepackagingEnabled()Z
    .locals 1

    const-string v0, "creative_repackaging_enabled"

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public isFallbackOnInvalidCreativeEnabled()Z
    .locals 1

    const-string v0, "fallbackOnInvalidCreative"

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public setCreativeRepackagingEnabled(Z)V
    .locals 2

    const-string v0, "creative_repackaging_enabled"

    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public setCustomParameters(Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 1

    const-string v0, "custom_parameters"

    invoke-virtual {p0, v0, p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    return-void
.end method

.method public setData(Ljava/lang/Object;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/metadata/AuditudeSettings;->data:Ljava/lang/Object;

    return-void
.end method

.method public setDefaultMediaId(Ljava/lang/String;)V
    .locals 2

    const-string v0, "default_mediaid"

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public setDomain(Ljava/lang/String;)V
    .locals 1

    const-string v0, "domain"

    invoke-virtual {p0, v0, p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public setFallbackOnInvalidCreativeEnabled(Z)V
    .locals 2

    const-string v0, "fallbackOnInvalidCreative"

    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public setMediaId(Ljava/lang/String;)V
    .locals 1

    const-string v0, "mediaid"

    invoke-virtual {p0, v0, p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public setTargetingParameters(Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 1

    const-string v0, "targeting"

    invoke-virtual {p0, v0, p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    return-void
.end method

.method public setUserAgent(Ljava/lang/String;)V
    .locals 2

    const-string v0, "custom_user_agent"

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public setValidMimeTypes(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const-string v0, "validMimeTypes"

    invoke-virtual {p0, v0, p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setObject(Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method public setZoneId(Ljava/lang/String;)V
    .locals 1

    const-string v0, "zoneid"

    invoke-virtual {p0, v0, p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
