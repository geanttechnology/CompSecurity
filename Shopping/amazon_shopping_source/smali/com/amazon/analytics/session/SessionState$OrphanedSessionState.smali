.class Lcom/amazon/analytics/session/SessionState$OrphanedSessionState;
.super Lcom/amazon/analytics/session/SessionState;
.source "SessionState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/session/SessionState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "OrphanedSessionState"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 109
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/analytics/session/SessionState;-><init>(Lcom/amazon/analytics/session/SessionState$1;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/analytics/session/SessionState$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/analytics/session/SessionState$1;

    .prologue
    .line 109
    invoke-direct {p0}, Lcom/amazon/analytics/session/SessionState$OrphanedSessionState;-><init>()V

    return-void
.end method

.method private createStopEvent(Lcom/amazon/analytics/util/Message;Lcom/amazon/device/analytics/events/Event;)Lcom/amazon/device/analytics/events/Event;
    .locals 5
    .param p1, "message"    # Lcom/amazon/analytics/util/Message;
    .param p2, "startEvent"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 128
    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v2

    const-string/jumbo v3, "TailwindEvent"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/events/Event;

    .line 129
    .local v0, "messageEvent":Lcom/amazon/device/analytics/events/Event;
    const/4 v1, 0x0

    .line 130
    .local v1, "stopEvent":Lcom/amazon/device/analytics/events/Event;
    if-eqz v0, :cond_0

    .line 131
    new-instance v1, Lcom/amazon/device/analytics/events/Event;

    .end local v1    # "stopEvent":Lcom/amazon/device/analytics/events/Event;
    invoke-virtual {v0}, Lcom/amazon/device/analytics/events/Event;->getApplicationKey()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "com.amazon.analytics.session.stop"

    invoke-direct {v1, v2, v3, v0}, Lcom/amazon/device/analytics/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/device/analytics/events/Event;)V

    .line 135
    .restart local v1    # "stopEvent":Lcom/amazon/device/analytics/events/Event;
    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v2

    const-string/jumbo v3, "TimeStamp"

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 137
    const-string/jumbo v2, "TimeStamp"

    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v3

    const-string/jumbo v4, "TimeStamp"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/amazon/device/analytics/events/Event;->addMetric(Ljava/lang/String;Ljava/lang/Number;)V

    .line 140
    :cond_0
    return-object v1
.end method


# virtual methods
.method public getNextState(Lcom/amazon/analytics/session/PackageSession;ILcom/amazon/analytics/util/Message;)Lcom/amazon/analytics/session/SessionState;
    .locals 1
    .param p1, "pSession"    # Lcom/amazon/analytics/session/PackageSession;
    .param p2, "flag"    # I
    .param p3, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 124
    sget-object v0, Lcom/amazon/analytics/session/SessionState$OrphanedSessionState;->NO_SESSION:Lcom/amazon/analytics/session/SessionState;

    return-object v0
.end method

.method public triggerOnStateAction(Lcom/amazon/analytics/session/PackageSession;Lcom/amazon/analytics/session/SessionState;Lcom/amazon/analytics/util/Message;)Lcom/amazon/device/analytics/events/Event;
    .locals 3
    .param p1, "pSession"    # Lcom/amazon/analytics/session/PackageSession;
    .param p2, "prevState"    # Lcom/amazon/analytics/session/SessionState;
    .param p3, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 113
    const/4 v0, 0x0

    .line 114
    .local v0, "stopEvent":Lcom/amazon/device/analytics/events/Event;
    sget-object v1, Lcom/amazon/analytics/session/SessionState$OrphanedSessionState;->NO_SESSION:Lcom/amazon/analytics/session/SessionState;

    if-ne p2, v1, :cond_0

    .line 115
    const/4 v1, 0x0

    invoke-direct {p0, p3, v1}, Lcom/amazon/analytics/session/SessionState$OrphanedSessionState;->createStopEvent(Lcom/amazon/analytics/util/Message;Lcom/amazon/device/analytics/events/Event;)Lcom/amazon/device/analytics/events/Event;

    move-result-object v0

    .line 116
    const-string/jumbo v1, "session_end_reason"

    const-string/jumbo v2, "orphan"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->clearTrackingInfo()V

    .line 119
    :cond_0
    return-object v0
.end method
