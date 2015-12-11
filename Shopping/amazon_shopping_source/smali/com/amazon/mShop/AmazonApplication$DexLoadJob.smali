.class Lcom/amazon/mShop/AmazonApplication$DexLoadJob;
.super Ljava/lang/Object;
.source "AmazonApplication.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonApplication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DexLoadJob"
.end annotation


# instance fields
.field private mAppStoreLoadingLatch:Ljava/util/concurrent/CountDownLatch;

.field private mContext:Landroid/content/Context;

.field private mCriticalJars:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Ljava/util/concurrent/CountDownLatch;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "appStoreLoadingLatch"    # Ljava/util/concurrent/CountDownLatch;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/concurrent/CountDownLatch;",
            ")V"
        }
    .end annotation

    .prologue
    .line 229
    .local p2, "criticalJars":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 230
    iput-object p1, p0, Lcom/amazon/mShop/AmazonApplication$DexLoadJob;->mContext:Landroid/content/Context;

    .line 231
    iput-object p2, p0, Lcom/amazon/mShop/AmazonApplication$DexLoadJob;->mCriticalJars:Ljava/util/List;

    .line 232
    iput-object p3, p0, Lcom/amazon/mShop/AmazonApplication$DexLoadJob;->mAppStoreLoadingLatch:Ljava/util/concurrent/CountDownLatch;

    .line 233
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 238
    invoke-static {}, Lamazon/android/dexload/SupplementalDexLoader;->getInstance()Lamazon/android/dexload/SupplementalDexLoader;

    move-result-object v1

    .line 241
    .local v1, "supplementalDexLoader":Lamazon/android/dexload/SupplementalDexLoader;
    :try_start_0
    iget-object v2, p0, Lcom/amazon/mShop/AmazonApplication$DexLoadJob;->mContext:Landroid/content/Context;

    sget-object v3, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;->YES:Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    iget-object v4, p0, Lcom/amazon/mShop/AmazonApplication$DexLoadJob;->mCriticalJars:Ljava/util/List;

    invoke-virtual {v1, v2, v3, v4}, Lamazon/android/dexload/SupplementalDexLoader;->updateClassLoader(Landroid/content/Context;Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;Ljava/util/List;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 248
    iget-object v2, p0, Lcom/amazon/mShop/AmazonApplication$DexLoadJob;->mAppStoreLoadingLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 255
    :goto_0
    :try_start_1
    iget-object v2, p0, Lcom/amazon/mShop/AmazonApplication$DexLoadJob;->mContext:Landroid/content/Context;

    sget-object v3, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;->YES:Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    invoke-virtual {v1, v2, v3}, Lamazon/android/dexload/SupplementalDexLoader;->updateClassLoader(Landroid/content/Context;Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 259
    :goto_1
    return-void

    .line 242
    :catch_0
    move-exception v0

    .line 243
    .local v0, "e":Ljava/lang/Exception;
    :try_start_2
    const-string/jumbo v2, "AmazonApplication"

    const-string/jumbo v3, "Dex loading fails, restart app and skip loading "

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 248
    iget-object v2, p0, Lcom/amazon/mShop/AmazonApplication$DexLoadJob;->mAppStoreLoadingLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_0

    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/amazon/mShop/AmazonApplication$DexLoadJob;->mAppStoreLoadingLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v3}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v2

    .line 256
    :catch_1
    move-exception v0

    .line 257
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string/jumbo v2, "AmazonApplication"

    const-string/jumbo v3, "Dex loading fails, restart app and skip loading "

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1
.end method
