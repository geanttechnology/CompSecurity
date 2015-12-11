.class public Lcom/amazon/mShop/search/viewit/ViewItDBHelper;
.super Ljava/lang/Object;
.source "ViewItDBHelper.java"


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mAllDBObjects:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->mAllDBObjects:Ljava/util/List;

    .line 28
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 29
    return-void
.end method


# virtual methods
.method public delete(Lcom/amazon/mShop/search/viewit/ResultWrapper;)V
    .locals 6
    .param p1, "wrapper"    # Lcom/amazon/mShop/search/viewit/ResultWrapper;

    .prologue
    .line 85
    if-eqz p1, :cond_0

    .line 87
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 88
    .local v0, "deleteEntireRowWhereClause":Ljava/lang/StringBuilder;
    const-string/jumbo v2, "original_scanned_history in (\""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "\")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 89
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/history/HistoryContentProvider;->VISUAL_SEARCH_URI:Landroid/net/Uri;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v4, v5}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    .line 94
    .end local v0    # "deleteEntireRowWhereClause":Ljava/lang/StringBuilder;
    :cond_0
    :goto_0
    return-void

    .line 90
    :catch_0
    move-exception v1

    .line 91
    .local v1, "e":Lcom/amazon/mShop/util/DBException;
    const-string/jumbo v2, "ViewItDBHelper"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Error delete ResultWrapper object from DB:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public deleteAllObjectsFromDB()V
    .locals 7

    .prologue
    .line 102
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/history/HistoryContentProvider;->VISUAL_SEARCH_URI:Landroid/net/Uri;

    const-string/jumbo v4, "email=?"

    const/4 v1, 0x1

    new-array v5, v1, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v1

    :goto_0
    aput-object v1, v5, v6

    invoke-virtual {v2, v3, v4, v5}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 108
    :goto_1
    return-void

    .line 102
    :cond_0
    const-string/jumbo v1, ""
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 105
    :catch_0
    move-exception v0

    .line 106
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    const-string/jumbo v1, "ViewItDBHelper"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Error delete all objects from DB:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method public getAllHistoryItems()Ljava/util/List;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;",
            ">;"
        }
    .end annotation

    .prologue
    .line 111
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->mAllDBObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 112
    const/4 v7, 0x0

    .line 114
    .local v7, "cursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/amazon/mShop/history/HistoryContentProvider;->VISUAL_SEARCH_URI:Landroid/net/Uri;

    sget-object v2, Lcom/amazon/mShop/history/HistoryEntity;->HISTORY_VISION_PROJECTION:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const-string/jumbo v5, "visit_date DESC"

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 115
    if-eqz v7, :cond_1

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_1

    .line 116
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    .line 118
    :cond_0
    const-string/jumbo v0, "original_scanned_history"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 119
    .local v9, "originalScannedOutput":Ljava/lang/String;
    const-string/jumbo v0, "asin"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 120
    .local v6, "asinsSequence":Ljava/lang/String;
    const-string/jumbo v0, "visit_date"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v11

    .line 121
    .local v11, "scanDateTime":J
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v10

    .line 122
    .local v10, "scanDate":Ljava/util/Date;
    invoke-virtual {v10, v11, v12}, Ljava/util/Date;->setTime(J)V

    .line 124
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->mAllDBObjects:Ljava/util/List;

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;

    invoke-direct {v1, v9, v6, v10}, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 126
    const/4 v0, 0x1

    invoke-interface {v7, v0}, Landroid/database/Cursor;->move(I)Z
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_0

    .line 131
    .end local v6    # "asinsSequence":Ljava/lang/String;
    .end local v9    # "originalScannedOutput":Ljava/lang/String;
    .end local v10    # "scanDate":Ljava/util/Date;
    .end local v11    # "scanDateTime":J
    :cond_1
    if-eqz v7, :cond_2

    .line 132
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 135
    :cond_2
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->mAllDBObjects:Ljava/util/List;

    return-object v0

    .line 128
    :catch_0
    move-exception v8

    .line 129
    .local v8, "e":Lcom/amazon/mShop/util/DBException;
    :try_start_1
    const-string/jumbo v0, "ViewItDBHelper"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Error get all ViewItDBResultWrapper objects from DB:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v8}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 131
    if-eqz v7, :cond_2

    .line 132
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 131
    .end local v8    # "e":Lcom/amazon/mShop/util/DBException;
    :catchall_0
    move-exception v0

    if-eqz v7, :cond_3

    .line 132
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v0
.end method

.method public insert(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V
    .locals 5
    .param p1, "wrapper"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .prologue
    .line 36
    if-eqz p1, :cond_0

    .line 38
    :try_start_0
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 39
    .local v1, "values":Landroid/content/ContentValues;
    const-string/jumbo v2, "original_scanned_history"

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    const-string/jumbo v2, "asin"

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSeriesAsinString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    const-string/jumbo v2, "visit_date"

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getScannedDate()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/Date;->getTime()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 42
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/history/HistoryContentProvider;->VISUAL_SEARCH_URI:Landroid/net/Uri;

    invoke-virtual {v2, v3, v1}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    .line 47
    .end local v1    # "values":Landroid/content/ContentValues;
    :cond_0
    :goto_0
    return-void

    .line 43
    :catch_0
    move-exception v0

    .line 44
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    const-string/jumbo v2, "ViewItDBHelper"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Error insert ViewItSearchResultWrapper object to DB:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public update(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V
    .locals 10
    .param p1, "wrapper"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .prologue
    .line 54
    if-eqz p1, :cond_0

    .line 56
    :try_start_0
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSeriesAsinString()Ljava/lang/String;

    move-result-object v2

    .line 57
    .local v2, "seriesAsinString":Ljava/lang/String;
    invoke-virtual {p1, v2}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getLatestScannedOutput(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 58
    .local v1, "latestScannedOutput":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 59
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 60
    .local v3, "values":Landroid/content/ContentValues;
    const-string/jumbo v4, "original_scanned_history"

    invoke-virtual {v3, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    const-string/jumbo v4, "asin"

    invoke-virtual {v3, v4, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    const-string/jumbo v4, "visit_date"

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getScannedDate()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 63
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v4}, Lcom/amazon/mShop/AmazonActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    sget-object v6, Lcom/amazon/mShop/history/HistoryContentProvider;->VISUAL_SEARCH_URI:Landroid/net/Uri;

    const-string/jumbo v7, "original_scanned_history=? AND email=?"

    const/4 v4, 0x2

    new-array v8, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getOriginalScannedOutput()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v4

    const/4 v9, 0x1

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v4

    :goto_0
    aput-object v4, v8, v9

    invoke-virtual {v5, v6, v3, v7, v8}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 69
    invoke-virtual {p1, v1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->updateOriginalScannedOutput(Ljava/lang/String;)V

    .line 78
    .end local v1    # "latestScannedOutput":Ljava/lang/String;
    .end local v2    # "seriesAsinString":Ljava/lang/String;
    .end local v3    # "values":Landroid/content/ContentValues;
    :cond_0
    :goto_1
    return-void

    .line 63
    .restart local v1    # "latestScannedOutput":Ljava/lang/String;
    .restart local v2    # "seriesAsinString":Ljava/lang/String;
    .restart local v3    # "values":Landroid/content/ContentValues;
    :cond_1
    const-string/jumbo v4, ""

    goto :goto_0

    .line 72
    .end local v3    # "values":Landroid/content/ContentValues;
    :cond_2
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->delete(Lcom/amazon/mShop/search/viewit/ResultWrapper;)V
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 74
    .end local v1    # "latestScannedOutput":Ljava/lang/String;
    .end local v2    # "seriesAsinString":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 75
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    const-string/jumbo v4, "ViewItDBHelper"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Error update ViewItSearchResultWrapper object to DB:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method
