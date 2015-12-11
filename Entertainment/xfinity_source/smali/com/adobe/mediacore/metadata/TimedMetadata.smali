.class public final Lcom/adobe/mediacore/metadata/TimedMetadata;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/metadata/TimedMetadata$Type;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/adobe/mediacore/metadata/TimedMetadata;",
        ">;"
    }
.end annotation


# instance fields
.field private final _id:J

.field private final _metadata:Lcom/adobe/mediacore/metadata/Metadata;

.field private final _name:Ljava/lang/String;

.field private final _time:J

.field private final _type:Lcom/adobe/mediacore/metadata/TimedMetadata$Type;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/metadata/TimedMetadata$Type;JJLjava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_type:Lcom/adobe/mediacore/metadata/TimedMetadata$Type;

    iput-wide p2, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_time:J

    iput-wide p4, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_id:J

    iput-object p6, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_name:Ljava/lang/String;

    iput-object p7, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    return-void
.end method

.method private getMetadataHashcode()I
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    new-instance v0, Ljava/util/TreeSet;

    iget-object v1, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    invoke-interface {v1}, Lcom/adobe/mediacore/metadata/Metadata;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/TreeSet;-><init>(Ljava/util/Collection;)V

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v3, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    invoke-interface {v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0
.end method


# virtual methods
.method public compareTo(Lcom/adobe/mediacore/metadata/TimedMetadata;)I
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_time:J

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-gez v0, :cond_0

    const/4 v0, -0x1

    :goto_0
    return v0

    :cond_0
    iget-wide v0, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_time:J

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

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

    check-cast p1, Lcom/adobe/mediacore/metadata/TimedMetadata;

    invoke-virtual {p0, p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->compareTo(Lcom/adobe/mediacore/metadata/TimedMetadata;)I

    move-result v0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 6

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-ne p1, p0, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    instance-of v2, p1, Lcom/adobe/mediacore/metadata/TimedMetadata;

    if-nez v2, :cond_2

    move v0, v1

    goto :goto_0

    :cond_2
    check-cast p1, Lcom/adobe/mediacore/metadata/TimedMetadata;

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getId()J

    move-result-wide v2

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getId()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_3

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v2

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_3

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getType()Lcom/adobe/mediacore/metadata/TimedMetadata$Type;

    move-result-object v2

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getType()Lcom/adobe/mediacore/metadata/TimedMetadata$Type;

    move-result-object v3

    if-ne v2, v3, :cond_3

    invoke-direct {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadataHashcode()I

    move-result v2

    invoke-direct {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadataHashcode()I

    move-result v3

    if-eq v2, v3, :cond_0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method public getId()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_id:J

    return-wide v0
.end method

.method public getMetadata()Lcom/adobe/mediacore/metadata/Metadata;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_name:Ljava/lang/String;

    return-object v0
.end method

.method public getTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_time:J

    return-wide v0
.end method

.method public getType()Lcom/adobe/mediacore/metadata/TimedMetadata$Type;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_type:Lcom/adobe/mediacore/metadata/TimedMetadata$Type;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/Long;

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    int-to-long v2, v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x3

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getType()Lcom/adobe/mediacore/metadata/TimedMetadata$Type;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/TimedMetadata$Type;->hashCode()I

    move-result v2

    int-to-long v2, v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x4

    invoke-direct {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadataHashcode()I

    move-result v2

    int-to-long v2, v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " Object {"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, " type="

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_type:Lcom/adobe/mediacore/metadata/TimedMetadata$Type;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v0, " ,time="

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_time:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v0, " ,name="

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_name:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, " ,id="

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_id:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    iget-object v0, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    if-eqz v0, :cond_2

    new-instance v0, Ljava/util/TreeSet;

    iget-object v2, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    invoke-interface {v2}, Lcom/adobe/mediacore/metadata/Metadata;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/util/TreeSet;-><init>(Ljava/util/Collection;)V

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v4, p0, Lcom/adobe/mediacore/metadata/TimedMetadata;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    invoke-interface {v4, v0}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    if-lez v5, :cond_0

    const-string v5, ", "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_0
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, ":"

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    :cond_1
    const-string v0, " ,metadata="

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_2
    const-string v0, " }"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
