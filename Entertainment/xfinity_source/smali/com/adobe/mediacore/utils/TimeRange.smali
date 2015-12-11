.class public Lcom/adobe/mediacore/utils/TimeRange;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/adobe/mediacore/utils/TimeRange;",
        ">;"
    }
.end annotation


# instance fields
.field private final _begin:J

.field private final _end:J


# direct methods
.method public constructor <init>(JJ)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide p1, p0, Lcom/adobe/mediacore/utils/TimeRange;->_begin:J

    iput-wide p3, p0, Lcom/adobe/mediacore/utils/TimeRange;->_end:J

    return-void
.end method

.method public static adjustTime(JJJ)J
    .locals 2

    invoke-static {p4, p5, p0, p1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    invoke-static {p2, p3, v0, v1}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public static createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;
    .locals 4

    new-instance v0, Lcom/adobe/mediacore/utils/TimeRange;

    add-long v2, p0, p2

    invoke-direct {v0, p0, p1, v2, v3}, Lcom/adobe/mediacore/utils/TimeRange;-><init>(JJ)V

    return-object v0
.end method


# virtual methods
.method public compareTo(Lcom/adobe/mediacore/utils/TimeRange;)I
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/utils/TimeRange;->_begin:J

    invoke-virtual {p1}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v2

    sub-long/2addr v0, v2

    long-to-int v0, v0

    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Lcom/adobe/mediacore/utils/TimeRange;

    invoke-virtual {p0, p1}, Lcom/adobe/mediacore/utils/TimeRange;->compareTo(Lcom/adobe/mediacore/utils/TimeRange;)I

    move-result v0

    return v0
.end method

.method public contains(J)Z
    .locals 3

    iget-wide v0, p0, Lcom/adobe/mediacore/utils/TimeRange;->_begin:J

    cmp-long v0, v0, p1

    if-gtz v0, :cond_0

    iget-wide v0, p0, Lcom/adobe/mediacore/utils/TimeRange;->_end:J

    cmp-long v0, p1, v0

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getBegin()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/utils/TimeRange;->_begin:J

    return-wide v0
.end method

.method public getDuration()J
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/utils/TimeRange;->_end:J

    iget-wide v2, p0, Lcom/adobe/mediacore/utils/TimeRange;->_begin:J

    sub-long/2addr v0, v2

    return-wide v0
.end method

.method public getEnd()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/utils/TimeRange;->_end:J

    return-wide v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "Object {"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " begin="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/adobe/mediacore/utils/TimeRange;->_begin:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, " ,end="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/adobe/mediacore/utils/TimeRange;->_end:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
