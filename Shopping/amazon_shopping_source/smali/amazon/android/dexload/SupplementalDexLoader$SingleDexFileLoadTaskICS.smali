.class Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;
.super Ljava/lang/Object;
.source "SupplementalDexLoader.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lamazon/android/dexload/SupplementalDexLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingleDexFileLoadTaskICS"
.end annotation


# instance fields
.field protected mClassLoaderArray:Ljava/lang/Object;

.field protected mContext:Landroid/content/Context;

.field protected mDexElementCompatibility:Lamazon/android/dexload/compatibility/DexElementCompatibility;

.field protected mFileName:Ljava/lang/String;

.field protected mIdx:I

.field protected mLoadingLatch:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lamazon/android/dexload/compatibility/DexElementCompatibility;Ljava/lang/Object;Ljava/lang/String;ILjava/util/concurrent/CountDownLatch;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dexElementCompatibility"    # Lamazon/android/dexload/compatibility/DexElementCompatibility;
    .param p3, "classLoaderArray"    # Ljava/lang/Object;
    .param p4, "fileName"    # Ljava/lang/String;
    .param p5, "idx"    # I
    .param p6, "loadingLatch"    # Ljava/util/concurrent/CountDownLatch;

    .prologue
    .line 559
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 560
    iput-object p1, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mContext:Landroid/content/Context;

    .line 561
    iput-object p2, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mDexElementCompatibility:Lamazon/android/dexload/compatibility/DexElementCompatibility;

    .line 562
    iput-object p3, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mClassLoaderArray:Ljava/lang/Object;

    .line 563
    iput-object p4, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mFileName:Ljava/lang/String;

    .line 564
    iput p5, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mIdx:I

    .line 565
    iput-object p6, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mLoadingLatch:Ljava/util/concurrent/CountDownLatch;

    .line 566
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 571
    :try_start_0
    iget-object v0, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mDexElementCompatibility:Lamazon/android/dexload/compatibility/DexElementCompatibility;

    iget-object v2, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mClassLoaderArray:Ljava/lang/Object;

    iget-object v3, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mFileName:Ljava/lang/String;

    iget v4, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mIdx:I

    # invokes: Lamazon/android/dexload/SupplementalDexLoader;->optimizeAndAddToArray(Landroid/content/Context;Lamazon/android/dexload/compatibility/DexElementCompatibility;Ljava/lang/Object;Ljava/lang/String;I)V
    invoke-static {v0, v1, v2, v3, v4}, Lamazon/android/dexload/SupplementalDexLoader;->access$100(Landroid/content/Context;Lamazon/android/dexload/compatibility/DexElementCompatibility;Ljava/lang/Object;Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 578
    :goto_0
    iget-object v0, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;->mLoadingLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 579
    return-void

    .line 573
    :catch_0
    move-exception v0

    goto :goto_0
.end method
