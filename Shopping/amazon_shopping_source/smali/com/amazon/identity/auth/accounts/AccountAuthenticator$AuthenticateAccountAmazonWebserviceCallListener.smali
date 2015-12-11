.class Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;
.super Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;
.source "AccountAuthenticator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AccountAuthenticator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AuthenticateAccountAmazonWebserviceCallListener"
.end annotation


# instance fields
.field protected final mCallback:Lcom/amazon/identity/auth/device/api/Callback;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 200
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;-><init>()V

    .line 201
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    .line 202
    return-void
.end method

.method private bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 3
    .param p1, "error"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 293
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 294
    .local v0, "errorBundle":Landroid/os/Bundle;
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 295
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorMessage"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 296
    return-object v0
.end method


# virtual methods
.method public onAuthenticationFailed()V
    .locals 3

    .prologue
    .line 215
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Authentication failure performing authenticate account request"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v2, "Failed to authenticate"

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 217
    return-void
.end method

.method public onNetworkFailure()V
    .locals 3

    .prologue
    .line 207
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Network failure performing authenticate account request. "

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v2, "Network failure occured while authenticating account. Please check your internet connectivity"

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 210
    return-void
.end method

.method public onParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V
    .locals 3
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/common/ParseError;

    .prologue
    .line 222
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Parsing failure performing authenticate account  request"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v2, "Failed to parse the response"

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 224
    return-void
.end method

.method public onResponseComplete(Ljava/lang/Object;)V
    .locals 8
    .param p1, "response"    # Ljava/lang/Object;

    .prologue
    .line 229
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Got completed response of type ("

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "): "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-object v4, p1

    .line 230
    check-cast v4, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;

    .line 231
    .local v4, "pandaResponse":Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;
    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->getError()Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 233
    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->getError()Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;

    move-result-object v1

    .line 234
    .local v1, "error":Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$1;->$SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError:[I

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 279
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Authentication Error: Unrecognized response."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 280
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->getErrorString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 289
    .end local v1    # "error":Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    :goto_0
    return-void

    .line 237
    .restart local v1    # "error":Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    :pswitch_0
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Authentication Error: Crentials Invalid"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->CUSTOMER_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->getErrorString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    .line 242
    :pswitch_1
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Authentication Error: Invalid Value"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 243
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->getErrorString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    .line 246
    :pswitch_2
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Authentication Error: Missing Value"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 247
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->getErrorString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    .line 250
    :pswitch_3
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Authentication Error: Server Error"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->getErrorString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    .line 254
    :pswitch_4
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Authentication Error: Service Unavailable"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 255
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->getErrorString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 258
    :pswitch_5
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Authentication Error: Unknown."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 259
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->getErrorString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 262
    :pswitch_6
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Authentication Error: Challenge Exception."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 263
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_CHALLENGED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->getErrorString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v5, v6}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    .line 265
    .local v2, "errorBundle":Landroid/os/Bundle;
    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->getChallenge()Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    move-result-object v0

    .line 266
    .local v0, "challenge":Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    if-nez v0, :cond_0

    .line 268
    # getter for: Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Authentication Error: Unknown. Challenge Exception was missing."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 269
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;->getErrorString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->bundleWithErrorCode(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 274
    :cond_0
    const-string/jumbo v5, "com.amazon.identity.auth.ChallengeException"

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->toBundle()Landroid/os/Bundle;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 276
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v5, v2}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 285
    .end local v0    # "challenge":Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .end local v1    # "error":Lcom/amazon/identity/kcpsdk/auth/AuthenticateAccountError;
    .end local v2    # "errorBundle":Landroid/os/Bundle;
    :cond_1
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 286
    .local v3, "output":Landroid/os/Bundle;
    const-string/jumbo v5, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->getDirectedId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 287
    const-string/jumbo v5, "com.amazon.dcp.sso.AddAccount.options.AccessToken"

    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponse;->getAccessToken()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 288
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v5, v3}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 234
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method
