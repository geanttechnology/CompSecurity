.class final Lcom/amazon/dcp/ota/Update$1;
.super Ljava/lang/Object;
.source "Update.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/dcp/ota/Update;
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
        "Lcom/amazon/dcp/ota/Update;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/Update;
    .locals 1
    .param p1, "source"    # Landroid/os/Parcel;

    .prologue
    .line 18
    # invokes: Lcom/amazon/dcp/ota/Update;->fromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/Update;
    invoke-static {p1}, Lcom/amazon/dcp/ota/Update;->access$000(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/Update;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 14
    invoke-virtual {p0, p1}, Lcom/amazon/dcp/ota/Update$1;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/Update;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/dcp/ota/Update;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 24
    new-array v0, p1, [Lcom/amazon/dcp/ota/Update;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 14
    invoke-virtual {p0, p1}, Lcom/amazon/dcp/ota/Update$1;->newArray(I)[Lcom/amazon/dcp/ota/Update;

    move-result-object v0

    return-object v0
.end method
