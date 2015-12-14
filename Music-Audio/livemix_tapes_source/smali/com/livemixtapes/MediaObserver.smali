.class public Lcom/livemixtapes/MediaObserver;
.super Ljava/lang/Object;
.source "MediaObserver.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private activity:Landroid/app/Activity;

.field private stop:Ljava/util/concurrent/atomic/AtomicBoolean;

.field volatile task1Running:Z

.field private ultrastop:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v1, 0x0

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/livemixtapes/MediaObserver;->stop:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 9
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/livemixtapes/MediaObserver;->ultrastop:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 10
    iput-boolean v1, p0, Lcom/livemixtapes/MediaObserver;->task1Running:Z

    .line 17
    iget-boolean v0, p0, Lcom/livemixtapes/MediaObserver;->task1Running:Z

    if-eqz v0, :cond_0

    .line 23
    :goto_0
    return-void

    .line 20
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/livemixtapes/MediaObserver;->task1Running:Z

    .line 21
    iput-object p1, p0, Lcom/livemixtapes/MediaObserver;->activity:Landroid/app/Activity;

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/livemixtapes/MediaObserver;)Ljava/util/concurrent/atomic/AtomicBoolean;
    .locals 1

    .prologue
    .line 8
    iget-object v0, p0, Lcom/livemixtapes/MediaObserver;->stop:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 34
    iget-object v0, p0, Lcom/livemixtapes/MediaObserver;->stop:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 36
    :goto_0
    iget-object v0, p0, Lcom/livemixtapes/MediaObserver;->ultrastop:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 75
    return-void

    .line 40
    :cond_0
    const-wide/16 v0, 0x1f4

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 46
    :goto_1
    iget-object v0, p0, Lcom/livemixtapes/MediaObserver;->activity:Landroid/app/Activity;

    new-instance v1, Lcom/livemixtapes/MediaObserver$1;

    invoke-direct {v1, p0}, Lcom/livemixtapes/MediaObserver$1;-><init>(Lcom/livemixtapes/MediaObserver;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 42
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 26
    iget-object v0, p0, Lcom/livemixtapes/MediaObserver;->stop:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 27
    return-void
.end method

.method public unstop()V
    .locals 2

    .prologue
    .line 30
    iget-object v0, p0, Lcom/livemixtapes/MediaObserver;->stop:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 31
    return-void
.end method
