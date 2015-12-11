.class final Lcom/adobe/mobile/Lifecycle;
.super Ljava/lang/Object;
.source "Lifecycle.java"


# static fields
.field protected static final ADB_LIFECYCLE_PUSH_MESSAGE_ID_KEY:Ljava/lang/String; = "adb_m_id"

.field protected static final ADB_TRACK_INTERNAL_PUSH_CLICK_THROUGH:Ljava/lang/String; = "PushMessage"

.field private static final _contextDataMutex:Ljava/lang/Object;

.field private static final _lifecycleContextData:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private static final _lifecycleContextDataLowercase:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private static final _lowercaseContextDataMutex:Ljava/lang/Object;

.field private static final _previousSessionlifecycleContextData:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field protected static volatile lifecycleHasRun:Z

.field protected static sessionStartTime:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 36
    const-wide/16 v0, 0x0

    sput-wide v0, Lcom/adobe/mobile/Lifecycle;->sessionStartTime:J

    .line 47
    const/4 v0, 0x0

    sput-boolean v0, Lcom/adobe/mobile/Lifecycle;->lifecycleHasRun:Z

    .line 48
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    .line 49
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextDataLowercase:Ljava/util/HashMap;

    .line 50
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/adobe/mobile/Lifecycle;->_previousSessionlifecycleContextData:Ljava/util/HashMap;

    .line 215
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/Lifecycle;->_contextDataMutex:Ljava/lang/Object;

    .line 255
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/Lifecycle;->_lowercaseContextDataMutex:Ljava/lang/Object;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static addInstallData(Ljava/util/Map;J)V
    .locals 17
    .param p1, "date"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;J)V"
        }
    .end annotation

    .prologue
    .line 334
    .local p0, "cdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v4, Ljava/text/SimpleDateFormat;

    const-string v12, "M/d/yyyy"

    sget-object v13, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v4, v12, v13}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 335
    .local v4, "dayMonthYearFormat":Ljava/text/DateFormat;
    const-string v12, "a.InstallDate"

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    invoke-virtual {v4, v13}, Ljava/text/DateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p0

    invoke-interface {v0, v12, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 336
    const-string v12, "a.InstallEvent"

    const-string v13, "InstallEvent"

    move-object/from16 v0, p0

    invoke-interface {v0, v12, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 337
    const-string v12, "a.DailyEngUserEvent"

    const-string v13, "DailyEngUserEvent"

    move-object/from16 v0, p0

    invoke-interface {v0, v12, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 338
    const-string v12, "a.MonthlyEngUserEvent"

    const-string v13, "MonthlyEngUserEvent"

    move-object/from16 v0, p0

    invoke-interface {v0, v12, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 344
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v12

    const-string v13, "ADMS_Referrer_ContextData_Json_String"

    invoke-interface {v12, v13}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_1

    .line 346
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v12

    const-string v13, "ADMS_Referrer_ContextData_Json_String"

    const/4 v14, 0x0

    invoke-interface {v12, v13, v14}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Lcom/adobe/mobile/ReferrerHandler;->parseV3Response(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v8

    .line 349
    .local v8, "referrerContextData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p0

    invoke-interface {v0, v8}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 375
    .end local v8    # "referrerContextData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    :goto_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    .line 377
    .local v6, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v12, "ADMS_InstallDate"

    move-wide/from16 v0, p1

    invoke-interface {v6, v12, v0, v1}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 378
    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 382
    .end local v6    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_1
    return-void

    .line 351
    :cond_1
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v12

    const-string v13, "utm_campaign"

    invoke-interface {v12, v13}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 353
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v12

    const-string v13, "utm_source"

    const/4 v14, 0x0

    invoke-interface {v12, v13, v14}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 354
    .local v9, "source":Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v12

    const-string v13, "utm_medium"

    const/4 v14, 0x0

    invoke-interface {v12, v13, v14}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 355
    .local v7, "medium":Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v12

    const-string v13, "utm_term"

    const/4 v14, 0x0

    invoke-interface {v12, v13, v14}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 356
    .local v10, "term":Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v12

    const-string v13, "utm_content"

    const/4 v14, 0x0

    invoke-interface {v12, v13, v14}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 357
    .local v3, "content":Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v12

    const-string v13, "utm_campaign"

    const/4 v14, 0x0

    invoke-interface {v12, v13, v14}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 358
    .local v2, "campaign":Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v12

    const-string v13, "trackingcode"

    const/4 v14, 0x0

    invoke-interface {v12, v13, v14}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 360
    .local v11, "trackingcode":Ljava/lang/String;
    if-eqz v9, :cond_0

    if-eqz v2, :cond_0

    .line 362
    const-string v12, "a.referrer.campaign.source"

    move-object/from16 v0, p0

    invoke-interface {v0, v12, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 363
    const-string v12, "a.referrer.campaign.medium"

    move-object/from16 v0, p0

    invoke-interface {v0, v12, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 364
    const-string v12, "a.referrer.campaign.term"

    move-object/from16 v0, p0

    invoke-interface {v0, v12, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 365
    const-string v12, "a.referrer.campaign.content"

    move-object/from16 v0, p0

    invoke-interface {v0, v12, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 366
    const-string v12, "a.referrer.campaign.name"

    move-object/from16 v0, p0

    invoke-interface {v0, v12, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 367
    const-string v12, "a.referrer.campaign.trackingcode"

    move-object/from16 v0, p0

    invoke-interface {v0, v12, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 379
    .end local v2    # "campaign":Ljava/lang/String;
    .end local v3    # "content":Ljava/lang/String;
    .end local v7    # "medium":Ljava/lang/String;
    .end local v9    # "source":Ljava/lang/String;
    .end local v10    # "term":Ljava/lang/String;
    .end local v11    # "trackingcode":Ljava/lang/String;
    :catch_0
    move-exception v5

    .line 380
    .local v5, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v12, "Lifecycle - Error setting install data (%s)."

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    invoke-virtual {v5}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-static {v12, v13}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_1

    .line 369
    .end local v5    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    :cond_2
    :try_start_1
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v12

    invoke-virtual {v12}, Lcom/adobe/mobile/MobileConfig;->mobileReferrerConfigured()Z

    move-result v12

    if-eqz v12, :cond_0

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v12

    invoke-virtual {v12}, Lcom/adobe/mobile/MobileConfig;->getReferrerTimeout()I

    move-result v12

    if-lez v12, :cond_0

    .line 371
    const/4 v12, 0x0

    invoke-static {v12}, Lcom/adobe/mobile/ReferrerHandler;->setReferrerProcessed(Z)V

    .line 372
    invoke-static {}, Lcom/adobe/mobile/Messages;->block3rdPartyCallbacksQueueForReferrer()V
    :try_end_1
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method private static addLifecycleGenericData(Ljava/util/Map;J)V
    .locals 11
    .param p1, "date"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;J)V"
        }
    .end annotation

    .prologue
    .local p0, "cdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v10, 0x0

    .line 411
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getDefaultData()Ljava/util/HashMap;

    move-result-object v7

    invoke-interface {p0, v7}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 412
    const-string v7, "a.LaunchEvent"

    const-string v8, "LaunchEvent"

    invoke-interface {p0, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 413
    const-string v7, "a.OSVersion"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getOperatingSystem()Ljava/lang/String;

    move-result-object v8

    invoke-interface {p0, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 415
    new-instance v5, Ljava/text/SimpleDateFormat;

    const-string v7, "H"

    sget-object v8, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v5, v7, v8}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 416
    .local v5, "hourOfDayDateFormat":Ljava/text/DateFormat;
    const-string v7, "a.HourOfDay"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/text/DateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-interface {p0, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 418
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    .line 419
    .local v1, "cal":Ljava/util/Calendar;
    invoke-virtual {v1, p1, p2}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 420
    const/4 v7, 0x7

    invoke-virtual {v1, v7}, Ljava/util/Calendar;->get(I)I

    move-result v2

    .line 421
    .local v2, "dow":I
    const-string v7, "a.DayOfWeek"

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    invoke-interface {p0, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 423
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getAdvertisingIdentifier()Ljava/lang/String;

    move-result-object v0

    .line 424
    .local v0, "adid":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 425
    const-string v7, "a.adid"

    invoke-interface {p0, v7, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 429
    :cond_0
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    .line 430
    .local v4, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v7

    const-string v8, "ADMS_Launches"

    const/4 v9, 0x0

    invoke-interface {v7, v8, v9}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v7

    add-int/lit8 v6, v7, 0x1

    .line 431
    .local v6, "launches":I
    const-string v7, "a.Launches"

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    invoke-interface {p0, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 433
    const-string v7, "ADMS_Launches"

    invoke-interface {v4, v7, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 434
    const-string v7, "ADMS_LastDateUsed"

    invoke-interface {v4, v7, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 435
    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    .line 439
    .end local v4    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v6    # "launches":I
    :goto_0
    return-void

    .line 436
    :catch_0
    move-exception v3

    .line 437
    .local v3, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v7, "Lifecycle - Error adding generic data (%s)."

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    invoke-virtual {v3}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-static {v7, v8}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private static addNonInstallData(Ljava/util/Map;J)V
    .locals 25
    .param p1, "date"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;J)V"
        }
    .end annotation

    .prologue
    .line 445
    .local p0, "cdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    new-instance v7, Ljava/text/SimpleDateFormat;

    const-string v19, "yyyy/M/d"

    sget-object v20, Ljava/util/Locale;->US:Ljava/util/Locale;

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-direct {v7, v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 447
    .local v7, "dailyFormatter":Ljava/text/DateFormat;
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v19

    const-string v20, "ADMS_LastDateUsed"

    const-wide/16 v22, 0x0

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    move-wide/from16 v2, v22

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v14

    .line 448
    .local v14, "lastUseMillis":J
    new-instance v19, Ljava/util/Date;

    move-object/from16 v0, v19

    invoke-direct {v0, v14, v15}, Ljava/util/Date;-><init>(J)V

    move-object/from16 v0, v19

    invoke-virtual {v7, v0}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v16

    .line 449
    .local v16, "lastUsedDateDaily":Ljava/lang/String;
    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v7, v0}, Ljava/text/DateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 451
    .local v5, "currentDateDaily":Ljava/lang/String;
    move-object/from16 v0, v16

    invoke-virtual {v5, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_0

    .line 452
    const-string v19, "a.DailyEngUserEvent"

    const-string v20, "DailyEngUserEvent"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 456
    :cond_0
    new-instance v18, Ljava/text/SimpleDateFormat;

    const-string v19, "yyyy/M"

    sget-object v20, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct/range {v18 .. v20}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 457
    .local v18, "monthlyFormatter":Ljava/text/DateFormat;
    new-instance v19, Ljava/util/Date;

    move-object/from16 v0, v19

    invoke-direct {v0, v14, v15}, Ljava/util/Date;-><init>(J)V

    invoke-virtual/range {v18 .. v19}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v17

    .line 458
    .local v17, "lastUsedDateMonthly":Ljava/lang/String;
    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/text/DateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 459
    .local v6, "currentDateMonthly":Ljava/lang/String;
    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_1

    .line 460
    const-string v19, "a.MonthlyEngUserEvent"

    const-string v20, "MonthlyEngUserEvent"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 464
    :cond_1
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v19

    const-string v20, "ADMS_InstallDate"

    const-wide/16 v22, 0x0

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    move-wide/from16 v2, v22

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v10

    .line 465
    .local v10, "installMillis":J
    const-string v19, "a.DaysSinceFirstUse"

    move-wide/from16 v0, p1

    invoke-static {v10, v11, v0, v1}, Lcom/adobe/mobile/Lifecycle;->calculateDaysSince(JJ)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 468
    const-string v19, "a.DaysSinceLastUse"

    move-wide/from16 v0, p1

    invoke-static {v14, v15, v0, v1}, Lcom/adobe/mobile/Lifecycle;->calculateDaysSince(JJ)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 471
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v19

    const-string v20, "ADMS_SuccessfulClose"

    const/16 v21, 0x0

    invoke-interface/range {v19 .. v21}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v19

    if-nez v19, :cond_2

    .line 472
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v9

    .line 474
    .local v9, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v19, "ADMS_PauseDate"

    move-object/from16 v0, v19

    invoke-interface {v9, v0}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 475
    const-string v19, "ADMS_SessionStart"

    move-object/from16 v0, v19

    invoke-interface {v9, v0}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 476
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v20

    sput-wide v20, Lcom/adobe/mobile/Lifecycle;->sessionStartTime:J

    .line 477
    invoke-interface {v9}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 480
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v19

    const-string v20, "ADBLastKnownTimestampKey"

    const-wide/16 v22, 0x0

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    move-wide/from16 v2, v22

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v12

    .line 482
    .local v12, "lastKnownTimestamp":J
    const-wide/16 v20, 0x0

    cmp-long v19, v12, v20

    if-lez v19, :cond_3

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/adobe/mobile/MobileConfig;->mobileUsingAnalytics()Z

    move-result v19

    if-eqz v19, :cond_3

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/adobe/mobile/MobileConfig;->getOfflineTrackingEnabled()Z

    move-result v19

    if-eqz v19, :cond_3

    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/adobe/mobile/MobileConfig;->getBackdateSessionInfoEnabled()Z

    move-result v19

    if-eqz v19, :cond_3

    .line 484
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 485
    .local v4, "crashCData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v19, "a.CrashEvent"

    const-string v20, "CrashEvent"

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 486
    sget-object v19, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    move-object/from16 v0, v19

    invoke-virtual {v0, v4}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 489
    const-string v19, "Crash"

    const-wide/16 v20, 0x1

    add-long v20, v20, v12

    move-object/from16 v0, v19

    move-wide/from16 v1, v20

    invoke-static {v0, v4, v1, v2}, Lcom/adobe/mobile/AnalyticsTrackInternal;->trackInternal(Ljava/lang/String;Ljava/util/Map;J)V

    .line 496
    .end local v4    # "crashCData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    invoke-static {}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sharedInstance()Lcom/adobe/mobile/AnalyticsTrackTimedAction;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->trackTimedActionUpdateActionsClearAdjustedStartTime()V

    .line 501
    .end local v5    # "currentDateDaily":Ljava/lang/String;
    .end local v6    # "currentDateMonthly":Ljava/lang/String;
    .end local v7    # "dailyFormatter":Ljava/text/DateFormat;
    .end local v9    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v10    # "installMillis":J
    .end local v12    # "lastKnownTimestamp":J
    .end local v14    # "lastUseMillis":J
    .end local v16    # "lastUsedDateDaily":Ljava/lang/String;
    .end local v17    # "lastUsedDateMonthly":Ljava/lang/String;
    .end local v18    # "monthlyFormatter":Ljava/text/DateFormat;
    :cond_2
    :goto_1
    return-void

    .line 492
    .restart local v5    # "currentDateDaily":Ljava/lang/String;
    .restart local v6    # "currentDateMonthly":Ljava/lang/String;
    .restart local v7    # "dailyFormatter":Ljava/text/DateFormat;
    .restart local v9    # "editor":Landroid/content/SharedPreferences$Editor;
    .restart local v10    # "installMillis":J
    .restart local v12    # "lastKnownTimestamp":J
    .restart local v14    # "lastUseMillis":J
    .restart local v16    # "lastUsedDateDaily":Ljava/lang/String;
    .restart local v17    # "lastUsedDateMonthly":Ljava/lang/String;
    .restart local v18    # "monthlyFormatter":Ljava/text/DateFormat;
    :cond_3
    const-string v19, "a.CrashEvent"

    const-string v20, "CrashEvent"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 498
    .end local v5    # "currentDateDaily":Ljava/lang/String;
    .end local v6    # "currentDateMonthly":Ljava/lang/String;
    .end local v7    # "dailyFormatter":Ljava/text/DateFormat;
    .end local v9    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v10    # "installMillis":J
    .end local v12    # "lastKnownTimestamp":J
    .end local v14    # "lastUseMillis":J
    .end local v16    # "lastUsedDateDaily":Ljava/lang/String;
    .end local v17    # "lastUsedDateMonthly":Ljava/lang/String;
    .end local v18    # "monthlyFormatter":Ljava/text/DateFormat;
    :catch_0
    move-exception v8

    .line 499
    .local v8, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v19, "Lifecycle - Error setting non install data (%s)."

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    invoke-virtual {v8}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method private static addPersistedLifecycleToMap(Ljava/util/Map;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p0, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 283
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v4

    const-string v5, "ADMS_LifecycleData"

    const/4 v6, 0x0

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 285
    .local v3, "lifecycleJSONString":Ljava/lang/String;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_0

    .line 286
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 287
    .local v2, "lifecycleData":Lorg/json/JSONObject;
    invoke-static {v2}, Lcom/adobe/mobile/StaticMethods;->mapFromJson(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v4

    invoke-interface {p0, v4}, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 294
    .end local v2    # "lifecycleData":Lorg/json/JSONObject;
    .end local v3    # "lifecycleJSONString":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 289
    :catch_0
    move-exception v0

    .line 290
    .local v0, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v4, "Lifecycle - Issue loading persisted lifecycle data"

    new-array v5, v8, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 291
    .end local v0    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    :catch_1
    move-exception v1

    .line 292
    .local v1, "ex":Lorg/json/JSONException;
    const-string v4, "Lifecycle - Issue loading persisted lifecycle data (%s)"

    new-array v5, v8, [Ljava/lang/Object;

    invoke-virtual {v1}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private static addSessionLengthData(Ljava/util/Map;)V
    .locals 18
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 506
    .local p0, "cdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v14

    const-string v15, "ADMS_PauseDate"

    const-wide/16 v16, 0x0

    invoke-interface/range {v14 .. v17}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v6

    .line 507
    .local v6, "pauseDate":J
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v14

    invoke-virtual {v14}, Lcom/adobe/mobile/MobileConfig;->getLifecycleTimeout()I

    move-result v12

    .line 508
    .local v12, "sessionTimeout":I
    new-instance v14, Ljava/util/Date;

    invoke-direct {v14}, Ljava/util/Date;-><init>()V

    invoke-virtual {v14}, Ljava/util/Date;->getTime()J

    move-result-wide v14

    sub-long/2addr v14, v6

    const-wide/16 v16, 0x3e8

    div-long v14, v14, v16

    long-to-int v13, v14

    .line 511
    .local v13, "timeSincePause":I
    if-ge v13, v12, :cond_0

    .line 552
    .end local v6    # "pauseDate":J
    .end local v12    # "sessionTimeout":I
    .end local v13    # "timeSincePause":I
    :goto_0
    return-void

    .line 515
    .restart local v6    # "pauseDate":J
    .restart local v12    # "sessionTimeout":I
    .restart local v13    # "timeSincePause":I
    :cond_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v14

    const-string v15, "ADMS_SessionStart"

    const-wide/16 v16, 0x0

    invoke-interface/range {v14 .. v17}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v10

    .line 516
    .local v10, "sessionStart":J
    sub-long v14, v6, v10

    const-wide/16 v16, 0x3e8

    div-long v14, v14, v16

    long-to-int v9, v14

    .line 517
    .local v9, "sessionTime":I
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v14

    sput-wide v14, Lcom/adobe/mobile/Lifecycle;->sessionStartTime:J

    .line 520
    if-lez v9, :cond_2

    const v14, 0x93a80

    if-ge v9, v14, :cond_2

    .line 522
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v14

    const-string v15, "ADBLastKnownTimestampKey"

    const-wide/16 v16, 0x0

    invoke-interface/range {v14 .. v17}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v4

    .line 525
    .local v4, "lastKnownTimestamp":J
    const-wide/16 v14, 0x0

    cmp-long v14, v4, v14

    if-lez v14, :cond_1

    .line 526
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v14

    invoke-virtual {v14}, Lcom/adobe/mobile/MobileConfig;->mobileUsingAnalytics()Z

    move-result v14

    if-eqz v14, :cond_1

    .line 527
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v14

    invoke-virtual {v14}, Lcom/adobe/mobile/MobileConfig;->getOfflineTrackingEnabled()Z

    move-result v14

    if-eqz v14, :cond_1

    .line 528
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v14

    invoke-virtual {v14}, Lcom/adobe/mobile/MobileConfig;->getBackdateSessionInfoEnabled()Z

    move-result v14

    if-eqz v14, :cond_1

    .line 530
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 531
    .local v8, "sessionCData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v14, "a.PrevSessionLength"

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, ""

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v8, v14, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 532
    sget-object v14, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    invoke-virtual {v14, v8}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 535
    const-string v14, "SessionInfo"

    const-wide/16 v16, 0x1

    add-long v16, v16, v4

    move-wide/from16 v0, v16

    invoke-static {v14, v8, v0, v1}, Lcom/adobe/mobile/AnalyticsTrackInternal;->trackInternal(Ljava/lang/String;Ljava/util/Map;J)V

    .line 545
    .end local v4    # "lastKnownTimestamp":J
    .end local v8    # "sessionCData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_1
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 547
    .local v3, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v14, "ADMS_SessionStart"

    invoke-interface {v3, v14}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 548
    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 549
    .end local v3    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v6    # "pauseDate":J
    .end local v9    # "sessionTime":I
    .end local v10    # "sessionStart":J
    .end local v12    # "sessionTimeout":I
    .end local v13    # "timeSincePause":I
    :catch_0
    move-exception v2

    .line 550
    .local v2, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v14, "Lifecycle - Error adding session length data (%s)."

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-virtual {v2}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 538
    .end local v2    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    .restart local v4    # "lastKnownTimestamp":J
    .restart local v6    # "pauseDate":J
    .restart local v9    # "sessionTime":I
    .restart local v10    # "sessionStart":J
    .restart local v12    # "sessionTimeout":I
    .restart local v13    # "timeSincePause":I
    :cond_1
    :try_start_1
    const-string v14, "a.PrevSessionLength"

    invoke-static {v9}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p0

    invoke-interface {v0, v14, v15}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 542
    .end local v4    # "lastKnownTimestamp":J
    :cond_2
    const-string v14, "a.ignoredSessionLength"

    invoke-static {v9}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p0

    invoke-interface {v0, v14, v15}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method private static addUpgradeData(Ljava/util/Map;J)V
    .locals 11
    .param p1, "date"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;J)V"
        }
    .end annotation

    .prologue
    .line 386
    .local p0, "cdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 388
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v6, "ADMS_UpgradeDate"

    const-wide/16 v8, 0x0

    invoke-interface {v3, v6, v8, v9}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v4

    .line 390
    .local v4, "upgradeDate":J
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getApplicationVersion()Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v6

    const-string v7, "ADMS_LastVersion"

    const-string v8, ""

    invoke-interface {v6, v7, v8}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 391
    const-string v3, "a.UpgradeEvent"

    const-string v6, "UpgradeEvent"

    invoke-interface {p0, v3, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 392
    const-string v3, "ADMS_UpgradeDate"

    invoke-interface {v1, v3, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 393
    const-string v3, "ADMS_LaunchesAfterUpgrade"

    const/4 v6, 0x0

    invoke-interface {v1, v3, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 398
    :cond_0
    :goto_0
    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-lez v3, :cond_1

    .line 399
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v6, "ADMS_LaunchesAfterUpgrade"

    const/4 v7, 0x0

    invoke-interface {v3, v6, v7}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v3

    add-int/lit8 v2, v3, 0x1

    .line 400
    .local v2, "newLaunchesAfterUpgradeCount":I
    const-string v3, "a.LaunchesSinceUpgrade"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {p0, v3, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 401
    const-string v3, "ADMS_LaunchesAfterUpgrade"

    invoke-interface {v1, v3, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 404
    .end local v2    # "newLaunchesAfterUpgradeCount":I
    :cond_1
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 408
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v4    # "upgradeDate":J
    :goto_1
    return-void

    .line 394
    .restart local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    .restart local v4    # "upgradeDate":J
    :cond_2
    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-lez v3, :cond_0

    .line 395
    const-string v3, "a.DaysSinceLastUpgrade"

    invoke-static {v4, v5, p1, p2}, Lcom/adobe/mobile/Lifecycle;->calculateDaysSince(JJ)Ljava/lang/String;

    move-result-object v6

    invoke-interface {p0, v3, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 405
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v4    # "upgradeDate":J
    :catch_0
    move-exception v0

    .line 406
    .local v0, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v3, "Lifecycle - Error setting upgrade data (%s)."

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v0}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v3, v6}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method private static calculateDaysSince(JJ)Ljava/lang/String;
    .locals 4
    .param p0, "since"    # J
    .param p2, "to"    # J

    .prologue
    .line 556
    sub-long v0, p2, p0

    const-wide/32 v2, 0x5265c00

    div-long/2addr v0, v2

    long-to-int v0, v0

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static checkForPushMessageClickThrough(Landroid/app/Activity;)V
    .locals 6
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 564
    if-nez p0, :cond_1

    .line 582
    :cond_0
    :goto_0
    return-void

    .line 567
    :cond_1
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 568
    .local v0, "intent":Landroid/content/Intent;
    if-eqz v0, :cond_0

    .line 571
    const-string v3, "adb_m_id"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 574
    .local v2, "pushMessageID":Ljava/lang/String;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_0

    .line 575
    new-instance v1, Lcom/adobe/mobile/Lifecycle$1;

    invoke-direct {v1, v2}, Lcom/adobe/mobile/Lifecycle$1;-><init>(Ljava/lang/String;)V

    .line 576
    .local v1, "messageIDMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-static {v1}, Lcom/adobe/mobile/Lifecycle;->updateContextData(Ljava/util/HashMap;)V

    .line 578
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mobile/MobileConfig;->mobileUsingAnalytics()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 579
    const-string v3, "PushMessage"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v4

    invoke-static {v3, v1, v4, v5}, Lcom/adobe/mobile/AnalyticsTrackInternal;->trackInternal(Ljava/lang/String;Ljava/util/Map;J)V

    goto :goto_0
.end method

.method private static clearContextDataLowercase()V
    .locals 2

    .prologue
    .line 272
    sget-object v1, Lcom/adobe/mobile/Lifecycle;->_lowercaseContextDataMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 273
    :try_start_0
    sget-object v0, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextDataLowercase:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 274
    monitor-exit v1

    .line 275
    return-void

    .line 274
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private static generateLifecycleToBeSaved(Ljava/util/Map;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 297
    .local p0, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p0, :cond_0

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1, p0}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 300
    .local v1, "mutableData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getDefaultData()Ljava/util/HashMap;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 301
    const-string v2, "a.locale"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getDefaultAcceptLanguage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 303
    sget-object v2, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    invoke-virtual {v2, v1}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 306
    invoke-static {}, Lcom/adobe/mobile/Lifecycle;->clearContextDataLowercase()V

    .line 307
    sget-object v2, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 308
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-object v4, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextDataLowercase:Ljava/util/HashMap;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v2, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 297
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v1    # "mutableData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    goto :goto_0

    .line 310
    .restart local v1    # "mutableData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_1
    return-void
.end method

.method protected static getContextData()Ljava/util/HashMap;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 217
    sget-object v1, Lcom/adobe/mobile/Lifecycle;->_contextDataMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 219
    :try_start_0
    sget-object v0, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 220
    sget-object v0, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    monitor-exit v1

    .line 229
    :goto_0
    return-object v0

    .line 223
    :cond_0
    sget-object v0, Lcom/adobe/mobile/Lifecycle;->_previousSessionlifecycleContextData:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 224
    sget-object v0, Lcom/adobe/mobile/Lifecycle;->_previousSessionlifecycleContextData:Ljava/util/HashMap;

    monitor-exit v1

    goto :goto_0

    .line 230
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 227
    :cond_1
    :try_start_1
    sget-object v0, Lcom/adobe/mobile/Lifecycle;->_previousSessionlifecycleContextData:Ljava/util/HashMap;

    invoke-static {v0}, Lcom/adobe/mobile/Lifecycle;->addPersistedLifecycleToMap(Ljava/util/Map;)V

    .line 229
    sget-object v0, Lcom/adobe/mobile/Lifecycle;->_previousSessionlifecycleContextData:Ljava/util/HashMap;

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method protected static getContextDataLowercase()Ljava/util/Map;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 257
    sget-object v3, Lcom/adobe/mobile/Lifecycle;->_lowercaseContextDataMutex:Ljava/lang/Object;

    monitor-enter v3

    .line 258
    :try_start_0
    sget-object v2, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextDataLowercase:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->size()I

    move-result v2

    if-gtz v2, :cond_0

    .line 260
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 261
    .local v1, "previousSessionlifecycleContextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-static {v1}, Lcom/adobe/mobile/Lifecycle;->addPersistedLifecycleToMap(Ljava/util/Map;)V

    .line 262
    invoke-virtual {v1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 263
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-object v5, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextDataLowercase:Ljava/util/HashMap;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v5, v2, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 268
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 267
    :cond_0
    :try_start_1
    sget-object v2, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextDataLowercase:Ljava/util/HashMap;

    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v2
.end method

.method private static persistLifecycleContextData()V
    .locals 7

    .prologue
    .line 205
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 206
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    new-instance v2, Lorg/json/JSONObject;

    sget-object v3, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    .line 207
    .local v2, "lifecycleJSON":Lorg/json/JSONObject;
    const-string v3, "ADMS_LifecycleData"

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 208
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    .line 213
    .end local v2    # "lifecycleJSON":Lorg/json/JSONObject;
    :goto_0
    return-void

    .line 210
    :catch_0
    move-exception v0

    .line 211
    .local v0, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v3, "Lifecycle - Error persisting lifecycle data (%s)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected static removeContextData(Ljava/lang/String;)V
    .locals 3
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 246
    sget-object v1, Lcom/adobe/mobile/Lifecycle;->_contextDataMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 247
    :try_start_0
    sget-object v0, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 248
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 250
    sget-object v1, Lcom/adobe/mobile/Lifecycle;->_lowercaseContextDataMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 251
    :try_start_1
    sget-object v0, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextDataLowercase:Ljava/util/HashMap;

    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 252
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 253
    return-void

    .line 248
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    .line 252
    :catchall_1
    move-exception v0

    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v0
.end method

.method private static resetLifecycleFlags(J)V
    .locals 6
    .param p0, "date"    # J

    .prologue
    const/4 v5, 0x0

    .line 314
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 316
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v2

    const-string v3, "ADMS_SessionStart"

    invoke-interface {v2, v3}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 317
    const-string v2, "ADMS_SessionStart"

    invoke-interface {v1, v2, p0, p1}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 320
    const-wide/16 v2, 0x3e8

    div-long v2, p0, v2

    sput-wide v2, Lcom/adobe/mobile/Lifecycle;->sessionStartTime:J

    .line 323
    :cond_0
    const-string v2, "ADMS_LastVersion"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getApplicationVersion()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 324
    const-string v2, "ADMS_SuccessfulClose"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 325
    const-string v2, "ADMS_PauseDate"

    invoke-interface {v1, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 326
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    .line 330
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_0
    return-void

    .line 327
    :catch_0
    move-exception v0

    .line 328
    .local v0, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v2, "Lifecycle - Error resetting lifecycle flags (%s)."

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected static start(Landroid/app/Activity;Ljava/util/Map;)V
    .locals 24
    .param p0, "activity"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 56
    .local p1, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-boolean v19, Lcom/adobe/mobile/Lifecycle;->lifecycleHasRun:Z

    if-eqz v19, :cond_0

    .line 172
    :goto_0
    return-void

    .line 60
    :cond_0
    const/16 v19, 0x1

    sput-boolean v19, Lcom/adobe/mobile/Lifecycle;->lifecycleHasRun:Z

    .line 64
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v18

    .line 72
    .local v18, "userDefaults":Landroid/content/SharedPreferences;
    const/4 v5, 0x0

    .line 74
    .local v5, "currentActivity":Landroid/app/Activity;
    :try_start_1
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getCurrentActivity()Landroid/app/Activity;
    :try_end_1
    .catch Lcom/adobe/mobile/StaticMethods$NullActivityException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v5

    .line 79
    :goto_1
    if-eqz v5, :cond_1

    if-eqz p0, :cond_1

    .line 80
    invoke-virtual {v5}, Landroid/app/Activity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Landroid/content/ComponentName;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {p0 .. p0}, Landroid/app/Activity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Landroid/content/ComponentName;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_1

    .line 81
    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    invoke-static/range {v19 .. v21}, Lcom/adobe/mobile/Messages;->checkForInAppMessage(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V

    .line 85
    :cond_1
    invoke-static/range {p0 .. p0}, Lcom/adobe/mobile/StaticMethods;->setCurrentActivity(Landroid/app/Activity;)V

    .line 87
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v11

    .line 88
    .local v11, "mobileConfig":Lcom/adobe/mobile/MobileConfig;
    const-string v19, "ADMS_PauseDate"

    const-wide/16 v20, 0x0

    invoke-interface/range {v18 .. v21}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v12

    .line 89
    .local v12, "lastPauseDate":J
    invoke-virtual {v11}, Lcom/adobe/mobile/MobileConfig;->getLifecycleTimeout()I

    move-result v17

    .line 91
    .local v17, "sessionTimeout":I
    const/4 v10, 0x1

    .line 94
    .local v10, "isNewSession":Z
    const-wide/16 v20, 0x0

    cmp-long v19, v12, v20

    if-lez v19, :cond_2

    .line 95
    new-instance v19, Ljava/util/Date;

    invoke-direct/range {v19 .. v19}, Ljava/util/Date;-><init>()V

    invoke-virtual/range {v19 .. v19}, Ljava/util/Date;->getTime()J

    move-result-wide v20

    sub-long v20, v20, v12

    const-wide/16 v22, 0x3e8

    div-long v20, v20, v22

    move-wide/from16 v0, v20

    long-to-int v0, v0

    move/from16 v16, v0

    .line 96
    .local v16, "pausedTime":I
    const-string v19, "ADMS_SessionStart"

    const-wide/16 v20, 0x0

    invoke-interface/range {v18 .. v21}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v14

    .line 99
    .local v14, "originalStartDate":J
    const-wide/16 v20, 0x3e8

    div-long v20, v14, v20

    sput-wide v20, Lcom/adobe/mobile/Lifecycle;->sessionStartTime:J

    .line 101
    invoke-static {}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->sharedInstance()Lcom/adobe/mobile/AnalyticsTrackTimedAction;

    move-result-object v19

    move/from16 v0, v16

    int-to-long v0, v0

    move-wide/from16 v20, v0

    invoke-virtual/range {v19 .. v21}, Lcom/adobe/mobile/AnalyticsTrackTimedAction;->trackTimedActionUpdateAdjustedStartTime(J)V

    .line 103
    move/from16 v0, v16

    move/from16 v1, v17

    if-ge v0, v1, :cond_2

    const-wide/16 v20, 0x0

    cmp-long v19, v14, v20

    if-lez v19, :cond_2

    .line 107
    :try_start_2
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v9

    .line 108
    .local v9, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v19, "ADMS_SessionStart"

    move/from16 v0, v16

    mul-int/lit16 v0, v0, 0x3e8

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-long v0, v0

    move-wide/from16 v20, v0

    add-long v20, v20, v14

    move-object/from16 v0, v19

    move-wide/from16 v1, v20

    invoke-interface {v9, v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 109
    invoke-interface {v9}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_2
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_2 .. :try_end_2} :catch_1

    .line 115
    .end local v9    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_2
    const-string v19, "ADMS_SessionStart"

    const-wide/16 v20, 0x0

    invoke-interface/range {v18 .. v21}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v20

    const-wide/16 v22, 0x3e8

    div-long v20, v20, v22

    sput-wide v20, Lcom/adobe/mobile/Lifecycle;->sessionStartTime:J

    .line 117
    const/4 v10, 0x0

    .line 121
    .end local v14    # "originalStartDate":J
    .end local v16    # "pausedTime":I
    :cond_2
    new-instance v19, Ljava/util/Date;

    invoke-direct/range {v19 .. v19}, Ljava/util/Date;-><init>()V

    invoke-virtual/range {v19 .. v19}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    .line 124
    .local v6, "date":J
    if-eqz v10, :cond_4

    .line 127
    invoke-virtual {v11}, Lcom/adobe/mobile/MobileConfig;->downloadRemoteConfigs()V

    .line 130
    sget-object v19, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    invoke-virtual/range {v19 .. v19}, Ljava/util/HashMap;->clear()V

    .line 132
    invoke-static {}, Lcom/adobe/mobile/Lifecycle;->clearContextDataLowercase()V

    .line 134
    if-eqz p1, :cond_5

    new-instance v4, Ljava/util/HashMap;

    move-object/from16 v0, p1

    invoke-direct {v4, v0}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 137
    .local v4, "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_3
    const-string v19, "ADMS_InstallDate"

    invoke-interface/range {v18 .. v19}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_6

    .line 138
    invoke-static {v4, v6, v7}, Lcom/adobe/mobile/Lifecycle;->addInstallData(Ljava/util/Map;J)V

    .line 146
    :goto_4
    invoke-static {v4, v6, v7}, Lcom/adobe/mobile/Lifecycle;->addLifecycleGenericData(Ljava/util/Map;J)V

    .line 148
    invoke-static {v4}, Lcom/adobe/mobile/Lifecycle;->generateLifecycleToBeSaved(Ljava/util/Map;)V

    .line 155
    invoke-static {}, Lcom/adobe/mobile/Lifecycle;->persistLifecycleContextData()V

    .line 158
    invoke-virtual {v11}, Lcom/adobe/mobile/MobileConfig;->mobileUsingAnalytics()Z

    move-result v19

    if-eqz v19, :cond_3

    .line 159
    const-string v19, "Lifecycle"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v20

    const-wide/16 v22, 0x1

    sub-long v20, v20, v22

    move-object/from16 v0, v19

    move-wide/from16 v1, v20

    invoke-static {v0, v4, v1, v2}, Lcom/adobe/mobile/AnalyticsTrackInternal;->trackInternal(Ljava/lang/String;Ljava/util/Map;J)V

    .line 163
    :cond_3
    invoke-virtual {v11}, Lcom/adobe/mobile/MobileConfig;->mobileUsingAudienceManager()Z

    move-result v19

    if-eqz v19, :cond_4

    .line 164
    sget-object v19, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    const/16 v20, 0x0

    invoke-static/range {v19 .. v20}, Lcom/adobe/mobile/AudienceManagerWorker;->SubmitSignal(Ljava/util/Map;Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;)V

    .line 169
    .end local v4    # "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_4
    invoke-static/range {p0 .. p0}, Lcom/adobe/mobile/Lifecycle;->checkForPushMessageClickThrough(Landroid/app/Activity;)V

    .line 171
    invoke-static {v6, v7}, Lcom/adobe/mobile/Lifecycle;->resetLifecycleFlags(J)V

    goto/16 :goto_0

    .line 65
    .end local v5    # "currentActivity":Landroid/app/Activity;
    .end local v6    # "date":J
    .end local v10    # "isNewSession":Z
    .end local v11    # "mobileConfig":Lcom/adobe/mobile/MobileConfig;
    .end local v12    # "lastPauseDate":J
    .end local v17    # "sessionTimeout":I
    .end local v18    # "userDefaults":Landroid/content/SharedPreferences;
    :catch_0
    move-exception v8

    .line 66
    .local v8, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v19, "Lifecycle - Error starting lifecycle (%s)."

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    invoke-virtual {v8}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 110
    .end local v8    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    .restart local v5    # "currentActivity":Landroid/app/Activity;
    .restart local v10    # "isNewSession":Z
    .restart local v11    # "mobileConfig":Lcom/adobe/mobile/MobileConfig;
    .restart local v12    # "lastPauseDate":J
    .restart local v14    # "originalStartDate":J
    .restart local v16    # "pausedTime":I
    .restart local v17    # "sessionTimeout":I
    .restart local v18    # "userDefaults":Landroid/content/SharedPreferences;
    :catch_1
    move-exception v8

    .line 111
    .restart local v8    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v19, "Lifecycle - Error while updating start time (%s)."

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    invoke-virtual {v8}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v22

    aput-object v22, v20, v21

    invoke-static/range {v19 .. v20}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_2

    .line 134
    .end local v8    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    .end local v14    # "originalStartDate":J
    .end local v16    # "pausedTime":I
    .restart local v6    # "date":J
    :cond_5
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    goto :goto_3

    .line 140
    .restart local v4    # "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_6
    invoke-static {v4, v6, v7}, Lcom/adobe/mobile/Lifecycle;->addNonInstallData(Ljava/util/Map;J)V

    .line 141
    invoke-static {v4, v6, v7}, Lcom/adobe/mobile/Lifecycle;->addUpgradeData(Ljava/util/Map;J)V

    .line 142
    invoke-static {v4}, Lcom/adobe/mobile/Lifecycle;->addSessionLengthData(Ljava/util/Map;)V

    goto :goto_4

    .line 76
    .end local v4    # "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v6    # "date":J
    .end local v10    # "isNewSession":Z
    .end local v11    # "mobileConfig":Lcom/adobe/mobile/MobileConfig;
    .end local v12    # "lastPauseDate":J
    .end local v17    # "sessionTimeout":I
    :catch_2
    move-exception v19

    goto/16 :goto_1
.end method

.method protected static stop()V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 176
    sput-boolean v8, Lcom/adobe/mobile/Lifecycle;->lifecycleHasRun:Z

    .line 178
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v4}, Lcom/adobe/mobile/StaticMethods;->updateLastKnownTimestamp(Ljava/lang/Long;)V

    .line 181
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 182
    .local v2, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v4, "ADMS_SuccessfulClose"

    const/4 v5, 0x1

    invoke-interface {v2, v4, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 183
    const-string v4, "ADMS_PauseDate"

    new-instance v5, Ljava/util/Date;

    invoke-direct {v5}, Ljava/util/Date;-><init>()V

    invoke-virtual {v5}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    invoke-interface {v2, v4, v6, v7}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 184
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    .line 192
    :goto_0
    :try_start_1
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getCurrentActivity()Landroid/app/Activity;
    :try_end_1
    .catch Lcom/adobe/mobile/StaticMethods$NullActivityException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    .line 198
    .local v0, "currentActivity":Landroid/app/Activity;
    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 199
    invoke-static {}, Lcom/adobe/mobile/Messages;->resetAllInAppMessages()V

    .line 201
    .end local v0    # "currentActivity":Landroid/app/Activity;
    :cond_0
    :goto_1
    return-void

    .line 185
    :catch_0
    move-exception v1

    .line 186
    .local v1, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v4, "Lifecycle - Error updating lifecycle pause data (%s)"

    new-array v5, v9, [Ljava/lang/Object;

    invoke-virtual {v1}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-static {v4, v5}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 194
    .end local v1    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    :catch_1
    move-exception v3

    .line 195
    .local v3, "ex":Lcom/adobe/mobile/StaticMethods$NullActivityException;
    goto :goto_1
.end method

.method protected static updateContextData(Ljava/util/HashMap;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 234
    .local p0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-object v2, Lcom/adobe/mobile/Lifecycle;->_contextDataMutex:Ljava/lang/Object;

    monitor-enter v2

    .line 235
    :try_start_0
    sget-object v1, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextData:Ljava/util/HashMap;

    invoke-virtual {v1, p0}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 236
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 238
    sget-object v2, Lcom/adobe/mobile/Lifecycle;->_lowercaseContextDataMutex:Ljava/lang/Object;

    monitor-enter v2

    .line 239
    :try_start_1
    invoke-virtual {p0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 240
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-object v4, Lcom/adobe/mobile/Lifecycle;->_lifecycleContextDataLowercase:Ljava/util/HashMap;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v1, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 242
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 236
    :catchall_1
    move-exception v1

    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v1

    .line 242
    :cond_0
    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 243
    return-void
.end method
