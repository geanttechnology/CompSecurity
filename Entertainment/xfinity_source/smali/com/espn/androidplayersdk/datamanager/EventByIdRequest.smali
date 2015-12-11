.class Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;
.super Ljava/lang/Thread;
.source "EventByIdRequest.java"


# instance fields
.field eventId:Ljava/lang/String;

.field listener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

.field mCallBack:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 385
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;-><init>(Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->listener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    .line 33
    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;)V
    .locals 1
    .param p1, "eventId"    # Ljava/lang/String;
    .param p2, "pCallback"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 385
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;-><init>(Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->listener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    .line 36
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->eventId:Ljava/lang/String;

    .line 37
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->mCallBack:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    .line 38
    return-void
.end method


# virtual methods
.method parse(Lorg/json/JSONObject;)Lcom/espn/androidplayersdk/datamanager/EPEvents;
    .locals 22
    .param p1, "object"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 264
    const-string v19, "EventByIdRequest:"

    const/16 v20, 0x3

    const/16 v21, 0x0

    invoke-static/range {v19 .. v21}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 266
    const/4 v5, 0x0

    .line 267
    .local v5, "events":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    const-string v19, "listings"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v12

    .line 268
    .local v12, "listingsArray":Lorg/json/JSONArray;
    invoke-virtual {v12}, Lorg/json/JSONArray;->length()I

    move-result v13

    .line 270
    .local v13, "listingsArrayLength":I
    if-lez v13, :cond_14

    .line 272
    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-virtual {v12, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    .line 274
    .local v6, "eventsObject":Lorg/json/JSONObject;
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 276
    .local v9, "items":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v19, "name"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_0

    const-string v19, "name"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_0

    .line 277
    const-string v19, "eventName"

    const-string v20, "name"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 278
    const-string v19, "showName"

    const-string v20, "name"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 281
    :cond_0
    const-string v19, "id"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_1

    const-string v19, "id"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_1

    .line 282
    const-string v19, "eventId"

    const-string v20, "id"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 284
    :cond_1
    const-string v19, "simulcastAiringId"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_2

    const-string v19, "simulcastAiringId"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_2

    .line 285
    const-string v19, "simulcastAiringId"

    const-string v20, "simulcastAiringId"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 287
    :cond_2
    const-string v19, "type"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_3

    const-string v19, "type"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_3

    .line 288
    const-string v19, "eventType"

    const-string v20, "type"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 290
    :cond_3
    const-string v19, "broadcastStartTime"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_4

    const-string v19, "broadcastStartTime"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_4

    .line 291
    const-string v19, "broadcastStartTime"

    const-string v20, "broadcastStartTime"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 293
    :cond_4
    const-string v19, "startTime"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_5

    const-string v19, "startTime"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_5

    .line 294
    const-string v19, "startTime"

    const-string v20, "startTime"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 296
    :cond_5
    const-string v19, "endTime"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_6

    const-string v19, "endTime"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_6

    .line 297
    const-string v19, "endTime"

    const-string v20, "endTime"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 299
    :cond_6
    const-string v19, "thumbnails"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_9

    const-string v19, "thumbnails"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_9

    .line 300
    const-string v19, "thumbnails"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    .line 302
    .local v8, "imageObj":Lorg/json/JSONObject;
    const-string v19, "small"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_7

    const-string v19, "small"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_7

    .line 303
    const-string v19, "small"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v15

    .line 304
    .local v15, "small":Lorg/json/JSONObject;
    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_7

    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_7

    .line 305
    const-string v19, "imageSmall"

    const-string v20, "href"

    move-object/from16 v0, v20

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 308
    .end local v15    # "small":Lorg/json/JSONObject;
    :cond_7
    const-string v19, "medium"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_8

    const-string v19, "medium"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_8

    .line 309
    const-string v19, "medium"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v14

    .line 310
    .local v14, "med":Lorg/json/JSONObject;
    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_8

    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_8

    .line 311
    const-string v19, "imageMed"

    const-string v20, "href"

    move-object/from16 v0, v20

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 314
    .end local v14    # "med":Lorg/json/JSONObject;
    :cond_8
    const-string v19, "large"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_9

    const-string v19, "large"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_9

    .line 315
    const-string v19, "large"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v10

    .line 316
    .local v10, "large":Lorg/json/JSONObject;
    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_9

    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_9

    .line 317
    const-string v19, "imageLarge"

    const-string v20, "href"

    move-object/from16 v0, v20

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 321
    .end local v8    # "imageObj":Lorg/json/JSONObject;
    .end local v10    # "large":Lorg/json/JSONObject;
    :cond_9
    const-string v19, "subcategories"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_b

    const-string v19, "subcategories"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_b

    .line 322
    const-string v19, "subcategories"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v17

    .line 323
    .local v17, "subCatArray":Lorg/json/JSONArray;
    invoke-virtual/range {v17 .. v17}, Lorg/json/JSONArray;->length()I

    move-result v19

    if-lez v19, :cond_b

    .line 324
    const/16 v19, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v18

    .line 325
    .local v18, "subCatObj":Lorg/json/JSONObject;
    const-string v19, "id"

    invoke-virtual/range {v18 .. v19}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_a

    const-string v19, "id"

    invoke-virtual/range {v18 .. v19}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_a

    .line 326
    const-string v19, "league"

    const-string v20, "id"

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 327
    :cond_a
    const-string v19, "name"

    invoke-virtual/range {v18 .. v19}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_b

    const-string v19, "name"

    invoke-virtual/range {v18 .. v19}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_b

    .line 328
    const-string v19, "leagueName"

    const-string v20, "name"

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 332
    .end local v17    # "subCatArray":Lorg/json/JSONArray;
    .end local v18    # "subCatObj":Lorg/json/JSONObject;
    :cond_b
    const-string v19, "parentalRating"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_c

    const-string v19, "parentalRating"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_c

    .line 333
    const-string v19, "parentalRating"

    const-string v20, "parentalRating"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 335
    :cond_c
    const-string v19, "seekInSeconds"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_d

    const-string v19, "seekInSeconds"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_d

    .line 336
    const-string v19, "seekInSeconds"

    const-string v20, "seekInSeconds"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 338
    :cond_d
    const-string v19, "broadcasts"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_11

    const-string v19, "broadcasts"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_11

    .line 339
    const-string v19, "broadcasts"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 340
    .local v2, "broadcastArray":Lorg/json/JSONArray;
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v19

    if-lez v19, :cond_11

    .line 341
    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 342
    .local v3, "broadcastObj":Lorg/json/JSONObject;
    const-string v19, "abbreviation"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_e

    const-string v19, "abbreviation"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_e

    .line 343
    const-string v19, "networkCode"

    const-string v20, "abbreviation"

    move-object/from16 v0, v20

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 345
    :cond_e
    const-string v19, "name"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_f

    const-string v19, "name"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_f

    .line 346
    const-string v19, "networkName"

    const-string v20, "name"

    move-object/from16 v0, v20

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 348
    :cond_f
    const-string v19, "ncsId"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_10

    const-string v19, "ncsId"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_10

    .line 349
    const-string v19, "networkId"

    const-string v20, "ncsId"

    move-object/from16 v0, v20

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 352
    :cond_10
    const-string v19, "adobeResource"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_11

    const-string v19, "adobeResource"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_11

    .line 353
    const-string v19, "networkResourceId"

    const-string v20, "adobeResource"

    move-object/from16 v0, v20

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 358
    .end local v2    # "broadcastArray":Lorg/json/JSONArray;
    .end local v3    # "broadcastObj":Lorg/json/JSONObject;
    :cond_11
    const-string v19, "description"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_12

    const-string v19, "description"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_12

    .line 359
    const-string v19, "description"

    const-string v20, "description"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 361
    :cond_12
    const-string v19, "links"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_13

    const-string v19, "links"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_13

    .line 362
    const-string v19, "links"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    .line 363
    .local v11, "linksObj":Lorg/json/JSONObject;
    const-string v19, "source"

    move-object/from16 v0, v19

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_13

    const-string v19, "source"

    move-object/from16 v0, v19

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_13

    .line 364
    const-string v19, "source"

    move-object/from16 v0, v19

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v16

    .line 365
    .local v16, "sourceObj":Lorg/json/JSONObject;
    const-string v19, "hls"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_13

    const-string v19, "hls"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_13

    .line 366
    const-string v19, "hls"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    .line 368
    .local v7, "hlsObj":Lorg/json/JSONObject;
    const-string v19, "default"

    move-object/from16 v0, v19

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_13

    const-string v19, "default"

    move-object/from16 v0, v19

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_13

    .line 369
    const-string v19, "default"

    move-object/from16 v0, v19

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 370
    .local v4, "dfltObj":Lorg/json/JSONObject;
    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_13

    const-string v19, "href"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_13

    .line 371
    const-string v19, "defaultStartSessionUrl"

    const-string v20, "href"

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v9, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 378
    .end local v4    # "dfltObj":Lorg/json/JSONObject;
    .end local v7    # "hlsObj":Lorg/json/JSONObject;
    .end local v11    # "linksObj":Lorg/json/JSONObject;
    .end local v16    # "sourceObj":Lorg/json/JSONObject;
    :cond_13
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPEvents;

    .end local v5    # "events":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    invoke-direct {v5, v9}, Lcom/espn/androidplayersdk/datamanager/EPEvents;-><init>(Ljava/util/HashMap;)V

    .line 382
    .end local v6    # "eventsObject":Lorg/json/JSONObject;
    .end local v9    # "items":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v5    # "events":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    :cond_14
    return-object v5
.end method

.method parse(Lorg/json/JSONObject;Ljava/util/HashMap;)Lcom/espn/androidplayersdk/datamanager/EPEvents;
    .locals 29
    .param p1, "object"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Lcom/espn/androidplayersdk/datamanager/EPEvents;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 52
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v26, "EventByIdRequest.parse()"

    const/16 v27, 0x3

    const/16 v28, 0x0

    invoke-static/range {v26 .. v28}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 53
    const/4 v8, 0x0

    .line 54
    .local v8, "events":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    new-instance v12, Ljava/util/HashMap;

    invoke-direct {v12}, Ljava/util/HashMap;-><init>()V

    .line 55
    .local v12, "items":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 57
    .local v7, "eventValues":Landroid/content/ContentValues;
    const-string v26, "listings"

    move-object/from16 v0, p1

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v16

    .line 58
    .local v16, "listingsArray":Lorg/json/JSONArray;
    invoke-virtual/range {v16 .. v16}, Lorg/json/JSONArray;->length()I

    move-result v15

    .line 60
    .local v15, "listingArrayLength":I
    if-lez v15, :cond_1f

    .line 62
    const/16 v26, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    .line 64
    .local v9, "eventsObject":Lorg/json/JSONObject;
    const-string v26, "broadcastStartTime"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_0

    const-string v26, "broadcastStartTime"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_0

    .line 65
    const-string v26, "broadcastStartTime"

    const-string v27, "broadcastStartTime"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    const-string v26, "broadcastStartTime"

    const-string v27, "broadcastStartTime"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    :cond_0
    const-string v26, "description"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1

    const-string v26, "description"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1

    .line 70
    const-string v26, "description"

    const-string v27, "description"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    const-string v26, "description"

    const-string v27, "description"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    :cond_1
    const-string v26, "blackouts"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_2

    const-string v26, "blackouts"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_2

    .line 75
    const-string v26, "coverageType"

    const-string v27, "blackouts"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v27

    invoke-virtual/range {v27 .. v27}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    :cond_2
    const-string v26, "categories"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_4

    const-string v26, "categories"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_4

    .line 78
    const-string v26, "categories"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 79
    .local v4, "categoryArray":Lorg/json/JSONArray;
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v26

    if-lez v26, :cond_4

    .line 80
    const/16 v26, 0x0

    move/from16 v0, v26

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 81
    .local v5, "categoryObj":Lorg/json/JSONObject;
    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_3

    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_3

    .line 82
    const-string v26, "SPORT"

    const-string v27, "name"

    move-object/from16 v0, v27

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    :cond_3
    const-string v26, "abbreviation"

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_4

    const-string v26, "abbreviation"

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_4

    .line 84
    const-string v26, "sportCode"

    const-string v27, "abbreviation"

    move-object/from16 v0, v27

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    .end local v4    # "categoryArray":Lorg/json/JSONArray;
    .end local v5    # "categoryObj":Lorg/json/JSONObject;
    :cond_4
    const-string v26, "program"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_5

    const-string v26, "program"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_5

    .line 89
    const-string v26, "program"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v21

    .line 90
    .local v21, "programObj":Lorg/json/JSONObject;
    const-string v26, "code"

    move-object/from16 v0, v21

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_5

    const-string v26, "code"

    move-object/from16 v0, v21

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_5

    .line 91
    const-string v26, "programingCode"

    const-string v27, "code"

    move-object/from16 v0, v21

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    .end local v21    # "programObj":Lorg/json/JSONObject;
    :cond_5
    const-string v26, "type"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_6

    const-string v26, "type"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_6

    .line 95
    const-string v26, "eventType"

    const-string v27, "type"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    const-string v26, "eventType"

    const-string v27, "type"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    :cond_6
    const-string v26, "endTime"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_7

    const-string v26, "endTime"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_7

    .line 100
    const-string v26, "endTime"

    const-string v27, "endTime"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    const-string v26, "endTime"

    const-string v27, "endTime"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    :cond_7
    const-string v26, "subcategories"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_9

    const-string v26, "subcategories"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_9

    .line 105
    const-string v26, "subcategories"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v24

    .line 106
    .local v24, "subCatArray":Lorg/json/JSONArray;
    invoke-virtual/range {v24 .. v24}, Lorg/json/JSONArray;->length()I

    move-result v26

    if-lez v26, :cond_9

    .line 107
    const/16 v26, 0x0

    move-object/from16 v0, v24

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v25

    .line 108
    .local v25, "subCatObj":Lorg/json/JSONObject;
    const-string v26, "id"

    invoke-virtual/range {v25 .. v26}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_8

    const-string v26, "id"

    invoke-virtual/range {v25 .. v26}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_8

    .line 109
    const-string v26, "league"

    const-string v27, "id"

    move-object/from16 v0, v25

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 110
    :cond_8
    const-string v26, "name"

    invoke-virtual/range {v25 .. v26}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_9

    const-string v26, "name"

    invoke-virtual/range {v25 .. v26}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_9

    .line 111
    const-string v26, "leagueName"

    const-string v27, "name"

    move-object/from16 v0, v25

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 115
    .end local v24    # "subCatArray":Lorg/json/JSONArray;
    .end local v25    # "subCatObj":Lorg/json/JSONObject;
    :cond_9
    const-string v26, "broadcasts"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_d

    const-string v26, "broadcasts"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_d

    .line 116
    const-string v26, "broadcasts"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 117
    .local v2, "broadcastArray":Lorg/json/JSONArray;
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v26

    if-lez v26, :cond_d

    .line 118
    const/16 v26, 0x0

    move/from16 v0, v26

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 119
    .local v3, "broadcastObj":Lorg/json/JSONObject;
    const-string v26, "abbreviation"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_a

    const-string v26, "abbreviation"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_a

    .line 120
    const-string v26, "networkCode"

    const-string v27, "abbreviation"

    move-object/from16 v0, v27

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    const-string v26, "networkCode"

    const-string v27, "abbreviation"

    move-object/from16 v0, v27

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 123
    :cond_a
    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_b

    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_b

    .line 124
    const-string v26, "networkName"

    const-string v27, "name"

    move-object/from16 v0, v27

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    const-string v26, "networkName"

    const-string v27, "name"

    move-object/from16 v0, v27

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    :cond_b
    const-string v26, "ncsId"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_c

    const-string v26, "ncsId"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_c

    .line 128
    const-string v26, "networkId"

    const-string v27, "ncsId"

    move-object/from16 v0, v27

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    const-string v26, "networkId"

    const-string v27, "ncsId"

    move-object/from16 v0, v27

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    :cond_c
    const-string v26, "adobeResource"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_d

    const-string v26, "adobeResource"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_d

    .line 133
    const-string v26, "networkResourceId"

    const-string v27, "adobeResource"

    move-object/from16 v0, v27

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    const-string v26, "networkResourceId"

    const-string v27, "adobeResource"

    move-object/from16 v0, v27

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 140
    .end local v2    # "broadcastArray":Lorg/json/JSONArray;
    .end local v3    # "broadcastObj":Lorg/json/JSONObject;
    :cond_d
    const-string v26, "guid"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_e

    const-string v26, "guid"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_e

    .line 141
    const-string v26, "guid"

    const-string v27, "guid"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    const-string v26, "guid"

    const-string v27, "guid"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    :cond_e
    const-string v26, "startTime"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_f

    const-string v26, "startTime"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_f

    .line 146
    const-string v26, "startTime"

    const-string v27, "startTime"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    const-string v26, "startTime"

    const-string v27, "startTime"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 150
    :cond_f
    const-string v26, "id"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_10

    const-string v26, "id"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_10

    .line 151
    const-string v26, "eventId"

    const-string v27, "id"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 153
    const-string v26, "eventId"

    const-string v27, "id"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 156
    :cond_10
    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_11

    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_11

    .line 157
    const-string v26, "showName"

    const-string v27, "name"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    const-string v26, "eventName"

    const-string v27, "name"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 160
    const-string v26, "showName"

    const-string v27, "name"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    :cond_11
    const-string v26, "simulcastAiringId"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_12

    const-string v26, "simulcastAiringId"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_12

    .line 164
    const-string v26, "simulcastAiringId"

    const-string v27, "simulcastAiringId"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    const-string v26, "simulcastAiringId"

    const-string v27, "simulcastAiringId"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 169
    :cond_12
    const-string v26, "seekInSeconds"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_13

    const-string v26, "seekInSeconds"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_13

    .line 170
    const-string v26, "seekInSeconds"

    const-string v27, "seekInSeconds"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 171
    const-string v26, "seekInSeconds"

    const-string v27, "seekInSeconds"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 174
    :cond_13
    const-string v26, "parentalRating"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_14

    const-string v26, "parentalRating"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_14

    .line 175
    const-string v26, "parentalRating"

    const-string v27, "parentalRating"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    const-string v26, "parentalRating"

    const-string v27, "parentalRating"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 179
    :cond_14
    const-string v26, "omniture"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_15

    const-string v26, "omniture"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_15

    .line 180
    const-string v26, "omnitureJson"

    const-string v27, "omniture"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v27

    invoke-virtual/range {v27 .. v27}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    :cond_15
    const-string v26, "thumbnails"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_18

    const-string v26, "thumbnails"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_18

    .line 183
    const-string v26, "thumbnails"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    .line 185
    .local v11, "imageObj":Lorg/json/JSONObject;
    const-string v26, "small"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_16

    const-string v26, "small"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_16

    .line 186
    const-string v26, "small"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v22

    .line 187
    .local v22, "small":Lorg/json/JSONObject;
    const-string v26, "href"

    move-object/from16 v0, v22

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_16

    const-string v26, "href"

    move-object/from16 v0, v22

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_16

    .line 188
    const-string v26, "imageSmall"

    const-string v27, "href"

    move-object/from16 v0, v22

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 189
    const-string v26, "imageSmall"

    const-string v27, "href"

    move-object/from16 v0, v22

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 193
    .end local v22    # "small":Lorg/json/JSONObject;
    :cond_16
    const-string v26, "medium"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_17

    const-string v26, "medium"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_17

    .line 194
    const-string v26, "medium"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v19

    .line 195
    .local v19, "med":Lorg/json/JSONObject;
    const-string v26, "href"

    move-object/from16 v0, v19

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_17

    const-string v26, "href"

    move-object/from16 v0, v19

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_17

    .line 196
    const-string v26, "imageMed"

    const-string v27, "href"

    move-object/from16 v0, v19

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    const-string v26, "imageMed"

    const-string v27, "href"

    move-object/from16 v0, v19

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 201
    .end local v19    # "med":Lorg/json/JSONObject;
    :cond_17
    const-string v26, "large"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_18

    const-string v26, "large"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_18

    .line 202
    const-string v26, "large"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v13

    .line 203
    .local v13, "large":Lorg/json/JSONObject;
    const-string v26, "href"

    move-object/from16 v0, v26

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_18

    const-string v26, "href"

    move-object/from16 v0, v26

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_18

    .line 204
    const-string v26, "imageLarge"

    const-string v27, "href"

    move-object/from16 v0, v27

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    const-string v26, "imageLarge"

    const-string v27, "href"

    move-object/from16 v0, v27

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 210
    .end local v11    # "imageObj":Lorg/json/JSONObject;
    .end local v13    # "large":Lorg/json/JSONObject;
    :cond_18
    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_19

    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_19

    .line 211
    const-string v26, "eventName"

    const-string v27, "name"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    :cond_19
    const-string v26, "streamUrl"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1a

    const-string v26, "streamUrl"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1a

    .line 214
    const-string v26, "videoURLSmall"

    const-string v27, "streamUrl"

    move-object/from16 v0, v27

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    :cond_1a
    const-string v26, "links"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1e

    const-string v26, "links"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1e

    .line 217
    const-string v26, "links"

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v14

    .line 218
    .local v14, "linksObj":Lorg/json/JSONObject;
    const-string v26, "source"

    move-object/from16 v0, v26

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1e

    const-string v26, "source"

    move-object/from16 v0, v26

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1e

    .line 219
    const-string v26, "source"

    move-object/from16 v0, v26

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v23

    .line 220
    .local v23, "sourceObj":Lorg/json/JSONObject;
    const-string v26, "hls"

    move-object/from16 v0, v23

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1e

    const-string v26, "hls"

    move-object/from16 v0, v23

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1e

    .line 221
    const-string v26, "hls"

    move-object/from16 v0, v23

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v10

    .line 223
    .local v10, "hlsObj":Lorg/json/JSONObject;
    const-string v26, "default"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1b

    const-string v26, "default"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1b

    .line 224
    const-string v26, "default"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 225
    .local v6, "dfltObj":Lorg/json/JSONObject;
    const-string v26, "href"

    move-object/from16 v0, v26

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1b

    const-string v26, "href"

    move-object/from16 v0, v26

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1b

    .line 226
    const-string v26, "videoURLDefault"

    const-string v27, "href"

    move-object/from16 v0, v27

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 227
    const-string v26, "defaultStartSessionUrl"

    const-string v27, "href"

    move-object/from16 v0, v27

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 231
    .end local v6    # "dfltObj":Lorg/json/JSONObject;
    :cond_1b
    const-string v26, "high"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1c

    const-string v26, "high"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1c

    .line 232
    const-string v26, "high"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v18

    .line 233
    .local v18, "lrgObj":Lorg/json/JSONObject;
    const-string v26, "href"

    move-object/from16 v0, v18

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1c

    const-string v26, "href"

    move-object/from16 v0, v18

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1c

    .line 234
    const-string v26, "videoURLLarge"

    const-string v27, "href"

    move-object/from16 v0, v18

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    .end local v18    # "lrgObj":Lorg/json/JSONObject;
    :cond_1c
    const-string v26, "mid"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1d

    const-string v26, "mid"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1d

    .line 239
    const-string v26, "mid"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v20

    .line 240
    .local v20, "midObj":Lorg/json/JSONObject;
    const-string v26, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1d

    const-string v26, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1d

    .line 241
    const-string v26, "videoURLMed"

    const-string v27, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 245
    .end local v20    # "midObj":Lorg/json/JSONObject;
    :cond_1d
    const-string v26, "low"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1e

    const-string v26, "low"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1e

    .line 246
    const-string v26, "low"

    move-object/from16 v0, v26

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v17

    .line 247
    .local v17, "lowObj":Lorg/json/JSONObject;
    const-string v26, "href"

    move-object/from16 v0, v17

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v26

    if-eqz v26, :cond_1e

    const-string v26, "href"

    move-object/from16 v0, v17

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v26

    if-nez v26, :cond_1e

    .line 248
    const-string v26, "videoURLSmall"

    const-string v27, "href"

    move-object/from16 v0, v17

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 254
    .end local v10    # "hlsObj":Lorg/json/JSONObject;
    .end local v14    # "linksObj":Lorg/json/JSONObject;
    .end local v17    # "lowObj":Lorg/json/JSONObject;
    .end local v23    # "sourceObj":Lorg/json/JSONObject;
    :cond_1e
    const-string v26, "metaEventRelationId"

    const-string v27, "6"

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    sget-object v26, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    move-object/from16 v0, v26

    invoke-virtual {v0, v7}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoEventsTable(Landroid/content/ContentValues;)V

    .line 257
    new-instance v8, Lcom/espn/androidplayersdk/datamanager/EPEvents;

    .end local v8    # "events":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    invoke-direct {v8, v12}, Lcom/espn/androidplayersdk/datamanager/EPEvents;-><init>(Ljava/util/HashMap;)V

    .line 259
    .end local v9    # "eventsObject":Lorg/json/JSONObject;
    .restart local v8    # "events":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    :cond_1f
    return-object v8
.end method

.method public run()V
    .locals 2

    .prologue
    .line 42
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 43
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->listener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    invoke-direct {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>(Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;)V

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->eventId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventById(Ljava/lang/String;)V

    .line 44
    return-void
.end method
