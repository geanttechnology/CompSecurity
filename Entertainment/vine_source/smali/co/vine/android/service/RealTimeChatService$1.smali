.class Lco/vine/android/service/RealTimeChatService$1;
.super Ljava/lang/Object;
.source "RealTimeChatService.java"

# interfaces
.implements Lcom/codebutler/android_websockets/WebSocketClient$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/RealTimeChatService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/service/RealTimeChatService;


# direct methods
.method constructor <init>(Lco/vine/android/service/RealTimeChatService;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lco/vine/android/service/RealTimeChatService$1;->this$0:Lco/vine/android/service/RealTimeChatService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onConnect()V
    .locals 3

    .prologue
    .line 125
    const-string v0, "RTCService"

    const-string v1, "Connected - now ready to subscribe to conversations."

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService$1;->this$0:Lco/vine/android/service/RealTimeChatService;

    # invokes: Lco/vine/android/service/RealTimeChatService;->removeReconnectCallback()V
    invoke-static {v0}, Lco/vine/android/service/RealTimeChatService;->access$000(Lco/vine/android/service/RealTimeChatService;)V

    .line 127
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService$1;->this$0:Lco/vine/android/service/RealTimeChatService;

    const/4 v1, 0x1

    const/4 v2, 0x0

    # invokes: Lco/vine/android/service/RealTimeChatService;->broadcastEvent(ILandroid/os/Bundle;)V
    invoke-static {v0, v1, v2}, Lco/vine/android/service/RealTimeChatService;->access$100(Lco/vine/android/service/RealTimeChatService;ILandroid/os/Bundle;)V

    .line 128
    return-void
.end method

.method public onDisconnect(ILjava/lang/String;)V
    .locals 7
    .param p1, "code"    # I
    .param p2, "reason"    # Ljava/lang/String;

    .prologue
    .line 147
    const-string v1, "RTCService"

    const-string v2, "Disconnected with code=%d, reason=%s, delay=%dms"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p2, v3, v4

    const/4 v4, 0x2

    iget-object v5, p0, Lco/vine/android/service/RealTimeChatService$1;->this$0:Lco/vine/android/service/RealTimeChatService;

    # getter for: Lco/vine/android/service/RealTimeChatService;->mReconnectDelay:J
    invoke-static {v5}, Lco/vine/android/service/RealTimeChatService;->access$200(Lco/vine/android/service/RealTimeChatService;)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 150
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "code"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 151
    const-string v1, "reason"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    iget-object v1, p0, Lco/vine/android/service/RealTimeChatService$1;->this$0:Lco/vine/android/service/RealTimeChatService;

    const/4 v2, 0x5

    # invokes: Lco/vine/android/service/RealTimeChatService;->broadcastEvent(ILandroid/os/Bundle;)V
    invoke-static {v1, v2, v0}, Lco/vine/android/service/RealTimeChatService;->access$100(Lco/vine/android/service/RealTimeChatService;ILandroid/os/Bundle;)V

    .line 153
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 157
    const-string v0, "RTCService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    return-void
.end method

.method public onMessage(Ljava/lang/String;)V
    .locals 8
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 132
    const-string v4, "RTCService"

    const-string v5, "Got string message: %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    :try_start_0
    invoke-static {p1}, Lco/vine/android/api/VineParsers;->createParser(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v3

    .line 136
    .local v3, "p":Lcom/fasterxml/jackson/core/JsonParser;
    invoke-static {v3}, Lco/vine/android/api/VineParsers;->parseRTCEvent(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/ArrayList;

    move-result-object v1

    .line 137
    .local v1, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCConversation;>;"
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 138
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "data"

    invoke-virtual {v0, v4, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 139
    iget-object v4, p0, Lco/vine/android/service/RealTimeChatService$1;->this$0:Lco/vine/android/service/RealTimeChatService;

    const/16 v5, 0x9

    # invokes: Lco/vine/android/service/RealTimeChatService;->broadcastEvent(ILandroid/os/Bundle;)V
    invoke-static {v4, v5, v0}, Lco/vine/android/service/RealTimeChatService;->access$100(Lco/vine/android/service/RealTimeChatService;ILandroid/os/Bundle;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 143
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCConversation;>;"
    .end local v3    # "p":Lcom/fasterxml/jackson/core/JsonParser;
    :goto_0
    return-void

    .line 140
    :catch_0
    move-exception v2

    .line 141
    .local v2, "e":Ljava/io/IOException;
    const-string v4, "Failed to parse message."

    invoke-static {v4, v2}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onMessage([B)V
    .locals 0
    .param p1, "data"    # [B

    .prologue
    .line 162
    return-void
.end method
