.class public Lcom/amazon/client/metrics/trigger/TriggerExpressionCodec;
.super Ljava/lang/Object;
.source "TriggerExpressionCodec.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "TriggerExpressionCodec"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public deserializeTriggerExpression(Ljava/lang/String;)Lcom/amazon/client/metrics/trigger/TriggerExpression;
    .locals 12
    .param p1, "serializedTriggerExpression"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x0

    .line 26
    if-nez p1, :cond_0

    .line 27
    const-string/jumbo v9, "TriggerExpressionCodec"

    const-string/jumbo v10, "SerializeTriggerExpression was null. "

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 59
    :goto_0
    return-object v8

    .line 35
    :cond_0
    const-string/jumbo v9, " "

    invoke-virtual {p1, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 37
    .local v5, "operatorAndValue":[Ljava/lang/String;
    array-length v9, v5

    const/4 v10, 0x2

    if-eq v9, v10, :cond_1

    .line 38
    const-string/jumbo v9, "TriggerExpressionCodec"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "Trigger expression is not properly formatted: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 42
    :cond_1
    const/4 v9, 0x0

    aget-object v4, v5, v9

    .line 43
    .local v4, "operator":Ljava/lang/String;
    const/4 v9, 0x1

    aget-object v6, v5, v9

    .line 47
    .local v6, "threshold":Ljava/lang/String;
    :try_start_0
    invoke-static {v4}, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;->fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;

    move-result-object v7

    .line 51
    .local v7, "triggerOperator":Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;
    invoke-static {v6}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v2

    .line 53
    .local v2, "numericThreshold":D
    new-instance v9, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression;

    invoke-direct {v9, v7, v2, v3}, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression;-><init>(Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;D)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    move-object v8, v9

    goto :goto_0

    .line 54
    .end local v2    # "numericThreshold":D
    .end local v7    # "triggerOperator":Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;
    :catch_0
    move-exception v1

    .line 55
    .local v1, "nfe":Ljava/lang/NumberFormatException;
    const-string/jumbo v9, "TriggerExpressionCodec"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "Trigger expression has a malformed threshold value: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 57
    .end local v1    # "nfe":Ljava/lang/NumberFormatException;
    :catch_1
    move-exception v0

    .line 58
    .local v0, "iae":Ljava/lang/IllegalArgumentException;
    const-string/jumbo v9, "TriggerExpressionCodec"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "Trigger expression has a malformed operator value: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
