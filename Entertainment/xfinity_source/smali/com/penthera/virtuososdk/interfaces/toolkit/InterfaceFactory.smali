.class public Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory;
.super Ljava/lang/Object;
.source "InterfaceFactory.java"


# static fields
.field public static final FD_CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;"
        }
    .end annotation
.end field

.field public static final FILE_CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoFile;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->CREATOR:Landroid/os/Parcelable$Creator;

    sput-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory;->FILE_CREATOR:Landroid/os/Parcelable$Creator;

    .line 39
    new-instance v0, Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory$1;

    invoke-direct {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory$1;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory;->FD_CREATOR:Landroid/os/Parcelable$Creator;

    .line 18
    return-void
.end method

.method protected static virtuosoHLSFile(Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;
    .locals 1
    .param p0, "aAssetId"    # Ljava/lang/String;
    .param p1, "aMetaData"    # Ljava/lang/String;

    .prologue
    .line 70
    new-instance v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;

    invoke-direct {v0, p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method
