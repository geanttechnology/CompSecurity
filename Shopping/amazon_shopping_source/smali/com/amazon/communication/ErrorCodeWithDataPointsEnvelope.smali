.class public Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mErrorCodeWithDataPoints:Lcom/amazon/communication/ErrorCodeWithDataPoints;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope$1;

    invoke-direct {v0}, Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope$1;-><init>()V

    sput-object v0, Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/communication/ErrorCodeWithDataPoints;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;->mErrorCodeWithDataPoints:Lcom/amazon/communication/ErrorCodeWithDataPoints;

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;->mErrorCodeWithDataPoints:Lcom/amazon/communication/ErrorCodeWithDataPoints;

    invoke-virtual {v0}, Lcom/amazon/communication/ErrorCodeWithDataPoints;->getCode()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Lcom/amazon/communication/ErrorCodeWithDataPointsEnvelope;->mErrorCodeWithDataPoints:Lcom/amazon/communication/ErrorCodeWithDataPoints;

    invoke-virtual {v0}, Lcom/amazon/communication/ErrorCodeWithDataPoints;->getDataPoints()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeList(Ljava/util/List;)V

    return-void
.end method
