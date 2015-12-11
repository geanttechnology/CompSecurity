.class public abstract Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;
.super Landroid/os/Binder;
.source "PlaybackSdkEventResponse.java"

# interfaces
.implements Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub$Proxy;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 18
    const-string/jumbo v0, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse"

    invoke-virtual {p0, p0, v0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse;
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
    const-string/jumbo v1, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 30
    .local v0, "iin":Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse;

    if-eqz v1, :cond_1

    .line 31
    check-cast v0, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse;

    goto :goto_0

    .line 33
    :cond_1
    new-instance v0, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub$Proxy;

    .end local v0    # "iin":Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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

    .line 105
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v3

    :goto_0
    return v3

    .line 45
    :sswitch_0
    const-string/jumbo v4, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse"

    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 50
    :sswitch_1
    const-string/jumbo v4, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 52
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    move-result-object v0

    .line 53
    .local v0, "_arg0":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    invoke-virtual {p0, v0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;->onStart(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 54
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 59
    .end local v0    # "_arg0":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    :sswitch_2
    const-string/jumbo v4, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 61
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    move-result-object v0

    .line 62
    .restart local v0    # "_arg0":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    invoke-virtual {p0, v0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;->onResume(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 63
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 68
    .end local v0    # "_arg0":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    :sswitch_3
    const-string/jumbo v4, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 70
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    move-result-object v0

    .line 71
    .restart local v0    # "_arg0":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    invoke-virtual {p0, v0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;->onPause(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 72
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 77
    .end local v0    # "_arg0":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    :sswitch_4
    const-string/jumbo v4, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 79
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    move-result-object v0

    .line 80
    .restart local v0    # "_arg0":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    invoke-virtual {p0, v0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;->onStop(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 81
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 86
    .end local v0    # "_arg0":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    :sswitch_5
    const-string/jumbo v4, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 88
    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    .line 90
    .local v0, "_arg0":J
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    move-result-object v2

    .line 91
    .local v2, "_arg1":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;->onSeekStart(JLcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 92
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 97
    .end local v0    # "_arg0":J
    .end local v2    # "_arg1":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    :sswitch_6
    const-string/jumbo v4, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 99
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    move-result-object v0

    .line 100
    .local v0, "_arg0":Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    invoke-virtual {p0, v0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse$Stub;->onSeekEnd(Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;)V

    .line 101
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
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method
