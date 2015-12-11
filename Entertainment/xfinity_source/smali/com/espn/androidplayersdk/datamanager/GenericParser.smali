.class Lcom/espn/androidplayersdk/datamanager/GenericParser;
.super Ljava/lang/Object;
.source "GenericParser.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected static parseAndInsertLinearEvent(Lorg/json/JSONObject;Ljava/util/HashMap;)Landroid/content/ContentValues;
    .locals 23
    .param p0, "eventsObject"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Landroid/content/ContentValues;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 110
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 111
    .local v7, "featuredEventValues":Landroid/content/ContentValues;
    const-string v21, "broadcastStartTime"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_0

    const-string v21, "broadcastStartTime"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_0

    .line 112
    const-string v21, "broadcastStartTime"

    const-string v22, "broadcastStartTime"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    :cond_0
    const-string v21, "description"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1

    const-string v21, "description"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1

    .line 115
    const-string v21, "description"

    const-string v22, "description"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    :cond_1
    const-string v21, "blackouts"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_2

    const-string v21, "blackouts"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_2

    .line 118
    const-string v21, "blackoutsJason"

    const-string v22, "blackouts"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    :cond_2
    const-string v21, "categories"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_4

    const-string v21, "categories"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_4

    .line 121
    const-string v21, "categories"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 122
    .local v4, "categoryArray":Lorg/json/JSONArray;
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v21

    if-lez v21, :cond_4

    .line 123
    const/16 v21, 0x0

    move/from16 v0, v21

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 124
    .local v5, "categoryObj":Lorg/json/JSONObject;
    const-string v21, "name"

    move-object/from16 v0, v21

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_3

    const-string v21, "name"

    move-object/from16 v0, v21

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_3

    .line 125
    const-string v21, "SPORT"

    const-string v22, "name"

    move-object/from16 v0, v22

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    :cond_3
    const-string v21, "abbreviation"

    move-object/from16 v0, v21

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_4

    const-string v21, "abbreviation"

    move-object/from16 v0, v21

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_4

    .line 127
    const-string v21, "sportCode"

    const-string v22, "abbreviation"

    move-object/from16 v0, v22

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    .end local v4    # "categoryArray":Lorg/json/JSONArray;
    .end local v5    # "categoryObj":Lorg/json/JSONObject;
    :cond_4
    const-string v21, "program"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_5

    const-string v21, "program"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_5

    .line 132
    const-string v21, "program"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v16

    .line 133
    .local v16, "programObj":Lorg/json/JSONObject;
    const-string v21, "code"

    move-object/from16 v0, v16

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_5

    const-string v21, "code"

    move-object/from16 v0, v16

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_5

    .line 134
    const-string v21, "programingCode"

    const-string v22, "code"

    move-object/from16 v0, v16

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    .end local v16    # "programObj":Lorg/json/JSONObject;
    :cond_5
    const-string v21, "type"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_6

    const-string v21, "type"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_6

    .line 138
    const-string v21, "eventType"

    const-string v22, "type"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    :cond_6
    const-string v21, "endTime"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_7

    const-string v21, "endTime"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_7

    .line 141
    const-string v21, "endTime"

    const-string v22, "endTime"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    :cond_7
    const-string v21, "subcategories"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_9

    const-string v21, "subcategories"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_9

    .line 144
    const-string v21, "subcategories"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v19

    .line 145
    .local v19, "subCatArray":Lorg/json/JSONArray;
    invoke-virtual/range {v19 .. v19}, Lorg/json/JSONArray;->length()I

    move-result v21

    if-lez v21, :cond_9

    .line 146
    const/16 v21, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v20

    .line 147
    .local v20, "subCatObj":Lorg/json/JSONObject;
    const-string v21, "id"

    invoke-virtual/range {v20 .. v21}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_8

    const-string v21, "id"

    invoke-virtual/range {v20 .. v21}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_8

    .line 148
    const-string v21, "league"

    const-string v22, "id"

    move-object/from16 v0, v20

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    :cond_8
    const-string v21, "name"

    invoke-virtual/range {v20 .. v21}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_9

    const-string v21, "name"

    invoke-virtual/range {v20 .. v21}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_9

    .line 150
    const-string v21, "leagueName"

    const-string v22, "name"

    move-object/from16 v0, v20

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    .end local v19    # "subCatArray":Lorg/json/JSONArray;
    .end local v20    # "subCatObj":Lorg/json/JSONObject;
    :cond_9
    const-string v21, "broadcasts"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_d

    const-string v21, "broadcasts"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_d

    .line 155
    const-string v21, "broadcasts"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 156
    .local v2, "broadcastArray":Lorg/json/JSONArray;
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v21

    if-lez v21, :cond_d

    .line 157
    const/16 v21, 0x0

    move/from16 v0, v21

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 158
    .local v3, "broadcastObj":Lorg/json/JSONObject;
    const-string v21, "abbreviation"

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_a

    const-string v21, "abbreviation"

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_a

    .line 159
    const-string v21, "networkCode"

    const-string v22, "abbreviation"

    move-object/from16 v0, v22

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 160
    :cond_a
    const-string v21, "name"

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_b

    const-string v21, "name"

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_b

    .line 161
    const-string v21, "networkName"

    const-string v22, "name"

    move-object/from16 v0, v22

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    :cond_b
    const-string v21, "ncsId"

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_c

    const-string v21, "ncsId"

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_c

    .line 163
    const-string v21, "networkId"

    const-string v22, "ncsId"

    move-object/from16 v0, v22

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    :cond_c
    const-string v21, "adobeResource"

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_d

    const-string v21, "adobeResource"

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_d

    .line 166
    const-string v21, "networkResourceId"

    const-string v22, "adobeResource"

    move-object/from16 v0, v22

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 172
    .end local v2    # "broadcastArray":Lorg/json/JSONArray;
    .end local v3    # "broadcastObj":Lorg/json/JSONObject;
    :cond_d
    const-string v21, "guid"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_e

    const-string v21, "guid"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_e

    .line 173
    const-string v21, "guid"

    const-string v22, "guid"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    :cond_e
    const-string v21, "startTime"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_f

    const-string v21, "startTime"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_f

    .line 176
    const-string v21, "startTime"

    const-string v22, "startTime"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 178
    :cond_f
    const-string v21, "id"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_10

    const-string v21, "id"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_10

    .line 179
    const-string v21, "eventId"

    const-string v22, "id"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 181
    :cond_10
    const-string v21, "name"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_11

    const-string v21, "name"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_11

    .line 182
    const-string v21, "showName"

    const-string v22, "name"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    :cond_11
    const-string v21, "simulcastAiringId"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_12

    const-string v21, "simulcastAiringId"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_12

    .line 185
    const-string v21, "simulcastAiringId"

    const-string v22, "simulcastAiringId"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    :cond_12
    const-string v21, "seekInSeconds"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_13

    const-string v21, "seekInSeconds"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_13

    .line 188
    const-string v21, "seekInSeconds"

    const-string v22, "seekInSeconds"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    :cond_13
    const-string v21, "parentalRating"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_14

    const-string v21, "parentalRating"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_14

    .line 191
    const-string v21, "parentalRating"

    const-string v22, "parentalRating"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 193
    :cond_14
    const-string v21, "omniture"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_15

    const-string v21, "omniture"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_15

    .line 194
    const-string v21, "omnitureJson"

    const-string v22, "omniture"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    :cond_15
    const-string v21, "thumbnails"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_18

    const-string v21, "thumbnails"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_18

    .line 197
    const-string v21, "thumbnails"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    .line 199
    .local v9, "imageObj":Lorg/json/JSONObject;
    const-string v21, "small"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_16

    const-string v21, "small"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_16

    .line 200
    const-string v21, "small"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v17

    .line 201
    .local v17, "small":Lorg/json/JSONObject;
    const-string v21, "href"

    move-object/from16 v0, v17

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_16

    const-string v21, "href"

    move-object/from16 v0, v17

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_16

    .line 202
    const-string v21, "imageSmall"

    const-string v22, "href"

    move-object/from16 v0, v17

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    .end local v17    # "small":Lorg/json/JSONObject;
    :cond_16
    const-string v21, "medium"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_17

    const-string v21, "medium"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_17

    .line 206
    const-string v21, "medium"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v14

    .line 207
    .local v14, "med":Lorg/json/JSONObject;
    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_17

    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_17

    .line 208
    const-string v21, "imageMed"

    const-string v22, "href"

    move-object/from16 v0, v22

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    .end local v14    # "med":Lorg/json/JSONObject;
    :cond_17
    const-string v21, "large"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_18

    const-string v21, "large"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_18

    .line 212
    const-string v21, "large"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v10

    .line 213
    .local v10, "large":Lorg/json/JSONObject;
    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_18

    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_18

    .line 214
    const-string v21, "imageLarge"

    const-string v22, "href"

    move-object/from16 v0, v22

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    .end local v9    # "imageObj":Lorg/json/JSONObject;
    .end local v10    # "large":Lorg/json/JSONObject;
    :cond_18
    const-string v21, "name"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_19

    const-string v21, "name"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_19

    .line 219
    const-string v21, "eventName"

    const-string v22, "name"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    :cond_19
    const-string v21, "streamUrl"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1a

    const-string v21, "streamUrl"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1a

    .line 222
    const-string v21, "videoURLSmall"

    const-string v22, "streamUrl"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    :cond_1a
    const-string v21, "links"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1e

    const-string v21, "links"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1e

    .line 225
    const-string v21, "links"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    .line 226
    .local v11, "linksObj":Lorg/json/JSONObject;
    const-string v21, "source"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1e

    const-string v21, "source"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1e

    .line 227
    const-string v21, "source"

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v18

    .line 228
    .local v18, "sourceObj":Lorg/json/JSONObject;
    const-string v21, "hls"

    move-object/from16 v0, v18

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1e

    const-string v21, "hls"

    move-object/from16 v0, v18

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1e

    .line 229
    const-string v21, "hls"

    move-object/from16 v0, v18

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    .line 231
    .local v8, "hlsObj":Lorg/json/JSONObject;
    const-string v21, "default"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1b

    const-string v21, "default"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1b

    .line 232
    const-string v21, "default"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 233
    .local v6, "dfltObj":Lorg/json/JSONObject;
    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1b

    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1b

    .line 234
    const-string v21, "videoURLDefault"

    const-string v22, "href"

    move-object/from16 v0, v22

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    .end local v6    # "dfltObj":Lorg/json/JSONObject;
    :cond_1b
    const-string v21, "high"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1c

    const-string v21, "high"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1c

    .line 239
    const-string v21, "high"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v13

    .line 240
    .local v13, "lrgObj":Lorg/json/JSONObject;
    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1c

    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1c

    .line 241
    const-string v21, "videoURLLarge"

    const-string v22, "href"

    move-object/from16 v0, v22

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 245
    .end local v13    # "lrgObj":Lorg/json/JSONObject;
    :cond_1c
    const-string v21, "mid"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1d

    const-string v21, "mid"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1d

    .line 246
    const-string v21, "mid"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v15

    .line 247
    .local v15, "midObj":Lorg/json/JSONObject;
    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1d

    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1d

    .line 248
    const-string v21, "videoURLMed"

    const-string v22, "href"

    move-object/from16 v0, v22

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 252
    .end local v15    # "midObj":Lorg/json/JSONObject;
    :cond_1d
    const-string v21, "low"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1e

    const-string v21, "low"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1e

    .line 253
    const-string v21, "low"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v12

    .line 254
    .local v12, "lowObj":Lorg/json/JSONObject;
    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_1e

    const-string v21, "href"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v21

    if-nez v21, :cond_1e

    .line 255
    const-string v21, "videoURLSmall"

    const-string v22, "href"

    move-object/from16 v0, v22

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 261
    .end local v8    # "hlsObj":Lorg/json/JSONObject;
    .end local v11    # "linksObj":Lorg/json/JSONObject;
    .end local v12    # "lowObj":Lorg/json/JSONObject;
    .end local v18    # "sourceObj":Lorg/json/JSONObject;
    :cond_1e
    if-eqz p1, :cond_21

    .line 262
    const-string v21, "featuredType"

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_1f

    .line 263
    const-string v22, "metaEventRelationId"

    const-string v21, "featuredType"

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Ljava/lang/Integer;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 264
    :cond_1f
    const-string v21, "sportId"

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_20

    .line 265
    const-string v22, "sportId"

    const-string v21, "sportId"

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Ljava/lang/String;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 266
    :cond_20
    const-string v21, "eventType"

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_21

    .line 267
    const-string v22, "eventType"

    const-string v21, "eventType"

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Ljava/lang/String;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 269
    :cond_21
    return-object v7
.end method

.method protected static parseAndInsertVODEvent(Lorg/json/JSONObject;Ljava/util/HashMap;)Landroid/content/ContentValues;
    .locals 10
    .param p0, "VODObject"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Landroid/content/ContentValues;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 28
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 29
    .local v1, "featuredEventValues":Landroid/content/ContentValues;
    const-string v8, "headline"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    const-string v8, "headline"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 30
    const-string v8, "eventName"

    const-string v9, "headline"

    invoke-virtual {p0, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    const-string v8, "showName"

    const-string v9, "headline"

    invoke-virtual {p0, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    :cond_0
    const-string v8, "description"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    const-string v8, "description"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 34
    const-string v8, "description"

    const-string v9, "description"

    invoke-virtual {p0, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    :cond_1
    const-string v8, "id"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    const-string v8, "id"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_2

    .line 36
    const-string v8, "eventId"

    const-string v9, "id"

    invoke-virtual {p0, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    :cond_2
    const-string v8, "posterImages"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    const-string v8, "posterImages"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 39
    const-string v8, "posterImages"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 40
    .local v5, "imageObj":Lorg/json/JSONObject;
    const-string v8, "default"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    const-string v8, "default"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 41
    const-string v8, "default"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 42
    .local v0, "defaultImageObj":Lorg/json/JSONObject;
    const-string v8, "href"

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    const-string v8, "href"

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 43
    const-string v8, "imageMed"

    const-string v9, "href"

    invoke-virtual {v0, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    const-string v8, "imageSmall"

    const-string v9, "href"

    invoke-virtual {v0, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    .end local v0    # "defaultImageObj":Lorg/json/JSONObject;
    :cond_3
    const-string v8, "full"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    const-string v8, "full"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 48
    const-string v8, "full"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 49
    .local v2, "fullImageObj":Lorg/json/JSONObject;
    const-string v8, "href"

    invoke-virtual {v2, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    const-string v8, "href"

    invoke-virtual {v2, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 50
    const-string v8, "imageLarge"

    const-string v9, "href"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    .end local v2    # "fullImageObj":Lorg/json/JSONObject;
    .end local v5    # "imageObj":Lorg/json/JSONObject;
    :cond_4
    const-string v8, "links"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    const-string v8, "links"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_6

    .line 55
    const-string v8, "links"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 56
    .local v6, "linksObj":Lorg/json/JSONObject;
    const-string v8, "source"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    const-string v8, "source"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_6

    .line 57
    const-string v8, "source"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    .line 58
    .local v7, "sourceObj":Lorg/json/JSONObject;
    const-string v8, "HLS"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_a

    const-string v8, "HLS"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_a

    .line 59
    const-string v8, "HLS"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 60
    .local v4, "hlsObj":Lorg/json/JSONObject;
    const-string v8, "href"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_5

    const-string v8, "href"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_5

    .line 61
    const-string v8, "videoURLLarge"

    const-string v9, "href"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    const-string v8, "videoURLMed"

    const-string v9, "href"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    const-string v8, "videoURLSmall"

    const-string v9, "href"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    :cond_5
    const-string v8, "HD"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    const-string v8, "HD"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_6

    .line 66
    const-string v8, "HD"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 67
    .local v3, "hdObj":Lorg/json/JSONObject;
    const-string v8, "href"

    invoke-virtual {v3, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    const-string v8, "href"

    invoke-virtual {v3, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_6

    .line 68
    const-string v8, "videoURLHD"

    const-string v9, "href"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    .end local v3    # "hdObj":Lorg/json/JSONObject;
    .end local v4    # "hlsObj":Lorg/json/JSONObject;
    .end local v6    # "linksObj":Lorg/json/JSONObject;
    .end local v7    # "sourceObj":Lorg/json/JSONObject;
    :cond_6
    const-string v8, "duration"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_7

    const-string v8, "duration"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_7

    .line 76
    const-string v8, "endTime"

    const-string v9, "duration"

    invoke-virtual {p0, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    :cond_7
    const-string v8, "blackoutsJason"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    const-string v8, "broadcastStartTime"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    const-string v8, "eventType"

    const-string v9, "VOD"

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    const-string v8, "guid"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    const-string v8, "omnitureJson"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    const-string v8, "parentalRating"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    const-string v8, "seekInSeconds"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    const-string v8, "simulcastAiringId"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    const-string v8, "networkCode"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    const-string v8, "networkName"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    const-string v8, "networkId"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    const-string v8, "league"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    const-string v8, "leagueName"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    const-string v8, "SPORT"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    const-string v8, "startTime"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    const-string v8, "networkResourceId"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    if-eqz p1, :cond_9

    .line 96
    const-string v8, "featuredType"

    invoke-virtual {p1, v8}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_8

    .line 97
    const-string v9, "metaEventRelationId"

    const-string v8, "featuredType"

    invoke-virtual {p1, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Integer;

    invoke-virtual {v1, v9, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 98
    :cond_8
    const-string v8, "sportId"

    invoke-virtual {p1, v8}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_9

    .line 99
    const-string v9, "sportId"

    const-string v8, "sportId"

    invoke-virtual {p1, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v1, v9, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    :cond_9
    return-object v1

    .line 71
    .restart local v6    # "linksObj":Lorg/json/JSONObject;
    .restart local v7    # "sourceObj":Lorg/json/JSONObject;
    :cond_a
    new-instance v8, Lcom/espn/androidplayersdk/datamanager/ParserException;

    const-string v9, "No HLS Video"

    invoke-direct {v8, v9}, Lcom/espn/androidplayersdk/datamanager/ParserException;-><init>(Ljava/lang/String;)V

    throw v8
.end method

.method protected static parseAndUpdateMetaData(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 4
    .param p1, "eventType"    # Ljava/lang/String;
    .param p2, "resultLimit"    # Ljava/lang/String;
    .param p3, "networkId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 277
    .local p0, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 278
    .local v1, "metaValues":Landroid/content/ContentValues;
    if-eqz p0, :cond_2

    .line 279
    const-string v2, "ttl"

    invoke-virtual {p0, v2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 281
    :try_start_0
    const-string v3, "ttl"

    const-string v2, "ttl"

    invoke-virtual {p0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Lcom/espn/androidplayersdk/utilities/Utils;->getExpiryTime(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 287
    :cond_0
    :goto_0
    const-string v2, "featuredType"

    invoke-virtual {p0, v2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 288
    const-string v3, "eventRelationId"

    const-string v2, "featuredType"

    invoke-virtual {p0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v1, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 290
    :cond_1
    const-string v2, "sportId"

    invoke-virtual {p0, v2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 291
    const-string v3, "sportId"

    const-string v2, "sportId"

    invoke-virtual {p0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v1, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 293
    :cond_2
    if-eqz p3, :cond_3

    .line 294
    const-string v2, "networkId"

    invoke-virtual {v1, v2, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 295
    :cond_3
    const-string v2, "eventsType"

    invoke-virtual {v1, v2, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 296
    const-string v2, "omnitureJson"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 297
    const-string v2, "count"

    invoke-virtual {v1, v2, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v2, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertOrUpdateMetaEventsTable(Landroid/content/ContentValues;)V

    .line 300
    const/4 v2, 0x1

    return v2

    .line 282
    :catch_0
    move-exception v0

    .line 283
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "GenericParser; Error: "

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 284
    const-string v2, "ttl"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
