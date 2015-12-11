.class Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute$1;
.super Ljava/lang/Object;
.source "ConnPoolByRoute.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/PoolEntryRequest;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->requestPoolEntry(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/PoolEntryRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;

.field final synthetic val$aborter:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;

.field final synthetic val$route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

.field final synthetic val$state:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 285
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute$1;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;

    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute$1;->val$aborter:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;

    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute$1;->val$route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    iput-object p4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute$1;->val$state:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getPoolEntry(JLjava/util/concurrent/TimeUnit;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    .locals 9
    .param p1, "timeout"    # J
    .param p3, "tunit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionPoolTimeoutException;
        }
    .end annotation

    .prologue
    .line 300
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute$1;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute$1;->val$route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute$1;->val$state:Ljava/lang/Object;

    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute$1;->val$aborter:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;

    move-wide v4, p1

    move-object v6, p3

    invoke-virtual/range {v1 .. v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->getEntryBlocking(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;JLjava/util/concurrent/TimeUnit;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    move-result-object v0

    return-object v0
.end method
