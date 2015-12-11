.class public Lcom/a9/cameralibrary/DataSourceThread;
.super Ljava/lang/Thread;
.source "DataSourceThread.java"


# instance fields
.field private m_handler:Landroid/os/Handler;

.field private final m_name:Ljava/lang/String;

.field private final m_readyLatch:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/a9/cameralibrary/DataSourceThread;->m_name:Ljava/lang/String;

    .line 21
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/a9/cameralibrary/DataSourceThread;->m_readyLatch:Ljava/util/concurrent/CountDownLatch;

    .line 22
    return-void
.end method


# virtual methods
.method public awaitReady()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 48
    iget-object v0, p0, Lcom/a9/cameralibrary/DataSourceThread;->m_readyLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V

    .line 49
    return-void
.end method

.method public run()V
    .locals 2

    .prologue
    .line 36
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/a9/cameralibrary/DataSourceThread;->m_name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " Thread"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/a9/cameralibrary/DataSourceThread;->setName(Ljava/lang/String;)V

    .line 37
    invoke-static {}, Landroid/os/Looper;->prepare()V

    .line 38
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/a9/cameralibrary/DataSourceThread;->m_handler:Landroid/os/Handler;

    .line 39
    iget-object v0, p0, Lcom/a9/cameralibrary/DataSourceThread;->m_readyLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 40
    invoke-static {}, Landroid/os/Looper;->loop()V

    .line 41
    return-void
.end method

.method public runRunnable(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "r"    # Ljava/lang/Runnable;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/a9/cameralibrary/DataSourceThread;->m_handler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 57
    return-void
.end method

.method public shutdown()V
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/a9/cameralibrary/DataSourceThread;->m_handler:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->quit()V

    .line 53
    return-void
.end method

.method public start()V
    .locals 4

    .prologue
    .line 26
    invoke-super {p0}, Ljava/lang/Thread;->start()V

    .line 28
    :try_start_0
    invoke-virtual {p0}, Lcom/a9/cameralibrary/DataSourceThread;->awaitReady()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 32
    return-void

    .line 29
    :catch_0
    move-exception v0

    .line 30
    .local v0, "e":Ljava/lang/InterruptedException;
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Could not start data source thread for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/a9/cameralibrary/DataSourceThread;->m_name:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method
