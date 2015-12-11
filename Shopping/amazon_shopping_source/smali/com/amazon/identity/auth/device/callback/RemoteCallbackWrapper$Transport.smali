.class Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;
.super Lcom/amazon/identity/auth/device/callback/IRemoteCallback$Stub;
.source "RemoteCallbackWrapper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Transport"
.end annotation


# instance fields
.field private final mCallback:Lcom/amazon/identity/auth/device/api/Callback;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/callback/IRemoteCallback$Stub;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    .line 22
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;)Lcom/amazon/identity/auth/device/api/Callback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    return-object v0
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    if-eqz v0, :cond_0

    .line 50
    new-instance v0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport$2;

    invoke-direct {v0, p0, p1}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport$2;-><init>(Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;Landroid/os/Bundle;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->runOffMainThread(Ljava/lang/Runnable;)V

    .line 60
    :cond_0
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    if-eqz v0, :cond_0

    .line 31
    new-instance v0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport$1;

    invoke-direct {v0, p0, p1}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport$1;-><init>(Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;Landroid/os/Bundle;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->runOffMainThread(Ljava/lang/Runnable;)V

    .line 41
    :cond_0
    return-void
.end method
