.class public Lcom/xfinity/playerlib/model/entitlement/GracefullyDegradingVideoEntitlementCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;
.source "GracefullyDegradingVideoEntitlementCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask",
        "<",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        ">;"
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 13
    .local p1, "delegateTask":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 10
    const-class v0, Lcom/xfinity/playerlib/model/entitlement/GracefullyDegradingVideoEntitlementCache;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/GracefullyDegradingVideoEntitlementCache;->LOG:Lorg/slf4j/Logger;

    .line 14
    return-void
.end method


# virtual methods
.method protected getDefaultValue()Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 1

    .prologue
    .line 27
    new-instance v0, Lcom/xfinity/playerlib/model/entitlement/NullVideoEntitlement;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/entitlement/NullVideoEntitlement;-><init>()V

    return-object v0
.end method

.method protected bridge synthetic getDefaultValue()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 9
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/entitlement/GracefullyDegradingVideoEntitlementCache;->getDefaultValue()Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-result-object v0

    return-object v0
.end method

.method protected handleException(Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 18
    instance-of v0, p1, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->getDetailedStatusCode()I

    move-result v0

    const/16 v1, 0xbc1

    if-ne v0, v1, :cond_0

    .line 19
    check-cast p1, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    .end local p1    # "throwable":Ljava/lang/Throwable;
    throw p1

    .line 21
    .restart local p1    # "throwable":Ljava/lang/Throwable;
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/GracefullyDegradingVideoEntitlementCache;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Exception while retrieving video entitlement, using null entitlement"

    invoke-interface {v0, v1, p1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 23
    return-void
.end method
