.class Lcom/espn/androidplayersdk/datamanager/SearchAPI;
.super Ljava/lang/Object;
.source "SearchAPI.java"


# instance fields
.field callback:Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;

.field searchListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;


# direct methods
.method protected constructor <init>(Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;)V
    .locals 1
    .param p1, "callback"    # Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/SearchAPI$1;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/SearchAPI$1;-><init>(Lcom/espn/androidplayersdk/datamanager/SearchAPI;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/SearchAPI;->searchListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    .line 32
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/SearchAPI;->callback:Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;

    .line 33
    return-void
.end method


# virtual methods
.method parse(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    .locals 27
    .param p1, "object"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/datamanager/EPEvents;",
            ">;"
        }
    .end annotation

    .prologue
    .line 92
    const/4 v8, 0x0

    .line 95
    .local v8, "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :try_start_0
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 96
    .end local v8    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .local v9, "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :try_start_1
    const-string v25, "listings"

    move-object/from16 v0, p1

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v17

    .line 97
    .local v17, "listingsArray":Lorg/json/JSONArray;
    invoke-virtual/range {v17 .. v17}, Lorg/json/JSONArray;->length()I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result v10

    .line 99
    .local v10, "eventsArrayLength":I
    if-lez v10, :cond_19

    .line 100
    const/4 v13, 0x0

    .local v13, "i":I
    :goto_0
    if-lt v13, v10, :cond_0

    move-object v8, v9

    .line 235
    .end local v9    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .end local v10    # "eventsArrayLength":I
    .end local v13    # "i":I
    .end local v17    # "listingsArray":Lorg/json/JSONArray;
    .restart local v8    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :goto_1
    return-object v8

    .line 102
    .end local v8    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .restart local v9    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .restart local v10    # "eventsArrayLength":I
    .restart local v13    # "i":I
    .restart local v17    # "listingsArray":Lorg/json/JSONArray;
    :cond_0
    :try_start_2
    new-instance v24, Ljava/util/HashMap;

    invoke-direct/range {v24 .. v24}, Ljava/util/HashMap;-><init>()V

    .line 103
    .local v24, "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    move-object/from16 v0, v17

    invoke-virtual {v0, v13}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v11

    .line 105
    .local v11, "eventsObject":Lorg/json/JSONObject;
    const-string v25, "broadcastStartTime"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_1

    const-string v25, "broadcastStartTime"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_1

    .line 106
    const-string v25, "broadcastStartTime"

    const-string v26, "broadcastStartTime"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 108
    :cond_1
    const-string v25, "description"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_2

    const-string v25, "description"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_2

    .line 109
    const-string v25, "description"

    const-string v26, "description"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 111
    :cond_2
    const-string v25, "categories"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_4

    const-string v25, "categories"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_4

    .line 112
    const-string v25, "categories"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 113
    .local v4, "categoryArray":Lorg/json/JSONArray;
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v25

    if-lez v25, :cond_4

    .line 114
    const/16 v25, 0x0

    move/from16 v0, v25

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 115
    .local v5, "categoryObj":Lorg/json/JSONObject;
    const-string v25, "name"

    move-object/from16 v0, v25

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_3

    const-string v25, "name"

    move-object/from16 v0, v25

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_3

    .line 116
    const-string v25, "SPORT"

    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 117
    :cond_3
    const-string v25, "abbreviation"

    move-object/from16 v0, v25

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_4

    const-string v25, "abbreviation"

    move-object/from16 v0, v25

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_4

    .line 118
    const-string v25, "sportCode"

    const-string v26, "abbreviation"

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 122
    .end local v4    # "categoryArray":Lorg/json/JSONArray;
    .end local v5    # "categoryObj":Lorg/json/JSONObject;
    :cond_4
    const-string v25, "program"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_5

    const-string v25, "program"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_5

    .line 123
    const-string v25, "program"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v19

    .line 124
    .local v19, "programObj":Lorg/json/JSONObject;
    const-string v25, "code"

    move-object/from16 v0, v19

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_5

    const-string v25, "code"

    move-object/from16 v0, v19

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_5

    .line 125
    const-string v25, "programingCode"

    const-string v26, "code"

    move-object/from16 v0, v19

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 128
    .end local v19    # "programObj":Lorg/json/JSONObject;
    :cond_5
    const-string v25, "type"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_6

    const-string v25, "type"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_6

    .line 129
    const-string v25, "eventType"

    const-string v26, "type"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    :cond_6
    const-string v25, "endTime"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_7

    const-string v25, "endTime"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_7

    .line 132
    const-string v25, "endTime"

    const-string v26, "endTime"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 134
    :cond_7
    const-string v25, "subcategories"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_9

    const-string v25, "subcategories"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_9

    .line 135
    const-string v25, "subcategories"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v22

    .line 136
    .local v22, "subCatArray":Lorg/json/JSONArray;
    invoke-virtual/range {v22 .. v22}, Lorg/json/JSONArray;->length()I

    move-result v25

    if-lez v25, :cond_9

    .line 137
    const/16 v25, 0x0

    move-object/from16 v0, v22

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v23

    .line 138
    .local v23, "subCatObj":Lorg/json/JSONObject;
    const-string v25, "id"

    move-object/from16 v0, v23

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_8

    const-string v25, "id"

    move-object/from16 v0, v23

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_8

    .line 139
    const-string v25, "league"

    const-string v26, "id"

    move-object/from16 v0, v23

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 140
    :cond_8
    const-string v25, "name"

    move-object/from16 v0, v23

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_9

    const-string v25, "name"

    move-object/from16 v0, v23

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_9

    .line 141
    const-string v25, "leagueName"

    const-string v26, "name"

    move-object/from16 v0, v23

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    .end local v22    # "subCatArray":Lorg/json/JSONArray;
    .end local v23    # "subCatObj":Lorg/json/JSONObject;
    :cond_9
    const-string v25, "broadcasts"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_d

    const-string v25, "broadcasts"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_d

    .line 146
    const-string v25, "broadcasts"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 147
    .local v2, "broadcastArray":Lorg/json/JSONArray;
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v25

    if-lez v25, :cond_d

    .line 148
    const/16 v25, 0x0

    move/from16 v0, v25

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 149
    .local v3, "broadcastObj":Lorg/json/JSONObject;
    const-string v25, "code"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_a

    const-string v25, "code"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_a

    .line 150
    const-string v25, "networkCode"

    const-string v26, "code"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 151
    :cond_a
    const-string v25, "name"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_b

    const-string v25, "name"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_b

    .line 152
    const-string v25, "networkName"

    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 153
    :cond_b
    const-string v25, "ncsId"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_c

    const-string v25, "ncsId"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_c

    .line 154
    const-string v25, "networkId"

    const-string v26, "ncsId"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 156
    :cond_c
    const-string v25, "adobeResource"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_d

    const-string v25, "adobeResource"

    move-object/from16 v0, v25

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_d

    .line 157
    const-string v25, "networkResourceId"

    const-string v26, "adobeResource"

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 162
    .end local v2    # "broadcastArray":Lorg/json/JSONArray;
    .end local v3    # "broadcastObj":Lorg/json/JSONObject;
    :cond_d
    const-string v25, "startTime"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_e

    const-string v25, "startTime"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_e

    .line 163
    const-string v25, "startTime"

    const-string v26, "startTime"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 165
    :cond_e
    const-string v25, "id"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_f

    const-string v25, "id"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_f

    .line 166
    const-string v25, "eventId"

    const-string v26, "id"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 168
    :cond_f
    const-string v25, "name"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_10

    const-string v25, "name"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_10

    .line 169
    const-string v25, "showName"

    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 171
    :cond_10
    const-string v25, "simulcastAiringId"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_11

    const-string v25, "simulcastAiringId"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_11

    .line 172
    const-string v25, "simulcastAiringId"

    const-string v26, "simulcastAiringId"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 174
    :cond_11
    const-string v25, "seekInSeconds"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_12

    const-string v25, "seekInSeconds"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_12

    .line 175
    const-string v25, "seekInSeconds"

    const-string v26, "seekInSeconds"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 177
    :cond_12
    const-string v25, "parentalRating"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_13

    const-string v25, "parentalRating"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_13

    .line 178
    const-string v25, "parentalRating"

    const-string v26, "parentalRating"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 180
    :cond_13
    const-string v25, "thumbnails"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_16

    const-string v25, "thumbnails"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_16

    .line 181
    const-string v25, "thumbnails"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v14

    .line 183
    .local v14, "imageObj":Lorg/json/JSONObject;
    const-string v25, "small"

    move-object/from16 v0, v25

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_14

    const-string v25, "small"

    move-object/from16 v0, v25

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_14

    .line 184
    const-string v25, "small"

    move-object/from16 v0, v25

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v20

    .line 185
    .local v20, "small":Lorg/json/JSONObject;
    const-string v25, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_14

    const-string v25, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_14

    .line 186
    const-string v25, "imageSmall"

    const-string v26, "href"

    move-object/from16 v0, v20

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 189
    .end local v20    # "small":Lorg/json/JSONObject;
    :cond_14
    const-string v25, "medium"

    move-object/from16 v0, v25

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_15

    const-string v25, "medium"

    move-object/from16 v0, v25

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_15

    .line 190
    const-string v25, "medium"

    move-object/from16 v0, v25

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v18

    .line 191
    .local v18, "med":Lorg/json/JSONObject;
    const-string v25, "href"

    move-object/from16 v0, v18

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_15

    const-string v25, "href"

    move-object/from16 v0, v18

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_15

    .line 192
    const-string v25, "imageMed"

    const-string v26, "href"

    move-object/from16 v0, v18

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 195
    .end local v18    # "med":Lorg/json/JSONObject;
    :cond_15
    const-string v25, "large"

    move-object/from16 v0, v25

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_16

    const-string v25, "large"

    move-object/from16 v0, v25

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_16

    .line 196
    const-string v25, "large"

    move-object/from16 v0, v25

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v15

    .line 197
    .local v15, "large":Lorg/json/JSONObject;
    const-string v25, "href"

    move-object/from16 v0, v25

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_16

    const-string v25, "href"

    move-object/from16 v0, v25

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_16

    .line 198
    const-string v25, "imageLarge"

    const-string v26, "href"

    move-object/from16 v0, v26

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 202
    .end local v14    # "imageObj":Lorg/json/JSONObject;
    .end local v15    # "large":Lorg/json/JSONObject;
    :cond_16
    const-string v25, "name"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_17

    const-string v25, "name"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_17

    .line 203
    const-string v25, "eventName"

    const-string v26, "name"

    move-object/from16 v0, v26

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 205
    :cond_17
    const-string v25, "links"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_18

    const-string v25, "links"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_18

    .line 206
    const-string v25, "links"

    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v16

    .line 208
    .local v16, "linksObj":Lorg/json/JSONObject;
    const-string v25, "source"

    move-object/from16 v0, v16

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_18

    const-string v25, "source"

    move-object/from16 v0, v16

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_18

    .line 209
    const-string v25, "source"

    move-object/from16 v0, v16

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v21

    .line 211
    .local v21, "sourceObj":Lorg/json/JSONObject;
    const-string v25, "hls"

    move-object/from16 v0, v21

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_18

    const-string v25, "hls"

    move-object/from16 v0, v21

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_18

    .line 212
    const-string v25, "hls"

    move-object/from16 v0, v21

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v12

    .line 214
    .local v12, "hlsObj":Lorg/json/JSONObject;
    const-string v25, "default"

    move-object/from16 v0, v25

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_18

    const-string v25, "default"

    move-object/from16 v0, v25

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_18

    .line 215
    const-string v25, "default"

    move-object/from16 v0, v25

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 217
    .local v6, "defaultObj":Lorg/json/JSONObject;
    const-string v25, "href"

    move-object/from16 v0, v25

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v25

    if-eqz v25, :cond_18

    const-string v25, "href"

    move-object/from16 v0, v25

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v25

    if-nez v25, :cond_18

    .line 218
    const-string v25, "defaultStartSessionUrl"

    const-string v26, "href"

    move-object/from16 v0, v26

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 225
    .end local v6    # "defaultObj":Lorg/json/JSONObject;
    .end local v12    # "hlsObj":Lorg/json/JSONObject;
    .end local v16    # "linksObj":Lorg/json/JSONObject;
    .end local v21    # "sourceObj":Lorg/json/JSONObject;
    :cond_18
    new-instance v25, Lcom/espn/androidplayersdk/datamanager/EPEvents;

    move-object/from16 v0, v25

    move-object/from16 v1, v24

    invoke-direct {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EPEvents;-><init>(Ljava/util/HashMap;)V

    move-object/from16 v0, v25

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 100
    .end local v11    # "eventsObject":Lorg/json/JSONObject;
    .end local v24    # "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_2
    add-int/lit8 v13, v13, 0x1

    goto/16 :goto_0

    .line 226
    :catch_0
    move-exception v7

    .line 227
    .local v7, "e":Ljava/lang/Exception;
    :try_start_3
    const-string v25, "SearchParser - Error: "

    const/16 v26, 0x5

    move-object/from16 v0, v25

    move/from16 v1, v26

    invoke-static {v0, v1, v7}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_2

    .line 231
    .end local v7    # "e":Ljava/lang/Exception;
    .end local v10    # "eventsArrayLength":I
    .end local v13    # "i":I
    .end local v17    # "listingsArray":Lorg/json/JSONArray;
    :catch_1
    move-exception v7

    move-object v8, v9

    .line 232
    .end local v9    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .restart local v7    # "e":Ljava/lang/Exception;
    .restart local v8    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :goto_3
    const-string v25, "SearchParser - Error: "

    const/16 v26, 0x5

    move-object/from16 v0, v25

    move/from16 v1, v26

    invoke-static {v0, v1, v7}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto/16 :goto_1

    .line 231
    .end local v7    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v7

    goto :goto_3

    .end local v8    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .restart local v9    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .restart local v10    # "eventsArrayLength":I
    .restart local v17    # "listingsArray":Lorg/json/JSONArray;
    :cond_19
    move-object v8, v9

    .end local v9    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .restart local v8    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    goto/16 :goto_1
.end method

.method parseKeywords(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "keywords"    # Ljava/lang/String;

    .prologue
    .line 42
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, " "

    const-string v2, ","

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected search(Ljava/lang/String;Ljava/lang/String;II)V
    .locals 8
    .param p1, "keyword"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "limit"    # I
    .param p4, "start"    # I

    .prologue
    .line 36
    const/4 v0, 0x2

    new-array v7, v0, [Ljava/lang/String;

    .line 37
    .local v7, "dates":[Ljava/lang/String;
    const/16 v0, 0x168

    invoke-virtual {p0, p2, v0, v7}, Lcom/espn/androidplayersdk/datamanager/SearchAPI;->setDateRange(Ljava/lang/String;I[Ljava/lang/String;)V

    .line 38
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/SearchAPI;->searchListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    invoke-direct {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>(Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;)V

    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/SearchAPI;->parseKeywords(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    aget-object v5, v7, v2

    const/4 v2, 0x1

    aget-object v6, v7, v2

    move-object v2, p2

    move v3, p3

    move v4, p4

    invoke-virtual/range {v0 .. v6}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->searchFeed(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V

    .line 39
    return-void
.end method

.method varargs setDateRange(Ljava/lang/String;I[Ljava/lang/String;)V
    .locals 10
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "range"    # I
    .param p3, "dates"    # [Ljava/lang/String;

    .prologue
    const/4 v9, 0x5

    .line 48
    :try_start_0
    new-instance v0, Ljava/util/GregorianCalendar;

    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v5

    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v5, v6}, Ljava/util/GregorianCalendar;-><init>(Ljava/util/TimeZone;Ljava/util/Locale;)V

    .line 49
    .local v0, "calander":Ljava/util/GregorianCalendar;
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v5, "yyyy-MM-dd"

    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v2, v5, v6}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 50
    .local v2, "format":Ljava/text/SimpleDateFormat;
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    .line 52
    .local v4, "today":Ljava/util/Date;
    sget-object v5, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 53
    const/4 v5, 0x5

    invoke-virtual {v0, v5, p2}, Ljava/util/GregorianCalendar;->add(II)V

    .line 54
    invoke-virtual {v0}, Ljava/util/GregorianCalendar;->getTime()Ljava/util/Date;

    move-result-object v3

    .line 61
    .local v3, "maxDate":Ljava/util/Date;
    :goto_0
    const/4 v5, 0x0

    invoke-virtual {v2, v4}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "-"

    const-string v8, ""

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, p3, v5

    .line 62
    const/4 v5, 0x1

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "-"

    const-string v8, ""

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, p3, v5

    .line 66
    .end local v0    # "calander":Ljava/util/GregorianCalendar;
    .end local v2    # "format":Ljava/text/SimpleDateFormat;
    .end local v3    # "maxDate":Ljava/util/Date;
    .end local v4    # "today":Ljava/util/Date;
    :goto_1
    return-void

    .line 55
    .restart local v0    # "calander":Ljava/util/GregorianCalendar;
    .restart local v2    # "format":Ljava/text/SimpleDateFormat;
    .restart local v4    # "today":Ljava/util/Date;
    :cond_0
    sget-object v5, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 56
    const/4 v5, 0x5

    neg-int v6, p2

    invoke-virtual {v0, v5, v6}, Ljava/util/GregorianCalendar;->add(II)V

    .line 57
    move-object v3, v4

    .line 58
    .restart local v3    # "maxDate":Ljava/util/Date;
    invoke-virtual {v0}, Ljava/util/GregorianCalendar;->getTime()Ljava/util/Date;

    move-result-object v4

    .line 59
    goto :goto_0

    .line 60
    .end local v3    # "maxDate":Ljava/util/Date;
    :cond_1
    invoke-virtual {v0}, Ljava/util/GregorianCalendar;->getTime()Ljava/util/Date;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .restart local v3    # "maxDate":Ljava/util/Date;
    goto :goto_0

    .line 63
    .end local v0    # "calander":Ljava/util/GregorianCalendar;
    .end local v2    # "format":Ljava/text/SimpleDateFormat;
    .end local v3    # "maxDate":Ljava/util/Date;
    .end local v4    # "today":Ljava/util/Date;
    :catch_0
    move-exception v1

    .line 64
    .local v1, "e":Ljava/lang/Exception;
    const-string v5, "Error: "

    invoke-static {v5, v9, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1
.end method
