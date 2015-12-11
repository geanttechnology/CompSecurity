.class Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker$1;
.super Ljava/lang/Object;
.source "AsynchronousServiceCallInvoker.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;

.field final synthetic val$serviceCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

.field final synthetic val$worker:Lcom/amazon/rio/j2me/client/util/Worker;


# direct methods
.method constructor <init>(Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;Lcom/amazon/rio/j2me/client/util/Worker;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker$1;->this$0:Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;

    iput-object p2, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker$1;->val$serviceCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

    iput-object p3, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker$1;->val$worker:Lcom/amazon/rio/j2me/client/util/Worker;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker$1;->val$serviceCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->invoke()V

    .line 50
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker$1;->this$0:Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;

    # getter for: Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;
    invoke-static {v0}, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;->access$000(Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;)Lcom/amazon/rio/j2me/client/util/WorkerPool;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker$1;->val$worker:Lcom/amazon/rio/j2me/client/util/Worker;

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->releaseWorker(Lcom/amazon/rio/j2me/client/util/Worker;)V

    .line 51
    return-void
.end method
