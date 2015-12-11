.class Lcom/amazon/analytics/session/SessionState$MaybeEndSessionState;
.super Lcom/amazon/analytics/session/SessionState;
.source "SessionState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/session/SessionState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MaybeEndSessionState"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 186
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/analytics/session/SessionState;-><init>(Lcom/amazon/analytics/session/SessionState$1;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/analytics/session/SessionState$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/analytics/session/SessionState$1;

    .prologue
    .line 186
    invoke-direct {p0}, Lcom/amazon/analytics/session/SessionState$MaybeEndSessionState;-><init>()V

    return-void
.end method


# virtual methods
.method public getNextState(Lcom/amazon/analytics/session/PackageSession;ILcom/amazon/analytics/util/Message;)Lcom/amazon/analytics/session/SessionState;
    .locals 3
    .param p1, "pSession"    # Lcom/amazon/analytics/session/PackageSession;
    .param p2, "flag"    # I
    .param p3, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 200
    packed-switch p2, :pswitch_data_0

    .line 213
    :cond_0
    :pswitch_0
    sget-object v1, Lcom/amazon/analytics/session/SessionState$MaybeEndSessionState;->MAYBE_END_SESSION:Lcom/amazon/analytics/session/SessionState;

    :goto_0
    return-object v1

    .line 202
    :pswitch_1
    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->getPackageName()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/analytics/session/SessionState;->isSamePackage(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z
    invoke-static {p3, v1}, Lcom/amazon/analytics/session/SessionState;->access$500(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 203
    invoke-virtual {p3}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v1

    const-string/jumbo v2, "SessionRunId"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 204
    .local v0, "timerRunId":I
    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->getRunId()I

    move-result v1

    if-ne v1, v0, :cond_1

    sget-object v1, Lcom/amazon/analytics/session/SessionState$MaybeEndSessionState;->NO_SESSION:Lcom/amazon/analytics/session/SessionState;

    goto :goto_0

    :cond_1
    sget-object v1, Lcom/amazon/analytics/session/SessionState$MaybeEndSessionState;->MAYBE_END_SESSION:Lcom/amazon/analytics/session/SessionState;

    goto :goto_0

    .line 206
    .end local v0    # "timerRunId":I
    :cond_2
    sget-object v1, Lcom/amazon/analytics/session/SessionState$MaybeEndSessionState;->MAYBE_END_SESSION:Lcom/amazon/analytics/session/SessionState;

    goto :goto_0

    .line 209
    :pswitch_2
    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->getPackageName()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/analytics/session/SessionState;->isSamePackage(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z
    invoke-static {p3, v1}, Lcom/amazon/analytics/session/SessionState;->access$500(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 210
    sget-object v1, Lcom/amazon/analytics/session/SessionState$MaybeEndSessionState;->RUNNING_SESSION:Lcom/amazon/analytics/session/SessionState;

    goto :goto_0

    .line 200
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public triggerOnStateAction(Lcom/amazon/analytics/session/PackageSession;Lcom/amazon/analytics/session/SessionState;Lcom/amazon/analytics/util/Message;)Lcom/amazon/device/analytics/events/Event;
    .locals 2
    .param p1, "pSession"    # Lcom/amazon/analytics/session/PackageSession;
    .param p2, "prevState"    # Lcom/amazon/analytics/session/SessionState;
    .param p3, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    const/4 v1, 0x0

    .line 190
    sget-object v0, Lcom/amazon/analytics/session/SessionState$MaybeEndSessionState;->RUNNING_SESSION:Lcom/amazon/analytics/session/SessionState;

    if-ne p2, v0, :cond_0

    .line 191
    invoke-virtual {p1, p3}, Lcom/amazon/analytics/session/PackageSession;->scheduleTimerTask(Lcom/amazon/analytics/util/Message;)Z

    .line 194
    :cond_0
    return-object v1
.end method
