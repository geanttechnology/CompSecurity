.class public Lcom/amazon/identity/auth/device/storage/LambortishClock;
.super Ljava/lang/Object;
.source "LambortishClock.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/LambortishClock$ChangeTimestampsBroadcastReceiver;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/LambortishClock;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mDeltaMs:Ljava/lang/Long;

.field private mGreatestTimeStampMs:Ljava/lang/Long;

.field private final mSystem:Lcom/amazon/identity/auth/device/framework/SystemWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const-class v0, Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 72
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mContext:Landroid/content/Context;

    .line 74
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_system"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mSystem:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    .line 75
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private getGreatestTimestampSeen(Landroid/content/SharedPreferences;)J
    .locals 3
    .param p1, "clockStore"    # Landroid/content/SharedPreferences;

    .prologue
    .line 157
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mGreatestTimeStampMs:Ljava/lang/Long;

    if-nez v0, :cond_0

    .line 159
    const-string/jumbo v0, "greatest_timestamp_ms_seen_key"

    const-wide/16 v1, 0x0

    invoke-interface {p1, v0, v1, v2}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mGreatestTimeStampMs:Ljava/lang/Long;

    .line 162
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mGreatestTimeStampMs:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/LambortishClock;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 79
    const-class v1, Lcom/amazon/identity/auth/device/storage/LambortishClock;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 81
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LambortishClock;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/storage/LambortishClock;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/LambortishClock;

    .line 84
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/LambortishClock;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 79
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private getStore()Landroid/content/SharedPreferences;
    .locals 3

    .prologue
    .line 199
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "Lambortish_Clock_Store"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method private saveGreatestTimestampSeen(Landroid/content/SharedPreferences;J)Z
    .locals 3
    .param p1, "clockStore"    # Landroid/content/SharedPreferences;
    .param p2, "curTimestamp"    # J

    .prologue
    .line 167
    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mGreatestTimeStampMs:Ljava/lang/Long;

    .line 168
    invoke-interface {p1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string/jumbo v1, "greatest_timestamp_ms_seen_key"

    invoke-interface {v0, v1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v0

    .line 169
    if-nez v0, :cond_0

    .line 171
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Could not save the greatest timestamp seen!"

    new-instance v2, Ljava/lang/Throwable;

    invoke-direct {v2}, Ljava/lang/Throwable;-><init>()V

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 172
    const/4 v0, 0x0

    .line 174
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized getNewTimestamp()Ljava/util/Date;
    .locals 10

    .prologue
    .line 89
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getStore()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 91
    .local v0, "clockStore":Landroid/content/SharedPreferences;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getGreatestTimestampSeen(Landroid/content/SharedPreferences;)J

    move-result-wide v3

    .line 93
    .local v3, "greatestTimestampSeen":J
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mSystem:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/SystemWrapper;->currentTimeMillis()J

    move-result-wide v5

    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mDeltaMs:Ljava/lang/Long;

    if-nez v7, :cond_0

    const-string/jumbo v7, "cur_delta_ms_key"

    const-wide/16 v8, 0x0

    invoke-interface {v0, v7, v8, v9}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mDeltaMs:Ljava/lang/Long;

    :cond_0
    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mDeltaMs:Ljava/lang/Long;

    invoke-virtual {v7}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    add-long v1, v5, v7

    cmp-long v7, v1, v3

    if-lez v7, :cond_2

    .line 95
    .local v1, "curTimestamp":J
    :cond_1
    :goto_0
    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->saveGreatestTimestampSeen(Landroid/content/SharedPreferences;J)Z

    .line 97
    new-instance v5, Ljava/util/Date;

    invoke-direct {v5, v1, v2}, Ljava/util/Date;-><init>(J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v5

    .line 93
    .end local v1    # "curTimestamp":J
    :cond_2
    const-wide/16 v7, 0x64

    add-long v1, v3, v7

    sub-long v5, v1, v5

    :try_start_1
    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mDeltaMs:Ljava/lang/Long;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v7

    const-string/jumbo v8, "cur_delta_ms_key"

    invoke-interface {v7, v8, v5, v6}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v5

    if-nez v5, :cond_1

    sget-object v5, Lcom/amazon/identity/auth/device/storage/LambortishClock;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Could not save the new delta!"

    new-instance v7, Ljava/lang/Throwable;

    invoke-direct {v7}, Ljava/lang/Throwable;-><init>()V

    invoke-static {v5, v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 89
    .end local v0    # "clockStore":Landroid/content/SharedPreferences;
    .end local v3    # "greatestTimestampSeen":J
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5
.end method

.method public declared-synchronized markDateSeen(Ljava/util/Date;)Z
    .locals 7
    .param p1, "seenTimestamp"    # Ljava/util/Date;

    .prologue
    const/4 v5, 0x0

    .line 106
    monitor-enter p0

    if-nez p1, :cond_1

    .line 122
    :cond_0
    :goto_0
    monitor-exit p0

    return v5

    .line 111
    :cond_1
    :try_start_0
    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v3

    .line 113
    .local v3, "seenTimestampMs":J
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getStore()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 115
    .local v0, "clockStore":Landroid/content/SharedPreferences;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getGreatestTimestampSeen(Landroid/content/SharedPreferences;)J

    move-result-wide v1

    .line 117
    .local v1, "greatestTimestampSeen":J
    cmp-long v6, v3, v1

    if-lez v6, :cond_0

    .line 119
    sget-object v5, Lcom/amazon/identity/auth/device/storage/LambortishClock;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Saving greatest timestamp seen : "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 120
    invoke-direct {p0, v0, v3, v4}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->saveGreatestTimestampSeen(Landroid/content/SharedPreferences;J)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v5

    goto :goto_0

    .line 106
    .end local v0    # "clockStore":Landroid/content/SharedPreferences;
    .end local v1    # "greatestTimestampSeen":J
    .end local v3    # "seenTimestampMs":J
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5
.end method

.method public declared-synchronized notifySystemTimeChanged()V
    .locals 7

    .prologue
    .line 129
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getNewTimestamp()Ljava/util/Date;

    move-result-object v0

    .line 130
    .local v0, "curTimestamp":Ljava/util/Date;
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LambortishClock;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Users clock moved. System time is %s and timestamp is %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/LambortishClock;->mSystem:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/SystemWrapper;->currentTimeMillis()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 134
    monitor-exit p0

    return-void

    .line 129
    .end local v0    # "curTimestamp":Ljava/util/Date;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
