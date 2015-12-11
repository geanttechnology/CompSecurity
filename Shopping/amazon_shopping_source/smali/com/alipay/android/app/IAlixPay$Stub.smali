.class public abstract Lcom/alipay/android/app/IAlixPay$Stub;
.super Landroid/os/Binder;
.source "IAlixPay.java"

# interfaces
.implements Lcom/alipay/android/app/IAlixPay;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/alipay/android/app/IAlixPay;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/alipay/android/app/IAlixPay$Stub$Proxy;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 29
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 30
    const-string/jumbo v0, "com.alipay.android.app.IAlixPay"

    invoke-virtual {p0, p0, v0}, Lcom/alipay/android/app/IAlixPay$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 31
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/alipay/android/app/IAlixPay;
    .locals 2
    .param p0, "obj"    # Landroid/os/IBinder;

    .prologue
    .line 38
    if-nez p0, :cond_0

    .line 39
    const/4 v0, 0x0

    .line 45
    :goto_0
    return-object v0

    .line 41
    :cond_0
    const-string/jumbo v1, "com.alipay.android.app.IAlixPay"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 42
    .local v0, "iin":Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/alipay/android/app/IAlixPay;

    if-eqz v1, :cond_1

    .line 43
    check-cast v0, Lcom/alipay/android/app/IAlixPay;

    goto :goto_0

    .line 45
    :cond_1
    new-instance v0, Lcom/alipay/android/app/IAlixPay$Stub$Proxy;

    .end local v0    # "iin":Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/alipay/android/app/IAlixPay$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_0
.end method


# virtual methods
.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 4
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
    const/4 v2, 0x1

    .line 53
    sparse-switch p1, :sswitch_data_0

    .line 114
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v2

    :goto_0
    return v2

    .line 57
    :sswitch_0
    const-string/jumbo v3, "com.alipay.android.app.IAlixPay"

    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 62
    :sswitch_1
    const-string/jumbo v3, "com.alipay.android.app.IAlixPay"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 64
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 65
    .local v0, "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/alipay/android/app/IAlixPay$Stub;->Pay(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 66
    .local v1, "_result":Ljava/lang/String;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 67
    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 72
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v1    # "_result":Ljava/lang/String;
    :sswitch_2
    const-string/jumbo v3, "com.alipay.android.app.IAlixPay"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 73
    invoke-virtual {p0}, Lcom/alipay/android/app/IAlixPay$Stub;->test()Ljava/lang/String;

    move-result-object v1

    .line 74
    .restart local v1    # "_result":Ljava/lang/String;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 75
    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 80
    .end local v1    # "_result":Ljava/lang/String;
    :sswitch_3
    const-string/jumbo v3, "com.alipay.android.app.IAlixPay"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 82
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v3

    invoke-static {v3}, Lcom/alipay/android/app/IRemoteServiceCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/alipay/android/app/IRemoteServiceCallback;

    move-result-object v0

    .line 83
    .local v0, "_arg0":Lcom/alipay/android/app/IRemoteServiceCallback;
    invoke-virtual {p0, v0}, Lcom/alipay/android/app/IAlixPay$Stub;->registerCallback(Lcom/alipay/android/app/IRemoteServiceCallback;)V

    .line 84
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 89
    .end local v0    # "_arg0":Lcom/alipay/android/app/IRemoteServiceCallback;
    :sswitch_4
    const-string/jumbo v3, "com.alipay.android.app.IAlixPay"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 91
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v3

    invoke-static {v3}, Lcom/alipay/android/app/IRemoteServiceCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/alipay/android/app/IRemoteServiceCallback;

    move-result-object v0

    .line 92
    .restart local v0    # "_arg0":Lcom/alipay/android/app/IRemoteServiceCallback;
    invoke-virtual {p0, v0}, Lcom/alipay/android/app/IAlixPay$Stub;->unregisterCallback(Lcom/alipay/android/app/IRemoteServiceCallback;)V

    .line 93
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 98
    .end local v0    # "_arg0":Lcom/alipay/android/app/IRemoteServiceCallback;
    :sswitch_5
    const-string/jumbo v3, "com.alipay.android.app.IAlixPay"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 100
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 101
    .local v0, "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/alipay/android/app/IAlixPay$Stub;->prePay(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 102
    .restart local v1    # "_result":Ljava/lang/String;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 103
    invoke-virtual {p3, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 108
    .end local v0    # "_arg0":Ljava/lang/String;
    .end local v1    # "_result":Ljava/lang/String;
    :sswitch_6
    const-string/jumbo v3, "com.alipay.android.app.IAlixPay"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 109
    invoke-virtual {p0}, Lcom/alipay/android/app/IAlixPay$Stub;->deployFastConnect()V

    .line 110
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_0

    .line 53
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
