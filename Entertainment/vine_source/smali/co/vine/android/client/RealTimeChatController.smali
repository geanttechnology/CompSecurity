.class public Lco/vine/android/client/RealTimeChatController;
.super Ljava/lang/Object;
.source "RealTimeChatController.java"

# interfaces
.implements Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;


# static fields
.field private static final TAG:Ljava/lang/String; = "RTCController"

.field private static sInstance:Lco/vine/android/client/RealTimeChatController;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/client/AppSessionListener;",
            ">;"
        }
    .end annotation
.end field

.field private final mServiceConnection:Lco/vine/android/service/VineServiceConnection;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    new-instance v0, Lco/vine/android/service/VineServiceConnection;

    invoke-direct {v0, p1, p0}, Lco/vine/android/service/VineServiceConnection;-><init>(Landroid/content/Context;Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;)V

    iput-object v0, p0, Lco/vine/android/client/RealTimeChatController;->mServiceConnection:Lco/vine/android/service/VineServiceConnection;

    .line 39
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/RealTimeChatService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iget-object v1, p0, Lco/vine/android/client/RealTimeChatController;->mServiceConnection:Lco/vine/android/service/VineServiceConnection;

    const/4 v2, 0x1

    invoke-virtual {p1, v0, v1, v2}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/client/RealTimeChatController;->mListeners:Ljava/util/ArrayList;

    .line 42
    iput-object p1, p0, Lco/vine/android/client/RealTimeChatController;->mContext:Landroid/content/Context;

    .line 43
    return-void
.end method

.method private createServiceBundle()Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 85
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 87
    .local v0, "b":Landroid/os/Bundle;
    const/4 v2, 0x1

    :try_start_0
    invoke-direct {p0, v2}, Lco/vine/android/client/RealTimeChatController;->getActiveSession(Z)Lco/vine/android/client/Session;

    move-result-object v2

    invoke-direct {p0, v0, v2}, Lco/vine/android/client/RealTimeChatController;->injectServiceBundle(Landroid/os/Bundle;Lco/vine/android/client/Session;)Landroid/os/Bundle;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 90
    .end local v0    # "b":Landroid/os/Bundle;
    :goto_0
    return-object v0

    .line 88
    .restart local v0    # "b":Landroid/os/Bundle;
    :catch_0
    move-exception v1

    .line 89
    .local v1, "e":Ljava/lang/Exception;
    const-string v2, "Failed to get active session."

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;
    .locals 2
    .param p1, "actionCode"    # I
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 170
    const-string v0, "pid"

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v1

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 171
    iget-object v0, p0, Lco/vine/android/client/RealTimeChatController;->mServiceConnection:Lco/vine/android/service/VineServiceConnection;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/service/VineServiceConnection;->queueAndExecute(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getActiveSession(Z)Lco/vine/android/client/Session;
    .locals 1
    .param p1, "readOnly"    # Z

    .prologue
    .line 103
    iget-object v0, p0, Lco/vine/android/client/RealTimeChatController;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Lco/vine/android/client/VineAccountHelper;->getActiveSession(Landroid/content/Context;Z)Lco/vine/android/client/Session;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance(Landroid/content/Context;)Lco/vine/android/client/RealTimeChatController;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 31
    sget-object v0, Lco/vine/android/client/RealTimeChatController;->sInstance:Lco/vine/android/client/RealTimeChatController;

    if-nez v0, :cond_0

    .line 32
    new-instance v0, Lco/vine/android/client/RealTimeChatController;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lco/vine/android/client/RealTimeChatController;-><init>(Landroid/content/Context;)V

    sput-object v0, Lco/vine/android/client/RealTimeChatController;->sInstance:Lco/vine/android/client/RealTimeChatController;

    .line 34
    :cond_0
    sget-object v0, Lco/vine/android/client/RealTimeChatController;->sInstance:Lco/vine/android/client/RealTimeChatController;

    return-object v0
.end method

.method private injectServiceBundle(Landroid/os/Bundle;Lco/vine/android/client/Session;)Landroid/os/Bundle;
    .locals 3
    .param p1, "bundle"    # Landroid/os/Bundle;
    .param p2, "session"    # Lco/vine/android/client/Session;

    .prologue
    .line 95
    const-string v0, "s_key"

    invoke-virtual {p2}, Lco/vine/android/client/Session;->getSessionKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    const-string v0, "s_owner_id"

    invoke-virtual {p2}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v1

    invoke-virtual {p1, v0, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 97
    const-string v0, "a_name"

    invoke-virtual {p2}, Lco/vine/android/client/Session;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    const-string v0, "email"

    invoke-virtual {p2}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    return-object p1
.end method


# virtual methods
.method public addListener(Lco/vine/android/client/AppSessionListener;)V
    .locals 1
    .param p1, "listener"    # Lco/vine/android/client/AppSessionListener;

    .prologue
    .line 107
    iget-object v0, p0, Lco/vine/android/client/RealTimeChatController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 111
    :goto_0
    return-void

    .line 110
    :cond_0
    iget-object v0, p0, Lco/vine/android/client/RealTimeChatController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public connectChatService()Ljava/lang/String;
    .locals 3

    .prologue
    .line 46
    invoke-direct {p0}, Lco/vine/android/client/RealTimeChatController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 48
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "respond"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 49
    const/4 v1, 0x1

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/RealTimeChatController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public disconnect()V
    .locals 3

    .prologue
    .line 58
    const-string v1, "RTCController"

    const-string v2, "RTCController disconnect() hit"

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    invoke-direct {p0}, Lco/vine/android/client/RealTimeChatController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 60
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "respond"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 61
    const/4 v1, 0x5

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/RealTimeChatController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 62
    return-void
.end method

.method public handleServiceResponse(IILjava/lang/String;Landroid/os/Bundle;)V
    .locals 3
    .param p1, "actionCode"    # I
    .param p2, "responseCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "b"    # Landroid/os/Bundle;

    .prologue
    .line 119
    const-string v2, "rid"

    invoke-virtual {p4, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 120
    .local v1, "reqId":Ljava/lang/String;
    iget-object v2, p0, Lco/vine/android/client/RealTimeChatController;->mServiceConnection:Lco/vine/android/service/VineServiceConnection;

    invoke-virtual {v2, v1}, Lco/vine/android/service/VineServiceConnection;->remove(Ljava/lang/String;)Lco/vine/android/service/PendingAction;

    move-result-object v0

    .line 121
    .local v0, "action":Lco/vine/android/service/PendingAction;
    invoke-virtual {p0, p1, p4}, Lco/vine/android/client/RealTimeChatController;->notifyListeners(ILandroid/os/Bundle;)V

    .line 122
    return-void
.end method

.method public notifyListeners(ILandroid/os/Bundle;)V
    .locals 5
    .param p1, "actionCode"    # I
    .param p2, "b"    # Landroid/os/Bundle;

    .prologue
    .line 125
    packed-switch p1, :pswitch_data_0

    .line 167
    :cond_0
    :pswitch_0
    return-void

    .line 127
    :pswitch_1
    iget-object v4, p0, Lco/vine/android/client/RealTimeChatController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/client/AppSessionListener;

    .line 128
    .local v3, "listener":Lco/vine/android/client/AppSessionListener;
    invoke-virtual {v3}, Lco/vine/android/client/AppSessionListener;->onWebSocketConnectComplete()V

    goto :goto_0

    .line 133
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "listener":Lco/vine/android/client/AppSessionListener;
    :pswitch_2
    iget-object v4, p0, Lco/vine/android/client/RealTimeChatController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/client/AppSessionListener;

    .line 134
    .restart local v3    # "listener":Lco/vine/android/client/AppSessionListener;
    invoke-virtual {v3}, Lco/vine/android/client/AppSessionListener;->onSubscribeConversationComplete()V

    goto :goto_1

    .line 139
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "listener":Lco/vine/android/client/AppSessionListener;
    :pswitch_3
    const-string v4, "is_typing"

    invoke-virtual {p2, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    .line 140
    .local v2, "isTyping":Z
    iget-object v4, p0, Lco/vine/android/client/RealTimeChatController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/client/AppSessionListener;

    .line 141
    .restart local v3    # "listener":Lco/vine/android/client/AppSessionListener;
    invoke-virtual {v3, v2}, Lco/vine/android/client/AppSessionListener;->onUpdateTypingStateComplete(Z)V

    goto :goto_2

    .line 146
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "isTyping":Z
    .end local v3    # "listener":Lco/vine/android/client/AppSessionListener;
    :pswitch_4
    iget-object v4, p0, Lco/vine/android/client/RealTimeChatController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/client/AppSessionListener;

    .line 147
    .restart local v3    # "listener":Lco/vine/android/client/AppSessionListener;
    invoke-virtual {v3}, Lco/vine/android/client/AppSessionListener;->onWebSocketDisconnected()V

    goto :goto_3

    .line 152
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "listener":Lco/vine/android/client/AppSessionListener;
    :pswitch_5
    iget-object v4, p0, Lco/vine/android/client/RealTimeChatController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :goto_4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/client/AppSessionListener;

    .line 153
    .restart local v3    # "listener":Lco/vine/android/client/AppSessionListener;
    invoke-virtual {v3}, Lco/vine/android/client/AppSessionListener;->onWebSocketError()V

    goto :goto_4

    .line 158
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "listener":Lco/vine/android/client/AppSessionListener;
    :pswitch_6
    const-string v4, "data"

    invoke-virtual {p2, v4}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    .line 159
    .local v0, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCConversation;>;"
    iget-object v4, p0, Lco/vine/android/client/RealTimeChatController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    :goto_5
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/client/AppSessionListener;

    .line 160
    .restart local v3    # "listener":Lco/vine/android/client/AppSessionListener;
    if-eqz v0, :cond_1

    .line 161
    invoke-virtual {v3, v0}, Lco/vine/android/client/AppSessionListener;->onReceiveRTCMessage(Ljava/util/ArrayList;)V

    goto :goto_5

    .line 125
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_4
        :pswitch_5
        :pswitch_3
        :pswitch_0
        :pswitch_6
    .end packed-switch
.end method

.method public notifyNewPrivateMessage(JJ)Ljava/lang/String;
    .locals 2
    .param p1, "conversationId"    # J
    .param p3, "lastMessageId"    # J

    .prologue
    .line 78
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 79
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "conversation_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 80
    const-string v1, "last_message_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 81
    const/16 v1, 0x8

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/RealTimeChatController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public reconnectChatService()Ljava/lang/String;
    .locals 2

    .prologue
    .line 53
    invoke-direct {p0}, Lco/vine/android/client/RealTimeChatController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 54
    .local v0, "b":Landroid/os/Bundle;
    const/4 v1, 0x2

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/RealTimeChatController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public removeListener(Lco/vine/android/client/AppSessionListener;)V
    .locals 1
    .param p1, "listener"    # Lco/vine/android/client/AppSessionListener;

    .prologue
    .line 114
    iget-object v0, p0, Lco/vine/android/client/RealTimeChatController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 115
    return-void
.end method

.method public subscribeConversation(J)Ljava/lang/String;
    .locals 2
    .param p1, "conversationRemoteId"    # J

    .prologue
    .line 65
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 66
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "conversation_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 67
    const/4 v1, 0x3

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/RealTimeChatController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public updateTypingState(JZ)Ljava/lang/String;
    .locals 2
    .param p1, "conversationId"    # J
    .param p3, "isTyping"    # Z

    .prologue
    .line 71
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 72
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "conversation_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 73
    const-string v1, "is_typing"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 74
    const/4 v1, 0x7

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/RealTimeChatController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
