.class Lcom/amazon/device/ads/AppEventRegistrationHandler;
.super Ljava/lang/Object;
.source "AppEventRegistrationHandler.java"


# static fields
.field protected static final APP_EVENTS_FILE:Ljava/lang/String; = "AppEventsJsonFile"

.field protected static final APP_EVENTS_FILE_MAX_SIZE:J = 0x100000L

.field protected static final APP_EVENT_NAME_KEY:Ljava/lang/String; = "evtName"

.field protected static final APP_EVENT_TIMESTAMP_KEY:Ljava/lang/String; = "ts"

.field private static final LOG_TAG:Ljava/lang/String;

.field protected static instance:Lcom/amazon/device/ads/AppEventRegistrationHandler;


# instance fields
.field protected final appEventsFileLock:Ljava/lang/Object;

.field protected final eventsSent:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected final newEventsToSave:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/amazon/device/ads/AppEventRegistrationHandler;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    .line 55
    new-instance v0, Lcom/amazon/device/ads/AppEventRegistrationHandler;

    invoke-direct {v0}, Lcom/amazon/device/ads/AppEventRegistrationHandler;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->instance:Lcom/amazon/device/ads/AppEventRegistrationHandler;

    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->appEventsFileLock:Ljava/lang/Object;

    .line 60
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->newEventsToSave:Ljava/util/Set;

    .line 61
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->eventsSent:Ljava/util/Set;

    .line 62
    return-void
.end method

.method public static getInstance()Lcom/amazon/device/ads/AppEventRegistrationHandler;
    .locals 1

    .prologue
    .line 65
    sget-object v0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->instance:Lcom/amazon/device/ads/AppEventRegistrationHandler;

    return-object v0
.end method


# virtual methods
.method public addEventToAppEventsCacheFile(Lcom/amazon/device/ads/AppEvent;)V
    .locals 1
    .param p1, "appEvent"    # Lcom/amazon/device/ads/AppEvent;

    .prologue
    .line 74
    new-instance v0, Lcom/amazon/device/ads/AppEventRegistrationHandler$1;

    invoke-direct {v0, p0, p1}, Lcom/amazon/device/ads/AppEventRegistrationHandler$1;-><init>(Lcom/amazon/device/ads/AppEventRegistrationHandler;Lcom/amazon/device/ads/AppEvent;)V

    invoke-static {v0}, Lcom/amazon/device/ads/ThreadUtils;->executeRunnable(Ljava/lang/Runnable;)V

    .line 82
    return-void
.end method

.method protected appendAppEventToFile(Lcom/amazon/device/ads/AppEvent;)V
    .locals 19
    .param p1, "appEvent"    # Lcom/amazon/device/ads/AppEvent;

    .prologue
    .line 90
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v13

    invoke-interface {v13}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 91
    .local v2, "appContext":Landroid/content/Context;
    if-nez v2, :cond_0

    .line 155
    :goto_0
    return-void

    .line 95
    :cond_0
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8}, Lorg/json/JSONObject;-><init>()V

    .line 98
    .local v8, "jsonEvent":Lorg/json/JSONObject;
    :try_start_0
    const-string/jumbo v13, "evtName"

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/device/ads/AppEvent;->getEventName()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v8, v13, v14}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 99
    const-string/jumbo v13, "ts"

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/device/ads/AppEvent;->getTimestamp()J

    move-result-wide v14

    invoke-virtual {v8, v13, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 100
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/device/ads/AppEvent;->getPropertyEntries()Ljava/util/Set;

    move-result-object v13

    invoke-interface {v13}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v13

    if-eqz v13, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/Map$Entry;

    .line 102
    .local v9, "prop":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v9}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    invoke-interface {v9}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v14

    invoke-virtual {v8, v13, v14}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 105
    .end local v7    # "i$":Ljava/util/Iterator;
    .end local v9    # "prop":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_0
    move-exception v3

    .line 107
    .local v3, "e":Lorg/json/JSONException;
    sget-object v13, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v14, "Internal error while persisting the application event %s."

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/device/ads/AppEvent;->toString()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v13, v14, v15}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 114
    .end local v3    # "e":Lorg/json/JSONException;
    .restart local v7    # "i$":Ljava/util/Iterator;
    :cond_1
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->newEventsToSave:Ljava/util/Set;

    invoke-virtual {v8}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-interface {v13, v14}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 117
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->appEventsFileLock:Ljava/lang/Object;

    monitor-enter v14

    .line 119
    :try_start_1
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v13, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string/jumbo v15, "\n"

    invoke-virtual {v13, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 120
    .local v10, "toAppend":Ljava/lang/String;
    new-instance v4, Ljava/io/File;

    invoke-virtual {v2}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v13

    const-string/jumbo v15, "AppEventsJsonFile"

    invoke-direct {v4, v13, v15}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 121
    .local v4, "file":Ljava/io/File;
    invoke-virtual {v4}, Ljava/io/File;->length()J

    move-result-wide v15

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v13

    int-to-long v0, v13

    move-wide/from16 v17, v0

    add-long v15, v15, v17

    const-wide/32 v17, 0x100000

    cmp-long v13, v15, v17

    if-lez v13, :cond_2

    .line 123
    sget-object v13, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v15, "Couldn\'t write the application event %s to the cache file. Maximum size limit reached."

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/device/ads/AppEvent;->toString()Ljava/lang/String;

    move-result-object v18

    aput-object v18, v16, v17

    move-object/from16 v0, v16

    invoke-static {v13, v15, v0}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 124
    monitor-exit v14

    goto/16 :goto_0

    .line 154
    .end local v4    # "file":Ljava/io/File;
    .end local v10    # "toAppend":Ljava/lang/String;
    :catchall_0
    move-exception v13

    monitor-exit v14
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v13

    .line 127
    .restart local v4    # "file":Ljava/io/File;
    .restart local v10    # "toAppend":Ljava/lang/String;
    :cond_2
    const/4 v5, 0x0

    .line 128
    .local v5, "fos":Ljava/io/FileOutputStream;
    const/4 v11, 0x0

    .line 131
    .local v11, "writer":Ljava/io/OutputStreamWriter;
    :try_start_2
    new-instance v6, Ljava/io/FileOutputStream;

    const/4 v13, 0x1

    invoke-direct {v6, v4, v13}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 132
    .end local v5    # "fos":Ljava/io/FileOutputStream;
    .local v6, "fos":Ljava/io/FileOutputStream;
    :try_start_3
    new-instance v12, Ljava/io/OutputStreamWriter;

    invoke-direct {v12, v6}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_5
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 133
    .end local v11    # "writer":Ljava/io/OutputStreamWriter;
    .local v12, "writer":Ljava/io/OutputStreamWriter;
    :try_start_4
    invoke-virtual {v12, v10}, Ljava/io/OutputStreamWriter;->write(Ljava/lang/String;)V

    .line 134
    sget-object v13, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v15, "Added the application event %s to the cache file."

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/device/ads/AppEvent;->toString()Ljava/lang/String;

    move-result-object v18

    aput-object v18, v16, v17

    move-object/from16 v0, v16

    invoke-static {v13, v15, v0}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_6
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    .line 144
    if-eqz v12, :cond_3

    .line 146
    :try_start_5
    invoke-virtual {v12}, Ljava/io/OutputStreamWriter;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :cond_3
    move-object v11, v12

    .end local v12    # "writer":Ljava/io/OutputStreamWriter;
    .restart local v11    # "writer":Ljava/io/OutputStreamWriter;
    move-object v5, v6

    .line 154
    .end local v6    # "fos":Ljava/io/FileOutputStream;
    .restart local v5    # "fos":Ljava/io/FileOutputStream;
    :cond_4
    :goto_2
    :try_start_6
    monitor-exit v14

    goto/16 :goto_0

    .line 149
    .end local v5    # "fos":Ljava/io/FileOutputStream;
    .end local v11    # "writer":Ljava/io/OutputStreamWriter;
    .restart local v6    # "fos":Ljava/io/FileOutputStream;
    .restart local v12    # "writer":Ljava/io/OutputStreamWriter;
    :catch_1
    move-exception v3

    .line 151
    .local v3, "e":Ljava/io/IOException;
    sget-object v13, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v15, "Problem while closing application events file."

    invoke-static {v13, v15}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-object v11, v12

    .end local v12    # "writer":Ljava/io/OutputStreamWriter;
    .restart local v11    # "writer":Ljava/io/OutputStreamWriter;
    move-object v5, v6

    .line 153
    .end local v6    # "fos":Ljava/io/FileOutputStream;
    .restart local v5    # "fos":Ljava/io/FileOutputStream;
    goto :goto_2

    .line 136
    .end local v3    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v3

    .line 138
    .restart local v3    # "e":Ljava/io/IOException;
    :goto_3
    :try_start_7
    sget-object v13, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v15, "Couldn\'t write the application event %s to the file."

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/device/ads/AppEvent;->toString()Ljava/lang/String;

    move-result-object v18

    aput-object v18, v16, v17

    move-object/from16 v0, v16

    invoke-static {v13, v15, v0}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 144
    if-eqz v11, :cond_4

    .line 146
    :try_start_8
    invoke-virtual {v11}, Ljava/io/OutputStreamWriter;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_3
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto :goto_2

    .line 149
    :catch_3
    move-exception v3

    .line 151
    :try_start_9
    sget-object v13, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v15, "Problem while closing application events file."

    invoke-static {v13, v15}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    goto :goto_2

    .line 142
    .end local v3    # "e":Ljava/io/IOException;
    :catchall_1
    move-exception v13

    .line 144
    :goto_4
    if-eqz v11, :cond_5

    .line 146
    :try_start_a
    invoke-virtual {v11}, Ljava/io/OutputStreamWriter;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_4
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 152
    :cond_5
    :goto_5
    :try_start_b
    throw v13

    .line 149
    :catch_4
    move-exception v3

    .line 151
    .restart local v3    # "e":Ljava/io/IOException;
    sget-object v15, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v16, "Problem while closing application events file."

    invoke-static/range {v15 .. v16}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    goto :goto_5

    .line 142
    .end local v3    # "e":Ljava/io/IOException;
    .end local v5    # "fos":Ljava/io/FileOutputStream;
    .restart local v6    # "fos":Ljava/io/FileOutputStream;
    :catchall_2
    move-exception v13

    move-object v5, v6

    .end local v6    # "fos":Ljava/io/FileOutputStream;
    .restart local v5    # "fos":Ljava/io/FileOutputStream;
    goto :goto_4

    .end local v5    # "fos":Ljava/io/FileOutputStream;
    .end local v11    # "writer":Ljava/io/OutputStreamWriter;
    .restart local v6    # "fos":Ljava/io/FileOutputStream;
    .restart local v12    # "writer":Ljava/io/OutputStreamWriter;
    :catchall_3
    move-exception v13

    move-object v11, v12

    .end local v12    # "writer":Ljava/io/OutputStreamWriter;
    .restart local v11    # "writer":Ljava/io/OutputStreamWriter;
    move-object v5, v6

    .end local v6    # "fos":Ljava/io/FileOutputStream;
    .restart local v5    # "fos":Ljava/io/FileOutputStream;
    goto :goto_4

    .line 136
    .end local v5    # "fos":Ljava/io/FileOutputStream;
    .restart local v6    # "fos":Ljava/io/FileOutputStream;
    :catch_5
    move-exception v3

    move-object v5, v6

    .end local v6    # "fos":Ljava/io/FileOutputStream;
    .restart local v5    # "fos":Ljava/io/FileOutputStream;
    goto :goto_3

    .end local v5    # "fos":Ljava/io/FileOutputStream;
    .end local v11    # "writer":Ljava/io/OutputStreamWriter;
    .restart local v6    # "fos":Ljava/io/FileOutputStream;
    .restart local v12    # "writer":Ljava/io/OutputStreamWriter;
    :catch_6
    move-exception v3

    move-object v11, v12

    .end local v12    # "writer":Ljava/io/OutputStreamWriter;
    .restart local v11    # "writer":Ljava/io/OutputStreamWriter;
    move-object v5, v6

    .end local v6    # "fos":Ljava/io/FileOutputStream;
    .restart local v5    # "fos":Ljava/io/FileOutputStream;
    goto :goto_3
.end method

.method public getAppEventsJSONArray()Lorg/json/JSONArray;
    .locals 17

    .prologue
    .line 163
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v13

    invoke-interface {v13}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 164
    .local v1, "appContext":Landroid/content/Context;
    if-nez v1, :cond_0

    .line 166
    const/4 v7, 0x0

    .line 236
    :goto_0
    return-object v7

    .line 169
    :cond_0
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->appEventsFileLock:Ljava/lang/Object;

    monitor-enter v14

    .line 171
    :try_start_0
    new-instance v4, Ljava/io/File;

    invoke-virtual {v1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v13

    const-string/jumbo v15, "AppEventsJsonFile"

    invoke-direct {v4, v13, v15}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 172
    .local v4, "file":Ljava/io/File;
    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v13

    if-nez v13, :cond_1

    .line 174
    const/4 v7, 0x0

    monitor-exit v14

    goto :goto_0

    .line 237
    .end local v4    # "file":Ljava/io/File;
    :catchall_0
    move-exception v13

    monitor-exit v14
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v13

    .line 177
    .restart local v4    # "file":Ljava/io/File;
    :cond_1
    const/4 v7, 0x0

    .line 178
    .local v7, "jsonArray":Lorg/json/JSONArray;
    const/4 v5, 0x0

    .line 179
    .local v5, "fin":Ljava/io/FileInputStream;
    const/4 v11, 0x0

    .line 182
    .local v11, "reader":Ljava/io/BufferedReader;
    :try_start_1
    new-instance v6, Ljava/io/FileInputStream;

    invoke-direct {v6, v4}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 183
    .end local v5    # "fin":Ljava/io/FileInputStream;
    .local v6, "fin":Ljava/io/FileInputStream;
    :try_start_2
    new-instance v12, Ljava/io/BufferedReader;

    new-instance v13, Ljava/io/InputStreamReader;

    invoke-direct {v13, v6}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v12, v13}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_7
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 184
    .end local v11    # "reader":Ljava/io/BufferedReader;
    .local v12, "reader":Ljava/io/BufferedReader;
    const/4 v10, 0x0

    .local v10, "jsonEventString":Ljava/lang/String;
    move-object v8, v7

    .line 185
    .end local v7    # "jsonArray":Lorg/json/JSONArray;
    .local v8, "jsonArray":Lorg/json/JSONArray;
    :goto_1
    :try_start_3
    invoke-virtual {v12}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_a

    .line 187
    invoke-static {v10}, Lcom/amazon/device/ads/JSONUtils;->getJSONObjectFromString(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    .line 190
    .local v9, "jsonEventObject":Lorg/json/JSONObject;
    if-nez v9, :cond_5

    .line 192
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/device/ads/AppEventRegistrationHandler;->onAppEventsRegistered()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_8
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    .line 193
    const/4 v7, 0x0

    .line 215
    .end local v8    # "jsonArray":Lorg/json/JSONArray;
    .end local v9    # "jsonEventObject":Lorg/json/JSONObject;
    .restart local v7    # "jsonArray":Lorg/json/JSONArray;
    :goto_2
    if-eqz v6, :cond_2

    .line 217
    :try_start_4
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 226
    :cond_2
    :goto_3
    if-eqz v12, :cond_3

    .line 228
    :try_start_5
    invoke-virtual {v12}, Ljava/io/BufferedReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :cond_3
    move-object v11, v12

    .end local v12    # "reader":Ljava/io/BufferedReader;
    .restart local v11    # "reader":Ljava/io/BufferedReader;
    move-object v5, v6

    .line 236
    .end local v6    # "fin":Ljava/io/FileInputStream;
    .end local v10    # "jsonEventString":Ljava/lang/String;
    .restart local v5    # "fin":Ljava/io/FileInputStream;
    :cond_4
    :goto_4
    :try_start_6
    monitor-exit v14
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_0

    .line 196
    .end local v5    # "fin":Ljava/io/FileInputStream;
    .end local v7    # "jsonArray":Lorg/json/JSONArray;
    .end local v11    # "reader":Ljava/io/BufferedReader;
    .restart local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v8    # "jsonArray":Lorg/json/JSONArray;
    .restart local v9    # "jsonEventObject":Lorg/json/JSONObject;
    .restart local v10    # "jsonEventString":Ljava/lang/String;
    .restart local v12    # "reader":Ljava/io/BufferedReader;
    :cond_5
    if-nez v8, :cond_9

    .line 198
    :try_start_7
    new-instance v7, Lorg/json/JSONArray;

    invoke-direct {v7}, Lorg/json/JSONArray;-><init>()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_8
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    .line 200
    .end local v8    # "jsonArray":Lorg/json/JSONArray;
    .restart local v7    # "jsonArray":Lorg/json/JSONArray;
    :goto_5
    :try_start_8
    invoke-virtual {v7, v9}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 201
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->eventsSent:Ljava/util/Set;

    invoke-virtual {v9}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-interface {v13, v15}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_9
    .catchall {:try_start_8 .. :try_end_8} :catchall_4

    move-object v8, v7

    .line 202
    .end local v7    # "jsonArray":Lorg/json/JSONArray;
    .restart local v8    # "jsonArray":Lorg/json/JSONArray;
    goto :goto_1

    .line 220
    .end local v8    # "jsonArray":Lorg/json/JSONArray;
    .end local v9    # "jsonEventObject":Lorg/json/JSONObject;
    .restart local v7    # "jsonArray":Lorg/json/JSONArray;
    :catch_0
    move-exception v3

    .line 222
    .local v3, "e1":Ljava/io/IOException;
    :try_start_9
    sget-object v13, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v15, "Problem while closing the application events file."

    invoke-static {v13, v15}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 231
    .end local v3    # "e1":Ljava/io/IOException;
    :catch_1
    move-exception v2

    .line 233
    .local v2, "e":Ljava/io/IOException;
    sget-object v13, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v15, "Problem while closing the application events file."

    invoke-static {v13, v15}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    move-object v11, v12

    .end local v12    # "reader":Ljava/io/BufferedReader;
    .restart local v11    # "reader":Ljava/io/BufferedReader;
    move-object v5, v6

    .line 235
    .end local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v5    # "fin":Ljava/io/FileInputStream;
    goto :goto_4

    .line 204
    .end local v2    # "e":Ljava/io/IOException;
    .end local v10    # "jsonEventString":Ljava/lang/String;
    :catch_2
    move-exception v2

    .line 208
    .restart local v2    # "e":Ljava/io/IOException;
    :goto_6
    :try_start_a
    sget-object v13, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v15, "Problem while reading the application events file."

    invoke-static {v13, v15}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    .line 209
    const/4 v7, 0x0

    .line 215
    if-eqz v5, :cond_6

    .line 217
    :try_start_b
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_4
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    .line 226
    :cond_6
    :goto_7
    if-eqz v11, :cond_4

    .line 228
    :try_start_c
    invoke-virtual {v11}, Ljava/io/BufferedReader;->close()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_3
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    goto :goto_4

    .line 231
    :catch_3
    move-exception v2

    .line 233
    :try_start_d
    sget-object v13, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v15, "Problem while closing the application events file."

    invoke-static {v13, v15}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_4

    .line 220
    :catch_4
    move-exception v3

    .line 222
    .restart local v3    # "e1":Ljava/io/IOException;
    sget-object v13, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v15, "Problem while closing the application events file."

    invoke-static {v13, v15}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_0

    goto :goto_7

    .line 213
    .end local v2    # "e":Ljava/io/IOException;
    .end local v3    # "e1":Ljava/io/IOException;
    :catchall_1
    move-exception v13

    .line 215
    :goto_8
    if-eqz v5, :cond_7

    .line 217
    :try_start_e
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_e
    .catch Ljava/io/IOException; {:try_start_e .. :try_end_e} :catch_5
    .catchall {:try_start_e .. :try_end_e} :catchall_0

    .line 226
    :cond_7
    :goto_9
    if-eqz v11, :cond_8

    .line 228
    :try_start_f
    invoke-virtual {v11}, Ljava/io/BufferedReader;->close()V
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_f} :catch_6
    .catchall {:try_start_f .. :try_end_f} :catchall_0

    .line 234
    :cond_8
    :goto_a
    :try_start_10
    throw v13

    .line 220
    :catch_5
    move-exception v3

    .line 222
    .restart local v3    # "e1":Ljava/io/IOException;
    sget-object v15, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v16, "Problem while closing the application events file."

    invoke-static/range {v15 .. v16}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_9

    .line 231
    .end local v3    # "e1":Ljava/io/IOException;
    :catch_6
    move-exception v2

    .line 233
    .restart local v2    # "e":Ljava/io/IOException;
    sget-object v15, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v16, "Problem while closing the application events file."

    invoke-static/range {v15 .. v16}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_0

    goto :goto_a

    .line 213
    .end local v2    # "e":Ljava/io/IOException;
    .end local v5    # "fin":Ljava/io/FileInputStream;
    .restart local v6    # "fin":Ljava/io/FileInputStream;
    :catchall_2
    move-exception v13

    move-object v5, v6

    .end local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v5    # "fin":Ljava/io/FileInputStream;
    goto :goto_8

    .end local v5    # "fin":Ljava/io/FileInputStream;
    .end local v7    # "jsonArray":Lorg/json/JSONArray;
    .end local v11    # "reader":Ljava/io/BufferedReader;
    .restart local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v8    # "jsonArray":Lorg/json/JSONArray;
    .restart local v10    # "jsonEventString":Ljava/lang/String;
    .restart local v12    # "reader":Ljava/io/BufferedReader;
    :catchall_3
    move-exception v13

    move-object v11, v12

    .end local v12    # "reader":Ljava/io/BufferedReader;
    .restart local v11    # "reader":Ljava/io/BufferedReader;
    move-object v5, v6

    .end local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v5    # "fin":Ljava/io/FileInputStream;
    move-object v7, v8

    .end local v8    # "jsonArray":Lorg/json/JSONArray;
    .restart local v7    # "jsonArray":Lorg/json/JSONArray;
    goto :goto_8

    .end local v5    # "fin":Ljava/io/FileInputStream;
    .end local v11    # "reader":Ljava/io/BufferedReader;
    .restart local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v9    # "jsonEventObject":Lorg/json/JSONObject;
    .restart local v12    # "reader":Ljava/io/BufferedReader;
    :catchall_4
    move-exception v13

    move-object v11, v12

    .end local v12    # "reader":Ljava/io/BufferedReader;
    .restart local v11    # "reader":Ljava/io/BufferedReader;
    move-object v5, v6

    .end local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v5    # "fin":Ljava/io/FileInputStream;
    goto :goto_8

    .line 204
    .end local v5    # "fin":Ljava/io/FileInputStream;
    .end local v9    # "jsonEventObject":Lorg/json/JSONObject;
    .end local v10    # "jsonEventString":Ljava/lang/String;
    .restart local v6    # "fin":Ljava/io/FileInputStream;
    :catch_7
    move-exception v2

    move-object v5, v6

    .end local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v5    # "fin":Ljava/io/FileInputStream;
    goto :goto_6

    .end local v5    # "fin":Ljava/io/FileInputStream;
    .end local v7    # "jsonArray":Lorg/json/JSONArray;
    .end local v11    # "reader":Ljava/io/BufferedReader;
    .restart local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v8    # "jsonArray":Lorg/json/JSONArray;
    .restart local v10    # "jsonEventString":Ljava/lang/String;
    .restart local v12    # "reader":Ljava/io/BufferedReader;
    :catch_8
    move-exception v2

    move-object v11, v12

    .end local v12    # "reader":Ljava/io/BufferedReader;
    .restart local v11    # "reader":Ljava/io/BufferedReader;
    move-object v5, v6

    .end local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v5    # "fin":Ljava/io/FileInputStream;
    move-object v7, v8

    .end local v8    # "jsonArray":Lorg/json/JSONArray;
    .restart local v7    # "jsonArray":Lorg/json/JSONArray;
    goto :goto_6

    .end local v5    # "fin":Ljava/io/FileInputStream;
    .end local v11    # "reader":Ljava/io/BufferedReader;
    .restart local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v9    # "jsonEventObject":Lorg/json/JSONObject;
    .restart local v12    # "reader":Ljava/io/BufferedReader;
    :catch_9
    move-exception v2

    move-object v11, v12

    .end local v12    # "reader":Ljava/io/BufferedReader;
    .restart local v11    # "reader":Ljava/io/BufferedReader;
    move-object v5, v6

    .end local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v5    # "fin":Ljava/io/FileInputStream;
    goto :goto_6

    .end local v5    # "fin":Ljava/io/FileInputStream;
    .end local v7    # "jsonArray":Lorg/json/JSONArray;
    .end local v11    # "reader":Ljava/io/BufferedReader;
    .restart local v6    # "fin":Ljava/io/FileInputStream;
    .restart local v8    # "jsonArray":Lorg/json/JSONArray;
    .restart local v12    # "reader":Ljava/io/BufferedReader;
    :cond_9
    move-object v7, v8

    .end local v8    # "jsonArray":Lorg/json/JSONArray;
    .restart local v7    # "jsonArray":Lorg/json/JSONArray;
    goto/16 :goto_5

    .end local v7    # "jsonArray":Lorg/json/JSONArray;
    .end local v9    # "jsonEventObject":Lorg/json/JSONObject;
    .restart local v8    # "jsonArray":Lorg/json/JSONArray;
    :cond_a
    move-object v7, v8

    .end local v8    # "jsonArray":Lorg/json/JSONArray;
    .restart local v7    # "jsonArray":Lorg/json/JSONArray;
    goto/16 :goto_2
.end method

.method public onAppEventsRegistered()V
    .locals 14

    .prologue
    .line 245
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v10

    invoke-interface {v10}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 246
    .local v0, "appContext":Landroid/content/Context;
    if-nez v0, :cond_0

    .line 306
    :goto_0
    return-void

    .line 251
    :cond_0
    iget-object v11, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->appEventsFileLock:Ljava/lang/Object;

    monitor-enter v11

    .line 254
    :try_start_0
    iget-object v10, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->newEventsToSave:Ljava/util/Set;

    iget-object v12, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->eventsSent:Ljava/util/Set;

    invoke-interface {v10, v12}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 258
    iget-object v10, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->newEventsToSave:Ljava/util/Set;

    invoke-interface {v10}, Ljava/util/Set;->isEmpty()Z

    move-result v10

    if-nez v10, :cond_5

    .line 260
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 261
    .local v7, "toWrite":Ljava/lang/StringBuilder;
    iget-object v12, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->newEventsToSave:Ljava/util/Set;

    monitor-enter v12
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 263
    :try_start_1
    iget-object v10, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->newEventsToSave:Ljava/util/Set;

    invoke-interface {v10}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 265
    .local v6, "newEvent":Ljava/lang/String;
    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string/jumbo v13, "\n"

    invoke-virtual {v10, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 267
    .end local v5    # "i$":Ljava/util/Iterator;
    .end local v6    # "newEvent":Ljava/lang/String;
    :catchall_0
    move-exception v10

    monitor-exit v12
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v10

    .line 305
    .end local v7    # "toWrite":Ljava/lang/StringBuilder;
    :catchall_1
    move-exception v10

    monitor-exit v11
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v10

    .line 267
    .restart local v5    # "i$":Ljava/util/Iterator;
    .restart local v7    # "toWrite":Ljava/lang/StringBuilder;
    :cond_1
    :try_start_3
    monitor-exit v12
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 268
    :try_start_4
    new-instance v2, Ljava/io/File;

    invoke-virtual {v0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v10

    const-string/jumbo v12, "AppEventsJsonFile"

    invoke-direct {v2, v10, v12}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 269
    .local v2, "file":Ljava/io/File;
    const/4 v3, 0x0

    .line 270
    .local v3, "fos":Ljava/io/FileOutputStream;
    const/4 v8, 0x0

    .line 273
    .local v8, "writer":Ljava/io/BufferedWriter;
    :try_start_5
    new-instance v4, Ljava/io/FileOutputStream;

    const/4 v10, 0x0

    invoke-direct {v4, v2, v10}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 274
    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .local v4, "fos":Ljava/io/FileOutputStream;
    :try_start_6
    new-instance v9, Ljava/io/BufferedWriter;

    new-instance v10, Ljava/io/OutputStreamWriter;

    invoke-direct {v10, v4}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    invoke-direct {v9, v10}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    .line 275
    .end local v8    # "writer":Ljava/io/BufferedWriter;
    .local v9, "writer":Ljava/io/BufferedWriter;
    :try_start_7
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 277
    iget-object v10, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->newEventsToSave:Ljava/util/Set;

    invoke-interface {v10}, Ljava/util/Set;->clear()V

    .line 278
    iget-object v10, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->eventsSent:Ljava/util/Set;

    invoke-interface {v10}, Ljava/util/Set;->clear()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_5
    .catchall {:try_start_7 .. :try_end_7} :catchall_4

    .line 288
    if-eqz v9, :cond_2

    .line 290
    :try_start_8
    invoke-virtual {v9}, Ljava/io/BufferedWriter;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_0
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    :cond_2
    move-object v8, v9

    .end local v9    # "writer":Ljava/io/BufferedWriter;
    .restart local v8    # "writer":Ljava/io/BufferedWriter;
    move-object v3, v4

    .line 305
    .end local v2    # "file":Ljava/io/File;
    .end local v4    # "fos":Ljava/io/FileOutputStream;
    .end local v5    # "i$":Ljava/util/Iterator;
    .end local v7    # "toWrite":Ljava/lang/StringBuilder;
    .end local v8    # "writer":Ljava/io/BufferedWriter;
    :cond_3
    :goto_2
    :try_start_9
    monitor-exit v11

    goto :goto_0

    .line 293
    .restart local v2    # "file":Ljava/io/File;
    .restart local v4    # "fos":Ljava/io/FileOutputStream;
    .restart local v5    # "i$":Ljava/util/Iterator;
    .restart local v7    # "toWrite":Ljava/lang/StringBuilder;
    .restart local v9    # "writer":Ljava/io/BufferedWriter;
    :catch_0
    move-exception v1

    .line 295
    .local v1, "e":Ljava/io/IOException;
    sget-object v10, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v12, "Problem while closing application events file."

    invoke-static {v10, v12}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    move-object v8, v9

    .end local v9    # "writer":Ljava/io/BufferedWriter;
    .restart local v8    # "writer":Ljava/io/BufferedWriter;
    move-object v3, v4

    .line 297
    .end local v4    # "fos":Ljava/io/FileOutputStream;
    .restart local v3    # "fos":Ljava/io/FileOutputStream;
    goto :goto_2

    .line 280
    .end local v1    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v1

    .line 282
    .restart local v1    # "e":Ljava/io/IOException;
    :goto_3
    :try_start_a
    sget-object v10, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v12, "Couldn\'t write the application event(s) to the file."

    invoke-static {v10, v12}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_2

    .line 288
    if-eqz v8, :cond_3

    .line 290
    :try_start_b
    invoke-virtual {v8}, Ljava/io/BufferedWriter;->close()V
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_2
    .catchall {:try_start_b .. :try_end_b} :catchall_1

    goto :goto_2

    .line 293
    :catch_2
    move-exception v1

    .line 295
    :try_start_c
    sget-object v10, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v12, "Problem while closing application events file."

    invoke-static {v10, v12}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_1

    goto :goto_2

    .line 286
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_2
    move-exception v10

    .line 288
    :goto_4
    if-eqz v8, :cond_4

    .line 290
    :try_start_d
    invoke-virtual {v8}, Ljava/io/BufferedWriter;->close()V
    :try_end_d
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_d} :catch_3
    .catchall {:try_start_d .. :try_end_d} :catchall_1

    .line 296
    :cond_4
    :goto_5
    :try_start_e
    throw v10

    .line 293
    :catch_3
    move-exception v1

    .line 295
    .restart local v1    # "e":Ljava/io/IOException;
    sget-object v12, Lcom/amazon/device/ads/AppEventRegistrationHandler;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v13, "Problem while closing application events file."

    invoke-static {v12, v13}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_5

    .line 302
    .end local v1    # "e":Ljava/io/IOException;
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .end local v5    # "i$":Ljava/util/Iterator;
    .end local v7    # "toWrite":Ljava/lang/StringBuilder;
    .end local v8    # "writer":Ljava/io/BufferedWriter;
    :cond_5
    const-string/jumbo v10, "AppEventsJsonFile"

    invoke-virtual {v0, v10}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    .line 303
    iget-object v10, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler;->eventsSent:Ljava/util/Set;

    invoke-interface {v10}, Ljava/util/Set;->clear()V
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_1

    goto :goto_2

    .line 286
    .restart local v2    # "file":Ljava/io/File;
    .restart local v4    # "fos":Ljava/io/FileOutputStream;
    .restart local v5    # "i$":Ljava/util/Iterator;
    .restart local v7    # "toWrite":Ljava/lang/StringBuilder;
    .restart local v8    # "writer":Ljava/io/BufferedWriter;
    :catchall_3
    move-exception v10

    move-object v3, v4

    .end local v4    # "fos":Ljava/io/FileOutputStream;
    .restart local v3    # "fos":Ljava/io/FileOutputStream;
    goto :goto_4

    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .end local v8    # "writer":Ljava/io/BufferedWriter;
    .restart local v4    # "fos":Ljava/io/FileOutputStream;
    .restart local v9    # "writer":Ljava/io/BufferedWriter;
    :catchall_4
    move-exception v10

    move-object v8, v9

    .end local v9    # "writer":Ljava/io/BufferedWriter;
    .restart local v8    # "writer":Ljava/io/BufferedWriter;
    move-object v3, v4

    .end local v4    # "fos":Ljava/io/FileOutputStream;
    .restart local v3    # "fos":Ljava/io/FileOutputStream;
    goto :goto_4

    .line 280
    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .restart local v4    # "fos":Ljava/io/FileOutputStream;
    :catch_4
    move-exception v1

    move-object v3, v4

    .end local v4    # "fos":Ljava/io/FileOutputStream;
    .restart local v3    # "fos":Ljava/io/FileOutputStream;
    goto :goto_3

    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .end local v8    # "writer":Ljava/io/BufferedWriter;
    .restart local v4    # "fos":Ljava/io/FileOutputStream;
    .restart local v9    # "writer":Ljava/io/BufferedWriter;
    :catch_5
    move-exception v1

    move-object v8, v9

    .end local v9    # "writer":Ljava/io/BufferedWriter;
    .restart local v8    # "writer":Ljava/io/BufferedWriter;
    move-object v3, v4

    .end local v4    # "fos":Ljava/io/FileOutputStream;
    .restart local v3    # "fos":Ljava/io/FileOutputStream;
    goto :goto_3
.end method
