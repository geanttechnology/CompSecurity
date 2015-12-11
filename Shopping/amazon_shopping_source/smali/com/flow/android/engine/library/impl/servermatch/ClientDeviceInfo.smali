.class public Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;
.super Ljava/lang/Object;
.source "ClientDeviceInfo.java"


# instance fields
.field private application:Ljava/lang/String;

.field private clientDevice:Ljava/lang/String;

.field private clientDeviceId:Ljava/lang/String;

.field private clientId:Ljava/lang/String;

.field private clientVersion:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field private deviceVersion:Ljava/lang/String;

.field private errorReportingResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

.field private errorReportingServer:Ljava/lang/String;

.field private imageMatchServer:Ljava/lang/String;

.field private imageMatchServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

.field private isDataCollectionDisabled:Z

.field private key:Ljava/lang/String;

.field private logoMatchServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

.field private secret:Ljava/lang/String;

.field private textServer:Ljava/lang/String;

.field private textServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_TERS_TR:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->textServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 28
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_VSEARCH:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->imageMatchServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 31
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_LOGO:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->logoMatchServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 33
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_VSEARCH:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->errorReportingResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 68
    return-void
.end method

.method public constructor <init>(Lcom/flow/android/engine/models/FlowStateEngineIO;)V
    .locals 3
    .param p1, "flowStateEngineIO"    # Lcom/flow/android/engine/models/FlowStateEngineIO;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_TERS_TR:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    iput-object v1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->textServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 28
    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_VSEARCH:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    iput-object v1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->imageMatchServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 31
    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_LOGO:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    iput-object v1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->logoMatchServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 33
    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_VSEARCH:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    iput-object v1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->errorReportingResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 42
    invoke-virtual {p1}, Lcom/flow/android/engine/models/FlowStateEngineIO;->getUsername()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setKey(Ljava/lang/String;)V

    .line 43
    invoke-virtual {p1}, Lcom/flow/android/engine/models/FlowStateEngineIO;->getSecret()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setSecret(Ljava/lang/String;)V

    .line 44
    invoke-virtual {p1}, Lcom/flow/android/engine/models/FlowStateEngineIO;->getApplication()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setApplication(Ljava/lang/String;)V

    .line 46
    invoke-virtual {p1}, Lcom/flow/android/engine/models/FlowStateEngineIO;->getClientVersion()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setClientVersion(Ljava/lang/String;)V

    .line 49
    invoke-virtual {p1}, Lcom/flow/android/engine/models/FlowStateEngineIO;->getClientDeviceID()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setClientDeviceId(Ljava/lang/String;)V

    .line 50
    invoke-virtual {p1}, Lcom/flow/android/engine/models/FlowStateEngineIO;->getClientSessionID()Ljava/lang/String;

    move-result-object v0

    .line 51
    .local v0, "clientSessionID":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/flow/android/engine/models/FlowStateEngineIO;->getClientSessionID()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_0

    .line 52
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 54
    :cond_0
    invoke-virtual {p0, v0}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setClientId(Ljava/lang/String;)V

    .line 55
    sget-object v1, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {p0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setDeviceVersion(Ljava/lang/String;)V

    .line 56
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Android - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setClientDevice(Ljava/lang/String;)V

    .line 58
    invoke-virtual {p1}, Lcom/flow/android/engine/models/FlowStateEngineIO;->getTextServer()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setHttpTextServer(Ljava/lang/String;)V

    .line 59
    invoke-virtual {p1}, Lcom/flow/android/engine/models/FlowStateEngineIO;->getImgServer()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setHttpImageMatchServer(Ljava/lang/String;)V

    .line 60
    invoke-virtual {p1}, Lcom/flow/android/engine/models/FlowStateEngineIO;->isDataCollectionDisabled()Z

    move-result v1

    invoke-virtual {p0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setDataCollectionDisabled(Z)V

    .line 61
    invoke-virtual {p1}, Lcom/flow/android/engine/models/FlowStateEngineIO;->getErrorReportingServer()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setHttpErrorReportingServer(Ljava/lang/String;)V

    .line 62
    return-void
.end method

.method private getMD5FromString(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "authStr"    # Ljava/lang/String;

    .prologue
    .line 78
    :try_start_0
    const-string/jumbo v4, "MD5"

    invoke-static {v4}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v2

    .line 79
    .local v2, "md":Ljava/security/MessageDigest;
    const-string/jumbo v4, "UTF-8"

    invoke-virtual {p1, v4}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v0

    .line 81
    .local v0, "b":[B
    const-string/jumbo v3, ""

    .line 82
    .local v3, "result":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v4, v0

    if-ge v1, v4, :cond_0

    .line 83
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    aget-byte v5, v0, v1

    and-int/lit16 v5, v5, 0xff

    add-int/lit16 v5, v5, 0x100

    const/16 v6, 0x10

    invoke-static {v5, v6}, Ljava/lang/Integer;->toString(II)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 82
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 86
    .end local v0    # "b":[B
    .end local v1    # "i":I
    .end local v2    # "md":Ljava/security/MessageDigest;
    .end local v3    # "result":Ljava/lang/String;
    :catch_0
    move-exception v4

    move-object v3, p1

    .line 88
    :cond_0
    return-object v3
.end method

.method private setHttpErrorReportingServer(Ljava/lang/String;)V
    .locals 0
    .param p1, "errorReportingServer"    # Ljava/lang/String;

    .prologue
    .line 129
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->errorReportingServer:Ljava/lang/String;

    .line 130
    return-void
.end method

.method private setHttpImageMatchServer(Ljava/lang/String;)V
    .locals 0
    .param p1, "imgServer"    # Ljava/lang/String;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->imageMatchServer:Ljava/lang/String;

    .line 98
    return-void
.end method

.method private setHttpTextServer(Ljava/lang/String;)V
    .locals 0
    .param p1, "textServer"    # Ljava/lang/String;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->textServer:Ljava/lang/String;

    .line 118
    return-void
.end method


# virtual methods
.method public getApplication()Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->application:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthtoken(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "timestamp"    # Ljava/lang/String;

    .prologue
    .line 92
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getSecret()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getApplication()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 93
    .local v0, "authStr":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getMD5FromString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getClientDevice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->clientDevice:Ljava/lang/String;

    return-object v0
.end method

.method public getClientDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->clientDeviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 181
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->clientId:Ljava/lang/String;

    return-object v0
.end method

.method public getClientVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->clientVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getConnectionType()Lcom/flow/android/engine/library/constants/ConnectionType;
    .locals 3

    .prologue
    .line 205
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->context:Landroid/content/Context;

    invoke-static {v1}, Lcom/flow/android/engine/library/utils/ConnectivityUtil;->getNetworkInfo(Landroid/content/Context;)Landroid/net/NetworkInfo;

    move-result-object v0

    .line 206
    .local v0, "info":Landroid/net/NetworkInfo;
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v1

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v2

    invoke-static {v1, v2}, Lcom/flow/android/engine/library/constants/ConnectionType;->findGroupByTypeSubtypeId(II)Lcom/flow/android/engine/library/constants/ConnectionType;

    move-result-object v1

    return-object v1
.end method

.method public getDeviceVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->deviceVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getHttpImageMatchServer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->imageMatchServer:Ljava/lang/String;

    return-object v0
.end method

.method public getHttpTextServer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->textServer:Ljava/lang/String;

    return-object v0
.end method

.method public getImageMatchServerResponseType()Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->imageMatchServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getRawNetworkSubTypeId()I
    .locals 2

    .prologue
    .line 210
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->context:Landroid/content/Context;

    invoke-static {v1}, Lcom/flow/android/engine/library/utils/ConnectivityUtil;->getNetworkInfo(Landroid/content/Context;)Landroid/net/NetworkInfo;

    move-result-object v0

    .line 211
    .local v0, "info":Landroid/net/NetworkInfo;
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v1

    return v1
.end method

.method public getSecret()Ljava/lang/String;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->secret:Ljava/lang/String;

    return-object v0
.end method

.method public getTextServerResponseType()Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->textServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    return-object v0
.end method

.method public getTimestampInEpochSeconds()Ljava/lang/String;
    .locals 6

    .prologue
    .line 72
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 73
    .local v0, "d":Ljava/util/Date;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public isDataCollectionDisabled()Z
    .locals 1

    .prologue
    .line 219
    iget-boolean v0, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->isDataCollectionDisabled:Z

    return v0
.end method

.method public setApplication(Ljava/lang/String;)V
    .locals 0
    .param p1, "application"    # Ljava/lang/String;

    .prologue
    .line 161
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->application:Ljava/lang/String;

    .line 162
    return-void
.end method

.method public setClientDevice(Ljava/lang/String;)V
    .locals 0
    .param p1, "clientDevice"    # Ljava/lang/String;

    .prologue
    .line 193
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->clientDevice:Ljava/lang/String;

    .line 194
    return-void
.end method

.method public setClientDeviceId(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceId"    # Ljava/lang/String;

    .prologue
    .line 177
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->clientDeviceId:Ljava/lang/String;

    .line 178
    return-void
.end method

.method public setClientId(Ljava/lang/String;)V
    .locals 0
    .param p1, "clientId"    # Ljava/lang/String;

    .prologue
    .line 185
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->clientId:Ljava/lang/String;

    .line 186
    return-void
.end method

.method public setClientVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "clientVersion"    # Ljava/lang/String;

    .prologue
    .line 169
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->clientVersion:Ljava/lang/String;

    .line 170
    return-void
.end method

.method public setContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 215
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->context:Landroid/content/Context;

    .line 216
    return-void
.end method

.method public setDataCollectionDisabled(Z)V
    .locals 0
    .param p1, "isDataCollectionDisabled"    # Z

    .prologue
    .line 223
    iput-boolean p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->isDataCollectionDisabled:Z

    .line 224
    return-void
.end method

.method public setDeviceVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceVersion"    # Ljava/lang/String;

    .prologue
    .line 201
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->deviceVersion:Ljava/lang/String;

    .line 202
    return-void
.end method

.method public setKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 145
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->key:Ljava/lang/String;

    .line 146
    return-void
.end method

.method public setSecret(Ljava/lang/String;)V
    .locals 0
    .param p1, "secret"    # Ljava/lang/String;

    .prologue
    .line 153
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->secret:Ljava/lang/String;

    .line 154
    return-void
.end method
