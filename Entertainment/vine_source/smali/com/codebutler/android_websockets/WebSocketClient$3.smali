.class Lcom/codebutler/android_websockets/WebSocketClient$3;
.super Ljava/lang/Object;
.source "WebSocketClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/codebutler/android_websockets/WebSocketClient;->sendFrame([B)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/codebutler/android_websockets/WebSocketClient;

.field final synthetic val$frame:[B


# direct methods
.method constructor <init>(Lcom/codebutler/android_websockets/WebSocketClient;[B)V
    .locals 0

    .prologue
    .line 251
    iput-object p1, p0, Lcom/codebutler/android_websockets/WebSocketClient$3;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    iput-object p2, p0, Lcom/codebutler/android_websockets/WebSocketClient$3;->val$frame:[B

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 255
    :try_start_0
    iget-object v2, p0, Lcom/codebutler/android_websockets/WebSocketClient$3;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mSendLock:Ljava/lang/Object;
    invoke-static {v2}, Lcom/codebutler/android_websockets/WebSocketClient;->access$1200(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/lang/Object;

    move-result-object v3

    monitor-enter v3
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 256
    :try_start_1
    iget-object v2, p0, Lcom/codebutler/android_websockets/WebSocketClient$3;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;
    invoke-static {v2}, Lcom/codebutler/android_websockets/WebSocketClient;->access$400(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/Socket;

    move-result-object v2

    if-nez v2, :cond_0

    .line 257
    new-instance v2, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Socket not connected while trying to write: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/codebutler/android_websockets/WebSocketClient$3;->val$frame:[B

    invoke-static {v5}, Ljava/util/Arrays;->toString([B)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 265
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v2
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 266
    :catch_0
    move-exception v0

    .line 267
    .local v0, "e":Ljava/io/IOException;
    iget-object v2, p0, Lcom/codebutler/android_websockets/WebSocketClient$3;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;
    invoke-static {v2}, Lcom/codebutler/android_websockets/WebSocketClient;->access$1000(Lcom/codebutler/android_websockets/WebSocketClient;)Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v2

    invoke-interface {v2, v0}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onError(Ljava/lang/Exception;)V

    .line 269
    .end local v0    # "e":Ljava/io/IOException;
    :goto_0
    return-void

    .line 261
    :cond_0
    :try_start_3
    iget-object v2, p0, Lcom/codebutler/android_websockets/WebSocketClient$3;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;
    invoke-static {v2}, Lcom/codebutler/android_websockets/WebSocketClient;->access$400(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/Socket;

    move-result-object v2

    invoke-virtual {v2}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v1

    .line 262
    .local v1, "outputStream":Ljava/io/OutputStream;
    iget-object v2, p0, Lcom/codebutler/android_websockets/WebSocketClient$3;->val$frame:[B

    invoke-virtual {v1, v2}, Ljava/io/OutputStream;->write([B)V

    .line 263
    invoke-virtual {v1}, Ljava/io/OutputStream;->flush()V

    .line 265
    monitor-exit v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0
.end method
