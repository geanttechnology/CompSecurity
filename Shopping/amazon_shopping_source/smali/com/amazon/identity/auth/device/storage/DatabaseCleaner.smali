.class public Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;
.super Ljava/lang/Object;
.source "DatabaseCleaner.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;
    }
.end annotation


# static fields
.field public static final CLEAN_DATA_ACTION:Ljava/lang/String; = "com.amazon.identity.action.CLEAN_DATA"

.field private static final LOCK:[Ljava/lang/Object;

.field private static final TAG:Ljava/lang/String;

.field public static final WAIT_TO_CLEAN_DATABASE_MS_KEY:Ljava/lang/String; = "wait_to_clean_database_ms"


# instance fields
.field private final mAlarmManager:Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;

.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mSystem:Lcom/amazon/identity/auth/device/framework/SystemWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->TAG:Ljava/lang/String;

    .line 86
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    sput-object v0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->LOCK:[Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 98
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 100
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 102
    .local v0, "factory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 104
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v2, "sso_alarm_maanger"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mAlarmManager:Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;

    .line 105
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v2, "dcp_system"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mSystem:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    .line 106
    return-void
.end method

.method private cleanDatabaseOfUnneededDeletedItems(Ljava/util/Collection;Ljava/util/Collection;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;",
            ">;",
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
    .line 182
    .local p1, "remoteMapInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    .local p2, "itemsToDelete":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .line 184
    .local v1, "remoteMapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    new-instance v2, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v2, v3, v1}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)V

    .line 186
    invoke-virtual {v2, p2}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->clearBulkData(Ljava/util/Collection;)Z

    move-result v2

    .line 187
    if-nez v2, :cond_0

    .line 189
    sget-object v2, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Was not fully successful remotely removing deleted items"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 192
    .end local v1    # "remoteMapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :cond_1
    return-void
.end method

.method public static getCleanDatabaseIntent(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 255
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "com.amazon.identity.action.CLEAN_DATA"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-class v1, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 256
    .local v0, "cleanDatabaseIntent":Landroid/content/Intent;
    const/4 v1, 0x0

    const/high16 v2, 0x40000000    # 2.0f

    invoke-static {p0, v1, v0, v2}, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public cleanDatabase()V
    .locals 8

    .prologue
    .line 135
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAllMapApplication()Ljava/util/Collection;

    move-result-object v0

    .line 138
    .local v0, "remoteMapInfos":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    const/4 v1, 0x0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    new-instance v3, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v3, v5, v2}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)V

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->getAllDeletedData()Ljava/util/Collection;

    move-result-object v3

    if-nez v3, :cond_0

    sget-object v3, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Remote Package %s is unable to provide any deleted data"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->toString()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    if-nez v1, :cond_1

    move-object v1, v3

    goto :goto_0

    :cond_1
    invoke-interface {v1, v3}, Ljava/util/Collection;->retainAll(Ljava/util/Collection;)Z

    goto :goto_0

    :cond_2
    sget-object v2, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Deleting Values: "

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-eqz v1, :cond_4

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    :goto_1
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 140
    .local v1, "valuesToRemove":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    if-eqz v1, :cond_3

    invoke-interface {v1}, Ljava/util/Collection;->size()I

    move-result v2

    if-nez v2, :cond_5

    .line 142
    :cond_3
    sget-object v2, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "No Deleted items to clean from the MAP databases"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    :goto_2
    return-void

    .line 138
    .end local v1    # "valuesToRemove":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_4
    const-string/jumbo v2, "None"

    goto :goto_1

    .line 146
    .restart local v1    # "valuesToRemove":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_5
    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->cleanDatabaseOfUnneededDeletedItems(Ljava/util/Collection;Ljava/util/Collection;)V

    goto :goto_2
.end method

.method public scheduleDatabaseClean()V
    .locals 10

    .prologue
    const/4 v4, 0x1

    .line 110
    sget-object v5, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->LOCK:[Ljava/lang/Object;

    monitor-enter v5

    .line 112
    :try_start_0
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mSystem:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/framework/SystemWrapper;->currentTimeMillis()J

    move-result-wide v0

    .line 113
    .local v0, "currentTime":J
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v7, "clean_database_store"

    const-string/jumbo v8, "clean_database_time_ms_key"

    invoke-virtual {v6, v7, v8}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v2

    .line 114
    .local v2, "lastScheduledCleanTime":Ljava/lang/Long;
    if-nez v2, :cond_1

    :cond_0
    :goto_0
    if-nez v4, :cond_2

    const/4 v3, 0x0

    .line 117
    .local v3, "pendingCleanDatabaseIntent":Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    :goto_1
    if-nez v3, :cond_3

    sget-object v4, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->TAG:Ljava/lang/String;

    .line 118
    :goto_2
    monitor-exit v5

    return-void

    .line 114
    .end local v3    # "pendingCleanDatabaseIntent":Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    :cond_1
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    cmp-long v6, v6, v0

    if-lez v6, :cond_0

    const/4 v4, 0x0

    goto :goto_0

    :cond_2
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v4}, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->getCleanDatabaseIntent(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    move-result-object v3

    goto :goto_1

    .line 117
    .restart local v3    # "pendingCleanDatabaseIntent":Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    :cond_3
    sget-object v4, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->TAG:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v4}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v4

    const-string/jumbo v6, "wait_to_clean_database_ms"

    const-wide/16 v7, 0x1

    sget-object v9, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v7, v8, v9}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->fromDaysTo(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v7

    invoke-virtual {v4, v6, v7, v8}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingLong(Ljava/lang/String;J)J

    move-result-wide v6

    add-long/2addr v6, v0

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mAlarmManager:Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;

    const/4 v8, 0x1

    invoke-virtual {v4, v8, v6, v7, v3}, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->set(IJLcom/amazon/identity/auth/device/framework/PendingIntentWrapper;)V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/DatabaseCleaner;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v8, "clean_database_store"

    const-string/jumbo v9, "clean_database_time_ms_key"

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v8, v9, v6}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_2

    .line 118
    .end local v0    # "currentTime":J
    .end local v2    # "lastScheduledCleanTime":Ljava/lang/Long;
    .end local v3    # "pendingCleanDatabaseIntent":Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4
.end method
