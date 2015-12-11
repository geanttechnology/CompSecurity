.class public abstract Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub;
.super Landroid/os/Binder;
.source "AivPlaybackSdk.java"

# interfaces
.implements Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub$Proxy;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 22
    const-string/jumbo v0, "com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk"

    invoke-virtual {p0, p0, v0}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 23
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;
    .locals 2
    .param p0, "obj"    # Landroid/os/IBinder;

    .prologue
    .line 30
    if-nez p0, :cond_0

    .line 31
    const/4 v0, 0x0

    .line 37
    :goto_0
    return-object v0

    .line 33
    :cond_0
    const-string/jumbo v1, "com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 34
    .local v0, "iin":Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    if-eqz v1, :cond_1

    .line 35
    check-cast v0, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    goto :goto_0

    .line 37
    :cond_1
    new-instance v0, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub$Proxy;

    .end local v0    # "iin":Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_0
.end method


# virtual methods
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
    const/4 v5, 0x0

    const/4 v6, 0x1

    .line 45
    sparse-switch p1, :sswitch_data_0

    .line 121
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v6

    :goto_0
    return v6

    .line 49
    :sswitch_0
    const-string/jumbo v5, "com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk"

    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 54
    :sswitch_1
    const-string/jumbo v5, "com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 56
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 58
    .local v0, "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_0

    .line 59
    sget-object v5, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    .line 65
    .local v2, "_arg1":Landroid/os/Bundle;
    :goto_1
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse;

    move-result-object v3

    .line 66
    .local v3, "_arg2":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse;
    invoke-virtual {p0, v0, v2, v3}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub;->startPlayback(Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse;)V

    .line 67
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 62
    .end local v2    # "_arg1":Landroid/os/Bundle;
    .end local v3    # "_arg2":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse;
    :cond_0
    const/4 v2, 0x0

    .restart local v2    # "_arg1":Landroid/os/Bundle;
    goto :goto_1

    .line 72
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Landroid/os/Bundle;
    :sswitch_2
    const-string/jumbo v5, "com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 73
    invoke-virtual {p0}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub;->terminatePlayback()V

    .line 74
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 79
    :sswitch_3
    const-string/jumbo v5, "com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 81
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 82
    .restart local v0    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub;->prepareVideo(Ljava/lang/String;)V

    .line 83
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 88
    .end local v0    # "_arg0":Ljava/lang/String;
    :sswitch_4
    const-string/jumbo v5, "com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 89
    invoke-virtual {p0}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub;->teardownPreparedVideo()V

    .line 90
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 95
    :sswitch_5
    const-string/jumbo v5, "com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 97
    invoke-virtual {p2}, Landroid/os/Parcel;->createStringArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 99
    .local v1, "_arg0":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 100
    .local v2, "_arg1":Ljava/lang/String;
    invoke-virtual {p0, v1, v2}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub;->whisperCacheContent(Ljava/util/List;Ljava/lang/String;)V

    .line 101
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 106
    .end local v1    # "_arg0":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v2    # "_arg1":Ljava/lang/String;
    :sswitch_6
    const-string/jumbo v7, "com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 107
    invoke-virtual {p0}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub;->isPlaybackSupported()Z

    move-result v4

    .line 108
    .local v4, "_result":Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 109
    if-eqz v4, :cond_1

    move v5, v6

    :cond_1
    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_0

    .line 114
    .end local v4    # "_result":Z
    :sswitch_7
    const-string/jumbo v7, "com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 115
    invoke-virtual {p0}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub;->isPlaybackSustainable()Z

    move-result v4

    .line 116
    .restart local v4    # "_result":Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 117
    if-eqz v4, :cond_2

    move v5, v6

    :cond_2
    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_0

    .line 45
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
