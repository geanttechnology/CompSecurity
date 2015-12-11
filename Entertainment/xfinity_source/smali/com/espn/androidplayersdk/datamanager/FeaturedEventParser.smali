.class Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "FeaturedEventParser.java"


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
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendSuccessBroadcast:Z

    .line 25
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendPartialErrorBroadcast:Z

    .line 22
    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 1
    .param p1, "errorCode"    # I

    .prologue
    .line 273
    const/4 v0, 0x2

    if-ne p1, v0, :cond_0

    .line 274
    const-string v0, "com.espn.action.FEATURED_EVENT_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendBroadcast(Ljava/lang/String;)V

    .line 275
    :cond_0
    return-void
.end method

.method public parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 35
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
    const-string v31, "FeaturedEventParser"

    const/16 v32, 0x3

    const/16 v33, 0x0

    invoke-static/range {v31 .. v33}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 32
    :try_start_0
    new-instance v12, Landroid/content/ContentValues;

    invoke-direct {v12}, Landroid/content/ContentValues;-><init>()V

    .line 33
    .local v12, "featuredEventValues":Landroid/content/ContentValues;
    new-instance v23, Landroid/content/ContentValues;

    invoke-direct/range {v23 .. v23}, Landroid/content/ContentValues;-><init>()V

    .line 34
    .local v23, "metaValues":Landroid/content/ContentValues;
    const/16 v19, 0x0

    .line 36
    .local v19, "listingsArray":Lorg/json/JSONArray;
    const-string v31, "eventWhere"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_0

    const-string v31, "eventWhereArg"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_0

    .line 38
    sget-object v33, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v34, "featuredEvents"

    const-string v31, "eventWhere"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v31

    check-cast v31, Ljava/lang/String;

    .line 39
    const-string v32, "eventWhereArg"

    move-object/from16 v0, p2

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v32

    check-cast v32, [Ljava/lang/String;

    .line 38
    move-object/from16 v0, v33

    move-object/from16 v1, v34

    move-object/from16 v2, v31

    move-object/from16 v3, v32

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 41
    :cond_0
    const-string v31, "categories"

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_a

    const-string v31, "categories"

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_a

    .line 42
    const-string v31, "categories"

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    .line 43
    .local v6, "categoriesArray":Lorg/json/JSONArray;
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v31

    if-lez v31, :cond_1

    .line 44
    const/16 v31, 0x0

    move/from16 v0, v31

    invoke-virtual {v6, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v25

    .line 45
    .local v25, "obj":Lorg/json/JSONObject;
    const-string v31, "listings"

    move-object/from16 v0, v25

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_9

    const-string v31, "listings"

    move-object/from16 v0, v25

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_9

    .line 46
    const-string v31, "listings"

    move-object/from16 v0, v25

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v19

    .line 53
    .end local v6    # "categoriesArray":Lorg/json/JSONArray;
    .end local v25    # "obj":Lorg/json/JSONObject;
    :cond_1
    :goto_0
    invoke-virtual/range {v19 .. v19}, Lorg/json/JSONArray;->length()I

    move-result v18

    .line 55
    .local v18, "listingArrayLength":I
    if-lez v18, :cond_7

    .line 56
    const/16 v31, 0x1

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendSuccessBroadcast:Z

    .line 58
    const/4 v14, 0x0

    .local v14, "i":I
    :goto_1
    move/from16 v0, v18

    if-lt v14, v0, :cond_b

    .line 231
    if-eqz p2, :cond_4

    .line 232
    const-string v31, "ttl"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v31

    if-eqz v31, :cond_2

    .line 234
    :try_start_1
    const-string v32, "ttl"

    const-string v31, "ttl"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v31

    check-cast v31, Ljava/lang/String;

    invoke-static/range {v31 .. v31}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v31

    invoke-static/range {v31 .. v31}, Lcom/espn/androidplayersdk/utilities/Utils;->getExpiryTime(I)Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v23

    move-object/from16 v1, v32

    move-object/from16 v2, v31

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 240
    :cond_2
    :goto_2
    :try_start_2
    const-string v31, "featuredType"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_3

    .line 241
    const-string v32, "eventRelationId"

    const-string v31, "featuredType"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v31

    check-cast v31, Ljava/lang/Integer;

    move-object/from16 v0, v23

    move-object/from16 v1, v32

    move-object/from16 v2, v31

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 243
    :cond_3
    const-string v31, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_4

    .line 244
    const-string v32, "sportId"

    const-string v31, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v31

    check-cast v31, Ljava/lang/String;

    move-object/from16 v0, v23

    move-object/from16 v1, v32

    move-object/from16 v2, v31

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    :cond_4
    const-string v31, "eventsType"

    const-string v32, "featured"

    move-object/from16 v0, v23

    move-object/from16 v1, v31

    move-object/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 248
    const-string v31, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_5

    const-string v31, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_5

    .line 249
    const-string v31, "omnitureJson"

    const-string v32, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v23

    move-object/from16 v1, v31

    move-object/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    :cond_5
    const-string v31, "resultsLimit"

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_6

    const-string v31, "resultsLimit"

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_6

    .line 252
    const-string v31, "count"

    const-string v32, "resultsLimit"

    move-object/from16 v0, p1

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v23

    move-object/from16 v1, v31

    move-object/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 255
    :cond_6
    sget-object v31, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    move-object/from16 v0, v31

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertOrUpdateMetaEventsTable(Landroid/content/ContentValues;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 263
    .end local v14    # "i":I
    :cond_7
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendSuccessBroadcast:Z

    move/from16 v31, v0

    if-eqz v31, :cond_30

    .line 264
    const-string v31, "com.espn.action.FEATURED_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendBroadcast(Ljava/lang/String;)V

    .line 269
    .end local v12    # "featuredEventValues":Landroid/content/ContentValues;
    .end local v18    # "listingArrayLength":I
    .end local v19    # "listingsArray":Lorg/json/JSONArray;
    .end local v23    # "metaValues":Landroid/content/ContentValues;
    :cond_8
    :goto_3
    return-void

    .line 48
    .restart local v6    # "categoriesArray":Lorg/json/JSONArray;
    .restart local v12    # "featuredEventValues":Landroid/content/ContentValues;
    .restart local v19    # "listingsArray":Lorg/json/JSONArray;
    .restart local v23    # "metaValues":Landroid/content/ContentValues;
    .restart local v25    # "obj":Lorg/json/JSONObject;
    :cond_9
    :try_start_3
    new-instance v19, Lorg/json/JSONArray;

    .end local v19    # "listingsArray":Lorg/json/JSONArray;
    invoke-direct/range {v19 .. v19}, Lorg/json/JSONArray;-><init>()V

    .line 50
    .restart local v19    # "listingsArray":Lorg/json/JSONArray;
    goto/16 :goto_0

    .line 51
    .end local v6    # "categoriesArray":Lorg/json/JSONArray;
    .end local v25    # "obj":Lorg/json/JSONObject;
    :cond_a
    const-string v31, "listings"

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v19

    goto/16 :goto_0

    .line 61
    .restart local v14    # "i":I
    .restart local v18    # "listingArrayLength":I
    :cond_b
    :try_start_4
    invoke-virtual {v12}, Landroid/content/ContentValues;->clear()V

    .line 62
    move-object/from16 v0, v19

    invoke-virtual {v0, v14}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v11

    .line 64
    .local v11, "eventsObject":Lorg/json/JSONObject;
    const-string v31, "broadcastStartTime"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_c

    const-string v31, "broadcastStartTime"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_c

    .line 65
    const-string v31, "broadcastStartTime"

    const-string v32, "broadcastStartTime"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    :cond_c
    const-string v31, "description"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_d

    const-string v31, "description"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_d

    .line 68
    const-string v31, "description"

    const-string v32, "description"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    :cond_d
    const-string v31, "blackouts"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_e

    const-string v31, "blackouts"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_e

    .line 71
    const-string v31, "coverageType"

    const-string v32, "blackouts"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    :cond_e
    const-string v31, "categories"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_10

    const-string v31, "categories"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_10

    .line 74
    const-string v31, "categories"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    .line 75
    .local v7, "categoryArray":Lorg/json/JSONArray;
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v31

    if-lez v31, :cond_10

    .line 76
    const/16 v31, 0x0

    move/from16 v0, v31

    invoke-virtual {v7, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v8

    .line 77
    .local v8, "categoryObj":Lorg/json/JSONObject;
    const-string v31, "name"

    move-object/from16 v0, v31

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_f

    const-string v31, "name"

    move-object/from16 v0, v31

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_f

    .line 78
    const-string v31, "SPORT"

    const-string v32, "name"

    move-object/from16 v0, v32

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    :cond_f
    const-string v31, "abbreviation"

    move-object/from16 v0, v31

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_10

    const-string v31, "abbreviation"

    move-object/from16 v0, v31

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_10

    .line 80
    const-string v31, "sportCode"

    const-string v32, "abbreviation"

    move-object/from16 v0, v32

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    .end local v7    # "categoryArray":Lorg/json/JSONArray;
    .end local v8    # "categoryObj":Lorg/json/JSONObject;
    :cond_10
    const-string v31, "program"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_11

    const-string v31, "program"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_11

    .line 85
    const-string v31, "program"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v26

    .line 86
    .local v26, "programObj":Lorg/json/JSONObject;
    const-string v31, "code"

    move-object/from16 v0, v26

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_11

    const-string v31, "code"

    move-object/from16 v0, v26

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_11

    .line 87
    const-string v31, "programingCode"

    const-string v32, "code"

    move-object/from16 v0, v26

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    .end local v26    # "programObj":Lorg/json/JSONObject;
    :cond_11
    const-string v31, "type"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_12

    const-string v31, "type"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_12

    .line 91
    const-string v31, "eventType"

    const-string v32, "type"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    :cond_12
    const-string v31, "endTime"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_13

    const-string v31, "endTime"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_13

    .line 94
    const-string v31, "endTime"

    const-string v32, "endTime"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    :cond_13
    const-string v31, "subcategories"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_15

    const-string v31, "subcategories"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_15

    .line 97
    const-string v31, "subcategories"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v29

    .line 98
    .local v29, "subCatArray":Lorg/json/JSONArray;
    invoke-virtual/range {v29 .. v29}, Lorg/json/JSONArray;->length()I

    move-result v31

    if-lez v31, :cond_15

    .line 99
    const/16 v31, 0x0

    move-object/from16 v0, v29

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v30

    .line 100
    .local v30, "subCatObj":Lorg/json/JSONObject;
    const-string v31, "id"

    invoke-virtual/range {v30 .. v31}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_14

    const-string v31, "id"

    invoke-virtual/range {v30 .. v31}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_14

    .line 101
    const-string v31, "league"

    const-string v32, "id"

    move-object/from16 v0, v30

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    :cond_14
    const-string v31, "name"

    invoke-virtual/range {v30 .. v31}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_15

    const-string v31, "name"

    invoke-virtual/range {v30 .. v31}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_15

    .line 103
    const-string v31, "leagueName"

    const-string v32, "name"

    move-object/from16 v0, v30

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    .end local v29    # "subCatArray":Lorg/json/JSONArray;
    .end local v30    # "subCatObj":Lorg/json/JSONObject;
    :cond_15
    const-string v31, "broadcasts"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_19

    const-string v31, "broadcasts"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_19

    .line 108
    const-string v31, "broadcasts"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 109
    .local v4, "broadcastArray":Lorg/json/JSONArray;
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v31

    if-lez v31, :cond_19

    .line 110
    const/16 v31, 0x0

    move/from16 v0, v31

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 111
    .local v5, "broadcastObj":Lorg/json/JSONObject;
    const-string v31, "abbreviation"

    move-object/from16 v0, v31

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_16

    const-string v31, "abbreviation"

    move-object/from16 v0, v31

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_16

    .line 112
    const-string v31, "networkCode"

    const-string v32, "abbreviation"

    move-object/from16 v0, v32

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    :cond_16
    const-string v31, "name"

    move-object/from16 v0, v31

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_17

    const-string v31, "name"

    move-object/from16 v0, v31

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_17

    .line 114
    const-string v31, "networkName"

    const-string v32, "name"

    move-object/from16 v0, v32

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    :cond_17
    const-string v31, "ncsId"

    move-object/from16 v0, v31

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_18

    const-string v31, "ncsId"

    move-object/from16 v0, v31

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_18

    .line 116
    const-string v31, "networkId"

    const-string v32, "ncsId"

    move-object/from16 v0, v32

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    const-string v31, "networkId"

    const-string v32, "ncsId"

    move-object/from16 v0, v32

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v23

    move-object/from16 v1, v31

    move-object/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    :cond_18
    const-string v31, "adobeResource"

    move-object/from16 v0, v31

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_19

    const-string v31, "adobeResource"

    move-object/from16 v0, v31

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_19

    .line 120
    const-string v31, "networkResourceId"

    const-string v32, "adobeResource"

    move-object/from16 v0, v32

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    .end local v4    # "broadcastArray":Lorg/json/JSONArray;
    .end local v5    # "broadcastObj":Lorg/json/JSONObject;
    :cond_19
    const-string v31, "guid"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_1a

    const-string v31, "guid"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_1a

    .line 127
    const-string v31, "guid"

    const-string v32, "guid"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    :cond_1a
    const-string v31, "startTime"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_1b

    const-string v31, "startTime"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_1b

    .line 130
    const-string v31, "startTime"

    const-string v32, "startTime"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    :cond_1b
    const-string v31, "id"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_1c

    const-string v31, "id"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_1c

    .line 133
    const-string v31, "eventId"

    const-string v32, "id"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    :cond_1c
    const-string v31, "name"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_1d

    const-string v31, "name"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_1d

    .line 136
    const-string v31, "showName"

    const-string v32, "name"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    :cond_1d
    const-string v31, "simulcastAiringId"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_1e

    const-string v31, "simulcastAiringId"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_1e

    .line 139
    const-string v31, "simulcastAiringId"

    const-string v32, "simulcastAiringId"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    :cond_1e
    const-string v31, "seekInSeconds"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_1f

    const-string v31, "seekInSeconds"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_1f

    .line 142
    const-string v31, "seekInSeconds"

    const-string v32, "seekInSeconds"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    :cond_1f
    const-string v31, "parentalRating"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_20

    const-string v31, "parentalRating"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_20

    .line 145
    const-string v31, "parentalRating"

    const-string v32, "parentalRating"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    :cond_20
    const-string v31, "omniture"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_21

    const-string v31, "omniture"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_21

    .line 148
    const-string v31, "omnitureJson"

    const-string v32, "omniture"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    :cond_21
    const-string v31, "thumbnails"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_24

    const-string v31, "thumbnails"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_24

    .line 151
    const-string v31, "thumbnails"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v15

    .line 153
    .local v15, "imageObj":Lorg/json/JSONObject;
    const-string v31, "small"

    move-object/from16 v0, v31

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_22

    const-string v31, "small"

    move-object/from16 v0, v31

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_22

    .line 154
    const-string v31, "small"

    move-object/from16 v0, v31

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v27

    .line 155
    .local v27, "small":Lorg/json/JSONObject;
    const-string v31, "href"

    move-object/from16 v0, v27

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_22

    const-string v31, "href"

    move-object/from16 v0, v27

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_22

    .line 156
    const-string v31, "imageSmall"

    const-string v32, "href"

    move-object/from16 v0, v27

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    .end local v27    # "small":Lorg/json/JSONObject;
    :cond_22
    const-string v31, "medium"

    move-object/from16 v0, v31

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_23

    const-string v31, "medium"

    move-object/from16 v0, v31

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_23

    .line 160
    const-string v31, "medium"

    move-object/from16 v0, v31

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v22

    .line 161
    .local v22, "med":Lorg/json/JSONObject;
    const-string v31, "href"

    move-object/from16 v0, v22

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_23

    const-string v31, "href"

    move-object/from16 v0, v22

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_23

    .line 162
    const-string v31, "imageMed"

    const-string v32, "href"

    move-object/from16 v0, v22

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    .end local v22    # "med":Lorg/json/JSONObject;
    :cond_23
    const-string v31, "large"

    move-object/from16 v0, v31

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_24

    const-string v31, "large"

    move-object/from16 v0, v31

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_24

    .line 166
    const-string v31, "large"

    move-object/from16 v0, v31

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v16

    .line 167
    .local v16, "large":Lorg/json/JSONObject;
    const-string v31, "href"

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_24

    const-string v31, "href"

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_24

    .line 168
    const-string v31, "imageLarge"

    const-string v32, "href"

    move-object/from16 v0, v16

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 172
    .end local v15    # "imageObj":Lorg/json/JSONObject;
    .end local v16    # "large":Lorg/json/JSONObject;
    :cond_24
    const-string v31, "name"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_25

    const-string v31, "name"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_25

    .line 173
    const-string v31, "eventName"

    const-string v32, "name"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    :cond_25
    const-string v31, "streamUrl"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_26

    const-string v31, "streamUrl"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_26

    .line 176
    const-string v31, "videoURLSmall"

    const-string v32, "streamUrl"

    move-object/from16 v0, v32

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 178
    :cond_26
    const-string v31, "links"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_2a

    const-string v31, "links"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_2a

    .line 179
    const-string v31, "links"

    move-object/from16 v0, v31

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v17

    .line 180
    .local v17, "linksObj":Lorg/json/JSONObject;
    const-string v31, "source"

    move-object/from16 v0, v17

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_2a

    const-string v31, "source"

    move-object/from16 v0, v17

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_2a

    .line 181
    const-string v31, "source"

    move-object/from16 v0, v17

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v28

    .line 182
    .local v28, "sourceObj":Lorg/json/JSONObject;
    const-string v31, "hls"

    move-object/from16 v0, v28

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_2a

    const-string v31, "hls"

    move-object/from16 v0, v28

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_2a

    .line 183
    const-string v31, "hls"

    move-object/from16 v0, v28

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v13

    .line 185
    .local v13, "hlsObj":Lorg/json/JSONObject;
    const-string v31, "default"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_27

    const-string v31, "default"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_27

    .line 186
    const-string v31, "default"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    .line 187
    .local v9, "dfltObj":Lorg/json/JSONObject;
    const-string v31, "href"

    move-object/from16 v0, v31

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_27

    const-string v31, "href"

    move-object/from16 v0, v31

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_27

    .line 188
    const-string v31, "videoURLDefault"

    const-string v32, "href"

    move-object/from16 v0, v32

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 192
    .end local v9    # "dfltObj":Lorg/json/JSONObject;
    :cond_27
    const-string v31, "high"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_28

    const-string v31, "high"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_28

    .line 193
    const-string v31, "high"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v21

    .line 194
    .local v21, "lrgObj":Lorg/json/JSONObject;
    const-string v31, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_28

    const-string v31, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_28

    .line 195
    const-string v31, "videoURLLarge"

    const-string v32, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    .end local v21    # "lrgObj":Lorg/json/JSONObject;
    :cond_28
    const-string v31, "mid"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_29

    const-string v31, "mid"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_29

    .line 200
    const-string v31, "mid"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v24

    .line 201
    .local v24, "midObj":Lorg/json/JSONObject;
    const-string v31, "href"

    move-object/from16 v0, v24

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_29

    const-string v31, "href"

    move-object/from16 v0, v24

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_29

    .line 202
    const-string v31, "videoURLMed"

    const-string v32, "href"

    move-object/from16 v0, v24

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 206
    .end local v24    # "midObj":Lorg/json/JSONObject;
    :cond_29
    const-string v31, "low"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_2a

    const-string v31, "low"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_2a

    .line 207
    const-string v31, "low"

    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v20

    .line 208
    .local v20, "lowObj":Lorg/json/JSONObject;
    const-string v31, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_2a

    const-string v31, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v31

    if-nez v31, :cond_2a

    .line 209
    const-string v31, "videoURLSmall"

    const-string v32, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    move-object/from16 v0, v31

    move-object/from16 v1, v32

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    .end local v13    # "hlsObj":Lorg/json/JSONObject;
    .end local v17    # "linksObj":Lorg/json/JSONObject;
    .end local v20    # "lowObj":Lorg/json/JSONObject;
    .end local v28    # "sourceObj":Lorg/json/JSONObject;
    :cond_2a
    if-eqz p2, :cond_2c

    .line 216
    const-string v31, "featuredType"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_2b

    .line 217
    const-string v32, "metaEventRelationId"

    const-string v31, "featuredType"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v31

    check-cast v31, Ljava/lang/Integer;

    move-object/from16 v0, v32

    move-object/from16 v1, v31

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 218
    :cond_2b
    const-string v31, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_2c

    .line 219
    const-string v32, "sportId"

    const-string v31, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v31

    check-cast v31, Ljava/lang/String;

    move-object/from16 v0, v32

    move-object/from16 v1, v31

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 222
    :cond_2c
    sget-object v31, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    move-object/from16 v0, v31

    invoke-virtual {v0, v12}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoFeaturedEventsTable(Landroid/content/ContentValues;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 58
    .end local v11    # "eventsObject":Lorg/json/JSONObject;
    :goto_4
    add-int/lit8 v14, v14, 0x1

    goto/16 :goto_1

    .line 224
    :catch_0
    move-exception v10

    .line 225
    .local v10, "e":Ljava/lang/Exception;
    :try_start_5
    const-string v31, "FeaturedEventParser"

    const/16 v32, 0x5

    move-object/from16 v0, v31

    move/from16 v1, v32

    invoke-static {v0, v1, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 226
    const/16 v31, 0x0

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendSuccessBroadcast:Z

    .line 227
    const/16 v31, 0x1

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendPartialErrorBroadcast:Z
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_4

    .line 257
    .end local v10    # "e":Ljava/lang/Exception;
    .end local v12    # "featuredEventValues":Landroid/content/ContentValues;
    .end local v14    # "i":I
    .end local v18    # "listingArrayLength":I
    .end local v19    # "listingsArray":Lorg/json/JSONArray;
    .end local v23    # "metaValues":Landroid/content/ContentValues;
    :catch_1
    move-exception v10

    .line 258
    .restart local v10    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v31, "FeaturedEventParser"

    const/16 v32, 0x5

    move-object/from16 v0, v31

    move/from16 v1, v32

    invoke-static {v0, v1, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 259
    const/16 v31, 0x0

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendSuccessBroadcast:Z

    .line 260
    const/16 v31, 0x0

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendPartialErrorBroadcast:Z

    .line 261
    const/16 v31, 0x2

    move-object/from16 v0, p0

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->errorHandler(I)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 263
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendSuccessBroadcast:Z

    move/from16 v31, v0

    if-eqz v31, :cond_2e

    .line 264
    const-string v31, "com.espn.action.FEATURED_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 235
    .end local v10    # "e":Ljava/lang/Exception;
    .restart local v12    # "featuredEventValues":Landroid/content/ContentValues;
    .restart local v14    # "i":I
    .restart local v18    # "listingArrayLength":I
    .restart local v19    # "listingsArray":Lorg/json/JSONArray;
    .restart local v23    # "metaValues":Landroid/content/ContentValues;
    :catch_2
    move-exception v10

    .line 236
    .restart local v10    # "e":Ljava/lang/Exception;
    :try_start_7
    const-string v31, "FeaturedEventParser"

    const/16 v32, 0x5

    move-object/from16 v0, v31

    move/from16 v1, v32

    invoke-static {v0, v1, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 237
    const-string v31, "ttl"

    const-string v32, ""

    move-object/from16 v0, v23

    move-object/from16 v1, v31

    move-object/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_2

    .line 262
    .end local v10    # "e":Ljava/lang/Exception;
    .end local v12    # "featuredEventValues":Landroid/content/ContentValues;
    .end local v14    # "i":I
    .end local v18    # "listingArrayLength":I
    .end local v19    # "listingsArray":Lorg/json/JSONArray;
    .end local v23    # "metaValues":Landroid/content/ContentValues;
    :catchall_0
    move-exception v31

    .line 263
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendSuccessBroadcast:Z

    move/from16 v32, v0

    if-eqz v32, :cond_2f

    .line 264
    const-string v32, "com.espn.action.FEATURED_EVENT_UPDATED"

    move-object/from16 v0, p0

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendBroadcast(Ljava/lang/String;)V

    .line 267
    :cond_2d
    :goto_5
    throw v31

    .line 265
    .restart local v10    # "e":Ljava/lang/Exception;
    :cond_2e
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendPartialErrorBroadcast:Z

    move/from16 v31, v0

    if-eqz v31, :cond_8

    .line 266
    const-string v31, "com.espn.action.FEATURED_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 265
    .end local v10    # "e":Ljava/lang/Exception;
    :cond_2f
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendPartialErrorBroadcast:Z

    move/from16 v32, v0

    if-eqz v32, :cond_2d

    .line 266
    const-string v32, "com.espn.action.FEATURED_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_5

    .line 265
    .restart local v12    # "featuredEventValues":Landroid/content/ContentValues;
    .restart local v18    # "listingArrayLength":I
    .restart local v19    # "listingsArray":Lorg/json/JSONArray;
    .restart local v23    # "metaValues":Landroid/content/ContentValues;
    :cond_30
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendPartialErrorBroadcast:Z

    move/from16 v31, v0

    if-eqz v31, :cond_8

    .line 266
    const-string v31, "com.espn.action.FEATURED_EVENT_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_3
.end method
