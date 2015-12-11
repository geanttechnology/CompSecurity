.class public Lcom/conviva/session/SessionFactory;
.super Ljava/lang/Object;


# instance fields
.field private _nextSessionId:I

.field private _sessionsById:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/conviva/session/Session;",
            ">;"
        }
    .end annotation
.end field

.field private _utils:Lcom/conviva/utils/PlatformUtils;


# direct methods
.method public constructor <init>()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput v1, p0, Lcom/conviva/session/SessionFactory;->_nextSessionId:I

    iput-object v0, p0, Lcom/conviva/session/SessionFactory;->_sessionsById:Ljava/util/Map;

    iput-object v0, p0, Lcom/conviva/session/SessionFactory;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-static {}, Lcom/conviva/utils/PlatformUtils;->getInstance()Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/session/SessionFactory;->_utils:Lcom/conviva/utils/PlatformUtils;

    iput v1, p0, Lcom/conviva/session/SessionFactory;->_nextSessionId:I

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/conviva/session/SessionFactory;->_sessionsById:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public cleanupSession(I)V
    .locals 4

    iget-object v0, p0, Lcom/conviva/session/SessionFactory;->_sessionsById:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/conviva/session/Session;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/conviva/session/SessionFactory;->_sessionsById:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v1, p0, Lcom/conviva/session/SessionFactory;->_utils:Lcom/conviva/utils/PlatformUtils;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "session id("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") is cleaned up and removed from sessionFactory"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/conviva/session/Session;->cleanup()V

    :cond_0
    return-void
.end method

.method public getSession(I)Lcom/conviva/session/Session;
    .locals 2

    iget-object v0, p0, Lcom/conviva/session/SessionFactory;->_sessionsById:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/conviva/session/Session;

    return-object v0
.end method

.method public makeSession(Ljava/lang/Object;Lcom/conviva/ConvivaContentInfo;Ljava/util/Map;IZ)Lcom/conviva/session/Session;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcom/conviva/ConvivaContentInfo;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;IZ)",
            "Lcom/conviva/session/Session;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    new-instance v0, Lcom/conviva/session/Session;

    invoke-direct {v0, p1, p2, p3, p5}, Lcom/conviva/session/Session;-><init>(Ljava/lang/Object;Lcom/conviva/ConvivaContentInfo;Ljava/util/Map;Z)V

    iget-object v1, p0, Lcom/conviva/session/SessionFactory;->_sessionsById:Ljava/util/Map;

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v1, p0, Lcom/conviva/session/SessionFactory;->_utils:Lcom/conviva/utils/PlatformUtils;

    const-string v2, "Session is created; session is about to start"

    invoke-virtual {v1, v2}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/conviva/session/Session;->start()V

    return-object v0
.end method

.method public newSessionId()I
    .locals 2

    iget v0, p0, Lcom/conviva/session/SessionFactory;->_nextSessionId:I

    iget v1, p0, Lcom/conviva/session/SessionFactory;->_nextSessionId:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/conviva/session/SessionFactory;->_nextSessionId:I

    return v0
.end method
