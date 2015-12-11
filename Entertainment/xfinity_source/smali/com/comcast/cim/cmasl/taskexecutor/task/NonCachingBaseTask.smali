.class public abstract Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;
.source "NonCachingBaseTask.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask<TT;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 1

    .prologue
    .line 26
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask<TT;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 11
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method
