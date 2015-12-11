.class final Lcom/a/b/ag;
.super Ljava/lang/Thread;
.source "SourceFile"


# instance fields
.field private final a:Ljava/lang/ref/ReferenceQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/ReferenceQueue",
            "<*>;"
        }
    .end annotation
.end field

.field private final b:Landroid/os/Handler;


# direct methods
.method constructor <init>(Ljava/lang/ref/ReferenceQueue;Landroid/os/Handler;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/ref/ReferenceQueue",
            "<*>;",
            "Landroid/os/Handler;",
            ")V"
        }
    .end annotation

    .prologue
    .line 341
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 342
    iput-object p1, p0, Lcom/a/b/ag;->a:Ljava/lang/ref/ReferenceQueue;

    .line 343
    iput-object p2, p0, Lcom/a/b/ag;->b:Landroid/os/Handler;

    .line 344
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/a/b/ag;->setDaemon(Z)V

    .line 345
    const-string v0, "Picasso-refQueue"

    invoke-virtual {p0, v0}, Lcom/a/b/ag;->setName(Ljava/lang/String;)V

    .line 346
    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    .prologue
    .line 349
    const/16 v0, 0xa

    invoke-static {v0}, Landroid/os/Process;->setThreadPriority(I)V

    .line 352
    :goto_0
    :try_start_0
    iget-object v0, p0, Lcom/a/b/ag;->a:Ljava/lang/ref/ReferenceQueue;

    invoke-virtual {v0}, Ljava/lang/ref/ReferenceQueue;->remove()Ljava/lang/ref/Reference;

    move-result-object v0

    check-cast v0, Lcom/a/b/b;

    .line 353
    iget-object v1, p0, Lcom/a/b/ag;->b:Landroid/os/Handler;

    iget-object v2, p0, Lcom/a/b/ag;->b:Landroid/os/Handler;

    const/4 v3, 0x3

    iget-object v0, v0, Lcom/a/b/b;->a:Lcom/a/b/a;

    invoke-virtual {v2, v3, v0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 355
    :catch_0
    move-exception v0

    .line 362
    :goto_1
    return-void

    .line 356
    :catch_1
    move-exception v0

    .line 357
    iget-object v1, p0, Lcom/a/b/ag;->b:Landroid/os/Handler;

    new-instance v2, Lcom/a/b/ah;

    invoke-direct {v2, p0, v0}, Lcom/a/b/ah;-><init>(Lcom/a/b/ag;Ljava/lang/Exception;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_1
.end method
