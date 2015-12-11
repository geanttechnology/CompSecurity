.class Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "TrendingEventsParser.java"


# instance fields
.field sendSuccessBroadcast:Z


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;-><init>()V

    .line 22
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->sendSuccessBroadcast:Z

    .line 20
    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 1
    .param p1, "errorCode"    # I

    .prologue
    .line 78
    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    const/4 v0, 0x2

    if-ne p1, v0, :cond_1

    .line 79
    :cond_0
    const-string v0, "com.espn.action.FEATURED_TRENDING_EVENT_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 80
    :cond_1
    return-void
.end method

.method public parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 11
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
    .local p2, "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    const-string v7, "eventWhere"

    invoke-virtual {p2, v7}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    const-string v7, "eventWhereArg"

    invoke-virtual {p2, v7}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 30
    sget-object v9, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v10, "featuredEvents"

    const-string v7, "eventWhere"

    invoke-virtual {p2, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 31
    const-string v8, "eventWhereArg"

    invoke-virtual {p2, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, [Ljava/lang/String;

    .line 30
    invoke-virtual {v9, v10, v7, v8}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 33
    :cond_0
    const-string v7, "listings"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    const-string v7, "listings"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 34
    const-string v7, "listings"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 35
    .local v2, "listingArray":Lorg/json/JSONArray;
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    .line 36
    .local v3, "listingArrayLength":I
    if-lez v3, :cond_1

    .line 37
    const/4 v7, 0x1

    iput-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->sendSuccessBroadcast:Z

    .line 39
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-lt v1, v3, :cond_5

    .line 44
    .end local v1    # "i":I
    .end local v2    # "listingArray":Lorg/json/JSONArray;
    .end local v3    # "listingArrayLength":I
    :cond_1
    const-string v7, "videos"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    const-string v7, "videos"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_2

    .line 45
    const-string v7, "videos"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    .line 46
    .local v5, "videoArray":Lorg/json/JSONArray;
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v6

    .line 47
    .local v6, "videoArrayLength":I
    if-lez v6, :cond_2

    .line 48
    const/4 v7, 0x1

    iput-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->sendSuccessBroadcast:Z

    .line 50
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_1
    if-lt v1, v6, :cond_6

    .line 61
    .end local v1    # "i":I
    .end local v5    # "videoArray":Lorg/json/JSONArray;
    .end local v6    # "videoArrayLength":I
    :cond_2
    const-string v4, ""

    .line 62
    .local v4, "resultLimit":Ljava/lang/String;
    const-string v7, "resultsCount"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    const-string v7, "resultsCount"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    .line 63
    const-string v7, "resultsCount"

    invoke-virtual {p1, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 64
    :cond_3
    const-string v7, "trending"

    const/4 v8, 0x0

    invoke-static {p2, v7, v4, v8}, Lcom/espn/androidplayersdk/datamanager/GenericParser;->parseAndUpdateMetaData(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 71
    iget-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->sendSuccessBroadcast:Z

    if-eqz v7, :cond_4

    .line 72
    const-string v7, "com.espn.action.FEATURED_TRENDING_EVENT_UPDATED"

    invoke-virtual {p0, v7}, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 74
    .end local v4    # "resultLimit":Ljava/lang/String;
    :cond_4
    :goto_2
    return-void

    .line 40
    .restart local v1    # "i":I
    .restart local v2    # "listingArray":Lorg/json/JSONArray;
    .restart local v3    # "listingArrayLength":I
    :cond_5
    :try_start_1
    sget-object v7, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v8

    invoke-static {v8, p2}, Lcom/espn/androidplayersdk/datamanager/GenericParser;->parseAndInsertLinearEvent(Lorg/json/JSONObject;Ljava/util/HashMap;)Landroid/content/ContentValues;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoFeaturedEventsTable(Landroid/content/ContentValues;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 39
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 52
    .end local v2    # "listingArray":Lorg/json/JSONArray;
    .end local v3    # "listingArrayLength":I
    .restart local v5    # "videoArray":Lorg/json/JSONArray;
    .restart local v6    # "videoArrayLength":I
    :cond_6
    :try_start_2
    sget-object v7, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v5, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v8

    invoke-static {v8, p2}, Lcom/espn/androidplayersdk/datamanager/GenericParser;->parseAndInsertVODEvent(Lorg/json/JSONObject;Ljava/util/HashMap;)Landroid/content/ContentValues;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoFeaturedEventsTable(Landroid/content/ContentValues;)V
    :try_end_2
    .catch Lcom/espn/androidplayersdk/datamanager/ParserException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 50
    :goto_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 53
    :catch_0
    move-exception v0

    .line 54
    .local v0, "e":Lcom/espn/androidplayersdk/datamanager/ParserException;
    :try_start_3
    const-string v7, "TopSportEventParser: No HLS Video"

    const/4 v8, 0x3

    invoke-static {v7, v8, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_3

    .line 66
    .end local v0    # "e":Lcom/espn/androidplayersdk/datamanager/ParserException;
    .end local v1    # "i":I
    .end local v5    # "videoArray":Lorg/json/JSONArray;
    .end local v6    # "videoArrayLength":I
    :catch_1
    move-exception v0

    .line 67
    .local v0, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v7, "TrendingEventsParser"

    const/4 v8, 0x5

    invoke-static {v7, v8, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 68
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->sendSuccessBroadcast:Z

    .line 69
    const/4 v7, 0x2

    invoke-virtual {p0, v7}, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->errorHandler(I)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 71
    iget-boolean v7, p0, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->sendSuccessBroadcast:Z

    if-eqz v7, :cond_4

    .line 72
    const-string v7, "com.espn.action.FEATURED_TRENDING_EVENT_UPDATED"

    invoke-virtual {p0, v7}, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_2

    .line 70
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v7

    .line 71
    iget-boolean v8, p0, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->sendSuccessBroadcast:Z

    if-eqz v8, :cond_7

    .line 72
    const-string v8, "com.espn.action.FEATURED_TRENDING_EVENT_UPDATED"

    invoke-virtual {p0, v8}, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 73
    :cond_7
    throw v7
.end method
