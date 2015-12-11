.class Lcom/stericson/RootTools/Executer$Worker;
.super Ljava/lang/Thread;
.source "Executer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/stericson/RootTools/Executer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Worker"
.end annotation


# instance fields
.field private commands:[Ljava/lang/String;

.field public exit:I

.field public finalResponse:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private result:Lcom/stericson/RootTools/IResult;

.field private sleepTime:I

.field private useRoot:Z


# direct methods
.method private constructor <init>([Ljava/lang/String;ILcom/stericson/RootTools/IResult;Z)V
    .locals 1
    .param p1, "commands"    # [Ljava/lang/String;
    .param p2, "sleepTime"    # I
    .param p3, "result"    # Lcom/stericson/RootTools/IResult;
    .param p4, "useRoot"    # Z

    .prologue
    .line 107
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 104
    const/16 v0, -0x38f

    iput v0, p0, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    .line 109
    iput-object p1, p0, Lcom/stericson/RootTools/Executer$Worker;->commands:[Ljava/lang/String;

    .line 110
    iput p2, p0, Lcom/stericson/RootTools/Executer$Worker;->sleepTime:I

    .line 111
    iput-object p3, p0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    .line 112
    iput-boolean p4, p0, Lcom/stericson/RootTools/Executer$Worker;->useRoot:Z

    .line 113
    return-void
.end method

.method synthetic constructor <init>([Ljava/lang/String;ILcom/stericson/RootTools/IResult;ZLcom/stericson/RootTools/Executer$Worker;)V
    .locals 0

    .prologue
    .line 107
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/stericson/RootTools/Executer$Worker;-><init>([Ljava/lang/String;ILcom/stericson/RootTools/IResult;Z)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 22

    .prologue
    .line 116
    const/4 v12, 0x0

    .line 117
    .local v12, "process":Ljava/lang/Process;
    const/4 v6, 0x0

    .line 118
    .local v6, "os":Ljava/io/DataOutputStream;
    const/4 v10, 0x0

    .line 119
    .local v10, "osRes":Ljava/io/InputStreamReader;
    const/4 v8, 0x0

    .line 122
    .local v8, "osErr":Ljava/io/InputStreamReader;
    :try_start_0
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Runtime;->gc()V

    .line 123
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v18

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/stericson/RootTools/Executer$Worker;->useRoot:Z

    move/from16 v17, v0

    if-eqz v17, :cond_7

    const-string v17, "su"

    :goto_0
    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/Runtime;->exec(Ljava/lang/String;)Ljava/lang/Process;

    move-result-object v12

    .line 124
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/stericson/RootTools/Executer$Worker;->useRoot:Z

    move/from16 v17, v0

    if-eqz v17, :cond_8

    const-string v17, "Using Root"

    :goto_1
    invoke-static/range {v17 .. v17}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 125
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    if-eqz v17, :cond_0

    .line 126
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v0, v12}, Lcom/stericson/RootTools/IResult;->setProcess(Ljava/lang/Process;)Lcom/stericson/RootTools/IResult;

    .line 129
    :cond_0
    new-instance v7, Ljava/io/DataOutputStream;

    invoke-virtual {v12}, Ljava/lang/Process;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-direct {v7, v0}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_e
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_b
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    .line 130
    .end local v6    # "os":Ljava/io/DataOutputStream;
    .local v7, "os":Ljava/io/DataOutputStream;
    :try_start_1
    new-instance v11, Ljava/io/InputStreamReader;

    invoke-virtual {v12}, Ljava/lang/Process;->getInputStream()Ljava/io/InputStream;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-direct {v11, v0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_f
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_c
    .catchall {:try_start_1 .. :try_end_1} :catchall_3

    .line 131
    .end local v10    # "osRes":Ljava/io/InputStreamReader;
    .local v11, "osRes":Ljava/io/InputStreamReader;
    :try_start_2
    new-instance v9, Ljava/io/InputStreamReader;

    invoke-virtual {v12}, Ljava/lang/Process;->getErrorStream()Ljava/io/InputStream;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-direct {v9, v0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_10
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_d
    .catchall {:try_start_2 .. :try_end_2} :catchall_4

    .line 132
    .end local v8    # "osErr":Ljava/io/InputStreamReader;
    .local v9, "osErr":Ljava/io/InputStreamReader;
    :try_start_3
    new-instance v13, Ljava/io/BufferedReader;

    invoke-direct {v13, v11}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 133
    .local v13, "reader":Ljava/io/BufferedReader;
    new-instance v14, Ljava/io/BufferedReader;

    invoke-direct {v14, v9}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 135
    .local v14, "reader_error":Ljava/io/BufferedReader;
    const/4 v15, 0x0

    .line 137
    .local v15, "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    if-nez v17, :cond_1

    .line 138
    new-instance v15, Ljava/util/LinkedList;

    .end local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {v15}, Ljava/util/LinkedList;-><init>()V
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 144
    .restart local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_1
    :try_start_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->commands:[Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v19, v0

    const/16 v17, 0x0

    :goto_2
    move/from16 v0, v17

    move/from16 v1, v19

    if-lt v0, v1, :cond_9

    .line 151
    const-string v17, "exit \n"

    move-object/from16 v0, v17

    invoke-virtual {v7, v0}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 152
    invoke-virtual {v7}, Ljava/io/DataOutputStream;->flush()V

    .line 154
    invoke-virtual {v13}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .line 155
    .local v4, "line":Ljava/lang/String;
    invoke-virtual {v14}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-object v5

    .line 157
    .local v5, "line_error":Ljava/lang/String;
    :goto_3
    if-nez v4, :cond_a

    .line 168
    :goto_4
    if-nez v5, :cond_10

    .line 187
    if-eqz v12, :cond_2

    .line 188
    :try_start_5
    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/stericson/RootTools/Executer$Worker;->finalResponse:Ljava/util/List;

    .line 189
    invoke-virtual {v12}, Ljava/lang/Process;->waitFor()I

    move-result v17

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    .line 190
    move-object/from16 v0, p0

    iget v0, v0, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    move/from16 v17, v0

    sput v17, Lcom/stericson/RootTools/RootTools;->lastExitCode:I

    .line 192
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    if-eqz v17, :cond_1d

    .line 193
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    move/from16 v18, v0

    invoke-interface/range {v17 .. v18}, Lcom/stericson/RootTools/IResult;->onComplete(I)V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 210
    .end local v4    # "line":Ljava/lang/String;
    .end local v5    # "line_error":Ljava/lang/String;
    :cond_2
    :goto_5
    if-eqz v12, :cond_3

    .line 214
    :try_start_6
    invoke-virtual {v12}, Ljava/lang/Process;->destroy()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_a

    .line 216
    :goto_6
    const/4 v12, 0x0

    .line 220
    :cond_3
    if-eqz v7, :cond_4

    .line 221
    :try_start_7
    invoke-virtual {v7}, Ljava/io/DataOutputStream;->flush()V

    .line 222
    invoke-virtual {v7}, Ljava/io/DataOutputStream;->close()V

    .line 224
    :cond_4
    if-eqz v11, :cond_5

    .line 225
    invoke-virtual {v11}, Ljava/io/InputStreamReader;->close()V

    .line 227
    :cond_5
    if-eqz v9, :cond_1e

    .line 228
    invoke-virtual {v9}, Ljava/io/InputStreamReader;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_6

    move-object v8, v9

    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v8    # "osErr":Ljava/io/InputStreamReader;
    move-object v10, v11

    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v10    # "osRes":Ljava/io/InputStreamReader;
    move-object v6, v7

    .line 236
    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v13    # "reader":Ljava/io/BufferedReader;
    .end local v14    # "reader_error":Ljava/io/BufferedReader;
    .end local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    :cond_6
    :goto_7
    return-void

    .line 123
    :cond_7
    :try_start_8
    const-string v17, "sh"

    goto/16 :goto_0

    .line 124
    :cond_8
    const-string v17, "Using sh"
    :try_end_8
    .catch Ljava/lang/InterruptedException; {:try_start_8 .. :try_end_8} :catch_e
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_b
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    goto/16 :goto_1

    .line 144
    .end local v6    # "os":Ljava/io/DataOutputStream;
    .end local v8    # "osErr":Ljava/io/InputStreamReader;
    .end local v10    # "osRes":Ljava/io/InputStreamReader;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v13    # "reader":Ljava/io/BufferedReader;
    .restart local v14    # "reader_error":Ljava/io/BufferedReader;
    .restart local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_9
    :try_start_9
    aget-object v16, v18, v17

    .line 145
    .local v16, "single":Ljava/lang/String;
    new-instance v20, Ljava/lang/StringBuilder;

    const-string v21, "Shell command: "

    invoke-direct/range {v20 .. v21}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v20

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-static/range {v20 .. v20}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 146
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v21

    invoke-direct/range {v20 .. v21}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v21, "\n"

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v7, v0}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 147
    invoke-virtual {v7}, Ljava/io/DataOutputStream;->flush()V

    .line 148
    move-object/from16 v0, p0

    iget v0, v0, Lcom/stericson/RootTools/Executer$Worker;->sleepTime:I

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-long v0, v0

    move-wide/from16 v20, v0

    invoke-static/range {v20 .. v21}, Ljava/lang/Thread;->sleep(J)V

    .line 144
    add-int/lit8 v17, v17, 0x1

    goto/16 :goto_2

    .line 158
    .end local v16    # "single":Ljava/lang/String;
    .restart local v4    # "line":Ljava/lang/String;
    .restart local v5    # "line_error":Ljava/lang/String;
    :cond_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    if-nez v17, :cond_b

    .line 159
    invoke-interface {v15, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 164
    :goto_8
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "input stream"

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 165
    invoke-virtual {v13}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_3

    .line 161
    :cond_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v0, v4}, Lcom/stericson/RootTools/IResult;->process(Ljava/lang/String;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_0
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    goto :goto_8

    .line 180
    .end local v4    # "line":Ljava/lang/String;
    .end local v5    # "line_error":Ljava/lang/String;
    :catch_0
    move-exception v3

    .line 182
    .local v3, "ex":Ljava/lang/Exception;
    :try_start_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    if-eqz v17, :cond_c

    .line 184
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v0, v3}, Lcom/stericson/RootTools/IResult;->onFailure(Ljava/lang/Exception;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 187
    :cond_c
    if-eqz v12, :cond_2

    .line 188
    :try_start_b
    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/stericson/RootTools/Executer$Worker;->finalResponse:Ljava/util/List;

    .line 189
    invoke-virtual {v12}, Ljava/lang/Process;->waitFor()I

    move-result v17

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    .line 190
    move-object/from16 v0, p0

    iget v0, v0, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    move/from16 v17, v0

    sput v17, Lcom/stericson/RootTools/RootTools;->lastExitCode:I

    .line 192
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    if-eqz v17, :cond_17

    .line 193
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    move/from16 v18, v0

    invoke-interface/range {v17 .. v18}, Lcom/stericson/RootTools/IResult;->onComplete(I)V
    :try_end_b
    .catch Ljava/lang/InterruptedException; {:try_start_b .. :try_end_b} :catch_1
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_3
    .catchall {:try_start_b .. :try_end_b} :catchall_1

    goto/16 :goto_5

    .line 200
    .end local v3    # "ex":Ljava/lang/Exception;
    .end local v13    # "reader":Ljava/io/BufferedReader;
    .end local v14    # "reader_error":Ljava/io/BufferedReader;
    .end local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_1
    move-exception v17

    move-object v8, v9

    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v8    # "osErr":Ljava/io/InputStreamReader;
    move-object v10, v11

    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v10    # "osRes":Ljava/io/InputStreamReader;
    move-object v6, v7

    .line 210
    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    :goto_9
    if-eqz v12, :cond_d

    .line 214
    :try_start_c
    invoke-virtual {v12}, Ljava/lang/Process;->destroy()V
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_7

    .line 216
    :goto_a
    const/4 v12, 0x0

    .line 220
    :cond_d
    if-eqz v6, :cond_e

    .line 221
    :try_start_d
    invoke-virtual {v6}, Ljava/io/DataOutputStream;->flush()V

    .line 222
    invoke-virtual {v6}, Ljava/io/DataOutputStream;->close()V

    .line 224
    :cond_e
    if-eqz v10, :cond_f

    .line 225
    invoke-virtual {v10}, Ljava/io/InputStreamReader;->close()V

    .line 227
    :cond_f
    if-eqz v8, :cond_6

    .line 228
    invoke-virtual {v8}, Ljava/io/InputStreamReader;->close()V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_2

    goto/16 :goto_7

    .line 230
    :catch_2
    move-exception v2

    .line 231
    .local v2, "e":Ljava/lang/Exception;
    sget-boolean v17, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v17, :cond_6

    .line 232
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Error: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    goto/16 :goto_7

    .line 169
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v6    # "os":Ljava/io/DataOutputStream;
    .end local v8    # "osErr":Ljava/io/InputStreamReader;
    .end local v10    # "osRes":Ljava/io/InputStreamReader;
    .restart local v4    # "line":Ljava/lang/String;
    .restart local v5    # "line_error":Ljava/lang/String;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v13    # "reader":Ljava/io/BufferedReader;
    .restart local v14    # "reader_error":Ljava/io/BufferedReader;
    .restart local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_10
    :try_start_e
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    if-nez v17, :cond_11

    .line 170
    invoke-interface {v15, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 175
    :goto_b
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "error stream: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 176
    invoke-virtual {v14}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_4

    .line 172
    :cond_11
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v0, v5}, Lcom/stericson/RootTools/IResult;->processError(Ljava/lang/String;)V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_0
    .catchall {:try_start_e .. :try_end_e} :catchall_0

    goto :goto_b

    .line 186
    .end local v4    # "line":Ljava/lang/String;
    .end local v5    # "line_error":Ljava/lang/String;
    :catchall_0
    move-exception v17

    .line 187
    if-eqz v12, :cond_12

    .line 188
    :try_start_f
    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/stericson/RootTools/Executer$Worker;->finalResponse:Ljava/util/List;

    .line 189
    invoke-virtual {v12}, Ljava/lang/Process;->waitFor()I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    .line 190
    move-object/from16 v0, p0

    iget v0, v0, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    move/from16 v18, v0

    sput v18, Lcom/stericson/RootTools/RootTools;->lastExitCode:I

    .line 192
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v18, v0

    if-eqz v18, :cond_1c

    .line 193
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/Executer$Worker;->result:Lcom/stericson/RootTools/IResult;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    move/from16 v19, v0

    invoke-interface/range {v18 .. v19}, Lcom/stericson/RootTools/IResult;->onComplete(I)V

    .line 198
    :cond_12
    :goto_c
    throw v17
    :try_end_f
    .catch Ljava/lang/InterruptedException; {:try_start_f .. :try_end_f} :catch_1
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_3
    .catchall {:try_start_f .. :try_end_f} :catchall_1

    .line 204
    .end local v13    # "reader":Ljava/io/BufferedReader;
    .end local v14    # "reader_error":Ljava/io/BufferedReader;
    .end local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_3
    move-exception v2

    move-object v8, v9

    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v8    # "osErr":Ljava/io/InputStreamReader;
    move-object v10, v11

    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v10    # "osRes":Ljava/io/InputStreamReader;
    move-object v6, v7

    .line 205
    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v2    # "e":Ljava/lang/Exception;
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    :goto_d
    :try_start_10
    sget-boolean v17, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v17, :cond_13

    .line 206
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Error: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_2

    .line 210
    :cond_13
    if-eqz v12, :cond_14

    .line 214
    :try_start_11
    invoke-virtual {v12}, Ljava/lang/Process;->destroy()V
    :try_end_11
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_11} :catch_8

    .line 216
    :goto_e
    const/4 v12, 0x0

    .line 220
    :cond_14
    if-eqz v6, :cond_15

    .line 221
    :try_start_12
    invoke-virtual {v6}, Ljava/io/DataOutputStream;->flush()V

    .line 222
    invoke-virtual {v6}, Ljava/io/DataOutputStream;->close()V

    .line 224
    :cond_15
    if-eqz v10, :cond_16

    .line 225
    invoke-virtual {v10}, Ljava/io/InputStreamReader;->close()V

    .line 227
    :cond_16
    if-eqz v8, :cond_6

    .line 228
    invoke-virtual {v8}, Ljava/io/InputStreamReader;->close()V
    :try_end_12
    .catch Ljava/lang/Exception; {:try_start_12 .. :try_end_12} :catch_4

    goto/16 :goto_7

    .line 230
    :catch_4
    move-exception v2

    .line 231
    sget-boolean v17, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v17, :cond_6

    .line 232
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Error: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    goto/16 :goto_7

    .line 195
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v6    # "os":Ljava/io/DataOutputStream;
    .end local v8    # "osErr":Ljava/io/InputStreamReader;
    .end local v10    # "osRes":Ljava/io/InputStreamReader;
    .restart local v3    # "ex":Ljava/lang/Exception;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v13    # "reader":Ljava/io/BufferedReader;
    .restart local v14    # "reader_error":Ljava/io/BufferedReader;
    .restart local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_17
    :try_start_13
    move-object/from16 v0, p0

    iget v0, v0, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-interface {v15, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_13
    .catch Ljava/lang/InterruptedException; {:try_start_13 .. :try_end_13} :catch_1
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_13} :catch_3
    .catchall {:try_start_13 .. :try_end_13} :catchall_1

    goto/16 :goto_5

    .line 208
    .end local v3    # "ex":Ljava/lang/Exception;
    .end local v13    # "reader":Ljava/io/BufferedReader;
    .end local v14    # "reader_error":Ljava/io/BufferedReader;
    .end local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catchall_1
    move-exception v17

    move-object v8, v9

    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v8    # "osErr":Ljava/io/InputStreamReader;
    move-object v10, v11

    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v10    # "osRes":Ljava/io/InputStreamReader;
    move-object v6, v7

    .line 210
    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    :goto_f
    if-eqz v12, :cond_18

    .line 214
    :try_start_14
    invoke-virtual {v12}, Ljava/lang/Process;->destroy()V
    :try_end_14
    .catch Ljava/lang/Exception; {:try_start_14 .. :try_end_14} :catch_9

    .line 216
    :goto_10
    const/4 v12, 0x0

    .line 220
    :cond_18
    if-eqz v6, :cond_19

    .line 221
    :try_start_15
    invoke-virtual {v6}, Ljava/io/DataOutputStream;->flush()V

    .line 222
    invoke-virtual {v6}, Ljava/io/DataOutputStream;->close()V

    .line 224
    :cond_19
    if-eqz v10, :cond_1a

    .line 225
    invoke-virtual {v10}, Ljava/io/InputStreamReader;->close()V

    .line 227
    :cond_1a
    if-eqz v8, :cond_1b

    .line 228
    invoke-virtual {v8}, Ljava/io/InputStreamReader;->close()V
    :try_end_15
    .catch Ljava/lang/Exception; {:try_start_15 .. :try_end_15} :catch_5

    .line 235
    :cond_1b
    :goto_11
    throw v17

    .line 195
    .end local v6    # "os":Ljava/io/DataOutputStream;
    .end local v8    # "osErr":Ljava/io/InputStreamReader;
    .end local v10    # "osRes":Ljava/io/InputStreamReader;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v13    # "reader":Ljava/io/BufferedReader;
    .restart local v14    # "reader_error":Ljava/io/BufferedReader;
    .restart local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_1c
    :try_start_16
    move-object/from16 v0, p0

    iget v0, v0, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    move/from16 v18, v0

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-interface {v15, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_c

    .restart local v4    # "line":Ljava/lang/String;
    .restart local v5    # "line_error":Ljava/lang/String;
    :cond_1d
    move-object/from16 v0, p0

    iget v0, v0, Lcom/stericson/RootTools/Executer$Worker;->exit:I

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-interface {v15, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_16
    .catch Ljava/lang/InterruptedException; {:try_start_16 .. :try_end_16} :catch_1
    .catch Ljava/lang/Exception; {:try_start_16 .. :try_end_16} :catch_3
    .catchall {:try_start_16 .. :try_end_16} :catchall_1

    goto/16 :goto_5

    .line 230
    .end local v4    # "line":Ljava/lang/String;
    .end local v5    # "line_error":Ljava/lang/String;
    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .end local v13    # "reader":Ljava/io/BufferedReader;
    .end local v14    # "reader_error":Ljava/io/BufferedReader;
    .end local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    .restart local v8    # "osErr":Ljava/io/InputStreamReader;
    .restart local v10    # "osRes":Ljava/io/InputStreamReader;
    :catch_5
    move-exception v2

    .line 231
    .restart local v2    # "e":Ljava/lang/Exception;
    sget-boolean v18, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v18, :cond_1b

    .line 232
    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "Error: "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    goto :goto_11

    .line 230
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v6    # "os":Ljava/io/DataOutputStream;
    .end local v8    # "osErr":Ljava/io/InputStreamReader;
    .end local v10    # "osRes":Ljava/io/InputStreamReader;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v13    # "reader":Ljava/io/BufferedReader;
    .restart local v14    # "reader_error":Ljava/io/BufferedReader;
    .restart local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_6
    move-exception v2

    .line 231
    .restart local v2    # "e":Ljava/lang/Exception;
    sget-boolean v17, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v17, :cond_1e

    .line 232
    new-instance v17, Ljava/lang/StringBuilder;

    const-string v18, "Error: "

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .end local v2    # "e":Ljava/lang/Exception;
    :cond_1e
    move-object v8, v9

    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v8    # "osErr":Ljava/io/InputStreamReader;
    move-object v10, v11

    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v10    # "osRes":Ljava/io/InputStreamReader;
    move-object v6, v7

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_7

    .line 215
    .end local v13    # "reader":Ljava/io/BufferedReader;
    .end local v14    # "reader_error":Ljava/io/BufferedReader;
    .end local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_7
    move-exception v17

    goto/16 :goto_a

    .restart local v2    # "e":Ljava/lang/Exception;
    :catch_8
    move-exception v17

    goto/16 :goto_e

    .end local v2    # "e":Ljava/lang/Exception;
    :catch_9
    move-exception v18

    goto :goto_10

    .end local v6    # "os":Ljava/io/DataOutputStream;
    .end local v8    # "osErr":Ljava/io/InputStreamReader;
    .end local v10    # "osRes":Ljava/io/InputStreamReader;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v13    # "reader":Ljava/io/BufferedReader;
    .restart local v14    # "reader_error":Ljava/io/BufferedReader;
    .restart local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_a
    move-exception v17

    goto/16 :goto_6

    .line 208
    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .end local v13    # "reader":Ljava/io/BufferedReader;
    .end local v14    # "reader_error":Ljava/io/BufferedReader;
    .end local v15    # "response":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    .restart local v8    # "osErr":Ljava/io/InputStreamReader;
    .restart local v10    # "osRes":Ljava/io/InputStreamReader;
    :catchall_2
    move-exception v17

    goto/16 :goto_f

    .end local v6    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    :catchall_3
    move-exception v17

    move-object v6, v7

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_f

    .end local v6    # "os":Ljava/io/DataOutputStream;
    .end local v10    # "osRes":Ljava/io/InputStreamReader;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    :catchall_4
    move-exception v17

    move-object v10, v11

    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v10    # "osRes":Ljava/io/InputStreamReader;
    move-object v6, v7

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_f

    .line 204
    :catch_b
    move-exception v2

    goto/16 :goto_d

    .end local v6    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    :catch_c
    move-exception v2

    move-object v6, v7

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_d

    .end local v6    # "os":Ljava/io/DataOutputStream;
    .end local v10    # "osRes":Ljava/io/InputStreamReader;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    :catch_d
    move-exception v2

    move-object v10, v11

    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v10    # "osRes":Ljava/io/InputStreamReader;
    move-object v6, v7

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_d

    .line 200
    :catch_e
    move-exception v17

    goto/16 :goto_9

    .end local v6    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    :catch_f
    move-exception v17

    move-object v6, v7

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_9

    .end local v6    # "os":Ljava/io/DataOutputStream;
    .end local v10    # "osRes":Ljava/io/InputStreamReader;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    :catch_10
    move-exception v17

    move-object v10, v11

    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v10    # "osRes":Ljava/io/InputStreamReader;
    move-object v6, v7

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v6    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_9
.end method
