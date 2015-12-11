.class Lcom/stericson/RootTools/InternalMethods$Worker;
.super Ljava/lang/Thread;
.source "InternalMethods.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/stericson/RootTools/InternalMethods;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Worker"
.end annotation


# instance fields
.field private commands:[Ljava/lang/String;

.field public exit:I


# direct methods
.method private constructor <init>([Ljava/lang/String;)V
    .locals 1
    .param p1, "commands"    # [Ljava/lang/String;

    .prologue
    .line 259
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 257
    const/16 v0, -0x38f

    iput v0, p0, Lcom/stericson/RootTools/InternalMethods$Worker;->exit:I

    .line 261
    iput-object p1, p0, Lcom/stericson/RootTools/InternalMethods$Worker;->commands:[Ljava/lang/String;

    .line 262
    return-void
.end method

.method synthetic constructor <init>([Ljava/lang/String;Lcom/stericson/RootTools/InternalMethods$Worker;)V
    .locals 0

    .prologue
    .line 259
    invoke-direct {p0, p1}, Lcom/stericson/RootTools/InternalMethods$Worker;-><init>([Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 23

    .prologue
    .line 265
    const/4 v13, 0x0

    .line 266
    .local v13, "process":Ljava/lang/Process;
    const/4 v7, 0x0

    .line 267
    .local v7, "os":Ljava/io/DataOutputStream;
    const/4 v11, 0x0

    .line 268
    .local v11, "osRes":Ljava/io/InputStreamReader;
    const/4 v9, 0x0

    .line 271
    .local v9, "osErr":Ljava/io/InputStreamReader;
    :try_start_0
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/Runtime;->gc()V

    .line 272
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v18

    const-string v19, "su"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/Runtime;->exec(Ljava/lang/String;)Ljava/lang/Process;

    move-result-object v13

    .line 273
    new-instance v8, Ljava/io/DataOutputStream;

    invoke-virtual {v13}, Ljava/lang/Process;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-direct {v8, v0}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_d
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 274
    .end local v7    # "os":Ljava/io/DataOutputStream;
    .local v8, "os":Ljava/io/DataOutputStream;
    :try_start_1
    new-instance v12, Ljava/io/InputStreamReader;

    invoke-virtual {v13}, Ljava/lang/Process;->getInputStream()Ljava/io/InputStream;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-direct {v12, v0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_e
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_a
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 275
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .local v12, "osRes":Ljava/io/InputStreamReader;
    :try_start_2
    new-instance v10, Ljava/io/InputStreamReader;

    invoke-virtual {v13}, Ljava/lang/Process;->getErrorStream()Ljava/io/InputStream;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-direct {v10, v0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_f
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_b
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 276
    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .local v10, "osErr":Ljava/io/InputStreamReader;
    :try_start_3
    new-instance v14, Ljava/io/BufferedReader;

    invoke-direct {v14, v12}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 277
    .local v14, "reader":Ljava/io/BufferedReader;
    new-instance v15, Ljava/io/BufferedReader;

    invoke-direct {v15, v10}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 280
    .local v15, "reader_err":Ljava/io/BufferedReader;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/InternalMethods$Worker;->commands:[Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    array-length v0, v0

    move/from16 v20, v0

    const/16 v18, 0x0

    :goto_0
    move/from16 v0, v18

    move/from16 v1, v20

    if-lt v0, v1, :cond_4

    .line 287
    const-string v18, "exit \n"

    move-object/from16 v0, v18

    invoke-virtual {v8, v0}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 288
    invoke-virtual {v8}, Ljava/io/DataOutputStream;->flush()V

    .line 290
    invoke-virtual {v14}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v5

    .line 291
    .local v5, "line":Ljava/lang/String;
    invoke-virtual {v15}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v6

    .line 293
    .local v6, "line_err":Ljava/lang/String;
    :goto_1
    if-nez v5, :cond_5

    .line 330
    :goto_2
    if-nez v6, :cond_f

    .line 337
    invoke-virtual {v13}, Ljava/lang/Process;->waitFor()I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/stericson/RootTools/InternalMethods$Worker;->exit:I
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_c
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    .line 350
    if-eqz v13, :cond_0

    .line 354
    :try_start_4
    invoke-virtual {v13}, Ljava/lang/Process;->destroy()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_9

    .line 356
    :goto_3
    const/4 v13, 0x0

    .line 360
    :cond_0
    if-eqz v8, :cond_1

    .line 361
    :try_start_5
    invoke-virtual {v8}, Ljava/io/DataOutputStream;->flush()V

    .line 362
    invoke-virtual {v8}, Ljava/io/DataOutputStream;->close()V

    .line 364
    :cond_1
    if-eqz v12, :cond_2

    .line 365
    invoke-virtual {v12}, Ljava/io/InputStreamReader;->close()V

    .line 367
    :cond_2
    if-eqz v10, :cond_18

    .line 368
    invoke-virtual {v10}, Ljava/io/InputStreamReader;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_5

    move-object v9, v10

    .end local v10    # "osErr":Ljava/io/InputStreamReader;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    move-object v11, v12

    .end local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    move-object v7, v8

    .line 377
    .end local v5    # "line":Ljava/lang/String;
    .end local v6    # "line_err":Ljava/lang/String;
    .end local v8    # "os":Ljava/io/DataOutputStream;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v15    # "reader_err":Ljava/io/BufferedReader;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    :cond_3
    :goto_4
    return-void

    .line 280
    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v10    # "osErr":Ljava/io/InputStreamReader;
    .restart local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v15    # "reader_err":Ljava/io/BufferedReader;
    :cond_4
    :try_start_6
    aget-object v16, v19, v18

    .line 281
    .local v16, "single":Ljava/lang/String;
    new-instance v21, Ljava/lang/StringBuilder;

    const-string v22, "Shell command: "

    invoke-direct/range {v21 .. v22}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v21

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v21 .. v21}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 282
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v22

    invoke-direct/range {v21 .. v22}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v22, "\n"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 283
    invoke-virtual {v8}, Ljava/io/DataOutputStream;->flush()V

    .line 280
    add-int/lit8 v18, v18, 0x1

    goto :goto_0

    .line 294
    .end local v16    # "single":Ljava/lang/String;
    .restart local v5    # "line":Ljava/lang/String;
    .restart local v6    # "line_err":Ljava/lang/String;
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/InternalMethods$Worker;->commands:[Ljava/lang/String;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aget-object v18, v18, v19

    const-string v19, "id"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_7

    .line 295
    new-instance v2, Ljava/util/HashSet;

    const-string v18, " "

    move-object/from16 v0, v18

    invoke-virtual {v5, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-direct {v2, v0}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 296
    .local v2, "ID":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v18

    :cond_6
    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->hasNext()Z

    move-result v19

    if-nez v19, :cond_b

    .line 303
    :goto_5
    sget-boolean v18, Lcom/stericson/RootTools/InternalVariables;->accessGiven:Z

    if-nez v18, :cond_7

    .line 304
    sget-object v18, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v19, "Access Denied?"

    invoke-static/range {v18 .. v19}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    .end local v2    # "ID":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/InternalMethods$Worker;->commands:[Ljava/lang/String;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aget-object v18, v18, v19

    const-string v19, "df"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_8

    .line 308
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/InternalMethods$Worker;->commands:[Ljava/lang/String;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aget-object v18, v18, v19

    const/16 v19, 0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/InternalMethods$Worker;->commands:[Ljava/lang/String;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    aget-object v20, v20, v21

    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->length()I

    move-result v20

    invoke-virtual/range {v18 .. v20}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v5, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v18

    if-eqz v18, :cond_8

    .line 309
    const-string v18, " "

    move-object/from16 v0, v18

    invoke-virtual {v5, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v18

    sput-object v18, Lcom/stericson/RootTools/InternalVariables;->space:[Ljava/lang/String;

    .line 312
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/InternalMethods$Worker;->commands:[Ljava/lang/String;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aget-object v18, v18, v19

    const-string v19, "busybox"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_9

    .line 313
    const-string v18, "BusyBox"

    move-object/from16 v0, v18

    invoke-virtual {v5, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_9

    .line 314
    const-string v18, " "

    move-object/from16 v0, v18

    invoke-virtual {v5, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v17

    .line 315
    .local v17, "temp":[Ljava/lang/String;
    const/16 v18, 0x1

    aget-object v18, v17, v18

    sput-object v18, Lcom/stericson/RootTools/InternalVariables;->busyboxVersion:Ljava/lang/String;

    .line 318
    .end local v17    # "temp":[Ljava/lang/String;
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/stericson/RootTools/InternalMethods$Worker;->commands:[Ljava/lang/String;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aget-object v18, v18, v19

    const-string v19, "busybox pidof"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_a

    .line 319
    const-string v18, ""

    move-object/from16 v0, v18

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-nez v18, :cond_a

    .line 320
    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "PID: "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 321
    sput-object v5, Lcom/stericson/RootTools/InternalVariables;->pid:Ljava/lang/String;

    .line 325
    :cond_a
    invoke-static {v5}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 327
    invoke-virtual {v14}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_1

    .line 296
    .restart local v2    # "ID":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_b
    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 297
    .local v4, "id":Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v19

    const-string v20, "uid=0"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v19

    if-eqz v19, :cond_6

    .line 298
    const/16 v18, 0x1

    sput-boolean v18, Lcom/stericson/RootTools/InternalVariables;->accessGiven:Z

    .line 299
    sget-object v18, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v19, "Access Given"

    invoke-static/range {v18 .. v19}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/InterruptedException; {:try_start_6 .. :try_end_6} :catch_0
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_c
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    goto/16 :goto_5

    .line 339
    .end local v2    # "ID":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v4    # "id":Ljava/lang/String;
    .end local v5    # "line":Ljava/lang/String;
    .end local v6    # "line_err":Ljava/lang/String;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v15    # "reader_err":Ljava/io/BufferedReader;
    :catch_0
    move-exception v18

    move-object v9, v10

    .end local v10    # "osErr":Ljava/io/InputStreamReader;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    move-object v11, v12

    .end local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    move-object v7, v8

    .line 350
    .end local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    :goto_6
    if-eqz v13, :cond_c

    .line 354
    :try_start_7
    invoke-virtual {v13}, Ljava/lang/Process;->destroy()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_6

    .line 356
    :goto_7
    const/4 v13, 0x0

    .line 360
    :cond_c
    if-eqz v7, :cond_d

    .line 361
    :try_start_8
    invoke-virtual {v7}, Ljava/io/DataOutputStream;->flush()V

    .line 362
    invoke-virtual {v7}, Ljava/io/DataOutputStream;->close()V

    .line 364
    :cond_d
    if-eqz v11, :cond_e

    .line 365
    invoke-virtual {v11}, Ljava/io/InputStreamReader;->close()V

    .line 367
    :cond_e
    if-eqz v9, :cond_3

    .line 368
    invoke-virtual {v9}, Ljava/io/InputStreamReader;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_1

    goto/16 :goto_4

    .line 370
    :catch_1
    move-exception v3

    .line 371
    .local v3, "e":Ljava/lang/Exception;
    sget-boolean v18, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v18, :cond_3

    .line 372
    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "Error: "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 373
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_4

    .line 332
    .end local v3    # "e":Ljava/lang/Exception;
    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v5    # "line":Ljava/lang/String;
    .restart local v6    # "line_err":Ljava/lang/String;
    .restart local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v10    # "osErr":Ljava/io/InputStreamReader;
    .restart local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v15    # "reader_err":Ljava/io/BufferedReader;
    :cond_f
    :try_start_9
    invoke-static {v6}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 334
    invoke-virtual {v15}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_9
    .catch Ljava/lang/InterruptedException; {:try_start_9 .. :try_end_9} :catch_0
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_c
    .catchall {:try_start_9 .. :try_end_9} :catchall_3

    move-result-object v6

    goto/16 :goto_2

    .line 343
    .end local v5    # "line":Ljava/lang/String;
    .end local v6    # "line_err":Ljava/lang/String;
    .end local v8    # "os":Ljava/io/DataOutputStream;
    .end local v10    # "osErr":Ljava/io/InputStreamReader;
    .end local v12    # "osRes":Ljava/io/InputStreamReader;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v15    # "reader_err":Ljava/io/BufferedReader;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    :catch_2
    move-exception v3

    .line 344
    .restart local v3    # "e":Ljava/lang/Exception;
    :goto_8
    :try_start_a
    sget-boolean v18, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v18, :cond_10

    .line 345
    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "Error: "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 346
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 350
    :cond_10
    if-eqz v13, :cond_11

    .line 354
    :try_start_b
    invoke-virtual {v13}, Ljava/lang/Process;->destroy()V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_7

    .line 356
    :goto_9
    const/4 v13, 0x0

    .line 360
    :cond_11
    if-eqz v7, :cond_12

    .line 361
    :try_start_c
    invoke-virtual {v7}, Ljava/io/DataOutputStream;->flush()V

    .line 362
    invoke-virtual {v7}, Ljava/io/DataOutputStream;->close()V

    .line 364
    :cond_12
    if-eqz v11, :cond_13

    .line 365
    invoke-virtual {v11}, Ljava/io/InputStreamReader;->close()V

    .line 367
    :cond_13
    if-eqz v9, :cond_3

    .line 368
    invoke-virtual {v9}, Ljava/io/InputStreamReader;->close()V
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_3

    goto/16 :goto_4

    .line 370
    :catch_3
    move-exception v3

    .line 371
    sget-boolean v18, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v18, :cond_3

    .line 372
    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "Error: "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 373
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_4

    .line 348
    .end local v3    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v18

    .line 350
    :goto_a
    if-eqz v13, :cond_14

    .line 354
    :try_start_d
    invoke-virtual {v13}, Ljava/lang/Process;->destroy()V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_8

    .line 356
    :goto_b
    const/4 v13, 0x0

    .line 360
    :cond_14
    if-eqz v7, :cond_15

    .line 361
    :try_start_e
    invoke-virtual {v7}, Ljava/io/DataOutputStream;->flush()V

    .line 362
    invoke-virtual {v7}, Ljava/io/DataOutputStream;->close()V

    .line 364
    :cond_15
    if-eqz v11, :cond_16

    .line 365
    invoke-virtual {v11}, Ljava/io/InputStreamReader;->close()V

    .line 367
    :cond_16
    if-eqz v9, :cond_17

    .line 368
    invoke-virtual {v9}, Ljava/io/InputStreamReader;->close()V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_4

    .line 376
    :cond_17
    :goto_c
    throw v18

    .line 370
    :catch_4
    move-exception v3

    .line 371
    .restart local v3    # "e":Ljava/lang/Exception;
    sget-boolean v19, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v19, :cond_17

    .line 372
    new-instance v19, Ljava/lang/StringBuilder;

    const-string v20, "Error: "

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v19 .. v19}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 373
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_c

    .line 370
    .end local v3    # "e":Ljava/lang/Exception;
    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v5    # "line":Ljava/lang/String;
    .restart local v6    # "line_err":Ljava/lang/String;
    .restart local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v10    # "osErr":Ljava/io/InputStreamReader;
    .restart local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v15    # "reader_err":Ljava/io/BufferedReader;
    :catch_5
    move-exception v3

    .line 371
    .restart local v3    # "e":Ljava/lang/Exception;
    sget-boolean v18, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v18, :cond_18

    .line 372
    new-instance v18, Ljava/lang/StringBuilder;

    const-string v19, "Error: "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 373
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    .end local v3    # "e":Ljava/lang/Exception;
    :cond_18
    move-object v9, v10

    .end local v10    # "osErr":Ljava/io/InputStreamReader;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    move-object v11, v12

    .end local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    move-object v7, v8

    .end local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_4

    .line 355
    .end local v5    # "line":Ljava/lang/String;
    .end local v6    # "line_err":Ljava/lang/String;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v15    # "reader_err":Ljava/io/BufferedReader;
    :catch_6
    move-exception v18

    goto/16 :goto_7

    .restart local v3    # "e":Ljava/lang/Exception;
    :catch_7
    move-exception v18

    goto/16 :goto_9

    .end local v3    # "e":Ljava/lang/Exception;
    :catch_8
    move-exception v19

    goto :goto_b

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v5    # "line":Ljava/lang/String;
    .restart local v6    # "line_err":Ljava/lang/String;
    .restart local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v10    # "osErr":Ljava/io/InputStreamReader;
    .restart local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v15    # "reader_err":Ljava/io/BufferedReader;
    :catch_9
    move-exception v18

    goto/16 :goto_3

    .line 348
    .end local v5    # "line":Ljava/lang/String;
    .end local v6    # "line_err":Ljava/lang/String;
    .end local v10    # "osErr":Ljava/io/InputStreamReader;
    .end local v12    # "osRes":Ljava/io/InputStreamReader;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v15    # "reader_err":Ljava/io/BufferedReader;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    :catchall_1
    move-exception v18

    move-object v7, v8

    .end local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    goto :goto_a

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v12    # "osRes":Ljava/io/InputStreamReader;
    :catchall_2
    move-exception v18

    move-object v11, v12

    .end local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    move-object v7, v8

    .end local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    goto :goto_a

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v10    # "osErr":Ljava/io/InputStreamReader;
    .restart local v12    # "osRes":Ljava/io/InputStreamReader;
    :catchall_3
    move-exception v18

    move-object v9, v10

    .end local v10    # "osErr":Ljava/io/InputStreamReader;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    move-object v11, v12

    .end local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    move-object v7, v8

    .end local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    goto :goto_a

    .line 343
    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v8    # "os":Ljava/io/DataOutputStream;
    :catch_a
    move-exception v3

    move-object v7, v8

    .end local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_8

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v12    # "osRes":Ljava/io/InputStreamReader;
    :catch_b
    move-exception v3

    move-object v11, v12

    .end local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    move-object v7, v8

    .end local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_8

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v9    # "osErr":Ljava/io/InputStreamReader;
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v10    # "osErr":Ljava/io/InputStreamReader;
    .restart local v12    # "osRes":Ljava/io/InputStreamReader;
    :catch_c
    move-exception v3

    move-object v9, v10

    .end local v10    # "osErr":Ljava/io/InputStreamReader;
    .restart local v9    # "osErr":Ljava/io/InputStreamReader;
    move-object v11, v12

    .end local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    move-object v7, v8

    .end local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_8

    .line 339
    :catch_d
    move-exception v18

    goto/16 :goto_6

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .restart local v8    # "os":Ljava/io/DataOutputStream;
    :catch_e
    move-exception v18

    move-object v7, v8

    .end local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_6

    .end local v7    # "os":Ljava/io/DataOutputStream;
    .end local v11    # "osRes":Ljava/io/InputStreamReader;
    .restart local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v12    # "osRes":Ljava/io/InputStreamReader;
    :catch_f
    move-exception v18

    move-object v11, v12

    .end local v12    # "osRes":Ljava/io/InputStreamReader;
    .restart local v11    # "osRes":Ljava/io/InputStreamReader;
    move-object v7, v8

    .end local v8    # "os":Ljava/io/DataOutputStream;
    .restart local v7    # "os":Ljava/io/DataOutputStream;
    goto/16 :goto_6
.end method
