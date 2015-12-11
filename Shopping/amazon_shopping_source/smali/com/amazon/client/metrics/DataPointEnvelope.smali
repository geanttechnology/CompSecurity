.class public Lcom/amazon/client/metrics/DataPointEnvelope;
.super Ljava/lang/Object;
.source "DataPointEnvelope.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/client/metrics/DataPointEnvelope;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private dataPoint:Lcom/amazon/client/metrics/DataPoint;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 57
    new-instance v0, Lcom/amazon/client/metrics/DataPointEnvelope$1;

    invoke-direct {v0}, Lcom/amazon/client/metrics/DataPointEnvelope$1;-><init>()V

    sput-object v0, Lcom/amazon/client/metrics/DataPointEnvelope;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method constructor <init>(Lcom/amazon/client/metrics/DataPoint;)V
    .locals 0
    .param p1, "datapoint"    # Lcom/amazon/client/metrics/DataPoint;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-object p1, p0, Lcom/amazon/client/metrics/DataPointEnvelope;->dataPoint:Lcom/amazon/client/metrics/DataPoint;

    .line 32
    return-void
.end method

.method public static convertFromEnvelopes(Ljava/util/List;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPointEnvelope;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;"
        }
    .end annotation

    .prologue
    .line 89
    .local p0, "datapointEnvelopes":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPointEnvelope;>;"
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v2

    .line 90
    .local v2, "numDP":I
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 91
    .local v0, "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 92
    invoke-interface {p0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/client/metrics/DataPointEnvelope;

    invoke-virtual {v3}, Lcom/amazon/client/metrics/DataPointEnvelope;->toDataPoint()Lcom/amazon/client/metrics/DataPoint;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 91
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 94
    :cond_0
    return-object v0
.end method

.method public static convertToEnvelopes(Ljava/util/List;)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPointEnvelope;",
            ">;"
        }
    .end annotation

    .prologue
    .line 80
    .local p0, "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v2

    .line 81
    .local v2, "numDP":I
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 82
    .local v0, "datapointEnvelopes":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPointEnvelope;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 83
    new-instance v4, Lcom/amazon/client/metrics/DataPointEnvelope;

    invoke-interface {p0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/client/metrics/DataPoint;

    invoke-direct {v4, v3}, Lcom/amazon/client/metrics/DataPointEnvelope;-><init>(Lcom/amazon/client/metrics/DataPoint;)V

    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 82
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 85
    :cond_0
    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 46
    const/4 v0, 0x1

    return v0
.end method

.method public toDataPoint()Lcom/amazon/client/metrics/DataPoint;
    .locals 2

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/client/metrics/DataPointEnvelope;->dataPoint:Lcom/amazon/client/metrics/DataPoint;

    .line 40
    .local v0, "temp":Lcom/amazon/client/metrics/DataPoint;
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/client/metrics/DataPointEnvelope;->dataPoint:Lcom/amazon/client/metrics/DataPoint;

    .line 41
    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/client/metrics/DataPointEnvelope;->dataPoint:Lcom/amazon/client/metrics/DataPoint;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPoint;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 52
    iget-object v0, p0, Lcom/amazon/client/metrics/DataPointEnvelope;->dataPoint:Lcom/amazon/client/metrics/DataPoint;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPoint;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 53
    iget-object v0, p0, Lcom/amazon/client/metrics/DataPointEnvelope;->dataPoint:Lcom/amazon/client/metrics/DataPoint;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPoint;->getSamples()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 54
    iget-object v0, p0, Lcom/amazon/client/metrics/DataPointEnvelope;->dataPoint:Lcom/amazon/client/metrics/DataPoint;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPoint;->getType()Lcom/amazon/client/metrics/DataPointType;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPointType;->ordinal()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 55
    return-void
.end method
