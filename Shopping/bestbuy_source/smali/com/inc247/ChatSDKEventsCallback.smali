.class public Lcom/inc247/ChatSDKEventsCallback;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static self:Lcom/inc247/ChatSDKEventsCallback;


# instance fields
.field private listener:Lcom/inc247/ChatSDKEventsListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    sput-object v0, Lcom/inc247/ChatSDKEventsCallback;->self:Lcom/inc247/ChatSDKEventsCallback;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/inc247/ChatSDKEventsCallback;->listener:Lcom/inc247/ChatSDKEventsListener;

    .line 24
    return-void
.end method

.method static synthetic access$0()Lcom/inc247/ChatSDKEventsCallback;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/inc247/ChatSDKEventsCallback;->self:Lcom/inc247/ChatSDKEventsCallback;

    return-object v0
.end method

.method static synthetic access$1(Lcom/inc247/ChatSDKEventsCallback;)Lcom/inc247/ChatSDKEventsListener;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/inc247/ChatSDKEventsCallback;->listener:Lcom/inc247/ChatSDKEventsListener;

    return-object v0
.end method

.method public static getInstance()Lcom/inc247/ChatSDKEventsCallback;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/inc247/ChatSDKEventsCallback;->self:Lcom/inc247/ChatSDKEventsCallback;

    if-nez v0, :cond_0

    .line 28
    new-instance v0, Lcom/inc247/ChatSDKEventsCallback;

    invoke-direct {v0}, Lcom/inc247/ChatSDKEventsCallback;-><init>()V

    sput-object v0, Lcom/inc247/ChatSDKEventsCallback;->self:Lcom/inc247/ChatSDKEventsCallback;

    .line 30
    :cond_0
    sget-object v0, Lcom/inc247/ChatSDKEventsCallback;->self:Lcom/inc247/ChatSDKEventsCallback;

    return-object v0
.end method


# virtual methods
.method public sendOnChatStartedEvent(Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 40
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 41
    new-instance v1, Lcom/inc247/ChatSDKEventsCallback$1;

    invoke-direct {v1, p0, p1}, Lcom/inc247/ChatSDKEventsCallback$1;-><init>(Lcom/inc247/ChatSDKEventsCallback;Lorg/json/JSONObject;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 46
    return-void
.end method

.method public sendonAgentMessageEvent(Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 67
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 68
    new-instance v1, Lcom/inc247/ChatSDKEventsCallback$4;

    invoke-direct {v1, p0, p1}, Lcom/inc247/ChatSDKEventsCallback$4;-><init>(Lcom/inc247/ChatSDKEventsCallback;Lorg/json/JSONObject;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 74
    return-void
.end method

.method public sendonChatAgentAvailabilityEvent(Z)V
    .locals 2

    .prologue
    .line 58
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 59
    new-instance v1, Lcom/inc247/ChatSDKEventsCallback$3;

    invoke-direct {v1, p0, p1}, Lcom/inc247/ChatSDKEventsCallback$3;-><init>(Lcom/inc247/ChatSDKEventsCallback;Z)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 64
    return-void
.end method

.method public sendonChatEndedEvent(Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 49
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 50
    new-instance v1, Lcom/inc247/ChatSDKEventsCallback$2;

    invoke-direct {v1, p0, p1}, Lcom/inc247/ChatSDKEventsCallback$2;-><init>(Lcom/inc247/ChatSDKEventsCallback;Lorg/json/JSONObject;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 55
    return-void
.end method

.method public sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V
    .locals 2

    .prologue
    .line 104
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 105
    new-instance v1, Lcom/inc247/ChatSDKEventsCallback$8;

    invoke-direct {v1, p0, p1}, Lcom/inc247/ChatSDKEventsCallback$8;-><init>(Lcom/inc247/ChatSDKEventsCallback;Lcom/inc247/errors/ChatSDKError;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 110
    return-void
.end method

.method public sendonChatMaximizedEvent(Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 86
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 87
    new-instance v1, Lcom/inc247/ChatSDKEventsCallback$6;

    invoke-direct {v1, p0, p1}, Lcom/inc247/ChatSDKEventsCallback$6;-><init>(Lcom/inc247/ChatSDKEventsCallback;Lorg/json/JSONObject;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 92
    return-void
.end method

.method public sendonChatMinimizedEvent(Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 77
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 78
    new-instance v1, Lcom/inc247/ChatSDKEventsCallback$5;

    invoke-direct {v1, p0, p1}, Lcom/inc247/ChatSDKEventsCallback$5;-><init>(Lcom/inc247/ChatSDKEventsCallback;Lorg/json/JSONObject;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 83
    return-void
.end method

.method public sendonNavigationRequest(Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 95
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 96
    new-instance v1, Lcom/inc247/ChatSDKEventsCallback$7;

    invoke-direct {v1, p0, p1}, Lcom/inc247/ChatSDKEventsCallback$7;-><init>(Lcom/inc247/ChatSDKEventsCallback;Lorg/json/JSONObject;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 101
    return-void
.end method

.method public sendonQueueIdParamRetrievalFinished()V
    .locals 2

    .prologue
    .line 122
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 123
    new-instance v1, Lcom/inc247/ChatSDKEventsCallback$10;

    invoke-direct {v1, p0}, Lcom/inc247/ChatSDKEventsCallback$10;-><init>(Lcom/inc247/ChatSDKEventsCallback;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 128
    return-void
.end method

.method public sendonQueueIdParamRetrievalStarted()V
    .locals 2

    .prologue
    .line 113
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 114
    new-instance v1, Lcom/inc247/ChatSDKEventsCallback$9;

    invoke-direct {v1, p0}, Lcom/inc247/ChatSDKEventsCallback$9;-><init>(Lcom/inc247/ChatSDKEventsCallback;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 119
    return-void
.end method

.method public setChatEventsListener(Lcom/inc247/ChatSDKEventsListener;)V
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/inc247/ChatSDKEventsCallback;->self:Lcom/inc247/ChatSDKEventsCallback;

    iput-object p1, v0, Lcom/inc247/ChatSDKEventsCallback;->listener:Lcom/inc247/ChatSDKEventsListener;

    .line 37
    return-void
.end method
