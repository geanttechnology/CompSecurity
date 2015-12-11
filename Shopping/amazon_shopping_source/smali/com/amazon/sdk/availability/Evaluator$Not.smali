.class public Lcom/amazon/sdk/availability/Evaluator$Not;
.super Lcom/amazon/sdk/availability/Evaluator$Operation;
.source "Evaluator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/Evaluator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Not"
.end annotation


# direct methods
.method constructor <init>(Lorg/json/JSONArray;Lorg/json/JSONObject;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "data"    # Lorg/json/JSONObject;

    .prologue
    .line 524
    const-string/jumbo v0, "not"

    invoke-direct {p0, p1, v0, p2}, Lcom/amazon/sdk/availability/Evaluator$Operation;-><init>(Lorg/json/JSONArray;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 525
    return-void
.end method


# virtual methods
.method checkArguments()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 534
    iget-object v1, p0, Lcom/amazon/sdk/availability/Evaluator$Not;->arguments:Lorg/json/JSONArray;

    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ne v0, v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method evaluateImpl()Z
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;,
            Lcom/amazon/sdk/availability/Evaluator$ParseException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 529
    iget-object v1, p0, Lcom/amazon/sdk/availability/Evaluator$Not;->arguments:Lorg/json/JSONArray;

    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/sdk/availability/Evaluator$Not;->evaluate(Lorg/json/JSONObject;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    return v0
.end method
