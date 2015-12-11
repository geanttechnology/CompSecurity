.class Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory$1;
.super Ljava/lang/Object;
.source "InterfaceFactory.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory;
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
        "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .locals 3
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 43
    invoke-virtual {p1}, Landroid/os/Parcel;->dataPosition()I

    move-result v0

    .line 44
    .local v0, "initial_pos":I
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 45
    .local v1, "type":I
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->setDataPosition(I)V

    .line 46
    packed-switch v1, :pswitch_data_0

    .line 58
    new-instance v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;

    invoke-direct {v2, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;-><init>(Landroid/os/Parcel;)V

    :goto_0
    return-object v2

    .line 48
    :pswitch_0
    new-instance v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContainerCollection;

    invoke-direct {v2, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContainerCollection;-><init>(Landroid/os/Parcel;)V

    goto :goto_0

    .line 50
    :pswitch_1
    new-instance v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;

    invoke-direct {v2, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;-><init>(Landroid/os/Parcel;)V

    goto :goto_0

    .line 52
    :pswitch_2
    new-instance v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;

    invoke-direct {v2, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;-><init>(Landroid/os/Parcel;)V

    goto :goto_0

    .line 54
    :pswitch_3
    new-instance v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;

    invoke-direct {v2, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;-><init>(Landroid/os/Parcel;)V

    goto :goto_0

    .line 46
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory$1;->createFromParcel(Landroid/os/Parcel;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .locals 1
    .param p1, "aSize"    # I

    .prologue
    .line 63
    new-array v0, p1, [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory$1;->newArray(I)[Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v0

    return-object v0
.end method
