.class public Lcom/amazon/avod/sdk/internal/BindingConnection;
.super Ljava/lang/Object;
.source "BindingConnection.java"

# interfaces
.implements Lcom/amazon/avod/sdk/internal/AivConnection;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;,
        Lcom/amazon/avod/sdk/internal/BindingConnection$HandleResponseTask;
    }
.end annotation


# static fields
.field private static final SERVICE_INTENT_ACTION:Ljava/lang/String;


# instance fields
.field private final mBackgroundExecutor:Ljava/util/concurrent/ExecutorService;

.field private mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

.field private final mFallbackConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

.field private final mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

.field private final mUiHandler:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/avod/sdk/internal/BindingConnection;->SERVICE_INTENT_ACTION:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/amazon/avod/sdk/internal/AivConnection;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "fallbackConnection"    # Lcom/amazon/avod/sdk/internal/AivConnection;

    .prologue
    .line 47
    new-instance v7, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    new-instance v0, Landroid/content/Intent;

    sget-object v1, Lcom/amazon/avod/sdk/internal/BindingConnection;->SERVICE_INTENT_ACTION:Ljava/lang/String;

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-direct {v7, p1, v0}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;-><init>(Landroid/content/Context;Landroid/content/Intent;)V

    new-instance v8, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {v8, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    const/4 v1, 0x0

    const/4 v2, 0x1

    const-wide/16 v3, 0x1e

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    invoke-direct/range {v0 .. v6}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    invoke-direct {p0, p2, v7, v8, v0}, Lcom/amazon/avod/sdk/internal/BindingConnection;-><init>(Lcom/amazon/avod/sdk/internal/AivConnection;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)V

    .line 51
    return-void
.end method

.method private constructor <init>(Lcom/amazon/avod/sdk/internal/AivConnection;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Landroid/os/Handler;Ljava/util/concurrent/ExecutorService;)V
    .locals 0
    .param p1, "fallbackConnection"    # Lcom/amazon/avod/sdk/internal/AivConnection;
    .param p2, "serviceConnection"    # Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;
    .param p3, "uiHandler"    # Landroid/os/Handler;
    .param p4, "backgroundExecutor"    # Ljava/util/concurrent/ExecutorService;

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mFallbackConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

    .line 59
    iput-object p2, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    .line 60
    iput-object p3, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mUiHandler:Landroid/os/Handler;

    .line 61
    iput-object p4, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mBackgroundExecutor:Ljava/util/concurrent/ExecutorService;

    .line 62
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/avod/sdk/internal/BindingConnection;)Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/avod/sdk/internal/BindingConnection;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/avod/sdk/internal/BindingConnection;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/avod/sdk/internal/BindingConnection;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mUiHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/avod/sdk/internal/BindingConnection;)Lcom/amazon/avod/sdk/PlaybackStateEventListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/avod/sdk/internal/BindingConnection;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/avod/sdk/internal/BindingConnection;Lcom/amazon/avod/sdk/ResponseHandler;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/avod/sdk/internal/BindingConnection;
    .param p1, "x1"    # Lcom/amazon/avod/sdk/ResponseHandler;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/amazon/avod/sdk/internal/BindingConnection;->sendDefaultSuccessResponse(Lcom/amazon/avod/sdk/ResponseHandler;)V

    return-void
.end method

.method private callBindingAsync(Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;)V
    .locals 4
    .param p1, "sdkRunnable"    # Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;

    .prologue
    .line 285
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mBackgroundExecutor:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->isShutdown()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 286
    const-string/jumbo v0, "AmazonInstantVideoSDK"

    const-string/jumbo v1, "Attempting to call SDK method %s after cleanup, ignoring"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 291
    :goto_0
    return-void

    .line 290
    :cond_0
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mBackgroundExecutor:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0, p1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method private handleResponseOnUiThread(Lcom/amazon/avod/sdk/ResponseHandler;Lcom/amazon/avod/sdk/CallResponse;)V
    .locals 3
    .param p1, "handler"    # Lcom/amazon/avod/sdk/ResponseHandler;
    .param p2, "response"    # Lcom/amazon/avod/sdk/CallResponse;

    .prologue
    .line 294
    if-eqz p1, :cond_0

    .line 295
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mUiHandler:Landroid/os/Handler;

    new-instance v1, Lcom/amazon/avod/sdk/internal/BindingConnection$HandleResponseTask;

    const/4 v2, 0x0

    invoke-direct {v1, p1, p2, v2}, Lcom/amazon/avod/sdk/internal/BindingConnection$HandleResponseTask;-><init>(Lcom/amazon/avod/sdk/ResponseHandler;Lcom/amazon/avod/sdk/CallResponse;Lcom/amazon/avod/sdk/internal/BindingConnection$1;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 297
    :cond_0
    return-void
.end method

.method private sendDefaultSuccessResponse(Lcom/amazon/avod/sdk/ResponseHandler;)V
    .locals 4
    .param p1, "handler"    # Lcom/amazon/avod/sdk/ResponseHandler;

    .prologue
    .line 192
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 193
    .local v0, "bundle":Landroid/os/Bundle;
    const-string/jumbo v2, "callResponseType"

    sget-object v3, Lcom/amazon/avod/sdk/Constants$CallResponseType;->SUCCESS:Lcom/amazon/avod/sdk/Constants$CallResponseType;

    invoke-virtual {v3}, Lcom/amazon/avod/sdk/Constants$CallResponseType;->getResponseCode()I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 194
    invoke-static {v0}, Lcom/amazon/avod/sdk/CallResponse;->fromBundle(Landroid/os/Bundle;)Lcom/amazon/avod/sdk/CallResponse;

    move-result-object v1

    .line 195
    .local v1, "response":Lcom/amazon/avod/sdk/CallResponse;
    invoke-direct {p0, p1, v1}, Lcom/amazon/avod/sdk/internal/BindingConnection;->handleResponseOnUiThread(Lcom/amazon/avod/sdk/ResponseHandler;Lcom/amazon/avod/sdk/CallResponse;)V

    .line 196
    return-void
.end method


# virtual methods
.method public disconnect()V
    .locals 2

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mFallbackConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

    invoke-interface {v0}, Lcom/amazon/avod/sdk/internal/AivConnection;->disconnect()V

    .line 89
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mBackgroundExecutor:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/amazon/avod/sdk/internal/BindingConnection$1;

    invoke-direct {v1, p0}, Lcom/amazon/avod/sdk/internal/BindingConnection$1;-><init>(Lcom/amazon/avod/sdk/internal/BindingConnection;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 95
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mBackgroundExecutor:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdown()V

    .line 96
    return-void
.end method

.method public playVideo(Ljava/lang/String;Ljava/util/Map;)V
    .locals 5
    .param p1, "asin"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 134
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 135
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 136
    .local v2, "param":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 151
    .end local v2    # "param":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    new-instance v3, Lcom/amazon/avod/sdk/internal/BindingConnection$1PlayVideoRunnable;

    iget-object v4, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    invoke-direct {v3, p0, v4, p1, v0}, Lcom/amazon/avod/sdk/internal/BindingConnection$1PlayVideoRunnable;-><init>(Lcom/amazon/avod/sdk/internal/BindingConnection;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Ljava/lang/String;Landroid/os/Bundle;)V

    invoke-direct {p0, v3}, Lcom/amazon/avod/sdk/internal/BindingConnection;->callBindingAsync(Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;)V

    .line 152
    return-void
.end method

.method public queryPlaybackSupport(Lcom/amazon/avod/sdk/PlaybackSupportResponse;)V
    .locals 2
    .param p1, "callback"    # Lcom/amazon/avod/sdk/PlaybackSupportResponse;

    .prologue
    .line 124
    new-instance v0, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;

    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    invoke-direct {v0, p0, v1, p1}, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;-><init>(Lcom/amazon/avod/sdk/internal/BindingConnection;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Lcom/amazon/avod/sdk/PlaybackSupportResponse;)V

    invoke-direct {p0, v0}, Lcom/amazon/avod/sdk/internal/BindingConnection;->callBindingAsync(Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;)V

    .line 125
    return-void
.end method

.method public teardownPreparedVideo(Lcom/amazon/avod/sdk/ResponseHandler;)V
    .locals 2
    .param p1, "handler"    # Lcom/amazon/avod/sdk/ResponseHandler;

    .prologue
    .line 185
    new-instance v0, Lcom/amazon/avod/sdk/internal/BindingConnection$1TeardownRunnable;

    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    invoke-direct {v0, p0, v1, p1}, Lcom/amazon/avod/sdk/internal/BindingConnection$1TeardownRunnable;-><init>(Lcom/amazon/avod/sdk/internal/BindingConnection;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Lcom/amazon/avod/sdk/ResponseHandler;)V

    invoke-direct {p0, v0}, Lcom/amazon/avod/sdk/internal/BindingConnection;->callBindingAsync(Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;)V

    .line 186
    return-void
.end method

.method public tryConnect()Z
    .locals 3

    .prologue
    .line 66
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mFallbackConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

    invoke-interface {v1}, Lcom/amazon/avod/sdk/internal/AivConnection;->tryConnect()Z

    move-result v1

    if-nez v1, :cond_0

    .line 71
    const-string/jumbo v1, "AmazonInstantVideoSDK"

    const-string/jumbo v2, "Could not establish fallback connection, legacy functionality will be unavailable"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 74
    :cond_0
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    invoke-virtual {v1}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->canBind()Z

    move-result v0

    .line 75
    .local v0, "canBind":Z
    if-eqz v0, :cond_1

    .line 76
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    invoke-virtual {v1}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->bind()V

    .line 79
    :cond_1
    return v0
.end method

.method public whisperCacheContent(Ljava/util/List;Lcom/amazon/avod/sdk/CacheLevel;)V
    .locals 2
    .param p2, "cacheLevel"    # Lcom/amazon/avod/sdk/CacheLevel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/avod/sdk/CacheLevel;",
            ")V"
        }
    .end annotation

    .prologue
    .line 211
    .local p1, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v0, Lcom/amazon/avod/sdk/internal/BindingConnection$1WhisperCacheRunnable;

    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    invoke-direct {v0, p0, v1, p1, p2}, Lcom/amazon/avod/sdk/internal/BindingConnection$1WhisperCacheRunnable;-><init>(Lcom/amazon/avod/sdk/internal/BindingConnection;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Ljava/util/List;Lcom/amazon/avod/sdk/CacheLevel;)V

    invoke-direct {p0, v0}, Lcom/amazon/avod/sdk/internal/BindingConnection;->callBindingAsync(Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;)V

    .line 212
    return-void
.end method
