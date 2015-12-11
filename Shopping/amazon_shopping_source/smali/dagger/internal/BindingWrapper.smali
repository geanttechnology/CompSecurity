.class public Ldagger/internal/BindingWrapper;
.super Ldagger/internal/Binding;
.source "BindingWrapper.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ldagger/internal/Binding",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final mBinding:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ldagger/internal/Binding;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ldagger/internal/Binding",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 17
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    .local p1, "binding":Ldagger/internal/Binding;, "Ldagger/internal/Binding<TT;>;"
    iget-object v0, p1, Ldagger/internal/Binding;->provideKey:Ljava/lang/String;

    iget-object v1, p1, Ldagger/internal/Binding;->membersKey:Ljava/lang/String;

    invoke-virtual {p1}, Ldagger/internal/Binding;->isSingleton()Z

    move-result v2

    iget-object v3, p1, Ldagger/internal/Binding;->requiredBy:Ljava/lang/Object;

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/Binding;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V

    .line 18
    iput-object p1, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    .line 19
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 1
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 25
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0, p1}, Ldagger/internal/Binding;->attach(Ldagger/internal/Linker;)V

    .line 26
    return-void
.end method

.method public dependedOn()Z
    .locals 1

    .prologue
    .line 106
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->dependedOn()Z

    move-result v0

    return v0
.end method

.method public get()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    const/4 v3, 0x3

    .line 38
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "DI:DaggerBinding:get:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 39
    .local v0, "traceName":Ljava/lang/String;
    invoke-static {v0, v3}, Lcom/amazon/avod/perf/Profiler;->beginTrace(Ljava/lang/String;I)V

    .line 41
    :try_start_0
    iget-object v1, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v1}, Ldagger/internal/Binding;->get()Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 44
    invoke-static {v0, v3}, Lcom/amazon/avod/perf/Profiler;->endTrace(Ljava/lang/String;I)V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-static {v0, v3}, Lcom/amazon/avod/perf/Profiler;->endTrace(Ljava/lang/String;I)V

    throw v1
.end method

.method public getDependencies(Ljava/util/Set;Ljava/util/Set;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ldagger/internal/Binding",
            "<*>;>;",
            "Ljava/util/Set",
            "<",
            "Ldagger/internal/Binding",
            "<*>;>;)V"
        }
    .end annotation

    .prologue
    .line 51
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0, p1, p2}, Ldagger/internal/Binding;->getDependencies(Ljava/util/Set;Ljava/util/Set;)V

    .line 52
    return-void
.end method

.method public injectMembers(Ljava/lang/Object;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    .local p1, "t":Ljava/lang/Object;, "TT;"
    const/4 v3, 0x3

    .line 30
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "DI:DaggerBinding:injectMembers:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 31
    .local v0, "traceName":Ljava/lang/String;
    invoke-static {v0, v3}, Lcom/amazon/avod/perf/Profiler;->beginTrace(Ljava/lang/String;I)V

    .line 32
    iget-object v1, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v1, p1}, Ldagger/internal/Binding;->injectMembers(Ljava/lang/Object;)V

    .line 33
    invoke-static {v0, v3}, Lcom/amazon/avod/perf/Profiler;->endTrace(Ljava/lang/String;I)V

    .line 34
    return-void
.end method

.method public isCycleFree()Z
    .locals 1

    .prologue
    .line 81
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->isCycleFree()Z

    move-result v0

    return v0
.end method

.method public isLinked()Z
    .locals 1

    .prologue
    .line 61
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->isLinked()Z

    move-result v0

    return v0
.end method

.method isSingleton()Z
    .locals 1

    .prologue
    .line 66
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->isSingleton()Z

    move-result v0

    return v0
.end method

.method public isVisiting()Z
    .locals 1

    .prologue
    .line 71
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->isVisiting()Z

    move-result v0

    return v0
.end method

.method public library()Z
    .locals 1

    .prologue
    .line 96
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->library()Z

    move-result v0

    return v0
.end method

.method public setCycleFree(Z)V
    .locals 1
    .param p1, "cycleFree"    # Z

    .prologue
    .line 86
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0, p1}, Ldagger/internal/Binding;->setCycleFree(Z)V

    .line 87
    return-void
.end method

.method public setDependedOn(Z)V
    .locals 1
    .param p1, "dependedOn"    # Z

    .prologue
    .line 101
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0, p1}, Ldagger/internal/Binding;->setDependedOn(Z)V

    .line 102
    return-void
.end method

.method public setLibrary(Z)V
    .locals 1
    .param p1, "library"    # Z

    .prologue
    .line 91
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0, p1}, Ldagger/internal/Binding;->setLibrary(Z)V

    .line 92
    return-void
.end method

.method setLinked()V
    .locals 1

    .prologue
    .line 56
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->setLinked()V

    .line 57
    return-void
.end method

.method public setVisiting(Z)V
    .locals 1
    .param p1, "visiting"    # Z

    .prologue
    .line 76
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0, p1}, Ldagger/internal/Binding;->setVisiting(Z)V

    .line 77
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    .local p0, "this":Ldagger/internal/BindingWrapper;, "Ldagger/internal/BindingWrapper<TT;>;"
    iget-object v0, p0, Ldagger/internal/BindingWrapper;->mBinding:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
