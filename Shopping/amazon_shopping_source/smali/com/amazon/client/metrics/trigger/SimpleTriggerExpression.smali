.class Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression;
.super Ljava/lang/Object;
.source "SimpleTriggerExpression.java"

# interfaces
.implements Lcom/amazon/client/metrics/trigger/TriggerExpression;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$1;,
        Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;
    }
.end annotation


# instance fields
.field private final mTriggerOperator:Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;

.field private final mTriggerThreshold:D


# direct methods
.method constructor <init>(Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;D)V
    .locals 0
    .param p1, "triggerOperator"    # Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;
    .param p2, "triggerThreshold"    # D

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression;->mTriggerOperator:Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;

    .line 50
    iput-wide p2, p0, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression;->mTriggerThreshold:D

    .line 51
    return-void
.end method


# virtual methods
.method public evaluate(D)Z
    .locals 4
    .param p1, "value"    # D

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 68
    sget-object v2, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$1;->$SwitchMap$com$amazon$client$metrics$trigger$SimpleTriggerExpression$TriggerOperator:[I

    iget-object v3, p0, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression;->mTriggerOperator:Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;

    invoke-virtual {v3}, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    move v0, v1

    .line 76
    :cond_0
    :goto_0
    return v0

    .line 70
    :pswitch_0
    iget-wide v2, p0, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression;->mTriggerThreshold:D

    cmpl-double v2, p1, v2

    if-gtz v2, :cond_0

    move v0, v1

    goto :goto_0

    .line 72
    :pswitch_1
    iget-wide v2, p0, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression;->mTriggerThreshold:D

    cmpg-double v2, p1, v2

    if-ltz v2, :cond_0

    move v0, v1

    goto :goto_0

    .line 74
    :pswitch_2
    iget-wide v2, p0, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression;->mTriggerThreshold:D

    cmpl-double v2, p1, v2

    if-eqz v2, :cond_0

    move v0, v1

    goto :goto_0

    .line 68
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method getOperator()Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression;->mTriggerOperator:Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator;

    return-object v0
.end method

.method getThreshold()D
    .locals 2

    .prologue
    .line 58
    iget-wide v0, p0, Lcom/amazon/client/metrics/trigger/SimpleTriggerExpression;->mTriggerThreshold:D

    return-wide v0
.end method
