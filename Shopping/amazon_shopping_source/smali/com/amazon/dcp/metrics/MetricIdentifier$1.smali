.class final Lcom/amazon/dcp/metrics/MetricIdentifier$1;
.super Ljava/lang/Object;
.source "MetricIdentifier.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/dcp/metrics/MetricIdentifier;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/metrics/MetricIdentifier;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 28
    new-instance v0, Lcom/amazon/dcp/metrics/MetricIdentifier;

    invoke-direct {v0, p1}, Lcom/amazon/dcp/metrics/MetricIdentifier;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 24
    invoke-virtual {p0, p1}, Lcom/amazon/dcp/metrics/MetricIdentifier$1;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/metrics/MetricIdentifier;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/dcp/metrics/MetricIdentifier;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 34
    new-array v0, p1, [Lcom/amazon/dcp/metrics/MetricIdentifier;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 24
    invoke-virtual {p0, p1}, Lcom/amazon/dcp/metrics/MetricIdentifier$1;->newArray(I)[Lcom/amazon/dcp/metrics/MetricIdentifier;

    move-result-object v0

    return-object v0
.end method
