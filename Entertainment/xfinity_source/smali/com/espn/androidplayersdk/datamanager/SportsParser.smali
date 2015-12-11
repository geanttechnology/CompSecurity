.class Lcom/espn/androidplayersdk/datamanager/SportsParser;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "SportsParser.java"


# instance fields
.field sendPartialErrorBroadcast:Z

.field sendSuccessBroadcast:Z


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 21
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;-><init>()V

    .line 23
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendSuccessBroadcast:Z

    .line 24
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendPartialErrorBroadcast:Z

    .line 21
    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 1
    .param p1, "errorCode"    # I

    .prologue
    .line 104
    const/4 v0, 0x2

    if-ne p1, v0, :cond_0

    .line 105
    const-string v0, "com.espn.action.SPORT_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 106
    :cond_0
    return-void
.end method

.method public parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 13
    .param p1, "object"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 29
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v7, "SportsParser"

    const/4 v8, 0x3

    const/4 v9, 0x0

    invoke-static {v7, v8, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 32
    :try_start_0
    sget-object v7, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v8, "sport"

    const-string v9, "sportMetaSportRelation= ?"

    .line 33
    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    const-string v12, "101"

    aput-object v12, v10, v11

    .line 32
    invoke-virtual {v7, v8, v9, v10}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 35
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 36
    .local v5, "sportsValues":Landroid/content/ContentValues;
    const-string v7, "categories"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 38
    .local v3, "sportsCategoriesArray":Lorg/json/JSONArray;
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v6

    .line 40
    .local v6, "sportslArrayLength":I
    if-lez v6, :cond_1

    .line 41
    const/4 v7, 0x1

    iput-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendSuccessBroadcast:Z

    .line 43
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-lt v1, v6, :cond_3

    .line 67
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 69
    .local v2, "metaValues":Landroid/content/ContentValues;
    if-eqz p2, :cond_0

    const-string v7, "ttl"

    invoke-virtual {p2, v7}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v7

    if-eqz v7, :cond_0

    .line 71
    :try_start_1
    const-string v8, "TTL"

    const-string v7, "ttl"

    invoke-virtual {p2, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-static {v7}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v7

    invoke-static {v7}, Lcom/espn/androidplayersdk/utilities/Utils;->getExpiryTime(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v8, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 78
    :cond_0
    :goto_1
    :try_start_2
    const-string v7, "omniture"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_8

    const-string v7, "omniture"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_8

    .line 79
    const-string v7, "omnitureJason"

    const-string v8, "omniture"

    invoke-virtual {p1, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    invoke-virtual {v8}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    :goto_2
    const-string v7, "sportrelationId"

    const-string v8, "101"

    invoke-virtual {v2, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    sget-object v7, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v7, v2}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertOrUpdateMetaSportTable(Landroid/content/ContentValues;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 94
    .end local v1    # "i":I
    .end local v2    # "metaValues":Landroid/content/ContentValues;
    :cond_1
    iget-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendSuccessBroadcast:Z

    if-eqz v7, :cond_b

    .line 95
    const-string v7, "com.espn.action.SPORT_UPDATED"

    invoke-virtual {p0, v7}, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 100
    .end local v3    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .end local v5    # "sportsValues":Landroid/content/ContentValues;
    .end local v6    # "sportslArrayLength":I
    :cond_2
    :goto_3
    return-void

    .line 45
    .restart local v1    # "i":I
    .restart local v3    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .restart local v5    # "sportsValues":Landroid/content/ContentValues;
    .restart local v6    # "sportslArrayLength":I
    :cond_3
    :try_start_3
    invoke-virtual {v5}, Landroid/content/ContentValues;->clear()V

    .line 46
    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 47
    .local v4, "sportsObject":Lorg/json/JSONObject;
    const-string v7, "id"

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_4

    const-string v7, "id"

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_4

    .line 48
    const-string v7, "soprtId"

    const-string v8, "id"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    :cond_4
    const-string v7, "name"

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_5

    const-string v7, "name"

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_5

    .line 51
    const-string v7, "sportName"

    const-string v8, "name"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    :cond_5
    const-string v7, "abbreviation"

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_6

    const-string v7, "abbreviation"

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_6

    .line 54
    const-string v7, "sportAbbre"

    const-string v8, "abbreviation"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    :cond_6
    const-string v7, "sportMetaSportRelation"

    const-string v8, "101"

    invoke-virtual {v5, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    sget-object v7, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v7, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoSportsTable(Landroid/content/ContentValues;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 43
    .end local v4    # "sportsObject":Lorg/json/JSONObject;
    :goto_4
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_0

    .line 60
    :catch_0
    move-exception v0

    .line 61
    .local v0, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v7, "SportsParser"

    const/4 v8, 0x5

    invoke-static {v7, v8, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 62
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendSuccessBroadcast:Z

    .line 63
    const/4 v7, 0x1

    iput-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendPartialErrorBroadcast:Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_4

    .line 86
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "i":I
    .end local v3    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .end local v5    # "sportsValues":Landroid/content/ContentValues;
    .end local v6    # "sportslArrayLength":I
    :catch_1
    move-exception v0

    .line 87
    .restart local v0    # "e":Ljava/lang/Exception;
    :try_start_5
    const-string v7, "SportsParser"

    const/4 v8, 0x5

    invoke-static {v7, v8, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 88
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendSuccessBroadcast:Z

    .line 89
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendPartialErrorBroadcast:Z

    .line 90
    const/4 v7, 0x2

    invoke-virtual {p0, v7}, Lcom/espn/androidplayersdk/datamanager/SportsParser;->errorHandler(I)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 94
    iget-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendSuccessBroadcast:Z

    if-eqz v7, :cond_9

    .line 95
    const-string v7, "com.espn.action.SPORT_UPDATED"

    invoke-virtual {p0, v7}, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 72
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "i":I
    .restart local v2    # "metaValues":Landroid/content/ContentValues;
    .restart local v3    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .restart local v5    # "sportsValues":Landroid/content/ContentValues;
    .restart local v6    # "sportslArrayLength":I
    :catch_2
    move-exception v0

    .line 73
    .restart local v0    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v7, "SportsParser"

    const/4 v8, 0x5

    invoke-static {v7, v8, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 74
    const-string v7, "TTL"

    const-string v8, ""

    invoke-virtual {v2, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_1

    .line 93
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "i":I
    .end local v2    # "metaValues":Landroid/content/ContentValues;
    .end local v3    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .end local v5    # "sportsValues":Landroid/content/ContentValues;
    .end local v6    # "sportslArrayLength":I
    :catchall_0
    move-exception v7

    .line 94
    iget-boolean v8, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendSuccessBroadcast:Z

    if-eqz v8, :cond_a

    .line 95
    const-string v8, "com.espn.action.SPORT_UPDATED"

    invoke-virtual {p0, v8}, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 98
    :cond_7
    :goto_5
    throw v7

    .line 81
    .restart local v1    # "i":I
    .restart local v2    # "metaValues":Landroid/content/ContentValues;
    .restart local v3    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .restart local v5    # "sportsValues":Landroid/content/ContentValues;
    .restart local v6    # "sportslArrayLength":I
    :cond_8
    :try_start_7
    const-string v7, "omnitureJason"

    const-string v8, ""

    invoke-virtual {v2, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_2

    .line 96
    .end local v1    # "i":I
    .end local v2    # "metaValues":Landroid/content/ContentValues;
    .end local v3    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .end local v5    # "sportsValues":Landroid/content/ContentValues;
    .end local v6    # "sportslArrayLength":I
    .restart local v0    # "e":Ljava/lang/Exception;
    :cond_9
    iget-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendPartialErrorBroadcast:Z

    if-eqz v7, :cond_2

    .line 97
    const-string v7, "com.espn.action.SPORT_PARTIAL_DATA_ERROR"

    invoke-virtual {p0, v7}, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 96
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_a
    iget-boolean v8, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendPartialErrorBroadcast:Z

    if-eqz v8, :cond_7

    .line 97
    const-string v8, "com.espn.action.SPORT_PARTIAL_DATA_ERROR"

    invoke-virtual {p0, v8}, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_5

    .line 96
    .restart local v3    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .restart local v5    # "sportsValues":Landroid/content/ContentValues;
    .restart local v6    # "sportslArrayLength":I
    :cond_b
    iget-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendPartialErrorBroadcast:Z

    if-eqz v7, :cond_2

    .line 97
    const-string v7, "com.espn.action.SPORT_PARTIAL_DATA_ERROR"

    invoke-virtual {p0, v7}, Lcom/espn/androidplayersdk/datamanager/SportsParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3
.end method
