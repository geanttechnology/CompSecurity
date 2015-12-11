.class final Lcom/a/b/an;
.super Ljava/util/concurrent/ThreadPoolExecutor;
.source "SourceFile"


# direct methods
.method constructor <init>()V
    .locals 9

    .prologue
    const/4 v2, 0x3

    .line 35
    const-wide/16 v4, 0x0

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v7}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    new-instance v8, Lcom/a/b/bc;

    invoke-direct {v8}, Lcom/a/b/bc;-><init>()V

    move-object v1, p0

    move v3, v2

    invoke-direct/range {v1 .. v8}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    .line 37
    return-void
.end method


# virtual methods
.method final a(I)V
    .locals 0

    .prologue
    .line 78
    invoke-virtual {p0, p1}, Lcom/a/b/an;->setCorePoolSize(I)V

    .line 79
    invoke-virtual {p0, p1}, Lcom/a/b/an;->setMaximumPoolSize(I)V

    .line 80
    return-void
.end method
