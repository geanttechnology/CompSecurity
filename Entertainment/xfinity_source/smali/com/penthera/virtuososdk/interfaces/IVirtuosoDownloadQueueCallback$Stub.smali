.class public abstract Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;
.super Landroid/os/Binder;
.source "IVirtuosoDownloadQueueCallback.java"

# interfaces
.implements Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 18
    const-string v0, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p0, p0, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;
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
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 30
    .local v0, "iin":Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    if-eqz v1, :cond_1

    .line 31
    check-cast v0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    goto :goto_0

    .line 33
    :cond_1
    new-instance v0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;

    .end local v0    # "iin":Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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
    .locals 9
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
    const/4 v0, 0x1

    .line 41
    sparse-switch p1, :sswitch_data_0

    .line 247
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v0

    :goto_0
    return v0

    .line 45
    :sswitch_0
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 50
    :sswitch_1
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 52
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 54
    .local v2, "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 56
    .local v3, "_arg1":I
    invoke-virtual {p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v4

    .line 58
    .local v4, "_arg2":D
    invoke-virtual {p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v6

    .line 60
    .local v6, "_arg3":D
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v8

    .local v8, "_arg4":I
    move-object v1, p0

    .line 61
    invoke-virtual/range {v1 .. v8}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->downloadEngineDidStartDownloadingFileMin(Ljava/lang/String;IDDI)V

    .line 62
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 67
    .end local v2    # "_arg0":Ljava/lang/String;
    .end local v3    # "_arg1":I
    .end local v4    # "_arg2":D
    .end local v6    # "_arg3":D
    .end local v8    # "_arg4":I
    :sswitch_2
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 69
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 71
    .restart local v2    # "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 73
    .restart local v3    # "_arg1":I
    invoke-virtual {p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v4

    .line 75
    .restart local v4    # "_arg2":D
    invoke-virtual {p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v6

    .line 77
    .restart local v6    # "_arg3":D
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v8

    .restart local v8    # "_arg4":I
    move-object v1, p0

    .line 78
    invoke-virtual/range {v1 .. v8}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->downloadEngineProgressUpdatedForFileMin(Ljava/lang/String;IDDI)V

    .line 79
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 84
    .end local v2    # "_arg0":Ljava/lang/String;
    .end local v3    # "_arg1":I
    .end local v4    # "_arg2":D
    .end local v6    # "_arg3":D
    .end local v8    # "_arg4":I
    :sswitch_3
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 86
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 88
    .restart local v2    # "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 90
    .restart local v3    # "_arg1":I
    invoke-virtual {p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v4

    .line 92
    .restart local v4    # "_arg2":D
    invoke-virtual {p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v6

    .line 94
    .restart local v6    # "_arg3":D
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v8

    .restart local v8    # "_arg4":I
    move-object v1, p0

    .line 95
    invoke-virtual/range {v1 .. v8}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->downloadEngineDidFinishDownloadingFileMin(Ljava/lang/String;IDDI)V

    .line 96
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 101
    .end local v2    # "_arg0":Ljava/lang/String;
    .end local v3    # "_arg1":I
    .end local v4    # "_arg2":D
    .end local v6    # "_arg3":D
    .end local v8    # "_arg4":I
    :sswitch_4
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 103
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 105
    .restart local v2    # "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 107
    .restart local v3    # "_arg1":I
    invoke-virtual {p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v4

    .line 109
    .restart local v4    # "_arg2":D
    invoke-virtual {p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v6

    .line 111
    .restart local v6    # "_arg3":D
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v8

    .restart local v8    # "_arg4":I
    move-object v1, p0

    .line 112
    invoke-virtual/range {v1 .. v8}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->downloadEngineFileWithErrorMin(Ljava/lang/String;IDDI)V

    .line 113
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 118
    .end local v2    # "_arg0":Ljava/lang/String;
    .end local v3    # "_arg1":I
    .end local v4    # "_arg2":D
    .end local v6    # "_arg3":D
    .end local v8    # "_arg4":I
    :sswitch_5
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 120
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 122
    .restart local v2    # "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 124
    .restart local v3    # "_arg1":I
    invoke-virtual {p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v4

    .line 126
    .restart local v4    # "_arg2":D
    invoke-virtual {p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v6

    .line 128
    .restart local v6    # "_arg3":D
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v8

    .restart local v8    # "_arg4":I
    move-object v1, p0

    .line 129
    invoke-virtual/range {v1 .. v8}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->fragmentCompleteMin(Ljava/lang/String;IDDI)V

    .line 130
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 135
    .end local v2    # "_arg0":Ljava/lang/String;
    .end local v3    # "_arg1":I
    .end local v4    # "_arg2":D
    .end local v6    # "_arg3":D
    .end local v8    # "_arg4":I
    :sswitch_6
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 137
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_0

    .line 138
    sget-object v1, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v1, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 143
    .local v2, "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_1
    invoke-virtual {p0, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->downloadEngineDidStartDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 144
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 141
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_0
    const/4 v2, 0x0

    .restart local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_1

    .line 149
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_7
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 151
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_1

    .line 152
    sget-object v1, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v1, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 157
    .restart local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_2
    invoke-virtual {p0, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->downloadEngineProgressUpdatedForFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 158
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 155
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_1
    const/4 v2, 0x0

    .restart local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_2

    .line 163
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_8
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 165
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_2

    .line 166
    sget-object v1, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v1, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 171
    .restart local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_3
    invoke-virtual {p0, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->downloadEngineDidFinishDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 172
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 169
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_2
    const/4 v2, 0x0

    .restart local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_3

    .line 177
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_9
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 179
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_3

    .line 180
    sget-object v1, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v1, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 185
    .restart local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_4
    invoke-virtual {p0, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->downloadEngineFileWithError(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 186
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 183
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_3
    const/4 v2, 0x0

    .restart local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_4

    .line 191
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_a
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 193
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_4

    .line 194
    sget-object v1, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v1, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 199
    .restart local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_5
    invoke-virtual {p0, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->fragmentComplete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 200
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 197
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_4
    const/4 v2, 0x0

    .restart local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_5

    .line 205
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_b
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 207
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-eqz v1, :cond_5

    .line 208
    sget-object v1, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v1, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 214
    .restart local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_6
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 216
    .restart local v3    # "_arg1":I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .line 217
    .local v4, "_arg2":I
    invoke-virtual {p0, v2, v3, v4}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->engineContentInQueuedList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V

    .line 218
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 211
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v3    # "_arg1":I
    .end local v4    # "_arg2":I
    :cond_5
    const/4 v2, 0x0

    .restart local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_6

    .line 223
    .end local v2    # "_arg0":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_c
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 224
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->engineDownloadQueueChanged()V

    .line 225
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 230
    :sswitch_d
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 232
    sget-object v1, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 233
    .local v2, "_arg0":[Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-virtual {p0, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->collectionsProgressUpdated([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 234
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

    .line 239
    .end local v2    # "_arg0":[Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :sswitch_e
    const-string v1, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 241
    sget-object v1, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 242
    .restart local v2    # "_arg0":[Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-virtual {p0, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;->collectionsComplete([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 243
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_0

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
        0x8 -> :sswitch_8
        0x9 -> :sswitch_9
        0xa -> :sswitch_a
        0xb -> :sswitch_b
        0xc -> :sswitch_c
        0xd -> :sswitch_d
        0xe -> :sswitch_e
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method
