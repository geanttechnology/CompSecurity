.class public Lcom/poshmark/db/SavedSearchesUpdater;
.super Landroid/os/AsyncTask;
.source "SavedSearchesUpdater.java"

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


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 18
    return-void
.end method

.method private populateDb()V
    .locals 6

    .prologue
    .line 33
    invoke-static {}, Lcom/poshmark/controllers/SavedSearchController;->getGlobalSavedSearchController()Lcom/poshmark/controllers/SavedSearchController;

    move-result-object v0

    .line 34
    .local v0, "controller":Lcom/poshmark/controllers/SavedSearchController;
    invoke-virtual {v0}, Lcom/poshmark/controllers/SavedSearchController;->getAllSavedSearches()Ljava/util/List;

    move-result-object v3

    .line 35
    .local v3, "savedSearches":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/SuggestedSearchItem;>;"
    if-eqz v3, :cond_1

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v4

    if-lez v4, :cond_1

    .line 36
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 37
    .local v2, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/SuggestedSearchItem;>;"
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 38
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    .line 39
    .local v1, "item":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v4

    iget-object v5, v1, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/poshmark/controllers/GlobalDbController;->addNewSearchToSavedSearches(Ljava/lang/String;)V

    goto :goto_0

    .line 41
    .end local v1    # "item":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    :cond_0
    invoke-virtual {v0}, Lcom/poshmark/controllers/SavedSearchController;->clearAll()V

    .line 42
    invoke-virtual {v0}, Lcom/poshmark/controllers/SavedSearchController;->commit()V

    .line 44
    .end local v2    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/SuggestedSearchItem;>;"
    :cond_1
    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/db/SavedSearchesUpdater;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
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
    iget-object v0, p0, Lcom/poshmark/db/SavedSearchesUpdater;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "SavedSearchesUpdater#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 15
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/db/SavedSearchesUpdater;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "SavedSearchesUpdater#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 2
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 26
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalDbController;->getMutex()Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 27
    :try_start_0
    invoke-direct {p0}, Lcom/poshmark/db/SavedSearchesUpdater;->populateDb()V

    .line 28
    monitor-exit v1

    .line 29
    const/4 v0, 0x0

    return-object v0

    .line 28
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
    .line 22
    return-void
.end method
