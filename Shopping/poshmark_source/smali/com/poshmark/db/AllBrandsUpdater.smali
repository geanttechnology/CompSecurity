.class public Lcom/poshmark/db/AllBrandsUpdater;
.super Landroid/os/AsyncTask;
.source "AllBrandsUpdater.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field clearAllRows:Z

.field data:Lcom/poshmark/db/AllBrandsModel;


# direct methods
.method public constructor <init>(Lcom/poshmark/db/AllBrandsModel;Z)V
    .locals 1
    .param p1, "allBrands"    # Lcom/poshmark/db/AllBrandsModel;
    .param p2, "clearAllRows"    # Z

    .prologue
    .line 27
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/db/AllBrandsUpdater;->clearAllRows:Z

    .line 28
    iput-boolean p2, p0, Lcom/poshmark/db/AllBrandsUpdater;->clearAllRows:Z

    .line 29
    iput-object p1, p0, Lcom/poshmark/db/AllBrandsUpdater;->data:Lcom/poshmark/db/AllBrandsModel;

    .line 30
    return-void
.end method

.method private bulkInsertToBrandsTable(Lcom/poshmark/db/AllBrandsModel;)V
    .locals 7
    .param p1, "allBrands"    # Lcom/poshmark/db/AllBrandsModel;

    .prologue
    .line 74
    iget-object v5, p1, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v2

    .line 75
    .local v2, "size":I
    new-array v4, v2, [Landroid/content/ContentValues;

    .line 76
    .local v4, "valuesArray":[Landroid/content/ContentValues;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 77
    iget-object v5, p1, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/Brand;

    .line 78
    .local v0, "brand":Lcom/poshmark/data_model/models/Brand;
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 79
    .local v3, "values":Landroid/content/ContentValues;
    const-string v5, "canonical_name"

    iget-object v6, v0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-virtual {v3, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    const-string v5, "description"

    const-string v6, "Dummy Description"

    invoke-virtual {v3, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    const-string v5, "following"

    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 82
    aput-object v3, v4, v1

    .line 76
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 84
    .end local v0    # "brand":Lcom/poshmark/data_model/models/Brand;
    .end local v3    # "values":Landroid/content/ContentValues;
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    sget-object v6, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_BRANDS:Landroid/net/Uri;

    invoke-virtual {v5, v6, v4}, Landroid/content/ContentResolver;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I

    .line 86
    const-string v5, "brands"

    iget-object v6, p1, Lcom/poshmark/db/AllBrandsModel;->meta:Lcom/poshmark/db/AllBrandsModel$LastUpdateDTM;

    iget-object v6, v6, Lcom/poshmark/db/AllBrandsModel$LastUpdateDTM;->updated_at:Ljava/lang/String;

    invoke-virtual {p0, v5, v6}, Lcom/poshmark/db/AllBrandsUpdater;->updateTimeStamp(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    return-void
.end method

.method private cleanupCursor(Landroid/database/Cursor;)V
    .locals 0
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 100
    if-eqz p1, :cond_0

    .line 101
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    .line 103
    :cond_0
    return-void
.end method

.method private populateDb(Lcom/poshmark/db/AllBrandsModel;)V
    .locals 14
    .param p1, "allBrands"    # Lcom/poshmark/db/AllBrandsModel;

    .prologue
    const/4 v3, 0x0

    .line 49
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_BRANDS:Landroid/net/Uri;

    const-string v4, " SELECT * from brands"

    move-object v5, v3

    move-object v6, v3

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 50
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_1

    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_1

    .line 51
    if-nez p1, :cond_0

    .line 53
    new-instance v7, Lcom/google/gson/GsonBuilder;

    invoke-direct {v7}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 54
    .local v7, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v7}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v12

    .line 56
    .local v12, "gson":Lcom/google/gson/Gson;
    :try_start_0
    const-string v11, "listing_meta/allBrands.json"

    .line 57
    .local v11, "fileName":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v1

    invoke-virtual {v1, v11}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v13

    .line 58
    .local v13, "ip":Ljava/io/InputStream;
    new-instance v8, Ljava/io/BufferedReader;

    new-instance v1, Ljava/io/InputStreamReader;

    const-string v2, "UTF-8"

    invoke-direct {v1, v13, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v8, v1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 59
    .local v8, "buffered":Ljava/io/BufferedReader;
    const-class v1, Lcom/poshmark/db/AllBrandsModel;

    instance-of v2, v12, Lcom/google/gson/Gson;

    if-nez v2, :cond_2

    invoke-virtual {v12, v8, v1}, Lcom/google/gson/Gson;->fromJson(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    .end local v12    # "gson":Lcom/google/gson/Gson;
    :goto_0
    move-object v0, v1

    check-cast v0, Lcom/poshmark/db/AllBrandsModel;

    move-object p1, v0
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 67
    .end local v7    # "b":Lcom/google/gson/GsonBuilder;
    .end local v8    # "buffered":Ljava/io/BufferedReader;
    .end local v11    # "fileName":Ljava/lang/String;
    .end local v13    # "ip":Ljava/io/InputStream;
    :cond_0
    :goto_1
    invoke-direct {p0, p1}, Lcom/poshmark/db/AllBrandsUpdater;->bulkInsertToBrandsTable(Lcom/poshmark/db/AllBrandsModel;)V

    .line 69
    :cond_1
    invoke-direct {p0, v9}, Lcom/poshmark/db/AllBrandsUpdater;->cleanupCursor(Landroid/database/Cursor;)V

    .line 71
    return-void

    .line 59
    .restart local v7    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v8    # "buffered":Ljava/io/BufferedReader;
    .restart local v11    # "fileName":Ljava/lang/String;
    .restart local v12    # "gson":Lcom/google/gson/Gson;
    .restart local v13    # "ip":Ljava/io/InputStream;
    :cond_2
    :try_start_1
    check-cast v12, Lcom/google/gson/Gson;

    .end local v12    # "gson":Lcom/google/gson/Gson;
    invoke-static {v12, v8, v1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v1

    goto :goto_0

    .line 60
    .end local v8    # "buffered":Ljava/io/BufferedReader;
    .end local v11    # "fileName":Ljava/lang/String;
    .end local v13    # "ip":Ljava/io/InputStream;
    :catch_0
    move-exception v10

    .line 61
    .local v10, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v10}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 62
    .end local v10    # "e":Ljava/io/FileNotFoundException;
    :catch_1
    move-exception v10

    .line 63
    .local v10, "e":Ljava/io/IOException;
    invoke-virtual {v10}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/db/AllBrandsUpdater;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/db/AllBrandsUpdater;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "AllBrandsUpdater#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 22
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/db/AllBrandsUpdater;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "AllBrandsUpdater#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 6
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v5, 0x0

    .line 38
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalDbController;->getMutex()Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 39
    :try_start_0
    iget-boolean v0, p0, Lcom/poshmark/db/AllBrandsUpdater;->clearAllRows:Z

    if-eqz v0, :cond_0

    .line 41
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_BRANDS:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 43
    :cond_0
    iget-object v0, p0, Lcom/poshmark/db/AllBrandsUpdater;->data:Lcom/poshmark/db/AllBrandsModel;

    invoke-direct {p0, v0}, Lcom/poshmark/db/AllBrandsUpdater;->populateDb(Lcom/poshmark/db/AllBrandsModel;)V

    .line 44
    monitor-exit v1

    .line 45
    return-object v5

    .line 44
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 34
    return-void
.end method

.method public updateTimeStamp(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "timestamp"    # Ljava/lang/String;

    .prologue
    .line 91
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    const-string v3, "tag=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 93
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 94
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "last_update_dtm"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    const-string v1, "tag"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 97
    return-void
.end method
