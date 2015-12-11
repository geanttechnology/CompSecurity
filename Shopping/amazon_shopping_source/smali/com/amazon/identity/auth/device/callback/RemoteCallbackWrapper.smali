.class public Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;
.super Ljava/lang/Object;
.source "RemoteCallbackWrapper.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;",
            ">;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mCallback:Lcom/amazon/identity/auth/device/callback/IRemoteCallback;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 63
    new-instance v0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$1;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$1;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 78
    const-class v0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 90
    invoke-virtual {p1}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/callback/IRemoteCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/identity/auth/device/callback/IRemoteCallback;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;-><init>(Lcom/amazon/identity/auth/device/callback/IRemoteCallback;)V

    .line 91
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 1
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 85
    new-instance v0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;-><init>(Lcom/amazon/identity/auth/device/callback/IRemoteCallback;)V

    .line 86
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/callback/IRemoteCallback;)V
    .locals 0
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/callback/IRemoteCallback;

    .prologue
    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 95
    iput-object p1, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->mCallback:Lcom/amazon/identity/auth/device/callback/IRemoteCallback;

    .line 96
    return-void
.end method

.method public static toRemoteCallback(Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/callback/IRemoteCallback;
    .locals 1
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 100
    new-instance v0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 173
    const/4 v0, 0x0

    return v0
.end method

.method public onError(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 137
    const/4 v1, 0x0

    .line 138
    .local v1, "success":Z
    const/4 v2, 0x0

    .line 139
    .local v2, "tries":I
    :goto_0
    if-nez v1, :cond_1

    const/4 v3, 0x1

    if-gt v2, v3, :cond_1

    .line 143
    add-int/lit8 v2, v2, 0x1

    .line 144
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->mCallback:Lcom/amazon/identity/auth/device/callback/IRemoteCallback;

    if-eqz v3, :cond_0

    .line 146
    iget-object v3, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->mCallback:Lcom/amazon/identity/auth/device/callback/IRemoteCallback;

    invoke-interface {v3, p1}, Lcom/amazon/identity/auth/device/callback/IRemoteCallback;->onError(Landroid/os/Bundle;)V

    .line 152
    :goto_1
    const/4 v1, 0x1

    goto :goto_0

    .line 150
    :cond_0
    sget-object v3, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Not calling onError because mCallback is null"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_1

    .line 154
    :catch_0
    move-exception v0

    .line 156
    .local v0, "e":Landroid/os/RemoteException;
    sget-object v3, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "onError callback failed"

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 158
    .end local v0    # "e":Landroid/os/RemoteException;
    :catch_1
    move-exception v0

    .line 160
    .local v0, "e":Ljava/lang/NullPointerException;
    sget-object v3, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "NullPointerException onError"

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 163
    .end local v0    # "e":Ljava/lang/NullPointerException;
    :cond_1
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 106
    const/4 v1, 0x0

    .line 107
    .local v1, "success":Z
    const/4 v2, 0x0

    .line 108
    .local v2, "tries":I
    :goto_0
    if-nez v1, :cond_1

    const/4 v3, 0x1

    if-gt v2, v3, :cond_1

    .line 112
    add-int/lit8 v2, v2, 0x1

    .line 113
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->mCallback:Lcom/amazon/identity/auth/device/callback/IRemoteCallback;

    if-eqz v3, :cond_0

    .line 115
    iget-object v3, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->mCallback:Lcom/amazon/identity/auth/device/callback/IRemoteCallback;

    invoke-interface {v3, p1}, Lcom/amazon/identity/auth/device/callback/IRemoteCallback;->onSuccess(Landroid/os/Bundle;)V

    .line 121
    :goto_1
    const/4 v1, 0x1

    goto :goto_0

    .line 119
    :cond_0
    sget-object v3, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Not calling onSuccess because mCallback is null"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_1

    .line 123
    :catch_0
    move-exception v0

    .line 125
    .local v0, "e":Landroid/os/RemoteException;
    sget-object v3, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "onSuccess callback failed"

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 127
    .end local v0    # "e":Landroid/os/RemoteException;
    :catch_1
    move-exception v0

    .line 129
    .local v0, "e":Ljava/lang/NullPointerException;
    sget-object v3, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "NullPointerException onSuccess"

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 132
    .end local v0    # "e":Ljava/lang/NullPointerException;
    :cond_1
    return-void
.end method

.method public toRemoteCallback()Lcom/amazon/identity/auth/device/callback/IRemoteCallback;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->mCallback:Lcom/amazon/identity/auth/device/callback/IRemoteCallback;

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "parcel"    # Landroid/os/Parcel;
    .param p2, "flag"    # I

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->mCallback:Lcom/amazon/identity/auth/device/callback/IRemoteCallback;

    if-eqz v0, :cond_0

    .line 181
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->mCallback:Lcom/amazon/identity/auth/device/callback/IRemoteCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/device/callback/IRemoteCallback;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    .line 183
    :cond_0
    return-void
.end method
