.class public abstract Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub;
.super Landroid/os/Binder;
.source "IRequestAuthenticationMethod.java"

# interfaces
.implements Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub$Proxy;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 15
    const-string/jumbo v0, "com.amazon.dcp.sso.IRequestAuthenticationMethod"

    invoke-virtual {p0, p0, v0}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 16
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;
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
    const-string/jumbo v1, "com.amazon.dcp.sso.IRequestAuthenticationMethod"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 27
    .local v0, "iin":Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;

    if-eqz v1, :cond_1

    .line 28
    check-cast v0, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;

    goto :goto_0

    .line 30
    :cond_1
    new-instance v0, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub$Proxy;

    .end local v0    # "iin":Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_0
.end method


# virtual methods
.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 10
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
    .line 38
    sparse-switch p1, :sswitch_data_0

    .line 176
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v0

    :goto_0
    return v0

    .line 42
    :sswitch_0
    const-string/jumbo v0, "com.amazon.dcp.sso.IRequestAuthenticationMethod"

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 43
    const/4 v0, 0x1

    goto :goto_0

    .line 47
    :sswitch_1
    const-string/jumbo v0, "com.amazon.dcp.sso.IRequestAuthenticationMethod"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 49
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 51
    .local v1, "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 53
    .local v2, "_arg1":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 55
    .local v3, "_arg2":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_0

    .line 56
    sget-object v0, Landroid/net/Uri;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/net/Uri;

    .line 62
    .local v4, "_arg3":Landroid/net/Uri;
    :goto_1
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    .line 64
    .local v5, "_arg4":Ljava/lang/String;
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v9

    .line 65
    .local v9, "cl":Ljava/lang/ClassLoader;
    invoke-virtual {p2, v9}, Landroid/os/Parcel;->readHashMap(Ljava/lang/ClassLoader;)Ljava/util/HashMap;

    move-result-object v6

    .line 67
    .local v6, "_arg5":Ljava/util/Map;
    invoke-virtual {p2}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v7

    .local v7, "_arg6":[B
    move-object v0, p0

    .line 68
    invoke-virtual/range {v0 .. v7}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub;->getAuthenticationParametersForRequest(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[B)Lcom/amazon/dcp/sso/ReturnValueOrError;

    move-result-object v8

    .line 69
    .local v8, "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 70
    if-eqz v8, :cond_1

    .line 71
    const/4 v0, 0x1

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 72
    const/4 v0, 0x1

    invoke-virtual {v8, p3, v0}, Lcom/amazon/dcp/sso/ReturnValueOrError;->writeToParcel(Landroid/os/Parcel;I)V

    .line 77
    :goto_2
    const/4 v0, 0x1

    goto :goto_0

    .line 59
    .end local v4    # "_arg3":Landroid/net/Uri;
    .end local v5    # "_arg4":Ljava/lang/String;
    .end local v6    # "_arg5":Ljava/util/Map;
    .end local v7    # "_arg6":[B
    .end local v8    # "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    .end local v9    # "cl":Ljava/lang/ClassLoader;
    :cond_0
    const/4 v4, 0x0

    .restart local v4    # "_arg3":Landroid/net/Uri;
    goto :goto_1

    .line 75
    .restart local v5    # "_arg4":Ljava/lang/String;
    .restart local v6    # "_arg5":Ljava/util/Map;
    .restart local v7    # "_arg6":[B
    .restart local v8    # "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    .restart local v9    # "cl":Ljava/lang/ClassLoader;
    :cond_1
    const/4 v0, 0x0

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_2

    .line 81
    .end local v1    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Ljava/lang/String;
    .end local v3    # "_arg2":Ljava/lang/String;
    .end local v4    # "_arg3":Landroid/net/Uri;
    .end local v5    # "_arg4":Ljava/lang/String;
    .end local v6    # "_arg5":Ljava/util/Map;
    .end local v7    # "_arg6":[B
    .end local v8    # "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    .end local v9    # "cl":Ljava/lang/ClassLoader;
    :sswitch_2
    const-string/jumbo v0, "com.amazon.dcp.sso.IRequestAuthenticationMethod"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 83
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 85
    .restart local v1    # "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 87
    .restart local v2    # "_arg1":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 89
    .restart local v3    # "_arg2":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v4

    .line 90
    .local v4, "_arg3":[B
    invoke-virtual {p0, v1, v2, v3, v4}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub;->signCorpus(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)Lcom/amazon/dcp/sso/ReturnValueOrError;

    move-result-object v8

    .line 91
    .restart local v8    # "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 92
    if-eqz v8, :cond_2

    .line 93
    const/4 v0, 0x1

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 94
    const/4 v0, 0x1

    invoke-virtual {v8, p3, v0}, Lcom/amazon/dcp/sso/ReturnValueOrError;->writeToParcel(Landroid/os/Parcel;I)V

    .line 99
    :goto_3
    const/4 v0, 0x1

    goto :goto_0

    .line 97
    :cond_2
    const/4 v0, 0x0

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_3

    .line 103
    .end local v1    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Ljava/lang/String;
    .end local v3    # "_arg2":Ljava/lang/String;
    .end local v4    # "_arg3":[B
    .end local v8    # "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    :sswitch_3
    const-string/jumbo v0, "com.amazon.dcp.sso.IRequestAuthenticationMethod"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 105
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 107
    .restart local v1    # "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 108
    .restart local v2    # "_arg1":Ljava/lang/String;
    invoke-virtual {p0, v1, v2}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub;->getAdpToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 109
    .local v8, "_result":Ljava/lang/String;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 110
    invoke-virtual {p3, v8}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 111
    const/4 v0, 0x1

    goto/16 :goto_0

    .line 115
    .end local v1    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Ljava/lang/String;
    .end local v8    # "_result":Ljava/lang/String;
    :sswitch_4
    const-string/jumbo v0, "com.amazon.dcp.sso.IRequestAuthenticationMethod"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 117
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 119
    .restart local v1    # "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 121
    .restart local v2    # "_arg1":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_3

    .line 122
    sget-object v0, Landroid/net/Uri;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/net/Uri;

    .line 128
    .local v3, "_arg2":Landroid/net/Uri;
    :goto_4
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    .line 130
    .local v4, "_arg3":Ljava/lang/String;
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v9

    .line 131
    .restart local v9    # "cl":Ljava/lang/ClassLoader;
    invoke-virtual {p2, v9}, Landroid/os/Parcel;->readHashMap(Ljava/lang/ClassLoader;)Ljava/util/HashMap;

    move-result-object v5

    .line 133
    .local v5, "_arg4":Ljava/util/Map;
    invoke-virtual {p2}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v6

    .local v6, "_arg5":[B
    move-object v0, p0

    .line 134
    invoke-virtual/range {v0 .. v6}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub;->getAuthenticationParametersForRequestByDirectedId(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[B)Lcom/amazon/dcp/sso/ReturnValueOrError;

    move-result-object v8

    .line 135
    .local v8, "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 136
    if-eqz v8, :cond_4

    .line 137
    const/4 v0, 0x1

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 138
    const/4 v0, 0x1

    invoke-virtual {v8, p3, v0}, Lcom/amazon/dcp/sso/ReturnValueOrError;->writeToParcel(Landroid/os/Parcel;I)V

    .line 143
    :goto_5
    const/4 v0, 0x1

    goto/16 :goto_0

    .line 125
    .end local v3    # "_arg2":Landroid/net/Uri;
    .end local v4    # "_arg3":Ljava/lang/String;
    .end local v5    # "_arg4":Ljava/util/Map;
    .end local v6    # "_arg5":[B
    .end local v8    # "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    .end local v9    # "cl":Ljava/lang/ClassLoader;
    :cond_3
    const/4 v3, 0x0

    .restart local v3    # "_arg2":Landroid/net/Uri;
    goto :goto_4

    .line 141
    .restart local v4    # "_arg3":Ljava/lang/String;
    .restart local v5    # "_arg4":Ljava/util/Map;
    .restart local v6    # "_arg5":[B
    .restart local v8    # "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    .restart local v9    # "cl":Ljava/lang/ClassLoader;
    :cond_4
    const/4 v0, 0x0

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_5

    .line 147
    .end local v1    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Ljava/lang/String;
    .end local v3    # "_arg2":Landroid/net/Uri;
    .end local v4    # "_arg3":Ljava/lang/String;
    .end local v5    # "_arg4":Ljava/util/Map;
    .end local v6    # "_arg5":[B
    .end local v8    # "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    .end local v9    # "cl":Ljava/lang/ClassLoader;
    :sswitch_5
    const-string/jumbo v0, "com.amazon.dcp.sso.IRequestAuthenticationMethod"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 149
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 151
    .restart local v1    # "_arg0":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 153
    .restart local v2    # "_arg1":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v3

    .line 154
    .local v3, "_arg2":[B
    invoke-virtual {p0, v1, v2, v3}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub;->signCorpusByDirectedId(Ljava/lang/String;Ljava/lang/String;[B)Lcom/amazon/dcp/sso/ReturnValueOrError;

    move-result-object v8

    .line 155
    .restart local v8    # "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 156
    if-eqz v8, :cond_5

    .line 157
    const/4 v0, 0x1

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 158
    const/4 v0, 0x1

    invoke-virtual {v8, p3, v0}, Lcom/amazon/dcp/sso/ReturnValueOrError;->writeToParcel(Landroid/os/Parcel;I)V

    .line 163
    :goto_6
    const/4 v0, 0x1

    goto/16 :goto_0

    .line 161
    :cond_5
    const/4 v0, 0x0

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_6

    .line 167
    .end local v1    # "_arg0":Ljava/lang/String;
    .end local v2    # "_arg1":Ljava/lang/String;
    .end local v3    # "_arg2":[B
    .end local v8    # "_result":Lcom/amazon/dcp/sso/ReturnValueOrError;
    :sswitch_6
    const-string/jumbo v0, "com.amazon.dcp.sso.IRequestAuthenticationMethod"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 169
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 170
    .restart local v1    # "_arg0":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub;->getAdpTokenByDirectedId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 171
    .local v8, "_result":Ljava/lang/String;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 172
    invoke-virtual {p3, v8}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 173
    const/4 v0, 0x1

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
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method
