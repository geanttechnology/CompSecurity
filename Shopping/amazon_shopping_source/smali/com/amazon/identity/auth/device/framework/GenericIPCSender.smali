.class public Lcom/amazon/identity/auth/device/framework/GenericIPCSender;
.super Ljava/lang/Object;
.source "GenericIPCSender.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;,
        Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;,
        Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;
    }
.end annotation


# static fields
.field private static final COLUMNS:[Ljava/lang/String;

.field public static final COLUMN_BUNDLE_VALUE:Ljava/lang/String; = "bundle_value"

.field public static final COMMAND_KEY:Ljava/lang/String; = "command"

.field public static final ERROR_CODE_GENERIC_INTERNAL_ERROR:I = 0x1f4

.field public static final GENERIC_IPC_URI:Landroid/net/Uri;

.field public static final KEY_IPC_ERROR_CODE:Ljava/lang/String; = "ipc_error_code_key"

.field public static final KEY_IPC_ERROR_MESSAGE:Ljava/lang/String; = "ipc_error_code_message"

.field private static final METRICS_COMPONENT_NAME:Ljava/lang/String;

.field public static final PARAMETERS_KEY:Ljava/lang/String; = "parameters"

.field public static final SYNC_IPC_TIMEOUT_MS:J = 0x1f4L

.field private static final TAG:Ljava/lang/String;

.field private static sGenericIpcManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager",
            "<",
            "Lcom/amazon/identity/auth/device/callback/IGenericIPC;",
            ">;"
        }
    .end annotation
.end field


# instance fields
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

.field private final mErrorCodeKey:Ljava/lang/String;

.field private final mErrorCodeMap:Landroid/util/SparseIntArray;

.field private final mErrorMessageKey:Ljava/lang/String;

.field private final mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 203
    const-string/jumbo v0, "content://com.amazon.map.generic_ipc"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->GENERIC_IPC_URI:Landroid/net/Uri;

    .line 223
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "bundle_value"

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->COLUMNS:[Ljava/lang/String;

    .line 225
    const-class v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->TAG:Ljava/lang/String;

    .line 227
    const-class v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 242
    invoke-direct {p0, p1, v0, v0, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 243
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "errorCodeKey"    # Ljava/lang/String;
    .param p3, "errorMessageKey"    # Ljava/lang/String;
    .param p4, "internalErrorCode"    # Ljava/lang/Integer;

    .prologue
    .line 250
    new-instance v5, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    invoke-direct {v5, p1}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;-><init>(Landroid/content/Context;)V

    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->getGenericIpcManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    move-result-object v6

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/amazon/identity/auth/device/framework/SecureContentResolver;Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)V

    .line 256
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/amazon/identity/auth/device/framework/SecureContentResolver;Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "errorCodeKey"    # Ljava/lang/String;
    .param p3, "errorMessageKey"    # Ljava/lang/String;
    .param p4, "internalErrorCode"    # Ljava/lang/Integer;
    .param p5, "secureContentResolver"    # Lcom/amazon/identity/auth/device/framework/SecureContentResolver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            "Lcom/amazon/identity/auth/device/framework/SecureContentResolver;",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager",
            "<",
            "Lcom/amazon/identity/auth/device/callback/IGenericIPC;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 264
    .local p6, "boundServiceManager":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<Lcom/amazon/identity/auth/device/callback/IGenericIPC;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 265
    iput-object p5, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    .line 266
    iput-object p6, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mBoundServiceManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    .line 267
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mErrorCodeKey:Ljava/lang/String;

    .line 268
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mErrorMessageKey:Ljava/lang/String;

    .line 270
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mErrorCodeMap:Landroid/util/SparseIntArray;

    .line 271
    if-eqz p4, :cond_0

    .line 273
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mErrorCodeMap:Landroid/util/SparseIntArray;

    const/16 v1, 0x1f4

    invoke-virtual {p4}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->put(II)V

    .line 275
    :cond_0
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/framework/GenericIPCSender;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/GenericIPCSender;
    .param p1, "x1"    # Landroid/os/Bundle;

    .prologue
    .line 32
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mapErrorKeysInBundle(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->COLUMNS:[Ljava/lang/String;

    return-object v0
.end method

.method private static declared-synchronized getGenericIpcManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager",
            "<",
            "Lcom/amazon/identity/auth/device/callback/IGenericIPC;",
            ">;"
        }
    .end annotation

    .prologue
    .line 472
    const-class v2, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    monitor-enter v2

    :try_start_0
    sget-object v1, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->sGenericIpcManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    if-eqz v1, :cond_1

    .line 474
    sget-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->sGenericIpcManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 493
    :cond_0
    :goto_0
    monitor-exit v2

    return-object v0

    .line 477
    :cond_1
    :try_start_1
    new-instance v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$2;

    const-string/jumbo v1, "com.amazon.identity.framework.GenericIPCService"

    sget-object v3, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->MAP_COMMON_THREAD_POOL:Ljava/util/concurrent/Executor;

    invoke-direct {v0, p0, v1, v3}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$2;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/concurrent/Executor;)V

    .line 489
    .local v0, "boundServiceManager":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<Lcom/amazon/identity/auth/device/callback/IGenericIPC;>;"
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v1

    if-nez v1, :cond_0

    .line 491
    sput-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->sGenericIpcManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 472
    .end local v0    # "boundServiceManager":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<Lcom/amazon/identity/auth/device/callback/IGenericIPC;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static getIpcErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "errorCode"    # I
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 439
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 441
    .local v0, "ipcErrorBundle":Landroid/os/Bundle;
    const-string/jumbo v1, "ipc_error_code_key"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 442
    const-string/jumbo v1, "ipc_error_code_message"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 444
    return-object v0
.end method

.method private mapErrorKeysInBundle(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 4
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 449
    if-nez p1, :cond_1

    .line 451
    const/4 p1, 0x0

    .line 467
    .end local p1    # "bundle":Landroid/os/Bundle;
    :cond_0
    :goto_0
    return-object p1

    .line 454
    .restart local p1    # "bundle":Landroid/os/Bundle;
    :cond_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mErrorCodeKey:Ljava/lang/String;

    if-eqz v2, :cond_0

    const-string/jumbo v2, "ipc_error_code_key"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 459
    const-string/jumbo v2, "ipc_error_code_key"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 460
    .local v0, "errorCode":I
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mErrorCodeKey:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mErrorCodeMap:Landroid/util/SparseIntArray;

    invoke-virtual {v3, v0, v0}, Landroid/util/SparseIntArray;->get(II)I

    move-result v3

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 461
    const-string/jumbo v2, "ipc_error_code_key"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 463
    const-string/jumbo v2, "ipc_error_code_message"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 464
    .local v1, "errorMessage":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mErrorMessageKey:Ljava/lang/String;

    invoke-virtual {p1, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 465
    const-string/jumbo v2, "ipc_error_code_message"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static performIpcErrorCallback(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    .locals 1
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 428
    if-nez p0, :cond_0

    .line 435
    :goto_0
    return-void

    .line 433
    :cond_0
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->getIpcErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 434
    .local v0, "ipcErrorBundle":Landroid/os/Bundle;
    invoke-interface {p0, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method private queryCentralStore(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 6
    .param p1, "commandInfo"    # Landroid/os/Bundle;

    .prologue
    .line 357
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->bundleToString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    .line 361
    .local v0, "command":Ljava/lang/String;
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    sget-object v4, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->GENERIC_IPC_URI:Landroid/net/Uri;

    new-instance v5, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;

    invoke-direct {v5, p0, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;-><init>(Lcom/amazon/identity/auth/device/framework/GenericIPCSender;Ljava/lang/String;)V

    invoke-virtual {v3, v4, v5}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->acquireContentProviderClient(Landroid/net/Uri;Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/os/Bundle;
    :try_end_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_0

    .line 413
    :goto_0
    return-object v3

    .line 408
    :catch_0
    move-exception v1

    .line 410
    .local v1, "e":Ljava/util/concurrent/ExecutionException;
    const-string/jumbo v2, "Got an error while calling Generic IPC central store. This can happen in certain edge cases around a crash."

    .line 412
    .local v2, "message":Ljava/lang/String;
    sget-object v3, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->TAG:Ljava/lang/String;

    invoke-static {v3, v2, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 413
    const/16 v3, 0x1f4

    const-string/jumbo v4, "Got an error while calling Generic IPC central store."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->getIpcErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    goto :goto_0
.end method


# virtual methods
.method public call(Ljava/lang/Class;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 11
    .param p2, "parameters"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/amazon/identity/auth/device/framework/IPCCommand;",
            ">;",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/os/Bundle;"
        }
    .end annotation

    .prologue
    .line 295
    .local p1, "ipcCommandClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/amazon/identity/auth/device/framework/IPCCommand;>;"
    const-string/jumbo v0, "ipcCommandClass"

    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 297
    sget-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v9

    .line 302
    .local v9, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    const/4 v8, 0x0

    .line 308
    .local v8, "result":Landroid/os/Bundle;
    :try_start_0
    new-instance v1, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;

    const/4 v0, 0x0

    invoke-direct {v1, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;-><init>(Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;)V

    .line 309
    .local v1, "future":Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;
    iget-object v10, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mBoundServiceManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    new-instance v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mBoundServiceManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    const/4 v5, 0x0

    move-object v2, p2

    move-object v3, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;-><init>(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/lang/Class;Lcom/amazon/identity/auth/device/framework/BoundServiceManager;Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;)V

    invoke-virtual {v10, v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->useServiceIfAlreadyBound(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-eqz v0, :cond_0

    .line 316
    const-wide/16 v2, 0x1f4

    :try_start_1
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;->get(JLjava/util/concurrent/TimeUnit;)Landroid/os/Bundle;
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v8

    .line 332
    :cond_0
    :goto_0
    if-nez v8, :cond_1

    .line 334
    :try_start_2
    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    const-string/jumbo v0, "command"

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v0, "parameters"

    invoke-virtual {v6, v0, p2}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 335
    .local v6, "commandInfo":Landroid/os/Bundle;
    invoke-direct {p0, v6}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->queryCentralStore(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v8

    .line 338
    .end local v6    # "commandInfo":Landroid/os/Bundle;
    :cond_1
    invoke-direct {p0, v8}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mapErrorKeysInBundle(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v8

    .line 340
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mErrorMessageKey:Ljava/lang/String;

    invoke-virtual {v8, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 342
    sget-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " returned error "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mErrorCodeKey:Ljava/lang/String;

    const/4 v4, -0x1

    invoke-virtual {v8, v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mErrorMessageKey:Ljava/lang/String;

    invoke-virtual {v8, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 351
    :cond_2
    invoke-virtual {v9}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    return-object v8

    .line 318
    :catch_0
    move-exception v7

    .line 320
    .local v7, "e":Ljava/lang/InterruptedException;
    :try_start_3
    sget-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "InterruptedException while waiting for "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 321
    const/16 v0, 0x1f4

    const-string/jumbo v2, "Got an error while calling Generic IPC central store."

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->getIpcErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v8

    .line 329
    goto/16 :goto_0

    .line 325
    .end local v7    # "e":Ljava/lang/InterruptedException;
    :catch_1
    move-exception v7

    .line 327
    .local v7, "e":Ljava/util/concurrent/TimeoutException;
    sget-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "TimeoutException while waiting for "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "; will retry over content provider"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_0

    .line 351
    .end local v1    # "future":Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;
    .end local v7    # "e":Ljava/util/concurrent/TimeoutException;
    :catchall_0
    move-exception v0

    invoke-virtual {v9}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v0
.end method

.method public call(Ljava/lang/Class;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 7
    .param p2, "parameters"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/amazon/identity/auth/device/framework/IPCCommand;",
            ">;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "ipcCommandClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/amazon/identity/auth/device/framework/IPCCommand;>;"
    const/4 v5, 0x0

    .line 281
    const-string/jumbo v0, "ipcCommandClass"

    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 282
    const-string/jumbo v0, "callback"

    invoke-static {p3, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 284
    sget-object v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 286
    new-instance v2, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;

    invoke-direct {v2, p0, p3, v5}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;-><init>(Lcom/amazon/identity/auth/device/framework/GenericIPCSender;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;)V

    invoke-static {v0, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v1

    .line 287
    .local v1, "wrappedCallback":Lcom/amazon/identity/auth/device/api/Callback;
    iget-object v6, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mBoundServiceManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    new-instance v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mBoundServiceManager:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    move-object v2, p2

    move-object v3, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$GenericIPCServiceCallback;-><init>(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/lang/Class;Lcom/amazon/identity/auth/device/framework/BoundServiceManager;Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;)V

    invoke-virtual {v6, v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->useService(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V

    .line 291
    return-void
.end method
