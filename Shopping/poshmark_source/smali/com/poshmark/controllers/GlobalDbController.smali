.class public Lcom/poshmark/controllers/GlobalDbController;
.super Ljava/lang/Object;
.source "GlobalDbController.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/controllers/GlobalDbController$SingletonHolder;
    }
.end annotation


# instance fields
.field mutex:Ljava/lang/Object;


# direct methods
.method constructor <init>()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    new-instance v2, Ljava/lang/Object;

    invoke-direct {v2}, Ljava/lang/Object;-><init>()V

    iput-object v2, p0, Lcom/poshmark/controllers/GlobalDbController;->mutex:Ljava/lang/Object;

    .line 57
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v2

    const-string v3, "com.poshmark.intents.NEW_BRANDS_ON_SERVER"

    invoke-virtual {v2, v3, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 58
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v2

    const-string v3, "com.poshmark.intents.NEW_CATALOG_ON_SERVER"

    invoke-virtual {v2, v3, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 59
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v2

    const-string v3, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v2, v3, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 61
    new-instance v0, Lcom/poshmark/db/AllBrandsUpdater;

    invoke-direct {v0, v5, v4}, Lcom/poshmark/db/AllBrandsUpdater;-><init>(Lcom/poshmark/db/AllBrandsModel;Z)V

    .line 62
    .local v0, "allBrandsUpdater":Lcom/poshmark/db/AllBrandsUpdater;
    new-array v2, v4, [Ljava/lang/Void;

    instance-of v3, v0, Landroid/os/AsyncTask;

    if-nez v3, :cond_0

    invoke-virtual {v0, v2}, Lcom/poshmark/db/AllBrandsUpdater;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 64
    .end local v0    # "allBrandsUpdater":Lcom/poshmark/db/AllBrandsUpdater;
    :goto_0
    new-instance v1, Lcom/poshmark/db/CategoriesUpdater;

    invoke-direct {v1, v5, v4}, Lcom/poshmark/db/CategoriesUpdater;-><init>(Lcom/poshmark/data_model/models/Catalog;Z)V

    .line 65
    .local v1, "categories":Lcom/poshmark/db/CategoriesUpdater;
    new-array v2, v4, [Ljava/lang/Void;

    instance-of v3, v1, Landroid/os/AsyncTask;

    if-nez v3, :cond_1

    invoke-virtual {v1, v2}, Lcom/poshmark/db/CategoriesUpdater;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 66
    .end local v1    # "categories":Lcom/poshmark/db/CategoriesUpdater;
    :goto_1
    return-void

    .line 62
    .restart local v0    # "allBrandsUpdater":Lcom/poshmark/db/AllBrandsUpdater;
    :cond_0
    check-cast v0, Landroid/os/AsyncTask;

    .end local v0    # "allBrandsUpdater":Lcom/poshmark/db/AllBrandsUpdater;
    invoke-static {v0, v2}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 65
    .restart local v1    # "categories":Lcom/poshmark/db/CategoriesUpdater;
    :cond_1
    check-cast v1, Landroid/os/AsyncTask;

    .end local v1    # "categories":Lcom/poshmark/db/CategoriesUpdater;
    invoke-static {v1, v2}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1
.end method

.method private cleanupCursor(Landroid/database/Cursor;)V
    .locals 0
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 435
    if-eqz p1, :cond_0

    .line 436
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    .line 438
    :cond_0
    return-void
.end method

.method public static getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;
    .locals 1

    .prologue
    .line 43
    sget-object v0, Lcom/poshmark/controllers/GlobalDbController$SingletonHolder;->INSTANCE:Lcom/poshmark/controllers/GlobalDbController;

    return-object v0
.end method

.method private reloadAllBrands()V
    .locals 2

    .prologue
    .line 160
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 161
    .local v0, "fields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v1, "canonical_name"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 162
    new-instance v1, Lcom/poshmark/controllers/GlobalDbController$2;

    invoke-direct {v1, p0}, Lcom/poshmark/controllers/GlobalDbController$2;-><init>(Lcom/poshmark/controllers/GlobalDbController;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getAllBrands(Ljava/util/List;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 172
    return-void
.end method

.method private reloadAllFollowingBrands()V
    .locals 2

    .prologue
    .line 175
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 176
    .local v0, "fields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v1, "canonical_name"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 177
    new-instance v1, Lcom/poshmark/controllers/GlobalDbController$3;

    invoke-direct {v1, p0}, Lcom/poshmark/controllers/GlobalDbController$3;-><init>(Lcom/poshmark/controllers/GlobalDbController;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getAllFollowingBrands(Ljava/util/List;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 187
    return-void
.end method

.method private reloadCatalog()V
    .locals 1

    .prologue
    .line 147
    new-instance v0, Lcom/poshmark/controllers/GlobalDbController$1;

    invoke-direct {v0, p0}, Lcom/poshmark/controllers/GlobalDbController$1;-><init>(Lcom/poshmark/controllers/GlobalDbController;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getCatalog(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 157
    return-void
.end method

.method private updateAllBrands(Ljava/lang/String;Ljava/lang/String;)V
    .locals 11
    .param p1, "allBrandsDTM"    # Ljava/lang/String;
    .param p2, "TAG"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 111
    const-string v0, "SELECT * FROM timestamps WHERE tag=\'%s\'"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 112
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 113
    .local v8, "cursor":Landroid/database/Cursor;
    if-eqz v8, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 114
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    .line 115
    const-string v0, "last_update_dtm"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 116
    .local v6, "colIndex":I
    invoke-interface {v8, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 117
    .local v9, "dtmString":Ljava/lang/String;
    invoke-static {v9}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v7

    .line 118
    .local v7, "currentDate":Ljava/util/Date;
    invoke-static {p1}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v10

    .line 119
    .local v10, "newDate":Ljava/util/Date;
    invoke-virtual {v7, v10}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 122
    invoke-direct {p0}, Lcom/poshmark/controllers/GlobalDbController;->reloadAllBrands()V

    .line 125
    .end local v6    # "colIndex":I
    .end local v7    # "currentDate":Ljava/util/Date;
    .end local v9    # "dtmString":Ljava/lang/String;
    .end local v10    # "newDate":Ljava/util/Date;
    :cond_0
    invoke-direct {p0, v8}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 126
    return-void
.end method

.method private updateCatalog(Ljava/lang/String;Ljava/lang/String;)V
    .locals 11
    .param p1, "catalogDTM"    # Ljava/lang/String;
    .param p2, "TAG"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 129
    const-string v0, "SELECT * FROM timestamps WHERE tag=\'%s\'"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 130
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 131
    .local v8, "cursor":Landroid/database/Cursor;
    if-eqz v8, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 132
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    .line 133
    const-string v0, "last_update_dtm"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 134
    .local v6, "colIndex":I
    invoke-interface {v8, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 135
    .local v9, "dtmString":Ljava/lang/String;
    invoke-static {v9}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v7

    .line 136
    .local v7, "currentDate":Ljava/util/Date;
    invoke-static {p1}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v10

    .line 137
    .local v10, "newDate":Ljava/util/Date;
    invoke-virtual {v7, v10}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 138
    invoke-direct {p0}, Lcom/poshmark/controllers/GlobalDbController;->reloadCatalog()V

    .line 141
    .end local v6    # "colIndex":I
    .end local v7    # "currentDate":Ljava/util/Date;
    .end local v9    # "dtmString":Ljava/lang/String;
    .end local v10    # "newDate":Ljava/util/Date;
    :cond_0
    invoke-direct {p0, v8}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 142
    return-void
.end method

.method private updateFollowingBrands(Ljava/lang/String;Ljava/lang/String;)V
    .locals 11
    .param p1, "followingBrandsDTM"    # Ljava/lang/String;
    .param p2, "userId"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 91
    const-string v0, "SELECT * FROM timestamps WHERE tag=\'%s\'"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 92
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 93
    .local v8, "cursor":Landroid/database/Cursor;
    if-eqz v8, :cond_1

    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_1

    .line 94
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    .line 95
    const-string v0, "last_update_dtm"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 96
    .local v6, "colIndex":I
    invoke-interface {v8, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 97
    .local v9, "dtmString":Ljava/lang/String;
    invoke-static {v9}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v7

    .line 98
    .local v7, "currentDate":Ljava/util/Date;
    invoke-static {p1}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v10

    .line 99
    .local v10, "newDate":Ljava/util/Date;
    invoke-virtual {v7, v10}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 102
    invoke-direct {p0}, Lcom/poshmark/controllers/GlobalDbController;->reloadAllFollowingBrands()V

    .line 107
    .end local v6    # "colIndex":I
    .end local v7    # "currentDate":Ljava/util/Date;
    .end local v9    # "dtmString":Ljava/lang/String;
    .end local v10    # "newDate":Ljava/util/Date;
    :cond_0
    :goto_0
    invoke-direct {p0, v8}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 108
    return-void

    .line 105
    :cond_1
    invoke-direct {p0}, Lcom/poshmark/controllers/GlobalDbController;->reloadAllFollowingBrands()V

    goto :goto_0
.end method


# virtual methods
.method public addBrandToRecents(Lcom/poshmark/data_model/models/MetaItem;)V
    .locals 14
    .param p1, "item"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 233
    new-instance v6, Ljava/util/Date;

    invoke-direct {v6}, Ljava/util/Date;-><init>()V

    .line 234
    .local v6, "currentTime":Ljava/util/Date;
    invoke-static {v6}, Lcom/poshmark/utils/DateUtils;->getTimeStampStringFromUTCDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v11

    .line 235
    .local v11, "timestamp":Ljava/lang/String;
    new-instance v13, Landroid/content/ContentValues;

    invoke-direct {v13}, Landroid/content/ContentValues;-><init>()V

    .line 236
    .local v13, "values":Landroid/content/ContentValues;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v12

    .line 239
    .local v12, "userId":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/poshmark/db/SqlStore;->sqlEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 240
    .local v8, "escapedString":Ljava/lang/String;
    const-string v0, "select * from recent_brands WHERE user=\'%s\' AND canonical_name =\'%s\'"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object v12, v1, v2

    const/4 v2, 0x1

    aput-object v8, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 241
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_RECENTS_BRANDS:Landroid/net/Uri;

    const/4 v2, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 242
    .local v7, "cursor":Landroid/database/Cursor;
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 243
    const-string v0, "insert_dtm"

    invoke-virtual {v13, v0, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 244
    const-string v10, "canonical_name=?"

    .line 245
    .local v10, "selectionClause":Ljava/lang/String;
    const/4 v0, 0x1

    new-array v9, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v9, v0

    .line 246
    .local v9, "selectionArgs":[Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_RECENTS_BRANDS:Landroid/net/Uri;

    invoke-virtual {v0, v1, v13, v10, v9}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 253
    .end local v9    # "selectionArgs":[Ljava/lang/String;
    .end local v10    # "selectionClause":Ljava/lang/String;
    :goto_0
    invoke-direct {p0, v7}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 254
    return-void

    .line 248
    :cond_0
    const-string v0, "insert_dtm"

    invoke-virtual {v13, v0, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 249
    const-string v0, "user"

    invoke-virtual {v13, v0, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 250
    const-string v0, "canonical_name"

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v13, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_RECENTS_BRANDS:Landroid/net/Uri;

    invoke-virtual {v0, v1, v13}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    goto :goto_0
.end method

.method public addNewSearchToSavedSearches(Ljava/lang/String;)V
    .locals 13
    .param p1, "kw"    # Ljava/lang/String;

    .prologue
    .line 305
    new-instance v6, Ljava/util/Date;

    invoke-direct {v6}, Ljava/util/Date;-><init>()V

    .line 306
    .local v6, "currentTime":Ljava/util/Date;
    invoke-static {v6}, Lcom/poshmark/utils/DateUtils;->getTimeStampStringFromUTCDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v10

    .line 307
    .local v10, "timestamp":Ljava/lang/String;
    new-instance v12, Landroid/content/ContentValues;

    invoke-direct {v12}, Landroid/content/ContentValues;-><init>()V

    .line 308
    .local v12, "values":Landroid/content/ContentValues;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v11

    .line 309
    .local v11, "userId":Ljava/lang/String;
    const-string v0, "SELECT keyword FROM saved_searches WHERE keyword =\'%s\'  AND user = \'%s\'"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p1}, Lcom/poshmark/db/SqlStore;->sqlEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v1, v2

    const/4 v2, 0x1

    aput-object v11, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 310
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_SAVED_SEARCHES:Landroid/net/Uri;

    const/4 v2, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 311
    .local v7, "cursor":Landroid/database/Cursor;
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 312
    const-string v0, "insert_dtm"

    invoke-virtual {v12, v0, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 313
    const-string v9, "keyword=?"

    .line 314
    .local v9, "selectionClause":Ljava/lang/String;
    const/4 v0, 0x1

    new-array v8, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {p1}, Lcom/poshmark/db/SqlStore;->sqlEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v8, v0

    .line 315
    .local v8, "selectionArgs":[Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_SAVED_SEARCHES:Landroid/net/Uri;

    invoke-virtual {v0, v1, v12, v9, v8}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 322
    .end local v8    # "selectionArgs":[Ljava/lang/String;
    .end local v9    # "selectionClause":Ljava/lang/String;
    :goto_0
    invoke-direct {p0, v7}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 323
    return-void

    .line 317
    :cond_0
    const-string v0, "insert_dtm"

    invoke-virtual {v12, v0, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 318
    const-string v0, "user"

    invoke-virtual {v12, v0, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 319
    const-string v0, "keyword"

    invoke-virtual {v12, v0, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_SAVED_SEARCHES:Landroid/net/Uri;

    invoke-virtual {v0, v1, v12}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    goto :goto_0
.end method

.method public followBrand(Ljava/lang/String;)V
    .locals 4
    .param p1, "brandName"    # Ljava/lang/String;

    .prologue
    .line 380
    invoke-virtual {p0, p1}, Lcom/poshmark/controllers/GlobalDbController;->isFollowingBrand(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 381
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    .line 382
    .local v0, "userId":Ljava/lang/String;
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 383
    .local v1, "values":Landroid/content/ContentValues;
    const-string v2, "canonical_name"

    invoke-virtual {v1, v2, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 384
    const-string v2, "user"

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 385
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_FOLLOWING_BRANDS:Landroid/net/Uri;

    invoke-virtual {v2, v3, v1}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 387
    .end local v0    # "userId":Ljava/lang/String;
    .end local v1    # "values":Landroid/content/ContentValues;
    :cond_0
    return-void
.end method

.method public getAllBrands()Ljava/util/List;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 195
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 197
    .local v6, "allBrandsList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_BRANDS:Landroid/net/Uri;

    const-string v3, " SELECT * from brands"

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 198
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_0

    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 199
    const-string v0, "canonical_name"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 200
    .local v8, "colIndex":I
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    .line 201
    :goto_0
    invoke-interface {v9}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_0

    .line 202
    invoke-interface {v9, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 203
    .local v7, "brandName":Ljava/lang/String;
    new-instance v10, Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {v10, v7, v7}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    .local v10, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v6, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 205
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 208
    .end local v7    # "brandName":Ljava/lang/String;
    .end local v8    # "colIndex":I
    .end local v10    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-direct {p0, v9}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 209
    return-object v6
.end method

.method public getAllCategories()Ljava/util/List;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 441
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 443
    .local v6, "allCategories":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY:Landroid/net/Uri;

    const-string v3, " SELECT * from category"

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 444
    .local v10, "cursor":Landroid/database/Cursor;
    if-eqz v10, :cond_0

    invoke-interface {v10}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 445
    const-string v0, "canonical_name"

    invoke-interface {v10, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 446
    .local v9, "colIndexName":I
    const-string v0, "_id"

    invoke-interface {v10, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 447
    .local v8, "colIndexId":I
    invoke-interface {v10}, Landroid/database/Cursor;->moveToFirst()Z

    .line 448
    :goto_0
    invoke-interface {v10}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_0

    .line 449
    invoke-interface {v10, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 450
    .local v7, "brandName":Ljava/lang/String;
    invoke-interface {v10, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v11

    .line 451
    .local v11, "id":Ljava/lang/String;
    new-instance v12, Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {v12, v11, v7}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 452
    .local v12, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v6, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 453
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 456
    .end local v7    # "brandName":Ljava/lang/String;
    .end local v8    # "colIndexId":I
    .end local v9    # "colIndexName":I
    .end local v11    # "id":Ljava/lang/String;
    .end local v12    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-direct {p0, v10}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 457
    return-object v6
.end method

.method public getAllColors()Ljava/util/List;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 581
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 582
    .local v6, "allColors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    const/4 v9, 0x0

    .line 583
    .local v9, "color":Lcom/poshmark/data_model/models/PMColor;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_COLORS:Landroid/net/Uri;

    const-string v3, " SELECT * from colors"

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 584
    .local v10, "cursor":Landroid/database/Cursor;
    if-eqz v10, :cond_0

    invoke-interface {v10}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 585
    invoke-interface {v10}, Landroid/database/Cursor;->moveToFirst()Z

    .line 586
    const-string v0, "_id"

    invoke-interface {v10, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 587
    .local v7, "colIndex":I
    const-string v0, "rgb"

    invoke-interface {v10, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 588
    .local v8, "colIndexRgb":I
    :goto_0
    invoke-interface {v10}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_0

    .line 589
    new-instance v9, Lcom/poshmark/data_model/models/PMColor;

    .end local v9    # "color":Lcom/poshmark/data_model/models/PMColor;
    invoke-interface {v10, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v10, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v9, v0, v1}, Lcom/poshmark/data_model/models/PMColor;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 590
    .restart local v9    # "color":Lcom/poshmark/data_model/models/PMColor;
    invoke-interface {v6, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 591
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 594
    .end local v7    # "colIndex":I
    .end local v8    # "colIndexRgb":I
    :cond_0
    invoke-direct {p0, v10}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 595
    return-object v6
.end method

.method public getAllFollowingBrands()Ljava/util/List;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 390
    const/4 v8, 0x0

    .line 391
    .local v8, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v10

    .line 392
    .local v10, "userId":Ljava/lang/String;
    const-string v0, "SELECT canonical_name FROM following WHERE user=\'%s\'"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v10, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 393
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_FOLLOWING_BRANDS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 394
    .local v6, "cursor":Landroid/database/Cursor;
    if-eqz v6, :cond_0

    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 395
    new-instance v8, Ljava/util/ArrayList;

    .end local v8    # "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 396
    .restart local v8    # "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    .line 397
    const-string v0, "canonical_name"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 398
    .local v7, "index":I
    :goto_0
    invoke-interface {v6}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_0

    .line 399
    invoke-interface {v6, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 400
    .local v9, "name":Ljava/lang/String;
    invoke-virtual {v8, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 401
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 404
    .end local v7    # "index":I
    .end local v9    # "name":Ljava/lang/String;
    :cond_0
    invoke-direct {p0, v6}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 405
    return-object v8
.end method

.method public getAllSizesForCategory(Ljava/lang/String;)Ljava/util/List;
    .locals 11
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 497
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 498
    .local v6, "allSizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    const/4 v10, 0x0

    .line 499
    .local v10, "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v0, " SELECT * from sizes WHERE _id =\'%s\'"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 501
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_SIZES:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 502
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_0

    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 503
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    .line 504
    const-string v0, "short_name"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 505
    .local v8, "colIndexShortName":I
    const-string v0, "long_name"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 506
    .local v7, "colIndexLongName":I
    :goto_0
    invoke-interface {v9}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_0

    .line 507
    new-instance v10, Lcom/poshmark/data_model/models/MetaItem;

    .end local v10    # "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v9, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v9, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v10, v0, v1}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 508
    .restart local v10    # "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v6, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 509
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 512
    .end local v7    # "colIndexLongName":I
    .end local v8    # "colIndexShortName":I
    :cond_0
    invoke-direct {p0, v9}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 513
    return-object v6
.end method

.method public getAllSubCategoriesForCategory(Ljava/lang/String;)Ljava/util/List;
    .locals 11
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 517
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 518
    .local v6, "allTags":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    const/4 v10, 0x0

    .line 519
    .local v10, "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v0, " SELECT * from subcategory WHERE category_id =\'%s\'"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 521
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_STYLE_TAGS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 522
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_0

    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 523
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    .line 524
    const-string v0, "_id"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 525
    .local v7, "colIndexId":I
    const-string v0, "name"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 526
    .local v8, "colIndexName":I
    :goto_0
    invoke-interface {v9}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_0

    .line 527
    new-instance v10, Lcom/poshmark/data_model/models/MetaItem;

    .end local v10    # "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v9, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v9, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v10, v0, v1}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 528
    .restart local v10    # "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v6, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 529
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 532
    .end local v7    # "colIndexId":I
    .end local v8    # "colIndexName":I
    :cond_0
    invoke-direct {p0, v9}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 533
    return-object v6
.end method

.method public getBrandCanonicalName(Ljava/lang/String;)Ljava/lang/String;
    .locals 11
    .param p1, "brandName"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x1

    const/4 v2, 0x0

    .line 421
    invoke-static {p1}, Lcom/poshmark/db/SqlStore;->sqlEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 422
    .local v8, "escapedString":Ljava/lang/String;
    const-string v0, " SELECT canonical_name from brands WHERE canonical_name =\'%s\'"

    new-array v1, v10, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v8, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 423
    .local v3, "sql":Ljava/lang/String;
    const/4 v9, 0x0

    .line 424
    .local v9, "name":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_BRANDS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 425
    .local v7, "cursor":Landroid/database/Cursor;
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ne v0, v10, :cond_0

    .line 426
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    .line 427
    const-string v0, "canonical_name"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 428
    .local v6, "colIndex":I
    invoke-interface {v7, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 430
    .end local v6    # "colIndex":I
    :cond_0
    invoke-direct {p0, v7}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 431
    return-object v9
.end method

.method public getCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 12
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    const/4 v11, 0x1

    const/4 v2, 0x0

    .line 462
    const/4 v9, 0x0

    .line 463
    .local v9, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-static {p1}, Lcom/poshmark/db/SqlStore;->sqlEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 464
    .local v8, "escapedString":Ljava/lang/String;
    const-string v0, " SELECT canonical_name from category WHERE _id =\'%s\'"

    new-array v1, v11, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v8, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 466
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 467
    .local v7, "cursor":Landroid/database/Cursor;
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ne v0, v11, :cond_0

    .line 468
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    .line 469
    const-string v0, "canonical_name"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 470
    .local v6, "colIndexName":I
    invoke-interface {v7, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 471
    .local v10, "name":Ljava/lang/String;
    new-instance v9, Lcom/poshmark/data_model/models/MetaItem;

    .end local v9    # "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-direct {v9, p1, v10}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 473
    .end local v6    # "colIndexName":I
    .end local v10    # "name":Ljava/lang/String;
    .restart local v9    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-direct {p0, v7}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 474
    return-object v9
.end method

.method public getCategoryFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 14
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    const/4 v13, 0x1

    const/4 v2, 0x0

    .line 478
    const/4 v11, 0x0

    .line 479
    .local v11, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-static {p1}, Lcom/poshmark/db/SqlStore;->sqlEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 480
    .local v9, "escapedString":Ljava/lang/String;
    const-string v0, " SELECT * from category WHERE canonical_name =\'%s\'"

    new-array v1, v13, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v9, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 483
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 484
    .local v8, "cursor":Landroid/database/Cursor;
    if-eqz v8, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ne v0, v13, :cond_0

    .line 485
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    .line 486
    const-string v0, "canonical_name"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 487
    .local v7, "colIndexName":I
    const-string v0, "_id"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 488
    .local v6, "colIndexId":I
    invoke-interface {v8, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    .line 489
    .local v12, "name":Ljava/lang/String;
    invoke-interface {v8, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 490
    .local v10, "id":Ljava/lang/String;
    new-instance v11, Lcom/poshmark/data_model/models/MetaItem;

    .end local v11    # "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-direct {v11, v10, v12}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 492
    .end local v6    # "colIndexId":I
    .end local v7    # "colIndexName":I
    .end local v10    # "id":Ljava/lang/String;
    .end local v12    # "name":Ljava/lang/String;
    .restart local v11    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-direct {p0, v8}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 493
    return-object v11
.end method

.method public getColorFromName(Ljava/lang/String;)Lcom/poshmark/data_model/models/PMColor;
    .locals 10
    .param p1, "colorLabel"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 599
    const/4 v8, 0x0

    .line 600
    .local v8, "color":Lcom/poshmark/data_model/models/PMColor;
    const-string v0, " SELECT * from colors WHERE _id =\'%s\'"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 601
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_COLORS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 602
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_0

    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 603
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    .line 604
    const-string v0, "_id"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 605
    .local v6, "colIndexName":I
    const-string v0, "rgb"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 606
    .local v7, "colIndexRgb":I
    new-instance v8, Lcom/poshmark/data_model/models/PMColor;

    .end local v8    # "color":Lcom/poshmark/data_model/models/PMColor;
    invoke-interface {v9, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v9, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v8, v0, v1}, Lcom/poshmark/data_model/models/PMColor;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 608
    .end local v6    # "colIndexName":I
    .end local v7    # "colIndexRgb":I
    .restart local v8    # "color":Lcom/poshmark/data_model/models/PMColor;
    :cond_0
    invoke-direct {p0, v9}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 609
    return-object v8
.end method

.method public getFollowingBrandsCount()I
    .locals 9

    .prologue
    const/4 v2, 0x0

    .line 409
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v8

    .line 410
    .local v8, "userId":Ljava/lang/String;
    const-string v0, "SELECT canonical_name FROM following WHERE user=\'%s\'"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v8, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 411
    .local v3, "sql":Ljava/lang/String;
    const/4 v6, 0x0

    .line 412
    .local v6, "count":I
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_FOLLOWING_BRANDS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 413
    .local v7, "cursor":Landroid/database/Cursor;
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 414
    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v6

    .line 416
    :cond_0
    invoke-direct {p0, v7}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 417
    return v6
.end method

.method public getMutex()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalDbController;->mutex:Ljava/lang/Object;

    return-object v0
.end method

.method public getRecentBrands()Ljava/util/List;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 213
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 214
    .local v10, "recentBrandsList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v11

    .line 215
    .local v11, "userId":Ljava/lang/String;
    const-string v0, "select * from recent_brands WHERE user=\'%s\' ORDER BY insert_dtm COLLATE NOCASE DESC"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v11, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 216
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_RECENTS_BRANDS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 217
    .local v8, "cursor":Landroid/database/Cursor;
    if-eqz v8, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 218
    const-string v0, "canonical_name"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 219
    .local v7, "colIndex_name":I
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    .line 220
    :goto_0
    invoke-interface {v8}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_0

    .line 221
    const-string v0, "canonical_name"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 222
    invoke-interface {v8, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 223
    .local v6, "brandName":Ljava/lang/String;
    new-instance v9, Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {v9, v6, v6}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    .local v9, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v10, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 225
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 228
    .end local v6    # "brandName":Ljava/lang/String;
    .end local v7    # "colIndex_name":I
    .end local v9    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-direct {p0, v8}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 229
    return-object v10
.end method

.method public getRecentBrandsAndFollowingBrands()Ljava/util/List;
    .locals 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v2, 0x0

    .line 338
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 339
    .local v10, "recentBrandsList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v14

    .line 340
    .local v14, "userId":Ljava/lang/String;
    const-string v0, "select canonical_name,insert_dtm from recent_brands WHERE user=\'%s\'"

    new-array v1, v5, [Ljava/lang/Object;

    aput-object v14, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    .line 341
    .local v11, "sql1":Ljava/lang/String;
    const-string v0, "select canonical_name,Null  from following WHERE user=\'%s\'"

    new-array v1, v5, [Ljava/lang/Object;

    aput-object v14, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    .line 342
    .local v12, "sql2":Ljava/lang/String;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " UNION "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " ORDER BY "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "insert_dtm"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " DESC"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 343
    .local v13, "sql3":Ljava/lang/String;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "SELECT DISTINCT canonical_name FROM ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " )"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 344
    .local v3, "sql4":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_RECENTS_BRANDS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 345
    .local v8, "cursor":Landroid/database/Cursor;
    if-eqz v8, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 346
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    .line 347
    :goto_0
    invoke-interface {v8}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_0

    .line 348
    const-string v0, "canonical_name"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 349
    .local v7, "colIndex":I
    invoke-interface {v8, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 350
    .local v6, "brandName":Ljava/lang/String;
    new-instance v9, Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {v9, v6, v6}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 351
    .local v9, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v10, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 352
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 355
    .end local v6    # "brandName":Ljava/lang/String;
    .end local v7    # "colIndex":I
    .end local v9    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-direct {p0, v8}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 356
    return-object v10
.end method

.method public getSizeForCategoryFromLabel(Ljava/lang/String;Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 12
    .param p1, "categoryId"    # Ljava/lang/String;
    .param p2, "label"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 537
    const/4 v11, 0x0

    .line 538
    .local v11, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-static {p2}, Lcom/poshmark/db/SqlStore;->sqlEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 539
    .local v10, "escapedLabel":Ljava/lang/String;
    const-string v0, "SELECT *  FROM sizes WHERE short_name = \'%s\'  AND _id = \'%s\'"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v10, v1, v4

    const/4 v4, 0x1

    aput-object p1, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 540
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_SIZES:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 541
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_0

    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 542
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    .line 543
    const-string v0, "short_name"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 544
    .local v8, "colIndexShortName":I
    const-string v0, "long_name"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 545
    .local v7, "colIndexLongName":I
    const-string v0, "_id"

    invoke-interface {v9, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 546
    .local v6, "colIndexId":I
    new-instance v11, Lcom/poshmark/data_model/models/MetaItem;

    .end local v11    # "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v9, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v9, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v11, v0, v1}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 548
    .end local v6    # "colIndexId":I
    .end local v7    # "colIndexLongName":I
    .end local v8    # "colIndexShortName":I
    .restart local v11    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-direct {p0, v9}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 549
    return-object v11
.end method

.method public getSubCategoryFromId(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 10
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 553
    const/4 v9, 0x0

    .line 554
    .local v9, "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v0, " SELECT _id,name from subcategory WHERE _id =\'%s\'"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 555
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_STYLE_TAGS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 556
    .local v8, "cursor":Landroid/database/Cursor;
    if-eqz v8, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 557
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    .line 558
    const-string v0, "_id"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 559
    .local v6, "colIndexId":I
    const-string v0, "name"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 560
    .local v7, "colIndexName":I
    new-instance v9, Lcom/poshmark/data_model/models/MetaItem;

    .end local v9    # "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v8, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v8, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v9, v0, v1}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 562
    .end local v6    # "colIndexId":I
    .end local v7    # "colIndexName":I
    .restart local v9    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-direct {p0, v8}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 563
    return-object v9
.end method

.method public getSubCategoryFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 10
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 567
    const/4 v9, 0x0

    .line 568
    .local v9, "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v0, " SELECT _id,name from subcategory WHERE name =\'%s\'"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 569
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_STYLE_TAGS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 570
    .local v8, "cursor":Landroid/database/Cursor;
    if-eqz v8, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 571
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    .line 572
    const-string v0, "_id"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 573
    .local v6, "colIndexId":I
    const-string v0, "name"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 574
    .local v7, "colIndexName":I
    new-instance v9, Lcom/poshmark/data_model/models/MetaItem;

    .end local v9    # "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-interface {v8, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v8, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v9, v0, v1}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 576
    .end local v6    # "colIndexId":I
    .end local v7    # "colIndexName":I
    .restart local v9    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    invoke-direct {p0, v8}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 577
    return-object v9
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 9
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v8, 0x0

    .line 70
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v6

    const-string v7, "com.poshmark.intents.NEW_BRANDS_ON_SERVER"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 71
    const-string v6, "RESULT"

    invoke-virtual {p1, v6}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 72
    .local v1, "bundle":Landroid/os/Bundle;
    const-string v6, "ALL_BRANDS_UPDATE_DTM"

    invoke-virtual {v1, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 73
    .local v0, "allBrandsDTM":Ljava/lang/String;
    const-string v6, "FOLLOWING_BRANDS_UPDATE_DTM"

    invoke-virtual {v1, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 74
    .local v2, "followingBrandsDTM":Ljava/lang/String;
    const-string v6, "brands"

    invoke-direct {p0, v0, v6}, Lcom/poshmark/controllers/GlobalDbController;->updateAllBrands(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v2, v6}, Lcom/poshmark/controllers/GlobalDbController;->updateFollowingBrands(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    .end local v0    # "allBrandsDTM":Ljava/lang/String;
    .end local v1    # "bundle":Landroid/os/Bundle;
    .end local v2    # "followingBrandsDTM":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 76
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v6

    const-string v7, "com.poshmark.intents.NEW_CATALOG_ON_SERVER"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 77
    const-string v6, "RESULT"

    invoke-virtual {p1, v6}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 78
    .restart local v1    # "bundle":Landroid/os/Bundle;
    const-string v6, "CATALOG_UPDATE_DTM"

    invoke-virtual {v1, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 79
    .local v3, "newCatalogDTM":Ljava/lang/String;
    const-string v6, "category"

    invoke-direct {p0, v3, v6}, Lcom/poshmark/controllers/GlobalDbController;->updateCatalog(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 80
    .end local v1    # "bundle":Landroid/os/Bundle;
    .end local v3    # "newCatalogDTM":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v6

    const-string v7, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 82
    new-instance v5, Lcom/poshmark/db/RecentBrandsUpdater;

    invoke-direct {v5}, Lcom/poshmark/db/RecentBrandsUpdater;-><init>()V

    .line 83
    .local v5, "updater":Lcom/poshmark/db/RecentBrandsUpdater;
    new-array v6, v8, [Ljava/lang/Void;

    instance-of v7, v5, Landroid/os/AsyncTask;

    if-nez v7, :cond_3

    invoke-virtual {v5, v6}, Lcom/poshmark/db/RecentBrandsUpdater;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 85
    .end local v5    # "updater":Lcom/poshmark/db/RecentBrandsUpdater;
    :goto_1
    new-instance v4, Lcom/poshmark/db/SavedSearchesUpdater;

    invoke-direct {v4}, Lcom/poshmark/db/SavedSearchesUpdater;-><init>()V

    .line 86
    .local v4, "savedSearchesUpdater":Lcom/poshmark/db/SavedSearchesUpdater;
    new-array v6, v8, [Ljava/lang/Void;

    instance-of v7, v4, Landroid/os/AsyncTask;

    if-nez v7, :cond_4

    invoke-virtual {v4, v6}, Lcom/poshmark/db/SavedSearchesUpdater;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 83
    .end local v4    # "savedSearchesUpdater":Lcom/poshmark/db/SavedSearchesUpdater;
    .restart local v5    # "updater":Lcom/poshmark/db/RecentBrandsUpdater;
    :cond_3
    check-cast v5, Landroid/os/AsyncTask;

    .end local v5    # "updater":Lcom/poshmark/db/RecentBrandsUpdater;
    invoke-static {v5, v6}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 86
    .restart local v4    # "savedSearchesUpdater":Lcom/poshmark/db/SavedSearchesUpdater;
    :cond_4
    check-cast v4, Landroid/os/AsyncTask;

    .end local v4    # "savedSearchesUpdater":Lcom/poshmark/db/SavedSearchesUpdater;
    invoke-static {v4, v6}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public isBrand(Ljava/lang/String;)Z
    .locals 9
    .param p1, "brandName"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    const/4 v2, 0x0

    .line 257
    const/4 v7, 0x0

    .line 258
    .local v7, "retVal":Z
    const-string v0, " SELECT canonical_name from brands WHERE canonical_name =\'%s\'"

    new-array v1, v8, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Lcom/poshmark/db/SqlStore;->sqlEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 259
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_BRANDS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 260
    .local v6, "cursor":Landroid/database/Cursor;
    if-eqz v6, :cond_0

    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ne v0, v8, :cond_0

    .line 261
    const/4 v7, 0x1

    .line 263
    :cond_0
    invoke-direct {p0, v6}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 264
    return v7
.end method

.method public isFollowingBrand(Ljava/lang/String;)Z
    .locals 11
    .param p1, "brandName"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x1

    const/4 v2, 0x0

    .line 360
    const/4 v8, 0x0

    .line 361
    .local v8, "retVal":Z
    invoke-static {p1}, Lcom/poshmark/db/SqlStore;->sqlEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 362
    .local v7, "escapedString":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v9

    .line 363
    .local v9, "userId":Ljava/lang/String;
    const-string v0, "SELECT canonical_name FROM following WHERE canonical_name=\'%s\' AND user =\'%s\'  COLLATE NOCASE"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v7, v1, v4

    aput-object v9, v1, v10

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 364
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_FOLLOWING_BRANDS:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 365
    .local v6, "cursor":Landroid/database/Cursor;
    if-eqz v6, :cond_0

    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ne v0, v10, :cond_0

    .line 366
    const/4 v8, 0x1

    .line 368
    :cond_0
    invoke-direct {p0, v6}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 369
    return v8
.end method

.method public isKeywordInSavedSearches(Ljava/lang/String;)Z
    .locals 10
    .param p1, "kw"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x1

    const/4 v2, 0x0

    .line 326
    const/4 v7, 0x0

    .line 327
    .local v7, "retVal":Z
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v8

    .line 328
    .local v8, "userId":Ljava/lang/String;
    const-string v0, "SELECT keyword FROM saved_searches WHERE keyword =\'%s\'  AND user = \'%s\'"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Lcom/poshmark/db/SqlStore;->sqlEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v4

    aput-object v8, v1, v9

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 329
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_SAVED_SEARCHES:Landroid/net/Uri;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 330
    .local v6, "cursor":Landroid/database/Cursor;
    if-eqz v6, :cond_0

    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ne v0, v9, :cond_0

    .line 331
    const/4 v7, 0x1

    .line 333
    :cond_0
    invoke-direct {p0, v6}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 334
    return v7
.end method

.method public populateCursorWithRecentSavedSearches(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;I)V
    .locals 11
    .param p1, "displayCursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    .param p2, "count"    # I

    .prologue
    .line 286
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v10

    .line 287
    .local v10, "userId":Ljava/lang/String;
    const-string v0, "select * from saved_searches WHERE user=\'%s\' ORDER BY insert_dtm desc  LIMIT %s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object v10, v1, v2

    const/4 v2, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 288
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_SAVED_SEARCHES:Landroid/net/Uri;

    const/4 v2, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 289
    .local v7, "cursor":Landroid/database/Cursor;
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v0

    const/4 v1, 0x1

    if-lt v0, v1, :cond_0

    .line 290
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    .line 291
    :goto_0
    invoke-interface {v7}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_0

    .line 292
    const-string v0, "keyword"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 293
    .local v6, "colIndex":I
    invoke-interface {v7, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 294
    .local v8, "savedSearchString":Ljava/lang/String;
    new-instance v9, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    invoke-direct {v9}, Lcom/poshmark/data_model/models/SuggestedSearchItem;-><init>()V

    .line 295
    .local v9, "suggestion":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    iput-object v8, v9, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    .line 296
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    aput-object v9, v0, v1

    invoke-virtual {p1, v0}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 297
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 300
    .end local v6    # "colIndex":I
    .end local v8    # "savedSearchString":Ljava/lang/String;
    .end local v9    # "suggestion":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    :cond_0
    invoke-direct {p0, v7}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 301
    return-void
.end method

.method public populateCursorWithRelevantSavedSearches(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;Ljava/lang/String;)V
    .locals 11
    .param p1, "displayCursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    .param p2, "kw"    # Ljava/lang/String;

    .prologue
    .line 268
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v10

    .line 269
    .local v10, "userId":Ljava/lang/String;
    const-string v0, "SELECT keyword FROM saved_searches WHERE keyword LIKE \'%s%%\'  AND user = \'%s\'"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p2}, Lcom/poshmark/db/SqlStore;->sqlEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v1, v2

    const/4 v2, 0x1

    aput-object v10, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 270
    .local v3, "sql":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_SAVED_SEARCHES:Landroid/net/Uri;

    const/4 v2, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 271
    .local v7, "cursor":Landroid/database/Cursor;
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v0

    const/4 v1, 0x1

    if-lt v0, v1, :cond_0

    .line 272
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    .line 273
    :goto_0
    invoke-interface {v7}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_0

    .line 274
    const-string v0, "keyword"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 275
    .local v6, "colIndex":I
    invoke-interface {v7, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 276
    .local v8, "savedSearchString":Ljava/lang/String;
    new-instance v9, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    invoke-direct {v9}, Lcom/poshmark/data_model/models/SuggestedSearchItem;-><init>()V

    .line 277
    .local v9, "suggestion":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    iput-object v8, v9, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    .line 278
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    aput-object v9, v0, v1

    invoke-virtual {p1, v0}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 279
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 282
    .end local v6    # "colIndex":I
    .end local v8    # "savedSearchString":Ljava/lang/String;
    .end local v9    # "suggestion":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    :cond_0
    invoke-direct {p0, v7}, Lcom/poshmark/controllers/GlobalDbController;->cleanupCursor(Landroid/database/Cursor;)V

    .line 283
    return-void
.end method

.method public unFollowBrand(Ljava/lang/String;)V
    .locals 6
    .param p1, "brandName"    # Ljava/lang/String;

    .prologue
    .line 373
    invoke-virtual {p0, p1}, Lcom/poshmark/controllers/GlobalDbController;->isFollowingBrand(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 374
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    .line 375
    .local v0, "userId":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_FOLLOWING_BRANDS:Landroid/net/Uri;

    const-string v3, "canonical_name=? AND user=?"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 377
    .end local v0    # "userId":Ljava/lang/String;
    :cond_0
    return-void
.end method
