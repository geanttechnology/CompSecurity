.class Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus$1;
.super Ljava/lang/Object;
.source "VirtuosoDownloadEngineStatus.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 44
    new-instance v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    invoke-direct {v0, p1}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus$1;->createFromParcel(Landroid/os/Parcel;)Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;
    .locals 1
    .param p1, "aSize"    # I

    .prologue
    .line 48
    new-array v0, p1, [Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus$1;->newArray(I)[Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    move-result-object v0

    return-object v0
.end method
