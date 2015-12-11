.class public Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;
.super Ljava/lang/Object;
.source "RenameDeviceRequest.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mDeviceName:Ljava/lang/String;

.field private mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    return-void
.end method


# virtual methods
.method public getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 37
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mDeviceName:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 39
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "getWebRequest: Cannot construct a WebRequest because the RenameDeviceRequest is invalid. (See previous warnings from RenameDeviceRequest::isValidDeviceName for details.)"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    const/4 v0, 0x0

    .line 67
    :goto_0
    return-object v0

    .line 44
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    if-eqz v0, :cond_1

    .line 46
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    goto :goto_0

    .line 49
    :cond_1
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .line 51
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebProtocol;->WebProtocolHttps:Lcom/amazon/identity/kcpsdk/common/WebProtocol;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setProtocol(Lcom/amazon/identity/kcpsdk/common/WebProtocol;)V

    .line 52
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getFIRSHost()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHost(Ljava/lang/String;)V

    .line 53
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v1, "/FirsProxy/renameFiona"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setPath(Ljava/lang/String;)V

    .line 54
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbGet:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setVerb(Lcom/amazon/identity/kcpsdk/common/HttpVerb;)V

    .line 55
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mDeviceName:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 57
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v1, "nickname"

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mDeviceName:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v1, "Content-Type"

    const-string/jumbo v2, "text/xml"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v0, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setAuthenticationRequired(Z)V

    .line 64
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "getWebRequest: getWebRequest: constructed a web request."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->TAG:Ljava/lang/String;

    new-array v0, v3, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mDeviceName:Ljava/lang/String;

    aput-object v2, v0, v1

    .line 67
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    goto :goto_0
.end method

.method public setDeviceName(Ljava/lang/String;)Z
    .locals 2
    .param p1, "deviceName"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 27
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setDeviceName: device name was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    const/4 v0, 0x0

    .line 32
    :goto_0
    return v0

    .line 31
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->mDeviceName:Ljava/lang/String;

    .line 32
    const/4 v0, 0x1

    goto :goto_0
.end method
