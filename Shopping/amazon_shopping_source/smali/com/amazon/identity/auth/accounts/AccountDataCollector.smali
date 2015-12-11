.class public Lcom/amazon/identity/auth/accounts/AccountDataCollector;
.super Ljava/lang/Object;
.source "AccountDataCollector.java"


# instance fields
.field private mUserData:Landroid/os/Bundle;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    .line 23
    return-void
.end method


# virtual methods
.method public getCurrentUserData()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    invoke-virtual {v0}, Landroid/os/Bundle;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;

    return-object v0
.end method

.method public getUserDataNecessaryForAccountCreation()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 142
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->throwIfNotValid()V

    .line 144
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->getCurrentUserData()Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public setAccessToken(Ljava/lang/String;)V
    .locals 2
    .param p1, "accessToken"    # Ljava/lang/String;

    .prologue
    .line 202
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    return-void
.end method

.method public setAccessTokenExpiresIn(I)V
    .locals 3
    .param p1, "accessTokenExpiresIn"    # I

    .prologue
    .line 207
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 209
    return-void
.end method

.method public setAccountPool(Ljava/lang/String;)V
    .locals 2
    .param p1, "accountPool"    # Ljava/lang/String;

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.accountpool"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    return-void
.end method

.method public setAdpToken(Ljava/lang/String;)V
    .locals 2
    .param p1, "adpToken"    # Ljava/lang/String;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    return-void
.end method

.method public setCookies(Lorg/json/JSONArray;)V
    .locals 3
    .param p1, "cookies"    # Lorg/json/JSONArray;

    .prologue
    .line 197
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "website_cookies_json_array"

    invoke-virtual {p1}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 198
    return-void
.end method

.method public setCor(Ljava/lang/String;)V
    .locals 2
    .param p1, "cor"    # Ljava/lang/String;

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.cor"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    return-void
.end method

.method public setCredentialsMap(Ljava/util/Map;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 117
    .local p1, "credentialsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/CredentialMapSerializer;->toJSONString(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    .line 118
    .local v0, "serializedCredentials":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 120
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.credentialsmap"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    :cond_0
    return-void
.end method

.method public setCustomerRegion(Ljava/lang/String;)V
    .locals 2
    .param p1, "customerRegion"    # Ljava/lang/String;

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.customer_region"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    return-void
.end method

.method public setDeviceEmail(Ljava/lang/String;)V
    .locals 2
    .param p1, "deviceEmail"    # Ljava/lang/String;

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.deviceemail"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    return-void
.end method

.method public setDeviceName(Ljava/lang/String;)V
    .locals 2
    .param p1, "deviceName"    # Ljava/lang/String;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.devicename"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    return-void
.end method

.method public setDeviceSerialNumber(Ljava/lang/String;)V
    .locals 2
    .param p1, "serialNumber"    # Ljava/lang/String;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.deviceserialname"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    return-void
.end method

.method public setDeviceType(Ljava/lang/String;)V
    .locals 2
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.devicedevicetype"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    return-void
.end method

.method public setDirectedId(Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    return-void
.end method

.method public setEmail(Ljava/lang/String;)V
    .locals 2
    .param p1, "email"    # Ljava/lang/String;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.useremail"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    return-void
.end method

.method public setExtras(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    invoke-virtual {v0, p1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    return-void
.end method

.method public setPfm(Ljava/lang/String;)V
    .locals 2
    .param p1, "pfm"    # Ljava/lang/String;

    .prologue
    .line 102
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.pfm"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    return-void
.end method

.method public setPrivateKey(Ljava/lang/String;)V
    .locals 2
    .param p1, "privateKey"    # Ljava/lang/String;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    return-void
.end method

.method public setRefreshToken(Ljava/lang/String;)V
    .locals 2
    .param p1, "refreshToken"    # Ljava/lang/String;

    .prologue
    .line 213
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    return-void
.end method

.method public setSourceOfCor(Ljava/lang/String;)V
    .locals 2
    .param p1, "sourceOfCor"    # Ljava/lang/String;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.sourceofcor"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    return-void
.end method

.method public setUserName(Ljava/lang/String;)V
    .locals 2
    .param p1, "userName"    # Ljava/lang/String;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.username"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    return-void
.end method

.method public setXMainAndXAcbCookies(Ljava/lang/String;)V
    .locals 2
    .param p1, "xmainAndXacbCookies"    # Ljava/lang/String;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    return-void
.end method

.method public setXMainToken(Ljava/lang/String;)V
    .locals 2
    .param p1, "xmainToken"    # Ljava/lang/String;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.cookie.xmain"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    return-void
.end method

.method public setXfsnCookie(Ljava/lang/String;)V
    .locals 2
    .param p1, "xfsnCookie"    # Ljava/lang/String;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.identity.cookies.xfsn"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    return-void
.end method

.method public throwIfNotValid()V
    .locals 2

    .prologue
    .line 149
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.username"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 151
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "UserData is invalid because User Name has not been set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 154
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.devicename"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 156
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "UserData is invalid because Device Name has not been set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 159
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 161
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "UserData is invalid because ADP Token has not been set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 164
    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 166
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "UserData is invalid because private key has not been set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 169
    :cond_3
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.deviceserialname"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 171
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "UserData is invalid because the serial number has not been set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 174
    :cond_4
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->mUserData:Landroid/os/Bundle;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.devicedevicetype"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 176
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "UserData is invalid because the device type has not been set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 178
    :cond_5
    return-void
.end method
