.class Lcom/conviva/session/Session$5;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/conviva/session/Session;->onHeartbeatResponse(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/conviva/session/Session;

.field final synthetic val$jsonResponse:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/conviva/session/Session;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    iput-object p2, p0, Lcom/conviva/session/Session$5;->val$jsonResponse:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/conviva/session/Session$5;->call()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/Void;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/conviva/session/Session$5;->val$jsonResponse:Ljava/lang/String;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;
    invoke-static {v0}, Lcom/conviva/session/Session;->access$200(Lcom/conviva/session/Session;)Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "onHeartbeatResponse: data = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/conviva/session/Session$5;->val$jsonResponse:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/conviva/utils/PlatformUtils;->logConsole(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;
    invoke-static {v0}, Lcom/conviva/session/Session;->access$200(Lcom/conviva/session/Session;)Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    iget-object v2, p0, Lcom/conviva/session/Session$5;->val$jsonResponse:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/conviva/utils/PlatformUtils;->jsonDecode(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v2

    const-string v0, "sid"

    invoke-interface {v2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "sid"

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    iget-object v0, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_sessionId:I
    invoke-static {v0}, Lcom/conviva/session/Session;->access$400(Lcom/conviva/session/Session;)I

    move-result v0

    int-to-long v6, v0

    cmp-long v0, v4, v6

    if-nez v0, :cond_0

    const-string v0, "clid"

    invoke-interface {v2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;
    invoke-static {v0}, Lcom/conviva/session/Session;->access$200(Lcom/conviva/session/Session;)Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    const-string v3, "clid"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/conviva/utils/PlatformUtils;->setClientIdFromServer(Ljava/lang/String;)V

    :cond_0
    const-string v0, "slg"

    invoke-interface {v2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    const-string v0, "slg"

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_4

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iget-object v4, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;
    invoke-static {v4}, Lcom/conviva/session/Session;->access$500(Lcom/conviva/session/Session;)Lcom/conviva/utils/Settings;

    move-result-object v4

    iget-boolean v4, v4, Lcom/conviva/utils/Settings;->sendLogs:Z

    if-eq v0, v4, :cond_1

    iget-object v0, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;
    invoke-static {v0}, Lcom/conviva/session/Session;->access$200(Lcom/conviva/session/Session;)Lcom/conviva/utils/PlatformUtils;

    move-result-object v4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Turning "

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_5

    const-string v0, "on"

    :goto_1
    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, " sending of logs"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;
    invoke-static {v0}, Lcom/conviva/session/Session;->access$500(Lcom/conviva/session/Session;)Lcom/conviva/utils/Settings;

    move-result-object v0

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, v0, Lcom/conviva/utils/Settings;->sendLogs:Z

    :cond_1
    const-string v0, "hbi"

    invoke-interface {v2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "hbi"

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    mul-long/2addr v4, v6

    iget-object v0, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;
    invoke-static {v0}, Lcom/conviva/session/Session;->access$500(Lcom/conviva/session/Session;)Lcom/conviva/utils/Settings;

    move-result-object v0

    iget v0, v0, Lcom/conviva/utils/Settings;->heartbeatIntervalMs:I

    int-to-long v6, v0

    cmp-long v0, v6, v4

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;
    invoke-static {v0}, Lcom/conviva/session/Session;->access$200(Lcom/conviva/session/Session;)Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Received hbIntervalMs from server "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;
    invoke-static {v0}, Lcom/conviva/session/Session;->access$500(Lcom/conviva/session/Session;)Lcom/conviva/utils/Settings;

    move-result-object v0

    long-to-int v3, v4

    iput v3, v0, Lcom/conviva/utils/Settings;->heartbeatIntervalMs:I

    iget-object v0, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # invokes: Lcom/conviva/session/Session;->createHBTimer(Z)V
    invoke-static {v0, v1}, Lcom/conviva/session/Session;->access$600(Lcom/conviva/session/Session;Z)V

    :cond_2
    const-string v0, "gw"

    invoke-interface {v2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "gw"

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;
    invoke-static {v1}, Lcom/conviva/session/Session;->access$500(Lcom/conviva/session/Session;)Lcom/conviva/utils/Settings;

    move-result-object v1

    iget-object v1, v1, Lcom/conviva/utils/Settings;->gatewayUrl:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    iget-object v1, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;
    invoke-static {v1}, Lcom/conviva/session/Session;->access$200(Lcom/conviva/session/Session;)Lcom/conviva/utils/PlatformUtils;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Received gatewayUrl from server "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;
    invoke-static {v1}, Lcom/conviva/session/Session;->access$500(Lcom/conviva/session/Session;)Lcom/conviva/utils/Settings;

    move-result-object v1

    iput-object v0, v1, Lcom/conviva/utils/Settings;->gatewayUrl:Ljava/lang/String;

    :cond_3
    :goto_2
    const/4 v0, 0x0

    return-object v0

    :cond_4
    move v0, v1

    goto/16 :goto_0

    :cond_5
    const-string v0, "off"

    goto/16 :goto_1

    :cond_6
    iget-object v0, p0, Lcom/conviva/session/Session$5;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;
    invoke-static {v0}, Lcom/conviva/session/Session;->access$200(Lcom/conviva/session/Session;)Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    const-string v1, "Received no response (or a bad response) to a POST request."

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    goto :goto_2
.end method
