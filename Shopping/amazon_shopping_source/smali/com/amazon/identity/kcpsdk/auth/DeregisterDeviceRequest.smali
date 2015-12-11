.class public Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;
.super Ljava/lang/Object;
.source "DeregisterDeviceRequest.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mDeregisterExisting:Z

.field private mDidDeleteContent:Z

.field private mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    return-void
.end method


# virtual methods
.method public getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .locals 5

    .prologue
    const/4 v3, 0x1

    .line 33
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    if-eqz v0, :cond_0

    .line 35
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .line 70
    :goto_0
    return-object v0

    .line 38
    :cond_0
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .line 40
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebProtocol;->WebProtocolHttps:Lcom/amazon/identity/kcpsdk/common/WebProtocol;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setProtocol(Lcom/amazon/identity/kcpsdk/common/WebProtocol;)V

    .line 41
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getFIRSHost()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHost(Ljava/lang/String;)V

    .line 42
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v1, "/FirsProxy/disownFiona"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setPath(Ljava/lang/String;)V

    .line 43
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbGet:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setVerb(Lcom/amazon/identity/kcpsdk/common/HttpVerb;)V

    .line 45
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mDidDeleteContent:Z

    if-eqz v0, :cond_1

    .line 47
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v1, "contentDeleted"

    const-string/jumbo v2, "true"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    :goto_1
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mDeregisterExisting:Z

    if-eqz v0, :cond_2

    .line 56
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v1, "deregisterExisting"

    const-string/jumbo v2, "true"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    :goto_2
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v1, "Content-Type"

    const-string/jumbo v2, "text/xml"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v0, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setAuthenticationRequired(Z)V

    .line 67
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "DeregisterDeviceRequest: getWebRequest: constructed a web request with:\nContent Deleted: %s"

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mDidDeleteContent:Z

    if-eqz v0, :cond_3

    const-string/jumbo v0, "Yes"

    :goto_3
    aput-object v0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 70
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    goto :goto_0

    .line 51
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v1, "contentDeleted"

    const-string/jumbo v2, "false"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 60
    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v1, "deregisterExisting"

    const-string/jumbo v2, "false"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 67
    :cond_3
    const-string/jumbo v0, "No"

    goto :goto_3
.end method

.method public setDeregisterAllAccountsForDevice(Z)V
    .locals 0
    .param p1, "deregisterExistingAccounts"    # Z

    .prologue
    .line 28
    iput-boolean p1, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mDeregisterExisting:Z

    .line 29
    return-void
.end method

.method public setDidDeleteContent(Z)V
    .locals 0
    .param p1, "didDeleteContent"    # Z

    .prologue
    .line 23
    iput-boolean p1, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->mDidDeleteContent:Z

    .line 24
    return-void
.end method
