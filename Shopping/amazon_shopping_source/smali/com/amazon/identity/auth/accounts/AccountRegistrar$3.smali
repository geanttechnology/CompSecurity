.class Lcom/amazon/identity/auth/accounts/AccountRegistrar$3;
.super Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;
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


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    .prologue
    .line 1700
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$3;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$3;->val$accountRegAuth:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;-><init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;)V

    return-void
.end method


# virtual methods
.method protected cleanupDeviceState(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V
    .locals 0
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .prologue
    .line 1719
    return-void
.end method

.method protected onRegisterResponseComplete(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;
    .locals 2
    .param p1, "registerResponse"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .prologue
    .line 1704
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$3;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$3;->val$accountRegAuth:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    invoke-static {v0, p1, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$300(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;)V

    .line 1705
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$3;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$3;->val$accountRegAuth:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    invoke-static {v0, p1, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$400(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1707
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;

    invoke-direct {v0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;-><init>()V

    .line 1711
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;-><init>(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    goto :goto_0
.end method
