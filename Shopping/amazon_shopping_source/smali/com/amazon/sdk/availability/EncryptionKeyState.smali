.class public Lcom/amazon/sdk/availability/EncryptionKeyState;
.super Ljava/lang/Object;
.source "EncryptionKeyState.java"


# instance fields
.field private final keySpecs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/sdk/availability/KeySpec;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    .line 23
    return-void
.end method

.method public constructor <init>(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/sdk/availability/KeySpec;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 29
    .local p1, "keySpecs":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/sdk/availability/KeySpec;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    .line 31
    return-void
.end method

.method public static fromJSON(Lorg/json/JSONObject;)Lcom/amazon/sdk/availability/EncryptionKeyState;
    .locals 6
    .param p0, "jobj"    # Lorg/json/JSONObject;

    .prologue
    .line 140
    if-nez p0, :cond_0

    .line 141
    const/4 v5, 0x0

    .line 157
    :goto_0
    return-object v5

    .line 144
    :cond_0
    new-instance v4, Ljava/util/LinkedList;

    invoke-direct {v4}, Ljava/util/LinkedList;-><init>()V

    .line 145
    .local v4, "keySpecs":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/sdk/availability/KeySpec;>;"
    const-string/jumbo v5, "keySpecs"

    invoke-virtual {p0, v5}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 146
    .local v2, "jarray":Lorg/json/JSONArray;
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-lez v5, :cond_2

    .line 147
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-ge v0, v5, :cond_2

    .line 148
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 149
    .local v1, "jKeySpec":Lorg/json/JSONObject;
    invoke-static {v1}, Lcom/amazon/sdk/availability/KeySpec;->fromJSON(Lorg/json/JSONObject;)Lcom/amazon/sdk/availability/KeySpec;

    move-result-object v3

    .line 150
    .local v3, "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    if-eqz v3, :cond_1

    .line 151
    invoke-interface {v4, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 147
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 157
    .end local v0    # "i":I
    .end local v1    # "jKeySpec":Lorg/json/JSONObject;
    .end local v3    # "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    :cond_2
    new-instance v5, Lcom/amazon/sdk/availability/EncryptionKeyState;

    invoke-direct {v5, v4}, Lcom/amazon/sdk/availability/EncryptionKeyState;-><init>(Ljava/util/List;)V

    goto :goto_0
.end method


# virtual methods
.method public addKeySpec(Lcom/amazon/sdk/availability/KeySpec;)V
    .locals 5
    .param p1, "keySpec"    # Lcom/amazon/sdk/availability/KeySpec;

    .prologue
    .line 48
    if-eqz p1, :cond_1

    .line 49
    const-wide/16 v3, 0x0

    invoke-virtual {p0, v3, v4}, Lcom/amazon/sdk/availability/EncryptionKeyState;->getApplicableKeySpec(J)Lcom/amazon/sdk/availability/KeySpec;

    move-result-object v2

    .line 50
    .local v2, "previousValidAsOf":Lcom/amazon/sdk/availability/KeySpec;
    const-wide/16 v0, 0x0

    .line 51
    .local v0, "nextValidAsOf":J
    if-eqz v2, :cond_0

    .line 53
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 56
    :cond_0
    invoke-virtual {p1, v0, v1}, Lcom/amazon/sdk/availability/KeySpec;->setValidAsOf(J)V

    .line 58
    iget-object v3, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 60
    .end local v0    # "nextValidAsOf":J
    .end local v2    # "previousValidAsOf":Lcom/amazon/sdk/availability/KeySpec;
    :cond_1
    return-void
.end method

.method public clearKeySpecsBefore(J)V
    .locals 8
    .param p1, "timeStamp"    # J

    .prologue
    .line 68
    invoke-virtual {p0, p1, p2}, Lcom/amazon/sdk/availability/EncryptionKeyState;->getApplicableKeySpec(J)Lcom/amazon/sdk/availability/KeySpec;

    move-result-object v0

    .line 70
    .local v0, "applicableKeySpec":Lcom/amazon/sdk/availability/KeySpec;
    if-eqz v0, :cond_2

    .line 71
    new-instance v3, Ljava/util/LinkedList;

    invoke-direct {v3}, Ljava/util/LinkedList;-><init>()V

    .line 72
    .local v3, "keySpecsToRemove":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/sdk/availability/KeySpec;>;"
    iget-object v4, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/sdk/availability/KeySpec;

    .line 73
    .local v2, "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    invoke-virtual {v0, v2}, Lcom/amazon/sdk/availability/KeySpec;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-virtual {v2}, Lcom/amazon/sdk/availability/KeySpec;->getValidAsOf()J

    move-result-wide v4

    invoke-virtual {v0}, Lcom/amazon/sdk/availability/KeySpec;->getValidAsOf()J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-gtz v4, :cond_0

    .line 74
    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 77
    .end local v2    # "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    :cond_1
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_2

    .line 78
    iget-object v4, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    invoke-interface {v4, v3}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 81
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "keySpecsToRemove":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/sdk/availability/KeySpec;>;"
    :cond_2
    return-void
.end method

.method public getApplicableKeySpec(J)Lcom/amazon/sdk/availability/KeySpec;
    .locals 5
    .param p1, "timeStamp"    # J

    .prologue
    .line 97
    iget-object v3, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 98
    :cond_0
    const/4 v2, 0x0

    .line 108
    :cond_1
    return-object v2

    .line 101
    :cond_2
    const/4 v2, 0x0

    .line 102
    .local v2, "validKeySpec":Lcom/amazon/sdk/availability/KeySpec;
    iget-object v3, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/sdk/availability/KeySpec;

    .line 103
    .local v1, "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    invoke-virtual {v1}, Lcom/amazon/sdk/availability/KeySpec;->getValidAsOf()J

    move-result-wide v3

    cmp-long v3, p1, v3

    if-ltz v3, :cond_3

    .line 104
    move-object v2, v1

    goto :goto_0
.end method

.method public getState()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/sdk/availability/KeySpec;",
            ">;"
        }
    .end annotation

    .prologue
    .line 39
    new-instance v0, Ljava/util/LinkedList;

    iget-object v1, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/LinkedList;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method

.method public toJSON()Lorg/json/JSONObject;
    .locals 6

    .prologue
    .line 117
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 118
    .local v3, "jobj":Lorg/json/JSONObject;
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 119
    .local v2, "jarray":Lorg/json/JSONArray;
    iget-object v5, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    .line 120
    iget-object v5, p0, Lcom/amazon/sdk/availability/EncryptionKeyState;->keySpecs:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/sdk/availability/KeySpec;

    .line 121
    .local v4, "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    invoke-virtual {v4}, Lcom/amazon/sdk/availability/KeySpec;->toJSON()Lorg/json/JSONObject;

    move-result-object v5

    invoke-virtual {v2, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 126
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "jarray":Lorg/json/JSONArray;
    .end local v3    # "jobj":Lorg/json/JSONObject;
    .end local v4    # "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    :catch_0
    move-exception v0

    .line 127
    .local v0, "e":Lorg/json/JSONException;
    const-string/jumbo v5, "error jsonifying encryption key state"

    invoke-static {v5, v0}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 129
    const/4 v3, 0x0

    .end local v0    # "e":Lorg/json/JSONException;
    :goto_1
    return-object v3

    .line 124
    .restart local v2    # "jarray":Lorg/json/JSONArray;
    .restart local v3    # "jobj":Lorg/json/JSONObject;
    :cond_0
    :try_start_1
    const-string/jumbo v5, "keySpecs"

    invoke-virtual {v3, v5, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method
