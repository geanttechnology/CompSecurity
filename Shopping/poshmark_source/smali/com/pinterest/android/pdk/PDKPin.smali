.class public Lcom/pinterest/android/pdk/PDKPin;
.super Lcom/pinterest/android/pdk/PDKModel;
.source "PDKPin.java"


# instance fields
.field private board:Lcom/pinterest/android/pdk/PDKBoard;

.field private commentCount:Ljava/lang/Integer;

.field private createdAt:Ljava/util/Date;

.field private imageUrl:Ljava/lang/String;

.field private likeCount:Ljava/lang/Integer;

.field private link:Ljava/lang/String;

.field private metadata:Ljava/lang/String;

.field private note:Ljava/lang/String;

.field private repinCount:Ljava/lang/Integer;

.field private uid:Ljava/lang/String;

.field private user:Lcom/pinterest/android/pdk/PDKUser;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/pinterest/android/pdk/PDKModel;-><init>()V

    return-void
.end method

.method public static makePin(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKPin;
    .locals 13
    .param p0, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v11, 0x1

    const/4 v12, 0x0

    .line 29
    new-instance v8, Lcom/pinterest/android/pdk/PDKPin;

    invoke-direct {v8}, Lcom/pinterest/android/pdk/PDKPin;-><init>()V

    .line 31
    .local v8, "pin":Lcom/pinterest/android/pdk/PDKPin;
    :try_start_0
    instance-of v9, p0, Lorg/json/JSONObject;

    if-eqz v9, :cond_c

    .line 32
    move-object v0, p0

    check-cast v0, Lorg/json/JSONObject;

    move-object v2, v0

    .line 33
    .local v2, "dataObj":Lorg/json/JSONObject;
    const-string v9, "id"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 34
    const-string v9, "id"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKPin;->setUid(Ljava/lang/String;)V

    .line 36
    :cond_0
    const-string v9, "link"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 37
    const-string v9, "link"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKPin;->setLink(Ljava/lang/String;)V

    .line 39
    :cond_1
    const-string v9, "note"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 40
    const-string v9, "note"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKPin;->setNote(Ljava/lang/String;)V

    .line 42
    :cond_2
    const-string v9, "metadata"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 43
    const-string v9, "metadata"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKPin;->setMetadata(Ljava/lang/String;)V

    .line 45
    :cond_3
    const-string v9, "counts"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 46
    const-string v9, "counts"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 47
    .local v1, "countsObj":Lorg/json/JSONObject;
    const-string v9, "likes"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 48
    const-string v9, "likes"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKPin;->setLikeCount(Ljava/lang/Integer;)V

    .line 50
    :cond_4
    const-string v9, "comments"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 51
    const-string v9, "comments"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKPin;->setCommentCount(Ljava/lang/Integer;)V

    .line 53
    :cond_5
    const-string v9, "repins"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 54
    const-string v9, "repins"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKPin;->setRepinCount(Ljava/lang/Integer;)V

    .line 57
    .end local v1    # "countsObj":Lorg/json/JSONObject;
    :cond_6
    const-string v9, "metadata"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_7

    .line 58
    const-string v9, "metadata"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKPin;->setMetadata(Ljava/lang/String;)V

    .line 60
    :cond_7
    const-string v9, "creator"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_8

    .line 61
    const-string v9, "creator"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    invoke-static {v9}, Lcom/pinterest/android/pdk/PDKUser;->makeUser(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKUser;

    .line 63
    :cond_8
    const-string v9, "board"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_9

    .line 64
    const-string v9, "board"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    invoke-static {v9}, Lcom/pinterest/android/pdk/PDKBoard;->makeBoard(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKBoard;

    .line 66
    :cond_9
    const-string v9, "created_at"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_a

    .line 67
    invoke-static {}, Lcom/pinterest/android/pdk/Utils;->getDateFormatter()Ljava/text/DateFormat;

    move-result-object v9

    const-string v10, "created_at"

    invoke-virtual {v2, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKPin;->setCreatedAt(Ljava/util/Date;)V

    .line 70
    :cond_a
    const-string v9, "image"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_c

    .line 71
    const-string v9, "image"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 72
    .local v5, "imageObj":Lorg/json/JSONObject;
    invoke-virtual {v5}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v7

    .line 75
    .local v7, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_b
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_c

    .line 76
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 77
    .local v6, "key":Ljava/lang/String;
    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    instance-of v9, v9, Lorg/json/JSONObject;

    if-eqz v9, :cond_b

    .line 78
    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 79
    .local v4, "iObj":Lorg/json/JSONObject;
    const-string v9, "url"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_b

    .line 80
    const-string v9, "url"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKPin;->setImageUrl(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 86
    .end local v2    # "dataObj":Lorg/json/JSONObject;
    .end local v4    # "iObj":Lorg/json/JSONObject;
    .end local v5    # "imageObj":Lorg/json/JSONObject;
    .end local v6    # "key":Ljava/lang/String;
    .end local v7    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :catch_0
    move-exception v3

    .line 87
    .local v3, "e":Lorg/json/JSONException;
    const-string v9, "PDK: PDKPin JSON parse error %s"

    new-array v10, v11, [Ljava/lang/Object;

    invoke-virtual {v3}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v9, v10}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 91
    .end local v3    # "e":Lorg/json/JSONException;
    :cond_c
    :goto_1
    return-object v8

    .line 88
    :catch_1
    move-exception v3

    .line 89
    .local v3, "e":Ljava/text/ParseException;
    const-string v9, "PDK: PDKPin Text parse error %s"

    new-array v10, v11, [Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/text/ParseException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v9, v10}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method public static makePinList(Ljava/lang/Object;)Ljava/util/List;
    .locals 11
    .param p0, "obj"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/pinterest/android/pdk/PDKPin;",
            ">;"
        }
    .end annotation

    .prologue
    .line 95
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 97
    .local v5, "pinList":Ljava/util/List;, "Ljava/util/List<Lcom/pinterest/android/pdk/PDKPin;>;"
    :try_start_0
    instance-of v7, p0, Lorg/json/JSONArray;

    if-eqz v7, :cond_0

    .line 99
    move-object v0, p0

    check-cast v0, Lorg/json/JSONArray;

    move-object v4, v0

    .line 100
    .local v4, "jAarray":Lorg/json/JSONArray;
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v6

    .line 101
    .local v6, "size":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v6, :cond_0

    .line 102
    invoke-virtual {v4, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 103
    .local v1, "dataObj":Lorg/json/JSONObject;
    invoke-static {v1}, Lcom/pinterest/android/pdk/PDKPin;->makePin(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKPin;

    move-result-object v7

    invoke-interface {v5, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 101
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 106
    .end local v1    # "dataObj":Lorg/json/JSONObject;
    .end local v3    # "i":I
    .end local v4    # "jAarray":Lorg/json/JSONArray;
    .end local v6    # "size":I
    :catch_0
    move-exception v2

    .line 107
    .local v2, "e":Lorg/json/JSONException;
    const-string v7, "PDK: PDKPinList parse JSON error %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v2}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 109
    .end local v2    # "e":Lorg/json/JSONException;
    :cond_0
    return-object v5
.end method


# virtual methods
.method public getBoard()Lcom/pinterest/android/pdk/PDKBoard;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKPin;->board:Lcom/pinterest/android/pdk/PDKBoard;

    return-object v0
.end method

.method public getCommentCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKPin;->commentCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getCreatedAt()Ljava/util/Date;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKPin;->createdAt:Ljava/util/Date;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKPin;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getLikeCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKPin;->likeCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKPin;->link:Ljava/lang/String;

    return-object v0
.end method

.method public getMetadata()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKPin;->metadata:Ljava/lang/String;

    return-object v0
.end method

.method public getNote()Ljava/lang/String;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKPin;->note:Ljava/lang/String;

    return-object v0
.end method

.method public getRepinCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKPin;->repinCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getUid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKPin;->uid:Ljava/lang/String;

    return-object v0
.end method

.method public getUser()Lcom/pinterest/android/pdk/PDKUser;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKPin;->user:Lcom/pinterest/android/pdk/PDKUser;

    return-object v0
.end method

.method public setBoard(Lcom/pinterest/android/pdk/PDKBoard;)V
    .locals 0
    .param p1, "board"    # Lcom/pinterest/android/pdk/PDKBoard;

    .prologue
    .line 163
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKPin;->board:Lcom/pinterest/android/pdk/PDKBoard;

    .line 164
    return-void
.end method

.method public setCommentCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "commentCount"    # Ljava/lang/Integer;

    .prologue
    .line 191
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKPin;->commentCount:Ljava/lang/Integer;

    .line 192
    return-void
.end method

.method public setCreatedAt(Ljava/util/Date;)V
    .locals 0
    .param p1, "createdAt"    # Ljava/util/Date;

    .prologue
    .line 183
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKPin;->createdAt:Ljava/util/Date;

    .line 184
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 199
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKPin;->imageUrl:Ljava/lang/String;

    .line 200
    return-void
.end method

.method public setLikeCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "likeCount"    # Ljava/lang/Integer;

    .prologue
    .line 187
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKPin;->likeCount:Ljava/lang/Integer;

    .line 188
    return-void
.end method

.method public setLink(Ljava/lang/String;)V
    .locals 0
    .param p1, "link"    # Ljava/lang/String;

    .prologue
    .line 171
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKPin;->link:Ljava/lang/String;

    .line 172
    return-void
.end method

.method public setMetadata(Ljava/lang/String;)V
    .locals 0
    .param p1, "metadata"    # Ljava/lang/String;

    .prologue
    .line 179
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKPin;->metadata:Ljava/lang/String;

    .line 180
    return-void
.end method

.method public setNote(Ljava/lang/String;)V
    .locals 0
    .param p1, "note"    # Ljava/lang/String;

    .prologue
    .line 175
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKPin;->note:Ljava/lang/String;

    .line 176
    return-void
.end method

.method public setRepinCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "repinCount"    # Ljava/lang/Integer;

    .prologue
    .line 195
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKPin;->repinCount:Ljava/lang/Integer;

    .line 196
    return-void
.end method

.method public setUid(Ljava/lang/String;)V
    .locals 0
    .param p1, "uid"    # Ljava/lang/String;

    .prologue
    .line 159
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKPin;->uid:Ljava/lang/String;

    .line 160
    return-void
.end method

.method public setUser(Lcom/pinterest/android/pdk/PDKUser;)V
    .locals 0
    .param p1, "user"    # Lcom/pinterest/android/pdk/PDKUser;

    .prologue
    .line 167
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKPin;->user:Lcom/pinterest/android/pdk/PDKUser;

    .line 168
    return-void
.end method
