.class Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;
.super Ljava/lang/Thread;
.source "SanityCheckRootTools.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/stericson/RootTools/SanityCheckRootTools;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SanityCheckThread"
.end annotation


# instance fields
.field private mHandler:Landroid/os/Handler;

.field final synthetic this$0:Lcom/stericson/RootTools/SanityCheckRootTools;


# direct methods
.method public constructor <init>(Lcom/stericson/RootTools/SanityCheckRootTools;Landroid/content/Context;Landroid/os/Handler;)V
    .locals 0
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "handler"    # Landroid/os/Handler;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->this$0:Lcom/stericson/RootTools/SanityCheckRootTools;

    .line 97
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 98
    iput-object p3, p0, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->mHandler:Landroid/os/Handler;

    return-void
.end method

.method static synthetic access$0(Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 229
    invoke-direct {p0, p1, p2}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    return-void
.end method

.method private visualUpdate(ILjava/lang/String;)V
    .locals 3
    .param p1, "action"    # I
    .param p2, "text"    # Ljava/lang/String;

    .prologue
    .line 230
    iget-object v2, p0, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v1

    .line 231
    .local v1, "msg":Landroid/os/Message;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 232
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v2, "action"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 233
    const-string v2, "text"

    invoke-virtual {v0, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 234
    invoke-virtual {v1, v0}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    .line 235
    iget-object v2, p0, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 236
    return-void
.end method


# virtual methods
.method public run()V
    .locals 14

    .prologue
    const/4 v13, 0x0

    const/4 v7, 0x1

    const/4 v12, 0x4

    const/4 v9, 0x3

    const/4 v11, 0x2

    .line 102
    invoke-direct {p0, v7, v13}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    .line 114
    const-string v7, "Testing df"

    invoke-direct {p0, v12, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    .line 115
    const-string v7, "/data"

    invoke-static {v7}, Lcom/stericson/RootTools/RootTools;->getSpace(Ljava/lang/String;)J

    move-result-wide v5

    .line 116
    .local v5, "spaceValue":J
    const-string v7, "[ Checking /data partition size]\n"

    invoke-direct {p0, v9, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    .line 117
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v5, v6}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, "k\n\n"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v9, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    .line 119
    const-string v7, "Testing sendShell() w/ return array"

    invoke-direct {p0, v12, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    .line 121
    :try_start_0
    const-string v7, "ls /"

    sget v8, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-static {v7, v8}, Lcom/stericson/RootTools/RootTools;->sendShell(Ljava/lang/String;I)Ljava/util/List;

    move-result-object v2

    .line 122
    .local v2, "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v7, 0x3

    const-string v8, "[ Listing of / (passing a List)]\n"

    invoke-direct {p0, v7, v8}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    .line 123
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/stericson/RootTools/RootToolsException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_2

    move-result v8

    if-nez v8, :cond_1

    .line 137
    const-string v7, "Testing sendShell() w/ callbacks"

    invoke-direct {p0, v12, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    .line 139
    const/4 v7, 0x3

    :try_start_1
    const-string v8, "\n[ Listing of / (callback)]\n"

    invoke-direct {p0, v7, v8}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    .line 140
    new-instance v3, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread$1;

    invoke-direct {v3, p0}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread$1;-><init>(Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;)V

    .line 162
    .local v3, "result":Lcom/stericson/RootTools/RootTools$Result;
    const-string v7, "ls /"

    sget v8, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-static {v7, v3, v8}, Lcom/stericson/RootTools/RootTools;->sendShell(Ljava/lang/String;Lcom/stericson/RootTools/RootTools$Result;I)Ljava/util/List;

    .line 163
    invoke-virtual {v3}, Lcom/stericson/RootTools/RootTools$Result;->getError()I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Lcom/stericson/RootTools/RootToolsException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_5

    move-result v7

    if-eqz v7, :cond_2

    .line 227
    .end local v2    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v3    # "result":Lcom/stericson/RootTools/RootTools$Result;
    :cond_0
    :goto_1
    return-void

    .line 123
    .restart local v2    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_1
    :try_start_2
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 124
    .local v1, "line":Ljava/lang/String;
    const/4 v8, 0x3

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "\n"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {p0, v8, v9}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lcom/stericson/RootTools/RootToolsException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_0

    .line 126
    .end local v1    # "line":Ljava/lang/String;
    .end local v2    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_0
    move-exception v0

    .line 127
    .local v0, "e":Ljava/io/IOException;
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "ERROR: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v11, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    goto :goto_1

    .line 129
    .end local v0    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 130
    .local v0, "e":Lcom/stericson/RootTools/RootToolsException;
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "DEV-DEFINED ERROR: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v11, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    goto :goto_1

    .line 132
    .end local v0    # "e":Lcom/stericson/RootTools/RootToolsException;
    :catch_2
    move-exception v0

    .line 133
    .local v0, "e":Ljava/util/concurrent/TimeoutException;
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "Timeout.. "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v11, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    goto :goto_1

    .line 165
    .end local v0    # "e":Ljava/util/concurrent/TimeoutException;
    .restart local v2    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_3
    move-exception v0

    .line 166
    .local v0, "e":Ljava/io/IOException;
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "ERROR: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v11, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    goto :goto_1

    .line 168
    .end local v0    # "e":Ljava/io/IOException;
    :catch_4
    move-exception v0

    .line 169
    .local v0, "e":Lcom/stericson/RootTools/RootToolsException;
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "DEV-DEFINED ERROR: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v11, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    goto/16 :goto_1

    .line 171
    .end local v0    # "e":Lcom/stericson/RootTools/RootToolsException;
    :catch_5
    move-exception v0

    .line 172
    .local v0, "e":Ljava/util/concurrent/TimeoutException;
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "Timeout.. "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v11, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    goto/16 :goto_1

    .line 176
    .end local v0    # "e":Ljava/util/concurrent/TimeoutException;
    .restart local v3    # "result":Lcom/stericson/RootTools/RootTools$Result;
    :cond_2
    const-string v7, "Testing sendShell() for multiple commands"

    invoke-direct {p0, v12, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    .line 178
    const/4 v7, 0x3

    :try_start_3
    const-string v8, "\n[ ps + ls + date / (callback)]\n"

    invoke-direct {p0, v7, v8}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    .line 179
    new-instance v4, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread$2;

    invoke-direct {v4, p0}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread$2;-><init>(Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_6
    .catch Lcom/stericson/RootTools/RootToolsException; {:try_start_3 .. :try_end_3} :catch_7
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_3 .. :try_end_3} :catch_8

    .line 203
    .end local v3    # "result":Lcom/stericson/RootTools/RootTools$Result;
    .local v4, "result":Lcom/stericson/RootTools/RootTools$Result;
    const/4 v7, 0x6

    :try_start_4
    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    .line 204
    const-string v9, "echo \"* PS:\""

    aput-object v9, v7, v8

    const/4 v8, 0x1

    .line 205
    const-string v9, "ps"

    aput-object v9, v7, v8

    const/4 v8, 0x2

    .line 206
    const-string v9, "echo \"* LS:\""

    aput-object v9, v7, v8

    const/4 v8, 0x3

    .line 207
    const-string v9, "ls"

    aput-object v9, v7, v8

    const/4 v8, 0x4

    .line 208
    const-string v9, "echo \"* DATE:\""

    aput-object v9, v7, v8

    const/4 v8, 0x5

    .line 209
    const-string v9, "date"

    aput-object v9, v7, v8

    .line 210
    const/16 v8, 0x7d0

    .line 212
    sget v9, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    .line 202
    invoke-static {v7, v8, v4, v9}, Lcom/stericson/RootTools/RootTools;->sendShell([Ljava/lang/String;ILcom/stericson/RootTools/RootTools$Result;I)Ljava/util/List;

    .line 214
    invoke-virtual {v4}, Lcom/stericson/RootTools/RootTools$Result;->getError()I
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_b
    .catch Lcom/stericson/RootTools/RootToolsException; {:try_start_4 .. :try_end_4} :catch_a
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_4 .. :try_end_4} :catch_9

    move-result v7

    if-nez v7, :cond_0

    .line 225
    .end local v4    # "result":Lcom/stericson/RootTools/RootTools$Result;
    :goto_2
    const-string v7, "All tests complete."

    invoke-direct {p0, v12, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    .line 226
    invoke-direct {p0, v11, v13}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    goto/16 :goto_1

    .line 216
    .restart local v3    # "result":Lcom/stericson/RootTools/RootTools$Result;
    :catch_6
    move-exception v0

    .line 217
    .local v0, "e":Ljava/io/IOException;
    :goto_3
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "ERROR: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v11, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    goto :goto_2

    .line 218
    .end local v0    # "e":Ljava/io/IOException;
    :catch_7
    move-exception v0

    .line 219
    .local v0, "e":Lcom/stericson/RootTools/RootToolsException;
    :goto_4
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "DEV-DEFINED ERROR: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v11, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    goto :goto_2

    .line 220
    .end local v0    # "e":Lcom/stericson/RootTools/RootToolsException;
    :catch_8
    move-exception v0

    .line 221
    .local v0, "e":Ljava/util/concurrent/TimeoutException;
    :goto_5
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "Timeout.. "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v11, v7}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->visualUpdate(ILjava/lang/String;)V

    goto/16 :goto_1

    .line 220
    .end local v0    # "e":Ljava/util/concurrent/TimeoutException;
    .end local v3    # "result":Lcom/stericson/RootTools/RootTools$Result;
    .restart local v4    # "result":Lcom/stericson/RootTools/RootTools$Result;
    :catch_9
    move-exception v0

    move-object v3, v4

    .end local v4    # "result":Lcom/stericson/RootTools/RootTools$Result;
    .restart local v3    # "result":Lcom/stericson/RootTools/RootTools$Result;
    goto :goto_5

    .line 218
    .end local v3    # "result":Lcom/stericson/RootTools/RootTools$Result;
    .restart local v4    # "result":Lcom/stericson/RootTools/RootTools$Result;
    :catch_a
    move-exception v0

    move-object v3, v4

    .end local v4    # "result":Lcom/stericson/RootTools/RootTools$Result;
    .restart local v3    # "result":Lcom/stericson/RootTools/RootTools$Result;
    goto :goto_4

    .line 216
    .end local v3    # "result":Lcom/stericson/RootTools/RootTools$Result;
    .restart local v4    # "result":Lcom/stericson/RootTools/RootTools$Result;
    :catch_b
    move-exception v0

    move-object v3, v4

    .end local v4    # "result":Lcom/stericson/RootTools/RootTools$Result;
    .restart local v3    # "result":Lcom/stericson/RootTools/RootTools$Result;
    goto :goto_3
.end method
