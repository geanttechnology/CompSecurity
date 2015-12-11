.class Lcom/espn/androidplayersdk/datamanager/TopSportParser;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "TopSportParser.java"


# instance fields
.field sendPartialErrorBroadcast:Z

.field sendSuccessBroadcast:Z


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 22
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;-><init>()V

    .line 24
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendSuccessBroadcast:Z

    .line 25
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendPartialErrorBroadcast:Z

    .line 22
    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 1
    .param p1, "errorCode"    # I

    .prologue
    .line 138
    const/4 v0, 0x2

    if-ne p1, v0, :cond_0

    .line 139
    const-string v0, "com.espn.action.SPORT_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendBroadcast(Ljava/lang/String;)V

    .line 140
    :cond_0
    return-void
.end method

.method public parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 17
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
    .line 30
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v11, "TopSportParser"

    const/4 v12, 0x3

    const/4 v13, 0x0

    invoke-static {v11, v12, v13}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 33
    :try_start_0
    sget-object v11, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v12, "sport"

    const-string v13, "sportMetaSportRelation= ?"

    .line 34
    const/4 v14, 0x1

    new-array v14, v14, [Ljava/lang/String;

    const/4 v15, 0x0

    const-string v16, "102"

    aput-object v16, v14, v15

    .line 33
    invoke-virtual {v11, v12, v13, v14}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 36
    const-string v11, "categories"

    move-object/from16 v0, p1

    invoke-virtual {v0, v11}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    .line 37
    .local v6, "sportsCategoriesArray":Lorg/json/JSONArray;
    new-instance v8, Landroid/content/ContentValues;

    invoke-direct {v8}, Landroid/content/ContentValues;-><init>()V

    .line 39
    .local v8, "sportsValues":Landroid/content/ContentValues;
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v9

    .line 41
    .local v9, "sportslArrayLength":I
    if-lez v9, :cond_1

    .line 42
    const/4 v11, 0x1

    move-object/from16 v0, p0

    iput-boolean v11, v0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendSuccessBroadcast:Z

    .line 44
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-lt v3, v9, :cond_3

    .line 101
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 103
    .local v5, "metaValues":Landroid/content/ContentValues;
    if-eqz p2, :cond_0

    const-string v11, "ttl"

    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v11

    if-eqz v11, :cond_0

    .line 105
    :try_start_1
    const-string v12, "TTL"

    const-string v11, "ttl"

    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    invoke-static {v11}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v11

    invoke-static {v11}, Lcom/espn/androidplayersdk/utilities/Utils;->getExpiryTime(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v5, v12, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 112
    :cond_0
    :goto_1
    :try_start_2
    const-string v11, "omniture"

    move-object/from16 v0, p1

    invoke-virtual {v0, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_d

    const-string v11, "omniture"

    move-object/from16 v0, p1

    invoke-virtual {v0, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_d

    .line 113
    const-string v11, "omnitureJason"

    const-string v12, "omniture"

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v12

    invoke-virtual {v12}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v5, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    :goto_2
    const-string v11, "sportrelationId"

    const-string v12, "102"

    invoke-virtual {v5, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    sget-object v11, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v11, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertOrUpdateMetaSportTable(Landroid/content/ContentValues;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 128
    .end local v3    # "i":I
    .end local v5    # "metaValues":Landroid/content/ContentValues;
    :cond_1
    move-object/from16 v0, p0

    iget-boolean v11, v0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendSuccessBroadcast:Z

    if-eqz v11, :cond_10

    .line 129
    const-string v11, "com.espn.action.SPORT_UPDATED"

    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendBroadcast(Ljava/lang/String;)V

    .line 134
    .end local v6    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .end local v8    # "sportsValues":Landroid/content/ContentValues;
    .end local v9    # "sportslArrayLength":I
    :cond_2
    :goto_3
    return-void

    .line 46
    .restart local v3    # "i":I
    .restart local v6    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .restart local v8    # "sportsValues":Landroid/content/ContentValues;
    .restart local v9    # "sportslArrayLength":I
    :cond_3
    :try_start_3
    invoke-virtual {v6, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v7

    .line 47
    .local v7, "sportsObject":Lorg/json/JSONObject;
    invoke-virtual {v8}, Landroid/content/ContentValues;->clear()V

    .line 49
    const-string v11, "id"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_4

    const-string v11, "id"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_4

    .line 50
    const-string v11, "soprtId"

    const-string v12, "id"

    invoke-virtual {v7, v12}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    :cond_4
    const-string v11, "name"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_5

    const-string v11, "name"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_5

    .line 53
    const-string v11, "sportName"

    const-string v12, "name"

    invoke-virtual {v7, v12}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    :cond_5
    const-string v11, "abbreviation"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_6

    const-string v11, "abbreviation"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_6

    .line 56
    const-string v11, "sportAbbre"

    const-string v12, "abbreviation"

    invoke-virtual {v7, v12}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    :cond_6
    const-string v11, "leagueId"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_7

    const-string v11, "leagueId"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_7

    .line 59
    const-string v11, "sportLeagueId"

    const-string v12, "leagueId"

    invoke-virtual {v7, v12}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    :cond_7
    const-string v11, "shortName"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_8

    const-string v11, "shortName"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_8

    .line 62
    const-string v11, "sportShortName"

    const-string v12, "shortName"

    invoke-virtual {v7, v12}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    :cond_8
    const-string v11, "type"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_9

    const-string v11, "type"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_9

    .line 65
    const-string v11, "sportType"

    const-string v12, "type"

    invoke-virtual {v7, v12}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    :cond_9
    const-string v11, "links"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_a

    const-string v11, "links"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_a

    .line 68
    const-string v11, "links"

    invoke-virtual {v7, v11}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 69
    .local v4, "linksObj":Lorg/json/JSONObject;
    const-string v11, "api"

    invoke-virtual {v4, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_a

    const-string v11, "api"

    invoke-virtual {v4, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_a

    .line 70
    const-string v11, "api"

    invoke-virtual {v4, v11}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 71
    .local v1, "apiObj":Lorg/json/JSONObject;
    const-string v11, "video"

    invoke-virtual {v1, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_a

    const-string v11, "video"

    invoke-virtual {v1, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_a

    .line 72
    const-string v11, "video"

    invoke-virtual {v1, v11}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v10

    .line 73
    .local v10, "videoObj":Lorg/json/JSONObject;
    const-string v11, "href"

    invoke-virtual {v10, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_a

    const-string v11, "href"

    invoke-virtual {v10, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_a

    .line 74
    const-string v11, "sportVodUrl"

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "href"

    invoke-virtual {v10, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v13, "?"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    .end local v1    # "apiObj":Lorg/json/JSONObject;
    .end local v4    # "linksObj":Lorg/json/JSONObject;
    .end local v10    # "videoObj":Lorg/json/JSONObject;
    :cond_a
    const-string v11, "subcategory"

    const-string v12, "sportType"

    invoke-virtual {v8, v12}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_b

    .line 81
    const-string v11, "sportListingUrl"

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "/listings?subcategories="

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v13, "soprtId"

    invoke-virtual {v8, v13}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    .line 82
    const-string v13, "&"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 81
    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    const-string v11, "sportListingtop"

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "subcategories/"

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v13, "sportAbbre"

    invoke-virtual {v8, v13}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, "/listings/top?"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    :goto_4
    const-string v11, "sportMetaSportRelation"

    const-string v12, "102"

    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    sget-object v11, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v11, v8}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoSportsTable(Landroid/content/ContentValues;)V

    .line 44
    .end local v7    # "sportsObject":Lorg/json/JSONObject;
    :goto_5
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_0

    .line 86
    .restart local v7    # "sportsObject":Lorg/json/JSONObject;
    :cond_b
    const-string v11, "sportListingUrl"

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "/listings?categories="

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v13, "soprtId"

    invoke-virtual {v8, v13}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, "&"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    const-string v11, "sportListingtop"

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "categories/"

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v13, "sportAbbre"

    invoke-virtual {v8, v13}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, "/listings/top?"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v8, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_4

    .line 94
    .end local v7    # "sportsObject":Lorg/json/JSONObject;
    :catch_0
    move-exception v2

    .line 95
    .local v2, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v11, "TopSportParser"

    const/4 v12, 0x5

    invoke-static {v11, v12, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 96
    const/4 v11, 0x0

    move-object/from16 v0, p0

    iput-boolean v11, v0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendSuccessBroadcast:Z

    .line 97
    const/4 v11, 0x1

    move-object/from16 v0, p0

    iput-boolean v11, v0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendPartialErrorBroadcast:Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_5

    .line 120
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v3    # "i":I
    .end local v6    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .end local v8    # "sportsValues":Landroid/content/ContentValues;
    .end local v9    # "sportslArrayLength":I
    :catch_1
    move-exception v2

    .line 121
    .restart local v2    # "e":Ljava/lang/Exception;
    :try_start_5
    const-string v11, "TopSportParser"

    const/4 v12, 0x5

    invoke-static {v11, v12, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 122
    const/4 v11, 0x0

    move-object/from16 v0, p0

    iput-boolean v11, v0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendSuccessBroadcast:Z

    .line 123
    const/4 v11, 0x0

    move-object/from16 v0, p0

    iput-boolean v11, v0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendPartialErrorBroadcast:Z

    .line 124
    const/4 v11, 0x2

    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->errorHandler(I)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 128
    move-object/from16 v0, p0

    iget-boolean v11, v0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendSuccessBroadcast:Z

    if-eqz v11, :cond_e

    .line 129
    const-string v11, "com.espn.action.SPORT_UPDATED"

    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 106
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v3    # "i":I
    .restart local v5    # "metaValues":Landroid/content/ContentValues;
    .restart local v6    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .restart local v8    # "sportsValues":Landroid/content/ContentValues;
    .restart local v9    # "sportslArrayLength":I
    :catch_2
    move-exception v2

    .line 107
    .restart local v2    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v11, "TopSportParser"

    const/4 v12, 0x5

    invoke-static {v11, v12, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 108
    const-string v11, "TTL"

    const-string v12, ""

    invoke-virtual {v5, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_1

    .line 127
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v3    # "i":I
    .end local v5    # "metaValues":Landroid/content/ContentValues;
    .end local v6    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .end local v8    # "sportsValues":Landroid/content/ContentValues;
    .end local v9    # "sportslArrayLength":I
    :catchall_0
    move-exception v11

    .line 128
    move-object/from16 v0, p0

    iget-boolean v12, v0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendSuccessBroadcast:Z

    if-eqz v12, :cond_f

    .line 129
    const-string v12, "com.espn.action.SPORT_UPDATED"

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendBroadcast(Ljava/lang/String;)V

    .line 132
    :cond_c
    :goto_6
    throw v11

    .line 115
    .restart local v3    # "i":I
    .restart local v5    # "metaValues":Landroid/content/ContentValues;
    .restart local v6    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .restart local v8    # "sportsValues":Landroid/content/ContentValues;
    .restart local v9    # "sportslArrayLength":I
    :cond_d
    :try_start_7
    const-string v11, "omnitureJason"

    const-string v12, ""

    invoke-virtual {v5, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_2

    .line 130
    .end local v3    # "i":I
    .end local v5    # "metaValues":Landroid/content/ContentValues;
    .end local v6    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .end local v8    # "sportsValues":Landroid/content/ContentValues;
    .end local v9    # "sportslArrayLength":I
    .restart local v2    # "e":Ljava/lang/Exception;
    :cond_e
    move-object/from16 v0, p0

    iget-boolean v11, v0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendPartialErrorBroadcast:Z

    if-eqz v11, :cond_2

    .line 131
    const-string v11, "com.espn.action.SPORT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 130
    .end local v2    # "e":Ljava/lang/Exception;
    :cond_f
    move-object/from16 v0, p0

    iget-boolean v12, v0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendPartialErrorBroadcast:Z

    if-eqz v12, :cond_c

    .line 131
    const-string v12, "com.espn.action.SPORT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_6

    .line 130
    .restart local v6    # "sportsCategoriesArray":Lorg/json/JSONArray;
    .restart local v8    # "sportsValues":Landroid/content/ContentValues;
    .restart local v9    # "sportslArrayLength":I
    :cond_10
    move-object/from16 v0, p0

    iget-boolean v11, v0, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendPartialErrorBroadcast:Z

    if-eqz v11, :cond_2

    .line 131
    const-string v11, "com.espn.action.SPORT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lcom/espn/androidplayersdk/datamanager/TopSportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3
.end method
