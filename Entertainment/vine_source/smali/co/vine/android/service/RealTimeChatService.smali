.class public Lco/vine/android/service/RealTimeChatService;
.super Landroid/app/Service;
.source "RealTimeChatService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;,
        Lco/vine/android/service/RealTimeChatService$VineServiceHandler;,
        Lco/vine/android/service/RealTimeChatService$Conversation;
    }
.end annotation


# static fields
.field public static final ACTION_CODE_ALERT_NEW_PRIVATE_MESSAGE:I = 0x8

.field public static final ACTION_CODE_CONNECT:I = 0x1

.field public static final ACTION_CODE_DISCONNECT:I = 0x5

.field public static final ACTION_CODE_ERROR:I = 0x6

.field public static final ACTION_CODE_NEW_WEBSOCKET_FRAME:I = 0x9

.field public static final ACTION_CODE_RECONNECT:I = 0x2

.field public static final ACTION_CODE_SUBSCRIBE:I = 0x3

.field public static final ACTION_CODE_UNSUBSCRIBE:I = 0x4

.field public static final ACTION_CODE_UPDATE_TYPING_STATE:I = 0x7

.field public static final ACTION_WEBSOCKET_EVENT:Ljava/lang/String; = "co.vine.android.rtc.WEBSOCKET_EVENT"

.field public static final EXTRA_ACTION_CODE:Ljava/lang/String; = "action_code"

.field public static final EXTRA_CODE:Ljava/lang/String; = "code"

.field public static final EXTRA_CONNECTED:Ljava/lang/String; = "connected"

.field public static final EXTRA_CONVERSATION_ID:Ljava/lang/String; = "conversation_id"

.field public static final EXTRA_DATA:Ljava/lang/String; = "data"

.field public static final EXTRA_IS_TYPING:Ljava/lang/String; = "is_typing"

.field public static final EXTRA_LAST_MESSAGE_ID:Ljava/lang/String; = "last_message_id"

.field public static final EXTRA_PID:Ljava/lang/String; = "pid"

.field public static final EXTRA_REASON:Ljava/lang/String; = "reason"

.field public static final EXTRA_RESPOND:Ljava/lang/String; = "respond"

.field public static final EXTRA_SESSION_KEY:Ljava/lang/String; = "s_key"

.field private static final INITIAL_RETRY_DELAY:J = 0x3e8L

.field private static final MAX_RETRY_DELAY:I = 0x3e80

.field public static final PARAM_CONNECTED:Ljava/lang/String; = "connected"

.field public static final PARAM_CONVERSATIONS:Ljava/lang/String; = "conversations"

.field public static final PARAM_LAST_MESSAGE_ID:Ljava/lang/String; = "last_message_id"

.field public static final PARAM_TYPING:Ljava/lang/String; = "typing"

.field public static final TAG:Ljava/lang/String; = "RTCService"


# instance fields
.field private mClient:Lcom/codebutler/android_websockets/WebSocketClient;

.field private mExecutor:Ljava/util/concurrent/ExecutorService;

.field private mMainHandler:Landroid/os/Handler;

.field private mMessenger:Landroid/os/Messenger;

.field private mReconnectDelay:J

.field private final mReconnectRunnable:Ljava/lang/Runnable;

.field private mRtcUrl:Ljava/lang/String;

.field private mWebSocketListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 122
    new-instance v0, Lco/vine/android/service/RealTimeChatService$1;

    invoke-direct {v0, p0}, Lco/vine/android/service/RealTimeChatService$1;-><init>(Lco/vine/android/service/RealTimeChatService;)V

    iput-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mWebSocketListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    .line 172
    new-instance v0, Lco/vine/android/service/RealTimeChatService$2;

    invoke-direct {v0, p0}, Lco/vine/android/service/RealTimeChatService$2;-><init>(Lco/vine/android/service/RealTimeChatService;)V

    iput-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mReconnectRunnable:Ljava/lang/Runnable;

    .line 271
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/service/RealTimeChatService;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService;

    .prologue
    .line 36
    invoke-direct {p0}, Lco/vine/android/service/RealTimeChatService;->removeReconnectCallback()V

    return-void
.end method

.method static synthetic access$100(Lco/vine/android/service/RealTimeChatService;ILandroid/os/Bundle;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroid/os/Bundle;

    .prologue
    .line 36
    invoke-direct {p0, p1, p2}, Lco/vine/android/service/RealTimeChatService;->broadcastEvent(ILandroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$1100(Lco/vine/android/service/RealTimeChatService;)Ljava/util/concurrent/ExecutorService;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService;

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mExecutor:Ljava/util/concurrent/ExecutorService;

    return-object v0
.end method

.method static synthetic access$1200(Lco/vine/android/service/RealTimeChatService;ILandroid/os/Bundle;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroid/os/Bundle;

    .prologue
    .line 36
    invoke-direct {p0, p1, p2}, Lco/vine/android/service/RealTimeChatService;->executeAction(ILandroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$200(Lco/vine/android/service/RealTimeChatService;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService;

    .prologue
    .line 36
    iget-wide v0, p0, Lco/vine/android/service/RealTimeChatService;->mReconnectDelay:J

    return-wide v0
.end method

.method static synthetic access$202(Lco/vine/android/service/RealTimeChatService;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService;
    .param p1, "x1"    # J

    .prologue
    .line 36
    iput-wide p1, p0, Lco/vine/android/service/RealTimeChatService;->mReconnectDelay:J

    return-wide p1
.end method

.method static synthetic access$300(Lco/vine/android/service/RealTimeChatService;)Lcom/codebutler/android_websockets/WebSocketClient;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService;

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/service/RealTimeChatService;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService;

    .prologue
    .line 36
    invoke-direct {p0}, Lco/vine/android/service/RealTimeChatService;->clientIsActive()Z

    move-result v0

    return v0
.end method

.method static synthetic access$500(Lco/vine/android/service/RealTimeChatService;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService;

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mReconnectRunnable:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/service/RealTimeChatService;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService;

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mMainHandler:Landroid/os/Handler;

    return-object v0
.end method

.method private declared-synchronized broadcastEvent(ILandroid/os/Bundle;)V
    .locals 2
    .param p1, "actionCode"    # I
    .param p2, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 166
    monitor-enter p0

    :try_start_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "co.vine.android.rtc.WEBSOCKET_EVENT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 167
    .local v0, "intent":Landroid/content/Intent;
    if-eqz p2, :cond_0

    invoke-virtual {v0, p2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 168
    :cond_0
    const-string v1, "action_code"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 169
    const-string v1, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v0, v1}, Lco/vine/android/service/RealTimeChatService;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 170
    monitor-exit p0

    return-void

    .line 166
    .end local v0    # "intent":Landroid/content/Intent;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private declared-synchronized clientIsActive()Z
    .locals 2

    .prologue
    .line 186
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    .line 187
    .local v0, "client":Lcom/codebutler/android_websockets/WebSocketClient;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/codebutler/android_websockets/WebSocketClient;->isConnected()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    monitor-exit p0

    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 186
    .end local v0    # "client":Lcom/codebutler/android_websockets/WebSocketClient;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private declared-synchronized disconnect()V
    .locals 2

    .prologue
    .line 94
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    .line 95
    .local v0, "client":Lcom/codebutler/android_websockets/WebSocketClient;
    if-eqz v0, :cond_0

    .line 96
    invoke-virtual {v0}, Lcom/codebutler/android_websockets/WebSocketClient;->disconnect()V

    .line 97
    const/4 v1, 0x0

    iput-object v1, p0, Lco/vine/android/service/RealTimeChatService;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 99
    :cond_0
    monitor-exit p0

    return-void

    .line 94
    .end local v0    # "client":Lcom/codebutler/android_websockets/WebSocketClient;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private executeAction(ILandroid/os/Bundle;)V
    .locals 11
    .param p1, "actionCode"    # I
    .param p2, "b"    # Landroid/os/Bundle;

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 316
    packed-switch p1, :pswitch_data_0

    .line 374
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 318
    :pswitch_1
    const-string v7, "s_key"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 319
    .local v6, "sessionKey":Ljava/lang/String;
    invoke-direct {p0}, Lco/vine/android/service/RealTimeChatService;->removeReconnectCallback()V

    .line 320
    invoke-virtual {p0, v6}, Lco/vine/android/service/RealTimeChatService;->prepareClient(Ljava/lang/String;)V

    .line 321
    iget-object v7, p0, Lco/vine/android/service/RealTimeChatService;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    invoke-virtual {v7}, Lcom/codebutler/android_websockets/WebSocketClient;->isConnected()Z

    move-result v7

    if-nez v7, :cond_0

    .line 322
    iget-object v7, p0, Lco/vine/android/service/RealTimeChatService;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    invoke-virtual {v7}, Lcom/codebutler/android_websockets/WebSocketClient;->connect()V

    goto :goto_0

    .line 327
    .end local v6    # "sessionKey":Ljava/lang/String;
    :pswitch_2
    const-string v7, "s_key"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 328
    .restart local v6    # "sessionKey":Ljava/lang/String;
    invoke-virtual {p0, v6}, Lco/vine/android/service/RealTimeChatService;->prepareClient(Ljava/lang/String;)V

    .line 329
    invoke-direct {p0}, Lco/vine/android/service/RealTimeChatService;->removeReconnectCallback()V

    .line 331
    const-wide/16 v7, 0x3e8

    iput-wide v7, p0, Lco/vine/android/service/RealTimeChatService;->mReconnectDelay:J

    .line 332
    iget-object v7, p0, Lco/vine/android/service/RealTimeChatService;->mMainHandler:Landroid/os/Handler;

    iget-object v8, p0, Lco/vine/android/service/RealTimeChatService;->mReconnectRunnable:Ljava/lang/Runnable;

    iget-wide v9, p0, Lco/vine/android/service/RealTimeChatService;->mReconnectDelay:J

    invoke-virtual {v7, v8, v9, v10}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 336
    .end local v6    # "sessionKey":Ljava/lang/String;
    :pswitch_3
    const-string v7, "conversation_id"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 337
    .local v1, "conversationId":Ljava/lang/Long;
    new-instance v7, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    invoke-direct {v7}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;-><init>()V

    invoke-virtual {v7}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->setConnected()Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    move-result-object v7

    invoke-virtual {v7}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->build()Lco/vine/android/service/RealTimeChatService$Conversation;

    move-result-object v0

    .line 340
    .local v0, "conversation":Lco/vine/android/service/RealTimeChatService$Conversation;
    new-array v7, v10, [Lco/vine/android/service/RealTimeChatService$Conversation;

    aput-object v0, v7, v9

    invoke-direct {p0, v1, v7}, Lco/vine/android/service/RealTimeChatService;->getPayload(Ljava/lang/Long;[Lco/vine/android/service/RealTimeChatService$Conversation;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v7}, Lco/vine/android/service/RealTimeChatService;->send(Ljava/lang/String;)V

    goto :goto_0

    .line 344
    .end local v0    # "conversation":Lco/vine/android/service/RealTimeChatService$Conversation;
    .end local v1    # "conversationId":Ljava/lang/Long;
    :pswitch_4
    const-string v7, "conversation_id"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 345
    .restart local v1    # "conversationId":Ljava/lang/Long;
    new-instance v7, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    invoke-direct {v7}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;-><init>()V

    invoke-virtual {v7}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->build()Lco/vine/android/service/RealTimeChatService$Conversation;

    move-result-object v0

    .line 346
    .restart local v0    # "conversation":Lco/vine/android/service/RealTimeChatService$Conversation;
    new-array v7, v10, [Lco/vine/android/service/RealTimeChatService$Conversation;

    aput-object v0, v7, v9

    invoke-direct {p0, v1, v7}, Lco/vine/android/service/RealTimeChatService;->getPayload(Ljava/lang/Long;[Lco/vine/android/service/RealTimeChatService$Conversation;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v7}, Lco/vine/android/service/RealTimeChatService;->send(Ljava/lang/String;)V

    goto :goto_0

    .line 350
    .end local v0    # "conversation":Lco/vine/android/service/RealTimeChatService$Conversation;
    .end local v1    # "conversationId":Ljava/lang/Long;
    :pswitch_5
    invoke-direct {p0}, Lco/vine/android/service/RealTimeChatService;->disconnect()V

    goto :goto_0

    .line 354
    :pswitch_6
    const-string v7, "is_typing"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    .line 355
    .local v3, "isTyping":Z
    const-string v7, "conversation_id"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 356
    .restart local v1    # "conversationId":Ljava/lang/Long;
    new-instance v7, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    invoke-direct {v7}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;-><init>()V

    invoke-virtual {v7}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->setConnected()Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    move-result-object v7

    invoke-virtual {v7, v3}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->setTyping(Z)Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    move-result-object v7

    invoke-virtual {v7}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->build()Lco/vine/android/service/RealTimeChatService$Conversation;

    move-result-object v0

    .line 360
    .restart local v0    # "conversation":Lco/vine/android/service/RealTimeChatService$Conversation;
    new-array v7, v10, [Lco/vine/android/service/RealTimeChatService$Conversation;

    aput-object v0, v7, v9

    invoke-direct {p0, v1, v7}, Lco/vine/android/service/RealTimeChatService;->getPayload(Ljava/lang/Long;[Lco/vine/android/service/RealTimeChatService$Conversation;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v7}, Lco/vine/android/service/RealTimeChatService;->send(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 364
    .end local v0    # "conversation":Lco/vine/android/service/RealTimeChatService$Conversation;
    .end local v1    # "conversationId":Ljava/lang/Long;
    .end local v3    # "isTyping":Z
    :pswitch_7
    const-string v7, "conversation_id"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v1

    .line 365
    .local v1, "conversationId":J
    const-string v7, "last_message_id"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 366
    .local v4, "lastMessageId":J
    new-instance v7, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    invoke-direct {v7}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;-><init>()V

    invoke-virtual {v7}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->setConnected()Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    move-result-object v7

    invoke-virtual {v7, v4, v5}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->setLastMessageId(J)Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    move-result-object v7

    invoke-virtual {v7}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->build()Lco/vine/android/service/RealTimeChatService$Conversation;

    move-result-object v0

    .line 370
    .restart local v0    # "conversation":Lco/vine/android/service/RealTimeChatService$Conversation;
    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    new-array v8, v10, [Lco/vine/android/service/RealTimeChatService$Conversation;

    aput-object v0, v8, v9

    invoke-direct {p0, v7, v8}, Lco/vine/android/service/RealTimeChatService;->getPayload(Ljava/lang/Long;[Lco/vine/android/service/RealTimeChatService$Conversation;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v7}, Lco/vine/android/service/RealTimeChatService;->send(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 316
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_0
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method private varargs declared-synchronized getPayload(Ljava/lang/Long;[Lco/vine/android/service/RealTimeChatService$Conversation;)Ljava/lang/String;
    .locals 13
    .param p1, "conversationId"    # Ljava/lang/Long;
    .param p2, "conversations"    # [Lco/vine/android/service/RealTimeChatService$Conversation;

    .prologue
    .line 191
    monitor-enter p0

    :try_start_0
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 192
    .local v2, "conversationsMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Ljava/lang/Object;>;"
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 193
    .local v4, "event":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/HashMap<Ljava/lang/Long;Ljava/lang/Object;>;>;"
    move-object v0, p2

    .local v0, "arr$":[Lco/vine/android/service/RealTimeChatService$Conversation;
    array-length v7, v0

    .local v7, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v7, :cond_0

    aget-object v1, v0, v5

    .line 194
    .local v1, "conversation":Lco/vine/android/service/RealTimeChatService$Conversation;
    invoke-virtual {v2, p1, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 193
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 196
    .end local v1    # "conversation":Lco/vine/android/service/RealTimeChatService$Conversation;
    :cond_0
    const-string v10, "conversations"

    invoke-virtual {v4, v10, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 198
    new-instance v8, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v8}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    .line 199
    .local v8, "mapper":Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-virtual {v8, v4}, Lcom/fasterxml/jackson/databind/ObjectMapper;->valueToTree(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonNode;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v6

    .line 203
    .local v6, "jsonBody":Lcom/fasterxml/jackson/databind/JsonNode;
    :try_start_1
    invoke-virtual {v8, v6}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writeValueAsString(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    .line 204
    .local v9, "payload":Ljava/lang/String;
    const-string v10, "RTCService"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "RTC event payload="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 208
    :goto_1
    monitor-exit p0

    return-object v9

    .line 205
    .end local v9    # "payload":Ljava/lang/String;
    :catch_0
    move-exception v3

    .line 206
    .local v3, "e":Ljava/lang/Exception;
    :try_start_2
    const-string v9, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .restart local v9    # "payload":Ljava/lang/String;
    goto :goto_1

    .line 191
    .end local v0    # "arr$":[Lco/vine/android/service/RealTimeChatService$Conversation;
    .end local v2    # "conversationsMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Ljava/lang/Object;>;"
    .end local v3    # "e":Ljava/lang/Exception;
    .end local v4    # "event":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/HashMap<Ljava/lang/Long;Ljava/lang/Object;>;>;"
    .end local v5    # "i$":I
    .end local v6    # "jsonBody":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v7    # "len$":I
    .end local v8    # "mapper":Lcom/fasterxml/jackson/databind/ObjectMapper;
    .end local v9    # "payload":Ljava/lang/String;
    :catchall_0
    move-exception v10

    monitor-exit p0

    throw v10
.end method

.method private removeReconnectCallback()V
    .locals 2

    .prologue
    .line 312
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mMainHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/service/RealTimeChatService;->mReconnectRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 313
    return-void
.end method

.method private send(Ljava/lang/String;)V
    .locals 3
    .param p1, "payload"    # Ljava/lang/String;

    .prologue
    .line 302
    :try_start_0
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    .line 303
    .local v0, "client":Lcom/codebutler/android_websockets/WebSocketClient;
    if-eqz v0, :cond_0

    invoke-direct {p0}, Lco/vine/android/service/RealTimeChatService;->clientIsActive()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 304
    invoke-virtual {v0, p1}, Lcom/codebutler/android_websockets/WebSocketClient;->send(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 309
    .end local v0    # "client":Lcom/codebutler/android_websockets/WebSocketClient;
    :cond_0
    :goto_0
    return-void

    .line 306
    :catch_0
    move-exception v1

    .line 307
    .local v1, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v1}, Ljava/lang/IllegalStateException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 103
    const-string v0, "RTCService"

    const-string v1, "rtc service was bound"

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mMessenger:Landroid/os/Messenger;

    invoke-virtual {v0}, Landroid/os/Messenger;->getBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public onCreate()V
    .locals 2

    .prologue
    .line 81
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 82
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mMainHandler:Landroid/os/Handler;

    .line 83
    invoke-static {}, Ljava/util/concurrent/Executors;->newCachedThreadPool()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mExecutor:Ljava/util/concurrent/ExecutorService;

    .line 84
    new-instance v0, Landroid/os/Messenger;

    new-instance v1, Lco/vine/android/service/RealTimeChatService$VineServiceHandler;

    invoke-direct {v1, p0}, Lco/vine/android/service/RealTimeChatService$VineServiceHandler;-><init>(Lco/vine/android/service/RealTimeChatService;)V

    invoke-direct {v0, v1}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mMessenger:Landroid/os/Messenger;

    .line 85
    invoke-static {p0}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/VineAPI;->getRtcUrl()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/service/RealTimeChatService;->mRtcUrl:Ljava/lang/String;

    .line 86
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 213
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 214
    invoke-direct {p0}, Lco/vine/android/service/RealTimeChatService;->removeReconnectCallback()V

    .line 215
    invoke-direct {p0}, Lco/vine/android/service/RealTimeChatService;->disconnect()V

    .line 216
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 90
    const/4 v0, 0x2

    return v0
.end method

.method public declared-synchronized prepareClient(Ljava/lang/String;)V
    .locals 9
    .param p1, "sessionKey"    # Ljava/lang/String;

    .prologue
    .line 108
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lco/vine/android/service/RealTimeChatService;->clientIsActive()Z

    move-result v4

    if-nez v4, :cond_0

    .line 109
    const-string v4, "RTCService"

    const-string v5, "preparing client now"

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 110
    invoke-static {p0}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v0

    .line 111
    .local v0, "api":Lco/vine/android/client/VineAPI;
    iget-object v4, p0, Lco/vine/android/service/RealTimeChatService;->mRtcUrl:Ljava/lang/String;

    invoke-static {v4}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v3

    .line 112
    .local v3, "uri":Ljava/net/URI;
    const/4 v4, 0x2

    new-array v4, v4, [Lorg/apache/http/message/BasicNameValuePair;

    const/4 v5, 0x0

    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v7, "vine-session-id"

    invoke-direct {v6, v7, p1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v6, v4, v5

    const/4 v5, 0x1

    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v7, "X-Vine-Client"

    invoke-virtual {v0}, Lco/vine/android/client/VineAPI;->getVineClientHeader()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v6, v7, v8}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v6, v4, v5

    invoke-static {v4}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    .line 116
    .local v2, "extraHeaders":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/message/BasicNameValuePair;>;"
    const-string v4, "RTCService"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Creating client: sessionKey="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", uri="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v3}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    new-instance v1, Lcom/codebutler/android_websockets/WebSocketClient;

    iget-object v4, p0, Lco/vine/android/service/RealTimeChatService;->mWebSocketListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    invoke-direct {v1, v3, v4, v2}, Lcom/codebutler/android_websockets/WebSocketClient;-><init>(Ljava/net/URI;Lcom/codebutler/android_websockets/WebSocketClient$Listener;Ljava/util/List;)V

    .line 118
    .local v1, "client":Lcom/codebutler/android_websockets/WebSocketClient;
    iput-object v1, p0, Lco/vine/android/service/RealTimeChatService;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 120
    .end local v0    # "api":Lco/vine/android/client/VineAPI;
    .end local v1    # "client":Lcom/codebutler/android_websockets/WebSocketClient;
    .end local v2    # "extraHeaders":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v3    # "uri":Ljava/net/URI;
    :cond_0
    monitor-exit p0

    return-void

    .line 108
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4
.end method
