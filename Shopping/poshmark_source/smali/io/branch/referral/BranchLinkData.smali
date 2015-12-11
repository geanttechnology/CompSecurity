.class Lio/branch/referral/BranchLinkData;
.super Lorg/json/JSONObject;
.source "BranchLinkData.java"


# instance fields
.field private alias:Ljava/lang/String;

.field private channel:Ljava/lang/String;

.field private duration:I

.field private feature:Ljava/lang/String;

.field private params:Ljava/lang/String;

.field private stage:Ljava/lang/String;

.field private tags:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private type:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 128
    invoke-direct {p0}, Lorg/json/JSONObject;-><init>()V

    .line 129
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 303
    if-ne p0, p1, :cond_1

    .line 346
    :cond_0
    :goto_0
    return v1

    .line 305
    :cond_1
    if-nez p1, :cond_2

    move v1, v2

    .line 306
    goto :goto_0

    .line 307
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 308
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 309
    check-cast v0, Lio/branch/referral/BranchLinkData;

    .line 310
    .local v0, "other":Lio/branch/referral/BranchLinkData;
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->alias:Ljava/lang/String;

    if-nez v3, :cond_4

    .line 311
    iget-object v3, v0, Lio/branch/referral/BranchLinkData;->alias:Ljava/lang/String;

    if-eqz v3, :cond_5

    move v1, v2

    .line 312
    goto :goto_0

    .line 313
    :cond_4
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->alias:Ljava/lang/String;

    iget-object v4, v0, Lio/branch/referral/BranchLinkData;->alias:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    move v1, v2

    .line 314
    goto :goto_0

    .line 315
    :cond_5
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->channel:Ljava/lang/String;

    if-nez v3, :cond_6

    .line 316
    iget-object v3, v0, Lio/branch/referral/BranchLinkData;->channel:Ljava/lang/String;

    if-eqz v3, :cond_7

    move v1, v2

    .line 317
    goto :goto_0

    .line 318
    :cond_6
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->channel:Ljava/lang/String;

    iget-object v4, v0, Lio/branch/referral/BranchLinkData;->channel:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_7

    move v1, v2

    .line 319
    goto :goto_0

    .line 320
    :cond_7
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->feature:Ljava/lang/String;

    if-nez v3, :cond_8

    .line 321
    iget-object v3, v0, Lio/branch/referral/BranchLinkData;->feature:Ljava/lang/String;

    if-eqz v3, :cond_9

    move v1, v2

    .line 322
    goto :goto_0

    .line 323
    :cond_8
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->feature:Ljava/lang/String;

    iget-object v4, v0, Lio/branch/referral/BranchLinkData;->feature:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    move v1, v2

    .line 324
    goto :goto_0

    .line 325
    :cond_9
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->params:Ljava/lang/String;

    if-nez v3, :cond_a

    .line 326
    iget-object v3, v0, Lio/branch/referral/BranchLinkData;->params:Ljava/lang/String;

    if-eqz v3, :cond_b

    move v1, v2

    .line 327
    goto :goto_0

    .line 328
    :cond_a
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->params:Ljava/lang/String;

    iget-object v4, v0, Lio/branch/referral/BranchLinkData;->params:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_b

    move v1, v2

    .line 329
    goto :goto_0

    .line 330
    :cond_b
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->stage:Ljava/lang/String;

    if-nez v3, :cond_c

    .line 331
    iget-object v3, v0, Lio/branch/referral/BranchLinkData;->stage:Ljava/lang/String;

    if-eqz v3, :cond_d

    move v1, v2

    .line 332
    goto :goto_0

    .line 333
    :cond_c
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->stage:Ljava/lang/String;

    iget-object v4, v0, Lio/branch/referral/BranchLinkData;->stage:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_d

    move v1, v2

    .line 334
    goto/16 :goto_0

    .line 335
    :cond_d
    iget v3, p0, Lio/branch/referral/BranchLinkData;->type:I

    iget v4, v0, Lio/branch/referral/BranchLinkData;->type:I

    if-eq v3, v4, :cond_e

    move v1, v2

    .line 336
    goto/16 :goto_0

    .line 337
    :cond_e
    iget v3, p0, Lio/branch/referral/BranchLinkData;->duration:I

    iget v4, v0, Lio/branch/referral/BranchLinkData;->duration:I

    if-eq v3, v4, :cond_f

    move v1, v2

    .line 338
    goto/16 :goto_0

    .line 340
    :cond_f
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->tags:Ljava/util/Collection;

    if-nez v3, :cond_10

    .line 341
    iget-object v3, v0, Lio/branch/referral/BranchLinkData;->tags:Ljava/util/Collection;

    if-eqz v3, :cond_0

    move v1, v2

    .line 342
    goto/16 :goto_0

    .line 343
    :cond_10
    iget-object v3, p0, Lio/branch/referral/BranchLinkData;->tags:Ljava/util/Collection;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, v0, Lio/branch/referral/BranchLinkData;->tags:Ljava/util/Collection;

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 344
    goto/16 :goto_0
.end method

.method public getAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lio/branch/referral/BranchLinkData;->alias:Ljava/lang/String;

    return-object v0
.end method

.method public getChannel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lio/branch/referral/BranchLinkData;->channel:Ljava/lang/String;

    return-object v0
.end method

.method public getDuration()I
    .locals 1

    .prologue
    .line 215
    iget v0, p0, Lio/branch/referral/BranchLinkData;->duration:I

    return v0
.end method

.method public getFeature()Ljava/lang/String;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lio/branch/referral/BranchLinkData;->feature:Ljava/lang/String;

    return-object v0
.end method

.method public getParams()Ljava/lang/String;
    .locals 1

    .prologue
    .line 289
    iget-object v0, p0, Lio/branch/referral/BranchLinkData;->params:Ljava/lang/String;

    return-object v0
.end method

.method public getStage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 273
    iget-object v0, p0, Lio/branch/referral/BranchLinkData;->stage:Ljava/lang/String;

    return-object v0
.end method

.method public getTags()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 154
    iget-object v0, p0, Lio/branch/referral/BranchLinkData;->tags:Ljava/util/Collection;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 195
    iget v0, p0, Lio/branch/referral/BranchLinkData;->type:I

    return v0
.end method

.method public hashCode()I
    .locals 7
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "DefaultLocale"
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 375
    const/4 v2, 0x1

    .line 376
    .local v2, "result":I
    const/16 v1, 0x13

    .line 378
    .local v1, "prime":I
    iget v4, p0, Lio/branch/referral/BranchLinkData;->type:I

    add-int/lit8 v2, v4, 0x13

    .line 379
    mul-int v6, v1, v2

    iget-object v4, p0, Lio/branch/referral/BranchLinkData;->alias:Ljava/lang/String;

    if-nez v4, :cond_0

    move v4, v5

    :goto_0
    add-int v2, v6, v4

    .line 381
    mul-int v6, v1, v2

    iget-object v4, p0, Lio/branch/referral/BranchLinkData;->channel:Ljava/lang/String;

    if-nez v4, :cond_1

    move v4, v5

    :goto_1
    add-int v2, v6, v4

    .line 383
    mul-int v6, v1, v2

    iget-object v4, p0, Lio/branch/referral/BranchLinkData;->feature:Ljava/lang/String;

    if-nez v4, :cond_2

    move v4, v5

    :goto_2
    add-int v2, v6, v4

    .line 385
    mul-int v6, v1, v2

    iget-object v4, p0, Lio/branch/referral/BranchLinkData;->stage:Ljava/lang/String;

    if-nez v4, :cond_3

    move v4, v5

    :goto_3
    add-int v2, v6, v4

    .line 387
    mul-int v4, v1, v2

    iget-object v6, p0, Lio/branch/referral/BranchLinkData;->params:Ljava/lang/String;

    if-nez v6, :cond_4

    :goto_4
    add-int v2, v4, v5

    .line 389
    mul-int v4, v1, v2

    iget v5, p0, Lio/branch/referral/BranchLinkData;->duration:I

    add-int v2, v4, v5

    .line 391
    iget-object v4, p0, Lio/branch/referral/BranchLinkData;->tags:Ljava/util/Collection;

    if-eqz v4, :cond_5

    .line 392
    iget-object v4, p0, Lio/branch/referral/BranchLinkData;->tags:Ljava/util/Collection;

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_5
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_5

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 393
    .local v3, "tag":Ljava/lang/String;
    mul-int v4, v1, v2

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->hashCode()I

    move-result v5

    add-int v2, v4, v5

    .line 394
    goto :goto_5

    .line 379
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v3    # "tag":Ljava/lang/String;
    :cond_0
    iget-object v4, p0, Lio/branch/referral/BranchLinkData;->alias:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v4

    goto :goto_0

    .line 381
    :cond_1
    iget-object v4, p0, Lio/branch/referral/BranchLinkData;->channel:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v4

    goto :goto_1

    .line 383
    :cond_2
    iget-object v4, p0, Lio/branch/referral/BranchLinkData;->feature:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v4

    goto :goto_2

    .line 385
    :cond_3
    iget-object v4, p0, Lio/branch/referral/BranchLinkData;->stage:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v4

    goto :goto_3

    .line 387
    :cond_4
    iget-object v5, p0, Lio/branch/referral/BranchLinkData;->params:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->hashCode()I

    move-result v5

    goto :goto_4

    .line 397
    :cond_5
    return v2
.end method

.method public putAlias(Ljava/lang/String;)V
    .locals 1
    .param p1, "alias"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 165
    if-eqz p1, :cond_0

    .line 166
    iput-object p1, p0, Lio/branch/referral/BranchLinkData;->alias:Ljava/lang/String;

    .line 167
    sget-object v0, Lio/branch/referral/Defines$LinkParam;->Alias:Lio/branch/referral/Defines$LinkParam;

    invoke-virtual {v0}, Lio/branch/referral/Defines$LinkParam;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 169
    :cond_0
    return-void
.end method

.method public putChannel(Ljava/lang/String;)V
    .locals 1
    .param p1, "channel"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 228
    if-eqz p1, :cond_0

    .line 229
    iput-object p1, p0, Lio/branch/referral/BranchLinkData;->channel:Ljava/lang/String;

    .line 230
    sget-object v0, Lio/branch/referral/Defines$LinkParam;->Channel:Lio/branch/referral/Defines$LinkParam;

    invoke-virtual {v0}, Lio/branch/referral/Defines$LinkParam;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 232
    :cond_0
    return-void
.end method

.method public putDuration(I)V
    .locals 1
    .param p1, "duration"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 208
    if-lez p1, :cond_0

    .line 209
    iput p1, p0, Lio/branch/referral/BranchLinkData;->duration:I

    .line 210
    sget-object v0, Lio/branch/referral/Defines$LinkParam;->Duration:Lio/branch/referral/Defines$LinkParam;

    invoke-virtual {v0}, Lio/branch/referral/Defines$LinkParam;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 212
    :cond_0
    return-void
.end method

.method public putFeature(Ljava/lang/String;)V
    .locals 1
    .param p1, "feature"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 247
    if-eqz p1, :cond_0

    .line 248
    iput-object p1, p0, Lio/branch/referral/BranchLinkData;->feature:Ljava/lang/String;

    .line 249
    sget-object v0, Lio/branch/referral/Defines$LinkParam;->Feature:Lio/branch/referral/Defines$LinkParam;

    invoke-virtual {v0}, Lio/branch/referral/Defines$LinkParam;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 251
    :cond_0
    return-void
.end method

.method public putParams(Ljava/lang/String;)V
    .locals 1
    .param p1, "params"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 284
    iput-object p1, p0, Lio/branch/referral/BranchLinkData;->params:Ljava/lang/String;

    .line 285
    sget-object v0, Lio/branch/referral/Defines$LinkParam;->Data:Lio/branch/referral/Defines$LinkParam;

    invoke-virtual {v0}, Lio/branch/referral/Defines$LinkParam;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 286
    return-void
.end method

.method public putStage(Ljava/lang/String;)V
    .locals 1
    .param p1, "stage"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 266
    if-eqz p1, :cond_0

    .line 267
    iput-object p1, p0, Lio/branch/referral/BranchLinkData;->stage:Ljava/lang/String;

    .line 268
    sget-object v0, Lio/branch/referral/Defines$LinkParam;->Stage:Lio/branch/referral/Defines$LinkParam;

    invoke-virtual {v0}, Lio/branch/referral/Defines$LinkParam;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 270
    :cond_0
    return-void
.end method

.method public putTags(Ljava/util/Collection;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 143
    .local p1, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    if-eqz p1, :cond_1

    .line 144
    iput-object p1, p0, Lio/branch/referral/BranchLinkData;->tags:Ljava/util/Collection;

    .line 146
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 147
    .local v2, "tagArray":Lorg/json/JSONArray;
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 148
    .local v1, "tag":Ljava/lang/String;
    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_0

    .line 149
    .end local v1    # "tag":Ljava/lang/String;
    :cond_0
    sget-object v3, Lio/branch/referral/Defines$LinkParam;->Tags:Lio/branch/referral/Defines$LinkParam;

    invoke-virtual {v3}, Lio/branch/referral/Defines$LinkParam;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3, v2}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 151
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v2    # "tagArray":Lorg/json/JSONArray;
    :cond_1
    return-void
.end method

.method public putType(I)V
    .locals 1
    .param p1, "type"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 188
    if-eqz p1, :cond_0

    .line 189
    iput p1, p0, Lio/branch/referral/BranchLinkData;->type:I

    .line 190
    sget-object v0, Lio/branch/referral/Defines$LinkParam;->Type:Lio/branch/referral/Defines$LinkParam;

    invoke-virtual {v0}, Lio/branch/referral/Defines$LinkParam;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 192
    :cond_0
    return-void
.end method
