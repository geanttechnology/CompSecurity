.class public Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;
.super Ljava/lang/Object;
.source "SecondDexEntry.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$1;,
        Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$ExtractAndFillClassLoader;,
        Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$SingletonHolder;
    }
.end annotation


# instance fields
.field protected mClassLoader:Ldalvik/system/DexClassLoader;

.field protected mContext:Landroid/content/Context;

.field private final mDexPathUpdatedLatch:Ljava/util/concurrent/CountDownLatch;

.field private mIsDebuggable:Z


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mDexPathUpdatedLatch:Ljava/util/concurrent/CountDownLatch;

    .line 43
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mIsDebuggable:Z

    .line 55
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$1;

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;-><init>()V

    return-void
.end method

.method private getClassLoader(J)Ljava/lang/ClassLoader;
    .locals 1
    .param p1, "timeoutInSeconds"    # J

    .prologue
    .line 102
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->waitForLoad(J)V

    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mClassLoader:Ldalvik/system/DexClassLoader;

    if-nez v0, :cond_0

    invoke-super {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mClassLoader:Ldalvik/system/DexClassLoader;

    goto :goto_0
.end method

.method private getDelegateName(Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p1, "proxy"    # Ljava/lang/Object;

    .prologue
    .line 305
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Proxy"

    const-string/jumbo v2, "Delegate"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    return-object v0
.end method

.method private static getIsDebuggableFlag(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 314
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    iget v0, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static throwRuntimeException(Ljava/lang/Exception;)V
    .locals 1
    .param p0, "e"    # Ljava/lang/Exception;

    .prologue
    .line 125
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0, p0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method

.method private waitForLoad(J)V
    .locals 3
    .param p1, "timeoutInSeconds"    # J

    .prologue
    .line 238
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mContext:Landroid/content/Context;

    if-eqz v1, :cond_1

    .line 242
    const-wide/16 v1, -0x1

    cmp-long v1, p1, v1

    if-gtz v1, :cond_0

    .line 243
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mDexPathUpdatedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->await()V

    .line 254
    :goto_0
    return-void

    .line 245
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mDexPathUpdatedLatch:Ljava/util/concurrent/CountDownLatch;

    sget-object v2, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, p1, p2, v2}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 247
    :catch_0
    move-exception v0

    .line 248
    .local v0, "e":Ljava/lang/Exception;
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->interrupt()V

    .line 249
    invoke-static {v0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->throwRuntimeException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 252
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "The secondary dex hasn\'t been initialized before using it"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method


# virtual methods
.method public createActivityDelegate(Landroid/app/Activity;)Ljava/lang/Object;
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/app/Activity;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 121
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->createDelegate(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public createBroadcastReceiveDelegate(Landroid/content/BroadcastReceiver;)Ljava/lang/Object;
    .locals 2
    .param p1, "receiver"    # Landroid/content/BroadcastReceiver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/content/BroadcastReceiver;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 155
    const-wide/16 v0, 0x4

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->createDelegate(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public createContentProviderDelegate(Landroid/content/ContentProvider;)Ljava/lang/Object;
    .locals 2
    .param p1, "provider"    # Landroid/content/ContentProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/content/ContentProvider;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 171
    const-wide/16 v0, 0x4

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->createDelegate(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public createDelegate(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "proxy"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 184
    const-wide/16 v0, -0x1

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->createDelegate(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public createDelegate(Ljava/lang/Object;J)Ljava/lang/Object;
    .locals 8
    .param p1, "proxy"    # Ljava/lang/Object;
    .param p2, "timeoutInSeconds"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            "J)TT;"
        }
    .end annotation

    .prologue
    .line 201
    const/4 v2, 0x0

    .line 203
    .local v2, "delegate":Ljava/lang/Object;, "TT;"
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getDelegateName(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 205
    .local v0, "className":Ljava/lang/String;
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader(J)Ljava/lang/ClassLoader;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 206
    .local v1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Class;

    const/4 v6, 0x0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v1, v5}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v4

    .line 207
    .local v4, "implConstructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<TT;>;"
    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    invoke-virtual {v4, v5}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_5

    move-result-object v2

    .line 222
    .end local v0    # "className":Ljava/lang/String;
    .end local v1    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .end local v2    # "delegate":Ljava/lang/Object;, "TT;"
    .end local v4    # "implConstructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<TT;>;"
    :goto_0
    return-object v2

    .line 208
    .restart local v2    # "delegate":Ljava/lang/Object;, "TT;"
    :catch_0
    move-exception v3

    .line 209
    .local v3, "e":Ljava/lang/ClassNotFoundException;
    invoke-static {v3}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->throwRuntimeException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 210
    .end local v3    # "e":Ljava/lang/ClassNotFoundException;
    :catch_1
    move-exception v3

    .line 211
    .local v3, "e":Ljava/lang/NoSuchMethodException;
    invoke-static {v3}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->throwRuntimeException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 212
    .end local v3    # "e":Ljava/lang/NoSuchMethodException;
    :catch_2
    move-exception v3

    .line 213
    .local v3, "e":Ljava/lang/IllegalArgumentException;
    invoke-static {v3}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->throwRuntimeException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 214
    .end local v3    # "e":Ljava/lang/IllegalArgumentException;
    :catch_3
    move-exception v3

    .line 215
    .local v3, "e":Ljava/lang/InstantiationException;
    invoke-static {v3}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->throwRuntimeException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 216
    .end local v3    # "e":Ljava/lang/InstantiationException;
    :catch_4
    move-exception v3

    .line 217
    .local v3, "e":Ljava/lang/IllegalAccessException;
    invoke-static {v3}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->throwRuntimeException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 218
    .end local v3    # "e":Ljava/lang/IllegalAccessException;
    :catch_5
    move-exception v3

    .line 219
    .local v3, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-static {v3}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->throwRuntimeException(Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method public createServiceDelegate(Landroid/app/Service;)Ljava/lang/Object;
    .locals 2
    .param p1, "service"    # Landroid/app/Service;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/app/Service;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 140
    const-wide/16 v0, 0x4

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->createDelegate(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected extractDexAndLoad(Ljava/util/concurrent/ThreadPoolExecutor;)V
    .locals 6
    .param p1, "executor"    # Ljava/util/concurrent/ThreadPoolExecutor;

    .prologue
    .line 275
    :try_start_0
    iget-object v3, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mContext:Landroid/content/Context;

    invoke-static {v3, p1}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->copyJarsToAppPrivateFolder(Landroid/content/Context;Ljava/util/concurrent/ThreadPoolExecutor;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 277
    .local v0, "dexList":Ljava/lang/String;
    const/4 v2, 0x0

    .line 279
    .local v2, "libPath":Ljava/lang/String;
    :try_start_1
    iget-object v3, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->getAppPrivateNativeLibsPath(Landroid/content/Context;)Ljava/lang/String;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v2

    .line 284
    :goto_0
    :try_start_2
    new-instance v3, Ldalvik/system/DexClassLoader;

    iget-object v4, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mContext:Landroid/content/Context;

    invoke-static {v4}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->getPrivateDexCachePath(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v5

    invoke-direct {v3, v0, v4, v2, v5}, Ldalvik/system/DexClassLoader;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V

    iput-object v3, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mClassLoader:Ldalvik/system/DexClassLoader;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 289
    .end local v0    # "dexList":Ljava/lang/String;
    .end local v2    # "libPath":Ljava/lang/String;
    :goto_1
    iget-object v3, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mDexPathUpdatedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v3}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 290
    return-void

    .line 286
    :catch_0
    move-exception v1

    .line 287
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v3, "SecondDexEntry"

    const-string/jumbo v4, "Copying jar has error"

    invoke-static {v3, v4, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 280
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v0    # "dexList":Ljava/lang/String;
    .restart local v2    # "libPath":Ljava/lang/String;
    :catch_1
    move-exception v3

    goto :goto_0
.end method

.method public getClassLoader()Ljava/lang/ClassLoader;
    .locals 2

    .prologue
    .line 90
    const-wide/16 v0, -0x1

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader(J)Ljava/lang/ClassLoader;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized init(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 66
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mContext:Landroid/content/Context;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 81
    :goto_0
    monitor-exit p0

    return-void

    .line 70
    :cond_0
    :try_start_1
    iput-object p1, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mContext:Landroid/content/Context;

    .line 72
    invoke-static {p1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getIsDebuggableFlag(Landroid/content/Context;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mIsDebuggable:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 75
    :try_start_2
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->loadDex()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 76
    :catch_0
    move-exception v0

    .line 77
    .local v0, "e":Ljava/io/IOException;
    :try_start_3
    invoke-static {v0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->throwRuntimeException(Ljava/lang/Exception;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 66
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 78
    :catch_1
    move-exception v0

    .line 79
    .local v0, "e":Ljava/lang/InterruptedException;
    :try_start_4
    invoke-static {v0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->throwRuntimeException(Ljava/lang/Exception;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0
.end method

.method public isDebuggable()Z
    .locals 1

    .prologue
    .line 257
    iget-boolean v0, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->mIsDebuggable:Z

    return v0
.end method

.method protected loadDex()V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 262
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Runtime;->availableProcessors()I

    move-result v2

    const/4 v3, 0x2

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 263
    .local v1, "availableCores":I
    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    .line 264
    .local v6, "workQueue":Ljava/util/concurrent/BlockingQueue;, "Ljava/util/concurrent/BlockingQueue<Ljava/lang/Runnable;>;"
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/16 v3, 0x1

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    move v2, v1

    invoke-direct/range {v0 .. v6}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    .line 268
    .local v0, "executor":Ljava/util/concurrent/ThreadPoolExecutor;
    new-instance v7, Ljava/lang/Thread;

    new-instance v2, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$ExtractAndFillClassLoader;

    invoke-direct {v2, v0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$ExtractAndFillClassLoader;-><init>(Ljava/util/concurrent/ThreadPoolExecutor;)V

    invoke-direct {v7, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 269
    .local v7, "backgroundThread":Ljava/lang/Thread;
    invoke-virtual {v7}, Ljava/lang/Thread;->start()V

    .line 270
    return-void
.end method
