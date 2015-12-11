.class public Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;
.super Ljava/lang/Object;
.source "UnitTestSafeExecutorService.java"

# interfaces
.implements Ljava/util/concurrent/Executor;


# instance fields
.field private final mExecutorService:Ljava/util/concurrent/ExecutorService;


# direct methods
.method public constructor <init>(Ljava/util/concurrent/ExecutorService;)V
    .locals 0
    .param p1, "executorService"    # Ljava/util/concurrent/ExecutorService;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;->mExecutorService:Ljava/util/concurrent/ExecutorService;

    .line 16
    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "task"    # Ljava/lang/Runnable;

    .prologue
    .line 21
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 23
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    .line 28
    :goto_0
    return-void

    .line 27
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;->mExecutorService:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0, p1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
