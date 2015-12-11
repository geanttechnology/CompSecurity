.class public Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
.super Ljava/lang/Object;
.source "PandaTokenExchangeRequestBuilder.java"


# static fields
.field public static final TAG:Ljava/lang/String;


# instance fields
.field private mAccessToken:Ljava/lang/String;

.field private mAppName:Ljava/lang/String;

.field private mAppVersion:Ljava/lang/String;

.field private mCookieDomain:Ljava/lang/String;

.field private mExistingCookies:Ljava/util/Map;
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

.field private mHwVersion:Ljava/lang/String;

.field private mOsName:Ljava/lang/String;

.field private mOsVersion:Ljava/lang/String;

.field private mSdkVersion:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mExistingCookies:Ljava/util/Map;

    .line 24
    const-string/jumbo v0, "defaultOS"

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mOsName:Ljava/lang/String;

    .line 25
    const-string/jumbo v0, "defaultHwVersion"

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mHwVersion:Ljava/lang/String;

    .line 26
    const-string/jumbo v0, "defaultOsVersion"

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mOsVersion:Ljava/lang/String;

    .line 27
    const-string/jumbo v0, "defaultSDKVersion"

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mSdkVersion:Ljava/lang/String;

    .line 28
    const-string/jumbo v0, "defaultAppName"

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mAppName:Ljava/lang/String;

    .line 29
    const-string/jumbo v0, "defaultAppVersion"

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mAppVersion:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public addExistingCookie(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mExistingCookies:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    return-object p0
.end method

.method public build()Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequest;
    .locals 17

    .prologue
    .line 105
    new-instance v14, Ljava/util/LinkedList;

    invoke-direct {v14}, Ljava/util/LinkedList;-><init>()V

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mAccessToken:Ljava/lang/String;

    invoke-static {v15}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v15

    if-eqz v15, :cond_0

    const-string/jumbo v15, "AccessToken"

    invoke-interface {v14, v15}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mCookieDomain:Ljava/lang/String;

    invoke-static {v15}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v15

    if-eqz v15, :cond_1

    const-string/jumbo v15, "CookieDomain"

    invoke-interface {v14, v15}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_1
    invoke-interface {v14}, Ljava/util/List;->isEmpty()Z

    move-result v15

    if-nez v15, :cond_2

    new-instance v15, Ljava/lang/StringBuilder;

    const-string/jumbo v16, "Missing arguments for Panda: "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string/jumbo v16, ","

    move-object/from16 v0, v16

    invoke-static {v0, v14}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v15, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    sget-object v15, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->TAG:Ljava/lang/String;

    invoke-static {v15, v14}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v14, 0x0

    :goto_0
    if-nez v14, :cond_3

    .line 107
    const/4 v14, 0x0

    .line 166
    :goto_1
    return-object v14

    .line 105
    :cond_2
    const/4 v14, 0x1

    goto :goto_0

    .line 112
    :cond_3
    :try_start_0
    new-instance v9, Lorg/json/JSONObject;

    invoke-direct {v9}, Lorg/json/JSONObject;-><init>()V

    .line 115
    .local v9, "request":Lorg/json/JSONObject;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 116
    .local v1, "bearerSource":Lorg/json/JSONObject;
    const-string/jumbo v14, "access_token"

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mAccessToken:Ljava/lang/String;

    invoke-virtual {v1, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 118
    new-instance v11, Lorg/json/JSONObject;

    invoke-direct {v11}, Lorg/json/JSONObject;-><init>()V

    .line 119
    .local v11, "sourceTokens":Lorg/json/JSONObject;
    const-string/jumbo v14, "bearer"

    invoke-virtual {v11, v14, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 122
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 123
    .local v2, "bearerToken":Lorg/json/JSONObject;
    const-string/jumbo v14, "token_type"

    const-string/jumbo v15, "bearer"

    invoke-virtual {v2, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 125
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    .line 126
    .local v4, "cookiesArray":Lorg/json/JSONArray;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mExistingCookies:Ljava/util/Map;

    invoke-interface {v14}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v14

    invoke-interface {v14}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_4

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map$Entry;

    .line 128
    .local v6, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 129
    .local v3, "cookie":Lorg/json/JSONObject;
    const-string/jumbo v14, "Name"

    invoke-interface {v6}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v15

    invoke-virtual {v3, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 130
    const-string/jumbo v14, "Value"

    invoke-interface {v6}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v15

    invoke-virtual {v3, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 131
    invoke-virtual {v4, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 162
    .end local v1    # "bearerSource":Lorg/json/JSONObject;
    .end local v2    # "bearerToken":Lorg/json/JSONObject;
    .end local v3    # "cookie":Lorg/json/JSONObject;
    .end local v4    # "cookiesArray":Lorg/json/JSONArray;
    .end local v6    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v9    # "request":Lorg/json/JSONObject;
    .end local v11    # "sourceTokens":Lorg/json/JSONObject;
    :catch_0
    move-exception v7

    .line 164
    .local v7, "ex":Lorg/json/JSONException;
    sget-object v14, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string/jumbo v16, "Error creating JSON request: "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    const/4 v14, 0x0

    goto/16 :goto_1

    .line 134
    .end local v7    # "ex":Lorg/json/JSONException;
    .restart local v1    # "bearerSource":Lorg/json/JSONObject;
    .restart local v2    # "bearerToken":Lorg/json/JSONObject;
    .restart local v4    # "cookiesArray":Lorg/json/JSONArray;
    .restart local v8    # "i$":Ljava/util/Iterator;
    .restart local v9    # "request":Lorg/json/JSONObject;
    .restart local v11    # "sourceTokens":Lorg/json/JSONObject;
    :cond_4
    :try_start_1
    new-instance v13, Lorg/json/JSONObject;

    invoke-direct {v13}, Lorg/json/JSONObject;-><init>()V

    .line 135
    .local v13, "websiteCookiesObject":Lorg/json/JSONObject;
    const-string/jumbo v14, "domain"

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mCookieDomain:Ljava/lang/String;

    invoke-virtual {v13, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 136
    const-string/jumbo v14, "existing_cookies"

    invoke-virtual {v13, v14, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 138
    new-instance v12, Lorg/json/JSONArray;

    invoke-direct {v12}, Lorg/json/JSONArray;-><init>()V

    .line 139
    .local v12, "websiteCookiesArray":Lorg/json/JSONArray;
    invoke-virtual {v12, v13}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 141
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5}, Lorg/json/JSONObject;-><init>()V

    .line 142
    .local v5, "cookiesToken":Lorg/json/JSONObject;
    const-string/jumbo v14, "token_type"

    const-string/jumbo v15, "website_cookies"

    invoke-virtual {v5, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 143
    const-string/jumbo v14, "website_cookies"

    invoke-virtual {v5, v14, v12}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 145
    new-instance v10, Lorg/json/JSONArray;

    invoke-direct {v10}, Lorg/json/JSONArray;-><init>()V

    .line 146
    .local v10, "requestedTokensArray":Lorg/json/JSONArray;
    invoke-virtual {v10, v2}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 147
    invoke-virtual {v10, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 150
    const-string/jumbo v14, "source_tokens"

    invoke-virtual {v9, v14, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 151
    const-string/jumbo v14, "requested_token_types"

    invoke-virtual {v9, v14, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 153
    const-string/jumbo v14, "device_os_name"

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mOsName:Ljava/lang/String;

    invoke-virtual {v9, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 154
    const-string/jumbo v14, "device_hw_version"

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mHwVersion:Ljava/lang/String;

    invoke-virtual {v9, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 155
    const-string/jumbo v14, "device_os_version"

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mOsVersion:Ljava/lang/String;

    invoke-virtual {v9, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 156
    const-string/jumbo v14, "device_sdk_version"

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mSdkVersion:Ljava/lang/String;

    invoke-virtual {v9, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 157
    const-string/jumbo v14, "app_name"

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mAppName:Ljava/lang/String;

    invoke-virtual {v9, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 158
    const-string/jumbo v14, "app_version"

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mAppVersion:Ljava/lang/String;

    invoke-virtual {v9, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 160
    new-instance v14, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequest;

    invoke-direct {v14, v9}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequest;-><init>(Lorg/json/JSONObject;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1
.end method

.method public setAccessToken(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
    .locals 0
    .param p1, "accessToken"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mAccessToken:Ljava/lang/String;

    .line 34
    return-object p0
.end method

.method public setAppName(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
    .locals 1
    .param p1, "appName"    # Ljava/lang/String;

    .prologue
    .line 87
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 89
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mAppName:Ljava/lang/String;

    .line 91
    :cond_0
    return-object p0
.end method

.method public setAppVersion(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
    .locals 1
    .param p1, "appVersion"    # Ljava/lang/String;

    .prologue
    .line 96
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 98
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mAppVersion:Ljava/lang/String;

    .line 100
    :cond_0
    return-object p0
.end method

.method public setCookieDomain(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
    .locals 0
    .param p1, "cookieDomain"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mCookieDomain:Ljava/lang/String;

    .line 40
    return-object p0
.end method

.method public setHwVersion(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
    .locals 1
    .param p1, "hwVersion"    # Ljava/lang/String;

    .prologue
    .line 60
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 62
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mHwVersion:Ljava/lang/String;

    .line 64
    :cond_0
    return-object p0
.end method

.method public setOsName(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
    .locals 1
    .param p1, "osName"    # Ljava/lang/String;

    .prologue
    .line 51
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 53
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mOsName:Ljava/lang/String;

    .line 55
    :cond_0
    return-object p0
.end method

.method public setOsVersion(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
    .locals 1
    .param p1, "osVersion"    # Ljava/lang/String;

    .prologue
    .line 69
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 71
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mOsVersion:Ljava/lang/String;

    .line 73
    :cond_0
    return-object p0
.end method

.method public setSDKVersion(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
    .locals 1
    .param p1, "sdkVersion"    # Ljava/lang/String;

    .prologue
    .line 78
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 80
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->mSdkVersion:Ljava/lang/String;

    .line 82
    :cond_0
    return-object p0
.end method
