.class public Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;
.super Lcom/amazon/identity/auth/device/storage/DataStorage;
.source "DistributedDataStorage.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;
    }
.end annotation


# static fields
.field private static final PROPAGATION_EXECUTOR:Ljava/util/concurrent/Executor;

.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

.field private final mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

.field private final mRetryDirtyDataScheduler:Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 45
    const-class v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    .line 59
    new-instance v0, Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;-><init>(Ljava/util/concurrent/ExecutorService;)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->PROPAGATION_EXECUTOR:Ljava/util/concurrent/Executor;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 71
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/DataStorage;-><init>()V

    .line 72
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    .line 74
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_local_datastorage"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    .line 76
    new-instance v0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mRetryDirtyDataScheduler:Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;

    .line 78
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/LambortishClock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    .line 79
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/LocalDataStorage;Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;Lcom/amazon/identity/auth/device/storage/LambortishClock;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "localDataStorage"    # Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
    .param p3, "scheduler"    # Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;
    .param p4, "lambortishClock"    # Lcom/amazon/identity/auth/device/storage/LambortishClock;

    .prologue
    .line 86
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/DataStorage;-><init>()V

    .line 87
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    .line 88
    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    .line 89
    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mRetryDirtyDataScheduler:Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;

    .line 90
    iput-object p4, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    .line 91
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;)Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;

    .prologue
    .line 34
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChange(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;)Z

    move-result v0

    return v0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 95
    const-class v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 97
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    .line 100
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 95
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private getLatestInitializedMapApplication()Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .locals 8

    .prologue
    .line 802
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getSortedByLatestMapApplications()Ljava/util/List;

    move-result-object v4

    .line 805
    .local v4, "sortedByNewestMapInfo":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    if-eqz v4, :cond_1

    .line 807
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .line 809
    .local v3, "mapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->isSelf()Z

    move-result v5

    if-nez v5, :cond_0

    .line 811
    :try_start_0
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->fetchMAPInitVersion()Ljava/lang/Integer;

    move-result-object v0

    .line 817
    .local v0, "currentMapInitVersion":Ljava/lang/Integer;
    if-eqz v0, :cond_0

    const/4 v5, 0x3

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v6

    if-gt v5, v6, :cond_0

    .line 831
    .end local v0    # "currentMapInitVersion":Ljava/lang/Integer;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "mapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :goto_1
    return-object v3

    .line 823
    .restart local v2    # "i$":Ljava/util/Iterator;
    .restart local v3    # "mapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :catch_0
    move-exception v1

    .line 825
    .local v1, "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    sget-object v5, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Failed to get MAP init version from "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 830
    .end local v1    # "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "mapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :cond_1
    sget-object v5, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Found no initialized map application"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 831
    const/4 v3, 0x0

    goto :goto_1
.end method

.method private propagateDataChange(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;)Z
    .locals 3
    .param p1, "action"    # Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;

    .prologue
    .line 723
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mRetryDirtyDataScheduler:Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->setDirtyData()Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;

    move-result-object v1

    .line 727
    .local v1, "syncDirtyScheduler":Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeToAllMapApplications(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    .line 728
    .local v0, "success":Z
    if-eqz v0, :cond_0

    .line 734
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;->markDataNotDirty()V

    :cond_0
    return v0

    .line 732
    .end local v0    # "success":Z
    :catchall_0
    move-exception v2

    throw v2
.end method

.method private propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
    .locals 2
    .param p1, "action"    # Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;

    .prologue
    .line 707
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->PROPAGATION_EXECUTOR:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$11;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$11;-><init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 719
    return-void
.end method

.method private propagateDataChangeToAllMapApplications(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;)Z
    .locals 13
    .param p1, "action"    # Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;

    .prologue
    .line 741
    const/4 v7, 0x1

    .line 742
    .local v7, "success":Z
    iget-object v8, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v8}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v8

    invoke-virtual {v8}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAllMapApplication()Ljava/util/Collection;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .line 744
    .local v4, "info":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->isSelf()Z

    move-result v8

    if-nez v8, :cond_0

    .line 746
    sget-object v8, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const/4 v8, 0x3

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-interface {p1}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;->getName()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x2

    iget-object v10, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    .line 755
    new-instance v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;

    iget-object v8, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v5, v8, v4}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)V

    .line 757
    .local v5, "remoteMapInstanceDataStorage":Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;
    const/4 v6, 0x0

    .line 758
    .local v6, "remoteSuccessful":Z
    const/4 v1, 0x0

    .line 759
    .local v1, "communicationSuccessful":Z
    const/4 v0, 0x0

    .line 762
    .local v0, "attempts":I
    :cond_1
    add-int/lit8 v0, v0, 0x1

    .line 765
    :try_start_0
    invoke-interface {p1, v5}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;->performAction(Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;)Z
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v6

    .line 766
    const/4 v1, 0x1

    .line 777
    :goto_1
    if-nez v1, :cond_2

    const/4 v8, 0x2

    if-lt v0, v8, :cond_1

    .line 779
    :cond_2
    if-nez v6, :cond_3

    .line 781
    sget-object v8, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Failed action %s with remote package %s."

    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-interface {p1}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;->getName()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x1

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 787
    :cond_3
    and-int/2addr v7, v6

    .line 788
    goto :goto_0

    .line 768
    :catch_0
    move-exception v2

    .line 770
    .local v2, "e":Ljava/lang/RuntimeException;
    sget-object v8, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Package %s threw runtime exception while propogating action %s"

    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x1

    invoke-interface {p1}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;->getName()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 790
    .end local v0    # "attempts":I
    .end local v1    # "communicationSuccessful":Z
    .end local v2    # "e":Ljava/lang/RuntimeException;
    .end local v4    # "info":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .end local v5    # "remoteMapInstanceDataStorage":Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;
    .end local v6    # "remoteSuccessful":Z
    :cond_4
    if-eqz v7, :cond_5

    .line 792
    sget-object v8, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Action %s was synced to all other MAP instances successfully"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-interface {p1}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;->getName()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 794
    invoke-interface {p1}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;->setActionPerformed()V

    .line 797
    :cond_5
    return v7
.end method

.method public static setIsInitialized(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 853
    const-string/jumbo v0, "distributed.datastore.info.store"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 855
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string/jumbo v1, "distributed.datastore.init.key"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v0

    .line 856
    if-nez v0, :cond_0

    .line 858
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Was unable to save distributed store initialized"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 860
    :cond_0
    return-void
.end method

.method public static shouldPlatformUseThisStore(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z
    .locals 1
    .param p0, "platform"    # Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .prologue
    .line 105
    invoke-static {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->shouldPlatformUseThisStore(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z
    .locals 5
    .param p1, "displayName"    # Ljava/lang/String;
    .param p2, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;

    .prologue
    .line 255
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 260
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getSnapShotOfData()Ljava/util/Collection;

    move-result-object v0

    .line 261
    .local v0, "allData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->saveHighestTimestampFromDBSnapshot(Ljava/util/Collection;)V

    .line 263
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getNewTimestamp()Ljava/util/Date;

    move-result-object v2

    .line 265
    .local v2, "timestamp":Ljava/util/Date;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    const/4 v4, 0x0

    invoke-virtual {v3, p1, p2, v2, v4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z

    move-result v1

    .line 271
    .local v1, "successful":Z
    new-instance v3, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;

    invoke-direct {v3, p0, p1, p2, v2}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;-><init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;)V

    invoke-direct {p0, v3, p3}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 296
    monitor-exit p0

    return v1

    .line 255
    .end local v0    # "allData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    .end local v1    # "successful":Z
    .end local v2    # "timestamp":Ljava/util/Date;
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized expireToken(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 618
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 620
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getNewTimestamp()Ljava/util/Date;

    move-result-object v0

    .line 621
    .local v0, "timestamp":Ljava/util/Date;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, p2, v0, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->expireToken(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v1

    .line 623
    if-nez v1, :cond_0

    .line 625
    sget-object v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Expiring the token was not successful"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 651
    :goto_0
    monitor-exit p0

    return-void

    .line 629
    :cond_0
    :try_start_1
    new-instance v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$9;

    invoke-direct {v1, p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$9;-><init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 618
    .end local v0    # "timestamp":Ljava/util/Date;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public getAccountNames()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 245
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 247
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAccountNames()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getAccounts()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 237
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 239
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAccounts()Ljava/util/Set;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    .line 237
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 656
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 658
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    .line 656
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getDirectedId(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "displayName"    # Ljava/lang/String;

    .prologue
    .line 868
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "It is not supported on DistributedDataStorage!"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getDisplayName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 874
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "It is not supported on DistributedDataStorage!"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public declared-synchronized getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 438
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 440
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    .line 438
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 339
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 341
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    .line 339
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized initialize()V
    .locals 6

    .prologue
    .line 111
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "distributed.datastore.info.store"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string/jumbo v1, "distributed.datastore.init.key"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-eqz v0, :cond_0

    .line 119
    :goto_0
    monitor-exit p0

    return-void

    .line 116
    :cond_0
    :try_start_1
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->getLatestInitializedMapApplication()Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    move-result-object v0

    if-nez v0, :cond_1

    sget-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Did not find another MAP application to get initial data from."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    :goto_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->setIsInitialized(Landroid/content/Context;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 111
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 116
    :cond_1
    :try_start_2
    sget-object v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Initializing data storage from application %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v1, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2, v0}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)V

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->getAllData()Ljava/util/Collection;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setSnapshotOfData(Ljava/util/Collection;)Z

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->saveHighestTimestampFromDBSnapshot(Ljava/util/Collection;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public declared-synchronized removeAccount(Ljava/lang/String;)V
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 302
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 304
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getNewTimestamp()Ljava/util/Date;

    move-result-object v0

    .line 305
    .local v0, "timestamp":Ljava/util/Date;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v0, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->removeAccount(Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v1

    .line 306
    if-nez v1, :cond_0

    .line 308
    sget-object v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Removing the account was not successful"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 334
    :goto_0
    monitor-exit p0

    return-void

    .line 312
    :cond_0
    :try_start_1
    new-instance v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$3;

    invoke-direct {v1, p0, p1, v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$3;-><init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/lang/String;Ljava/util/Date;)V

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 302
    .end local v0    # "timestamp":Ljava/util/Date;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public saveHighestTimestampFromDBSnapshot(Ljava/util/Collection;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 147
    .local p1, "snapshot":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    const-wide/16 v3, -0x1

    .line 148
    .local v3, "highestTimestamp":J
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map;

    .line 152
    .local v6, "item":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_0
    const-string/jumbo v7, "timestamp_key"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-static {v7}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v0

    .line 153
    .local v0, "currentTimestamp":J
    cmp-long v7, v0, v3

    if-lez v7, :cond_0

    .line 155
    move-wide v3, v0

    goto :goto_0

    .line 162
    .end local v0    # "currentTimestamp":J
    .end local v6    # "item":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    const-wide/16 v7, -0x1

    cmp-long v7, v3, v7

    if-nez v7, :cond_2

    .line 165
    sget-object v7, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Not able to find a timestamp from the DB snapshot used to initialize the current apps"

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 171
    :goto_1
    return-void

    .line 169
    :cond_2
    new-instance v2, Ljava/util/Date;

    invoke-direct {v2, v3, v4}, Ljava/util/Date;-><init>(J)V

    .line 170
    .local v2, "dateTime":Ljava/util/Date;
    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v7, v2}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->markDateSeen(Ljava/util/Date;)Z

    goto :goto_1

    .line 160
    .end local v2    # "dateTime":Ljava/util/Date;
    .restart local v6    # "item":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_0
    move-exception v7

    goto :goto_0
.end method

.method public setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V
    .locals 7
    .param p1, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    .prologue
    .line 534
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 536
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getNewTimestamp()Ljava/util/Date;

    move-result-object v4

    .line 537
    .local v4, "timestamp":Ljava/util/Date;
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v4, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z

    move-result v6

    .line 538
    .local v6, "success":Z
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v3

    .line 539
    .local v3, "directedId":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getTokens()Ljava/util/Map;

    move-result-object v2

    .line 540
    .local v2, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData()Ljava/util/Map;

    move-result-object v5

    .line 542
    .local v5, "userData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez v6, :cond_0

    .line 544
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Setting the data was not successful"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 613
    :goto_0
    return-void

    .line 548
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;-><init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/util/Map;Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;)V

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V

    goto :goto_0
.end method

.method public declared-synchronized setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 11
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 664
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 666
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getNewTimestamp()Ljava/util/Date;

    move-result-object v4

    .line 667
    .local v4, "timestamp":Ljava/util/Date;
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    const/4 v5, 0x0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v0

    .line 669
    if-nez v0, :cond_0

    .line 671
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Setting the token was not successful"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 697
    :goto_0
    monitor-exit p0

    return-void

    .line 675
    :cond_0
    :try_start_1
    new-instance v5, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;

    move-object v6, p0

    move-object v7, p1

    move-object v8, p2

    move-object v9, p3

    move-object v10, v4

    invoke-direct/range {v5 .. v10}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;-><init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    const/4 v0, 0x0

    invoke-direct {p0, v5, v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 664
    .end local v4    # "timestamp":Ljava/util/Date;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 11
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;

    .prologue
    .line 446
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 448
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getNewTimestamp()Ljava/util/Date;

    move-result-object v4

    .line 449
    .local v4, "timestamp":Ljava/util/Date;
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    const/4 v5, 0x0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v0

    .line 451
    if-nez v0, :cond_0

    .line 453
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Setting the token was not successful"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 479
    :goto_0
    monitor-exit p0

    return-void

    .line 457
    :cond_0
    :try_start_1
    new-instance v5, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$6;

    move-object v6, p0

    move-object v7, p1

    move-object v8, p2

    move-object v9, p3

    move-object v10, v4

    invoke-direct/range {v5 .. v10}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$6;-><init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    const/4 v0, 0x0

    invoke-direct {p0, v5, v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 446
    .end local v4    # "timestamp":Ljava/util/Date;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setTokens(Ljava/lang/String;Ljava/util/Map;)V
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 484
    .local p2, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 486
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getNewTimestamp()Ljava/util/Date;

    move-result-object v0

    .line 487
    .local v0, "timestamp":Ljava/util/Date;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    new-instance v2, Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    const/4 v3, 0x0

    invoke-direct {v2, p1, v3, p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v0, v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setTokens(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z

    move-result v1

    .line 490
    if-nez v1, :cond_0

    .line 492
    sget-object v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Setting the token was not successful"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 529
    :goto_0
    monitor-exit p0

    return-void

    .line 496
    :cond_0
    :try_start_1
    new-instance v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;

    invoke-direct {v1, p0, p2, p1, v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;-><init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/util/Map;Ljava/lang/String;Ljava/util/Date;)V

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 484
    .end local v0    # "timestamp":Ljava/util/Date;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 11
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 347
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 349
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getNewTimestamp()Ljava/util/Date;

    move-result-object v4

    .line 350
    .local v4, "timestamp":Ljava/util/Date;
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    const/4 v5, 0x0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Z

    move-result v0

    .line 352
    if-nez v0, :cond_0

    .line 354
    sget-object v0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Setting the userdata was not successful"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 380
    :goto_0
    monitor-exit p0

    return-void

    .line 358
    :cond_0
    :try_start_1
    new-instance v5, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$4;

    move-object v6, p0

    move-object v7, p1

    move-object v8, p2

    move-object v9, p3

    move-object v10, v4

    invoke-direct/range {v5 .. v10}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$4;-><init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    const/4 v0, 0x0

    invoke-direct {p0, v5, v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 347
    .end local v4    # "timestamp":Ljava/util/Date;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setUserData(Ljava/lang/String;Ljava/util/Map;)V
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 385
    .local p2, "userData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 387
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getNewTimestamp()Ljava/util/Date;

    move-result-object v0

    .line 388
    .local v0, "timestamp":Ljava/util/Date;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    new-instance v2, Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    const/4 v3, 0x0

    invoke-direct {v2, p1, p2, v3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v0, v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setUserData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;Z)Z

    move-result v1

    .line 391
    if-nez v1, :cond_0

    .line 393
    sget-object v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Setting the userdata was not successful"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 433
    :goto_0
    monitor-exit p0

    return-void

    .line 397
    :cond_0
    :try_start_1
    new-instance v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$5;

    invoke-direct {v1, p0, p2, p1, v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$5;-><init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/util/Map;Ljava/lang/String;Ljava/util/Date;)V

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 385
    .end local v0    # "timestamp":Ljava/util/Date;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized setup()V
    .locals 3

    .prologue
    .line 176
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getLatestMapApp()Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    move-result-object v0

    .line 177
    .local v0, "info":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 179
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Am not the latest application. Not creating alarm to clean database"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 186
    :goto_0
    monitor-exit p0

    return-void

    .line 183
    :cond_1
    :try_start_1
    sget-object v1, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Am the latest application. Setting up alarm to clean database"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    new-instance v1, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;-><init>(Landroid/content/Context;)V

    .line 185
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->scheduleDatabaseClean()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 176
    .end local v0    # "info":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized syncDirtyData()V
    .locals 4

    .prologue
    .line 191
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->initialize()V

    .line 197
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLambortishClock:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getNewTimestamp()Ljava/util/Date;

    move-result-object v1

    .line 198
    .local v1, "timestamp":Ljava/util/Date;
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    invoke-virtual {v2, v1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getAllDirtyData(Ljava/util/Date;)Ljava/util/Collection;

    move-result-object v0

    .line 199
    .local v0, "allCurrentDirtyData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {v0}, Ljava/util/Collection;->size()I

    move-result v2

    if-nez v2, :cond_0

    .line 201
    sget-object v2, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->TAG:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 232
    :goto_0
    monitor-exit p0

    return-void

    .line 205
    :cond_0
    :try_start_1
    new-instance v2, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$1;

    invoke-direct {v2, p0, v0, v1}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$1;-><init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/util/Collection;Ljava/util/Date;)V

    const/4 v3, 0x0

    invoke-direct {p0, v2, v3}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 191
    .end local v0    # "allCurrentDirtyData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    .end local v1    # "timestamp":Ljava/util/Date;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method
