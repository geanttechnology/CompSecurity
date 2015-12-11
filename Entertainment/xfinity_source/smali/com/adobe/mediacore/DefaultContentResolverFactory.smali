.class Lcom/adobe/mediacore/DefaultContentResolverFactory;
.super Ljava/lang/Object;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createContentResolver(Lcom/adobe/mediacore/MediaResource;Landroid/content/Context;)Lcom/adobe/mediacore/timeline/advertising/ContentResolver;
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v0, :cond_2

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    invoke-direct {v0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;-><init>(Landroid/content/Context;)V

    :goto_0
    return-object v0

    :cond_0
    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->JSON_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;

    invoke-direct {v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;-><init>()V

    goto :goto_0

    :cond_1
    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;

    invoke-direct {v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;-><init>()V

    goto :goto_0

    :cond_2
    move-object v0, v1

    goto :goto_0
.end method

.method public static createContentResolvers(Lcom/adobe/mediacore/MediaResource;Landroid/content/Context;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/MediaResource;",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/ContentResolver;",
            ">;"
        }
    .end annotation

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v0, :cond_2

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;

    invoke-direct {v2}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;-><init>()V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "delete"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;

    invoke-direct {v2}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;-><init>()V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_1
    :goto_0
    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    invoke-direct {v0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;-><init>(Landroid/content/Context;)V

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_2
    :goto_1
    return-object v1

    :cond_3
    const-string v3, "replace"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;

    invoke-direct {v2}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;-><init>()V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_4
    const-string v3, "mark"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;

    invoke-direct {v2}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;-><init>()V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_5
    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->JSON_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;

    invoke-direct {v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;-><init>()V

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1
.end method
