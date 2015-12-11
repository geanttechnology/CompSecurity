.class public Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;
.super Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
.source "AlertZipResponseHandler.java"


# static fields
.field public static final logger:Lorg/slf4j/Logger;


# instance fields
.field private fipsCode:Ljava/lang/String;

.field private listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

.field private retryAttempt:I

.field private retryInterval:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->logger:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;-><init>()V

    .line 23
    const/16 v0, 0x3e8

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->retryInterval:I

    .line 24
    const/4 v0, 0x1

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->retryAttempt:I

    .line 29
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    .line 30
    return-void
.end method

.method private declared-synchronized handleResponse(Ljava/lang/String;)V
    .locals 4
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 63
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->parseFipsCodeResponse(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->fipsCode:Ljava/lang/String;

    .line 65
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->fipsCode:Ljava/lang/String;

    invoke-static {v1}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 66
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->fipsCode:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->fipsCodeFound(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 73
    :goto_0
    monitor-exit p0

    return-void

    .line 68
    :cond_0
    :try_start_1
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to receive fips from uri: : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->requestFailed(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 70
    :catch_0
    move-exception v0

    .line 71
    .local v0, "e":Ljava/lang/Exception;
    :try_start_2
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to receive fips from zipcode. Exception occured: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->requestFailed(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 63
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method


# virtual methods
.method public requestFailed(Ljava/lang/String;)V
    .locals 1
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->requestFailed(Ljava/lang/String;)V

    .line 58
    return-void
.end method

.method public responseReceived(Ljava/lang/String;)V
    .locals 0
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 52
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;->handleResponse(Ljava/lang/String;)V

    .line 53
    return-void
.end method
