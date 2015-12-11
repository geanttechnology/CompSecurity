.class public Lcom/amazon/sdk/availability/Evaluator$Eq;
.super Lcom/amazon/sdk/availability/Evaluator$Operation;
.source "Evaluator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/Evaluator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Eq"
.end annotation


# direct methods
.method constructor <init>(Lorg/json/JSONArray;Lorg/json/JSONObject;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "data"    # Lorg/json/JSONObject;

    .prologue
    .line 459
    const-string/jumbo v0, "eq"

    invoke-direct {p0, p1, v0, p2}, Lcom/amazon/sdk/availability/Evaluator$Operation;-><init>(Lorg/json/JSONArray;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 460
    return-void
.end method

.method private evaluateValue(Lorg/json/JSONObject;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 7
    .param p1, "currentRules"    # Lorg/json/JSONObject;
    .param p2, "data"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/sdk/availability/Evaluator$ParseException;
        }
    .end annotation

    .prologue
    .line 471
    invoke-virtual {p1}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v1

    .line 472
    .local v1, "ki":Ljava/util/Iterator;
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 473
    .local v2, "node":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Value Node is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 474
    const-string/jumbo v4, "fetchKey"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    const-string/jumbo v4, "metadataKey"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 475
    :cond_0
    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 476
    .local v0, "key":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 477
    new-instance v4, Lcom/amazon/sdk/availability/Evaluator$ParseException;

    const-string/jumbo v5, "Syntax error, empty keyname for fetchKey"

    invoke-direct {v4, v5}, Lcom/amazon/sdk/availability/Evaluator$ParseException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 479
    :cond_1
    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 480
    .local v3, "result":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Value Operation fetchKey returning "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 487
    .end local v0    # "key":Ljava/lang/String;
    :goto_0
    return-object v3

    .line 484
    .end local v3    # "result":Ljava/lang/String;
    :cond_2
    const-string/jumbo v4, "constant"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 485
    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 486
    .restart local v3    # "result":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Value Operation constant returning "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    goto :goto_0

    .line 490
    .end local v3    # "result":Ljava/lang/String;
    :cond_3
    new-instance v4, Lcom/amazon/sdk/availability/Evaluator$ParseException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Syntax error, unknown value statement "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/sdk/availability/Evaluator$ParseException;-><init>(Ljava/lang/String;)V

    throw v4
.end method


# virtual methods
.method checkArguments()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 510
    iget-object v1, p0, Lcom/amazon/sdk/availability/Evaluator$Eq;->arguments:Lorg/json/JSONArray;

    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method evaluateImpl()Z
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Lcom/amazon/sdk/availability/Evaluator$ParseException;
        }
    .end annotation

    .prologue
    .line 495
    const/4 v2, 0x1

    .line 496
    .local v2, "result":Z
    iget-object v4, p0, Lcom/amazon/sdk/availability/Evaluator$Eq;->arguments:Lorg/json/JSONArray;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/sdk/availability/Evaluator$Eq;->data:Lorg/json/JSONObject;

    invoke-direct {p0, v4, v5}, Lcom/amazon/sdk/availability/Evaluator$Eq;->evaluateValue(Lorg/json/JSONObject;Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v3

    .line 497
    .local v3, "valZero":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/sdk/availability/Evaluator$Eq;->arguments:Lorg/json/JSONArray;

    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v0

    .line 498
    .local v0, "count":I
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 499
    iget-object v4, p0, Lcom/amazon/sdk/availability/Evaluator$Eq;->arguments:Lorg/json/JSONArray;

    invoke-virtual {v4, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/sdk/availability/Evaluator$Eq;->data:Lorg/json/JSONObject;

    invoke-direct {p0, v4, v5}, Lcom/amazon/sdk/availability/Evaluator$Eq;->evaluateValue(Lorg/json/JSONObject;Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    and-int/2addr v2, v4

    .line 500
    if-nez v2, :cond_1

    .line 505
    :cond_0
    return v2

    .line 498
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method
