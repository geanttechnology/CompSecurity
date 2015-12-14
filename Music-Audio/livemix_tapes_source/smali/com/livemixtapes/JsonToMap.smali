.class public Lcom/livemixtapes/JsonToMap;
.super Ljava/lang/Object;
.source "JsonToMap.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static convert(Lorg/json/JSONObject;)Ljava/util/HashMap;
    .locals 2
    .param p0, "json"    # Lorg/json/JSONObject;

    .prologue
    .line 14
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 16
    .local v0, "retMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-object v1, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    if-eq p0, v1, :cond_0

    .line 18
    :try_start_0
    invoke-static {p0}, Lcom/livemixtapes/JsonToMap;->toMap(Lorg/json/JSONObject;)Ljava/util/HashMap;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 24
    :goto_0
    return-object v0

    .line 21
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 19
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static toList(Lorg/json/JSONArray;)Ljava/util/List;
    .locals 4
    .param p0, "array"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 53
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 54
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-lt v0, v3, :cond_0

    .line 71
    return-object v1

    .line 55
    :cond_0
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    .line 57
    .local v2, "value":Ljava/lang/Object;
    sget-object v3, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 58
    const/4 v2, 0x0

    .line 69
    .end local v2    # "value":Ljava/lang/Object;
    :cond_1
    :goto_1
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 54
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 61
    .restart local v2    # "value":Ljava/lang/Object;
    :cond_2
    instance-of v3, v2, Lorg/json/JSONArray;

    if-eqz v3, :cond_3

    .line 62
    check-cast v2, Lorg/json/JSONArray;

    .end local v2    # "value":Ljava/lang/Object;
    invoke-static {v2}, Lcom/livemixtapes/JsonToMap;->toList(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v2

    .line 63
    .local v2, "value":Ljava/util/List;
    goto :goto_1

    .line 65
    .local v2, "value":Ljava/lang/Object;
    :cond_3
    instance-of v3, v2, Lorg/json/JSONObject;

    if-eqz v3, :cond_1

    .line 66
    check-cast v2, Lorg/json/JSONObject;

    .end local v2    # "value":Ljava/lang/Object;
    invoke-static {v2}, Lcom/livemixtapes/JsonToMap;->toMap(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v2

    .local v2, "value":Ljava/util/HashMap;
    goto :goto_1
.end method

.method private static toMap(Lorg/json/JSONObject;)Ljava/util/HashMap;
    .locals 5
    .param p0, "object"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 28
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 30
    .local v2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {p0}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v1

    .line 31
    .local v1, "keysItr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_0

    .line 49
    return-object v2

    .line 32
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 33
    .local v0, "key":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    .line 35
    .local v3, "value":Ljava/lang/Object;
    sget-object v4, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 36
    const/4 v3, 0x0

    .line 47
    .end local v3    # "value":Ljava/lang/Object;
    :cond_1
    :goto_1
    invoke-virtual {v2, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 39
    .restart local v3    # "value":Ljava/lang/Object;
    :cond_2
    instance-of v4, v3, Lorg/json/JSONArray;

    if-eqz v4, :cond_3

    .line 40
    check-cast v3, Lorg/json/JSONArray;

    .end local v3    # "value":Ljava/lang/Object;
    invoke-static {v3}, Lcom/livemixtapes/JsonToMap;->toList(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v3

    .line 41
    .local v3, "value":Ljava/util/List;
    goto :goto_1

    .line 43
    .local v3, "value":Ljava/lang/Object;
    :cond_3
    instance-of v4, v3, Lorg/json/JSONObject;

    if-eqz v4, :cond_1

    .line 44
    check-cast v3, Lorg/json/JSONObject;

    .end local v3    # "value":Ljava/lang/Object;
    invoke-static {v3}, Lcom/livemixtapes/JsonToMap;->toMap(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v3

    .local v3, "value":Ljava/util/HashMap;
    goto :goto_1
.end method
