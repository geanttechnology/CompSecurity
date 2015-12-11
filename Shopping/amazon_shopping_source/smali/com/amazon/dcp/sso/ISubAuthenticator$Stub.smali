.class public abstract Lcom/amazon/dcp/sso/ISubAuthenticator$Stub;
.super Landroid/os/Binder;
.source "ISubAuthenticator.java"

# interfaces
.implements Lcom/amazon/dcp/sso/ISubAuthenticator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/dcp/sso/ISubAuthenticator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/dcp/sso/ISubAuthenticator$Stub$Proxy;
    }
.end annotation


# static fields
.field static final TRANSACTION_getAccountRemovalAllowed:I = 0x2

.field static final TRANSACTION_getAuthToken:I = 0x1

.field static final TRANSACTION_updateAuthToken:I = 0x3


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 17
    const-string/jumbo v0, "com.amazon.dcp.sso.ISubAuthenticator"

    invoke-virtual {p0, p0, v0}, Lcom/amazon/dcp/sso/ISubAuthenticator$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 18
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/amazon/dcp/sso/ISubAuthenticator;
    .locals 2
    .param p0, "obj"    # Landroid/os/IBinder;

    .prologue
    .line 25
    if-nez p0, :cond_0

    .line 26
    const/4 v0, 0x0

    .line 32
    :goto_0
    return-object v0

    .line 28
    :cond_0
    const-string/jumbo v1, "com.amazon.dcp.sso.ISubAuthenticator"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 29
    .local v0, "iin":Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/amazon/dcp/sso/ISubAuthenticator;

    if-eqz v1, :cond_1

    .line 30
    check-cast v0, Lcom/amazon/dcp/sso/ISubAuthenticator;

    goto :goto_0

    .line 32
    :cond_1
    new-instance v0, Lcom/amazon/dcp/sso/ISubAuthenticator$Stub$Proxy;

    .end local v0    # "iin":Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/amazon/dcp/sso/ISubAuthenticator$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_0
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 0

    .prologue
    .line 36
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
    const/4 v7, 0x1

    .line 40
    sparse-switch p1, :sswitch_data_0

    .line 109
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v0

    :goto_0
    return v0

    .line 44
    :sswitch_0
    const-string/jumbo v0, "com.amazon.dcp.sso.ISubAuthenticator"

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    move v0, v7

    .line 45
    goto :goto_0

    .line 49
    :sswitch_1
    const-string/jumbo v0, "com.amazon.dcp.sso.ISubAuthenticator"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 51
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    move-result-object v1

    .line 53
    .local v1, "_arg0":Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 55
    .local v2, "_arg1":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 57
    .local v3, "_arg2":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    .line 59
    .local v4, "_arg3":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_0

    .line 60
    sget-object v0, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/os/Bundle;

    .line 66
    .local v5, "_arg4":Landroid/os/Bundle;
    :goto_1
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    move-result-object v6

    .local v6, "_arg5":Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;
    move-object v0, p0

    .line 67
    invoke-virtual/range {v0 .. v6}, Lcom/amazon/dcp/sso/ISubAuthenticator$Stub;->getAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V

    .line 68
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    move v0, v7

    .line 69
    goto :goto_0

    .line 63
    .end local v5    # "_arg4":Landroid/os/Bundle;
    .end local v6    # "_arg5":Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;
    :cond_0
    const/4 v5, 0x0

    .restart local v5    # "_arg4":Landroid/os/Bundle;
    goto :goto_1

    .line 73
    .end local v1    # "_arg0":Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .end local v2    # "_arg1":Ljava/lang/String;
    .end local v3    # "_arg2":Ljava/lang/String;
    .end local v4    # "_arg3":Ljava/lang/String;
    .end local v5    # "_arg4":Landroid/os/Bundle;
    :sswitch_2
    const-string/jumbo v0, "com.amazon.dcp.sso.ISubAuthenticator"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 75
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    move-result-object v1

    .line 77
    .restart local v1    # "_arg0":Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 79
    .restart local v2    # "_arg1":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 80
    .restart local v3    # "_arg2":Ljava/lang/String;
    invoke-virtual {p0, v1, v2, v3}, Lcom/amazon/dcp/sso/ISubAuthenticator$Stub;->getAccountRemovalAllowed(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    move v0, v7

    .line 82
    goto :goto_0

    .line 86
    .end local v1    # "_arg0":Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .end local v2    # "_arg1":Ljava/lang/String;
    .end local v3    # "_arg2":Ljava/lang/String;
    :sswitch_3
    const-string/jumbo v0, "com.amazon.dcp.sso.ISubAuthenticator"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 88
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    move-result-object v1

    .line 90
    .restart local v1    # "_arg0":Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 92
    .restart local v2    # "_arg1":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 94
    .restart local v3    # "_arg2":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    .line 96
    .restart local v4    # "_arg3":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_1

    .line 97
    sget-object v0, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/os/Bundle;

    .line 103
    .restart local v5    # "_arg4":Landroid/os/Bundle;
    :goto_2
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    move-result-object v6

    .restart local v6    # "_arg5":Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;
    move-object v0, p0

    .line 104
    invoke-virtual/range {v0 .. v6}, Lcom/amazon/dcp/sso/ISubAuthenticator$Stub;->updateAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V

    .line 105
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    move v0, v7

    .line 106
    goto/16 :goto_0

    .line 100
    .end local v5    # "_arg4":Landroid/os/Bundle;
    .end local v6    # "_arg5":Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;
    :cond_1
    const/4 v5, 0x0

    .restart local v5    # "_arg4":Landroid/os/Bundle;
    goto :goto_2

    .line 40
    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_1
        0x2 -> :sswitch_2
        0x3 -> :sswitch_3
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method
