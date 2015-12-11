.class Lcom/codebutler/android_websockets/WebSocketClient$2;
.super Ljava/lang/Object;
.source "WebSocketClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/codebutler/android_websockets/WebSocketClient;->disconnect()V
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
    .line 177
    iput-object p1, p0, Lcom/codebutler/android_websockets/WebSocketClient$2;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 181
    :try_start_0
    iget-object v1, p0, Lcom/codebutler/android_websockets/WebSocketClient$2;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;
    invoke-static {v1}, Lcom/codebutler/android_websockets/WebSocketClient;->access$400(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/Socket;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/Socket;->close()V

    .line 182
    const-string v1, "RTC"

    const-string v2, "WebSocket disconnected"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 183
    iget-object v1, p0, Lcom/codebutler/android_websockets/WebSocketClient$2;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    const/4 v2, 0x0

    # setter for: Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;
    invoke-static {v1, v2}, Lcom/codebutler/android_websockets/WebSocketClient;->access$402(Lcom/codebutler/android_websockets/WebSocketClient;Ljava/net/Socket;)Ljava/net/Socket;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 188
    :goto_0
    return-void

    .line 184
    :catch_0
    move-exception v0

    .line 185
    .local v0, "ex":Ljava/io/IOException;
    const-string v1, "WebSocketClient"

    const-string v2, "Error while disconnecting"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 186
    iget-object v1, p0, Lcom/codebutler/android_websockets/WebSocketClient$2;->this$0:Lcom/codebutler/android_websockets/WebSocketClient;

    # getter for: Lcom/codebutler/android_websockets/WebSocketClient;->mListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;
    invoke-static {v1}, Lcom/codebutler/android_websockets/WebSocketClient;->access$1000(Lcom/codebutler/android_websockets/WebSocketClient;)Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onError(Ljava/lang/Exception;)V

    goto :goto_0
.end method
