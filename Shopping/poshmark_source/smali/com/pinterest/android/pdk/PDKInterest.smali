.class public Lcom/pinterest/android/pdk/PDKInterest;
.super Lcom/pinterest/android/pdk/PDKModel;
.source "PDKInterest.java"


# instance fields
.field private name:Ljava/lang/String;

.field private uid:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/pinterest/android/pdk/PDKModel;-><init>()V

    return-void
.end method

.method public static makeInterest(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKInterest;
    .locals 8
    .param p0, "obj"    # Ljava/lang/Object;

    .prologue
    .line 38
    new-instance v3, Lcom/pinterest/android/pdk/PDKInterest;

    invoke-direct {v3}, Lcom/pinterest/android/pdk/PDKInterest;-><init>()V

    .line 40
    .local v3, "interest":Lcom/pinterest/android/pdk/PDKInterest;
    :try_start_0
    instance-of v4, p0, Lorg/json/JSONObject;

    if-eqz v4, :cond_1

    .line 41
    move-object v0, p0

    check-cast v0, Lorg/json/JSONObject;

    move-object v1, v0

    .line 42
    .local v1, "dataObj":Lorg/json/JSONObject;
    const-string v4, "id"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 43
    const-string v4, "id"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/pinterest/android/pdk/PDKInterest;->setUid(Ljava/lang/String;)V

    .line 45
    :cond_0
    const-string v4, "name"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 46
    const-string v4, "name"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/pinterest/android/pdk/PDKInterest;->setName(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 52
    .end local v1    # "dataObj":Lorg/json/JSONObject;
    :cond_1
    :goto_0
    return-object v3

    .line 49
    :catch_0
    move-exception v2

    .line 50
    .local v2, "e":Lorg/json/JSONException;
    const-string v4, "PDK: PDKInterest parse JSON error %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v2}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static makeInterestList(Ljava/lang/Object;)Ljava/util/List;
    .locals 11
    .param p0, "obj"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/pinterest/android/pdk/PDKInterest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 56
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 58
    .local v4, "interestList":Ljava/util/List;, "Ljava/util/List<Lcom/pinterest/android/pdk/PDKInterest;>;"
    :try_start_0
    instance-of v7, p0, Lorg/json/JSONArray;

    if-eqz v7, :cond_0

    .line 60
    move-object v0, p0

    check-cast v0, Lorg/json/JSONArray;

    move-object v5, v0

    .line 61
    .local v5, "jAarray":Lorg/json/JSONArray;
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v6

    .line 62
    .local v6, "size":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v6, :cond_0

    .line 63
    invoke-virtual {v5, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 64
    .local v1, "dataObj":Lorg/json/JSONObject;
    invoke-static {v1}, Lcom/pinterest/android/pdk/PDKInterest;->makeInterest(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKInterest;

    move-result-object v7

    invoke-interface {v4, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 62
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 67
    .end local v1    # "dataObj":Lorg/json/JSONObject;
    .end local v3    # "i":I
    .end local v5    # "jAarray":Lorg/json/JSONArray;
    .end local v6    # "size":I
    :catch_0
    move-exception v2

    .line 68
    .local v2, "e":Lorg/json/JSONException;
    const-string v7, "PDK: PDKInterst parse JSON error %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v2}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 70
    .end local v2    # "e":Lorg/json/JSONException;
    :cond_0
    return-object v4
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKInterest;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getUid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKInterest;->uid:Ljava/lang/String;

    return-object v0
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKInterest;->name:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public setUid(Ljava/lang/String;)V
    .locals 0
    .param p1, "uid"    # Ljava/lang/String;

    .prologue
    .line 21
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKInterest;->uid:Ljava/lang/String;

    .line 22
    return-void
.end method
