.class final Lcom/amazon/dcp/ota/UpdateState$1;
.super Ljava/lang/Object;
.source "UpdateState.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/dcp/ota/UpdateState;
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
        "Lcom/amazon/dcp/ota/UpdateState;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/UpdateState;
    .locals 1
    .param p1, "source"    # Landroid/os/Parcel;

    .prologue
    .line 37
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    invoke-static {v0}, Lcom/amazon/dcp/ota/UpdateState;->fromValue(I)Lcom/amazon/dcp/ota/UpdateState;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 33
    invoke-virtual {p0, p1}, Lcom/amazon/dcp/ota/UpdateState$1;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/UpdateState;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/dcp/ota/UpdateState;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 43
    new-array v0, p1, [Lcom/amazon/dcp/ota/UpdateState;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 33
    invoke-virtual {p0, p1}, Lcom/amazon/dcp/ota/UpdateState$1;->newArray(I)[Lcom/amazon/dcp/ota/UpdateState;

    move-result-object v0

    return-object v0
.end method
