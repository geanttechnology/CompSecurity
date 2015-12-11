.class Lamazon/android/dexload/ThreadUtil;
.super Ljava/lang/Object;
.source "ThreadUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lamazon/android/dexload/ThreadUtil$1;,
        Lamazon/android/dexload/ThreadUtil$DexLoadThreadFactory;
    }
.end annotation


# static fields
.field private static final MINIMAL_THREAD_COUNT:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 12
    const/4 v0, 0x2

    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Runtime;->availableProcessors()I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    sput v0, Lamazon/android/dexload/ThreadUtil;->MINIMAL_THREAD_COUNT:I

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    return-void
.end method

.method public static createExector(Ljava/util/concurrent/BlockingQueue;I)Ljava/util/concurrent/ThreadPoolExecutor;
    .locals 8
    .param p1, "requestThread"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/BlockingQueue",
            "<",
            "Ljava/lang/Runnable;",
            ">;I)",
            "Ljava/util/concurrent/ThreadPoolExecutor;"
        }
    .end annotation

    .prologue
    .line 19
    .local p0, "workingQueue":Ljava/util/concurrent/BlockingQueue;, "Ljava/util/concurrent/BlockingQueue<Ljava/lang/Runnable;>;"
    sget v0, Lamazon/android/dexload/ThreadUtil;->MINIMAL_THREAD_COUNT:I

    invoke-static {p1, v0}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 20
    .local v1, "threadCount":I
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/16 v3, 0x1

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Lamazon/android/dexload/ThreadUtil$DexLoadThreadFactory;

    const/4 v2, 0x0

    invoke-direct {v7, v2}, Lamazon/android/dexload/ThreadUtil$DexLoadThreadFactory;-><init>(Lamazon/android/dexload/ThreadUtil$1;)V

    move v2, v1

    move-object v6, p0

    invoke-direct/range {v0 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    return-object v0
.end method
