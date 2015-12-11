.class Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback$Stub$Proxy;
.super Ljava/lang/Object;
.source "IVirtuosoDownloadedCallback.java"

# interfaces
.implements Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback$Stub;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Proxy"
.end annotation


# instance fields
.field private mRemote:Landroid/os/IBinder;


# direct methods
.method constructor <init>(Landroid/os/IBinder;)V
    .locals 0
    .param p1, "remote"    # Landroid/os/IBinder;

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    .line 82
    return-void
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    return-object v0
.end method

.method public engineContentInDownloadedList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V
    .locals 5
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p2, "aOffset"    # I
    .param p3, "aListSize"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 99
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 100
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 102
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 103
    if-eqz p1, :cond_0

    .line 104
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 105
    const/4 v2, 0x0

    invoke-interface {p1, v0, v2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->writeToParcel(Landroid/os/Parcel;I)V

    .line 110
    :goto_0
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeInt(I)V

    .line 111
    invoke-virtual {v0, p3}, Landroid/os/Parcel;->writeInt(I)V

    .line 112
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v3, 0x1

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 113
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 116
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 117
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 119
    return-void

    .line 108
    :cond_0
    const/4 v2, 0x0

    :try_start_1
    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 115
    :catchall_0
    move-exception v2

    .line 116
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 117
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 118
    throw v2
.end method

.method public engineDownloadedListChanged()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 126
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 127
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 129
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 130
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 131
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 134
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 135
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 137
    return-void

    .line 133
    :catchall_0
    move-exception v2

    .line 134
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 135
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 136
    throw v2
.end method
