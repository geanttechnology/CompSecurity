.class public Lcom/poshmark/db/RecentBrandsUpdater;
.super Landroid/os/AsyncTask;
.source "RecentBrandsUpdater.java"

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


# static fields
.field private static final DEFAULT_RECENT_BRANDS:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field clearAllRows:Z

.field data:Lcom/poshmark/db/AllBrandsModel;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 29
    new-instance v0, Ljava/util/ArrayList;

    const/16 v1, 0xb

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "Tory Burch"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "Michael Kors"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "Coach"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "Louis Vuitton"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "Gucci"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "kate spade"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "J. Crew"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    const-string v3, "Steve Madden"

    aput-object v3, v1, v2

    const/16 v2, 0x8

    const-string v3, "Juicy Couture"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    const-string v3, "Free People"

    aput-object v3, v1, v2

    const/16 v2, 0xa

    const-string v3, "lululemon athletica"

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    sput-object v0, Lcom/poshmark/db/RecentBrandsUpdater;->DEFAULT_RECENT_BRANDS:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 31
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 27
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/db/RecentBrandsUpdater;->clearAllRows:Z

    .line 32
    return-void
.end method

.method private cleanupCursor(Landroid/database/Cursor;)V
    .locals 0
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 88
    if-eqz p1, :cond_0

    .line 89
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    .line 91
    :cond_0
    return-void
.end method

.method private populateRecentsDb()V
    .locals 19

    .prologue
    .line 53
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v17

    .line 54
    .local v17, "userId":Ljava/lang/String;
    const-string v2, "select * from recent_brands WHERE user=\'%s\' ORDER BY insert_dtm COLLATE NOCASE DESC"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v17, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 55
    .local v5, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_RECENTS_BRANDS:Landroid/net/Uri;

    const/4 v4, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 56
    .local v11, "cursor":Landroid/database/Cursor;
    if-eqz v11, :cond_2

    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-nez v2, :cond_2

    .line 57
    sget-object v2, Lcom/poshmark/db/RecentBrandsUpdater;->DEFAULT_RECENT_BRANDS:Ljava/util/List;

    sget-object v3, Lcom/poshmark/db/RecentBrandsUpdater;->DEFAULT_RECENT_BRANDS:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-interface {v2, v3}, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v14

    .line 58
    .local v14, "itr":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v14}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 59
    new-instance v10, Ljava/util/Date;

    invoke-direct {v10}, Ljava/util/Date;-><init>()V

    .line 60
    .local v10, "currentTime":Ljava/util/Date;
    invoke-static {v10}, Lcom/poshmark/utils/DateUtils;->getTimeStampStringFromUTCDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v16

    .line 61
    .local v16, "timeStamp":Ljava/lang/String;
    invoke-interface {v14}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 62
    .local v8, "brandName":Ljava/lang/String;
    new-instance v18, Landroid/content/ContentValues;

    invoke-direct/range {v18 .. v18}, Landroid/content/ContentValues;-><init>()V

    .line 63
    .local v18, "values":Landroid/content/ContentValues;
    const-string v2, "canonical_name"

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    const-string v2, "user"

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    const-string v2, "insert_dtm"

    move-object/from16 v0, v18

    move-object/from16 v1, v16

    invoke-virtual {v0, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_RECENTS_BRANDS:Landroid/net/Uri;

    move-object/from16 v0, v18

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    goto :goto_0

    .line 72
    .end local v8    # "brandName":Ljava/lang/String;
    .end local v10    # "currentTime":Ljava/util/Date;
    .end local v16    # "timeStamp":Ljava/lang/String;
    .end local v18    # "values":Landroid/content/ContentValues;
    :cond_0
    invoke-static {}, Lcom/poshmark/controllers/RecentBrandsController;->globalRecentBrandsController()Lcom/poshmark/controllers/RecentBrandsController;

    move-result-object v9

    .line 73
    .local v9, "controller":Lcom/poshmark/controllers/RecentBrandsController;
    const/4 v2, 0x1

    invoke-virtual {v9, v2}, Lcom/poshmark/controllers/RecentBrandsController;->retrieveRecentBrands(Z)Lcom/poshmark/utils/MetaItemList;

    move-result-object v13

    .line 74
    .local v13, "items":Lcom/poshmark/utils/MetaItemList;, "Lcom/poshmark/utils/MetaItemList<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-eqz v13, :cond_2

    .line 75
    invoke-virtual {v13}, Lcom/poshmark/utils/MetaItemList;->iterator()Ljava/util/Iterator;

    move-result-object v15

    .line 76
    .local v15, "recentBrandsItr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :goto_1
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 77
    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/poshmark/data_model/models/MetaItem;

    .line 78
    .local v12, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v2

    invoke-virtual {v2, v12}, Lcom/poshmark/controllers/GlobalDbController;->addBrandToRecents(Lcom/poshmark/data_model/models/MetaItem;)V

    goto :goto_1

    .line 81
    .end local v12    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_1
    invoke-virtual {v9}, Lcom/poshmark/controllers/RecentBrandsController;->clearGlobalRecentBrandsPref()V

    .line 84
    .end local v9    # "controller":Lcom/poshmark/controllers/RecentBrandsController;
    .end local v13    # "items":Lcom/poshmark/utils/MetaItemList;, "Lcom/poshmark/utils/MetaItemList<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v14    # "itr":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Ljava/lang/String;>;"
    .end local v15    # "recentBrandsItr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_2
    move-object/from16 v0, p0

    invoke-direct {v0, v11}, Lcom/poshmark/db/RecentBrandsUpdater;->cleanupCursor(Landroid/database/Cursor;)V

    .line 85
    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/db/RecentBrandsUpdater;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
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
    iget-object v0, p0, Lcom/poshmark/db/RecentBrandsUpdater;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "RecentBrandsUpdater#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 25
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/db/RecentBrandsUpdater;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "RecentBrandsUpdater#doInBackground"

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
    .line 40
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalDbController;->getMutex()Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 41
    :try_start_0
    invoke-direct {p0}, Lcom/poshmark/db/RecentBrandsUpdater;->populateRecentsDb()V

    .line 42
    monitor-exit v1

    .line 43
    const/4 v0, 0x0

    return-object v0

    .line 42
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
    .line 36
    return-void
.end method
