.class Lcom/amazon/identity/auth/accounts/AccountRegistrar$1;
.super Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;
.source "AccountRegistrar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountRegistrar;->doUpdateCredentials(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

.field final synthetic val$directedId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    .prologue
    .line 1519
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$1;->val$directedId:Ljava/lang/String;

    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;-><init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;)V

    return-void
.end method


# virtual methods
.method protected cleanupDeviceState(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V
    .locals 0
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .prologue
    .line 1555
    return-void
.end method

.method protected onRegisterResponseComplete(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;
    .locals 6
    .param p1, "registerResponse"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .prologue
    .line 1523
    new-instance v2, Lcom/amazon/identity/auth/accounts/AccountDataCollector;

    invoke-direct {v2}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;-><init>()V

    .line 1525
    .local v2, "userDataUpdateBundle":Lcom/amazon/identity/auth/accounts/AccountDataCollector;
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getUserName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setUserName(Ljava/lang/String;)V

    .line 1527
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getDeviceName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setDeviceName(Ljava/lang/String;)V

    .line 1528
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;
    invoke-static {v3}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$100(Lcom/amazon/identity/auth/accounts/AccountRegistrar;)Landroid/content/Context;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$1;->val$directedId:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getDeviceName()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v4, v5}, Lcom/amazon/identity/auth/attributes/UserProperties;->storeDeviceName(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    .line 1530
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getEmail()Ljava/lang/String;

    move-result-object v1

    .line 1531
    .local v1, "deviceEmail":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 1533
    invoke-virtual {v2, v1}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setDeviceEmail(Ljava/lang/String;)V

    .line 1539
    :goto_0
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getAdpToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setAdpToken(Ljava/lang/String;)V

    .line 1540
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getPrivateKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setPrivateKey(Ljava/lang/String;)V

    .line 1542
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getDirectedId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setDirectedId(Ljava/lang/String;)V

    .line 1544
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    invoke-virtual {v3, p1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getCookieJar(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Lcom/amazon/identity/auth/device/storage/CookieJar;

    move-result-object v0

    .line 1545
    .local v0, "cookieJar":Lcom/amazon/identity/auth/device/storage/CookieJar;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/CookieJar;->getXmain()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setXMainToken(Ljava/lang/String;)V

    .line 1546
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/CookieJar;->getInternationalXMainAndXAcbCookies()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->setXMainAndXAcbCookies(Ljava/lang/String;)V

    .line 1548
    new-instance v3, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/AccountDataCollector;->getCurrentUserData()Landroid/os/Bundle;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;-><init>(Landroid/os/Bundle;)V

    return-object v3

    .line 1537
    .end local v0    # "cookieJar":Lcom/amazon/identity/auth/device/storage/CookieJar;
    :cond_0
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "Was not able to updated device email since it was not returned"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
