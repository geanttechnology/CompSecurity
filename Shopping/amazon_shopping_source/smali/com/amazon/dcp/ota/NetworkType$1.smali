.class final Lcom/amazon/dcp/ota/NetworkType$1;
.super Ljava/lang/Object;
.source "NetworkType.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/dcp/ota/NetworkType;
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
        "Lcom/amazon/dcp/ota/NetworkType;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/NetworkType;
    .locals 1
    .param p1, "source"    # Landroid/os/Parcel;

    .prologue
    .line 30
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    invoke-static {v0}, Lcom/amazon/dcp/ota/NetworkType;->fromValue(I)Lcom/amazon/dcp/ota/NetworkType;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 26
    invoke-virtual {p0, p1}, Lcom/amazon/dcp/ota/NetworkType$1;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/NetworkType;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/dcp/ota/NetworkType;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 36
    new-array v0, p1, [Lcom/amazon/dcp/ota/NetworkType;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 26
    invoke-virtual {p0, p1}, Lcom/amazon/dcp/ota/NetworkType$1;->newArray(I)[Lcom/amazon/dcp/ota/NetworkType;

    move-result-object v0

    return-object v0
.end method
