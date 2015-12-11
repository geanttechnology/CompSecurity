.class public Lcom/comcast/cim/model/GracefullyDegradingMinVersionCheckCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;
.source "GracefullyDegradingMinVersionCheckCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask",
        "<",
        "Ljava/lang/Integer;",
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
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 13
    .local p1, "delegate":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Ljava/lang/Integer;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 10
    const-class v0, Lcom/comcast/cim/model/GracefullyDegradingMinVersionCheckCache;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/model/GracefullyDegradingMinVersionCheckCache;->LOG:Lorg/slf4j/Logger;

    .line 14
    return-void
.end method


# virtual methods
.method protected getDefaultValue()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 24
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic getDefaultValue()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 8
    invoke-virtual {p0}, Lcom/comcast/cim/model/GracefullyDegradingMinVersionCheckCache;->getDefaultValue()Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method protected handleException(Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/comcast/cim/model/GracefullyDegradingMinVersionCheckCache;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Exception while retrieving minimum version, assuming no minimum version set"

    invoke-interface {v0, v1, p1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 20
    return-void
.end method
