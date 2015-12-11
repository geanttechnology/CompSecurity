.class public Lcom/amazon/sdk/availability/Evaluator;
.super Ljava/lang/Object;
.source "Evaluator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/sdk/availability/Evaluator$ParseException;,
        Lcom/amazon/sdk/availability/Evaluator$Not;,
        Lcom/amazon/sdk/availability/Evaluator$Eq;,
        Lcom/amazon/sdk/availability/Evaluator$Or;,
        Lcom/amazon/sdk/availability/Evaluator$And;,
        Lcom/amazon/sdk/availability/Evaluator$Operation;
    }
.end annotation


# instance fields
.field private final rules:Lorg/json/JSONObject;


# direct methods
.method public constructor <init>(Lorg/json/JSONObject;)V
    .locals 3
    .param p1, "rules"    # Lorg/json/JSONObject;

    .prologue
    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 93
    const/4 v1, 0x0

    .line 95
    .local v1, "r":Lorg/json/JSONObject;
    :try_start_0
    invoke-static {p1}, Lcom/amazon/sdk/availability/Evaluator;->cleanup(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 99
    :goto_0
    iput-object v1, p0, Lcom/amazon/sdk/availability/Evaluator;->rules:Lorg/json/JSONObject;

    .line 100
    return-void

    .line 96
    :catch_0
    move-exception v0

    .line 97
    .local v0, "ex":Lorg/json/JSONException;
    const-string/jumbo v2, "JSON error in rules"

    invoke-static {v2, v0}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method static cleanup(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "object"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 341
    instance-of v0, p0, Lorg/json/JSONObject;

    if-eqz v0, :cond_1

    .line 342
    check-cast p0, Lorg/json/JSONObject;

    .end local p0    # "object":Ljava/lang/Object;
    invoke-static {p0}, Lcom/amazon/sdk/availability/Evaluator;->cleanup(Lorg/json/JSONObject;)Lorg/json/JSONObject;

    move-result-object p0

    .line 349
    :cond_0
    :goto_0
    return-object p0

    .line 345
    .restart local p0    # "object":Ljava/lang/Object;
    :cond_1
    instance-of v0, p0, Lorg/json/JSONArray;

    if-eqz v0, :cond_0

    .line 346
    check-cast p0, Lorg/json/JSONArray;

    .end local p0    # "object":Ljava/lang/Object;
    invoke-static {p0}, Lcom/amazon/sdk/availability/Evaluator;->cleanup(Lorg/json/JSONArray;)Lorg/json/JSONArray;

    move-result-object p0

    goto :goto_0
.end method

.method static cleanup(Lorg/json/JSONArray;)Lorg/json/JSONArray;
    .locals 2
    .param p0, "input"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 327
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 328
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/sdk/availability/Evaluator;->cleanup(Ljava/lang/Object;)Ljava/lang/Object;

    .line 327
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 330
    :cond_0
    return-object p0
.end method

.method static cleanup(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    .locals 4
    .param p0, "input"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 299
    if-nez p0, :cond_1

    .line 316
    :cond_0
    return-object p0

    .line 302
    :cond_1
    const-string/jumbo v3, "__type"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 303
    invoke-virtual {p0}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v1

    .line 304
    .local v1, "ki":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 305
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 307
    .local v0, "key":Ljava/lang/String;
    const-string/jumbo v3, "eq"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 309
    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/Evaluator;->cleanup(Lorg/json/JSONArray;)Lorg/json/JSONArray;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/Evaluator;->fixupEq(Lorg/json/JSONArray;)Lorg/json/JSONArray;

    move-result-object v2

    .line 310
    .local v2, "val":Lorg/json/JSONArray;
    invoke-virtual {p0, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 314
    .end local v2    # "val":Lorg/json/JSONArray;
    :goto_1
    invoke-static {v2}, Lcom/amazon/sdk/availability/Evaluator;->cleanup(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 312
    :cond_2
    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .local v2, "val":Ljava/lang/Object;
    goto :goto_1
.end method

.method private evaluate(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z
    .locals 1
    .param p1, "currentRules"    # Lorg/json/JSONObject;
    .param p2, "data"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Lcom/amazon/sdk/availability/Evaluator$ParseException;
        }
    .end annotation

    .prologue
    .line 136
    invoke-static {p1, p2}, Lcom/amazon/sdk/availability/Evaluator$Operation;->fromJson(Lorg/json/JSONObject;Lorg/json/JSONObject;)Lcom/amazon/sdk/availability/Evaluator$Operation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/sdk/availability/Evaluator$Operation;->evaluate(Lorg/json/JSONObject;)Z

    move-result v0

    return v0
.end method

.method static fixupEq(Lorg/json/JSONArray;)Lorg/json/JSONArray;
    .locals 7
    .param p0, "input"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 361
    const/4 v5, 0x1

    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v6

    if-eq v5, v6, :cond_0

    .line 374
    .end local p0    # "input":Lorg/json/JSONArray;
    :goto_0
    return-object p0

    .line 365
    .restart local p0    # "input":Lorg/json/JSONArray;
    :cond_0
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    .line 366
    .local v4, "result":Lorg/json/JSONArray;
    const/4 v5, 0x0

    invoke-virtual {p0, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 367
    .local v0, "broken":Lorg/json/JSONObject;
    invoke-virtual {v0}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v2

    .line 368
    .local v2, "ki":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 369
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 370
    .local v3, "object":Lorg/json/JSONObject;
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 371
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v1, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 372
    invoke-virtual {v4, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_1

    .end local v1    # "key":Ljava/lang/String;
    .end local v3    # "object":Lorg/json/JSONObject;
    :cond_1
    move-object p0, v4

    .line 374
    goto :goto_0
.end method


# virtual methods
.method public evaluate(Lorg/json/JSONObject;)Z
    .locals 3
    .param p1, "data"    # Lorg/json/JSONObject;

    .prologue
    const/4 v1, 0x0

    .line 110
    :try_start_0
    iget-object v2, p0, Lcom/amazon/sdk/availability/Evaluator;->rules:Lorg/json/JSONObject;

    invoke-direct {p0, v2, p1}, Lcom/amazon/sdk/availability/Evaluator;->evaluate(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z
    :try_end_0
    .catch Lcom/amazon/sdk/availability/Evaluator$ParseException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v1

    .line 120
    :goto_0
    return v1

    .line 111
    :catch_0
    move-exception v0

    .line 112
    .local v0, "ex":Lcom/amazon/sdk/availability/Evaluator$ParseException;
    const-string/jumbo v2, "Syntax error in rules"

    invoke-static {v2, v0}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 116
    .end local v0    # "ex":Lcom/amazon/sdk/availability/Evaluator$ParseException;
    :catch_1
    move-exception v0

    .line 117
    .local v0, "ex":Lorg/json/JSONException;
    const-string/jumbo v2, "JSON error in rules"

    invoke-static {v2, v0}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
