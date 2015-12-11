.class public Lcom/amazon/client/metrics/DataPoint;
.super Ljava/lang/Object;
.source "DataPoint.java"


# instance fields
.field private final mName:Ljava/lang/String;

.field private final mSamples:I

.field private final mType:Lcom/amazon/client/metrics/DataPointType;

.field private final mValue:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "samples"    # I
    .param p4, "type"    # Lcom/amazon/client/metrics/DataPointType;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    const-string/jumbo v0, "name cannot be null or empty"

    invoke-direct {p0, p1, v0}, Lcom/amazon/client/metrics/DataPoint;->validateString(Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    const-string/jumbo v0, "value cannot be null or empty"

    invoke-direct {p0, p2, v0}, Lcom/amazon/client/metrics/DataPoint;->validateString(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    if-nez p4, :cond_0

    .line 39
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "DataPoint type cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 41
    :cond_0
    iput-object p1, p0, Lcom/amazon/client/metrics/DataPoint;->mName:Ljava/lang/String;

    .line 42
    iput-object p2, p0, Lcom/amazon/client/metrics/DataPoint;->mValue:Ljava/lang/String;

    .line 43
    iput p3, p0, Lcom/amazon/client/metrics/DataPoint;->mSamples:I

    .line 44
    iput-object p4, p0, Lcom/amazon/client/metrics/DataPoint;->mType:Lcom/amazon/client/metrics/DataPointType;

    .line 45
    return-void
.end method

.method private validateString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "toValidate"    # Ljava/lang/String;
    .param p2, "errorMsg"    # Ljava/lang/String;

    .prologue
    .line 145
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 146
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 148
    :cond_1
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 92
    if-ne p0, p1, :cond_1

    .line 115
    :cond_0
    :goto_0
    return v1

    .line 95
    :cond_1
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_2

    move v1, v2

    .line 96
    goto :goto_0

    :cond_2
    move-object v0, p1

    .line 98
    check-cast v0, Lcom/amazon/client/metrics/DataPoint;

    .line 100
    .local v0, "other":Lcom/amazon/client/metrics/DataPoint;
    iget-object v3, p0, Lcom/amazon/client/metrics/DataPoint;->mName:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/client/metrics/DataPoint;->mName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3

    move v1, v2

    .line 101
    goto :goto_0

    .line 104
    :cond_3
    iget v3, p0, Lcom/amazon/client/metrics/DataPoint;->mSamples:I

    iget v4, v0, Lcom/amazon/client/metrics/DataPoint;->mSamples:I

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 105
    goto :goto_0

    .line 108
    :cond_4
    iget-object v3, p0, Lcom/amazon/client/metrics/DataPoint;->mType:Lcom/amazon/client/metrics/DataPointType;

    iget-object v4, v0, Lcom/amazon/client/metrics/DataPoint;->mType:Lcom/amazon/client/metrics/DataPointType;

    invoke-virtual {v3, v4}, Lcom/amazon/client/metrics/DataPointType;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    move v1, v2

    .line 109
    goto :goto_0

    .line 112
    :cond_5
    iget-object v3, p0, Lcom/amazon/client/metrics/DataPoint;->mValue:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/client/metrics/DataPoint;->mValue:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 113
    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/client/metrics/DataPoint;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public getSamples()I
    .locals 1

    .prologue
    .line 76
    iget v0, p0, Lcom/amazon/client/metrics/DataPoint;->mSamples:I

    return v0
.end method

.method public getType()Lcom/amazon/client/metrics/DataPointType;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/client/metrics/DataPoint;->mType:Lcom/amazon/client/metrics/DataPointType;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/client/metrics/DataPoint;->mValue:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 81
    const/16 v0, 0x1f

    .line 82
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 83
    .local v1, "result":I
    iget-object v2, p0, Lcom/amazon/client/metrics/DataPoint;->mName:Ljava/lang/String;

    if-nez v2, :cond_0

    move v2, v3

    :goto_0
    add-int/lit8 v1, v2, 0x1f

    .line 84
    mul-int/lit8 v2, v1, 0x1f

    iget v4, p0, Lcom/amazon/client/metrics/DataPoint;->mSamples:I

    add-int v1, v2, v4

    .line 85
    mul-int/lit8 v4, v1, 0x1f

    iget-object v2, p0, Lcom/amazon/client/metrics/DataPoint;->mType:Lcom/amazon/client/metrics/DataPointType;

    if-nez v2, :cond_1

    move v2, v3

    :goto_1
    add-int v1, v4, v2

    .line 86
    mul-int/lit8 v2, v1, 0x1f

    iget-object v4, p0, Lcom/amazon/client/metrics/DataPoint;->mValue:Ljava/lang/String;

    if-nez v4, :cond_2

    :goto_2
    add-int v1, v2, v3

    .line 87
    return v1

    .line 83
    :cond_0
    iget-object v2, p0, Lcom/amazon/client/metrics/DataPoint;->mName:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    goto :goto_0

    .line 85
    :cond_1
    iget-object v2, p0, Lcom/amazon/client/metrics/DataPoint;->mType:Lcom/amazon/client/metrics/DataPointType;

    invoke-virtual {v2}, Lcom/amazon/client/metrics/DataPointType;->hashCode()I

    move-result v2

    goto :goto_1

    .line 86
    :cond_2
    iget-object v3, p0, Lcom/amazon/client/metrics/DataPoint;->mValue:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v3

    goto :goto_2
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 126
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 127
    .local v0, "sb":Ljava/lang/StringBuilder;
    const-string/jumbo v1, " ["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 128
    iget-object v1, p0, Lcom/amazon/client/metrics/DataPoint;->mName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 129
    const-string/jumbo v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 130
    iget-object v1, p0, Lcom/amazon/client/metrics/DataPoint;->mValue:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 131
    const-string/jumbo v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 132
    iget v1, p0, Lcom/amazon/client/metrics/DataPoint;->mSamples:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 133
    const-string/jumbo v1, "] "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 134
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
