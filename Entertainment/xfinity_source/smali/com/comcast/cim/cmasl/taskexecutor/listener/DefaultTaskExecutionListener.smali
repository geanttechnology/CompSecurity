.class public abstract Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.super Ljava/lang/Object;
.source "DefaultTaskExecutionListener.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreAsynchronousExecute()V
    .locals 0

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener<TT;>;"
    return-void
.end method

.method public onStaleResultAvailable(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener<TT;>;"
    .local p1, "result":Ljava/lang/Object;, "TT;"
    return-void
.end method
