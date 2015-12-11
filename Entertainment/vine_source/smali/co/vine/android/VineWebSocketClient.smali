.class public Lco/vine/android/VineWebSocketClient;
.super Lcom/codebutler/android_websockets/WebSocketClient;
.source "VineWebSocketClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/VineWebSocketClient$1;,
        Lco/vine/android/VineWebSocketClient$Conversation;
    }
.end annotation


# static fields
.field public static final PARAM_CONNECTED:Ljava/lang/String; = "connected"

.field public static final PARAM_CONVERSATIONS:Ljava/lang/String; = "conversations"

.field public static final PARAM_LAST_MESSAGE_ID:Ljava/lang/String; = "last_message_id"

.field public static final PARAM_TYPING:Ljava/lang/String; = "typing"

.field private static final TAG:Ljava/lang/String; = "VineWebSocketClient;RTC"


# direct methods
.method public constructor <init>(Ljava/net/URI;Lcom/codebutler/android_websockets/WebSocketClient$Listener;Ljava/util/List;)V
    .locals 0
    .param p1, "uri"    # Ljava/net/URI;
    .param p2, "listener"    # Lcom/codebutler/android_websockets/WebSocketClient$Listener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Lcom/codebutler/android_websockets/WebSocketClient$Listener;",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 27
    .local p3, "extraHeaders":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/message/BasicNameValuePair;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/codebutler/android_websockets/WebSocketClient;-><init>(Ljava/net/URI;Lcom/codebutler/android_websockets/WebSocketClient$Listener;Ljava/util/List;)V

    .line 28
    return-void
.end method

.method private sendPayload(Ljava/lang/String;)V
    .locals 1
    .param p1, "payload"    # Ljava/lang/String;

    .prologue
    .line 77
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/VineWebSocketClient;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 78
    invoke-virtual {p0, p1}, Lco/vine/android/VineWebSocketClient;->send(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    :cond_0
    :goto_0
    return-void

    .line 80
    :catch_0
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method public alertNewPrivateMessage(JJ)V
    .locals 4
    .param p1, "conversationId"    # J
    .param p3, "lastMessageId"    # J

    .prologue
    const/4 v3, 0x0

    .line 67
    new-instance v1, Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    invoke-direct {v1}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;-><init>()V

    invoke-virtual {v1}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->setConnected()Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    move-result-object v1

    invoke-virtual {v1, p3, p4}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->setLastMessageId(J)Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    move-result-object v1

    invoke-virtual {v1, v3}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->setTyping(Z)Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->build()Lco/vine/android/VineWebSocketClient$Conversation;

    move-result-object v0

    .line 72
    .local v0, "conversation":Lco/vine/android/VineWebSocketClient$Conversation;
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Lco/vine/android/VineWebSocketClient$Conversation;

    aput-object v0, v2, v3

    invoke-virtual {p0, v1, v2}, Lco/vine/android/VineWebSocketClient;->getPayload(Ljava/lang/Long;[Lco/vine/android/VineWebSocketClient$Conversation;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lco/vine/android/VineWebSocketClient;->sendPayload(Ljava/lang/String;)V

    .line 73
    return-void
.end method

.method public varargs getPayload(Ljava/lang/Long;[Lco/vine/android/VineWebSocketClient$Conversation;)Ljava/lang/String;
    .locals 13
    .param p1, "conversationId"    # Ljava/lang/Long;
    .param p2, "conversations"    # [Lco/vine/android/VineWebSocketClient$Conversation;

    .prologue
    .line 31
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 32
    .local v2, "conversationsMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Long;Ljava/lang/Object;>;"
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 33
    .local v4, "event":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/HashMap<Ljava/lang/Long;Ljava/lang/Object;>;>;"
    move-object v0, p2

    .local v0, "arr$":[Lco/vine/android/VineWebSocketClient$Conversation;
    array-length v7, v0

    .local v7, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v7, :cond_0

    aget-object v1, v0, v5

    .line 34
    .local v1, "conversation":Lco/vine/android/VineWebSocketClient$Conversation;
    invoke-virtual {v2, p1, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 33
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 36
    .end local v1    # "conversation":Lco/vine/android/VineWebSocketClient$Conversation;
    :cond_0
    const-string v10, "conversations"

    invoke-virtual {v4, v10, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    new-instance v8, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v8}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    .line 39
    .local v8, "mapper":Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-virtual {v8, v4}, Lcom/fasterxml/jackson/databind/ObjectMapper;->valueToTree(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v6

    .line 43
    .local v6, "jsonBody":Lcom/fasterxml/jackson/databind/JsonNode;
    :try_start_0
    invoke-virtual {v8, v6}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writeValueAsString(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    .line 44
    .local v9, "payload":Ljava/lang/String;
    const-string v10, "VineWebSocketClient;RTC"

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
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 48
    :goto_1
    return-object v9

    .line 45
    .end local v9    # "payload":Ljava/lang/String;
    :catch_0
    move-exception v3

    .line 46
    .local v3, "e":Ljava/lang/Exception;
    const-string v9, ""

    .restart local v9    # "payload":Ljava/lang/String;
    goto :goto_1
.end method

.method public subscribeConversation(J)V
    .locals 4
    .param p1, "conversationId"    # J

    .prologue
    .line 52
    new-instance v1, Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    invoke-direct {v1}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;-><init>()V

    invoke-virtual {v1}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->setConnected()Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->build()Lco/vine/android/VineWebSocketClient$Conversation;

    move-result-object v0

    .line 55
    .local v0, "conversation":Lco/vine/android/VineWebSocketClient$Conversation;
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Lco/vine/android/VineWebSocketClient$Conversation;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-virtual {p0, v1, v2}, Lco/vine/android/VineWebSocketClient;->getPayload(Ljava/lang/Long;[Lco/vine/android/VineWebSocketClient$Conversation;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lco/vine/android/VineWebSocketClient;->sendPayload(Ljava/lang/String;)V

    .line 56
    return-void
.end method

.method public updateTypingState(JZ)V
    .locals 4
    .param p1, "conversationId"    # J
    .param p3, "isTyping"    # Z

    .prologue
    .line 59
    new-instance v1, Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    invoke-direct {v1}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;-><init>()V

    invoke-virtual {v1}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->setConnected()Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    move-result-object v1

    invoke-virtual {v1, p3}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->setTyping(Z)Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->build()Lco/vine/android/VineWebSocketClient$Conversation;

    move-result-object v0

    .line 63
    .local v0, "conversation":Lco/vine/android/VineWebSocketClient$Conversation;
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Lco/vine/android/VineWebSocketClient$Conversation;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-virtual {p0, v1, v2}, Lco/vine/android/VineWebSocketClient;->getPayload(Ljava/lang/Long;[Lco/vine/android/VineWebSocketClient$Conversation;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lco/vine/android/VineWebSocketClient;->sendPayload(Ljava/lang/String;)V

    .line 64
    return-void
.end method
