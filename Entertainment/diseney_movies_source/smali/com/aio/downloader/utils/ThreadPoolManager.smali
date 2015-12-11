.class public Lcom/aio/downloader/utils/ThreadPoolManager;
.super Ljava/lang/Object;
.source "ThreadPoolManager.java"


# static fields
.field private static final mThreadPoolManager:Lcom/aio/downloader/utils/ThreadPoolManager;


# instance fields
.field private executorService:Ljava/util/concurrent/ExecutorService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    new-instance v0, Lcom/aio/downloader/utils/ThreadPoolManager;

    invoke-direct {v0}, Lcom/aio/downloader/utils/ThreadPoolManager;-><init>()V

    sput-object v0, Lcom/aio/downloader/utils/ThreadPoolManager;->mThreadPoolManager:Lcom/aio/downloader/utils/ThreadPoolManager;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Runtime;->availableProcessors()I

    move-result v0

    .line 18
    .local v0, "run":I
    mul-int/lit8 v1, v0, 0x2

    invoke-static {v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/utils/ThreadPoolManager;->executorService:Ljava/util/concurrent/ExecutorService;

    .line 19
    return-void
.end method

.method public static getInstance()Lcom/aio/downloader/utils/ThreadPoolManager;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/aio/downloader/utils/ThreadPoolManager;->mThreadPoolManager:Lcom/aio/downloader/utils/ThreadPoolManager;

    return-object v0
.end method


# virtual methods
.method public addTask(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/aio/downloader/utils/ThreadPoolManager;->executorService:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0, p1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 28
    return-void
.end method
