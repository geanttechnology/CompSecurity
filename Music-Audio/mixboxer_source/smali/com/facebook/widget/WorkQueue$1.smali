.class Lcom/facebook/widget/WorkQueue$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/facebook/widget/WorkQueue;

.field final synthetic val$node:Lcom/facebook/widget/WorkQueue$WorkNode;


# direct methods
.method constructor <init>(Lcom/facebook/widget/WorkQueue;Lcom/facebook/widget/WorkQueue$WorkNode;)V
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/facebook/widget/WorkQueue$1;->this$0:Lcom/facebook/widget/WorkQueue;

    iput-object p2, p0, Lcom/facebook/widget/WorkQueue$1;->val$node:Lcom/facebook/widget/WorkQueue$WorkNode;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 118
    :try_start_0
    iget-object v0, p0, Lcom/facebook/widget/WorkQueue$1;->val$node:Lcom/facebook/widget/WorkQueue$WorkNode;

    invoke-virtual {v0}, Lcom/facebook/widget/WorkQueue$WorkNode;->getCallback()Ljava/lang/Runnable;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 120
    iget-object v0, p0, Lcom/facebook/widget/WorkQueue$1;->this$0:Lcom/facebook/widget/WorkQueue;

    iget-object v1, p0, Lcom/facebook/widget/WorkQueue$1;->val$node:Lcom/facebook/widget/WorkQueue$WorkNode;

    # invokes: Lcom/facebook/widget/WorkQueue;->finishItemAndStartNew(Lcom/facebook/widget/WorkQueue$WorkNode;)V
    invoke-static {v0, v1}, Lcom/facebook/widget/WorkQueue;->access$000(Lcom/facebook/widget/WorkQueue;Lcom/facebook/widget/WorkQueue$WorkNode;)V

    .line 121
    return-void

    .line 120
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/facebook/widget/WorkQueue$1;->this$0:Lcom/facebook/widget/WorkQueue;

    iget-object v2, p0, Lcom/facebook/widget/WorkQueue$1;->val$node:Lcom/facebook/widget/WorkQueue$WorkNode;

    # invokes: Lcom/facebook/widget/WorkQueue;->finishItemAndStartNew(Lcom/facebook/widget/WorkQueue$WorkNode;)V
    invoke-static {v1, v2}, Lcom/facebook/widget/WorkQueue;->access$000(Lcom/facebook/widget/WorkQueue;Lcom/facebook/widget/WorkQueue$WorkNode;)V

    throw v0
.end method
