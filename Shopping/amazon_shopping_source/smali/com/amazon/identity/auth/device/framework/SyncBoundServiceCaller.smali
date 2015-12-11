.class public abstract Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;
.super Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;
.source "SyncBoundServiceCaller.java"


# static fields
.field private static final THREAD_POOL:Ljava/util/concurrent/Executor;


# instance fields
.field private final mServiceCaller:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 22
    const/4 v0, 0x4

    const-string/jumbo v1, "MAP-SyncBoundServiceCallerThreadPool"

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->getNamedThreadFactory(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/NamedThreadFactory;

    move-result-object v1

    invoke-static {v0, v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->THREAD_POOL:Ljava/util/concurrent/Executor;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/content/Intent;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "serviceIntent"    # Landroid/content/Intent;
    .param p3, "bindingFlags"    # I

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;-><init>()V

    .line 28
    new-instance v0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1;-><init>(Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;Landroid/content/Context;Landroid/content/Intent;I)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->mServiceCaller:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    .line 51
    return-void
.end method

.method static synthetic access$000()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 20
    sget-object v0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->THREAD_POOL:Ljava/util/concurrent/Executor;

    return-object v0
.end method


# virtual methods
.method protected doneUsingService()V
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->mServiceCaller:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->unbind()V

    .line 74
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->asyncOperationComplete()V

    .line 75
    return-void
.end method

.method protected startAsyncOperation()V
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->mServiceCaller:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->call()Z

    move-result v0

    if-nez v0, :cond_0

    .line 58
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->doneUsingService()V

    .line 60
    :cond_0
    return-void
.end method

.method protected useService(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 0
    .param p1, "name"    # Landroid/content/ComponentName;
    .param p2, "service"    # Landroid/os/IBinder;

    .prologue
    .line 68
    invoke-virtual {p0, p2}, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->useService(Landroid/os/IBinder;)V

    .line 69
    return-void
.end method

.method protected useService(Landroid/os/IBinder;)V
    .locals 0
    .param p1, "service"    # Landroid/os/IBinder;

    .prologue
    .line 64
    return-void
.end method
