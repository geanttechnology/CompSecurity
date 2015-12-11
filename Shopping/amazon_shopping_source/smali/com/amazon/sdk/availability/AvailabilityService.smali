.class public Lcom/amazon/sdk/availability/AvailabilityService;
.super Lcom/amazon/android/service/IntentTimeoutService;
.source "AvailabilityService.java"


# static fields
.field private static haveWarnedAboutPrng:Z

.field private static isInitialized:Z


# instance fields
.field private alarmManager:Landroid/app/AlarmManager;

.field private attemptedToSyncEmptyConfigThisInstance:Z

.field private context:Landroid/content/Context;

.field private submissionScheduledForThisInstance:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 83
    sput-boolean v0, Lcom/amazon/sdk/availability/AvailabilityService;->haveWarnedAboutPrng:Z

    .line 119
    sput-boolean v0, Lcom/amazon/sdk/availability/AvailabilityService;->isInitialized:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 148
    const-string/jumbo v0, "AvailabilityServiceWorker"

    const/16 v1, 0x13

    invoke-direct {p0, v0, v1}, Lcom/amazon/android/service/IntentTimeoutService;-><init>(Ljava/lang/String;I)V

    .line 135
    iput-boolean v2, p0, Lcom/amazon/sdk/availability/AvailabilityService;->attemptedToSyncEmptyConfigThisInstance:Z

    .line 140
    iput-boolean v2, p0, Lcom/amazon/sdk/availability/AvailabilityService;->submissionScheduledForThisInstance:Z

    .line 149
    return-void
.end method

.method private getAndOpenDataStore(Ljava/lang/String;Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;)Lcom/amazon/sdk/availability/DataStore;
    .locals 7
    .param p1, "clientId"    # Ljava/lang/String;
    .param p2, "collectionConfig"    # Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;

    .prologue
    .line 1105
    invoke-virtual {p2}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getLocalStoragePersistenceFormat()Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    move-result-object v4

    .line 1107
    .local v4, "persistenceFormat":Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;
    if-nez v4, :cond_1

    .line 1108
    const/4 v0, 0x0

    .line 1123
    :cond_0
    :goto_0
    return-object v0

    .line 1111
    :cond_1
    invoke-virtual {p2}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getLocalStorageMaxRollover()Ljava/lang/Long;

    move-result-object v2

    .line 1112
    .local v2, "localStorageMaxRollOver":Ljava/lang/Long;
    invoke-virtual {p2}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getLocalStorageRolloverFilesize()Ljava/lang/Long;

    move-result-object v3

    .line 1114
    .local v3, "localStorageMaxRollOverSize":Ljava/lang/Long;
    invoke-static {v4, v2, v3, p1}, Lcom/amazon/sdk/availability/DatastoreFactory;->getDataStore(Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/amazon/sdk/availability/DataStore;

    move-result-object v0

    .line 1116
    .local v0, "dataStore":Lcom/amazon/sdk/availability/DataStore;
    if-eqz v0, :cond_0

    .line 1117
    invoke-virtual {p2}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getLocalStorageEncryptionScheme()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p2}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getLocalStorageEncryptionKey()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/sdk/availability/EncryptionFactory;->getEncryptionManager(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/EncryptionManager;

    move-result-object v1

    .line 1121
    .local v1, "encryptionManager":Lcom/amazon/sdk/availability/EncryptionManager;
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-interface {v0, v5, v1}, Lcom/amazon/sdk/availability/DataStore;->open(Landroid/content/Context;Lcom/amazon/sdk/availability/EncryptionManager;)V

    goto :goto_0
.end method

.method private getIntent(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    .locals 3
    .param p1, "intentAction"    # Ljava/lang/String;
    .param p2, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 396
    invoke-static {p1}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 397
    new-instance v1, Lcom/amazon/sdk/availability/AvailabilityServiceException;

    const-string/jumbo v2, "\'intentAction\' cannot be null"

    invoke-direct {v1, v2}, Lcom/amazon/sdk/availability/AvailabilityServiceException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 399
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 400
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/amazon/sdk/availability/AvailabilityService;->context:Landroid/content/Context;

    const-class v2, Lcom/amazon/sdk/availability/AvailabilityService;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 401
    if-eqz p2, :cond_1

    .line 402
    invoke-virtual {v0, p2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 404
    :cond_1
    return-object v0
.end method


# virtual methods
.method protected addFilesToMeasurement(Lorg/json/JSONObject;Landroid/os/Bundle;)V
    .locals 9
    .param p1, "measurementJson"    # Lorg/json/JSONObject;
    .param p2, "extras"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 488
    const-class v7, Lcom/amazon/sdk/availability/AvailabilityService;

    const-string/jumbo v8, "addFilesToMeasurement"

    invoke-static {v7, v8}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v6

    .line 491
    .local v6, "methodScope":Lcom/amazon/profiling/ProfilerScope;
    const-string/jumbo v7, "mapOfFiles"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 492
    const-string/jumbo v7, "mapOfFiles"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    .line 493
    .local v4, "mapOfFiles":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/io/File;>;"
    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 494
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/io/File;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/io/File;

    invoke-virtual {p0, v7, v8}, Lcom/amazon/sdk/availability/AvailabilityService;->getBytesOfFile(Ljava/lang/String;Ljava/io/File;)[B

    move-result-object v0

    .line 496
    .local v0, "bytes":[B
    if-nez v0, :cond_0

    .line 497
    const-string/jumbo v1, "ERROR_READING_FILE"

    .line 503
    .local v1, "content":Ljava/lang/String;
    :goto_1
    const-string/jumbo v7, "metadata"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 504
    .local v5, "metadata":Lorg/json/JSONObject;
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v5, v7, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 505
    const-string/jumbo v7, "metadata"

    invoke-virtual {p1, v7, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 506
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, " added to measurement"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    goto :goto_0

    .line 499
    .end local v1    # "content":Ljava/lang/String;
    .end local v5    # "metadata":Lorg/json/JSONObject;
    :cond_0
    const/16 v7, 0xb

    invoke-static {v0, v7}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "content":Ljava/lang/String;
    goto :goto_1

    .line 509
    .end local v0    # "bytes":[B
    .end local v1    # "content":Ljava/lang/String;
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/io/File;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "mapOfFiles":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/io/File;>;"
    :cond_1
    invoke-static {v6}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    .line 510
    return-void
.end method

.method protected adjustMeasurementTimestamp(Lorg/json/JSONObject;)V
    .locals 7
    .param p1, "measurementJson"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Ljava/text/ParseException;
        }
    .end annotation

    .prologue
    .line 464
    const-class v5, Lcom/amazon/sdk/availability/AvailabilityService;

    const-string/jumbo v6, "adjustMeasurementTimestamp"

    invoke-static {v5, v6}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v0

    .line 467
    .local v0, "methodScope":Lcom/amazon/profiling/ProfilerScope;
    const-string/jumbo v5, "measurementTimestamp"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 468
    .local v4, "timestampString":Ljava/lang/String;
    if-eqz v4, :cond_0

    .line 469
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string/jumbo v5, "yyyy-MM-dd\'T\'HH:mm:ss.SSSZ"

    invoke-direct {v1, v5}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 470
    .local v1, "sdf":Ljava/text/SimpleDateFormat;
    invoke-virtual {v1, v4}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    .line 471
    .local v2, "timestamp":J
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5, v2, v3}, Lcom/amazon/sdk/availability/Clock;->getAdjustedTime(Landroid/content/Context;J)J

    move-result-wide v2

    .line 472
    const-string/jumbo v5, "measurementTimestamp"

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v1, v6}, Ljava/text/SimpleDateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 474
    .end local v1    # "sdf":Ljava/text/SimpleDateFormat;
    .end local v2    # "timestamp":J
    :cond_0
    invoke-static {v0}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    .line 475
    return-void
.end method

.method protected cancelSubmit()V
    .locals 3

    .prologue
    .line 356
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string/jumbo v1, "SubmitMeasurements"

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lcom/amazon/sdk/availability/AvailabilityService;->getIntent(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/android/service/SchedulePeriodicWork;->cancelWork(Landroid/content/Context;Landroid/content/Intent;)V

    .line 357
    return-void
.end method

.method protected createSchedule()V
    .locals 7

    .prologue
    .line 299
    sget-boolean v4, Lcom/amazon/sdk/availability/AvailabilityService;->isInitialized:Z

    if-nez v4, :cond_0

    .line 300
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->loadConfiguration()Lcom/amazon/sdk/availability/Configuration;

    move-result-object v1

    .line 301
    .local v1, "configuration":Lcom/amazon/sdk/availability/Configuration;
    new-instance v3, Lcom/amazon/sdk/availability/ConfigurationState;

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/amazon/sdk/availability/ConfigurationState;-><init>(Landroid/content/Context;)V

    .line 304
    .local v3, "schedule":Lcom/amazon/sdk/availability/ConfigurationState;
    invoke-virtual {v3}, Lcom/amazon/sdk/availability/ConfigurationState;->getConfigurationNextRefresh()Ljava/lang/Long;

    move-result-object v2

    .line 305
    .local v2, "nextRefresh":Ljava/lang/Long;
    if-eqz v2, :cond_1

    .line 306
    invoke-virtual {v1}, Lcom/amazon/sdk/availability/Configuration;->getStateNextRefresh()Ljava/lang/Long;

    move-result-object v0

    .line 307
    .local v0, "configNextRefresh":Ljava/lang/Long;
    invoke-virtual {p0, v2, v0}, Lcom/amazon/sdk/availability/AvailabilityService;->scheduleSync(Ljava/lang/Long;Ljava/lang/Long;)V

    .line 312
    .end local v0    # "configNextRefresh":Ljava/lang/Long;
    :goto_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "created schedule @ "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/sdk/availability/StringUtil;->dateToString(Ljava/lang/Long;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/sdk/availability/Logger;->i(Ljava/lang/String;)V

    .line 313
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "schedule: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3}, Lcom/amazon/sdk/availability/ConfigurationState;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 314
    const/4 v4, 0x1

    sput-boolean v4, Lcom/amazon/sdk/availability/AvailabilityService;->isInitialized:Z

    .line 316
    .end local v1    # "configuration":Lcom/amazon/sdk/availability/Configuration;
    .end local v2    # "nextRefresh":Ljava/lang/Long;
    .end local v3    # "schedule":Lcom/amazon/sdk/availability/ConfigurationState;
    :cond_0
    return-void

    .line 309
    .restart local v1    # "configuration":Lcom/amazon/sdk/availability/Configuration;
    .restart local v2    # "nextRefresh":Ljava/lang/Long;
    .restart local v3    # "schedule":Lcom/amazon/sdk/availability/ConfigurationState;
    :cond_1
    const-wide/16 v4, 0x0

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {p0, v4, v5}, Lcom/amazon/sdk/availability/AvailabilityService;->scheduleSync(Ljava/lang/Long;Ljava/lang/Long;)V

    goto :goto_0
.end method

.method protected fixBrokenPreferences(Ljava/lang/String;J)V
    .locals 3
    .param p1, "clientId"    # Ljava/lang/String;
    .param p2, "lastSubmission"    # J

    .prologue
    .line 1341
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 1342
    .local v0, "now":J
    cmp-long v2, p2, v0

    if-lez v2, :cond_0

    .line 1343
    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/sdk/availability/AvailabilityService;->setLastClientSubmission(Ljava/lang/String;J)V

    .line 1345
    :cond_0
    return-void
.end method

.method getBytesOfFile(Ljava/lang/String;Ljava/io/File;)[B
    .locals 10
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "file"    # Ljava/io/File;

    .prologue
    const/4 v0, 0x0

    .line 1266
    if-nez p2, :cond_1

    .line 1306
    :cond_0
    :goto_0
    return-object v0

    .line 1269
    :cond_1
    invoke-virtual {p2}, Ljava/io/File;->length()J

    move-result-wide v3

    .line 1270
    .local v3, "fileSize":J
    const-wide/32 v8, 0x100000

    cmp-long v8, v3, v8

    if-lez v8, :cond_2

    .line 1271
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "File "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, " is too big. Not added to measurement"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    goto :goto_0

    .line 1274
    :cond_2
    invoke-virtual {p2}, Ljava/io/File;->canRead()Z

    move-result v8

    if-nez v8, :cond_3

    .line 1275
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Cannot read file "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    goto :goto_0

    .line 1278
    :cond_3
    const/4 v0, 0x0

    .line 1280
    .local v0, "bytes":[B
    const/4 v5, 0x0

    .line 1282
    .local v5, "fis":Ljava/io/FileInputStream;
    :try_start_0
    new-instance v6, Ljava/io/FileInputStream;

    invoke-direct {v6, p2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1283
    .end local v5    # "fis":Ljava/io/FileInputStream;
    .local v6, "fis":Ljava/io/FileInputStream;
    long-to-int v8, v3

    :try_start_1
    new-array v0, v8, [B

    .line 1284
    const/4 v7, 0x0

    .line 1285
    .local v7, "totalBytesRead":I
    const/4 v1, 0x0

    .line 1287
    .local v1, "bytesRead":I
    :goto_1
    int-to-long v8, v7

    cmp-long v8, v8, v3

    if-gez v8, :cond_4

    .line 1288
    long-to-int v8, v3

    sub-int/2addr v8, v7

    invoke-virtual {v6, v0, v7, v8}, Ljava/io/FileInputStream;->read([BII)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v1

    .line 1289
    if-gtz v1, :cond_5

    .line 1298
    :cond_4
    if-eqz v6, :cond_7

    .line 1300
    :try_start_2
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    move-object v5, v6

    .line 1303
    .end local v6    # "fis":Ljava/io/FileInputStream;
    .restart local v5    # "fis":Ljava/io/FileInputStream;
    goto :goto_0

    .line 1292
    .end local v5    # "fis":Ljava/io/FileInputStream;
    .restart local v6    # "fis":Ljava/io/FileInputStream;
    :cond_5
    add-int/2addr v7, v1

    goto :goto_1

    .line 1301
    :catch_0
    move-exception v2

    .line 1302
    .local v2, "e":Ljava/io/IOException;
    const-string/jumbo v8, "Could not close fileInputStream"

    invoke-static {v8, v2}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v5, v6

    .line 1303
    .end local v6    # "fis":Ljava/io/FileInputStream;
    .restart local v5    # "fis":Ljava/io/FileInputStream;
    goto :goto_0

    .line 1295
    .end local v1    # "bytesRead":I
    .end local v2    # "e":Ljava/io/IOException;
    .end local v7    # "totalBytesRead":I
    :catch_1
    move-exception v2

    .line 1296
    .local v2, "e":Ljava/lang/Exception;
    :goto_2
    :try_start_3
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Exception thrown when reading file "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, " to measurement"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8, v2}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1298
    if-eqz v5, :cond_0

    .line 1300
    :try_start_4
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    goto/16 :goto_0

    .line 1301
    :catch_2
    move-exception v2

    .line 1302
    .local v2, "e":Ljava/io/IOException;
    const-string/jumbo v8, "Could not close fileInputStream"

    invoke-static {v8, v2}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 1298
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v8

    :goto_3
    if-eqz v5, :cond_6

    .line 1300
    :try_start_5
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 1303
    :cond_6
    :goto_4
    throw v8

    .line 1301
    :catch_3
    move-exception v2

    .line 1302
    .restart local v2    # "e":Ljava/io/IOException;
    const-string/jumbo v9, "Could not close fileInputStream"

    invoke-static {v9, v2}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_4

    .line 1298
    .end local v2    # "e":Ljava/io/IOException;
    .end local v5    # "fis":Ljava/io/FileInputStream;
    .restart local v6    # "fis":Ljava/io/FileInputStream;
    :catchall_1
    move-exception v8

    move-object v5, v6

    .end local v6    # "fis":Ljava/io/FileInputStream;
    .restart local v5    # "fis":Ljava/io/FileInputStream;
    goto :goto_3

    .line 1295
    .end local v5    # "fis":Ljava/io/FileInputStream;
    .restart local v6    # "fis":Ljava/io/FileInputStream;
    :catch_4
    move-exception v2

    move-object v5, v6

    .end local v6    # "fis":Ljava/io/FileInputStream;
    .restart local v5    # "fis":Ljava/io/FileInputStream;
    goto :goto_2

    .end local v5    # "fis":Ljava/io/FileInputStream;
    .restart local v1    # "bytesRead":I
    .restart local v6    # "fis":Ljava/io/FileInputStream;
    .restart local v7    # "totalBytesRead":I
    :cond_7
    move-object v5, v6

    .end local v6    # "fis":Ljava/io/FileInputStream;
    .restart local v5    # "fis":Ljava/io/FileInputStream;
    goto/16 :goto_0
.end method

.method protected getCarrierName()Ljava/lang/String;
    .locals 4

    .prologue
    .line 1174
    const/4 v0, 0x0

    .line 1175
    .local v0, "carrierName":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/sdk/availability/AvailabilityService;->context:Landroid/content/Context;

    const-string/jumbo v3, "phone"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/telephony/TelephonyManager;

    .line 1176
    .local v1, "telephony":Landroid/telephony/TelephonyManager;
    if-eqz v1, :cond_0

    .line 1177
    invoke-virtual {v1}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;

    move-result-object v0

    .line 1179
    :cond_0
    return-object v0
.end method

.method protected getConnectivity()Lcom/amazon/sdk/availability/Connectivity;
    .locals 2

    .prologue
    .line 1327
    new-instance v0, Lcom/amazon/sdk/availability/Connectivity;

    const-string/jumbo v1, "connectivity"

    invoke-virtual {p0, v1}, Lcom/amazon/sdk/availability/AvailabilityService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/ConnectivityManager;

    invoke-direct {v0, v1}, Lcom/amazon/sdk/availability/Connectivity;-><init>(Landroid/net/ConnectivityManager;)V

    .line 1328
    .local v0, "c":Lcom/amazon/sdk/availability/Connectivity;
    return-object v0
.end method

.method protected getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 1134
    iget-object v0, p0, Lcom/amazon/sdk/availability/AvailabilityService;->context:Landroid/content/Context;

    return-object v0
.end method

.method protected getLastClientSubmission(Ljava/lang/String;)J
    .locals 7
    .param p1, "clientId"    # Ljava/lang/String;

    .prologue
    .line 1224
    const-wide/16 v3, 0x0

    .line 1225
    .local v3, "result":J
    if-eqz p1, :cond_0

    .line 1226
    new-instance v2, Lcom/amazon/sdk/availability/Preferences;

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v2, v5}, Lcom/amazon/sdk/availability/Preferences;-><init>(Landroid/content/Context;)V

    .line 1228
    .local v2, "preferences":Lcom/amazon/sdk/availability/Preferences;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "lastClientSubmission-"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1230
    .local v1, "lastSubmissionString":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 1232
    :try_start_0
    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v3

    .line 1238
    .end local v1    # "lastSubmissionString":Ljava/lang/String;
    .end local v2    # "preferences":Lcom/amazon/sdk/availability/Preferences;
    :cond_0
    :goto_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "last submission for "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " @ "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/sdk/availability/StringUtil;->dateToString(Ljava/lang/Long;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 1239
    return-wide v3

    .line 1233
    .restart local v1    # "lastSubmissionString":Ljava/lang/String;
    .restart local v2    # "preferences":Lcom/amazon/sdk/availability/Preferences;
    :catch_0
    move-exception v0

    .line 1234
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "error parsing last submission time for "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v0}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected getPackageNameForMeasurement(Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 3
    .param p1, "measurement"    # Lorg/json/JSONObject;

    .prologue
    .line 1190
    const/4 v1, 0x0

    .line 1191
    .local v1, "result":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 1192
    const-string/jumbo v2, "metadata"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 1193
    .local v0, "metadata":Lorg/json/JSONObject;
    if-eqz v0, :cond_0

    .line 1194
    const-string/jumbo v2, "packageName"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1197
    .end local v0    # "metadata":Lorg/json/JSONObject;
    :cond_0
    return-object v1
.end method

.method protected getPendingIntent(Ljava/lang/String;Landroid/os/Bundle;)Landroid/app/PendingIntent;
    .locals 3
    .param p1, "intentAction"    # Ljava/lang/String;
    .param p2, "extras"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x0

    .line 381
    invoke-direct {p0, p1, p2}, Lcom/amazon/sdk/availability/AvailabilityService;->getIntent(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v0

    .line 383
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/amazon/sdk/availability/AvailabilityService;->context:Landroid/content/Context;

    invoke-static {v1, v2, v0, v2}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    return-object v1
.end method

.method protected handleForceSubmitMeasurementsIntent(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 776
    invoke-static {}, Lcom/amazon/sdk/availability/Stage;->isProduction()Z

    move-result v1

    if-nez v1, :cond_1

    .line 777
    const-string/jumbo v1, "force-submit intent received, attempting submission"

    invoke-static {v1}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;)V

    .line 778
    const-string/jumbo v1, "clientId"

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 779
    .local v0, "clientId":Ljava/lang/String;
    const-wide/16 v1, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/sdk/availability/AvailabilityService;->submitMeasurements(Ljava/lang/String;J)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 780
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/sdk/availability/AvailabilityService;->setLastClientSubmission(Ljava/lang/String;J)V

    .line 785
    .end local v0    # "clientId":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 783
    :cond_1
    const-string/jumbo v1, "force-submit intent received, but not gamma, so ignoring"

    invoke-static {v1}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public handlePutMeasurement(Landroid/content/Intent;)V
    .locals 14
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 632
    const-class v11, Lcom/amazon/sdk/availability/AvailabilityService;

    const-string/jumbo v12, "handlePutMeasurement"

    invoke-static {v11, v12}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v8

    .line 635
    .local v8, "methodScope":Lcom/amazon/profiling/ProfilerScope;
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    .line 636
    .local v4, "extras":Landroid/os/Bundle;
    if-eqz v4, :cond_0

    const-string/jumbo v11, "payload"

    invoke-virtual {v4, v11}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_1

    .line 638
    :cond_0
    const-string/jumbo v11, "no payload for measurement"

    invoke-static {v11}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 698
    invoke-static {v8}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    .line 700
    :goto_0
    return-void

    .line 642
    :cond_1
    :try_start_1
    const-string/jumbo v11, "payload"

    invoke-virtual {v4, v11}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v9

    .line 645
    .local v9, "payload":Ljava/lang/String;
    :try_start_2
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5, v9}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 648
    .local v5, "measurementJson":Lorg/json/JSONObject;
    const-string/jumbo v11, "clientId"

    invoke-virtual {v5, v11}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 649
    .local v0, "clientId":Ljava/lang/String;
    const-string/jumbo v11, "measurementName"

    invoke-virtual {v5, v11}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 650
    .local v6, "measurementName":Ljava/lang/String;
    const-string/jumbo v11, "processing putMeasurement intent (%s)"

    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    aput-object v0, v12, v13

    invoke-static {v11, v12}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 653
    invoke-static {v0}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result v11

    if-eqz v11, :cond_2

    .line 698
    invoke-static {v8}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    goto :goto_0

    .line 657
    :cond_2
    :try_start_3
    invoke-virtual {p0, v5}, Lcom/amazon/sdk/availability/AvailabilityService;->adjustMeasurementTimestamp(Lorg/json/JSONObject;)V

    .line 660
    invoke-static {}, Lcom/amazon/sdk/availability/Stage;->isProduction()Z

    move-result v11

    if-nez v11, :cond_3

    .line 661
    const-string/jumbo v11, "stage"

    invoke-static {}, Lcom/amazon/sdk/availability/Stage;->getDomain()Lcom/amazon/sdk/availability/Stage$Domain;

    move-result-object v12

    invoke-virtual {v12}, Lcom/amazon/sdk/availability/Stage$Domain;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v5, v11, v12}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 664
    :cond_3
    invoke-virtual {p0, v5, v4}, Lcom/amazon/sdk/availability/AvailabilityService;->addFilesToMeasurement(Lorg/json/JSONObject;Landroid/os/Bundle;)V

    .line 666
    new-instance v10, Lcom/amazon/sdk/availability/Preferences;

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v11

    invoke-direct {v10, v11}, Lcom/amazon/sdk/availability/Preferences;-><init>(Landroid/content/Context;)V

    .line 667
    .local v10, "preferences":Lcom/amazon/sdk/availability/Preferences;
    iget-boolean v11, p0, Lcom/amazon/sdk/availability/AvailabilityService;->attemptedToSyncEmptyConfigThisInstance:Z

    if-nez v11, :cond_4

    const-string/jumbo v11, "configuration"

    invoke-virtual {v10, v11}, Lcom/amazon/sdk/availability/Preferences;->contains(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_4

    .line 668
    const-string/jumbo v11, "Configuration has never been retrieved. Attempting to sync once."

    invoke-static {v11}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 669
    const/4 v11, 0x1

    iput-boolean v11, p0, Lcom/amazon/sdk/availability/AvailabilityService;->attemptedToSyncEmptyConfigThisInstance:Z

    .line 670
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->handleSyncConfigurationIntent()V

    .line 672
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->loadConfiguration()Lcom/amazon/sdk/availability/Configuration;

    move-result-object v2

    .line 673
    .local v2, "config":Lcom/amazon/sdk/availability/Configuration;
    invoke-virtual {v2, v0}, Lcom/amazon/sdk/availability/Configuration;->getCollectionConfiguration(Ljava/lang/String;)Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    :try_end_3
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v1

    .line 676
    .local v1, "collectionConfig":Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    if-nez v1, :cond_5

    .line 698
    invoke-static {v8}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    goto :goto_0

    .line 680
    :cond_5
    :try_start_4
    invoke-virtual {p0, v1, v6, v0, v5}, Lcom/amazon/sdk/availability/AvailabilityService;->writeMeasurement(Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Z

    move-result v7

    .line 683
    .local v7, "measurementPut":Z
    invoke-virtual {p0, v1, v0, v5}, Lcom/amazon/sdk/availability/AvailabilityService;->submitImmediateMeasurements(Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 685
    if-eqz v7, :cond_6

    iget-boolean v11, p0, Lcom/amazon/sdk/availability/AvailabilityService;->submissionScheduledForThisInstance:Z

    if-nez v11, :cond_6

    .line 686
    invoke-virtual {v2}, Lcom/amazon/sdk/availability/Configuration;->getStateSubmissionInterval()Ljava/lang/Long;

    move-result-object v11

    invoke-virtual {p0, v11}, Lcom/amazon/sdk/availability/AvailabilityService;->scheduleSubmit(Ljava/lang/Long;)V

    .line 687
    const/4 v11, 0x1

    iput-boolean v11, p0, Lcom/amazon/sdk/availability/AvailabilityService;->submissionScheduledForThisInstance:Z
    :try_end_4
    .catch Ljava/lang/RuntimeException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 698
    :cond_6
    invoke-static {v8}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    goto/16 :goto_0

    .line 691
    .end local v0    # "clientId":Ljava/lang/String;
    .end local v1    # "collectionConfig":Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    .end local v2    # "config":Lcom/amazon/sdk/availability/Configuration;
    .end local v5    # "measurementJson":Lorg/json/JSONObject;
    .end local v6    # "measurementName":Ljava/lang/String;
    .end local v7    # "measurementPut":Z
    .end local v10    # "preferences":Lcom/amazon/sdk/availability/Preferences;
    :catch_0
    move-exception v3

    .line 692
    .local v3, "e":Ljava/lang/RuntimeException;
    :try_start_5
    const-string/jumbo v11, "runtime exception caught and suppressed handling PUT_MEASUREMENT"

    invoke-static {v11, v3}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 693
    new-instance v11, Lcom/amazon/sdk/availability/AvailabilityServiceException;

    invoke-direct {v11, v3}, Lcom/amazon/sdk/availability/AvailabilityServiceException;-><init>(Ljava/lang/Throwable;)V

    throw v11
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 698
    .end local v3    # "e":Ljava/lang/RuntimeException;
    .end local v4    # "extras":Landroid/os/Bundle;
    .end local v9    # "payload":Ljava/lang/String;
    :catchall_0
    move-exception v11

    invoke-static {v8}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    throw v11

    .line 694
    .restart local v4    # "extras":Landroid/os/Bundle;
    .restart local v9    # "payload":Ljava/lang/String;
    :catch_1
    move-exception v3

    .line 695
    .local v3, "e":Ljava/lang/Exception;
    :try_start_6
    new-instance v11, Lcom/amazon/sdk/availability/AvailabilityServiceException;

    invoke-direct {v11, v3}, Lcom/amazon/sdk/availability/AvailabilityServiceException;-><init>(Ljava/lang/Throwable;)V

    throw v11
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0
.end method

.method protected handleSetIdentity(Landroid/content/Intent;)V
    .locals 11
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 415
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    .line 416
    .local v4, "extras":Landroid/os/Bundle;
    if-eqz v4, :cond_5

    .line 418
    const-string/jumbo v8, "marketplaceId"

    invoke-virtual {v4, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 419
    .local v5, "marketplaceId":Ljava/lang/String;
    const-string/jumbo v8, "customerId"

    invoke-virtual {v4, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 420
    .local v1, "customerId":Ljava/lang/String;
    const-string/jumbo v8, "deviceType"

    invoke-virtual {v4, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 421
    .local v3, "deviceType":Ljava/lang/String;
    const-string/jumbo v8, "deviceId"

    invoke-virtual {v4, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 422
    .local v2, "deviceId":Ljava/lang/String;
    const-string/jumbo v8, "region"

    invoke-virtual {v4, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 423
    .local v7, "region":Ljava/lang/String;
    const-string/jumbo v8, "clientIds"

    invoke-virtual {v4, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 424
    .local v0, "clientIds":Ljava/lang/String;
    const-string/jumbo v8, "processing setIdentity intent (%s, %s, %s, %s, %s, %s)"

    const/4 v9, 0x6

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v5, v9, v10

    const/4 v10, 0x1

    aput-object v1, v9, v10

    const/4 v10, 0x2

    aput-object v3, v9, v10

    const/4 v10, 0x3

    aput-object v2, v9, v10

    const/4 v10, 0x4

    aput-object v7, v9, v10

    const/4 v10, 0x5

    aput-object v0, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 428
    new-instance v6, Lcom/amazon/sdk/availability/Preferences;

    iget-object v8, p0, Lcom/amazon/sdk/availability/AvailabilityService;->context:Landroid/content/Context;

    invoke-direct {v6, v8}, Lcom/amazon/sdk/availability/Preferences;-><init>(Landroid/content/Context;)V

    .line 429
    .local v6, "preferences":Lcom/amazon/sdk/availability/Preferences;
    if-eqz v5, :cond_0

    .line 430
    const-string/jumbo v8, "marketplaceId"

    invoke-virtual {v6, v8, v5}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 432
    :cond_0
    if-eqz v1, :cond_1

    .line 433
    const-string/jumbo v8, "customerId"

    invoke-virtual {v6, v8, v1}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 435
    :cond_1
    if-eqz v3, :cond_2

    .line 436
    const-string/jumbo v8, "deviceType"

    invoke-virtual {v6, v8, v3}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 438
    :cond_2
    if-eqz v2, :cond_3

    .line 439
    const-string/jumbo v8, "deviceId"

    invoke-virtual {v6, v8, v2}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 441
    :cond_3
    if-eqz v7, :cond_4

    .line 442
    const-string/jumbo v8, "region"

    invoke-virtual {v6, v8, v7}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 444
    :cond_4
    if-eqz v0, :cond_5

    .line 445
    const-string/jumbo v8, "clientIds"

    invoke-virtual {v6, v8, v0}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 450
    .end local v0    # "clientIds":Ljava/lang/String;
    .end local v1    # "customerId":Ljava/lang/String;
    .end local v2    # "deviceId":Ljava/lang/String;
    .end local v3    # "deviceType":Ljava/lang/String;
    .end local v5    # "marketplaceId":Ljava/lang/String;
    .end local v6    # "preferences":Lcom/amazon/sdk/availability/Preferences;
    .end local v7    # "region":Ljava/lang/String;
    :cond_5
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->createSchedule()V

    .line 451
    return-void
.end method

.method protected handleSubmitMeasurementsIntent()V
    .locals 26

    .prologue
    .line 885
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->loadConfiguration()Lcom/amazon/sdk/availability/Configuration;

    move-result-object v7

    .line 887
    .local v7, "config":Lcom/amazon/sdk/availability/Configuration;
    invoke-virtual {v7}, Lcom/amazon/sdk/availability/Configuration;->getClientIds()Ljava/util/Set;

    move-result-object v5

    .line 888
    .local v5, "clientIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :cond_0
    :goto_0
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_4

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 889
    .local v4, "clientId":Ljava/lang/String;
    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v24, "analyzing "

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string/jumbo v24, " submission policies"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-static/range {v23 .. v23}, Lcom/amazon/sdk/availability/Logger;->i(Ljava/lang/String;)V

    .line 890
    invoke-virtual {v7, v4}, Lcom/amazon/sdk/availability/Configuration;->getCollectionConfiguration(Ljava/lang/String;)Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;

    move-result-object v6

    .line 893
    .local v6, "collectionConfig":Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    if-eqz v6, :cond_0

    .line 895
    invoke-virtual {v6}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getSubmissionPolicies()Ljava/util/List;

    move-result-object v21

    .line 897
    .local v21, "policies":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/sdk/availability/Configuration$Policy;>;"
    if-eqz v21, :cond_0

    .line 899
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/amazon/sdk/availability/AvailabilityService;->getLastClientSubmission(Ljava/lang/String;)J

    move-result-wide v15

    .line 902
    .local v15, "lastSubmission":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v17

    .line 904
    .local v17, "now":J
    move-object/from16 v0, p0

    move-wide v1, v15

    invoke-virtual {v0, v4, v1, v2}, Lcom/amazon/sdk/availability/AvailabilityService;->fixBrokenPreferences(Ljava/lang/String;J)V

    .line 907
    sub-long v8, v17, v15

    .line 910
    .local v8, "elapsed":J
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->isAirplaneMode()Z

    move-result v13

    .line 911
    .local v13, "inAirplaneMode":Z
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getConnectivity()Lcom/amazon/sdk/availability/Connectivity;

    move-result-object v3

    .line 914
    .local v3, "c":Lcom/amazon/sdk/availability/Connectivity;
    invoke-interface/range {v21 .. v21}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v12

    .local v12, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_0

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v22

    check-cast v22, Lcom/amazon/sdk/availability/Configuration$Policy;

    .line 915
    .local v22, "policy":Lcom/amazon/sdk/availability/Configuration$Policy;
    const-string/jumbo v23, "analyzing policy: %s"

    const/16 v24, 0x1

    move/from16 v0, v24

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v24, v0

    const/16 v25, 0x0

    aput-object v22, v24, v25

    invoke-static/range {v23 .. v24}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v23

    invoke-static/range {v23 .. v23}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 916
    invoke-virtual/range {v22 .. v22}, Lcom/amazon/sdk/availability/Configuration$Policy;->getPeriod()J

    move-result-wide v19

    .line 918
    .local v19, "period":J
    invoke-virtual/range {v22 .. v22}, Lcom/amazon/sdk/availability/Configuration$Policy;->isPackageSpecific()Z

    move-result v23

    if-nez v23, :cond_1

    const-wide/16 v23, -0x1

    cmp-long v23, v19, v23

    if-eqz v23, :cond_1

    .line 920
    cmp-long v23, v19, v8

    if-gez v23, :cond_2

    const/4 v10, 0x1

    .line 921
    .local v10, "hasEnoughTimeElapsed":Z
    :goto_1
    if-nez v13, :cond_3

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v3, v1}, Lcom/amazon/sdk/availability/AvailabilityService;->isNetworkSupported(Lcom/amazon/sdk/availability/Connectivity;Lcom/amazon/sdk/availability/Configuration$Policy;)Z

    move-result v23

    if-eqz v23, :cond_3

    const/4 v14, 0x1

    .line 922
    .local v14, "isNetworkSupported":Z
    :goto_2
    if-eqz v10, :cond_1

    if-eqz v14, :cond_1

    .line 923
    const-string/jumbo v23, "applying policy: %s"

    const/16 v24, 0x1

    move/from16 v0, v24

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v24, v0

    const/16 v25, 0x0

    aput-object v22, v24, v25

    invoke-static/range {v23 .. v24}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v23

    invoke-static/range {v23 .. v23}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 925
    move-object/from16 v0, p0

    move-wide v1, v15

    invoke-virtual {v0, v4, v1, v2}, Lcom/amazon/sdk/availability/AvailabilityService;->submitMeasurements(Ljava/lang/String;J)Z

    move-result v23

    if-eqz v23, :cond_0

    .line 927
    move-object/from16 v0, p0

    move-wide/from16 v1, v17

    invoke-virtual {v0, v4, v1, v2}, Lcom/amazon/sdk/availability/AvailabilityService;->setLastClientSubmission(Ljava/lang/String;J)V

    goto/16 :goto_0

    .line 920
    .end local v10    # "hasEnoughTimeElapsed":Z
    .end local v14    # "isNetworkSupported":Z
    :cond_2
    const/4 v10, 0x0

    goto :goto_1

    .line 921
    .restart local v10    # "hasEnoughTimeElapsed":Z
    :cond_3
    const/4 v14, 0x0

    goto :goto_2

    .line 936
    .end local v3    # "c":Lcom/amazon/sdk/availability/Connectivity;
    .end local v4    # "clientId":Ljava/lang/String;
    .end local v6    # "collectionConfig":Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    .end local v8    # "elapsed":J
    .end local v10    # "hasEnoughTimeElapsed":Z
    .end local v12    # "i$":Ljava/util/Iterator;
    .end local v13    # "inAirplaneMode":Z
    .end local v15    # "lastSubmission":J
    .end local v17    # "now":J
    .end local v19    # "period":J
    .end local v21    # "policies":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/sdk/availability/Configuration$Policy;>;"
    .end local v22    # "policy":Lcom/amazon/sdk/availability/Configuration$Policy;
    :cond_4
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v23

    const-string/jumbo v24, "SubmitMeasurements"

    const/16 v25, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    invoke-direct {v0, v1, v2}, Lcom/amazon/sdk/availability/AvailabilityService;->getIntent(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Lcom/amazon/android/service/SchedulePeriodicWork;->workComplete(Landroid/content/Context;Landroid/content/Intent;)V

    .line 937
    return-void
.end method

.method protected handleSyncConfigurationIntent()V
    .locals 27

    .prologue
    .line 707
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v21

    .line 708
    .local v21, "now":J
    new-instance v23, Lcom/amazon/sdk/availability/Preferences;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v3

    move-object/from16 v0, v23

    invoke-direct {v0, v3}, Lcom/amazon/sdk/availability/Preferences;-><init>(Landroid/content/Context;)V

    .line 709
    .local v23, "preferences":Lcom/amazon/sdk/availability/Preferences;
    const-string/jumbo v3, "marketplaceId"

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 710
    .local v4, "marketplaceId":Ljava/lang/String;
    const-string/jumbo v3, "customerId"

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 711
    .local v5, "customerId":Ljava/lang/String;
    const-string/jumbo v3, "deviceType"

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 712
    .local v6, "deviceType":Ljava/lang/String;
    const-string/jumbo v3, "deviceId"

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 713
    .local v7, "deviceId":Ljava/lang/String;
    const-string/jumbo v3, "region"

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 714
    .local v12, "region":Ljava/lang/String;
    const-string/jumbo v3, "clientIds"

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v8, ","

    invoke-static {v3, v8}, Lcom/amazon/sdk/availability/StringUtil;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v13

    .line 717
    .local v13, "clientIds":[Ljava/lang/String;
    const-string/jumbo v3, "submissionState"

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    .line 718
    .local v26, "submissionState":Ljava/lang/String;
    if-eqz v26, :cond_0

    .line 719
    const-string/jumbo v3, "submissionState"

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Lcom/amazon/sdk/availability/Preferences;->remove(Ljava/lang/String;)V

    .line 723
    :cond_0
    const/4 v15, 0x0

    .line 725
    .local v15, "config":Lcom/amazon/sdk/availability/Configuration;
    :try_start_0
    invoke-static {}, Lcom/amazon/sdk/availability/ConfigurationClientFactory;->getConfigurationClient()Lcom/amazon/sdk/availability/ConfigurationClient;

    move-result-object v2

    .line 726
    .local v2, "cc":Lcom/amazon/sdk/availability/ConfigurationClient;
    const-string/jumbo v3, "1.3"

    sget-object v8, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sget-object v9, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getCarrierName()Ljava/lang/String;

    move-result-object v10

    sget-object v11, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    const/4 v14, 0x0

    invoke-interface/range {v2 .. v14}, Lcom/amazon/sdk/availability/ConfigurationClient;->getAvailabilityConfiguration(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/amazon/sdk/availability/SubmissionState;)Lcom/amazon/sdk/availability/Configuration;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v15

    .line 734
    .end local v2    # "cc":Lcom/amazon/sdk/availability/ConfigurationClient;
    :goto_0
    if-eqz v15, :cond_4

    .line 736
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "retrieved configuration: "

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v15}, Lcom/amazon/sdk/availability/Configuration;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 738
    const-string/jumbo v3, "configuration"

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Lcom/amazon/sdk/availability/Preferences;->remove(Ljava/lang/String;)V

    .line 740
    invoke-virtual {v15}, Lcom/amazon/sdk/availability/Configuration;->getJson()Lorg/json/JSONObject;

    move-result-object v16

    .line 741
    .local v16, "configJson":Lorg/json/JSONObject;
    if-eqz v16, :cond_1

    .line 742
    const-string/jumbo v3, "configuration"

    invoke-virtual/range {v16 .. v16}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v8

    move-object/from16 v0, v23

    invoke-virtual {v0, v3, v8}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 745
    :cond_1
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v15}, Lcom/amazon/sdk/availability/Configuration;->getStateServerTime()Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    invoke-static {v3, v8, v9}, Lcom/amazon/sdk/availability/Clock;->updateAdjustment(Landroid/content/Context;J)V

    .line 747
    new-instance v3, Lcom/amazon/sdk/availability/ConfigurationState;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-direct {v3, v8}, Lcom/amazon/sdk/availability/ConfigurationState;-><init>(Landroid/content/Context;)V

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v3, v8, v15}, Lcom/amazon/sdk/availability/ConfigurationState;->updateSchedule(Landroid/content/Context;Lcom/amazon/sdk/availability/Configuration;)Lcom/amazon/sdk/availability/ConfigurationState;

    .line 749
    invoke-virtual {v15}, Lcom/amazon/sdk/availability/Configuration;->getStateNextRefresh()Ljava/lang/Long;

    move-result-object v20

    .line 750
    .local v20, "nextRefresh":Ljava/lang/Long;
    if-eqz v20, :cond_2

    .line 751
    invoke-virtual/range {v20 .. v20}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    add-long v8, v8, v21

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v3, v1}, Lcom/amazon/sdk/availability/AvailabilityService;->scheduleSync(Ljava/lang/Long;Ljava/lang/Long;)V

    .line 753
    :cond_2
    invoke-virtual {v15}, Lcom/amazon/sdk/availability/Configuration;->getStateSubmissionInterval()Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/amazon/sdk/availability/AvailabilityService;->scheduleSubmit(Ljava/lang/Long;)V

    .line 767
    .end local v16    # "configJson":Lorg/json/JSONObject;
    .end local v20    # "nextRefresh":Ljava/lang/Long;
    :cond_3
    :goto_1
    return-void

    .line 729
    :catch_0
    move-exception v19

    .line 730
    .local v19, "e":Ljava/lang/Exception;
    const-string/jumbo v3, "error retrieving configuration"

    move-object/from16 v0, v19

    invoke-static {v3, v0}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 756
    .end local v19    # "e":Ljava/lang/Exception;
    :cond_4
    const-wide/16 v24, -0x1

    .line 757
    .local v24, "retryInterval":J
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->loadConfiguration()Lcom/amazon/sdk/availability/Configuration;

    move-result-object v18

    .line 758
    .local v18, "configuration":Lcom/amazon/sdk/availability/Configuration;
    invoke-virtual/range {v18 .. v18}, Lcom/amazon/sdk/availability/Configuration;->getStateRetryInterval()Ljava/lang/Long;

    move-result-object v17

    .line 759
    .local v17, "configRetryInterval":Ljava/lang/Long;
    if-eqz v17, :cond_5

    .line 760
    invoke-virtual/range {v17 .. v17}, Ljava/lang/Long;->longValue()J

    move-result-wide v24

    .line 762
    :cond_5
    const-wide/16 v8, 0x0

    cmp-long v3, v24, v8

    if-ltz v3, :cond_3

    .line 764
    add-long v8, v21, v24

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    const-wide/16 v8, 0x0

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v8}, Lcom/amazon/sdk/availability/AvailabilityService;->scheduleSync(Ljava/lang/Long;Ljava/lang/Long;)V

    goto :goto_1
.end method

.method protected handleThrowable(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 1355
    invoke-static {p1, p2}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1356
    instance-of v0, p2, Ljava/lang/ThreadDeath;

    if-eqz v0, :cond_0

    .line 1357
    check-cast p2, Ljava/lang/ThreadDeath;

    .end local p2    # "t":Ljava/lang/Throwable;
    throw p2

    .line 1360
    .restart local p2    # "t":Ljava/lang/Throwable;
    :cond_0
    instance-of v0, p2, Ljava/lang/InterruptedException;

    if-eqz v0, :cond_2

    .line 1361
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    .line 1368
    :cond_1
    return-void

    .line 1365
    :cond_2
    invoke-static {}, Lcom/amazon/sdk/availability/Stage;->isProduction()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1366
    new-instance v0, Ljava/lang/RuntimeException;

    const-string/jumbo v1, "Debug, unhandled throwable caught in non-prod mode"

    invoke-direct {v0, v1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0
.end method

.method protected isAirplaneMode()Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1315
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string/jumbo v4, "airplane_mode_on"

    invoke-static {v3, v4, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v3

    if-eqz v3, :cond_0

    move v0, v1

    .line 1317
    .local v0, "inAirplaneMode":Z
    :goto_0
    const-string/jumbo v3, "airplane mode: %s"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v1, v2

    invoke-static {v3, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 1318
    return v0

    .end local v0    # "inAirplaneMode":Z
    :cond_0
    move v0, v2

    .line 1315
    goto :goto_0
.end method

.method protected isNetworkSupported(Lcom/amazon/sdk/availability/Connectivity;Lcom/amazon/sdk/availability/Configuration$Policy;)Z
    .locals 6
    .param p1, "c"    # Lcom/amazon/sdk/availability/Connectivity;
    .param p2, "policy"    # Lcom/amazon/sdk/availability/Configuration$Policy;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 1210
    invoke-virtual {p1}, Lcom/amazon/sdk/availability/Connectivity;->hasWifi()Z

    move-result v5

    if-eqz v5, :cond_2

    sget-object v5, Lcom/amazon/sdk/availability/Connectivity$Network;->WIFI:Lcom/amazon/sdk/availability/Connectivity$Network;

    invoke-virtual {p2, v5}, Lcom/amazon/sdk/availability/Configuration$Policy;->isExcluded(Lcom/amazon/sdk/availability/Connectivity$Network;)Z

    move-result v5

    if-nez v5, :cond_2

    move v2, v3

    .line 1211
    .local v2, "supportedViaWifi":Z
    :goto_0
    invoke-virtual {p1}, Lcom/amazon/sdk/availability/Connectivity;->hasMobile()Z

    move-result v5

    if-eqz v5, :cond_3

    sget-object v5, Lcom/amazon/sdk/availability/Connectivity$Network;->MOBILE:Lcom/amazon/sdk/availability/Connectivity$Network;

    invoke-virtual {p2, v5}, Lcom/amazon/sdk/availability/Configuration$Policy;->isExcluded(Lcom/amazon/sdk/availability/Connectivity$Network;)Z

    move-result v5

    if-nez v5, :cond_3

    move v1, v3

    .line 1212
    .local v1, "supportedViaMobile":Z
    :goto_1
    invoke-virtual {p1}, Lcom/amazon/sdk/availability/Connectivity;->hasEthernet()Z

    move-result v5

    if-eqz v5, :cond_4

    sget-object v5, Lcom/amazon/sdk/availability/Connectivity$Network;->ETHERNET:Lcom/amazon/sdk/availability/Connectivity$Network;

    invoke-virtual {p2, v5}, Lcom/amazon/sdk/availability/Configuration$Policy;->isExcluded(Lcom/amazon/sdk/availability/Connectivity$Network;)Z

    move-result v5

    if-nez v5, :cond_4

    move v0, v3

    .line 1213
    .local v0, "supportedViaEthernet":Z
    :goto_2
    if-nez v2, :cond_0

    if-nez v1, :cond_0

    if-eqz v0, :cond_1

    :cond_0
    move v4, v3

    :cond_1
    return v4

    .end local v0    # "supportedViaEthernet":Z
    .end local v1    # "supportedViaMobile":Z
    .end local v2    # "supportedViaWifi":Z
    :cond_2
    move v2, v4

    .line 1210
    goto :goto_0

    .restart local v2    # "supportedViaWifi":Z
    :cond_3
    move v1, v4

    .line 1211
    goto :goto_1

    .restart local v1    # "supportedViaMobile":Z
    :cond_4
    move v0, v4

    .line 1212
    goto :goto_2
.end method

.method protected loadConfiguration()Lcom/amazon/sdk/availability/Configuration;
    .locals 13

    .prologue
    .line 793
    const-class v11, Lcom/amazon/sdk/availability/AvailabilityService;

    const-string/jumbo v12, "loadConfiguration"

    invoke-static {v11, v12}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v7

    .line 794
    .local v7, "methodScope":Lcom/amazon/profiling/ProfilerScope;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    .line 795
    .local v8, "now":J
    new-instance v10, Lcom/amazon/sdk/availability/Preferences;

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v11

    invoke-direct {v10, v11}, Lcom/amazon/sdk/availability/Preferences;-><init>(Landroid/content/Context;)V

    .line 796
    .local v10, "preferences":Lcom/amazon/sdk/availability/Preferences;
    new-instance v0, Lcom/amazon/sdk/availability/ConfigurationState;

    iget-object v11, p0, Lcom/amazon/sdk/availability/AvailabilityService;->context:Landroid/content/Context;

    invoke-direct {v0, v11}, Lcom/amazon/sdk/availability/ConfigurationState;-><init>(Landroid/content/Context;)V

    .line 797
    .local v0, "c":Lcom/amazon/sdk/availability/ConfigurationState;
    invoke-virtual {v0}, Lcom/amazon/sdk/availability/ConfigurationState;->getConfigurationExpiry()Ljava/lang/Long;

    move-result-object v6

    .line 798
    .local v6, "expiry":Ljava/lang/Long;
    new-instance v4, Lcom/amazon/sdk/availability/Configuration;

    const/4 v11, 0x0

    invoke-direct {v4, v11}, Lcom/amazon/sdk/availability/Configuration;-><init>(Lorg/json/JSONObject;)V

    .line 801
    .local v4, "configuration":Lcom/amazon/sdk/availability/Configuration;
    if-eqz v6, :cond_0

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v11

    cmp-long v11, v11, v8

    if-lez v11, :cond_1

    .line 803
    :cond_0
    const-string/jumbo v11, "configuration"

    invoke-virtual {v10, v11}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 804
    .local v1, "configJson":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 805
    const/4 v2, 0x0

    .line 807
    .local v2, "configObject":Lorg/json/JSONObject;
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v2    # "configObject":Lorg/json/JSONObject;
    .local v3, "configObject":Lorg/json/JSONObject;
    move-object v2, v3

    .line 812
    .end local v3    # "configObject":Lorg/json/JSONObject;
    .restart local v2    # "configObject":Lorg/json/JSONObject;
    :goto_0
    if-eqz v2, :cond_1

    .line 813
    new-instance v4, Lcom/amazon/sdk/availability/Configuration;

    .end local v4    # "configuration":Lcom/amazon/sdk/availability/Configuration;
    invoke-direct {v4, v2}, Lcom/amazon/sdk/availability/Configuration;-><init>(Lorg/json/JSONObject;)V

    .line 818
    .end local v1    # "configJson":Ljava/lang/String;
    .end local v2    # "configObject":Lorg/json/JSONObject;
    .restart local v4    # "configuration":Lcom/amazon/sdk/availability/Configuration;
    :cond_1
    invoke-virtual {p0, v4}, Lcom/amazon/sdk/availability/AvailabilityService;->warnOnceAboutPRNG(Lcom/amazon/sdk/availability/Configuration;)V

    .line 820
    invoke-static {v7}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    .line 821
    return-object v4

    .line 808
    .restart local v1    # "configJson":Ljava/lang/String;
    .restart local v2    # "configObject":Lorg/json/JSONObject;
    :catch_0
    move-exception v5

    .line 809
    .local v5, "e":Lorg/json/JSONException;
    const-string/jumbo v11, "failed to parse stored configuration"

    invoke-static {v11, v5}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onCreate()V
    .locals 2

    .prologue
    .line 158
    invoke-super {p0}, Lcom/amazon/android/service/IntentTimeoutService;->onCreate()V

    .line 159
    const-string/jumbo v0, "onCreate()"

    invoke-static {v0}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 160
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "Stage is "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/amazon/sdk/availability/Stage;->getDomain()Lcom/amazon/sdk/availability/Stage$Domain;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 161
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 290
    invoke-super {p0}, Lcom/amazon/android/service/IntentTimeoutService;->onDestroy()V

    .line 291
    const-string/jumbo v0, "onDestroy()"

    invoke-static {v0}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 292
    return-void
.end method

.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 183
    const-class v3, Lcom/amazon/sdk/availability/AvailabilityService;

    const-string/jumbo v4, "onHandleIntent"

    invoke-static {v3, v4}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v1

    .line 185
    .local v1, "methodScope":Lcom/amazon/profiling/ProfilerScope;
    if-nez p1, :cond_0

    .line 219
    invoke-static {v1}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    .line 221
    :goto_0
    return-void

    .line 189
    :cond_0
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->setContextIfNeeded()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 192
    :try_start_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 193
    .local v0, "intentAction":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "received intent: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Landroid/content/Intent;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 194
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "intentAction = <<"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ">>"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 196
    const-string/jumbo v3, "SetIdentity"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 197
    invoke-virtual {p0, p1}, Lcom/amazon/sdk/availability/AvailabilityService;->handleSetIdentity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 219
    .end local v0    # "intentAction":Ljava/lang/String;
    :cond_1
    :goto_1
    invoke-static {v1}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    goto :goto_0

    .line 198
    .restart local v0    # "intentAction":Ljava/lang/String;
    :cond_2
    :try_start_2
    const-string/jumbo v3, "PutMeasurement"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 199
    invoke-virtual {p0, p1}, Lcom/amazon/sdk/availability/AvailabilityService;->handlePutMeasurement(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 215
    .end local v0    # "intentAction":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 216
    .local v2, "t":Ljava/lang/Throwable;
    :try_start_3
    const-string/jumbo v3, "uncaught error handling intent"

    invoke-virtual {p0, v3, v2}, Lcom/amazon/sdk/availability/AvailabilityService;->handleThrowable(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 219
    .end local v2    # "t":Ljava/lang/Throwable;
    :catchall_0
    move-exception v3

    invoke-static {v1}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    throw v3

    .line 200
    .restart local v0    # "intentAction":Ljava/lang/String;
    :cond_3
    :try_start_4
    const-string/jumbo v3, "SyncConfiguration"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 201
    const-string/jumbo v3, "processing syncConfiguration intent"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 203
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->handleSyncConfigurationIntent()V

    goto :goto_1

    .line 204
    :cond_4
    const-string/jumbo v3, "SubmitMeasurements"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 206
    const-string/jumbo v3, "processing submitMeasurements intent"

    invoke-static {v3}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 207
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->handleSubmitMeasurementsIntent()V

    goto :goto_1

    .line 208
    :cond_5
    const-string/jumbo v3, "SubmitMeasurementsUponStart"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 210
    const-string/jumbo v3, "processing submitMeasurementsUponStart intent"

    invoke-static {v3}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 211
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->handleSubmitMeasurementsIntent()V

    goto :goto_1

    .line 212
    :cond_6
    const-string/jumbo v3, "ForceSubmitMeasurements"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 213
    invoke-virtual {p0, p1}, Lcom/amazon/sdk/availability/AvailabilityService;->handleForceSubmitMeasurementsIntent(Landroid/content/Intent;)V
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_1
.end method

.method protected onTimeout()V
    .locals 2

    .prologue
    .line 273
    invoke-super {p0}, Lcom/amazon/android/service/IntentTimeoutService;->onTimeout()V

    .line 276
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/amazon/sdk/availability/AvailabilityService;->submissionScheduledForThisInstance:Z

    .line 279
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->updateSubmitSchedule()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 283
    :goto_0
    return-void

    .line 280
    :catch_0
    move-exception v0

    .line 281
    .local v0, "t":Ljava/lang/Throwable;
    const-string/jumbo v1, "Caught throwable trying to update schedule"

    invoke-virtual {p0, v1, v0}, Lcom/amazon/sdk/availability/AvailabilityService;->handleThrowable(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected scheduleSubmit(Ljava/lang/Long;)V
    .locals 4
    .param p1, "interval"    # Ljava/lang/Long;

    .prologue
    .line 347
    if-eqz p1, :cond_0

    .line 348
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string/jumbo v1, "SubmitMeasurements"

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lcom/amazon/sdk/availability/AvailabilityService;->getIntent(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/android/service/SchedulePeriodicWork;->scheduleWork(Landroid/content/Context;Landroid/content/Intent;J)V

    .line 350
    :cond_0
    return-void
.end method

.method protected scheduleSync(Ljava/lang/Long;Ljava/lang/Long;)V
    .locals 8
    .param p1, "time"    # Ljava/lang/Long;
    .param p2, "interval"    # Ljava/lang/Long;

    .prologue
    const/4 v1, 0x1

    .line 327
    const-string/jumbo v0, "SyncConfiguration"

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v2}, Lcom/amazon/sdk/availability/AvailabilityService;->getPendingIntent(Ljava/lang/String;Landroid/os/Bundle;)Landroid/app/PendingIntent;

    move-result-object v6

    .line 328
    .local v6, "intent":Landroid/app/PendingIntent;
    if-eqz p1, :cond_0

    .line 329
    if-eqz p2, :cond_1

    .line 330
    iget-object v0, p0, Lcom/amazon/sdk/availability/AvailabilityService;->alarmManager:Landroid/app/AlarmManager;

    invoke-virtual {v0, v6}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 331
    iget-object v0, p0, Lcom/amazon/sdk/availability/AvailabilityService;->alarmManager:Landroid/app/AlarmManager;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {p2}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-virtual/range {v0 .. v6}, Landroid/app/AlarmManager;->setInexactRepeating(IJJLandroid/app/PendingIntent;)V

    .line 336
    :cond_0
    :goto_0
    if-eqz p2, :cond_2

    move v7, v1

    .line 337
    .local v7, "isRepeating":Z
    :goto_1
    invoke-static {p1, v7}, Lcom/amazon/sdk/availability/Logger;->syncConfigurationScheduled(Ljava/lang/Long;Z)V

    .line 338
    return-void

    .line 333
    .end local v7    # "isRepeating":Z
    :cond_1
    iget-object v0, p0, Lcom/amazon/sdk/availability/AvailabilityService;->alarmManager:Landroid/app/AlarmManager;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3, v6}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    goto :goto_0

    .line 336
    :cond_2
    const/4 v7, 0x0

    goto :goto_1
.end method

.method protected setAlarmManager(Landroid/app/AlarmManager;)V
    .locals 0
    .param p1, "alarmManager"    # Landroid/app/AlarmManager;

    .prologue
    .line 1165
    iput-object p1, p0, Lcom/amazon/sdk/availability/AvailabilityService;->alarmManager:Landroid/app/AlarmManager;

    .line 1166
    return-void
.end method

.method protected setContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1145
    iput-object p1, p0, Lcom/amazon/sdk/availability/AvailabilityService;->context:Landroid/content/Context;

    .line 1146
    return-void
.end method

.method protected setContextIfNeeded()V
    .locals 2

    .prologue
    .line 167
    iget-object v0, p0, Lcom/amazon/sdk/availability/AvailabilityService;->context:Landroid/content/Context;

    if-nez v0, :cond_0

    .line 168
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/sdk/availability/AvailabilityService;->setContext(Landroid/content/Context;)V

    .line 171
    :cond_0
    iget-object v0, p0, Lcom/amazon/sdk/availability/AvailabilityService;->context:Landroid/content/Context;

    if-eqz v0, :cond_1

    .line 172
    iget-object v0, p0, Lcom/amazon/sdk/availability/AvailabilityService;->context:Landroid/content/Context;

    const-string/jumbo v1, "alarm"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    invoke-virtual {p0, v0}, Lcom/amazon/sdk/availability/AvailabilityService;->setAlarmManager(Landroid/app/AlarmManager;)V

    .line 174
    :cond_1
    return-void
.end method

.method protected setLastClientSubmission(Ljava/lang/String;J)V
    .locals 3
    .param p1, "clientId"    # Ljava/lang/String;
    .param p2, "time"    # J

    .prologue
    .line 1251
    new-instance v0, Lcom/amazon/sdk/availability/Preferences;

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/sdk/availability/Preferences;-><init>(Landroid/content/Context;)V

    .line 1252
    .local v0, "preferences":Lcom/amazon/sdk/availability/Preferences;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "lastClientSubmission-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p2, p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1253
    return-void
.end method

.method protected submitImmediateMeasurements(Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 19
    .param p1, "collectionConfig"    # Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    .param p2, "clientId"    # Ljava/lang/String;
    .param p3, "measurementJson"    # Lorg/json/JSONObject;

    .prologue
    .line 525
    const-class v15, Lcom/amazon/sdk/availability/AvailabilityService;

    const-string/jumbo v16, "submitImmediateMeasurements"

    invoke-static/range {v15 .. v16}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v9

    .line 528
    .local v9, "methodScope":Lcom/amazon/profiling/ProfilerScope;
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getSubmissionPolicies()Ljava/util/List;

    move-result-object v13

    .line 530
    .local v13, "policies":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/sdk/availability/Configuration$Policy;>;"
    if-eqz v13, :cond_1

    .line 532
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Lcom/amazon/sdk/availability/AvailabilityService;->getLastClientSubmission(Ljava/lang/String;)J

    move-result-wide v7

    .line 534
    .local v7, "lastSubmission":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    .line 537
    .local v10, "now":J
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v7, v8}, Lcom/amazon/sdk/availability/AvailabilityService;->fixBrokenPreferences(Ljava/lang/String;J)V

    .line 539
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Lcom/amazon/sdk/availability/AvailabilityService;->getPackageNameForMeasurement(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v12

    .line 541
    .local v12, "packageName":Ljava/lang/String;
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->isAirplaneMode()Z

    move-result v4

    .line 542
    .local v4, "inAirplaneMode":Z
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getConnectivity()Lcom/amazon/sdk/availability/Connectivity;

    move-result-object v2

    .line 544
    .local v2, "c":Lcom/amazon/sdk/availability/Connectivity;
    invoke-interface {v13}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/amazon/sdk/availability/Configuration$Policy;

    .line 546
    .local v14, "policy":Lcom/amazon/sdk/availability/Configuration$Policy;
    invoke-virtual {v14}, Lcom/amazon/sdk/availability/Configuration$Policy;->getPeriod()J

    move-result-wide v15

    const-wide/16 v17, 0x0

    cmp-long v15, v15, v17

    if-nez v15, :cond_0

    .line 548
    invoke-virtual {v14, v12}, Lcom/amazon/sdk/availability/Configuration$Policy;->isPackageSupported(Ljava/lang/String;)Z

    move-result v6

    .line 550
    .local v6, "isPackageSupported":Z
    if-nez v4, :cond_2

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v14}, Lcom/amazon/sdk/availability/AvailabilityService;->isNetworkSupported(Lcom/amazon/sdk/availability/Connectivity;Lcom/amazon/sdk/availability/Configuration$Policy;)Z

    move-result v15

    if-eqz v15, :cond_2

    const/4 v5, 0x1

    .line 552
    .local v5, "isNetworkSupported":Z
    :goto_0
    if-eqz v6, :cond_0

    if-eqz v5, :cond_0

    move-object/from16 v0, p3

    invoke-virtual {v14, v0}, Lcom/amazon/sdk/availability/Configuration$Policy;->applies(Lorg/json/JSONObject;)Z

    move-result v15

    if-eqz v15, :cond_0

    .line 554
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v16, "policy "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string/jumbo v16, " applies to measurement "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p3

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 556
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v7, v8}, Lcom/amazon/sdk/availability/AvailabilityService;->submitMeasurements(Ljava/lang/String;J)Z

    move-result v15

    if-eqz v15, :cond_1

    .line 558
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v10, v11}, Lcom/amazon/sdk/availability/AvailabilityService;->setLastClientSubmission(Ljava/lang/String;J)V

    .line 565
    .end local v2    # "c":Lcom/amazon/sdk/availability/Connectivity;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "inAirplaneMode":Z
    .end local v5    # "isNetworkSupported":Z
    .end local v6    # "isPackageSupported":Z
    .end local v7    # "lastSubmission":J
    .end local v10    # "now":J
    .end local v12    # "packageName":Ljava/lang/String;
    .end local v14    # "policy":Lcom/amazon/sdk/availability/Configuration$Policy;
    :cond_1
    invoke-static {v9}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    .line 566
    return-void

    .line 550
    .restart local v2    # "c":Lcom/amazon/sdk/availability/Connectivity;
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v4    # "inAirplaneMode":Z
    .restart local v6    # "isPackageSupported":Z
    .restart local v7    # "lastSubmission":J
    .restart local v10    # "now":J
    .restart local v12    # "packageName":Ljava/lang/String;
    .restart local v14    # "policy":Lcom/amazon/sdk/availability/Configuration$Policy;
    :cond_2
    const/4 v5, 0x0

    goto :goto_0
.end method

.method protected submitMeasurements(Ljava/lang/String;J)Z
    .locals 33
    .param p1, "clientId"    # Ljava/lang/String;
    .param p2, "lastSubmission"    # J

    .prologue
    .line 949
    const/16 v28, 0x0

    .line 951
    .local v28, "submissionSuccess":Z
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->loadConfiguration()Lcom/amazon/sdk/availability/Configuration;

    move-result-object v7

    .line 952
    .local v7, "config":Lcom/amazon/sdk/availability/Configuration;
    move-object/from16 v0, p1

    invoke-virtual {v7, v0}, Lcom/amazon/sdk/availability/Configuration;->getCollectionConfiguration(Ljava/lang/String;)Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;

    move-result-object v6

    .line 956
    .local v6, "collectionConfig":Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    if-nez v6, :cond_1

    .line 957
    const/16 v30, 0x0

    .line 1090
    :cond_0
    :goto_0
    return v30

    .line 960
    :cond_1
    invoke-virtual {v6}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getAwsAccessId()Ljava/lang/String;

    move-result-object v5

    .line 961
    .local v5, "accessId":Ljava/lang/String;
    invoke-virtual {v6}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getAwsSecretKey()Ljava/lang/String;

    move-result-object v22

    .line 962
    .local v22, "secretKey":Ljava/lang/String;
    invoke-virtual {v6}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getAwsSesssionToken()Ljava/lang/String;

    move-result-object v23

    .line 964
    .local v23, "sessionToken":Ljava/lang/String;
    if-eqz v5, :cond_2

    if-nez v22, :cond_3

    .line 965
    :cond_2
    const/16 v30, 0x0

    goto :goto_0

    .line 969
    :cond_3
    if-eqz v23, :cond_5

    .line 970
    new-instance v8, Lcom/amazonaws/auth/BasicSessionCredentials;

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    invoke-direct {v8, v5, v0, v1}, Lcom/amazonaws/auth/BasicSessionCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 976
    .local v8, "creds":Lcom/amazonaws/auth/AWSCredentials;
    :goto_1
    invoke-virtual {v6}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getS3Bucket()Ljava/lang/String;

    move-result-object v18

    .line 977
    .local v18, "s3Bucket":Ljava/lang/String;
    invoke-virtual {v6}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getS3DateFormatKey()Ljava/lang/String;

    move-result-object v19

    .line 980
    .local v19, "s3FormatKey":Ljava/lang/String;
    if-eqz v18, :cond_4

    if-nez v19, :cond_6

    .line 981
    :cond_4
    const/16 v30, 0x0

    goto :goto_0

    .line 973
    .end local v8    # "creds":Lcom/amazonaws/auth/AWSCredentials;
    .end local v18    # "s3Bucket":Ljava/lang/String;
    .end local v19    # "s3FormatKey":Ljava/lang/String;
    :cond_5
    new-instance v8, Lcom/amazonaws/auth/BasicAWSCredentials;

    move-object/from16 v0, v22

    invoke-direct {v8, v5, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .restart local v8    # "creds":Lcom/amazonaws/auth/AWSCredentials;
    goto :goto_1

    .line 984
    .restart local v18    # "s3Bucket":Ljava/lang/String;
    .restart local v19    # "s3FormatKey":Ljava/lang/String;
    :cond_6
    new-instance v21, Ljava/text/SimpleDateFormat;

    move-object/from16 v0, v21

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 985
    .local v21, "sdf":Ljava/text/SimpleDateFormat;
    const-string/jumbo v30, "GMT"

    invoke-static/range {v30 .. v30}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v30

    move-object/from16 v0, v21

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 986
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v30

    invoke-static/range {v30 .. v30}, Lcom/amazon/sdk/availability/Clock;->getCurrentTime(Landroid/content/Context;)J

    move-result-wide v30

    invoke-static/range {v30 .. v31}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v30

    move-object/from16 v0, v21

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    .line 989
    .local v20, "s3Key":Ljava/lang/String;
    const-wide/16 v16, 0x0

    .line 991
    .local v16, "numMeasurements":J
    const/4 v9, 0x0

    .line 993
    .local v9, "dataStore":Lcom/amazon/sdk/availability/DataStore;
    :try_start_0
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v1, v6}, Lcom/amazon/sdk/availability/AvailabilityService;->getAndOpenDataStore(Ljava/lang/String;Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;)Lcom/amazon/sdk/availability/DataStore;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v9

    .line 994
    if-nez v9, :cond_7

    .line 995
    const/16 v30, 0x0

    .line 1067
    if-eqz v9, :cond_0

    .line 1068
    invoke-interface {v9}, Lcom/amazon/sdk/availability/DataStore;->close()V

    goto :goto_0

    .line 998
    :cond_7
    :try_start_1
    new-instance v30, Ljava/lang/StringBuilder;

    invoke-direct/range {v30 .. v30}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v31, "looking for "

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    const-string/jumbo v31, " measurements to submit..."

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v30

    invoke-static/range {v30 .. v30}, Lcom/amazon/sdk/availability/Logger;->i(Ljava/lang/String;)V

    .line 1001
    move-wide/from16 v0, p2

    invoke-interface {v9, v0, v1}, Lcom/amazon/sdk/availability/DataStore;->getMeasurementsAfter(J)Lcom/amazon/sdk/availability/DataStoreIterator;

    move-result-object v13

    .line 1005
    .local v13, "iterator":Lcom/amazon/sdk/availability/DataStoreIterator;, "Lcom/amazon/sdk/availability/DataStoreIterator<Ljava/lang/String;>;"
    invoke-interface {v13}, Lcom/amazon/sdk/availability/DataStoreIterator;->hasNext()Z

    move-result v12

    .line 1008
    .local v12, "hasNext":Z
    if-eqz v12, :cond_e

    .line 1009
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/sdk/availability/AvailabilityService;->context:Landroid/content/Context;

    move-object/from16 v30, v0

    invoke-virtual/range {v30 .. v30}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v26

    .line 1010
    .local v26, "stagedDir":Ljava/io/File;
    const-string/jumbo v30, "submission"

    const-string/jumbo v31, "gz"

    move-object/from16 v0, v30

    move-object/from16 v1, v31

    move-object/from16 v2, v26

    invoke-static {v0, v1, v2}, Ljava/io/File;->createTempFile(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;

    move-result-object v27

    .line 1011
    .local v27, "stagedFile":Ljava/io/File;
    new-instance v30, Ljava/lang/StringBuilder;

    invoke-direct/range {v30 .. v30}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v31, "stagedFile is "

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v30

    invoke-static/range {v30 .. v30}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 1012
    new-instance v24, Lcom/amazon/sdk/availability/StagingStream;

    invoke-virtual {v6}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getPublicKeyString()Ljava/lang/String;

    move-result-object v30

    invoke-virtual {v6}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getPublicKeySerial()J

    move-result-wide v31

    move-object/from16 v0, v24

    move-object/from16 v1, v27

    move-object/from16 v2, v30

    move-wide/from16 v3, v31

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/sdk/availability/StagingStream;-><init>(Ljava/io/File;Ljava/lang/String;J)V

    .line 1016
    .local v24, "sos":Lcom/amazon/sdk/availability/StagingStream;
    new-instance v29, Ljava/io/BufferedOutputStream;

    const/high16 v30, 0x10000

    move-object/from16 v0, v29

    move-object/from16 v1, v24

    move/from16 v2, v30

    invoke-direct {v0, v1, v2}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;I)V
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1018
    .local v29, "zos":Ljava/io/OutputStream;
    :goto_2
    if-eqz v12, :cond_c

    .line 1022
    :try_start_2
    invoke-interface {v13}, Lcom/amazon/sdk/availability/DataStoreIterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    .line 1023
    .local v15, "measurement":Ljava/lang/String;
    new-instance v30, Ljava/lang/StringBuilder;

    invoke-direct/range {v30 .. v30}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v30

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    const-string/jumbo v31, "\n"

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v30

    const-string/jumbo v31, "UTF-8"

    invoke-virtual/range {v30 .. v31}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/io/OutputStream;->write([B)V
    :try_end_2
    .catch Lcom/amazon/sdk/availability/DataStoreException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1024
    const-wide/16 v30, 0x1

    add-long v16, v16, v30

    .line 1028
    .end local v15    # "measurement":Ljava/lang/String;
    :goto_3
    :try_start_3
    invoke-interface {v13}, Lcom/amazon/sdk/availability/DataStoreIterator;->hasNext()Z

    move-result v12

    goto :goto_2

    .line 1025
    :catch_0
    move-exception v10

    .line 1026
    .local v10, "e":Lcom/amazon/sdk/availability/DataStoreException;
    const-string/jumbo v30, "persistence read error, record skipped, continuing"

    move-object/from16 v0, v30

    invoke-static {v0, v10}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_3

    .line 1030
    .end local v10    # "e":Lcom/amazon/sdk/availability/DataStoreException;
    :catch_1
    move-exception v11

    .line 1031
    .local v11, "ex":Ljava/lang/Exception;
    :try_start_4
    const-string/jumbo v30, "unexpected persistence read error, all subsequent records discarded"

    move-object/from16 v0, v30

    invoke-static {v0, v11}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 1035
    :try_start_5
    invoke-virtual/range {v29 .. v29}, Ljava/io/OutputStream;->close()V

    .line 1039
    .end local v11    # "ex":Ljava/lang/Exception;
    :goto_4
    const-wide/16 v30, 0x0

    cmp-long v30, v16, v30

    if-lez v30, :cond_d

    .line 1040
    invoke-virtual/range {v24 .. v24}, Lcom/amazon/sdk/availability/StagingStream;->getUserMetadata()Ljava/util/Map;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    move-object/from16 v2, v27

    move-object/from16 v3, v30

    invoke-static {v8, v0, v1, v2, v3}, Lcom/amazon/sdk/availability/AwsUtil;->putObject(Lcom/amazonaws/auth/AWSCredentials;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/util/Map;)Z

    move-result v28

    .line 1042
    move/from16 v0, v28

    move-wide/from16 v1, v16

    move-object/from16 v3, v18

    move-object/from16 v4, v20

    invoke-static {v0, v1, v2, v3, v4}, Lcom/amazon/sdk/availability/Logger;->measurementsSubmitted(ZJLjava/lang/String;Ljava/lang/String;)V

    .line 1046
    if-eqz v28, :cond_8

    .line 1047
    invoke-interface {v13}, Lcom/amazon/sdk/availability/DataStoreIterator;->clear()V

    .line 1048
    const-string/jumbo v30, "completed clearing the data store"

    invoke-static/range {v30 .. v30}, Lcom/amazon/sdk/availability/Logger;->i(Ljava/lang/String;)V

    .line 1055
    :cond_8
    :goto_5
    invoke-virtual/range {v27 .. v27}, Ljava/io/File;->delete()Z

    move-result v30

    if-nez v30, :cond_9

    .line 1056
    const-string/jumbo v30, "could not delete staged measurements file"

    invoke-static/range {v30 .. v30}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/RuntimeException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 1067
    .end local v24    # "sos":Lcom/amazon/sdk/availability/StagingStream;
    .end local v26    # "stagedDir":Ljava/io/File;
    .end local v27    # "stagedFile":Ljava/io/File;
    .end local v29    # "zos":Ljava/io/OutputStream;
    :cond_9
    :goto_6
    if-eqz v9, :cond_a

    .line 1068
    invoke-interface {v9}, Lcom/amazon/sdk/availability/DataStore;->close()V

    .line 1071
    .end local v12    # "hasNext":Z
    .end local v13    # "iterator":Lcom/amazon/sdk/availability/DataStoreIterator;, "Lcom/amazon/sdk/availability/DataStoreIterator<Ljava/lang/String;>;"
    :cond_a
    :goto_7
    if-eqz v28, :cond_b

    .line 1073
    invoke-virtual {v6}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getSqsQueueName()Ljava/lang/String;

    move-result-object v25

    .line 1074
    .local v25, "sqsQueueName":Ljava/lang/String;
    invoke-static/range {v25 .. v25}, Lcom/amazon/sdk/availability/StringUtil;->isBlank(Ljava/lang/String;)Z

    move-result v30

    if-nez v30, :cond_b

    .line 1076
    new-instance v14, Lorg/json/JSONObject;

    invoke-direct {v14}, Lorg/json/JSONObject;-><init>()V

    .line 1078
    .local v14, "json":Lorg/json/JSONObject;
    :try_start_6
    const-string/jumbo v30, "clientId"

    move-object/from16 v0, v30

    move-object/from16 v1, p1

    invoke-virtual {v14, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1079
    const-string/jumbo v30, "s3Bucket"

    move-object/from16 v0, v30

    move-object/from16 v1, v18

    invoke-virtual {v14, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1080
    const-string/jumbo v30, "s3Key"

    move-object/from16 v0, v30

    move-object/from16 v1, v20

    invoke-virtual {v14, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1081
    const-string/jumbo v30, "numMeasurements"

    move-object/from16 v0, v30

    move-wide/from16 v1, v16

    invoke-virtual {v14, v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1083
    move-object/from16 v0, v25

    invoke-static {v8, v0, v14}, Lcom/amazon/sdk/availability/AwsUtil;->sendMessage(Lcom/amazonaws/auth/AWSCredentials;Ljava/lang/String;Lorg/json/JSONObject;)Z
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_4

    .end local v14    # "json":Lorg/json/JSONObject;
    .end local v25    # "sqsQueueName":Ljava/lang/String;
    :cond_b
    :goto_8
    move/from16 v30, v28

    .line 1090
    goto/16 :goto_0

    .line 1035
    .restart local v12    # "hasNext":Z
    .restart local v13    # "iterator":Lcom/amazon/sdk/availability/DataStoreIterator;, "Lcom/amazon/sdk/availability/DataStoreIterator<Ljava/lang/String;>;"
    .restart local v24    # "sos":Lcom/amazon/sdk/availability/StagingStream;
    .restart local v26    # "stagedDir":Ljava/io/File;
    .restart local v27    # "stagedFile":Ljava/io/File;
    .restart local v29    # "zos":Ljava/io/OutputStream;
    :cond_c
    :try_start_7
    invoke-virtual/range {v29 .. v29}, Ljava/io/OutputStream;->close()V
    :try_end_7
    .catch Ljava/lang/RuntimeException; {:try_start_7 .. :try_end_7} :catch_2
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_3
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    goto/16 :goto_4

    .line 1062
    .end local v12    # "hasNext":Z
    .end local v13    # "iterator":Lcom/amazon/sdk/availability/DataStoreIterator;, "Lcom/amazon/sdk/availability/DataStoreIterator<Ljava/lang/String;>;"
    .end local v24    # "sos":Lcom/amazon/sdk/availability/StagingStream;
    .end local v26    # "stagedDir":Ljava/io/File;
    .end local v27    # "stagedFile":Ljava/io/File;
    .end local v29    # "zos":Ljava/io/OutputStream;
    :catch_2
    move-exception v10

    .line 1063
    .local v10, "e":Ljava/lang/RuntimeException;
    :try_start_8
    const-string/jumbo v30, "runtime error building submission"

    move-object/from16 v0, v30

    invoke-static {v0, v10}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    .line 1067
    if-eqz v9, :cond_a

    .line 1068
    invoke-interface {v9}, Lcom/amazon/sdk/availability/DataStore;->close()V

    goto :goto_7

    .line 1035
    .end local v10    # "e":Ljava/lang/RuntimeException;
    .restart local v12    # "hasNext":Z
    .restart local v13    # "iterator":Lcom/amazon/sdk/availability/DataStoreIterator;, "Lcom/amazon/sdk/availability/DataStoreIterator<Ljava/lang/String;>;"
    .restart local v24    # "sos":Lcom/amazon/sdk/availability/StagingStream;
    .restart local v26    # "stagedDir":Ljava/io/File;
    .restart local v27    # "stagedFile":Ljava/io/File;
    .restart local v29    # "zos":Ljava/io/OutputStream;
    :catchall_0
    move-exception v30

    :try_start_9
    invoke-virtual/range {v29 .. v29}, Ljava/io/OutputStream;->close()V

    throw v30
    :try_end_9
    .catch Ljava/lang/RuntimeException; {:try_start_9 .. :try_end_9} :catch_2
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_3
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    .line 1064
    .end local v12    # "hasNext":Z
    .end local v13    # "iterator":Lcom/amazon/sdk/availability/DataStoreIterator;, "Lcom/amazon/sdk/availability/DataStoreIterator<Ljava/lang/String;>;"
    .end local v24    # "sos":Lcom/amazon/sdk/availability/StagingStream;
    .end local v26    # "stagedDir":Ljava/io/File;
    .end local v27    # "stagedFile":Ljava/io/File;
    .end local v29    # "zos":Ljava/io/OutputStream;
    :catch_3
    move-exception v10

    .line 1065
    .local v10, "e":Ljava/lang/Exception;
    :try_start_a
    const-string/jumbo v30, "error occurred building submission"

    move-object/from16 v0, v30

    invoke-static {v0, v10}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    .line 1067
    if-eqz v9, :cond_a

    .line 1068
    invoke-interface {v9}, Lcom/amazon/sdk/availability/DataStore;->close()V

    goto :goto_7

    .line 1051
    .end local v10    # "e":Ljava/lang/Exception;
    .restart local v12    # "hasNext":Z
    .restart local v13    # "iterator":Lcom/amazon/sdk/availability/DataStoreIterator;, "Lcom/amazon/sdk/availability/DataStoreIterator<Ljava/lang/String;>;"
    .restart local v24    # "sos":Lcom/amazon/sdk/availability/StagingStream;
    .restart local v26    # "stagedDir":Ljava/io/File;
    .restart local v27    # "stagedFile":Ljava/io/File;
    .restart local v29    # "zos":Ljava/io/OutputStream;
    :cond_d
    const/16 v28, 0x1

    goto :goto_5

    .line 1060
    .end local v24    # "sos":Lcom/amazon/sdk/availability/StagingStream;
    .end local v26    # "stagedDir":Ljava/io/File;
    .end local v27    # "stagedFile":Ljava/io/File;
    .end local v29    # "zos":Ljava/io/OutputStream;
    :cond_e
    :try_start_b
    invoke-interface {v13}, Lcom/amazon/sdk/availability/DataStoreIterator;->clear()V
    :try_end_b
    .catch Ljava/lang/RuntimeException; {:try_start_b .. :try_end_b} :catch_2
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_3
    .catchall {:try_start_b .. :try_end_b} :catchall_1

    goto :goto_6

    .line 1067
    .end local v12    # "hasNext":Z
    .end local v13    # "iterator":Lcom/amazon/sdk/availability/DataStoreIterator;, "Lcom/amazon/sdk/availability/DataStoreIterator<Ljava/lang/String;>;"
    :catchall_1
    move-exception v30

    if-eqz v9, :cond_f

    .line 1068
    invoke-interface {v9}, Lcom/amazon/sdk/availability/DataStore;->close()V

    :cond_f
    throw v30

    .line 1084
    .restart local v14    # "json":Lorg/json/JSONObject;
    .restart local v25    # "sqsQueueName":Ljava/lang/String;
    :catch_4
    move-exception v10

    .line 1085
    .local v10, "e":Lorg/json/JSONException;
    const-string/jumbo v30, "error building message payload"

    move-object/from16 v0, v30

    invoke-static {v0, v10}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_8
.end method

.method protected updateSubmitSchedule()V
    .locals 10

    .prologue
    .line 228
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->loadConfiguration()Lcom/amazon/sdk/availability/Configuration;

    move-result-object v3

    .line 229
    .local v3, "config":Lcom/amazon/sdk/availability/Configuration;
    invoke-virtual {v3}, Lcom/amazon/sdk/availability/Configuration;->getClientIds()Ljava/util/Set;

    move-result-object v1

    .line 231
    .local v1, "clientIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v7, 0x0

    .line 232
    .local v7, "measurementsPending":Z
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 233
    .local v0, "clientId":Ljava/lang/String;
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "analyzing "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, " submission policies"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/sdk/availability/Logger;->i(Ljava/lang/String;)V

    .line 234
    invoke-virtual {v3, v0}, Lcom/amazon/sdk/availability/Configuration;->getCollectionConfiguration(Ljava/lang/String;)Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;

    move-result-object v2

    .line 237
    .local v2, "collectionConfig":Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    if-eqz v2, :cond_0

    .line 243
    invoke-direct {p0, v0, v2}, Lcom/amazon/sdk/availability/AvailabilityService;->getAndOpenDataStore(Ljava/lang/String;Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;)Lcom/amazon/sdk/availability/DataStore;

    move-result-object v4

    .line 244
    .local v4, "dataStore":Lcom/amazon/sdk/availability/DataStore;
    if-eqz v4, :cond_0

    .line 248
    invoke-virtual {p0, v0}, Lcom/amazon/sdk/availability/AvailabilityService;->getLastClientSubmission(Ljava/lang/String;)J

    move-result-wide v8

    invoke-interface {v4, v8, v9}, Lcom/amazon/sdk/availability/DataStore;->getMeasurementsAfter(J)Lcom/amazon/sdk/availability/DataStoreIterator;

    move-result-object v5

    .line 251
    .local v5, "dataStoreIterator":Lcom/amazon/sdk/availability/DataStoreIterator;
    :try_start_0
    invoke-interface {v5}, Lcom/amazon/sdk/availability/DataStoreIterator;->hasNext()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v8

    if-eqz v8, :cond_2

    .line 252
    const/4 v7, 0x1

    .line 256
    invoke-interface {v4}, Lcom/amazon/sdk/availability/DataStore;->close()V

    .line 257
    invoke-interface {v5}, Lcom/amazon/sdk/availability/DataStoreIterator;->closeAfterUse()V

    .line 261
    .end local v0    # "clientId":Ljava/lang/String;
    .end local v2    # "collectionConfig":Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    .end local v4    # "dataStore":Lcom/amazon/sdk/availability/DataStore;
    .end local v5    # "dataStoreIterator":Lcom/amazon/sdk/availability/DataStoreIterator;
    :cond_1
    if-eqz v7, :cond_3

    .line 262
    invoke-virtual {v3}, Lcom/amazon/sdk/availability/Configuration;->getStateSubmissionInterval()Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/amazon/sdk/availability/AvailabilityService;->scheduleSubmit(Ljava/lang/Long;)V

    .line 266
    :goto_1
    return-void

    .line 256
    .restart local v0    # "clientId":Ljava/lang/String;
    .restart local v2    # "collectionConfig":Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    .restart local v4    # "dataStore":Lcom/amazon/sdk/availability/DataStore;
    .restart local v5    # "dataStoreIterator":Lcom/amazon/sdk/availability/DataStoreIterator;
    :cond_2
    invoke-interface {v4}, Lcom/amazon/sdk/availability/DataStore;->close()V

    .line 257
    invoke-interface {v5}, Lcom/amazon/sdk/availability/DataStoreIterator;->closeAfterUse()V

    goto :goto_0

    .line 256
    :catchall_0
    move-exception v8

    invoke-interface {v4}, Lcom/amazon/sdk/availability/DataStore;->close()V

    .line 257
    invoke-interface {v5}, Lcom/amazon/sdk/availability/DataStoreIterator;->closeAfterUse()V

    throw v8

    .line 264
    .end local v0    # "clientId":Ljava/lang/String;
    .end local v2    # "collectionConfig":Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    .end local v4    # "dataStore":Lcom/amazon/sdk/availability/DataStore;
    .end local v5    # "dataStoreIterator":Lcom/amazon/sdk/availability/DataStoreIterator;
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->cancelSubmit()V

    goto :goto_1
.end method

.method protected warnOnceAboutPRNG(Lcom/amazon/sdk/availability/Configuration;)V
    .locals 9
    .param p1, "configuration"    # Lcom/amazon/sdk/availability/Configuration;

    .prologue
    const/4 v8, 0x1

    .line 831
    const-string/jumbo v6, "warnOnceAboutPRNG() called"

    invoke-static {v6}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 832
    sget-boolean v6, Lcom/amazon/sdk/availability/AvailabilityService;->haveWarnedAboutPrng:Z

    if-eqz v6, :cond_0

    .line 833
    const-string/jumbo v6, "warnOnceAboutPRNG() has already been called, doing nothing"

    invoke-static {v6}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 878
    :goto_0
    return-void

    .line 837
    :cond_0
    sput-boolean v8, Lcom/amazon/sdk/availability/AvailabilityService;->haveWarnedAboutPrng:Z

    .line 840
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0x12

    if-le v6, v7, :cond_1

    .line 841
    const-string/jumbo v6, "warnOnceAboutPRNG() detected unaffected OS version, doing nothing"

    invoke-static {v6}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    goto :goto_0

    .line 847
    :cond_1
    const/4 v4, 0x0

    .line 848
    .local v4, "needWarning":Z
    invoke-virtual {p1}, Lcom/amazon/sdk/availability/Configuration;->getClientIds()Ljava/util/Set;

    move-result-object v2

    .line 849
    .local v2, "clientIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 850
    .local v1, "clientId":Ljava/lang/String;
    invoke-virtual {p1, v1}, Lcom/amazon/sdk/availability/Configuration;->getCollectionConfiguration(Ljava/lang/String;)Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;

    move-result-object v0

    .line 851
    .local v0, "ccfg":Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    invoke-virtual {v0}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getPublicKeyString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/sdk/availability/StringUtil;->isBlank(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 852
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "warnOnceAboutPRNG() detected encrypted upload usage for client ID "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 853
    const/4 v4, 0x1

    .line 858
    .end local v0    # "ccfg":Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    .end local v1    # "clientId":Ljava/lang/String;
    :cond_3
    if-nez v4, :cond_4

    .line 859
    const-string/jumbo v6, "warnOnceAboutPRNG() detected no clients using encrypted upload, doing nothing"

    invoke-static {v6}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    goto :goto_0

    .line 864
    :cond_4
    const-string/jumbo v6, "SecureRandom.SHA1PRNG"

    invoke-static {v6}, Ljava/security/Security;->getProviders(Ljava/lang/String;)[Ljava/security/Provider;

    move-result-object v5

    .line 865
    .local v5, "secureRandomProviders":[Ljava/security/Provider;
    if-eqz v5, :cond_5

    array-length v6, v5

    if-lt v6, v8, :cond_5

    const-class v6, Lcom/amazon/googlefixes/PRNGFixes$LinuxPRNGSecureRandomProvider;

    const/4 v7, 0x0

    aget-object v7, v5, v7

    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 868
    const-string/jumbo v6, "warnOnceAboutPRNG() detected workaround applied, doing nothing"

    invoke-static {v6}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    goto :goto_0

    .line 873
    :cond_5
    const-string/jumbo v6, "A possible problem has been detected"

    invoke-static {v6}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;)V

    .line 876
    const-string/jumbo v6, "SecureRandom workaround appears applicable and appears not to have been applied."

    invoke-static {v6}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 877
    const-string/jumbo v6, "SecureRandom info http://android-developers.blogspot.com/2013/08/some-securerandom-thoughts.html"

    invoke-static {v6}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method protected writeMeasurement(Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Z
    .locals 11
    .param p1, "collectionConfig"    # Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    .param p2, "measurementName"    # Ljava/lang/String;
    .param p3, "clientId"    # Ljava/lang/String;
    .param p4, "measurementJson"    # Lorg/json/JSONObject;

    .prologue
    .line 584
    const-class v9, Lcom/amazon/sdk/availability/AvailabilityService;

    const-string/jumbo v10, "writeMeasurement"

    invoke-static {v9, v10}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v7

    .line 586
    .local v7, "methodScope":Lcom/amazon/profiling/ProfilerScope;
    invoke-virtual {p1}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getLocalStoragePersistenceFormat()Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    move-result-object v8

    .line 588
    .local v8, "persistenceFormat":Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;
    invoke-virtual {p1}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getLocalStorageMaxRollover()Ljava/lang/Long;

    move-result-object v4

    .line 589
    .local v4, "localStorageMaxRollOver":Ljava/lang/Long;
    invoke-virtual {p1}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getLocalStorageRolloverFilesize()Ljava/lang/Long;

    move-result-object v5

    .line 592
    .local v5, "localStorageMaxRollOverSize":Ljava/lang/Long;
    const/4 v6, 0x0

    .line 594
    .local v6, "measurementPut":Z
    if-eqz v8, :cond_0

    .line 595
    invoke-virtual {p1}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getLocalStorageEncryptionScheme()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p1}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->getLocalStorageEncryptionKey()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/amazon/sdk/availability/EncryptionFactory;->getEncryptionManager(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/EncryptionManager;

    move-result-object v3

    .line 599
    .local v3, "encryptionManager":Lcom/amazon/sdk/availability/EncryptionManager;
    invoke-static {v8, v4, v5, p3}, Lcom/amazon/sdk/availability/DatastoreFactory;->getDataStore(Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/amazon/sdk/availability/DataStore;

    move-result-object v1

    .line 601
    .local v1, "dataStore":Lcom/amazon/sdk/availability/DataStore;
    if-eqz v1, :cond_0

    .line 602
    const-class v9, Lcom/amazon/sdk/availability/AvailabilityService;

    const-string/jumbo v10, "writeMeasurement/write"

    invoke-static {v9, v10}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v0

    .line 605
    .local v0, "blockScope":Lcom/amazon/profiling/ProfilerScope;
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/AvailabilityService;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-interface {v1, v9, v3}, Lcom/amazon/sdk/availability/DataStore;->open(Landroid/content/Context;Lcom/amazon/sdk/availability/EncryptionManager;)V

    .line 606
    invoke-interface {v1, p4}, Lcom/amazon/sdk/availability/DataStore;->put(Lorg/json/JSONObject;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 607
    invoke-static {p2, p3}, Lcom/amazon/sdk/availability/Logger;->measurementRecorded(Ljava/lang/String;Ljava/lang/String;)V

    .line 608
    const/4 v6, 0x1

    .line 609
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "put measurement for client ID: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/amazon/sdk/availability/DataStoreException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 616
    :goto_0
    invoke-interface {v1}, Lcom/amazon/sdk/availability/DataStore;->close()V

    .line 617
    invoke-static {v0}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    .line 621
    .end local v0    # "blockScope":Lcom/amazon/profiling/ProfilerScope;
    .end local v1    # "dataStore":Lcom/amazon/sdk/availability/DataStore;
    .end local v3    # "encryptionManager":Lcom/amazon/sdk/availability/EncryptionManager;
    :cond_0
    :goto_1
    invoke-static {v7}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    .line 622
    return v6

    .line 611
    .restart local v0    # "blockScope":Lcom/amazon/profiling/ProfilerScope;
    .restart local v1    # "dataStore":Lcom/amazon/sdk/availability/DataStore;
    .restart local v3    # "encryptionManager":Lcom/amazon/sdk/availability/EncryptionManager;
    :cond_1
    :try_start_1
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "dropped measurement for client ID: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/amazon/sdk/availability/DataStoreException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 613
    :catch_0
    move-exception v2

    .line 614
    .local v2, "e":Lcom/amazon/sdk/availability/DataStoreException;
    :try_start_2
    const-string/jumbo v9, "persistence write error"

    invoke-static {v9, v2}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 616
    invoke-interface {v1}, Lcom/amazon/sdk/availability/DataStore;->close()V

    .line 617
    invoke-static {v0}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    goto :goto_1

    .line 616
    .end local v2    # "e":Lcom/amazon/sdk/availability/DataStoreException;
    :catchall_0
    move-exception v9

    invoke-interface {v1}, Lcom/amazon/sdk/availability/DataStore;->close()V

    .line 617
    invoke-static {v0}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    throw v9
.end method
