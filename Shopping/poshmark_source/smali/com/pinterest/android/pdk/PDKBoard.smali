.class public Lcom/pinterest/android/pdk/PDKBoard;
.super Lcom/pinterest/android/pdk/PDKModel;
.source "PDKBoard.java"


# instance fields
.field private collaboratorsCount:Ljava/lang/Integer;

.field private createdAt:Ljava/util/Date;

.field private creator:Lcom/pinterest/android/pdk/PDKUser;

.field private description:Ljava/lang/String;

.field private followersCount:Ljava/lang/Integer;

.field private imageUrl:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private pinsCount:Ljava/lang/Integer;

.field private uid:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/pinterest/android/pdk/PDKModel;-><init>()V

    return-void
.end method

.method public static makeBoard(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKBoard;
    .locals 13
    .param p0, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v11, 0x1

    const/4 v12, 0x0

    .line 100
    new-instance v1, Lcom/pinterest/android/pdk/PDKBoard;

    invoke-direct {v1}, Lcom/pinterest/android/pdk/PDKBoard;-><init>()V

    .line 102
    .local v1, "board":Lcom/pinterest/android/pdk/PDKBoard;
    :try_start_0
    instance-of v9, p0, Lorg/json/JSONObject;

    if-eqz v9, :cond_9

    .line 103
    move-object v0, p0

    check-cast v0, Lorg/json/JSONObject;

    move-object v3, v0

    .line 104
    .local v3, "dataObj":Lorg/json/JSONObject;
    const-string v9, "id"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 105
    const-string v9, "id"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Lcom/pinterest/android/pdk/PDKBoard;->setUid(Ljava/lang/String;)V

    .line 107
    :cond_0
    const-string v9, "name"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 108
    const-string v9, "name"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Lcom/pinterest/android/pdk/PDKBoard;->setName(Ljava/lang/String;)V

    .line 110
    :cond_1
    const-string v9, "description"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 111
    const-string v9, "description"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Lcom/pinterest/android/pdk/PDKBoard;->setDescription(Ljava/lang/String;)V

    .line 113
    :cond_2
    const-string v9, "creator"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 114
    const-string v9, "creator"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    invoke-static {v9}, Lcom/pinterest/android/pdk/PDKUser;->makeUser(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKUser;

    .line 116
    :cond_3
    const-string v9, "created_at"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 117
    invoke-static {}, Lcom/pinterest/android/pdk/Utils;->getDateFormatter()Ljava/text/DateFormat;

    move-result-object v9

    const-string v10, "created_at"

    invoke-virtual {v3, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v9

    iput-object v9, v1, Lcom/pinterest/android/pdk/PDKBoard;->createdAt:Ljava/util/Date;

    .line 119
    :cond_4
    const-string v9, "counts"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_7

    .line 120
    const-string v9, "counts"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 121
    .local v2, "countsObj":Lorg/json/JSONObject;
    const-string v9, "pins"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 122
    const-string v9, "pins"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v1, v9}, Lcom/pinterest/android/pdk/PDKBoard;->setPinsCount(Ljava/lang/Integer;)V

    .line 124
    :cond_5
    const-string v9, "collaborators"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 125
    const-string v9, "collaborators"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v1, v9}, Lcom/pinterest/android/pdk/PDKBoard;->setCollaboratorsCount(Ljava/lang/Integer;)V

    .line 127
    :cond_6
    const-string v9, "followers"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_7

    .line 128
    const-string v9, "followers"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v1, v9}, Lcom/pinterest/android/pdk/PDKBoard;->setFollowersCount(Ljava/lang/Integer;)V

    .line 131
    .end local v2    # "countsObj":Lorg/json/JSONObject;
    :cond_7
    const-string v9, "image"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_9

    .line 132
    const-string v9, "image"

    invoke-virtual {v3, v9}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 133
    .local v6, "imageObj":Lorg/json/JSONObject;
    invoke-virtual {v6}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v8

    .line 136
    .local v8, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_8
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_9

    .line 137
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 138
    .local v7, "key":Ljava/lang/String;
    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    instance-of v9, v9, Lorg/json/JSONObject;

    if-eqz v9, :cond_8

    .line 139
    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 140
    .local v5, "iObj":Lorg/json/JSONObject;
    const-string v9, "url"

    invoke-virtual {v5, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_8

    .line 141
    const-string v9, "url"

    invoke-virtual {v5, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Lcom/pinterest/android/pdk/PDKBoard;->setImageUrl(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 147
    .end local v3    # "dataObj":Lorg/json/JSONObject;
    .end local v5    # "iObj":Lorg/json/JSONObject;
    .end local v6    # "imageObj":Lorg/json/JSONObject;
    .end local v7    # "key":Ljava/lang/String;
    .end local v8    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :catch_0
    move-exception v4

    .line 148
    .local v4, "e":Lorg/json/JSONException;
    const-string v9, "PDK: PDKBoard parse JSON error %s"

    new-array v10, v11, [Ljava/lang/Object;

    invoke-virtual {v4}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v9, v10}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 152
    .end local v4    # "e":Lorg/json/JSONException;
    :cond_9
    :goto_1
    return-object v1

    .line 149
    :catch_1
    move-exception v4

    .line 150
    .local v4, "e":Ljava/text/ParseException;
    const-string v9, "PDK: PDKBoard parse error %s"

    new-array v10, v11, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/text/ParseException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v9, v10}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method public static makeBoardList(Ljava/lang/Object;)Ljava/util/List;
    .locals 11
    .param p0, "obj"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/pinterest/android/pdk/PDKBoard;",
            ">;"
        }
    .end annotation

    .prologue
    .line 156
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 158
    .local v1, "boardList":Ljava/util/List;, "Ljava/util/List<Lcom/pinterest/android/pdk/PDKBoard;>;"
    :try_start_0
    instance-of v7, p0, Lorg/json/JSONArray;

    if-eqz v7, :cond_0

    .line 160
    move-object v0, p0

    check-cast v0, Lorg/json/JSONArray;

    move-object v5, v0

    .line 161
    .local v5, "jAarray":Lorg/json/JSONArray;
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v6

    .line 162
    .local v6, "size":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v6, :cond_0

    .line 163
    invoke-virtual {v5, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 164
    .local v2, "dataObj":Lorg/json/JSONObject;
    invoke-static {v2}, Lcom/pinterest/android/pdk/PDKBoard;->makeBoard(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKBoard;

    move-result-object v7

    invoke-interface {v1, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 162
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 167
    .end local v2    # "dataObj":Lorg/json/JSONObject;
    .end local v4    # "i":I
    .end local v5    # "jAarray":Lorg/json/JSONArray;
    .end local v6    # "size":I
    :catch_0
    move-exception v3

    .line 168
    .local v3, "e":Lorg/json/JSONException;
    const-string v7, "PDK: PDKBoard parse JSON error %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v3}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 170
    .end local v3    # "e":Lorg/json/JSONException;
    :cond_0
    return-object v1
.end method


# virtual methods
.method public getCollaboratorsCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKBoard;->collaboratorsCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getCreatedAt()Ljava/util/Date;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKBoard;->createdAt:Ljava/util/Date;

    return-object v0
.end method

.method public getCreator()Lcom/pinterest/android/pdk/PDKUser;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKBoard;->creator:Lcom/pinterest/android/pdk/PDKUser;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKBoard;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getFollowersCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKBoard;->followersCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKBoard;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKBoard;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPinsCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKBoard;->pinsCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getUid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKBoard;->uid:Ljava/lang/String;

    return-object v0
.end method

.method public setCollaboratorsCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "collaboratorsCount"    # Ljava/lang/Integer;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKBoard;->collaboratorsCount:Ljava/lang/Integer;

    .line 52
    return-void
.end method

.method public setCreatedAt(Ljava/util/Date;)V
    .locals 0
    .param p1, "createdAt"    # Ljava/util/Date;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKBoard;->createdAt:Ljava/util/Date;

    .line 44
    return-void
.end method

.method public setCreator(Lcom/pinterest/android/pdk/PDKUser;)V
    .locals 0
    .param p1, "creator"    # Lcom/pinterest/android/pdk/PDKUser;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKBoard;->creator:Lcom/pinterest/android/pdk/PDKUser;

    .line 40
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKBoard;->description:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setFollowersCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "followersCount"    # Ljava/lang/Integer;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKBoard;->followersCount:Ljava/lang/Integer;

    .line 56
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKBoard;->imageUrl:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKBoard;->name:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setPinsCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "pinsCount"    # Ljava/lang/Integer;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKBoard;->pinsCount:Ljava/lang/Integer;

    .line 48
    return-void
.end method

.method public setUid(Ljava/lang/String;)V
    .locals 0
    .param p1, "uid"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKBoard;->uid:Ljava/lang/String;

    .line 28
    return-void
.end method
