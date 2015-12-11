.class public Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;",
        ">;"
    }
.end annotation


# instance fields
.field private alias:Ljava/lang/String;

.field private created:J

.field private created_by:Ljava/lang/String;

.field private favorite:Z

.field private last_updated_by:Ljava/lang/String;

.field private location:Ljava/lang/String;

.field private modified:J

.field private name:Ljava/lang/String;

.field private parent_Reference:Ljava/lang/String;

.field private requiredQuantity:Ljava/lang/String;

.field private sku:Ljava/lang/String;

.field private tags:Ljava/lang/String;

.field private transientFlag:Z

.field private type:Ljava/lang/String;

.field private uuid:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static parseRegistrySpecificData(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 219
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 220
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 222
    const-string v1, "entities"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    move v1, v2

    .line 223
    :goto_0
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 224
    invoke-virtual {v4, v1}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    .line 226
    new-instance v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;

    invoke-direct {v5}, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;-><init>()V

    .line 227
    const-string v6, "uuid"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->uuid:Ljava/lang/String;

    .line 228
    const-string v6, "type"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->type:Ljava/lang/String;

    .line 229
    const-string v6, "alias"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->alias:Ljava/lang/String;

    .line 230
    const-string v6, "created-by"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->created_by:Ljava/lang/String;

    .line 231
    const-string v6, "last-updated-by"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->last_updated_by:Ljava/lang/String;

    .line 232
    const-string v6, "name"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->name:Ljava/lang/String;

    .line 233
    const-string v6, "tags"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->tags:Ljava/lang/String;

    .line 234
    const-string v6, "transient"

    invoke-virtual {v0, v6, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v6

    iput-boolean v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->transientFlag:Z

    .line 235
    const-string v6, "favorite"

    invoke-virtual {v0, v6, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v6

    iput-boolean v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->favorite:Z

    .line 236
    const-string v6, "created"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v6

    iput-wide v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->created:J

    .line 237
    const-string v6, "modified"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v6

    iput-wide v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->modified:J

    .line 238
    const-string v6, "parentRef"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->parent_Reference:Ljava/lang/String;

    .line 239
    const-string v6, "name"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->name:Ljava/lang/String;

    .line 240
    const-string v6, "required-quantity"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->requiredQuantity:Ljava/lang/String;

    .line 241
    const-string v6, "sku"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->sku:Ljava/lang/String;

    .line 242
    const-string v6, "tags"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v5, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->tags:Ljava/lang/String;

    .line 243
    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 223
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_0

    .line 248
    :cond_0
    return-object v3
.end method


# virtual methods
.method public compareTo(Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;)I
    .locals 4

    .prologue
    .line 252
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->created:J

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->getCreated()J

    move-result-wide v2

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, -0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 15
    check-cast p1, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;

    invoke-virtual {p0, p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->compareTo(Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;)I

    move-result v0

    return v0
.end method

.method public getAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->alias:Ljava/lang/String;

    return-object v0
.end method

.method public getCreated()J
    .locals 2

    .prologue
    .line 45
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->created:J

    return-wide v0
.end method

.method public getCreated_by()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->created_by:Ljava/lang/String;

    return-object v0
.end method

.method public getFavorite()Z
    .locals 1

    .prologue
    .line 175
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->favorite:Z

    return v0
.end method

.method public getLast_updated_by()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->last_updated_by:Ljava/lang/String;

    return-object v0
.end method

.method public getLocation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->location:Ljava/lang/String;

    return-object v0
.end method

.method public getModified()J
    .locals 2

    .prologue
    .line 57
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->modified:J

    return-wide v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getParent_Reference()Ljava/lang/String;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->parent_Reference:Ljava/lang/String;

    return-object v0
.end method

.method public getRequiredQuantity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->requiredQuantity:Ljava/lang/String;

    return-object v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public getTags()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->tags:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getUuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->uuid:Ljava/lang/String;

    return-object v0
.end method

.method public isTransientFlag()Z
    .locals 1

    .prologue
    .line 69
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->transientFlag:Z

    return v0
.end method

.method public setAlias(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->alias:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setCreated(J)V
    .locals 1

    .prologue
    .line 51
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->created:J

    .line 52
    return-void
.end method

.method public setCreated_by(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->created_by:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setFavorite(Z)V
    .locals 0

    .prologue
    .line 181
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->favorite:Z

    .line 182
    return-void
.end method

.method public setLast_updated_by(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->last_updated_by:Ljava/lang/String;

    .line 112
    return-void
.end method

.method public setLocation(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 147
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->location:Ljava/lang/String;

    .line 148
    return-void
.end method

.method public setModified(J)V
    .locals 1

    .prologue
    .line 63
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->modified:J

    .line 64
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->name:Ljava/lang/String;

    .line 124
    return-void
.end method

.method public setParent_Reference(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 159
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->parent_Reference:Ljava/lang/String;

    .line 160
    return-void
.end method

.method public setRequiredQuantity(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 196
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->requiredQuantity:Ljava/lang/String;

    .line 197
    return-void
.end method

.method public setSku(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->sku:Ljava/lang/String;

    .line 172
    return-void
.end method

.method public setTags(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->tags:Ljava/lang/String;

    .line 136
    return-void
.end method

.method public setTransientFlag(Z)V
    .locals 0

    .prologue
    .line 75
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->transientFlag:Z

    .line 76
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->type:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setUuid(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistrySpecificResData;->uuid:Ljava/lang/String;

    .line 28
    return-void
.end method
