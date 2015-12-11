.class public Lcom/amazon/sdk/availability/KeySpec;
.super Ljava/lang/Object;
.source "KeySpec.java"


# instance fields
.field private final encryptionAlgorithm:Ljava/lang/String;

.field private final key:Ljava/lang/String;

.field private validAsOf:J


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;J)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "encryptionAlgorithm"    # Ljava/lang/String;
    .param p3, "validAsOf"    # J

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p1, p0, Lcom/amazon/sdk/availability/KeySpec;->key:Ljava/lang/String;

    .line 38
    iput-object p2, p0, Lcom/amazon/sdk/availability/KeySpec;->encryptionAlgorithm:Ljava/lang/String;

    .line 39
    iput-wide p3, p0, Lcom/amazon/sdk/availability/KeySpec;->validAsOf:J

    .line 40
    return-void
.end method

.method public static fromJSON(Lorg/json/JSONObject;)Lcom/amazon/sdk/availability/KeySpec;
    .locals 5
    .param p0, "jobj"    # Lorg/json/JSONObject;

    .prologue
    .line 142
    if-nez p0, :cond_0

    .line 143
    const/4 v4, 0x0

    .line 150
    :goto_0
    return-object v4

    .line 146
    :cond_0
    const-string/jumbo v4, "key"

    invoke-virtual {p0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 147
    .local v1, "key":Ljava/lang/String;
    const-string/jumbo v4, "encryptionAlgorithm"

    invoke-virtual {p0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 148
    .local v0, "encryptionAlgorithm":Ljava/lang/String;
    const-string/jumbo v4, "validAsOf"

    invoke-virtual {p0, v4}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v2

    .line 150
    .local v2, "validAsOf":J
    new-instance v4, Lcom/amazon/sdk/availability/KeySpec;

    invoke-direct {v4, v1, v0, v2, v3}, Lcom/amazon/sdk/availability/KeySpec;-><init>(Ljava/lang/String;Ljava/lang/String;J)V

    goto :goto_0
.end method

.method private getHashCode(Ljava/lang/Object;)I
    .locals 2
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 125
    if-nez p1, :cond_0

    .line 126
    const/4 v0, 0x0

    .line 131
    .local v0, "result":I
    :goto_0
    return v0

    .line 128
    .end local v0    # "result":I
    :cond_0
    iget-object v1, p0, Lcom/amazon/sdk/availability/KeySpec;->key:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v0

    .restart local v0    # "result":I
    goto :goto_0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v5, 0x0

    .line 74
    if-eqz p1, :cond_0

    instance-of v6, p1, Lcom/amazon/sdk/availability/KeySpec;

    if-nez v6, :cond_1

    .line 97
    :cond_0
    :goto_0
    return v5

    :cond_1
    move-object v2, p1

    .line 78
    check-cast v2, Lcom/amazon/sdk/availability/KeySpec;

    .line 80
    .local v2, "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/KeySpec;->getKey()Ljava/lang/String;

    move-result-object v4

    .line 82
    .local v4, "theKey":Ljava/lang/String;
    if-eqz v4, :cond_2

    .line 83
    invoke-virtual {v2}, Lcom/amazon/sdk/availability/KeySpec;->getKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    .line 88
    .local v1, "isKeySame":Z
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/KeySpec;->getEncryptionAlgorithm()Ljava/lang/String;

    move-result-object v3

    .line 90
    .local v3, "theEncryptionAlgorithm":Ljava/lang/String;
    iget-object v6, p0, Lcom/amazon/sdk/availability/KeySpec;->encryptionAlgorithm:Ljava/lang/String;

    if-eqz v6, :cond_3

    .line 91
    invoke-virtual {v2}, Lcom/amazon/sdk/availability/KeySpec;->getEncryptionAlgorithm()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 97
    .local v0, "isEncryptionAlgorithmSame":Z
    :goto_2
    if-eqz v1, :cond_0

    if-eqz v0, :cond_0

    const/4 v5, 0x1

    goto :goto_0

    .line 85
    .end local v0    # "isEncryptionAlgorithmSame":Z
    .end local v1    # "isKeySame":Z
    .end local v3    # "theEncryptionAlgorithm":Ljava/lang/String;
    :cond_2
    const/4 v1, 0x0

    .restart local v1    # "isKeySame":Z
    goto :goto_1

    .line 93
    .restart local v3    # "theEncryptionAlgorithm":Ljava/lang/String;
    :cond_3
    const/4 v0, 0x0

    .restart local v0    # "isEncryptionAlgorithmSame":Z
    goto :goto_2
.end method

.method public getEncryptionAlgorithm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/sdk/availability/KeySpec;->encryptionAlgorithm:Ljava/lang/String;

    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/sdk/availability/KeySpec;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getValidAsOf()J
    .locals 2

    .prologue
    .line 60
    iget-wide v0, p0, Lcom/amazon/sdk/availability/KeySpec;->validAsOf:J

    return-wide v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 110
    const/16 v0, 0x2a

    .line 112
    .local v0, "result":I
    iget-object v1, p0, Lcom/amazon/sdk/availability/KeySpec;->key:Ljava/lang/String;

    invoke-direct {p0, v1}, Lcom/amazon/sdk/availability/KeySpec;->getHashCode(Ljava/lang/Object;)I

    move-result v1

    add-int/lit16 v0, v1, 0x612

    .line 113
    mul-int/lit8 v1, v0, 0x25

    iget-object v2, p0, Lcom/amazon/sdk/availability/KeySpec;->encryptionAlgorithm:Ljava/lang/String;

    invoke-direct {p0, v2}, Lcom/amazon/sdk/availability/KeySpec;->getHashCode(Ljava/lang/Object;)I

    move-result v2

    add-int v0, v1, v2

    .line 114
    return v0
.end method

.method public setValidAsOf(J)V
    .locals 0
    .param p1, "validAsOf"    # J

    .prologue
    .line 69
    iput-wide p1, p0, Lcom/amazon/sdk/availability/KeySpec;->validAsOf:J

    .line 70
    return-void
.end method

.method public toJSON()Lorg/json/JSONObject;
    .locals 6

    .prologue
    .line 159
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 160
    .local v1, "jobj":Lorg/json/JSONObject;
    const-string/jumbo v2, "key"

    iget-object v3, p0, Lcom/amazon/sdk/availability/KeySpec;->key:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v2

    const-string/jumbo v3, "encryptionAlgorithm"

    iget-object v4, p0, Lcom/amazon/sdk/availability/KeySpec;->encryptionAlgorithm:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v2

    const-string/jumbo v3, "validAsOf"

    iget-wide v4, p0, Lcom/amazon/sdk/availability/KeySpec;->validAsOf:J

    invoke-virtual {v2, v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 163
    .end local v1    # "jobj":Lorg/json/JSONObject;
    :goto_0
    return-object v1

    .line 162
    :catch_0
    move-exception v0

    .line 163
    .local v0, "e":Lorg/json/JSONException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 169
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/KeySpec;->toJSON()Lorg/json/JSONObject;

    move-result-object v0

    .line 170
    .local v0, "jobj":Lorg/json/JSONObject;
    if-eqz v0, :cond_0

    .line 171
    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    .line 174
    :goto_0
    return-object v1

    :cond_0
    const-string/jumbo v1, ""

    goto :goto_0
.end method
