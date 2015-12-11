.class abstract Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;
.super Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;
.source "AccountRegistrar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AccountRegistrar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "RegisterDeviceAmazonWebserviceCallListener"
.end annotation


# instance fields
.field protected final mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

.field protected final mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    .prologue
    .line 144
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;-><init>()V

    .line 145
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    .line 146
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 147
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/api/MAPAccountManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p2, "mapAccountManager"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .prologue
    .line 151
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;-><init>()V

    .line 152
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    .line 153
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 154
    return-void
.end method


# virtual methods
.method protected abstract cleanupDeviceState(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V
.end method

.method public onAuthenticationFailed()V
    .locals 3

    .prologue
    .line 166
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Authentication failure performing registration request"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 168
    return-void
.end method

.method public onNetworkFailure()V
    .locals 3

    .prologue
    .line 159
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Network failure performing registration request"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 160
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 161
    return-void
.end method

.method public onParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V
    .locals 3
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/common/ParseError;

    .prologue
    .line 173
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Parsing failure performing registration request"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 175
    return-void
.end method

.method protected abstract onRegisterResponseComplete(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;
.end method

.method public onResponseComplete(Ljava/lang/Object;)V
    .locals 10
    .param p1, "response"    # Ljava/lang/Object;

    .prologue
    const/4 v9, 0x0

    .line 180
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Successfully completed the registration request"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    move-object v5, p1

    .line 181
    check-cast v5, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .line 183
    .local v5, "registerResponse":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    if-nez v5, :cond_0

    .line 185
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: Null response"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 186
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 322
    :goto_0
    return-void

    .line 190
    :cond_0
    invoke-virtual {v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getError()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 192
    invoke-virtual {v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getError()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    move-result-object v1

    .line 193
    .local v1, "error":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;
    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;->getType()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->getErrorString()Ljava/lang/String;

    move-result-object v2

    .line 194
    .local v2, "errorMessage":Ljava/lang/String;
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Error string: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    sget-object v6, Lcom/amazon/identity/auth/accounts/AccountRegistrar$6;->$SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType:[I

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;->getType()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->ordinal()I

    move-result v7

    aget v6, v6, v7

    packed-switch v6, :pswitch_data_0

    .line 295
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: Unrecognized response. If this is a 1st party Amazon device and is not corrected from a retry, please verify that your device has been fulfilled."

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    .line 301
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 307
    :goto_1
    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;->getType()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    move-result-object v6

    invoke-virtual {p0, v6}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->cleanupDeviceState(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V

    goto :goto_0

    .line 199
    :pswitch_0
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: Customer not found. The credential is invalid."

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 200
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->CUSTOMER_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_1

    .line 204
    :pswitch_1
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: Device already registered"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DEVICE_ALREADY_REGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_1

    .line 209
    :pswitch_2
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: Duplicate device name"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DUPLICATE_DEVICE_NAME:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_1

    .line 214
    :pswitch_3
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: Challenge Response Received"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    invoke-virtual {v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getChallenge()Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    move-result-object v0

    .line 216
    .local v0, "challenge":Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    if-nez v0, :cond_1

    .line 218
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: Unknown. Challenge Exception was missing."

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 219
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_1

    .line 223
    :cond_1
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 224
    .local v3, "extras":Landroid/os/Bundle;
    const-string/jumbo v6, "com.amazon.identity.auth.ChallengeException"

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->toBundle()Landroid/os/Bundle;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 225
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_CHALLENGED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v3}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_1

    .line 229
    .end local v0    # "challenge":Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .end local v3    # "extras":Landroid/os/Bundle;
    :pswitch_4
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "MAP internal bug: One or more required values are missing"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 234
    :pswitch_5
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: One or more required values are invalid"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 235
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 239
    :pswitch_6
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "MAP internal bug: The Protocol is not supported. SSL required"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 240
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 244
    :pswitch_7
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "MAP internal bug: The HTTP method is not valid. For example, using POST instead of GET"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 250
    :pswitch_8
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: The server has encountered a runtime error, or the service is temporarily overloaded or unavailable, try again later"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 252
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 256
    :pswitch_9
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "MAP internal bug: The feature is not implemented"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 257
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 261
    :pswitch_a
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: The directedId is invalid. e.g. The customer directedId is invalid. The device directedId is invalid"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 263
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 267
    :pswitch_b
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: The device information is invalid. The device serial number is too long"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 269
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 272
    :pswitch_c
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Registration Error: The service is temporarily overloaded or unavailable, try again later"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 277
    :pswitch_d
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Registration Error: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 278
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 281
    :pswitch_e
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Registration Error: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 282
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 285
    :pswitch_f
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Registration Error: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 287
    const-string/jumbo v6, "PrimaryAccountDeregisteredWhenRegisterSecondaryWithPanda"

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/String;

    invoke-static {v6, v7}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 288
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 291
    :pswitch_10
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Registration Error: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 292
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_1

    .line 311
    .end local v1    # "error":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;
    .end local v2    # "errorMessage":Ljava/lang/String;
    :cond_2
    invoke-virtual {p0, v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->onRegisterResponseComplete(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;

    move-result-object v4

    .line 313
    .local v4, "info":Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;
    iget-object v6, v4, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->error:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    if-nez v6, :cond_3

    .line 315
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->getDirectedId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->getUserName()Ljava/lang/String;

    move-result-object v8

    iget-object v9, v4, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->userData:Landroid/os/Bundle;

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->success(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 319
    :cond_3
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Registration Error: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v8, v4, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->error:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v8}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;->mListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    iget-object v7, v4, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->error:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v6, v7, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 196
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
    .end packed-switch
.end method
