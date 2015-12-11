.class Lco/vine/android/ConversationActivity$2;
.super Ljava/lang/Object;
.source "ConversationActivity.java"

# interfaces
.implements Lcom/codebutler/android_websockets/WebSocketClient$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ConversationActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConversationActivity;


# direct methods
.method constructor <init>(Lco/vine/android/ConversationActivity;)V
    .locals 0

    .prologue
    .line 551
    iput-object p1, p0, Lco/vine/android/ConversationActivity$2;->this$0:Lco/vine/android/ConversationActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onConnect()V
    .locals 2

    .prologue
    .line 554
    const-string v0, "ConvActivity;RTC"

    const-string v1, "Websocket connected"

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 555
    iget-object v0, p0, Lco/vine/android/ConversationActivity$2;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mMainHandler:Landroid/os/Handler;
    invoke-static {v0}, Lco/vine/android/ConversationActivity;->access$500(Lco/vine/android/ConversationActivity;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/ConversationActivity$2;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mReconnectRunnable:Ljava/lang/Runnable;
    invoke-static {v1}, Lco/vine/android/ConversationActivity;->access$400(Lco/vine/android/ConversationActivity;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 556
    iget-object v0, p0, Lco/vine/android/ConversationActivity$2;->this$0:Lco/vine/android/ConversationActivity;

    iget-object v0, v0, Lco/vine/android/ConversationActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v0}, Lco/vine/android/client/AppSessionListener;->onWebSocketConnectComplete()V

    .line 557
    return-void
.end method

.method public onDisconnect(ILjava/lang/String;)V
    .locals 3
    .param p1, "code"    # I
    .param p2, "reason"    # Ljava/lang/String;

    .prologue
    .line 580
    const-string v0, "ConvActivity;RTC"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Websocket disconnected, reason="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 581
    iget-object v0, p0, Lco/vine/android/ConversationActivity$2;->this$0:Lco/vine/android/ConversationActivity;

    iget-object v0, v0, Lco/vine/android/ConversationActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v0}, Lco/vine/android/client/AppSessionListener;->onWebSocketDisconnected()V

    .line 582
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 586
    const-string v0, "ConvActivity;RTC"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Websocket error="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 587
    iget-object v0, p0, Lco/vine/android/ConversationActivity$2;->this$0:Lco/vine/android/ConversationActivity;

    iget-object v0, v0, Lco/vine/android/ConversationActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v0}, Lco/vine/android/client/AppSessionListener;->onWebSocketError()V

    .line 588
    return-void
.end method

.method public onMessage(Ljava/lang/String;)V
    .locals 7
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 561
    const-string v3, "ConvActivity;RTC"

    const-string v4, "Got string message: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 564
    :try_start_0
    invoke-static {p1}, Lco/vine/android/api/VineParsers;->createParser(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v2

    .line 565
    .local v2, "p":Lcom/fasterxml/jackson/core/JsonParser;
    invoke-static {v2}, Lco/vine/android/api/VineParsers;->parseRTCEvent(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/ArrayList;

    move-result-object v0

    .line 566
    .local v0, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCConversation;>;"
    if-eqz v0, :cond_0

    .line 567
    iget-object v3, p0, Lco/vine/android/ConversationActivity$2;->this$0:Lco/vine/android/ConversationActivity;

    iget-object v3, v3, Lco/vine/android/ConversationActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v3, v0}, Lco/vine/android/client/AppSessionListener;->onReceiveRTCMessage(Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 572
    .end local v0    # "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCConversation;>;"
    .end local v2    # "p":Lcom/fasterxml/jackson/core/JsonParser;
    :cond_0
    :goto_0
    return-void

    .line 569
    :catch_0
    move-exception v1

    .line 570
    .local v1, "e":Ljava/io/IOException;
    const-string v3, "Failed to parse message."

    invoke-static {v3, v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onMessage([B)V
    .locals 0
    .param p1, "data"    # [B

    .prologue
    .line 576
    return-void
.end method
