.class public Lco/vine/android/ConversationActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "ConversationActivity.java"

# interfaces
.implements Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ConversationActivity$ConversationSessionListener;,
        Lco/vine/android/ConversationActivity$RealTimeChatReceiver;
    }
.end annotation


# static fields
.field private static final DIALOG_DELETE:I = 0x0

.field private static final DIALOG_DELETE_MESSAGE:I = 0x2

.field private static final DIALOG_IGNORE:I = 0x1

.field private static final EVENT_SOURCE_TITLE:Ljava/lang/String;

.field public static final EXTRA_AM_FOLLOWING_RECIPIENT:Ljava/lang/String; = "am_following_recipient"

.field public static final EXTRA_CONVERSATION_ROW_ID:Ljava/lang/String; = "conversation_row_id"

.field public static final EXTRA_KEYBOARD_UP:Ljava/lang/String; = "keyboard_up"

.field public static final EXTRA_RECIPIENT_USERNAME:Ljava/lang/String; = "recipient_username"

.field private static final EXTRA_USER_ID:Ljava/lang/String; = "user_id"

.field private static final FRAGMENT_TAG:Ljava/lang/String; = "conversationFragment"

.field private static final INITIAL_RETRY_DELAY:J = 0x3e8L

.field private static final INVALID_ID:J = -0x1L

.field private static final MAX_RETRY_DELAY:I = 0x3e80

.field public static final REQUEST_CONFIRMATION:I = 0x65

.field private static final TAG:Ljava/lang/String; = "ConvActivity;RTC"


# instance fields
.field public keyBoardUpOnStart:Z

.field private mAmFollowingRecipient:Z

.field private mChatReceiver:Lco/vine/android/ConversationActivity$RealTimeChatReceiver;

.field private mClient:Lco/vine/android/VineWebSocketClient;

.field private mConnectivityReceiver:Landroid/content/BroadcastReceiver;

.field private mConversationId:J

.field private mConversationRowId:J

.field private mDirectUserId:J

.field private mHelper:Lco/vine/android/recorder/RecordingActivityHelper;

.field private final mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

.field private mLastIsConnected:Z

.field private mLastMessageId:J

.field private mLastTyping:Z

.field private mMainHandler:Landroid/os/Handler;

.field private mMessageIdToDelete:J

.field private mPref:Landroid/content/SharedPreferences;

.field private mRecipientUserName:Ljava/lang/String;

.field private mReconnectDelay:J

.field private final mReconnectRunnable:Ljava/lang/Runnable;

.field private mRetrySuccessRunnable:Ljava/lang/Runnable;

.field private mVersion:Lco/vine/android/recorder/RecordSessionVersion;

.field private mWebSocketListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 74
    const-class v0, Lco/vine/android/ConversationActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/ConversationActivity;->EVENT_SOURCE_TITLE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 56
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    .line 82
    new-instance v0, Lco/vine/android/recorder/RecordingActivityHelper;

    invoke-direct {v0}, Lco/vine/android/recorder/RecordingActivityHelper;-><init>()V

    iput-object v0, p0, Lco/vine/android/ConversationActivity;->mHelper:Lco/vine/android/recorder/RecordingActivityHelper;

    .line 84
    new-instance v0, Lco/vine/android/util/IntentionalObjectCounter;

    const-string v1, "recorder"

    invoke-direct {v0, v1, p0}, Lco/vine/android/util/IntentionalObjectCounter;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    iput-object v0, p0, Lco/vine/android/ConversationActivity;->mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

    .line 414
    new-instance v0, Lco/vine/android/ConversationActivity$1;

    invoke-direct {v0, p0}, Lco/vine/android/ConversationActivity$1;-><init>(Lco/vine/android/ConversationActivity;)V

    iput-object v0, p0, Lco/vine/android/ConversationActivity;->mConnectivityReceiver:Landroid/content/BroadcastReceiver;

    .line 551
    new-instance v0, Lco/vine/android/ConversationActivity$2;

    invoke-direct {v0, p0}, Lco/vine/android/ConversationActivity$2;-><init>(Lco/vine/android/ConversationActivity;)V

    iput-object v0, p0, Lco/vine/android/ConversationActivity;->mWebSocketListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    .line 597
    new-instance v0, Lco/vine/android/ConversationActivity$3;

    invoke-direct {v0, p0}, Lco/vine/android/ConversationActivity$3;-><init>(Lco/vine/android/ConversationActivity;)V

    iput-object v0, p0, Lco/vine/android/ConversationActivity;->mReconnectRunnable:Ljava/lang/Runnable;

    .line 614
    return-void
.end method

.method static synthetic access$1000(Lco/vine/android/ConversationActivity;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    invoke-direct {p0}, Lco/vine/android/ConversationActivity;->clientIsActive()Z

    move-result v0

    return v0
.end method

.method static synthetic access$1100(Lco/vine/android/ConversationActivity;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    iget-wide v0, p0, Lco/vine/android/ConversationActivity;->mDirectUserId:J

    return-wide v0
.end method

.method static synthetic access$1200(Lco/vine/android/ConversationActivity;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    iget-wide v0, p0, Lco/vine/android/ConversationActivity;->mLastMessageId:J

    return-wide v0
.end method

.method static synthetic access$1202(Lco/vine/android/ConversationActivity;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;
    .param p1, "x1"    # J

    .prologue
    .line 56
    iput-wide p1, p0, Lco/vine/android/ConversationActivity;->mLastMessageId:J

    return-wide p1
.end method

.method static synthetic access$1300(Lco/vine/android/ConversationActivity;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    iget-wide v0, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    return-wide v0
.end method

.method static synthetic access$200(Lco/vine/android/ConversationActivity;)Lco/vine/android/VineWebSocketClient;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/ConversationActivity;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    iget-boolean v0, p0, Lco/vine/android/ConversationActivity;->mLastIsConnected:Z

    return v0
.end method

.method static synthetic access$302(Lco/vine/android/ConversationActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 56
    iput-boolean p1, p0, Lco/vine/android/ConversationActivity;->mLastIsConnected:Z

    return p1
.end method

.method static synthetic access$400(Lco/vine/android/ConversationActivity;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mReconnectRunnable:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic access$500(Lco/vine/android/ConversationActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mMainHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/ConversationActivity;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    invoke-direct {p0}, Lco/vine/android/ConversationActivity;->reconnectWithBackoff()V

    return-void
.end method

.method static synthetic access$700(Lco/vine/android/ConversationActivity;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    invoke-direct {p0}, Lco/vine/android/ConversationActivity;->prepareClient()V

    return-void
.end method

.method static synthetic access$800(Lco/vine/android/ConversationActivity;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    iget-wide v0, p0, Lco/vine/android/ConversationActivity;->mReconnectDelay:J

    return-wide v0
.end method

.method static synthetic access$802(Lco/vine/android/ConversationActivity;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;
    .param p1, "x1"    # J

    .prologue
    .line 56
    iput-wide p1, p0, Lco/vine/android/ConversationActivity;->mReconnectDelay:J

    return-wide p1
.end method

.method static synthetic access$900(Lco/vine/android/ConversationActivity;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;

    .prologue
    .line 56
    iget-wide v0, p0, Lco/vine/android/ConversationActivity;->mConversationId:J

    return-wide v0
.end method

.method static synthetic access$902(Lco/vine/android/ConversationActivity;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationActivity;
    .param p1, "x1"    # J

    .prologue
    .line 56
    iput-wide p1, p0, Lco/vine/android/ConversationActivity;->mConversationId:J

    return-wide p1
.end method

.method private declared-synchronized clientIsActive()Z
    .locals 2

    .prologue
    .line 522
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;

    .line 523
    .local v0, "client":Lco/vine/android/VineWebSocketClient;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lco/vine/android/VineWebSocketClient;->isConnected()Z
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

    .line 522
    .end local v0    # "client":Lco/vine/android/VineWebSocketClient;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private disconnectClient()V
    .locals 3

    .prologue
    .line 543
    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mMainHandler:Landroid/os/Handler;

    iget-object v2, p0, Lco/vine/android/ConversationActivity;->mReconnectRunnable:Ljava/lang/Runnable;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 544
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;

    .line 545
    .local v0, "client":Lcom/codebutler/android_websockets/WebSocketClient;
    if-eqz v0, :cond_0

    .line 546
    invoke-virtual {v0}, Lcom/codebutler/android_websockets/WebSocketClient;->disconnect()V

    .line 547
    const/4 v1, 0x0

    iput-object v1, p0, Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;

    .line 549
    :cond_0
    return-void
.end method

.method public static getConversationActivityStates(Landroid/app/Activity;)[J
    .locals 15
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    const-wide/16 v13, 0x0

    const-wide/16 v8, -0x1

    const/4 v12, 0x0

    .line 366
    invoke-static {p0}, Lco/vine/android/util/Util;->getRecentActivityData(Landroid/app/Activity;)Ljava/lang/String;

    move-result-object v2

    .line 367
    .local v2, "data":Ljava/lang/String;
    const-string v10, ":"

    invoke-virtual {v2, v10}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    .line 368
    .local v6, "separator":I
    const/4 v10, 0x2

    new-array v7, v10, [J

    fill-array-data v7, :array_0

    .line 370
    .local v7, "state":[J
    const/4 v10, 0x0

    :try_start_0
    invoke-virtual {v2, v10, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 371
    .local v0, "conversationId":J
    const/4 v10, 0x0

    cmp-long v11, v0, v13

    if-lez v11, :cond_0

    .end local v0    # "conversationId":J
    :goto_0
    aput-wide v0, v7, v10
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 377
    :goto_1
    add-int/lit8 v10, v6, 0x1

    :try_start_1
    invoke-virtual {v2, v10}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    .line 378
    .local v3, "directUserId":J
    const/4 v10, 0x1

    cmp-long v11, v3, v13

    if-lez v11, :cond_1

    .end local v3    # "directUserId":J
    :goto_2
    aput-wide v3, v7, v10
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    .line 383
    :goto_3
    return-object v7

    .restart local v0    # "conversationId":J
    :cond_0
    move-wide v0, v8

    .line 371
    goto :goto_0

    .line 372
    .end local v0    # "conversationId":J
    :catch_0
    move-exception v5

    .line 373
    .local v5, "e":Ljava/lang/NumberFormatException;
    const-string v10, "Attempted to restore activity state with an invalid conversation id"

    new-array v11, v12, [Ljava/lang/Object;

    invoke-static {v5, v10, v11}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .end local v5    # "e":Ljava/lang/NumberFormatException;
    .restart local v3    # "directUserId":J
    :cond_1
    move-wide v3, v8

    .line 378
    goto :goto_2

    .line 379
    .end local v3    # "directUserId":J
    :catch_1
    move-exception v5

    .line 380
    .restart local v5    # "e":Ljava/lang/NumberFormatException;
    const-string v8, "Attempted to restore activity state with an invalid direct user id"

    new-array v9, v12, [Ljava/lang/Object;

    invoke-static {v5, v8, v9}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_3

    .line 368
    nop

    :array_0
    .array-data 8
        -0x1
        -0x1
    .end array-data
.end method

.method public static getIntent(Landroid/content/Context;JLjava/lang/String;JZZ)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "conversationObjectId"    # J
    .param p3, "recipientUsername"    # Ljava/lang/String;
    .param p4, "userId"    # J
    .param p6, "followingThem"    # Z
    .param p7, "keyboardUpOnStart"    # Z

    .prologue
    .line 102
    new-instance v0, Landroid/content/Intent;

    invoke-static {p0}, Lco/vine/android/util/Util;->isCapableOfInline(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-class v1, Lco/vine/android/ConversationActivity;

    :goto_0
    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 106
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 107
    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 108
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p4, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 109
    const-string v1, "am_following_recipient"

    invoke-virtual {v0, v1, p6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 110
    const-string v1, "keyboard_up"

    invoke-virtual {v0, v1, p7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 111
    return-object v0

    .line 102
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    const-class v1, Lco/vine/android/ConversationActivityMain;

    goto :goto_0
.end method

.method private prepareClient()V
    .locals 10

    .prologue
    .line 527
    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;

    .line 528
    .local v1, "client":Lco/vine/android/VineWebSocketClient;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lco/vine/android/VineWebSocketClient;->isConnecting()Z

    move-result v5

    if-nez v5, :cond_1

    invoke-virtual {v1}, Lco/vine/android/VineWebSocketClient;->isConnected()Z

    move-result v5

    if-nez v5, :cond_1

    .line 529
    :cond_0
    const-string v5, "ConvActivity;RTC"

    const-string v6, "Preparing client now"

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 530
    invoke-static {p0}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v0

    .line 531
    .local v0, "api":Lco/vine/android/client/VineAPI;
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-static {v5}, Lco/vine/android/util/BuildUtil;->getRtcUrl(Landroid/content/res/Resources;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v4

    .line 532
    .local v4, "uri":Ljava/net/URI;
    iget-object v5, p0, Lco/vine/android/ConversationActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveSessionReadOnly()Lco/vine/android/client/Session;

    move-result-object v5

    invoke-virtual {v5}, Lco/vine/android/client/Session;->getSessionKey()Ljava/lang/String;

    move-result-object v3

    .line 533
    .local v3, "sessionKey":Ljava/lang/String;
    const/4 v5, 0x2

    new-array v5, v5, [Lorg/apache/http/message/BasicNameValuePair;

    const/4 v6, 0x0

    new-instance v7, Lorg/apache/http/message/BasicNameValuePair;

    const-string v8, "vine-session-id"

    invoke-direct {v7, v8, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v7, v5, v6

    const/4 v6, 0x1

    new-instance v7, Lorg/apache/http/message/BasicNameValuePair;

    const-string v8, "X-Vine-Client"

    invoke-virtual {v0}, Lco/vine/android/client/VineAPI;->getVineClientHeader()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v7, v8, v9}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v7, v5, v6

    invoke-static {v5}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    .line 537
    .local v2, "extraHeaders":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/message/BasicNameValuePair;>;"
    const-string v5, "ConvActivity;RTC"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Creating client: sessionKey="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ", uri="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 538
    new-instance v5, Lco/vine/android/VineWebSocketClient;

    iget-object v6, p0, Lco/vine/android/ConversationActivity;->mWebSocketListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    invoke-direct {v5, v4, v6, v2}, Lco/vine/android/VineWebSocketClient;-><init>(Ljava/net/URI;Lcom/codebutler/android_websockets/WebSocketClient$Listener;Ljava/util/List;)V

    iput-object v5, p0, Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;

    .line 540
    .end local v0    # "api":Lco/vine/android/client/VineAPI;
    .end local v2    # "extraHeaders":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v3    # "sessionKey":Ljava/lang/String;
    .end local v4    # "uri":Ljava/net/URI;
    :cond_1
    return-void
.end method

.method private reconnectWithBackoff()V
    .locals 4

    .prologue
    .line 592
    const-wide/16 v0, 0x3e8

    iput-wide v0, p0, Lco/vine/android/ConversationActivity;->mReconnectDelay:J

    .line 593
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mMainHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mReconnectRunnable:Ljava/lang/Runnable;

    iget-wide v2, p0, Lco/vine/android/ConversationActivity;->mReconnectDelay:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 594
    const-string v0, "ConvActivity;RTC"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Posting reconnect runnable with delay="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lco/vine/android/ConversationActivity;->mReconnectDelay:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 595
    return-void
.end method


# virtual methods
.method public getRecordingActivityHelper()Lco/vine/android/recorder/RecordingActivityHelper;
    .locals 1

    .prologue
    .line 478
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mHelper:Lco/vine/android/recorder/RecordingActivityHelper;

    return-object v0
.end method

.method public isConversationSideMenuEnabled()Z
    .locals 1

    .prologue
    .line 116
    const/4 v0, 0x1

    return v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 4
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 494
    const/16 v1, 0x65

    if-ne p1, v1, :cond_1

    .line 495
    const/16 v1, 0x5f7

    if-ne p2, v1, :cond_0

    .line 496
    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mPref:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "profile_phone_verified"

    const/4 v3, 0x1

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 497
    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mRetrySuccessRunnable:Ljava/lang/Runnable;

    if-eqz v1, :cond_0

    .line 498
    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mRetrySuccessRunnable:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V

    .line 509
    :cond_0
    :goto_0
    return-void

    .line 502
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "conversationFragment"

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 503
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v1, v0, Lco/vine/android/ConversationFragment;

    if-eqz v1, :cond_2

    .line 504
    const/high16 v1, 0x10000

    sub-int v1, p1, v1

    invoke-virtual {v0, v1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0

    .line 506
    :cond_2
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseControllerActionBarActivity;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public onBackPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 437
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->onBackPressed()V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 441
    :goto_0
    return-void

    .line 438
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 12
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const-wide/16 v10, -0x1

    const/4 v9, 0x0

    const/4 v4, 0x1

    const-wide/16 v7, 0x0

    const/4 v6, 0x0

    .line 126
    const v3, 0x7f030046

    invoke-super {p0, p1, v3, v4, v4}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZZ)V

    .line 127
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    .line 128
    .local v2, "intent":Landroid/content/Intent;
    iget-object v3, p0, Lco/vine/android/ConversationActivity;->mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

    invoke-virtual {v3}, Lco/vine/android/util/IntentionalObjectCounter;->add()V

    .line 129
    const-string v3, "conversation_row_id"

    invoke-virtual {v2, v3, v10, v11}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    .line 130
    const-string v3, "user_id"

    invoke-virtual {v2, v3, v10, v11}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/ConversationActivity;->mDirectUserId:J

    .line 131
    const-string v3, "recipient_username"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/ConversationActivity;->mRecipientUserName:Ljava/lang/String;

    .line 132
    const-string v3, "am_following_recipient"

    invoke-virtual {v2, v3, v6}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lco/vine/android/ConversationActivity;->mAmFollowingRecipient:Z

    .line 133
    const-string v3, "keyboard_up"

    invoke-virtual {v2, v3, v6}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lco/vine/android/ConversationActivity;->keyBoardUpOnStart:Z

    .line 134
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/ConversationActivity;->mPref:Landroid/content/SharedPreferences;

    .line 136
    const-string v3, "co.vine.android.MESSAGE_NOTIFICATION_PRESSED"

    invoke-virtual {v2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 137
    iget-object v3, p0, Lco/vine/android/ConversationActivity;->mAppController:Lco/vine/android/client/AppController;

    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Lco/vine/android/client/AppController;->clearPushNotifications(I)V

    .line 140
    :cond_0
    iget-wide v3, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    cmp-long v3, v3, v7

    if-gez v3, :cond_1

    iget-wide v3, p0, Lco/vine/android/ConversationActivity;->mDirectUserId:J

    cmp-long v3, v3, v7

    if-gez v3, :cond_1

    .line 141
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->restoreActivityState()V

    .line 144
    :cond_1
    new-instance v3, Lco/vine/android/ConversationActivity$ConversationSessionListener;

    invoke-direct {v3, p0, v9}, Lco/vine/android/ConversationActivity$ConversationSessionListener;-><init>(Lco/vine/android/ConversationActivity;Lco/vine/android/ConversationActivity$1;)V

    iput-object v3, p0, Lco/vine/android/ConversationActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 146
    iget-wide v3, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    cmp-long v3, v3, v7

    if-gez v3, :cond_2

    iget-wide v3, p0, Lco/vine/android/ConversationActivity;->mDirectUserId:J

    cmp-long v3, v3, v7

    if-lez v3, :cond_2

    .line 150
    :cond_2
    iget-object v3, p0, Lco/vine/android/ConversationActivity;->mHelper:Lco/vine/android/recorder/RecordingActivityHelper;

    invoke-virtual {v3, p0}, Lco/vine/android/recorder/RecordingActivityHelper;->bindCameraService(Landroid/app/Activity;)V

    .line 152
    invoke-static {p0}, Lco/vine/android/recorder/RecordSessionManager;->getCurrentVersion(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/ConversationActivity;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 154
    if-nez p1, :cond_3

    .line 155
    new-instance v1, Lco/vine/android/ConversationFragment;

    invoke-direct {v1}, Lco/vine/android/ConversationFragment;-><init>()V

    .line 156
    .local v1, "fragment":Lco/vine/android/ConversationFragment;
    invoke-static {v2, v6}, Lco/vine/android/ConversationFragment;->prepareArguments(Landroid/content/Intent;Z)Landroid/os/Bundle;

    move-result-object v0

    .line 157
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "arg_encoder_version"

    iget-object v4, p0, Lco/vine/android/ConversationActivity;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 158
    const-string v3, "conversation_row_id"

    iget-wide v4, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    invoke-virtual {v0, v3, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 159
    invoke-virtual {v1, v0}, Lco/vine/android/ConversationFragment;->setArguments(Landroid/os/Bundle;)V

    .line 160
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    const v4, 0x7f0a0102

    const-string v5, "conversationFragment"

    invoke-virtual {v3, v4, v1, v5}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 165
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "fragment":Lco/vine/android/ConversationFragment;
    :cond_3
    new-instance v3, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v3, p0, Lco/vine/android/ConversationActivity;->mMainHandler:Landroid/os/Handler;

    .line 166
    iget-object v3, p0, Lco/vine/android/ConversationActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v4, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    invoke-virtual {v3, v4, v5}, Lco/vine/android/client/AppController;->getConversationRemoteId(J)Ljava/lang/String;

    .line 167
    new-instance v3, Lco/vine/android/ConversationActivity$RealTimeChatReceiver;

    invoke-direct {v3, p0, v9}, Lco/vine/android/ConversationActivity$RealTimeChatReceiver;-><init>(Lco/vine/android/ConversationActivity;Lco/vine/android/ConversationActivity$1;)V

    iput-object v3, p0, Lco/vine/android/ConversationActivity;->mChatReceiver:Lco/vine/android/ConversationActivity$RealTimeChatReceiver;

    .line 168
    iput-boolean v6, p0, Lco/vine/android/ConversationActivity;->mLastTyping:Z

    .line 169
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 10
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const v9, 0x7f0a0243

    const v8, 0x7f0a0242

    const v7, 0x7f0a0241

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 211
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v1

    const v2, 0x7f100003

    invoke-virtual {v1, v2, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 213
    iget-boolean v1, p0, Lco/vine/android/ConversationActivity;->mAmFollowingRecipient:Z

    if-nez v1, :cond_0

    iget-wide v1, p0, Lco/vine/android/ConversationActivity;->mDirectUserId:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mRecipientUserName:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 214
    :cond_0
    invoke-interface {p1, v7}, Landroid/view/Menu;->removeItem(I)V

    .line 220
    :goto_0
    iget-wide v1, p0, Lco/vine/android/ConversationActivity;->mDirectUserId:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-lez v1, :cond_2

    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mRecipientUserName:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 221
    invoke-interface {p1, v9}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 222
    .local v0, "item":Landroid/view/MenuItem;
    const v1, 0x7f0e010e

    invoke-virtual {p0, v1}, Lco/vine/android/ConversationActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v6, [Ljava/lang/Object;

    iget-object v3, p0, Lco/vine/android/ConversationActivity;->mRecipientUserName:Ljava/lang/String;

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 224
    invoke-interface {p1, v8}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 225
    const v1, 0x7f0e010a

    invoke-virtual {p0, v1}, Lco/vine/android/ConversationActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v6, [Ljava/lang/Object;

    iget-object v3, p0, Lco/vine/android/ConversationActivity;->mRecipientUserName:Ljava/lang/String;

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 231
    .end local v0    # "item":Landroid/view/MenuItem;
    :goto_1
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v1

    return v1

    .line 216
    :cond_1
    invoke-interface {p1, v7}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 217
    .restart local v0    # "item":Landroid/view/MenuItem;
    const v1, 0x7f0e0101

    invoke-virtual {p0, v1}, Lco/vine/android/ConversationActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v6, [Ljava/lang/Object;

    iget-object v3, p0, Lco/vine/android/ConversationActivity;->mRecipientUserName:Ljava/lang/String;

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    goto :goto_0

    .line 227
    .end local v0    # "item":Landroid/view/MenuItem;
    :cond_2
    invoke-interface {p1, v9}, Landroid/view/Menu;->removeItem(I)V

    .line 228
    invoke-interface {p1, v8}, Landroid/view/Menu;->removeItem(I)V

    goto :goto_1
.end method

.method protected onDestroy()V
    .locals 4

    .prologue
    .line 318
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onDestroy()V

    .line 320
    :try_start_0
    iget-object v2, p0, Lco/vine/android/ConversationActivity;->mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

    invoke-virtual {v2}, Lco/vine/android/util/IntentionalObjectCounter;->release()V

    .line 321
    iget-object v2, p0, Lco/vine/android/ConversationActivity;->mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

    invoke-virtual {v2}, Lco/vine/android/util/IntentionalObjectCounter;->getCount()I

    move-result v0

    .line 322
    .local v0, "count":I
    if-nez v0, :cond_1

    .line 323
    const-string v2, "Clean up folders because we are the last one."

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 324
    iget-object v2, p0, Lco/vine/android/ConversationActivity;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-virtual {v2, p0}, Lco/vine/android/recorder/RecordSessionVersion;->getManager(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionManager;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordSessionManager;->cleanUnusedFolders()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 333
    .end local v0    # "count":I
    :cond_0
    :goto_0
    iget-object v2, p0, Lco/vine/android/ConversationActivity;->mHelper:Lco/vine/android/recorder/RecordingActivityHelper;

    invoke-virtual {v2, p0}, Lco/vine/android/recorder/RecordingActivityHelper;->unBindCameraService(Landroid/app/Activity;)V

    .line 334
    return-void

    .line 326
    .restart local v0    # "count":I
    :cond_1
    const/4 v2, 0x1

    if-le v0, v2, :cond_0

    .line 327
    :try_start_1
    new-instance v2, Lco/vine/android/VineLoggingException;

    const-string v3, "Double instance violation, but it\'s ok."

    invoke-direct {v2, v3}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 330
    .end local v0    # "count":I
    :catch_0
    move-exception v1

    .line 331
    .local v1, "e":Ljava/io/IOException;
    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 283
    packed-switch p2, :pswitch_data_0

    .line 314
    :goto_0
    return-void

    .line 285
    :pswitch_0
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 287
    :pswitch_1
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v1, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->deleteConversation(J)Ljava/lang/String;

    .line 288
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->finish()V

    goto :goto_0

    .line 295
    :pswitch_2
    packed-switch p3, :pswitch_data_2

    goto :goto_0

    .line 297
    :pswitch_3
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v1, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->ignoreConversation(J)Ljava/lang/String;

    .line 298
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->finish()V

    goto :goto_0

    .line 305
    :pswitch_4
    packed-switch p3, :pswitch_data_3

    goto :goto_0

    .line 307
    :pswitch_5
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v1, p0, Lco/vine/android/ConversationActivity;->mMessageIdToDelete:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->deleteMessage(J)V

    goto :goto_0

    .line 283
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_4
    .end packed-switch

    .line 285
    :pswitch_data_1
    .packed-switch -0x1
        :pswitch_1
    .end packed-switch

    .line 295
    :pswitch_data_2
    .packed-switch -0x1
        :pswitch_3
    .end packed-switch

    .line 305
    :pswitch_data_3
    .packed-switch -0x1
        :pswitch_5
    .end packed-switch
.end method

.method public onMenuClose()V
    .locals 2

    .prologue
    .line 338
    invoke-static {p0}, Lco/vine/android/util/MuteUtil;->isMuted(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 339
    new-instance v0, Landroid/content/Intent;

    sget-object v1, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_UNMUTE:Ljava/lang/String;

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v0, v1}, Lco/vine/android/ConversationActivity;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 341
    :cond_0
    return-void
.end method

.method public onMenuOpened()V
    .locals 2

    .prologue
    .line 345
    invoke-static {p0}, Lco/vine/android/util/MuteUtil;->isMuted(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 346
    new-instance v0, Landroid/content/Intent;

    sget-object v1, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_MUTE:Ljava/lang/String;

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v0, v1}, Lco/vine/android/ConversationActivity;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 348
    :cond_0
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 9
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const-wide/16 v7, 0x0

    const-wide/16 v5, -0x1

    const/4 v4, 0x0

    .line 186
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 187
    const-string v2, "conversation_row_id"

    invoke-virtual {p1, v2, v5, v6}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v2

    iput-wide v2, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    .line 188
    const-string v2, "am_following_recipient"

    invoke-virtual {p1, v2, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lco/vine/android/ConversationActivity;->mAmFollowingRecipient:Z

    .line 189
    iget-wide v2, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    cmp-long v2, v2, v7

    if-gez v2, :cond_0

    iget-wide v2, p0, Lco/vine/android/ConversationActivity;->mDirectUserId:J

    cmp-long v2, v2, v7

    if-lez v2, :cond_0

    .line 193
    :cond_0
    const-string v2, "user_id"

    invoke-virtual {p1, v2, v5, v6}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v2

    iput-wide v2, p0, Lco/vine/android/ConversationActivity;->mDirectUserId:J

    .line 194
    const-string v2, "recipient_username"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/ConversationActivity;->mRecipientUserName:Ljava/lang/String;

    .line 195
    const-string v2, "am_following_recipient"

    invoke-virtual {p1, v2, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lco/vine/android/ConversationActivity;->mAmFollowingRecipient:Z

    .line 197
    new-instance v1, Lco/vine/android/ConversationFragment;

    invoke-direct {v1}, Lco/vine/android/ConversationFragment;-><init>()V

    .line 198
    .local v1, "fragment":Lco/vine/android/ConversationFragment;
    invoke-static {p1, v4}, Lco/vine/android/ConversationFragment;->prepareArguments(Landroid/content/Intent;Z)Landroid/os/Bundle;

    move-result-object v0

    .line 199
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "arg_encoder_version"

    iget-object v3, p0, Lco/vine/android/ConversationActivity;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 200
    const-string v2, "conversation_row_id"

    iget-wide v3, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    invoke-virtual {v0, v2, v3, v4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 201
    const-string v2, "am_following_recipient"

    iget-boolean v3, p0, Lco/vine/android/ConversationActivity;->mAmFollowingRecipient:Z

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 202
    invoke-virtual {v1, v0}, Lco/vine/android/ConversationFragment;->setArguments(Landroid/os/Bundle;)V

    .line 203
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    const v3, 0x7f0a0102

    const-string v4, "conversationFragment"

    invoke-virtual {v2, v3, v1, v4}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 207
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 5
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v0, 0x1

    .line 236
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 258
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 238
    :sswitch_0
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->showIgnoreDialog()V

    goto :goto_0

    .line 242
    :sswitch_1
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->showDeleteDialog()V

    goto :goto_0

    .line 246
    :sswitch_2
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->onBackPressed()V

    goto :goto_0

    .line 250
    :sswitch_3
    iget-wide v1, p0, Lco/vine/android/ConversationActivity;->mDirectUserId:J

    sget-object v3, Lco/vine/android/ConversationActivity;->EVENT_SOURCE_TITLE:Ljava/lang/String;

    invoke-static {p0, v1, v2, v3}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    goto :goto_0

    .line 254
    :sswitch_4
    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/ConversationActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    iget-wide v3, p0, Lco/vine/android/ConversationActivity;->mDirectUserId:J

    invoke-virtual {v1, v2, v3, v4, v0}, Lco/vine/android/client/AppController;->followUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;

    goto :goto_0

    .line 236
    nop

    :sswitch_data_0
    .sparse-switch
        0x102002c -> :sswitch_2
        0x7f0a0241 -> :sswitch_4
        0x7f0a0242 -> :sswitch_3
        0x7f0a0243 -> :sswitch_0
        0x7f0a0244 -> :sswitch_1
    .end sparse-switch
.end method

.method protected onPause()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 445
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onPause()V

    .line 447
    :try_start_0
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mChatReceiver:Lco/vine/android/ConversationActivity$RealTimeChatReceiver;

    invoke-virtual {p0, v0}, Lco/vine/android/ConversationActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    .line 452
    :goto_0
    :try_start_1
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mConnectivityReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lco/vine/android/ConversationActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0

    .line 456
    :goto_1
    invoke-virtual {p0, v1, v1}, Lco/vine/android/ConversationActivity;->onTypingStatusChanged(ZZ)V

    .line 457
    invoke-direct {p0}, Lco/vine/android/ConversationActivity;->disconnectClient()V

    .line 458
    return-void

    .line 453
    :catch_0
    move-exception v0

    goto :goto_1

    .line 448
    :catch_1
    move-exception v0

    goto :goto_0
.end method

.method protected onResume()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 394
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onResume()V

    .line 395
    iget-wide v3, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    sput-wide v3, Lco/vine/android/service/ResourceService;->lastActiveconversationRowId:J

    .line 397
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 398
    .local v0, "chatFilter":Landroid/content/IntentFilter;
    const-string v3, "co.vine.android.rtc.WEBSOCKET_EVENT"

    invoke-virtual {v0, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 399
    const-string v3, "co.vine.android.service.mergeSelfNewMessage"

    invoke-virtual {v0, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 400
    iget-object v3, p0, Lco/vine/android/ConversationActivity;->mChatReceiver:Lco/vine/android/ConversationActivity$RealTimeChatReceiver;

    const-string v4, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v3, v0, v4, v6}, Lco/vine/android/ConversationActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 403
    const/4 v3, 0x2

    iget-wide v4, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    invoke-static {p0, v3, v4, v5}, Lco/vine/android/service/GCMNotificationService;->getUpdateNotificationIntent(Landroid/content/Context;IJ)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {p0, v3}, Lco/vine/android/ConversationActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 405
    new-instance v2, Landroid/content/IntentFilter;

    const-string v3, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 406
    .local v2, "connFilter":Landroid/content/IntentFilter;
    iget-object v3, p0, Lco/vine/android/ConversationActivity;->mConnectivityReceiver:Landroid/content/BroadcastReceiver;

    const-string v4, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v3, v2, v4, v6}, Lco/vine/android/ConversationActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 407
    invoke-direct {p0}, Lco/vine/android/ConversationActivity;->prepareClient()V

    .line 408
    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;

    .line 409
    .local v1, "client":Lco/vine/android/VineWebSocketClient;
    if-eqz v1, :cond_0

    .line 410
    invoke-virtual {v1}, Lco/vine/android/VineWebSocketClient;->connect()V

    .line 412
    :cond_0
    return-void
.end method

.method protected onStart()V
    .locals 1

    .prologue
    .line 388
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onStart()V

    .line 389
    const/4 v0, 0x1

    sput-boolean v0, Lco/vine/android/service/ResourceService;->isConversationActive:Z

    .line 390
    return-void
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 462
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onStop()V

    .line 463
    const/4 v0, 0x0

    sput-boolean v0, Lco/vine/android/service/ResourceService;->isConversationActive:Z

    .line 464
    return-void
.end method

.method public onTypingStatusChanged(ZZ)V
    .locals 4
    .param p1, "isTyping"    # Z
    .param p2, "isSending"    # Z

    .prologue
    .line 467
    iget-wide v0, p0, Lco/vine/android/ConversationActivity;->mConversationId:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    invoke-direct {p0}, Lco/vine/android/ConversationActivity;->clientIsActive()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/ConversationActivity;->mLastTyping:Z

    if-eq v0, p1, :cond_0

    .line 468
    if-eqz p1, :cond_1

    .line 469
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;

    iget-wide v1, p0, Lco/vine/android/ConversationActivity;->mConversationId:J

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/VineWebSocketClient;->updateTypingState(JZ)V

    .line 474
    :cond_0
    :goto_0
    iput-boolean p1, p0, Lco/vine/android/ConversationActivity;->mLastTyping:Z

    .line 475
    return-void

    .line 470
    :cond_1
    if-nez p2, :cond_0

    .line 471
    iget-object v0, p0, Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;

    iget-wide v1, p0, Lco/vine/android/ConversationActivity;->mConversationId:J

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/VineWebSocketClient;->updateTypingState(JZ)V

    goto :goto_0
.end method

.method protected restoreActivityState()V
    .locals 5

    .prologue
    .line 353
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->restoreActivityState()V

    .line 354
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 355
    .local v1, "intent":Landroid/content/Intent;
    if-eqz v1, :cond_0

    .line 356
    invoke-virtual {v1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 357
    .local v0, "action":Ljava/lang/String;
    const-string v3, "android.intent.action.MAIN"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 358
    invoke-static {p0}, Lco/vine/android/ConversationActivity;->getConversationActivityStates(Landroid/app/Activity;)[J

    move-result-object v2

    .line 359
    .local v2, "states":[J
    const/4 v3, 0x0

    aget-wide v3, v2, v3

    iput-wide v3, p0, Lco/vine/android/ConversationActivity;->mConversationRowId:J

    .line 360
    const/4 v3, 0x1

    aget-wide v3, v2, v3

    iput-wide v3, p0, Lco/vine/android/ConversationActivity;->mDirectUserId:J

    .line 363
    .end local v0    # "action":Ljava/lang/String;
    .end local v2    # "states":[J
    :cond_0
    return-void
.end method

.method public setRecipientUsername(Ljava/lang/String;)V
    .locals 4
    .param p1, "recipientUsername"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    .line 120
    iput-object p1, p0, Lco/vine/android/ConversationActivity;->mRecipientUserName:Ljava/lang/String;

    .line 121
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ConversationActivity;->mRecipientUserName:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iget-object v2, p0, Lco/vine/android/ConversationActivity;->mRecipientUserName:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {p0, v1, v0, v2, v3}, Lco/vine/android/ConversationActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 122
    return-void

    .line 121
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public showDeleteDialog()V
    .locals 2

    .prologue
    .line 262
    const/4 v1, 0x0

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogFragment;

    move-result-object v0

    .line 264
    .local v0, "p":Lco/vine/android/widgets/PromptDialogFragment;
    invoke-virtual {v0, p0}, Lco/vine/android/widgets/PromptDialogFragment;->setListener(Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;)V

    .line 265
    const v1, 0x7f0e00b2

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 266
    const v1, 0x7f0e00b6

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 267
    const v1, 0x7f0e0057

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 268
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->show(Landroid/app/FragmentManager;)V

    .line 269
    return-void
.end method

.method public showDeleteMessageDialog(J)V
    .locals 2
    .param p1, "messageId"    # J

    .prologue
    .line 482
    iput-wide p1, p0, Lco/vine/android/ConversationActivity;->mMessageIdToDelete:J

    .line 483
    const/4 v1, 0x2

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogFragment;

    move-result-object v0

    .line 485
    .local v0, "p":Lco/vine/android/widgets/PromptDialogFragment;
    invoke-virtual {v0, p0}, Lco/vine/android/widgets/PromptDialogFragment;->setListener(Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;)V

    .line 486
    const v1, 0x7f0e00b4

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 487
    const v1, 0x7f0e00b6

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 488
    const v1, 0x7f0e0057

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 489
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->show(Landroid/app/FragmentManager;)V

    .line 490
    return-void
.end method

.method public showIgnoreDialog()V
    .locals 2

    .prologue
    .line 272
    const/4 v1, 0x1

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogFragment;

    move-result-object v0

    .line 274
    .local v0, "p":Lco/vine/android/widgets/PromptDialogFragment;
    invoke-virtual {v0, p0}, Lco/vine/android/widgets/PromptDialogFragment;->setListener(Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;)V

    .line 275
    const v1, 0x7f0e010d

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 276
    const v1, 0x7f0e010f

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 277
    const v1, 0x7f0e0057

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 278
    invoke-virtual {p0}, Lco/vine/android/ConversationActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->show(Landroid/app/FragmentManager;)V

    .line 279
    return-void
.end method

.method public startPhoneConfirmation(Ljava/lang/Runnable;)V
    .locals 5
    .param p1, "retrySuccessRunnable"    # Ljava/lang/Runnable;

    .prologue
    const/4 v4, 0x0

    .line 512
    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mPref:Landroid/content/SharedPreferences;

    const-string v2, "profile_phone_verified"

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 513
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    .line 519
    :goto_0
    return-void

    .line 515
    :cond_0
    iput-object p1, p0, Lco/vine/android/ConversationActivity;->mRetrySuccessRunnable:Ljava/lang/Runnable;

    .line 516
    iget-object v1, p0, Lco/vine/android/ConversationActivity;->mPref:Landroid/content/SharedPreferences;

    const-string v2, "settings_profile_phone"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 517
    .local v0, "phone":Ljava/lang/String;
    invoke-static {p0, v0, v4}, Lco/vine/android/ConfirmationFlowActivity;->getIntent(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v1

    const/16 v2, 0x65

    invoke-virtual {p0, v1, v2}, Lco/vine/android/ConversationActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0
.end method
