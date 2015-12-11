.class Lcom/google/tagmanager/PersistentHitStore;
.super Ljava/lang/Object;
.source "PersistentHitStore.java"

# interfaces
.implements Lcom/google/tagmanager/HitStore;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;,
        Lcom/google/tagmanager/PersistentHitStore$StoreDispatchListener;
    }
.end annotation


# static fields
.field private static final CREATE_HITS_TABLE:Ljava/lang/String;

.field private static final DATABASE_FILENAME:Ljava/lang/String; = "gtm_urls.db"

.field static final HITS_TABLE:Ljava/lang/String; = "gtm_hits"
    .annotation build Lcom/google/android/gms/common/util/VisibleForTesting;
    .end annotation
.end field

.field static final HIT_DISPATCH_RETRY_WINDOW:J = 0xdbba00L

.field static final HIT_FIRST_DISPATCH_TIME:Ljava/lang/String; = "hit_first_send_time"
    .annotation build Lcom/google/android/gms/common/util/VisibleForTesting;
    .end annotation
.end field

.field static final HIT_ID:Ljava/lang/String; = "hit_id"
    .annotation build Lcom/google/android/gms/common/util/VisibleForTesting;
    .end annotation
.end field

.field private static final HIT_ID_WHERE_CLAUSE:Ljava/lang/String; = "hit_id=?"

.field static final HIT_TIME:Ljava/lang/String; = "hit_time"
    .annotation build Lcom/google/android/gms/common/util/VisibleForTesting;
    .end annotation
.end field

.field static final HIT_URL:Ljava/lang/String; = "hit_url"
    .annotation build Lcom/google/android/gms/common/util/VisibleForTesting;
    .end annotation
.end field


# instance fields
.field private mClock:Lcom/google/tagmanager/Clock;

.field private final mContext:Landroid/content/Context;

.field private final mDatabaseName:Ljava/lang/String;

.field private final mDbHelper:Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;

.field private volatile mDispatcher:Lcom/google/tagmanager/Dispatcher;

.field private mLastDeleteStaleHitsTime:J

.field private final mListener:Lcom/google/tagmanager/HitStoreStateListener;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 55
    const-string v0, "CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL,\'%s\' INTEGER NOT NULL);"

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "gtm_hits"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "hit_id"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "hit_time"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "hit_url"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "hit_first_send_time"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/google/tagmanager/PersistentHitStore;->CREATE_HITS_TABLE:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Lcom/google/tagmanager/HitStoreStateListener;Landroid/content/Context;)V
    .locals 1
    .param p1, "listener"    # Lcom/google/tagmanager/HitStoreStateListener;
    .param p2, "ctx"    # Landroid/content/Context;

    .prologue
    .line 91
    const-string v0, "gtm_urls.db"

    invoke-direct {p0, p1, p2, v0}, Lcom/google/tagmanager/PersistentHitStore;-><init>(Lcom/google/tagmanager/HitStoreStateListener;Landroid/content/Context;Ljava/lang/String;)V

    .line 92
    return-void
.end method

.method constructor <init>(Lcom/google/tagmanager/HitStoreStateListener;Landroid/content/Context;Ljava/lang/String;)V
    .locals 4
    .param p1, "listener"    # Lcom/google/tagmanager/HitStoreStateListener;
    .param p2, "ctx"    # Landroid/content/Context;
    .param p3, "databaseName"    # Ljava/lang/String;
    .annotation build Lcom/google/android/gms/common/util/VisibleForTesting;
    .end annotation

    .prologue
    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 104
    invoke-virtual {p2}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/google/tagmanager/PersistentHitStore;->mContext:Landroid/content/Context;

    .line 105
    iput-object p3, p0, Lcom/google/tagmanager/PersistentHitStore;->mDatabaseName:Ljava/lang/String;

    .line 106
    iput-object p1, p0, Lcom/google/tagmanager/PersistentHitStore;->mListener:Lcom/google/tagmanager/HitStoreStateListener;

    .line 107
    new-instance v0, Lcom/google/tagmanager/PersistentHitStore$1;

    invoke-direct {v0, p0}, Lcom/google/tagmanager/PersistentHitStore$1;-><init>(Lcom/google/tagmanager/PersistentHitStore;)V

    iput-object v0, p0, Lcom/google/tagmanager/PersistentHitStore;->mClock:Lcom/google/tagmanager/Clock;

    .line 113
    new-instance v0, Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;

    iget-object v1, p0, Lcom/google/tagmanager/PersistentHitStore;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/google/tagmanager/PersistentHitStore;->mDatabaseName:Ljava/lang/String;

    invoke-direct {v0, p0, v1, v2}, Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;-><init>(Lcom/google/tagmanager/PersistentHitStore;Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/google/tagmanager/PersistentHitStore;->mDbHelper:Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;

    .line 114
    new-instance v0, Lcom/google/tagmanager/SimpleNetworkDispatcher;

    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v1}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    iget-object v2, p0, Lcom/google/tagmanager/PersistentHitStore;->mContext:Landroid/content/Context;

    new-instance v3, Lcom/google/tagmanager/PersistentHitStore$StoreDispatchListener;

    invoke-direct {v3, p0}, Lcom/google/tagmanager/PersistentHitStore$StoreDispatchListener;-><init>(Lcom/google/tagmanager/PersistentHitStore;)V

    invoke-direct {v0, v1, v2, v3}, Lcom/google/tagmanager/SimpleNetworkDispatcher;-><init>(Lorg/apache/http/client/HttpClient;Landroid/content/Context;Lcom/google/tagmanager/SimpleNetworkDispatcher$DispatchListener;)V

    iput-object v0, p0, Lcom/google/tagmanager/PersistentHitStore;->mDispatcher:Lcom/google/tagmanager/Dispatcher;

    .line 118
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/google/tagmanager/PersistentHitStore;->mLastDeleteStaleHitsTime:J

    .line 119
    return-void
.end method

.method static synthetic access$000(Lcom/google/tagmanager/PersistentHitStore;J)V
    .locals 1
    .param p0, "x0"    # Lcom/google/tagmanager/PersistentHitStore;
    .param p1, "x1"    # J

    .prologue
    .line 37
    invoke-direct {p0, p1, p2}, Lcom/google/tagmanager/PersistentHitStore;->deleteHit(J)V

    return-void
.end method

.method static synthetic access$100(Lcom/google/tagmanager/PersistentHitStore;)Lcom/google/tagmanager/Clock;
    .locals 1
    .param p0, "x0"    # Lcom/google/tagmanager/PersistentHitStore;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/google/tagmanager/PersistentHitStore;->mClock:Lcom/google/tagmanager/Clock;

    return-object v0
.end method

.method static synthetic access$200(Lcom/google/tagmanager/PersistentHitStore;JJ)V
    .locals 1
    .param p0, "x0"    # Lcom/google/tagmanager/PersistentHitStore;
    .param p1, "x1"    # J
    .param p3, "x2"    # J

    .prologue
    .line 37
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/google/tagmanager/PersistentHitStore;->setHitFirstDispatchTime(JJ)V

    return-void
.end method

.method static synthetic access$300(Lcom/google/tagmanager/PersistentHitStore;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/google/tagmanager/PersistentHitStore;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/google/tagmanager/PersistentHitStore;->mDatabaseName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/google/tagmanager/PersistentHitStore;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/google/tagmanager/PersistentHitStore;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/google/tagmanager/PersistentHitStore;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$500()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/google/tagmanager/PersistentHitStore;->CREATE_HITS_TABLE:Ljava/lang/String;

    return-object v0
.end method

.method private deleteHit(J)V
    .locals 3
    .param p1, "hitId"    # J

    .prologue
    .line 380
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-virtual {p0, v0}, Lcom/google/tagmanager/PersistentHitStore;->deleteHits([Ljava/lang/String;)V

    .line 381
    return-void
.end method

.method private getWritableDatabase(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    .locals 3
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 529
    const/4 v0, 0x0

    .line 531
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    iget-object v2, p0, Lcom/google/tagmanager/PersistentHitStore;->mDbHelper:Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;

    invoke-virtual {v2}, Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    move-object v2, v0

    .line 536
    :goto_0
    return-object v2

    .line 532
    :catch_0
    move-exception v1

    .line 533
    .local v1, "e":Landroid/database/sqlite/SQLiteException;
    invoke-static {p1}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V

    .line 534
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private removeOldHitIfFull()V
    .locals 4

    .prologue
    .line 153
    invoke-virtual {p0}, Lcom/google/tagmanager/PersistentHitStore;->getNumStoredHits()I

    move-result v2

    add-int/lit16 v2, v2, -0x7d0

    add-int/lit8 v0, v2, 0x1

    .line 154
    .local v0, "hitsOverLimit":I
    if-lez v0, :cond_0

    .line 155
    invoke-virtual {p0, v0}, Lcom/google/tagmanager/PersistentHitStore;->peekHitIds(I)Ljava/util/List;

    move-result-object v1

    .line 156
    .local v1, "hitsToDelete":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Store full, deleting "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " hits to make room."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/tagmanager/Log;->v(Ljava/lang/String;)V

    .line 157
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    invoke-virtual {p0, v2}, Lcom/google/tagmanager/PersistentHitStore;->deleteHits([Ljava/lang/String;)V

    .line 159
    .end local v1    # "hitsToDelete":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    return-void
.end method

.method private setHitFirstDispatchTime(JJ)V
    .locals 9
    .param p1, "hitId"    # J
    .param p3, "firstDispatchTime"    # J

    .prologue
    .line 384
    const-string v3, "Error opening database for getNumStoredHits."

    invoke-direct {p0, v3}, Lcom/google/tagmanager/PersistentHitStore;->getWritableDatabase(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 385
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-nez v1, :cond_0

    .line 400
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    return-void

    .line 388
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 389
    .local v0, "cv":Landroid/content/ContentValues;
    const-string v3, "hit_first_send_time"

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 391
    :try_start_0
    const-string v3, "gtm_hits"

    const-string v4, "hit_id=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    instance-of v6, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v6, :cond_1

    invoke-virtual {v1, v3, v0, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 393
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catch_0
    move-exception v2

    .line 394
    .local v2, "e":Landroid/database/sqlite/SQLiteException;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error setting HIT_FIRST_DISPATCH_TIME for hitId: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V

    .line 398
    invoke-direct {p0, p1, p2}, Lcom/google/tagmanager/PersistentHitStore;->deleteHit(J)V

    goto :goto_0

    .line 391
    .end local v2    # "e":Landroid/database/sqlite/SQLiteException;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_1
    :try_start_1
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v3, v0, v4, v5}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->update(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method private writeHitToDatabase(JLjava/lang/String;)V
    .locals 7
    .param p1, "hitTimeInMilliseconds"    # J
    .param p3, "path"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 162
    const-string v3, "Error opening database for putHit"

    invoke-direct {p0, v3}, Lcom/google/tagmanager/PersistentHitStore;->getWritableDatabase(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 163
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-nez v1, :cond_0

    .line 181
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    return-void

    .line 167
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 170
    .local v0, "content":Landroid/content/ContentValues;
    const-string v3, "hit_time"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 171
    const-string v3, "hit_url"

    invoke-virtual {v0, v3, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 172
    const-string v3, "hit_first_send_time"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 174
    :try_start_0
    const-string v3, "gtm_hits"

    const/4 v4, 0x0

    instance-of v5, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v5, :cond_1

    invoke-virtual {v1, v3, v4, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 177
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_1
    iget-object v3, p0, Lcom/google/tagmanager/PersistentHitStore;->mListener:Lcom/google/tagmanager/HitStoreStateListener;

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Lcom/google/tagmanager/HitStoreStateListener;->reportStoreIsEmpty(Z)V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 178
    :catch_0
    move-exception v2

    .line 179
    .local v2, "e":Landroid/database/sqlite/SQLiteException;
    const-string v3, "Error storing hit"

    invoke-static {v3}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V

    goto :goto_0

    .line 174
    .end local v2    # "e":Landroid/database/sqlite/SQLiteException;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_1
    :try_start_1
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v3, v4, v0}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->insert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method


# virtual methods
.method public close()V
    .locals 2

    .prologue
    .line 508
    :try_start_0
    iget-object v1, p0, Lcom/google/tagmanager/PersistentHitStore;->mDbHelper:Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;

    invoke-virtual {v1}, Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 509
    iget-object v1, p0, Lcom/google/tagmanager/PersistentHitStore;->mDispatcher:Lcom/google/tagmanager/Dispatcher;

    invoke-interface {v1}, Lcom/google/tagmanager/Dispatcher;->close()V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 514
    :goto_0
    return-void

    .line 510
    :catch_0
    move-exception v0

    .line 511
    .local v0, "e":Landroid/database/sqlite/SQLiteException;
    const-string v1, "Error opening database for close"

    invoke-static {v1}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V

    goto :goto_0
.end method

.method deleteHits([Ljava/lang/String;)V
    .locals 10
    .param p1, "hitIds"    # [Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 362
    if-eqz p1, :cond_0

    array-length v5, p1

    if-nez v5, :cond_1

    .line 377
    :cond_0
    :goto_0
    return-void

    .line 365
    :cond_1
    const-string v5, "Error opening database for deleteHits."

    invoke-direct {p0, v5}, Lcom/google/tagmanager/PersistentHitStore;->getWritableDatabase(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 366
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-eqz v0, :cond_0

    .line 369
    const-string v5, "HIT_ID in (%s)"

    new-array v6, v3, [Ljava/lang/Object;

    const-string v7, ","

    array-length v8, p1

    const-string v9, "?"

    invoke-static {v8, v9}, Ljava/util/Collections;->nCopies(ILjava/lang/Object;)Ljava/util/List;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v4

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 372
    .local v2, "whereClause":Ljava/lang/String;
    :try_start_0
    const-string v5, "gtm_hits"

    instance-of v6, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v6, :cond_2

    invoke-virtual {v0, v5, v2, p1}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 373
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_1
    iget-object v5, p0, Lcom/google/tagmanager/PersistentHitStore;->mListener:Lcom/google/tagmanager/HitStoreStateListener;

    invoke-virtual {p0}, Lcom/google/tagmanager/PersistentHitStore;->getNumStoredHits()I

    move-result v6

    if-nez v6, :cond_3

    :goto_2
    invoke-interface {v5, v3}, Lcom/google/tagmanager/HitStoreStateListener;->reportStoreIsEmpty(Z)V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 374
    :catch_0
    move-exception v1

    .line 375
    .local v1, "e":Landroid/database/sqlite/SQLiteException;
    const-string v3, "Error deleting hits"

    invoke-static {v3}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V

    goto :goto_0

    .line 372
    .end local v1    # "e":Landroid/database/sqlite/SQLiteException;
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_2
    :try_start_1
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v5, v2, p1}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    :cond_3
    move v3, v4

    .line 373
    goto :goto_2
.end method

.method deleteStaleHits()I
    .locals 12

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 339
    iget-object v8, p0, Lcom/google/tagmanager/PersistentHitStore;->mClock:Lcom/google/tagmanager/Clock;

    invoke-interface {v8}, Lcom/google/tagmanager/Clock;->currentTimeMillis()J

    move-result-wide v4

    .line 342
    .local v4, "now":J
    iget-wide v8, p0, Lcom/google/tagmanager/PersistentHitStore;->mLastDeleteStaleHitsTime:J

    const-wide/32 v10, 0x5265c00

    add-long/2addr v8, v10

    cmp-long v8, v4, v8

    if-gtz v8, :cond_1

    .line 353
    :cond_0
    :goto_0
    return v7

    .line 345
    :cond_1
    iput-wide v4, p0, Lcom/google/tagmanager/PersistentHitStore;->mLastDeleteStaleHitsTime:J

    .line 346
    const-string v8, "Error opening database for deleteStaleHits."

    invoke-direct {p0, v8}, Lcom/google/tagmanager/PersistentHitStore;->getWritableDatabase(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 347
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-eqz v0, :cond_0

    .line 350
    iget-object v8, p0, Lcom/google/tagmanager/PersistentHitStore;->mClock:Lcom/google/tagmanager/Clock;

    invoke-interface {v8}, Lcom/google/tagmanager/Clock;->currentTimeMillis()J

    move-result-wide v8

    const-wide v10, 0x9a7ec800L

    sub-long v2, v8, v10

    .line 351
    .local v2, "lastGoodTime":J
    const-string v8, "gtm_hits"

    const-string v9, "HIT_TIME < ?"

    new-array v10, v6, [Ljava/lang/String;

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v7

    instance-of v11, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v11, :cond_2

    invoke-virtual {v0, v8, v9, v10}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 352
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .local v1, "rslt":I
    :goto_1
    iget-object v8, p0, Lcom/google/tagmanager/PersistentHitStore;->mListener:Lcom/google/tagmanager/HitStoreStateListener;

    invoke-virtual {p0}, Lcom/google/tagmanager/PersistentHitStore;->getNumStoredHits()I

    move-result v9

    if-nez v9, :cond_3

    :goto_2
    invoke-interface {v8, v6}, Lcom/google/tagmanager/HitStoreStateListener;->reportStoreIsEmpty(Z)V

    move v7, v1

    .line 353
    goto :goto_0

    .line 351
    .end local v1    # "rslt":I
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_2
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v8, v9, v10}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    goto :goto_1

    .restart local v1    # "rslt":I
    :cond_3
    move v6, v7

    .line 352
    goto :goto_2
.end method

.method public dispatch()V
    .locals 3

    .prologue
    .line 452
    const-string v1, "GTM Dispatch running..."

    invoke-static {v1}, Lcom/google/tagmanager/Log;->v(Ljava/lang/String;)V

    .line 454
    iget-object v1, p0, Lcom/google/tagmanager/PersistentHitStore;->mDispatcher:Lcom/google/tagmanager/Dispatcher;

    invoke-interface {v1}, Lcom/google/tagmanager/Dispatcher;->okToDispatch()Z

    move-result v1

    if-nez v1, :cond_1

    .line 471
    :cond_0
    :goto_0
    return-void

    .line 458
    :cond_1
    const/16 v1, 0x28

    invoke-virtual {p0, v1}, Lcom/google/tagmanager/PersistentHitStore;->peekHits(I)Ljava/util/List;

    move-result-object v0

    .line 459
    .local v0, "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 460
    const-string v1, "...nothing to dispatch"

    invoke-static {v1}, Lcom/google/tagmanager/Log;->v(Ljava/lang/String;)V

    .line 461
    iget-object v1, p0, Lcom/google/tagmanager/PersistentHitStore;->mListener:Lcom/google/tagmanager/HitStoreStateListener;

    const/4 v2, 0x1

    invoke-interface {v1, v2}, Lcom/google/tagmanager/HitStoreStateListener;->reportStoreIsEmpty(Z)V

    goto :goto_0

    .line 464
    :cond_2
    iget-object v1, p0, Lcom/google/tagmanager/PersistentHitStore;->mDispatcher:Lcom/google/tagmanager/Dispatcher;

    invoke-interface {v1, v0}, Lcom/google/tagmanager/Dispatcher;->dispatchHits(Ljava/util/List;)V

    .line 468
    invoke-virtual {p0}, Lcom/google/tagmanager/PersistentHitStore;->getNumStoredUntriedHits()I

    move-result v1

    if-lez v1, :cond_0

    .line 469
    invoke-static {}, Lcom/google/tagmanager/ServiceManagerImpl;->getInstance()Lcom/google/tagmanager/ServiceManagerImpl;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/tagmanager/ServiceManagerImpl;->dispatch()V

    goto :goto_0
.end method

.method public getDbHelper()Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;
    .locals 1
    .annotation build Lcom/google/android/gms/common/util/VisibleForTesting;
    .end annotation

    .prologue
    .line 128
    iget-object v0, p0, Lcom/google/tagmanager/PersistentHitStore;->mDbHelper:Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;

    return-object v0
.end method

.method public getDispatcher()Lcom/google/tagmanager/Dispatcher;
    .locals 1

    .prologue
    .line 502
    iget-object v0, p0, Lcom/google/tagmanager/PersistentHitStore;->mDispatcher:Lcom/google/tagmanager/Dispatcher;

    return-object v0
.end method

.method getHelper()Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;
    .locals 1
    .annotation build Lcom/google/android/gms/common/util/VisibleForTesting;
    .end annotation

    .prologue
    .line 518
    iget-object v0, p0, Lcom/google/tagmanager/PersistentHitStore;->mDbHelper:Lcom/google/tagmanager/PersistentHitStore$UrlDatabaseHelper;

    return-object v0
.end method

.method getNumStoredHits()I
    .locals 8

    .prologue
    .line 403
    const/4 v3, 0x0

    .line 404
    .local v3, "numStoredHits":I
    const-string v5, "Error opening database for getNumStoredHits."

    invoke-direct {p0, v5}, Lcom/google/tagmanager/PersistentHitStore;->getWritableDatabase(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 405
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-nez v1, :cond_0

    move v4, v3

    .line 421
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v3    # "numStoredHits":I
    .local v4, "numStoredHits":I
    :goto_0
    return v4

    .line 408
    .end local v4    # "numStoredHits":I
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v3    # "numStoredHits":I
    :cond_0
    const/4 v0, 0x0

    .line 410
    .local v0, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string v5, "SELECT COUNT(*) from gtm_hits"

    const/4 v6, 0x0

    instance-of v7, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v7, :cond_3

    invoke-virtual {v1, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 411
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_1
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 412
    const/4 v5, 0x0

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getLong(I)J
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v6

    long-to-int v3, v6

    .line 417
    :cond_1
    if-eqz v0, :cond_2

    .line 418
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_2
    :goto_2
    move v4, v3

    .line 421
    .end local v3    # "numStoredHits":I
    .restart local v4    # "numStoredHits":I
    goto :goto_0

    .line 410
    .end local v4    # "numStoredHits":I
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v3    # "numStoredHits":I
    :cond_3
    :try_start_1
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v5, v6}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    goto :goto_1

    .line 414
    :catch_0
    move-exception v2

    .line 415
    .local v2, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_2
    const-string v5, "Error getting numStoredHits"

    invoke-static {v5}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 417
    if-eqz v0, :cond_2

    .line 418
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_2

    .line 417
    .end local v2    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v5

    if-eqz v0, :cond_4

    .line 418
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v5
.end method

.method getNumStoredUntriedHits()I
    .locals 21

    .prologue
    .line 425
    const/16 v19, 0x0

    .line 426
    .local v19, "numStoredHits":I
    const-string v2, "Error opening database for getNumStoredHits."

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/google/tagmanager/PersistentHitStore;->getWritableDatabase(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 427
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-nez v1, :cond_0

    move/from16 v20, v19

    .line 447
    .end local v19    # "numStoredHits":I
    .local v20, "numStoredHits":I
    :goto_0
    return v20

    .line 430
    .end local v20    # "numStoredHits":I
    .restart local v19    # "numStoredHits":I
    :cond_0
    const/16 v17, 0x0

    .line 432
    .local v17, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string v2, "gtm_hits"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "hit_id"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string v5, "hit_first_send_time"

    aput-object v5, v3, v4

    const-string v4, "hit_first_send_time=0"

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    instance-of v9, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v9, :cond_2

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v17

    .line 439
    :goto_1
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v19

    .line 443
    if-eqz v17, :cond_1

    .line 444
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    :cond_1
    :goto_2
    move/from16 v20, v19

    .line 447
    .end local v19    # "numStoredHits":I
    .restart local v20    # "numStoredHits":I
    goto :goto_0

    .line 432
    .end local v20    # "numStoredHits":I
    .restart local v19    # "numStoredHits":I
    :cond_2
    :try_start_1
    move-object v0, v1

    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    move-object v9, v0

    move-object v10, v2

    move-object v11, v3

    move-object v12, v4

    move-object v13, v5

    move-object v14, v6

    move-object v15, v7

    move-object/from16 v16, v8

    invoke-static/range {v9 .. v16}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->query(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v17

    goto :goto_1

    .line 440
    :catch_0
    move-exception v18

    .line 441
    .local v18, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_2
    const-string v2, "Error getting num untried hits"

    invoke-static {v2}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 443
    if-eqz v17, :cond_1

    .line 444
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    goto :goto_2

    .line 443
    .end local v18    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v2

    if-eqz v17, :cond_3

    .line 444
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v2
.end method

.method peekHitIds(I)Ljava/util/List;
    .locals 23
    .param p1, "maxHits"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 191
    new-instance v22, Ljava/util/ArrayList;

    invoke-direct/range {v22 .. v22}, Ljava/util/ArrayList;-><init>()V

    .line 192
    .local v22, "hitIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-gtz p1, :cond_1

    .line 193
    const-string v3, "Invalid maxHits specified. Skipping"

    invoke-static {v3}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V

    .line 223
    :cond_0
    :goto_0
    return-object v22

    .line 196
    :cond_1
    const-string v3, "Error opening database for peekHitIds."

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/google/tagmanager/PersistentHitStore;->getWritableDatabase(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 197
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-eqz v2, :cond_0

    .line 201
    const/16 v20, 0x0

    .line 203
    .local v20, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string v3, "gtm_hits"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "hit_id"

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const-string v9, "%s ASC"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string v12, "hit_id"

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v10

    instance-of v11, v2, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v11, :cond_4

    invoke-virtual/range {v2 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v20

    .line 211
    :goto_1
    invoke-interface/range {v20 .. v20}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 213
    :cond_2
    const/4 v3, 0x0

    move-object/from16 v0, v20

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v22

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 214
    invoke-interface/range {v20 .. v20}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v3

    if-nez v3, :cond_2

    .line 219
    :cond_3
    if-eqz v20, :cond_0

    .line 220
    invoke-interface/range {v20 .. v20}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 203
    :cond_4
    :try_start_1
    move-object v0, v2

    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    move-object v11, v0

    move-object v12, v3

    move-object v13, v4

    move-object v14, v5

    move-object v15, v6

    move-object/from16 v16, v7

    move-object/from16 v17, v8

    move-object/from16 v18, v9

    move-object/from16 v19, v10

    invoke-static/range {v11 .. v19}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->query(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v20

    goto :goto_1

    .line 216
    :catch_0
    move-exception v21

    .line 217
    .local v21, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_2
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error in peekHits fetching hitIds: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {v21 .. v21}, Landroid/database/sqlite/SQLiteException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 219
    if-eqz v20, :cond_0

    .line 220
    invoke-interface/range {v20 .. v20}, Landroid/database/Cursor;->close()V

    goto/16 :goto_0

    .line 219
    .end local v21    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v3

    if-eqz v20, :cond_5

    .line 220
    invoke-interface/range {v20 .. v20}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v3
.end method

.method public peekHits(I)Ljava/util/List;
    .locals 29
    .param p1, "maxHits"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Lcom/google/tagmanager/Hit;",
            ">;"
        }
    .end annotation

    .prologue
    .line 234
    new-instance v25, Ljava/util/ArrayList;

    invoke-direct/range {v25 .. v25}, Ljava/util/ArrayList;-><init>()V

    .line 235
    .local v25, "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    const-string v4, "Error opening database for peekHits"

    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/google/tagmanager/PersistentHitStore;->getWritableDatabase(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 236
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-nez v2, :cond_0

    move-object/from16 v26, v25

    .line 324
    :goto_0
    return-object v26

    .line 240
    :cond_0
    const/16 v21, 0x0

    .line 248
    .local v21, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string v3, "gtm_hits"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "hit_id"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-string v6, "hit_time"

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const-string v6, "hit_first_send_time"

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const-string v9, "%s ASC"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string v12, "hit_id"

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v10

    instance-of v11, v2, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v11, :cond_7

    invoke-virtual/range {v2 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v21

    .line 257
    :goto_1
    new-instance v26, Ljava/util/ArrayList;

    invoke-direct/range {v26 .. v26}, Ljava/util/ArrayList;-><init>()V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 258
    .end local v25    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    .local v26, "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    :try_start_1
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 260
    :cond_1
    new-instance v3, Lcom/google/tagmanager/Hit;

    const/4 v4, 0x0

    move-object/from16 v0, v21

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    const/4 v6, 0x1

    move-object/from16 v0, v21

    invoke-interface {v0, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    const/4 v8, 0x2

    move-object/from16 v0, v21

    invoke-interface {v0, v8}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    invoke-direct/range {v3 .. v9}, Lcom/google/tagmanager/Hit;-><init>(JJJ)V

    .line 261
    .local v3, "hit":Lcom/google/tagmanager/Hit;
    move-object/from16 v0, v26

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 262
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    move-result v4

    if-nez v4, :cond_1

    .line 268
    .end local v3    # "hit":Lcom/google/tagmanager/Hit;
    :cond_2
    if-eqz v21, :cond_3

    .line 269
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->close()V

    .line 273
    :cond_3
    const/16 v20, 0x0

    .line 275
    .local v20, "count":I
    :try_start_2
    const-string v5, "gtm_hits"

    const/4 v4, 0x2

    new-array v6, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v7, "hit_id"

    aput-object v7, v6, v4

    const/4 v4, 0x1

    const-string v7, "hit_url"

    aput-object v7, v6, v4

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const-string v4, "%s ASC"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    const-string v13, "hit_id"

    aput-object v13, v11, v12

    invoke-static {v4, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v12

    instance-of v4, v2, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_a

    move-object v4, v2

    invoke-virtual/range {v4 .. v12}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v21

    .line 284
    :goto_2
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 286
    :cond_4
    move-object/from16 v0, v21

    check-cast v0, Landroid/database/sqlite/SQLiteCursor;

    move-object v4, v0

    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteCursor;->getWindow()Landroid/database/CursorWindow;

    move-result-object v22

    .line 290
    .local v22, "cw":Landroid/database/CursorWindow;
    invoke-virtual/range {v22 .. v22}, Landroid/database/CursorWindow;->getNumRows()I

    move-result v4

    if-lez v4, :cond_b

    .line 291
    move-object/from16 v0, v26

    move/from16 v1, v20

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/tagmanager/Hit;

    const/4 v5, 0x1

    move-object/from16 v0, v21

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/google/tagmanager/Hit;->setHitUrl(Ljava/lang/String;)V

    .line 296
    :goto_3
    add-int/lit8 v20, v20, 0x1

    .line 297
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_2
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result v4

    if-nez v4, :cond_4

    .line 323
    .end local v22    # "cw":Landroid/database/CursorWindow;
    :cond_5
    if-eqz v21, :cond_6

    .line 324
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->close()V

    :cond_6
    move-object/from16 v25, v26

    .end local v26    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    .restart local v25    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    goto/16 :goto_0

    .line 248
    .end local v20    # "count":I
    :cond_7
    :try_start_3
    move-object v0, v2

    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    move-object v11, v0

    move-object v12, v3

    move-object v13, v4

    move-object v14, v5

    move-object v15, v6

    move-object/from16 v16, v7

    move-object/from16 v17, v8

    move-object/from16 v18, v9

    move-object/from16 v19, v10

    invoke-static/range {v11 .. v19}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->query(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_3
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v21

    goto/16 :goto_1

    .line 264
    :catch_0
    move-exception v23

    .line 265
    .local v23, "e":Landroid/database/sqlite/SQLiteException;
    :goto_4
    :try_start_4
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error in peekHits fetching hitIds: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {v23 .. v23}, Landroid/database/sqlite/SQLiteException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 268
    if-eqz v21, :cond_8

    .line 269
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->close()V

    :cond_8
    move-object/from16 v26, v25

    goto/16 :goto_0

    .line 268
    .end local v23    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v4

    :goto_5
    if-eqz v21, :cond_9

    .line 269
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->close()V

    :cond_9
    throw v4

    .line 275
    .end local v25    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    .restart local v20    # "count":I
    .restart local v26    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    :cond_a
    :try_start_5
    move-object v0, v2

    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    move-object v4, v0

    invoke-static/range {v4 .. v12}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->query(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v21

    goto/16 :goto_2

    .line 293
    .restart local v22    # "cw":Landroid/database/CursorWindow;
    :cond_b
    const-string v5, "HitString for hitId %d too large.  Hit will be deleted."

    const/4 v4, 0x1

    new-array v6, v4, [Ljava/lang/Object;

    const/4 v7, 0x0

    move-object/from16 v0, v26

    move/from16 v1, v20

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/tagmanager/Hit;

    invoke-virtual {v4}, Lcom/google/tagmanager/Hit;->getHitId()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto :goto_3

    .line 300
    .end local v22    # "cw":Landroid/database/CursorWindow;
    :catch_1
    move-exception v23

    .line 301
    .restart local v23    # "e":Landroid/database/sqlite/SQLiteException;
    :try_start_6
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error in peekHits fetching hit url: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {v23 .. v23}, Landroid/database/sqlite/SQLiteException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/google/tagmanager/Log;->w(Ljava/lang/String;)V

    .line 309
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 310
    .local v28, "partialHits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    const/16 v24, 0x0

    .line 311
    .local v24, "foundOneBadHit":Z
    invoke-interface/range {v26 .. v26}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v27

    .local v27, "i$":Ljava/util/Iterator;
    :goto_6
    invoke-interface/range {v27 .. v27}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_c

    invoke-interface/range {v27 .. v27}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/tagmanager/Hit;

    .line 312
    .restart local v3    # "hit":Lcom/google/tagmanager/Hit;
    invoke-virtual {v3}, Lcom/google/tagmanager/Hit;->getHitUrl()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    move-result v4

    if-eqz v4, :cond_f

    .line 313
    if-eqz v24, :cond_e

    .line 323
    .end local v3    # "hit":Lcom/google/tagmanager/Hit;
    :cond_c
    if-eqz v21, :cond_d

    .line 324
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->close()V

    :cond_d
    move-object/from16 v25, v26

    .end local v26    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    .restart local v25    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    move-object/from16 v26, v28

    goto/16 :goto_0

    .line 316
    .end local v25    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    .restart local v3    # "hit":Lcom/google/tagmanager/Hit;
    .restart local v26    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    :cond_e
    const/16 v24, 0x1

    .line 319
    :cond_f
    :try_start_7
    move-object/from16 v0, v28

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    goto :goto_6

    .line 323
    .end local v3    # "hit":Lcom/google/tagmanager/Hit;
    .end local v23    # "e":Landroid/database/sqlite/SQLiteException;
    .end local v24    # "foundOneBadHit":Z
    .end local v27    # "i$":Ljava/util/Iterator;
    .end local v28    # "partialHits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    :catchall_1
    move-exception v4

    if-eqz v21, :cond_10

    .line 324
    invoke-interface/range {v21 .. v21}, Landroid/database/Cursor;->close()V

    :cond_10
    throw v4

    .line 268
    .end local v20    # "count":I
    :catchall_2
    move-exception v4

    move-object/from16 v25, v26

    .end local v26    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    .restart local v25    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    goto/16 :goto_5

    .line 264
    .end local v25    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    .restart local v26    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    :catch_2
    move-exception v23

    move-object/from16 v25, v26

    .end local v26    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    .restart local v25    # "hits":Ljava/util/List;, "Ljava/util/List<Lcom/google/tagmanager/Hit;>;"
    goto/16 :goto_4
.end method

.method public putHit(JLjava/lang/String;)V
    .locals 1
    .param p1, "hitTimeInMilliseconds"    # J
    .param p3, "path"    # Ljava/lang/String;

    .prologue
    .line 143
    invoke-virtual {p0}, Lcom/google/tagmanager/PersistentHitStore;->deleteStaleHits()I

    .line 144
    invoke-direct {p0}, Lcom/google/tagmanager/PersistentHitStore;->removeOldHitIfFull()V

    .line 145
    invoke-direct {p0, p1, p2, p3}, Lcom/google/tagmanager/PersistentHitStore;->writeHitToDatabase(JLjava/lang/String;)V

    .line 146
    return-void
.end method

.method public setClock(Lcom/google/tagmanager/Clock;)V
    .locals 0
    .param p1, "clock"    # Lcom/google/tagmanager/Clock;
    .annotation build Lcom/google/android/gms/common/util/VisibleForTesting;
    .end annotation

    .prologue
    .line 123
    iput-object p1, p0, Lcom/google/tagmanager/PersistentHitStore;->mClock:Lcom/google/tagmanager/Clock;

    .line 124
    return-void
.end method

.method setDispatcher(Lcom/google/tagmanager/Dispatcher;)V
    .locals 0
    .param p1, "dispatcher"    # Lcom/google/tagmanager/Dispatcher;
    .annotation build Lcom/google/android/gms/common/util/VisibleForTesting;
    .end annotation

    .prologue
    .line 133
    iput-object p1, p0, Lcom/google/tagmanager/PersistentHitStore;->mDispatcher:Lcom/google/tagmanager/Dispatcher;

    .line 134
    return-void
.end method

.method setLastDeleteStaleHitsTime(J)V
    .locals 1
    .param p1, "timeInMilliseconds"    # J
    .annotation build Lcom/google/android/gms/common/util/VisibleForTesting;
    .end annotation

    .prologue
    .line 331
    iput-wide p1, p0, Lcom/google/tagmanager/PersistentHitStore;->mLastDeleteStaleHitsTime:J

    .line 332
    return-void
.end method
