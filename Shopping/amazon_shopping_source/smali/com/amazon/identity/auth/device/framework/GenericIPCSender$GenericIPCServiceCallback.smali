.class final Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;
.super Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;
.source "GenericIPCSender.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/GenericIPCSender;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "GenericIPCServiceCallback"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback",
        "<",
        "Lcom/amazon/identity/auth/device/callback/IGenericIPC;",
        ">;",
        "Lcom/amazon/identity/auth/device/api/Callback;"
    }
.end annotation


# instance fields
.field private mAlreadyCalledBack:Z

.field private final mBoundServiceManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager",
            "<",
            "Lcom/amazon/identity/auth/device/callback/IGenericIPC;",
            ">;"
        }
    .end annotation
.end field

.field private final mCallback:Lcom/amazon/identity/auth/device/api/Callback;

.field private final mIpcCommandClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+",
            "Lcom/amazon/identity/auth/device/framework/IPCCommand;",
            ">;"
        }
    .end annotation
.end field

.field private final mParameters:Landroid/os/Bundle;


# direct methods
.method private constructor <init>(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/lang/Class;Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)V
    .locals 1
    .param p1, "wrappedCallback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "parameters"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Landroid/os/Bundle;",
            "Ljava/lang/Class",
            "<+",
            "Lcom/amazon/identity/auth/device/framework/IPCCommand;",
            ">;",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager",
            "<",
            "Lcom/amazon/identity/auth/device/callback/IGenericIPC;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 46
    .local p3, "ipcCommandClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/amazon/identity/auth/device/framework/IPCCommand;>;"
    .local p4, "boundServiceManager":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<Lcom/amazon/identity/auth/device/callback/IGenericIPC;>;"
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    .line 48
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mParameters:Landroid/os/Bundle;

    .line 49
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mIpcCommandClass:Ljava/lang/Class;

    .line 50
    iput-object p4, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mBoundServiceManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    .line 51
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mAlreadyCalledBack:Z

    .line 52
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/lang/Class;Lcom/amazon/identity/auth/device/framework/BoundServiceManager;Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "x1"    # Landroid/os/Bundle;
    .param p3, "x2"    # Ljava/lang/Class;
    .param p4, "x3"    # Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
    .param p5, "x4"    # Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;-><init>(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/lang/Class;Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)V

    return-void
.end method


# virtual methods
.method public onError()V
    .locals 2

    .prologue
    .line 65
    const/16 v0, 0x1f4

    const-string/jumbo v1, "Got an error while calling Generic IPC central store."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->getIpcErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->onError(Landroid/os/Bundle;)V

    .line 67
    return-void
.end method

.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 88
    monitor-enter p0

    .line 90
    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mAlreadyCalledBack:Z

    if-eqz v0, :cond_0

    .line 92
    monitor-exit p0

    .line 99
    :goto_0
    return-void

    .line 95
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mAlreadyCalledBack:Z

    .line 96
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 97
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mBoundServiceManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    invoke-virtual {v0, p0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->doneUsingService(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V

    .line 98
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    .line 96
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 72
    monitor-enter p0

    .line 74
    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mAlreadyCalledBack:Z

    if-eqz v0, :cond_0

    .line 76
    monitor-exit p0

    .line 83
    :goto_0
    return-void

    .line 79
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mAlreadyCalledBack:Z

    .line 80
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 81
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mBoundServiceManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    invoke-virtual {v0, p0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->doneUsingService(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V

    .line 82
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0

    .line 80
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public useService(Lcom/amazon/identity/auth/device/callback/IGenericIPC;)V
    .locals 3
    .param p1, "genericIpc"    # Lcom/amazon/identity/auth/device/callback/IGenericIPC;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 57
    invoke-static {p0}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->toRemoteCallback(Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/callback/IRemoteCallback;

    move-result-object v0

    .line 58
    .local v0, "remoteCallback":Lcom/amazon/identity/auth/device/callback/IRemoteCallback;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mBoundServiceManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    invoke-virtual {v1, p0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->startUsingServiceAsynchronously(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V

    .line 59
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mIpcCommandClass:Ljava/lang/Class;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->mParameters:Landroid/os/Bundle;

    invoke-interface {p1, v1, v2, v0}, Lcom/amazon/identity/auth/device/callback/IGenericIPC;->call(Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/callback/IRemoteCallback;)V

    .line 60
    return-void
.end method

.method public bridge synthetic useService(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 34
    check-cast p1, Lcom/amazon/identity/auth/device/callback/IGenericIPC;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;->useService(Lcom/amazon/identity/auth/device/callback/IGenericIPC;)V

    return-void
.end method
