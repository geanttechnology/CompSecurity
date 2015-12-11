.class Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "FeaturedEventsParserII.java"


# instance fields
.field contentType:I

.field sendPartialErrorBroadcast:Z

.field sendSuccessBroadcast:Z


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 23
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;-><init>()V

    .line 25
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendSuccessBroadcast:Z

    .line 26
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendPartialErrorBroadcast:Z

    .line 27
    iput v0, p0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    .line 23
    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 2
    .param p1, "errorCode"    # I

    .prologue
    .line 200
    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    const/4 v0, 0x2

    if-ne p1, v0, :cond_1

    .line 201
    :cond_0
    iget v0, p0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    const/16 v1, 0xe

    if-ne v0, v1, :cond_2

    .line 202
    const-string v0, "com.espn.action.FEATURED_BEST_OF_EVENT_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    .line 208
    :cond_1
    :goto_0
    return-void

    .line 203
    :cond_2
    iget v0, p0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    const/16 v1, 0xd

    if-ne v0, v1, :cond_3

    .line 204
    const-string v0, "com.espn.action.FEATURED_MUST_SEE_EVENT_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_0

    .line 205
    :cond_3
    iget v0, p0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    const/16 v1, 0xf

    if-ne v0, v1, :cond_1

    .line 206
    const-string v0, "com.espn.action.FEATURED_TOP_VOD_EVENT_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 23
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
    .line 31
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v19, "FeaturedEventsParserII"

    const/16 v20, 0x3

    const/16 v21, 0x0

    invoke-static/range {v19 .. v21}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 33
    :try_start_0
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 34
    .local v7, "featuredEventValues":Landroid/content/ContentValues;
    new-instance v14, Landroid/content/ContentValues;

    invoke-direct {v14}, Landroid/content/ContentValues;-><init>()V

    .line 36
    .local v14, "metaValues":Landroid/content/ContentValues;
    const-string v19, "featuredType"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_0

    .line 37
    const-string v19, "featuredType"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/Integer;

    invoke-virtual/range {v19 .. v19}, Ljava/lang/Integer;->intValue()I

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    .line 39
    :cond_0
    const-string v19, "eventWhere"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_1

    const-string v19, "eventWhereArg"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_1

    .line 41
    sget-object v21, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v22, "featuredEvents"

    const-string v19, "eventWhere"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/String;

    .line 42
    const-string v20, "eventWhereArg"

    move-object/from16 v0, p2

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, [Ljava/lang/String;

    .line 41
    move-object/from16 v0, v21

    move-object/from16 v1, v22

    move-object/from16 v2, v19

    move-object/from16 v3, v20

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 44
    :cond_1
    const-string v19, "videos"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_7

    const-string v19, "videos"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_7

    .line 45
    const-string v19, "videos"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v17

    .line 46
    .local v17, "videoArray":Lorg/json/JSONArray;
    invoke-virtual/range {v17 .. v17}, Lorg/json/JSONArray;->length()I

    move-result v18

    .line 48
    .local v18, "videoArrayLength":I
    if-lez v18, :cond_7

    .line 49
    const/16 v19, 0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendSuccessBroadcast:Z

    .line 52
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    move/from16 v0, v18

    if-lt v11, v0, :cond_9

    .line 148
    if-eqz p2, :cond_4

    .line 149
    const-string v19, "ttl"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v19

    if-eqz v19, :cond_2

    .line 151
    :try_start_1
    const-string v20, "ttl"

    const-string v19, "ttl"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/String;

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v19

    invoke-static/range {v19 .. v19}, Lcom/espn/androidplayersdk/utilities/Utils;->getExpiryTime(I)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v20

    move-object/from16 v1, v19

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 157
    :cond_2
    :goto_1
    :try_start_2
    const-string v19, "featuredType"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_3

    .line 158
    const-string v20, "eventRelationId"

    const-string v19, "featuredType"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/Integer;

    move-object/from16 v0, v20

    move-object/from16 v1, v19

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 160
    :cond_3
    const-string v19, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_4

    .line 161
    const-string v20, "sportId"

    const-string v19, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/String;

    move-object/from16 v0, v20

    move-object/from16 v1, v19

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    :cond_4
    const-string v19, "eventsType"

    const-string v20, "featuredII"

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    const-string v19, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_5

    const-string v19, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_5

    .line 166
    const-string v19, "omnitureJson"

    const-string v20, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 168
    :cond_5
    const-string v19, "resultsLimit"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_6

    const-string v19, "resultsLimit"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_6

    .line 169
    const-string v19, "count"

    const-string v20, "resultsLimit"

    move-object/from16 v0, p1

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 171
    :cond_6
    sget-object v19, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    move-object/from16 v0, v19

    invoke-virtual {v0, v14}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertOrUpdateMetaEventsTable(Landroid/content/ContentValues;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 180
    .end local v11    # "i":I
    .end local v17    # "videoArray":Lorg/json/JSONArray;
    .end local v18    # "videoArrayLength":I
    :cond_7
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendSuccessBroadcast:Z

    move/from16 v19, v0

    if-eqz v19, :cond_24

    .line 181
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xe

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_22

    .line 182
    const-string v19, "com.espn.action.FEATURED_BEST_OF_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    .line 196
    .end local v7    # "featuredEventValues":Landroid/content/ContentValues;
    .end local v14    # "metaValues":Landroid/content/ContentValues;
    :cond_8
    :goto_2
    return-void

    .line 54
    .restart local v7    # "featuredEventValues":Landroid/content/ContentValues;
    .restart local v11    # "i":I
    .restart local v14    # "metaValues":Landroid/content/ContentValues;
    .restart local v17    # "videoArray":Lorg/json/JSONArray;
    .restart local v18    # "videoArrayLength":I
    :cond_9
    :try_start_3
    invoke-virtual {v7}, Landroid/content/ContentValues;->clear()V

    .line 55
    move-object/from16 v0, v17

    invoke-virtual {v0, v11}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 57
    .local v4, "VODObject":Lorg/json/JSONObject;
    const-string v19, "headline"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_a

    const-string v19, "headline"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_a

    .line 58
    const-string v19, "eventName"

    const-string v20, "headline"

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    const-string v19, "showName"

    const-string v20, "headline"

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    :cond_a
    const-string v19, "description"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_b

    const-string v19, "description"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_b

    .line 62
    const-string v19, "description"

    const-string v20, "description"

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    :cond_b
    const-string v19, "id"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_c

    const-string v19, "id"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_c

    .line 64
    const-string v19, "eventId"

    const-string v20, "id"

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    :cond_c
    const-string v19, "posterImages"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_e

    const-string v19, "posterImages"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_e

    .line 67
    const-string v19, "posterImages"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v12

    .line 68
    .local v12, "imageObj":Lorg/json/JSONObject;
    const-string v19, "default"

    move-object/from16 v0, v19

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_d

    const-string v19, "default"

    move-object/from16 v0, v19

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_d

    .line 69
    const-string v19, "default"

    move-object/from16 v0, v19

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 70
    .local v5, "defaultImageObj":Lorg/json/JSONObject;
    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_d

    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_d

    .line 71
    const-string v19, "imageMed"

    const-string v20, "href"

    move-object/from16 v0, v20

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    const-string v19, "imageSmall"

    const-string v20, "href"

    move-object/from16 v0, v20

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    .end local v5    # "defaultImageObj":Lorg/json/JSONObject;
    :cond_d
    const-string v19, "full"

    move-object/from16 v0, v19

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_e

    const-string v19, "full"

    move-object/from16 v0, v19

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_e

    .line 76
    const-string v19, "full"

    move-object/from16 v0, v19

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    .line 77
    .local v8, "fullImageObj":Lorg/json/JSONObject;
    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_e

    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_e

    .line 78
    const-string v19, "imageLarge"

    const-string v20, "href"

    move-object/from16 v0, v20

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    .end local v8    # "fullImageObj":Lorg/json/JSONObject;
    .end local v12    # "imageObj":Lorg/json/JSONObject;
    :cond_e
    const-string v19, "links"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_10

    const-string v19, "links"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_10

    .line 83
    const-string v19, "links"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v13

    .line 84
    .local v13, "linksObj":Lorg/json/JSONObject;
    const-string v19, "source"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_10

    const-string v19, "source"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_10

    .line 85
    const-string v19, "source"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v15

    .line 86
    .local v15, "sourceObj":Lorg/json/JSONObject;
    const-string v19, "HLS"

    move-object/from16 v0, v19

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_10

    const-string v19, "HLS"

    move-object/from16 v0, v19

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_10

    .line 87
    const-string v19, "HLS"

    move-object/from16 v0, v19

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v10

    .line 88
    .local v10, "hlsObj":Lorg/json/JSONObject;
    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_f

    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_f

    .line 89
    const-string v19, "videoURLLarge"

    const-string v20, "href"

    move-object/from16 v0, v20

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    const-string v19, "videoURLMed"

    const-string v20, "href"

    move-object/from16 v0, v20

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    const-string v19, "videoURLSmall"

    const-string v20, "href"

    move-object/from16 v0, v20

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    :cond_f
    const-string v19, "HD"

    move-object/from16 v0, v19

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_10

    const-string v19, "HD"

    move-object/from16 v0, v19

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_10

    .line 94
    const-string v19, "HD"

    move-object/from16 v0, v19

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    .line 95
    .local v9, "hdObj":Lorg/json/JSONObject;
    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_10

    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_10

    .line 96
    const-string v19, "videoURLHD"

    const-string v20, "href"

    move-object/from16 v0, v20

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    .end local v9    # "hdObj":Lorg/json/JSONObject;
    .end local v10    # "hlsObj":Lorg/json/JSONObject;
    .end local v13    # "linksObj":Lorg/json/JSONObject;
    .end local v15    # "sourceObj":Lorg/json/JSONObject;
    :cond_10
    const-string v19, "duration"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_11

    const-string v19, "duration"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_11

    .line 104
    const-string v19, "endTime"

    const-string v20, "duration"

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    :cond_11
    const-string v19, "tracking"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_14

    const-string v19, "tracking"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_14

    .line 108
    const-string v19, "tracking"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v16

    .line 109
    .local v16, "trackingObj":Lorg/json/JSONObject;
    const-string v19, "sportName"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_12

    const-string v19, "sportName"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_12

    .line 110
    const-string v19, "SPORT"

    const-string v20, "sportName"

    move-object/from16 v0, v16

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    :cond_12
    const-string v19, "leagueName"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_13

    const-string v19, "leagueName"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_13

    .line 112
    const-string v19, "leagueName"

    const-string v20, "leagueName"

    move-object/from16 v0, v16

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    :cond_13
    const-string v19, "coverageType"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_14

    const-string v19, "coverageType"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_14

    .line 114
    const-string v19, "coverageType"

    const-string v20, "coverageType"

    move-object/from16 v0, v16

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    .end local v16    # "trackingObj":Lorg/json/JSONObject;
    :cond_14
    const-string v19, "broadcastStartTime"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    const-string v19, "eventType"

    const-string v20, "VOD"

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    const-string v19, "guid"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    const-string v19, "omnitureJson"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    const-string v19, "parentalRating"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    const-string v19, "seekInSeconds"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    const-string v19, "simulcastAiringId"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    const-string v19, "networkCode"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    const-string v19, "networkName"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    const-string v19, "networkId"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    const-string v19, "league"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    const-string v19, "startTime"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    const-string v19, "networkResourceId"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    if-eqz p2, :cond_16

    .line 133
    const-string v19, "featuredType"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_15

    .line 134
    const-string v20, "metaEventRelationId"

    const-string v19, "featuredType"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/Integer;

    move-object/from16 v0, v20

    move-object/from16 v1, v19

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 135
    :cond_15
    const-string v19, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_16

    .line 136
    const-string v20, "sportId"

    const-string v19, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/String;

    move-object/from16 v0, v20

    move-object/from16 v1, v19

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    :cond_16
    sget-object v19, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    move-object/from16 v0, v19

    invoke-virtual {v0, v7}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoFeaturedEventsTable(Landroid/content/ContentValues;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 52
    .end local v4    # "VODObject":Lorg/json/JSONObject;
    :goto_3
    add-int/lit8 v11, v11, 0x1

    goto/16 :goto_0

    .line 141
    :catch_0
    move-exception v6

    .line 142
    .local v6, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v19, "FeaturedEventsParserII"

    const/16 v20, 0x5

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 143
    const/16 v19, 0x0

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendSuccessBroadcast:Z

    .line 144
    const/16 v19, 0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendPartialErrorBroadcast:Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_3

    .line 174
    .end local v6    # "e":Ljava/lang/Exception;
    .end local v7    # "featuredEventValues":Landroid/content/ContentValues;
    .end local v11    # "i":I
    .end local v14    # "metaValues":Landroid/content/ContentValues;
    .end local v17    # "videoArray":Lorg/json/JSONArray;
    .end local v18    # "videoArrayLength":I
    :catch_1
    move-exception v6

    .line 175
    .restart local v6    # "e":Ljava/lang/Exception;
    :try_start_5
    const-string v19, "FeaturedEventsParserII"

    const/16 v20, 0x5

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 176
    const/16 v19, 0x0

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendSuccessBroadcast:Z

    .line 177
    const/16 v19, 0x0

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendPartialErrorBroadcast:Z

    .line 178
    const/16 v19, 0x2

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->errorHandler(I)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 180
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendSuccessBroadcast:Z

    move/from16 v19, v0

    if-eqz v19, :cond_1a

    .line 181
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xe

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_18

    .line 182
    const-string v19, "com.espn.action.FEATURED_BEST_OF_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 152
    .end local v6    # "e":Ljava/lang/Exception;
    .restart local v7    # "featuredEventValues":Landroid/content/ContentValues;
    .restart local v11    # "i":I
    .restart local v14    # "metaValues":Landroid/content/ContentValues;
    .restart local v17    # "videoArray":Lorg/json/JSONArray;
    .restart local v18    # "videoArrayLength":I
    :catch_2
    move-exception v6

    .line 153
    .restart local v6    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v19, "FeaturedEventsParserII"

    const/16 v20, 0x5

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 154
    const-string v19, "ttl"

    const-string v20, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_1

    .line 179
    .end local v6    # "e":Ljava/lang/Exception;
    .end local v7    # "featuredEventValues":Landroid/content/ContentValues;
    .end local v11    # "i":I
    .end local v14    # "metaValues":Landroid/content/ContentValues;
    .end local v17    # "videoArray":Lorg/json/JSONArray;
    .end local v18    # "videoArrayLength":I
    :catchall_0
    move-exception v19

    .line 180
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendSuccessBroadcast:Z

    move/from16 v20, v0

    if-eqz v20, :cond_1f

    .line 181
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v20, v0

    const/16 v21, 0xe

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_1d

    .line 182
    const-string v20, "com.espn.action.FEATURED_BEST_OF_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    .line 195
    :cond_17
    :goto_4
    throw v19

    .line 183
    .restart local v6    # "e":Ljava/lang/Exception;
    :cond_18
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xd

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_19

    .line 184
    const-string v19, "com.espn.action.FEATURED_MUST_SEE_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 185
    :cond_19
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xf

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_8

    .line 186
    const-string v19, "com.espn.action.FEATURED_TOP_VOD_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 187
    :cond_1a
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendPartialErrorBroadcast:Z

    move/from16 v19, v0

    if-eqz v19, :cond_8

    .line 188
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xe

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_1b

    .line 189
    const-string v19, "com.espn.action.FEATURED_BEST_OF_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 190
    :cond_1b
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xd

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_1c

    .line 191
    const-string v19, "com.espn.action.FEATURED_MUST_SEE_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 192
    :cond_1c
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xf

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_8

    .line 193
    const-string v19, "com.espn.action.FEATURED_TOP_VOD_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 183
    .end local v6    # "e":Ljava/lang/Exception;
    :cond_1d
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v20, v0

    const/16 v21, 0xd

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_1e

    .line 184
    const-string v20, "com.espn.action.FEATURED_MUST_SEE_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 185
    :cond_1e
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v20, v0

    const/16 v21, 0xf

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_17

    .line 186
    const-string v20, "com.espn.action.FEATURED_TOP_VOD_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 187
    :cond_1f
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendPartialErrorBroadcast:Z

    move/from16 v20, v0

    if-eqz v20, :cond_17

    .line 188
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v20, v0

    const/16 v21, 0xe

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_20

    .line 189
    const-string v20, "com.espn.action.FEATURED_BEST_OF_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 190
    :cond_20
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v20, v0

    const/16 v21, 0xd

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_21

    .line 191
    const-string v20, "com.espn.action.FEATURED_MUST_SEE_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 192
    :cond_21
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v20, v0

    const/16 v21, 0xf

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_17

    .line 193
    const-string v20, "com.espn.action.FEATURED_TOP_VOD_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 183
    .restart local v7    # "featuredEventValues":Landroid/content/ContentValues;
    .restart local v14    # "metaValues":Landroid/content/ContentValues;
    :cond_22
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xd

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_23

    .line 184
    const-string v19, "com.espn.action.FEATURED_MUST_SEE_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 185
    :cond_23
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xf

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_8

    .line 186
    const-string v19, "com.espn.action.FEATURED_TOP_VOD_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 187
    :cond_24
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendPartialErrorBroadcast:Z

    move/from16 v19, v0

    if-eqz v19, :cond_8

    .line 188
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xe

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_25

    .line 189
    const-string v19, "com.espn.action.FEATURED_BEST_OF_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 190
    :cond_25
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xd

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_26

    .line 191
    const-string v19, "com.espn.action.FEATURED_MUST_SEE_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 192
    :cond_26
    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->contentType:I

    move/from16 v19, v0

    const/16 v20, 0xf

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_8

    .line 193
    const-string v19, "com.espn.action.FEATURED_TOP_VOD_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2
.end method
