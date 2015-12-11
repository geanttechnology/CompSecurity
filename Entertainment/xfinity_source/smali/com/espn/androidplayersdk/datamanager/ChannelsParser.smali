.class Lcom/espn/androidplayersdk/datamanager/ChannelsParser;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "ChannelsParser.java"


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
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendSuccessBroadcast:Z

    .line 25
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendPartialErrorBroadcast:Z

    .line 22
    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 1
    .param p1, "errorCode"    # I

    .prologue
    .line 132
    const/4 v0, 0x2

    if-ne p1, v0, :cond_0

    .line 133
    const-string v0, "com.espn.action.CHANNEL_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 134
    :cond_0
    return-void
.end method

.method public parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 16
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
    const-string v12, "ChannelsParser.parse"

    const/4 v13, 0x3

    const/4 v14, 0x0

    invoke-static {v12, v13, v14}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 33
    :try_start_0
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 34
    .local v3, "channelValues":Landroid/content/ContentValues;
    const-string v12, "networks"

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 37
    .local v4, "channelsArray":Lorg/json/JSONArray;
    sget-object v12, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v13, "channel"

    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-virtual {v12, v13, v14, v15}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 39
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v1

    .line 41
    .local v1, "channelArrayLength":I
    if-lez v1, :cond_2

    .line 42
    const/4 v12, 0x1

    move-object/from16 v0, p0

    iput-boolean v12, v0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendSuccessBroadcast:Z

    .line 44
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    if-lt v7, v1, :cond_4

    .line 101
    new-instance v9, Landroid/content/ContentValues;

    invoke-direct {v9}, Landroid/content/ContentValues;-><init>()V

    .line 103
    .local v9, "metaValues":Landroid/content/ContentValues;
    if-eqz p2, :cond_0

    const-string v12, "ttl"

    move-object/from16 v0, p2

    invoke-virtual {v0, v12}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v12

    if-eqz v12, :cond_0

    .line 105
    :try_start_1
    const-string v13, "TTL"

    const-string v12, "ttl"

    move-object/from16 v0, p2

    invoke-virtual {v0, v12}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-static {v12}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v12

    invoke-static {v12}, Lcom/espn/androidplayersdk/utilities/Utils;->getExpiryTime(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v9, v13, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 111
    :cond_0
    :goto_1
    :try_start_2
    const-string v12, "omniture"

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_1

    const-string v12, "omniture"

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_1

    .line 112
    const-string v12, "omnitureJason"

    const-string v13, "omniture"

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v13

    invoke-virtual {v13}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v9, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    :cond_1
    sget-object v12, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v12, v9}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertOrUpdateMetaChannelTable(Landroid/content/ContentValues;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 123
    .end local v7    # "i":I
    .end local v9    # "metaValues":Landroid/content/ContentValues;
    :cond_2
    move-object/from16 v0, p0

    iget-boolean v12, v0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendSuccessBroadcast:Z

    if-eqz v12, :cond_15

    .line 124
    const-string v12, "com.espn.action.CHANNELS_UPDATED"

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 128
    .end local v1    # "channelArrayLength":I
    .end local v3    # "channelValues":Landroid/content/ContentValues;
    .end local v4    # "channelsArray":Lorg/json/JSONArray;
    :cond_3
    :goto_2
    return-void

    .line 46
    .restart local v1    # "channelArrayLength":I
    .restart local v3    # "channelValues":Landroid/content/ContentValues;
    .restart local v4    # "channelsArray":Lorg/json/JSONArray;
    .restart local v7    # "i":I
    :cond_4
    :try_start_3
    invoke-virtual {v3}, Landroid/content/ContentValues;->clear()V

    .line 47
    invoke-virtual {v4, v7}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 48
    .local v5, "channelsObject":Lorg/json/JSONObject;
    const-string v12, "name"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_5

    const-string v12, "name"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_5

    .line 49
    const-string v12, "channelName"

    const-string v13, "name"

    invoke-virtual {v5, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    :cond_5
    const-string v12, "type"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_6

    const-string v12, "type"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_6

    .line 52
    const-string v12, "type"

    const-string v13, "type"

    invoke-virtual {v5, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    :cond_6
    const-string v12, "id"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_7

    const-string v12, "id"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_7

    .line 55
    const-string v12, "id"

    const-string v13, "id"

    invoke-virtual {v5, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    :cond_7
    const-string v12, "abbreviation"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_8

    const-string v12, "abbreviation"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_8

    .line 58
    const-string v12, "code"

    const-string v13, "abbreviation"

    invoke-virtual {v5, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    :cond_8
    const-string v12, "isActive"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_9

    const-string v12, "isActive"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_9

    .line 61
    const-string v12, "isActive"

    const-string v13, "isActive"

    invoke-virtual {v5, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    :cond_9
    const-string v12, "adobeResource"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_a

    const-string v12, "adobeResource"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_a

    .line 64
    const-string v12, "resourceId"

    const-string v13, "adobeResource"

    invoke-virtual {v5, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    :cond_a
    const-string v12, "images"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_e

    const-string v12, "images"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_e

    .line 68
    const-string v12, "images"

    invoke-virtual {v5, v12}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 70
    .local v2, "channelImageObj":Lorg/json/JSONObject;
    const-string v12, "small"

    invoke-virtual {v2, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_b

    const-string v12, "small"

    invoke-virtual {v2, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_b

    .line 71
    const-string v12, "small"

    invoke-virtual {v2, v12}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v10

    .line 72
    .local v10, "smallImageObj":Lorg/json/JSONObject;
    const-string v12, "ImageSmall"

    const-string v13, "href"

    invoke-virtual {v10, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    .end local v10    # "smallImageObj":Lorg/json/JSONObject;
    :cond_b
    const-string v12, "slates"

    invoke-virtual {v2, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_e

    const-string v12, "slates"

    invoke-virtual {v2, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_e

    .line 76
    const-string v12, "slates"

    invoke-virtual {v2, v12}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    .line 77
    .local v8, "imageSlateObj":Lorg/json/JSONObject;
    const-string v12, "small"

    invoke-virtual {v8, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_c

    const-string v12, "small"

    invoke-virtual {v8, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_c

    .line 78
    const-string v12, "small"

    invoke-virtual {v8, v12}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    .line 79
    .local v11, "smallSlateObj":Lorg/json/JSONObject;
    const-string v12, "slateImageSmall"

    const-string v13, "href"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    .end local v11    # "smallSlateObj":Lorg/json/JSONObject;
    :cond_c
    const-string v12, "medium"

    invoke-virtual {v8, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_d

    const-string v12, "medium"

    invoke-virtual {v8, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_d

    .line 82
    const-string v12, "medium"

    invoke-virtual {v8, v12}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    .line 83
    .restart local v11    # "smallSlateObj":Lorg/json/JSONObject;
    const-string v12, "slateImageMedium"

    const-string v13, "href"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    .end local v11    # "smallSlateObj":Lorg/json/JSONObject;
    :cond_d
    const-string v12, "large"

    invoke-virtual {v8, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_e

    const-string v12, "large"

    invoke-virtual {v8, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_e

    .line 86
    const-string v12, "large"

    invoke-virtual {v8, v12}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    .line 87
    .restart local v11    # "smallSlateObj":Lorg/json/JSONObject;
    const-string v12, "slateImageLarge"

    const-string v13, "href"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    .end local v2    # "channelImageObj":Lorg/json/JSONObject;
    .end local v8    # "imageSlateObj":Lorg/json/JSONObject;
    .end local v11    # "smallSlateObj":Lorg/json/JSONObject;
    :cond_e
    sget-object v12, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v12, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoChannelsTable(Landroid/content/ContentValues;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 44
    .end local v5    # "channelsObject":Lorg/json/JSONObject;
    :goto_3
    add-int/lit8 v7, v7, 0x1

    goto/16 :goto_0

    .line 94
    :catch_0
    move-exception v6

    .line 95
    .local v6, "e":Ljava/lang/Exception;
    :try_start_4
    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "ChannelsParser: Error: "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    if-eqz v12, :cond_f

    invoke-virtual {v6}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v12

    :goto_4
    const/4 v13, 0x5

    const/4 v14, 0x0

    invoke-static {v12, v13, v14}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 96
    const/4 v12, 0x0

    move-object/from16 v0, p0

    iput-boolean v12, v0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendSuccessBroadcast:Z

    .line 97
    const/4 v12, 0x1

    move-object/from16 v0, p0

    iput-boolean v12, v0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendPartialErrorBroadcast:Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_3

    .line 117
    .end local v1    # "channelArrayLength":I
    .end local v3    # "channelValues":Landroid/content/ContentValues;
    .end local v4    # "channelsArray":Lorg/json/JSONArray;
    .end local v6    # "e":Ljava/lang/Exception;
    .end local v7    # "i":I
    :catch_1
    move-exception v6

    .line 118
    .restart local v6    # "e":Ljava/lang/Exception;
    :try_start_5
    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "ChannelsParser: Error: "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    if-eqz v12, :cond_12

    invoke-virtual {v6}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v12

    :goto_5
    const/4 v13, 0x5

    const/4 v14, 0x0

    invoke-static {v12, v13, v14}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 119
    const/4 v12, 0x0

    move-object/from16 v0, p0

    iput-boolean v12, v0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendSuccessBroadcast:Z

    .line 120
    const/4 v12, 0x0

    move-object/from16 v0, p0

    iput-boolean v12, v0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendPartialErrorBroadcast:Z

    .line 121
    const/4 v12, 0x2

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->errorHandler(I)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 123
    move-object/from16 v0, p0

    iget-boolean v12, v0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendSuccessBroadcast:Z

    if-eqz v12, :cond_13

    .line 124
    const-string v12, "com.espn.action.CHANNELS_UPDATED"

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 95
    .restart local v1    # "channelArrayLength":I
    .restart local v3    # "channelValues":Landroid/content/ContentValues;
    .restart local v4    # "channelsArray":Lorg/json/JSONArray;
    .restart local v7    # "i":I
    :cond_f
    :try_start_6
    const-string v12, ""

    goto :goto_4

    .line 106
    .end local v6    # "e":Ljava/lang/Exception;
    .restart local v9    # "metaValues":Landroid/content/ContentValues;
    :catch_2
    move-exception v6

    .line 107
    .restart local v6    # "e":Ljava/lang/Exception;
    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "ChannelsParser: Error: "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    if-eqz v12, :cond_11

    invoke-virtual {v6}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v12

    :goto_6
    const/4 v13, 0x5

    const/4 v14, 0x0

    invoke-static {v12, v13, v14}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 108
    const-string v12, "TTL"

    const-string v13, ""

    invoke-virtual {v9, v12, v13}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_1

    .line 122
    .end local v1    # "channelArrayLength":I
    .end local v3    # "channelValues":Landroid/content/ContentValues;
    .end local v4    # "channelsArray":Lorg/json/JSONArray;
    .end local v6    # "e":Ljava/lang/Exception;
    .end local v7    # "i":I
    .end local v9    # "metaValues":Landroid/content/ContentValues;
    :catchall_0
    move-exception v12

    .line 123
    move-object/from16 v0, p0

    iget-boolean v13, v0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendSuccessBroadcast:Z

    if-eqz v13, :cond_14

    .line 124
    const-string v13, "com.espn.action.CHANNELS_UPDATED"

    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendBroadcast(Ljava/lang/String;)V

    .line 127
    :cond_10
    :goto_7
    throw v12

    .line 107
    .restart local v1    # "channelArrayLength":I
    .restart local v3    # "channelValues":Landroid/content/ContentValues;
    .restart local v4    # "channelsArray":Lorg/json/JSONArray;
    .restart local v6    # "e":Ljava/lang/Exception;
    .restart local v7    # "i":I
    .restart local v9    # "metaValues":Landroid/content/ContentValues;
    :cond_11
    :try_start_7
    const-string v12, ""
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto :goto_6

    .line 118
    .end local v1    # "channelArrayLength":I
    .end local v3    # "channelValues":Landroid/content/ContentValues;
    .end local v4    # "channelsArray":Lorg/json/JSONArray;
    .end local v7    # "i":I
    .end local v9    # "metaValues":Landroid/content/ContentValues;
    :cond_12
    :try_start_8
    const-string v12, ""
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto :goto_5

    .line 125
    :cond_13
    move-object/from16 v0, p0

    iget-boolean v12, v0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendPartialErrorBroadcast:Z

    if-eqz v12, :cond_3

    .line 126
    const-string v12, "com.espn.action.CHANNEL_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 125
    .end local v6    # "e":Ljava/lang/Exception;
    :cond_14
    move-object/from16 v0, p0

    iget-boolean v13, v0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendPartialErrorBroadcast:Z

    if-eqz v13, :cond_10

    .line 126
    const-string v13, "com.espn.action.CHANNEL_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_7

    .line 125
    .restart local v1    # "channelArrayLength":I
    .restart local v3    # "channelValues":Landroid/content/ContentValues;
    .restart local v4    # "channelsArray":Lorg/json/JSONArray;
    :cond_15
    move-object/from16 v0, p0

    iget-boolean v12, v0, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendPartialErrorBroadcast:Z

    if-eqz v12, :cond_3

    .line 126
    const-string v12, "com.espn.action.CHANNEL_PARTIAL_DATA_ERROR"

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_2
.end method
