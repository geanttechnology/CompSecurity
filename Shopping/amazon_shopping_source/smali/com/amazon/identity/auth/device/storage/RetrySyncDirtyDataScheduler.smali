.class public Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;
.super Ljava/lang/Object;
.source "RetrySyncDirtyDataScheduler.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$1;,
        Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static final WAIT_TO_RETRY_SYNC_DIRTY_DATA_MS_DEFAULT:J

.field static final WAIT_TO_RETRY_SYNC_DIRTY_DATA_MS_KEY:Ljava/lang/String; = "wait_to_retry_sync_dirty_data_ms"


# instance fields
.field private final mAlarmManager:Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;

.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mLock:[Ljava/lang/Object;

.field private final mSystem:Lcom/amazon/identity/auth/device/framework/SystemWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 24
    const-class v0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->TAG:Ljava/lang/String;

    .line 29
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0xf

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->WAIT_TO_RETRY_SYNC_DIRTY_DATA_MS_DEFAULT:J

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mLock:[Ljava/lang/Object;

    .line 70
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 71
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v1, "sso_alarm_maanger"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mAlarmManager:Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;

    .line 72
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v1, "dcp_system"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mSystem:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    .line 73
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;)[Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mLock:[Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    sget-object v0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;)Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mAlarmManager:Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;Ljava/lang/Long;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;
    .param p1, "x1"    # Ljava/lang/Long;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->setNextScheduledDirtyDataSync(Ljava/lang/Long;)V

    return-void
.end method

.method private getStore()Landroid/content/SharedPreferences;
    .locals 3

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v1, "sync_dirty_data_store"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method public static getSyncDirtyDataPendingIntent(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 174
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "com.amazon.identity.action.SYNC_DIRTY_DATA"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-class v1, Lcom/amazon/identity/auth/device/storage/DirtyDataSyncingService;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 175
    .local v0, "syncDirtyDataIntent":Landroid/content/Intent;
    const/4 v1, 0x0

    const/high16 v2, 0x40000000    # 2.0f

    invoke-static {p0, v1, v0, v2}, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    move-result-object v1

    return-object v1
.end method

.method private setNextScheduledDirtyDataSync(Ljava/lang/Long;)V
    .locals 4
    .param p1, "nextTime"    # Ljava/lang/Long;

    .prologue
    .line 143
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->getStore()Landroid/content/SharedPreferences;

    move-result-object v1

    .line 144
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 145
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    if-eqz p1, :cond_1

    .line 147
    const-string/jumbo v1, "sync_dirty_data_store_time"

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 154
    :goto_0
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    if-nez v1, :cond_0

    .line 156
    sget-object v1, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Unable to save next scheduled dirty data sync"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    :cond_0
    return-void

    .line 151
    :cond_1
    const-string/jumbo v1, "sync_dirty_data_store_time"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0
.end method


# virtual methods
.method public setDirtyData()Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;
    .locals 10

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x1

    .line 77
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mLock:[Ljava/lang/Object;

    monitor-enter v5

    .line 79
    :try_start_0
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mSystem:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/framework/SystemWrapper;->currentTimeMillis()J

    move-result-wide v0

    .line 80
    .local v0, "currentTime":J
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->getStore()Landroid/content/SharedPreferences;

    move-result-object v6

    const-string/jumbo v7, "sync_dirty_data_store_time"

    invoke-interface {v6, v7}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    const-string/jumbo v7, "sync_dirty_data_store_time"

    const-wide/16 v8, 0x0

    invoke-interface {v6, v7, v8, v9}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    .line 81
    .local v2, "lastScheduledDirtySyncTime":Ljava/lang/Long;
    :goto_0
    if-nez v2, :cond_2

    :cond_0
    :goto_1
    if-nez v4, :cond_3

    .line 84
    .local v3, "pendingSyncDirtyDataIntent":Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    :goto_2
    if-nez v3, :cond_4

    sget-object v4, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->TAG:Ljava/lang/String;

    .line 86
    :goto_3
    new-instance v4, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;

    const/4 v6, 0x0

    invoke-direct {v4, p0, v3, v2, v6}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;-><init>(Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;Ljava/lang/Long;Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$1;)V

    monitor-exit v5

    return-object v4

    .end local v2    # "lastScheduledDirtySyncTime":Ljava/lang/Long;
    .end local v3    # "pendingSyncDirtyDataIntent":Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    :cond_1
    move-object v2, v3

    .line 80
    goto :goto_0

    .line 81
    .restart local v2    # "lastScheduledDirtySyncTime":Ljava/lang/Long;
    :cond_2
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    cmp-long v6, v6, v0

    if-lez v6, :cond_0

    const/4 v4, 0x0

    goto :goto_1

    :cond_3
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v4}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->getSyncDirtyDataPendingIntent(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    move-result-object v3

    goto :goto_2

    .line 84
    .restart local v3    # "pendingSyncDirtyDataIntent":Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    :cond_4
    sget-object v4, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->TAG:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v4}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v4

    const-string/jumbo v6, "wait_to_retry_sync_dirty_data_ms"

    sget-wide v7, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->WAIT_TO_RETRY_SYNC_DIRTY_DATA_MS_DEFAULT:J

    invoke-virtual {v4, v6, v7, v8}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingLong(Ljava/lang/String;J)J

    move-result-wide v6

    add-long/2addr v6, v0

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mAlarmManager:Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;

    const/4 v8, 0x1

    invoke-virtual {v4, v8, v6, v7, v3}, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->set(IJLcom/amazon/identity/auth/device/framework/PendingIntentWrapper;)V

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->setNextScheduledDirtyDataSync(Ljava/lang/Long;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_3

    .line 87
    .end local v0    # "currentTime":J
    .end local v2    # "lastScheduledDirtySyncTime":Ljava/lang/Long;
    .end local v3    # "pendingSyncDirtyDataIntent":Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4
.end method
