.class public interface abstract Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
.super Ljava/lang/Object;
.source "TaskExecutionListener.java"


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
.method public abstract onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
.end method

.method public abstract onPostExecute(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method public abstract onPreAsynchronousExecute()V
.end method

.method public abstract onStaleResultAvailable(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method
