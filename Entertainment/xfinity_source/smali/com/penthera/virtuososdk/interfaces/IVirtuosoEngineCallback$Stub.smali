.class public abstract Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;
.super Landroid/os/Binder;
.source "IVirtuosoEngineCallback.java"

# interfaces
.implements Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub$Proxy;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 18
    const-string v0, "com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback"

    invoke-virtual {p0, p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;
    .locals 2
    .param p0, "obj"    # Landroid/os/IBinder;

    .prologue
    .line 26
    if-nez p0, :cond_0

    .line 27
    const/4 v0, 0x0

    .line 33
    :goto_0
    return-object v0

    .line 29
    :cond_0
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 30
    .local v0, "iin":Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    if-eqz v1, :cond_1

    .line 31
    check-cast v0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    goto :goto_0

    .line 33
    :cond_1
    new-instance v0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub$Proxy;

    .end local v0    # "iin":Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_0
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 0

    .prologue
    .line 37
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 5
    .param p1, "code"    # I
    .param p2, "data"    # Landroid/os/Parcel;
    .param p3, "reply"    # Landroid/os/Parcel;
    .param p4, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 41
    sparse-switch p1, :sswitch_data_0

    .line 129
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v3

    :goto_0
    return v3

    .line 45
    :sswitch_0
    const-string v4, "com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback"

    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 50
    :sswitch_1
    const-string v4, "com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 52
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_0

    .line 53
    sget-object v4, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    .line 58
    .local v0, "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    :goto_1
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;->downloadEngineStatusDidChange(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V

    .line 59
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 56
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    :cond_0
    const/4 v0, 0x0

    .restart local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    goto :goto_1

    .line 64
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    :sswitch_2
    const-string v4, "com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 66
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_1

    .line 67
    sget-object v4, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 73
    .local v0, "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_2
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 75
    .local v1, "_arg1":I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 76
    .local v2, "_arg2":I
    invoke-virtual {p0, v0, v1, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;->engineContentInList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V

    .line 77
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 70
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v1    # "_arg1":I
    .end local v2    # "_arg2":I
    :cond_1
    const/4 v0, 0x0

    .restart local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_2

    .line 82
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_3
    const-string v4, "com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 83
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;->engineListChanged()V

    .line 84
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 89
    :sswitch_4
    const-string v4, "com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 91
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 92
    .local v0, "_arg0":I
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;->settingChanged(I)V

    .line 93
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 98
    .end local v0    # "_arg0":I
    :sswitch_5
    const-string v4, "com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 100
    sget-object v4, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 101
    .local v0, "_arg0":[Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;->collectionsChanged([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 102
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 107
    .end local v0    # "_arg0":[Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_6
    const-string v4, "com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 109
    invoke-virtual {p2}, Landroid/os/Parcel;->createStringArray()[Ljava/lang/String;

    move-result-object v0

    .line 110
    .local v0, "_arg0":[Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;->collectionsDeleted([Ljava/lang/String;)V

    .line 111
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 116
    .end local v0    # "_arg0":[Ljava/lang/String;
    :sswitch_7
    const-string v4, "com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 118
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_2

    .line 119
    sget-object v4, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 124
    .local v0, "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_3
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;->itemUpdated(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 125
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 122
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_2
    const/4 v0, 0x0

    .restart local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_3

    .line 41
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_1
        0x2 -> :sswitch_2
        0x3 -> :sswitch_3
        0x4 -> :sswitch_4
        0x5 -> :sswitch_5
        0x6 -> :sswitch_6
        0x7 -> :sswitch_7
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method
