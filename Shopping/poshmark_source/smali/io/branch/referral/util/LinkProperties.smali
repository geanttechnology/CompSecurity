.class public Lio/branch/referral/util/LinkProperties;
.super Ljava/lang/Object;
.source "LinkProperties.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;


# instance fields
.field private alias_:Ljava/lang/String;

.field private channel_:Ljava/lang/String;

.field private final controlParams_:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private feature_:Ljava/lang/String;

.field private matchDuration_:I

.field private stage_:Ljava/lang/String;

.field private final tags_:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 213
    new-instance v0, Lio/branch/referral/util/LinkProperties$1;

    invoke-direct {v0}, Lio/branch/referral/util/LinkProperties$1;-><init>()V

    sput-object v0, Lio/branch/referral/util/LinkProperties;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lio/branch/referral/util/LinkProperties;->tags_:Ljava/util/ArrayList;

    .line 42
    const-string v0, "Share"

    iput-object v0, p0, Lio/branch/referral/util/LinkProperties;->feature_:Ljava/lang/String;

    .line 43
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lio/branch/referral/util/LinkProperties;->controlParams_:Ljava/util/HashMap;

    .line 44
    const-string v0, ""

    iput-object v0, p0, Lio/branch/referral/util/LinkProperties;->alias_:Ljava/lang/String;

    .line 45
    const-string v0, ""

    iput-object v0, p0, Lio/branch/referral/util/LinkProperties;->stage_:Ljava/lang/String;

    .line 46
    const/4 v0, 0x0

    iput v0, p0, Lio/branch/referral/util/LinkProperties;->matchDuration_:I

    .line 47
    const-string v0, ""

    iput-object v0, p0, Lio/branch/referral/util/LinkProperties;->channel_:Ljava/lang/String;

    .line 48
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 6
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 293
    invoke-direct {p0}, Lio/branch/referral/util/LinkProperties;-><init>()V

    .line 294
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lio/branch/referral/util/LinkProperties;->feature_:Ljava/lang/String;

    .line 295
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lio/branch/referral/util/LinkProperties;->alias_:Ljava/lang/String;

    .line 296
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lio/branch/referral/util/LinkProperties;->stage_:Ljava/lang/String;

    .line 297
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lio/branch/referral/util/LinkProperties;->channel_:Ljava/lang/String;

    .line 298
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v3

    iput v3, p0, Lio/branch/referral/util/LinkProperties;->matchDuration_:I

    .line 300
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    .line 301
    .local v2, "tagsTemp":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v3, p0, Lio/branch/referral/util/LinkProperties;->tags_:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 303
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 304
    .local v0, "controlPramSize":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 305
    iget-object v3, p0, Lio/branch/referral/util/LinkProperties;->controlParams_:Ljava/util/HashMap;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 304
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 307
    :cond_0
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lio/branch/referral/util/LinkProperties$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lio/branch/referral/util/LinkProperties$1;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lio/branch/referral/util/LinkProperties;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public static getReferredLinkProperties()Lio/branch/referral/util/LinkProperties;
    .locals 9

    .prologue
    .line 229
    const/4 v5, 0x0

    .line 230
    .local v5, "linkProperties":Lio/branch/referral/util/LinkProperties;
    invoke-static {}, Lio/branch/referral/Branch;->getInstance()Lio/branch/referral/Branch;

    move-result-object v0

    .line 231
    .local v0, "branchInstance":Lio/branch/referral/Branch;
    if-eqz v0, :cond_7

    invoke-virtual {v0}, Lio/branch/referral/Branch;->getLatestReferringParams()Lorg/json/JSONObject;

    move-result-object v8

    if-eqz v8, :cond_7

    .line 232
    invoke-virtual {v0}, Lio/branch/referral/Branch;->getLatestReferringParams()Lorg/json/JSONObject;

    move-result-object v4

    .line 235
    .local v4, "latestParam":Lorg/json/JSONObject;
    :try_start_0
    const-string v8, "+clicked_branch_link"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_7

    const-string v8, "+clicked_branch_link"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 236
    new-instance v6, Lio/branch/referral/util/LinkProperties;

    invoke-direct {v6}, Lio/branch/referral/util/LinkProperties;-><init>()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 237
    .end local v5    # "linkProperties":Lio/branch/referral/util/LinkProperties;
    .local v6, "linkProperties":Lio/branch/referral/util/LinkProperties;
    :try_start_1
    const-string v8, "~channel"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 238
    const-string v8, "~channel"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lio/branch/referral/util/LinkProperties;->setChannel(Ljava/lang/String;)Lio/branch/referral/util/LinkProperties;

    .line 240
    :cond_0
    const-string v8, "~feature"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 241
    const-string v8, "~feature"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lio/branch/referral/util/LinkProperties;->setFeature(Ljava/lang/String;)Lio/branch/referral/util/LinkProperties;

    .line 243
    :cond_1
    const-string v8, "~stage"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 244
    const-string v8, "~stage"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lio/branch/referral/util/LinkProperties;->setStage(Ljava/lang/String;)Lio/branch/referral/util/LinkProperties;

    .line 246
    :cond_2
    const-string v8, "~duration"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 247
    const-string v8, "~duration"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v6, v8}, Lio/branch/referral/util/LinkProperties;->setDuration(I)Lio/branch/referral/util/LinkProperties;

    .line 249
    :cond_3
    const-string v8, "$match_duration"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 250
    const-string v8, "$match_duration"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v6, v8}, Lio/branch/referral/util/LinkProperties;->setDuration(I)Lio/branch/referral/util/LinkProperties;

    .line 252
    :cond_4
    const-string v8, "~tags"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 253
    const-string v8, "~tags"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    .line 254
    .local v7, "tagsArray":Lorg/json/JSONArray;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v8

    if-ge v1, v8, :cond_5

    .line 255
    invoke-virtual {v7, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lio/branch/referral/util/LinkProperties;->addTag(Ljava/lang/String;)Lio/branch/referral/util/LinkProperties;

    .line 254
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 259
    .end local v1    # "i":I
    .end local v7    # "tagsArray":Lorg/json/JSONArray;
    :cond_5
    invoke-virtual {v4}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v3

    .line 260
    .local v3, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_6
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_8

    .line 261
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 262
    .local v2, "key":Ljava/lang/String;
    const-string v8, "$"

    invoke-virtual {v2, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 263
    invoke-virtual {v4, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v2, v8}, Lio/branch/referral/util/LinkProperties;->addControlParameter(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/util/LinkProperties;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 267
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :catch_0
    move-exception v8

    move-object v5, v6

    .line 270
    .end local v4    # "latestParam":Lorg/json/JSONObject;
    .end local v6    # "linkProperties":Lio/branch/referral/util/LinkProperties;
    .restart local v5    # "linkProperties":Lio/branch/referral/util/LinkProperties;
    :cond_7
    :goto_2
    return-object v5

    .line 267
    .restart local v4    # "latestParam":Lorg/json/JSONObject;
    :catch_1
    move-exception v8

    goto :goto_2

    .end local v5    # "linkProperties":Lio/branch/referral/util/LinkProperties;
    .restart local v3    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .restart local v6    # "linkProperties":Lio/branch/referral/util/LinkProperties;
    :cond_8
    move-object v5, v6

    .end local v6    # "linkProperties":Lio/branch/referral/util/LinkProperties;
    .restart local v5    # "linkProperties":Lio/branch/referral/util/LinkProperties;
    goto :goto_2
.end method


# virtual methods
.method public addControlParameter(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/util/LinkProperties;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 88
    iget-object v0, p0, Lio/branch/referral/util/LinkProperties;->controlParams_:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    return-object p0
.end method

.method public addTag(Ljava/lang/String;)Lio/branch/referral/util/LinkProperties;
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 74
    iget-object v0, p0, Lio/branch/referral/util/LinkProperties;->tags_:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 75
    return-object p0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 210
    const/4 v0, 0x0

    return v0
.end method

.method public getAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lio/branch/referral/util/LinkProperties;->alias_:Ljava/lang/String;

    return-object v0
.end method

.method public getChannel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lio/branch/referral/util/LinkProperties;->channel_:Ljava/lang/String;

    return-object v0
.end method

.method public getControlParams()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 155
    iget-object v0, p0, Lio/branch/referral/util/LinkProperties;->controlParams_:Ljava/util/HashMap;

    return-object v0
.end method

.method public getFeature()Ljava/lang/String;
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lio/branch/referral/util/LinkProperties;->feature_:Ljava/lang/String;

    return-object v0
.end method

.method public getMatchDuration()I
    .locals 1

    .prologue
    .line 167
    iget v0, p0, Lio/branch/referral/util/LinkProperties;->matchDuration_:I

    return v0
.end method

.method public getStage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lio/branch/referral/util/LinkProperties;->stage_:Ljava/lang/String;

    return-object v0
.end method

.method public getTags()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 146
    iget-object v0, p0, Lio/branch/referral/util/LinkProperties;->tags_:Ljava/util/ArrayList;

    return-object v0
.end method

.method public setAlias(Ljava/lang/String;)Lio/branch/referral/util/LinkProperties;
    .locals 0
    .param p1, "alias"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lio/branch/referral/util/LinkProperties;->alias_:Ljava/lang/String;

    .line 63
    return-object p0
.end method

.method public setChannel(Ljava/lang/String;)Lio/branch/referral/util/LinkProperties;
    .locals 0
    .param p1, "channel"    # Ljava/lang/String;

    .prologue
    .line 136
    iput-object p1, p0, Lio/branch/referral/util/LinkProperties;->channel_:Ljava/lang/String;

    .line 137
    return-object p0
.end method

.method public setDuration(I)Lio/branch/referral/util/LinkProperties;
    .locals 0
    .param p1, "duration"    # I

    .prologue
    .line 112
    iput p1, p0, Lio/branch/referral/util/LinkProperties;->matchDuration_:I

    .line 113
    return-object p0
.end method

.method public setFeature(Ljava/lang/String;)Lio/branch/referral/util/LinkProperties;
    .locals 0
    .param p1, "feature"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lio/branch/referral/util/LinkProperties;->feature_:Ljava/lang/String;

    .line 101
    return-object p0
.end method

.method public setStage(Ljava/lang/String;)Lio/branch/referral/util/LinkProperties;
    .locals 0
    .param p1, "stage"    # Ljava/lang/String;

    .prologue
    .line 124
    iput-object p1, p0, Lio/branch/referral/util/LinkProperties;->stage_:Ljava/lang/String;

    .line 125
    return-object p0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 4
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 276
    iget-object v3, p0, Lio/branch/referral/util/LinkProperties;->feature_:Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 277
    iget-object v3, p0, Lio/branch/referral/util/LinkProperties;->alias_:Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 278
    iget-object v3, p0, Lio/branch/referral/util/LinkProperties;->stage_:Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 279
    iget-object v3, p0, Lio/branch/referral/util/LinkProperties;->channel_:Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 280
    iget v3, p0, Lio/branch/referral/util/LinkProperties;->matchDuration_:I

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 281
    iget-object v3, p0, Lio/branch/referral/util/LinkProperties;->tags_:Ljava/util/ArrayList;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 283
    iget-object v3, p0, Lio/branch/referral/util/LinkProperties;->controlParams_:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->size()I

    move-result v0

    .line 284
    .local v0, "controlParamSize":I
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 285
    iget-object v3, p0, Lio/branch/referral/util/LinkProperties;->controlParams_:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 286
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 287
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 290
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    return-void
.end method
