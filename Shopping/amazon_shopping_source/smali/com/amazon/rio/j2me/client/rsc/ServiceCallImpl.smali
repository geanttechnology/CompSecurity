.class public Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;
.super Ljava/lang/Object;
.source "ServiceCallImpl.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/rsc/ServiceCall;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;
    }
.end annotation


# static fields
.field private static _nextId:I

.field private static final dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;

.field private static final logger:Lcom/amazon/rio/j2me/client/util/Logger;

.field private static sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

.field private static final workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;


# instance fields
.field private final allowCookies:Z

.field private final applicationID:Ljava/lang/String;

.field private final clientRequestReply:Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

.field private final cookieJarKey:Ljava/lang/String;

.field private endTime:J

.field private error:Ljava/lang/Exception;

.field private final id:I

.field private final method:Ljava/lang/String;

.field private final secure:Z

.field private final secureCookieJarKey:Ljava/lang/String;

.field private final serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

.field private final serviceCallInvoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

.field private final serviceName:Ljava/lang/String;

.field private startTime:J

.field private state:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 23
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    sput-object v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    .line 25
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    const-class v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->getLogger(Ljava/lang/Class;)Lcom/amazon/rio/j2me/client/util/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->logger:Lcom/amazon/rio/j2me/client/util/Logger;

    .line 27
    invoke-static {}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->getInstance()Lcom/amazon/rio/j2me/client/util/WorkerPool;

    move-result-object v0

    sput-object v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;

    .line 32
    const/4 v0, 0x0

    sput v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->_nextId:I

    return-void
.end method

.method constructor <init>(Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/trans/IServiceConnection;Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)V
    .locals 9
    .param p1, "serviceCallInvoker"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;
    .param p2, "serviceName"    # Ljava/lang/String;
    .param p3, "method"    # Ljava/lang/String;
    .param p4, "applicationID"    # Ljava/lang/String;
    .param p5, "secure"    # Z
    .param p6, "allowCookies"    # Z
    .param p7, "serverConnection"    # Lcom/amazon/rio/j2me/client/trans/IServiceConnection;
    .param p8, "clientRequestReply"    # Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    .prologue
    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    const-wide/16 v5, -0x1

    iput-wide v5, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->startTime:J

    .line 36
    const-wide/16 v5, -0x1

    iput-wide v5, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->endTime:J

    .line 45
    sget-object v5, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->NOT_STARTED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    iput-object v5, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->state:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    .line 61
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serviceCallInvoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    .line 62
    iput-object p2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serviceName:Ljava/lang/String;

    .line 63
    iput-object p3, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->method:Ljava/lang/String;

    .line 65
    const-string/jumbo v5, "home_v38"

    invoke-virtual {v5, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    const/4 v5, 0x0

    :goto_0
    iput-boolean v5, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->secure:Z

    .line 66
    iput-boolean p6, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->allowCookies:Z

    .line 67
    move-object/from16 v0, p7

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    .line 68
    move-object/from16 v0, p8

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->clientRequestReply:Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    .line 69
    invoke-static {}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getId()I

    move-result v5

    iput v5, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->id:I

    .line 72
    if-eqz p4, :cond_0

    .line 73
    invoke-interface/range {p7 .. p7}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->getUrl()Ljava/lang/String;

    move-result-object v5

    const/16 v6, 0x3b

    invoke-virtual {v5, v6}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .line 74
    .local v1, "index":I
    if-ltz v1, :cond_0

    .line 75
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ";connParams="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface/range {p7 .. p7}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->getUrl()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v6

    const/16 v7, 0x3b

    const/16 v8, 0x2f

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v6

    const/16 v7, 0x3d

    const/16 v8, 0x40

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p4

    .line 80
    .end local v1    # "index":I
    :cond_0
    sget-object v5, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    if-eqz v5, :cond_1

    sget-object v5, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v5

    sget-object v6, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->COMPLETED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    if-ne v5, v6, :cond_1

    .line 81
    sget-object v5, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->getEndTime()J

    move-result-wide v5

    sget-object v7, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->getStartTime()J

    move-result-wide v7

    sub-long v2, v5, v7

    .line 82
    .local v2, "ttgMsec":J
    const-wide/16 v5, 0x0

    cmp-long v5, v2, v5

    if-lez v5, :cond_1

    .line 83
    long-to-float v5, v2

    const/high16 v6, 0x447a0000    # 1000.0f

    div-float v4, v5, v6

    .line 84
    .local v4, "ttgSec":F
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ";ttg="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->getMethod()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p4

    .line 89
    .end local v2    # "ttgMsec":J
    .end local v4    # "ttgSec":F
    :cond_1
    sget-object v5, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    if-eqz v5, :cond_2

    sget-object v5, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->getErrorString()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 90
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ";prevCallFailed="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->getMethod()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->getErrorString()Ljava/lang/String;

    move-result-object v6

    const/16 v7, 0x3b

    const/16 v8, 0x5f

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v6

    const/16 v7, 0x3d

    const/16 v8, 0x20

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p4

    .line 93
    :cond_2
    iput-object p4, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->applicationID:Ljava/lang/String;

    .line 95
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "cookieJar."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->cookieJarKey:Ljava/lang/String;

    .line 96
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "secureCookieJar."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->secureCookieJarKey:Ljava/lang/String;

    .line 97
    return-void

    .line 65
    :cond_3
    const/4 v5, 0x1

    goto/16 :goto_0
.end method

.method static synthetic access$000(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;)Lcom/amazon/rio/j2me/client/trans/IServiceConnection;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

    .prologue
    .line 22
    iget v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->id:I

    return v0
.end method

.method static synthetic access$200()Lcom/amazon/rio/j2me/client/util/Logger;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->logger:Lcom/amazon/rio/j2me/client/util/Logger;

    return-object v0
.end method

.method static synthetic access$300()Lcom/amazon/rio/j2me/client/util/WorkerPool;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;

    return-object v0
.end method

.method private static declared-synchronized getId()I
    .locals 3

    .prologue
    .line 33
    const-class v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

    monitor-enter v1

    :try_start_0
    sget v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->_nextId:I

    add-int/lit8 v2, v0, 0x1

    sput v2, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->_nextId:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private declared-synchronized setState(Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;)V
    .locals 1
    .param p1, "state"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    .prologue
    .line 292
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->state:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    .line 293
    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 294
    monitor-exit p0

    return-void

    .line 292
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public allowCookies()Z
    .locals 1

    .prologue
    .line 285
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->allowCookies:Z

    return v0
.end method

.method public cancel()V
    .locals 6

    .prologue
    .line 247
    monitor-enter p0

    .line 248
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->isTerminalState()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 252
    monitor-exit p0

    .line 277
    :goto_0
    return-void

    .line 255
    :cond_0
    sget-object v3, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->CANCELLED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    invoke-direct {p0, v3}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->setState(Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;)V

    .line 256
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 261
    :try_start_1
    sget-object v3, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->acquireWorker()Lcom/amazon/rio/j2me/client/util/Worker;

    move-result-object v2

    .line 262
    .local v2, "worker":Lcom/amazon/rio/j2me/client/util/Worker;
    new-instance v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$1;

    invoke-direct {v1, p0, v2}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$1;-><init>(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;Lcom/amazon/rio/j2me/client/util/Worker;)V

    .line 272
    .local v1, "task":Ljava/lang/Runnable;
    const-string/jumbo v3, "serverConnection.cancel()"

    invoke-virtual {v2, v3, v1}, Lcom/amazon/rio/j2me/client/util/Worker;->execute(Ljava/lang/String;Ljava/lang/Runnable;)V
    :try_end_1
    .catch Lcom/amazon/rio/j2me/client/util/LifecycleException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 274
    .end local v1    # "task":Ljava/lang/Runnable;
    .end local v2    # "worker":Lcom/amazon/rio/j2me/client/util/Worker;
    :catch_0
    move-exception v0

    .line 275
    .local v0, "le":Lcom/amazon/rio/j2me/client/util/LifecycleException;
    new-instance v3, Ljava/lang/RuntimeException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "unable to obtain worker to cancel connection: exp= "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/util/LifecycleException;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 256
    .end local v0    # "le":Lcom/amazon/rio/j2me/client/util/LifecycleException;
    :catchall_0
    move-exception v3

    :try_start_2
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3
.end method

.method public getApplicationID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 284
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->applicationID:Ljava/lang/String;

    return-object v0
.end method

.method public getClientRequestReply()Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;
    .locals 1

    .prologue
    .line 287
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->clientRequestReply:Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    return-object v0
.end method

.method public getEndTime()J
    .locals 2

    .prologue
    .line 280
    iget-wide v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->endTime:J

    return-wide v0
.end method

.method public getError()Ljava/lang/Exception;
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->error:Ljava/lang/Exception;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 283
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->method:Ljava/lang/String;

    return-object v0
.end method

.method public getServiceCallInvoker()Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;
    .locals 1

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serviceCallInvoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    return-object v0
.end method

.method public getServiceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 282
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serviceName:Ljava/lang/String;

    return-object v0
.end method

.method public getStartTime()J
    .locals 2

    .prologue
    .line 279
    iget-wide v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->startTime:J

    return-wide v0
.end method

.method public declared-synchronized getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;
    .locals 1

    .prologue
    .line 289
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->state:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method invoke()V
    .locals 12

    .prologue
    .line 100
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->startTime:J

    .line 105
    :try_start_0
    monitor-enter p0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 106
    :try_start_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v1

    sget-object v2, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->NOT_STARTED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    if-eq v1, v2, :cond_1

    .line 107
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "ServiceCallImpl expected to be in "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->NOT_STARTED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " state: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 111
    :catchall_0
    move-exception v1

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v1
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 215
    :catch_0
    move-exception v8

    .line 216
    .local v8, "e":Ljava/lang/Exception;
    :try_start_3
    monitor-enter p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 217
    :try_start_4
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v1

    sget-object v2, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->CANCELLED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    if-eq v1, v2, :cond_0

    .line 218
    sget-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->ERROR:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    invoke-direct {p0, v1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->setState(Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;)V

    .line 220
    :cond_0
    monitor-exit p0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_6

    .line 222
    :try_start_5
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v1

    sget-object v2, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->CANCELLED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    if-ne v1, v2, :cond_d

    .line 223
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->clientRequestReply:Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    invoke-interface {v1, p0}, Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;->cancelled(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 239
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->cancel()V

    .line 241
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->endTime:J

    .line 242
    new-instance v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-direct {v1, p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;-><init>(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;)V

    sput-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    .line 244
    .end local v8    # "e":Ljava/lang/Exception;
    :goto_0
    return-void

    .line 110
    :cond_1
    :try_start_6
    sget-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->EXECUTING:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    invoke-direct {p0, v1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->setState(Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;)V

    .line 111
    monitor-exit p0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 113
    const/4 v1, 0x2

    :try_start_7
    new-array v6, v1, [[B

    .line 115
    .local v6, "data":[[B
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 117
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->clientRequestReply:Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;->produceRequestData(Ljava/io/OutputStream;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 119
    const/4 v1, 0x1

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v2

    aput-object v2, v6, v1

    .line 122
    const/4 v4, 0x0

    .line 123
    .local v4, "cookieJar":[B
    const/4 v5, 0x0

    .line 124
    .local v5, "secureCookieJar":[B
    iget-boolean v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->allowCookies:Z

    if-eqz v1, :cond_2

    .line 125
    sget-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->cookieJarKey:Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getByteArray(Ljava/lang/String;)[B

    move-result-object v4

    .line 126
    iget-boolean v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->secure:Z

    if-eqz v1, :cond_2

    .line 127
    sget-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->secureCookieJarKey:Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getByteArray(Ljava/lang/String;)[B

    move-result-object v5

    .line 131
    :cond_2
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 132
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getServiceName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getMethod()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->applicationID:Ljava/lang/String;

    invoke-static/range {v0 .. v5}, Lcom/amazon/rio/j2me/client/rsc/RscRequestHeaderWriter;->writeHeader(Ljava/io/OutputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B[B)I

    .line 133
    const/4 v1, 0x0

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v2

    aput-object v2, v6, v1

    .line 135
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->isTerminalState()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 140
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v1

    sget-object v2, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->CANCELLED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    if-ne v1, v2, :cond_3

    .line 141
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->clientRequestReply:Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    invoke-interface {v1, p0}, Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;->cancelled(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_0
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 239
    :cond_3
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->cancel()V

    .line 241
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->endTime:J

    .line 242
    new-instance v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-direct {v1, p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;-><init>(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;)V

    sput-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    goto :goto_0

    .line 147
    :cond_4
    :try_start_8
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->method:Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->addCustomHeaders(Ljava/lang/String;)V

    .line 149
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    invoke-interface {v1, v6}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->send([[B)Ljava/io/InputStream;

    move-result-object v9

    .line 151
    .local v9, "is":Ljava/io/InputStream;
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->isTerminalState()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 156
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v1

    sget-object v2, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->CANCELLED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    if-ne v1, v2, :cond_5

    .line 157
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->clientRequestReply:Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    invoke-interface {v1, p0}, Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;->cancelled(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_0
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    .line 239
    :cond_5
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->cancel()V

    .line 241
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->endTime:J

    .line 242
    new-instance v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-direct {v1, p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;-><init>(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;)V

    sput-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    goto/16 :goto_0

    .line 164
    :cond_6
    :try_start_9
    new-instance v7, Ljava/io/DataInputStream;

    invoke-direct {v7, v9}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 165
    .local v7, "dis":Ljava/io/DataInputStream;
    invoke-static {v7}, Lcom/amazon/rio/j2me/client/rsc/RscResponseHeaderReader;->readHeader(Ljava/io/DataInputStream;)Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;

    move-result-object v11

    .line 170
    .local v11, "rscResponseHeader":Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;
    invoke-virtual {v11}, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->getException()Ljava/lang/String;

    move-result-object v10

    .line 171
    .local v10, "responseException":Ljava/lang/String;
    if-eqz v10, :cond_7

    .line 172
    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v10}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_0
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    .line 239
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v4    # "cookieJar":[B
    .end local v5    # "secureCookieJar":[B
    .end local v6    # "data":[[B
    .end local v7    # "dis":Ljava/io/DataInputStream;
    .end local v9    # "is":Ljava/io/InputStream;
    .end local v10    # "responseException":Ljava/lang/String;
    .end local v11    # "rscResponseHeader":Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;
    :catchall_1
    move-exception v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    invoke-interface {v2}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->cancel()V

    .line 241
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->endTime:J

    .line 242
    new-instance v2, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-direct {v2, p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;-><init>(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;)V

    sput-object v2, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    throw v1

    .line 176
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v4    # "cookieJar":[B
    .restart local v5    # "secureCookieJar":[B
    .restart local v6    # "data":[[B
    .restart local v7    # "dis":Ljava/io/DataInputStream;
    .restart local v9    # "is":Ljava/io/InputStream;
    .restart local v10    # "responseException":Ljava/lang/String;
    .restart local v11    # "rscResponseHeader":Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;
    :cond_7
    :try_start_a
    invoke-virtual {v11}, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->getCookieJar()[B

    move-result-object v4

    .line 177
    iget-boolean v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->allowCookies:Z

    if-eqz v1, :cond_8

    if-eqz v4, :cond_8

    .line 178
    sget-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->cookieJarKey:Ljava/lang/String;

    invoke-interface {v1, v2, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putByteArray(Ljava/lang/String;[B)V

    .line 181
    :cond_8
    iget-boolean v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->secure:Z

    if-eqz v1, :cond_9

    .line 182
    invoke-virtual {v11}, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->getSecureCookieJar()[B

    move-result-object v5

    .line 183
    iget-boolean v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->allowCookies:Z

    if-eqz v1, :cond_9

    if-eqz v5, :cond_9

    .line 184
    sget-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->secureCookieJarKey:Ljava/lang/String;

    invoke-interface {v1, v2, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putByteArray(Ljava/lang/String;[B)V

    .line 188
    :cond_9
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->clientRequestReply:Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    invoke-interface {v1, v7, p0}, Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;->consumeReply(Ljava/io/InputStream;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_0
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    .line 197
    :try_start_b
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->close()V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_1
    .catchall {:try_start_b .. :try_end_b} :catchall_4

    .line 204
    :try_start_c
    monitor-enter p0
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_0
    .catchall {:try_start_c .. :try_end_c} :catchall_1

    .line 205
    :try_start_d
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->isTerminalState()Z

    move-result v1

    if-nez v1, :cond_a

    .line 206
    sget-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->COMPLETED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    invoke-direct {p0, v1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->setState(Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;)V

    .line 208
    :cond_a
    monitor-exit p0
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_2

    .line 239
    :goto_1
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->cancel()V

    .line 241
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->endTime:J

    .line 242
    new-instance v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-direct {v1, p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;-><init>(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;)V

    sput-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    goto/16 :goto_0

    .line 208
    :catchall_2
    move-exception v1

    :try_start_e
    monitor-exit p0
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_2

    :try_start_f
    throw v1
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_0
    .catchall {:try_start_f .. :try_end_f} :catchall_1

    .line 199
    :catch_1
    move-exception v8

    .line 200
    .restart local v8    # "e":Ljava/lang/Exception;
    :try_start_10
    sget-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->logger:Lcom/amazon/rio/j2me/client/util/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "invoke() ERROR: post consumeReply exception="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " this="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/util/Logger;->error(Ljava/lang/String;)V

    .line 201
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->cancel()V
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_4

    .line 204
    :try_start_11
    monitor-enter p0
    :try_end_11
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_11} :catch_0
    .catchall {:try_start_11 .. :try_end_11} :catchall_1

    .line 205
    :try_start_12
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->isTerminalState()Z

    move-result v1

    if-nez v1, :cond_b

    .line 206
    sget-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->COMPLETED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    invoke-direct {p0, v1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->setState(Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;)V

    .line 208
    :cond_b
    monitor-exit p0

    goto :goto_1

    :catchall_3
    move-exception v1

    monitor-exit p0
    :try_end_12
    .catchall {:try_start_12 .. :try_end_12} :catchall_3

    :try_start_13
    throw v1

    .line 204
    .end local v8    # "e":Ljava/lang/Exception;
    :catchall_4
    move-exception v1

    monitor-enter p0
    :try_end_13
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_13} :catch_0
    .catchall {:try_start_13 .. :try_end_13} :catchall_1

    .line 205
    :try_start_14
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->isTerminalState()Z

    move-result v2

    if-nez v2, :cond_c

    .line 206
    sget-object v2, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->COMPLETED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    invoke-direct {p0, v2}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->setState(Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;)V

    .line 208
    :cond_c
    monitor-exit p0
    :try_end_14
    .catchall {:try_start_14 .. :try_end_14} :catchall_5

    :try_start_15
    throw v1
    :try_end_15
    .catch Ljava/lang/Exception; {:try_start_15 .. :try_end_15} :catch_0
    .catchall {:try_start_15 .. :try_end_15} :catchall_1

    :catchall_5
    move-exception v1

    :try_start_16
    monitor-exit p0
    :try_end_16
    .catchall {:try_start_16 .. :try_end_16} :catchall_5

    :try_start_17
    throw v1
    :try_end_17
    .catch Ljava/lang/Exception; {:try_start_17 .. :try_end_17} :catch_0
    .catchall {:try_start_17 .. :try_end_17} :catchall_1

    .line 220
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v4    # "cookieJar":[B
    .end local v5    # "secureCookieJar":[B
    .end local v6    # "data":[[B
    .end local v7    # "dis":Ljava/io/DataInputStream;
    .end local v9    # "is":Ljava/io/InputStream;
    .end local v10    # "responseException":Ljava/lang/String;
    .end local v11    # "rscResponseHeader":Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;
    .restart local v8    # "e":Ljava/lang/Exception;
    :catchall_6
    move-exception v1

    :try_start_18
    monitor-exit p0
    :try_end_18
    .catchall {:try_start_18 .. :try_end_18} :catchall_6

    :try_start_19
    throw v1

    .line 227
    :cond_d
    iput-object v8, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->error:Ljava/lang/Exception;

    .line 228
    sget-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->logger:Lcom/amazon/rio/j2me/client/util/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "invoke() ERROR: exception="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " this="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/util/Logger;->error(Ljava/lang/String;)V

    .line 229
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->cancel()V

    .line 230
    instance-of v1, v8, Ljava/io/IOException;

    if-eqz v1, :cond_e

    .line 231
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->clientRequestReply:Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    invoke-interface {v1, v8, p0}, Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;->communicationError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    :try_end_19
    .catchall {:try_start_19 .. :try_end_19} :catchall_1

    .line 239
    :goto_2
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->cancel()V

    .line 241
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->endTime:J

    .line 242
    new-instance v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    invoke-direct {v1, p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;-><init>(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;)V

    sput-object v1, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->sLastServiceCallInfo:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;

    goto/16 :goto_0

    .line 234
    :cond_e
    :try_start_1a
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->clientRequestReply:Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    invoke-interface {v1, v8, p0}, Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;->internalError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    :try_end_1a
    .catchall {:try_start_1a .. :try_end_1a} :catchall_1

    goto :goto_2
.end method

.method public isSecure()Z
    .locals 1

    .prologue
    .line 286
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->secure:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 302
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 304
    .local v0, "sb":Ljava/lang/StringBuffer;
    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 305
    const-string/jumbo v1, "state="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 306
    const-string/jumbo v1, ", id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget v2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->id:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 307
    const-string/jumbo v1, ", serverConnection="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 308
    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 310
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
