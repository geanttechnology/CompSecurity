.class Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "LiveEventsParser.java"


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
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendSuccessBroadcast:Z

    .line 24
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendPartialErrorBroadcast:Z

    .line 21
    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 1
    .param p1, "errorCode"    # I

    .prologue
    .line 249
    const/4 v0, 0x2

    if-ne p1, v0, :cond_0

    .line 250
    const-string v0, "com.espn.action.LIVE_EVENT_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 251
    :cond_0
    return-void
.end method

.method public parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 33
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
    .line 28
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v29, "LiveEventsParser"

    const/16 v30, 0x3

    const/16 v31, 0x0

    invoke-static/range {v29 .. v31}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 31
    :try_start_0
    new-instance v18, Landroid/content/ContentValues;

    invoke-direct/range {v18 .. v18}, Landroid/content/ContentValues;-><init>()V

    .line 32
    .local v18, "liveEventValues":Landroid/content/ContentValues;
    new-instance v22, Landroid/content/ContentValues;

    invoke-direct/range {v22 .. v22}, Landroid/content/ContentValues;-><init>()V

    .line 34
    .local v22, "metaValues":Landroid/content/ContentValues;
    const-string v29, "eventWhere"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_0

    const-string v29, "eventWhereArg"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_0

    .line 36
    sget-object v31, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v32, "events"

    const-string v29, "eventWhere"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Ljava/lang/String;

    .line 37
    const-string v30, "eventWhereArg"

    move-object/from16 v0, p2

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v30

    check-cast v30, [Ljava/lang/String;

    .line 36
    move-object/from16 v0, v31

    move-object/from16 v1, v32

    move-object/from16 v2, v29

    move-object/from16 v3, v30

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 39
    :cond_0
    const-string v29, "listings"

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v17

    .line 41
    .local v17, "listingsArray":Lorg/json/JSONArray;
    invoke-virtual/range {v17 .. v17}, Lorg/json/JSONArray;->length()I

    move-result v16

    .line 43
    .local v16, "listingArrayLength":I
    if-lez v16, :cond_4

    .line 44
    const/16 v29, 0x1

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendSuccessBroadcast:Z

    .line 47
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_0
    move/from16 v0, v16

    if-lt v12, v0, :cond_6

    .line 212
    if-eqz p2, :cond_1

    const-string v29, "ttl"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v29

    if-eqz v29, :cond_1

    .line 214
    :try_start_1
    const-string v30, "ttl"

    const-string v29, "ttl"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Ljava/lang/String;

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v29

    invoke-static/range {v29 .. v29}, Lcom/espn/androidplayersdk/utilities/Utils;->getExpiryTime(I)Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v22

    move-object/from16 v1, v30

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 220
    :cond_1
    :goto_1
    :try_start_2
    const-string v29, "eventsType"

    const-string v30, "live"

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 222
    const-string v29, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_2

    const-string v29, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_2

    .line 223
    const-string v29, "omnitureJson"

    const-string v30, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    :cond_2
    const-string v29, "resultsLimit"

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_3

    const-string v29, "resultsLimit"

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_3

    .line 226
    const-string v29, "count"

    const-string v30, "resultsLimit"

    move-object/from16 v0, p1

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 228
    :cond_3
    const-string v29, "eventRelationId"

    const-string v30, "1"

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 231
    sget-object v29, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    move-object/from16 v0, v29

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertOrUpdateMetaEventsTable(Landroid/content/ContentValues;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 239
    .end local v12    # "i":I
    :cond_4
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendSuccessBroadcast:Z

    move/from16 v29, v0

    if-eqz v29, :cond_28

    .line 240
    const-string v29, "com.espn.action.LIVE_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 245
    .end local v16    # "listingArrayLength":I
    .end local v17    # "listingsArray":Lorg/json/JSONArray;
    .end local v18    # "liveEventValues":Landroid/content/ContentValues;
    .end local v22    # "metaValues":Landroid/content/ContentValues;
    :cond_5
    :goto_2
    return-void

    .line 50
    .restart local v12    # "i":I
    .restart local v16    # "listingArrayLength":I
    .restart local v17    # "listingsArray":Lorg/json/JSONArray;
    .restart local v18    # "liveEventValues":Landroid/content/ContentValues;
    .restart local v22    # "metaValues":Landroid/content/ContentValues;
    :cond_6
    :try_start_3
    invoke-virtual/range {v18 .. v18}, Landroid/content/ContentValues;->clear()V

    .line 51
    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v10

    .line 53
    .local v10, "eventsObject":Lorg/json/JSONObject;
    const-string v29, "broadcastStartTime"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_7

    const-string v29, "broadcastStartTime"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_7

    .line 54
    const-string v29, "broadcastStartTime"

    const-string v30, "broadcastStartTime"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    :cond_7
    const-string v29, "description"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_8

    const-string v29, "description"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_8

    .line 57
    const-string v29, "description"

    const-string v30, "description"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    :cond_8
    const-string v29, "blackouts"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_9

    const-string v29, "blackouts"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_9

    .line 60
    const-string v29, "blackoutsJason"

    const-string v30, "blackouts"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    :cond_9
    const-string v29, "categories"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_b

    const-string v29, "categories"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_b

    .line 63
    const-string v29, "categories"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    .line 64
    .local v6, "categoryArray":Lorg/json/JSONArray;
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v29

    if-lez v29, :cond_b

    .line 65
    const/16 v29, 0x0

    move/from16 v0, v29

    invoke-virtual {v6, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v7

    .line 66
    .local v7, "categoryObj":Lorg/json/JSONObject;
    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_a

    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_a

    .line 67
    const-string v29, "SPORT"

    const-string v30, "name"

    move-object/from16 v0, v30

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    :cond_a
    const-string v29, "abbreviation"

    move-object/from16 v0, v29

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_b

    const-string v29, "abbreviation"

    move-object/from16 v0, v29

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_b

    .line 69
    const-string v29, "sportCode"

    const-string v30, "abbreviation"

    move-object/from16 v0, v30

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    .end local v6    # "categoryArray":Lorg/json/JSONArray;
    .end local v7    # "categoryObj":Lorg/json/JSONObject;
    :cond_b
    const-string v29, "program"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_c

    const-string v29, "program"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_c

    .line 74
    const-string v29, "program"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v24

    .line 75
    .local v24, "programObj":Lorg/json/JSONObject;
    const-string v29, "code"

    move-object/from16 v0, v24

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_c

    const-string v29, "code"

    move-object/from16 v0, v24

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_c

    .line 76
    const-string v29, "programingCode"

    const-string v30, "code"

    move-object/from16 v0, v24

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    .end local v24    # "programObj":Lorg/json/JSONObject;
    :cond_c
    const-string v29, "type"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_d

    const-string v29, "type"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_d

    .line 79
    const-string v29, "eventType"

    const-string v30, "type"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    :cond_d
    const-string v29, "endTime"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_e

    const-string v29, "endTime"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_e

    .line 82
    const-string v29, "endTime"

    const-string v30, "endTime"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    :cond_e
    const-string v29, "subcategories"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_10

    const-string v29, "subcategories"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_10

    .line 85
    const-string v29, "subcategories"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v27

    .line 86
    .local v27, "subCatArray":Lorg/json/JSONArray;
    invoke-virtual/range {v27 .. v27}, Lorg/json/JSONArray;->length()I

    move-result v29

    if-lez v29, :cond_10

    .line 87
    const/16 v29, 0x0

    move-object/from16 v0, v27

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v28

    .line 88
    .local v28, "subCatObj":Lorg/json/JSONObject;
    const-string v29, "id"

    invoke-virtual/range {v28 .. v29}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_f

    const-string v29, "id"

    invoke-virtual/range {v28 .. v29}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_f

    .line 89
    const-string v29, "league"

    const-string v30, "id"

    move-object/from16 v0, v28

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    :cond_f
    const-string v29, "name"

    invoke-virtual/range {v28 .. v29}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_10

    const-string v29, "name"

    invoke-virtual/range {v28 .. v29}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_10

    .line 91
    const-string v29, "leagueName"

    const-string v30, "name"

    move-object/from16 v0, v28

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    .end local v27    # "subCatArray":Lorg/json/JSONArray;
    .end local v28    # "subCatObj":Lorg/json/JSONObject;
    :cond_10
    const-string v29, "broadcasts"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_14

    const-string v29, "broadcasts"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_14

    .line 96
    const-string v29, "broadcasts"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 97
    .local v4, "broadcastArray":Lorg/json/JSONArray;
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v29

    if-lez v29, :cond_14

    .line 98
    const/16 v29, 0x0

    move/from16 v0, v29

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 99
    .local v5, "broadcastObj":Lorg/json/JSONObject;
    const-string v29, "abbreviation"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_11

    const-string v29, "abbreviation"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_11

    .line 100
    const-string v29, "networkCode"

    const-string v30, "abbreviation"

    move-object/from16 v0, v30

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    :cond_11
    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_12

    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_12

    .line 102
    const-string v29, "networkName"

    const-string v30, "name"

    move-object/from16 v0, v30

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    :cond_12
    const-string v29, "ncsId"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_13

    const-string v29, "ncsId"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_13

    .line 104
    const-string v29, "networkId"

    const-string v30, "ncsId"

    move-object/from16 v0, v30

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    const-string v29, "networkId"

    const-string v30, "ncsId"

    move-object/from16 v0, v30

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    :cond_13
    const-string v29, "adobeResource"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_14

    const-string v29, "adobeResource"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_14

    .line 108
    const-string v29, "networkResourceId"

    const-string v30, "adobeResource"

    move-object/from16 v0, v30

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    .end local v4    # "broadcastArray":Lorg/json/JSONArray;
    .end local v5    # "broadcastObj":Lorg/json/JSONObject;
    :cond_14
    const-string v29, "guid"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_15

    const-string v29, "guid"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_15

    .line 114
    const-string v29, "guid"

    const-string v30, "guid"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    :cond_15
    const-string v29, "startTime"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_16

    const-string v29, "startTime"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_16

    .line 117
    const-string v29, "startTime"

    const-string v30, "startTime"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    :cond_16
    const-string v29, "id"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_17

    const-string v29, "id"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_17

    .line 120
    const-string v29, "eventId"

    const-string v30, "id"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    :cond_17
    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_18

    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_18

    .line 123
    const-string v29, "showName"

    const-string v30, "name"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    :cond_18
    const-string v29, "simulcastAiringId"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_19

    const-string v29, "simulcastAiringId"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_19

    .line 126
    const-string v29, "simulcastAiringId"

    const-string v30, "simulcastAiringId"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    :cond_19
    const-string v29, "seekInSeconds"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1a

    const-string v29, "seekInSeconds"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1a

    .line 129
    const-string v29, "seekInSeconds"

    const-string v30, "seekInSeconds"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    :cond_1a
    const-string v29, "parentalRating"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1b

    const-string v29, "parentalRating"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1b

    .line 132
    const-string v29, "parentalRating"

    const-string v30, "parentalRating"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    :cond_1b
    const-string v29, "omniture"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1c

    const-string v29, "omniture"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1c

    .line 135
    const-string v29, "omnitureJson"

    const-string v30, "omniture"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    :cond_1c
    const-string v29, "thumbnails"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1f

    const-string v29, "thumbnails"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1f

    .line 138
    const-string v29, "thumbnails"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v13

    .line 140
    .local v13, "imageObj":Lorg/json/JSONObject;
    const-string v29, "small"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1d

    const-string v29, "small"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1d

    .line 141
    const-string v29, "small"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v25

    .line 142
    .local v25, "small":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v25

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1d

    const-string v29, "href"

    move-object/from16 v0, v25

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1d

    .line 143
    const-string v29, "imageSmall"

    const-string v30, "href"

    move-object/from16 v0, v25

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    .end local v25    # "small":Lorg/json/JSONObject;
    :cond_1d
    const-string v29, "medium"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1e

    const-string v29, "medium"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1e

    .line 147
    const-string v29, "medium"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v21

    .line 148
    .local v21, "med":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1e

    const-string v29, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1e

    .line 149
    const-string v29, "imageMed"

    const-string v30, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    .end local v21    # "med":Lorg/json/JSONObject;
    :cond_1e
    const-string v29, "large"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1f

    const-string v29, "large"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1f

    .line 153
    const-string v29, "large"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v14

    .line 154
    .local v14, "large":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v29

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1f

    const-string v29, "href"

    move-object/from16 v0, v29

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1f

    .line 155
    const-string v29, "imageLarge"

    const-string v30, "href"

    move-object/from16 v0, v30

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    .end local v13    # "imageObj":Lorg/json/JSONObject;
    .end local v14    # "large":Lorg/json/JSONObject;
    :cond_1f
    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_20

    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_20

    .line 160
    const-string v29, "eventName"

    const-string v30, "name"

    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    :cond_20
    const-string v29, "links"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_24

    const-string v29, "links"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_24

    .line 163
    const-string v29, "links"

    move-object/from16 v0, v29

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v15

    .line 164
    .local v15, "linksObj":Lorg/json/JSONObject;
    const-string v29, "source"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_24

    const-string v29, "source"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_24

    .line 165
    const-string v29, "source"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v26

    .line 166
    .local v26, "sourceObj":Lorg/json/JSONObject;
    const-string v29, "hls"

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_24

    const-string v29, "hls"

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_24

    .line 167
    const-string v29, "hls"

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    .line 169
    .local v11, "hlsObj":Lorg/json/JSONObject;
    const-string v29, "default"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_21

    const-string v29, "default"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_21

    .line 170
    const-string v29, "default"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    .line 171
    .local v8, "dfltObj":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v29

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_21

    const-string v29, "href"

    move-object/from16 v0, v29

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_21

    .line 172
    const-string v29, "videoURLDefault"

    const-string v30, "href"

    move-object/from16 v0, v30

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    .end local v8    # "dfltObj":Lorg/json/JSONObject;
    :cond_21
    const-string v29, "high"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_22

    const-string v29, "high"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_22

    .line 177
    const-string v29, "high"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v20

    .line 178
    .local v20, "lrgObj":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_22

    const-string v29, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_22

    .line 179
    const-string v29, "videoURLLarge"

    const-string v30, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 183
    .end local v20    # "lrgObj":Lorg/json/JSONObject;
    :cond_22
    const-string v29, "mid"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_23

    const-string v29, "mid"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_23

    .line 184
    const-string v29, "mid"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v23

    .line 185
    .local v23, "midObj":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v23

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_23

    const-string v29, "href"

    move-object/from16 v0, v23

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_23

    .line 186
    const-string v29, "videoURLMed"

    const-string v30, "href"

    move-object/from16 v0, v23

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    .end local v23    # "midObj":Lorg/json/JSONObject;
    :cond_23
    const-string v29, "low"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_24

    const-string v29, "low"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_24

    .line 191
    const-string v29, "low"

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v19

    .line 192
    .local v19, "lowObj":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v19

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_24

    const-string v29, "href"

    move-object/from16 v0, v19

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_24

    .line 194
    const-string v29, "videoURLSmall"

    const-string v30, "href"

    move-object/from16 v0, v19

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 200
    .end local v11    # "hlsObj":Lorg/json/JSONObject;
    .end local v15    # "linksObj":Lorg/json/JSONObject;
    .end local v19    # "lowObj":Lorg/json/JSONObject;
    .end local v26    # "sourceObj":Lorg/json/JSONObject;
    :cond_24
    const-string v29, "metaEventRelationId"

    const-string v30, "1"

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    const-string v29, "sportId"

    const-string v30, ""

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    sget-object v29, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    move-object/from16 v0, v29

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoEventsTable(Landroid/content/ContentValues;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 47
    .end local v10    # "eventsObject":Lorg/json/JSONObject;
    :goto_3
    add-int/lit8 v12, v12, 0x1

    goto/16 :goto_0

    .line 205
    :catch_0
    move-exception v9

    .line 206
    .local v9, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v29, "LiveEventsParser"

    const/16 v30, 0x5

    move-object/from16 v0, v29

    move/from16 v1, v30

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 207
    const/16 v29, 0x0

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendSuccessBroadcast:Z

    .line 208
    const/16 v29, 0x1

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendPartialErrorBroadcast:Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_3

    .line 233
    .end local v9    # "e":Ljava/lang/Exception;
    .end local v12    # "i":I
    .end local v16    # "listingArrayLength":I
    .end local v17    # "listingsArray":Lorg/json/JSONArray;
    .end local v18    # "liveEventValues":Landroid/content/ContentValues;
    .end local v22    # "metaValues":Landroid/content/ContentValues;
    :catch_1
    move-exception v9

    .line 234
    .restart local v9    # "e":Ljava/lang/Exception;
    :try_start_5
    const-string v29, "LiveEventsParser"

    const/16 v30, 0x5

    move-object/from16 v0, v29

    move/from16 v1, v30

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 235
    const/16 v29, 0x0

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendSuccessBroadcast:Z

    .line 236
    const/16 v29, 0x0

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendPartialErrorBroadcast:Z

    .line 237
    const/16 v29, 0x2

    move-object/from16 v0, p0

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->errorHandler(I)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 239
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendSuccessBroadcast:Z

    move/from16 v29, v0

    if-eqz v29, :cond_26

    .line 240
    const-string v29, "com.espn.action.LIVE_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 215
    .end local v9    # "e":Ljava/lang/Exception;
    .restart local v12    # "i":I
    .restart local v16    # "listingArrayLength":I
    .restart local v17    # "listingsArray":Lorg/json/JSONArray;
    .restart local v18    # "liveEventValues":Landroid/content/ContentValues;
    .restart local v22    # "metaValues":Landroid/content/ContentValues;
    :catch_2
    move-exception v9

    .line 216
    .restart local v9    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v29, "LiveEventsParser"

    const/16 v30, 0x5

    move-object/from16 v0, v29

    move/from16 v1, v30

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 217
    const-string v29, "ttl"

    const-string v30, ""

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_1

    .line 238
    .end local v9    # "e":Ljava/lang/Exception;
    .end local v12    # "i":I
    .end local v16    # "listingArrayLength":I
    .end local v17    # "listingsArray":Lorg/json/JSONArray;
    .end local v18    # "liveEventValues":Landroid/content/ContentValues;
    .end local v22    # "metaValues":Landroid/content/ContentValues;
    :catchall_0
    move-exception v29

    .line 239
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendSuccessBroadcast:Z

    move/from16 v30, v0

    if-eqz v30, :cond_27

    .line 240
    const-string v30, "com.espn.action.LIVE_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 243
    :cond_25
    :goto_4
    throw v29

    .line 241
    .restart local v9    # "e":Ljava/lang/Exception;
    :cond_26
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendPartialErrorBroadcast:Z

    move/from16 v29, v0

    if-eqz v29, :cond_5

    .line 242
    const-string v29, "com.espn.action.LIVE_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 241
    .end local v9    # "e":Ljava/lang/Exception;
    :cond_27
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendPartialErrorBroadcast:Z

    move/from16 v30, v0

    if-eqz v30, :cond_25

    .line 242
    const-string v30, "com.espn.action.LIVE_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_4

    .line 241
    .restart local v16    # "listingArrayLength":I
    .restart local v17    # "listingsArray":Lorg/json/JSONArray;
    .restart local v18    # "liveEventValues":Landroid/content/ContentValues;
    .restart local v22    # "metaValues":Landroid/content/ContentValues;
    :cond_28
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendPartialErrorBroadcast:Z

    move/from16 v29, v0

    if-eqz v29, :cond_5

    .line 242
    const-string v29, "com.espn.action.LIVE_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2
.end method
