.class public Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;
.super Ljava/lang/Object;
.source "UpdateDeviceCredentialsRequest.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mDeviceTypeSoftwareVersionMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mReason:Ljava/lang/String;

.field private mSoftwareComponentId:Ljava/lang/String;

.field private mSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

.field private mUrl:Ljava/lang/String;

.field private mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->getDefaultUrl()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mUrl:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public static getDefaultUrl()Ljava/lang/String;
    .locals 2

    .prologue
    .line 34
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "https://"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getFIRSHost()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "/FirsProxy/getDeviceCredentials"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static isValidReason(Ljava/lang/String;)Z
    .locals 2
    .param p0, "reason"    # Ljava/lang/String;

    .prologue
    .line 72
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 74
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "isValidReason: returning false because a null or empty reason was given."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    const/4 v0, 0x0

    .line 78
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isValidSoftwareVersion(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)Z
    .locals 1
    .param p0, "swVer"    # Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    .prologue
    .line 101
    const/4 v0, 0x1

    return v0
.end method

.method public static isValidURL(Ljava/lang/String;)Z
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 54
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->isValidUrl(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .locals 6

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 126
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->isValid()Z

    move-result v1

    if-nez v1, :cond_0

    .line 128
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "getWebRequest: Cannot construct a WebRequest because the UpdateDeviceCredentialsRequest is invalid. (See previous warnings from UpdateDeviceCredentialsRequest::isValid for details.)"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    const/4 v1, 0x0

    .line 177
    :goto_0
    return-object v1

    .line 134
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    if-eqz v1, :cond_1

    .line 136
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    goto :goto_0

    .line 138
    :cond_1
    new-instance v1, Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-direct {v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .line 139
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mUrl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setUrl(Ljava/lang/String;)Z

    .line 140
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbGet:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setVerb(Lcom/amazon/identity/kcpsdk/common/HttpVerb;)V

    .line 142
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mReason:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 144
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v2, "reason"

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mReason:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    :cond_2
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    if-eqz v1, :cond_3

    .line 149
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v2, "softwareVersion"

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->getString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    :cond_3
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mSoftwareComponentId:Ljava/lang/String;

    if-eqz v1, :cond_4

    .line 154
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v2, "softwareComponentId"

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mSoftwareComponentId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    :cond_4
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v2, "Content-Type"

    const-string/jumbo v3, "text/xml"

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 161
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    if-eqz v1, :cond_5

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v1

    if-lez v1, :cond_5

    .line 163
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v1, "request"

    new-array v2, v5, [Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLEntity;)V

    .line 164
    .local v0, "request":Lcom/amazon/identity/kcpsdk/common/XMLElement;
    new-instance v1, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    invoke-direct {v1, v2}, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;-><init>(Ljava/util/Map;)V

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChild(Lcom/amazon/identity/kcpsdk/common/XMLEntity;)Z

    .line 165
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->convertToString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setBody(Ljava/lang/String;)V

    .line 170
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPost:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setVerb(Lcom/amazon/identity/kcpsdk/common/HttpVerb;)V

    .line 173
    .end local v0    # "request":Lcom/amazon/identity/kcpsdk/common/XMLElement;
    :cond_5
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v1, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setAuthenticationRequired(Z)V

    .line 175
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "getWebRequest: constructed a web request with:\nReason: %s"

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mReason:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 177
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    goto/16 :goto_0
.end method

.method public isValid()Z
    .locals 2

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mUrl:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 117
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "isValid: returning false because a valid url has not been set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    const/4 v0, 0x0

    .line 121
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setDeviceTypeToSoftwareVersionMapping(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 110
    .local p1, "versionMapForApps":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;>;"
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0, p1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    .line 111
    return-void
.end method

.method public setReason(Ljava/lang/String;)Z
    .locals 2
    .param p1, "reason"    # Ljava/lang/String;

    .prologue
    .line 59
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->isValidReason(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 61
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setReason: reason was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    const/4 v0, 0x0

    .line 67
    :goto_0
    return v0

    .line 65
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mReason:Ljava/lang/String;

    .line 67
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setSoftwareComponentId(Ljava/lang/String;)V
    .locals 0
    .param p1, "softwareComponentId"    # Ljava/lang/String;

    .prologue
    .line 96
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mSoftwareComponentId:Ljava/lang/String;

    .line 97
    return-void
.end method

.method public setSoftwareVersion(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)Z
    .locals 2
    .param p1, "swVer"    # Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    .prologue
    .line 83
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->isValidSoftwareVersion(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 85
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setSoftwareVersion: software version was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    const/4 v0, 0x0

    .line 91
    :goto_0
    return v0

    .line 89
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    .line 91
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setURL(Ljava/lang/String;)Z
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->isValidURL(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 41
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setURL: url is invalid. Cannot be set. Invalidating default URL to prevent it from being used."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mUrl:Ljava/lang/String;

    .line 45
    const/4 v0, 0x0

    .line 49
    :goto_0
    return v0

    .line 48
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->mUrl:Ljava/lang/String;

    .line 49
    const/4 v0, 0x1

    goto :goto_0
.end method
