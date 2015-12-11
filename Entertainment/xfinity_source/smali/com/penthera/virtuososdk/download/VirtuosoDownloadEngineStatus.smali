.class public Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;
.super Ljava/lang/Object;
.source "VirtuosoDownloadEngineStatus.java"

# interfaces
.implements Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public iExtras:Landroid/os/Bundle;

.field public iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    new-instance v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus$1;

    invoke-direct {v0}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus$1;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 27
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    sget-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 54
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    .line 55
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    sget-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 59
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->readFromParcel(Landroid/os/Parcel;)V

    .line 60
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 111
    const/4 v0, 0x0

    return v0
.end method

.method public extras()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    return-object v0
.end method

.method protected readFromParcel(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 122
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->values()[Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v0

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 123
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readBundle(Ljava/lang/ClassLoader;)Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    .line 124
    return-void
.end method

.method public status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flag"    # I

    .prologue
    .line 129
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 130
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V

    .line 131
    return-void
.end method
