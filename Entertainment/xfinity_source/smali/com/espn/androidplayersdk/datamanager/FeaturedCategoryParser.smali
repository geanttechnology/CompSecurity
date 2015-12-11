.class Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "FeaturedCategoryParser.java"


# instance fields
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
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendSuccessBroadcast:Z

    .line 26
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendPartialErrorBroadcast:Z

    .line 23
    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 1
    .param p1, "errorCode"    # I

    .prologue
    .line 138
    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    const/4 v0, 0x2

    if-ne p1, v0, :cond_1

    .line 139
    :cond_0
    const-string v0, "com.espn.action.ACTION_FEATURED_CATEGORY_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendBroadcast(Ljava/lang/String;)V

    .line 140
    :cond_1
    return-void
.end method

.method public parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 18
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
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 32
    .local v5, "featuredEventValues":Landroid/content/ContentValues;
    new-instance v12, Landroid/content/ContentValues;

    invoke-direct {v12}, Landroid/content/ContentValues;-><init>()V

    .line 33
    .local v12, "metaValues":Landroid/content/ContentValues;
    const-string v14, "FeaturedCategoryParser"

    const/4 v15, 0x3

    const/16 v16, 0x0

    invoke-static/range {v14 .. v16}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 35
    :try_start_0
    const-string v14, "features"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_1

    const-string v14, "features"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_1

    .line 36
    const-string v14, "features"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    .line 37
    .local v6, "featuresArray":Lorg/json/JSONArray;
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v7

    .line 38
    .local v7, "featuresArraySize":I
    if-lez v7, :cond_1

    .line 39
    const-string v14, "eventWhere"

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_0

    const-string v14, "eventWhereArg"

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_0

    .line 41
    sget-object v14, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v15, "featuredCategories"

    const/16 v16, 0x0

    const/16 v17, 0x0

    invoke-virtual/range {v14 .. v17}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 42
    :cond_0
    const/4 v14, 0x1

    move-object/from16 v0, p0

    iput-boolean v14, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendSuccessBroadcast:Z

    .line 43
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    if-lt v8, v7, :cond_4

    .line 94
    .end local v6    # "featuresArray":Lorg/json/JSONArray;
    .end local v7    # "featuresArraySize":I
    .end local v8    # "i":I
    :cond_1
    if-eqz p2, :cond_2

    const-string v14, "ttl"

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v14

    if-eqz v14, :cond_2

    .line 96
    :try_start_1
    const-string v15, "ttl"

    const-string v14, "ttl"

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/String;

    invoke-static {v14}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v14

    invoke-static {v14}, Lcom/espn/androidplayersdk/utilities/Utils;->getExpiryTime(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v15, v14}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 103
    :cond_2
    :goto_1
    :try_start_2
    const-string v14, "eventType"

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_a

    .line 104
    const-string v15, "eventsType"

    const-string v14, "eventType"

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/String;

    invoke-virtual {v12, v15, v14}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    :goto_2
    const-string v14, "omniture"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_b

    const-string v14, "omniture"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_b

    .line 109
    const-string v14, "omnitureJson"

    const-string v15, "omniture"

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v15

    invoke-virtual {v15}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v12, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    :goto_3
    const-string v14, "resultsCount"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_c

    const-string v14, "resultsCount"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_c

    .line 114
    const-string v14, "count"

    const-string v15, "resultsCount"

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v12, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    :goto_4
    const-string v14, "eventRelationId"

    const/16 v15, 0x1e

    invoke-static {v15}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    invoke-virtual {v12, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 120
    sget-object v14, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v14, v12}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertOrUpdateMetaEventsTable(Landroid/content/ContentValues;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 128
    move-object/from16 v0, p0

    iget-boolean v14, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendSuccessBroadcast:Z

    if-eqz v14, :cond_f

    .line 129
    const-string v14, "com.espn.action.ACTION_FEATURED_CATEGORY_UPDATE"

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendBroadcast(Ljava/lang/String;)V

    .line 134
    :cond_3
    :goto_5
    return-void

    .line 46
    .restart local v6    # "featuresArray":Lorg/json/JSONArray;
    .restart local v7    # "featuresArraySize":I
    .restart local v8    # "i":I
    :cond_4
    :try_start_3
    invoke-virtual {v5}, Landroid/content/ContentValues;->clear()V

    .line 47
    invoke-virtual {v6, v8}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 48
    .local v4, "featuredCatObj":Lorg/json/JSONObject;
    const-string v14, "categoryId"

    const-string v15, "id"

    invoke-virtual {v4, v15}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    const-string v14, "name"

    const-string v15, "name"

    invoke-virtual {v4, v15}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    const-string v14, "abbre"

    const-string v15, "abbreviation"

    invoke-virtual {v4, v15}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    const-string v14, "shortName"

    invoke-virtual {v4, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_5

    const-string v14, "shortName"

    invoke-virtual {v4, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_5

    .line 53
    const-string v14, "shortName"

    const-string v15, "shortName"

    invoke-virtual {v4, v15}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    :cond_5
    const-string v14, "type"

    const-string v15, "type"

    invoke-virtual {v4, v15}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    const-string v14, "images"

    invoke-virtual {v4, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_6

    const-string v14, "images"

    invoke-virtual {v4, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_6

    .line 59
    const-string v14, "images"

    invoke-virtual {v4, v14}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    .line 60
    .local v9, "imagesObj":Lorg/json/JSONObject;
    const-string v14, "edgartv"

    invoke-virtual {v9, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_6

    const-string v14, "edgartv"

    invoke-virtual {v9, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_6

    .line 61
    const-string v14, "edgartv"

    invoke-virtual {v9, v14}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 62
    .local v3, "edgarObj":Lorg/json/JSONObject;
    const-string v14, "href"

    invoke-virtual {v3, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_6

    const-string v14, "href"

    invoke-virtual {v3, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_6

    .line 63
    const-string v14, "imageUrl"

    const-string v15, "href"

    invoke-virtual {v3, v15}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    .end local v3    # "edgarObj":Lorg/json/JSONObject;
    .end local v9    # "imagesObj":Lorg/json/JSONObject;
    :cond_6
    const-string v14, "links"

    invoke-virtual {v4, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_8

    const-string v14, "links"

    invoke-virtual {v4, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_8

    .line 68
    const-string v14, "links"

    invoke-virtual {v4, v14}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v10

    .line 69
    .local v10, "linksObj":Lorg/json/JSONObject;
    const-string v14, "api"

    invoke-virtual {v10, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_8

    const-string v14, "api"

    invoke-virtual {v10, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_8

    .line 70
    const-string v14, "api"

    invoke-virtual {v10, v14}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 71
    .local v1, "apiObj":Lorg/json/JSONObject;
    const-string v14, "listings"

    invoke-virtual {v1, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_7

    const-string v14, "listings"

    invoke-virtual {v1, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_7

    .line 72
    const-string v14, "listings"

    invoke-virtual {v1, v14}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    .line 73
    .local v11, "listingsObj":Lorg/json/JSONObject;
    const-string v14, "href"

    invoke-virtual {v11, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_7

    const-string v14, "href"

    invoke-virtual {v11, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_7

    .line 74
    const-string v14, "listingUrl"

    const-string v15, "href"

    invoke-virtual {v11, v15}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    .end local v11    # "listingsObj":Lorg/json/JSONObject;
    :cond_7
    const-string v14, "video"

    invoke-virtual {v1, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_8

    const-string v14, "video"

    invoke-virtual {v1, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_8

    .line 77
    const-string v14, "video"

    invoke-virtual {v1, v14}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v13

    .line 78
    .local v13, "videoObj":Lorg/json/JSONObject;
    const-string v14, "href"

    invoke-virtual {v13, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_8

    const-string v14, "href"

    invoke-virtual {v13, v14}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_8

    .line 79
    const-string v14, "vodUrl"

    const-string v15, "href"

    invoke-virtual {v13, v15}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    .end local v1    # "apiObj":Lorg/json/JSONObject;
    .end local v10    # "linksObj":Lorg/json/JSONObject;
    .end local v13    # "videoObj":Lorg/json/JSONObject;
    :cond_8
    sget-object v14, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v14, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoFeaturedCategoriesTable(Landroid/content/ContentValues;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 43
    .end local v4    # "featuredCatObj":Lorg/json/JSONObject;
    :goto_6
    add-int/lit8 v8, v8, 0x1

    goto/16 :goto_0

    .line 84
    :catch_0
    move-exception v2

    .line 85
    .local v2, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v14, "FeaturedCategoryParser"

    const/4 v15, 0x5

    invoke-static {v14, v15, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 86
    const/4 v14, 0x0

    move-object/from16 v0, p0

    iput-boolean v14, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendSuccessBroadcast:Z

    .line 87
    const/4 v14, 0x1

    move-object/from16 v0, p0

    iput-boolean v14, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendPartialErrorBroadcast:Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_6

    .line 122
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v6    # "featuresArray":Lorg/json/JSONArray;
    .end local v7    # "featuresArraySize":I
    .end local v8    # "i":I
    :catch_1
    move-exception v2

    .line 123
    .restart local v2    # "e":Ljava/lang/Exception;
    :try_start_5
    const-string v14, "FeaturedCategoryParser"

    const/4 v15, 0x5

    invoke-static {v14, v15, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 124
    const/4 v14, 0x0

    move-object/from16 v0, p0

    iput-boolean v14, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendSuccessBroadcast:Z

    .line 125
    const/4 v14, 0x0

    move-object/from16 v0, p0

    iput-boolean v14, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendPartialErrorBroadcast:Z

    .line 126
    const/4 v14, 0x2

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->errorHandler(I)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 128
    move-object/from16 v0, p0

    iget-boolean v14, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendSuccessBroadcast:Z

    if-eqz v14, :cond_d

    .line 129
    const-string v14, "com.espn.action.ACTION_FEATURED_CATEGORY_UPDATE"

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 97
    .end local v2    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v2

    .line 98
    .restart local v2    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v14, "FeaturedCategoryParser"

    const/4 v15, 0x5

    invoke-static {v14, v15, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 99
    const-string v14, "ttl"

    const-string v15, ""

    invoke-virtual {v12, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_1

    .line 127
    .end local v2    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v14

    .line 128
    move-object/from16 v0, p0

    iget-boolean v15, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendSuccessBroadcast:Z

    if-eqz v15, :cond_e

    .line 129
    const-string v15, "com.espn.action.ACTION_FEATURED_CATEGORY_UPDATE"

    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendBroadcast(Ljava/lang/String;)V

    .line 132
    :cond_9
    :goto_7
    throw v14

    .line 106
    :cond_a
    :try_start_7
    const-string v14, "eventsType"

    const-string v15, ""

    invoke-virtual {v12, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    .line 111
    :cond_b
    const-string v14, "omnitureJson"

    const-string v15, ""

    invoke-virtual {v12, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_3

    .line 116
    :cond_c
    const-string v14, "count"

    const-string v15, ""

    invoke-virtual {v12, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_4

    .line 130
    .restart local v2    # "e":Ljava/lang/Exception;
    :cond_d
    move-object/from16 v0, p0

    iget-boolean v14, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendPartialErrorBroadcast:Z

    if-eqz v14, :cond_3

    .line 131
    const-string v14, "com.espn.action.ACTION_FEATURED_CATEGORY_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 130
    .end local v2    # "e":Ljava/lang/Exception;
    :cond_e
    move-object/from16 v0, p0

    iget-boolean v15, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendPartialErrorBroadcast:Z

    if-eqz v15, :cond_9

    .line 131
    const-string v15, "com.espn.action.ACTION_FEATURED_CATEGORY_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_7

    .line 130
    :cond_f
    move-object/from16 v0, p0

    iget-boolean v14, v0, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendPartialErrorBroadcast:Z

    if-eqz v14, :cond_3

    .line 131
    const-string v14, "com.espn.action.ACTION_FEATURED_CATEGORY_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_5
.end method
