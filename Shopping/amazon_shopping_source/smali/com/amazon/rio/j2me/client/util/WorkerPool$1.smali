.class Lcom/amazon/rio/j2me/client/util/WorkerPool$1;
.super Ljava/lang/Object;
.source "WorkerPool.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/util/LifecycleManager;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/rio/j2me/client/util/WorkerPool;-><init>(Ljava/lang/String;II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/util/LifecycleManager",
        "<",
        "Lcom/amazon/rio/j2me/client/util/Worker;",
        ">;"
    }
.end annotation


# instance fields
.field private cnt:I

.field final synthetic val$name:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 20
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/util/WorkerPool$1;->val$name:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createInstance()Lcom/amazon/rio/j2me/client/util/Worker;
    .locals 4

    .prologue
    .line 23
    new-instance v0, Lcom/amazon/rio/j2me/client/util/Worker;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/WorkerPool$1;->val$name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/amazon/rio/j2me/client/util/WorkerPool$1;->cnt:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/amazon/rio/j2me/client/util/WorkerPool$1;->cnt:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/rio/j2me/client/util/Worker;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public bridge synthetic createInstance()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/rio/j2me/client/util/LifecycleException;
        }
    .end annotation

    .prologue
    .line 20
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/WorkerPool$1;->createInstance()Lcom/amazon/rio/j2me/client/util/Worker;

    move-result-object v0

    return-object v0
.end method

.method public destroyInstance(Lcom/amazon/rio/j2me/client/util/Worker;)V
    .locals 0
    .param p1, "worker"    # Lcom/amazon/rio/j2me/client/util/Worker;

    .prologue
    .line 27
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/util/Worker;->stopWorker()Lcom/amazon/rio/j2me/client/util/Worker$State;

    .line 28
    return-void
.end method

.method public bridge synthetic destroyInstance(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 20
    check-cast p1, Lcom/amazon/rio/j2me/client/util/Worker;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/rio/j2me/client/util/WorkerPool$1;->destroyInstance(Lcom/amazon/rio/j2me/client/util/Worker;)V

    return-void
.end method
