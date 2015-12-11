.class Lcom/amazon/analytics/session/SessionState$NoSessionState;
.super Lcom/amazon/analytics/session/SessionState;
.source "SessionState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/session/SessionState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "NoSessionState"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 43
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/analytics/session/SessionState;-><init>(Lcom/amazon/analytics/session/SessionState$1;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/analytics/session/SessionState$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/analytics/session/SessionState$1;

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/amazon/analytics/session/SessionState$NoSessionState;-><init>()V

    return-void
.end method

.method private createStopEvent(Lcom/amazon/analytics/util/Message;Lcom/amazon/device/analytics/events/Event;)Lcom/amazon/device/analytics/events/Event;
    .locals 5
    .param p1, "message"    # Lcom/amazon/analytics/util/Message;
    .param p2, "startEvent"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 76
    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v2

    const-string/jumbo v3, "TailwindEvent"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/events/Event;

    .line 77
    .local v0, "messageEvent":Lcom/amazon/device/analytics/events/Event;
    const/4 v1, 0x0

    .line 78
    .local v1, "stopEvent":Lcom/amazon/device/analytics/events/Event;
    if-nez v0, :cond_2

    .line 80
    new-instance v1, Lcom/amazon/device/analytics/events/Event;

    .end local v1    # "stopEvent":Lcom/amazon/device/analytics/events/Event;
    invoke-virtual {p2}, Lcom/amazon/device/analytics/events/Event;->getApplicationKey()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "com.amazon.analytics.session.stop"

    invoke-direct {v1, v2, v3, p2}, Lcom/amazon/device/analytics/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/device/analytics/events/Event;)V

    .line 84
    .restart local v1    # "stopEvent":Lcom/amazon/device/analytics/events/Event;
    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v2

    const-string/jumbo v3, "TimeStamp"

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 86
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

    .line 88
    :cond_0
    const-string/jumbo v2, "session_end_reason"

    const-string/jumbo v3, "artificial"

    invoke-virtual {v1, v2, v3}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    :goto_0
    const-string/jumbo v2, "TimeStamp"

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/events/Event;->hasMetric(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v2

    const-string/jumbo v3, "TimeStamp"

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 98
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

    .line 100
    :cond_1
    return-object v1

    .line 91
    :cond_2
    move-object v1, v0

    .line 92
    const-string/jumbo v2, "session_end_reason"

    const-string/jumbo v3, "normal"

    invoke-virtual {v1, v2, v3}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public getNextState(Lcom/amazon/analytics/session/PackageSession;ILcom/amazon/analytics/util/Message;)Lcom/amazon/analytics/session/SessionState;
    .locals 1
    .param p1, "pSession"    # Lcom/amazon/analytics/session/PackageSession;
    .param p2, "flag"    # I
    .param p3, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 67
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->getCurrentStartEvent()Lcom/amazon/device/analytics/events/Event;

    move-result-object v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->getPackageName()Ljava/lang/String;

    move-result-object v0

    # invokes: Lcom/amazon/analytics/session/SessionState;->isSamePackage(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z
    invoke-static {p3, v0}, Lcom/amazon/analytics/session/SessionState;->access$500(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 68
    sget-object v0, Lcom/amazon/analytics/session/SessionState$NoSessionState;->ORPHANED_SESSION:Lcom/amazon/analytics/session/SessionState;

    .line 70
    :goto_0
    return-object v0

    :cond_0
    if-nez p2, :cond_1

    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->getPackageName()Ljava/lang/String;

    move-result-object v0

    # invokes: Lcom/amazon/analytics/session/SessionState;->isSamePackage(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z
    invoke-static {p3, v0}, Lcom/amazon/analytics/session/SessionState;->access$500(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    sget-object v0, Lcom/amazon/analytics/session/SessionState$NoSessionState;->RUNNING_SESSION:Lcom/amazon/analytics/session/SessionState;

    goto :goto_0

    :cond_1
    sget-object v0, Lcom/amazon/analytics/session/SessionState$NoSessionState;->NO_SESSION:Lcom/amazon/analytics/session/SessionState;

    goto :goto_0
.end method

.method public triggerOnStateAction(Lcom/amazon/analytics/session/PackageSession;Lcom/amazon/analytics/session/SessionState;Lcom/amazon/analytics/util/Message;)Lcom/amazon/device/analytics/events/Event;
    .locals 8
    .param p1, "pSession"    # Lcom/amazon/analytics/session/PackageSession;
    .param p2, "prevState"    # Lcom/amazon/analytics/session/SessionState;
    .param p3, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 47
    const/4 v2, 0x0

    .line 48
    .local v2, "stopEvent":Lcom/amazon/device/analytics/events/Event;
    sget-object v3, Lcom/amazon/analytics/session/SessionState$NoSessionState;->MAYBE_END_SESSION:Lcom/amazon/analytics/session/SessionState;

    if-ne p2, v3, :cond_1

    .line 49
    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->getCurrentStartEvent()Lcom/amazon/device/analytics/events/Event;

    move-result-object v1

    .line 51
    .local v1, "startEvent":Lcom/amazon/device/analytics/events/Event;
    invoke-direct {p0, p3, v1}, Lcom/amazon/analytics/session/SessionState$NoSessionState;->createStopEvent(Lcom/amazon/analytics/util/Message;Lcom/amazon/device/analytics/events/Event;)Lcom/amazon/device/analytics/events/Event;

    move-result-object v2

    .line 53
    const/4 v0, 0x0

    .line 54
    .local v0, "sessionLength":Ljava/lang/Long;
    const-string/jumbo v3, "TimeStamp"

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/events/Event;->hasMetric(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    const-string/jumbo v3, "TimeStamp"

    invoke-virtual {v1, v3}, Lcom/amazon/device/analytics/events/Event;->hasMetric(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 55
    const-string/jumbo v3, "TimeStamp"

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/events/Event;->getMetric(Ljava/lang/String;)Ljava/lang/Number;

    move-result-object v3

    check-cast v3, Ljava/lang/Long;

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    const-string/jumbo v3, "TimeStamp"

    invoke-virtual {v1, v3}, Lcom/amazon/device/analytics/events/Event;->getMetric(Ljava/lang/String;)Ljava/lang/Number;

    move-result-object v3

    check-cast v3, Ljava/lang/Long;

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    sub-long v3, v4, v6

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 58
    :cond_0
    const-string/jumbo v3, "sessionlength"

    invoke-virtual {v2, v3, v0}, Lcom/amazon/device/analytics/events/Event;->addMetric(Ljava/lang/String;Ljava/lang/Number;)V

    .line 59
    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->clearTrackingInfo()V

    .line 62
    .end local v0    # "sessionLength":Ljava/lang/Long;
    .end local v1    # "startEvent":Lcom/amazon/device/analytics/events/Event;
    :cond_1
    return-object v2
.end method
