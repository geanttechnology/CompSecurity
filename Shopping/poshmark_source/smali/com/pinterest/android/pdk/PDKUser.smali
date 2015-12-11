.class public Lcom/pinterest/android/pdk/PDKUser;
.super Lcom/pinterest/android/pdk/PDKModel;
.source "PDKUser.java"


# instance fields
.field private bio:Ljava/lang/String;

.field private boardsCount:Ljava/lang/Integer;

.field private createdAt:Ljava/util/Date;

.field private firstName:Ljava/lang/String;

.field private followersCount:Ljava/lang/Integer;

.field private followingCount:Ljava/lang/Integer;

.field private imageHeight:Ljava/lang/Integer;

.field private imageUrl:Ljava/lang/String;

.field private imageWidth:Ljava/lang/Integer;

.field private lastName:Ljava/lang/String;

.field private likesCount:Ljava/lang/Integer;

.field private pinCount:Ljava/lang/Integer;

.field private uid:Ljava/lang/String;

.field private username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/pinterest/android/pdk/PDKModel;-><init>()V

    return-void
.end method

.method public static makeUser(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKUser;
    .locals 13
    .param p0, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v11, 0x1

    const/4 v12, 0x0

    .line 146
    new-instance v8, Lcom/pinterest/android/pdk/PDKUser;

    invoke-direct {v8}, Lcom/pinterest/android/pdk/PDKUser;-><init>()V

    .line 148
    .local v8, "user":Lcom/pinterest/android/pdk/PDKUser;
    :try_start_0
    instance-of v9, p0, Lorg/json/JSONObject;

    if-eqz v9, :cond_c

    .line 150
    move-object v0, p0

    check-cast v0, Lorg/json/JSONObject;

    move-object v2, v0

    .line 151
    .local v2, "dataObj":Lorg/json/JSONObject;
    const-string v9, "id"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 152
    const-string v9, "id"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setUid(Ljava/lang/String;)V

    .line 154
    :cond_0
    const-string v9, "first_name"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 155
    const-string v9, "first_name"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setFirstName(Ljava/lang/String;)V

    .line 157
    :cond_1
    const-string v9, "last_name"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 158
    const-string v9, "last_name"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setLastName(Ljava/lang/String;)V

    .line 160
    :cond_2
    const-string v9, "username"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 161
    const-string v9, "username"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setUsername(Ljava/lang/String;)V

    .line 163
    :cond_3
    const-string v9, "bio"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 164
    const-string v9, "bio"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setBio(Ljava/lang/String;)V

    .line 166
    :cond_4
    const-string v9, "created_at"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 167
    invoke-static {}, Lcom/pinterest/android/pdk/Utils;->getDateFormatter()Ljava/text/DateFormat;

    move-result-object v9

    const-string v10, "created_at"

    invoke-virtual {v2, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setCreatedAt(Ljava/util/Date;)V

    .line 170
    :cond_5
    const-string v9, "counts"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_a

    .line 171
    const-string v9, "counts"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 172
    .local v1, "countsObj":Lorg/json/JSONObject;
    const-string v9, "pins"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 173
    const-string v9, "pins"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setLikesCount(Ljava/lang/Integer;)V

    .line 175
    :cond_6
    const-string v9, "following"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_7

    .line 176
    const-string v9, "following"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setFollowingCount(Ljava/lang/Integer;)V

    .line 178
    :cond_7
    const-string v9, "followers"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_8

    .line 179
    const-string v9, "followers"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setFollowersCount(Ljava/lang/Integer;)V

    .line 181
    :cond_8
    const-string v9, "boards"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_9

    .line 182
    const-string v9, "boards"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setBoardsCount(Ljava/lang/Integer;)V

    .line 184
    :cond_9
    const-string v9, "likes"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_a

    .line 185
    const-string v9, "likes"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setLikesCount(Ljava/lang/Integer;)V

    .line 188
    .end local v1    # "countsObj":Lorg/json/JSONObject;
    :cond_a
    const-string v9, "image"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_c

    .line 189
    const-string v9, "image"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 190
    .local v5, "imageObj":Lorg/json/JSONObject;
    invoke-virtual {v5}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v7

    .line 193
    .local v7, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_b
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_c

    .line 194
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 195
    .local v6, "key":Ljava/lang/String;
    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    instance-of v9, v9, Lorg/json/JSONObject;

    if-eqz v9, :cond_b

    .line 196
    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 197
    .local v4, "iObj":Lorg/json/JSONObject;
    const-string v9, "url"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_b

    .line 198
    const-string v9, "url"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/pinterest/android/pdk/PDKUser;->setImageUrl(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 204
    .end local v2    # "dataObj":Lorg/json/JSONObject;
    .end local v4    # "iObj":Lorg/json/JSONObject;
    .end local v5    # "imageObj":Lorg/json/JSONObject;
    .end local v6    # "key":Ljava/lang/String;
    .end local v7    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :catch_0
    move-exception v3

    .line 205
    .local v3, "e":Lorg/json/JSONException;
    const-string v9, "PDK: PDKUser parse JSON error %s"

    new-array v10, v11, [Ljava/lang/Object;

    invoke-virtual {v3}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v9, v10}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 209
    .end local v3    # "e":Lorg/json/JSONException;
    :cond_c
    :goto_1
    return-object v8

    .line 206
    :catch_1
    move-exception v3

    .line 207
    .local v3, "e":Ljava/text/ParseException;
    const-string v9, "PDK: PDKUser parse error %s"

    new-array v10, v11, [Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/text/ParseException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v9, v10}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method public static makeUserList(Ljava/lang/Object;)Ljava/util/List;
    .locals 11
    .param p0, "obj"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/pinterest/android/pdk/PDKUser;",
            ">;"
        }
    .end annotation

    .prologue
    .line 213
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 215
    .local v6, "userList":Ljava/util/List;, "Ljava/util/List<Lcom/pinterest/android/pdk/PDKUser;>;"
    :try_start_0
    instance-of v7, p0, Lorg/json/JSONArray;

    if-eqz v7, :cond_0

    .line 217
    move-object v0, p0

    check-cast v0, Lorg/json/JSONArray;

    move-object v4, v0

    .line 218
    .local v4, "jAarray":Lorg/json/JSONArray;
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    .line 219
    .local v5, "size":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v5, :cond_0

    .line 220
    invoke-virtual {v4, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 221
    .local v1, "dataObj":Lorg/json/JSONObject;
    invoke-static {v1}, Lcom/pinterest/android/pdk/PDKUser;->makeUser(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKUser;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 219
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 224
    .end local v1    # "dataObj":Lorg/json/JSONObject;
    .end local v3    # "i":I
    .end local v4    # "jAarray":Lorg/json/JSONArray;
    .end local v5    # "size":I
    :catch_0
    move-exception v2

    .line 225
    .local v2, "e":Lorg/json/JSONException;
    const-string v7, "PDK: PDKUserList parse JSON error %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v2}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 227
    .end local v2    # "e":Lorg/json/JSONException;
    :cond_0
    return-object v6
.end method


# virtual methods
.method public getBio()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->bio:Ljava/lang/String;

    return-object v0
.end method

.method public getBoardsCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->boardsCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getCreatedAt()Ljava/util/Date;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->createdAt:Ljava/util/Date;

    return-object v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->firstName:Ljava/lang/String;

    return-object v0
.end method

.method public getFollowersCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->followersCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getFollowingCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->followingCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getImageHeight()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->imageHeight:Ljava/lang/Integer;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getImageWidth()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->imageWidth:Ljava/lang/Integer;

    return-object v0
.end method

.method public getLastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->lastName:Ljava/lang/String;

    return-object v0
.end method

.method public getLikesCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->likesCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getPinCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->pinCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getUid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->uid:Ljava/lang/String;

    return-object v0
.end method

.method public getUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKUser;->username:Ljava/lang/String;

    return-object v0
.end method

.method public setBio(Ljava/lang/String;)V
    .locals 0
    .param p1, "bio"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->bio:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setBoardsCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "boardsCount"    # Ljava/lang/Integer;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->boardsCount:Ljava/lang/Integer;

    .line 85
    return-void
.end method

.method public setCreatedAt(Ljava/util/Date;)V
    .locals 0
    .param p1, "createdAt"    # Ljava/util/Date;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->createdAt:Ljava/util/Date;

    .line 53
    return-void
.end method

.method public setFirstName(Ljava/lang/String;)V
    .locals 0
    .param p1, "firstName"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->firstName:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setFollowersCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "followersCount"    # Ljava/lang/Integer;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->followersCount:Ljava/lang/Integer;

    .line 69
    return-void
.end method

.method public setFollowingCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "followingCount"    # Ljava/lang/Integer;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->followingCount:Ljava/lang/Integer;

    .line 73
    return-void
.end method

.method public setImageHeight(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "imageHeight"    # Ljava/lang/Integer;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->imageHeight:Ljava/lang/Integer;

    .line 65
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->imageUrl:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public setImageWidth(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "imageWidth"    # Ljava/lang/Integer;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->imageWidth:Ljava/lang/Integer;

    .line 61
    return-void
.end method

.method public setLastName(Ljava/lang/String;)V
    .locals 0
    .param p1, "lastName"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->lastName:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setLikesCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "likesCount"    # Ljava/lang/Integer;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->likesCount:Ljava/lang/Integer;

    .line 81
    return-void
.end method

.method public setPinCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "pinCount"    # Ljava/lang/Integer;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->pinCount:Ljava/lang/Integer;

    .line 77
    return-void
.end method

.method public setUid(Ljava/lang/String;)V
    .locals 0
    .param p1, "uid"    # Ljava/lang/String;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->uid:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public setUsername(Ljava/lang/String;)V
    .locals 0
    .param p1, "username"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKUser;->username:Ljava/lang/String;

    .line 37
    return-void
.end method
