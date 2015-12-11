.class public Lcom/stericson/RootTools/Executer;
.super Ljava/lang/Object;
.source "Executer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/stericson/RootTools/Executer$Worker;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public sendShell([Ljava/lang/String;ILcom/stericson/RootTools/IResult;ZI)Ljava/util/List;
    .locals 7
    .param p1, "commands"    # [Ljava/lang/String;
    .param p2, "sleepTime"    # I
    .param p3, "result"    # Lcom/stericson/RootTools/IResult;
    .param p4, "useRoot"    # Z
    .param p5, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "I",
            "Lcom/stericson/RootTools/IResult;",
            "ZI)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/stericson/RootTools/RootToolsException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 66
    sget-object v2, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "Sending "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    array-length v3, p1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 67
    const-string v3, " shell command"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    array-length v1, p1

    const/4 v4, 0x1

    if-le v1, v4, :cond_1

    const-string v1, "s"

    :goto_0
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 66
    invoke-static {v2, v1}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    new-instance v0, Lcom/stericson/RootTools/Executer$Worker;

    const/4 v5, 0x0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    invoke-direct/range {v0 .. v5}, Lcom/stericson/RootTools/Executer$Worker;-><init>([Ljava/lang/String;ILcom/stericson/RootTools/IResult;ZLcom/stericson/RootTools/Executer$Worker;)V

    .line 70
    .local v0, "worker":Lcom/stericson/RootTools/Executer$Worker;
    invoke-virtual {v0}, Lcom/stericson/RootTools/Executer$Worker;->start()V

    .line 74
    const/4 v1, -0x1

    if-ne p5, v1, :cond_0

    .line 76
    const p5, 0x493e0

    .line 79
    :cond_0
    int-to-long v1, p5

    :try_start_0
    invoke-virtual {v0, v1, v2}, Lcom/stericson/RootTools/Executer$Worker;->join(J)V

    .line 82
    sget v1, Lcom/stericson/RootTools/RootTools;->shellDelay:I

    int-to-long v1, v1

    invoke-static {v1, v2}, Ljava/lang/Thread;->sleep(J)V

    .line 84
    iget v1, v0, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    const/16 v2, -0x38f

    if-eq v1, v2, :cond_2

    .line 85
    iget-object v1, v0, Lcom/stericson/RootTools/Executer$Worker;->finalResponse:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 67
    .end local v0    # "worker":Lcom/stericson/RootTools/Executer$Worker;
    :cond_1
    const-string v1, ""

    goto :goto_0

    .line 87
    .restart local v0    # "worker":Lcom/stericson/RootTools/Executer$Worker;
    :cond_2
    :try_start_1
    new-instance v1, Ljava/util/concurrent/TimeoutException;

    invoke-direct {v1}, Ljava/util/concurrent/TimeoutException;-><init>()V

    throw v1
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0

    .line 89
    :catch_0
    move-exception v6

    .line 91
    .local v6, "ex":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Lcom/stericson/RootTools/Executer$Worker;->interrupt()V

    .line 92
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->interrupt()V

    .line 93
    new-instance v1, Ljava/util/concurrent/TimeoutException;

    invoke-direct {v1}, Ljava/util/concurrent/TimeoutException;-><init>()V

    throw v1
.end method
