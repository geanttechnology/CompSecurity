.class Lcom/aio/downloader/start/MainActivity$12;
.super Ljava/lang/Thread;
.source "MainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/start/MainActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/start/MainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/start/MainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/start/MainActivity$12;->this$0:Lcom/aio/downloader/start/MainActivity;

    .line 626
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 24

    .prologue
    .line 631
    invoke-super/range {p0 .. p0}, Ljava/lang/Thread;->run()V

    .line 633
    const/4 v15, 0x0

    .line 635
    .local v15, "serivce":Ljava/net/ServerSocket;
    if-nez v15, :cond_0

    .line 636
    :try_start_0
    new-instance v16, Ljava/net/ServerSocket;

    const/16 v21, 0x2f59

    move-object/from16 v0, v16

    move/from16 v1, v21

    invoke-direct {v0, v1}, Ljava/net/ServerSocket;-><init>(I)V

    .end local v15    # "serivce":Ljava/net/ServerSocket;
    .local v16, "serivce":Ljava/net/ServerSocket;
    move-object/from16 v15, v16

    .line 639
    .end local v16    # "serivce":Ljava/net/ServerSocket;
    .restart local v15    # "serivce":Ljava/net/ServerSocket;
    :cond_0
    :goto_0
    invoke-virtual {v15}, Ljava/net/ServerSocket;->accept()Ljava/net/Socket;

    move-result-object v17

    .line 641
    .local v17, "socket":Ljava/net/Socket;
    const/4 v11, 0x0

    .line 642
    .local v11, "line":Ljava/lang/String;
    const-string v3, ""

    .line 645
    .local v3, "buffer":Ljava/lang/String;
    const-string v18, ""

    .line 648
    .local v18, "str":Ljava/lang/String;
    invoke-virtual/range {v17 .. v17}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v12

    .line 649
    .local v12, "output":Ljava/io/OutputStream;
    invoke-virtual/range {v17 .. v17}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    move-result-object v5

    .line 650
    .local v5, "input":Ljava/io/InputStream;
    new-instance v2, Ljava/io/BufferedReader;

    .line 651
    new-instance v21, Ljava/io/InputStreamReader;

    move-object/from16 v0, v21

    invoke-direct {v0, v5}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 650
    move-object/from16 v0, v21

    invoke-direct {v2, v0}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 654
    .local v2, "bff":Ljava/io/BufferedReader;
    :cond_1
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v11

    if-nez v11, :cond_2

    .line 661
    :goto_1
    const-string v21, "write"

    const-string v22, "write11111"

    invoke-static/range {v21 .. v22}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 662
    const-string v21, " "

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v20

    .line 663
    .local v20, "str_buffer":[Ljava/lang/String;
    const/16 v21, 0x1

    aget-object v21, v20, v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v14

    .line 666
    .local v14, "s1":Ljava/lang/String;
    const-string v21, "/?jsonpCallback="

    move-object/from16 v0, v21

    invoke-virtual {v14, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    .line 667
    .local v7, "iooi":[Ljava/lang/String;
    array-length v0, v7

    move/from16 v21, v0

    add-int/lit8 v21, v21, -0x1

    aget-object v6, v7, v21

    .line 668
    .local v6, "ioo":Ljava/lang/String;
    const-string v21, "&"

    move-object/from16 v0, v21

    invoke-virtual {v6, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v13

    .line 669
    .local v13, "ppp":[Ljava/lang/String;
    const/16 v21, 0x0

    aget-object v10, v13, v21

    .line 670
    .local v10, "key2":Ljava/lang/String;
    const-string v21, "gak"

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v23

    invoke-direct/range {v22 .. v23}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v23, "====buffer===="

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-static/range {v21 .. v22}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 671
    new-instance v9, Lorg/json/JSONObject;

    invoke-direct {v9}, Lorg/json/JSONObject;-><init>()V

    .line 672
    .local v9, "jsonObject":Lorg/json/JSONObject;
    new-instance v8, Lorg/json/JSONArray;

    invoke-direct {v8}, Lorg/json/JSONArray;-><init>()V

    .line 682
    .local v8, "jsonArray":Lorg/json/JSONArray;
    const-string v19, "({name:\'aio\'})"

    .line 683
    .local v19, "str2":Ljava/lang/String;
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v22

    invoke-direct/range {v21 .. v22}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v21

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 684
    const-string v21, "gak"

    new-instance v22, Ljava/lang/StringBuilder;

    const-string v23, "str==="

    invoke-direct/range {v22 .. v23}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v22

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-static/range {v21 .. v22}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 685
    const-string v21, "write"

    const-string v22, "write22222"

    invoke-static/range {v21 .. v22}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 687
    const-string v21, "gbk"

    move-object/from16 v0, v18

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/io/OutputStream;->write([B)V

    .line 688
    invoke-virtual {v12}, Ljava/io/OutputStream;->flush()V

    .line 691
    invoke-virtual/range {v17 .. v17}, Ljava/net/Socket;->shutdownOutput()V

    .line 694
    invoke-virtual {v12}, Ljava/io/OutputStream;->close()V

    .line 695
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    .line 696
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V

    .line 697
    invoke-virtual/range {v17 .. v17}, Ljava/net/Socket;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 699
    .end local v2    # "bff":Ljava/io/BufferedReader;
    .end local v3    # "buffer":Ljava/lang/String;
    .end local v5    # "input":Ljava/io/InputStream;
    .end local v6    # "ioo":Ljava/lang/String;
    .end local v7    # "iooi":[Ljava/lang/String;
    .end local v8    # "jsonArray":Lorg/json/JSONArray;
    .end local v9    # "jsonObject":Lorg/json/JSONObject;
    .end local v10    # "key2":Ljava/lang/String;
    .end local v11    # "line":Ljava/lang/String;
    .end local v12    # "output":Ljava/io/OutputStream;
    .end local v13    # "ppp":[Ljava/lang/String;
    .end local v14    # "s1":Ljava/lang/String;
    .end local v17    # "socket":Ljava/net/Socket;
    .end local v18    # "str":Ljava/lang/String;
    .end local v19    # "str2":Ljava/lang/String;
    .end local v20    # "str_buffer":[Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 701
    .local v4, "e":Ljava/io/IOException;
    const-string v21, "gak"

    new-instance v22, Ljava/lang/StringBuilder;

    const-string v23, "catch1"

    invoke-direct/range {v22 .. v23}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-static/range {v21 .. v22}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 702
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 705
    return-void

    .line 655
    .end local v4    # "e":Ljava/io/IOException;
    .restart local v2    # "bff":Ljava/io/BufferedReader;
    .restart local v3    # "buffer":Ljava/lang/String;
    .restart local v5    # "input":Ljava/io/InputStream;
    .restart local v11    # "line":Ljava/lang/String;
    .restart local v12    # "output":Ljava/io/OutputStream;
    .restart local v17    # "socket":Ljava/net/Socket;
    .restart local v18    # "str":Ljava/lang/String;
    :cond_2
    :try_start_1
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v22

    invoke-direct/range {v21 .. v22}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 656
    const-string v21, "gak"

    new-instance v22, Ljava/lang/StringBuilder;

    const-string v23, "line="

    invoke-direct/range {v22 .. v23}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v22

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-static/range {v21 .. v22}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 657
    const-string v21, ""

    move-object/from16 v0, v21

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    move-result v21

    if-eqz v21, :cond_1

    goto/16 :goto_1
.end method
