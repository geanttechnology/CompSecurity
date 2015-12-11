.class public final Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;
.super Ljava/lang/Object;
.source "DataStorageFactoryImpl.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/storage/DataStorageFactory;


# static fields
.field private static sInstance:Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mDataStorage:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Lcom/amazon/identity/auth/device/storage/DataStorage;",
            ">;"
        }
    .end annotation
.end field

.field private final mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->sInstance:Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mDataStorage:Ljava/util/concurrent/atomic/AtomicReference;

    .line 25
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mContext:Landroid/content/Context;

    .line 26
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 27
    new-instance v0, Lcom/amazon/identity/auth/device/features/FeatureSetCache;

    new-instance v1, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;-><init>(Landroid/content/Context;)V

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/features/FeatureSetCache;-><init>(Lcom/amazon/identity/auth/device/features/FeatureSet;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    .line 28
    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 32
    const-class v1, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->sInstance:Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;

    if-nez v0, :cond_0

    .line 34
    new-instance v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->sInstance:Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;

    .line 37
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->sInstance:Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 32
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;
    .locals 3

    .prologue
    .line 44
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mDataStorage:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v1

    if-nez v1, :cond_3

    .line 46
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->shouldUseNonCanonicalDataStorage(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 51
    new-instance v0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;-><init>(Landroid/content/Context;)V

    .line 66
    .local v0, "dataStorage":Lcom/amazon/identity/auth/device/storage/DataStorage;
    :goto_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mDataStorage:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v2, 0x0

    invoke-virtual {v1, v2, v0}, Ljava/util/concurrent/atomic/AtomicReference;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 70
    .end local v0    # "dataStorage":Lcom/amazon/identity/auth/device/storage/DataStorage;
    :goto_1
    return-object v0

    .line 53
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->shouldPlatformUseThisStore(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;Lcom/amazon/identity/auth/device/features/FeatureSet;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 55
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;

    move-result-object v0

    .restart local v0    # "dataStorage":Lcom/amazon/identity/auth/device/storage/DataStorage;
    goto :goto_0

    .line 57
    .end local v0    # "dataStorage":Lcom/amazon/identity/auth/device/storage/DataStorage;
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->shouldPlatformUseThisStore(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 59
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;

    move-result-object v0

    .restart local v0    # "dataStorage":Lcom/amazon/identity/auth/device/storage/DataStorage;
    goto :goto_0

    .line 63
    .end local v0    # "dataStorage":Lcom/amazon/identity/auth/device/storage/DataStorage;
    :cond_2
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    move-result-object v0

    .restart local v0    # "dataStorage":Lcom/amazon/identity/auth/device/storage/DataStorage;
    goto :goto_0

    .line 70
    .end local v0    # "dataStorage":Lcom/amazon/identity/auth/device/storage/DataStorage;
    :cond_3
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->mDataStorage:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-object v0, v1

    goto :goto_1
.end method
