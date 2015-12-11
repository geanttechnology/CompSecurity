.class public final Lcom/adobe/mediacore/MediaResource;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/MediaResource$MimeType;,
        Lcom/adobe/mediacore/MediaResource$Type;
    }
.end annotation


# instance fields
.field private final _metadata:Lcom/adobe/mediacore/metadata/Metadata;

.field private _mimeType:Lcom/adobe/mediacore/MediaResource$MimeType;

.field private final _type:Lcom/adobe/mediacore/MediaResource$Type;

.field private final _url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/adobe/mediacore/MediaResource$Type;Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/MediaResource;->_url:Ljava/lang/String;

    iput-object p2, p0, Lcom/adobe/mediacore/MediaResource;->_type:Lcom/adobe/mediacore/MediaResource$Type;

    iput-object p3, p0, Lcom/adobe/mediacore/MediaResource;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    return-void
.end method

.method public static createFromMetadata(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/MediaResource$Type;)Lcom/adobe/mediacore/MediaResource;
    .locals 2

    new-instance v0, Lcom/adobe/mediacore/MediaResource;

    const/4 v1, 0x0

    invoke-direct {v0, v1, p1, p0}, Lcom/adobe/mediacore/MediaResource;-><init>(Ljava/lang/String;Lcom/adobe/mediacore/MediaResource$Type;Lcom/adobe/mediacore/metadata/Metadata;)V

    return-object v0
.end method

.method public static createFromUrl(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/MediaResource;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    invoke-static {p0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Provided url is not valid"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-static {p0}, Lcom/adobe/mediacore/utils/StringUtils;->getFileExtension(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-object v1, Lcom/adobe/mediacore/MediaResource$Type;->HLS:Lcom/adobe/mediacore/MediaResource$Type;

    if-eqz v3, :cond_2

    invoke-static {}, Lcom/adobe/mediacore/MediaResource$Type;->values()[Lcom/adobe/mediacore/MediaResource$Type;

    move-result-object v4

    array-length v5, v4

    const/4 v0, 0x0

    move v2, v0

    :goto_0
    if-ge v2, v5, :cond_2

    aget-object v0, v4, v2

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource$Type;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    :goto_1
    new-instance v1, Lcom/adobe/mediacore/MediaResource;

    invoke-direct {v1, p0, v0, p1}, Lcom/adobe/mediacore/MediaResource;-><init>(Ljava/lang/String;Lcom/adobe/mediacore/MediaResource$Type;Lcom/adobe/mediacore/metadata/Metadata;)V

    return-object v1

    :cond_1
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    :cond_2
    move-object v0, v1

    goto :goto_1
.end method


# virtual methods
.method public equals(Lcom/adobe/mediacore/MediaResource;)Z
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-nez p1, :cond_1

    move v0, v1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v2, p0, Lcom/adobe/mediacore/MediaResource;->_url:Ljava/lang/String;

    if-nez v2, :cond_3

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/adobe/mediacore/MediaResource;->_type:Lcom/adobe/mediacore/MediaResource$Type;

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaResource;->getType()Lcom/adobe/mediacore/MediaResource$Type;

    move-result-object v3

    if-eq v2, v3, :cond_0

    :cond_2
    move v0, v1

    goto :goto_0

    :cond_3
    iget-object v2, p0, Lcom/adobe/mediacore/MediaResource;->_url:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/adobe/mediacore/MediaResource;->_type:Lcom/adobe/mediacore/MediaResource$Type;

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaResource;->getType()Lcom/adobe/mediacore/MediaResource$Type;

    move-result-object v3

    if-eq v2, v3, :cond_0

    :cond_4
    move v0, v1

    goto :goto_0
.end method

.method public getMetadata()Lcom/adobe/mediacore/metadata/Metadata;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaResource;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    return-object v0
.end method

.method public getType()Lcom/adobe/mediacore/MediaResource$Type;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaResource;->_type:Lcom/adobe/mediacore/MediaResource$Type;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaResource;->_url:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Object { "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "url="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaResource;->_url:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " ,type="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaResource;->_type:Lcom/adobe/mediacore/MediaResource$Type;

    invoke-virtual {v2}, Lcom/adobe/mediacore/MediaResource$Type;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
