.class public Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;
.super Ljava/lang/Object;
.source "OpenIdResponse.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse$Tags;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mParams:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mRedirectUrl:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "redirectUrl"    # Ljava/lang/String;

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    .line 59
    iput-object p1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mRedirectUrl:Ljava/lang/String;

    .line 60
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->parseRedirectUrl(Ljava/lang/String;)V

    .line 61
    return-void
.end method

.method private parseRedirectUrl(Ljava/lang/String;)V
    .locals 11
    .param p1, "redirectUrl"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x1

    .line 140
    :try_start_0
    new-instance v6, Ljava/net/URL;

    invoke-direct {v6, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 150
    .local v6, "url":Ljava/net/URL;
    invoke-virtual {v6}, Ljava/net/URL;->getQuery()Ljava/lang/String;

    move-result-object v5

    .line 152
    .local v5, "queryString":Ljava/lang/String;
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 168
    :cond_0
    return-void

    .line 146
    .end local v5    # "queryString":Ljava/lang/String;
    .end local v6    # "url":Ljava/net/URL;
    :catch_0
    move-exception v1

    .line 148
    .local v1, "e":Ljava/net/MalformedURLException;
    new-instance v7, Ljava/lang/RuntimeException;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string/jumbo v9, "Exception parsing Open ID redirect URL: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v7

    .line 156
    .end local v1    # "e":Ljava/net/MalformedURLException;
    .restart local v5    # "queryString":Ljava/lang/String;
    .restart local v6    # "url":Ljava/net/URL;
    :cond_1
    const-string/jumbo v7, "&"

    invoke-virtual {v5, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 158
    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v7, v0, v2

    .line 160
    const-string/jumbo v8, "="

    invoke-virtual {v7, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 162
    .local v3, "keyAndValue":[Ljava/lang/String;
    array-length v7, v3

    if-le v7, v10, :cond_2

    .line 165
    iget-object v7, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const/4 v8, 0x0

    aget-object v8, v3, v8

    aget-object v9, v3, v10

    invoke-static {v9}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-interface {v7, v8, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 158
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getAccessToken()Lcom/amazon/identity/auth/device/token/AccessToken;
    .locals 3

    .prologue
    .line 105
    const-string/jumbo v1, "device_auth_access"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getScope()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 107
    sget-object v1, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->LOG_TAG:Ljava/lang/String;

    .line 108
    const/4 v0, 0x0

    .line 110
    .local v0, "accessToken":Lcom/amazon/identity/auth/device/token/AccessToken;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.oa2.access_token"

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 112
    new-instance v0, Lcom/amazon/identity/auth/device/token/AccessToken;

    .end local v0    # "accessToken":Lcom/amazon/identity/auth/device/token/AccessToken;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.oa2.access_token"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/token/AccessToken;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    :cond_0
    :goto_0
    return-object v0

    .line 114
    .restart local v0    # "accessToken":Lcom/amazon/identity/auth/device/token/AccessToken;
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.oa2.refresh_token"

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 116
    new-instance v0, Lcom/amazon/identity/auth/device/token/AccessToken;

    .end local v0    # "accessToken":Lcom/amazon/identity/auth/device/token/AccessToken;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.oa2.refresh_token"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/token/AccessToken;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .restart local v0    # "accessToken":Lcom/amazon/identity/auth/device/token/AccessToken;
    goto :goto_0

    .line 121
    .end local v0    # "accessToken":Lcom/amazon/identity/auth/device/token/AccessToken;
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getDirectedId()Ljava/lang/String;
    .locals 3

    .prologue
    .line 187
    const/4 v0, 0x0

    .line 188
    .local v0, "directedId":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.identity"

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 190
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.identity"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const-string/jumbo v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 192
    :cond_0
    return-object v0
.end method

.method public getIdentity()Ljava/lang/String;
    .locals 2

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "openid.identity"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getRefreshToken()Lcom/amazon/identity/auth/device/token/RefreshToken;
    .locals 3

    .prologue
    .line 84
    const-string/jumbo v0, "device_auth_refresh"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getScope()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 86
    sget-object v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->LOG_TAG:Ljava/lang/String;

    .line 88
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "openid.oa2.refresh_token"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 90
    new-instance v1, Lcom/amazon/identity/auth/device/token/RefreshToken;

    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.oa2.refresh_token"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/amazon/identity/auth/device/token/RefreshToken;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    .line 97
    :goto_0
    return-object v0

    .line 92
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "openid.oa2.access_token"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 94
    new-instance v1, Lcom/amazon/identity/auth/device/token/RefreshToken;

    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.oa2.access_token"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/amazon/identity/auth/device/token/RefreshToken;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    goto :goto_0

    .line 97
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getScope()Ljava/lang/String;
    .locals 3

    .prologue
    .line 126
    const-string/jumbo v0, "device_auth_refresh"

    .line 127
    .local v0, "scope":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.oa2.scope"

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 129
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.oa2.scope"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "scope":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 131
    .restart local v0    # "scope":Ljava/lang/String;
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Token Scope = "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 132
    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 2

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "aToken"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public isCancelEvent(Ljava/lang/String;)Z
    .locals 4
    .param p1, "expectedUrl"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 210
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mRedirectUrl:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 218
    :cond_0
    :goto_0
    return v1

    .line 215
    :cond_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mRedirectUrl:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 217
    .local v0, "url":Ljava/lang/String;
    invoke-static {p1, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public isNewAccount()Ljava/lang/Boolean;
    .locals 3

    .prologue
    .line 175
    const-string/jumbo v1, "1"

    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "new_account"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 177
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 179
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method
