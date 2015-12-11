.class Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "TopSportEventParser.java"


# instance fields
.field sendSuccessBroadcast:Z


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;-><init>()V

    .line 23
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendSuccessBroadcast:Z

    .line 21
    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 1
    .param p1, "errorCode"    # I

    .prologue
    .line 106
    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    const/4 v0, 0x2

    if-ne p1, v0, :cond_1

    .line 107
    :cond_0
    const-string v0, "com.espn.action.ACTION_TOP_SPORT_EVENT_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendBroadcast(Ljava/lang/String;)V

    .line 108
    :cond_1
    return-void
.end method

.method getListings(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 5
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

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 92
    .local p2, "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v3, "listings"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    const-string v3, "listings"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 93
    const-string v3, "listings"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 94
    .local v1, "listingArray":Lorg/json/JSONArray;
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v2

    .line 95
    .local v2, "listingArrayLength":I
    if-lez v2, :cond_0

    .line 96
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendSuccessBroadcast:Z

    .line 98
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-lt v0, v2, :cond_1

    .line 102
    .end local v0    # "i":I
    .end local v1    # "listingArray":Lorg/json/JSONArray;
    .end local v2    # "listingArrayLength":I
    :cond_0
    return-void

    .line 99
    .restart local v0    # "i":I
    .restart local v1    # "listingArray":Lorg/json/JSONArray;
    .restart local v2    # "listingArrayLength":I
    :cond_1
    sget-object v3, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    invoke-static {v4, p2}, Lcom/espn/androidplayersdk/datamanager/GenericParser;->parseAndInsertLinearEvent(Lorg/json/JSONObject;Ljava/util/HashMap;)Landroid/content/ContentValues;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoFeaturedEventsTable(Landroid/content/ContentValues;)V

    .line 98
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
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
    .local p2, "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v11, 0x0

    const/4 v10, 0x3

    .line 27
    const-string v9, "TopSportEventParser"

    invoke-static {v9, v10, v11}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 29
    :try_start_0
    const-string v9, "eventWhere"

    invoke-virtual {p2, v9}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const-string v9, "eventWhereArg"

    invoke-virtual {p2, v9}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 31
    sget-object v11, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v12, "featuredEvents"

    const-string v9, "eventWhere"

    invoke-virtual {p2, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 32
    const-string v10, "eventWhereArg"

    invoke-virtual {p2, v10}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, [Ljava/lang/String;

    .line 31
    invoke-virtual {v11, v12, v9, v10}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 34
    :cond_0
    const-string v9, "featuredTopSportEventType"

    invoke-virtual {p2, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    .line 35
    .local v2, "categoryType":Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;
    const-string v4, ""

    .line 36
    .local v4, "eventType":Ljava/lang/String;
    sget-object v9, Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;->VOD:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    if-ne v2, v9, :cond_5

    .line 37
    const-string v4, "VOD"

    .line 38
    const-string v9, "videos"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    .line 39
    .local v7, "videoArray":Lorg/json/JSONArray;
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v8

    .line 40
    .local v8, "videoArrayLength":I
    if-lez v8, :cond_1

    .line 41
    const/4 v9, 0x1

    iput-boolean v9, p0, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendSuccessBroadcast:Z

    .line 43
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    if-lt v5, v8, :cond_4

    .line 73
    .end local v5    # "i":I
    .end local v7    # "videoArray":Lorg/json/JSONArray;
    .end local v8    # "videoArrayLength":I
    :cond_1
    :goto_1
    const-string v6, ""

    .line 75
    .local v6, "resultLimit":Ljava/lang/String;
    const-string v9, "resultsCount"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    const-string v9, "resultsCount"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_2

    .line 76
    const-string v9, "resultsCount"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 77
    :cond_2
    const/4 v9, 0x0

    invoke-static {p2, v4, v6, v9}, Lcom/espn/androidplayersdk/datamanager/GenericParser;->parseAndUpdateMetaData(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 84
    iget-boolean v9, p0, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendSuccessBroadcast:Z

    if-eqz v9, :cond_3

    .line 85
    const-string v9, "com.espn.action.ACTION_TOP_SPORT_EVENT_UPDATE"

    invoke-virtual {p0, v9}, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendBroadcast(Ljava/lang/String;)V

    .line 88
    .end local v2    # "categoryType":Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;
    .end local v4    # "eventType":Ljava/lang/String;
    .end local v6    # "resultLimit":Ljava/lang/String;
    :cond_3
    :goto_2
    return-void

    .line 45
    .restart local v2    # "categoryType":Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;
    .restart local v4    # "eventType":Ljava/lang/String;
    .restart local v5    # "i":I
    .restart local v7    # "videoArray":Lorg/json/JSONArray;
    .restart local v8    # "videoArrayLength":I
    :cond_4
    :try_start_1
    sget-object v9, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v7, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v10

    invoke-static {v10, p2}, Lcom/espn/androidplayersdk/datamanager/GenericParser;->parseAndInsertVODEvent(Lorg/json/JSONObject;Ljava/util/HashMap;)Landroid/content/ContentValues;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoFeaturedEventsTable(Landroid/content/ContentValues;)V
    :try_end_1
    .catch Lcom/espn/androidplayersdk/datamanager/ParserException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 43
    :goto_3
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 46
    :catch_0
    move-exception v3

    .line 47
    .local v3, "e":Lcom/espn/androidplayersdk/datamanager/ParserException;
    :try_start_2
    const-string v9, "TopSportEventParser: No HLS Video"

    const/4 v10, 0x3

    invoke-static {v9, v10, v3}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_3

    .line 79
    .end local v2    # "categoryType":Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;
    .end local v3    # "e":Lcom/espn/androidplayersdk/datamanager/ParserException;
    .end local v4    # "eventType":Ljava/lang/String;
    .end local v5    # "i":I
    .end local v7    # "videoArray":Lorg/json/JSONArray;
    .end local v8    # "videoArrayLength":I
    :catch_1
    move-exception v3

    .line 80
    .local v3, "e":Ljava/lang/Exception;
    :try_start_3
    const-string v9, "TopSportEventParser"

    const/4 v10, 0x5

    invoke-static {v9, v10, v3}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 81
    const/4 v9, 0x0

    iput-boolean v9, p0, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendSuccessBroadcast:Z

    .line 82
    const/4 v9, 0x2

    invoke-virtual {p0, v9}, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->errorHandler(I)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 84
    iget-boolean v9, p0, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendSuccessBroadcast:Z

    if-eqz v9, :cond_3

    .line 85
    const-string v9, "com.espn.action.ACTION_TOP_SPORT_EVENT_UPDATE"

    invoke-virtual {p0, v9}, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_2

    .line 52
    .end local v3    # "e":Ljava/lang/Exception;
    .restart local v2    # "categoryType":Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;
    .restart local v4    # "eventType":Ljava/lang/String;
    :cond_5
    :try_start_4
    const-string v9, "eventType"

    invoke-virtual {p2, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 53
    const-string v9, "categories"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_6

    const-string v9, "categories"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_6

    .line 54
    const-string v9, "categories"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 55
    .local v0, "categoryArray":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v1

    .line 56
    .local v1, "categoryArrayLength":I
    if-lez v1, :cond_1

    .line 57
    const/4 v9, 0x1

    iput-boolean v9, p0, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendSuccessBroadcast:Z

    .line 58
    const/4 v5, 0x0

    .restart local v5    # "i":I
    :goto_4
    if-ge v5, v1, :cond_1

    .line 59
    invoke-virtual {v0, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    invoke-virtual {p0, v9, p2}, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->getListings(Lorg/json/JSONObject;Ljava/util/HashMap;)V

    .line 58
    add-int/lit8 v5, v5, 0x1

    goto :goto_4

    .line 62
    .end local v0    # "categoryArray":Lorg/json/JSONArray;
    .end local v1    # "categoryArrayLength":I
    .end local v5    # "i":I
    :cond_6
    const-string v9, "subcategories"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_7

    const-string v9, "subcategories"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_7

    .line 63
    const-string v9, "subcategories"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 64
    .restart local v0    # "categoryArray":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v1

    .line 65
    .restart local v1    # "categoryArrayLength":I
    if-lez v1, :cond_1

    .line 66
    const/4 v9, 0x1

    iput-boolean v9, p0, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendSuccessBroadcast:Z

    .line 67
    const/4 v5, 0x0

    .restart local v5    # "i":I
    :goto_5
    if-ge v5, v1, :cond_1

    .line 68
    invoke-virtual {v0, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    invoke-virtual {p0, v9, p2}, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->getListings(Lorg/json/JSONObject;Ljava/util/HashMap;)V

    .line 67
    add-int/lit8 v5, v5, 0x1

    goto :goto_5

    .line 71
    .end local v0    # "categoryArray":Lorg/json/JSONArray;
    .end local v1    # "categoryArrayLength":I
    .end local v5    # "i":I
    :cond_7
    invoke-virtual {p0, p1, p2}, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->getListings(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_1

    .line 83
    .end local v2    # "categoryType":Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;
    .end local v4    # "eventType":Ljava/lang/String;
    :catchall_0
    move-exception v9

    .line 84
    iget-boolean v10, p0, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendSuccessBroadcast:Z

    if-eqz v10, :cond_8

    .line 85
    const-string v10, "com.espn.action.ACTION_TOP_SPORT_EVENT_UPDATE"

    invoke-virtual {p0, v10}, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;->sendBroadcast(Ljava/lang/String;)V

    .line 86
    :cond_8
    throw v9
.end method
