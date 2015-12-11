.class public Lco/vine/android/util/BlockingToken;
.super Ljava/lang/Object;
.source "BlockingToken.java"


# static fields
.field private static final LOCK:[I

.field private static final sTokens:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/concurrent/LinkedBlockingQueue",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lco/vine/android/util/BlockingToken;->LOCK:[I

    .line 14
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lco/vine/android/util/BlockingToken;->sTokens:Ljava/util/HashMap;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static acquire(Ljava/lang/String;)V
    .locals 4
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 17
    const-string v2, "bbq {} acquire."

    invoke-static {v2, p0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 18
    invoke-static {p0}, Lco/vine/android/util/BlockingToken;->getQueue(Ljava/lang/String;)Ljava/util/concurrent/LinkedBlockingQueue;

    move-result-object v1

    .line 19
    .local v1, "queue":Ljava/util/concurrent/LinkedBlockingQueue;, "Ljava/util/concurrent/LinkedBlockingQueue<Ljava/lang/String;>;"
    :goto_0
    invoke-virtual {v1}, Ljava/util/concurrent/LinkedBlockingQueue;->poll()Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_0

    .line 21
    const-wide/16 v2, 0xf

    :try_start_0
    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 22
    :catch_0
    move-exception v0

    .line 23
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v2, "bbq {} failed to acquire."

    invoke-static {v2, p0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    .line 26
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :cond_0
    return-void
.end method

.method private static getQueue(Ljava/lang/String;)Ljava/util/concurrent/LinkedBlockingQueue;
    .locals 4
    .param p0, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/concurrent/LinkedBlockingQueue",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 39
    sget-object v3, Lco/vine/android/util/BlockingToken;->LOCK:[I

    monitor-enter v3

    .line 41
    :try_start_0
    sget-object v2, Lco/vine/android/util/BlockingToken;->sTokens:Ljava/util/HashMap;

    invoke-virtual {v2, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/concurrent/LinkedBlockingQueue;

    .line 42
    .local v1, "queue":Ljava/util/concurrent/LinkedBlockingQueue;, "Ljava/util/concurrent/LinkedBlockingQueue<Ljava/lang/String;>;"
    if-nez v1, :cond_0

    .line 43
    new-instance v1, Ljava/util/concurrent/LinkedBlockingQueue;

    .end local v1    # "queue":Ljava/util/concurrent/LinkedBlockingQueue;, "Ljava/util/concurrent/LinkedBlockingQueue<Ljava/lang/String;>;"
    invoke-direct {v1}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 45
    .restart local v1    # "queue":Ljava/util/concurrent/LinkedBlockingQueue;, "Ljava/util/concurrent/LinkedBlockingQueue<Ljava/lang/String;>;"
    :try_start_1
    invoke-virtual {v1, p0}, Ljava/util/concurrent/LinkedBlockingQueue;->put(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 49
    :goto_0
    :try_start_2
    sget-object v2, Lco/vine/android/util/BlockingToken;->sTokens:Ljava/util/HashMap;

    invoke-virtual {v2, p0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    :cond_0
    monitor-exit v3

    return-object v1

    .line 46
    :catch_0
    move-exception v0

    .line 47
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v2, "bbq {} failed to queue."

    invoke-static {v2, p0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    .line 52
    .end local v0    # "e":Ljava/lang/InterruptedException;
    .end local v1    # "queue":Ljava/util/concurrent/LinkedBlockingQueue;, "Ljava/util/concurrent/LinkedBlockingQueue<Ljava/lang/String;>;"
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2
.end method

.method public static release(Ljava/lang/String;)V
    .locals 3
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 29
    const-string v2, "bbq {} release."

    invoke-static {v2, p0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 30
    invoke-static {p0}, Lco/vine/android/util/BlockingToken;->getQueue(Ljava/lang/String;)Ljava/util/concurrent/LinkedBlockingQueue;

    move-result-object v1

    .line 32
    .local v1, "queue":Ljava/util/concurrent/LinkedBlockingQueue;, "Ljava/util/concurrent/LinkedBlockingQueue<Ljava/lang/String;>;"
    :try_start_0
    invoke-virtual {v1, p0}, Ljava/util/concurrent/LinkedBlockingQueue;->put(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 36
    :goto_0
    return-void

    .line 33
    :catch_0
    move-exception v0

    .line 34
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v2, "bbq {} failed to release."

    invoke-static {v2, p0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
