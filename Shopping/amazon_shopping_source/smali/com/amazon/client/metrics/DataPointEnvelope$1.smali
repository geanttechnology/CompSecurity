.class final Lcom/amazon/client/metrics/DataPointEnvelope$1;
.super Ljava/lang/Object;
.source "DataPointEnvelope.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/DataPointEnvelope;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/amazon/client/metrics/DataPointEnvelope;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/client/metrics/DataPointEnvelope;
    .locals 6
    .param p1, "source"    # Landroid/os/Parcel;

    .prologue
    .line 61
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 62
    .local v0, "name":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 63
    .local v3, "value":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 64
    .local v1, "samples":I
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v4

    invoke-static {v4}, Lcom/amazon/client/metrics/DataPointType;->fromInt(I)Lcom/amazon/client/metrics/DataPointType;

    move-result-object v2

    .line 65
    .local v2, "type":Lcom/amazon/client/metrics/DataPointType;
    new-instance v4, Lcom/amazon/client/metrics/DataPointEnvelope;

    new-instance v5, Lcom/amazon/client/metrics/DataPoint;

    invoke-direct {v5, v0, v3, v1, v2}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    invoke-direct {v4, v5}, Lcom/amazon/client/metrics/DataPointEnvelope;-><init>(Lcom/amazon/client/metrics/DataPoint;)V

    return-object v4
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 57
    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/DataPointEnvelope$1;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/client/metrics/DataPointEnvelope;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/client/metrics/DataPointEnvelope;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 70
    new-array v0, p1, [Lcom/amazon/client/metrics/DataPointEnvelope;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 57
    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/DataPointEnvelope$1;->newArray(I)[Lcom/amazon/client/metrics/DataPointEnvelope;

    move-result-object v0

    return-object v0
.end method
