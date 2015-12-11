.class public Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;
.super Ljava/lang/Object;
.source "StringEncodedMetricEntry.java"

# interfaces
.implements Lcom/amazon/client/metrics/codec/EncodedMetricEntry;


# instance fields
.field private mEncodedMetricEntry:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "encodedMetricEntry"    # Ljava/lang/String;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;->mEncodedMetricEntry:Ljava/lang/String;

    .line 14
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 28
    if-ne p0, p1, :cond_1

    .line 29
    const/4 v1, 0x1

    .line 38
    :cond_0
    :goto_0
    return v1

    .line 31
    :cond_1
    if-eqz p1, :cond_0

    .line 34
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-ne v2, v3, :cond_0

    move-object v0, p1

    .line 37
    check-cast v0, Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;

    .line 38
    .local v0, "other":Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;
    iget-object v1, p0, Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;->mEncodedMetricEntry:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;->getEncodedMetricEntry()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method

.method public bridge synthetic getEncodedMetricEntry()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 8
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;->getEncodedMetricEntry()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedMetricEntry()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;->mEncodedMetricEntry:Ljava/lang/String;

    return-object v0
.end method

.method public getEncodedSize()I
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;->mEncodedMetricEntry:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    array-length v0, v0

    return v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;->mEncodedMetricEntry:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;->mEncodedMetricEntry:Ljava/lang/String;

    return-object v0
.end method
