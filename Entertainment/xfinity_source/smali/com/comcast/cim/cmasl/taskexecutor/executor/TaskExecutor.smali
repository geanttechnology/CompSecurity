.class public interface abstract Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
.super Ljava/lang/Object;
.source "TaskExecutor.java"


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
.method public abstract cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<TT;>;)V"
        }
    .end annotation
.end method

.method public abstract execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<",
            "L::Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<TT;>;>(T",
            "L;",
            ")T",
            "L;"
        }
    .end annotation
.end method
