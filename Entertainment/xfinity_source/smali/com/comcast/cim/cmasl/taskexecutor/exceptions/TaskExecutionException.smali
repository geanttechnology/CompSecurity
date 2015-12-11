.class public Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;
.super Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
.source "TaskExecutionException.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>()V

    .line 8
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    .line 20
    return-void
.end method
