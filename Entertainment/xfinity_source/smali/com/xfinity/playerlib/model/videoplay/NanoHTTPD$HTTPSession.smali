.class Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;
.super Ljava/lang/Object;
.source "NanoHTTPD.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HTTPSession"
.end annotation


# instance fields
.field private mySocket:Ljava/net/Socket;

.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/net/Socket;)V
    .locals 2
    .param p2, "s"    # Ljava/net/Socket;

    .prologue
    .line 263
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->this$0:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 264
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->mySocket:Ljava/net/Socket;

    .line 265
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, p0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 266
    .local v0, "t":Ljava/lang/Thread;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setDaemon(Z)V

    .line 267
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 268
    return-void
.end method

.method private decodeHeader(Ljava/io/BufferedReader;Ljava/util/Properties;Ljava/util/Properties;Ljava/util/Properties;)V
    .locals 11
    .param p1, "in"    # Ljava/io/BufferedReader;
    .param p2, "pre"    # Ljava/util/Properties;
    .param p3, "parms"    # Ljava/util/Properties;
    .param p4, "header"    # Ljava/util/Properties;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 424
    :try_start_0
    invoke-virtual {p1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v0

    .line 425
    .local v0, "inLine":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 470
    .end local v0    # "inLine":Ljava/lang/String;
    :goto_0
    return-void

    .line 428
    .restart local v0    # "inLine":Ljava/lang/String;
    :cond_0
    new-instance v6, Ljava/util/StringTokenizer;

    invoke-direct {v6, v0}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;)V

    .line 429
    .local v6, "st":Ljava/util/StringTokenizer;
    invoke-virtual {v6}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v8

    if-nez v8, :cond_1

    .line 430
    const-string v8, "400 Bad Request"

    const-string v9, "BAD REQUEST: Syntax error. Usage: GET /example/file.html"

    invoke-direct {p0, v8, v9}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V

    .line 433
    :cond_1
    invoke-virtual {v6}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v3

    .line 434
    .local v3, "method":Ljava/lang/String;
    const-string v8, "method"

    invoke-virtual {p2, v8, v3}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 436
    invoke-virtual {v6}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v8

    if-nez v8, :cond_2

    .line 437
    const-string v8, "400 Bad Request"

    const-string v9, "BAD REQUEST: Missing URI. Usage: GET /example/file.html"

    invoke-direct {p0, v8, v9}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V

    .line 440
    :cond_2
    invoke-virtual {v6}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v7

    .line 443
    .local v7, "uri":Ljava/lang/String;
    const/16 v8, 0x3f

    invoke-virtual {v7, v8}, Ljava/lang/String;->indexOf(I)I

    move-result v5

    .line 444
    .local v5, "qmi":I
    if-ltz v5, :cond_4

    .line 445
    add-int/lit8 v8, v5, 0x1

    invoke-virtual {v7, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v8, p3}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->decodeParms(Ljava/lang/String;Ljava/util/Properties;)V

    .line 446
    const/4 v8, 0x0

    invoke-virtual {v7, v8, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v8}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->decodePercent(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 455
    :goto_1
    invoke-virtual {v6}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v8

    if-eqz v8, :cond_5

    .line 456
    invoke-virtual {p1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    .line 457
    .local v2, "line":Ljava/lang/String;
    :goto_2
    if-eqz v2, :cond_5

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_5

    .line 458
    const/16 v8, 0x3a

    invoke-virtual {v2, v8}, Ljava/lang/String;->indexOf(I)I

    move-result v4

    .line 459
    .local v4, "p":I
    if-ltz v4, :cond_3

    .line 460
    const/4 v8, 0x0

    invoke-virtual {v2, v8, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v8

    add-int/lit8 v9, v4, 0x1

    invoke-virtual {v2, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p4, v8, v9}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 462
    :cond_3
    invoke-virtual {p1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    .line 463
    goto :goto_2

    .line 448
    .end local v2    # "line":Ljava/lang/String;
    .end local v4    # "p":I
    :cond_4
    invoke-direct {p0, v7}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->decodePercent(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    goto :goto_1

    .line 466
    :cond_5
    const-string v8, "uri"

    invoke-virtual {p2, v8, v7}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 467
    .end local v0    # "inLine":Ljava/lang/String;
    .end local v3    # "method":Ljava/lang/String;
    .end local v5    # "qmi":I
    .end local v6    # "st":Ljava/util/StringTokenizer;
    .end local v7    # "uri":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 468
    .local v1, "ioe":Ljava/io/IOException;
    const-string v8, "500 Internal Server Error"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "SERVER INTERNAL ERROR: IOException: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {p0, v8, v9}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method private decodeMultipartData(Ljava/lang/String;[BLjava/io/BufferedReader;Ljava/util/Properties;Ljava/util/Properties;)V
    .locals 21
    .param p1, "boundary"    # Ljava/lang/String;
    .param p2, "fbuf"    # [B
    .param p3, "in"    # Ljava/io/BufferedReader;
    .param p4, "parms"    # Ljava/util/Properties;
    .param p5, "files"    # Ljava/util/Properties;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 479
    :try_start_0
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v18

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->getBoundaryPositions([B[B)[I

    move-result-object v4

    .line 480
    .local v4, "bpositions":[I
    const/4 v3, 0x1

    .line 481
    .local v3, "boundarycount":I
    invoke-virtual/range {p3 .. p3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v10

    .line 482
    .local v10, "mpline":Ljava/lang/String;
    :cond_0
    :goto_0
    if-eqz v10, :cond_6

    .line 483
    move-object/from16 v0, p1

    invoke-virtual {v10, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v18

    const/16 v19, -0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_1

    .line 484
    const-string v18, "400 Bad Request"

    const-string v19, "BAD REQUEST: Content type is multipart/form-data but next chunk does not start with boundary. Usage: GET /example/file.html"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V

    .line 486
    :cond_1
    add-int/lit8 v3, v3, 0x1

    .line 487
    new-instance v9, Ljava/util/Properties;

    invoke-direct {v9}, Ljava/util/Properties;-><init>()V

    .line 488
    .local v9, "item":Ljava/util/Properties;
    invoke-virtual/range {p3 .. p3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v10

    .line 489
    :goto_1
    if-eqz v10, :cond_3

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->length()I

    move-result v18

    if-lez v18, :cond_3

    .line 490
    const/16 v18, 0x3a

    move/from16 v0, v18

    invoke-virtual {v10, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v12

    .line 491
    .local v12, "p":I
    const/16 v18, -0x1

    move/from16 v0, v18

    if-eq v12, v0, :cond_2

    .line 492
    const/16 v18, 0x0

    move/from16 v0, v18

    invoke-virtual {v10, v0, v12}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v18

    add-int/lit8 v19, v12, 0x1

    move/from16 v0, v19

    invoke-virtual {v10, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v9, v0, v1}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 494
    :cond_2
    invoke-virtual/range {p3 .. p3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v10

    .line 495
    goto :goto_1

    .line 496
    .end local v12    # "p":I
    :cond_3
    if-eqz v10, :cond_0

    .line 497
    const-string v18, "content-disposition"

    move-object/from16 v0, v18

    invoke-virtual {v9, v0}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 498
    .local v5, "contentDisposition":Ljava/lang/String;
    if-nez v5, :cond_4

    .line 499
    const-string v18, "400 Bad Request"

    const-string v19, "BAD REQUEST: Content type is multipart/form-data but no content-disposition info found. Usage: GET /example/file.html"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V

    .line 501
    :cond_4
    new-instance v15, Ljava/util/StringTokenizer;

    const-string v18, "; "

    move-object/from16 v0, v18

    invoke-direct {v15, v5, v0}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 502
    .local v15, "st":Ljava/util/StringTokenizer;
    new-instance v7, Ljava/util/Properties;

    invoke-direct {v7}, Ljava/util/Properties;-><init>()V

    .line 503
    .local v7, "disposition":Ljava/util/Properties;
    :cond_5
    :goto_2
    invoke-virtual {v15}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v18

    if-eqz v18, :cond_7

    .line 504
    invoke-virtual {v15}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v16

    .line 505
    .local v16, "token":Ljava/lang/String;
    const/16 v18, 0x3d

    move-object/from16 v0, v16

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(I)I

    move-result v12

    .line 506
    .restart local v12    # "p":I
    const/16 v18, -0x1

    move/from16 v0, v18

    if-eq v12, v0, :cond_5

    .line 507
    const/16 v18, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v18

    invoke-virtual {v0, v1, v12}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v18

    add-int/lit8 v19, v12, 0x1

    move-object/from16 v0, v16

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v7, v0, v1}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 542
    .end local v3    # "boundarycount":I
    .end local v4    # "bpositions":[I
    .end local v5    # "contentDisposition":Ljava/lang/String;
    .end local v7    # "disposition":Ljava/util/Properties;
    .end local v9    # "item":Ljava/util/Properties;
    .end local v10    # "mpline":Ljava/lang/String;
    .end local v12    # "p":I
    .end local v15    # "st":Ljava/util/StringTokenizer;
    .end local v16    # "token":Ljava/lang/String;
    :catch_0
    move-exception v8

    .line 543
    .local v8, "ioe":Ljava/io/IOException;
    const-string v18, "500 Internal Server Error"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "SERVER INTERNAL ERROR: IOException: "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual {v8}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V

    .line 545
    .end local v8    # "ioe":Ljava/io/IOException;
    :cond_6
    return-void

    .line 510
    .restart local v3    # "boundarycount":I
    .restart local v4    # "bpositions":[I
    .restart local v5    # "contentDisposition":Ljava/lang/String;
    .restart local v7    # "disposition":Ljava/util/Properties;
    .restart local v9    # "item":Ljava/util/Properties;
    .restart local v10    # "mpline":Ljava/lang/String;
    .restart local v15    # "st":Ljava/util/StringTokenizer;
    :cond_7
    :try_start_1
    const-string v18, "name"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 511
    .local v14, "pname":Ljava/lang/String;
    const/16 v18, 0x1

    invoke-virtual {v14}, Ljava/lang/String;->length()I

    move-result v19

    add-int/lit8 v19, v19, -0x1

    move/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v14, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v14

    .line 513
    const-string v17, ""

    .line 514
    .local v17, "value":Ljava/lang/String;
    const-string v18, "content-type"

    move-object/from16 v0, v18

    invoke-virtual {v9, v0}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    if-nez v18, :cond_a

    .line 515
    :cond_8
    :goto_3
    if-eqz v10, :cond_d

    move-object/from16 v0, p1

    invoke-virtual {v10, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v18

    const/16 v19, -0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_d

    .line 516
    invoke-virtual/range {p3 .. p3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v10

    .line 517
    if-eqz v10, :cond_8

    .line 518
    move-object/from16 v0, p1

    invoke-virtual {v10, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    .line 519
    .local v6, "d":I
    const/16 v18, -0x1

    move/from16 v0, v18

    if-ne v6, v0, :cond_9

    .line 520
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    goto :goto_3

    .line 522
    :cond_9
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const/16 v19, 0x0

    add-int/lit8 v20, v6, -0x2

    move/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v10, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    goto :goto_3

    .line 527
    .end local v6    # "d":I
    :cond_a
    array-length v0, v4

    move/from16 v18, v0

    move/from16 v0, v18

    if-le v3, v0, :cond_b

    .line 528
    const-string v18, "500 Internal Server Error"

    const-string v19, "Error processing request"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V

    .line 530
    :cond_b
    add-int/lit8 v18, v3, -0x2

    aget v18, v4, v18

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move/from16 v2, v18

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->stripMultipartHeaders([BI)I

    move-result v11

    .line 531
    .local v11, "offset":I
    add-int/lit8 v18, v3, -0x1

    aget v18, v4, v18

    sub-int v18, v18, v11

    add-int/lit8 v18, v18, -0x4

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move/from16 v2, v18

    invoke-direct {v0, v1, v11, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->saveTmpFile([BII)Ljava/lang/String;

    move-result-object v13

    .line 532
    .local v13, "path":Ljava/lang/String;
    move-object/from16 v0, p5

    invoke-virtual {v0, v14, v13}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 533
    const-string v18, "filename"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 534
    const/16 v18, 0x1

    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->length()I

    move-result v19

    add-int/lit8 v19, v19, -0x1

    invoke-virtual/range {v17 .. v19}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v17

    .line 536
    :cond_c
    invoke-virtual/range {p3 .. p3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v10

    .line 537
    if-eqz v10, :cond_d

    move-object/from16 v0, p1

    invoke-virtual {v10, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v18

    const/16 v19, -0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_c

    .line 539
    .end local v11    # "offset":I
    .end local v13    # "path":Ljava/lang/String;
    :cond_d
    move-object/from16 v0, p4

    move-object/from16 v1, v17

    invoke-virtual {v0, v14, v1}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method private decodeParms(Ljava/lang/String;Ljava/util/Properties;)V
    .locals 5
    .param p1, "parms"    # Ljava/lang/String;
    .param p2, "p"    # Ljava/util/Properties;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 666
    if-nez p1, :cond_1

    .line 679
    :cond_0
    return-void

    .line 670
    :cond_1
    new-instance v2, Ljava/util/StringTokenizer;

    const-string v3, "&"

    invoke-direct {v2, p1, v3}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 671
    .local v2, "st":Ljava/util/StringTokenizer;
    :cond_2
    :goto_0
    invoke-virtual {v2}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 672
    invoke-virtual {v2}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v0

    .line 673
    .local v0, "e":Ljava/lang/String;
    const/16 v3, 0x3d

    invoke-virtual {v0, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .line 674
    .local v1, "sep":I
    if-ltz v1, :cond_2

    .line 675
    const/4 v3, 0x0

    invoke-virtual {v0, v3, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->decodePercent(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    add-int/lit8 v4, v1, 0x1

    .line 676
    invoke-virtual {v0, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->decodePercent(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 675
    invoke-virtual {p2, v3, v4}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private decodePercent(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "str"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 634
    :try_start_0
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 635
    .local v3, "sb":Ljava/lang/StringBuffer;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 636
    invoke-virtual {p1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 637
    .local v0, "c":C
    sparse-switch v0, :sswitch_data_0

    .line 646
    invoke-virtual {v3, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 635
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 639
    :sswitch_0
    const/16 v4, 0x20

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 651
    .end local v0    # "c":C
    .end local v2    # "i":I
    .end local v3    # "sb":Ljava/lang/StringBuffer;
    :catch_0
    move-exception v1

    .line 652
    .local v1, "e":Ljava/lang/Exception;
    const-string v4, "400 Bad Request"

    const-string v5, "BAD REQUEST: Bad percent-encoding."

    invoke-direct {p0, v4, v5}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V

    .line 653
    const/4 v4, 0x0

    .end local v1    # "e":Ljava/lang/Exception;
    :goto_2
    return-object v4

    .line 642
    .restart local v0    # "c":C
    .restart local v2    # "i":I
    .restart local v3    # "sb":Ljava/lang/StringBuffer;
    :sswitch_1
    add-int/lit8 v4, v2, 0x1

    add-int/lit8 v5, v2, 0x3

    :try_start_1
    invoke-virtual {p1, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x10

    invoke-static {v4, v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v4

    int-to-char v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 643
    add-int/lit8 v2, v2, 0x2

    .line 644
    goto :goto_1

    .line 650
    .end local v0    # "c":C
    :cond_0
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v4

    goto :goto_2

    .line 637
    nop

    :sswitch_data_0
    .sparse-switch
        0x25 -> :sswitch_1
        0x2b -> :sswitch_0
    .end sparse-switch
.end method

.method private findHeaderEnd([BI)I
    .locals 4
    .param p1, "buf"    # [B
    .param p2, "rlen"    # I

    .prologue
    const/16 v3, 0xd

    const/16 v2, 0xa

    .line 552
    const/4 v0, 0x0

    .line 553
    .local v0, "splitbyte":I
    :goto_0
    add-int/lit8 v1, v0, 0x3

    if-ge v1, p2, :cond_1

    .line 554
    aget-byte v1, p1, v0

    if-ne v1, v3, :cond_0

    add-int/lit8 v1, v0, 0x1

    aget-byte v1, p1, v1

    if-ne v1, v2, :cond_0

    add-int/lit8 v1, v0, 0x2

    aget-byte v1, p1, v1

    if-ne v1, v3, :cond_0

    add-int/lit8 v1, v0, 0x3

    aget-byte v1, p1, v1

    if-ne v1, v2, :cond_0

    .line 555
    add-int/lit8 v1, v0, 0x4

    .line 559
    :goto_1
    return v1

    .line 557
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 559
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private saveTmpFile([BII)Ljava/lang/String;
    .locals 8
    .param p1, "b"    # [B
    .param p2, "offset"    # I
    .param p3, "len"    # I

    .prologue
    .line 597
    const-string v2, ""

    .line 598
    .local v2, "path":Ljava/lang/String;
    if-lez p3, :cond_0

    .line 599
    const-string v5, "java.io.tmpdir"

    invoke-static {v5}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 601
    .local v4, "tmpdir":Ljava/lang/String;
    :try_start_0
    const-string v5, "NanoHTTPD"

    const-string v6, ""

    new-instance v7, Ljava/io/File;

    invoke-direct {v7, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v5, v6, v7}, Ljava/io/File;->createTempFile(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;

    move-result-object v3

    .line 602
    .local v3, "temp":Ljava/io/File;
    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 603
    .local v1, "fstream":Ljava/io/OutputStream;
    invoke-virtual {v1, p1, p2, p3}, Ljava/io/OutputStream;->write([BII)V

    .line 604
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V

    .line 605
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 610
    .end local v1    # "fstream":Ljava/io/OutputStream;
    .end local v3    # "temp":Ljava/io/File;
    .end local v4    # "tmpdir":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v2

    .line 606
    .restart local v4    # "tmpdir":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 607
    .local v0, "e":Ljava/lang/Exception;
    sget-object v5, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myErr:Ljava/io/PrintStream;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Error: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private sendError(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "status"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 686
    const-string v0, "text/plain"

    const/4 v1, 0x0

    new-instance v2, Ljava/io/ByteArrayInputStream;

    invoke-virtual {p2}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendResponse(Ljava/lang/String;Ljava/lang/String;Ljava/util/Properties;Ljava/io/InputStream;)V

    .line 687
    new-instance v0, Ljava/lang/InterruptedException;

    invoke-direct {v0}, Ljava/lang/InterruptedException;-><init>()V

    throw v0
.end method

.method private sendResponse(Ljava/lang/String;Ljava/lang/String;Ljava/util/Properties;Ljava/io/InputStream;)V
    .locals 13
    .param p1, "status"    # Ljava/lang/String;
    .param p2, "mime"    # Ljava/lang/String;
    .param p3, "header"    # Ljava/util/Properties;
    .param p4, "data"    # Ljava/io/InputStream;

    .prologue
    .line 693
    if-nez p1, :cond_1

    .line 694
    :try_start_0
    new-instance v10, Ljava/lang/Error;

    const-string v11, "sendResponse(): Status can\'t be null."

    invoke-direct {v10, v11}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v10
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 738
    :catch_0
    move-exception v3

    .line 741
    .local v3, "ioe":Ljava/io/IOException;
    :try_start_1
    iget-object v10, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->mySocket:Ljava/net/Socket;

    invoke-virtual {v10}, Ljava/net/Socket;->close()V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    .line 745
    .end local v3    # "ioe":Ljava/io/IOException;
    :cond_0
    :goto_0
    return-void

    .line 697
    :cond_1
    :try_start_2
    iget-object v10, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->mySocket:Ljava/net/Socket;

    invoke-virtual {v10}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v5

    .line 698
    .local v5, "out":Ljava/io/OutputStream;
    new-instance v7, Ljava/io/PrintWriter;

    invoke-direct {v7, v5}, Ljava/io/PrintWriter;-><init>(Ljava/io/OutputStream;)V

    .line 699
    .local v7, "pw":Ljava/io/PrintWriter;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "HTTP/1.0 "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " \r\n"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 701
    if-eqz p2, :cond_2

    .line 702
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Content-Type: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\r\n"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 705
    :cond_2
    if-eqz p3, :cond_3

    const-string v10, "Date"

    move-object/from16 v0, p3

    invoke-virtual {v0, v10}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    if-nez v10, :cond_4

    .line 706
    :cond_3
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Date: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    # getter for: Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->gmtFrmt:Ljava/text/SimpleDateFormat;
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->access$100()Ljava/text/SimpleDateFormat;

    move-result-object v11

    new-instance v12, Ljava/util/Date;

    invoke-direct {v12}, Ljava/util/Date;-><init>()V

    invoke-virtual {v11, v12}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\r\n"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 709
    :cond_4
    if-eqz p3, :cond_5

    .line 710
    invoke-virtual/range {p3 .. p3}, Ljava/util/Properties;->keys()Ljava/util/Enumeration;

    move-result-object v2

    .line 711
    .local v2, "e":Ljava/util/Enumeration;
    :goto_1
    invoke-interface {v2}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v10

    if-eqz v10, :cond_5

    .line 712
    invoke-interface {v2}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 713
    .local v4, "key":Ljava/lang/String;
    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 714
    .local v9, "value":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ": "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\r\n"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    goto :goto_1

    .line 718
    .end local v2    # "e":Ljava/util/Enumeration;
    .end local v4    # "key":Ljava/lang/String;
    .end local v9    # "value":Ljava/lang/String;
    :cond_5
    const-string v10, "\r\n"

    invoke-virtual {v7, v10}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 719
    invoke-virtual {v7}, Ljava/io/PrintWriter;->flush()V

    .line 721
    if-eqz p4, :cond_6

    .line 722
    invoke-virtual/range {p4 .. p4}, Ljava/io/InputStream;->available()I

    move-result v6

    .line 723
    .local v6, "pending":I
    # getter for: Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->theBufferSize:I
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->access$200()I

    move-result v10

    new-array v1, v10, [B

    .line 724
    .local v1, "buff":[B
    :goto_2
    if-lez v6, :cond_6

    .line 725
    const/4 v11, 0x0

    # getter for: Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->theBufferSize:I
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->access$200()I

    move-result v10

    if-le v6, v10, :cond_7

    # getter for: Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->theBufferSize:I
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->access$200()I

    move-result v10

    :goto_3
    move-object/from16 v0, p4

    invoke-virtual {v0, v1, v11, v10}, Ljava/io/InputStream;->read([BII)I

    move-result v8

    .line 726
    .local v8, "read":I
    if-gtz v8, :cond_8

    .line 733
    .end local v1    # "buff":[B
    .end local v6    # "pending":I
    .end local v8    # "read":I
    :cond_6
    invoke-virtual {v5}, Ljava/io/OutputStream;->flush()V

    .line 734
    invoke-virtual {v5}, Ljava/io/OutputStream;->close()V

    .line 735
    if-eqz p4, :cond_0

    .line 736
    invoke-virtual/range {p4 .. p4}, Ljava/io/InputStream;->close()V

    goto/16 :goto_0

    .restart local v1    # "buff":[B
    .restart local v6    # "pending":I
    :cond_7
    move v10, v6

    .line 725
    goto :goto_3

    .line 729
    .restart local v8    # "read":I
    :cond_8
    const/4 v10, 0x0

    invoke-virtual {v5, v1, v10, v8}, Ljava/io/OutputStream;->write([BII)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 730
    sub-int/2addr v6, v8

    .line 731
    goto :goto_2

    .line 742
    .end local v1    # "buff":[B
    .end local v5    # "out":Ljava/io/OutputStream;
    .end local v6    # "pending":I
    .end local v7    # "pw":Ljava/io/PrintWriter;
    .end local v8    # "read":I
    .restart local v3    # "ioe":Ljava/io/IOException;
    :catch_1
    move-exception v10

    goto/16 :goto_0
.end method

.method private stripMultipartHeaders([BI)I
    .locals 4
    .param p1, "b"    # [B
    .param p2, "offset"    # I

    .prologue
    const/16 v3, 0xd

    const/16 v2, 0xa

    .line 619
    const/4 v0, 0x0

    .line 620
    .local v0, "i":I
    move v0, p2

    :goto_0
    array-length v1, p1

    if-ge v0, v1, :cond_0

    .line 621
    aget-byte v1, p1, v0

    if-ne v1, v3, :cond_1

    add-int/lit8 v0, v0, 0x1

    aget-byte v1, p1, v0

    if-ne v1, v2, :cond_1

    add-int/lit8 v0, v0, 0x1

    aget-byte v1, p1, v0

    if-ne v1, v3, :cond_1

    add-int/lit8 v0, v0, 0x1

    aget-byte v1, p1, v0

    if-ne v1, v2, :cond_1

    .line 625
    :cond_0
    add-int/lit8 v1, v0, 0x1

    return v1

    .line 620
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getBoundaryPositions([B[B)[I
    .locals 7
    .param p1, "b"    # [B
    .param p2, "boundary"    # [B

    .prologue
    .line 564
    const/4 v3, 0x0

    .line 565
    .local v3, "matchcount":I
    const/4 v1, -0x1

    .line 566
    .local v1, "matchbyte":I
    new-instance v2, Ljava/util/Vector;

    invoke-direct {v2}, Ljava/util/Vector;-><init>()V

    .line 567
    .local v2, "matchbytes":Ljava/util/Vector;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v5, p1

    if-ge v0, v5, :cond_3

    .line 568
    aget-byte v5, p1, v0

    aget-byte v6, p2, v3

    if-ne v5, v6, :cond_2

    .line 569
    if-nez v3, :cond_0

    .line 570
    move v1, v0

    .line 572
    :cond_0
    add-int/lit8 v3, v3, 0x1

    .line 573
    array-length v5, p2

    if-ne v3, v5, :cond_1

    .line 574
    new-instance v5, Ljava/lang/Integer;

    invoke-direct {v5, v1}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v2, v5}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 575
    const/4 v3, 0x0

    .line 576
    const/4 v1, -0x1

    .line 567
    :cond_1
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 579
    :cond_2
    sub-int/2addr v0, v3

    .line 580
    const/4 v3, 0x0

    .line 581
    const/4 v1, -0x1

    goto :goto_1

    .line 584
    :cond_3
    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v5

    new-array v4, v5, [I

    .line 585
    .local v4, "ret":[I
    const/4 v0, 0x0

    :goto_2
    array-length v5, v4

    if-ge v0, v5, :cond_4

    .line 586
    invoke-virtual {v2, v0}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    aput v5, v4, v0

    .line 585
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 588
    :cond_4
    return-object v4
.end method

.method public run()V
    .locals 38

    .prologue
    .line 272
    :try_start_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->mySocket:Ljava/net/Socket;

    invoke-virtual {v4}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    move-result-object v27

    .line 273
    .local v27, "is":Ljava/io/InputStream;
    if-nez v27, :cond_0

    .line 414
    .end local v27    # "is":Ljava/io/InputStream;
    :goto_0
    return-void

    .line 281
    .restart local v27    # "is":Ljava/io/InputStream;
    :cond_0
    const/16 v19, 0x2000

    .line 282
    .local v19, "bufsize":I
    const/16 v4, 0x2000

    new-array v0, v4, [B

    move-object/from16 v18, v0

    .line 283
    .local v18, "buf":[B
    const/16 v36, 0x0

    .line 284
    .local v36, "splitbyte":I
    const/16 v33, 0x0

    .line 286
    .local v33, "rlen":I
    const/4 v4, 0x0

    const/16 v10, 0x2000

    move-object/from16 v0, v27

    move-object/from16 v1, v18

    invoke-virtual {v0, v1, v4, v10}, Ljava/io/InputStream;->read([BII)I

    move-result v32

    .line 287
    .local v32, "read":I
    :goto_1
    if-lez v32, :cond_1

    .line 288
    add-int v33, v33, v32

    .line 289
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move/from16 v2, v33

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->findHeaderEnd([BI)I

    move-result v36

    .line 290
    if-lez v36, :cond_6

    .line 298
    :cond_1
    new-instance v24, Ljava/io/ByteArrayInputStream;

    const/4 v4, 0x0

    move-object/from16 v0, v24

    move-object/from16 v1, v18

    move/from16 v2, v33

    invoke-direct {v0, v1, v4, v2}, Ljava/io/ByteArrayInputStream;-><init>([BII)V

    .line 299
    .local v24, "hbis":Ljava/io/ByteArrayInputStream;
    new-instance v25, Ljava/io/BufferedReader;

    new-instance v4, Ljava/io/InputStreamReader;

    move-object/from16 v0, v24

    invoke-direct {v4, v0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    move-object/from16 v0, v25

    invoke-direct {v0, v4}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 300
    .local v25, "hin":Ljava/io/BufferedReader;
    new-instance v30, Ljava/util/Properties;

    invoke-direct/range {v30 .. v30}, Ljava/util/Properties;-><init>()V

    .line 301
    .local v30, "pre":Ljava/util/Properties;
    new-instance v8, Ljava/util/Properties;

    invoke-direct {v8}, Ljava/util/Properties;-><init>()V

    .line 302
    .local v8, "parms":Ljava/util/Properties;
    new-instance v13, Ljava/util/Properties;

    invoke-direct {v13}, Ljava/util/Properties;-><init>()V

    .line 303
    .local v13, "header":Ljava/util/Properties;
    new-instance v9, Ljava/util/Properties;

    invoke-direct {v9}, Ljava/util/Properties;-><init>()V

    .line 306
    .local v9, "files":Ljava/util/Properties;
    move-object/from16 v0, p0

    move-object/from16 v1, v25

    move-object/from16 v2, v30

    invoke-direct {v0, v1, v2, v8, v13}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->decodeHeader(Ljava/io/BufferedReader;Ljava/util/Properties;Ljava/util/Properties;Ljava/util/Properties;)V

    .line 307
    const-string v4, "method"

    move-object/from16 v0, v30

    invoke-virtual {v0, v4}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 308
    .local v12, "method":Ljava/lang/String;
    const-string v4, "uri"

    move-object/from16 v0, v30

    invoke-virtual {v0, v4}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 310
    .local v11, "uri":Ljava/lang/String;
    const-wide v34, 0x7fffffffffffffffL

    .line 311
    .local v34, "size":J
    const-string v4, "content-length"

    invoke-virtual {v13, v4}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v20

    .line 312
    .local v20, "contentLength":Ljava/lang/String;
    if-eqz v20, :cond_2

    .line 314
    :try_start_1
    invoke-static/range {v20 .. v20}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_2

    move-result v4

    int-to-long v0, v4

    move-wide/from16 v34, v0

    .line 320
    :cond_2
    :goto_2
    :try_start_2
    new-instance v23, Ljava/io/ByteArrayOutputStream;

    invoke-direct/range {v23 .. v23}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 321
    .local v23, "f":Ljava/io/ByteArrayOutputStream;
    move/from16 v0, v36

    move/from16 v1, v33

    if-ge v0, v1, :cond_3

    .line 322
    sub-int v4, v33, v36

    move-object/from16 v0, v23

    move-object/from16 v1, v18

    move/from16 v2, v36

    invoke-virtual {v0, v1, v2, v4}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    .line 331
    :cond_3
    move/from16 v0, v36

    move/from16 v1, v33

    if-ge v0, v1, :cond_7

    .line 332
    sub-int v4, v33, v36

    add-int/lit8 v4, v4, 0x1

    int-to-long v14, v4

    sub-long v34, v34, v14

    .line 338
    :cond_4
    :goto_3
    const/16 v4, 0x200

    new-array v0, v4, [B

    move-object/from16 v18, v0

    .line 339
    :cond_5
    :goto_4
    if-ltz v33, :cond_9

    const-wide/16 v14, 0x0

    cmp-long v4, v34, v14

    if-lez v4, :cond_9

    .line 340
    const/4 v4, 0x0

    const/16 v10, 0x200

    move-object/from16 v0, v27

    move-object/from16 v1, v18

    invoke-virtual {v0, v1, v4, v10}, Ljava/io/InputStream;->read([BII)I

    move-result v33

    .line 341
    move/from16 v0, v33

    int-to-long v14, v0

    sub-long v34, v34, v14

    .line 342
    if-lez v33, :cond_5

    .line 343
    const/4 v4, 0x0

    move-object/from16 v0, v23

    move-object/from16 v1, v18

    move/from16 v2, v33

    invoke-virtual {v0, v1, v4, v2}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_4

    .line 406
    .end local v8    # "parms":Ljava/util/Properties;
    .end local v9    # "files":Ljava/util/Properties;
    .end local v11    # "uri":Ljava/lang/String;
    .end local v12    # "method":Ljava/lang/String;
    .end local v13    # "header":Ljava/util/Properties;
    .end local v18    # "buf":[B
    .end local v19    # "bufsize":I
    .end local v20    # "contentLength":Ljava/lang/String;
    .end local v23    # "f":Ljava/io/ByteArrayOutputStream;
    .end local v24    # "hbis":Ljava/io/ByteArrayInputStream;
    .end local v25    # "hin":Ljava/io/BufferedReader;
    .end local v27    # "is":Ljava/io/InputStream;
    .end local v30    # "pre":Ljava/util/Properties;
    .end local v32    # "read":I
    .end local v33    # "rlen":I
    .end local v34    # "size":J
    .end local v36    # "splitbyte":I
    :catch_0
    move-exception v26

    .line 408
    .local v26, "ioe":Ljava/io/IOException;
    :try_start_3
    const-string v4, "500 Internal Server Error"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "SERVER INTERNAL ERROR: IOException: "

    invoke-virtual {v10, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual/range {v26 .. v26}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v10}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_0

    .line 409
    :catch_1
    move-exception v4

    goto/16 :goto_0

    .line 293
    .end local v26    # "ioe":Ljava/io/IOException;
    .restart local v18    # "buf":[B
    .restart local v19    # "bufsize":I
    .restart local v27    # "is":Ljava/io/InputStream;
    .restart local v32    # "read":I
    .restart local v33    # "rlen":I
    .restart local v36    # "splitbyte":I
    :cond_6
    move/from16 v0, v33

    rsub-int v4, v0, 0x2000

    :try_start_4
    move-object/from16 v0, v27

    move-object/from16 v1, v18

    move/from16 v2, v33

    invoke-virtual {v0, v1, v2, v4}, Ljava/io/InputStream;->read([BII)I

    move-result v32

    goto/16 :goto_1

    .line 333
    .restart local v8    # "parms":Ljava/util/Properties;
    .restart local v9    # "files":Ljava/util/Properties;
    .restart local v11    # "uri":Ljava/lang/String;
    .restart local v12    # "method":Ljava/lang/String;
    .restart local v13    # "header":Ljava/util/Properties;
    .restart local v20    # "contentLength":Ljava/lang/String;
    .restart local v23    # "f":Ljava/io/ByteArrayOutputStream;
    .restart local v24    # "hbis":Ljava/io/ByteArrayInputStream;
    .restart local v25    # "hin":Ljava/io/BufferedReader;
    .restart local v30    # "pre":Ljava/util/Properties;
    .restart local v34    # "size":J
    :cond_7
    if-eqz v36, :cond_8

    const-wide v14, 0x7fffffffffffffffL

    cmp-long v4, v34, v14

    if-nez v4, :cond_4

    .line 334
    :cond_8
    const-wide/16 v34, 0x0

    goto :goto_3

    .line 348
    :cond_9
    invoke-virtual/range {v23 .. v23}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v6

    .line 351
    .local v6, "fbuf":[B
    new-instance v16, Ljava/io/ByteArrayInputStream;

    move-object/from16 v0, v16

    invoke-direct {v0, v6}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 352
    .local v16, "bin":Ljava/io/ByteArrayInputStream;
    new-instance v7, Ljava/io/BufferedReader;

    new-instance v4, Ljava/io/InputStreamReader;

    move-object/from16 v0, v16

    invoke-direct {v4, v0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v7, v4}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 356
    .local v7, "in":Ljava/io/BufferedReader;
    const-string v4, "POST"

    invoke-virtual {v12, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_d

    .line 357
    const-string v21, ""

    .line 358
    .local v21, "contentType":Ljava/lang/String;
    const-string v4, "content-type"

    invoke-virtual {v13, v4}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 359
    .local v22, "contentTypeHeader":Ljava/lang/String;
    new-instance v37, Ljava/util/StringTokenizer;

    const-string v4, "; "

    move-object/from16 v0, v37

    move-object/from16 v1, v22

    invoke-direct {v0, v1, v4}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 360
    .local v37, "st":Ljava/util/StringTokenizer;
    invoke-virtual/range {v37 .. v37}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 361
    invoke-virtual/range {v37 .. v37}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v21

    .line 364
    :cond_a
    const-string v4, "multipart/form-data"

    move-object/from16 v0, v21

    invoke-virtual {v0, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_f

    .line 366
    invoke-virtual/range {v37 .. v37}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v4

    if-nez v4, :cond_b

    .line 367
    const-string v4, "400 Bad Request"

    const-string v10, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html"

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v10}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V

    .line 369
    :cond_b
    invoke-virtual/range {v37 .. v37}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v17

    .line 370
    .local v17, "boundaryExp":Ljava/lang/String;
    new-instance v37, Ljava/util/StringTokenizer;

    .end local v37    # "st":Ljava/util/StringTokenizer;
    const-string v4, "="

    move-object/from16 v0, v37

    move-object/from16 v1, v17

    invoke-direct {v0, v1, v4}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 371
    .restart local v37    # "st":Ljava/util/StringTokenizer;
    invoke-virtual/range {v37 .. v37}, Ljava/util/StringTokenizer;->countTokens()I

    move-result v4

    const/4 v10, 0x2

    if-eq v4, v10, :cond_c

    .line 372
    const-string v4, "400 Bad Request"

    const-string v10, "BAD REQUEST: Content type is multipart/form-data but boundary syntax error. Usage: GET /example/file.html"

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v10}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V

    .line 374
    :cond_c
    invoke-virtual/range {v37 .. v37}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    .line 375
    invoke-virtual/range {v37 .. v37}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v5

    .local v5, "boundary":Ljava/lang/String;
    move-object/from16 v4, p0

    .line 377
    invoke-direct/range {v4 .. v9}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->decodeMultipartData(Ljava/lang/String;[BLjava/io/BufferedReader;Ljava/util/Properties;Ljava/util/Properties;)V

    .line 392
    .end local v5    # "boundary":Ljava/lang/String;
    .end local v17    # "boundaryExp":Ljava/lang/String;
    .end local v21    # "contentType":Ljava/lang/String;
    .end local v22    # "contentTypeHeader":Ljava/lang/String;
    .end local v37    # "st":Ljava/util/StringTokenizer;
    :cond_d
    :goto_5
    const-string v4, "PUT"

    invoke-virtual {v12, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_e

    .line 393
    const-string v4, "content"

    const/4 v10, 0x0

    invoke-virtual/range {v23 .. v23}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v14

    move-object/from16 v0, p0

    invoke-direct {v0, v6, v10, v14}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->saveTmpFile([BII)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v4, v10}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 397
    :cond_e
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->this$0:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    move-object v14, v8

    move-object v15, v9

    invoke-virtual/range {v10 .. v15}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->serve(Ljava/lang/String;Ljava/lang/String;Ljava/util/Properties;Ljava/util/Properties;Ljava/util/Properties;)Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    move-result-object v31

    .line 398
    .local v31, "r":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    if-nez v31, :cond_11

    .line 399
    const-string v4, "500 Internal Server Error"

    const-string v10, "SERVER INTERNAL ERROR: Serve() returned a null response."

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v10}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendError(Ljava/lang/String;Ljava/lang/String;)V

    .line 404
    :goto_6
    invoke-virtual {v7}, Ljava/io/BufferedReader;->close()V

    .line 405
    invoke-virtual/range {v27 .. v27}, Ljava/io/InputStream;->close()V

    goto/16 :goto_0

    .line 411
    .end local v6    # "fbuf":[B
    .end local v7    # "in":Ljava/io/BufferedReader;
    .end local v8    # "parms":Ljava/util/Properties;
    .end local v9    # "files":Ljava/util/Properties;
    .end local v11    # "uri":Ljava/lang/String;
    .end local v12    # "method":Ljava/lang/String;
    .end local v13    # "header":Ljava/util/Properties;
    .end local v16    # "bin":Ljava/io/ByteArrayInputStream;
    .end local v18    # "buf":[B
    .end local v19    # "bufsize":I
    .end local v20    # "contentLength":Ljava/lang/String;
    .end local v23    # "f":Ljava/io/ByteArrayOutputStream;
    .end local v24    # "hbis":Ljava/io/ByteArrayInputStream;
    .end local v25    # "hin":Ljava/io/BufferedReader;
    .end local v27    # "is":Ljava/io/InputStream;
    .end local v30    # "pre":Ljava/util/Properties;
    .end local v31    # "r":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .end local v32    # "read":I
    .end local v33    # "rlen":I
    .end local v34    # "size":J
    .end local v36    # "splitbyte":I
    :catch_2
    move-exception v4

    goto/16 :goto_0

    .line 380
    .restart local v6    # "fbuf":[B
    .restart local v7    # "in":Ljava/io/BufferedReader;
    .restart local v8    # "parms":Ljava/util/Properties;
    .restart local v9    # "files":Ljava/util/Properties;
    .restart local v11    # "uri":Ljava/lang/String;
    .restart local v12    # "method":Ljava/lang/String;
    .restart local v13    # "header":Ljava/util/Properties;
    .restart local v16    # "bin":Ljava/io/ByteArrayInputStream;
    .restart local v18    # "buf":[B
    .restart local v19    # "bufsize":I
    .restart local v20    # "contentLength":Ljava/lang/String;
    .restart local v21    # "contentType":Ljava/lang/String;
    .restart local v22    # "contentTypeHeader":Ljava/lang/String;
    .restart local v23    # "f":Ljava/io/ByteArrayOutputStream;
    .restart local v24    # "hbis":Ljava/io/ByteArrayInputStream;
    .restart local v25    # "hin":Ljava/io/BufferedReader;
    .restart local v27    # "is":Ljava/io/InputStream;
    .restart local v30    # "pre":Ljava/util/Properties;
    .restart local v32    # "read":I
    .restart local v33    # "rlen":I
    .restart local v34    # "size":J
    .restart local v36    # "splitbyte":I
    .restart local v37    # "st":Ljava/util/StringTokenizer;
    :cond_f
    const-string v29, ""

    .line 381
    .local v29, "postLine":Ljava/lang/String;
    const/16 v4, 0x200

    new-array v0, v4, [C

    move-object/from16 v28, v0

    .line 382
    .local v28, "pbuf":[C
    move-object/from16 v0, v28

    invoke-virtual {v7, v0}, Ljava/io/BufferedReader;->read([C)I

    move-result v32

    .line 383
    :goto_7
    if-ltz v32, :cond_10

    const-string v4, "\r\n"

    move-object/from16 v0, v29

    invoke-virtual {v0, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_10

    .line 384
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v29

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/4 v10, 0x0

    move-object/from16 v0, v28

    move/from16 v1, v32

    invoke-static {v0, v10, v1}, Ljava/lang/String;->valueOf([CII)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    .line 385
    move-object/from16 v0, v28

    invoke-virtual {v7, v0}, Ljava/io/BufferedReader;->read([C)I

    move-result v32

    goto :goto_7

    .line 387
    :cond_10
    invoke-virtual/range {v29 .. v29}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v29

    .line 388
    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-direct {v0, v1, v8}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->decodeParms(Ljava/lang/String;Ljava/util/Properties;)V

    goto :goto_5

    .line 401
    .end local v21    # "contentType":Ljava/lang/String;
    .end local v22    # "contentTypeHeader":Ljava/lang/String;
    .end local v28    # "pbuf":[C
    .end local v29    # "postLine":Ljava/lang/String;
    .end local v37    # "st":Ljava/util/StringTokenizer;
    .restart local v31    # "r":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :cond_11
    move-object/from16 v0, v31

    iget-object v4, v0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->status:Ljava/lang/String;

    move-object/from16 v0, v31

    iget-object v10, v0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->mimeType:Ljava/lang/String;

    move-object/from16 v0, v31

    iget-object v14, v0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->header:Ljava/util/Properties;

    move-object/from16 v0, v31

    iget-object v15, v0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->data:Ljava/io/InputStream;

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v10, v14, v15}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;->sendResponse(Ljava/lang/String;Ljava/lang/String;Ljava/util/Properties;Ljava/io/InputStream;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_6

    .line 315
    .end local v6    # "fbuf":[B
    .end local v7    # "in":Ljava/io/BufferedReader;
    .end local v16    # "bin":Ljava/io/ByteArrayInputStream;
    .end local v23    # "f":Ljava/io/ByteArrayOutputStream;
    .end local v31    # "r":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :catch_3
    move-exception v4

    goto/16 :goto_2
.end method
