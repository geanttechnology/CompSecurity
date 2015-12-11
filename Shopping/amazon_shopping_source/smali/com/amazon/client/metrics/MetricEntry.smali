.class public Lcom/amazon/client/metrics/MetricEntry;
.super Ljava/lang/Object;
.source "MetricEntry.java"


# instance fields
.field private final mDatapoints:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;"
        }
    .end annotation
.end field

.field private final mProgram:Ljava/lang/String;

.field private final mSource:Ljava/lang/String;

.field private final mTimestamp:J


# direct methods
.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 2
    .param p1, "timestamp"    # J
    .param p3, "program"    # Ljava/lang/String;
    .param p4, "source"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 29
    .local p5, "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 31
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "program cannot be empty or null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 34
    :cond_1
    if-eqz p4, :cond_2

    invoke-virtual {p4}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 35
    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "source cannot be empty or null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 38
    :cond_3
    if-nez p5, :cond_4

    .line 39
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "data points cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 42
    :cond_4
    iput-wide p1, p0, Lcom/amazon/client/metrics/MetricEntry;->mTimestamp:J

    .line 43
    iput-object p3, p0, Lcom/amazon/client/metrics/MetricEntry;->mProgram:Ljava/lang/String;

    .line 44
    iput-object p4, p0, Lcom/amazon/client/metrics/MetricEntry;->mSource:Ljava/lang/String;

    .line 45
    iput-object p5, p0, Lcom/amazon/client/metrics/MetricEntry;->mDatapoints:Ljava/util/List;

    .line 46
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 77
    if-ne p0, p1, :cond_1

    .line 103
    :cond_0
    :goto_0
    return v1

    .line 80
    :cond_1
    if-nez p1, :cond_2

    move v1, v2

    .line 81
    goto :goto_0

    .line 83
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 84
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 86
    check-cast v0, Lcom/amazon/client/metrics/MetricEntry;

    .line 87
    .local v0, "other":Lcom/amazon/client/metrics/MetricEntry;
    iget-object v3, p0, Lcom/amazon/client/metrics/MetricEntry;->mDatapoints:Ljava/util/List;

    iget-object v4, v0, Lcom/amazon/client/metrics/MetricEntry;->mDatapoints:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    move v1, v2

    .line 88
    goto :goto_0

    .line 91
    :cond_4
    iget-object v3, p0, Lcom/amazon/client/metrics/MetricEntry;->mProgram:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/client/metrics/MetricEntry;->mProgram:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    move v1, v2

    .line 92
    goto :goto_0

    .line 95
    :cond_5
    iget-object v3, p0, Lcom/amazon/client/metrics/MetricEntry;->mSource:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/client/metrics/MetricEntry;->mSource:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    move v1, v2

    .line 96
    goto :goto_0

    .line 99
    :cond_6
    iget-wide v3, p0, Lcom/amazon/client/metrics/MetricEntry;->mTimestamp:J

    iget-wide v5, v0, Lcom/amazon/client/metrics/MetricEntry;->mTimestamp:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_0

    move v1, v2

    .line 100
    goto :goto_0
.end method

.method public getDatapoints()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;"
        }
    .end annotation

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricEntry;->mDatapoints:Ljava/util/List;

    return-object v0
.end method

.method public getProgram()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricEntry;->mProgram:Ljava/lang/String;

    return-object v0
.end method

.method public getSource()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricEntry;->mSource:Ljava/lang/String;

    return-object v0
.end method

.method public getTimestamp()J
    .locals 2

    .prologue
    .line 49
    iget-wide v0, p0, Lcom/amazon/client/metrics/MetricEntry;->mTimestamp:J

    return-wide v0
.end method

.method public hashCode()I
    .locals 8

    .prologue
    .line 66
    const/16 v0, 0x1f

    .line 67
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 68
    .local v1, "result":I
    iget-object v2, p0, Lcom/amazon/client/metrics/MetricEntry;->mDatapoints:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    add-int/lit8 v1, v2, 0x1f

    .line 69
    mul-int/lit8 v2, v1, 0x1f

    iget-object v3, p0, Lcom/amazon/client/metrics/MetricEntry;->mProgram:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v3

    add-int v1, v2, v3

    .line 70
    mul-int/lit8 v2, v1, 0x1f

    iget-object v3, p0, Lcom/amazon/client/metrics/MetricEntry;->mSource:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v3

    add-int v1, v2, v3

    .line 71
    mul-int/lit8 v2, v1, 0x1f

    iget-wide v3, p0, Lcom/amazon/client/metrics/MetricEntry;->mTimestamp:J

    iget-wide v5, p0, Lcom/amazon/client/metrics/MetricEntry;->mTimestamp:J

    const/16 v7, 0x20

    ushr-long/2addr v5, v7

    xor-long/2addr v3, v5

    long-to-int v3, v3

    add-int v1, v2, v3

    .line 72
    return v1
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 108
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 109
    .local v1, "stringBuilder":Ljava/lang/StringBuilder;
    iget-wide v2, p0, Lcom/amazon/client/metrics/MetricEntry;->mTimestamp:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 110
    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 111
    iget-object v2, p0, Lcom/amazon/client/metrics/MetricEntry;->mProgram:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 112
    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 113
    iget-object v2, p0, Lcom/amazon/client/metrics/MetricEntry;->mSource:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 114
    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 115
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/client/metrics/MetricEntry;->mDatapoints:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 116
    iget-object v2, p0, Lcom/amazon/client/metrics/MetricEntry;->mDatapoints:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/client/metrics/DataPoint;

    invoke-virtual {v2}, Lcom/amazon/client/metrics/DataPoint;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 115
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 118
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
