.class Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;
.super Lcom/amazon/device/ads/AmazonOOUserIdentifier;
.source "AmazonOODMSUserIdentifier.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$3;,
        Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;,
        Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$KCPAuthLogInterceptor;,
        Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;
    }
.end annotation


# static fields
.field private static final LOGTAG:Ljava/lang/String;

.field private static final PATH:Ljava/lang/String; = "/RegisterDMS"

.field private static commonObjectsInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;


# instance fields
.field private tokenAuthProvider:Lcom/AmazonDevice/Authentication/ITokenAuthProvider;

.field private webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 38
    const-class v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->LOGTAG:Ljava/lang/String;

    .line 40
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    sput-object v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->commonObjectsInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "adpToken"    # Ljava/lang/String;
    .param p2, "privateKey"    # Ljava/lang/String;

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/amazon/device/ads/AmazonOOUserIdentifier;-><init>()V

    .line 42
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->tokenAuthProvider:Lcom/AmazonDevice/Authentication/ITokenAuthProvider;

    .line 52
    sget-object v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->commonObjectsInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-nez v0, :cond_0

    .line 54
    new-instance v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$KCPAuthLogInterceptor;

    invoke-direct {v0}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$KCPAuthLogInterceptor;-><init>()V

    invoke-static {v0}, Lcom/AmazonDevice/Identity/Common/Log;->setLogOutput(Lcom/AmazonDevice/Identity/Common/ILogOutput;)V

    .line 55
    sget-object v0, Lcom/AmazonDevice/Identity/Common/SdkLogLevel;->SdkLogLevelDebug:Lcom/AmazonDevice/Identity/Common/SdkLogLevel;

    invoke-static {v0}, Lcom/AmazonDevice/Identity/Common/Log;->setLogLevel(Lcom/AmazonDevice/Identity/Common/SdkLogLevel;)V

    .line 57
    :cond_0
    invoke-static {p1, p2}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->makeITokenAuth(Ljava/lang/String;Ljava/lang/String;)Lcom/AmazonDevice/Authentication/ITokenAuthProvider;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->tokenAuthProvider:Lcom/AmazonDevice/Authentication/ITokenAuthProvider;

    .line 58
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    sget-object v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->LOGTAG:Ljava/lang/String;

    return-object v0
.end method

.method private buildWebRequest()V
    .locals 3

    .prologue
    .line 98
    new-instance v0, Lcom/AmazonDevice/Identity/Common/WebRequest;

    invoke-direct {v0}, Lcom/AmazonDevice/Identity/Common/WebRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    .line 99
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    invoke-direct {p0}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->getProtocol()Lcom/AmazonDevice/Identity/Common/WebProtocol;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/AmazonDevice/Identity/Common/WebRequest;->setProtocol(Lcom/AmazonDevice/Identity/Common/WebProtocol;)V

    .line 100
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    const-string/jumbo v1, "/RegisterDMS"

    invoke-virtual {v0, v1}, Lcom/AmazonDevice/Identity/Common/WebRequest;->setPath(Ljava/lang/String;)V

    .line 101
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    sget-object v1, Lcom/AmazonDevice/Identity/Common/HttpVerb;->HttpVerbPost:Lcom/AmazonDevice/Identity/Common/HttpVerb;

    invoke-virtual {v0, v1}, Lcom/AmazonDevice/Identity/Common/WebRequest;->setVerb(Lcom/AmazonDevice/Identity/Common/HttpVerb;)V

    .line 103
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->createWebRequestAdapter()Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->setParametersAndHost(Lcom/amazon/device/ads/WebRequest;)V

    .line 105
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    const-string/jumbo v1, "Accept"

    const-string/jumbo v2, "application/json"

    invoke-virtual {v0, v1, v2}, Lcom/AmazonDevice/Identity/Common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    return-void
.end method

.method private getProtocol()Lcom/AmazonDevice/Identity/Common/WebProtocol;
    .locals 2

    .prologue
    .line 121
    const-string/jumbo v0, "debug.madsUseSecure"

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 123
    sget-object v0, Lcom/AmazonDevice/Identity/Common/WebProtocol;->WebProtocolHttps:Lcom/AmazonDevice/Identity/Common/WebProtocol;

    .line 127
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/AmazonDevice/Identity/Common/WebProtocol;->WebProtocolHttp:Lcom/AmazonDevice/Identity/Common/WebProtocol;

    goto :goto_0
.end method

.method private static makeITokenAuth(Ljava/lang/String;Ljava/lang/String;)Lcom/AmazonDevice/Authentication/ITokenAuthProvider;
    .locals 1
    .param p0, "adpToken"    # Ljava/lang/String;
    .param p1, "privateKey"    # Ljava/lang/String;

    .prologue
    .line 62
    new-instance v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$1;

    invoke-direct {v0, p0, p1}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$1;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method protected callWebService()Z
    .locals 8

    .prologue
    .line 145
    invoke-direct {p0}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->buildWebRequest()V

    .line 147
    new-instance v1, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v5, 0x0

    invoke-direct {v1, v5}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    .line 148
    .local v1, "callSuccessful":Ljava/util/concurrent/atomic/AtomicBoolean;
    new-instance v4, Ljava/util/concurrent/CountDownLatch;

    const/4 v5, 0x1

    invoke-direct {v4, v5}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 149
    .local v4, "latch":Ljava/util/concurrent/CountDownLatch;
    new-instance v2, Lcom/AmazonDevice/Authentication/AmazonWebserviceCaller;

    iget-object v5, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->tokenAuthProvider:Lcom/AmazonDevice/Authentication/ITokenAuthProvider;

    invoke-direct {v2, v5}, Lcom/AmazonDevice/Authentication/AmazonWebserviceCaller;-><init>(Lcom/AmazonDevice/Authentication/ITokenAuthProvider;)V

    .line 150
    .local v2, "caller":Lcom/AmazonDevice/Authentication/AmazonWebserviceCaller;
    iget-object v5, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    new-instance v6, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;

    invoke-direct {v6}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;-><init>()V

    new-instance v7, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;

    invoke-direct {v7, p0, v4, v1}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$2;-><init>(Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;Ljava/util/concurrent/CountDownLatch;Ljava/util/concurrent/atomic/AtomicBoolean;)V

    invoke-virtual {v2, v5, v6, v7}, Lcom/AmazonDevice/Authentication/AmazonWebserviceCaller;->createCall(Lcom/AmazonDevice/Identity/Common/WebRequest;Lcom/AmazonDevice/Identity/Common/IWebResponseParser;Lcom/AmazonDevice/Authentication/IAmazonWebserviceCallListener;)Lcom/AmazonDevice/Authentication/AmazonWebserviceCall;

    move-result-object v0

    .line 193
    .local v0, "call":Lcom/AmazonDevice/Authentication/AmazonWebserviceCall;
    :try_start_0
    invoke-virtual {v0}, Lcom/AmazonDevice/Authentication/AmazonWebserviceCall;->call()V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 207
    :goto_0
    :try_start_1
    invoke-virtual {v4}, Ljava/util/concurrent/CountDownLatch;->await()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1

    .line 214
    :goto_1
    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v5

    return v5

    .line 195
    :catch_0
    move-exception v3

    .line 201
    .local v3, "e":Ljava/lang/SecurityException;
    sget-object v5, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->LOGTAG:Ljava/lang/String;

    const-string/jumbo v6, "Calling MobileAdsService was not successful due to a SecurityException"

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 202
    invoke-virtual {v4}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_0

    .line 209
    .end local v3    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v5

    goto :goto_1
.end method

.method protected createWebRequestAdapter()Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;
    .locals 2

    .prologue
    .line 110
    new-instance v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;

    iget-object v1, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    invoke-direct {v0, p0, v1}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;-><init>(Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;Lcom/AmazonDevice/Identity/Common/WebRequest;)V

    return-object v0
.end method

.method public executeRequest()V
    .locals 2

    .prologue
    .line 85
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x8

    if-gt v0, v1, :cond_0

    .line 87
    sget-object v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->LOGTAG:Ljava/lang/String;

    const-string/jumbo v1, "This functionality is only supported with Android SDK v9 and higher."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    :goto_0
    return-void

    .line 90
    :cond_0
    invoke-super {p0}, Lcom/amazon/device/ads/AmazonOOUserIdentifier;->executeRequest()V

    goto :goto_0
.end method

.method getWebRequest()Lcom/AmazonDevice/Identity/Common/WebRequest;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    return-object v0
.end method

.method protected identifyUser()Z
    .locals 1

    .prologue
    .line 137
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->callWebService()Z

    move-result v0

    return v0
.end method
