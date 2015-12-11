.class public abstract Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;
.super Ljava/lang/Object;
.source "PandaResponseJsonParser.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field protected static final ACCESS_TOKEN_KEY:Ljava/lang/String; = "access_token"

.field protected static final BEARER_KEY:Ljava/lang/String; = "bearer"

.field protected static final CHALLENGE_REASON_AUTHENTICATION_FAILED:Ljava/lang/String; = "AuthenticationFailed"

.field protected static final CHALLENGE_REASON_INVALID_AUTHENTICATION_DATA:Ljava/lang/String; = "InvalidAuthenticationData"

.field protected static final CREDENTIAL_INVALID_ERROR_CODE:Ljava/lang/String; = "CredentialError"

.field protected static final CUSTOMER_ID_KEY:Ljava/lang/String; = "customer_id"

.field protected static final ERROR_CODE_KEY:Ljava/lang/String; = "code"

.field protected static final INVALID_VALUE_ERROR_CODE:Ljava/lang/String; = "InvalidValue"

.field protected static final MISSING_VALUE_ERROR_CODE:Ljava/lang/String; = "MissingValue"

.field protected static final SERVER_ERROR_ERROR_CODE:Ljava/lang/String; = "ServerError"

.field protected static final SERVICE_UNAVAILABLE_ERROR_CODE:Ljava/lang/String; = "ServiceUnavailable"

.field private static final TAG:Ljava/lang/String;

.field protected static final TOKENS_KEY:Ljava/lang/String; = "tokens"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;, "Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract handlePandaChallengeResponse(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation
.end method

.method protected abstract handlePandaErrorCode(Lcom/amazon/identity/kcpsdk/auth/PandaError;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/kcpsdk/auth/PandaError;",
            ")TT;"
        }
    .end annotation
.end method

.method public parse(Lorg/json/JSONObject;)Ljava/lang/Object;
    .locals 10
    .param p1, "json"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            ")TT;"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;, "Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser<TT;>;"
    const/4 v2, 0x0

    .line 48
    :try_start_0
    const-string/jumbo v3, "response"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 50
    .local v1, "response":Lorg/json/JSONObject;
    const-string/jumbo v3, "success"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 52
    const-string/jumbo v3, "success"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;->parsePandaSuccessResponse(Lorg/json/JSONObject;)Ljava/lang/Object;

    move-result-object v2

    .line 71
    .end local v1    # "response":Lorg/json/JSONObject;
    :goto_0
    return-object v2

    .line 54
    .restart local v1    # "response":Lorg/json/JSONObject;
    :cond_0
    const-string/jumbo v3, "error"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 56
    const-string/jumbo v3, "error"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string/jumbo v3, "request_id"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v3, "code"

    invoke-virtual {v4, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v6, "MissingValue"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorMissingValue:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    :goto_1
    if-nez v3, :cond_6

    invoke-virtual {p0, v4}, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;->parseSpecificPandaErrorResponse(Lorg/json/JSONObject;)Ljava/lang/Object;

    move-result-object v2

    goto :goto_0

    :cond_1
    const-string/jumbo v6, "InvalidValue"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorInvalidValue:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    goto :goto_1

    :cond_2
    const-string/jumbo v6, "CredentialError"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorCredentialError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    goto :goto_1

    :cond_3
    const-string/jumbo v6, "ServerError"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorServerError:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    goto :goto_1

    :cond_4
    const-string/jumbo v6, "ServiceUnavailable"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/PandaError;->PandaErrorServiceUnavailable:Lcom/amazon/identity/kcpsdk/auth/PandaError;

    goto :goto_1

    :cond_5
    move-object v3, v2

    goto :goto_1

    :cond_6
    sget-object v6, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Panda Error:  %s. Request ID: %s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v4}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v8, v9

    const/4 v4, 0x1

    aput-object v5, v8, v4

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v6, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v3}, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;->handlePandaErrorCode(Lcom/amazon/identity/kcpsdk/auth/PandaError;)Ljava/lang/Object;

    move-result-object v2

    goto :goto_0

    .line 58
    :cond_7
    const-string/jumbo v3, "challenge"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 60
    const-string/jumbo v3, "challenge"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->fromPandaChallengeBody(Lorg/json/JSONObject;)Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;->handlePandaChallengeResponse(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;)Ljava/lang/Object;

    move-result-object v2

    goto/16 :goto_0

    .line 64
    :cond_8
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v4, " Panda Response is not correctly formatted."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 67
    .end local v1    # "response":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 69
    .local v0, "e":Lorg/json/JSONException;
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v4, " Panda Response is not correctly formatted."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method protected abstract parsePandaSuccessResponse(Lorg/json/JSONObject;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation
.end method

.method protected abstract parseSpecificPandaErrorResponse(Lorg/json/JSONObject;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation
.end method
