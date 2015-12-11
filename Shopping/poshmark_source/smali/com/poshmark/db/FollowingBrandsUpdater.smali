.class public Lcom/poshmark/db/FollowingBrandsUpdater;
.super Landroid/os/AsyncTask;
.source "FollowingBrandsUpdater.java"

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
    .line 19
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 16
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/db/FollowingBrandsUpdater;->clearAllRows:Z

    .line 20
    iput-boolean p2, p0, Lcom/poshmark/db/FollowingBrandsUpdater;->clearAllRows:Z

    .line 21
    iput-object p1, p0, Lcom/poshmark/db/FollowingBrandsUpdater;->data:Lcom/poshmark/db/AllBrandsModel;

    .line 22
    return-void
.end method

.method private bulkInsertToBrandsTable(Lcom/poshmark/db/AllBrandsModel;)V
    .locals 8
    .param p1, "allBrands"    # Lcom/poshmark/db/AllBrandsModel;

    .prologue
    .line 47
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    .line 48
    .local v3, "userId":Ljava/lang/String;
    iget-object v6, p1, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v2

    .line 49
    .local v2, "size":I
    new-array v5, v2, [Landroid/content/ContentValues;

    .line 50
    .local v5, "valuesArray":[Landroid/content/ContentValues;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 51
    iget-object v6, p1, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    invoke-interface {v6, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/Brand;

    .line 52
    .local v0, "brand":Lcom/poshmark/data_model/models/Brand;
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 53
    .local v4, "values":Landroid/content/ContentValues;
    const-string v6, "canonical_name"

    iget-object v7, v0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-virtual {v4, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    const-string v6, "user"

    invoke-virtual {v4, v6, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    aput-object v4, v5, v1

    .line 50
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 57
    .end local v0    # "brand":Lcom/poshmark/data_model/models/Brand;
    .end local v4    # "values":Landroid/content/ContentValues;
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    sget-object v7, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_FOLLOWING_BRANDS:Landroid/net/Uri;

    invoke-virtual {v6, v7, v5}, Landroid/content/ContentResolver;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I

    .line 59
    iget-object v6, p1, Lcom/poshmark/db/AllBrandsModel;->meta:Lcom/poshmark/db/AllBrandsModel$LastUpdateDTM;

    iget-object v6, v6, Lcom/poshmark/db/AllBrandsModel$LastUpdateDTM;->updated_at:Ljava/lang/String;

    invoke-virtual {p0, v3, v6}, Lcom/poshmark/db/FollowingBrandsUpdater;->updateTimeStamp(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    return-void
.end method

.method private populateDb(Lcom/poshmark/db/AllBrandsModel;)V
    .locals 0
    .param p1, "allBrands"    # Lcom/poshmark/db/AllBrandsModel;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Lcom/poshmark/db/FollowingBrandsUpdater;->bulkInsertToBrandsTable(Lcom/poshmark/db/AllBrandsModel;)V

    .line 44
    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/db/FollowingBrandsUpdater;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
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
    iget-object v0, p0, Lcom/poshmark/db/FollowingBrandsUpdater;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "FollowingBrandsUpdater#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 14
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/db/FollowingBrandsUpdater;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "FollowingBrandsUpdater#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 7
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 30
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalDbController;->getMutex()Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 31
    :try_start_0
    iget-boolean v0, p0, Lcom/poshmark/db/FollowingBrandsUpdater;->clearAllRows:Z

    if-eqz v0, :cond_0

    .line 33
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_FOLLOWING_BRANDS:Landroid/net/Uri;

    const-string v3, "user=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 35
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    const-string v3, "tag=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 37
    :cond_0
    iget-object v0, p0, Lcom/poshmark/db/FollowingBrandsUpdater;->data:Lcom/poshmark/db/AllBrandsModel;

    invoke-direct {p0, v0}, Lcom/poshmark/db/FollowingBrandsUpdater;->populateDb(Lcom/poshmark/db/AllBrandsModel;)V

    .line 38
    monitor-exit v1

    .line 39
    const/4 v0, 0x0

    return-object v0

    .line 38
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
    .line 26
    return-void
.end method

.method public updateTimeStamp(Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "timestamp"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    const-string v4, "tag=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    invoke-virtual {v2, v3, v4, v5}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 65
    .local v0, "count":I
    add-int/lit8 v0, v0, 0x1

    .line 67
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 68
    .local v1, "values":Landroid/content/ContentValues;
    const-string v2, "last_update_dtm"

    invoke-virtual {v1, v2, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    const-string v2, "tag"

    invoke-virtual {v1, v2, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    invoke-virtual {v2, v3, v1}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 71
    return-void
.end method
