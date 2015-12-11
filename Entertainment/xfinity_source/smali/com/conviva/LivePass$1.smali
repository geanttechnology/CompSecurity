.class final Lcom/conviva/LivePass$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/conviva/LivePass;->initWithSettings(Ljava/lang/String;Ljava/util/Map;Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
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


# direct methods
.method constructor <init>()V
    .locals 0

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

    invoke-virtual {p0}, Lcom/conviva/LivePass$1;->call()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/Void;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    # getter for: Lcom/conviva/LivePass;->_toggleTracesSet:Ljava/lang/Boolean;
    invoke-static {}, Lcom/conviva/LivePass;->access$000()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    # getter for: Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;
    invoke-static {}, Lcom/conviva/LivePass;->access$100()Lcom/conviva/utils/Settings;

    move-result-object v0

    # getter for: Lcom/conviva/LivePass;->_toggleTracesSetValue:Ljava/lang/Boolean;
    invoke-static {}, Lcom/conviva/LivePass;->access$200()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    iput-boolean v1, v0, Lcom/conviva/utils/Settings;->enableLogging:Z

    :cond_0
    # getter for: Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;
    invoke-static {}, Lcom/conviva/LivePass;->access$300()Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "LivePass.init url="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    # getter for: Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;
    invoke-static {}, Lcom/conviva/LivePass;->access$100()Lcom/conviva/utils/Settings;

    move-result-object v2

    iget-object v2, v2, Lcom/conviva/utils/Settings;->gatewayUrl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", customerKey="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    # getter for: Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;
    invoke-static {}, Lcom/conviva/LivePass;->access$100()Lcom/conviva/utils/Settings;

    move-result-object v2

    iget-object v2, v2, Lcom/conviva/utils/Settings;->customerKey:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    invoke-static {}, Lcom/conviva/monitor/PlayerStates;->init()V

    new-instance v0, Lcom/conviva/session/SessionFactory;

    invoke-direct {v0}, Lcom/conviva/session/SessionFactory;-><init>()V

    # setter for: Lcom/conviva/LivePass;->_sessionFactory:Lcom/conviva/session/SessionFactory;
    invoke-static {v0}, Lcom/conviva/LivePass;->access$402(Lcom/conviva/session/SessionFactory;)Lcom/conviva/session/SessionFactory;

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    # setter for: Lcom/conviva/LivePass;->readyState:Ljava/lang/Boolean;
    invoke-static {v0}, Lcom/conviva/LivePass;->access$502(Ljava/lang/Boolean;)Ljava/lang/Boolean;

    const/4 v0, 0x0

    return-object v0
.end method
