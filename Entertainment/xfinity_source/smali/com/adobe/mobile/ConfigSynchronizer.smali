.class final Lcom/adobe/mobile/ConfigSynchronizer;
.super Ljava/lang/Object;
.source "ConfigSynchronizer.java"


# static fields
.field private static final _adiDMutex:Ljava/lang/Object;

.field private static final _aidMutex:Ljava/lang/Object;

.field private static final _handheldInstallDateMutex:Ljava/lang/Object;

.field private static final _privacyStatusMutex:Ljava/lang/Object;

.field private static final _pushEnabledMutex:Ljava/lang/Object;

.field private static final _visServiceMutex:Ljava/lang/Object;

.field private static final _visitorIDMutex:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 154
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/ConfigSynchronizer;->_handheldInstallDateMutex:Ljava/lang/Object;

    .line 170
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/ConfigSynchronizer;->_aidMutex:Ljava/lang/Object;

    .line 186
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/ConfigSynchronizer;->_visitorIDMutex:Ljava/lang/Object;

    .line 193
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/ConfigSynchronizer;->_pushEnabledMutex:Ljava/lang/Object;

    .line 200
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/ConfigSynchronizer;->_adiDMutex:Ljava/lang/Object;

    .line 214
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/ConfigSynchronizer;->_visServiceMutex:Ljava/lang/Object;

    .line 233
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/ConfigSynchronizer;->_privacyStatusMutex:Ljava/lang/Object;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected static getSharedConfig()Lcom/google/android/gms/wearable/DataMap;
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 117
    new-instance v0, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v0}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 119
    .local v0, "dataMap":Lcom/google/android/gms/wearable/DataMap;
    :try_start_0
    const-string v2, "ADMS_InstallDate"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "ADMS_InstallDate"

    const-wide/16 v6, 0x0

    invoke-interface {v3, v4, v6, v7}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v4

    invoke-virtual {v0, v2, v4, v5}, Lcom/google/android/gms/wearable/DataMap;->putLong(Ljava/lang/String;J)V

    .line 121
    const-string v2, "ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putBoolean(Ljava/lang/String;Z)V

    .line 122
    const-string v2, "ADOBEMOBILE_STOREDDEFAULTS_AID"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "ADOBEMOBILE_STOREDDEFAULTS_AID"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    const-string v2, "ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putBoolean(Ljava/lang/String;Z)V

    .line 124
    const-string v2, "APP_MEASUREMENT_VISITOR_ID"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "APP_MEASUREMENT_VISITOR_ID"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    const-string v2, "ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    const-string v2, "ADBMOBILE_KEY_PUSH_ENABLED"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "ADBMOBILE_KEY_PUSH_ENABLED"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putBoolean(Ljava/lang/String;Z)V

    .line 128
    const-string v2, "ADBMOBILE_PERSISTED_MID"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "ADBMOBILE_PERSISTED_MID"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    const-string v2, "ADBMOBILE_PERSISTED_MID_HINT"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "ADBMOBILE_PERSISTED_MID_HINT"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    const-string v2, "ADBMOBILE_PERSISTED_MID_BLOB"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "ADBMOBILE_PERSISTED_MID_BLOB"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    const-string v2, "ADBMOBILE_VISITORID_TTL"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "ADBMOBILE_VISITORID_TTL"

    const-wide/16 v6, 0x0

    invoke-interface {v3, v4, v6, v7}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v4

    invoke-virtual {v0, v2, v4, v5}, Lcom/google/android/gms/wearable/DataMap;->putLong(Ljava/lang/String;J)V

    .line 132
    const-string v2, "ADBMOBILE_VISITORID_SYNC"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "ADBMOBILE_VISITORID_SYNC"

    const-wide/16 v6, 0x0

    invoke-interface {v3, v4, v6, v7}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v4

    invoke-virtual {v0, v2, v4, v5}, Lcom/google/android/gms/wearable/DataMap;->putLong(Ljava/lang/String;J)V

    .line 134
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v2

    const-string v3, "PrivacyStatus"

    invoke-interface {v2, v3}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 135
    const-string v2, "PrivacyStatus"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "PrivacyStatus"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putInt(Ljava/lang/String;I)V
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    .line 141
    :cond_0
    :goto_0
    return-object v0

    .line 138
    :catch_0
    move-exception v1

    .line 139
    .local v1, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v2, "Wearable - Error getting shared preferences"

    new-array v3, v8, [Ljava/lang/Object;

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private static restoreAdid(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 3
    .param p0, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 202
    sget-object v2, Lcom/adobe/mobile/ConfigSynchronizer;->_adiDMutex:Ljava/lang/Object;

    monitor-enter v2

    .line 203
    :try_start_0
    new-instance v0, Lcom/adobe/mobile/ConfigSynchronizer$1;

    invoke-direct {v0, p0}, Lcom/adobe/mobile/ConfigSynchronizer$1;-><init>(Lcom/google/android/gms/wearable/DataMap;)V

    .line 210
    .local v0, "task":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<Ljava/lang/String;>;"
    invoke-static {v0}, Lcom/adobe/mobile/Config;->submitAdvertisingIdentifierTask(Ljava/util/concurrent/Callable;)V

    .line 211
    monitor-exit v2

    .line 212
    return-void

    .line 211
    .end local v0    # "task":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<Ljava/lang/String;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private static restoreAid(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 5
    .param p0, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 172
    sget-object v3, Lcom/adobe/mobile/ConfigSynchronizer;->_aidMutex:Ljava/lang/Object;

    monitor-enter v3

    .line 174
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 176
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID"

    const-string v4, "ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID"

    invoke-virtual {p0, v4}, Lcom/google/android/gms/wearable/DataMap;->getBoolean(Ljava/lang/String;)Z

    move-result v4

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 177
    const-string v2, "ADOBEMOBILE_STOREDDEFAULTS_AID"

    const-string v4, "ADOBEMOBILE_STOREDDEFAULTS_AID"

    invoke-virtual {p0, v4}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 178
    const-string v2, "ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED"

    const-string v4, "ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED"

    invoke-virtual {p0, v4}, Lcom/google/android/gms/wearable/DataMap;->getBoolean(Ljava/lang/String;)Z

    move-result v4

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 179
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 183
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_0
    :try_start_1
    monitor-exit v3

    .line 184
    return-void

    .line 180
    :catch_0
    move-exception v0

    .line 181
    .local v0, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v2, "Wearable - Error saving Aid data to shared preferences"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v4}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 183
    .end local v0    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2
.end method

.method protected static restoreConfig(Lcom/google/android/gms/wearable/DataItem;)V
    .locals 3
    .param p0, "item"    # Lcom/google/android/gms/wearable/DataItem;

    .prologue
    .line 247
    if-eqz p0, :cond_0

    invoke-interface {p0}, Lcom/google/android/gms/wearable/DataItem;->getUri()Landroid/net/Uri;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p0}, Lcom/google/android/gms/wearable/DataItem;->getUri()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1

    .line 266
    :cond_0
    :goto_0
    return-void

    .line 250
    :cond_1
    invoke-static {p0}, Lcom/google/android/gms/wearable/DataMapItem;->fromDataItem(Lcom/google/android/gms/wearable/DataItem;)Lcom/google/android/gms/wearable/DataMapItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/wearable/DataMapItem;->getDataMap()Lcom/google/android/gms/wearable/DataMap;

    move-result-object v0

    .line 251
    .local v0, "dataMap":Lcom/google/android/gms/wearable/DataMap;
    if-eqz v0, :cond_0

    .line 254
    invoke-interface {p0}, Lcom/google/android/gms/wearable/DataItem;->getUri()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    .line 255
    .local v1, "path":Ljava/lang/String;
    const-string v2, "/abdmobile/data/config/visitorId"

    invoke-virtual {v1, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_2

    .line 256
    invoke-static {v0}, Lcom/adobe/mobile/ConfigSynchronizer;->restoreVisitorID(Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0

    .line 257
    :cond_2
    const-string v2, "/abdmobile/data/config/vidService"

    invoke-virtual {v1, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_3

    .line 258
    invoke-static {v0}, Lcom/adobe/mobile/ConfigSynchronizer;->restoreVidService(Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0

    .line 259
    :cond_3
    const-string v2, "/abdmobile/data/config/privacyStatus"

    invoke-virtual {v1, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_4

    .line 260
    invoke-static {v0}, Lcom/adobe/mobile/ConfigSynchronizer;->restorePrivacyStatus(Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0

    .line 261
    :cond_4
    const-string v2, "/abdmobile/data/config/adId"

    invoke-virtual {v1, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_5

    .line 262
    invoke-static {v0}, Lcom/adobe/mobile/ConfigSynchronizer;->restoreAdid(Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0

    .line 263
    :cond_5
    const-string v2, "/abdmobile/data/config/pushEnabled"

    invoke-virtual {v1, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_0

    .line 264
    invoke-static {v0}, Lcom/adobe/mobile/ConfigSynchronizer;->restorePushEnabled(Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0
.end method

.method private static restoreHandheldInstallDate(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 8
    .param p0, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 156
    sget-object v3, Lcom/adobe/mobile/ConfigSynchronizer;->_handheldInstallDateMutex:Ljava/lang/Object;

    monitor-enter v3

    .line 158
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 160
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "ADMS_InstallDate"

    invoke-virtual {p0, v2}, Lcom/google/android/gms/wearable/DataMap;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 161
    const-string v2, "ADMS_Handheld_App_InstallDate"

    const-string v4, "ADMS_InstallDate"

    const-wide/16 v6, 0x0

    invoke-virtual {p0, v4, v6, v7}, Lcom/google/android/gms/wearable/DataMap;->getLong(Ljava/lang/String;J)J

    move-result-wide v4

    invoke-interface {v1, v2, v4, v5}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 163
    :cond_0
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 167
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_0
    :try_start_1
    monitor-exit v3

    .line 168
    return-void

    .line 164
    :catch_0
    move-exception v0

    .line 165
    .local v0, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v2, "Wearable - Error saving Handheld App install date to shared preferences"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v4}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 167
    .end local v0    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2
.end method

.method private static restorePrivacyStatus(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 5
    .param p0, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 235
    sget-object v1, Lcom/adobe/mobile/ConfigSynchronizer;->_privacyStatusMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 236
    :try_start_0
    const-string v0, "PrivacyStatus"

    invoke-virtual {p0, v0}, Lcom/google/android/gms/wearable/DataMap;->getInt(Ljava/lang/String;)I

    move-result v0

    invoke-static {}, Lcom/adobe/mobile/MobilePrivacyStatus;->values()[Lcom/adobe/mobile/MobilePrivacyStatus;

    move-result-object v2

    array-length v2, v2

    if-lt v0, v2, :cond_0

    .line 237
    const-string v0, "Wearable - Invalid PrivacyStatus value (%d)"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const-string v4, "PrivacyStatus"

    invoke-virtual {p0, v4}, Lcom/google/android/gms/wearable/DataMap;->getInt(Ljava/lang/String;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 238
    monitor-exit v1

    .line 244
    :goto_0
    return-void

    .line 240
    :cond_0
    const-string v0, "PrivacyStatus"

    invoke-virtual {p0, v0}, Lcom/google/android/gms/wearable/DataMap;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 241
    invoke-static {}, Lcom/adobe/mobile/MobilePrivacyStatus;->values()[Lcom/adobe/mobile/MobilePrivacyStatus;

    move-result-object v0

    const-string v2, "PrivacyStatus"

    invoke-virtual {p0, v2}, Lcom/google/android/gms/wearable/DataMap;->getInt(Ljava/lang/String;)I

    move-result v2

    aget-object v0, v0, v2

    invoke-static {v0}, Lcom/adobe/mobile/Config;->setPrivacyStatus(Lcom/adobe/mobile/MobilePrivacyStatus;)V

    .line 243
    :cond_1
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private static restorePushEnabled(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 2
    .param p0, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 195
    sget-object v1, Lcom/adobe/mobile/ConfigSynchronizer;->_pushEnabledMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 196
    :try_start_0
    const-string v0, "ADBMOBILE_KEY_PUSH_ENABLED"

    invoke-virtual {p0, v0}, Lcom/google/android/gms/wearable/DataMap;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    invoke-static {v0}, Lcom/adobe/mobile/StaticMethods;->setPushEnabled(Z)V

    .line 197
    monitor-exit v1

    .line 198
    return-void

    .line 197
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected static restoreSharedConfig(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 0
    .param p0, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 145
    invoke-static {p0}, Lcom/adobe/mobile/ConfigSynchronizer;->restoreHandheldInstallDate(Lcom/google/android/gms/wearable/DataMap;)V

    .line 146
    invoke-static {p0}, Lcom/adobe/mobile/ConfigSynchronizer;->restorePrivacyStatus(Lcom/google/android/gms/wearable/DataMap;)V

    .line 147
    invoke-static {p0}, Lcom/adobe/mobile/ConfigSynchronizer;->restoreVisitorID(Lcom/google/android/gms/wearable/DataMap;)V

    .line 148
    invoke-static {p0}, Lcom/adobe/mobile/ConfigSynchronizer;->restoreVidService(Lcom/google/android/gms/wearable/DataMap;)V

    .line 149
    invoke-static {p0}, Lcom/adobe/mobile/ConfigSynchronizer;->restoreAid(Lcom/google/android/gms/wearable/DataMap;)V

    .line 150
    invoke-static {p0}, Lcom/adobe/mobile/ConfigSynchronizer;->restoreAdid(Lcom/google/android/gms/wearable/DataMap;)V

    .line 151
    invoke-static {p0}, Lcom/adobe/mobile/ConfigSynchronizer;->restorePushEnabled(Lcom/google/android/gms/wearable/DataMap;)V

    .line 152
    return-void
.end method

.method private static restoreVidService(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 6
    .param p0, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 216
    sget-object v3, Lcom/adobe/mobile/ConfigSynchronizer;->_visServiceMutex:Ljava/lang/Object;

    monitor-enter v3

    .line 218
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 220
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "ADBMOBILE_PERSISTED_MID"

    const-string v4, "ADBMOBILE_PERSISTED_MID"

    invoke-virtual {p0, v4}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 221
    const-string v2, "ADBMOBILE_PERSISTED_MID_HINT"

    const-string v4, "ADBMOBILE_PERSISTED_MID_HINT"

    invoke-virtual {p0, v4}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 222
    const-string v2, "ADBMOBILE_PERSISTED_MID_BLOB"

    const-string v4, "ADBMOBILE_PERSISTED_MID_BLOB"

    invoke-virtual {p0, v4}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 223
    const-string v2, "ADBMOBILE_VISITORID_TTL"

    const-string v4, "ADBMOBILE_VISITORID_TTL"

    invoke-virtual {p0, v4}, Lcom/google/android/gms/wearable/DataMap;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-interface {v1, v2, v4, v5}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 224
    const-string v2, "ADBMOBILE_VISITORID_SYNC"

    const-string v4, "ADBMOBILE_VISITORID_SYNC"

    invoke-virtual {p0, v4}, Lcom/google/android/gms/wearable/DataMap;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-interface {v1, v2, v4, v5}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 225
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 229
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_0
    :try_start_1
    invoke-static {}, Lcom/adobe/mobile/VisitorIDService;->sharedInstance()Lcom/adobe/mobile/VisitorIDService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mobile/VisitorIDService;->resetVariablesFromSharedPreferences()V

    .line 230
    monitor-exit v3

    .line 231
    return-void

    .line 226
    :catch_0
    move-exception v0

    .line 227
    .local v0, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v2, "Wearable - Error saving Visitor Id Service data to shared preferences"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v4}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 230
    .end local v0    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2
.end method

.method private static restoreVisitorID(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 2
    .param p0, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 188
    sget-object v1, Lcom/adobe/mobile/ConfigSynchronizer;->_visitorIDMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 189
    :try_start_0
    const-string v0, "APP_MEASUREMENT_VISITOR_ID"

    invoke-virtual {p0, v0}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mobile/Config;->setUserIdentifier(Ljava/lang/String;)V

    .line 190
    monitor-exit v1

    .line 191
    return-void

    .line 190
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected static syncAdvertisingIdentifier(Ljava/lang/String;)V
    .locals 2
    .param p0, "adid"    # Ljava/lang/String;

    .prologue
    .line 49
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 55
    :goto_0
    return-void

    .line 52
    :cond_0
    new-instance v0, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v0}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 53
    .local v0, "dataMap":Lcom/google/android/gms/wearable/DataMap;
    const-string v1, "ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER"

    invoke-virtual {v0, v1, p0}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    const-string v1, "/abdmobile/data/config/adId"

    invoke-static {v1, v0}, Lcom/adobe/mobile/ConfigSynchronizer;->syncData(Ljava/lang/String;Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0
.end method

.method protected static syncConfigFromHandheld()V
    .locals 13

    .prologue
    .line 270
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v9

    if-eqz v9, :cond_1

    .line 273
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 275
    .local v0, "appCtx":Landroid/content/Context;
    new-instance v9, Lcom/adobe/mobile/WearableDataConnection;

    invoke-direct {v9, v0}, Lcom/adobe/mobile/WearableDataConnection;-><init>(Landroid/content/Context;)V

    const/16 v10, 0x3a98

    invoke-static {v10}, Lcom/adobe/mobile/WearableDataRequest;->createShareConfigRequest(I)Lcom/adobe/mobile/WearableDataRequest;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/adobe/mobile/WearableDataConnection;->send(Lcom/adobe/mobile/WearableDataRequest;)Lcom/adobe/mobile/WearableDataResponse;

    move-result-object v8

    check-cast v8, Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;

    .line 276
    .local v8, "response":Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;
    if-eqz v8, :cond_0

    invoke-virtual {v8}, Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;->getResult()Lcom/google/android/gms/wearable/DataMap;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 277
    invoke-virtual {v8}, Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;->getResult()Lcom/google/android/gms/wearable/DataMap;

    move-result-object v9

    invoke-static {v9}, Lcom/adobe/mobile/ConfigSynchronizer;->restoreSharedConfig(Lcom/google/android/gms/wearable/DataMap;)V

    .line 281
    :cond_0
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v9

    invoke-virtual {v9}, Lcom/adobe/mobile/MobileConfig;->getPointsOfInterestURL()Ljava/lang/String;

    move-result-object v7

    .line 282
    .local v7, "pointsOfInterestURL":Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v9

    invoke-virtual {v9}, Lcom/adobe/mobile/MobileConfig;->getInAppMessageURL()Ljava/lang/String;

    move-result-object v4

    .line 285
    .local v4, "inAppMessagesURL":Ljava/lang/String;
    if-nez v7, :cond_2

    if-nez v4, :cond_2

    .line 313
    .end local v4    # "inAppMessagesURL":Ljava/lang/String;
    .end local v7    # "pointsOfInterestURL":Ljava/lang/String;
    .end local v8    # "response":Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;
    :cond_1
    :goto_0
    return-void

    .line 290
    .restart local v4    # "inAppMessagesURL":Ljava/lang/String;
    .restart local v7    # "pointsOfInterestURL":Ljava/lang/String;
    .restart local v8    # "response":Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;
    :cond_2
    const/4 v6, 0x0

    .line 291
    .local v6, "poiFileName":Ljava/lang/String;
    invoke-static {v7}, Lcom/adobe/mobile/RemoteDownload;->getFileForCachedURL(Ljava/lang/String;)Ljava/io/File;

    move-result-object v5

    .line 292
    .local v5, "poiFile":Ljava/io/File;
    if-eqz v5, :cond_3

    .line 293
    invoke-virtual {v5}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v6

    .line 297
    :cond_3
    const/4 v3, 0x0

    .line 298
    .local v3, "iamFileName":Ljava/lang/String;
    invoke-static {v4}, Lcom/adobe/mobile/RemoteDownload;->getFileForCachedURL(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 299
    .local v2, "iamFile":Ljava/io/File;
    if-eqz v2, :cond_4

    .line 300
    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    .line 303
    :cond_4
    new-instance v9, Lcom/adobe/mobile/WearableDataConnection;

    invoke-direct {v9, v0}, Lcom/adobe/mobile/WearableDataConnection;-><init>(Landroid/content/Context;)V

    const/16 v10, 0x3a98

    invoke-static {v7, v6, v10}, Lcom/adobe/mobile/WearableDataRequest;->createFileRequest(Ljava/lang/String;Ljava/lang/String;I)Lcom/adobe/mobile/WearableDataRequest;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/adobe/mobile/WearableDataConnection;->send(Lcom/adobe/mobile/WearableDataRequest;)Lcom/adobe/mobile/WearableDataResponse;

    .line 304
    new-instance v9, Lcom/adobe/mobile/WearableDataConnection;

    invoke-direct {v9, v0}, Lcom/adobe/mobile/WearableDataConnection;-><init>(Landroid/content/Context;)V

    const/16 v10, 0x3a98

    invoke-static {v4, v3, v10}, Lcom/adobe/mobile/WearableDataRequest;->createFileRequest(Ljava/lang/String;Ljava/lang/String;I)Lcom/adobe/mobile/WearableDataRequest;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/adobe/mobile/WearableDataConnection;->send(Lcom/adobe/mobile/WearableDataRequest;)Lcom/adobe/mobile/WearableDataResponse;

    .line 306
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v9

    invoke-virtual {v9}, Lcom/adobe/mobile/MobileConfig;->loadCachedRemotes()V
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 309
    .end local v2    # "iamFile":Ljava/io/File;
    .end local v3    # "iamFileName":Ljava/lang/String;
    .end local v4    # "inAppMessagesURL":Ljava/lang/String;
    .end local v5    # "poiFile":Ljava/io/File;
    .end local v6    # "poiFileName":Ljava/lang/String;
    .end local v7    # "pointsOfInterestURL":Ljava/lang/String;
    .end local v8    # "response":Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;
    :catch_0
    move-exception v1

    .line 310
    .local v1, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v9, "Analytics - Error syncing Points of Interest and In-app Messages from handheld app to wearable app (%s)"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-virtual {v1}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected static syncData(Ljava/lang/String;Lcom/google/android/gms/wearable/DataMap;)V
    .locals 8
    .param p0, "path"    # Ljava/lang/String;
    .param p1, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 94
    :try_start_0
    new-instance v5, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {v5, v6}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;-><init>(Landroid/content/Context;)V

    sget-object v6, Lcom/google/android/gms/wearable/Wearable;->API:Lcom/google/android/gms/common/api/Api;

    .line 95
    invoke-virtual {v5, v6}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addApi(Lcom/google/android/gms/common/api/Api;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v5

    .line 96
    invoke-virtual {v5}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->build()Lcom/google/android/gms/common/api/GoogleApiClient;
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 100
    .local v3, "mGoogleApiClient":Lcom/google/android/gms/common/api/GoogleApiClient;
    invoke-interface {v3}, Lcom/google/android/gms/common/api/GoogleApiClient;->connect()V

    .line 102
    const-wide/16 v6, 0x3a98

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v3, v6, v7, v5}, Lcom/google/android/gms/common/api/GoogleApiClient;->blockingConnect(JLjava/util/concurrent/TimeUnit;)Lcom/google/android/gms/common/ConnectionResult;

    move-result-object v0

    .line 104
    .local v0, "connectionResult":Lcom/google/android/gms/common/ConnectionResult;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/google/android/gms/common/ConnectionResult;->isSuccess()Z

    move-result v5

    if-nez v5, :cond_1

    .line 105
    :cond_0
    const-string v5, "Wearable - Failed to setup connection"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 114
    .end local v0    # "connectionResult":Lcom/google/android/gms/common/ConnectionResult;
    .end local v3    # "mGoogleApiClient":Lcom/google/android/gms/common/api/GoogleApiClient;
    :goto_0
    return-void

    .line 97
    :catch_0
    move-exception v2

    .line 98
    .local v2, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    goto :goto_0

    .line 110
    .end local v2    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    .restart local v0    # "connectionResult":Lcom/google/android/gms/common/ConnectionResult;
    .restart local v3    # "mGoogleApiClient":Lcom/google/android/gms/common/api/GoogleApiClient;
    :cond_1
    invoke-static {p0}, Lcom/google/android/gms/wearable/PutDataMapRequest;->create(Ljava/lang/String;)Lcom/google/android/gms/wearable/PutDataMapRequest;

    move-result-object v1

    .line 111
    .local v1, "dataMapRequest":Lcom/google/android/gms/wearable/PutDataMapRequest;
    invoke-virtual {v1}, Lcom/google/android/gms/wearable/PutDataMapRequest;->getDataMap()Lcom/google/android/gms/wearable/DataMap;

    move-result-object v5

    invoke-virtual {v5, p1}, Lcom/google/android/gms/wearable/DataMap;->putAll(Lcom/google/android/gms/wearable/DataMap;)V

    .line 112
    invoke-virtual {v1}, Lcom/google/android/gms/wearable/PutDataMapRequest;->asPutDataRequest()Lcom/google/android/gms/wearable/PutDataRequest;

    move-result-object v4

    .line 113
    .local v4, "request":Lcom/google/android/gms/wearable/PutDataRequest;
    sget-object v5, Lcom/google/android/gms/wearable/Wearable;->DataApi:Lcom/google/android/gms/wearable/DataApi;

    invoke-interface {v5, v3, v4}, Lcom/google/android/gms/wearable/DataApi;->putDataItem(Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/wearable/PutDataRequest;)Lcom/google/android/gms/common/api/PendingResult;

    goto :goto_0
.end method

.method protected static syncPrivacyStatus(I)V
    .locals 2
    .param p0, "privacyStatus"    # I

    .prologue
    .line 83
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 89
    :goto_0
    return-void

    .line 86
    :cond_0
    new-instance v0, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v0}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 87
    .local v0, "dataMap":Lcom/google/android/gms/wearable/DataMap;
    const-string v1, "PrivacyStatus"

    invoke-virtual {v0, v1, p0}, Lcom/google/android/gms/wearable/DataMap;->putInt(Ljava/lang/String;I)V

    .line 88
    const-string v1, "/abdmobile/data/config/privacyStatus"

    invoke-static {v1, v0}, Lcom/adobe/mobile/ConfigSynchronizer;->syncData(Ljava/lang/String;Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0
.end method

.method protected static syncPushEnabled(Z)V
    .locals 2
    .param p0, "enabled"    # Z

    .prologue
    .line 59
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 65
    :goto_0
    return-void

    .line 62
    :cond_0
    new-instance v0, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v0}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 63
    .local v0, "dataMap":Lcom/google/android/gms/wearable/DataMap;
    const-string v1, "ADBMOBILE_KEY_PUSH_ENABLED"

    invoke-virtual {v0, v1, p0}, Lcom/google/android/gms/wearable/DataMap;->putBoolean(Ljava/lang/String;Z)V

    .line 64
    const-string v1, "/abdmobile/data/config/pushEnabled"

    invoke-static {v1, v0}, Lcom/adobe/mobile/ConfigSynchronizer;->syncData(Ljava/lang/String;Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0
.end method

.method protected static syncVidService(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V
    .locals 3
    .param p0, "mid"    # Ljava/lang/String;
    .param p1, "hint"    # Ljava/lang/String;
    .param p2, "blob"    # Ljava/lang/String;
    .param p3, "ssl"    # J
    .param p5, "lastSync"    # J

    .prologue
    .line 69
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 79
    :goto_0
    return-void

    .line 72
    :cond_0
    new-instance v0, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v0}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 73
    .local v0, "dataMap":Lcom/google/android/gms/wearable/DataMap;
    const-string v1, "ADBMOBILE_PERSISTED_MID"

    invoke-virtual {v0, v1, p0}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    const-string v1, "ADBMOBILE_PERSISTED_MID_BLOB"

    invoke-virtual {v0, v1, p2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    const-string v1, "ADBMOBILE_PERSISTED_MID_HINT"

    invoke-virtual {v0, v1, p1}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    const-string v1, "ADBMOBILE_VISITORID_TTL"

    invoke-virtual {v0, v1, p3, p4}, Lcom/google/android/gms/wearable/DataMap;->putLong(Ljava/lang/String;J)V

    .line 77
    const-string v1, "ADBMOBILE_VISITORID_SYNC"

    invoke-virtual {v0, v1, p5, p6}, Lcom/google/android/gms/wearable/DataMap;->putLong(Ljava/lang/String;J)V

    .line 78
    const-string v1, "/abdmobile/data/config/vidService"

    invoke-static {v1, v0}, Lcom/adobe/mobile/ConfigSynchronizer;->syncData(Ljava/lang/String;Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0
.end method

.method protected static syncVisitorID(Ljava/lang/String;)V
    .locals 2
    .param p0, "vid"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 45
    :goto_0
    return-void

    .line 42
    :cond_0
    new-instance v0, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v0}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 43
    .local v0, "dataMap":Lcom/google/android/gms/wearable/DataMap;
    const-string v1, "APP_MEASUREMENT_VISITOR_ID"

    invoke-virtual {v0, v1, p0}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    const-string v1, "/abdmobile/data/config/visitorId"

    invoke-static {v1, v0}, Lcom/adobe/mobile/ConfigSynchronizer;->syncData(Ljava/lang/String;Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0
.end method
