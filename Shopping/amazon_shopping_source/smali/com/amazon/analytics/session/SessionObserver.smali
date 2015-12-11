.class public Lcom/amazon/analytics/session/SessionObserver;
.super Ljava/lang/Object;
.source "SessionObserver.java"


# static fields
.field private static final logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private final recorder:Lcom/amazon/device/analytics/events/EventRecorder;

.field private final sessionBuilder:Lcom/amazon/analytics/session/PackageSessionBuilder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/analytics/session/SessionObserver;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/analytics/session/SessionObserver;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/analytics/events/EventRecorder;Lcom/amazon/analytics/session/PackageSessionBuilder;)V
    .locals 0
    .param p1, "recorder"    # Lcom/amazon/device/analytics/events/EventRecorder;
    .param p2, "sessionBuilder"    # Lcom/amazon/analytics/session/PackageSessionBuilder;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/amazon/analytics/session/SessionObserver;->recorder:Lcom/amazon/device/analytics/events/EventRecorder;

    .line 24
    iput-object p2, p0, Lcom/amazon/analytics/session/SessionObserver;->sessionBuilder:Lcom/amazon/analytics/session/PackageSessionBuilder;

    .line 25
    return-void
.end method

.method private getPackageSessionsThatCareAbout(Lcom/amazon/analytics/util/Message;)Ljava/util/Set;
    .locals 4
    .param p1, "msg"    # Lcom/amazon/analytics/util/Message;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/analytics/util/Message;",
            ")",
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/analytics/session/PackageSession;",
            ">;"
        }
    .end annotation

    .prologue
    .line 45
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 48
    .local v0, "pSessions":Ljava/util/Set;, "Ljava/util/Set<Lcom/amazon/analytics/session/PackageSession;>;"
    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v2

    const-string/jumbo v3, "PackageName"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 49
    .local v1, "packageName":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/analytics/session/SessionObserver;->sessionBuilder:Lcom/amazon/analytics/session/PackageSessionBuilder;

    invoke-virtual {v2, v1}, Lcom/amazon/analytics/session/PackageSessionBuilder;->getInstance(Ljava/lang/String;)Lcom/amazon/analytics/session/PackageSession;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 51
    return-object v0
.end method


# virtual methods
.method public onUpdate(Lcom/amazon/analytics/util/Message;)V
    .locals 8
    .param p1, "message"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 28
    sget-object v4, Lcom/amazon/analytics/session/SessionObserver;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v5, "Enter onUpdate"

    invoke-virtual {v4, v5}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 29
    sget-object v4, Lcom/amazon/analytics/session/SessionObserver;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Received an "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v6

    const-string/jumbo v7, "topic"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " Session event at "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v6

    const-string/jumbo v7, "TimeStamp"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " for package "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v6

    const-string/jumbo v7, "PackageName"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 33
    invoke-direct {p0, p1}, Lcom/amazon/analytics/session/SessionObserver;->getPackageSessionsThatCareAbout(Lcom/amazon/analytics/util/Message;)Ljava/util/Set;

    move-result-object v2

    .line 34
    .local v2, "pSessions":Ljava/util/Set;, "Ljava/util/Set<Lcom/amazon/analytics/session/PackageSession;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/analytics/session/PackageSession;

    .line 35
    .local v3, "session":Lcom/amazon/analytics/session/PackageSession;
    invoke-virtual {v3, p1}, Lcom/amazon/analytics/session/PackageSession;->tryChangeSessionState(Lcom/amazon/analytics/util/Message;)Lcom/amazon/device/analytics/events/Event;

    move-result-object v0

    .line 36
    .local v0, "event":Lcom/amazon/device/analytics/events/Event;
    if-eqz v0, :cond_0

    .line 37
    iget-object v4, p0, Lcom/amazon/analytics/session/SessionObserver;->recorder:Lcom/amazon/device/analytics/events/EventRecorder;

    invoke-interface {v4, v0}, Lcom/amazon/device/analytics/events/EventRecorder;->recordEvent(Lcom/amazon/device/analytics/events/Event;)V

    goto :goto_0

    .line 40
    .end local v0    # "event":Lcom/amazon/device/analytics/events/Event;
    .end local v3    # "session":Lcom/amazon/analytics/session/PackageSession;
    :cond_1
    sget-object v4, Lcom/amazon/analytics/session/SessionObserver;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v5, "Exit onUpdate"

    invoke-virtual {v4, v5}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 41
    return-void
.end method
