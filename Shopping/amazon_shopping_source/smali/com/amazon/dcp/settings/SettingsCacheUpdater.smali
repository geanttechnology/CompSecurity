.class final Lcom/amazon/dcp/settings/SettingsCacheUpdater;
.super Ljava/lang/Object;
.source "SettingsCacheUpdater.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/dcp/settings/SettingsCacheUpdater$2;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dcp/settings/SettingsCache$IListener;",
            ">;"
        }
    .end annotation
.end field

.field private final mListenersLock:[Ljava/lang/Object;

.field private volatile mSettingsMap:Lcom/amazon/dcp/settings/SettingsMap;

.field private final mSyncLock:[Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    new-array v0, v1, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->mSyncLock:[Ljava/lang/Object;

    .line 30
    new-array v0, v1, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->mListenersLock:[Ljava/lang/Object;

    .line 31
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->mListeners:Ljava/util/List;

    .line 35
    new-instance v0, Lcom/amazon/dcp/settings/SettingsMap$Builder;

    invoke-direct {v0}, Lcom/amazon/dcp/settings/SettingsMap$Builder;-><init>()V

    invoke-virtual {v0}, Lcom/amazon/dcp/settings/SettingsMap$Builder;->build()Lcom/amazon/dcp/settings/SettingsMap;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->mSettingsMap:Lcom/amazon/dcp/settings/SettingsMap;

    .line 36
    return-void
.end method

.method private static addSettings(Landroid/content/ContentProviderClient;Landroid/content/Context;Lcom/amazon/dcp/settings/SettingsNamespace;Lcom/amazon/dcp/settings/SettingsMap$Builder;)I
    .locals 17
    .param p0, "contentProvider"    # Landroid/content/ContentProviderClient;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "namespace"    # Lcom/amazon/dcp/settings/SettingsNamespace;
    .param p3, "settingsMap"    # Lcom/amazon/dcp/settings/SettingsMap$Builder;

    .prologue
    .line 110
    sget-object v2, Lcom/amazon/dcp/settings/SettingsCacheUpdater$2;->$SwitchMap$com$amazon$dcp$settings$SettingsNamespace:[I

    invoke-virtual/range {p2 .. p2}, Lcom/amazon/dcp/settings/SettingsNamespace;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 119
    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-direct {v2}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v2

    .line 113
    :pswitch_0
    invoke-static/range {p1 .. p1}, Lcom/amazon/dcp/settings/SettingsContract;->getAppLocalNamespace(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v11

    .line 122
    .local v11, "namespaceString":Ljava/lang/String;
    :goto_0
    const/4 v14, 0x0

    .line 123
    .local v14, "result":Landroid/database/Cursor;
    const/4 v12, 0x0

    .line 126
    .local v12, "numRows":I
    :try_start_0
    sget-object v2, Lcom/amazon/dcp/settings/SettingsContract;->VALUES_CONTENT_URI:Landroid/net/Uri;

    invoke-static {v2, v11}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    const/4 v2, 0x2

    new-array v4, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string/jumbo v5, "key"

    aput-object v5, v4, v2

    const/4 v2, 0x1

    const-string/jumbo v5, "value"

    aput-object v5, v4, v2

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object/from16 v2, p0

    invoke-virtual/range {v2 .. v7}, Landroid/content/ContentProviderClient;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v14

    .line 132
    if-nez v14, :cond_1

    .line 157
    if-eqz v14, :cond_0

    .line 159
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    :cond_0
    move v13, v12

    .line 163
    .end local v12    # "numRows":I
    .local v13, "numRows":I
    :goto_1
    return v13

    .line 116
    .end local v11    # "namespaceString":Ljava/lang/String;
    .end local v13    # "numRows":I
    .end local v14    # "result":Landroid/database/Cursor;
    :pswitch_1
    const-string/jumbo v11, "-device-"

    .line 117
    .restart local v11    # "namespaceString":Ljava/lang/String;
    goto :goto_0

    .line 137
    .restart local v12    # "numRows":I
    .restart local v14    # "result":Landroid/database/Cursor;
    :cond_1
    :try_start_1
    const-string/jumbo v2, "key"

    invoke-interface {v14, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v10

    .line 138
    .local v10, "keyColumn":I
    const-string/jumbo v2, "value"

    invoke-interface {v14, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v16

    .line 140
    .local v16, "valueColumn":I
    :goto_2
    invoke-interface {v14}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 142
    invoke-interface {v14, v10}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 143
    .local v9, "key":Ljava/lang/String;
    move/from16 v0, v16

    invoke-interface {v14, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v15

    .line 145
    .local v15, "value":Ljava/lang/String;
    move-object/from16 v0, p3

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v9, v15}, Lcom/amazon/dcp/settings/SettingsMap$Builder;->setValue(Lcom/amazon/dcp/settings/SettingsNamespace;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 146
    add-int/lit8 v12, v12, 0x1

    .line 147
    goto :goto_2

    .line 157
    .end local v9    # "key":Ljava/lang/String;
    .end local v15    # "value":Ljava/lang/String;
    :cond_2
    if-eqz v14, :cond_3

    .line 159
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    .end local v10    # "keyColumn":I
    .end local v16    # "valueColumn":I
    :cond_3
    :goto_3
    move v13, v12

    .line 163
    .end local v12    # "numRows":I
    .restart local v13    # "numRows":I
    goto :goto_1

    .line 149
    .end local v13    # "numRows":I
    .restart local v12    # "numRows":I
    :catch_0
    move-exception v8

    .line 151
    .local v8, "e":Landroid/os/RemoteException;
    :try_start_2
    sget-object v2, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Remote Exception occurred when querying settings content provider because "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v8}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 157
    if-eqz v14, :cond_3

    .line 159
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    goto :goto_3

    .line 157
    .end local v8    # "e":Landroid/os/RemoteException;
    :catchall_0
    move-exception v2

    if-eqz v14, :cond_4

    .line 159
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v2

    .line 110
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private updateMap(Lcom/amazon/dcp/settings/SettingsMap;)V
    .locals 5
    .param p1, "newMap"    # Lcom/amazon/dcp/settings/SettingsMap;

    .prologue
    .line 184
    iput-object p1, p0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->mSettingsMap:Lcom/amazon/dcp/settings/SettingsMap;

    .line 186
    new-instance v2, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 187
    .local v2, "mainHandler":Landroid/os/Handler;
    iget-object v4, p0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->mListenersLock:[Ljava/lang/Object;

    monitor-enter v4

    .line 189
    :try_start_0
    iget-object v3, p0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->mListeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/dcp/settings/SettingsCache$IListener;

    .line 191
    .local v1, "listener":Lcom/amazon/dcp/settings/SettingsCache$IListener;
    new-instance v3, Lcom/amazon/dcp/settings/SettingsCacheUpdater$1;

    invoke-direct {v3, p0, v1}, Lcom/amazon/dcp/settings/SettingsCacheUpdater$1;-><init>(Lcom/amazon/dcp/settings/SettingsCacheUpdater;Lcom/amazon/dcp/settings/SettingsCache$IListener;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 200
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/amazon/dcp/settings/SettingsCache$IListener;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 201
    return-void
.end method


# virtual methods
.method public addListener(Lcom/amazon/dcp/settings/SettingsCache$IListener;)V
    .locals 2
    .param p1, "listener"    # Lcom/amazon/dcp/settings/SettingsCache$IListener;

    .prologue
    .line 168
    iget-object v1, p0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->mListenersLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 170
    :try_start_0
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->mListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 171
    monitor-exit v1

    .line 172
    return-void

    .line 171
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getMap()Lcom/amazon/dcp/settings/SettingsMap;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->mSettingsMap:Lcom/amazon/dcp/settings/SettingsMap;

    return-object v0
.end method

.method public updateFromContentProvider(Landroid/content/Context;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 69
    iget-object v4, p0, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->mSyncLock:[Ljava/lang/Object;

    monitor-enter v4

    .line 71
    const/4 v0, 0x0

    .line 74
    .local v0, "contentProvider":Landroid/content/ContentProviderClient;
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string/jumbo v5, "com.amazon.dcp.settings"

    invoke-virtual {v3, v5}, Landroid/content/ContentResolver;->acquireContentProviderClient(Ljava/lang/String;)Landroid/content/ContentProviderClient;

    move-result-object v0

    .line 76
    if-nez v0, :cond_1

    .line 78
    sget-object v3, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Content provider for Device Settings not found, sync unable to start"

    invoke-static {v3, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 95
    if-eqz v0, :cond_0

    .line 97
    :try_start_1
    invoke-virtual {v0}, Landroid/content/ContentProviderClient;->release()Z

    :cond_0
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 101
    :goto_0
    return-void

    .line 82
    :cond_1
    :try_start_2
    sget-object v3, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Starting sync with content provider."

    invoke-static {v3, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 84
    new-instance v1, Lcom/amazon/dcp/settings/SettingsMap$Builder;

    invoke-direct {v1}, Lcom/amazon/dcp/settings/SettingsMap$Builder;-><init>()V

    .line 85
    .local v1, "mapBuilder":Lcom/amazon/dcp/settings/SettingsMap$Builder;
    const/4 v2, 0x0

    .line 86
    .local v2, "totalRows":I
    sget-object v3, Lcom/amazon/dcp/settings/SettingsNamespace;->AppLocal:Lcom/amazon/dcp/settings/SettingsNamespace;

    invoke-static {v0, p1, v3, v1}, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->addSettings(Landroid/content/ContentProviderClient;Landroid/content/Context;Lcom/amazon/dcp/settings/SettingsNamespace;Lcom/amazon/dcp/settings/SettingsMap$Builder;)I

    move-result v3

    add-int/2addr v2, v3

    .line 87
    sget-object v3, Lcom/amazon/dcp/settings/SettingsNamespace;->DeviceGlobal:Lcom/amazon/dcp/settings/SettingsNamespace;

    invoke-static {v0, p1, v3, v1}, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->addSettings(Landroid/content/ContentProviderClient;Landroid/content/Context;Lcom/amazon/dcp/settings/SettingsNamespace;Lcom/amazon/dcp/settings/SettingsMap$Builder;)I

    move-result v3

    add-int/2addr v2, v3

    .line 89
    invoke-virtual {v1}, Lcom/amazon/dcp/settings/SettingsMap$Builder;->build()Lcom/amazon/dcp/settings/SettingsMap;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->updateMap(Lcom/amazon/dcp/settings/SettingsMap;)V

    .line 91
    sget-object v3, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Sync with content provider complete. Values processed: %d"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 95
    if-eqz v0, :cond_2

    .line 97
    :try_start_3
    invoke-virtual {v0}, Landroid/content/ContentProviderClient;->release()Z

    .line 100
    :cond_2
    monitor-exit v4

    goto :goto_0

    .end local v1    # "mapBuilder":Lcom/amazon/dcp/settings/SettingsMap$Builder;
    .end local v2    # "totalRows":I
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v3

    .line 95
    :catchall_1
    move-exception v3

    if-eqz v0, :cond_3

    .line 97
    :try_start_4
    invoke-virtual {v0}, Landroid/content/ContentProviderClient;->release()Z

    :cond_3
    throw v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method
