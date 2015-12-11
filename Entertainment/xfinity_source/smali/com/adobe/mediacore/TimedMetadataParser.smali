.class final Lcom/adobe/mediacore/TimedMetadataParser;
.super Ljava/lang/Object;


# static fields
.field private static final AD_CUE_DURATION_KEY:Ljava/lang/String; = "DURATION"

.field private static final AD_CUE_ID_KEY:Ljava/lang/String; = "ID"

.field private static final CUE_DATA:Ljava/lang/String; = "DATA"


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getMetadataId(Lcom/adobe/mediacore/metadata/Metadata;Ljava/lang/String;J)J
    .locals 2

    if-eqz p0, :cond_0

    const-string v0, "ID"

    invoke-interface {p0, v0}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    :try_start_0
    const-string v0, "ID"

    invoke-interface {p0, v0}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v0

    :goto_0
    return-wide v0

    :catch_0
    move-exception v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    int-to-long v0, v0

    goto :goto_0
.end method

.method private static parseMetadata(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/Metadata;
    .locals 6

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    invoke-static {p0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    const/16 v0, 0x2c

    invoke-static {v0, p0}, Lcom/adobe/mediacore/TimedMetadataParser;->splitIgnoringQuotes(CLjava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const/16 v3, 0x3d

    invoke-static {v3, v0}, Lcom/adobe/mediacore/TimedMetadataParser;->splitIgnoringQuotes(CLjava/lang/String;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    const/4 v5, 0x2

    if-eq v4, v5, :cond_3

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->trimQuotes(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/utils/NumberUtils;->isNumeric(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    const-string v3, "DURATION"

    invoke-virtual {v1, v3, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    const-string v3, "DATA"

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v3, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_3
    const/4 v0, 0x0

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->trimQuotes(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    const/4 v0, 0x1

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->trimQuotes(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    invoke-virtual {v1, v4, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_4
    move-object v0, v1

    goto :goto_0
.end method

.method public static parseTagData(Lcom/adobe/ave/TagData;)Lcom/adobe/mediacore/metadata/TimedMetadata;
    .locals 8

    const/4 v0, 0x0

    const/4 v7, 0x2

    const/4 v5, 0x1

    iget-object v1, p0, Lcom/adobe/ave/TagData;->data:Ljava/lang/String;

    iget-wide v2, p0, Lcom/adobe/ave/TagData;->time:J

    invoke-static {v1}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    const-string v4, ":"

    invoke-virtual {v1, v4, v7}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v1

    array-length v4, v1

    if-lt v4, v5, :cond_0

    const/4 v0, 0x0

    aget-object v0, v1, v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    array-length v0, v1

    if-lt v0, v7, :cond_2

    aget-object v0, v1, v5

    invoke-static {v0}, Lcom/adobe/mediacore/TimedMetadataParser;->parseMetadata(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v7

    :goto_1
    invoke-static {v7, v6, v2, v3}, Lcom/adobe/mediacore/TimedMetadataParser;->getMetadataId(Lcom/adobe/mediacore/metadata/Metadata;Ljava/lang/String;J)J

    move-result-wide v4

    new-instance v0, Lcom/adobe/mediacore/metadata/TimedMetadata;

    sget-object v1, Lcom/adobe/mediacore/metadata/TimedMetadata$Type;->TAG:Lcom/adobe/mediacore/metadata/TimedMetadata$Type;

    invoke-direct/range {v0 .. v7}, Lcom/adobe/mediacore/metadata/TimedMetadata;-><init>(Lcom/adobe/mediacore/metadata/TimedMetadata$Type;JJLjava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    goto :goto_0

    :cond_2
    new-instance v7, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v7}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    goto :goto_1
.end method

.method private static splitIgnoringQuotes(CLjava/lang/String;)Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(C",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const/4 v1, 0x0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    move v2, v1

    move-object v3, v0

    move v0, v1

    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    if-ge v0, v5, :cond_5

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v6, 0x22

    if-ne v5, v6, :cond_1

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    if-eqz v2, :cond_0

    move v2, v1

    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v2, 0x1

    goto :goto_1

    :cond_1
    if-ne v5, p0, :cond_4

    if-eqz v2, :cond_2

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_1

    :cond_2
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    if-lez v5, :cond_3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_3
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    goto :goto_1

    :cond_4
    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_1

    :cond_5
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    if-lez v0, :cond_6

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_6
    return-object v4
.end method
