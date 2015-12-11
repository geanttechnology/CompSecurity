.class public Lcom/amazon/mShop/startup/StartupTask;
.super Ljava/lang/Object;
.source "StartupTask.java"

# interfaces
.implements Lcom/amazon/mShop/util/mediator/Task;


# instance fields
.field private final mId:Ljava/lang/String;

.field private final mInputDependency:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mMediator:Lcom/amazon/mShop/util/mediator/Mediator;

.field private final mOutputDependency:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V
    .locals 1
    .param p1, "mediator"    # Lcom/amazon/mShop/util/mediator/Mediator;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/startup/StartupTask;->mInputDependency:Ljava/util/List;

    .line 14
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/startup/StartupTask;->mOutputDependency:Ljava/util/List;

    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupTask;->mMediator:Lcom/amazon/mShop/util/mediator/Mediator;

    .line 19
    iput-object p2, p0, Lcom/amazon/mShop/startup/StartupTask;->mId:Ljava/lang/String;

    .line 20
    invoke-interface {p1, p0}, Lcom/amazon/mShop/util/mediator/Mediator;->register(Lcom/amazon/mShop/util/mediator/Task;)V

    .line 21
    return-void
.end method


# virtual methods
.method public addInputDependency(Ljava/lang/String;)V
    .locals 1
    .param p1, "inputDep"    # Ljava/lang/String;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupTask;->mInputDependency:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupTask;->mInputDependency:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupTask;->mMediator:Lcom/amazon/mShop/util/mediator/Mediator;

    invoke-interface {v0, p0, p1}, Lcom/amazon/mShop/util/mediator/Mediator;->addDependency(Lcom/amazon/mShop/util/mediator/Task;Ljava/lang/String;)V

    .line 39
    :cond_0
    return-void
.end method

.method public addOutputDependency(Ljava/lang/String;)V
    .locals 1
    .param p1, "outputDep"    # Ljava/lang/String;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupTask;->mOutputDependency:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupTask;->mOutputDependency:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 50
    :cond_0
    return-void
.end method

.method public end(Ljava/lang/String;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 61
    const-string/jumbo v0, "taskResultSucceed"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 62
    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupTask;->onSucceed()V

    .line 67
    :goto_0
    return-void

    .line 65
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupTask;->onFailed()V

    goto :goto_0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupTask;->mId:Ljava/lang/String;

    return-object v0
.end method

.method public getInputDependency()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupTask;->mInputDependency:Ljava/util/List;

    return-object v0
.end method

.method public onFailed()V
    .locals 5

    .prologue
    .line 77
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "failed "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupTask;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 78
    iget-object v2, p0, Lcom/amazon/mShop/startup/StartupTask;->mOutputDependency:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 79
    .local v0, "d":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/startup/StartupTask;->mMediator:Lcom/amazon/mShop/util/mediator/Mediator;

    invoke-interface {v2, v0}, Lcom/amazon/mShop/util/mediator/Mediator;->onFailed(Ljava/lang/String;)V

    goto :goto_0

    .line 81
    .end local v0    # "d":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public onSucceed()V
    .locals 5

    .prologue
    .line 70
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "succeed "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupTask;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 71
    iget-object v2, p0, Lcom/amazon/mShop/startup/StartupTask;->mOutputDependency:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 72
    .local v0, "d":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/startup/StartupTask;->mMediator:Lcom/amazon/mShop/util/mediator/Mediator;

    invoke-interface {v2, v0}, Lcom/amazon/mShop/util/mediator/Mediator;->onReady(Ljava/lang/String;)V

    goto :goto_0

    .line 74
    .end local v0    # "d":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public removeInputDependency(Ljava/lang/String;)V
    .locals 1
    .param p1, "dependency"    # Ljava/lang/String;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupTask;->mInputDependency:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 44
    return-void
.end method

.method public start()V
    .locals 0

    .prologue
    .line 58
    return-void
.end method
