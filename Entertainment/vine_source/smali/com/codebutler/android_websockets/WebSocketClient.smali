.class public Lcom/codebutler/android_websockets/WebSocketClient;
.super Ljava/lang/Object;
.source "WebSocketClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/codebutler/android_websockets/WebSocketClient$Listener;
    }
.end annotation


# static fields
.field public static final FLAG_CONNECTED:I = 0x2

.field public static final FLAG_CONNECTING:I = 0x1

.field private static final TAG:Ljava/lang/String; = "WebSocketClient"

.field private static sTrustManagers:[Ljavax/net/ssl/TrustManager;


# instance fields
.field private volatile mConnectionFlag:I

.field private mExtraHeaders:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private mHandler:Landroid/os/Handler;

.field private mHandlerThread:Landroid/os/HandlerThread;

.field private mListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;

.field private mParser:Lcom/codebutler/android_websockets/HybiParser;

.field private final mSendLock:Ljava/lang/Object;

.field private mSocket:Ljava/net/Socket;

.field private mThread:Ljava/lang/Thread;

.field private mURI:Ljava/net/URI;


# direct methods
.method public constructor <init>(Ljava/net/URI;Lcom/codebutler/android_websockets/WebSocketClient$Listener;Ljava/util/List;)V
    .locals 2
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
    .line 54
    .local p3, "extraHeaders":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/message/BasicNameValuePair;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mSendLock:Ljava/lang/Object;

    .line 55
    iput-object p1, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mURI:Ljava/net/URI;

    .line 56
    iput-object p2, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    .line 57
    iput-object p3, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mExtraHeaders:Ljava/util/List;

    .line 58
    new-instance v0, Lcom/codebutler/android_websockets/HybiParser;

    invoke-direct {v0, p0}, Lcom/codebutler/android_websockets/HybiParser;-><init>(Lcom/codebutler/android_websockets/WebSocketClient;)V

    iput-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mParser:Lcom/codebutler/android_websockets/HybiParser;

    .line 60
    new-instance v0, Landroid/os/HandlerThread;

    const-string v1, "websocket-thread"

    invoke-direct {v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mHandlerThread:Landroid/os/HandlerThread;

    .line 61
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 62
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mHandler:Landroid/os/Handler;

    .line 63
    const/4 v0, 0x0

    iput v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mConnectionFlag:I

    .line 64
    return-void
.end method

.method static synthetic access$002(Lcom/codebutler/android_websockets/WebSocketClient;I)I
    .locals 0
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;
    .param p1, "x1"    # I

    .prologue
    .line 30
    iput p1, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mConnectionFlag:I

    return p1
.end method

.method static synthetic access$100(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/codebutler/android_websockets/WebSocketClient;->createSecret()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1000(Lcom/codebutler/android_websockets/WebSocketClient;)Lcom/codebutler/android_websockets/WebSocketClient$Listener;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/codebutler/android_websockets/WebSocketClient;)Lcom/codebutler/android_websockets/HybiParser;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mParser:Lcom/codebutler/android_websockets/HybiParser;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mSendLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$200(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/URI;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mURI:Ljava/net/URI;

    return-object v0
.end method

.method static synthetic access$300(Lcom/codebutler/android_websockets/WebSocketClient;)Ljavax/net/ssl/SSLSocketFactory;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/KeyManagementException;
        }
    .end annotation

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/codebutler/android_websockets/WebSocketClient;->getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/net/Socket;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;

    return-object v0
.end method

.method static synthetic access$402(Lcom/codebutler/android_websockets/WebSocketClient;Ljava/net/Socket;)Ljava/net/Socket;
    .locals 0
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;
    .param p1, "x1"    # Ljava/net/Socket;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;

    return-object p1
.end method

.method static synthetic access$500(Lcom/codebutler/android_websockets/WebSocketClient;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mExtraHeaders:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$600(Lcom/codebutler/android_websockets/WebSocketClient;Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;
    .param p1, "x1"    # Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/codebutler/android_websockets/WebSocketClient;->readLine(Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$700(Lcom/codebutler/android_websockets/WebSocketClient;Ljava/lang/String;)Lorg/apache/http/StatusLine;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/codebutler/android_websockets/WebSocketClient;->parseStatusLine(Ljava/lang/String;)Lorg/apache/http/StatusLine;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$800(Lcom/codebutler/android_websockets/WebSocketClient;Ljava/lang/String;)Lorg/apache/http/Header;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/codebutler/android_websockets/WebSocketClient;->parseHeader(Ljava/lang/String;)Lorg/apache/http/Header;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$900(Lcom/codebutler/android_websockets/WebSocketClient;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/codebutler/android_websockets/WebSocketClient;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/codebutler/android_websockets/WebSocketClient;->createSecretValidation(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private createSecret()Ljava/lang/String;
    .locals 7

    .prologue
    const/16 v6, 0x10

    .line 233
    new-array v1, v6, [B

    .line 234
    .local v1, "nonce":[B
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v6, :cond_0

    .line 235
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v2

    const-wide/high16 v4, 0x4070000000000000L    # 256.0

    mul-double/2addr v2, v4

    double-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v1, v0

    .line 234
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 237
    :cond_0
    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private createSecretValidation(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "secret"    # Ljava/lang/String;

    .prologue
    .line 242
    :try_start_0
    const-string v2, "SHA-1"

    invoke-static {v2}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v1

    .line 243
    .local v1, "md":Ljava/security/MessageDigest;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "258EAFA5-E914-47DA-95CA-C5AB0DC85B11"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/security/MessageDigest;->update([B)V

    .line 244
    invoke-virtual {v1}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v2, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    return-object v2

    .line 245
    .end local v1    # "md":Ljava/security/MessageDigest;
    :catch_0
    move-exception v0

    .line 246
    .local v0, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method private getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/KeyManagementException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 282
    const-string v1, "TLS"

    invoke-static {v1}, Ljavax/net/ssl/SSLContext;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;

    move-result-object v0

    .line 283
    .local v0, "context":Ljavax/net/ssl/SSLContext;
    sget-object v1, Lcom/codebutler/android_websockets/WebSocketClient;->sTrustManagers:[Ljavax/net/ssl/TrustManager;

    invoke-virtual {v0, v2, v1, v2}, Ljavax/net/ssl/SSLContext;->init([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V

    .line 284
    invoke-virtual {v0}, Ljavax/net/ssl/SSLContext;->getSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v1

    return-object v1
.end method

.method private parseHeader(Ljava/lang/String;)Lorg/apache/http/Header;
    .locals 1
    .param p1, "line"    # Ljava/lang/String;

    .prologue
    .line 209
    new-instance v0, Lorg/apache/http/message/BasicLineParser;

    invoke-direct {v0}, Lorg/apache/http/message/BasicLineParser;-><init>()V

    invoke-static {p1, v0}, Lorg/apache/http/message/BasicLineParser;->parseHeader(Ljava/lang/String;Lorg/apache/http/message/LineParser;)Lorg/apache/http/Header;

    move-result-object v0

    return-object v0
.end method

.method private parseStatusLine(Ljava/lang/String;)Lorg/apache/http/StatusLine;
    .locals 1
    .param p1, "line"    # Ljava/lang/String;

    .prologue
    .line 202
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 203
    const/4 v0, 0x0

    .line 205
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lorg/apache/http/message/BasicLineParser;

    invoke-direct {v0}, Lorg/apache/http/message/BasicLineParser;-><init>()V

    invoke-static {p1, v0}, Lorg/apache/http/message/BasicLineParser;->parseStatusLine(Ljava/lang/String;Lorg/apache/http/message/LineParser;)Lorg/apache/http/StatusLine;

    move-result-object v0

    goto :goto_0
.end method

.method private readLine(Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;)Ljava/lang/String;
    .locals 5
    .param p1, "reader"    # Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v4, -0x1

    .line 214
    invoke-virtual {p1}, Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;->read()I

    move-result v0

    .line 215
    .local v0, "readChar":I
    if-ne v0, v4, :cond_0

    .line 229
    :goto_0
    return-object v2

    .line 218
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, ""

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 219
    .local v1, "string":Ljava/lang/StringBuilder;
    :cond_1
    const/16 v3, 0xa

    if-eq v0, v3, :cond_3

    .line 220
    const/16 v3, 0xd

    if-eq v0, v3, :cond_2

    .line 221
    int-to-char v3, v0

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 224
    :cond_2
    invoke-virtual {p1}, Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;->read()I

    move-result v0

    .line 225
    if-ne v0, v4, :cond_1

    goto :goto_0

    .line 229
    :cond_3
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public static setTrustManagers([Ljavax/net/ssl/TrustManager;)V
    .locals 0
    .param p0, "tm"    # [Ljavax/net/ssl/TrustManager;

    .prologue
    .line 51
    sput-object p0, Lcom/codebutler/android_websockets/WebSocketClient;->sTrustManagers:[Ljavax/net/ssl/TrustManager;

    .line 52
    return-void
.end method


# virtual methods
.method public connect()V
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mThread:Ljava/lang/Thread;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->isAlive()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 172
    :goto_0
    return-void

    .line 83
    :cond_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/codebutler/android_websockets/WebSocketClient$1;

    invoke-direct {v1, p0}, Lcom/codebutler/android_websockets/WebSocketClient$1;-><init>(Lcom/codebutler/android_websockets/WebSocketClient;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mThread:Ljava/lang/Thread;

    .line 171
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_0
.end method

.method public disconnect()V
    .locals 2

    .prologue
    .line 175
    const/4 v0, 0x0

    iput v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mConnectionFlag:I

    .line 176
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 177
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/codebutler/android_websockets/WebSocketClient$2;

    invoke-direct {v1, p0}, Lcom/codebutler/android_websockets/WebSocketClient$2;-><init>(Lcom/codebutler/android_websockets/WebSocketClient;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 191
    :cond_0
    return-void
.end method

.method public getListener()Lcom/codebutler/android_websockets/WebSocketClient$Listener;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mListener:Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    return-object v0
.end method

.method public isConnected()Z
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mConnectionFlag:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isConnecting()Z
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mSocket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mConnectionFlag:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public send(Ljava/lang/String;)V
    .locals 1
    .param p1, "data"    # Ljava/lang/String;

    .prologue
    .line 194
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mParser:Lcom/codebutler/android_websockets/HybiParser;

    invoke-virtual {v0, p1}, Lcom/codebutler/android_websockets/HybiParser;->frame(Ljava/lang/String;)[B

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/codebutler/android_websockets/WebSocketClient;->sendFrame([B)V

    .line 195
    return-void
.end method

.method public send([B)V
    .locals 1
    .param p1, "data"    # [B

    .prologue
    .line 198
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mParser:Lcom/codebutler/android_websockets/HybiParser;

    invoke-virtual {v0, p1}, Lcom/codebutler/android_websockets/HybiParser;->frame([B)[B

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/codebutler/android_websockets/WebSocketClient;->sendFrame([B)V

    .line 199
    return-void
.end method

.method sendFrame([B)V
    .locals 2
    .param p1, "frame"    # [B

    .prologue
    .line 251
    iget-object v0, p0, Lcom/codebutler/android_websockets/WebSocketClient;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/codebutler/android_websockets/WebSocketClient$3;

    invoke-direct {v1, p0, p1}, Lcom/codebutler/android_websockets/WebSocketClient$3;-><init>(Lcom/codebutler/android_websockets/WebSocketClient;[B)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 271
    return-void
.end method
