.class Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;
.super Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;
.source "AccountRegistrar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AccountRegistrar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

.field final synthetic val$accountRegAuth:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

.field final synthetic val$deregisterAllAccounts:Z

.field final synthetic val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;ZLcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 0

    .prologue
    .line 1596
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    iput-boolean p3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$deregisterAllAccounts:Z

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$accountRegAuth:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAuthenticationFailed()V
    .locals 3

    .prologue
    .line 1607
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Authentication failure performing deregistration request"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1608
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1609
    return-void
.end method

.method public onNetworkFailure()V
    .locals 3

    .prologue
    .line 1600
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Network failure performing deregistration request"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1601
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1602
    return-void
.end method

.method public onParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V
    .locals 3
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/common/ParseError;

    .prologue
    .line 1614
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Parsing failure performing deregistration request"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1615
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1616
    return-void
.end method

.method public onResponseComplete(Ljava/lang/Object;)V
    .locals 6
    .param p1, "response"    # Ljava/lang/Object;

    .prologue
    const/4 v4, 0x0

    .line 1621
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Successfully completed the deregistration request"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, p1

    .line 1622
    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;

    .line 1624
    .local v0, "deregisterResponse":Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;
    if-nez v0, :cond_0

    .line 1626
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Deregistration Error: Null response"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1627
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1658
    :goto_0
    return-void

    .line 1631
    :cond_0
    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;->getError()Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 1633
    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;->getError()Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;

    move-result-object v1

    .line 1635
    .local v1, "error":Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;
    sget-object v2, Lcom/amazon/identity/auth/accounts/AccountRegistrar$6;->$SwitchMap$com$amazon$identity$kcpsdk$auth$DeregisterDeviceErrorType:[I

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;->getType()Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 1643
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Deregistration Error: Unrecognized response"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1644
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_0

    .line 1638
    :pswitch_0
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Deregistration Error: Failed"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1639
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DEREGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_0

    .line 1650
    .end local v1    # "error":Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;
    :cond_1
    iget-boolean v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$deregisterAllAccounts:Z

    if-eqz v2, :cond_2

    .line 1652
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$accountRegAuth:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-static {v2, v3, v4, v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$200(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0

    .line 1656
    :cond_2
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;->val$listener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    invoke-interface {v2, v4, v4, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->success(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0

    .line 1635
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
