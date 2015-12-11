.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile$1;
.super Ljava/lang/Object;
.source "VirtuosoFile.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;
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
        "Lcom/penthera/virtuososdk/client/IVirtuosoFile;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 83
    new-instance v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;

    invoke-direct {v0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile$1;->createFromParcel(Landroid/os/Parcel;)Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;
    .locals 1
    .param p1, "aSize"    # I

    .prologue
    .line 87
    new-array v0, p1, [Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile$1;->newArray(I)[Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;

    move-result-object v0

    return-object v0
.end method
