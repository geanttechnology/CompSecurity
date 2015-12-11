.class public final Lcom/adobe/mediacore/timeline/advertising/Ad;
.super Ljava/lang/Object;


# instance fields
.field private final _companionAssets:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdAsset;",
            ">;"
        }
    .end annotation
.end field

.field private final _contentTracker:Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

.field private final _duration:J

.field private final _id:I

.field private final _isCustomAdMarker:Z

.field private final _primaryAsset:Lcom/adobe/mediacore/timeline/advertising/AdAsset;

.field private final _type:Lcom/adobe/mediacore/MediaResource$Type;


# direct methods
.method private constructor <init>(ILcom/adobe/mediacore/MediaResource$Type;Lcom/adobe/mediacore/timeline/advertising/ContentTracker;JZLcom/adobe/mediacore/timeline/advertising/AdAsset;Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/adobe/mediacore/MediaResource$Type;",
            "Lcom/adobe/mediacore/timeline/advertising/ContentTracker;",
            "JZ",
            "Lcom/adobe/mediacore/timeline/advertising/AdAsset;",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdAsset;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_id:I

    iput-object p2, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_type:Lcom/adobe/mediacore/MediaResource$Type;

    iput-object p3, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_contentTracker:Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    iput-wide p4, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_duration:J

    iput-boolean p6, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_isCustomAdMarker:Z

    iput-object p7, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_primaryAsset:Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    iput-object p8, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_companionAssets:Ljava/util/List;

    return-void
.end method

.method public static cloneAd(Lcom/adobe/mediacore/timeline/advertising/Ad;JI)Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 9

    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getCompanionAssets()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->newInstance(Lcom/adobe/mediacore/timeline/advertising/AdAsset;)Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v0

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_0
    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getType()Lcom/adobe/mediacore/MediaResource$Type;

    move-result-object v2

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v3

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->isCustomAdMarker()Z

    move-result v6

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v1

    invoke-static {v1}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->newInstance(Lcom/adobe/mediacore/timeline/advertising/AdAsset;)Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v7

    move v1, p3

    move-wide v4, p1

    invoke-direct/range {v0 .. v8}, Lcom/adobe/mediacore/timeline/advertising/Ad;-><init>(ILcom/adobe/mediacore/MediaResource$Type;Lcom/adobe/mediacore/timeline/advertising/ContentTracker;JZLcom/adobe/mediacore/timeline/advertising/AdAsset;Ljava/util/List;)V

    return-object v0
.end method

.method public static createAd(Lcom/adobe/mediacore/MediaResource$Type;JILcom/adobe/mediacore/timeline/advertising/AdAsset;Ljava/util/List;Lcom/adobe/mediacore/timeline/advertising/ContentTracker;)Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/MediaResource$Type;",
            "JI",
            "Lcom/adobe/mediacore/timeline/advertising/AdAsset;",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdAsset;",
            ">;",
            "Lcom/adobe/mediacore/timeline/advertising/ContentTracker;",
            ")",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;"
        }
    .end annotation

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    const/4 v6, 0x0

    move v1, p3

    move-object v2, p0

    move-object v3, p6

    move-wide v4, p1

    move-object v7, p4

    move-object v8, p5

    invoke-direct/range {v0 .. v8}, Lcom/adobe/mediacore/timeline/advertising/Ad;-><init>(ILcom/adobe/mediacore/MediaResource$Type;Lcom/adobe/mediacore/timeline/advertising/ContentTracker;JZLcom/adobe/mediacore/timeline/advertising/AdAsset;Ljava/util/List;)V

    return-object v0
.end method

.method public static createCustomAdMarker(Lcom/adobe/mediacore/MediaResource$Type;JILcom/adobe/mediacore/timeline/advertising/AdAsset;)Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 9

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    const/4 v3, 0x0

    const/4 v6, 0x1

    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    move v1, p3

    move-object v2, p0

    move-wide v4, p1

    move-object v7, p4

    invoke-direct/range {v0 .. v8}, Lcom/adobe/mediacore/timeline/advertising/Ad;-><init>(ILcom/adobe/mediacore/MediaResource$Type;Lcom/adobe/mediacore/timeline/advertising/ContentTracker;JZLcom/adobe/mediacore/timeline/advertising/AdAsset;Ljava/util/List;)V

    return-object v0
.end method


# virtual methods
.method public equals(Lcom/adobe/mediacore/timeline/advertising/Ad;)Z
    .locals 2

    if-eqz p1, :cond_0

    iget v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_id:I

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_primaryAsset:Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getId()I

    move-result v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getId()I

    move-result v1

    if-ne v0, v1, :cond_0

    invoke-super {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getCompanionAssets()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdAsset;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_companionAssets:Ljava/util/List;

    return-object v0
.end method

.method public getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_contentTracker:Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    return-object v0
.end method

.method public final getDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_duration:J

    return-wide v0
.end method

.method public getId()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_id:I

    return v0
.end method

.method public final getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_primaryAsset:Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    return-object v0
.end method

.method public final getType()Lcom/adobe/mediacore/MediaResource$Type;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_type:Lcom/adobe/mediacore/MediaResource$Type;

    return-object v0
.end method

.method public isClickable()Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_primaryAsset:Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_primaryAsset:Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getAdClick()Lcom/adobe/mediacore/timeline/advertising/AdClick;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_primaryAsset:Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getAdClick()Lcom/adobe/mediacore/timeline/advertising/AdClick;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdClick;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isCustomAdMarker()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_isCustomAdMarker:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Object {"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " resource="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/MediaResource;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " ,duration="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, " ,id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/adobe/mediacore/timeline/advertising/Ad;->_id:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
