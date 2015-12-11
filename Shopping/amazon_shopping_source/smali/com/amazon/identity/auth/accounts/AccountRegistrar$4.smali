.class Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;
.super Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;
.source "AccountRegistrar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getRegisterListener(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

.field final synthetic val$accountRegAuth:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

.field final synthetic val$deviceType:Ljava/lang/String;

.field final synthetic val$email:Ljava/lang/String;

.field final synthetic val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

.field final synthetic val$privateKeyOverWrite:Ljava/lang/String;

.field final synthetic val$serialNumber:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/api/MAPAccountManager;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p3, "x1"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .prologue
    .line 1743
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$accountRegAuth:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$email:Ljava/lang/String;

    iput-object p6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$privateKeyOverWrite:Ljava/lang/String;

    iput-object p7, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    iput-object p8, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$serialNumber:Ljava/lang/String;

    iput-object p9, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$deviceType:Ljava/lang/String;

    invoke-direct {p0, p2, p3}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;-><init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/api/MAPAccountManager;)V

    return-void
.end method


# virtual methods
.method protected cleanupDeviceState(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V
    .locals 3
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .prologue
    .line 1840
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDeviceNotRegisteredPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    if-eq p1, v0, :cond_0

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    if-eq p1, v0, :cond_0

    .line 1879
    :goto_0
    return-void

    .line 1846
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    if-nez v0, :cond_1

    .line 1848
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "MAPAccountManager not initialized. Not able to deregister the device due to error "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1853
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    new-instance v1, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4$1;-><init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->deregisterDevice(Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    goto :goto_0
.end method

.method protected onRegisterResponseComplete(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;
    .locals 6
    .param p1, "registerResponse"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .prologue
    .line 1747
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$accountRegAuth:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    invoke-static {v3, p1, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$300(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;)V

    .line 1749
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    # invokes: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->isAnonymousCredentials(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Z
    invoke-static {v3, p1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$500(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1753
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$accountRegAuth:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    invoke-static {v3, p1, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$400(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;)Z

    .line 1755
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "Cannot register the device, because anonymous credentials were returned from the server. FRO has either already been called or this device is not associated with an account."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1758
    new-instance v3, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;

    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-direct {v3, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;-><init>(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    .line 1830
    :goto_0
    return-object v3

    .line 1761
    :cond_0
    new-instance v1, Lcom/amazon/identity/auth/accounts/AccountDataCollector;

    invoke-direct {v1}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;-><init>()V

    .line 1763
    .local v1, "userDataConstructor":Lcom/amazon/identity/auth/accounts/AccountDataCollector;
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$email:Ljava/lang/String;

    if-eqz v3, :cond_1

    .line 1765
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$email:Ljava/lang/String;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setEmail(Ljava/lang/String;)V

    .line 1768
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getUserName()Ljava/lang/String;

    move-result-object v2

    .line 1769
    .local v2, "userName":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 1773
    const-string/jumbo v2, " "

    .line 1776
    :cond_2
    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setUserName(Ljava/lang/String;)V

    .line 1777
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getDeviceName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setDeviceName(Ljava/lang/String;)V

    .line 1778
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getEmail()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setDeviceEmail(Ljava/lang/String;)V

    .line 1787
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getAdpToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setAdpToken(Ljava/lang/String;)V

    .line 1789
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getPrivateKey()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_3

    .line 1791
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "Registration returned server generated credentials."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1792
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getPrivateKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setPrivateKey(Ljava/lang/String;)V

    .line 1806
    :goto_1
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$serialNumber:Ljava/lang/String;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setDeviceSerialNumber(Ljava/lang/String;)V

    .line 1807
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$deviceType:Ljava/lang/String;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setDeviceType(Ljava/lang/String;)V

    .line 1809
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getDirectedId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setDirectedId(Ljava/lang/String;)V

    .line 1811
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    invoke-virtual {v3, p1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getCookieJar(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Lcom/amazon/identity/auth/device/storage/CookieJar;

    move-result-object v0

    .line 1812
    .local v0, "cookieJar":Lcom/amazon/identity/auth/device/storage/CookieJar;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/CookieJar;->getXmain()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setXMainToken(Ljava/lang/String;)V

    .line 1813
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/CookieJar;->getInternationalXMainAndXAcbCookies()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setXMainAndXAcbCookies(Ljava/lang/String;)V

    .line 1814
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getStoreAuthenticationCookie()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setXfsnCookie(Ljava/lang/String;)V

    .line 1816
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getAccountPool()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setAccountPool(Ljava/lang/String;)V

    .line 1817
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getCustomerRegion()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setCustomerRegion(Ljava/lang/String;)V

    .line 1819
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getCor()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setCor(Ljava/lang/String;)V

    .line 1820
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getSourceOfCor()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setSourceOfCor(Ljava/lang/String;)V

    .line 1821
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getPfm()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setPfm(Ljava/lang/String;)V

    .line 1823
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getCredentialsReceived()Ljava/util/Map;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setCredentialsMap(Ljava/util/Map;)V

    .line 1825
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getCookiesRetrievedFromPanda()Lorg/json/JSONArray;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setCookies(Lorg/json/JSONArray;)V

    .line 1826
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getAccessToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setAccessToken(Ljava/lang/String;)V

    .line 1827
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getAccessTokenExpiresIn()I

    move-result v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setAccessTokenExpiresIn(I)V

    .line 1828
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getRefreshToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setRefreshToken(Ljava/lang/String;)V

    .line 1830
    new-instance v3, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->getUserDataNecessaryForAccountCreation()Landroid/os/Bundle;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;-><init>(Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1796
    .end local v0    # "cookieJar":Lcom/amazon/identity/auth/device/storage/CookieJar;
    :cond_3
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$privateKeyOverWrite:Ljava/lang/String;

    if-nez v3, :cond_4

    .line 1798
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "No private key to set after register."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1799
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1801
    :cond_4
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "The device will use self generated credentials."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1802
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->val$privateKeyOverWrite:Ljava/lang/String;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setPrivateKey(Ljava/lang/String;)V

    goto/16 :goto_1
.end method
