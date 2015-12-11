.class public Lcom/amazon/identity/auth/device/utils/NamedCachedThreadPool;
.super Ljava/lang/Object;
.source "NamedCachedThreadPool.java"

# interfaces
.implements Ljava/util/concurrent/Executor;


# instance fields
.field private final mInnerExecutor:Ljava/util/concurrent/Executor;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    new-instance v0, Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;

    new-instance v1, Lcom/amazon/identity/auth/device/utils/NamedThreadFactory;

    invoke-direct {v1, p1}, Lcom/amazon/identity/auth/device/utils/NamedThreadFactory;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Ljava/util/concurrent/Executors;->newCachedThreadPool(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;-><init>(Ljava/util/concurrent/ExecutorService;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/NamedCachedThreadPool;->mInnerExecutor:Ljava/util/concurrent/Executor;

    .line 16
    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "command"    # Ljava/lang/Runnable;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/NamedCachedThreadPool;->mInnerExecutor:Ljava/util/concurrent/Executor;

    invoke-interface {v0, p1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 22
    return-void
.end method
