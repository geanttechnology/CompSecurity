.class Lcom/amazon/device/ads/ThreadUtils$ThreadPoolRunnableExecutor;
.super Ljava/lang/Object;
.source "ThreadUtils.java"

# interfaces
.implements Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/ThreadUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ThreadPoolRunnableExecutor"
.end annotation


# static fields
.field private static final keepAliveTimeSeconds:I = 0x1e

.field private static final maxNumberThreads:I = 0x3

.field private static final numberThreads:I = 0x1


# instance fields
.field private executorService:Ljava/util/concurrent/ExecutorService;


# direct methods
.method constructor <init>()V
    .locals 7

    .prologue
    .line 90
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 99
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    const/4 v1, 0x1

    const/4 v2, 0x3

    const-wide/16 v3, 0x1e

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    invoke-direct/range {v0 .. v6}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    iput-object v0, p0, Lcom/amazon/device/ads/ThreadUtils$ThreadPoolRunnableExecutor;->executorService:Ljava/util/concurrent/ExecutorService;

    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "proc"    # Ljava/lang/Runnable;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/device/ads/ThreadUtils$ThreadPoolRunnableExecutor;->executorService:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0, p1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    .line 110
    return-void
.end method
