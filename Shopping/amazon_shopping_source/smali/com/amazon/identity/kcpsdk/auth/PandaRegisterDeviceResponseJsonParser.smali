.class public Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;
.super Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;
.source "PandaRegisterDeviceResponseJsonParser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser$1;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;",
        ">;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mAccessToken:Ljava/lang/String;

.field private mAccessTokenExpiresIn:I

.field private mAccountPool:Ljava/lang/String;

.field private mAdpToken:Ljava/lang/String;

.field private mAlias:Ljava/lang/String;

.field private mCookies:Lorg/json/JSONArray;

.field private mCountryOfResidence:Ljava/lang/String;

.field private mCustomerRegion:Ljava/lang/String;

.field private mDdevicePrivateKey:Ljava/lang/String;

.field private mDeviceName:Ljava/lang/String;

.field private mDeviceType:Ljava/lang/String;

.field private mDirectedId:Ljava/lang/String;

.field private mDviceSerialNumber:Ljava/lang/String;

.field private mGivenName:Ljava/lang/String;

.field private mKindleEmailAddress:Ljava/lang/String;

.field private mName:Ljava/lang/String;

.field private mPreferredMarketplace:Ljava/lang/String;

.field private mRefreshToken:Ljava/lang/String;

.field private mSourceOfcountryOfResidence:Ljava/lang/String;

.field private mStoreAuthenticationCookie:Ljava/lang/String;

.field private mUserId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 91
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;-><init>()V

    .line 92
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mCookies:Lorg/json/JSONArray;

    .line 93
    return-void
.end method

.method private errorTypeToResponse(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .locals 8
    .param p1, "errorType"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .prologue
    const/4 v1, 0x0

    .line 302
    new-instance v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    invoke-direct {v7, p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;-><init>(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V

    .line 304
    .local v7, "registerError":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    const/4 v4, 0x0

    move-object v2, v1

    move-object v3, v1

    move-object v5, v1

    move-object v6, v1

    invoke-direct/range {v0 .. v7}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    return-object v0
.end method


# virtual methods
.method protected handlePandaChallengeResponse(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .locals 6
    .param p1, "challenge"    # Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 363
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->getReason()Ljava/lang/String;

    move-result-object v0

    .line 364
    .local v0, "challengeReason":Ljava/lang/String;
    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v3, " PandaResponseJsonParser: response received a %s challenge."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 365
    const-string/jumbo v2, "AuthenticationFailed"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string/jumbo v2, "InvalidAuthenticationData"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 371
    :cond_0
    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeCustomerNotFound:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    invoke-direct {p0, v2}, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->errorTypeToResponse(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v2

    .line 377
    :goto_0
    return-object v2

    .line 375
    :cond_1
    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeChallengeResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    invoke-direct {v1, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;-><init>(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V

    .line 377
    .local v1, "registerError":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;
    new-instance v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    invoke-direct {v2, p1, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    goto :goto_0
.end method

.method protected bridge synthetic handlePandaChallengeResponse(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 16
    invoke-virtual {p0, p1}, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->handlePandaChallengeResponse(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v0

    return-object v0
.end method

.method protected handlePandaErrorCode(Lcom/amazon/identity/kcpsdk/auth/PandaError;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .locals 3
    .param p1, "pandaError"    # Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .prologue
    .line 266
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser$1;->$SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError:[I

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/PandaError;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 286
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognizedPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 289
    .local v0, "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    :goto_0
    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->errorTypeToResponse(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v1

    return-object v1

    .line 270
    .end local v0    # "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    :pswitch_0
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeMissingValue:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 271
    .restart local v0    # "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    goto :goto_0

    .line 273
    .end local v0    # "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    :pswitch_1
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeCustomerNotFound:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 274
    .restart local v0    # "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    goto :goto_0

    .line 276
    .end local v0    # "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    :pswitch_2
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidValue:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 277
    .restart local v0    # "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    goto :goto_0

    .line 279
    .end local v0    # "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    :pswitch_3
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeServerError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 280
    .restart local v0    # "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    goto :goto_0

    .line 282
    .end local v0    # "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    :pswitch_4
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeServerUnavailable:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 283
    .restart local v0    # "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    goto :goto_0

    .line 266
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method protected bridge synthetic handlePandaErrorCode(Lcom/amazon/identity/kcpsdk/auth/PandaError;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .prologue
    .line 16
    invoke-virtual {p0, p1}, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->handlePandaErrorCode(Lcom/amazon/identity/kcpsdk/auth/PandaError;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v0

    return-object v0
.end method

.method protected parsePandaSuccessResponse(Lorg/json/JSONObject;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .locals 13
    .param p1, "successJson"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 99
    const-string/jumbo v1, "tokens"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 101
    const-string/jumbo v1, "tokens"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v12

    .line 102
    .local v12, "tokens":Lorg/json/JSONObject;
    const-string/jumbo v1, "bearer"

    invoke-virtual {v12, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 104
    const-string/jumbo v1, "bearer"

    invoke-virtual {v12, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    .line 105
    .local v8, "bearerTokens":Lorg/json/JSONObject;
    const-string/jumbo v1, "refresh_token"

    invoke-virtual {v8, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mRefreshToken:Ljava/lang/String;

    .line 106
    const-string/jumbo v1, "access_token"

    invoke-virtual {v8, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mAccessToken:Ljava/lang/String;

    .line 107
    const-string/jumbo v1, "expires_in"

    invoke-virtual {v8, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mAccessTokenExpiresIn:I

    .line 109
    .end local v8    # "bearerTokens":Lorg/json/JSONObject;
    :cond_0
    const-string/jumbo v1, "mac_dms"

    invoke-virtual {v12, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 111
    const-string/jumbo v1, "mac_dms"

    invoke-virtual {v12, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v10

    .line 112
    .local v10, "macTokens":Lorg/json/JSONObject;
    const-string/jumbo v1, "adp_token"

    invoke-virtual {v10, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mAdpToken:Ljava/lang/String;

    .line 113
    const-string/jumbo v1, "device_private_key"

    invoke-virtual {v10, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mDdevicePrivateKey:Ljava/lang/String;

    .line 115
    .end local v10    # "macTokens":Lorg/json/JSONObject;
    :cond_1
    const-string/jumbo v1, "store_authentication_cookie"

    invoke-virtual {v12, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 117
    const-string/jumbo v1, "store_authentication_cookie"

    invoke-virtual {v12, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    .line 118
    .local v11, "storeAuthCookieToken":Lorg/json/JSONObject;
    const-string/jumbo v1, "cookie"

    invoke-virtual {v11, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mStoreAuthenticationCookie:Ljava/lang/String;

    .line 120
    .end local v11    # "storeAuthCookieToken":Lorg/json/JSONObject;
    :cond_2
    const-string/jumbo v1, "website_cookies"

    invoke-virtual {v12, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 122
    const-string/jumbo v1, "website_cookies"

    invoke-virtual {v12, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mCookies:Lorg/json/JSONArray;

    .line 125
    .end local v12    # "tokens":Lorg/json/JSONObject;
    :cond_3
    const-string/jumbo v1, "extensions"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_13

    .line 127
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognizedPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    invoke-direct {p0, v1}, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->errorTypeToResponse(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v9

    const-string/jumbo v1, "extensions"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string/jumbo v2, "customer_info"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_10

    const-string/jumbo v2, "customer_info"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string/jumbo v3, "account_pool"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_d

    const-string/jumbo v3, "account_pool"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mAccountPool:Ljava/lang/String;

    const-string/jumbo v3, "country_of_residence"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    const-string/jumbo v3, "country_of_residence"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mCountryOfResidence:Ljava/lang/String;

    :cond_4
    const-string/jumbo v3, "source_of_country_of_residence"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    const-string/jumbo v3, "source_of_country_of_residence"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mSourceOfcountryOfResidence:Ljava/lang/String;

    :cond_5
    const-string/jumbo v3, "home_region"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_6

    const-string/jumbo v3, "home_region"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mCustomerRegion:Ljava/lang/String;

    :cond_6
    const-string/jumbo v3, "name"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_e

    const-string/jumbo v3, "name"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mName:Ljava/lang/String;

    const-string/jumbo v3, "preferred_marketplace"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7

    const-string/jumbo v3, "preferred_marketplace"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mPreferredMarketplace:Ljava/lang/String;

    :cond_7
    const-string/jumbo v3, "user_id"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_8

    const-string/jumbo v3, "user_id"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mUserId:Ljava/lang/String;

    :cond_8
    const-string/jumbo v3, "given_name"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_f

    const-string/jumbo v3, "given_name"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mGivenName:Ljava/lang/String;

    const-string/jumbo v2, "device_info"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_12

    const-string/jumbo v2, "device_info"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string/jumbo v2, "device_name"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_11

    const-string/jumbo v2, "device_name"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mDeviceName:Ljava/lang/String;

    const-string/jumbo v2, "device_serial_number"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_9

    const-string/jumbo v2, "device_serial_number"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mDviceSerialNumber:Ljava/lang/String;

    :cond_9
    const-string/jumbo v2, "alias"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_a

    const-string/jumbo v2, "alias"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mAlias:Ljava/lang/String;

    :cond_a
    const-string/jumbo v2, "device_type"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_b

    const-string/jumbo v2, "device_type"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mDeviceType:Ljava/lang/String;

    :cond_b
    const-string/jumbo v2, "kindle_email_address"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_c

    const-string/jumbo v2, "kindle_email_address"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mKindleEmailAddress:Ljava/lang/String;

    :cond_c
    move-object v9, v7

    .line 128
    .local v9, "errorResponse":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    :goto_0
    if-eqz v9, :cond_13

    .line 153
    .end local v9    # "errorResponse":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    :goto_1
    return-object v9

    .line 127
    :cond_d
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " PandaResponseJsonParser: account pool is missing"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_e
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " PandaResponseJsonParser: name is missing"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_f
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " PandaResponseJsonParser: given name is missing"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_10
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " PandaResponseJsonParser: customer info is missing"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_11
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " PandaResponseJsonParser: device name is missing"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_12
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " PandaResponseJsonParser: device info is missing"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 133
    :cond_13
    const-string/jumbo v1, "customer_id"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mDirectedId:Ljava/lang/String;

    .line 134
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " PandaResponseJsonParser: success response received"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mAdpToken:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mRefreshToken:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mAccessToken:Ljava/lang/String;

    iget v4, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mAccessTokenExpiresIn:I

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mDdevicePrivateKey:Ljava/lang/String;

    iget-object v6, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mDirectedId:Ljava/lang/String;

    invoke-direct/range {v0 .. v7}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    .line 143
    .local v0, "response":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mCookies:Lorg/json/JSONArray;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setPandaCookies(Lorg/json/JSONArray;)V

    .line 144
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mStoreAuthenticationCookie:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setStoreAuthenticationCookie(Ljava/lang/String;)V

    .line 145
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mCustomerRegion:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setCustomerRegion(Ljava/lang/String;)V

    .line 146
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mAccountPool:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setAccountPool(Ljava/lang/String;)V

    .line 147
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mCountryOfResidence:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setCor(Ljava/lang/String;)V

    .line 148
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mSourceOfcountryOfResidence:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setSourceOfCor(Ljava/lang/String;)V

    .line 149
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mPreferredMarketplace:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setPfm(Ljava/lang/String;)V

    .line 150
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setUserName(Ljava/lang/String;)V

    .line 151
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mDeviceName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setDeviceName(Ljava/lang/String;)V

    .line 152
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->mKindleEmailAddress:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setEmail(Ljava/lang/String;)V

    move-object v9, v0

    .line 153
    goto/16 :goto_1
.end method

.method protected bridge synthetic parsePandaSuccessResponse(Lorg/json/JSONObject;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 16
    invoke-virtual {p0, p1}, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->parsePandaSuccessResponse(Lorg/json/JSONObject;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v0

    return-object v0
.end method

.method protected parseSpecificPandaErrorResponse(Lorg/json/JSONObject;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .locals 6
    .param p1, "errorJson"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 295
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " PandaResponseJsonParser: response received a %s error."

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 296
    const-string/jumbo v1, "code"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_9

    const-string/jumbo v2, "ProtocolError"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeProtocolError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 297
    .local v0, "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    :goto_0
    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->errorTypeToResponse(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v1

    return-object v1

    .line 296
    .end local v0    # "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    :cond_0
    const-string/jumbo v2, "MethodNotAllowed"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeMethodNotAllowed:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :cond_1
    const-string/jumbo v2, "NotImplemented"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeNotImplemented:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :cond_2
    const-string/jumbo v2, "InvalidDirectedId"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidDirectedId:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :cond_3
    const-string/jumbo v2, "InvalidDevice"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidDevice:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :cond_4
    const-string/jumbo v2, "DeviceAlreadyRegistered"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :cond_5
    const-string/jumbo v2, "DuplicateDeviceName"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDuplicateDeviceName:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :cond_6
    const-string/jumbo v2, "InvalidToken"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidTokenPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :cond_7
    const-string/jumbo v2, "DeviceNotRegistered"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDeviceNotRegisteredPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :cond_8
    const-string/jumbo v2, "Unauthorized"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnauthorizedPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :cond_9
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognizedPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0
.end method

.method protected bridge synthetic parseSpecificPandaErrorResponse(Lorg/json/JSONObject;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 16
    invoke-virtual {p0, p1}, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;->parseSpecificPandaErrorResponse(Lorg/json/JSONObject;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v0

    return-object v0
.end method
