.class public abstract Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;
.super Landroid/os/Binder;
.source "IVirtuosoService.java"

# interfaces
.implements Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub$Proxy;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 15
    const-string v0, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p0, p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 16
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;
    .locals 2
    .param p0, "obj"    # Landroid/os/IBinder;

    .prologue
    .line 23
    if-nez p0, :cond_0

    .line 24
    const/4 v0, 0x0

    .line 30
    :goto_0
    return-object v0

    .line 26
    :cond_0
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 27
    .local v0, "iin":Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    if-eqz v1, :cond_1

    .line 28
    check-cast v0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    goto :goto_0

    .line 30
    :cond_1
    new-instance v0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub$Proxy;

    .end local v0    # "iin":Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_0
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 0

    .prologue
    .line 34
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 8
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
    const/4 v1, 0x0

    const/4 v6, 0x1

    .line 38
    sparse-switch p1, :sswitch_data_0

    .line 436
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v6

    :goto_0
    return v6

    .line 42
    :sswitch_0
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p3, v7}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 47
    :sswitch_1
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 49
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->getCurrentThroughput(Ljava/lang/String;)D

    move-result-wide v4

    .line 51
    .local v4, "_result":D
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 52
    invoke-virtual {p3, v4, v5}, Landroid/os/Parcel;->writeDouble(D)V

    goto :goto_0

    .line 57
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":D
    :sswitch_2
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 59
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 60
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->getOverallThroughput(Ljava/lang/String;)D

    move-result-wide v4

    .line 61
    .restart local v4    # "_result":D
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 62
    invoke-virtual {p3, v4, v5}, Landroid/os/Parcel;->writeDouble(D)V

    goto :goto_0

    .line 67
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":D
    :sswitch_3
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 69
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v7

    if-eqz v7, :cond_0

    .line 70
    sget-object v7, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v7, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 76
    .local v0, "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_1
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 77
    .local v1, "_arg1":Ljava/lang/String;
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->markComplete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Ljava/lang/String;)V

    .line 78
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 73
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v1    # "_arg1":Ljava/lang/String;
    :cond_0
    const/4 v0, 0x0

    .restart local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_1

    .line 83
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_4
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 85
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v7

    if-eqz v7, :cond_1

    .line 86
    sget-object v7, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v7, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 92
    .restart local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_2
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 94
    .local v1, "_arg1":I
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 95
    .local v2, "_arg2":Ljava/lang/String;
    invoke-virtual {p0, v0, v1, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->markErrored(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;ILjava/lang/String;)V

    .line 96
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 89
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v1    # "_arg1":I
    .end local v2    # "_arg2":Ljava/lang/String;
    :cond_1
    const/4 v0, 0x0

    .restart local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_2

    .line 101
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_5
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 103
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 104
    .local v0, "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->resetErrorQueue(Ljava/lang/String;)V

    .line 105
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 110
    .end local v0    # "_arg0":Ljava/lang/String;
    :sswitch_6
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 112
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v7

    if-eqz v7, :cond_2

    .line 113
    sget-object v7, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v7, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;

    .line 119
    .local v0, "_arg0":Landroid/os/Bundle;
    :goto_3
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 120
    .local v1, "_arg1":Ljava/lang/String;
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->setTestSettings(Landroid/os/Bundle;Ljava/lang/String;)V

    .line 121
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 116
    .end local v0    # "_arg0":Landroid/os/Bundle;
    .end local v1    # "_arg1":Ljava/lang/String;
    :cond_2
    const/4 v0, 0x0

    .restart local v0    # "_arg0":Landroid/os/Bundle;
    goto :goto_3

    .line 126
    .end local v0    # "_arg0":Landroid/os/Bundle;
    :sswitch_7
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 128
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 129
    .local v0, "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->resetTestSettings(Ljava/lang/String;)V

    .line 130
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 135
    .end local v0    # "_arg0":Ljava/lang/String;
    :sswitch_8
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 137
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v7

    if-eqz v7, :cond_3

    .line 138
    sget-object v7, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v7, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;

    .line 144
    .local v0, "_arg0":Landroid/os/Bundle;
    :goto_4
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 146
    .local v1, "_arg1":I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 148
    .local v2, "_arg2":I
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 149
    .local v3, "_arg3":Ljava/lang/String;
    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->configure(Landroid/os/Bundle;IILjava/lang/String;)V

    .line 150
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 141
    .end local v0    # "_arg0":Landroid/os/Bundle;
    .end local v1    # "_arg1":I
    .end local v2    # "_arg2":I
    .end local v3    # "_arg3":Ljava/lang/String;
    :cond_3
    const/4 v0, 0x0

    .restart local v0    # "_arg0":Landroid/os/Bundle;
    goto :goto_4

    .line 155
    .end local v0    # "_arg0":Landroid/os/Bundle;
    :sswitch_9
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 157
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 159
    .local v0, "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v7

    if-eqz v7, :cond_4

    move v1, v6

    .line 160
    .local v1, "_arg1":Z
    :cond_4
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->signalQueueChange(Ljava/lang/String;Z)V

    .line 161
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 166
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v1    # "_arg1":Z
    :sswitch_a
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 168
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 170
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v7

    if-eqz v7, :cond_5

    .line 171
    sget-object v7, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v7, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 176
    .local v1, "_arg1":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_5
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->signalDelete(Ljava/lang/String;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 177
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 174
    .end local v1    # "_arg1":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_5
    const/4 v1, 0x0

    .restart local v1    # "_arg1":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_5

    .line 182
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v1    # "_arg1":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_b
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 184
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 186
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v7

    if-eqz v7, :cond_6

    .line 187
    sget-object v7, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v7, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 192
    .restart local v1    # "_arg1":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_6
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->signalExpire(Ljava/lang/String;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 193
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 190
    .end local v1    # "_arg1":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_6
    const/4 v1, 0x0

    .restart local v1    # "_arg1":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_6

    .line 198
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v1    # "_arg1":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_c
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 200
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 202
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 203
    .local v1, "_arg1":I
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->signalDownloadSettingChange(Ljava/lang/String;I)V

    .line 204
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 209
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v1    # "_arg1":I
    :sswitch_d
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 211
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    invoke-static {v7}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;

    move-result-object v0

    .line 213
    .local v0, "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 214
    .local v1, "_arg1":Ljava/lang/String;
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->registerDownloadCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;Ljava/lang/String;)V

    .line 215
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 220
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;
    .end local v1    # "_arg1":Ljava/lang/String;
    :sswitch_e
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 222
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    invoke-static {v7}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;

    move-result-object v0

    .line 224
    .restart local v0    # "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 225
    .restart local v1    # "_arg1":Ljava/lang/String;
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->unregisterDownloadCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;Ljava/lang/String;)V

    .line 226
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 231
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;
    .end local v1    # "_arg1":Ljava/lang/String;
    :sswitch_f
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 233
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    invoke-static {v7}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    move-result-object v0

    .line 235
    .local v0, "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 236
    .restart local v1    # "_arg1":Ljava/lang/String;
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->registerEngineCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;Ljava/lang/String;)V

    .line 237
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 242
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;
    .end local v1    # "_arg1":Ljava/lang/String;
    :sswitch_10
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 244
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    invoke-static {v7}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    move-result-object v0

    .line 246
    .restart local v0    # "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 247
    .restart local v1    # "_arg1":Ljava/lang/String;
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->unregisterEngineCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;Ljava/lang/String;)V

    .line 248
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 253
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;
    .end local v1    # "_arg1":Ljava/lang/String;
    :sswitch_11
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 255
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    invoke-static {v7}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    move-result-object v0

    .line 257
    .local v0, "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 258
    .restart local v1    # "_arg1":Ljava/lang/String;
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->registerQueueCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;Ljava/lang/String;)V

    .line 259
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 264
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;
    .end local v1    # "_arg1":Ljava/lang/String;
    :sswitch_12
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 266
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    invoke-static {v7}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    move-result-object v0

    .line 268
    .restart local v0    # "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 269
    .restart local v1    # "_arg1":Ljava/lang/String;
    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->unregisterQueueCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;Ljava/lang/String;)V

    .line 270
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 275
    .end local v0    # "_arg0":Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;
    .end local v1    # "_arg1":Ljava/lang/String;
    :sswitch_13
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 277
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 278
    .local v0, "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->pauseDownloads(Ljava/lang/String;)V

    .line 279
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 284
    .end local v0    # "_arg0":Ljava/lang/String;
    :sswitch_14
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 286
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 287
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->resumeDownloads(Ljava/lang/String;)V

    .line 288
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 293
    .end local v0    # "_arg0":Ljava/lang/String;
    :sswitch_15
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 295
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 296
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->queueSize(Ljava/lang/String;)I

    move-result v4

    .line 297
    .local v4, "_result":I
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 298
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_0

    .line 303
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":I
    :sswitch_16
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 305
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 306
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->resetCellularDataQuota(Ljava/lang/String;)V

    .line 307
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 312
    .end local v0    # "_arg0":Ljava/lang/String;
    :sswitch_17
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 314
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 315
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->enabled(Ljava/lang/String;)Z

    move-result v4

    .line 316
    .local v4, "_result":Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 317
    if-eqz v4, :cond_7

    move v1, v6

    :cond_7
    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_0

    .line 322
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":Z
    :sswitch_18
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 324
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 325
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->status(Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v4

    .line 326
    .local v4, "_result":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 327
    if-eqz v4, :cond_8

    .line 328
    invoke-virtual {p3, v6}, Landroid/os/Parcel;->writeInt(I)V

    .line 329
    invoke-interface {v4, p3, v6}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->writeToParcel(Landroid/os/Parcel;I)V

    goto/16 :goto_0

    .line 332
    :cond_8
    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_0

    .line 338
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    :sswitch_19
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 340
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 341
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->powerStatusOK(Ljava/lang/String;)Z

    move-result v4

    .line 342
    .local v4, "_result":Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 343
    if-eqz v4, :cond_9

    move v1, v6

    :cond_9
    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_0

    .line 348
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":Z
    :sswitch_1a
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 350
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 351
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->networkStatusOK(Ljava/lang/String;)Z

    move-result v4

    .line 352
    .restart local v4    # "_result":Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 353
    if-eqz v4, :cond_a

    move v1, v6

    :cond_a
    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_0

    .line 358
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":Z
    :sswitch_1b
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 360
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 361
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->diskStatusOK(Ljava/lang/String;)Z

    move-result v4

    .line 362
    .restart local v4    # "_result":Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 363
    if-eqz v4, :cond_b

    move v1, v6

    :cond_b
    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_0

    .line 368
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":Z
    :sswitch_1c
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 370
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 371
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->cellularDataQuotaOK(Ljava/lang/String;)Z

    move-result v4

    .line 372
    .restart local v4    # "_result":Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 373
    if-eqz v4, :cond_c

    move v1, v6

    :cond_c
    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_0

    .line 378
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":Z
    :sswitch_1d
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 380
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 381
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->utilizedCellularDataQuota(Ljava/lang/String;)D

    move-result-wide v4

    .line 382
    .local v4, "_result":D
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 383
    invoke-virtual {p3, v4, v5}, Landroid/os/Parcel;->writeDouble(D)V

    goto/16 :goto_0

    .line 388
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":D
    :sswitch_1e
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 390
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 391
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->quotaRecordingStart(Ljava/lang/String;)J

    move-result-wide v4

    .line 392
    .local v4, "_result":J
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 393
    invoke-virtual {p3, v4, v5}, Landroid/os/Parcel;->writeLong(J)V

    goto/16 :goto_0

    .line 398
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":J
    :sswitch_1f
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 400
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 401
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->cleanup(Ljava/lang/String;)V

    .line 402
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 407
    .end local v0    # "_arg0":Ljava/lang/String;
    :sswitch_20
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 409
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 410
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->storageUsed(Ljava/lang/String;)D

    move-result-wide v4

    .line 411
    .local v4, "_result":D
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 412
    invoke-virtual {p3, v4, v5}, Landroid/os/Parcel;->writeDouble(D)V

    goto/16 :goto_0

    .line 417
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":D
    :sswitch_21
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 419
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 420
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->totalFileSize(Ljava/lang/String;)D

    move-result-wide v4

    .line 421
    .restart local v4    # "_result":D
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 422
    invoke-virtual {p3, v4, v5}, Landroid/os/Parcel;->writeDouble(D)V

    goto/16 :goto_0

    .line 427
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v4    # "_result":D
    :sswitch_22
    const-string v7, "com.penthera.virtuososdk.interfaces.IVirtuosoService"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 429
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 430
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->allowableStorageRemaining(Ljava/lang/String;)D

    move-result-wide v4

    .line 431
    .restart local v4    # "_result":D
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 432
    invoke-virtual {p3, v4, v5}, Landroid/os/Parcel;->writeDouble(D)V

    goto/16 :goto_0

    .line 38
    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_1
        0x2 -> :sswitch_2
        0x3 -> :sswitch_3
        0x4 -> :sswitch_4
        0x5 -> :sswitch_5
        0x6 -> :sswitch_6
        0x7 -> :sswitch_7
        0x8 -> :sswitch_8
        0x9 -> :sswitch_9
        0xa -> :sswitch_a
        0xb -> :sswitch_b
        0xc -> :sswitch_c
        0xd -> :sswitch_d
        0xe -> :sswitch_e
        0xf -> :sswitch_f
        0x10 -> :sswitch_10
        0x11 -> :sswitch_11
        0x12 -> :sswitch_12
        0x13 -> :sswitch_13
        0x14 -> :sswitch_14
        0x15 -> :sswitch_15
        0x16 -> :sswitch_16
        0x17 -> :sswitch_17
        0x18 -> :sswitch_18
        0x19 -> :sswitch_19
        0x1a -> :sswitch_1a
        0x1b -> :sswitch_1b
        0x1c -> :sswitch_1c
        0x1d -> :sswitch_1d
        0x1e -> :sswitch_1e
        0x1f -> :sswitch_1f
        0x20 -> :sswitch_20
        0x21 -> :sswitch_21
        0x22 -> :sswitch_22
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method
