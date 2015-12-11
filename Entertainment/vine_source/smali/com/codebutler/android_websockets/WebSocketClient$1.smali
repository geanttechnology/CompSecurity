.class Lcom/codebutler/android_websockets/WebSocketClient$1;
.super Ljava/lang/Object;
.source "WebSocketClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/codebutler/android_websockets/WebSocketClient;->connect()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/codebutler/android_websockets/WebSocketClient;


# direct methods
.method constructor <init>(Lcom/codebutler/android_websockets/WebSocketClient;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 22

    .prologue
    .line 87
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    const/16 v19, 0x1

    # setter for: Lcom/codebutler/android_websockets/WebSocketClient;->mConnectionFlag:I
    invoke-static/range {v18 .. v19}, Lcom/codebutler/android_websockets/WebSocketClient;->access$002(Lcom/codebutler/android_websockets/WebSocketClient;I)I

    .line 88
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # invokes: Lcom/codebutler/android_websockets/WebSocketClient;->createSecret()Ljava/lang/String;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$100(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/lang/String;

    move-result-object v14

    .line 90
    .local v14, "secret":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mURI:Ljava/net/URI;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$200(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/URI;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v18

    if-eqz v18, :cond_1

    const-string v13, "/"

    .line 91
    .local v13, "path":Ljava/lang/String;
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mURI:Ljava/net/URI;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$200(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/URI;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/net/URI;->getQuery()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v18

    if-nez v18, :cond_0

    .line 92
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v18

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "?"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v19, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mURI:Ljava/net/URI;
    invoke-static/range {v19 .. v19}, Lcom/codebutler/android_websockets/WebSocketClient;->access$200(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/URI;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/net/URI;->getQuery()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 95
    :cond_0
    new-instance v10, Ljava/net/URI;

    const-string v18, "https"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "//"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v20, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mURI:Ljava/net/URI;
    invoke-static/range {v20 .. v20}, Lcom/codebutler/android_websockets/WebSocketClient;->access$200(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/URI;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    const/16 v20, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-direct {v10, v0, v1, v2}, Ljava/net/URI;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    .local v10, "origin":Ljava/net/URI;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # invokes: Lcom/codebutler/android_websockets/WebSocketClient;->getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$300(Lcom/codebutler/android_websockets/WebSocketClient;)Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v6

    .line 98
    .local v6, "factory":Ljavax/net/SocketFactory;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v19, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mURI:Ljava/net/URI;
    invoke-static/range {v19 .. v19}, Lcom/codebutler/android_websockets/WebSocketClient;->access$200(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/URI;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v19

    const/16 v20, 0x1bb

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v6, v0, v1}, Ljavax/net/SocketFactory;->createSocket(Ljava/lang/String;I)Ljava/net/Socket;

    move-result-object v19

    # setter for: Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;
    invoke-static/range {v18 .. v19}, Lcom/codebutler/android_websockets/WebSocketClient;->access$402(Lcom/codebutler/android_websockets/WebSocketClient;Ljava/net/Socket;)Ljava/net/Socket;

    .line 100
    new-instance v11, Ljava/io/PrintWriter;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$400(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/Socket;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-direct {v11, v0}, Ljava/io/PrintWriter;-><init>(Ljava/io/OutputStream;)V

    .line 101
    .local v11, "out":Ljava/io/PrintWriter;
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "GET "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " HTTP/1.1\r\n"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 102
    const-string v18, "Upgrade: websocket\r\n"

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 103
    const-string v18, "Connection: Upgrade\r\n"

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 104
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "Host: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v19, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mURI:Ljava/net/URI;
    invoke-static/range {v19 .. v19}, Lcom/codebutler/android_websockets/WebSocketClient;->access$200(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/URI;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "\r\n"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 105
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "Origin: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual {v10}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "\r\n"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 106
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "Sec-WebSocket-Key: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "\r\n"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 107
    const-string v18, "Sec-WebSocket-Version: 13\r\n"

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 108
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mExtraHeaders:Ljava/util/List;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$500(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/util/List;

    move-result-object v18

    if-eqz v18, :cond_2

    .line 109
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mExtraHeaders:Ljava/util/List;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$500(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/util/List;

    move-result-object v18

    invoke-interface/range {v18 .. v18}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_2

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lorg/apache/http/NameValuePair;

    .line 110
    .local v12, "pair":Lorg/apache/http/NameValuePair;
    const-string v18, "%s: %s\r\n"

    const/16 v19, 0x2

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-interface {v12}, Lorg/apache/http/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    const/16 v20, 0x1

    invoke-interface {v12}, Lorg/apache/http/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/net/ssl/SSLException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    goto :goto_1

    .line 154
    .end local v6    # "factory":Ljavax/net/SocketFactory;
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v10    # "origin":Ljava/net/URI;
    .end local v11    # "out":Ljava/io/PrintWriter;
    .end local v12    # "pair":Lorg/apache/http/NameValuePair;
    .end local v13    # "path":Ljava/lang/String;
    .end local v14    # "secret":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 155
    .local v4, "ex":Ljava/io/EOFException;
    const-string v18, "WebSocketClient"

    const-string v19, "WebSocket EOF!"

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-static {v0, v1, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 156
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$1000(Lcom/codebutler/android_websockets/WebSocketClient;)Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v18

    const/16 v19, 0x0

    const-string v20, "EOF"

    invoke-interface/range {v18 .. v20}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onDisconnect(ILjava/lang/String;)V

    .line 157
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    # setter for: Lcom/codebutler/android_websockets/WebSocketClient;->mConnectionFlag:I
    invoke-static/range {v18 .. v19}, Lcom/codebutler/android_websockets/WebSocketClient;->access$002(Lcom/codebutler/android_websockets/WebSocketClient;I)I

    .line 169
    .end local v4    # "ex":Ljava/io/EOFException;
    :goto_2
    return-void

    .line 90
    .restart local v14    # "secret":Ljava/lang/String;
    :cond_1
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mURI:Ljava/net/URI;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$200(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/URI;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v13

    goto/16 :goto_0

    .line 113
    .restart local v6    # "factory":Ljavax/net/SocketFactory;
    .restart local v10    # "origin":Ljava/net/URI;
    .restart local v11    # "out":Ljava/io/PrintWriter;
    .restart local v13    # "path":Ljava/lang/String;
    :cond_2
    const-string v18, "\r\n"

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 114
    invoke-virtual {v11}, Ljava/io/PrintWriter;->flush()V

    .line 116
    new-instance v16, Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$400(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/Socket;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    move-result-object v18

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-direct {v0, v1}, Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 119
    .local v16, "stream":Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    # invokes: Lcom/codebutler/android_websockets/WebSocketClient;->readLine(Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;)Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/codebutler/android_websockets/WebSocketClient;->access$600(Lcom/codebutler/android_websockets/WebSocketClient;Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;)Ljava/lang/String;

    move-result-object v19

    # invokes: Lcom/codebutler/android_websockets/WebSocketClient;->parseStatusLine(Ljava/lang/String;)Lorg/apache/http/StatusLine;
    invoke-static/range {v18 .. v19}, Lcom/codebutler/android_websockets/WebSocketClient;->access$700(Lcom/codebutler/android_websockets/WebSocketClient;Ljava/lang/String;)Lorg/apache/http/StatusLine;

    move-result-object v15

    .line 120
    .local v15, "statusLine":Lorg/apache/http/StatusLine;
    if-nez v15, :cond_3

    .line 121
    new-instance v18, Lorg/apache/http/HttpException;

    const-string v19, "Received no reply from server."

    invoke-direct/range {v18 .. v19}, Lorg/apache/http/HttpException;-><init>(Ljava/lang/String;)V

    throw v18
    :try_end_1
    .catch Ljava/io/EOFException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljavax/net/ssl/SSLException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    .line 159
    .end local v6    # "factory":Ljavax/net/SocketFactory;
    .end local v10    # "origin":Ljava/net/URI;
    .end local v11    # "out":Ljava/io/PrintWriter;
    .end local v13    # "path":Ljava/lang/String;
    .end local v14    # "secret":Ljava/lang/String;
    .end local v15    # "statusLine":Lorg/apache/http/StatusLine;
    .end local v16    # "stream":Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;
    :catch_1
    move-exception v4

    .line 161
    .local v4, "ex":Ljavax/net/ssl/SSLException;
    const-string v18, "WebSocketClient"

    const-string v19, "Websocket SSL error!"

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-static {v0, v1, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 162
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$1000(Lcom/codebutler/android_websockets/WebSocketClient;)Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v18

    const/16 v19, 0x0

    const-string v20, "SSL"

    invoke-interface/range {v18 .. v20}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onDisconnect(ILjava/lang/String;)V

    .line 163
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    # setter for: Lcom/codebutler/android_websockets/WebSocketClient;->mConnectionFlag:I
    invoke-static/range {v18 .. v19}, Lcom/codebutler/android_websockets/WebSocketClient;->access$002(Lcom/codebutler/android_websockets/WebSocketClient;I)I

    goto :goto_2

    .line 122
    .end local v4    # "ex":Ljavax/net/ssl/SSLException;
    .restart local v6    # "factory":Ljavax/net/SocketFactory;
    .restart local v10    # "origin":Ljava/net/URI;
    .restart local v11    # "out":Ljava/io/PrintWriter;
    .restart local v13    # "path":Ljava/lang/String;
    .restart local v14    # "secret":Ljava/lang/String;
    .restart local v15    # "statusLine":Lorg/apache/http/StatusLine;
    .restart local v16    # "stream":Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;
    :cond_3
    :try_start_2
    invoke-interface {v15}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v18

    const/16 v19, 0x65

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_4

    .line 123
    new-instance v18, Lorg/apache/http/client/HttpResponseException;

    invoke-interface {v15}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v19

    invoke-interface {v15}, Lorg/apache/http/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v18 .. v20}, Lorg/apache/http/client/HttpResponseException;-><init>(ILjava/lang/String;)V

    throw v18
    :try_end_2
    .catch Ljava/io/EOFException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljavax/net/ssl/SSLException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 165
    .end local v6    # "factory":Ljavax/net/SocketFactory;
    .end local v10    # "origin":Ljava/net/URI;
    .end local v11    # "out":Ljava/io/PrintWriter;
    .end local v13    # "path":Ljava/lang/String;
    .end local v14    # "secret":Ljava/lang/String;
    .end local v15    # "statusLine":Lorg/apache/http/StatusLine;
    .end local v16    # "stream":Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;
    :catch_2
    move-exception v4

    .line 166
    .local v4, "ex":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$1000(Lcom/codebutler/android_websockets/WebSocketClient;)Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-interface {v0, v4}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onError(Ljava/lang/Exception;)V

    .line 167
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    # setter for: Lcom/codebutler/android_websockets/WebSocketClient;->mConnectionFlag:I
    invoke-static/range {v18 .. v19}, Lcom/codebutler/android_websockets/WebSocketClient;->access$002(Lcom/codebutler/android_websockets/WebSocketClient;I)I

    goto/16 :goto_2

    .line 128
    .end local v4    # "ex":Ljava/lang/Exception;
    .restart local v6    # "factory":Ljavax/net/SocketFactory;
    .restart local v10    # "origin":Ljava/net/URI;
    .restart local v11    # "out":Ljava/io/PrintWriter;
    .restart local v13    # "path":Ljava/lang/String;
    .restart local v14    # "secret":Ljava/lang/String;
    .restart local v15    # "statusLine":Lorg/apache/http/StatusLine;
    .restart local v16    # "stream":Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;
    :cond_4
    const/16 v17, 0x0

    .line 130
    .local v17, "validated":Z
    :cond_5
    :goto_3
    :try_start_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v16

    # invokes: Lcom/codebutler/android_websockets/WebSocketClient;->readLine(Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;)Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/codebutler/android_websockets/WebSocketClient;->access$600(Lcom/codebutler/android_websockets/WebSocketClient;Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;)Ljava/lang/String;

    move-result-object v9

    .local v9, "line":Ljava/lang/String;
    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v18

    if-nez v18, :cond_7

    .line 131
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    # invokes: Lcom/codebutler/android_websockets/WebSocketClient;->parseHeader(Ljava/lang/String;)Lorg/apache/http/Header;
    invoke-static {v0, v9}, Lcom/codebutler/android_websockets/WebSocketClient;->access$800(Lcom/codebutler/android_websockets/WebSocketClient;Ljava/lang/String;)Lorg/apache/http/Header;

    move-result-object v7

    .line 132
    .local v7, "header":Lorg/apache/http/Header;
    invoke-interface {v7}, Lorg/apache/http/Header;->getName()Ljava/lang/String;

    move-result-object v18

    const-string v19, "Sec-WebSocket-Accept"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_5

    .line 133
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    # invokes: Lcom/codebutler/android_websockets/WebSocketClient;->createSecretValidation(Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v0, v14}, Lcom/codebutler/android_websockets/WebSocketClient;->access$900(Lcom/codebutler/android_websockets/WebSocketClient;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 134
    .local v5, "expected":Ljava/lang/String;
    invoke-interface {v7}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 136
    .local v3, "actual":Ljava/lang/String;
    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-nez v18, :cond_6

    .line 137
    new-instance v18, Lorg/apache/http/HttpException;

    const-string v19, "Bad Sec-WebSocket-Accept header value."

    invoke-direct/range {v18 .. v19}, Lorg/apache/http/HttpException;-><init>(Ljava/lang/String;)V

    throw v18

    .line 140
    :cond_6
    const/16 v17, 0x1

    goto :goto_3

    .line 144
    .end local v3    # "actual":Ljava/lang/String;
    .end local v5    # "expected":Ljava/lang/String;
    .end local v7    # "header":Lorg/apache/http/Header;
    :cond_7
    if-nez v17, :cond_8

    .line 145
    new-instance v18, Lorg/apache/http/HttpException;

    const-string v19, "No Sec-WebSocket-Accept header."

    invoke-direct/range {v18 .. v19}, Lorg/apache/http/HttpException;-><init>(Ljava/lang/String;)V

    throw v18

    .line 148
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    const/16 v19, 0x2

    # setter for: Lcom/codebutler/android_websockets/WebSocketClient;->mConnectionFlag:I
    invoke-static/range {v18 .. v19}, Lcom/codebutler/android_websockets/WebSocketClient;->access$002(Lcom/codebutler/android_websockets/WebSocketClient;I)I

    .line 149
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$1000(Lcom/codebutler/android_websockets/WebSocketClient;)Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v18

    invoke-interface/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onConnect()V

    .line 152
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/codebutler/android_websockets/WebSocketClient$1;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    move-object/from16 v18, v0

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mParser:Lcom/codebutler/android_websockets/HybiParser;
    invoke-static/range {v18 .. v18}, Lcom/codebutler/android_websockets/WebSocketClient;->access$1100(Lcom/codebutler/android_websockets/WebSocketClient;)Lcom/codebutler/android_websockets/HybiParser;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/codebutler/android_websockets/HybiParser;->start(Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;)V
    :try_end_3
    .catch Ljava/io/EOFException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljavax/net/ssl/SSLException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    goto/16 :goto_2
.end method
