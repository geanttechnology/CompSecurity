.class final Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope$1;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;
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
        "Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;
    .locals 4

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    const-class v2, Lcom/amazon/client/metrics/DataPointEnvelope;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Landroid/os/Parcel;->readList(Ljava/util/List;Ljava/lang/ClassLoader;)V

    new-instance v2, Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;

    new-instance v3, Lcom/amazon/communication/ErrorCodeWithDataPoints;

    invoke-direct {v3, v0, v1}, Lcom/amazon/communication/ErrorCodeWithDataPoints;-><init>(ILjava/util/List;)V

    invoke-direct {v2, v3}, Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;-><init>(Lcom/amazon/communication/ErrorCodeWithDataPoints;)V

    return-object v2
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope$1;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;
    .locals 1

    new-array v0, p1, [Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope$1;->newArray(I)[Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;

    move-result-object v0

    return-object v0
.end method
