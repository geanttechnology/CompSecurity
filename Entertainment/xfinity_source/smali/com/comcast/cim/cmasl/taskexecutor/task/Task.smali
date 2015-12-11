.class public interface abstract Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
.super Ljava/lang/Object;
.source "Task.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract clearCachedResult()V
.end method

.method public abstract execute()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method

.method public abstract getCachedResultIfAvailable()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method

.method public abstract getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method

.method public abstract getStaleResultIfAvailable()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method
