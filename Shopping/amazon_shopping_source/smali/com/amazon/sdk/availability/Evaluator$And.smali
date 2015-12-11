.class public Lcom/amazon/sdk/availability/Evaluator$And;
.super Lcom/amazon/sdk/availability/Evaluator$Operation;
.source "Evaluator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/Evaluator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "And"
.end annotation


# direct methods
.method constructor <init>(Lorg/json/JSONArray;Lorg/json/JSONObject;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "data"    # Lorg/json/JSONObject;

    .prologue
    .line 387
    const-string/jumbo v0, "and"

    invoke-direct {p0, p1, v0, p2}, Lcom/amazon/sdk/availability/Evaluator$Operation;-><init>(Lorg/json/JSONArray;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 388
    return-void
.end method


# virtual methods
.method checkArguments()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 409
    iget-object v1, p0, Lcom/amazon/sdk/availability/Evaluator$And;->arguments:Lorg/json/JSONArray;

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
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Lcom/amazon/sdk/availability/Evaluator$ParseException;
        }
    .end annotation

    .prologue
    .line 393
    const/4 v2, 0x1

    .line 394
    .local v2, "result":Z
    iget-object v3, p0, Lcom/amazon/sdk/availability/Evaluator$And;->arguments:Lorg/json/JSONArray;

    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v0

    .line 395
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 396
    iget-object v3, p0, Lcom/amazon/sdk/availability/Evaluator$And;->arguments:Lorg/json/JSONArray;

    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/amazon/sdk/availability/Evaluator$And;->evaluate(Lorg/json/JSONObject;)Z

    move-result v3

    and-int/2addr v2, v3

    .line 398
    if-nez v2, :cond_1

    .line 403
    :cond_0
    return v2

    .line 395
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method
