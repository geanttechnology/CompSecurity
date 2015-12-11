.class public Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseJsonParser;
.super Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;
.source "PandaAuthenticateAccountResponseJsonParser.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;",
        ">;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseJsonParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseJsonParser;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;-><init>()V

    return-void
.end method


# virtual methods
.method protected handlePandaChallengeResponse(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;)Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;
    .locals 3
    .param p1, "challenge"    # Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 49
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " handling panda challenge response."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->getReason()Ljava/lang/String;

    move-result-object v0

    .line 51
    .local v0, "challengeReason":Ljava/lang/String;
    const-string/jumbo v1, "AuthenticationFailed"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "InvalidAuthenticationData"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 57
    :cond_0
    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorCredentialError:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    invoke-direct {v1, v2}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;-><init>(Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;)V

    .line 61
    :goto_0
    return-object v1

    :cond_1
    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;

    invoke-direct {v1, p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;-><init>(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;)V

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
    .line 14
    invoke-virtual {p0, p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseJsonParser;->handlePandaChallengeResponse(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;)Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;

    move-result-object v0

    return-object v0
.end method

.method protected handlePandaErrorCode(Lcom/amazon/identity/kcpsdk/auth/PandaError;)Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;
    .locals 1
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .prologue
    .line 33
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;

    invoke-direct {v0, p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;-><init>(Lcom/amazon/identity/kcpsdk/auth/PandaError;)V

    return-object v0
.end method

.method protected bridge synthetic handlePandaErrorCode(Lcom/amazon/identity/kcpsdk/auth/PandaError;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/amazon/identity/kcpsdk/auth/PandaError;

    .prologue
    .line 14
    invoke-virtual {p0, p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseJsonParser;->handlePandaErrorCode(Lcom/amazon/identity/kcpsdk/auth/PandaError;)Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;

    move-result-object v0

    return-object v0
.end method

.method protected parsePandaSuccessResponse(Lorg/json/JSONObject;)Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;
    .locals 4
    .param p1, "success"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 23
    const-string/jumbo v2, "tokens"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 24
    const-string/jumbo v3, "bearer"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 25
    const-string/jumbo v3, "access_token"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 26
    .local v0, "accessToken":Ljava/lang/String;
    const-string/jumbo v2, "customer_id"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 27
    .local v1, "directedId":Ljava/lang/String;
    new-instance v2, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;

    invoke-direct {v2, v1, v0}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v2
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
    .line 14
    invoke-virtual {p0, p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseJsonParser;->parsePandaSuccessResponse(Lorg/json/JSONObject;)Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;

    move-result-object v0

    return-object v0
.end method

.method protected parseSpecificPandaErrorResponse(Lorg/json/JSONObject;)Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;
    .locals 5
    .param p1, "error"    # Lorg/json/JSONObject;

    .prologue
    .line 39
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseJsonParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, " PandaAuthenticateResponseParser: response received an unknown error: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 42
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->AuthenticateAccountErrorUnknown:Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    invoke-direct {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;-><init>(Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;)V

    return-object v0
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
    .line 14
    invoke-virtual {p0, p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseJsonParser;->parseSpecificPandaErrorResponse(Lorg/json/JSONObject;)Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;

    move-result-object v0

    return-object v0
.end method
