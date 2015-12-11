.class public abstract Lcom/amazon/sdk/availability/Evaluator$Operation;
.super Ljava/lang/Object;
.source "Evaluator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/Evaluator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Operation"
.end annotation


# instance fields
.field protected final arguments:Lorg/json/JSONArray;

.field protected final data:Lorg/json/JSONObject;

.field private final opName:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Lorg/json/JSONArray;Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 0
    .param p1, "arguments"    # Lorg/json/JSONArray;
    .param p2, "opName"    # Ljava/lang/String;
    .param p3, "data"    # Lorg/json/JSONObject;

    .prologue
    .line 165
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 166
    iput-object p1, p0, Lcom/amazon/sdk/availability/Evaluator$Operation;->arguments:Lorg/json/JSONArray;

    .line 167
    iput-object p2, p0, Lcom/amazon/sdk/availability/Evaluator$Operation;->opName:Ljava/lang/String;

    .line 168
    iput-object p3, p0, Lcom/amazon/sdk/availability/Evaluator$Operation;->data:Lorg/json/JSONObject;

    .line 169
    return-void
.end method

.method public static fromJson(Lorg/json/JSONObject;Lorg/json/JSONObject;)Lcom/amazon/sdk/availability/Evaluator$Operation;
    .locals 5
    .param p0, "expression"    # Lorg/json/JSONObject;
    .param p1, "data"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Lcom/amazon/sdk/availability/Evaluator$ParseException;
        }
    .end annotation

    .prologue
    .line 269
    if-nez p0, :cond_0

    .line 270
    new-instance v3, Lorg/json/JSONException;

    const-string/jumbo v4, "expression may not be null"

    invoke-direct {v3, v4}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 273
    :cond_0
    invoke-virtual {p0}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v1

    .line 274
    .local v1, "ki":Ljava/util/Iterator;
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 275
    .local v2, "node":Ljava/lang/String;
    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 277
    .local v0, "arguments":Lorg/json/JSONArray;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Node is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 281
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 282
    new-instance v3, Lcom/amazon/sdk/availability/Evaluator$ParseException;

    const-string/jumbo v4, "Syntax error in rules, current level has more than one outer object."

    invoke-direct {v3, v4}, Lcom/amazon/sdk/availability/Evaluator$ParseException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 286
    :cond_1
    invoke-static {v2, v0, p1}, Lcom/amazon/sdk/availability/Evaluator$Operation;->fromKeywordAndArgs(Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONObject;)Lcom/amazon/sdk/availability/Evaluator$Operation;

    move-result-object v3

    return-object v3
.end method

.method public static fromKeywordAndArgs(Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONObject;)Lcom/amazon/sdk/availability/Evaluator$Operation;
    .locals 3
    .param p0, "keyword"    # Ljava/lang/String;
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "data"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/sdk/availability/Evaluator$ParseException;
        }
    .end annotation

    .prologue
    .line 240
    const-string/jumbo v0, "and"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 241
    new-instance v0, Lcom/amazon/sdk/availability/Evaluator$And;

    invoke-direct {v0, p1, p2}, Lcom/amazon/sdk/availability/Evaluator$And;-><init>(Lorg/json/JSONArray;Lorg/json/JSONObject;)V

    .line 250
    :goto_0
    return-object v0

    .line 243
    :cond_0
    const-string/jumbo v0, "or"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 244
    new-instance v0, Lcom/amazon/sdk/availability/Evaluator$Or;

    invoke-direct {v0, p1, p2}, Lcom/amazon/sdk/availability/Evaluator$Or;-><init>(Lorg/json/JSONArray;Lorg/json/JSONObject;)V

    goto :goto_0

    .line 246
    :cond_1
    const-string/jumbo v0, "not"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 247
    new-instance v0, Lcom/amazon/sdk/availability/Evaluator$Not;

    invoke-direct {v0, p1, p2}, Lcom/amazon/sdk/availability/Evaluator$Not;-><init>(Lorg/json/JSONArray;Lorg/json/JSONObject;)V

    goto :goto_0

    .line 249
    :cond_2
    const-string/jumbo v0, "eq"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 250
    new-instance v0, Lcom/amazon/sdk/availability/Evaluator$Eq;

    invoke-direct {v0, p1, p2}, Lcom/amazon/sdk/availability/Evaluator$Eq;-><init>(Lorg/json/JSONArray;Lorg/json/JSONObject;)V

    goto :goto_0

    .line 253
    :cond_3
    new-instance v0, Lcom/amazon/sdk/availability/Evaluator$ParseException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Unknown keyword "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " detected."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/sdk/availability/Evaluator$ParseException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method abstract checkArguments()Z
.end method

.method evaluate(Lorg/json/JSONObject;)Z
    .locals 2
    .param p1, "expression"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Lcom/amazon/sdk/availability/Evaluator$ParseException;
        }
    .end annotation

    .prologue
    .line 180
    iget-object v1, p0, Lcom/amazon/sdk/availability/Evaluator$Operation;->data:Lorg/json/JSONObject;

    invoke-static {p1, v1}, Lcom/amazon/sdk/availability/Evaluator$Operation;->fromJson(Lorg/json/JSONObject;Lorg/json/JSONObject;)Lcom/amazon/sdk/availability/Evaluator$Operation;

    move-result-object v0

    .line 181
    .local v0, "op":Lcom/amazon/sdk/availability/Evaluator$Operation;
    invoke-virtual {v0}, Lcom/amazon/sdk/availability/Evaluator$Operation;->evaluateOp()Z

    move-result v1

    return v1
.end method

.method abstract evaluateImpl()Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Lcom/amazon/sdk/availability/Evaluator$ParseException;
        }
    .end annotation
.end method

.method evaluateOp()Z
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/sdk/availability/Evaluator$ParseException;
        }
    .end annotation

    .prologue
    .line 191
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/Evaluator$Operation;->checkArguments()Z

    move-result v4

    if-nez v4, :cond_0

    .line 192
    new-instance v4, Lcom/amazon/sdk/availability/Evaluator$ParseException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Incorrect number of arguments for "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/sdk/availability/Evaluator$Operation;->opName:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/sdk/availability/Evaluator$Operation;->arguments:Lorg/json/JSONArray;

    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/sdk/availability/Evaluator$ParseException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 197
    :cond_0
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/Evaluator$Operation;->evaluateImpl()Z

    move-result v2

    .line 198
    .local v2, "result":Z
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 199
    .local v3, "sb":Ljava/lang/StringBuilder;
    const-string/jumbo v4, "operation "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/sdk/availability/Evaluator$Operation;->opName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " with arguments "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 200
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v4, p0, Lcom/amazon/sdk/availability/Evaluator$Operation;->arguments:Lorg/json/JSONArray;

    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v1, v4, :cond_1

    .line 201
    iget-object v4, p0, Lcom/amazon/sdk/availability/Evaluator$Operation;->arguments:Lorg/json/JSONArray;

    invoke-virtual {v4, v1}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ", "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 200
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 203
    :cond_1
    const-string/jumbo v4, " returning "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 204
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 205
    return v2

    .line 206
    .end local v1    # "i":I
    .end local v2    # "result":Z
    .end local v3    # "sb":Ljava/lang/StringBuilder;
    :catch_0
    move-exception v0

    .line 207
    .local v0, "ex":Lorg/json/JSONException;
    new-instance v4, Lcom/amazon/sdk/availability/Evaluator$ParseException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Could not get value for "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/sdk/availability/Evaluator$Operation;->opName:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " while evaluating."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5, v0}, Lcom/amazon/sdk/availability/Evaluator$ParseException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4
.end method
