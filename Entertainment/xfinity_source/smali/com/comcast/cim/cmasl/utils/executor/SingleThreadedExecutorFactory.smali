.class public Lcom/comcast/cim/cmasl/utils/executor/SingleThreadedExecutorFactory;
.super Ljava/lang/Object;
.source "SingleThreadedExecutorFactory.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public create()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 10
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    return-object v0
.end method
