.class Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;
.super Lcom/amazon/device/ads/AmazonOOUserIdentifier;
.source "AmazonOOMAPUserIdentifier.java"


# static fields
.field private static final LOGTAG:Ljava/lang/String;

.field private static final PATH:Ljava/lang/String; = "/RegisterOAuth"


# instance fields
.field private authenticationPlatform:Lcom/amazon/device/ads/AmazonOOAuthenticationPlatformAdapter;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->LOGTAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/amazon/device/ads/AmazonOOUserIdentifier;-><init>()V

    .line 26
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->createAuthenticationPlatform()Lcom/amazon/device/ads/AmazonOOAuthenticationPlatformAdapter;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->authenticationPlatform:Lcom/amazon/device/ads/AmazonOOAuthenticationPlatformAdapter;

    .line 27
    return-void
.end method


# virtual methods
.method protected createAuthenticationPlatform()Lcom/amazon/device/ads/AmazonOOAuthenticationPlatformAdapter;
    .locals 1

    .prologue
    .line 31
    new-instance v0, Lcom/amazon/device/ads/AmazonOOMAPAdapter;

    invoke-direct {v0}, Lcom/amazon/device/ads/AmazonOOMAPAdapter;-><init>()V

    return-object v0
.end method

.method protected getAccount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->authenticationPlatform:Lcom/amazon/device/ads/AmazonOOAuthenticationPlatformAdapter;

    invoke-interface {v0}, Lcom/amazon/device/ads/AmazonOOAuthenticationPlatformAdapter;->getAccountName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected identifyUser()Z
    .locals 14

    .prologue
    const/4 v13, 0x0

    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 41
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->getAccount()Ljava/lang/String;

    move-result-object v0

    .line 42
    .local v0, "acct":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 73
    :cond_0
    :goto_0
    return v8

    .line 46
    :cond_1
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->makeWebRequest(Ljava/lang/String;)Lcom/amazon/device/ads/WebRequest;

    move-result-object v5

    .line 48
    .local v5, "webRequest":Lcom/amazon/device/ads/WebRequest;
    const/4 v6, 0x0

    .line 51
    .local v6, "webResponse":Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_start_0
    invoke-virtual {v5}, Lcom/amazon/device/ads/WebRequest;->makeCall()Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_end_0
    .catch Lcom/amazon/device/ads/WebRequest$WebRequestException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 58
    sget-object v9, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->LOGTAG:Ljava/lang/String;

    const-string/jumbo v10, "Service call result: %d"

    new-array v11, v7, [Ljava/lang/Object;

    invoke-virtual {v6}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getHttpStatusCode()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v11, v8

    invoke-static {v9, v10, v11}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 59
    invoke-virtual {v6}, Lcom/amazon/device/ads/WebRequest$WebResponse;->isHttpStatusCodeOK()Z

    move-result v9

    if-eqz v9, :cond_0

    .line 61
    invoke-virtual {v6}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getJSONObjectBody()Lorg/json/JSONObject;

    move-result-object v3

    .line 62
    .local v3, "jsonObject":Lorg/json/JSONObject;
    if-eqz v3, :cond_0

    .line 66
    const-string/jumbo v9, "code"

    invoke-static {v3, v9, v13}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 67
    .local v1, "code":Ljava/lang/String;
    const-string/jumbo v9, "status"

    invoke-static {v3, v9, v13}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 68
    .local v4, "status":Ljava/lang/String;
    sget-object v9, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->LOGTAG:Ljava/lang/String;

    const-string/jumbo v10, "Service result - code: %s, status: %s"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    aput-object v1, v11, v8

    aput-object v4, v11, v7

    invoke-static {v9, v10, v11}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 70
    if-eqz v1, :cond_2

    const-string/jumbo v9, "200"

    invoke-virtual {v1, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2

    :goto_1
    move v8, v7

    goto :goto_0

    .line 53
    .end local v1    # "code":Ljava/lang/String;
    .end local v3    # "jsonObject":Lorg/json/JSONObject;
    .end local v4    # "status":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 56
    .local v2, "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    goto :goto_0

    .end local v2    # "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    .restart local v1    # "code":Ljava/lang/String;
    .restart local v3    # "jsonObject":Lorg/json/JSONObject;
    .restart local v4    # "status":Ljava/lang/String;
    :cond_2
    move v7, v8

    .line 70
    goto :goto_1
.end method

.method protected makeAuthenticatedWebRequest(Ljava/lang/String;)Lcom/amazon/device/ads/WebRequest;
    .locals 1
    .param p1, "acct"    # Ljava/lang/String;

    .prologue
    .line 99
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->authenticationPlatform:Lcom/amazon/device/ads/AmazonOOAuthenticationPlatformAdapter;

    invoke-interface {v0, p1}, Lcom/amazon/device/ads/AmazonOOAuthenticationPlatformAdapter;->makeAuthenticatedWebRequest(Ljava/lang/String;)Lcom/amazon/device/ads/WebRequest;

    move-result-object v0

    return-object v0
.end method

.method protected makeWebRequest(Ljava/lang/String;)Lcom/amazon/device/ads/WebRequest;
    .locals 2
    .param p1, "acct"    # Ljava/lang/String;

    .prologue
    .line 86
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->makeAuthenticatedWebRequest(Ljava/lang/String;)Lcom/amazon/device/ads/WebRequest;

    move-result-object v0

    .line 87
    .local v0, "webRequest":Lcom/amazon/device/ads/WebRequest;
    sget-object v1, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->LOGTAG:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->setExternalLogTag(Ljava/lang/String;)V

    .line 88
    invoke-virtual {v0}, Lcom/amazon/device/ads/WebRequest;->convertToJSONPostRequest()V

    .line 90
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->enableLogUrl(Z)V

    .line 91
    const-string/jumbo v1, "/RegisterOAuth"

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->setPath(Ljava/lang/String;)V

    .line 92
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->setParametersAndHost(Lcom/amazon/device/ads/WebRequest;)V

    .line 94
    return-object v0
.end method
