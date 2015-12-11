.class public Lcom/amazon/mShop/util/mediator/MediatorImpl;
.super Ljava/lang/Object;
.source "MediatorImpl.java"

# interfaces
.implements Lcom/amazon/mShop/util/mediator/Mediator;


# instance fields
.field protected mDependencyTasks:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/util/mediator/Task;",
            ">;>;"
        }
    .end annotation
.end field

.field protected final mTasks:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/util/mediator/Task;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/util/mediator/MediatorImpl;->mDependencyTasks:Ljava/util/Map;

    .line 73
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/util/mediator/MediatorImpl;->mTasks:Ljava/util/Map;

    return-void
.end method

.method private createTaskListWith(Lcom/amazon/mShop/util/mediator/Task;)Ljava/util/List;
    .locals 1
    .param p1, "task"    # Lcom/amazon/mShop/util/mediator/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/util/mediator/Task;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/util/mediator/Task;",
            ">;"
        }
    .end annotation

    .prologue
    .line 39
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 40
    .local v0, "tasks":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/util/mediator/Task;>;"
    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 41
    return-object v0
.end method


# virtual methods
.method public addDependency(Lcom/amazon/mShop/util/mediator/Task;Ljava/lang/String;)V
    .locals 3
    .param p1, "task"    # Lcom/amazon/mShop/util/mediator/Task;
    .param p2, "dependency"    # Ljava/lang/String;

    .prologue
    .line 21
    iget-object v1, p0, Lcom/amazon/mShop/util/mediator/MediatorImpl;->mDependencyTasks:Ljava/util/Map;

    invoke-interface {v1, p2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 22
    iget-object v1, p0, Lcom/amazon/mShop/util/mediator/MediatorImpl;->mDependencyTasks:Ljava/util/Map;

    invoke-interface {v1, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 23
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/util/mediator/Task;>;"
    if-eqz v0, :cond_1

    .line 24
    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 25
    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 36
    .end local v0    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/util/mediator/Task;>;"
    :cond_0
    :goto_0
    return-void

    .line 30
    .restart local v0    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/util/mediator/Task;>;"
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/util/mediator/MediatorImpl;->mDependencyTasks:Ljava/util/Map;

    invoke-interface {v1, p2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    iget-object v1, p0, Lcom/amazon/mShop/util/mediator/MediatorImpl;->mDependencyTasks:Ljava/util/Map;

    invoke-direct {p0, p1}, Lcom/amazon/mShop/util/mediator/MediatorImpl;->createTaskListWith(Lcom/amazon/mShop/util/mediator/Task;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v1, p2, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 34
    .end local v0    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/util/mediator/Task;>;"
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/util/mediator/MediatorImpl;->mDependencyTasks:Ljava/util/Map;

    invoke-direct {p0, p1}, Lcom/amazon/mShop/util/mediator/MediatorImpl;->createTaskListWith(Lcom/amazon/mShop/util/mediator/Task;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v1, p2, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public onFailed(Ljava/lang/String;)V
    .locals 0
    .param p1, "dependency"    # Ljava/lang/String;

    .prologue
    .line 68
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/util/mediator/MediatorImpl;->onReady(Ljava/lang/String;)V

    .line 69
    return-void
.end method

.method public onReady(Ljava/lang/String;)V
    .locals 7
    .param p1, "dependency"    # Ljava/lang/String;

    .prologue
    .line 46
    iget-object v5, p0, Lcom/amazon/mShop/util/mediator/MediatorImpl;->mDependencyTasks:Ljava/util/Map;

    invoke-interface {v5, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 47
    iget-object v5, p0, Lcom/amazon/mShop/util/mediator/MediatorImpl;->mDependencyTasks:Ljava/util/Map;

    invoke-interface {v5, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 48
    .local v4, "tasks":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/util/mediator/Task;>;"
    if-eqz v4, :cond_3

    .line 49
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 50
    .local v2, "removed":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/util/mediator/Task;>;"
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/util/mediator/Task;

    .line 51
    .local v3, "task":Lcom/amazon/mShop/util/mediator/Task;
    iget-object v5, p0, Lcom/amazon/mShop/util/mediator/MediatorImpl;->mTasks:Ljava/util/Map;

    invoke-interface {v3}, Lcom/amazon/mShop/util/mediator/Task;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 52
    invoke-interface {v3, p1}, Lcom/amazon/mShop/util/mediator/Task;->removeInputDependency(Ljava/lang/String;)V

    .line 53
    invoke-interface {v3}, Lcom/amazon/mShop/util/mediator/Task;->getInputDependency()Ljava/util/List;

    move-result-object v0

    .line 54
    .local v0, "dependencies":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    if-nez v5, :cond_0

    .line 55
    :cond_1
    invoke-interface {v3}, Lcom/amazon/mShop/util/mediator/Task;->start()V

    .line 56
    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 60
    .end local v0    # "dependencies":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v3    # "task":Lcom/amazon/mShop/util/mediator/Task;
    :cond_2
    invoke-interface {v4, v2}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 63
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "removed":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/util/mediator/Task;>;"
    .end local v4    # "tasks":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/util/mediator/Task;>;"
    :cond_3
    return-void
.end method

.method public register(Lcom/amazon/mShop/util/mediator/Task;)V
    .locals 5
    .param p1, "task"    # Lcom/amazon/mShop/util/mediator/Task;

    .prologue
    .line 12
    iget-object v3, p0, Lcom/amazon/mShop/util/mediator/MediatorImpl;->mTasks:Ljava/util/Map;

    invoke-interface {p1}, Lcom/amazon/mShop/util/mediator/Task;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 13
    invoke-interface {p1}, Lcom/amazon/mShop/util/mediator/Task;->getInputDependency()Ljava/util/List;

    move-result-object v2

    .line 14
    .local v2, "inputDependencies":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 15
    .local v0, "dep":Ljava/lang/String;
    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/util/mediator/MediatorImpl;->addDependency(Lcom/amazon/mShop/util/mediator/Task;Ljava/lang/String;)V

    goto :goto_0

    .line 17
    .end local v0    # "dep":Ljava/lang/String;
    :cond_0
    return-void
.end method
