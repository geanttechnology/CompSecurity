.class public final Lcom/adobe/mediacore/timeline/advertising/AdBreak;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/timeline/TimelineMarker;
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/adobe/mediacore/timeline/TimelineMarker;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/adobe/mediacore/timeline/advertising/AdBreak;",
        ">;"
    }
.end annotation


# static fields
.field private static final REPLACE_DURATION_ALLOWED_VARIATION:I = 0x7d0

.field private static final USE_REPLACE_DURATION_FROM_CUE_DURATION:Z


# instance fields
.field private final _ads:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;"
        }
    .end annotation
.end field

.field private final _duration:J

.field private _isWatched:Ljava/lang/Boolean;

.field private _localTime:J

.field private final _replaceDuration:J

.field private _restoreId:Ljava/lang/String;

.field private final _tag:Ljava/lang/String;

.field private _time:J

.field private _type:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;


# direct methods
.method private constructor <init>(Ljava/util/List;JJLjava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;JJ",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_ads:Ljava/util/List;

    iput-wide p2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_time:J

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->calculateBreakDuration()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_duration:J

    iput-wide p4, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_replaceDuration:J

    iput-object p6, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_tag:Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_isWatched:Ljava/lang/Boolean;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_restoreId:Ljava/lang/String;

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_localTime:J

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->UNKNOWN:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_type:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    return-void
.end method

.method private calculateBreakDuration()J
    .locals 5

    const-wide/16 v0, 0x0

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_ads:Ljava/util/List;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_ads:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_ads:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    move-wide v2, v0

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v0

    add-long/2addr v0, v2

    move-wide v2, v0

    goto :goto_0

    :cond_0
    move-wide v0, v2

    :cond_1
    return-wide v0
.end method

.method public static createAdBreak(Ljava/util/List;JJLjava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;JJ",
            "Ljava/lang/String;",
            ")",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreak;"
        }
    .end annotation

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-object v1, p0

    move-wide v2, p1

    move-wide v4, p3

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;-><init>(Ljava/util/List;JJLjava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public adsIterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_ads:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public cloneFor(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .locals 7

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getDuration()J

    move-result-wide v4

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_ads:Ljava/util/List;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v2

    iget-object v6, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_tag:Ljava/lang/String;

    invoke-direct/range {v0 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;-><init>(Ljava/util/List;JJLjava/lang/String;)V

    return-object v0
.end method

.method public compareTo(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)I
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_time:J

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-gez v0, :cond_0

    const/4 v0, -0x1

    :goto_0
    return v0

    :cond_0
    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_time:J

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    invoke-virtual {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->compareTo(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)I

    move-result v0

    return v0
.end method

.method public getAdForContentId(I)Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_ads:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v2

    if-ne v2, p1, :cond_0

    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_duration:J

    return-wide v0
.end method

.method public getFirstAd()Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 3

    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v1

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    goto :goto_0
.end method

.method public getInitialReplaceDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_replaceDuration:J

    return-wide v0
.end method

.method public getLastAd()Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 4

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v2

    if-nez v2, :cond_0

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_0

    goto :goto_0

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method public getLocalTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_localTime:J

    return-wide v0
.end method

.method public getReplaceDuration()J
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_replaceDuration:J

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-lez v2, :cond_0

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_replaceDuration:J

    const-wide/16 v2, 0x7d0

    add-long/2addr v0, v2

    iget-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_duration:J

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    :cond_0
    return-wide v0
.end method

.method public getRestoreId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_restoreId:Ljava/lang/String;

    return-object v0
.end method

.method public getTag()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_tag:Ljava/lang/String;

    return-object v0
.end method

.method public getTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_time:J

    return-wide v0
.end method

.method public getType()Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_type:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    return-object v0
.end method

.method public isValid()Z
    .locals 6

    const/4 v0, 0x1

    iget-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_replaceDuration:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-lez v1, :cond_0

    iget-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_replaceDuration:J

    const-wide/16 v4, 0x7d0

    add-long/2addr v2, v4

    iget-wide v4, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_duration:J

    cmp-long v1, v2, v4

    if-ltz v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isWatched()Ljava/lang/Boolean;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_isWatched:Ljava/lang/Boolean;

    return-object v0
.end method

.method public setIsWatched(Ljava/lang/Boolean;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_isWatched:Ljava/lang/Boolean;

    return-void
.end method

.method public setLocalTime(J)V
    .locals 1

    iput-wide p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_localTime:J

    return-void
.end method

.method public setRestoreId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_restoreId:Ljava/lang/String;

    return-void
.end method

.method public setType(Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_type:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->UNKNOWN:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    if-ne v0, v1, :cond_0

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_type:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    :cond_0
    return-void
.end method

.method public size()J
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_ads:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_ads:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    int-to-long v0, v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
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

    const-string v1, " ad count="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_ads:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, " ,type="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_type:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, " ,time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_time:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, " ,local time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_localTime:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, " ,duration="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_duration:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, " ,replace duration="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_replaceDuration:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, " ,tag="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->_tag:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
