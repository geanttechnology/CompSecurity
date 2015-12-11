.class public Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;
.super Ljava/lang/Object;
.source "AsynchronousServiceCallInvoker.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;


# instance fields
.field private final secureServerConnectionFactory:Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;

.field private final serverConnectionFactory:Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;

.field private final threadPriority:I

.field private final workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;


# direct methods
.method public constructor <init>(Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;)V
    .locals 1
    .param p1, "serverConnectionFactory"    # Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;
    .param p2, "secureServerConnectionFactory"    # Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;

    .prologue
    .line 29
    const/4 v0, 0x5

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;-><init>(Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;I)V

    .line 30
    return-void
.end method

.method public constructor <init>(Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;I)V
    .locals 1
    .param p1, "serverConnectionFactory"    # Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;
    .param p2, "secureServerConnectionFactory"    # Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;
    .param p3, "threadPriority"    # I

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    invoke-static {}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->getInstance()Lcom/amazon/rio/j2me/client/util/WorkerPool;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;

    .line 33
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->serverConnectionFactory:Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;

    .line 34
    iput-object p2, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->secureServerConnectionFactory:Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;

    .line 35
    iput p3, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->threadPriority:I

    .line 36
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;)Lcom/amazon/rio/j2me/client/util/WorkerPool;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;

    return-object v0
.end method


# virtual methods
.method public invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    .locals 12
    .param p1, "serviceName"    # Ljava/lang/String;
    .param p2, "method"    # Ljava/lang/String;
    .param p3, "applicationID"    # Ljava/lang/String;
    .param p4, "secure"    # Z
    .param p5, "allowCookies"    # Z
    .param p6, "clientRequestReply"    # Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    .prologue
    .line 40
    const-string/jumbo v1, "home_v38"

    invoke-virtual {v1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->serverConnectionFactory:Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;->getServerConnection()Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    move-result-object v7

    .line 41
    .local v7, "serverConnection":Lcom/amazon/rio/j2me/client/trans/IServiceConnection;
    :goto_0
    new-instance v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move/from16 v5, p4

    move/from16 v6, p5

    move-object/from16 v8, p6

    invoke-direct/range {v0 .. v8}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/trans/IServiceConnection;Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)V

    .line 44
    .local v0, "serviceCall":Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->acquireWorker()Lcom/amazon/rio/j2me/client/util/Worker;

    move-result-object v11

    .line 45
    .local v11, "worker":Lcom/amazon/rio/j2me/client/util/Worker;
    iget v1, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->threadPriority:I

    invoke-virtual {v11, v1}, Lcom/amazon/rio/j2me/client/util/Worker;->setPriority(I)V

    .line 47
    new-instance v10, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker$1;

    invoke-direct {v10, p0, v0, v11}, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker$1;-><init>(Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;Lcom/amazon/rio/j2me/client/util/Worker;)V

    .line 54
    .local v10, "task":Ljava/lang/Runnable;
    const-string/jumbo v1, "serviceCall.invoke()"

    invoke-virtual {v11, v1, v10}, Lcom/amazon/rio/j2me/client/util/Worker;->execute(Ljava/lang/String;Ljava/lang/Runnable;)V
    :try_end_0
    .catch Lcom/amazon/rio/j2me/client/util/LifecycleException; {:try_start_0 .. :try_end_0} :catch_0

    .line 59
    return-object v0

    .line 40
    .end local v0    # "serviceCall":Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;
    .end local v7    # "serverConnection":Lcom/amazon/rio/j2me/client/trans/IServiceConnection;
    .end local v10    # "task":Ljava/lang/Runnable;
    .end local v11    # "worker":Lcom/amazon/rio/j2me/client/util/Worker;
    :cond_0
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->secureServerConnectionFactory:Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;->getServerConnection()Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    move-result-object v7

    goto :goto_0

    .line 55
    .restart local v0    # "serviceCall":Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;
    .restart local v7    # "serverConnection":Lcom/amazon/rio/j2me/client/trans/IServiceConnection;
    :catch_0
    move-exception v9

    .line 56
    .local v9, "le":Lcom/amazon/rio/j2me/client/util/LifecycleException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-virtual {v9}, Lcom/amazon/rio/j2me/client/util/LifecycleException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method
