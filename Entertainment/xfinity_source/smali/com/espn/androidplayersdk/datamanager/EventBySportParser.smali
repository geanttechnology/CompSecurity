.class Lcom/espn/androidplayersdk/datamanager/EventBySportParser;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "EventBySportParser.java"


# instance fields
.field contentType:Ljava/lang/String;

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
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendSuccessBroadcast:Z

    .line 25
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendPartialErrorBroadcast:Z

    .line 26
    const-string v0, ""

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 2
    .param p1, "errorCode"    # I

    .prologue
    .line 276
    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    const/4 v0, 0x2

    if-ne p1, v0, :cond_1

    .line 277
    :cond_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 278
    const-string v0, "com.espn.action.EVENTSBYSPORT_LIVE_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    .line 284
    :cond_1
    :goto_0
    return-void

    .line 279
    :cond_2
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 280
    const-string v0, "com.espn.action.EVENTSBYSPORT_UPCOMING_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_0

    .line 281
    :cond_3
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 282
    const-string v0, "com.espn.action.EVENTSBYSPORT_REPLAY_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_0
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
    .line 30
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v29, "EventBySportParser:"

    const/16 v30, 0x3

    const/16 v31, 0x0

    invoke-static/range {v29 .. v31}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 33
    :try_start_0
    new-instance v11, Landroid/content/ContentValues;

    invoke-direct {v11}, Landroid/content/ContentValues;-><init>()V

    .line 34
    .local v11, "eventsBySportsValues":Landroid/content/ContentValues;
    new-instance v22, Landroid/content/ContentValues;

    invoke-direct/range {v22 .. v22}, Landroid/content/ContentValues;-><init>()V

    .line 36
    .local v22, "metaValues":Landroid/content/ContentValues;
    const-string v29, "eventType"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_0

    .line 37
    const-string v29, "eventType"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Ljava/lang/String;

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    .line 39
    :cond_0
    const-string v29, "eventWhere"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_1

    const-string v29, "eventWhereArg"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_1

    .line 41
    sget-object v31, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v32, "events"

    const-string v29, "eventWhere"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Ljava/lang/String;

    .line 42
    const-string v30, "eventWhereArg"

    move-object/from16 v0, p2

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v30

    check-cast v30, [Ljava/lang/String;

    .line 41
    move-object/from16 v0, v31

    move-object/from16 v1, v32

    move-object/from16 v2, v29

    move-object/from16 v3, v30

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 44
    :cond_1
    const-string v29, "listings"

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v18

    .line 45
    .local v18, "listingsArray":Lorg/json/JSONArray;
    invoke-virtual/range {v18 .. v18}, Lorg/json/JSONArray;->length()I

    move-result v10

    .line 47
    .local v10, "eventsArrayLength":I
    if-lez v10, :cond_6

    .line 48
    const/16 v29, 0x1

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendSuccessBroadcast:Z

    .line 50
    const/4 v14, 0x0

    .local v14, "i":I
    :goto_0
    if-lt v14, v10, :cond_8

    .line 220
    if-eqz p2, :cond_2

    const-string v29, "ttl"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v29

    if-eqz v29, :cond_2

    .line 222
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

    .line 229
    :cond_2
    :goto_1
    if-eqz p2, :cond_3

    :try_start_2
    const-string v29, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_3

    .line 230
    const-string v30, "sportId"

    const-string v29, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Ljava/lang/String;

    move-object/from16 v0, v22

    move-object/from16 v1, v30

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    :cond_3
    if-eqz p2, :cond_29

    const-string v29, "eventType"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_29

    .line 233
    const-string v30, "eventsType"

    const-string v29, "eventType"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Ljava/lang/String;

    move-object/from16 v0, v22

    move-object/from16 v1, v30

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 237
    :goto_2
    const-string v29, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_4

    const-string v29, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_4

    .line 238
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

    .line 240
    :cond_4
    const-string v29, "resultsCount"

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_5

    const-string v29, "resultsCount"

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_5

    .line 241
    const-string v29, "count"

    const-string v30, "resultsCount"

    move-object/from16 v0, p1

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 243
    :cond_5
    const-string v29, "eventRelationId"

    const-string v30, "4"

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    sget-object v29, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    move-object/from16 v0, v29

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertOrUpdateMetaEventsTable(Landroid/content/ContentValues;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 254
    .end local v14    # "i":I
    :cond_6
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendSuccessBroadcast:Z

    move/from16 v29, v0

    if-eqz v29, :cond_36

    .line 255
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_34

    .line 256
    const-string v29, "com.espn.action.EVENTSBYSPORT_LIVE_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    .line 272
    .end local v10    # "eventsArrayLength":I
    .end local v11    # "eventsBySportsValues":Landroid/content/ContentValues;
    .end local v18    # "listingsArray":Lorg/json/JSONArray;
    .end local v22    # "metaValues":Landroid/content/ContentValues;
    :cond_7
    :goto_3
    return-void

    .line 52
    .restart local v10    # "eventsArrayLength":I
    .restart local v11    # "eventsBySportsValues":Landroid/content/ContentValues;
    .restart local v14    # "i":I
    .restart local v18    # "listingsArray":Lorg/json/JSONArray;
    .restart local v22    # "metaValues":Landroid/content/ContentValues;
    :cond_8
    :try_start_3
    invoke-virtual {v11}, Landroid/content/ContentValues;->clear()V

    .line 53
    move-object/from16 v0, v18

    invoke-virtual {v0, v14}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v12

    .line 55
    .local v12, "eventsObject":Lorg/json/JSONObject;
    const-string v29, "broadcastStartTime"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_9

    const-string v29, "broadcastStartTime"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_9

    .line 56
    const-string v29, "broadcastStartTime"

    const-string v30, "broadcastStartTime"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    :cond_9
    const-string v29, "description"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_a

    const-string v29, "description"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_a

    .line 59
    const-string v29, "description"

    const-string v30, "description"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    :cond_a
    const-string v29, "blackouts"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_b

    const-string v29, "blackouts"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_b

    .line 62
    const-string v29, "coverageType"

    const-string v30, "blackouts"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    :cond_b
    const-string v29, "categories"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_d

    const-string v29, "categories"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_d

    .line 65
    const-string v29, "categories"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    .line 66
    .local v6, "categoryArray":Lorg/json/JSONArray;
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v29

    if-lez v29, :cond_d

    .line 67
    const/16 v29, 0x0

    move/from16 v0, v29

    invoke-virtual {v6, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v7

    .line 68
    .local v7, "categoryObj":Lorg/json/JSONObject;
    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_c

    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_c

    .line 69
    const-string v29, "SPORT"

    const-string v30, "name"

    move-object/from16 v0, v30

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    :cond_c
    const-string v29, "abbreviation"

    move-object/from16 v0, v29

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_d

    const-string v29, "abbreviation"

    move-object/from16 v0, v29

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_d

    .line 71
    const-string v29, "sportCode"

    const-string v30, "abbreviation"

    move-object/from16 v0, v30

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    .end local v6    # "categoryArray":Lorg/json/JSONArray;
    .end local v7    # "categoryObj":Lorg/json/JSONObject;
    :cond_d
    const-string v29, "program"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_e

    const-string v29, "program"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_e

    .line 76
    const-string v29, "program"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v24

    .line 77
    .local v24, "programObj":Lorg/json/JSONObject;
    const-string v29, "code"

    move-object/from16 v0, v24

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_e

    const-string v29, "code"

    move-object/from16 v0, v24

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_e

    .line 78
    const-string v29, "programingCode"

    const-string v30, "code"

    move-object/from16 v0, v24

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    .end local v24    # "programObj":Lorg/json/JSONObject;
    :cond_e
    const-string v29, "type"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_f

    const-string v29, "type"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_f

    .line 82
    const-string v29, "eventType"

    const-string v30, "type"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    :cond_f
    const-string v29, "endTime"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_10

    const-string v29, "endTime"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_10

    .line 85
    const-string v29, "endTime"

    const-string v30, "endTime"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    :cond_10
    const-string v29, "broadcasts"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_14

    const-string v29, "broadcasts"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_14

    .line 88
    const-string v29, "broadcasts"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 89
    .local v4, "broadcastArray":Lorg/json/JSONArray;
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v29

    if-lez v29, :cond_14

    .line 90
    const/16 v29, 0x0

    move/from16 v0, v29

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 91
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

    .line 92
    const-string v29, "networkCode"

    const-string v30, "abbreviation"

    move-object/from16 v0, v30

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 94
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

    .line 95
    const-string v29, "networkName"

    const-string v30, "name"

    move-object/from16 v0, v30

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
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

    .line 98
    const-string v29, "networkId"

    const-string v30, "ncsId"

    move-object/from16 v0, v30

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    const-string v29, "networkId"

    const-string v30, "ncsId"

    move-object/from16 v0, v30

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
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

    .line 103
    const-string v29, "networkResourceId"

    const-string v30, "adobeResource"

    move-object/from16 v0, v30

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    .end local v4    # "broadcastArray":Lorg/json/JSONArray;
    .end local v5    # "broadcastObj":Lorg/json/JSONObject;
    :cond_14
    const-string v29, "subcategories"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_16

    const-string v29, "subcategories"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_16

    .line 109
    const-string v29, "subcategories"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v27

    .line 110
    .local v27, "subCatArray":Lorg/json/JSONArray;
    invoke-virtual/range {v27 .. v27}, Lorg/json/JSONArray;->length()I

    move-result v29

    if-lez v29, :cond_16

    .line 111
    const/16 v29, 0x0

    move-object/from16 v0, v27

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v28

    .line 112
    .local v28, "subCatObj":Lorg/json/JSONObject;
    const-string v29, "id"

    invoke-virtual/range {v28 .. v29}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_15

    const-string v29, "id"

    invoke-virtual/range {v28 .. v29}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_15

    .line 113
    const-string v29, "league"

    const-string v30, "id"

    move-object/from16 v0, v28

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    :cond_15
    const-string v29, "name"

    invoke-virtual/range {v28 .. v29}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_16

    const-string v29, "name"

    invoke-virtual/range {v28 .. v29}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_16

    .line 115
    const-string v29, "leagueName"

    const-string v30, "name"

    move-object/from16 v0, v28

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    .end local v27    # "subCatArray":Lorg/json/JSONArray;
    .end local v28    # "subCatObj":Lorg/json/JSONObject;
    :cond_16
    const-string v29, "guid"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_17

    const-string v29, "guid"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_17

    .line 120
    const-string v29, "guid"

    const-string v30, "guid"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    :cond_17
    const-string v29, "startTime"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_18

    const-string v29, "startTime"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_18

    .line 123
    const-string v29, "startTime"

    const-string v30, "startTime"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    :cond_18
    const-string v29, "id"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_19

    const-string v29, "id"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_19

    .line 126
    const-string v29, "eventId"

    const-string v30, "id"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    :cond_19
    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1a

    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1a

    .line 129
    const-string v29, "showName"

    const-string v30, "name"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    :cond_1a
    const-string v29, "simulcastAiringId"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1b

    const-string v29, "simulcastAiringId"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1b

    .line 132
    const-string v29, "simulcastAiringId"

    const-string v30, "simulcastAiringId"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    :cond_1b
    const-string v29, "seekInSeconds"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1c

    const-string v29, "seekInSeconds"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1c

    .line 135
    const-string v29, "seekInSeconds"

    const-string v30, "seekInSeconds"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    :cond_1c
    const-string v29, "parentalRating"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1d

    const-string v29, "parentalRating"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1d

    .line 138
    const-string v29, "parentalRating"

    const-string v30, "parentalRating"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    :cond_1d
    const-string v29, "omniture"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1e

    const-string v29, "omniture"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1e

    .line 141
    const-string v29, "omnitureJson"

    const-string v30, "omniture"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    :cond_1e
    const-string v29, "thumbnails"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_21

    const-string v29, "thumbnails"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_21

    .line 144
    const-string v29, "thumbnails"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v15

    .line 146
    .local v15, "imageObj":Lorg/json/JSONObject;
    const-string v29, "small"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1f

    const-string v29, "small"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1f

    .line 147
    const-string v29, "small"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v25

    .line 148
    .local v25, "small":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v25

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1f

    const-string v29, "href"

    move-object/from16 v0, v25

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1f

    .line 149
    const-string v29, "imageSmall"

    const-string v30, "href"

    move-object/from16 v0, v25

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    .end local v25    # "small":Lorg/json/JSONObject;
    :cond_1f
    const-string v29, "medium"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_20

    const-string v29, "medium"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_20

    .line 153
    const-string v29, "medium"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v21

    .line 154
    .local v21, "med":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_20

    const-string v29, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_20

    .line 155
    const-string v29, "imageMed"

    const-string v30, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    .end local v21    # "med":Lorg/json/JSONObject;
    :cond_20
    const-string v29, "large"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_21

    const-string v29, "large"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_21

    .line 159
    const-string v29, "large"

    move-object/from16 v0, v29

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v16

    .line 160
    .local v16, "large":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v16

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_21

    const-string v29, "href"

    move-object/from16 v0, v16

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_21

    .line 161
    const-string v29, "imageLarge"

    const-string v30, "href"

    move-object/from16 v0, v16

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    .end local v15    # "imageObj":Lorg/json/JSONObject;
    .end local v16    # "large":Lorg/json/JSONObject;
    :cond_21
    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_22

    const-string v29, "name"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_22

    .line 166
    const-string v29, "eventName"

    const-string v30, "name"

    move-object/from16 v0, v30

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 168
    :cond_22
    const-string v29, "links"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_26

    const-string v29, "links"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_26

    .line 169
    const-string v29, "links"

    move-object/from16 v0, v29

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v17

    .line 170
    .local v17, "linksObj":Lorg/json/JSONObject;
    const-string v29, "source"

    move-object/from16 v0, v17

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_26

    const-string v29, "source"

    move-object/from16 v0, v17

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_26

    .line 171
    const-string v29, "source"

    move-object/from16 v0, v17

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v26

    .line 172
    .local v26, "sourceObj":Lorg/json/JSONObject;
    const-string v29, "hls"

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_26

    const-string v29, "hls"

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_26

    .line 173
    const-string v29, "hls"

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v13

    .line 175
    .local v13, "hlsObj":Lorg/json/JSONObject;
    const-string v29, "default"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_23

    const-string v29, "default"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_23

    .line 176
    const-string v29, "default"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    .line 177
    .local v8, "dfltObj":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v29

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_23

    const-string v29, "href"

    move-object/from16 v0, v29

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_23

    .line 178
    const-string v29, "videoURLDefault"

    const-string v30, "href"

    move-object/from16 v0, v30

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    .end local v8    # "dfltObj":Lorg/json/JSONObject;
    :cond_23
    const-string v29, "high"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_24

    const-string v29, "high"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_24

    .line 183
    const-string v29, "high"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v20

    .line 184
    .local v20, "lrgObj":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_24

    const-string v29, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_24

    .line 185
    const-string v29, "videoURLLarge"

    const-string v30, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 189
    .end local v20    # "lrgObj":Lorg/json/JSONObject;
    :cond_24
    const-string v29, "mid"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_25

    const-string v29, "mid"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_25

    .line 190
    const-string v29, "mid"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v23

    .line 191
    .local v23, "midObj":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v23

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_25

    const-string v29, "href"

    move-object/from16 v0, v23

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_25

    .line 192
    const-string v29, "videoURLMed"

    const-string v30, "href"

    move-object/from16 v0, v23

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    .end local v23    # "midObj":Lorg/json/JSONObject;
    :cond_25
    const-string v29, "low"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_26

    const-string v29, "low"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_26

    .line 197
    const-string v29, "low"

    move-object/from16 v0, v29

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v19

    .line 198
    .local v19, "lowObj":Lorg/json/JSONObject;
    const-string v29, "href"

    move-object/from16 v0, v19

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_26

    const-string v29, "href"

    move-object/from16 v0, v19

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_26

    .line 200
    const-string v29, "videoURLSmall"

    const-string v30, "href"

    move-object/from16 v0, v19

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 206
    .end local v13    # "hlsObj":Lorg/json/JSONObject;
    .end local v17    # "linksObj":Lorg/json/JSONObject;
    .end local v19    # "lowObj":Lorg/json/JSONObject;
    .end local v26    # "sourceObj":Lorg/json/JSONObject;
    :cond_26
    const-string v29, "metaEventRelationId"

    const-string v30, "4"

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    if-eqz p2, :cond_27

    const-string v29, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_27

    .line 209
    const-string v30, "sportId"

    const-string v29, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Ljava/lang/String;

    move-object/from16 v0, v30

    move-object/from16 v1, v29

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    :cond_27
    sget-object v29, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    move-object/from16 v0, v29

    invoke-virtual {v0, v11}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoEventsTable(Landroid/content/ContentValues;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 50
    .end local v12    # "eventsObject":Lorg/json/JSONObject;
    :goto_4
    add-int/lit8 v14, v14, 0x1

    goto/16 :goto_0

    .line 213
    :catch_0
    move-exception v9

    .line 214
    .local v9, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v29, "EventBySportParser - Error:  "

    const/16 v30, 0x5

    move-object/from16 v0, v29

    move/from16 v1, v30

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 215
    const/16 v29, 0x0

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendSuccessBroadcast:Z

    .line 216
    const/16 v29, 0x1

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendPartialErrorBroadcast:Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_4

    .line 248
    .end local v9    # "e":Ljava/lang/Exception;
    .end local v10    # "eventsArrayLength":I
    .end local v11    # "eventsBySportsValues":Landroid/content/ContentValues;
    .end local v14    # "i":I
    .end local v18    # "listingsArray":Lorg/json/JSONArray;
    .end local v22    # "metaValues":Landroid/content/ContentValues;
    :catch_1
    move-exception v9

    .line 249
    .restart local v9    # "e":Ljava/lang/Exception;
    :try_start_5
    const-string v29, "EventBySportParser - Error:  "

    const/16 v30, 0x5

    move-object/from16 v0, v29

    move/from16 v1, v30

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 250
    const/16 v29, 0x0

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendSuccessBroadcast:Z

    .line 251
    const/16 v29, 0x0

    move/from16 v0, v29

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendPartialErrorBroadcast:Z

    .line 252
    const/16 v29, 0x2

    move-object/from16 v0, p0

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->errorHandler(I)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 254
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendSuccessBroadcast:Z

    move/from16 v29, v0

    if-eqz v29, :cond_2c

    .line 255
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_2a

    .line 256
    const-string v29, "com.espn.action.EVENTSBYSPORT_LIVE_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 223
    .end local v9    # "e":Ljava/lang/Exception;
    .restart local v10    # "eventsArrayLength":I
    .restart local v11    # "eventsBySportsValues":Landroid/content/ContentValues;
    .restart local v14    # "i":I
    .restart local v18    # "listingsArray":Lorg/json/JSONArray;
    .restart local v22    # "metaValues":Landroid/content/ContentValues;
    :catch_2
    move-exception v9

    .line 224
    .restart local v9    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v29, "EventBySportParser - Error:  "

    const/16 v30, 0x5

    move-object/from16 v0, v29

    move/from16 v1, v30

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 225
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

    .line 253
    .end local v9    # "e":Ljava/lang/Exception;
    .end local v10    # "eventsArrayLength":I
    .end local v11    # "eventsBySportsValues":Landroid/content/ContentValues;
    .end local v14    # "i":I
    .end local v18    # "listingsArray":Lorg/json/JSONArray;
    .end local v22    # "metaValues":Landroid/content/ContentValues;
    :catchall_0
    move-exception v29

    .line 254
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendSuccessBroadcast:Z

    move/from16 v30, v0

    if-eqz v30, :cond_31

    .line 255
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v30, v0

    sget-object v31, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v31 .. v31}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_2f

    .line 256
    const-string v30, "com.espn.action.EVENTSBYSPORT_LIVE_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    .line 271
    :cond_28
    :goto_5
    throw v29

    .line 235
    .restart local v10    # "eventsArrayLength":I
    .restart local v11    # "eventsBySportsValues":Landroid/content/ContentValues;
    .restart local v14    # "i":I
    .restart local v18    # "listingsArray":Lorg/json/JSONArray;
    .restart local v22    # "metaValues":Landroid/content/ContentValues;
    :cond_29
    :try_start_7
    const-string v29, "eventsType"

    const-string v30, ""

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_2

    .line 257
    .end local v10    # "eventsArrayLength":I
    .end local v11    # "eventsBySportsValues":Landroid/content/ContentValues;
    .end local v14    # "i":I
    .end local v18    # "listingsArray":Lorg/json/JSONArray;
    .end local v22    # "metaValues":Landroid/content/ContentValues;
    .restart local v9    # "e":Ljava/lang/Exception;
    :cond_2a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_2b

    .line 258
    const-string v29, "com.espn.action.EVENTSBYSPORT_UPCOMING_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 259
    :cond_2b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_7

    .line 260
    const-string v29, "com.espn.action.EVENTSBYSPORT_REPLAY_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 263
    :cond_2c
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendPartialErrorBroadcast:Z

    move/from16 v29, v0

    if-eqz v29, :cond_7

    .line 264
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_2d

    .line 265
    const-string v29, "com.espn.action.EVENTSBYSPORT_LIVE_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 266
    :cond_2d
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_2e

    .line 267
    const-string v29, "com.espn.action.EVENTSBYSPORT_UPCOMING_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 268
    :cond_2e
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_7

    .line 269
    const-string v29, "com.espn.action.EVENTSBYSPORT_REPLAY_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 257
    .end local v9    # "e":Ljava/lang/Exception;
    :cond_2f
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v30, v0

    sget-object v31, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v31 .. v31}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_30

    .line 258
    const-string v30, "com.espn.action.EVENTSBYSPORT_UPCOMING_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 259
    :cond_30
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v30, v0

    sget-object v31, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v31 .. v31}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_28

    .line 260
    const-string v30, "com.espn.action.EVENTSBYSPORT_REPLAY_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 263
    :cond_31
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendPartialErrorBroadcast:Z

    move/from16 v30, v0

    if-eqz v30, :cond_28

    .line 264
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v30, v0

    sget-object v31, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v31 .. v31}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_32

    .line 265
    const-string v30, "com.espn.action.EVENTSBYSPORT_LIVE_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 266
    :cond_32
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v30, v0

    sget-object v31, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v31 .. v31}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_33

    .line 267
    const-string v30, "com.espn.action.EVENTSBYSPORT_UPCOMING_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 268
    :cond_33
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v30, v0

    sget-object v31, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v31 .. v31}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_28

    .line 269
    const-string v30, "com.espn.action.EVENTSBYSPORT_REPLAY_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 257
    .restart local v10    # "eventsArrayLength":I
    .restart local v11    # "eventsBySportsValues":Landroid/content/ContentValues;
    .restart local v18    # "listingsArray":Lorg/json/JSONArray;
    .restart local v22    # "metaValues":Landroid/content/ContentValues;
    :cond_34
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_35

    .line 258
    const-string v29, "com.espn.action.EVENTSBYSPORT_UPCOMING_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 259
    :cond_35
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_7

    .line 260
    const-string v29, "com.espn.action.EVENTSBYSPORT_REPLAY_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 263
    :cond_36
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendPartialErrorBroadcast:Z

    move/from16 v29, v0

    if-eqz v29, :cond_7

    .line 264
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_37

    .line 265
    const-string v29, "com.espn.action.EVENTSBYSPORT_LIVE_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 266
    :cond_37
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_38

    .line 267
    const-string v29, "com.espn.action.EVENTSBYSPORT_UPCOMING_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 268
    :cond_38
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->contentType:Ljava/lang/String;

    move-object/from16 v29, v0

    sget-object v30, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual/range {v30 .. v30}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_7

    .line 269
    const-string v29, "com.espn.action.EVENTSBYSPORT_REPLAY_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3
.end method
