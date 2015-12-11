.class Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager$1;
.super Ljava/lang/Object;
.source "ThreadSafeClientConnManager.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;->requestConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;

.field final synthetic val$poolRequest:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/PoolEntryRequest;

.field final synthetic val$route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;


# direct methods
.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/PoolEntryRequest;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)V
    .locals 0

    .prologue
    .line 207
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager$1;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;

    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager$1;->val$poolRequest:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/PoolEntryRequest;

    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager$1;->val$route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getConnection(JLjava/util/concurrent/TimeUnit;)Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;
    .locals 5
    .param p1, "timeout"    # J
    .param p3, "tunit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionPoolTimeoutException;
        }
    .end annotation

    .prologue
    .line 216
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager$1;->val$route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    if-nez v1, :cond_0

    .line 217
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Route may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 220
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager$1;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;

    # getter for: Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;->log:Lorg/apache/commons/logging/Log;
    invoke-static {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;->access$000(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;)Lorg/apache/commons/logging/Log;

    move-result-object v1

    invoke-interface {v1}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 221
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager$1;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;

    # getter for: Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;->log:Lorg/apache/commons/logging/Log;
    invoke-static {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;->access$000(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;)Lorg/apache/commons/logging/Log;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Get connection: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager$1;->val$route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", timeout = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 224
    :cond_1
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager$1;->val$poolRequest:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/PoolEntryRequest;

    invoke-interface {v1, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/PoolEntryRequest;->getPoolEntry(JLjava/util/concurrent/TimeUnit;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    move-result-object v0

    .line 225
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPooledConnAdapter;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager$1;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v1, v2, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPooledConnAdapter;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V

    return-object v1
.end method
