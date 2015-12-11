.class Lcom/amazon/analytics/session/SessionState$RunningSessionState;
.super Lcom/amazon/analytics/session/SessionState;
.source "SessionState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/session/SessionState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RunningSessionState"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 151
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/analytics/session/SessionState;-><init>(Lcom/amazon/analytics/session/SessionState$1;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/analytics/session/SessionState$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/analytics/session/SessionState$1;

    .prologue
    .line 151
    invoke-direct {p0}, Lcom/amazon/analytics/session/SessionState$RunningSessionState;-><init>()V

    return-void
.end method


# virtual methods
.method public getNextState(Lcom/amazon/analytics/session/PackageSession;ILcom/amazon/analytics/util/Message;)Lcom/amazon/analytics/session/SessionState;
    .locals 1
    .param p1, "pSession"    # Lcom/amazon/analytics/session/PackageSession;
    .param p2, "flag"    # I
    .param p3, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 175
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->getPackageName()Ljava/lang/String;

    move-result-object v0

    # invokes: Lcom/amazon/analytics/session/SessionState;->isSamePackage(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z
    invoke-static {p3, v0}, Lcom/amazon/analytics/session/SessionState;->access$500(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/amazon/analytics/session/SessionState$RunningSessionState;->MAYBE_END_SESSION:Lcom/amazon/analytics/session/SessionState;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/amazon/analytics/session/SessionState$RunningSessionState;->RUNNING_SESSION:Lcom/amazon/analytics/session/SessionState;

    goto :goto_0
.end method

.method public triggerOnStateAction(Lcom/amazon/analytics/session/PackageSession;Lcom/amazon/analytics/session/SessionState;Lcom/amazon/analytics/util/Message;)Lcom/amazon/device/analytics/events/Event;
    .locals 4
    .param p1, "pSession"    # Lcom/amazon/analytics/session/PackageSession;
    .param p2, "prevState"    # Lcom/amazon/analytics/session/SessionState;
    .param p3, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    const/4 v1, 0x0

    .line 155
    sget-object v2, Lcom/amazon/analytics/session/SessionState$RunningSessionState;->NO_SESSION:Lcom/amazon/analytics/session/SessionState;

    if-ne p2, v2, :cond_1

    .line 156
    invoke-virtual {p3}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v2

    const-string/jumbo v3, "TailwindEvent"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/events/Event;

    .line 157
    .local v0, "event":Lcom/amazon/device/analytics/events/Event;
    new-instance v1, Lcom/amazon/device/analytics/events/Event;

    invoke-virtual {v0}, Lcom/amazon/device/analytics/events/Event;->getApplicationKey()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "com.amazon.analytics.session.start"

    invoke-direct {v1, v2, v3, v0}, Lcom/amazon/device/analytics/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/device/analytics/events/Event;)V

    .line 161
    .local v1, "startEvent":Lcom/amazon/device/analytics/events/Event;
    invoke-virtual {p1, v1}, Lcom/amazon/analytics/session/PackageSession;->setCurrentStartEvent(Lcom/amazon/device/analytics/events/Event;)V

    .line 169
    .end local v0    # "event":Lcom/amazon/device/analytics/events/Event;
    .end local v1    # "startEvent":Lcom/amazon/device/analytics/events/Event;
    :cond_0
    :goto_0
    return-object v1

    .line 163
    :cond_1
    sget-object v2, Lcom/amazon/analytics/session/SessionState$RunningSessionState;->MAYBE_END_SESSION:Lcom/amazon/analytics/session/SessionState;

    if-ne p2, v2, :cond_0

    .line 164
    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->tryCancelTimerTask()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 165
    invoke-virtual {p1}, Lcom/amazon/analytics/session/PackageSession;->incrementRunId()V

    goto :goto_0
.end method
